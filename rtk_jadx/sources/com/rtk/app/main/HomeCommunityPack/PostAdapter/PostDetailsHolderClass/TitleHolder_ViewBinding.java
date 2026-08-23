package com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsHolderClass;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TitleHolder_ViewBinding implements Unbinder {
    private TitleHolder b;

    @UiThread
    public TitleHolder_ViewBinding(TitleHolder titleHolder, View view) {
        this.b = titleHolder;
        titleHolder.postDetailsRecyclerViewItemInformationLv = (RelativeLayout) butterknife.c.a.c(view, R.id.post_details_recyclerView_item_imformation_lv, "field 'postDetailsRecyclerViewItemInformationLv'", RelativeLayout.class);
        titleHolder.postDetailsRecyclerViewItemTitle = (TextView) butterknife.c.a.c(view, R.id.post_details_recyclerView_item_title, "field 'postDetailsRecyclerViewItemTitle'", TextView.class);
        titleHolder.postDetailsRecyclerViewItemTitleViewNum = (TextView) butterknife.c.a.c(view, R.id.post_details_recyclerView_item_title_viewNum, "field 'postDetailsRecyclerViewItemTitleViewNum'", TextView.class);
        titleHolder.postDetailsRecyclerViewItemTitleUpNum = (TextView) butterknife.c.a.c(view, R.id.post_details_recyclerView_item_title_upNum, "field 'postDetailsRecyclerViewItemTitleUpNum'", TextView.class);
        titleHolder.postDetailsRecyclerViewItemTitleCommentNum = (TextView) butterknife.c.a.c(view, R.id.post_details_recyclerView_item_title_commentNum, "field 'postDetailsRecyclerViewItemTitleCommentNum'", TextView.class);
        titleHolder.postDetailsRecyclerViewItemTitlePlate = (TextView) butterknife.c.a.c(view, R.id.post_details_recyclerView_item_title_plate, "field 'postDetailsRecyclerViewItemTitlePlate'", TextView.class);
        titleHolder.postDetailsRecyclerViewItemTimeShareUrl = (TextView) butterknife.c.a.c(view, R.id.post_details_recyclerView_item_title_share_url, "field 'postDetailsRecyclerViewItemTimeShareUrl'", TextView.class);
        titleHolder.postDetailsRecyclerViewItemIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.post_details_recyclerView_item_icon, "field 'postDetailsRecyclerViewItemIcon'", RoundedImageView.class);
        titleHolder.postDetailsRecyclerViewItemNickName = (TextView) butterknife.c.a.c(view, R.id.post_details_recyclerView_item_nickName, "field 'postDetailsRecyclerViewItemNickName'", TextView.class);
        titleHolder.postDetailsRecyclerViewItemSex = (TextView) butterknife.c.a.c(view, R.id.post_details_recyclerView_item_sex, "field 'postDetailsRecyclerViewItemSex'", TextView.class);
        titleHolder.postDetailsRecyclerViewItemIsModerator = (TextView) butterknife.c.a.c(view, R.id.post_details_recyclerView_item_isModerator, "field 'postDetailsRecyclerViewItemIsModerator'", TextView.class);
        titleHolder.postDetailsRecyclerViewItemTime = (TextView) butterknife.c.a.c(view, R.id.post_details_recyclerView_item_time, "field 'postDetailsRecyclerViewItemTime'", TextView.class);
        titleHolder.postDetailsRecyclerviewItemMedal = (LinearLayout) butterknife.c.a.c(view, R.id.post_details_recyclerView_item_medal, "field 'postDetailsRecyclerviewItemMedal'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        TitleHolder titleHolder = this.b;
        if (titleHolder != null) {
            this.b = null;
            titleHolder.postDetailsRecyclerViewItemInformationLv = null;
            titleHolder.postDetailsRecyclerViewItemTitle = null;
            titleHolder.postDetailsRecyclerViewItemTitleViewNum = null;
            titleHolder.postDetailsRecyclerViewItemTitleUpNum = null;
            titleHolder.postDetailsRecyclerViewItemTitleCommentNum = null;
            titleHolder.postDetailsRecyclerViewItemTitlePlate = null;
            titleHolder.postDetailsRecyclerViewItemTimeShareUrl = null;
            titleHolder.postDetailsRecyclerViewItemIcon = null;
            titleHolder.postDetailsRecyclerViewItemNickName = null;
            titleHolder.postDetailsRecyclerViewItemSex = null;
            titleHolder.postDetailsRecyclerViewItemIsModerator = null;
            titleHolder.postDetailsRecyclerViewItemTime = null;
            titleHolder.postDetailsRecyclerviewItemMedal = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
