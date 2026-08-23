package com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsHolderClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.bean.FamilyBean;
import com.rtk.app.bean.HomeCommunityBean;
import com.rtk.app.bean.PostDetailsBean;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TitleHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private Context a;
    private PostDetailsBean.DataBean b;

    @BindView
    public RoundedImageView postDetailsRecyclerViewItemIcon;

    @BindView
    public RelativeLayout postDetailsRecyclerViewItemInformationLv;

    @BindView
    public TextView postDetailsRecyclerViewItemIsModerator;

    @BindView
    public TextView postDetailsRecyclerViewItemNickName;

    @BindView
    public TextView postDetailsRecyclerViewItemSex;

    @BindView
    public TextView postDetailsRecyclerViewItemTime;

    @BindView
    public TextView postDetailsRecyclerViewItemTimeShareUrl;

    @BindView
    public TextView postDetailsRecyclerViewItemTitle;

    @BindView
    public TextView postDetailsRecyclerViewItemTitleCommentNum;

    @BindView
    public TextView postDetailsRecyclerViewItemTitlePlate;

    @BindView
    public TextView postDetailsRecyclerViewItemTitleUpNum;

    @BindView
    public TextView postDetailsRecyclerViewItemTitleViewNum;

    @BindView
    public LinearLayout postDetailsRecyclerviewItemMedal;

    public TitleHolder(View view) {
        super(view);
        ButterKnife.b(this, view);
    }

    public void b(Context context, PostDetailsBean.DataBean dataBean) {
        this.a = context;
        this.b = dataBean;
        c();
    }

    public void c() {
        t.U1(this.postDetailsRecyclerViewItemTitle, this.b.getTitle(), this.b.getPost_title());
        this.postDetailsRecyclerViewItemNickName.setText(this.b.getPostsBase().getNickname());
        this.postDetailsRecyclerViewItemSex.setText(this.b.getPostsBase().getAge() + "");
        this.postDetailsRecyclerViewItemSex.setSelected(this.b.getPostsBase().getSex().endsWith("1"));
        this.postDetailsRecyclerViewItemTitleViewNum.setText(this.b.getClickNum());
        this.postDetailsRecyclerViewItemTitleViewNum.setVisibility(y.f335c ? 0 : 8);
        this.postDetailsRecyclerViewItemTitleUpNum.setText(this.b.getLikeNum());
        this.postDetailsRecyclerViewItemTitleCommentNum.setText(this.b.getCommentNum());
        this.postDetailsRecyclerViewItemTitlePlate.setText(this.b.getName() + ">");
        this.postDetailsRecyclerViewItemTime.setText(this.b.getAddtime());
        t.T1(this.postDetailsRecyclerViewItemIsModerator, "", this.b.getPostsBase().getUser_title(), 5, 5);
        t.c(this.a, this.b.getFace(), this.postDetailsRecyclerViewItemIcon, new boolean[0]);
        HomeCommunityBean.DataBean dataBean = new HomeCommunityBean.DataBean();
        dataBean.setTags(this.b.getTags());
        dataBean.setId(this.b.getMid());
        dataBean.setName(this.b.getName());
        this.postDetailsRecyclerViewItemInformationLv.setOnClickListener(this);
        this.postDetailsRecyclerViewItemTitlePlate.setOnClickListener(this);
        this.postDetailsRecyclerViewItemTimeShareUrl.setOnClickListener(this);
        this.postDetailsRecyclerViewItemIcon.setOnClickListener(this);
        this.postDetailsRecyclerviewItemMedal.removeAllViews();
        for (int i = 0; i < 5; i++) {
            this.postDetailsRecyclerviewItemMedal.addView(LayoutInflater.from(this.a).inflate(R.layout.medal_small_layout, (ViewGroup) this.postDetailsRecyclerviewItemMedal, false));
        }
        t.p1(this.a, this.postDetailsRecyclerviewItemMedal, this.b.getPostsBase().getMedalList().getAchievement(), this.b.getPostsBase().getMedalList().getEventMedal());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.post_details_recyclerView_item_icon /* 2131299813 */:
            case R.id.post_details_recyclerView_item_imformation_lv /* 2131299814 */:
                t.B0(this.a, this.b.getUid());
                return;
            case R.id.post_details_recyclerView_item_title_plate /* 2131299823 */:
                FamilyBean family = this.b.getFamily();
                String str = null;
                if (family != null) {
                    str = family.getFamily_id() + "";
                }
                t.I0(this.a, this.b.getName(), "", this.b.getMid(), str);
                return;
            case R.id.post_details_recyclerView_item_title_share_url /* 2131299824 */:
                t.I1(this.a, "http://a.ruansky.com/posts/" + (c0.n(this.b.getId()) + 1111110) + "/");
                return;
            default:
                return;
        }
    }
}
