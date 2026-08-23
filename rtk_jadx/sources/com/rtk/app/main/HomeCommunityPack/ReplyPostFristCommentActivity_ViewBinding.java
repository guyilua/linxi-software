package com.rtk.app.main.HomeCommunityPack;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.custom.RichEditText.RichEditText;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ReplyPostFristCommentActivity_ViewBinding implements Unbinder {
    private ReplyPostFristCommentActivity b;

    @UiThread
    public ReplyPostFristCommentActivity_ViewBinding(ReplyPostFristCommentActivity replyPostFristCommentActivity, View view) {
        this.b = replyPostFristCommentActivity;
        replyPostFristCommentActivity.replyPostFirstCommentBack = (TextView) butterknife.c.a.c(view, R.id.reply_post_first_comment_back, "field 'replyPostFirstCommentBack'", TextView.class);
        replyPostFristCommentActivity.replyPostFirstCommentSubmit = (TextView) butterknife.c.a.c(view, R.id.reply_post_first_comment_submit, "field 'replyPostFirstCommentSubmit'", TextView.class);
        replyPostFristCommentActivity.replyPostFirstCommentPostTitle = (TextView) butterknife.c.a.c(view, R.id.reply_post_first_comment_post_title, "field 'replyPostFirstCommentPostTitle'", TextView.class);
        replyPostFristCommentActivity.replyPostFirstCommentTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.reply_post_first_comment_top_layout, "field 'replyPostFirstCommentTopLayout'", LinearLayout.class);
        replyPostFristCommentActivity.replyPostFirstCommentIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.reply_post_first_comment_icon, "field 'replyPostFirstCommentIcon'", RoundedImageView.class);
        replyPostFristCommentActivity.replyPostFirstCommentNickName = (TextView) butterknife.c.a.c(view, R.id.reply_post_first_comment_nickName, "field 'replyPostFirstCommentNickName'", TextView.class);
        replyPostFristCommentActivity.replyPostFirstCommentEditNum = (TextView) butterknife.c.a.c(view, R.id.reply_post_first_comment_EditNum, "field 'replyPostFirstCommentEditNum'", TextView.class);
        replyPostFristCommentActivity.replyPostFirstCommentRichEditText = (RichEditText) butterknife.c.a.c(view, R.id.reply_post_first_comment_richEditText, "field 'replyPostFirstCommentRichEditText'", RichEditText.class);
        replyPostFristCommentActivity.replyPostFirstCommentGame = (ImageView) butterknife.c.a.c(view, R.id.reply_post_first_comment_game, "field 'replyPostFirstCommentGame'", ImageView.class);
        replyPostFristCommentActivity.replyPostFirstCommentPhoto = (ImageView) butterknife.c.a.c(view, R.id.reply_post_first_comment_photo, "field 'replyPostFirstCommentPhoto'", ImageView.class);
        replyPostFristCommentActivity.replyPostFirstCommentSetBold = (CheckedTextView) butterknife.c.a.c(view, R.id.reply_post_first_comment_set_bold, "field 'replyPostFirstCommentSetBold'", CheckedTextView.class);
        replyPostFristCommentActivity.replyPostFirstCommentSetUnderLine = (CheckedTextView) butterknife.c.a.c(view, R.id.reply_post_first_comment_set_underLine, "field 'replyPostFirstCommentSetUnderLine'", CheckedTextView.class);
        replyPostFristCommentActivity.replyPostFirstCommentSetItalic = (CheckedTextView) butterknife.c.a.c(view, R.id.reply_post_first_comment_set_italic, "field 'replyPostFirstCommentSetItalic'", CheckedTextView.class);
        replyPostFristCommentActivity.replyPostFirstCommentSetTextSize = (Spinner) butterknife.c.a.c(view, R.id.reply_post_first_comment_set_textSize, "field 'replyPostFirstCommentSetTextSize'", Spinner.class);
        replyPostFristCommentActivity.replyPostFirstCommentSetTextColor = (Spinner) butterknife.c.a.c(view, R.id.reply_post_first_comment_set_textColor, "field 'replyPostFirstCommentSetTextColor'", Spinner.class);
    }

    @CallSuper
    public void a() {
        ReplyPostFristCommentActivity replyPostFristCommentActivity = this.b;
        if (replyPostFristCommentActivity != null) {
            this.b = null;
            replyPostFristCommentActivity.replyPostFirstCommentBack = null;
            replyPostFristCommentActivity.replyPostFirstCommentSubmit = null;
            replyPostFristCommentActivity.replyPostFirstCommentPostTitle = null;
            replyPostFristCommentActivity.replyPostFirstCommentTopLayout = null;
            replyPostFristCommentActivity.replyPostFirstCommentIcon = null;
            replyPostFristCommentActivity.replyPostFirstCommentNickName = null;
            replyPostFristCommentActivity.replyPostFirstCommentEditNum = null;
            replyPostFristCommentActivity.replyPostFirstCommentRichEditText = null;
            replyPostFristCommentActivity.replyPostFirstCommentGame = null;
            replyPostFristCommentActivity.replyPostFirstCommentPhoto = null;
            replyPostFristCommentActivity.replyPostFirstCommentSetBold = null;
            replyPostFristCommentActivity.replyPostFirstCommentSetUnderLine = null;
            replyPostFristCommentActivity.replyPostFirstCommentSetItalic = null;
            replyPostFristCommentActivity.replyPostFirstCommentSetTextSize = null;
            replyPostFristCommentActivity.replyPostFirstCommentSetTextColor = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
