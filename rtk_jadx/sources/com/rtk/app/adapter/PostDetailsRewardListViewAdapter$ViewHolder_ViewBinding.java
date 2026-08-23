package com.rtk.app.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostDetailsRewardListViewAdapter$ViewHolder_ViewBinding implements Unbinder {
    private PostDetailsRewardListViewAdapter$ViewHolder b;

    @UiThread
    public PostDetailsRewardListViewAdapter$ViewHolder_ViewBinding(PostDetailsRewardListViewAdapter$ViewHolder postDetailsRewardListViewAdapter$ViewHolder, View view) {
        postDetailsRewardListViewAdapter$ViewHolder.postDetailsRewardItemImg = (ImageView) butterknife.c.a.c(view, R.id.post_details_reward_item_img, "field 'postDetailsRewardItemImg'", ImageView.class);
        postDetailsRewardListViewAdapter$ViewHolder.postDetailsRewardItemNum = (TextView) butterknife.c.a.c(view, R.id.post_details_reward_item_num, "field 'postDetailsRewardItemNum'", TextView.class);
    }

    @CallSuper
    public void a() {
        PostDetailsRewardListViewAdapter$ViewHolder postDetailsRewardListViewAdapter$ViewHolder = this.b;
        if (postDetailsRewardListViewAdapter$ViewHolder != null) {
            postDetailsRewardListViewAdapter$ViewHolder.postDetailsRewardItemImg = null;
            postDetailsRewardListViewAdapter$ViewHolder.postDetailsRewardItemNum = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
