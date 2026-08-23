package com.sigmob.sdk.videocache.file;

import com.czhj.sdk.logger.SigmobLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class d {

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class a implements Comparator<File> {
        private a() {
        }

        private int a(long j, long j2) {
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return a(file.lastModified(), file2.lastModified());
        }
    }

    d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(File file) {
        if (!file.exists()) {
            if (!file.mkdirs()) {
                throw new IOException(String.format("Directory %s can't be created", file.getAbsolutePath()));
            }
        } else {
            if (file.isDirectory()) {
                return;
            }
            throw new IOException("File " + file + " is not directory!");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<File> b(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return linkedList;
        }
        List<File> asList = Arrays.asList(listFiles);
        Collections.sort(asList, new a());
        return asList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(File file) {
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(currentTimeMillis)) {
                return;
            }
            d(file);
            if (file.lastModified() < currentTimeMillis) {
                SigmobLog.e("Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
            }
        }
    }

    static void d(File file) {
        long length = file.length();
        if (length == 0) {
            e(file);
            return;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
        long j = length - 1;
        randomAccessFile.seek(j);
        byte readByte = randomAccessFile.readByte();
        randomAccessFile.seek(j);
        randomAccessFile.write(readByte);
        randomAccessFile.close();
    }

    private static void e(File file) {
        if (file.delete() && file.createNewFile()) {
            return;
        }
        throw new IOException("Error recreate zero-size file " + file);
    }
}
