package com.rtk.app.main.Home5Activity.ClickHistory;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.adapter.HistoryGameAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.ListHisGameBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.c0;
import com.tencent.smtt.sdk.TbsListener;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ClickHistoryGameFragment extends BaseFragment {
    public static ListHisGameBean r = new ListHisGameBean();

    @BindView
    AutoListView clickListview;
    View o;
    Unbinder p;
    private HistoryGameAdapter q;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v() {
        this.clickListview.k();
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void w() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.clickListview.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.Home5Activity.ClickHistory.b
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                ClickHistoryGameFragment.this.v();
            }
        });
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        HistoryGameAdapter historyGameAdapter = new HistoryGameAdapter(this.e, r);
        this.q = historyGameAdapter;
        this.clickListview.setAdapter((ListAdapter) historyGameAdapter);
        this.clickListview.setPageSize(TbsListener.ErrorCode.ERROR_CODE_LOAD_BASE);
        this.clickListview.setResultSize(r.getListBean().size());
        q();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.o;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.fragement_for_click_hislayout, viewGroup, false);
            this.o = inflate;
            this.p = ButterKnife.b(this, inflate);
            b();
        } else {
            this.p = ButterKnife.b(this, view);
        }
        return this.o;
    }

    @Override // com.rtk.app.base.BaseFragment
    public void onResume() {
        super.onResume();
        if (this.e == null) {
            c0.t("ClickHistoryGameFragment", "context is null.");
            return;
        }
        r.getListBean().clear();
        ListHisGameBean m = f.m(this.e);
        if (m == null || m.getListBean() == null || m.getListBean().size() <= 0) {
            return;
        }
        for (ListHisGameBean.HisGameBean hisGameBean : m.getListBean()) {
            if (!TextUtils.isEmpty(hisGameBean.getApkInfo().getAppName())) {
                r.getListBean().add(hisGameBean);
            }
        }
        c0.u("ClickHistoryGameFragment", "game click size:" + r.getListBean().size());
        this.clickListview.setResultSize(m.getListBean().size());
        this.q.notifyDataSetChanged();
    }
}
