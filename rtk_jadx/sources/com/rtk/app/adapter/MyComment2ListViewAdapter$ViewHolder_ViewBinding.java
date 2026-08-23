package com.rtk.app.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyComment2ListViewAdapter$ViewHolder_ViewBinding implements Unbinder {
    private MyComment2ListViewAdapter$ViewHolder b;

    @UiThread
    public MyComment2ListViewAdapter$ViewHolder_ViewBinding(MyComment2ListViewAdapter$ViewHolder myComment2ListViewAdapter$ViewHolder, View view) {
        myComment2ListViewAdapter$ViewHolder.myComment2ListviewItemGameImg = (ImageView) butterknife.c.a.c(view, R.id.my_comment2_listview_item_game_img, "field 'myComment2ListviewItemGameImg'", ImageView.class);
        myComment2ListViewAdapter$ViewHolder.myComment2ListviewItemGameName = (TextView) butterknife.c.a.c(view, R.id.my_comment2_listview_item_game_name, "field 'myComment2ListviewItemGameName'", TextView.class);
        myComment2ListViewAdapter$ViewHolder.myComment2ListviewItemStart = (ImageView) butterknife.c.a.c(view, R.id.my_comment2_listview_item_start, "field 'myComment2ListviewItemStart'", ImageView.class);
        myComment2ListViewAdapter$ViewHolder.myComment2ListviewItemTime = (TextView) butterknife.c.a.c(view, R.id.my_comment2_listview_item_time, "field 'myComment2ListviewItemTime'", TextView.class);
        myComment2ListViewAdapter$ViewHolder.myComment2ListviewItemGameLayout = (LinearLayout) butterknife.c.a.c(view, R.id.my_comment2_listview_item_game_layout, "field 'myComment2ListviewItemGameLayout'", LinearLayout.class);
        myComment2ListViewAdapter$ViewHolder.myComment2ListviewItemAddLy = (LinearLayout) butterknife.c.a.c(view, R.id.my_comment2_listview_item_add_ly, "field 'myComment2ListviewItemAddLy'", LinearLayout.class);
        myComment2ListViewAdapter$ViewHolder.myComment2ListviewItemContent1 = (TextView) butterknife.c.a.c(view, R.id.my_comment2_listview_item_content1, "field 'myComment2ListviewItemContent1'", TextView.class);
        myComment2ListViewAdapter$ViewHolder.myComment2ListviewItemContent2 = (TextView) butterknife.c.a.c(view, R.id.my_comment2_listview_item_content2, "field 'myComment2ListviewItemContent2'", TextView.class);
    }

    @CallSuper
    public void a() {
        MyComment2ListViewAdapter$ViewHolder myComment2ListViewAdapter$ViewHolder = this.b;
        if (myComment2ListViewAdapter$ViewHolder != null) {
            myComment2ListViewAdapter$ViewHolder.myComment2ListviewItemGameImg = null;
            myComment2ListViewAdapter$ViewHolder.myComment2ListviewItemGameName = null;
            myComment2ListViewAdapter$ViewHolder.myComment2ListviewItemStart = null;
            myComment2ListViewAdapter$ViewHolder.myComment2ListviewItemTime = null;
            myComment2ListViewAdapter$ViewHolder.myComment2ListviewItemGameLayout = null;
            myComment2ListViewAdapter$ViewHolder.myComment2ListviewItemAddLy = null;
            myComment2ListViewAdapter$ViewHolder.myComment2ListviewItemContent1 = null;
            myComment2ListViewAdapter$ViewHolder.myComment2ListviewItemContent2 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
