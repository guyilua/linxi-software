package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.custom.YcSwipeRefreshLayout;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AccountSecurityActivity_ViewBinding implements Unbinder {
    private AccountSecurityActivity b;

    @UiThread
    public AccountSecurityActivity_ViewBinding(AccountSecurityActivity accountSecurityActivity, View view) {
        this.b = accountSecurityActivity;
        accountSecurityActivity.accountSecurityTopBack = (TextView) butterknife.c.a.c(view, R.id.account_security_topBack, "field 'accountSecurityTopBack'", TextView.class);
        accountSecurityActivity.accountSecurityTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.account_security_topLayout, "field 'accountSecurityTopLayout'", LinearLayout.class);
        accountSecurityActivity.accountSecurityLogo = (RoundedImageView) butterknife.c.a.c(view, R.id.account_security_logo, "field 'accountSecurityLogo'", RoundedImageView.class);
        accountSecurityActivity.accountSecurityNickName = (TextView) butterknife.c.a.c(view, R.id.account_security_nickName, "field 'accountSecurityNickName'", TextView.class);
        accountSecurityActivity.accountSecurityRegisterTime = (TextView) butterknife.c.a.c(view, R.id.account_security_register_time, "field 'accountSecurityRegisterTime'", TextView.class);
        accountSecurityActivity.accountSecurityUpdataPsw = (TextView) butterknife.c.a.c(view, R.id.account_security_updata_psw, "field 'accountSecurityUpdataPsw'", TextView.class);
        accountSecurityActivity.accountSecurityPhone = (TextView) butterknife.c.a.c(view, R.id.account_security_phone, "field 'accountSecurityPhone'", TextView.class);
        accountSecurityActivity.accountSecurityBoundPhone = (TextView) butterknife.c.a.c(view, R.id.account_security_boundPhone, "field 'accountSecurityBoundPhone'", TextView.class);
        accountSecurityActivity.accountSecurityQQFace = (ImageView) butterknife.c.a.c(view, R.id.account_security_QQ_face, "field 'accountSecurityQQFace'", ImageView.class);
        accountSecurityActivity.accountSecurityQQ = (TextView) butterknife.c.a.c(view, R.id.account_security_QQ, "field 'accountSecurityQQ'", TextView.class);
        accountSecurityActivity.accountSecurityBoundQQLv = (LinearLayout) butterknife.c.a.c(view, R.id.account_security_bound_QQ_lv, "field 'accountSecurityBoundQQLv'", LinearLayout.class);
        accountSecurityActivity.accountSecurityWFace = (ImageView) butterknife.c.a.c(view, R.id.account_security_w_face, "field 'accountSecurityWFace'", ImageView.class);
        accountSecurityActivity.accountSecurityWechat = (TextView) butterknife.c.a.c(view, R.id.account_security_wechat, "field 'accountSecurityWechat'", TextView.class);
        accountSecurityActivity.accountSecurityWechatLv = (LinearLayout) butterknife.c.a.c(view, R.id.account_security_wechat_lv, "field 'accountSecurityWechatLv'", LinearLayout.class);
        accountSecurityActivity.accountSecuritySignature = (TextView) butterknife.c.a.c(view, R.id.account_security_signature, "field 'accountSecuritySignature'", TextView.class);
        accountSecurityActivity.accountSecurityHeadLv = (LinearLayout) butterknife.c.a.c(view, R.id.account_security_head_lv, "field 'accountSecurityHeadLv'", LinearLayout.class);
        accountSecurityActivity.accountSecurityRefreshLayout = (YcSwipeRefreshLayout) butterknife.c.a.c(view, R.id.account_security_refreshLayout, "field 'accountSecurityRefreshLayout'", YcSwipeRefreshLayout.class);
    }

    @CallSuper
    public void a() {
        AccountSecurityActivity accountSecurityActivity = this.b;
        if (accountSecurityActivity != null) {
            this.b = null;
            accountSecurityActivity.accountSecurityTopBack = null;
            accountSecurityActivity.accountSecurityTopLayout = null;
            accountSecurityActivity.accountSecurityLogo = null;
            accountSecurityActivity.accountSecurityNickName = null;
            accountSecurityActivity.accountSecurityRegisterTime = null;
            accountSecurityActivity.accountSecurityUpdataPsw = null;
            accountSecurityActivity.accountSecurityPhone = null;
            accountSecurityActivity.accountSecurityBoundPhone = null;
            accountSecurityActivity.accountSecurityQQFace = null;
            accountSecurityActivity.accountSecurityQQ = null;
            accountSecurityActivity.accountSecurityBoundQQLv = null;
            accountSecurityActivity.accountSecurityWFace = null;
            accountSecurityActivity.accountSecurityWechat = null;
            accountSecurityActivity.accountSecurityWechatLv = null;
            accountSecurityActivity.accountSecuritySignature = null;
            accountSecurityActivity.accountSecurityHeadLv = null;
            accountSecurityActivity.accountSecurityRefreshLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
