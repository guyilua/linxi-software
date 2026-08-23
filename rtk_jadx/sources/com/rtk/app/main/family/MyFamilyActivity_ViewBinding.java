package com.rtk.app.main.family;

import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.custom.BaseViewPager;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyFamilyActivity_ViewBinding implements Unbinder {
    private MyFamilyActivity b;

    @UiThread
    public MyFamilyActivity_ViewBinding(MyFamilyActivity myFamilyActivity, View view) {
        this.b = myFamilyActivity;
        myFamilyActivity.publish = (ImageView) butterknife.c.a.c(view, R.id.family_publish_something, "field 'publish'", ImageView.class);
        myFamilyActivity.gridView = (GridView) butterknife.c.a.c(view, R.id.gridView, "field 'gridView'", GridView.class);
        myFamilyActivity.homePageItemAttentionTab = (TabLayout) butterknife.c.a.c(view, R.id.home_page_item_attention_tab, "field 'homePageItemAttentionTab'", TabLayout.class);
        myFamilyActivity.homePageItemAttentionViewPager = (BaseViewPager) butterknife.c.a.c(view, R.id.home_page_item_attention_viewPager, "field 'homePageItemAttentionViewPager'", BaseViewPager.class);
        myFamilyActivity.manager = butterknife.c.a.b(view, R.id.manager_layout, "field 'manager'");
        myFamilyActivity.familyCover = (ImageView) butterknife.c.a.c(view, R.id.family_cover, "field 'familyCover'", ImageView.class);
        myFamilyActivity.familyNotice = (TextView) butterknife.c.a.c(view, R.id.family_introduce, "field 'familyNotice'", TextView.class);
        myFamilyActivity.familyIntroduceLayout = (LinearLayout) butterknife.c.a.c(view, R.id.family_introduce_layout, "field 'familyIntroduceLayout'", LinearLayout.class);
        myFamilyActivity.familySn = (TextView) butterknife.c.a.c(view, R.id.family_sn, "field 'familySn'", TextView.class);
        myFamilyActivity.familyLogo = (RoundedImageView) butterknife.c.a.c(view, R.id.family_logo, "field 'familyLogo'", RoundedImageView.class);
        myFamilyActivity.familyName = (TextView) butterknife.c.a.c(view, R.id.family_name, "field 'familyName'", TextView.class);
        myFamilyActivity.familyMemberNu = (TextView) butterknife.c.a.c(view, R.id.family_member_nu, "field 'familyMemberNu'", TextView.class);
        myFamilyActivity.familyMore = butterknife.c.a.b(view, R.id.family_more, "field 'familyMore'");
        myFamilyActivity.familyGradientView = butterknife.c.a.b(view, R.id.family_gradient_view, "field 'familyGradientView'");
        myFamilyActivity.title = (TextView) butterknife.c.a.c(view, R.id.backTV, "field 'title'", TextView.class);
        myFamilyActivity.appBar = (AppBarLayout) butterknife.c.a.c(view, R.id.app_bar, "field 'appBar'", AppBarLayout.class);
        myFamilyActivity.familyDynamicsLayout = butterknife.c.a.b(view, R.id.family_dynamics_layout, "field 'familyDynamicsLayout'");
        myFamilyActivity.familyIntroduceOpen = (TextView) butterknife.c.a.c(view, R.id.family_introduce_open, "field 'familyIntroduceOpen'", TextView.class);
        myFamilyActivity.managerMessageNum = (TextView) butterknife.c.a.c(view, R.id.manager_massage_num, "field 'managerMessageNum'", TextView.class);
        myFamilyActivity.messageNum = (TextView) butterknife.c.a.c(view, R.id.message_num, "field 'messageNum'", TextView.class);
        myFamilyActivity.messageLayout = butterknife.c.a.b(view, R.id.message_layout, "field 'messageLayout'");
        myFamilyActivity.backLayout = butterknife.c.a.b(view, R.id.back_layout, "field 'backLayout'");
        myFamilyActivity.parent = (ViewGroup) butterknife.c.a.c(view, 2131299707, "field 'parent'", ViewGroup.class);
    }

    @CallSuper
    public void a() {
        MyFamilyActivity myFamilyActivity = this.b;
        if (myFamilyActivity != null) {
            this.b = null;
            myFamilyActivity.publish = null;
            myFamilyActivity.gridView = null;
            myFamilyActivity.homePageItemAttentionTab = null;
            myFamilyActivity.homePageItemAttentionViewPager = null;
            myFamilyActivity.manager = null;
            myFamilyActivity.familyCover = null;
            myFamilyActivity.familyNotice = null;
            myFamilyActivity.familyIntroduceLayout = null;
            myFamilyActivity.familySn = null;
            myFamilyActivity.familyLogo = null;
            myFamilyActivity.familyName = null;
            myFamilyActivity.familyMemberNu = null;
            myFamilyActivity.familyMore = null;
            myFamilyActivity.familyGradientView = null;
            myFamilyActivity.title = null;
            myFamilyActivity.appBar = null;
            myFamilyActivity.familyDynamicsLayout = null;
            myFamilyActivity.familyIntroduceOpen = null;
            myFamilyActivity.managerMessageNum = null;
            myFamilyActivity.messageNum = null;
            myFamilyActivity.messageLayout = null;
            myFamilyActivity.backLayout = null;
            myFamilyActivity.parent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
