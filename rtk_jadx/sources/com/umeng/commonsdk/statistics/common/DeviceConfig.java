package com.umeng.commonsdk.statistics.common;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.umeng.analytics.pro.ak;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.idtracking.h;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DeviceConfig {
    public static final int DEFAULT_TIMEZONE = 8;
    private static final String KEY_EMUI_VERSION_CODE = "ro.build.hw_emui_api_level";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    protected static final String LOG_TAG = "com.umeng.commonsdk.statistics.common.DeviceConfig";
    public static final String MOBILE_NETWORK = "2G/3G";
    public static final String UNKNOW = "";
    public static final String WIFI = "Wi-Fi";
    private static DeviceTypeEnum deviceTypeEnum = DeviceTypeEnum.DEFAULT;
    private static volatile String sWifiMac = "";
    private static volatile String sImei = "";
    private static volatile String sMeid = "";
    private static volatile String sImsi = "";
    private static volatile String sSerialNo = "";
    private static volatile String sAndroidID = "";
    private static volatile String sIDFA = "";
    private static volatile String sOAID = "";
    private static volatile String sSecondImei = "";
    private static volatile String sSimSerialNumber = "";
    private static volatile boolean sImeiOrMeidFlag = false;
    private static volatile boolean sSerialFlag = false;
    private static volatile boolean sSimSerialNumberFlag = false;
    private static volatile boolean sImsiFlag = false;
    private static volatile boolean sSecondImeiFlag = false;

    private static String byte2HexFormatted(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i]);
            int length = hexString.length();
            if (length == 1) {
                hexString = "0" + hexString;
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            sb.append(hexString.toUpperCase(Locale.getDefault()));
            if (i < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }

    public static boolean checkPermission(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() != 0) {
                    return false;
                }
            } catch (Throwable unused) {
                return false;
            }
        } else if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    public static String getAndroidId(Context context) {
        if (!TextUtils.isEmpty(sAndroidID)) {
            return sAndroidID;
        }
        String str = null;
        if (!FieldManager.allow(com.umeng.commonsdk.utils.b.i) || context == null) {
            return null;
        }
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
            sAndroidID = str;
            return str;
        } catch (Exception unused) {
            if (!AnalyticsConstants.UM_DEBUG) {
                return str;
            }
            MLog.w("can't read android id");
            return str;
        }
    }

    public static String getAppHashKey(Context context) {
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(getPackageName(context), 64).signatures;
            if (signatureArr.length <= 0) {
                return null;
            }
            Signature signature = signatureArr[0];
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            messageDigest.update(signature.toByteArray());
            return Base64.encodeToString(messageDigest.digest(), 0).trim();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getAppMD5Signature(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return byte2HexFormatted(MessageDigest.getInstance("MD5").digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(getPackageName(context), 64).signatures[0].toByteArray()))).getEncoded()));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getAppName(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (Throwable th) {
            if (!AnalyticsConstants.UM_DEBUG) {
                return null;
            }
            MLog.i(LOG_TAG, th);
            return null;
        }
    }

    public static String getAppSHA1Key(Context context) {
        try {
            return byte2HexFormatted(MessageDigest.getInstance("SHA1").digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(getPackageName(context), 64).signatures[0].toByteArray()))).getEncoded()));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getAppVersionCode(Context context) {
        return UMUtils.getAppVersionCode(context);
    }

    public static String getAppVersionName(Context context) {
        return UMUtils.getAppVersionName(context);
    }

    public static String getApplicationLable(Context context) {
        return context == null ? "" : context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
    }

    private static Properties getBuildProp() {
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
            } catch (Throwable unused) {
            }
            try {
                properties.load(fileInputStream);
                fileInputStream.close();
            } catch (Throwable unused2) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                return properties;
            }
        } catch (Throwable unused3) {
        }
        return properties;
    }

    public static String getCPU() {
        String str = null;
        try {
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            try {
                BufferedReader bufferedReader = new BufferedReader(fileReader, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                str = bufferedReader.readLine();
                bufferedReader.close();
                fileReader.close();
            } catch (Throwable th) {
                MLog.e(LOG_TAG, "Could not read from file /proc/cpuinfo", th);
            }
        } catch (FileNotFoundException e) {
            MLog.e(LOG_TAG, "Could not open file /proc/cpuinfo", e);
        }
        return str != null ? str.substring(str.indexOf(58) + 1).trim() : "";
    }

    public static String getDBencryptID(Context context) {
        return UMUtils.genId();
    }

    public static String getDeviceId(Context context) {
        if (AnalyticsConstants.getDeviceType() == 2) {
            return getDeviceIdForBox(context);
        }
        return getDeviceIdForGeneral(context);
    }

    public static String getDeviceIdForBox(Context context) {
        String str = "";
        if (context == null) {
            return "";
        }
        try {
            int i = Build.VERSION.SDK_INT;
            if (i < 23) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.b.i)) {
                    str = getAndroidId(context);
                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                    if (AnalyticsConstants.UM_DEBUG) {
                        MLog.i(LOG_TAG, "getDeviceId, ANDROID_ID: " + str);
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
                String macBySystemInterface = getMacBySystemInterface(context);
                deviceTypeEnum = DeviceTypeEnum.MAC;
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.i(LOG_TAG, "getDeviceId, MAC: " + macBySystemInterface);
                }
                if (!TextUtils.isEmpty(macBySystemInterface)) {
                    return macBySystemInterface;
                }
                String serialNo = getSerialNo();
                deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                if (!TextUtils.isEmpty(serialNo)) {
                    return serialNo;
                }
                String imei = getIMEI(context);
                deviceTypeEnum = DeviceTypeEnum.IMEI;
                return imei;
            }
            if (i == 23) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.b.i)) {
                    str = getAndroidId(context);
                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                    if (AnalyticsConstants.UM_DEBUG) {
                        MLog.i(LOG_TAG, "getDeviceId, ANDROID_ID: " + str);
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
                String macByJavaAPI = getMacByJavaAPI();
                DeviceTypeEnum deviceTypeEnum2 = DeviceTypeEnum.MAC;
                deviceTypeEnum = deviceTypeEnum2;
                if (TextUtils.isEmpty(macByJavaAPI)) {
                    if (AnalyticsConstants.CHECK_DEVICE) {
                        macByJavaAPI = getMacShell();
                        deviceTypeEnum = deviceTypeEnum2;
                    } else {
                        macByJavaAPI = getMacBySystemInterface(context);
                        deviceTypeEnum = deviceTypeEnum2;
                    }
                }
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.i(LOG_TAG, "getDeviceId, MAC: " + macByJavaAPI);
                }
                if (!TextUtils.isEmpty(macByJavaAPI)) {
                    return macByJavaAPI;
                }
                String serialNo2 = getSerialNo();
                deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                if (!TextUtils.isEmpty(serialNo2)) {
                    return serialNo2;
                }
                String imei2 = getIMEI(context);
                deviceTypeEnum = DeviceTypeEnum.IMEI;
                return imei2;
            }
            if (i >= 29) {
                String oaid = getOaid(context);
                deviceTypeEnum = DeviceTypeEnum.OAID;
                if (!TextUtils.isEmpty(oaid)) {
                    return oaid;
                }
                String idfa = getIdfa(context);
                deviceTypeEnum = DeviceTypeEnum.IDFA;
                if (!TextUtils.isEmpty(idfa)) {
                    return idfa;
                }
                String androidId = getAndroidId(context);
                deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                if (!TextUtils.isEmpty(androidId)) {
                    return androidId;
                }
                String serialNo3 = getSerialNo();
                deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                if (!TextUtils.isEmpty(serialNo3)) {
                    return serialNo3;
                }
                String macByJavaAPI2 = getMacByJavaAPI();
                DeviceTypeEnum deviceTypeEnum3 = DeviceTypeEnum.MAC;
                deviceTypeEnum = deviceTypeEnum3;
                if (!TextUtils.isEmpty(macByJavaAPI2)) {
                    return macByJavaAPI2;
                }
                String macBySystemInterface2 = getMacBySystemInterface(context);
                deviceTypeEnum = deviceTypeEnum3;
                return macBySystemInterface2;
            }
            if (FieldManager.allow(com.umeng.commonsdk.utils.b.i)) {
                str = getAndroidId(context);
                deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.i(LOG_TAG, "getDeviceId: ANDROID_ID: " + str);
                }
            }
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            String serialNo4 = getSerialNo();
            deviceTypeEnum = DeviceTypeEnum.SERIALNO;
            if (!TextUtils.isEmpty(serialNo4)) {
                return serialNo4;
            }
            String imei3 = getIMEI(context);
            deviceTypeEnum = DeviceTypeEnum.IMEI;
            if (!TextUtils.isEmpty(imei3)) {
                return imei3;
            }
            String macByJavaAPI3 = getMacByJavaAPI();
            DeviceTypeEnum deviceTypeEnum4 = DeviceTypeEnum.MAC;
            deviceTypeEnum = deviceTypeEnum4;
            if (!TextUtils.isEmpty(macByJavaAPI3)) {
                return macByJavaAPI3;
            }
            String macBySystemInterface3 = getMacBySystemInterface(context);
            deviceTypeEnum = deviceTypeEnum4;
            if (!AnalyticsConstants.UM_DEBUG) {
                return macBySystemInterface3;
            }
            MLog.i(LOG_TAG, "getDeviceId, MAC: " + macBySystemInterface3);
            return macBySystemInterface3;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getDeviceIdForGeneral(Context context) {
        if (context == null) {
            return "";
        }
        try {
            int i = Build.VERSION.SDK_INT;
            if (i < 23) {
                String imei = getIMEI(context);
                deviceTypeEnum = DeviceTypeEnum.IMEI;
                if (!TextUtils.isEmpty(imei)) {
                    return imei;
                }
                boolean z = AnalyticsConstants.UM_DEBUG;
                if (z) {
                    MLog.w(LOG_TAG, "No IMEI.");
                }
                String macBySystemInterface = getMacBySystemInterface(context);
                deviceTypeEnum = DeviceTypeEnum.MAC;
                if (!TextUtils.isEmpty(macBySystemInterface)) {
                    return macBySystemInterface;
                }
                if (FieldManager.allow(com.umeng.commonsdk.utils.b.i)) {
                    macBySystemInterface = getAndroidId(context);
                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                    if (z) {
                        MLog.i(LOG_TAG, "getDeviceId, ANDROID_ID: " + macBySystemInterface);
                    }
                }
                if (!TextUtils.isEmpty(macBySystemInterface)) {
                    return macBySystemInterface;
                }
                String serialNo = getSerialNo();
                deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                return serialNo;
            }
            if (i == 23) {
                String imei2 = getIMEI(context);
                deviceTypeEnum = DeviceTypeEnum.IMEI;
                if (!TextUtils.isEmpty(imei2)) {
                    return imei2;
                }
                String macByJavaAPI = getMacByJavaAPI();
                DeviceTypeEnum deviceTypeEnum2 = DeviceTypeEnum.MAC;
                deviceTypeEnum = deviceTypeEnum2;
                if (TextUtils.isEmpty(macByJavaAPI)) {
                    if (AnalyticsConstants.CHECK_DEVICE) {
                        macByJavaAPI = getMacShell();
                        deviceTypeEnum = deviceTypeEnum2;
                    } else {
                        macByJavaAPI = getMacBySystemInterface(context);
                        deviceTypeEnum = deviceTypeEnum2;
                    }
                }
                boolean z2 = AnalyticsConstants.UM_DEBUG;
                if (z2) {
                    MLog.i(LOG_TAG, "getDeviceId, MAC: " + macByJavaAPI);
                }
                if (!TextUtils.isEmpty(macByJavaAPI)) {
                    return macByJavaAPI;
                }
                if (FieldManager.allow(com.umeng.commonsdk.utils.b.i)) {
                    macByJavaAPI = getAndroidId(context);
                    deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                    if (z2) {
                        MLog.i(LOG_TAG, "getDeviceId, ANDROID_ID: " + macByJavaAPI);
                    }
                }
                if (!TextUtils.isEmpty(macByJavaAPI)) {
                    return macByJavaAPI;
                }
                String serialNo2 = getSerialNo();
                deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                return serialNo2;
            }
            if (i >= 29) {
                String oaid = getOaid(context);
                deviceTypeEnum = DeviceTypeEnum.OAID;
                if (!TextUtils.isEmpty(oaid)) {
                    return oaid;
                }
                String idfa = getIdfa(context);
                deviceTypeEnum = DeviceTypeEnum.IDFA;
                if (!TextUtils.isEmpty(idfa)) {
                    return idfa;
                }
                String androidId = getAndroidId(context);
                deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                if (!TextUtils.isEmpty(androidId)) {
                    return androidId;
                }
                String serialNo3 = getSerialNo();
                deviceTypeEnum = DeviceTypeEnum.SERIALNO;
                if (!TextUtils.isEmpty(serialNo3)) {
                    return serialNo3;
                }
                String macByJavaAPI2 = getMacByJavaAPI();
                DeviceTypeEnum deviceTypeEnum3 = DeviceTypeEnum.MAC;
                deviceTypeEnum = deviceTypeEnum3;
                if (!TextUtils.isEmpty(macByJavaAPI2)) {
                    return macByJavaAPI2;
                }
                String macBySystemInterface2 = getMacBySystemInterface(context);
                deviceTypeEnum = deviceTypeEnum3;
                return macBySystemInterface2;
            }
            String imei3 = getIMEI(context);
            deviceTypeEnum = DeviceTypeEnum.IMEI;
            if (!TextUtils.isEmpty(imei3)) {
                return imei3;
            }
            String serialNo4 = getSerialNo();
            deviceTypeEnum = DeviceTypeEnum.SERIALNO;
            if (!TextUtils.isEmpty(serialNo4)) {
                return serialNo4;
            }
            if (FieldManager.allow(com.umeng.commonsdk.utils.b.i)) {
                serialNo4 = getAndroidId(context);
                deviceTypeEnum = DeviceTypeEnum.ANDROIDID;
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.i(LOG_TAG, "getDeviceId, ANDROID_ID: " + serialNo4);
                }
            }
            if (!TextUtils.isEmpty(serialNo4)) {
                return serialNo4;
            }
            String macByJavaAPI3 = getMacByJavaAPI();
            DeviceTypeEnum deviceTypeEnum4 = DeviceTypeEnum.MAC;
            deviceTypeEnum = deviceTypeEnum4;
            if (!TextUtils.isEmpty(macByJavaAPI3)) {
                return macByJavaAPI3;
            }
            String macBySystemInterface3 = getMacBySystemInterface(context);
            deviceTypeEnum = deviceTypeEnum4;
            if (!AnalyticsConstants.UM_DEBUG) {
                return macBySystemInterface3;
            }
            MLog.i(LOG_TAG, "getDeviceId, MAC: " + macBySystemInterface3);
            return macBySystemInterface3;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getDeviceIdType() {
        return deviceTypeEnum.getDeviceIdType();
    }

    public static String getDeviceIdUmengMD5(Context context) {
        return HelperUtils.getUmengMD5(getDeviceId(context));
    }

    public static String getDeviceType(Context context) {
        if (context == null) {
            return "Phone";
        }
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3 ? "Tablet" : "Phone";
        } catch (Throwable unused) {
            return "Phone";
        }
    }

    public static String getDisplayResolution(Context context) {
        if (context == null) {
            return "";
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                int i = displayMetrics.widthPixels;
                return String.valueOf(displayMetrics.heightPixels) + "*" + String.valueOf(i);
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    private static String getEmuiVersion(Properties properties) {
        try {
            return properties.getProperty(KEY_EMUI_VERSION_CODE, null);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String getFlymeVersion(Properties properties) {
        try {
            String lowerCase = properties.getProperty("ro.build.display.id").toLowerCase(Locale.getDefault());
            if (lowerCase.contains("flyme os")) {
                return lowerCase.split(" ")[2];
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String[] getGPU(GL10 gl10) {
        try {
            return new String[]{gl10.glGetString(7936), gl10.glGetString(7937)};
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.e(LOG_TAG, "Could not read gpu infor:", th);
            }
            return new String[0];
        }
    }

    public static Activity getGlobleActivity(Context context) {
        Activity activity = null;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            for (Object obj : ((Map) declaredField.get(invoke)).values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField("activity");
                    declaredField3.setAccessible(true);
                    activity = (Activity) declaredField3.get(obj);
                }
            }
        } catch (Throwable unused) {
        }
        return activity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0071, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 29) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0060, code lost:
    
        com.umeng.commonsdk.statistics.common.DeviceConfig.sImeiOrMeidFlag = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x005e, code lost:
    
        if (r0 >= 29) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String getIMEI(android.content.Context r8) {
        /*
            java.lang.String r0 = com.umeng.commonsdk.statistics.common.DeviceConfig.sImei
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Lb
            java.lang.String r8 = com.umeng.commonsdk.statistics.common.DeviceConfig.sImei
            return r8
        Lb:
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.String r1 = ""
            r2 = 29
            if (r0 < r2) goto L18
            boolean r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.sImeiOrMeidFlag
            if (r3 == 0) goto L18
            return r1
        L18:
            java.lang.String r3 = "header_device_id_imei"
            boolean r3 = com.umeng.commonsdk.config.FieldManager.allow(r3)
            if (r3 == 0) goto L7c
            if (r8 != 0) goto L23
            return r1
        L23:
            java.lang.String r3 = "phone"
            java.lang.Object r3 = r8.getSystemService(r3)
            android.telephony.TelephonyManager r3 = (android.telephony.TelephonyManager) r3
            if (r3 == 0) goto L7c
            r4 = 1
            java.lang.String r5 = "android.permission.READ_PHONE_STATE"
            boolean r8 = checkPermission(r8, r5)     // Catch: java.lang.Throwable -> L63
            if (r8 == 0) goto L5e
            java.lang.String r8 = r3.getDeviceId()     // Catch: java.lang.Throwable -> L63
            boolean r1 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG     // Catch: java.lang.Throwable -> L5b
            if (r1 == 0) goto L59
            java.lang.String r1 = com.umeng.commonsdk.statistics.common.DeviceConfig.LOG_TAG     // Catch: java.lang.Throwable -> L5b
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L5b
            r5 = 0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5b
            r6.<init>()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r7 = "getDeviceId, IMEI: "
            r6.append(r7)     // Catch: java.lang.Throwable -> L5b
            r6.append(r8)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L5b
            r3[r5] = r6     // Catch: java.lang.Throwable -> L5b
            com.umeng.commonsdk.statistics.common.MLog.i(r1, r3)     // Catch: java.lang.Throwable -> L5b
        L59:
            r1 = r8
            goto L5e
        L5b:
            r0 = move-exception
            r1 = r8
            goto L64
        L5e:
            if (r0 < r2) goto L7c
        L60:
            com.umeng.commonsdk.statistics.common.DeviceConfig.sImeiOrMeidFlag = r4
            goto L7c
        L63:
            r0 = move-exception
        L64:
            boolean r8 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG     // Catch: java.lang.Throwable -> L74
            if (r8 == 0) goto L6f
            java.lang.String r8 = com.umeng.commonsdk.statistics.common.DeviceConfig.LOG_TAG     // Catch: java.lang.Throwable -> L74
            java.lang.String r3 = "No IMEI."
            com.umeng.commonsdk.statistics.common.MLog.w(r8, r3, r0)     // Catch: java.lang.Throwable -> L74
        L6f:
            int r8 = android.os.Build.VERSION.SDK_INT
            if (r8 < r2) goto L7c
            goto L60
        L74:
            r8 = move-exception
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r2) goto L7b
            com.umeng.commonsdk.statistics.common.DeviceConfig.sImeiOrMeidFlag = r4
        L7b:
            throw r8
        L7c:
            com.umeng.commonsdk.statistics.common.DeviceConfig.sImei = r1
            java.lang.String r8 = com.umeng.commonsdk.statistics.common.DeviceConfig.sImei
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.DeviceConfig.getIMEI(android.content.Context):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getIPAddress(android.content.Context r7) {
        /*
            r7 = 0
            java.util.Enumeration r0 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch: java.net.SocketException -> L6a
            java.util.ArrayList r0 = java.util.Collections.list(r0)     // Catch: java.net.SocketException -> L6a
            java.util.Iterator r0 = r0.iterator()     // Catch: java.net.SocketException -> L6a
            r1 = r7
        Le:
            boolean r2 = r0.hasNext()     // Catch: java.net.SocketException -> L69
            if (r2 == 0) goto L6e
            java.lang.Object r2 = r0.next()     // Catch: java.net.SocketException -> L69
            java.net.NetworkInterface r2 = (java.net.NetworkInterface) r2     // Catch: java.net.SocketException -> L69
            java.util.Enumeration r3 = r2.getInetAddresses()     // Catch: java.net.SocketException -> L69
            java.util.ArrayList r3 = java.util.Collections.list(r3)     // Catch: java.net.SocketException -> L69
            java.util.Iterator r3 = r3.iterator()     // Catch: java.net.SocketException -> L69
        L26:
            boolean r4 = r3.hasNext()     // Catch: java.net.SocketException -> L69
            if (r4 == 0) goto Le
            java.lang.Object r4 = r3.next()     // Catch: java.net.SocketException -> L69
            java.net.InetAddress r4 = (java.net.InetAddress) r4     // Catch: java.net.SocketException -> L69
            boolean r5 = r4.isLoopbackAddress()     // Catch: java.net.SocketException -> L69
            java.lang.String r6 = "dummy"
            if (r5 != 0) goto L4e
            boolean r5 = r4 instanceof java.net.Inet4Address     // Catch: java.net.SocketException -> L69
            if (r5 == 0) goto L4e
            java.lang.String r5 = r2.getDisplayName()     // Catch: java.net.SocketException -> L69
            boolean r5 = r5.contains(r6)     // Catch: java.net.SocketException -> L69
            if (r5 != 0) goto L4e
            if (r7 != 0) goto L4e
            java.lang.String r7 = r4.getHostAddress()     // Catch: java.net.SocketException -> L69
        L4e:
            boolean r5 = r4.isLoopbackAddress()     // Catch: java.net.SocketException -> L69
            if (r5 != 0) goto L26
            boolean r5 = r4 instanceof java.net.Inet6Address     // Catch: java.net.SocketException -> L69
            if (r5 == 0) goto L26
            java.lang.String r5 = r2.getDisplayName()     // Catch: java.net.SocketException -> L69
            boolean r5 = r5.contains(r6)     // Catch: java.net.SocketException -> L69
            if (r5 != 0) goto L26
            if (r1 != 0) goto L26
            java.lang.String r1 = r4.getHostAddress()     // Catch: java.net.SocketException -> L69
            goto L26
        L69:
            r7 = r1
        L6a:
            java.lang.String r0 = "SocketException"
            r1 = r7
            r7 = r0
        L6e:
            if (r7 == 0) goto L71
            return r7
        L71:
            if (r1 != 0) goto L75
            java.lang.String r1 = "null"
        L75:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.DeviceConfig.getIPAddress(android.content.Context):java.lang.String");
    }

    public static String getIdfa(Context context) {
        if (!TextUtils.isEmpty(sIDFA)) {
            return sIDFA;
        }
        String str = "";
        try {
            if (!FieldManager.allow(com.umeng.commonsdk.utils.b.w)) {
                return "";
            }
            str = a.a(context);
            sIDFA = str;
            return str;
        } catch (Throwable unused) {
            return str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x003d, code lost:
    
        if (r3 >= 29) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003f, code lost:
    
        com.umeng.commonsdk.statistics.common.DeviceConfig.sImeiOrMeidFlag = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0051, code lost:
    
        com.umeng.commonsdk.statistics.common.DeviceConfig.sImei = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x004e, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 29) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getImei(android.content.Context r6) {
        /*
            java.lang.String r0 = com.umeng.commonsdk.statistics.common.DeviceConfig.sImei
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Lb
            java.lang.String r6 = com.umeng.commonsdk.statistics.common.DeviceConfig.sImei
            return r6
        Lb:
            r0 = 0
            r1 = 1
            r2 = 29
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L42
            if (r3 < r2) goto L1c
            boolean r4 = com.umeng.commonsdk.statistics.common.DeviceConfig.sImeiOrMeidFlag     // Catch: java.lang.Throwable -> L42
            if (r4 == 0) goto L1c
            if (r3 < r2) goto L1b
            com.umeng.commonsdk.statistics.common.DeviceConfig.sImeiOrMeidFlag = r1
        L1b:
            return r0
        L1c:
            java.lang.String r4 = "header_device_id_imei"
            boolean r4 = com.umeng.commonsdk.config.FieldManager.allow(r4)     // Catch: java.lang.Throwable -> L42
            if (r4 == 0) goto L3d
            if (r6 == 0) goto L3d
            java.lang.String r4 = "phone"
            java.lang.Object r4 = r6.getSystemService(r4)     // Catch: java.lang.Throwable -> L42
            android.telephony.TelephonyManager r4 = (android.telephony.TelephonyManager) r4     // Catch: java.lang.Throwable -> L42
            if (r4 == 0) goto L3d
            java.lang.String r5 = "android.permission.READ_PHONE_STATE"
            boolean r6 = checkPermission(r6, r5)     // Catch: java.lang.Throwable -> L42
            if (r6 == 0) goto L3d
            java.lang.String r6 = r4.getDeviceId()     // Catch: java.lang.Throwable -> L42
            r0 = r6
        L3d:
            if (r3 < r2) goto L51
        L3f:
            com.umeng.commonsdk.statistics.common.DeviceConfig.sImeiOrMeidFlag = r1
            goto L51
        L42:
            r6 = move-exception
            boolean r3 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG     // Catch: java.lang.Throwable -> L54
            if (r3 == 0) goto L4c
            java.lang.String r3 = "No IMEI."
            com.umeng.commonsdk.statistics.common.MLog.w(r3, r6)     // Catch: java.lang.Throwable -> L54
        L4c:
            int r6 = android.os.Build.VERSION.SDK_INT
            if (r6 < r2) goto L51
            goto L3f
        L51:
            com.umeng.commonsdk.statistics.common.DeviceConfig.sImei = r0
            return r0
        L54:
            r6 = move-exception
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r2) goto L5b
            com.umeng.commonsdk.statistics.common.DeviceConfig.sImeiOrMeidFlag = r1
        L5b:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.DeviceConfig.getImei(android.content.Context):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x007a, code lost:
    
        com.umeng.commonsdk.statistics.common.DeviceConfig.sImei = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007c, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0077, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 29) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getImeiNew(android.content.Context r7) {
        /*
            java.lang.String r0 = com.umeng.commonsdk.statistics.common.DeviceConfig.sImei
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Lb
            java.lang.String r7 = com.umeng.commonsdk.statistics.common.DeviceConfig.sImei
            return r7
        Lb:
            r0 = 0
            r1 = 1
            r2 = 29
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L6b
            if (r3 < r2) goto L1c
            boolean r4 = com.umeng.commonsdk.statistics.common.DeviceConfig.sImeiOrMeidFlag     // Catch: java.lang.Throwable -> L6b
            if (r4 == 0) goto L1c
            if (r3 < r2) goto L1b
            com.umeng.commonsdk.statistics.common.DeviceConfig.sImeiOrMeidFlag = r1
        L1b:
            return r0
        L1c:
            java.lang.String r4 = "header_device_id_imei"
            boolean r4 = com.umeng.commonsdk.config.FieldManager.allow(r4)     // Catch: java.lang.Throwable -> L6b
            if (r4 == 0) goto L64
            if (r7 == 0) goto L64
            java.lang.String r4 = "phone"
            java.lang.Object r4 = r7.getSystemService(r4)     // Catch: java.lang.Throwable -> L6b
            android.telephony.TelephonyManager r4 = (android.telephony.TelephonyManager) r4     // Catch: java.lang.Throwable -> L6b
            if (r4 == 0) goto L64
            java.lang.String r5 = "android.permission.READ_PHONE_STATE"
            boolean r7 = checkPermission(r7, r5)     // Catch: java.lang.Throwable -> L6b
            if (r7 == 0) goto L64
            r7 = 26
            if (r3 < r7) goto L60
            java.lang.Class r7 = r4.getClass()     // Catch: java.lang.Throwable -> L55
            java.lang.String r3 = "getImei"
            r5 = 0
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch: java.lang.Throwable -> L55
            java.lang.reflect.Method r7 = r7.getMethod(r3, r6)     // Catch: java.lang.Throwable -> L55
            r7.setAccessible(r1)     // Catch: java.lang.Throwable -> L55
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L55
            java.lang.Object r7 = r7.invoke(r4, r3)     // Catch: java.lang.Throwable -> L55
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Throwable -> L55
            r0 = r7
        L55:
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L6b
            if (r7 == 0) goto L64
            java.lang.String r0 = r4.getDeviceId()     // Catch: java.lang.Throwable -> L6b
            goto L64
        L60:
            java.lang.String r0 = r4.getDeviceId()     // Catch: java.lang.Throwable -> L6b
        L64:
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r2) goto L7a
        L68:
            com.umeng.commonsdk.statistics.common.DeviceConfig.sImeiOrMeidFlag = r1
            goto L7a
        L6b:
            r7 = move-exception
            boolean r3 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG     // Catch: java.lang.Throwable -> L7d
            if (r3 == 0) goto L75
            java.lang.String r3 = "No IMEI."
            com.umeng.commonsdk.statistics.common.MLog.w(r3, r7)     // Catch: java.lang.Throwable -> L7d
        L75:
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r2) goto L7a
            goto L68
        L7a:
            com.umeng.commonsdk.statistics.common.DeviceConfig.sImei = r0
            return r0
        L7d:
            r7 = move-exception
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r2) goto L84
            com.umeng.commonsdk.statistics.common.DeviceConfig.sImeiOrMeidFlag = r1
        L84:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.DeviceConfig.getImeiNew(android.content.Context):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x003a, code lost:
    
        if (r1 >= 29) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003c, code lost:
    
        com.umeng.commonsdk.statistics.common.DeviceConfig.sImsiFlag = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0042, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 29) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getImsi(android.content.Context r6) {
        /*
            java.lang.String r0 = com.umeng.commonsdk.statistics.common.DeviceConfig.sImsi
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Lb
            java.lang.String r6 = com.umeng.commonsdk.statistics.common.DeviceConfig.sImsi
            return r6
        Lb:
            r0 = 0
            if (r6 != 0) goto Lf
            return r0
        Lf:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 29
            if (r1 < r2) goto L1a
            boolean r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.sImsiFlag
            if (r3 == 0) goto L1a
            return r0
        L1a:
            java.lang.String r3 = "phone"
            java.lang.Object r3 = r6.getSystemService(r3)
            android.telephony.TelephonyManager r3 = (android.telephony.TelephonyManager) r3
            java.lang.String r4 = "internal_imsi"
            boolean r4 = com.umeng.commonsdk.config.FieldManager.allow(r4)
            if (r4 == 0) goto L45
            r4 = 1
            java.lang.String r5 = "android.permission.READ_PHONE_STATE"
            boolean r6 = checkPermission(r6, r5)     // Catch: java.lang.Throwable -> L3f
            if (r6 == 0) goto L3a
            if (r3 == 0) goto L3a
            java.lang.String r6 = r3.getSubscriberId()     // Catch: java.lang.Throwable -> L3f
            r0 = r6
        L3a:
            if (r1 < r2) goto L45
        L3c:
            com.umeng.commonsdk.statistics.common.DeviceConfig.sImsiFlag = r4
            goto L45
        L3f:
            int r6 = android.os.Build.VERSION.SDK_INT
            if (r6 < r2) goto L45
            goto L3c
        L45:
            com.umeng.commonsdk.statistics.common.DeviceConfig.sImsi = r0
            java.lang.String r6 = com.umeng.commonsdk.statistics.common.DeviceConfig.sImsi
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.DeviceConfig.getImsi(android.content.Context):java.lang.String");
    }

    private static Locale getLocale(Context context) {
        Locale locale;
        if (context == null) {
            return Locale.getDefault();
        }
        try {
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            Settings.System.getConfiguration(context.getContentResolver(), configuration);
            locale = configuration.locale;
        } catch (Throwable unused) {
            MLog.e(LOG_TAG, "fail to read user config locale");
            locale = null;
        }
        return locale == null ? Locale.getDefault() : locale;
    }

    public static String[] getLocaleInfo(Context context) {
        String[] strArr = {"Unknown", "Unknown"};
        if (context == null) {
            return strArr;
        }
        try {
            Locale locale = getLocale(context);
            if (locale != null) {
                strArr[0] = locale.getCountry();
                strArr[1] = locale.getLanguage();
            }
            if (TextUtils.isEmpty(strArr[0])) {
                strArr[0] = "Unknown";
            }
            if (TextUtils.isEmpty(strArr[1])) {
                strArr[1] = "Unknown";
            }
            return strArr;
        } catch (Throwable th) {
            MLog.e(LOG_TAG, "error in getLocaleInfo", th);
            return strArr;
        }
    }

    public static String getMCCMNC(Context context) {
        if (context == null) {
            return null;
        }
        if (getImsi(context) == null) {
            return null;
        }
        int i = context.getResources().getConfiguration().mcc;
        int i2 = context.getResources().getConfiguration().mnc;
        if (i != 0) {
            String valueOf = String.valueOf(i2);
            if (i2 < 10) {
                valueOf = String.format("%02d", Integer.valueOf(i2));
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(String.valueOf(i));
            stringBuffer.append(valueOf);
            return stringBuffer.toString();
        }
        return null;
    }

    public static String getMac(Context context) {
        if (!TextUtils.isEmpty(sWifiMac)) {
            return sWifiMac;
        }
        String str = "";
        if (FieldManager.allow(com.umeng.commonsdk.utils.b.h)) {
            if (context == null) {
                return "";
            }
            int i = Build.VERSION.SDK_INT;
            if (i < 23) {
                str = getMacBySystemInterface(context);
            } else if (i == 23) {
                str = getMacByJavaAPI();
                if (TextUtils.isEmpty(str)) {
                    if (AnalyticsConstants.CHECK_DEVICE) {
                        str = getMacShell();
                    } else {
                        str = getMacBySystemInterface(context);
                    }
                }
            } else {
                str = getMacByJavaAPI();
                if (TextUtils.isEmpty(str)) {
                    str = getMacBySystemInterface(context);
                }
            }
        }
        sWifiMac = str;
        return sWifiMac;
    }

    private static String getMacByJavaAPI() {
        try {
            if (!FieldManager.allow(com.umeng.commonsdk.utils.b.h)) {
                return null;
            }
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if ("wlan0".equals(nextElement.getName()) || "eth0".equals(nextElement.getName())) {
                    byte[] hardwareAddress = nextElement.getHardwareAddress();
                    if (hardwareAddress != null && hardwareAddress.length != 0) {
                        StringBuilder sb = new StringBuilder();
                        for (byte b : hardwareAddress) {
                            sb.append(String.format("%02X:", Byte.valueOf(b)));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        return sb.toString().toLowerCase(Locale.getDefault());
                    }
                    return null;
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String getMacBySystemInterface(Context context) {
        if (context == null) {
            return "";
        }
        try {
            if (FieldManager.allow(com.umeng.commonsdk.utils.b.h)) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                    return wifiManager != null ? wifiManager.getConnectionInfo().getMacAddress() : "";
                }
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.w(LOG_TAG, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
                }
            }
            return "";
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.w(LOG_TAG, "Could not get mac address." + th.toString());
            }
            return "";
        }
    }

    private static String getMacShell() {
        String reaMac;
        try {
            if (!FieldManager.allow(com.umeng.commonsdk.utils.b.h)) {
                return null;
            }
            String[] strArr = {"/sys/class/net/wlan0/address", "/sys/class/net/eth0/address", "/sys/devices/virtual/net/wlan0/address"};
            for (int i = 0; i < 3; i++) {
                try {
                    reaMac = reaMac(strArr[i]);
                } catch (Throwable th) {
                    if (AnalyticsConstants.UM_DEBUG) {
                        MLog.e(LOG_TAG, "open file  Failed", th);
                    }
                }
                if (reaMac != null) {
                    return reaMac;
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getMeid(Context context) {
        TelephonyManager telephonyManager;
        String str = null;
        if (context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
            return null;
        }
        if (FieldManager.allow(com.umeng.commonsdk.utils.b.aj)) {
            try {
                if (checkPermission(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
                    if (Build.VERSION.SDK_INT < 26) {
                        str = getIMEI(context);
                    } else {
                        str = meid(context);
                        if (TextUtils.isEmpty(str)) {
                            str = getIMEI(context);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return str;
    }

    public static String[] getNetworkAccessMode(Context context) {
        String[] strArr = {"", ""};
        if (context == null) {
            return strArr;
        }
        if (!checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            strArr[0] = "";
            return strArr;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            strArr[0] = "";
            return strArr;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
            strArr[0] = "Wi-Fi";
            return strArr;
        }
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo2 != null && networkInfo2.getState() == NetworkInfo.State.CONNECTED) {
            strArr[0] = "2G/3G";
            strArr[1] = networkInfo2.getSubtypeName();
        }
        return strArr;
    }

    public static String getNetworkOperatorName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (checkPermission(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
                return telephonyManager.getNetworkOperatorName();
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static int getNetworkType(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                return telephonyManager.getNetworkType();
            }
            return 0;
        } catch (Exception unused) {
            return -100;
        }
    }

    public static String getOaid(Context context) {
        if (!TextUtils.isEmpty(sOAID)) {
            return sOAID;
        }
        if (!FieldManager.allow(com.umeng.commonsdk.utils.b.G)) {
            return "";
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(h.a, 0);
            if (sharedPreferences == null) {
                return "";
            }
            String string = sharedPreferences.getString(h.b, "");
            try {
                sOAID = string;
            } catch (Throwable unused) {
            }
            return string;
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static String getPackageName(Context context) {
        if (context == null) {
            return null;
        }
        return context.getPackageName();
    }

    public static String getRegisteredOperator(Context context) {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (!checkPermission(context, "android.permission.READ_PHONE_STATE") || telephonyManager == null) {
                return null;
            }
            return telephonyManager.getNetworkOperator();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int[] getResolutionArray(Context context) {
        int i;
        int i2;
        Method method;
        if (context == null) {
            return null;
        }
        int[] iArr = new int[2];
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                Display defaultDisplay = windowManager.getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                try {
                    Class<?> cls = Class.forName("android.view.Display");
                    if (cls != null && (method = cls.getMethod("getRealMetrics", DisplayMetrics.class)) != null) {
                        method.invoke(defaultDisplay, displayMetrics);
                        int i3 = displayMetrics.widthPixels;
                        int i4 = displayMetrics.heightPixels;
                        if (i3 > i4) {
                            iArr[0] = i4;
                            iArr[1] = i3;
                        } else {
                            iArr[0] = i3;
                            iArr[1] = i4;
                        }
                        iArr[0] = i3;
                        iArr[1] = i4;
                        return iArr;
                    }
                } catch (Throwable unused) {
                    return null;
                }
            } else {
                try {
                    DisplayMetrics displayMetrics2 = new DisplayMetrics();
                    windowManager.getDefaultDisplay().getMetrics(displayMetrics2);
                    if ((context.getApplicationInfo().flags & 8192) == 0) {
                        i = reflectMetrics(displayMetrics2, "noncompatWidthPixels");
                        i2 = reflectMetrics(displayMetrics2, "noncompatHeightPixels");
                    } else {
                        i = -1;
                        i2 = -1;
                    }
                    if (i == -1 || i2 == -1) {
                        i = displayMetrics2.widthPixels;
                        i2 = displayMetrics2.heightPixels;
                    }
                    if (i > i2) {
                        iArr[0] = i2;
                        iArr[1] = i;
                    } else {
                        iArr[0] = i;
                        iArr[1] = i2;
                    }
                    return iArr;
                } catch (Throwable unused2) {
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0075, code lost:
    
        if (r0 >= 29) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007d, code lost:
    
        com.umeng.commonsdk.statistics.common.DeviceConfig.sSecondImeiFlag = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007b, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 29) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getSecondSimIMEi(android.content.Context r9) {
        /*
            java.lang.String r0 = com.umeng.commonsdk.statistics.common.DeviceConfig.sSecondImei
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Lb
            java.lang.String r9 = com.umeng.commonsdk.statistics.common.DeviceConfig.sSecondImei
            return r9
        Lb:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 29
            if (r0 < r2) goto L17
            boolean r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.sSecondImeiFlag
            if (r3 == 0) goto L17
            return r1
        L17:
            if (r9 == 0) goto L7f
            java.lang.String r3 = "inner_imei2"
            boolean r3 = com.umeng.commonsdk.config.FieldManager.allow(r3)
            if (r3 == 0) goto L7f
            r3 = 23
            if (r0 < r3) goto L7f
            java.lang.String r3 = "android.permission.READ_PHONE_STATE"
            boolean r3 = com.umeng.commonsdk.utils.UMUtils.checkPermission(r9, r3)
            if (r3 == 0) goto L7f
            r3 = 1
            java.lang.String r4 = "phone"
            java.lang.Object r9 = r9.getSystemService(r4)     // Catch: java.lang.Throwable -> L78
            android.telephony.TelephonyManager r9 = (android.telephony.TelephonyManager) r9     // Catch: java.lang.Throwable -> L78
            if (r9 != 0) goto L3d
            if (r0 < r2) goto L3c
            com.umeng.commonsdk.statistics.common.DeviceConfig.sSecondImeiFlag = r3
        L3c:
            return r1
        L3d:
            java.lang.Class r1 = r9.getClass()     // Catch: java.lang.Throwable -> L78
            java.lang.String r4 = "getPhoneCount"
            r5 = 0
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch: java.lang.Throwable -> L78
            java.lang.reflect.Method r4 = r1.getMethod(r4, r6)     // Catch: java.lang.Throwable -> L78
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L78
            java.lang.Object r4 = r4.invoke(r9, r6)     // Catch: java.lang.Throwable -> L78
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> L78
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> L78
            r6 = 2
            if (r4 != r6) goto L75
            java.lang.String r4 = "getDeviceId"
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch: java.lang.Throwable -> L78
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch: java.lang.Throwable -> L78
            r7[r5] = r8     // Catch: java.lang.Throwable -> L78
            java.lang.reflect.Method r1 = r1.getMethod(r4, r7)     // Catch: java.lang.Throwable -> L78
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L78
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L78
            r4[r5] = r6     // Catch: java.lang.Throwable -> L78
            java.lang.Object r9 = r1.invoke(r9, r4)     // Catch: java.lang.Throwable -> L78
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.Throwable -> L78
            com.umeng.commonsdk.statistics.common.DeviceConfig.sSecondImei = r9     // Catch: java.lang.Throwable -> L78
        L75:
            if (r0 < r2) goto L7f
            goto L7d
        L78:
            int r9 = android.os.Build.VERSION.SDK_INT
            if (r9 < r2) goto L7f
        L7d:
            com.umeng.commonsdk.statistics.common.DeviceConfig.sSecondImeiFlag = r3
        L7f:
            java.lang.String r9 = com.umeng.commonsdk.statistics.common.DeviceConfig.sSecondImei
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.DeviceConfig.getSecondSimIMEi(android.content.Context):java.lang.String");
    }

    public static String getSerial() {
        return getSerialNo();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0050, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 29) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004a, code lost:
    
        com.umeng.commonsdk.statistics.common.DeviceConfig.sSerialFlag = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0048, code lost:
    
        if (android.os.Build.VERSION.SDK_INT >= 29) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String getSerialNo() {
        /*
            java.lang.String r0 = com.umeng.commonsdk.statistics.common.DeviceConfig.sSerialNo
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Lb
            java.lang.String r0 = com.umeng.commonsdk.statistics.common.DeviceConfig.sSerialNo
            return r0
        Lb:
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.String r1 = ""
            r2 = 29
            if (r0 < r2) goto L18
            boolean r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.sSerialFlag
            if (r3 == 0) goto L18
            return r1
        L18:
            java.lang.String r3 = "header_device_id_serialNo"
            boolean r3 = com.umeng.commonsdk.config.FieldManager.allow(r3)
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L53
            r3 = 9
            if (r0 < r3) goto L44
            r3 = 26
            if (r0 < r3) goto L41
            java.lang.String r0 = "android.os.Build"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Throwable -> L44
            java.lang.String r3 = "getSerial"
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch: java.lang.Throwable -> L44
            java.lang.reflect.Method r3 = r0.getMethod(r3, r6)     // Catch: java.lang.Throwable -> L44
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L44
            java.lang.Object r0 = r3.invoke(r0, r6)     // Catch: java.lang.Throwable -> L44
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L44
            goto L43
        L41:
            java.lang.String r0 = android.os.Build.SERIAL     // Catch: java.lang.Throwable -> L4d
        L43:
            r1 = r0
        L44:
            com.umeng.commonsdk.statistics.common.DeviceConfig.sSerialNo = r1     // Catch: java.lang.Throwable -> L4d
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r2) goto L53
        L4a:
            com.umeng.commonsdk.statistics.common.DeviceConfig.sSerialFlag = r5
            goto L53
        L4d:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r2) goto L53
            goto L4a
        L53:
            boolean r0 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG
            if (r0 == 0) goto L71
            java.lang.String r0 = com.umeng.commonsdk.statistics.common.DeviceConfig.LOG_TAG
            java.lang.Object[] r2 = new java.lang.Object[r5]
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "getDeviceId, serial no: "
            r3.append(r5)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2[r4] = r1
            com.umeng.commonsdk.statistics.common.MLog.i(r0, r2)
        L71:
            java.lang.String r0 = com.umeng.commonsdk.statistics.common.DeviceConfig.sSerialNo
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.DeviceConfig.getSerialNo():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0046, code lost:
    
        if (r0 >= 29) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
    
        com.umeng.commonsdk.statistics.common.DeviceConfig.sSimSerialNumberFlag = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0043, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 29) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getSimICCID(android.content.Context r5) {
        /*
            java.lang.String r0 = com.umeng.commonsdk.statistics.common.DeviceConfig.sSimSerialNumber
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Lb
            java.lang.String r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.sSimSerialNumber
            return r5
        Lb:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 29
            if (r0 < r2) goto L17
            boolean r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.sSimSerialNumberFlag
            if (r3 == 0) goto L17
            return r1
        L17:
            java.lang.String r3 = "inner_iccid"
            boolean r3 = com.umeng.commonsdk.config.FieldManager.allow(r3)
            if (r3 == 0) goto L4a
            r3 = 1
            if (r5 == 0) goto L46
            java.lang.String r4 = "android.permission.READ_PHONE_STATE"
            boolean r4 = com.umeng.commonsdk.utils.UMUtils.checkPermission(r5, r4)     // Catch: java.lang.Throwable -> L40
            if (r4 == 0) goto L46
            java.lang.String r4 = "phone"
            java.lang.Object r5 = r5.getSystemService(r4)     // Catch: java.lang.Throwable -> L40
            android.telephony.TelephonyManager r5 = (android.telephony.TelephonyManager) r5     // Catch: java.lang.Throwable -> L40
            if (r5 != 0) goto L39
            if (r0 < r2) goto L38
            com.umeng.commonsdk.statistics.common.DeviceConfig.sSimSerialNumberFlag = r3
        L38:
            return r1
        L39:
            java.lang.String r5 = r5.getSimSerialNumber()     // Catch: java.lang.Throwable -> L40
            com.umeng.commonsdk.statistics.common.DeviceConfig.sSimSerialNumber = r5     // Catch: java.lang.Throwable -> L40
            goto L46
        L40:
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r2) goto L4a
            goto L48
        L46:
            if (r0 < r2) goto L4a
        L48:
            com.umeng.commonsdk.statistics.common.DeviceConfig.sSimSerialNumberFlag = r3
        L4a:
            java.lang.String r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.sSimSerialNumber
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.DeviceConfig.getSimICCID(android.content.Context):java.lang.String");
    }

    public static String getSubOSName(Context context) {
        Properties buildProp = getBuildProp();
        try {
            String property = buildProp.getProperty(KEY_MIUI_VERSION_NAME);
            return TextUtils.isEmpty(property) ? isFlyMe() ? "Flyme" : isEmui(buildProp) ? "Emui" : !TextUtils.isEmpty(getYunOSVersion(buildProp)) ? "YunOS" : property : "MIUI";
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getSubOSVersion(Context context) {
        Properties buildProp = getBuildProp();
        try {
            String property = buildProp.getProperty(KEY_MIUI_VERSION_NAME);
            if (!TextUtils.isEmpty(property)) {
                return property;
            }
            try {
                if (isFlyMe()) {
                    property = getFlymeVersion(buildProp);
                } else if (isEmui(buildProp)) {
                    property = getEmuiVersion(buildProp);
                } else {
                    property = getYunOSVersion(buildProp);
                }
                return property;
            } catch (Throwable unused) {
                return property;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static int getTimeZone(Context context) {
        if (context == null) {
            return 8;
        }
        try {
            Calendar calendar = Calendar.getInstance(getLocale(context));
            if (calendar != null) {
                return calendar.getTimeZone().getRawOffset() / BaseConstants.Time.HOUR;
            }
        } catch (Throwable th) {
            MLog.i(LOG_TAG, "error in getTimeZone", th);
        }
        return 8;
    }

    private static String getYunOSVersion(Properties properties) {
        try {
            String property = properties.getProperty("ro.yunos.version");
            if (TextUtils.isEmpty(property)) {
                return null;
            }
            return property;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean isChineseAera(Context context) {
        String imprintProperty;
        if (context == null) {
            return false;
        }
        try {
            imprintProperty = UMEnvelopeBuild.imprintProperty(context, ak.O, "");
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(imprintProperty)) {
            return imprintProperty.equals("cn");
        }
        if (getImsi(context) == null) {
            String str = getLocaleInfo(context)[0];
            if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("cn")) {
                return true;
            }
        } else {
            int i = context.getResources().getConfiguration().mcc;
            if (i != 460 && i != 461) {
                if (i == 0) {
                    String str2 = getLocaleInfo(context)[0];
                    if (TextUtils.isEmpty(str2) || !str2.equalsIgnoreCase("cn")) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    private static boolean isEmui(Properties properties) {
        return properties.getProperty(KEY_EMUI_VERSION_CODE, null) != null;
    }

    private static boolean isFlyMe() {
        try {
            Build.class.getMethod("hasSmartBar", new Class[0]);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isHarmony(Context context) {
        try {
            return context.getString(Resources.getSystem().getIdentifier("config_os_brand", "string", "android")).equals("harmony");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return false;
        }
        try {
            if (checkPermission(context, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                return activeNetworkInfo.isConnectedOrConnecting();
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean isWiFiAvailable(Context context) {
        if (context == null) {
            return false;
        }
        return "Wi-Fi".equals(getNetworkAccessMode(context)[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
    
        if (r0 >= 29) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
    
        com.umeng.commonsdk.statistics.common.DeviceConfig.sImeiOrMeidFlag = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
    
        com.umeng.commonsdk.statistics.common.DeviceConfig.sMeid = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:
    
        return com.umeng.commonsdk.statistics.common.DeviceConfig.sMeid;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0059, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 29) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String meid(android.content.Context r7) {
        /*
            java.lang.String r0 = com.umeng.commonsdk.statistics.common.DeviceConfig.sMeid
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto Lb
            java.lang.String r7 = com.umeng.commonsdk.statistics.common.DeviceConfig.sMeid
            return r7
        Lb:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            r2 = 0
            if (r0 < r1) goto L17
            boolean r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.sImeiOrMeidFlag
            if (r3 == 0) goto L17
            return r2
        L17:
            if (r7 != 0) goto L1a
            return r2
        L1a:
            r7 = 1
            java.lang.String r3 = "android.telephony.TelephonyManager"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r4 = "getMeid"
            r5 = 0
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch: java.lang.Throwable -> L3e
            java.lang.reflect.Method r3 = r3.getMethod(r4, r6)     // Catch: java.lang.Throwable -> L3e
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r3 = r3.invoke(r2, r4)     // Catch: java.lang.Throwable -> L3e
            if (r3 == 0) goto L39
            boolean r4 = r3 instanceof java.lang.String     // Catch: java.lang.Throwable -> L3e
            if (r4 == 0) goto L39
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L3e
            r2 = r3
        L39:
            if (r0 < r1) goto L5c
        L3b:
            com.umeng.commonsdk.statistics.common.DeviceConfig.sImeiOrMeidFlag = r7
            goto L5c
        L3e:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L61
            r3.<init>()     // Catch: java.lang.Throwable -> L61
            java.lang.String r4 = "meid:"
            r3.append(r4)     // Catch: java.lang.Throwable -> L61
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L61
            r3.append(r0)     // Catch: java.lang.Throwable -> L61
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L61
            com.umeng.commonsdk.statistics.common.ULog.e(r0)     // Catch: java.lang.Throwable -> L61
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r1) goto L5c
            goto L3b
        L5c:
            com.umeng.commonsdk.statistics.common.DeviceConfig.sMeid = r2
            java.lang.String r7 = com.umeng.commonsdk.statistics.common.DeviceConfig.sMeid
            return r7
        L61:
            r0 = move-exception
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r1) goto L68
            com.umeng.commonsdk.statistics.common.DeviceConfig.sImeiOrMeidFlag = r7
        L68:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.DeviceConfig.meid(android.content.Context):java.lang.String");
    }

    private static String reaMac(String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String str2 = null;
        try {
            fileReader = new FileReader(str);
        } catch (Throwable unused) {
        }
        try {
            bufferedReader = new BufferedReader(fileReader, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            try {
                str2 = bufferedReader.readLine();
                try {
                    fileReader.close();
                } catch (Throwable unused2) {
                }
                bufferedReader.close();
                return str2;
            } catch (Throwable th) {
                th = th;
                try {
                    fileReader.close();
                } catch (Throwable unused3) {
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                        throw th;
                    } catch (Throwable unused4) {
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    private static int reflectMetrics(Object obj, String str) {
        try {
            Field declaredField = DisplayMetrics.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (Throwable unused) {
            return -1;
        }
    }
}
