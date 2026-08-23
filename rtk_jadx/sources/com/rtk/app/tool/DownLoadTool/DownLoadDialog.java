package com.rtk.app.tool.DownLoadTool;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.adapter.DownLoadDialogListAdapter;
import com.rtk.app.bean.DownLoadBean;
import com.rtk.app.custom.CustomListView;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DownLoadDialog extends Dialog implements h.j {
    private final ViewHolder a;
    private Window b;

    /* renamed from: c, reason: collision with root package name */
    private ApkInfo f282c;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        ImageView downloadDialogClose;

        @BindView
        CustomListView downloadDialogListview;

        @BindView
        RelativeLayout downloadDialogLv;

        ViewHolder(DownLoadDialog downLoadDialog, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.downloadDialogClose = (ImageView) butterknife.c.a.c(view, R.id.download_dialog_close, "field 'downloadDialogClose'", ImageView.class);
            viewHolder.downloadDialogLv = (RelativeLayout) butterknife.c.a.c(view, R.id.download_dialog_lv, "field 'downloadDialogLv'", RelativeLayout.class);
            viewHolder.downloadDialogListview = (CustomListView) butterknife.c.a.c(view, R.id.download_dialog_listview, "field 'downloadDialogListview'", CustomListView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.downloadDialogClose = null;
                viewHolder.downloadDialogLv = null;
                viewHolder.downloadDialogListview = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DownLoadDialog.this.dismiss();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements com.rtk.app.tool.s {
        b() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            String str = strArr[0];
            r.c(DownLoadDialog.this.getContext(), new p(DownLoadDialog.this.f282c, 0));
            DownLoadDialog.this.dismiss();
        }
    }

    public DownLoadDialog(Context context, ApkInfo apkInfo) {
        super(context);
        this.b = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.download_dialog_layout, (ViewGroup) null);
        setContentView(inflate);
        this.f282c = apkInfo;
        ViewHolder viewHolder = new ViewHolder(this, inflate);
        this.a = viewHolder;
        viewHolder.downloadDialogClose.setOnClickListener(new a());
        com.rtk.app.tool.t.J1(context, viewHolder.downloadDialogLv);
        setCanceledOnTouchOutside(true);
        c();
        b(context, apkInfo.getGameId());
    }

    private void b(Context context, int i) {
        com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(new String[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("game/downlist");
        sb.append(com.rtk.app.tool.y.u(context));
        sb.append("&game_id=");
        sb.append(i);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(c0.e(com.rtk.app.tool.y.v(context, "game_id=" + i))));
        com.rtk.app.tool.o.h.l(context, this, 1, h.a(sb.toString()));
    }

    public void c() {
        Window window = getWindow();
        this.b = window;
        window.setWindowAnimations(R.style.dialog_anim_style);
        show();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        c0.u("DownLoadDialog", "游戏下载列表" + str);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        this.a.downloadDialogListview.setAdapter((ListAdapter) new DownLoadDialogListAdapter(getContext(), ((DownLoadBean) create.fromJson(str, DownLoadBean.class)).getData(), new b()));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }
}
