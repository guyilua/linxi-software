package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.bean.ResponseDataBean;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpDeleteDialog extends o implements h.j {
    private ViewHolder k;
    private Context l;
    private String m;
    private com.rtk.app.tool.s n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ViewHolder {

        @BindView
        TextView upDeleteDialogEnsure;

        @BindView
        LinearLayout upDeleteDialogLv;

        @BindView
        TextView upDeleteDialogNo;

        @BindView
        LinearLayout upDeleteDialogProgress;

        ViewHolder(View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.upDeleteDialogNo = (TextView) butterknife.c.a.c(view, R.id.up_delete_dialog_no, "field 'upDeleteDialogNo'", TextView.class);
            viewHolder.upDeleteDialogEnsure = (TextView) butterknife.c.a.c(view, R.id.up_delete_dialog_ensure, "field 'upDeleteDialogEnsure'", TextView.class);
            viewHolder.upDeleteDialogLv = (LinearLayout) butterknife.c.a.c(view, R.id.up_delete_dialog_lv, "field 'upDeleteDialogLv'", LinearLayout.class);
            viewHolder.upDeleteDialogProgress = (LinearLayout) butterknife.c.a.c(view, R.id.up_delete_dialog_progress, "field 'upDeleteDialogProgress'", LinearLayout.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.upDeleteDialogNo = null;
                viewHolder.upDeleteDialogEnsure = null;
                viewHolder.upDeleteDialogLv = null;
                viewHolder.upDeleteDialogProgress = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public UpDeleteDialog(Context context, String str, String str2, com.rtk.app.tool.s sVar) {
        super(context);
        this.m = str;
        this.l = context;
        this.n = sVar;
        i(R.layout.up_delete_dialog_layout, 17);
        this.k = new ViewHolder(getWindow().getDecorView());
        q();
        r();
    }

    private void p() {
        HashMap hashMap = new HashMap();
        hashMap.put("file_name", this.m + ".apk");
        hashMap.put("file_upid", com.rtk.app.tool.y.I(this.l) + "");
        com.rtk.app.tool.c0.u("UpDeleteDialog", " 删除上传中的apk  apkName  " + this.m + "   Uid   " + com.rtk.app.tool.y.I(this.l) + "");
    }

    private void r() {
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("UpDeleteDialog", "删除apk" + str);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        if (((ResponseDataBean) create.fromJson(str, ResponseDataBean.class)).getCode() == 0) {
            com.rtk.app.tool.f.a(this.l, "删除成功", f.a.f);
            this.n.a(new String[0]);
            dismiss();
        } else {
            com.rtk.app.tool.f.a(this.l, "删除失败", f.a.f);
            dismiss();
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.l, "删除失败", f.a.f);
        com.rtk.app.tool.c0.u("UpDeleteDialog", " 删除失败  " + str);
        dismiss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != 2131300846) {
            if (id != 2131300848) {
                return;
            }
            dismiss();
        } else {
            p();
            this.k.upDeleteDialogLv.setVisibility(8);
            this.k.upDeleteDialogProgress.setVisibility(0);
            this.n.a(new String[0]);
            dismiss();
        }
    }

    public void q() {
        this.k.upDeleteDialogEnsure.setOnClickListener(this);
        this.k.upDeleteDialogNo.setOnClickListener(this);
    }
}
