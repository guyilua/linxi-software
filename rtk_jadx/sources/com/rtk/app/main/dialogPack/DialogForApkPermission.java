package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.adapter.ApkPermissionAdapter;
import com.rtk.app.bean.DialogForApkPermissionBean;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForApkPermission extends o implements h.j {

    @BindView
    ImageView dialogForApkPermissionClose;

    @BindView
    ListView dialogForApkPermissionListView;
    private Context k;
    private int l;
    private int m;

    public DialogForApkPermission(Context context, int i, int i2) {
        super(context);
        this.k = context;
        this.l = i2;
        this.m = i;
        i(R.layout.dialog_for_apk_permission_layout, 80);
        ButterKnife.b(this, getWindow().getDecorView());
        p();
        q();
    }

    private void p() {
        StringBuilder sb = new StringBuilder();
        sb.append("members/sourcePermision");
        sb.append(com.rtk.app.tool.y.u(this.k));
        sb.append("&sid=");
        sb.append(this.m);
        sb.append("&isup=");
        sb.append(this.l);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.k, "sid=" + this.m))));
        com.rtk.app.tool.o.h.l(this.k, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a(sb.toString()));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i != 1) {
            return;
        }
        com.rtk.app.tool.c0.u("DialogForApkPermission", "权限信息" + str);
        DialogForApkPermissionBean dialogForApkPermissionBean = (DialogForApkPermissionBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, DialogForApkPermissionBean.class);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(dialogForApkPermissionBean.getData());
        this.dialogForApkPermissionListView.setAdapter((ListAdapter) new ApkPermissionAdapter(this.k, arrayList));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (i2 != 1) {
            return;
        }
        com.rtk.app.tool.c0.u("DialogForApkPermission", "权限信息" + str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131297149) {
            return;
        }
        dismiss();
    }

    public void q() {
        this.dialogForApkPermissionClose.setOnClickListener(this);
    }
}
