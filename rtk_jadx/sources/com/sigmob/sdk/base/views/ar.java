package com.sigmob.sdk.base.views;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import com.czhj.sdk.logger.SigmobLog;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ar {

    /* renamed from: c, reason: collision with root package name */
    private static ar f458c;
    private static final AtomicReference<ar> d = new AtomicReference<>();
    private static int e = 0;
    private Queue<g> a;
    private Object b = new Object();

    private ar() {
        if (e > 0) {
            this.a = new LinkedBlockingQueue(e);
        }
    }

    public static ar a() {
        AtomicReference<ar> atomicReference;
        do {
            ar arVar = f458c;
            if (arVar != null) {
                return arVar;
            }
            atomicReference = d;
        } while (!atomicReference.compareAndSet(null, new ar()));
        ar arVar2 = atomicReference.get();
        f458c = arVar2;
        return arVar2;
    }

    private g b(Context context) {
        g gVar;
        Queue<g> queue = this.a;
        g poll = queue != null ? queue.poll() : null;
        SigmobLog.i("acquireWebViewInternal  webview:" + poll);
        if (poll != null) {
            ((MutableContextWrapper) poll.getContext()).setBaseContext(context);
            return poll;
        }
        synchronized (this.b) {
            gVar = new g(new MutableContextWrapper(context));
        }
        return gVar;
    }

    private void b(g gVar) {
        try {
            if (gVar.getContext() instanceof MutableContextWrapper) {
                MutableContextWrapper mutableContextWrapper = (MutableContextWrapper) gVar.getContext();
                mutableContextWrapper.setBaseContext(mutableContextWrapper.getApplicationContext());
                SigmobLog.i("enqueue  webview:" + gVar);
                if (e <= 0 || this.a == null) {
                    gVar.destroy();
                } else {
                    gVar.b();
                    this.a.offer(gVar);
                }
            }
            if (gVar.getContext() instanceof Activity) {
                SigmobLog.i("Abandon this webview  ， It will cause leak if enqueue !");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public g a(Context context) {
        return b(context);
    }

    public void a(g gVar) {
        b(gVar);
    }
}
