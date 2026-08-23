package com.rtk.app.main.MainActivityPack.HomePageItem1Pack;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.bean.UserRankBean;
import com.rtk.app.main.MainActivityPack.UpChoicenessPack.HomeUpExampleListActivity;
import com.rtk.app.main.MyApplication;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.f;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpUserTypeHolder extends RecyclerView.ViewHolder implements h.j {
    View a;
    private UserRankBean b;

    /* renamed from: c, reason: collision with root package name */
    private Context f207c;
    private d d;

    @BindView
    public LinearLayout homePageItem1FragmentUserRankItemNextTitle;

    @BindView
    public LinearLayout homeUpUserTypeRecommend14Layout;

    @BindView
    public LinearLayout homeUpUserTypeRecommend58Layout;

    @BindView
    public TextView homeUpUserTypeRecommendGoToUp;

    @BindView
    public TextView homeUpUserTypeRecommendMore;

    @BindView
    public LinearLayout homeUpUserTypeRecommendNoBodyLv;

    @BindView
    public ImageView homeUpUserTypeRecommendNoOneImg;

    @BindView
    public TextView homeUpUserTypeRecommendUpSrcMore;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements s {
        a() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            if (c0.q(y.H())) {
                f.a(MyApplication.b(), "请先登录~", f.a.f);
                t.w0(MyApplication.b());
            }
            int parseInt = Integer.parseInt(strArr[0]);
            int parseInt2 = Integer.parseInt(strArr[1]);
            StringBuilder sb = new StringBuilder();
            sb.append("members/follows");
            sb.append(y.u(MyApplication.b()));
            sb.append("&uid=");
            sb.append(y.K());
            sb.append("&token=");
            sb.append(y.H());
            sb.append("&fans=");
            sb.append(UpUserTypeHolder.this.b.getData().get(parseInt2).getUid());
            sb.append("&key=");
            sb.append(t.c0(c0.e(y.v(MyApplication.b(), "fans=" + UpUserTypeHolder.this.b.getData().get(parseInt2).getUid(), "uid=" + y.K(), "token=" + y.H()))));
            String sb2 = sb.toString();
            UpUserTypeHolder.this.d.b();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("关注链接");
            sb3.append(y.d);
            sb3.append(sb2);
            c0.u("UpUserTypeHolder", sb3.toString());
            h.l(MyApplication.b(), UpUserTypeHolder.this, parseInt + (parseInt2 * 10), h.h(new String[0]).a(sb2));
        }
    }

    public UpUserTypeHolder(@NonNull View view) {
        super(view);
        ButterKnife.b(this, view);
        this.a = view;
    }

    private void h() {
        for (int i = 0; i < this.homeUpUserTypeRecommend14Layout.getChildCount(); i++) {
            ViewGroup viewGroup = (ViewGroup) this.homeUpUserTypeRecommend14Layout.getChildAt(i);
            if (i >= this.b.getData().size()) {
                this.homeUpUserTypeRecommend14Layout.removeView(viewGroup);
            } else {
                l(viewGroup, (ImageView) viewGroup.getChildAt(0), (TextView) viewGroup.getChildAt(1), (TextView) viewGroup.getChildAt(2), i);
            }
        }
        if (this.b.getData().size() <= 4) {
            this.homeUpUserTypeRecommend58Layout.setVisibility(8);
        } else {
            this.homeUpUserTypeRecommend58Layout.setVisibility(0);
        }
        for (int i2 = 0; i2 < this.homeUpUserTypeRecommend58Layout.getChildCount(); i2++) {
            ViewGroup viewGroup2 = (ViewGroup) this.homeUpUserTypeRecommend58Layout.getChildAt(i2);
            if (i2 >= this.b.getData().size() - 4) {
                this.homeUpUserTypeRecommend58Layout.removeView(viewGroup2);
            } else {
                l(viewGroup2, (ImageView) viewGroup2.getChildAt(0), (TextView) viewGroup2.getChildAt(1), (TextView) viewGroup2.getChildAt(2), i2 + 4);
            }
        }
    }

    private void k() {
        for (int i = 0; i < this.homeUpUserTypeRecommend14Layout.getChildCount(); i++) {
            ViewGroup viewGroup = (ViewGroup) this.homeUpUserTypeRecommend14Layout.getChildAt(i);
            if (i >= this.b.getData().size()) {
                this.homeUpUserTypeRecommend14Layout.removeView(viewGroup);
            } else {
                e((TextView) viewGroup.getChildAt(2), this.b.getData().get(i).getFollowed(), i);
            }
        }
        for (int i2 = 0; i2 < this.homeUpUserTypeRecommend58Layout.getChildCount(); i2++) {
            ViewGroup viewGroup2 = (ViewGroup) this.homeUpUserTypeRecommend58Layout.getChildAt(i2);
            if (i2 >= this.b.getData().size() - 4) {
                this.homeUpUserTypeRecommend58Layout.removeView(viewGroup2);
            } else {
                int i3 = i2 + 4;
                e((TextView) viewGroup2.getChildAt(2), this.b.getData().get(i3).getFollowed(), i3);
            }
        }
    }

    private void l(ViewGroup viewGroup, ImageView imageView, TextView textView, TextView textView2, int i) {
        UserRankBean.DataBean dataBean = this.b.getData().get(i);
        t.c(MyApplication.b(), dataBean.getFace(), imageView, new boolean[0]);
        textView.setText(dataBean.getNickname());
        com.rtk.app.tool.g.h hVar = new com.rtk.app.tool.g.h();
        hVar.j(dataBean.getUid());
        hVar.k(dataBean);
        com.rtk.app.tool.b0.a aVar = new com.rtk.app.tool.b0.a(dataBean.getUid(), dataBean.getFollowed() + "", textView2, hVar);
        this.d.c(aVar);
        com.rtk.app.tool.b0.b.b().a(aVar);
        e(textView2, dataBean.getFollowed(), i);
        viewGroup.setTag(dataBean.getUid());
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.main.MainActivityPack.HomePageItem1Pack.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t.B0(MyApplication.b(), (String) view.getTag());
            }
        });
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        c0.u("UpUserTypeHolder", "关注返回   " + str);
        int i2 = i / 10;
        int i3 = i % 10;
        this.d.a();
        if (i3 != 1 && i3 != 2) {
            this.b.getData().get(i2).setFollowed(1);
            com.rtk.app.tool.f.a(this.f207c, "关注成功", f.a.f);
            com.rtk.app.tool.b0.b.b().e(Integer.parseInt(this.b.getData().get(i2).getUid()), 1);
            k();
            return;
        }
        this.b.getData().get(i2).setFollowed(0);
        com.rtk.app.tool.f.a(this.f207c, "取消关注成功", f.a.f);
        c0.u("UpUserTypeHolder", "关注返回   " + str);
        com.rtk.app.tool.b0.b.b().e(Integer.parseInt(this.b.getData().get(i2).getUid()), 0);
        k();
    }

    public void e(TextView textView, int i, int i2) {
        t.G1(textView, i + "", i2, new a());
    }

    public void f(UserRankBean userRankBean, Context context, d dVar) {
        this.f207c = context;
        this.b = userRankBean;
        this.d = dVar;
        this.homeUpUserTypeRecommendUpSrcMore.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.main.MainActivityPack.HomePageItem1Pack.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.rtk.app.tool.c.b((Activity) MyApplication.b(), HomeUpExampleListActivity.class, null);
            }
        });
        h();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.d.a();
        this.d.e();
    }
}
