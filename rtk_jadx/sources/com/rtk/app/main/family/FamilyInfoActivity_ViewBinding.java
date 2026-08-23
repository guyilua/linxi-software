package com.rtk.app.main.family;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyInfoActivity_ViewBinding implements Unbinder {
    private FamilyInfoActivity b;

    @UiThread
    public FamilyInfoActivity_ViewBinding(FamilyInfoActivity familyInfoActivity, View view) {
        this.b = familyInfoActivity;
        familyInfoActivity.backLayout = butterknife.c.a.b(view, R.id.back_layout, "field 'backLayout'");
        familyInfoActivity.familyName = (TextView) butterknife.c.a.c(view, R.id.family_name, "field 'familyName'", TextView.class);
        familyInfoActivity.familyLogo = (RoundedImageView) butterknife.c.a.c(view, R.id.family_logo, "field 'familyLogo'", RoundedImageView.class);
        familyInfoActivity.leaders = (LinearLayout) butterknife.c.a.c(view, R.id.leaders, "field 'leaders'", LinearLayout.class);
        familyInfoActivity.familyMember = (TextView) butterknife.c.a.c(view, R.id.family_member, "field 'familyMember'", TextView.class);
        familyInfoActivity.familyNu = (TextView) butterknife.c.a.c(view, R.id.family_number, "field 'familyNu'", TextView.class);
        familyInfoActivity.familyIntroduce = (TextView) butterknife.c.a.c(view, R.id.family_introduce, "field 'familyIntroduce'", TextView.class);
        familyInfoActivity.familyCreateTime = (TextView) butterknife.c.a.c(view, R.id.family_create_time, "field 'familyCreateTime'", TextView.class);
        familyInfoActivity.joinFamily = (TextView) butterknife.c.a.c(view, R.id.join_family, "field 'joinFamily'", TextView.class);
        familyInfoActivity.familyGradientView = butterknife.c.a.b(view, R.id.family_gradient_view, "field 'familyGradientView'");
        familyInfoActivity.familyOpenType = (TextView) butterknife.c.a.c(view, R.id.family_open_type, "field 'familyOpenType'", TextView.class);
        familyInfoActivity.fuZuZhangImg1 = (RoundedImageView) butterknife.c.a.c(view, R.id.fu_zuzhang_img1, "field 'fuZuZhangImg1'", RoundedImageView.class);
        familyInfoActivity.fuZuZhangTV1 = (TextView) butterknife.c.a.c(view, R.id.fu_zuzhang_tv1, "field 'fuZuZhangTV1'", TextView.class);
        familyInfoActivity.fuZuZhangImg2 = (RoundedImageView) butterknife.c.a.c(view, R.id.fu_zuzhang_img2, "field 'fuZuZhangImg2'", RoundedImageView.class);
        familyInfoActivity.fuZuZhangTV2 = (TextView) butterknife.c.a.c(view, R.id.fu_zuzhang_tv2, "field 'fuZuZhangTV2'", TextView.class);
        familyInfoActivity.zuZhangImg = (RoundedImageView) butterknife.c.a.c(view, R.id.zuzhang_img, "field 'zuZhangImg'", RoundedImageView.class);
        familyInfoActivity.zuZhangTV = (TextView) butterknife.c.a.c(view, R.id.zuzhang_tv, "field 'zuZhangTV'", TextView.class);
        familyInfoActivity.familyJoinCoins = (TextView) butterknife.c.a.c(view, R.id.family_join_coins, "field 'familyJoinCoins'", TextView.class);
        familyInfoActivity.familyCover = (ImageView) butterknife.c.a.c(view, R.id.family_cover, "field 'familyCover'", ImageView.class);
    }

    @CallSuper
    public void a() {
        FamilyInfoActivity familyInfoActivity = this.b;
        if (familyInfoActivity != null) {
            this.b = null;
            familyInfoActivity.backLayout = null;
            familyInfoActivity.familyName = null;
            familyInfoActivity.familyLogo = null;
            familyInfoActivity.leaders = null;
            familyInfoActivity.familyMember = null;
            familyInfoActivity.familyNu = null;
            familyInfoActivity.familyIntroduce = null;
            familyInfoActivity.familyCreateTime = null;
            familyInfoActivity.joinFamily = null;
            familyInfoActivity.familyGradientView = null;
            familyInfoActivity.familyOpenType = null;
            familyInfoActivity.fuZuZhangImg1 = null;
            familyInfoActivity.fuZuZhangTV1 = null;
            familyInfoActivity.fuZuZhangImg2 = null;
            familyInfoActivity.fuZuZhangTV2 = null;
            familyInfoActivity.zuZhangImg = null;
            familyInfoActivity.zuZhangTV = null;
            familyInfoActivity.familyJoinCoins = null;
            familyInfoActivity.familyCover = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
