package com.rtk.app.main.login;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.custom.MyHorizontalScrollView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class InformationActivity_ViewBinding implements Unbinder {
    private InformationActivity b;

    @UiThread
    public InformationActivity_ViewBinding(InformationActivity informationActivity, View view) {
        this.b = informationActivity;
        informationActivity.informationTopBack = (TextView) butterknife.c.a.c(view, R.id.information_top_back, "field 'informationTopBack'", TextView.class);
        informationActivity.informationTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.information_top_layout, "field 'informationTopLayout'", LinearLayout.class);
        informationActivity.informationIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.information_icon, "field 'informationIcon'", RoundedImageView.class);
        informationActivity.informationSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.information_swipeRefresh, "field 'informationSwipeRefresh'", SwipeRefreshLayout.class);
        informationActivity.informationIconLayout = (RelativeLayout) butterknife.c.a.c(view, R.id.information_icon_layout, "field 'informationIconLayout'", RelativeLayout.class);
        informationActivity.informationIconLayoutAuditState = (TextView) butterknife.c.a.c(view, R.id.information_icon_audit_state, "field 'informationIconLayoutAuditState'", TextView.class);
        informationActivity.informationName = (TextView) butterknife.c.a.c(view, R.id.information_name, "field 'informationName'", TextView.class);
        informationActivity.informationRtkUidLayout = (LinearLayout) butterknife.c.a.c(view, R.id.information_rtk_uid_layout, "field 'informationRtkUidLayout'", LinearLayout.class);
        informationActivity.informationRtkUid = (TextView) butterknife.c.a.c(view, R.id.information_rtk_uid, "field 'informationRtkUid'", TextView.class);
        informationActivity.informationNameLayout = (LinearLayout) butterknife.c.a.c(view, R.id.information_name_layout, "field 'informationNameLayout'", LinearLayout.class);
        informationActivity.informationSex = (TextView) butterknife.c.a.c(view, R.id.information_sex, "field 'informationSex'", TextView.class);
        informationActivity.informationSexLayout = (LinearLayout) butterknife.c.a.c(view, R.id.information_sex_layout, "field 'informationSexLayout'", LinearLayout.class);
        informationActivity.informationBirthday = (TextView) butterknife.c.a.c(view, R.id.information_birthday, "field 'informationBirthday'", TextView.class);
        informationActivity.informationBirthdayLayout = (LinearLayout) butterknife.c.a.c(view, R.id.information_birthday_layout, "field 'informationBirthdayLayout'", LinearLayout.class);
        informationActivity.informationIntro = (TextView) butterknife.c.a.c(view, R.id.information_intro, "field 'informationIntro'", TextView.class);
        informationActivity.informationIntroLayout = (LinearLayout) butterknife.c.a.c(view, R.id.information_intro_layout, "field 'informationIntroLayout'", LinearLayout.class);
        informationActivity.informationUpdataPsw = (TextView) butterknife.c.a.c(view, R.id.information_updataPsw, "field 'informationUpdataPsw'", TextView.class);
        informationActivity.informationLoginOut = (TextView) butterknife.c.a.c(view, R.id.information_loginOut, "field 'informationLoginOut'", TextView.class);
        informationActivity.informationPhotoAlbumNum = (CustomTextView) butterknife.c.a.c(view, R.id.information_photo_album_num, "field 'informationPhotoAlbumNum'", CustomTextView.class);
        informationActivity.informationPhotoAlbumLv = (LinearLayout) butterknife.c.a.c(view, R.id.information_photo_album_lv, "field 'informationPhotoAlbumLv'", LinearLayout.class);
        informationActivity.informationPictureLv = (LinearLayout) butterknife.c.a.c(view, R.id.information_picture_lv, "field 'informationPictureLv'", LinearLayout.class);
        informationActivity.informationPictureSV = (MyHorizontalScrollView) butterknife.c.a.c(view, R.id.information_picture_SV, "field 'informationPictureSV'", MyHorizontalScrollView.class);
        informationActivity.informationEmptyPictureLv = (LinearLayout) butterknife.c.a.c(view, R.id.information_empty_picture_lv, "field 'informationEmptyPictureLv'", LinearLayout.class);
        informationActivity.informationBoundQQ = (TextView) butterknife.c.a.c(view, R.id.information_bound_QQ, "field 'informationBoundQQ'", TextView.class);
        informationActivity.informationBoundQQLv = (LinearLayout) butterknife.c.a.c(view, R.id.information_bound_QQ_lv, "field 'informationBoundQQLv'", LinearLayout.class);
        informationActivity.informationBoundWechat = (TextView) butterknife.c.a.c(view, R.id.information_bound_wechat, "field 'informationBoundWechat'", TextView.class);
        informationActivity.informationBoundWechatLv = (LinearLayout) butterknife.c.a.c(view, R.id.information_bound_wechat_lv, "field 'informationBoundWechatLv'", LinearLayout.class);
        informationActivity.informationBoundQQFace = (ImageView) butterknife.c.a.c(view, R.id.information_bound_QQ_face, "field 'informationBoundQQFace'", ImageView.class);
        informationActivity.informationBoundWFace = (ImageView) butterknife.c.a.c(view, R.id.information_bound_w_face, "field 'informationBoundWFace'", ImageView.class);
    }

    @CallSuper
    public void a() {
        InformationActivity informationActivity = this.b;
        if (informationActivity != null) {
            this.b = null;
            informationActivity.informationTopBack = null;
            informationActivity.informationTopLayout = null;
            informationActivity.informationIcon = null;
            informationActivity.informationSwipeRefresh = null;
            informationActivity.informationIconLayout = null;
            informationActivity.informationIconLayoutAuditState = null;
            informationActivity.informationName = null;
            informationActivity.informationRtkUidLayout = null;
            informationActivity.informationRtkUid = null;
            informationActivity.informationNameLayout = null;
            informationActivity.informationSex = null;
            informationActivity.informationSexLayout = null;
            informationActivity.informationBirthday = null;
            informationActivity.informationBirthdayLayout = null;
            informationActivity.informationIntro = null;
            informationActivity.informationIntroLayout = null;
            informationActivity.informationUpdataPsw = null;
            informationActivity.informationLoginOut = null;
            informationActivity.informationPhotoAlbumNum = null;
            informationActivity.informationPhotoAlbumLv = null;
            informationActivity.informationPictureLv = null;
            informationActivity.informationPictureSV = null;
            informationActivity.informationEmptyPictureLv = null;
            informationActivity.informationBoundQQ = null;
            informationActivity.informationBoundQQLv = null;
            informationActivity.informationBoundWechat = null;
            informationActivity.informationBoundWechatLv = null;
            informationActivity.informationBoundQQFace = null;
            informationActivity.informationBoundWFace = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
