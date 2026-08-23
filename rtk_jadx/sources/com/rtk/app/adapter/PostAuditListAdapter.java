package com.rtk.app.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.base.BaseRecyclerViewAdapter;
import com.rtk.app.bean.CheckUser;
import com.rtk.app.bean.PostAuditListBean;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostAuditListAdapter extends BaseRecyclerViewAdapter {
    private String e;
    private Context f;
    private List<PostAuditListBean.DataBean> g;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class NoPictrueHolder extends RecyclerView.ViewHolder {
        private com.rtk.app.custom.c a;

        @BindView
        View auditInfo;

        @BindView
        TextView auditPostListItemAuditState;

        @BindView
        TextView auditPostListItemClickNum;

        @BindView
        TextView auditPostListItemCommentNum;

        @BindView
        TextView auditPostListItemContent;

        @BindView
        TextView auditPostListItemName;

        @BindView
        TextView auditPostListItemTime;

        @BindView
        TextView auditPostListItemUserName;
        View b;

        public NoPictrueHolder(View view, Context context) {
            super(view);
            ButterKnife.b(this, view);
            this.b = view;
            this.a = new com.rtk.app.custom.c(this.auditInfo, new WeakReference(context));
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class NoPictrueHolder_ViewBinding implements Unbinder {
        private NoPictrueHolder b;

        @UiThread
        public NoPictrueHolder_ViewBinding(NoPictrueHolder noPictrueHolder, View view) {
            this.b = noPictrueHolder;
            noPictrueHolder.auditPostListItemName = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_item_name, "field 'auditPostListItemName'", TextView.class);
            noPictrueHolder.auditPostListItemAuditState = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_no_pictrue_item_audit_state, "field 'auditPostListItemAuditState'", TextView.class);
            noPictrueHolder.auditPostListItemContent = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_item_content, "field 'auditPostListItemContent'", TextView.class);
            noPictrueHolder.auditPostListItemUserName = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_item_userName, "field 'auditPostListItemUserName'", TextView.class);
            noPictrueHolder.auditPostListItemCommentNum = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_item_commentNum, "field 'auditPostListItemCommentNum'", TextView.class);
            noPictrueHolder.auditPostListItemClickNum = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_item_clickNum, "field 'auditPostListItemClickNum'", TextView.class);
            noPictrueHolder.auditPostListItemTime = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_item_time, "field 'auditPostListItemTime'", TextView.class);
            noPictrueHolder.auditInfo = butterknife.c.a.b(view, R.id.audit_post_list_item_audit_info, "field 'auditInfo'");
        }

        @CallSuper
        public void a() {
            NoPictrueHolder noPictrueHolder = this.b;
            if (noPictrueHolder != null) {
                this.b = null;
                noPictrueHolder.auditPostListItemName = null;
                noPictrueHolder.auditPostListItemAuditState = null;
                noPictrueHolder.auditPostListItemContent = null;
                noPictrueHolder.auditPostListItemUserName = null;
                noPictrueHolder.auditPostListItemCommentNum = null;
                noPictrueHolder.auditPostListItemClickNum = null;
                noPictrueHolder.auditPostListItemTime = null;
                noPictrueHolder.auditInfo = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class OnePictrueHolder extends RecyclerView.ViewHolder {
        private com.rtk.app.custom.c a;

        @BindView
        View auditInfo;

        @BindView
        TextView auditPostListOnePictrueItemAuditState;

        @BindView
        TextView auditPostListOnePictrueItemAuthor;

        @BindView
        TextView auditPostListOnePictrueItemCommentNum;

        @BindView
        TextView auditPostListOnePictrueItemContent;

        @BindView
        ImageView auditPostListOnePictrueItemImg;

        @BindView
        TextView auditPostListOnePictrueItemImgNum;

        @BindView
        TextView auditPostListOnePictrueItemTime;

        @BindView
        TextView auditPostListOnePictrueItemTitle;

        @BindView
        TextView auditPostListOnePictrueItemViewNum;
        View b;

        OnePictrueHolder(View view, Context context) {
            super(view);
            ButterKnife.b(this, view);
            this.b = view;
            this.a = new com.rtk.app.custom.c(this.auditInfo, new WeakReference(context));
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class OnePictrueHolder_ViewBinding implements Unbinder {
        private OnePictrueHolder b;

        @UiThread
        public OnePictrueHolder_ViewBinding(OnePictrueHolder onePictrueHolder, View view) {
            this.b = onePictrueHolder;
            onePictrueHolder.auditPostListOnePictrueItemImg = (ImageView) butterknife.c.a.c(view, R.id.audit_post_list_one_pictrue_item_img, "field 'auditPostListOnePictrueItemImg'", ImageView.class);
            onePictrueHolder.auditPostListOnePictrueItemTitle = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_one_pictrue_item_title, "field 'auditPostListOnePictrueItemTitle'", TextView.class);
            onePictrueHolder.auditPostListOnePictrueItemContent = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_one_pictrue_item_content, "field 'auditPostListOnePictrueItemContent'", TextView.class);
            onePictrueHolder.auditPostListOnePictrueItemAuthor = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_one_pictrue_item_author, "field 'auditPostListOnePictrueItemAuthor'", TextView.class);
            onePictrueHolder.auditPostListOnePictrueItemCommentNum = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_one_pictrue_item_comment_num, "field 'auditPostListOnePictrueItemCommentNum'", TextView.class);
            onePictrueHolder.auditPostListOnePictrueItemViewNum = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_one_pictrue_item_viewNum, "field 'auditPostListOnePictrueItemViewNum'", TextView.class);
            onePictrueHolder.auditPostListOnePictrueItemAuditState = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_one_pictrue_item_audit_state, "field 'auditPostListOnePictrueItemAuditState'", TextView.class);
            onePictrueHolder.auditPostListOnePictrueItemTime = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_one_pictrue_item_time, "field 'auditPostListOnePictrueItemTime'", TextView.class);
            onePictrueHolder.auditPostListOnePictrueItemImgNum = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_one_pictrue_item_img_num, "field 'auditPostListOnePictrueItemImgNum'", TextView.class);
            onePictrueHolder.auditInfo = butterknife.c.a.b(view, R.id.audit_post_list_one_pictrue_item_audit_info, "field 'auditInfo'");
        }

        @CallSuper
        public void a() {
            OnePictrueHolder onePictrueHolder = this.b;
            if (onePictrueHolder != null) {
                this.b = null;
                onePictrueHolder.auditPostListOnePictrueItemImg = null;
                onePictrueHolder.auditPostListOnePictrueItemTitle = null;
                onePictrueHolder.auditPostListOnePictrueItemContent = null;
                onePictrueHolder.auditPostListOnePictrueItemAuthor = null;
                onePictrueHolder.auditPostListOnePictrueItemCommentNum = null;
                onePictrueHolder.auditPostListOnePictrueItemViewNum = null;
                onePictrueHolder.auditPostListOnePictrueItemAuditState = null;
                onePictrueHolder.auditPostListOnePictrueItemTime = null;
                onePictrueHolder.auditPostListOnePictrueItemImgNum = null;
                onePictrueHolder.auditInfo = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ThreePictrueHolder extends RecyclerView.ViewHolder {
        private com.rtk.app.custom.c a;

        @BindView
        View auditInfo;

        @BindView
        TextView auditPostListThreePictrueItemAuditState;

        @BindView
        TextView auditPostListThreePictrueItemAuthor;

        @BindView
        TextView auditPostListThreePictrueItemCommentNum;

        @BindView
        TextView auditPostListThreePictrueItemContent;

        @BindView
        ImageView auditPostListThreePictrueItemImg1;

        @BindView
        ImageView auditPostListThreePictrueItemImg2;

        @BindView
        ImageView auditPostListThreePictrueItemImg3;

        @BindView
        TextView auditPostListThreePictrueItemImg3Num;

        @BindView
        TextView auditPostListThreePictrueItemTime;

        @BindView
        TextView auditPostListThreePictrueItemTitle;

        @BindView
        TextView auditPostListThreePictrueItemViewNum;
        View b;

        ThreePictrueHolder(View view, Context context) {
            super(view);
            ButterKnife.b(this, view);
            this.b = view;
            this.a = new com.rtk.app.custom.c(this.auditInfo, new WeakReference(context));
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ThreePictrueHolder_ViewBinding implements Unbinder {
        private ThreePictrueHolder b;

        @UiThread
        public ThreePictrueHolder_ViewBinding(ThreePictrueHolder threePictrueHolder, View view) {
            this.b = threePictrueHolder;
            threePictrueHolder.auditPostListThreePictrueItemTitle = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_three_pictrue_item_title, "field 'auditPostListThreePictrueItemTitle'", TextView.class);
            threePictrueHolder.auditPostListThreePictrueItemAuditState = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_three_pictrue_item_audit_state, "field 'auditPostListThreePictrueItemAuditState'", TextView.class);
            threePictrueHolder.auditPostListThreePictrueItemContent = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_three_pictrue_item_content, "field 'auditPostListThreePictrueItemContent'", TextView.class);
            threePictrueHolder.auditPostListThreePictrueItemAuthor = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_three_pictrue_item_author, "field 'auditPostListThreePictrueItemAuthor'", TextView.class);
            threePictrueHolder.auditPostListThreePictrueItemImg1 = (ImageView) butterknife.c.a.c(view, R.id.audit_post_list_three_pictrue_item_img1, "field 'auditPostListThreePictrueItemImg1'", ImageView.class);
            threePictrueHolder.auditPostListThreePictrueItemImg2 = (ImageView) butterknife.c.a.c(view, R.id.audit_post_list_three_pictrue_item_img2, "field 'auditPostListThreePictrueItemImg2'", ImageView.class);
            threePictrueHolder.auditPostListThreePictrueItemImg3 = (ImageView) butterknife.c.a.c(view, R.id.audit_post_list_three_pictrue_item_img3, "field 'auditPostListThreePictrueItemImg3'", ImageView.class);
            threePictrueHolder.auditPostListThreePictrueItemTime = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_three_pictrue_item_time, "field 'auditPostListThreePictrueItemTime'", TextView.class);
            threePictrueHolder.auditPostListThreePictrueItemViewNum = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_three_pictrue_item_viewNum, "field 'auditPostListThreePictrueItemViewNum'", TextView.class);
            threePictrueHolder.auditPostListThreePictrueItemCommentNum = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_three_pictrue_item_commentNum, "field 'auditPostListThreePictrueItemCommentNum'", TextView.class);
            threePictrueHolder.auditPostListThreePictrueItemImg3Num = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_three_pictrue_item_img3_num, "field 'auditPostListThreePictrueItemImg3Num'", TextView.class);
            threePictrueHolder.auditInfo = butterknife.c.a.b(view, R.id.audit_post_list_three_picture_item_audit_info, "field 'auditInfo'");
        }

        @CallSuper
        public void a() {
            ThreePictrueHolder threePictrueHolder = this.b;
            if (threePictrueHolder != null) {
                this.b = null;
                threePictrueHolder.auditPostListThreePictrueItemTitle = null;
                threePictrueHolder.auditPostListThreePictrueItemAuditState = null;
                threePictrueHolder.auditPostListThreePictrueItemContent = null;
                threePictrueHolder.auditPostListThreePictrueItemAuthor = null;
                threePictrueHolder.auditPostListThreePictrueItemImg1 = null;
                threePictrueHolder.auditPostListThreePictrueItemImg2 = null;
                threePictrueHolder.auditPostListThreePictrueItemImg3 = null;
                threePictrueHolder.auditPostListThreePictrueItemTime = null;
                threePictrueHolder.auditPostListThreePictrueItemViewNum = null;
                threePictrueHolder.auditPostListThreePictrueItemCommentNum = null;
                threePictrueHolder.auditPostListThreePictrueItemImg3Num = null;
                threePictrueHolder.auditInfo = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class a implements View.OnClickListener {
        private Context a;
        private int b;

        /* renamed from: c, reason: collision with root package name */
        private PostAuditListBean.DataBean f99c;
        private String d;

        public a(Context context, int i, PostAuditListBean.DataBean dataBean, int i2, String str) {
            this.a = context;
            this.b = i;
            this.f99c = dataBean;
            this.d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.b != 1) {
                return;
            }
            com.rtk.app.tool.t.K0(this.a, this.f99c.getId() + "", this.d);
        }
    }

    public PostAuditListAdapter(Context context, List<PostAuditListBean.DataBean> list, String str) {
        this.f = context;
        this.g = list;
        this.e = str;
    }

    public int getItemCount() {
        if (this.g.size() == 0) {
            return 1;
        }
        return this.g.size() + 1;
    }

    public int getItemViewType(int i) {
        int size;
        if (i == getItemCount() - 1 || getItemCount() == 1) {
            return 4;
        }
        if (this.g.get(i).getPic() == null || (size = this.g.get(i).getPic().size()) == 0) {
            return 0;
        }
        return (size == 1 || size == 2) ? 1 : 3;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 1) {
            OnePictrueHolder onePictrueHolder = (OnePictrueHolder) viewHolder;
            int state = this.g.get(i).getState();
            if (!TextUtils.isEmpty(this.e)) {
                state = this.g.get(i).getState3();
                CheckUser check_user3 = this.g.get(i).getCheck_user3();
                View view = onePictrueHolder.auditInfo;
                if (check_user3 != null && !check_user3.getCheck_uid().equals("0")) {
                    r4 = 0;
                }
                view.setVisibility(r4);
                if (check_user3 != null) {
                    onePictrueHolder.a.c(check_user3);
                }
            }
            c.d.a.d.f(this.f, onePictrueHolder.auditPostListOnePictrueItemAuditState, state);
            com.rtk.app.tool.t.U1(onePictrueHolder.auditPostListOnePictrueItemTitle, this.g.get(i).getTitle(), this.g.get(i).getPost_title());
            onePictrueHolder.auditPostListOnePictrueItemAuthor.setText(this.g.get(i).getUser().getNickname());
            com.rtk.app.tool.t.c(this.f, this.g.get(i).getPic().get(0), onePictrueHolder.auditPostListOnePictrueItemImg, new boolean[0]);
            onePictrueHolder.auditPostListOnePictrueItemTime.setText(this.g.get(i).getBefore());
            onePictrueHolder.auditPostListOnePictrueItemViewNum.setText(this.g.get(i).getClickNum() + "");
            onePictrueHolder.auditPostListOnePictrueItemCommentNum.setText(this.g.get(i).getLevelCommentNum() + "");
            onePictrueHolder.auditPostListOnePictrueItemContent.setText(this.g.get(i).getContent());
            onePictrueHolder.auditPostListOnePictrueItemImgNum.setText(this.g.get(i).getPic().size() + "图");
            onePictrueHolder.b.setOnClickListener(new a(this.f, 1, this.g.get(i), i, this.e));
            return;
        }
        if (itemViewType != 3) {
            if (itemViewType != 4) {
                NoPictrueHolder noPictrueHolder = (NoPictrueHolder) viewHolder;
                int state2 = this.g.get(i).getState();
                if (!TextUtils.isEmpty(this.e)) {
                    state2 = this.g.get(i).getState3();
                    CheckUser check_user32 = this.g.get(i).getCheck_user3();
                    noPictrueHolder.auditInfo.setVisibility((check_user32 == null || check_user32.getCheck_uid().equals("0")) ? 8 : 0);
                    if (check_user32 != null) {
                        noPictrueHolder.a.c(check_user32);
                    }
                }
                c.d.a.d.f(this.f, noPictrueHolder.auditPostListItemAuditState, state2);
                com.rtk.app.tool.t.U1(noPictrueHolder.auditPostListItemName, this.g.get(i).getTitle(), this.g.get(i).getPost_title());
                noPictrueHolder.auditPostListItemContent.setText(this.g.get(i).getContent());
                noPictrueHolder.auditPostListItemUserName.setText(this.g.get(i).getUser().getNickname());
                noPictrueHolder.auditPostListItemTime.setText(this.g.get(i).getBefore());
                noPictrueHolder.auditPostListItemClickNum.setText(this.g.get(i).getClickNum() + "");
                noPictrueHolder.auditPostListItemClickNum.setVisibility(com.rtk.app.tool.y.f335c ? 0 : 8);
                noPictrueHolder.auditPostListItemCommentNum.setText(this.g.get(i).getLevelCommentNum() + "");
                noPictrueHolder.b.setOnClickListener(new a(this.f, 1, this.g.get(i), i, this.e));
                return;
            }
            BaseRecyclerViewAdapter.RecyclerViewFootViewHolder recyclerViewFootViewHolder = (BaseRecyclerViewAdapter.RecyclerViewFootViewHolder) viewHolder;
            Boolean valueOf = Boolean.valueOf(g());
            List<PostAuditListBean.DataBean> list = this.g;
            recyclerViewFootViewHolder.f(valueOf, list != null ? list.size() : 0, h(), f());
            return;
        }
        ThreePictrueHolder threePictrueHolder = (ThreePictrueHolder) viewHolder;
        int state3 = this.g.get(i).getState();
        if (!TextUtils.isEmpty(this.e)) {
            state3 = this.g.get(i).getState3();
            CheckUser check_user33 = this.g.get(i).getCheck_user3();
            threePictrueHolder.auditInfo.setVisibility((check_user33 == null || check_user33.getCheck_uid().equals("0")) ? 8 : 0);
            if (check_user33 != null) {
                threePictrueHolder.a.c(check_user33);
            }
        }
        c.d.a.d.f(this.f, threePictrueHolder.auditPostListThreePictrueItemAuditState, state3);
        com.rtk.app.tool.t.U1(threePictrueHolder.auditPostListThreePictrueItemTitle, this.g.get(i).getTitle(), this.g.get(i).getPost_title());
        threePictrueHolder.auditPostListThreePictrueItemAuthor.setText(this.g.get(i).getUser().getNickname());
        com.rtk.app.tool.t.c(this.f, this.g.get(i).getPic().get(0), threePictrueHolder.auditPostListThreePictrueItemImg1, new boolean[0]);
        com.rtk.app.tool.t.c(this.f, this.g.get(i).getPic().get(1), threePictrueHolder.auditPostListThreePictrueItemImg2, new boolean[0]);
        com.rtk.app.tool.t.c(this.f, this.g.get(i).getPic().get(2), threePictrueHolder.auditPostListThreePictrueItemImg3, new boolean[0]);
        threePictrueHolder.auditPostListThreePictrueItemTime.setText(this.g.get(i).getBefore());
        threePictrueHolder.auditPostListThreePictrueItemViewNum.setText(this.g.get(i).getClickNum() + "");
        threePictrueHolder.auditPostListThreePictrueItemViewNum.setVisibility(com.rtk.app.tool.y.f335c ? 0 : 8);
        threePictrueHolder.auditPostListThreePictrueItemCommentNum.setText(this.g.get(i).getLevelCommentNum() + "");
        threePictrueHolder.auditPostListThreePictrueItemImg3Num.setText(this.g.get(i).getPic().size() + "图");
        threePictrueHolder.auditPostListThreePictrueItemContent.setText(this.g.get(i).getContent());
        threePictrueHolder.b.setOnClickListener(new a(this.f, 1, this.g.get(i), i, this.e));
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new OnePictrueHolder(LayoutInflater.from(this.f).inflate(R.layout.audit_post_one_pictrue_item_layout, viewGroup, false), this.f);
        }
        if (i == 3) {
            return new ThreePictrueHolder(LayoutInflater.from(this.f).inflate(R.layout.audit_post_three_pictrue_item_layout, viewGroup, false), this.f);
        }
        if (i != 4) {
            return new NoPictrueHolder(LayoutInflater.from(this.f).inflate(R.layout.audit_post_list_no_pictrue_item_layout, viewGroup, false), this.f);
        }
        return new BaseRecyclerViewAdapter.RecyclerViewFootViewHolder(LayoutInflater.from(this.f).inflate(R.layout.looding_footview, viewGroup, false));
    }
}
