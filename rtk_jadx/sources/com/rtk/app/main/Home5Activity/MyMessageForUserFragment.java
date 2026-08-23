package com.rtk.app.main.Home5Activity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.adapter.MyMessageForUserAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.MyMessageForUserBean;
import com.rtk.app.bean.MyUpApkCommentBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.main.family.FamilyApplyJoinListActivity;
import com.rtk.app.main.family.FamilyInfoActivity;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyMessageForUserFragment extends BaseFragment implements h.j, com.rtk.app.tool.s {

    @BindView
    AutoListView myMessageForUserFragmentListView;
    Unbinder o;
    private MyMessageForUserAdapter s;
    public String t;
    public int u;
    private MyMessageListActivity w;
    private int p = 1;
    private String q = "1";
    private List<MyMessageForUserBean.DataBean> r = new ArrayList();
    private boolean v = false;
    private String x = null;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            try {
                int i2 = i - 1;
                MyMessageForUserBean.DataBean dataBean = (MyMessageForUserBean.DataBean) MyMessageForUserFragment.this.r.get(i2);
                MyMessageForUserFragment.this.t = dataBean.getId();
                MyMessageForUserFragment myMessageForUserFragment = MyMessageForUserFragment.this;
                myMessageForUserFragment.u = i2;
                myMessageForUserFragment.D(2);
                String type = dataBean.getType();
                char c2 = 65535;
                switch (type.hashCode()) {
                    case -1978695444:
                        if (type.equals("familyJoinExit")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case -1843148884:
                        if (type.equals("familyJoinDisagree")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -1214208866:
                        if (type.equals("familyJoinAgree")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -1213942432:
                        if (type.equals("familyJoinApply")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -471744086:
                        if (type.equals("postsReplyFmCheck")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -310238303:
                        if (type.equals("familyUserPmsCancel")) {
                            c2 = '\b';
                            break;
                        }
                        break;
                    case 704369519:
                        if (type.equals("familyTransfer")) {
                            c2 = '\t';
                            break;
                        }
                        break;
                    case 1065827016:
                        if (type.equals("familyJoinCancel")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 1170301914:
                        if (type.equals("familyUserDelete")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 1521413338:
                        if (type.equals("familyUserPmsAdd")) {
                            c2 = 7;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        return;
                    case 1:
                        String sid = dataBean.getSid();
                        com.rtk.app.tool.c0.r("MyMessageForUserFragment", "familyId=" + sid);
                        Bundle bundle = new Bundle();
                        bundle.putString("family_id", sid);
                        com.rtk.app.tool.c.b(MyMessageForUserFragment.this.getActivity(), FamilyApplyJoinListActivity.class, bundle);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case '\b':
                    case '\t':
                        String sid2 = dataBean.getSid();
                        com.rtk.app.tool.c0.r("MyMessageForUserFragment", "familyId=" + sid2);
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("family_id", sid2);
                        com.rtk.app.tool.c.b(MyMessageForUserFragment.this.getActivity(), FamilyInfoActivity.class, bundle2);
                        return;
                    default:
                        String lowerCase = type.toLowerCase();
                        if (lowerCase.contains("postsreplytoreply")) {
                            String str = dataBean.getExtra().get("pid");
                            String str2 = dataBean.getExtra().get("mid");
                            if (com.rtk.app.tool.c0.q(str, str2)) {
                                return;
                            }
                            com.rtk.app.tool.t.G0(((BaseFragment) MyMessageForUserFragment.this).e, str, dataBean.getSid(), str2);
                            return;
                        }
                        if (lowerCase.contains("postsreply")) {
                            com.rtk.app.tool.t.J0(((BaseFragment) MyMessageForUserFragment.this).e, dataBean.getSid());
                            return;
                        }
                        if (lowerCase.contains("post")) {
                            com.rtk.app.tool.t.J0(((BaseFragment) MyMessageForUserFragment.this).e, ((MyMessageForUserBean.DataBean) MyMessageForUserFragment.this.r.get(i2)).getSid());
                            return;
                        }
                        if (lowerCase.contains("system")) {
                            return;
                        }
                        if (lowerCase.contains("sourcereplytoreply")) {
                            int parseInt = Integer.parseInt(dataBean.getExtra().get("sid"));
                            String str3 = dataBean.getExtra().get("packageName");
                            if (com.rtk.app.tool.c0.q(str3)) {
                                return;
                            }
                            com.rtk.app.tool.t.W0(((BaseFragment) MyMessageForUserFragment.this).e, parseInt, Integer.parseInt(dataBean.getSid()), str3);
                            return;
                        }
                        if (lowerCase.contains("sourcereply")) {
                            MyUpApkCommentBean.DataBean dataBean2 = new MyUpApkCommentBean.DataBean();
                            dataBean2.setUsid(Integer.parseInt(dataBean.getSid()));
                            String str4 = dataBean.getExtra().get("packageName");
                            String str5 = dataBean.getExtra().get("varName");
                            String str6 = dataBean.getExtra().get("sourceLogo");
                            String str7 = dataBean.getExtra().get("sourcePath");
                            dataBean2.setPackageName(str4);
                            dataBean2.setVarName(str5);
                            dataBean2.setSourceLogo(str6);
                            dataBean2.setSourcePath(str7);
                            ApkInfo apkInfo = new ApkInfo(dataBean2);
                            if (com.rtk.app.tool.c0.q(str6, str7)) {
                                return;
                            }
                            com.rtk.app.tool.t.X0(((BaseFragment) MyMessageForUserFragment.this).e, apkInfo);
                            return;
                        }
                        if (!lowerCase.contains(com.sigmob.sdk.base.k.l) && !lowerCase.contains("upbuy")) {
                            if (lowerCase.contains("gamereplytoreply")) {
                                String str8 = dataBean.getExtra().get("package_name");
                                String str9 = dataBean.getExtra().get("install_comment");
                                int parseInt2 = Integer.parseInt(dataBean.getSid());
                                int parseInt3 = Integer.parseInt(dataBean.getExtra().get("game_id"));
                                if (com.rtk.app.tool.c0.q(str8, parseInt3 + "")) {
                                    return;
                                }
                                com.rtk.app.tool.t.d0(((BaseFragment) MyMessageForUserFragment.this).e, parseInt3, parseInt2, str9, str8);
                                return;
                            }
                            return;
                        }
                        MyUpApkCommentBean.DataBean dataBean3 = new MyUpApkCommentBean.DataBean();
                        dataBean3.setUsid(Integer.parseInt(dataBean.getSid()));
                        String str10 = dataBean.getExtra().get("packageName");
                        String str11 = dataBean.getExtra().get("varName");
                        String str12 = dataBean.getExtra().get("sourceLogo");
                        String str13 = dataBean.getExtra().get("sourcePath");
                        dataBean3.setPackageName(str10);
                        dataBean3.setVarName(str11);
                        dataBean3.setSourceLogo(str12);
                        dataBean3.setSourcePath(str13);
                        ApkInfo apkInfo2 = new ApkInfo(dataBean3);
                        if (com.rtk.app.tool.c0.q(str12)) {
                            return;
                        }
                        com.rtk.app.tool.t.X0(((BaseFragment) MyMessageForUserFragment.this).e, apkInfo2);
                        return;
                }
            } catch (NullPointerException unused) {
                com.rtk.app.tool.f.a(((BaseFragment) MyMessageForUserFragment.this).e, "消息列表详细信息为空", f.a.f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F(String[] strArr) {
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J() {
        this.p = 1;
        B();
    }

    public void D(int i) {
        String str;
        String w;
        if (i != 2) {
            w = "";
        } else {
            HashMap<String, String> l = com.rtk.app.tool.y.l();
            if (this.v) {
                if (!TextUtils.isEmpty(this.x)) {
                    l.put(com.rtk.app.tool.y.z("source_id"), this.x);
                    l.put(com.rtk.app.tool.y.z("data_source"), "9");
                }
                str = "user/message/read-all";
            } else {
                l.put("id", this.t);
                str = "user/message/read";
            }
            l.put("key", com.rtk.app.tool.t.L(l));
            w = com.rtk.app.tool.y.w(str, l);
        }
        com.rtk.app.tool.c0.u("MyMessageForUserFragment", "阅读消息  " + com.rtk.app.tool.y.d + w);
        com.rtk.app.tool.o.h.l(this.e, this, i, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(w));
    }

    public void K() {
        this.t = "";
        this.v = true;
        D(2);
    }

    @Override // com.rtk.app.tool.s
    public void a(String... strArr) {
        int parseInt = Integer.parseInt(strArr[0]);
        this.t = this.r.get(parseInt).getId();
        this.u = parseInt;
        D(2);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        int i2;
        int i3;
        q();
        this.myMessageForUserFragmentListView.k();
        if (i == 1) {
            com.rtk.app.tool.c0.u("MyMessageForUserFragment", "   " + this.q + "   消息列表" + str);
            MyMessageForUserBean myMessageForUserBean = (MyMessageForUserBean) this.f.fromJson(str, MyMessageForUserBean.class);
            if (this.p == 1) {
                this.r.clear();
            }
            this.p++;
            this.r.addAll(myMessageForUserBean.getData());
            this.s.notifyDataSetChanged();
            this.myMessageForUserFragmentListView.setResultSize(myMessageForUserBean.getData().size());
            return;
        }
        if (i != 2) {
            return;
        }
        com.rtk.app.tool.c0.u("MyMessageForUserFragment", "   " + this.q + "   阅读消息" + str);
        if (this.v) {
            for (int i4 = 0; i4 < this.r.size(); i4++) {
                this.r.get(i4).setOpened("1");
            }
            this.v = false;
            MyMessageListActivity myMessageListActivity = this.w;
            myMessageListActivity.r = 0;
            myMessageListActivity.q = 0;
            myMessageListActivity.O(0);
            MyMessageListActivity myMessageListActivity2 = this.w;
            myMessageListActivity2.N(myMessageListActivity2.q);
        } else {
            if (this.q.equals("1")) {
                MyMessageListActivity myMessageListActivity3 = this.w;
                if (!this.r.get(this.u).getOpened().endsWith("1") || (i3 = this.w.r) <= 0) {
                    i3 = this.w.r - 1;
                }
                myMessageListActivity3.r = i3;
                MyMessageListActivity myMessageListActivity4 = this.w;
                myMessageListActivity4.O(myMessageListActivity4.r);
            } else {
                MyMessageListActivity myMessageListActivity5 = this.w;
                if (!this.r.get(this.u).getOpened().endsWith("1") || (i2 = this.w.q) <= 0) {
                    i2 = this.w.q - 1;
                }
                myMessageListActivity5.q = i2;
                MyMessageListActivity myMessageListActivity6 = this.w;
                myMessageListActivity6.N(myMessageListActivity6.q);
            }
            this.r.get(this.u).setOpened("1");
        }
        this.s.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void H() {
        HashMap<String, String> l = com.rtk.app.tool.y.l();
        if (!TextUtils.isEmpty(this.x)) {
            l.put(com.rtk.app.tool.y.z("source_id"), this.x);
            l.put(com.rtk.app.tool.y.z("data_source"), "9");
        }
        l.put("msgType", this.q);
        l.put(com.rtk.app.tool.y.z("page"), this.p + "");
        l.put("key", com.rtk.app.tool.t.L(l));
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(com.rtk.app.tool.y.w("user/message/list", l)));
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.myMessageForUserFragmentListView.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.Home5Activity.s0
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                MyMessageForUserFragment.this.H();
            }
        });
        this.myMessageForUserFragmentListView.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.Home5Activity.u0
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                MyMessageForUserFragment.this.J();
            }
        });
        this.myMessageForUserFragmentListView.setOnItemClickListener(new a());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (this.p == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.Home5Activity.t0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    MyMessageForUserFragment.this.F(strArr);
                }
            });
        }
        this.myMessageForUserFragmentListView.f();
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.q = getArguments().getString("msgType");
        this.x = getArguments().getString("family_id");
        MyMessageForUserAdapter myMessageForUserAdapter = new MyMessageForUserAdapter(this.e, this.r, this);
        this.s = myMessageForUserAdapter;
        this.myMessageForUserFragmentListView.setAdapter((ListAdapter) myMessageForUserAdapter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttach(Context context) {
        super.onAttach(context);
        this.w = (MyMessageListActivity) context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.my_message_for_user_fragment_layout, viewGroup, false);
            this.a = inflate;
            this.o = ButterKnife.b(this, inflate);
            b();
            View view2 = this.a;
            r(view2, view2);
        } else {
            this.o = ButterKnife.b(this, view);
        }
        return this.a;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.o.a();
    }
}
