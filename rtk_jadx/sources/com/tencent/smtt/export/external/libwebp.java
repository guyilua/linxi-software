package com.tencent.smtt.export.external;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class libwebp {
    private static final int BITMAP_ALPHA_8 = 1;
    private static final int BITMAP_ARGB_4444 = 3;
    private static final int BITMAP_ARGB_8888 = 4;
    private static final int BITMAP_RGB_565 = 2;
    private static final String LOGTAG = "[image]";
    private static boolean isMultiCore = false;
    private static libwebp mInstance = null;
    private static boolean mIsLoadLibSuccess = false;
    private int mBitmapType = 4;

    /* renamed from: com.tencent.smtt.export.external.libwebp$1, reason: invalid class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            try {
                iArr[Bitmap.Config.ARGB_4444.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static int checkIsHuaModel() {
        String lowerCase = Build.BRAND.trim().toLowerCase();
        String lowerCase2 = Build.MODEL.trim().toLowerCase();
        int i = (lowerCase == null || lowerCase.length() <= 0 || !lowerCase.contains("huawei")) ? 0 : 1;
        if (lowerCase2 == null || lowerCase2.length() <= 0 || !lowerCase2.contains("huawei")) {
            return i;
        }
        return 1;
    }

    private String getCPUinfo() {
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/proc/cpuinfo").start().getInputStream();
            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static libwebp getInstance(Context context) {
        if (mInstance == null) {
            loadWepLibraryIfNeed(context);
            mInstance = new libwebp();
        }
        return mInstance;
    }

    private boolean isMultiCore() {
        return getCPUinfo().contains("processor");
    }

    public static void loadWepLibraryIfNeed(Context context, String str) {
        if (mIsLoadLibSuccess) {
            return;
        }
        try {
            System.load(str + File.separator + "libwebp_base.so");
            mIsLoadLibSuccess = true;
        } catch (UnsatisfiedLinkError unused) {
            Log.e(LOGTAG, "Load WebP Library Error...: libwebp.java - loadWepLibraryIfNeed()");
        }
    }

    public int[] decodeBase(byte[] bArr, int[] iArr, int[] iArr2) {
        if (!mIsLoadLibSuccess) {
            Log.e(LOGTAG, "Load WebP Library Error...");
            return null;
        }
        return nativeDecode(bArr, isMultiCore, iArr, iArr2);
    }

    public int[] decodeBase_16bit(byte[] bArr, Bitmap.Config config) {
        if (!mIsLoadLibSuccess) {
            Log.e(LOGTAG, "Load WebP Library Error...");
            return null;
        }
        int i = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()];
        if (i == 1) {
            this.mBitmapType = 3;
        } else if (i != 2) {
            this.mBitmapType = 2;
        } else {
            this.mBitmapType = 2;
        }
        return nativeDecode_16bit(bArr, isMultiCore, this.mBitmapType);
    }

    public int[] decodeInto(byte[] bArr, int[] iArr, int[] iArr2) {
        if (!mIsLoadLibSuccess) {
            Log.e(LOGTAG, "Load WebP Library Error...");
            return null;
        }
        return nativeDecodeInto(bArr, isMultiCore, iArr, iArr2);
    }

    public int getInfo(byte[] bArr, int[] iArr, int[] iArr2) {
        if (mIsLoadLibSuccess) {
            return nativeGetInfo(bArr, iArr, iArr2);
        }
        return 0;
    }

    public int[] incDecode(byte[] bArr, int[] iArr, int[] iArr2) {
        if (!mIsLoadLibSuccess) {
            Log.e(LOGTAG, "Load WebP Library Error...");
            return null;
        }
        return nativeIDecode(bArr, isMultiCore, iArr, iArr2);
    }

    public native int[] nativeDecode(byte[] bArr, boolean z, int[] iArr, int[] iArr2);

    public native int[] nativeDecodeInto(byte[] bArr, boolean z, int[] iArr, int[] iArr2);

    public native int[] nativeDecode_16bit(byte[] bArr, boolean z, int i);

    public native int nativeGetInfo(byte[] bArr, int[] iArr, int[] iArr2);

    public native int[] nativeIDecode(byte[] bArr, boolean z, int[] iArr, int[] iArr2);

    public static void loadWepLibraryIfNeed(Context context) {
        if (mIsLoadLibSuccess) {
            return;
        }
        try {
            LibraryLoader.loadLibrary(context, "webp_base");
            mIsLoadLibSuccess = true;
        } catch (UnsatisfiedLinkError unused) {
            Log.e(LOGTAG, "Load WebP Library Error...: libwebp.java - loadWepLibraryIfNeed()");
        }
    }
}
