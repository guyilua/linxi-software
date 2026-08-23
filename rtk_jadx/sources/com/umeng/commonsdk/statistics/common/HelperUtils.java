package com.umeng.commonsdk.statistics.common;

import android.text.TextUtils;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HelperUtils {
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private static final String TAG = "helper";

    public static String MD5(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                stringBuffer.append(String.format("%02X", Byte.valueOf(b)));
            }
            return stringBuffer.toString();
        } catch (Exception unused) {
            return str.replaceAll("[^[a-z][A-Z][0-9][.][_]]", "");
        }
    }

    public static boolean checkStrLen(String str, int i) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.length() <= i;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getFileMD5(File file) {
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        try {
            if (!file.isFile()) {
                return "";
            }
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                if (read != -1) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return String.format("%1$032x", new BigInteger(1, messageDigest.digest()));
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getMD5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                stringBuffer.append(Integer.toHexString((b & 255) | (-256)).substring(6));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            MLog.i(TAG, "getMD5 error", e);
            return "";
        }
    }

    public static String getUmengMD5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                stringBuffer.append(Integer.toHexString(b & 255));
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            MLog.i(TAG, "getMD5 error", th);
            return "";
        }
    }

    public static String readFile(File file) {
        FileInputStream fileInputStream;
        try {
            if (!file.exists()) {
                safeClose((InputStream) null);
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String str = new String(bArr);
                safeClose(fileInputStream);
                return str;
            } catch (Throwable unused) {
                safeClose(fileInputStream);
                return null;
            }
        } catch (Throwable unused2) {
            fileInputStream = null;
        }
    }

    public static byte[] readStreamToByteArray(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static String readStreamToString(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        StringWriter stringWriter = new StringWriter();
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (-1 != read) {
                stringWriter.write(cArr, 0, read);
            } else {
                return stringWriter.toString();
            }
        }
    }

    public static void safeClose(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    public static String subStr(String str, int i) {
        String str2 = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                str2 = str.substring(0, str.length() < i ? str.length() : i);
                int length = str2.getBytes("UTF-8").length;
                int i2 = i;
                while (length > i) {
                    i2--;
                    str2 = str.substring(0, i2 > str.length() ? str.length() : i2);
                    length = str2.getBytes("UTF-8").length;
                }
                return str2;
            }
        } catch (Exception e) {
            MLog.e(e);
        }
        return str2;
    }

    public static void writeFile(File file, byte[] bArr) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
        } finally {
            safeClose(fileOutputStream);
        }
    }

    public static void safeClose(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void writeFile(File file, String str) {
        writeFile(file, str.getBytes());
    }
}
