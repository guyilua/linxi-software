package com.rtk.app.main.dialogPack;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.rtk.app.R;
import com.rtk.app.adapter.z2;
import com.rtk.app.bean.TagsBean;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.List;

/* compiled from: DialogForRemovePostModuleTagList.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class u extends o implements h.j {
    private Context k;
    private List<TagsBean> l;
    private ListView m;
    private String n;
    private String o;
    private String p;
    private String q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DialogForRemovePostModuleTagList.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            u.this.q = ((TagsBean) u.this.l.get(i)).getId() + "";
            u.this.s();
            u.this.dismiss();
        }
    }

    public u(Context context, List<TagsBean> list, String str, String str2, String str3) {
        super(context);
        this.k = context;
        this.o = str2;
        this.n = str3;
        this.p = str;
        this.l = list;
        i(R.layout.dialog_for_remove_post_module_tag_list_layout, 17);
        this.m = (ListView) getWindow().getDecorView().findViewById(R.id.dialog_for_remove_post_module_tag_listView);
        this.m.setAdapter((ListAdapter) new z2(context, list));
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        StringBuilder sb = new StringBuilder();
        sb.append("members/changeModles");
        sb.append(com.rtk.app.tool.y.u(this.k));
        sb.append("&uid=");
        sb.append(com.rtk.app.tool.y.K());
        sb.append("&token=");
        sb.append(com.rtk.app.tool.y.H());
        sb.append("&mid=");
        sb.append(this.n);
        sb.append("&pid=");
        sb.append(this.p);
        sb.append("&tags=");
        sb.append(this.q);
        sb.append("&opmid=");
        sb.append(this.o);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.k, "pid=" + this.p, "mid=" + this.n, "tags=" + this.q, "opmid=" + this.o, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
        String sb2 = sb.toString();
        if (com.rtk.app.tool.c0.q(sb2)) {
            return;
        }
        com.rtk.app.tool.o.h.l(this.k, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a(sb2));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i != 1) {
            return;
        }
        com.rtk.app.tool.f.a(this.k, "移动成功", f.a.f);
        ((Activity) this.k).finish();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.k, str, f.a.f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void t() {
        this.m.setOnItemClickListener(new a());
    }
}
