package com.rtk.app.main.comment;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CommentActivity_ViewBinding implements Unbinder {
    private CommentActivity b;

    @UiThread
    public CommentActivity_ViewBinding(CommentActivity commentActivity, View view) {
        this.b = commentActivity;
        commentActivity.activityCommentTitleRl = (RelativeLayout) butterknife.c.a.c(view, R.id.activity_comment_title_rl, "field 'activityCommentTitleRl'", RelativeLayout.class);
        commentActivity.activityCommentsStartImg1 = (ImageView) butterknife.c.a.c(view, R.id.activity_comments_start_img1, "field 'activityCommentsStartImg1'", ImageView.class);
        commentActivity.activityCommentsStartImg2 = (ImageView) butterknife.c.a.c(view, R.id.activity_comments_start_img2, "field 'activityCommentsStartImg2'", ImageView.class);
        commentActivity.activityCommentsStartImg3 = (ImageView) butterknife.c.a.c(view, R.id.activity_comments_start_img3, "field 'activityCommentsStartImg3'", ImageView.class);
        commentActivity.activityCommentsStartImg4 = (ImageView) butterknife.c.a.c(view, R.id.activity_comments_start_img4, "field 'activityCommentsStartImg4'", ImageView.class);
        commentActivity.activityCommentsStartImg5 = (ImageView) butterknife.c.a.c(view, R.id.activity_comments_start_img5, "field 'activityCommentsStartImg5'", ImageView.class);
        commentActivity.activityCommentsStartHint = (TextView) butterknife.c.a.c(view, R.id.activity_comments_start_hint, "field 'activityCommentsStartHint'", TextView.class);
        commentActivity.activityCommentsStartLy = (LinearLayout) butterknife.c.a.c(view, R.id.activity_comments_start_ly, "field 'activityCommentsStartLy'", LinearLayout.class);
        commentActivity.activityCommentsContent = (EditText) butterknife.c.a.c(view, R.id.activity_comments_content, "field 'activityCommentsContent'", EditText.class);
        commentActivity.activityCommentsStartContentHint = (TextView) butterknife.c.a.c(view, R.id.activity_comments_start_content_hint, "field 'activityCommentsStartContentHint'", TextView.class);
        commentActivity.commentEmojie = (ImageView) butterknife.c.a.c(view, R.id.comment_emojie, "field 'commentEmojie'", ImageView.class);
        commentActivity.activityCommentsSubmit = (TextView) butterknife.c.a.c(view, R.id.activity_comments_submit, "field 'activityCommentsSubmit'", TextView.class);
        commentActivity.viwepagerExpression = (ViewPager) butterknife.c.a.c(view, R.id.viwepager_expression, "field 'viwepagerExpression'", ViewPager.class);
        commentActivity.llDotContainer = (LinearLayout) butterknife.c.a.c(view, R.id.ll_dot_container, "field 'llDotContainer'", LinearLayout.class);
        commentActivity.commentEmojiLayout = (LinearLayout) butterknife.c.a.c(view, R.id.comment_emoji_layout, "field 'commentEmojiLayout'", LinearLayout.class);
        commentActivity.activityCommentTitleBack = (TextView) butterknife.c.a.c(view, R.id.activity_comment_title_back, "field 'activityCommentTitleBack'", TextView.class);
        commentActivity.commentSepcificationTV = (TextView) butterknife.c.a.c(view, R.id.comment_sepcification_TV, "field 'commentSepcificationTV'", TextView.class);
        commentActivity.commentUpImageIncludeView = butterknife.c.a.b(view, R.id.comment_up_image_include_view, "field 'commentUpImageIncludeView'");
    }

    @CallSuper
    public void a() {
        CommentActivity commentActivity = this.b;
        if (commentActivity != null) {
            this.b = null;
            commentActivity.activityCommentTitleRl = null;
            commentActivity.activityCommentsStartImg1 = null;
            commentActivity.activityCommentsStartImg2 = null;
            commentActivity.activityCommentsStartImg3 = null;
            commentActivity.activityCommentsStartImg4 = null;
            commentActivity.activityCommentsStartImg5 = null;
            commentActivity.activityCommentsStartHint = null;
            commentActivity.activityCommentsStartLy = null;
            commentActivity.activityCommentsContent = null;
            commentActivity.activityCommentsStartContentHint = null;
            commentActivity.commentEmojie = null;
            commentActivity.activityCommentsSubmit = null;
            commentActivity.viwepagerExpression = null;
            commentActivity.llDotContainer = null;
            commentActivity.commentEmojiLayout = null;
            commentActivity.activityCommentTitleBack = null;
            commentActivity.commentSepcificationTV = null;
            commentActivity.commentUpImageIncludeView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
