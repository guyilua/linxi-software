package com.rtk.app.main;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GameFeedBackActivity_ViewBinding implements Unbinder {
    private GameFeedBackActivity b;

    @UiThread
    public GameFeedBackActivity_ViewBinding(GameFeedBackActivity gameFeedBackActivity, View view) {
        this.b = gameFeedBackActivity;
        gameFeedBackActivity.gameFeedBackBackTV = (TextView) butterknife.c.a.c(view, R.id.game_feed_back_backTV, "field 'gameFeedBackBackTV'", TextView.class);
        gameFeedBackActivity.gameFeedBackLayout = (LinearLayout) butterknife.c.a.c(view, R.id.game_feed_back_layout, "field 'gameFeedBackLayout'", LinearLayout.class);
        gameFeedBackActivity.gameFeedBackSubmit = (TextView) butterknife.c.a.c(view, R.id.game_feed_back_submit, "field 'gameFeedBackSubmit'", TextView.class);
        gameFeedBackActivity.feedBackToGameGameIcon = (ImageView) butterknife.c.a.c(view, R.id.feed_back_to_game_gameIcon, "field 'feedBackToGameGameIcon'", ImageView.class);
        gameFeedBackActivity.feedBackToGameGameName = (TextView) butterknife.c.a.c(view, R.id.feed_back_to_game_gameName, "field 'feedBackToGameGameName'", TextView.class);
        gameFeedBackActivity.feedBackToGameRadioGroup = (RadioGroup) butterknife.c.a.c(view, R.id.feed_back_to_game_radioGroup, "field 'feedBackToGameRadioGroup'", RadioGroup.class);
        gameFeedBackActivity.gameFeedBackComment = (EditText) butterknife.c.a.c(view, R.id.game_feed_back_comment, "field 'gameFeedBackComment'", EditText.class);
        gameFeedBackActivity.gameFeedBackContentSize = (TextView) butterknife.c.a.c(view, R.id.game_feed_back_content_size, "field 'gameFeedBackContentSize'", TextView.class);
        gameFeedBackActivity.gameFeedBackContact = (EditText) butterknife.c.a.c(view, R.id.game_feed_back_contact, "field 'gameFeedBackContact'", EditText.class);
    }

    @CallSuper
    public void a() {
        GameFeedBackActivity gameFeedBackActivity = this.b;
        if (gameFeedBackActivity != null) {
            this.b = null;
            gameFeedBackActivity.gameFeedBackBackTV = null;
            gameFeedBackActivity.gameFeedBackLayout = null;
            gameFeedBackActivity.gameFeedBackSubmit = null;
            gameFeedBackActivity.feedBackToGameGameIcon = null;
            gameFeedBackActivity.feedBackToGameGameName = null;
            gameFeedBackActivity.feedBackToGameRadioGroup = null;
            gameFeedBackActivity.gameFeedBackComment = null;
            gameFeedBackActivity.gameFeedBackContentSize = null;
            gameFeedBackActivity.gameFeedBackContact = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
