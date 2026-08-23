package com.rtk.app.custom.TestPost;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.c.a;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TestPostAdapter$ViewHolder_ViewBinding implements Unbinder {
    private TestPostAdapter$ViewHolder b;

    @UiThread
    public TestPostAdapter$ViewHolder_ViewBinding(TestPostAdapter$ViewHolder testPostAdapter$ViewHolder, View view) {
        testPostAdapter$ViewHolder.testPostUserIcon = (RoundedImageView) a.c(view, R.id.test_post_user_icon, "field 'testPostUserIcon'", RoundedImageView.class);
        testPostAdapter$ViewHolder.testPostUserNickName = (TextView) a.c(view, R.id.test_post_user_nickName, "field 'testPostUserNickName'", TextView.class);
        testPostAdapter$ViewHolder.testPostUserTime = (TextView) a.c(view, R.id.test_post_user_time, "field 'testPostUserTime'", TextView.class);
        testPostAdapter$ViewHolder.testPostAdapterItemLv = (LinearLayout) a.c(view, R.id.test_post_adapter_item_lv, "field 'testPostAdapterItemLv'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        TestPostAdapter$ViewHolder testPostAdapter$ViewHolder = this.b;
        if (testPostAdapter$ViewHolder != null) {
            testPostAdapter$ViewHolder.testPostUserIcon = null;
            testPostAdapter$ViewHolder.testPostUserNickName = null;
            testPostAdapter$ViewHolder.testPostUserTime = null;
            testPostAdapter$ViewHolder.testPostAdapterItemLv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
