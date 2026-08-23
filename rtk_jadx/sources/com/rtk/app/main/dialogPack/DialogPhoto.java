package com.rtk.app.main.dialogPack;

import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.base.BaseActivity;
import com.sigmob.sdk.downloader.f;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogPhoto extends Dialog implements View.OnClickListener {
    private Window a;
    private ViewHolder b;

    /* renamed from: c, reason: collision with root package name */
    private BaseActivity f244c;
    private boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder {

        @BindView
        TextView dialogIconCancel;

        @BindView
        TextView dialogIconPhotoAlbum;

        @BindView
        TextView dialogIconPhotoMore;

        @BindView
        TextView dialogIconPhotograph;

        ViewHolder(DialogPhoto dialogPhoto, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.dialogIconPhotograph = (TextView) butterknife.c.a.c(view, R.id.dialog_icon_photograph, "field 'dialogIconPhotograph'", TextView.class);
            viewHolder.dialogIconPhotoAlbum = (TextView) butterknife.c.a.c(view, R.id.dialog_icon_photo_album, "field 'dialogIconPhotoAlbum'", TextView.class);
            viewHolder.dialogIconPhotoMore = (TextView) butterknife.c.a.c(view, R.id.dialog_icon_photo_more, "field 'dialogIconPhotoMore'", TextView.class);
            viewHolder.dialogIconCancel = (TextView) butterknife.c.a.c(view, R.id.dialog_icon_cancel, "field 'dialogIconCancel'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.dialogIconPhotograph = null;
                viewHolder.dialogIconPhotoAlbum = null;
                viewHolder.dialogIconPhotoMore = null;
                viewHolder.dialogIconCancel = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DialogPhoto(BaseActivity baseActivity) {
        super(baseActivity);
        this.d = true;
        this.f244c = baseActivity;
        b();
        a();
    }

    private void a() {
        this.b.dialogIconCancel.setOnClickListener(this);
        this.b.dialogIconPhotoAlbum.setOnClickListener(this);
        this.b.dialogIconPhotograph.setOnClickListener(this);
        this.b.dialogIconPhotoMore.setOnClickListener(this);
    }

    private void b() {
        setContentView(R.layout.dialog_head_icon);
        e(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
        setCanceledOnTouchOutside(true);
        this.b = new ViewHolder(this, getWindow().getDecorView());
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }

    public void c(boolean z) {
        this.d = z;
    }

    public void d() {
        this.b.dialogIconPhotoMore.setVisibility(8);
    }

    public void e(float f, float f2) {
        Window window = getWindow();
        this.a = window;
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = (int) f;
        attributes.y = (int) f2;
        attributes.gravity = 80;
        attributes.width = -1;
        attributes.height = -2;
        this.a.setAttributes(attributes);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_icon_cancel /* 2131297286 */:
                com.rtk.app.tool.f.a(getContext(), "取消", f.a.f);
                dismiss();
                return;
            case R.id.dialog_icon_photo_album /* 2131297287 */:
                if (com.rtk.app.tool.r.b(this.f244c)) {
                    if (this.d) {
                        com.rtk.app.tool.t.E1(this.f244c, 1, false);
                    } else {
                        this.f244c.K();
                    }
                }
                dismiss();
                return;
            case R.id.dialog_icon_photo_more /* 2131297288 */:
                if (com.rtk.app.tool.r.b(this.f244c)) {
                    com.rtk.app.tool.t.E1(this.f244c, 9, false);
                }
                dismiss();
                return;
            case R.id.dialog_icon_photograph /* 2131297289 */:
                if (com.rtk.app.tool.r.a(this.f244c)) {
                    this.f244c.J();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
