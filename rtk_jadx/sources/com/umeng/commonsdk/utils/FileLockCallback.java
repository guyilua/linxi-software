package com.umeng.commonsdk.utils;

import java.io.File;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface FileLockCallback {
    boolean onFileLock(File file, int i);

    boolean onFileLock(String str);

    boolean onFileLock(String str, Object obj);
}
