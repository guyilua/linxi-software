package com.rtk.app.main.Home5Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.MedalDetailBean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MedalDetailInformationFragment extends BaseFragment {

    @BindView
    TextView medalDetailItemDegree;

    @BindView
    ImageView medalDetailItemImg;

    @BindView
    TextView medalDetailItemName;

    @BindView
    TextView medalDetailItemNeed;

    @BindView
    TextView medalDetailItemTime;
    Unbinder o;
    private MedalDetailBean.DataBean p;

    @Override // com.rtk.app.base.BaseFragment
    protected void e() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        MedalDetailBean.DataBean dataBean = (MedalDetailBean.DataBean) getArguments().getSerializable("medal");
        this.p = dataBean;
        if (dataBean == null) {
            return;
        }
        com.rtk.app.tool.t.c(this.e, dataBean.getPic(), this.medalDetailItemImg, new boolean[0]);
        this.medalDetailItemName.setText(this.p.getTitle());
        this.medalDetailItemNeed.setText("");
        this.medalDetailItemDegree.setText(this.p.getDesc());
        this.medalDetailItemTime.setText(this.p.getAddtime());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = LayoutInflater.from(this.e).inflate(R.layout.medal_detail_item_layout, (ViewGroup) null);
            this.a = inflate;
            this.o = ButterKnife.b(this, inflate);
            b();
        } else {
            this.o = ButterKnife.b(this, view);
        }
        return this.a;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.o.a();
    }
}
