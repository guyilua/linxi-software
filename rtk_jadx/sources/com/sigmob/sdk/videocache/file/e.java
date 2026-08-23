package com.sigmob.sdk.videocache.file;

import com.czhj.sdk.logger.SigmobLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class e implements com.sigmob.sdk.videocache.file.a {
    private final ExecutorService a = Executors.newSingleThreadExecutor();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private class a implements Callable<Void> {
        private final File b;

        public a(File file) {
            this.b = file;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            e.this.b(this.b);
            return null;
        }
    }

    private void a(List<File> list) {
        long b = b(list);
        int size = list.size();
        for (File file : list) {
            if (!a(file, b, size)) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    b -= length;
                    SigmobLog.i("Cache file " + file + " is deleted because it exceeds cache limit");
                } else {
                    SigmobLog.e("Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    private long b(List<File> list) {
        Iterator<File> it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += it.next().length();
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(File file) {
        d.c(file);
        a(d.b(file.getParentFile()));
    }

    @Override // com.sigmob.sdk.videocache.file.a
    public void a(File file) {
        this.a.submit(new a(file));
    }

    protected abstract boolean a(File file, long j, int i);
}
