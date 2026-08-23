package com.rtk.app.tool;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.rtk.app.R;

/* compiled from: ApkIconAsyncTast.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e extends AsyncTask<PackageInfo, Void, Drawable> {
    private ImageView a;
    private Context b;

    public e(Context context, ImageView imageView) {
        this.a = imageView;
        this.b = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Drawable doInBackground(PackageInfo... packageInfoArr) {
        return packageInfoArr[0].applicationInfo.loadIcon(this.b.getPackageManager());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Drawable drawable) {
        super.onPostExecute(drawable);
        ImageView imageView = this.a;
        if (drawable == null) {
            drawable = this.b.getResources().getDrawable(R.mipmap.icon_load_logo);
        }
        imageView.setImageDrawable(drawable);
    }
}
