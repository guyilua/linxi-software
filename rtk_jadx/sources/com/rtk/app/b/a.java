package com.rtk.app.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import com.sigmob.sdk.downloader.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* compiled from: FileUtil.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    private static boolean a(String str, String str2, ZipOutputStream zipOutputStream) {
        if (zipOutputStream == null) {
            return false;
        }
        try {
            File file = new File(str + str2);
            if (file.isFile()) {
                ZipEntry zipEntry = new ZipEntry(str2);
                FileInputStream fileInputStream = new FileInputStream(file);
                zipOutputStream.putNextEntry(zipEntry);
                byte[] bArr = new byte[f.a.f548c];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        zipOutputStream.write(bArr, 0, read);
                    } else {
                        zipOutputStream.closeEntry();
                        return true;
                    }
                }
            } else {
                String[] list = file.list();
                if (list.length <= 0) {
                    zipOutputStream.putNextEntry(new ZipEntry(str2 + File.separator));
                    zipOutputStream.closeEntry();
                }
                for (String str3 : list) {
                    a(str + str2 + "/", str3, zipOutputStream);
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean b(String str, String str2) {
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
            File file = new File(str);
            boolean a = a(file.getParent() + File.separator, file.getName(), zipOutputStream);
            zipOutputStream.finish();
            zipOutputStream.close();
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean c(File file, String str, String str2) {
        if (file != null && str != null) {
            File file2 = new File(str);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(str + str2);
            if (file3.exists()) {
                file3.delete();
            }
            try {
                file3.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                FileChannel channel = new FileInputStream(file).getChannel();
                FileChannel channel2 = new FileOutputStream(file3).getChannel();
                channel.transferTo(0L, channel.size(), channel2);
                try {
                    channel.close();
                    channel2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return true;
            } catch (FileNotFoundException e3) {
                e3.printStackTrace();
            } catch (IOException e4) {
                e4.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static boolean d(String str) {
        String str2 = File.separator;
        if (!str.endsWith(str2)) {
            str = str + str2;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        boolean z = true;
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isFile()) {
                z = e(listFiles[i].getAbsolutePath());
                if (!z) {
                    break;
                }
            } else {
                z = d(listFiles[i].getAbsolutePath());
                if (!z) {
                    break;
                }
            }
        }
        if (z) {
            return file.delete();
        }
        return false;
    }

    public static boolean e(String str) {
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static boolean f(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return e(str);
        }
        return d(str);
    }

    public static boolean g(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public static String h(Context context, String str, String str2) {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/download/apks");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str2);
        if (file2.exists()) {
            if (file2.length() == new File(str).length()) {
                return file2.getAbsolutePath();
            }
            file2.delete();
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                            intent.setData(Uri.fromFile(file2));
                            context.sendBroadcast(intent);
                            fileOutputStream.close();
                            fileInputStream.close();
                            return file2.getAbsolutePath();
                        }
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
