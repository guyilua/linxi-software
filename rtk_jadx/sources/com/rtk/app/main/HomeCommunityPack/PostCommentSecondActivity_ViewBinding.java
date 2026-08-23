package com.rtk.app.main.HomeCommunityPack;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.RichEditText.RichEditText;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostCommentSecondActivity_ViewBinding implements Unbinder {
    private PostCommentSecondActivity b;

    @UiThread
    public PostCommentSecondActivity_ViewBinding(PostCommentSecondActivity postCommentSecondActivity, View view) {
        this.b = postCommentSecondActivity;
        postCommentSecondActivity.postCommentSecondTitleBack = (TextView) butterknife.c.a.c(view, R.id.post_comment_second_title_back, "field 'postCommentSecondTitleBack'", TextView.class);
        postCommentSecondActivity.postCommentSecondTitleRl = (RelativeLayout) butterknife.c.a.c(view, R.id.post_comment_second_title_rl, "field 'postCommentSecondTitleRl'", RelativeLayout.class);
        postCommentSecondActivity.postCommentSecondsContent = (RichEditText) butterknife.c.a.c(view, R.id.post_comment_seconds_content, "field 'postCommentSecondsContent'", RichEditText.class);
        postCommentSecondActivity.postCommentSecondsStartContentHint = (TextView) butterknife.c.a.c(view, R.id.post_comment_seconds_start_content_hint, "field 'postCommentSecondsStartContentHint'", TextView.class);
        postCommentSecondActivity.commentEmojie = (ImageView) butterknife.c.a.c(view, R.id.comment_emojie, "field 'commentEmojie'", ImageView.class);
        postCommentSecondActivity.postCommentSecondsSubmit = (TextView) butterknife.c.a.c(view, R.id.post_comment_seconds_submit, "field 'postCommentSecondsSubmit'", TextView.class);
        postCommentSecondActivity.commentSepcificationTV = (TextView) butterknife.c.a.c(view, R.id.comment_sepcification_TV, "field 'commentSepcificationTV'", TextView.class);
        postCommentSecondActivity.viwepagerExpression = (ViewPager) butterknife.c.a.c(view, R.id.viwepager_expression, "field 'viwepagerExpression'", ViewPager.class);
        postCommentSecondActivity.llDotContainer = (LinearLayout) butterknife.c.a.c(view, R.id.ll_dot_container, "field 'llDotContainer'", LinearLayout.class);
        postCommentSecondActivity.commentEmojiLayout = (LinearLayout) butterknife.c.a.c(view, R.id.comment_emoji_layout, "field 'commentEmojiLayout'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        PostCommentSecondActivity postCommentSecondActivity = this.b;
        if (postCommentSecondActivity != null) {
            this.b = null;
            postCommentSecondActivity.postCommentSecondTitleBack = null;
            postCommentSecondActivity.postCommentSecondTitleRl = null;
            postCommentSecondActivity.postCommentSecondsContent = null;
            postCommentSecondActivity.postCommentSecondsStartContentHint = null;
            postCommentSecondActivity.commentEmojie = null;
            postCommentSecondActivity.postCommentSecondsSubmit = null;
            postCommentSecondActivity.commentSepcificationTV = null;
            postCommentSecondActivity.viwepagerExpression = null;
            postCommentSecondActivity.llDotContainer = null;
            postCommentSecondActivity.commentEmojiLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
