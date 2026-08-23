package com.rtk.app.main.MainActivityPack.UpChoicenessPack;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class BoardHeadView_ViewBinding implements Unbinder {
    private BoardHeadView b;

    @UiThread
    public BoardHeadView_ViewBinding(BoardHeadView boardHeadView, View view) {
        this.b = boardHeadView;
        boardHeadView.BoardHeadView = (TextView) butterknife.c.a.c(view, R.id.board_headView, "field 'BoardHeadView'", TextView.class);
    }

    @CallSuper
    public void a() {
        BoardHeadView boardHeadView = this.b;
        if (boardHeadView != null) {
            this.b = null;
            boardHeadView.BoardHeadView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
