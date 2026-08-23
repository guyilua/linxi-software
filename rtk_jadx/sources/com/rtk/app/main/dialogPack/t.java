package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.adapter.y2;
import com.rtk.app.bean.HomeCommunityBean;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DialogForRemovePostModuleList.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class t extends o implements h.j {
    private ListView k;
    private Context l;
    private List<HomeCommunityBean.DataBean> m;
    private String n;
    private String o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DialogForRemovePostModuleList.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            new u(t.this.l, ((HomeCommunityBean.DataBean) t.this.m.get(i)).getTags(), t.this.o, t.this.n, ((HomeCommunityBean.DataBean) t.this.m.get(i)).getId()).show();
            t.this.dismiss();
        }
    }

    public t(Context context, String str, String str2) {
        super(context);
        this.l = context;
        this.n = str;
        this.o = str2;
        i(R.layout.dialog_for_remove_post_module_list_layout, 17);
        this.k = (ListView) getWindow().getDecorView().findViewById(R.id.dialog_for_remove_post_module_list_listView);
        t();
        u();
    }

    private void t() {
        com.rtk.app.tool.o.h.l(this.l, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a("members/modulesListForHome" + com.rtk.app.tool.y.u(this.l) + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.l, new String[0])))));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        HomeCommunityBean homeCommunityBean = (HomeCommunityBean) create.fromJson(str, HomeCommunityBean.class);
        ArrayList arrayList = new ArrayList();
        this.m = arrayList;
        arrayList.addAll(homeCommunityBean.getData());
        this.k.setAdapter((ListAdapter) new y2(this.l, this.m));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.l, "", f.a.f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void u() {
        this.k.setOnItemClickListener(new a());
    }
}
