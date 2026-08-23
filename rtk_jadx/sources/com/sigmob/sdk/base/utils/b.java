package com.sigmob.sdk.base.utils;

import android.os.AsyncTask;
import com.czhj.sdk.logger.SigmobLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class b {

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class a extends AsyncTask<String, Void, Boolean> {
        private final File a;
        private final File b;

        /* renamed from: c, reason: collision with root package name */
        private final InterfaceC0037b f435c;

        a(File file, File file2, InterfaceC0037b interfaceC0037b) {
            this.a = file2;
            this.b = file;
            this.f435c = interfaceC0037b;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String[] strArr) {
            try {
                b.a(this.a, this.b);
                return Boolean.TRUE;
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
                return Boolean.FALSE;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            InterfaceC0037b interfaceC0037b = this.f435c;
            if (interfaceC0037b != null) {
                interfaceC0037b.a(bool.booleanValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.sigmob.sdk.base.utils.b$b, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface InterfaceC0037b {
        void a(boolean z);
    }

    public static List<File> a(File file, File file2) {
        GZIPInputStream gZIPInputStream;
        SigmobLog.i(String.format("Untaring %s to dir %s.", file.getAbsolutePath(), file2.getAbsolutePath()));
        LinkedList linkedList = new LinkedList();
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            gZIPInputStream = new GZIPInputStream(fileInputStream);
        } catch (Throwable th) {
            fileInputStream.close();
            fileInputStream = new FileInputStream(file);
            SigmobLog.e(th.getMessage());
            gZIPInputStream = null;
        }
        com.sigmob.sdk.archives.tar.b bVar = (com.sigmob.sdk.archives.tar.b) (gZIPInputStream != null ? new com.sigmob.sdk.archives.d().a("tar", gZIPInputStream) : new com.sigmob.sdk.archives.d().a("tar", fileInputStream));
        if (!file2.exists()) {
            file2.mkdirs();
        }
        while (true) {
            com.sigmob.sdk.archives.tar.a aVar = (com.sigmob.sdk.archives.tar.a) bVar.a();
            if (aVar == null) {
                bVar.close();
                if (gZIPInputStream != null) {
                    gZIPInputStream.close();
                }
                fileInputStream.close();
                return linkedList;
            }
            File file3 = new File(file2, aVar.a());
            if (aVar.c()) {
                SigmobLog.i(String.format("Attempting to write output directory %s.", file3.getAbsolutePath()));
                if (file3.exists()) {
                    continue;
                } else {
                    SigmobLog.i(String.format("Attempting to create output directory %s.", file3.getAbsolutePath()));
                    if (!file3.mkdirs()) {
                        throw new IllegalStateException(String.format("Couldn't create directory %s.", file3.getAbsolutePath()));
                    }
                }
            } else {
                SigmobLog.i(String.format("Creating output file %s.", file3.getAbsolutePath()));
                if (!file3.getParentFile().exists()) {
                    file3.getParentFile().mkdirs();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                com.sigmob.sdk.archives.utils.c.a(bVar, fileOutputStream);
                fileOutputStream.close();
            }
            linkedList.add(file3);
        }
    }

    public static void a(File file, File file2, InterfaceC0037b interfaceC0037b) {
        new a(file, file2, interfaceC0037b);
        SigmobLog.d("uncompressTarGzipAsync()  inputFile = [" + file + "], outputDir = [" + file2 + "], unCompressAsyncTaskListener = [" + interfaceC0037b + "]");
    }

    public static byte[] a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return a(str.getBytes("utf-8"));
    }

    private static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static String b(String str) {
        return (str == null || str.length() == 0) ? str : new String(b(str.getBytes("utf-8")));
    }

    private static byte[] b(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[256];
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read < 0) {
                gZIPInputStream.close();
                byteArrayInputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr2, 0, read);
        }
    }
}
