package com.rtk.app.main.Home5Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.OtherRuleCuntributeBean;
import com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsHolderClass.WebViewHolder;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home5MyContributeRuleFragment extends BaseFragment implements h.j {
    View o;
    Unbinder p;

    @BindView
    WebView swipeAndWebViewWebView;

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("Home5MyContributeRuleFragment", "   我的贡献值   " + str);
        if (i != 1) {
            return;
        }
        WebViewHolder.b(this.swipeAndWebViewWebView, ((OtherRuleCuntributeBean) this.f.fromJson(str, OtherRuleCuntributeBean.class)).getData().getMsg(), this.e, null);
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void C() {
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a("members/coinRules" + com.rtk.app.tool.y.u(this.e) + "&rid=2&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.e, "rid=2")))));
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.e, str, f.a.f);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.o;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.swipe_and_web_view_layout, viewGroup, false);
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
