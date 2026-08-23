package com.umeng.commonsdk.utils;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileLock;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FileLockUtil {
    private final Object lockObject = new Object();

    /* JADX WARN: Removed duplicated region for block: B:14:0x0022 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.nio.channels.FileLock getFileLock(java.lang.String r3) {
        /*
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.io.IOException -> L15 java.io.FileNotFoundException -> L1b
            java.lang.String r2 = "rw"
            r1.<init>(r3, r2)     // Catch: java.io.IOException -> L15 java.io.FileNotFoundException -> L1b
            java.nio.channels.FileChannel r3 = r1.getChannel()     // Catch: java.io.IOException -> L15 java.io.FileNotFoundException -> L1b
            java.nio.channels.FileLock r3 = r3.lock()     // Catch: java.io.IOException -> L11 java.io.FileNotFoundException -> L13
            return r3
        L11:
            r1 = move-exception
            goto L17
        L13:
            r1 = move-exception
            goto L1d
        L15:
            r1 = move-exception
            r3 = r0
        L17:
            r1.printStackTrace()
            goto L20
        L1b:
            r1 = move-exception
            r3 = r0
        L1d:
            r1.printStackTrace()
        L20:
            if (r3 == 0) goto L2a
            r3.close()     // Catch: java.io.IOException -> L26
            goto L2a
        L26:
            r3 = move-exception
            r3.printStackTrace()
        L2a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.FileLockUtil.getFileLock(java.lang.String):java.nio.channels.FileLock");
    }

    public void doFileOperateion(File file, FileLockCallback fileLockCallback, Object obj) {
        if (file.exists()) {
            synchronized (this.lockObject) {
                FileLock fileLock = getFileLock(file.getAbsolutePath());
                if (fileLock != null) {
                    try {
                        try {
                            fileLockCallback.onFileLock(file.getName(), obj);
                        } catch (Exception e) {
                            e.printStackTrace();
                            try {
                                fileLock.release();
                                fileLock.channel().close();
                            } catch (IOException e2) {
                                e = e2;
                                e.printStackTrace();
                            }
                        }
                        try {
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (IOException e3) {
                            e = e3;
                            e.printStackTrace();
                        }
                    } catch (Throwable th) {
                        try {
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                        throw th;
                    }
                }
            }
        }
    }

    public void doFileOperateion(File file, FileLockCallback fileLockCallback, int i) {
        if (file.exists()) {
            synchronized (this.lockObject) {
                FileLock fileLock = getFileLock(file.getAbsolutePath());
                if (fileLock != null) {
                    try {
                        try {
                            fileLockCallback.onFileLock(file, i);
                            try {
                                fileLock.release();
                                fileLock.channel().close();
                            } catch (Throwable th) {
                                th = th;
                                th.printStackTrace();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            try {
                                fileLock.release();
                                fileLock.channel().close();
                            } catch (Throwable th2) {
                                th = th2;
                                th.printStackTrace();
                            }
                        }
                    } catch (Throwable th3) {
                        try {
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                        throw th3;
                    }
                }
            }
        }
    }

    public void doFileOperateion(File file, FileLockCallback fileLockCallback) {
        if (file.exists()) {
            synchronized (this.lockObject) {
                FileLock fileLock = getFileLock(file.getAbsolutePath());
                if (fileLock != null) {
                    try {
                        try {
                            fileLockCallback.onFileLock(file.getName());
                        } catch (Exception e) {
                            e.printStackTrace();
                            try {
                                fileLock.release();
                                fileLock.channel().close();
                            } catch (IOException e2) {
                                e = e2;
                                e.printStackTrace();
                            }
                        }
                        try {
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (IOException e3) {
                            e = e3;
                            e.printStackTrace();
                        }
                    } catch (Throwable th) {
                        try {
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                        throw th;
                    }
                }
            }
        }
    }

    public void doFileOperateion(String str, FileLockCallback fileLockCallback) {
        File file = new File(str);
        if (file.exists()) {
            synchronized (this.lockObject) {
                FileLock fileLock = getFileLock(str);
                if (fileLock != null) {
                    try {
                        try {
                            fileLockCallback.onFileLock(file.getName());
                            try {
                                fileLock.release();
                                fileLock.channel().close();
                            } catch (IOException e) {
                                e = e;
                                e.printStackTrace();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            try {
                                fileLock.release();
                                fileLock.channel().close();
                            } catch (IOException e3) {
                                e = e3;
                                e.printStackTrace();
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                        throw th;
                    }
                }
            }
        }
    }
}
