package com.rtk.app.main.coins;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.main.family.FamilyBaseActivity;
import java.util.ArrayList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ExchangeRecordsActivity extends FamilyBaseActivity {

    @BindView
    AutoListView autoListView;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initView() {
        super.initView();
        View inflate = LayoutInflater.from(this).inflate(R.layout.coins_exchange_records_list_item, (ViewGroup) null);
        new ExchangeRecordViewHolder(inflate);
        this.autoListView.addHeaderView(inflate);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new c("2025/06/08 10:20", "1", "20", "成功"));
        this.autoListView.setAdapter((ListAdapter) new d(this, arrayList));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_coins_exchange_records);
        ButterKnife.a(this);
    }
}
