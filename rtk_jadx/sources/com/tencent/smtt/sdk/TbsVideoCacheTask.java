package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import com.tencent.smtt.export.external.DexLoader;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TbsVideoCacheTask {
    public static final String KEY_VIDEO_CACHE_PARAM_FILENAME = "filename";
    public static final String KEY_VIDEO_CACHE_PARAM_FOLDERPATH = "folderPath";
    public static final String KEY_VIDEO_CACHE_PARAM_HEADER = "header";
    public static final String KEY_VIDEO_CACHE_PARAM_URL = "url";
    Context a;
    TbsVideoCacheListener b;
    private String e;
    private String f;

    /* renamed from: c, reason: collision with root package name */
    private boolean f947c = false;
    private n d = null;
    private Object g = null;

    public TbsVideoCacheTask(Context context, Bundle bundle, TbsVideoCacheListener tbsVideoCacheListener) {
        this.a = null;
        this.b = null;
        this.a = context;
        this.b = tbsVideoCacheListener;
        if (bundle != null) {
            this.e = bundle.getString("taskId");
            this.f = bundle.getString("url");
        }
        a(bundle);
    }

    private void a(Bundle bundle) {
        DexLoader dexLoader;
        if (this.d == null) {
            d.a(true).a(this.a, false, false);
            r a = d.a(true).a();
            if (a != null) {
                dexLoader = a.b();
            } else {
                this.b.onVideoDownloadError(this, -1, "init engine error!", null);
                dexLoader = null;
            }
            if (dexLoader != null) {
                this.d = new n(dexLoader);
            } else {
                this.b.onVideoDownloadError(this, -1, "Java dexloader invalid!", null);
            }
        }
        n nVar = this.d;
        if (nVar != null) {
            Object a2 = nVar.a(this.a, this, bundle);
            this.g = a2;
            if (a2 == null) {
                this.b.onVideoDownloadError(this, -1, "init task error!", null);
                return;
            }
            return;
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener != null) {
            tbsVideoCacheListener.onVideoDownloadError(this, -1, "init error!", null);
        }
    }

    public long getContentLength() {
        n nVar = this.d;
        if (nVar != null && this.g != null) {
            return nVar.d();
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener == null) {
            return 0L;
        }
        tbsVideoCacheListener.onVideoDownloadError(this, -1, "getContentLength failed, init uncompleted!", null);
        return 0L;
    }

    public int getDownloadedSize() {
        n nVar = this.d;
        if (nVar != null && this.g != null) {
            return nVar.e();
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener == null) {
            return 0;
        }
        tbsVideoCacheListener.onVideoDownloadError(this, -1, "getDownloadedSize failed, init uncompleted!", null);
        return 0;
    }

    public int getProgress() {
        n nVar = this.d;
        if (nVar != null && this.g != null) {
            return nVar.f();
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener == null) {
            return 0;
        }
        tbsVideoCacheListener.onVideoDownloadError(this, -1, "getProgress failed, init uncompleted!", null);
        return 0;
    }

    public String getTaskID() {
        return this.e;
    }

    public String getTaskUrl() {
        return this.f;
    }

    public void pauseTask() {
        n nVar = this.d;
        if (nVar != null && this.g != null) {
            nVar.a();
            return;
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener != null) {
            tbsVideoCacheListener.onVideoDownloadError(this, -1, "pauseTask failed, init uncompleted!", null);
        }
    }

    public void removeTask(boolean z) {
        n nVar = this.d;
        if (nVar != null && this.g != null) {
            nVar.a(z);
            return;
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener != null) {
            tbsVideoCacheListener.onVideoDownloadError(this, -1, "removeTask failed, init uncompleted!", null);
        }
    }

    public void resumeTask() {
        n nVar = this.d;
        if (nVar != null && this.g != null) {
            nVar.b();
            return;
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener != null) {
            tbsVideoCacheListener.onVideoDownloadError(this, -1, "resumeTask failed, init uncompleted!", null);
        }
    }

    public void stopTask() {
        n nVar = this.d;
        if (nVar != null && this.g != null) {
            nVar.c();
            return;
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener != null) {
            tbsVideoCacheListener.onVideoDownloadError(this, -1, "stopTask failed, init uncompleted!", null);
        }
    }
}
