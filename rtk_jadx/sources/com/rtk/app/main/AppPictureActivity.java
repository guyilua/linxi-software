package com.rtk.app.main;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bluemobi.dylan.photoview.library.PhotoView;
import com.rtk.app.R;
import com.rtk.app.adapter.ViewPagerAdapter;
import com.rtk.app.bean.GameDetailsBean;
import com.rtk.app.custom.SwipeBackActivity;
import com.rtk.app.main.dialogPack.DialogPermision;
import com.uc.crashsdk.export.LogType;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AppPictureActivity extends SwipeBackActivity implements View.OnClickListener {

    @BindView
    RelativeLayout activityAppPicture;

    @BindView
    TextView appPictureIndex;

    @BindView
    ViewPager appPictureViewpager;

    /* renamed from: c, reason: collision with root package name */
    private Activity f178c;
    private GameDetailsBean d;
    private List<View> b = new ArrayList();
    private int e = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.rtk.app.tool.c.a(AppPictureActivity.this.f178c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements ViewPager.OnPageChangeListener {
        b() {
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            AppPictureActivity.this.appPictureIndex.setText((i + 1) + "/" + AppPictureActivity.this.d.getData().getGame_pic_list().size());
        }
    }

    private void t() {
        this.appPictureViewpager.setOnPageChangeListener(new b());
    }

    private void u() {
        ImageView photoView;
        for (int i = 0; i < this.d.getData().getGame_pic_list().size(); i++) {
            if (this.d.getData().getGame_pic_list().get(i).endsWith(".gif")) {
                photoView = new ImageView(this.f178c);
            } else {
                photoView = new PhotoView(this.f178c);
            }
            photoView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            com.rtk.app.tool.t.c(this.f178c, this.d.getData().getGame_pic_list().get(i), photoView, new boolean[0]);
            this.b.add(photoView);
            photoView.setOnClickListener(new a());
        }
        this.appPictureViewpager.setAdapter(new ViewPagerAdapter(this.b));
        this.appPictureViewpager.setCurrentItem(this.e);
        this.appPictureIndex.setText((this.e + 1) + "/" + this.d.getData().getGame_pic_list().size());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.app_picture_close /* 2131296516 */:
                finish();
                return;
            case R.id.app_picture_download /* 2131296517 */:
                if (com.rtk.app.tool.r.b(this.f178c)) {
                    com.rtk.app.tool.t.u(this.f178c, this.d.getData().getGame_pic_list().get(this.appPictureViewpager.getCurrentItem()));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(LogType.UNEXP_ANR);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
        setContentView(R.layout.activity_app_picture);
        ButterKnife.a(this);
        this.f178c = this;
        this.d = (GameDetailsBean) getIntent().getExtras().getSerializable("APPPicture");
        this.e = getIntent().getExtras().getInt("position", 1);
        u();
        t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.custom.SwipeBackActivity
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this.f178c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super/*androidx.fragment.app.FragmentActivity*/.onRequestPermissionsResult(i, strArr, iArr);
        com.rtk.app.tool.c0.u("AppPictureActivity", "存储权限" + i);
        if (i != 10000) {
            return;
        }
        for (int i2 : iArr) {
            if (i2 != 0) {
                DialogPermision dialogPermision = new DialogPermision(this.f178c, com.rtk.app.tool.t.U(this));
                dialogPermision.d();
                dialogPermision.show();
                return;
            }
        }
        int currentItem = this.appPictureViewpager.getCurrentItem();
        this.f178c = this;
        com.rtk.app.tool.t.u(this, this.d.getData().getGame_pic_list().get(currentItem));
    }

    protected void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        MobclickAgent.onResume(this.f178c);
    }
}
