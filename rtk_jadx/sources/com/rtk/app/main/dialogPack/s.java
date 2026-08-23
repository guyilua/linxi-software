package com.rtk.app.main.dialogPack;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.adapter.y2;
import com.rtk.app.bean.HomeCommunityBean;
import com.rtk.app.custom.RichEditText.PostModificationBean;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DialogForPublishPostModuleList.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class s extends o implements h.j {
    private ListView k;
    private ProgressBar l;
    private Context m;
    private List<HomeCommunityBean.DataBean> n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DialogForPublishPostModuleList.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.N0((Activity) s.this.m, new PostModificationBean(((HomeCommunityBean.DataBean) s.this.n.get(i)).getTags(), ((HomeCommunityBean.DataBean) s.this.n.get(i)).getId()));
            s.this.dismiss();
        }
    }

    public s(Context context) {
        super(context);
        this.m = context;
        i(R.layout.dialog_for_publish_post_module_list_layout, 17);
        this.k = (ListView) getWindow().getDecorView().findViewById(R.id.dialog_for_publish_post_module_list_listView);
        ProgressBar progressBar = (ProgressBar) getWindow().getDecorView().findViewById(R.id.dialog_for_publish_post_module_list_progressBar);
        this.l = progressBar;
        this.k.setEmptyView(progressBar);
        r();
        s();
    }

    private void r() {
        com.rtk.app.tool.o.h.l(this.m, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a("members/modulesListForHome" + com.rtk.app.tool.y.u(this.m) + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.m, new String[0])))));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        HomeCommunityBean homeCommunityBean = (HomeCommunityBean) create.fromJson(str, HomeCommunityBean.class);
        ArrayList arrayList = new ArrayList();
        this.n = arrayList;
        arrayList.addAll(homeCommunityBean.getData());
        this.k.setAdapter((ListAdapter) new y2(this.m, this.n));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.m, "", f.a.f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void s() {
        this.k.setOnItemClickListener(new a());
    }
}
