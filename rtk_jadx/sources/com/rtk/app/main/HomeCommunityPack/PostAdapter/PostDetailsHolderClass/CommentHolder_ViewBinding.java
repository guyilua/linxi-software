package com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsHolderClass;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CommentHolder_ViewBinding implements Unbinder {
    private CommentHolder b;

    @UiThread
    public CommentHolder_ViewBinding(CommentHolder commentHolder, View view) {
        this.b = commentHolder;
        commentHolder.testPostUserIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.test_post_user_icon, "field 'testPostUserIcon'", RoundedImageView.class);
        commentHolder.testPostUserIsMaster = (TextView) butterknife.c.a.c(view, R.id.test_post_user_is_master, "field 'testPostUserIsMaster'", TextView.class);
        commentHolder.testPostUserNickName = (TextView) butterknife.c.a.c(view, R.id.test_post_user_nickName, "field 'testPostUserNickName'", TextView.class);
        commentHolder.testPostUserMedal = (LinearLayout) butterknife.c.a.c(view, R.id.test_post_user_medal, "field 'testPostUserMedal'", LinearLayout.class);
        commentHolder.testPostFloor = (TextView) butterknife.c.a.c(view, R.id.test_post_floor, "field 'testPostFloor'", TextView.class);
        commentHolder.testPostUserTime = (TextView) butterknife.c.a.c(view, R.id.test_post_user_time, "field 'testPostUserTime'", TextView.class);
        commentHolder.testPostUserLever = (TextView) butterknife.c.a.c(view, R.id.test_post_user_lever, "field 'testPostUserLever'", TextView.class);
        commentHolder.postDetailsRecyclerViewItemCommentMore = (ImageView) butterknife.c.a.c(view, R.id.post_details_recyclerView_item_comment_more, "field 'postDetailsRecyclerViewItemCommentMore'", ImageView.class);
        commentHolder.postDetailsRecyclerViewItemCommentUp = (CheckBox) butterknife.c.a.c(view, R.id.post_details_recyclerView_item_comment_up, "field 'postDetailsRecyclerViewItemCommentUp'", CheckBox.class);
        commentHolder.postDetailsRecyclerViewItemCommentComment = (TextView) butterknife.c.a.c(view, R.id.post_details_recyclerView_item_comment_comment, "field 'postDetailsRecyclerViewItemCommentComment'", TextView.class);
        commentHolder.testPostAdapterItemLv = (LinearLayout) butterknife.c.a.c(view, R.id.test_post_adapter_item_lv, "field 'testPostAdapterItemLv'", LinearLayout.class);
        commentHolder.postDetailsRecyclerViewItemCommentSecondCommentLv = (LinearLayout) butterknife.c.a.c(view, R.id.postDetailsRecyclerViewItemCommentSecondCommentLv, "field 'postDetailsRecyclerViewItemCommentSecondCommentLv'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        CommentHolder commentHolder = this.b;
        if (commentHolder != null) {
            this.b = null;
            commentHolder.testPostUserIcon = null;
            commentHolder.testPostUserIsMaster = null;
            commentHolder.testPostUserNickName = null;
            commentHolder.testPostUserMedal = null;
            commentHolder.testPostFloor = null;
            commentHolder.testPostUserTime = null;
            commentHolder.testPostUserLever = null;
            commentHolder.postDetailsRecyclerViewItemCommentMore = null;
            commentHolder.postDetailsRecyclerViewItemCommentUp = null;
            commentHolder.postDetailsRecyclerViewItemCommentComment = null;
            commentHolder.testPostAdapterItemLv = null;
            commentHolder.postDetailsRecyclerViewItemCommentSecondCommentLv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
