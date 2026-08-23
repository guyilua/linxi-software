package com.rtk.app.main.UpModule.UpHolderTool;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.rtk.app.main.MyApplication;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.t;
import com.rtk.app.tool.v;

/* compiled from: UpAsyncTask.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c extends AsyncTask<String, Void, Boolean> {
    private String a;
    private String b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f221c;

    public c(String str, Handler handler) {
        this.a = str;
        this.f221c = handler;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(String... strArr) {
        this.b = t.I(this.a);
        v.h(MyApplication.b(), this.a + "MD5", this.b);
        c0.u("UpAsyncTask", "当前文件的md5   " + this.b);
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        if (bool.booleanValue()) {
            Message message = new Message();
            message.what = 2;
            message.obj = this.b;
            this.f221c.sendMessage(message);
        }
    }
}
