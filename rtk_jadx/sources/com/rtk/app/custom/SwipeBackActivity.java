package com.rtk.app.custom;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.rtk.app.R;
import com.rtk.app.tool.c0;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SwipeBackActivity extends AppCompatActivity {
    protected SwipeBackLayout a;

    /* JADX WARN: Multi-variable type inference failed */
    public void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        overridePendingTransition(0, R.anim.base_slide_right_out);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        SwipeBackLayout swipeBackLayout = (SwipeBackLayout) LayoutInflater.from(this).inflate(R.layout.base, (ViewGroup) null);
        this.a = swipeBackLayout;
        swipeBackLayout.a(this);
        MyHorizontalScrollView.b = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void onPause() {
        super/*androidx.fragment.app.FragmentActivity*/.onPause();
        overridePendingTransition(0, R.anim.base_slide_right_out);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    public boolean q() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startActivity(Intent intent) {
        try {
            super/*android.app.Activity*/.startActivity(intent);
        } catch (Exception e) {
            c0.s("SwipeBackActivity", e.getMessage());
        }
        overridePendingTransition(R.anim.base_slide_right_in, R.anim.base_slide_remain);
    }
}
