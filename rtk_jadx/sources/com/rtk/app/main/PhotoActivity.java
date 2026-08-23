package com.rtk.app.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bluemobi.dylan.photoview.library.PhotoView;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PhotoActivity extends AppCompatActivity implements View.OnClickListener, com.rtk.app.base.f {
    private String a;
    private Activity b;

    @BindView
    PhotoView photoPhotoView;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        this.a = getIntent().getExtras().getString("imgPath");
        com.rtk.app.tool.c0.u("PhotoActivity", "图片地址" + this.a);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        com.rtk.app.tool.t.c(this.b, this.a, this.photoPhotoView, new boolean[0]);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        setContentView(R.layout.activity_photo);
        ButterKnife.a(this);
        this.b = this;
        initData();
        initView();
        initListener();
    }
}
