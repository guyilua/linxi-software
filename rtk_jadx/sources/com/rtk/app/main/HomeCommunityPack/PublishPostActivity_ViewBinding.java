package com.rtk.app.main.HomeCommunityPack;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.RichEditText.RichEditText;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PublishPostActivity_ViewBinding implements Unbinder {
    private PublishPostActivity b;

    @UiThread
    public PublishPostActivity_ViewBinding(PublishPostActivity publishPostActivity, View view) {
        this.b = publishPostActivity;
        publishPostActivity.publishPostBack = (TextView) butterknife.c.a.c(view, R.id.publish_post_back, "field 'publishPostBack'", TextView.class);
        publishPostActivity.publishPostLayout = (LinearLayout) butterknife.c.a.c(view, R.id.publish_post_layout, "field 'publishPostLayout'", LinearLayout.class);
        publishPostActivity.publishPostSubmit = (TextView) butterknife.c.a.c(view, R.id.publish_post_submit, "field 'publishPostSubmit'", TextView.class);
        publishPostActivity.publishPostRichEditNum = (TextView) butterknife.c.a.c(view, R.id.publish_post_richEditNum, "field 'publishPostRichEditNum'", TextView.class);
        publishPostActivity.publishPostRichEditText = (RichEditText) butterknife.c.a.c(view, R.id.publish_post_richEditText, "field 'publishPostRichEditText'", RichEditText.class);
        publishPostActivity.publishPostTitle = (EditText) butterknife.c.a.c(view, R.id.publish_post_title, "field 'publishPostTitle'", EditText.class);
        publishPostActivity.publishPostInsertGame = (ImageView) butterknife.c.a.c(view, R.id.publish_post_insert_game, "field 'publishPostInsertGame'", ImageView.class);
        publishPostActivity.publishPostInsertPhoto = (ImageView) butterknife.c.a.c(view, R.id.publish_post_insert_photo, "field 'publishPostInsertPhoto'", ImageView.class);
        publishPostActivity.publishPostSetBold = (CheckedTextView) butterknife.c.a.c(view, R.id.publish_post_set_bold, "field 'publishPostSetBold'", CheckedTextView.class);
        publishPostActivity.publishPostSetItalic = (CheckedTextView) butterknife.c.a.c(view, R.id.publish_post_set_italic, "field 'publishPostSetItalic'", CheckedTextView.class);
        publishPostActivity.publishPostSetTextSize = (Spinner) butterknife.c.a.c(view, R.id.publish_post_set_textSize, "field 'publishPostSetTextSize'", Spinner.class);
        publishPostActivity.publishPostSetTextColor = (Spinner) butterknife.c.a.c(view, R.id.publish_post_set_textColor, "field 'publishPostSetTextColor'", Spinner.class);
        publishPostActivity.publishPostSetUnderLine = (CheckedTextView) butterknife.c.a.c(view, R.id.publish_post_set_underLine, "field 'publishPostSetUnderLine'", CheckedTextView.class);
        publishPostActivity.publishPostInsertUpSrc = (ImageView) butterknife.c.a.c(view, R.id.publish_post_insert_up_src, "field 'publishPostInsertUpSrc'", ImageView.class);
        publishPostActivity.publishPostInsertPost = (ImageView) butterknife.c.a.c(view, R.id.publish_post_insert_post, "field 'publishPostInsertPost'", ImageView.class);
        publishPostActivity.publishPostInsertUser = (ImageView) butterknife.c.a.c(view, R.id.publish_post_insert_user, "field 'publishPostInsertUser'", ImageView.class);
        publishPostActivity.publishPostSelectorTag = (TextView) butterknife.c.a.c(view, R.id.publish_post_selector_tag, "field 'publishPostSelectorTag'", TextView.class);
        publishPostActivity.publishPostScrollView = (ScrollView) butterknife.c.a.c(view, R.id.publish_post_scrollView, "field 'publishPostScrollView'", ScrollView.class);
        publishPostActivity.publishPostSetVideo = (ImageView) butterknife.c.a.c(view, R.id.publish_post_set_video, "field 'publishPostSetVideo'", ImageView.class);
    }

    @CallSuper
    public void a() {
        PublishPostActivity publishPostActivity = this.b;
        if (publishPostActivity != null) {
            this.b = null;
            publishPostActivity.publishPostBack = null;
            publishPostActivity.publishPostLayout = null;
            publishPostActivity.publishPostSubmit = null;
            publishPostActivity.publishPostRichEditNum = null;
            publishPostActivity.publishPostRichEditText = null;
            publishPostActivity.publishPostTitle = null;
            publishPostActivity.publishPostInsertGame = null;
            publishPostActivity.publishPostInsertPhoto = null;
            publishPostActivity.publishPostSetBold = null;
            publishPostActivity.publishPostSetItalic = null;
            publishPostActivity.publishPostSetTextSize = null;
            publishPostActivity.publishPostSetTextColor = null;
            publishPostActivity.publishPostSetUnderLine = null;
            publishPostActivity.publishPostInsertUpSrc = null;
            publishPostActivity.publishPostInsertPost = null;
            publishPostActivity.publishPostInsertUser = null;
            publishPostActivity.publishPostSelectorTag = null;
            publishPostActivity.publishPostScrollView = null;
            publishPostActivity.publishPostSetVideo = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
