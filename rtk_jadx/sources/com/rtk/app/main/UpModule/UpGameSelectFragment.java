package com.rtk.app.main.UpModule;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.adapter.UpGameApkListViewAdapter;
import com.rtk.app.adapter.UpGameApplicationViewListViewAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.ApkBean;
import com.rtk.app.main.dialogPack.DialogPermision;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpGameSelectFragment extends BaseFragment implements h.j {

    @BindView
    ListView fragmentUpGameSelectListView;

    @BindView
    EditText fragmentUpGameSelectSearch;

    @BindView
    TextView fragmentUpGameSelectSearchBtu;
    private View o;
    private Unbinder p;
    private List<ApkBean> q;
    private List<PackageInfo> r;
    private Handler s = new a();
    public com.rtk.app.tool.k t;
    private UpGameApkListViewAdapter u;
    private UpGameApplicationViewListViewAdapter v;
    private boolean w;
    private String x;
    private View y;
    private EmptyViewHolder z;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    protected static class EmptyViewHolder {

        @BindView
        TextView postDetailsRecyclerviewItemEmptyPathTv;

        @BindView
        ProgressBar postDetailsRecyclerviewItemEmptyViewProgressBar;

        @BindView
        TextView postDetailsRecyclerviewItemEmptyViewTV;

        EmptyViewHolder(View view, ListView listView) {
            ButterKnife.b(this, view);
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            view.setVisibility(8);
            ((ViewGroup) listView.getParent()).addView(view);
            listView.setEmptyView(view);
        }

        public void a(Boolean bool) {
            if (bool.booleanValue()) {
                this.postDetailsRecyclerviewItemEmptyViewTV.setVisibility(0);
                this.postDetailsRecyclerviewItemEmptyViewProgressBar.setVisibility(8);
            } else {
                this.postDetailsRecyclerviewItemEmptyViewTV.setVisibility(8);
                this.postDetailsRecyclerviewItemEmptyViewProgressBar.setVisibility(0);
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class EmptyViewHolder_ViewBinding implements Unbinder {
        private EmptyViewHolder b;

        @UiThread
        public EmptyViewHolder_ViewBinding(EmptyViewHolder emptyViewHolder, View view) {
            this.b = emptyViewHolder;
            emptyViewHolder.postDetailsRecyclerviewItemEmptyViewProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.post_details_recyclerview_item_empty_view_progressBar, "field 'postDetailsRecyclerviewItemEmptyViewProgressBar'", ProgressBar.class);
            emptyViewHolder.postDetailsRecyclerviewItemEmptyViewTV = (TextView) butterknife.c.a.c(view, R.id.post_details_recyclerview_item_empty_view_TV, "field 'postDetailsRecyclerviewItemEmptyViewTV'", TextView.class);
            emptyViewHolder.postDetailsRecyclerviewItemEmptyPathTv = (TextView) butterknife.c.a.c(view, R.id.post_details_recyclerview_item_empty_pathTv, "field 'postDetailsRecyclerviewItemEmptyPathTv'", TextView.class);
        }

        @CallSuper
        public void a() {
            EmptyViewHolder emptyViewHolder = this.b;
            if (emptyViewHolder != null) {
                this.b = null;
                emptyViewHolder.postDetailsRecyclerviewItemEmptyViewProgressBar = null;
                emptyViewHolder.postDetailsRecyclerviewItemEmptyViewTV = null;
                emptyViewHolder.postDetailsRecyclerviewItemEmptyPathTv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                com.rtk.app.tool.c0.u("UpGameSelectFragment", "安装包管理  handler 我被执行了" + UpGameSelectFragment.this.q.size());
                UpGameSelectFragment.this.q.addAll((Collection) message.obj);
                UpGameSelectFragment.this.z.postDetailsRecyclerviewItemEmptyPathTv.setVisibility(8);
                UpGameSelectFragment.this.u.notifyDataSetChanged();
                UpGameSelectFragment.this.z.a(Boolean.TRUE);
                return;
            }
            if (i != 2) {
                return;
            }
            UpGameSelectFragment.this.z.postDetailsRecyclerviewItemEmptyPathTv.setVisibility(0);
            String str = (String) message.obj;
            UpGameSelectFragment.this.z.postDetailsRecyclerviewItemEmptyPathTv.setText("正在扫描:" + str);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            UpGameSelectFragment.this.y();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        String trim = this.fragmentUpGameSelectSearch.getText().toString().trim();
        this.x = trim;
        if (com.rtk.app.tool.c0.q(trim)) {
            this.x = "";
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (this.w) {
            for (ApkBean apkBean : this.q) {
                if (apkBean.getName().contains(this.x)) {
                    arrayList2.add(apkBean);
                }
            }
            this.u.notifyDataSetChanged();
            UpGameApkListViewAdapter upGameApkListViewAdapter = new UpGameApkListViewAdapter(this.e, arrayList2);
            this.u = upGameApkListViewAdapter;
            this.fragmentUpGameSelectListView.setAdapter((ListAdapter) upGameApkListViewAdapter);
            return;
        }
        for (PackageInfo packageInfo : this.r) {
            if (packageInfo.applicationInfo.loadLabel(this.e.getPackageManager()).toString().contains(this.x)) {
                arrayList.add(packageInfo);
            }
        }
        UpGameApplicationViewListViewAdapter upGameApplicationViewListViewAdapter = new UpGameApplicationViewListViewAdapter(this.e, arrayList);
        this.v = upGameApplicationViewListViewAdapter;
        this.fragmentUpGameSelectListView.setAdapter((ListAdapter) upGameApplicationViewListViewAdapter);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    public void G() {
        if (this.w) {
            if (com.rtk.app.tool.r.e(this.e)) {
                com.rtk.app.tool.k kVar = new com.rtk.app.tool.k((Activity) this.e, this.s);
                this.t = kVar;
                kVar.execute(new String[0]);
                return;
            }
            return;
        }
        this.r.addAll(com.rtk.app.tool.t.z(this.e));
        if (this.r.size() <= 3) {
            new DialogPermision(this.e, getResources().getString(R.string.single_permission_tips)).show();
        }
        this.v.notifyDataSetChanged();
        this.z.a(Boolean.TRUE);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.fragmentUpGameSelectSearch.addTextChangedListener(new b());
        this.fragmentUpGameSelectSearchBtu.setOnClickListener(this);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.w = getArguments().getBoolean("isLocalApk");
        View inflate = LayoutInflater.from(this.e).inflate(R.layout.post_details_recyclerview_item_empty_view_layout, (ViewGroup) null);
        this.y = inflate;
        EmptyViewHolder emptyViewHolder = new EmptyViewHolder(inflate, this.fragmentUpGameSelectListView);
        this.z = emptyViewHolder;
        emptyViewHolder.a(Boolean.FALSE);
        if (this.w) {
            UpGameApkListViewAdapter upGameApkListViewAdapter = new UpGameApkListViewAdapter(this.e, this.q);
            this.u = upGameApkListViewAdapter;
            this.fragmentUpGameSelectListView.setAdapter((ListAdapter) upGameApkListViewAdapter);
        } else {
            UpGameApplicationViewListViewAdapter upGameApplicationViewListViewAdapter = new UpGameApplicationViewListViewAdapter(this.e, this.r);
            this.v = upGameApplicationViewListViewAdapter;
            this.fragmentUpGameSelectListView.setAdapter((ListAdapter) upGameApplicationViewListViewAdapter);
        }
    }

    @Override // com.rtk.app.base.BaseFragment
    public void n() {
        super.n();
        this.t.cancel(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131297626) {
            return;
        }
        y();
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.o;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.fragment_up_game_select_layout, viewGroup, false);
            this.o = inflate;
            this.p = ButterKnife.b(this, inflate);
            b();
        } else {
            this.p = ButterKnife.b(this, view);
        }
        return this.o;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.p.a();
    }
}
