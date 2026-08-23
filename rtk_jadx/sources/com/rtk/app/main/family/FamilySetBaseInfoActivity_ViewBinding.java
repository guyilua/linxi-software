package com.rtk.app.main.family;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilySetBaseInfoActivity_ViewBinding implements Unbinder {
    private FamilySetBaseInfoActivity b;

    @UiThread
    public FamilySetBaseInfoActivity_ViewBinding(FamilySetBaseInfoActivity familySetBaseInfoActivity, View view) {
        this.b = familySetBaseInfoActivity;
        familySetBaseInfoActivity.familyLogoLayout = butterknife.c.a.b(view, R.id.family_logo_layout, "field 'familyLogoLayout'");
        familySetBaseInfoActivity.familyLogo = (RoundedImageView) butterknife.c.a.c(view, R.id.logo, "field 'familyLogo'", RoundedImageView.class);
        familySetBaseInfoActivity.familyCover = (ImageView) butterknife.c.a.c(view, R.id.family_cover, "field 'familyCover'", ImageView.class);
        familySetBaseInfoActivity.familyCoverLayout = butterknife.c.a.b(view, R.id.family_cover_layout, "field 'familyCoverLayout'");
        familySetBaseInfoActivity.familyName = (TextView) butterknife.c.a.c(view, R.id.family_name, "field 'familyName'", TextView.class);
        familySetBaseInfoActivity.familyNameLayout = butterknife.c.a.b(view, R.id.family_name_layout, "field 'familyNameLayout'");
        familySetBaseInfoActivity.setJoinNeedMoneyLayout = butterknife.c.a.b(view, R.id.set_join_need_money_layout, "field 'setJoinNeedMoneyLayout'");
        familySetBaseInfoActivity.setJoinNeedMoney = (TextView) butterknife.c.a.c(view, R.id.set_join_need_money, "field 'setJoinNeedMoney'", TextView.class);
        familySetBaseInfoActivity.setNoticeLayout = butterknife.c.a.b(view, R.id.set_notice_layout, "field 'setNoticeLayout'");
        familySetBaseInfoActivity.setNotice = (TextView) butterknife.c.a.c(view, R.id.set_notice, "field 'setNotice'", TextView.class);
        familySetBaseInfoActivity.setIntroLayout = butterknife.c.a.b(view, R.id.set_intro_layout, "field 'setIntroLayout'");
        familySetBaseInfoActivity.setIntro = (TextView) butterknife.c.a.c(view, R.id.set_intro, "field 'setIntro'", TextView.class);
        familySetBaseInfoActivity.setOpenStateLayout = butterknife.c.a.b(view, R.id.set_open_state_layout, "field 'setOpenStateLayout'");
        familySetBaseInfoActivity.setOpenState = (TextView) butterknife.c.a.c(view, R.id.set_open_state, "field 'setOpenState'", TextView.class);
        familySetBaseInfoActivity.backLayout = butterknife.c.a.b(view, R.id.back_layout, "field 'backLayout'");
    }

    @CallSuper
    public void a() {
        FamilySetBaseInfoActivity familySetBaseInfoActivity = this.b;
        if (familySetBaseInfoActivity != null) {
            this.b = null;
            familySetBaseInfoActivity.familyLogoLayout = null;
            familySetBaseInfoActivity.familyLogo = null;
            familySetBaseInfoActivity.familyCover = null;
            familySetBaseInfoActivity.familyCoverLayout = null;
            familySetBaseInfoActivity.familyName = null;
            familySetBaseInfoActivity.familyNameLayout = null;
            familySetBaseInfoActivity.setJoinNeedMoneyLayout = null;
            familySetBaseInfoActivity.setJoinNeedMoney = null;
            familySetBaseInfoActivity.setNoticeLayout = null;
            familySetBaseInfoActivity.setNotice = null;
            familySetBaseInfoActivity.setIntroLayout = null;
            familySetBaseInfoActivity.setIntro = null;
            familySetBaseInfoActivity.setOpenStateLayout = null;
            familySetBaseInfoActivity.setOpenState = null;
            familySetBaseInfoActivity.backLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
