package com.rtk.app.main.MainActivityPack.HomePageItem1Pack;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpUserTypeHolder_ViewBinding implements Unbinder {
    private UpUserTypeHolder b;

    @UiThread
    public UpUserTypeHolder_ViewBinding(UpUserTypeHolder upUserTypeHolder, View view) {
        this.b = upUserTypeHolder;
        upUserTypeHolder.homeUpUserTypeRecommendMore = (TextView) butterknife.c.a.c(view, R.id.home_up_user_type_recommend_more, "field 'homeUpUserTypeRecommendMore'", TextView.class);
        upUserTypeHolder.homeUpUserTypeRecommend14Layout = (LinearLayout) butterknife.c.a.c(view, R.id.home_up_user_type_recommend_1_4_layout, "field 'homeUpUserTypeRecommend14Layout'", LinearLayout.class);
        upUserTypeHolder.homeUpUserTypeRecommend58Layout = (LinearLayout) butterknife.c.a.c(view, R.id.home_up_user_type_recommend_5_8_layout, "field 'homeUpUserTypeRecommend58Layout'", LinearLayout.class);
        upUserTypeHolder.homeUpUserTypeRecommendNoOneImg = (ImageView) butterknife.c.a.c(view, R.id.home_up_user_type_recommend_noOneImg, "field 'homeUpUserTypeRecommendNoOneImg'", ImageView.class);
        upUserTypeHolder.homeUpUserTypeRecommendGoToUp = (TextView) butterknife.c.a.c(view, R.id.home_up_user_type_recommend_goToUp, "field 'homeUpUserTypeRecommendGoToUp'", TextView.class);
        upUserTypeHolder.homeUpUserTypeRecommendNoBodyLv = (LinearLayout) butterknife.c.a.c(view, R.id.home_up_user_type_recommend_nobody_lv, "field 'homeUpUserTypeRecommendNoBodyLv'", LinearLayout.class);
        upUserTypeHolder.homeUpUserTypeRecommendUpSrcMore = (TextView) butterknife.c.a.c(view, R.id.home_up_user_type_recommend_up_src_more, "field 'homeUpUserTypeRecommendUpSrcMore'", TextView.class);
        upUserTypeHolder.homePageItem1FragmentUserRankItemNextTitle = (LinearLayout) butterknife.c.a.c(view, R.id.home_page_item1_fragment_user_rank_item_nextTitle, "field 'homePageItem1FragmentUserRankItemNextTitle'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        UpUserTypeHolder upUserTypeHolder = this.b;
        if (upUserTypeHolder != null) {
            this.b = null;
            upUserTypeHolder.homeUpUserTypeRecommendMore = null;
            upUserTypeHolder.homeUpUserTypeRecommend14Layout = null;
            upUserTypeHolder.homeUpUserTypeRecommend58Layout = null;
            upUserTypeHolder.homeUpUserTypeRecommendNoOneImg = null;
            upUserTypeHolder.homeUpUserTypeRecommendGoToUp = null;
            upUserTypeHolder.homeUpUserTypeRecommendNoBodyLv = null;
            upUserTypeHolder.homeUpUserTypeRecommendUpSrcMore = null;
            upUserTypeHolder.homePageItem1FragmentUserRankItemNextTitle = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
