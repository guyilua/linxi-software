package com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsHolderClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.bean.PostDetailsBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsRecyclerViewAdapter;
import com.rtk.app.main.dialogPack.RewardListDialog;
import com.rtk.app.tool.t;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpAndRewardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener {
    private PostDetailsBean.DataBean a;
    private Context b;

    /* renamed from: c, reason: collision with root package name */
    private PostDetailsRecyclerViewAdapter.a f192c;

    @BindView
    public Spinner postDetailsRecyclerViewItemUpAndRewardArrangeType;

    @BindView
    public TextView postDetailsRecyclerViewItemUpAndRewardCommentNum;

    @BindView
    public LinearLayout postDetailsRecyclerViewItemUpAndRewardLv;

    @BindView
    public LinearLayout postDetailsRecyclerViewItemUpAndRewardLv2;

    @BindView
    public CustomTextView postDetailsRecyclerViewItemUpAndRewardNum;

    @BindView
    public CheckBox postDetailsRecyclerViewItemUpAndRewardOnlyMaster;

    @BindView
    public LinearLayout postDetailsRecyclerViewItemUpAndRewardUpLv;

    @BindView
    public LinearLayout postDetailsRecyclerViewItemUpAndRewardUpLv2;

    @BindView
    public TextView postDetailsRecyclerViewItemUpAndRewardUpNum;

    public UpAndRewardViewHolder(View view) {
        super(view);
        ButterKnife.b(this, view);
    }

    private void c() {
        this.postDetailsRecyclerViewItemUpAndRewardUpLv.removeAllViews();
        this.postDetailsRecyclerViewItemUpAndRewardLv.removeAllViews();
        for (int i = 0; i < this.a.getLikeList().size(); i++) {
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.post_details_reward_item_layout, (ViewGroup) null);
            t.c(this.b, this.a.getLikeList().get(i).getFace(), (ImageView) inflate.findViewById(R.id.post_details_reward_item_img), new boolean[0]);
            inflate.findViewById(R.id.post_details_reward_item_num).setVisibility(8);
            this.postDetailsRecyclerViewItemUpAndRewardUpLv.addView(inflate);
        }
        this.postDetailsRecyclerViewItemUpAndRewardUpLv.setVisibility(this.a.getLikeList().size() > 0 ? 0 : 8);
        this.postDetailsRecyclerViewItemUpAndRewardUpLv2.setVisibility(this.a.getLikeList().size() > 0 ? 0 : 8);
        this.postDetailsRecyclerViewItemUpAndRewardLv2.setVisibility(this.a.getRewardList().size() > 0 ? 0 : 8);
        this.postDetailsRecyclerViewItemUpAndRewardUpNum.setText("有" + this.a.getLikeNum() + "人赞过");
        for (int i2 = 0; i2 < this.a.getRewardList().size() && i2 < 6; i2++) {
            View inflate2 = LayoutInflater.from(this.b).inflate(R.layout.post_details_reward_item_layout, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate2.findViewById(R.id.post_details_reward_item_img);
            TextView textView = (TextView) inflate2.findViewById(R.id.post_details_reward_item_num);
            t.c(this.b, this.a.getRewardList().get(i2).getFace(), imageView, new boolean[0]);
            textView.setText(this.a.getRewardList().get(i2).getCoin());
            this.postDetailsRecyclerViewItemUpAndRewardLv.addView(inflate2);
        }
        this.postDetailsRecyclerViewItemUpAndRewardLv.setVisibility(this.a.getRewardList().size() <= 0 ? 8 : 0);
        this.postDetailsRecyclerViewItemUpAndRewardNum.setLeftText("共有" + this.a.getRewardNum() + "人打赏了");
        this.postDetailsRecyclerViewItemUpAndRewardNum.setRightText("金币");
        this.postDetailsRecyclerViewItemUpAndRewardNum.setText(" " + this.a.getCoinNum() + " ");
        this.postDetailsRecyclerViewItemUpAndRewardCommentNum.setText("全部回复(" + this.a.getCommentNum() + ")");
        this.postDetailsRecyclerViewItemUpAndRewardLv.setOnClickListener(this);
        this.postDetailsRecyclerViewItemUpAndRewardUpLv.setOnClickListener(this);
        this.postDetailsRecyclerViewItemUpAndRewardArrangeType.setOnItemSelectedListener(this);
        this.postDetailsRecyclerViewItemUpAndRewardOnlyMaster.setOnCheckedChangeListener(this);
    }

    public void b(Context context, PostDetailsBean.DataBean dataBean, PostDetailsRecyclerViewAdapter.a aVar) {
        this.b = context;
        this.a = dataBean;
        this.f192c = aVar;
        c();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        PostDetailsRecyclerViewAdapter.a aVar = this.f192c;
        if (aVar != null) {
            aVar.p(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131299829) {
            new RewardListDialog(this.b, this.a.getId(), "reward").show();
        } else {
            if (id != 2131299834) {
                return;
            }
            new RewardListDialog(this.b, this.a.getId(), "up").show();
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        PostDetailsRecyclerViewAdapter.a aVar = this.f192c;
        if (aVar != null) {
            aVar.n(i);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
