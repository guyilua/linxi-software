package com.rtk.app.main;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.uc.crashsdk.export.LogType;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ThemeSwitchHelpActivity extends AppCompatActivity {
    private Context a;
    Handler b = new a();

    /* renamed from: c, reason: collision with root package name */
    private int f213c;

    @BindView
    ImageView themSwitchDownImg;

    @BindView
    ImageView themSwitchMoomDownImg;

    @BindView
    ImageView themSwitchMoomTopImg;

    @BindView
    ImageView themSwitchTopImg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    return;
                }
                ThemeSwitchHelpActivity.this.finish();
                return;
            }
            if (ThemeSwitchHelpActivity.this.f213c % 27 != 0 || ThemeSwitchHelpActivity.this.f213c == 0) {
                ThemeSwitchHelpActivity.this.f213c = 27;
                com.rtk.app.tool.y.S(false, null);
            } else {
                ThemeSwitchHelpActivity.this.f213c = 1;
                com.rtk.app.tool.y.S(true, null);
            }
            com.rtk.app.tool.v.f(ThemeSwitchHelpActivity.this.a, "THEME", ThemeSwitchHelpActivity.this.f213c);
            ThemeSwitchHelpActivity.this.b.sendEmptyMessage(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ThemeSwitchHelpActivity.this.b.sendEmptyMessage(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    private void initData() {
        int b2 = com.rtk.app.tool.v.b(this.a, "THEME") % 28;
        this.f213c = b2;
        if (b2 % 27 == 0 && b2 != 0) {
            this.themSwitchTopImg.setImageResource(R.mipmap.day_background_top);
            this.themSwitchDownImg.setImageResource(R.mipmap.day_background_buttom);
            this.themSwitchMoomTopImg.setImageResource(R.mipmap.day_background_moon);
            this.themSwitchMoomDownImg.setImageResource(R.mipmap.day_background_moon_shadow);
            return;
        }
        this.themSwitchTopImg.setImageResource(R.mipmap.night_background_top);
        this.themSwitchDownImg.setImageResource(R.mipmap.night_background_buttom);
        this.themSwitchMoomTopImg.setImageResource(R.mipmap.night_background_moon);
        this.themSwitchMoomDownImg.setImageResource(R.mipmap.night_background_moon_shadow);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.theme_top_anim);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this, R.anim.theme_down_anim);
        this.themSwitchMoomTopImg.setAnimation(loadAnimation);
        this.themSwitchMoomDownImg.setAnimation(loadAnimation2);
        loadAnimation.setAnimationListener(new b());
        loadAnimation.start();
        loadAnimation2.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
        super/*android.app.Activity*/.finish();
    }

    public void onBackPressed() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(LogType.UNEXP_ANR);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
        setContentView(R.layout.activity_theme_switch);
        ButterKnife.a(this);
        this.a = this;
        initData();
        initView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onPause() {
        super/*androidx.fragment.app.FragmentActivity*/.onPause();
        overridePendingTransition(0, R.anim.hid_anim);
    }
}
