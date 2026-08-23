package com.rtk.app.custom.TestPost;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.c.a;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TestPostActivity_ViewBinding implements Unbinder {
    private TestPostActivity b;

    @UiThread
    public TestPostActivity_ViewBinding(TestPostActivity testPostActivity, View view) {
        this.b = testPostActivity;
        testPostActivity.testPostSelectImg = (Button) a.c(view, R.id.test_post_selectImg, "field 'testPostSelectImg'", Button.class);
        testPostActivity.testPostContent = (TextView) a.c(view, R.id.test_post_content, "field 'testPostContent'", TextView.class);
    }

    @CallSuper
    public void a() {
        TestPostActivity testPostActivity = this.b;
        if (testPostActivity != null) {
            this.b = null;
            testPostActivity.testPostSelectImg = null;
            testPostActivity.testPostContent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
