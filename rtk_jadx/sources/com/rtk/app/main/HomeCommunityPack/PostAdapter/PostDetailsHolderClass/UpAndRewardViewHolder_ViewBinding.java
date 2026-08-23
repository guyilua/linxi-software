package com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsHolderClass;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.CustomTextView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpAndRewardViewHolder_ViewBinding implements Unbinder {
    private UpAndRewardViewHolder b;

    @UiThread
    public UpAndRewardViewHolder_ViewBinding(UpAndRewardViewHolder upAndRewardViewHolder, View view) {
        this.b = upAndRewardViewHolder;
        upAndRewardViewHolder.postDetailsRecyclerViewItemUpAndRewardUpLv = (LinearLayout) butterknife.c.a.c(view, R.id.post_details_recyclerView_item_up_and_reward_up_Lv, "field 'postDetailsRecyclerViewItemUpAndRewardUpLv'", LinearLayout.class);
        upAndRewardViewHolder.postDetailsRecyclerViewItemUpAndRewardUpLv2 = (LinearLayout) butterknife.c.a.c(view, R.id.post_details_recyclerView_item_up_and_reward_up_Lv2, "field 'postDetailsRecyclerViewItemUpAndRewardUpLv2'", LinearLayout.class);
        upAndRewardViewHolder.postDetailsRecyclerViewItemUpAndRewardUpNum = (TextView) butterknife.c.a.c(view, R.id.post_details_recyclerView_item_up_and_reward_upNum, "field 'postDetailsRecyclerViewItemUpAndRewardUpNum'", TextView.class);
        upAndRewardViewHolder.postDetailsRecyclerViewItemUpAndRewardLv = (LinearLayout) butterknife.c.a.c(view, R.id.post_details_recyclerView_item_up_and_reward_lv, "field 'postDetailsRecyclerViewItemUpAndRewardLv'", LinearLayout.class);
        upAndRewardViewHolder.postDetailsRecyclerViewItemUpAndRewardLv2 = (LinearLayout) butterknife.c.a.c(view, R.id.post_details_recyclerView_item_up_and_reward_lv2, "field 'postDetailsRecyclerViewItemUpAndRewardLv2'", LinearLayout.class);
        upAndRewardViewHolder.postDetailsRecyclerViewItemUpAndRewardNum = (CustomTextView) butterknife.c.a.c(view, R.id.post_details_recyclerView_item_up_and_reward_num, "field 'postDetailsRecyclerViewItemUpAndRewardNum'", CustomTextView.class);
        upAndRewardViewHolder.postDetailsRecyclerViewItemUpAndRewardCommentNum = (TextView) butterknife.c.a.c(view, R.id.post_details_recyclerView_item_up_and_reward_comment_num, "field 'postDetailsRecyclerViewItemUpAndRewardCommentNum'", TextView.class);
        upAndRewardViewHolder.postDetailsRecyclerViewItemUpAndRewardArrangeType = (Spinner) butterknife.c.a.c(view, R.id.post_details_recyclerView_item_up_and_reward_arrangeType, "field 'postDetailsRecyclerViewItemUpAndRewardArrangeType'", Spinner.class);
        upAndRewardViewHolder.postDetailsRecyclerViewItemUpAndRewardOnlyMaster = (CheckBox) butterknife.c.a.c(view, R.id.post_details_recyclerView_item_up_and_reward_only_master, "field 'postDetailsRecyclerViewItemUpAndRewardOnlyMaster'", CheckBox.class);
    }

    @CallSuper
    public void a() {
        UpAndRewardViewHolder upAndRewardViewHolder = this.b;
        if (upAndRewardViewHolder != null) {
            this.b = null;
            upAndRewardViewHolder.postDetailsRecyclerViewItemUpAndRewardUpLv = null;
            upAndRewardViewHolder.postDetailsRecyclerViewItemUpAndRewardUpLv2 = null;
            upAndRewardViewHolder.postDetailsRecyclerViewItemUpAndRewardUpNum = null;
            upAndRewardViewHolder.postDetailsRecyclerViewItemUpAndRewardLv = null;
            upAndRewardViewHolder.postDetailsRecyclerViewItemUpAndRewardLv2 = null;
            upAndRewardViewHolder.postDetailsRecyclerViewItemUpAndRewardNum = null;
            upAndRewardViewHolder.postDetailsRecyclerViewItemUpAndRewardCommentNum = null;
            upAndRewardViewHolder.postDetailsRecyclerViewItemUpAndRewardArrangeType = null;
            upAndRewardViewHolder.postDetailsRecyclerViewItemUpAndRewardOnlyMaster = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
