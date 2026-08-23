package com.rtk.app.main.MainActivityPack.HomePageItem1Pack;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.bean.HomeAdBean;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeAdImageHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private b a;
    private Context b;

    @BindView
    ImageView homePageItem1FragmentAdImage;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.homePage.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.gamePage.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum b {
        homePage,
        gamePage
    }

    public HomeAdImageHolder(@NonNull View view) {
        super(view);
        ButterKnife.b(this, view);
    }

    public void b(Context context, HomeAdBean homeAdBean, b bVar) {
        this.b = context;
        this.a = bVar;
        try {
            if (a.a[bVar.ordinal()] == 1) {
                if (homeAdBean.getData().get(0).getAd_status() == 1) {
                    t.c(context, homeAdBean.getData().get(0).getAd_image(), this.homePageItem1FragmentAdImage, new boolean[0]);
                    this.homePageItem1FragmentAdImage.setOnClickListener(this);
                } else {
                    this.homePageItem1FragmentAdImage.setVisibility(8);
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == 2131298063 && a.a[this.a.ordinal()] == 1) {
            t.i0(this.b, y.o.getData().get(0).getAd_id() + "");
        }
    }
}
