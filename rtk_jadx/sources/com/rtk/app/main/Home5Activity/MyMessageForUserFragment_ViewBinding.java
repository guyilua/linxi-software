package com.rtk.app.main.Home5Activity;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyMessageForUserFragment_ViewBinding implements Unbinder {
    private MyMessageForUserFragment b;

    @UiThread
    public MyMessageForUserFragment_ViewBinding(MyMessageForUserFragment myMessageForUserFragment, View view) {
        this.b = myMessageForUserFragment;
        myMessageForUserFragment.myMessageForUserFragmentListView = (AutoListView) butterknife.c.a.c(view, R.id.my_message_for_user_fragment_listView, "field 'myMessageForUserFragmentListView'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        MyMessageForUserFragment myMessageForUserFragment = this.b;
        if (myMessageForUserFragment != null) {
            this.b = null;
            myMessageForUserFragment.myMessageForUserFragmentListView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
