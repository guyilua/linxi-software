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
public class UserRankViewHolder_ViewBinding implements Unbinder {
    private UserRankViewHolder b;

    @UiThread
    public UserRankViewHolder_ViewBinding(UserRankViewHolder userRankViewHolder, View view) {
        this.b = userRankViewHolder;
        userRankViewHolder.homePageItem1FragmentUserRankItemTitle = (TextView) butterknife.c.a.c(view, R.id.home_page_item1_fragment_user_rank_item_title, "field 'homePageItem1FragmentUserRankItemTitle'", TextView.class);
        userRankViewHolder.homePageItem1FragmentUserRankItemMore = (TextView) butterknife.c.a.c(view, R.id.home_page_item1_fragment_user_rank_item_more, "field 'homePageItem1FragmentUserRankItemMore'", TextView.class);
        userRankViewHolder.homePageItem1FragmentUserRankItemLayoutLv = (LinearLayout) butterknife.c.a.c(view, R.id.home_page_item1_fragment_user_rank_item_layout_lv, "field 'homePageItem1FragmentUserRankItemLayoutLv'", LinearLayout.class);
        userRankViewHolder.homePageItem1FragmentUserRankItemNoOneImg = (ImageView) butterknife.c.a.c(view, R.id.home_page_item1_fragment_user_rank_item_noOneImg, "field 'homePageItem1FragmentUserRankItemNoOneImg'", ImageView.class);
        userRankViewHolder.homePageItem1FragmentUserRankItemGoToUp = (TextView) butterknife.c.a.c(view, R.id.home_page_item1_fragment_user_rank_item_goToUp, "field 'homePageItem1FragmentUserRankItemGoToUp'", TextView.class);
        userRankViewHolder.homePageItem1FragmentUserRankItemNobodyLv = (LinearLayout) butterknife.c.a.c(view, R.id.home_page_item1_fragment_user_rank_item_nobody_lv, "field 'homePageItem1FragmentUserRankItemNobodyLv'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        UserRankViewHolder userRankViewHolder = this.b;
        if (userRankViewHolder != null) {
            this.b = null;
            userRankViewHolder.homePageItem1FragmentUserRankItemTitle = null;
            userRankViewHolder.homePageItem1FragmentUserRankItemMore = null;
            userRankViewHolder.homePageItem1FragmentUserRankItemLayoutLv = null;
            userRankViewHolder.homePageItem1FragmentUserRankItemNoOneImg = null;
            userRankViewHolder.homePageItem1FragmentUserRankItemGoToUp = null;
            userRankViewHolder.homePageItem1FragmentUserRankItemNobodyLv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
