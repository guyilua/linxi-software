package com.rtk.app.main.MainActivityPack.HomePageItem1Pack;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.rtk.app.bean.UpAdBean;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.t;
import com.youth.banner.Banner;
import java.util.ArrayList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class BannerHolder extends RecyclerView.ViewHolder implements com.youth.banner.d.b {
    public View a;
    private UpAdBean b;

    /* renamed from: c, reason: collision with root package name */
    private Context f201c;

    @BindView
    public Banner homeUpChoicenessBannerLayoutBanner;

    @BindView
    public TextView homeUpChoicenessBannerLayoutBannerTitle;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.HomeBanner.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.UpBanner.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.GameBanner.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.CommunityBanner.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum b {
        HomeBanner,
        UpBanner,
        GameBanner,
        CommunityBanner
    }

    public BannerHolder(@NonNull View view, b bVar) {
        super(view);
        ButterKnife.b(this, view);
        this.homeUpChoicenessBannerLayoutBanner.v(4000);
        this.a = view;
        int i = a.a[bVar.ordinal()];
        if (i == 1) {
            this.homeUpChoicenessBannerLayoutBanner.r(3);
            this.homeUpChoicenessBannerLayoutBanner.q(com.youth.banner.b.a);
        } else if (i == 2) {
            this.homeUpChoicenessBannerLayoutBanner.r(5);
            this.homeUpChoicenessBannerLayoutBanner.q(com.youth.banner.b.b);
        } else if (i == 3 || i == 4) {
            this.homeUpChoicenessBannerLayoutBanner.r(5);
            this.homeUpChoicenessBannerLayoutBanner.q(com.youth.banner.b.c);
        }
        b();
    }

    private void b() {
        this.homeUpChoicenessBannerLayoutBanner.y(this);
    }

    public void a(int i) {
        String tags = this.b.getData().get(i).getTags();
        tags.hashCode();
        char c2 = 65535;
        switch (tags.hashCode()) {
            case 49:
                if (tags.equals("1")) {
                    c2 = 0;
                    break;
                }
                break;
            case 50:
                if (tags.equals("2")) {
                    c2 = 1;
                    break;
                }
                break;
            case 51:
                if (tags.equals(GlobalSetting.SPLASH_AD)) {
                    c2 = 2;
                    break;
                }
                break;
            case 52:
                if (tags.equals(GlobalSetting.NATIVE_EXPRESS_AD)) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                t.J0(this.f201c, this.b.getData().get(i).getSid() + "");
                return;
            case 1:
                ApkInfo apkInfo = new ApkInfo(this.b.getData().get(i).getSid() + 10000000, null, null, null, null, null, 0, 0, null);
                apkInfo.setUpGameId(this.b.getData().get(i).getSid() + 10000000);
                t.X0(this.f201c, apkInfo);
                return;
            case 2:
                t.B0(this.f201c, this.b.getData().get(i).getSid() + "");
                return;
            case 3:
                t.e0(this.f201c, new ApkInfo(this.b.getData().get(i).getSid(), null, null, null, null, null, 0, 0, null));
                return;
            default:
                return;
        }
    }

    public void c(Context context) {
        this.f201c = context;
    }

    public void e(UpAdBean upAdBean) {
        this.b = upAdBean;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < upAdBean.getData().size(); i++) {
            arrayList.add(upAdBean.getData().get(i).getDesc());
        }
        this.homeUpChoicenessBannerLayoutBanner.t(arrayList);
    }
}
