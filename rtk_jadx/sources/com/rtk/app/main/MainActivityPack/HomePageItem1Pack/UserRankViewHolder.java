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
import com.rtk.app.main.MainActivityPack.UpChoicenessPack.HomeUpChoicenessForExpertActivity;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.f;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UserRankViewHolder extends RecyclerView.ViewHolder implements h.j, View.OnClickListener {
    private DialogForProgressTip a;
    private Context b;

    /* renamed from: c, reason: collision with root package name */
    private List<com.rtk.app.tool.b0.c> f208c;
    private c d;
    private List<UserRankBean.DataBean> e;

    @BindView
    TextView homePageItem1FragmentUserRankItemGoToUp;

    @BindView
    public LinearLayout homePageItem1FragmentUserRankItemLayoutLv;

    @BindView
    public TextView homePageItem1FragmentUserRankItemMore;

    @BindView
    ImageView homePageItem1FragmentUserRankItemNoOneImg;

    @BindView
    LinearLayout homePageItem1FragmentUserRankItemNobodyLv;

    @BindView
    public TextView homePageItem1FragmentUserRankItemTitle;

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
            sb.append(((UserRankBean.DataBean) UserRankViewHolder.this.e.get(parseInt2)).getUid());
            sb.append("&key=");
            sb.append(t.c0(c0.e(y.v(MyApplication.b(), "fans=" + ((UserRankBean.DataBean) UserRankViewHolder.this.e.get(parseInt2)).getUid(), "uid=" + y.K(), "token=" + y.H()))));
            String sb2 = sb.toString();
            UserRankViewHolder.this.a.show();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("关注链接");
            sb3.append(y.d);
            sb3.append(sb2);
            c0.u("UserRankViewHolder", sb3.toString());
            h.l(MyApplication.b(), UserRankViewHolder.this, parseInt + (parseInt2 * 10), h.h(new String[0]).a(sb2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements View.OnClickListener {
        b(UserRankViewHolder userRankViewHolder) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t.B0(MyApplication.b(), (String) view.getTag());
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface c {
        void d(com.rtk.app.tool.b0.c cVar);
    }

    public UserRankViewHolder(@NonNull View view) {
        super(view);
        this.f208c = new ArrayList();
        ButterKnife.b(this, view);
    }

    private void e() {
        this.homePageItem1FragmentUserRankItemMore.setOnClickListener(this);
        this.homePageItem1FragmentUserRankItemGoToUp.setOnClickListener(this);
    }

    private void f() {
        List<UserRankBean.DataBean> list = this.e;
        if (list != null && list.size() != 0) {
            for (int i = 0; i < this.homePageItem1FragmentUserRankItemLayoutLv.getChildCount(); i++) {
                ViewGroup viewGroup = (ViewGroup) this.homePageItem1FragmentUserRankItemLayoutLv.getChildAt(i);
                if (i >= this.e.size()) {
                    this.homePageItem1FragmentUserRankItemLayoutLv.removeView(viewGroup);
                } else {
                    i(viewGroup, (ImageView) viewGroup.getChildAt(0), (TextView) viewGroup.getChildAt(1), (TextView) viewGroup.getChildAt(2), i);
                }
            }
            return;
        }
        this.homePageItem1FragmentUserRankItemNobodyLv.setVisibility(0);
        this.homePageItem1FragmentUserRankItemLayoutLv.setVisibility(8);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        c0.u("UserRankViewHolder", "关注返回   " + str);
        int i2 = i / 10;
        int i3 = i % 10;
        this.a.dismiss();
        if (i3 != 1 && i3 != 2) {
            this.e.get(i2).setFollowed(1);
            com.rtk.app.tool.b0.b.b().e(Integer.parseInt(this.e.get(i2).getUid()), 1);
        } else {
            this.e.get(i2).setFollowed(0);
            com.rtk.app.tool.f.a(MyApplication.b(), "取消关注成功", f.a.f);
            com.rtk.app.tool.b0.b.b().e(Integer.parseInt(this.e.get(i2).getUid()), 0);
        }
        f();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.a.dismiss();
        com.rtk.app.tool.f.a(MyApplication.b(), str, f.a.f);
    }

    public void h(Context context, List<UserRankBean.DataBean> list, c cVar) {
        this.e = list;
        this.b = context;
        this.d = cVar;
        DialogForProgressTip dialogForProgressTip = new DialogForProgressTip(MyApplication.b(), "请稍后...");
        this.a = dialogForProgressTip;
        dialogForProgressTip.setCancelable(false);
        f();
        e();
    }

    public void i(ViewGroup viewGroup, ImageView imageView, TextView textView, TextView textView2, int i) {
        UserRankBean.DataBean dataBean = this.e.get(i);
        t.c(MyApplication.b(), dataBean.getFace(), imageView, new boolean[0]);
        textView.setText(dataBean.getNickname());
        com.rtk.app.tool.g.h hVar = new com.rtk.app.tool.g.h();
        hVar.j(dataBean.getUid());
        hVar.k(dataBean);
        com.rtk.app.tool.b0.a aVar = new com.rtk.app.tool.b0.a(dataBean.getUid(), dataBean.getFollowed() + "", textView2, hVar);
        this.f208c.add(aVar);
        this.d.d(aVar);
        com.rtk.app.tool.b0.b.b().a(aVar);
        t.G1(textView2, dataBean.getFollowed() + "", i, new a());
        viewGroup.setTag(dataBean.getUid());
        viewGroup.setOnClickListener(new b(this));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131298073) {
            t.e2(this.b, view);
        } else {
            if (id != 2131298075) {
                return;
            }
            com.rtk.app.tool.c.b((Activity) this.b, HomeUpChoicenessForExpertActivity.class, null);
        }
    }
}
