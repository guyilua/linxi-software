package com.rtk.app.main.MainActivityPack.HomePageItem1Pack;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.bean.FamilyCreateCheckTipsBean;
import com.rtk.app.bean.FamilyListBean;
import com.rtk.app.main.family.FamilyCreateActivity;
import com.rtk.app.main.family.FamilyCreateCheckTipsActivity;
import com.rtk.app.main.family.FamilyListActivity;
import com.rtk.app.main.family.HotFamilyActivity;
import com.rtk.app.main.family.LatestFamilyActivity;
import com.rtk.app.main.family.MyFamilyActivity;
import com.rtk.app.main.family.NoFamilyActivity;
import com.rtk.app.main.family.j1;
import com.rtk.app.tool.f;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CommunityFamilyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public View a;
    private Context b;

    /* renamed from: c, reason: collision with root package name */
    FamilyListBean f203c;

    @BindView
    TextView createFamily;
    int d;

    @BindView
    ImageView hotFamily;

    @BindView
    ImageView myFamily;

    @BindView
    ImageView newFamily;

    @BindView
    ImageView searchFamily;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements h.j {
        a() {
        }

        @Override // com.rtk.app.tool.o.h.j
        public void d(String str, int i) {
            Intent intent;
            if (j1.a(((FamilyCreateCheckTipsBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, FamilyCreateCheckTipsBean.class)).getData())) {
                intent = new Intent(CommunityFamilyHolder.this.b, (Class<?>) FamilyCreateActivity.class);
            } else {
                intent = new Intent(CommunityFamilyHolder.this.b, (Class<?>) FamilyCreateCheckTipsActivity.class);
            }
            CommunityFamilyHolder.this.b.startActivity(intent);
        }

        @Override // com.rtk.app.tool.o.h.j
        public void g(int i, String str, int i2) {
            f.a(CommunityFamilyHolder.this.b, str, f.a.f);
        }
    }

    public CommunityFamilyHolder(Context context, View view) {
        super(view);
        this.d = 0;
        this.b = context;
        ButterKnife.b(this, view);
        this.a = view;
        c();
    }

    private void c() {
        this.myFamily.setOnClickListener(this);
        this.searchFamily.setOnClickListener(this);
        this.newFamily.setOnClickListener(this);
        this.hotFamily.setOnClickListener(this);
        this.createFamily.setOnClickListener(this);
    }

    public void e(FamilyListBean familyListBean) {
        this.f203c = familyListBean;
        if (familyListBean != null && familyListBean.getData() != null && !familyListBean.getData().isEmpty()) {
            this.d = familyListBean.getData().size();
        } else {
            this.d = 0;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.create_family /* 2131297083 */:
                HashMap<String, String> l = y.l();
                l.put("key", t.L(l));
                h.l(this.b, new a(), 1, h.h(y.e).a(y.w("family/create/check", l)));
                return;
            case R.id.hot_family /* 2131298172 */:
                this.b.startActivity(new Intent(this.b, (Class<?>) HotFamilyActivity.class));
                return;
            case R.id.my_family /* 2131299444 */:
                if (!y.x(this.b)) {
                    t.w0(this.b);
                    return;
                }
                Class<?> cls = NoFamilyActivity.class;
                Intent intent = new Intent();
                int i = this.d;
                if (i != 0) {
                    if (i != 1) {
                        cls = FamilyListActivity.class;
                    } else {
                        intent.putExtra("family_id", this.f203c.getData().get(0).getFamily_id());
                        cls = MyFamilyActivity.class;
                    }
                }
                intent.setClass(this.b, cls);
                this.b.startActivity(intent);
                return;
            case R.id.new_family /* 2131299569 */:
                this.b.startActivity(new Intent(this.b, (Class<?>) LatestFamilyActivity.class));
                return;
            case R.id.search_family /* 2131300092 */:
                Intent intent2 = new Intent(this.b, (Class<?>) HotFamilyActivity.class);
                intent2.putExtra("is_search_family", true);
                this.b.startActivity(intent2);
                return;
            default:
                return;
        }
    }
}
