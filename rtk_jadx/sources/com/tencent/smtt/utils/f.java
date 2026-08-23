package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsLogReport;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;

/* compiled from: FileUtil.java */
@SuppressLint({"NewApi"})
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f {
    public static String a = null;
    public static final a b = new a() { // from class: com.tencent.smtt.utils.f.2
        @Override // com.tencent.smtt.utils.f.a
        public boolean a(File file, File file2) {
            return file.length() == file2.length() && file.lastModified() == file2.lastModified();
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private static final int f984c = 4;
    private static RandomAccessFile d;

    /* compiled from: FileUtil.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        boolean a(File file, File file2);
    }

    /* compiled from: FileUtil.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface b {
        boolean a(InputStream inputStream, ZipEntry zipEntry, String str);
    }

    private static String b(Context context, String str) {
        if (context == null) {
            return "";
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        try {
            return context.getExternalFilesDir(str).getAbsolutePath();
        } catch (Throwable th) {
            th.printStackTrace();
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(Environment.getExternalStorageDirectory());
                String str2 = File.separator;
                sb.append(str2);
                sb.append("Android");
                sb.append(str2);
                sb.append("data");
                sb.append(str2);
                sb.append(context.getApplicationInfo().packageName);
                sb.append(str2);
                sb.append("files");
                sb.append(str2);
                sb.append(str);
                return sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    public static boolean c(File file) {
        return file != null && file.exists() && file.isFile() && file.length() > 0;
    }

    public static FileOutputStream d(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                if (!file.canWrite()) {
                    throw new IOException("File '" + file + "' cannot be written to");
                }
            } else {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
        } else {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                throw new IOException("File '" + file + "' could not be created");
            }
        }
        return new FileOutputStream(file);
    }

    public static FileLock e(Context context) {
        boolean z;
        TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #1");
        try {
            z = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
        } catch (Throwable unused) {
            z = true;
        }
        FileLock fileLock = null;
        if (!z) {
            FileOutputStream b2 = b(context, true, "tbs_rename_lock");
            if (b2 == null) {
                TbsLog.i("FileHelper", "init -- failed to get rename fileLock#1!");
            } else {
                fileLock = a(context, b2);
                if (fileLock == null) {
                    TbsLog.i("FileHelper", "init -- failed to get rename fileLock#2!");
                } else {
                    TbsLog.i("FileHelper", "init -- get rename fileLock success!");
                }
            }
            TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #2 renameFileLock is " + fileLock);
            return fileLock;
        }
        TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #3");
        File a2 = a(context, "tbs_rename_lock");
        TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #4 " + a2);
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(a2.getAbsolutePath(), "r");
            d = randomAccessFile;
            fileLock = randomAccessFile.getChannel().tryLock(0L, Long.MAX_VALUE, true);
        } catch (Throwable th) {
            TbsLog.e("FileHelper", "getTbsCoreLoadFileLock -- exception: " + th);
        }
        if (fileLock == null) {
            fileLock = g(context);
        }
        if (fileLock == null) {
            TbsLog.i("FileHelper", "getTbsCoreLoadFileLock -- failed: tbs_rename_lock");
        } else {
            TbsLog.i("FileHelper", "getTbsCoreLoadFileLock -- success: tbs_rename_lock");
        }
        return fileLock;
    }

    public static FileLock f(Context context) {
        FileLock fileLock;
        File a2 = a(context, "tbs_rename_lock");
        TbsLog.i("FileHelper", "getTbsCoreRenameFileLock #1 " + a2);
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(a2.getAbsolutePath(), "rw");
            d = randomAccessFile;
            fileLock = randomAccessFile.getChannel().tryLock(0L, Long.MAX_VALUE, false);
        } catch (Throwable unused) {
            TbsLog.e("FileHelper", "getTbsCoreRenameFileLock -- excpetion: tbs_rename_lock");
            fileLock = null;
        }
        if (fileLock == null) {
            TbsLog.i("FileHelper", "getTbsCoreRenameFileLock -- failed: tbs_rename_lock");
        } else {
            TbsLog.i("FileHelper", "getTbsCoreRenameFileLock -- success: tbs_rename_lock");
        }
        return fileLock;
    }

    private static FileLock g(Context context) {
        FileLock fileLock = null;
        try {
            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
            tbsLogInfo.setErrorCode(803);
            File a2 = a(context, "tbs_rename_lock");
            if (TbsDownloadConfig.getInstance(context).getTbsCoreLoadRenameFileLockWaitEnable()) {
                int i = 0;
                while (i < 20 && fileLock == null) {
                    try {
                        try {
                            Thread.sleep(100L);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        RandomAccessFile randomAccessFile = new RandomAccessFile(a2.getAbsolutePath(), "r");
                        d = randomAccessFile;
                        fileLock = randomAccessFile.getChannel().tryLock(0L, Long.MAX_VALUE, true);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    i++;
                }
                if (fileLock != null) {
                    tbsLogInfo.setErrorCode(802);
                } else {
                    tbsLogInfo.setErrorCode(801);
                }
                TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_SDK_REPORT_INFO, tbsLogInfo);
                StringBuilder sb = new StringBuilder();
                sb.append("getTbsCoreLoadFileLock,retry num=");
                sb.append(i);
                sb.append("success=");
                sb.append(fileLock == null);
                TbsLog.i("FileHelper", sb.toString());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return fileLock;
    }

    public static String a(Context context, int i) {
        return a(context, context.getApplicationInfo().packageName, i, true);
    }

    public static String c(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory());
        String str = File.separator;
        sb.append(str);
        sb.append("tbs");
        sb.append(str);
        sb.append("file_locks");
        return sb.toString();
    }

    public static String a(Context context, String str, int i, boolean z) {
        String str2;
        if (context == null) {
            return "";
        }
        try {
            str2 = Environment.getExternalStorageDirectory() + File.separator;
        } catch (Exception e) {
            e.printStackTrace();
            str2 = "";
        }
        switch (i) {
            case 1:
                if (str2.equals("")) {
                    return str2;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append("tencent");
                String str3 = File.separator;
                sb.append(str3);
                sb.append("tbs");
                sb.append(str3);
                sb.append(str);
                return sb.toString();
            case 2:
                if (str2.equals("")) {
                    return str2;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append("tbs");
                String str4 = File.separator;
                sb2.append(str4);
                sb2.append("backup");
                sb2.append(str4);
                sb2.append(str);
                return sb2.toString();
            case 3:
                if (str2.equals("")) {
                    return str2;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str2);
                sb3.append("tencent");
                String str5 = File.separator;
                sb3.append(str5);
                sb3.append("tbs");
                sb3.append(str5);
                sb3.append("backup");
                sb3.append(str5);
                sb3.append(str);
                return sb3.toString();
            case 4:
                if (str2.equals("")) {
                    return b(context, "backup");
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str2);
                sb4.append("tencent");
                String str6 = File.separator;
                sb4.append(str6);
                sb4.append("tbs");
                sb4.append(str6);
                sb4.append("backup");
                sb4.append(str6);
                sb4.append(str);
                String sb5 = sb4.toString();
                if (!z) {
                    return sb5;
                }
                File file = new File(sb5);
                if (file.exists() && file.canWrite()) {
                    return sb5;
                }
                if (!file.exists()) {
                    file.mkdirs();
                    return !file.canWrite() ? b(context, "backup") : sb5;
                }
                return b(context, "backup");
            case 5:
                if (str2.equals("")) {
                    return str2;
                }
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str2);
                sb6.append("tencent");
                String str7 = File.separator;
                sb6.append(str7);
                sb6.append("tbs");
                sb6.append(str7);
                sb6.append(str);
                return sb6.toString();
            case 6:
                String str8 = a;
                if (str8 != null) {
                    return str8;
                }
                String b2 = b(context, "tbslog");
                a = b2;
                return b2;
            case 7:
                if (str2.equals("")) {
                    return str2;
                }
                StringBuilder sb7 = new StringBuilder();
                sb7.append(str2);
                sb7.append("tencent");
                String str9 = File.separator;
                sb7.append(str9);
                sb7.append("tbs");
                sb7.append(str9);
                sb7.append("backup");
                sb7.append(str9);
                sb7.append("core");
                return sb7.toString();
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public static boolean b(InputStream inputStream, ZipEntry zipEntry, String str, String str2) {
        FileOutputStream fileOutputStream;
        a(new File(str));
        String str3 = str + File.separator + str2;
        File file = new File(str3);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.close();
            if (a(str3, zipEntry.getSize(), zipEntry.getTime(), zipEntry.getCrc())) {
                TbsLog.e("FileHelper", "file is different: " + str3);
                return false;
            }
            if (file.setLastModified(zipEntry.getTime())) {
                return true;
            }
            TbsLog.e("FileHelper", "Couldn't set time for dst file " + file);
            return true;
        } catch (IOException e2) {
            e = e2;
            b(file);
            throw new IOException("Couldn't write dst file " + file, e);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    static String d(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_private");
        if (file.isDirectory() || file.mkdir()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public static boolean b(File file, File file2) {
        return a(file, file2, (FileFilter) null);
    }

    private static boolean b(File file, File file2, FileFilter fileFilter, a aVar) {
        FileChannel fileChannel;
        if (file == null || file2 == null) {
            return false;
        }
        if (fileFilter != null && !fileFilter.accept(file)) {
            return false;
        }
        FileChannel fileChannel2 = null;
        try {
            if (file.exists() && file.isFile()) {
                if (file2.exists()) {
                    if (aVar != null && aVar.a(file, file2)) {
                        return true;
                    }
                    b(file2);
                }
                File parentFile = file2.getParentFile();
                if (parentFile.isFile()) {
                    b(parentFile);
                }
                if (!parentFile.exists() && !parentFile.mkdirs()) {
                    return false;
                }
                FileChannel channel = new FileInputStream(file).getChannel();
                try {
                    fileChannel2 = new FileOutputStream(file2).getChannel();
                    long size = channel.size();
                    if (fileChannel2.transferFrom(channel, 0L, size) == size) {
                        if (channel != null) {
                            channel.close();
                        }
                        if (fileChannel2 != null) {
                            fileChannel2.close();
                        }
                        return true;
                    }
                    b(file2);
                    if (channel != null) {
                        channel.close();
                    }
                    if (fileChannel2 != null) {
                        fileChannel2.close();
                    }
                    return false;
                } catch (Throwable th) {
                    FileChannel fileChannel3 = fileChannel2;
                    fileChannel2 = channel;
                    th = th;
                    fileChannel = fileChannel3;
                    if (fileChannel2 != null) {
                        fileChannel2.close();
                    }
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                    throw th;
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
        }
    }

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        if (context != null) {
            return context.getApplicationContext().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        }
        return false;
    }

    public static boolean a(File file, File file2) {
        return a(file.getPath(), file2.getPath());
    }

    @SuppressLint({"InlinedApi"})
    public static boolean a(String str, String str2) {
        return a(str, str2, Build.CPU_ABI, Build.VERSION.SDK_INT >= 8 ? Build.CPU_ABI2 : null, j.a("ro.product.cpu.upgradeabi", "armeabi"));
    }

    private static boolean a(String str, final String str2, String str3, String str4, String str5) {
        return a(str, str3, str4, str5, new b() { // from class: com.tencent.smtt.utils.f.1
            @Override // com.tencent.smtt.utils.f.b
            public boolean a(InputStream inputStream, ZipEntry zipEntry, String str6) {
                try {
                    return f.b(inputStream, zipEntry, str2, str6);
                } catch (Exception e) {
                    throw new Exception("copyFileIfChanged Exception", e);
                }
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x008b, code lost:
    
        if (r6.regionMatches(r9, r14, 0, r14.length()) == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0096, code lost:
    
        if (r6.charAt(r9 + r14.length()) != '/') goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0098, code lost:
    
        if (r3 != false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x009a, code lost:
    
        if (r4 == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x000e, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x000e, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x000e, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean a(java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, com.tencent.smtt.utils.f.b r15) {
        /*
            r0 = 0
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> Lca
            r1.<init>(r11)     // Catch: java.lang.Throwable -> Lca
            java.util.Enumeration r11 = r1.entries()     // Catch: java.lang.Throwable -> Lc7
            r0 = 1
            r2 = 0
            r3 = 0
            r4 = 0
        Le:
            boolean r5 = r11.hasMoreElements()     // Catch: java.lang.Throwable -> Lc7
            if (r5 == 0) goto Lc3
            java.lang.Object r5 = r11.nextElement()     // Catch: java.lang.Throwable -> Lc7
            java.util.zip.ZipEntry r5 = (java.util.zip.ZipEntry) r5     // Catch: java.lang.Throwable -> Lc7
            java.lang.String r6 = r5.getName()     // Catch: java.lang.Throwable -> Lc7
            if (r6 != 0) goto L21
            goto Le
        L21:
            java.lang.String r7 = "../"
            boolean r7 = r6.contains(r7)     // Catch: java.lang.Throwable -> Lc7
            if (r7 == 0) goto L2a
            goto Le
        L2a:
            java.lang.String r7 = "lib/"
            boolean r7 = r6.startsWith(r7)     // Catch: java.lang.Throwable -> Lc7
            if (r7 != 0) goto L3b
            java.lang.String r7 = "assets/"
            boolean r7 = r6.startsWith(r7)     // Catch: java.lang.Throwable -> Lc7
            if (r7 != 0) goto L3b
            goto Le
        L3b:
            r7 = 47
            int r8 = r6.lastIndexOf(r7)     // Catch: java.lang.Throwable -> Lc7
            java.lang.String r8 = r6.substring(r8)     // Catch: java.lang.Throwable -> Lc7
            java.lang.String r9 = ".so"
            boolean r9 = r8.endsWith(r9)     // Catch: java.lang.Throwable -> Lc7
            if (r9 == 0) goto L9e
            int r9 = com.tencent.smtt.utils.f.f984c     // Catch: java.lang.Throwable -> Lc7
            int r10 = r12.length()     // Catch: java.lang.Throwable -> Lc7
            boolean r10 = r6.regionMatches(r9, r12, r2, r10)     // Catch: java.lang.Throwable -> Lc7
            if (r10 == 0) goto L66
            int r10 = r12.length()     // Catch: java.lang.Throwable -> Lc7
            int r10 = r10 + r9
            char r10 = r6.charAt(r10)     // Catch: java.lang.Throwable -> Lc7
            if (r10 != r7) goto L66
            r3 = 1
            goto L9e
        L66:
            if (r13 == 0) goto L81
            int r10 = r13.length()     // Catch: java.lang.Throwable -> Lc7
            boolean r10 = r6.regionMatches(r9, r13, r2, r10)     // Catch: java.lang.Throwable -> Lc7
            if (r10 == 0) goto L81
            int r10 = r13.length()     // Catch: java.lang.Throwable -> Lc7
            int r10 = r10 + r9
            char r10 = r6.charAt(r10)     // Catch: java.lang.Throwable -> Lc7
            if (r10 != r7) goto L81
            r4 = 1
            if (r3 == 0) goto L9e
            goto Le
        L81:
            if (r14 == 0) goto Le
            int r10 = r14.length()     // Catch: java.lang.Throwable -> Lc7
            boolean r10 = r6.regionMatches(r9, r14, r2, r10)     // Catch: java.lang.Throwable -> Lc7
            if (r10 == 0) goto Le
            int r10 = r14.length()     // Catch: java.lang.Throwable -> Lc7
            int r9 = r9 + r10
            char r6 = r6.charAt(r9)     // Catch: java.lang.Throwable -> Lc7
            if (r6 != r7) goto Le
            if (r3 != 0) goto Le
            if (r4 == 0) goto L9e
            goto Le
        L9e:
            java.io.InputStream r6 = r1.getInputStream(r5)     // Catch: java.lang.Throwable -> Lc7
            java.lang.String r7 = r8.substring(r0)     // Catch: java.lang.Throwable -> Lbc
            boolean r5 = r15.a(r6, r5, r7)     // Catch: java.lang.Throwable -> Lbc
            if (r5 != 0) goto Lb5
            if (r6 == 0) goto Lb1
            r6.close()     // Catch: java.lang.Throwable -> Lc7
        Lb1:
            r1.close()
            return r2
        Lb5:
            if (r6 == 0) goto Le
            r6.close()     // Catch: java.lang.Throwable -> Lc7
            goto Le
        Lbc:
            r11 = move-exception
            if (r6 == 0) goto Lc2
            r6.close()     // Catch: java.lang.Throwable -> Lc7
        Lc2:
            throw r11     // Catch: java.lang.Throwable -> Lc7
        Lc3:
            r1.close()
            return r0
        Lc7:
            r11 = move-exception
            r0 = r1
            goto Lcb
        Lca:
            r11 = move-exception
        Lcb:
            if (r0 == 0) goto Ld0
            r0.close()
        Ld0:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.f.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.tencent.smtt.utils.f$b):boolean");
    }

    public static void b(File file) {
        a(file, false);
    }

    public static boolean b(Context context) {
        long a2 = q.a();
        boolean z = a2 >= TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
        if (!z) {
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDwonloader.hasEnoughFreeSpace] freeSpace too small,  freeSpace = " + a2);
        }
        return z;
    }

    public static FileOutputStream b(Context context, boolean z, String str) {
        File a2 = a(context, z, str);
        if (a2 == null) {
            return null;
        }
        try {
            return new FileOutputStream(a2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean a(String str, long j, long j2, long j3) {
        File file = new File(str);
        if (file.length() != j) {
            TbsLog.e("FileHelper", "file size doesn't match: " + file.length() + " vs " + j);
            return true;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                CRC32 crc32 = new CRC32();
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    crc32.update(bArr, 0, read);
                }
                long value = crc32.getValue();
                TbsLog.i("FileHelper", "" + file.getName() + ": crc = " + value + ", zipCrc = " + j3);
                if (value != j3) {
                    fileInputStream2.close();
                    return true;
                }
                fileInputStream2.close();
                return false;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean a(File file, File file2, FileFilter fileFilter) {
        return a(file, file2, fileFilter, b);
    }

    public static boolean a(File file, File file2, FileFilter fileFilter, a aVar) {
        if (file == null || file2 == null || !file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return b(file, file2, fileFilter, aVar);
        }
        File[] listFiles = file.listFiles(fileFilter);
        if (listFiles == null) {
            return false;
        }
        boolean z = true;
        for (File file3 : listFiles) {
            if (!a(file3, new File(file2, file3.getName()), fileFilter)) {
                z = false;
            }
        }
        return z;
    }

    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        b(file);
        return file.mkdirs();
    }

    public static void a(File file, boolean z) {
        TbsLog.i("FileUtils", "delete file,ignore=" + z + file + Log.getStackTraceString(new Throwable()));
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            a(file2, z);
        }
        if (z) {
            return;
        }
        file.delete();
    }

    public static void a(File file, boolean z, String str) {
        TbsLog.i("FileUtils", "delete file,ignore=" + z + "except" + str + file + Log.getStackTraceString(new Throwable()));
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (!file2.getName().equals(str)) {
                a(file2, z);
            }
        }
        if (z) {
            return;
        }
        file.delete();
    }

    public static File a(Context context, boolean z, String str) {
        String c2;
        if (z) {
            c2 = d(context);
        } else {
            c2 = c(context);
        }
        if (c2 == null) {
            return null;
        }
        File file = new File(c2);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!file.canWrite()) {
            return null;
        }
        File file2 = new File(file, str);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return file2;
    }

    public static File a(Context context, String str) {
        File file = new File(context.getFilesDir(), "tbs");
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!file.canWrite()) {
            TbsLog.e("FileHelper", "getPermanentTbsFile -- no permission!");
            return null;
        }
        File file2 = new File(file, str);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                TbsLog.e("FileHelper", "getPermanentTbsFile -- exception: " + e);
                return null;
            }
        }
        return file2;
    }

    public static FileLock a(Context context, FileOutputStream fileOutputStream) {
        FileLock tryLock;
        if (fileOutputStream == null) {
            return null;
        }
        try {
            tryLock = fileOutputStream.getChannel().tryLock();
        } catch (OverlappingFileLockException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (tryLock.isValid()) {
            return tryLock;
        }
        return null;
    }

    public static void a(FileLock fileLock, FileOutputStream fileOutputStream) {
        if (fileLock != null) {
            try {
                FileChannel channel = fileLock.channel();
                if (channel != null && channel.isOpen()) {
                    fileLock.release();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static synchronized void a(Context context, FileLock fileLock) {
        synchronized (f.class) {
            TbsLog.i("FileHelper", "releaseTbsCoreRenameFileLock -- lock: " + fileLock);
            FileChannel channel = fileLock.channel();
            if (channel != null && channel.isOpen()) {
                try {
                    fileLock.release();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
