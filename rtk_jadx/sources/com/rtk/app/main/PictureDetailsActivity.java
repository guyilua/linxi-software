package com.rtk.app.main;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.luck.picture.lib.photoview.PhotoView;
import com.rtk.app.R;
import com.rtk.app.adapter.ViewPagerAdapter;
import com.rtk.app.main.dialogPack.DialogPermision;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PictureDetailsActivity extends AppCompatActivity implements View.OnClickListener, com.rtk.app.base.f {
    private List<String> a;
    private String b;

    /* renamed from: c, reason: collision with root package name */
    private int f211c;
    private Context d;

    @BindView
    TextView pictureDetailsNum;

    @BindView
    ViewPager pictureDetailsViewpager;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.rtk.app.tool.c.a((Activity) PictureDetailsActivity.this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements View.OnLongClickListener {
        b(PictureDetailsActivity pictureDetailsActivity) {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            com.rtk.app.tool.c0.u("PictureDetailsActivity", "保存图片");
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class c implements ViewPager.OnPageChangeListener {
        c() {
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            PictureDetailsActivity.this.pictureDetailsNum.setText((i + 1) + "/" + PictureDetailsActivity.this.a.size());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        ArrayList<String> stringArrayList = extras.getStringArrayList("list");
        this.a = stringArrayList;
        if (stringArrayList == null) {
            this.a = new ArrayList();
        }
        this.b = extras.getString("nowPicture");
        for (int i = 0; i < this.a.size(); i++) {
            if (this.a.get(i).equals(this.b)) {
                this.pictureDetailsNum.setText((i + 1) + "/" + this.a.size());
                this.f211c = i;
                return;
            }
        }
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.pictureDetailsViewpager.setOnPageChangeListener(new c());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        ImageView photoView;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.a.size(); i++) {
            if (this.a.get(i).contains(".gif?")) {
                photoView = new ImageView(this.d);
            } else {
                photoView = new PhotoView(this.d);
            }
            photoView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            com.rtk.app.tool.c0.u("PictureDetailsActivity", "PictureDetails图片地址  " + this.a.get(i));
            com.rtk.app.tool.t.c(this.d, this.a.get(i), photoView, new boolean[0]);
            arrayList.add(photoView);
            photoView.setOnClickListener(new a());
            photoView.setOnLongClickListener(new b(this));
        }
        this.pictureDetailsViewpager.setAdapter(new ViewPagerAdapter(arrayList));
        this.pictureDetailsViewpager.setCurrentItem(this.f211c);
        this.pictureDetailsNum.setText((this.f211c + 1) + "/" + this.a.size());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.picture_details_close /* 2131299723 */:
                finish();
                return;
            case R.id.picture_details_download /* 2131299724 */:
                if (com.rtk.app.tool.r.b(this.d)) {
                    com.rtk.app.tool.t.u(this.d, this.a.get(this.pictureDetailsViewpager.getCurrentItem()));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        setContentView(R.layout.activity_picture_details);
        ButterKnife.a(this);
        this.d = this;
        initData();
        initView();
        initListener();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super/*androidx.fragment.app.FragmentActivity*/.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 10000) {
            return;
        }
        for (int i2 : iArr) {
            if (i2 != 0) {
                DialogPermision dialogPermision = new DialogPermision(this.d, com.rtk.app.tool.t.U(this));
                dialogPermision.d();
                dialogPermision.show();
                return;
            }
        }
        int currentItem = this.pictureDetailsViewpager.getCurrentItem();
        this.d = this;
        com.rtk.app.tool.t.u(this, this.a.get(currentItem));
    }
}
