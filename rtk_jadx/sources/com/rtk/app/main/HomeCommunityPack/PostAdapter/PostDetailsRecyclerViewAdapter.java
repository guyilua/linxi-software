package com.rtk.app.main.HomeCommunityPack.PostAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.rtk.app.R;
import com.rtk.app.base.BaseRecyclerViewAdapter;
import com.rtk.app.bean.PostDetailsBean;
import com.rtk.app.bean.PostDetailsCommentBean;
import com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsHolderClass.CommentHolder;
import com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsHolderClass.ContentHolder;
import com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsHolderClass.TitleHolder;
import com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsHolderClass.UpAndRewardViewHolder;
import com.rtk.app.main.HomeCommunityPack.PostDetailsActivity;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.v;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostDetailsRecyclerViewAdapter extends BaseRecyclerViewAdapter {
    private Context e;
    private PostDetailsBean.DataBean f;
    private List<PostDetailsCommentBean.DataBean.ReplyListBean> g = null;
    private boolean h = false;
    private a i;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void j(int i);

        void n(int i);

        void p(boolean z);
    }

    public PostDetailsRecyclerViewAdapter(Context context, PostDetailsBean.DataBean dataBean) {
        this.f = dataBean;
        this.e = context;
        com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsHolderClass.a.q(v.a(context, "postConciseVALUE"));
    }

    public int getItemCount() {
        if (this.g == null) {
            return 4;
        }
        if (l()) {
            return this.g.size() + 1;
        }
        return this.g.size() + 4;
    }

    public int getItemViewType(int i) {
        List<PostDetailsCommentBean.DataBean.ReplyListBean> list = this.g;
        if (list != null && list.size() == 0 && i == getItemCount()) {
            return 1110011;
        }
        if (getItemCount() - 1 == i) {
            return 4;
        }
        if (!l()) {
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 1;
            }
            if (i == 2) {
                return 2;
            }
        }
        return 3;
    }

    @Override // com.rtk.app.base.BaseRecyclerViewAdapter
    public void i() {
        super.i();
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }

    public boolean l() {
        return this.h;
    }

    public void m(a aVar) {
        this.i = aVar;
    }

    public void n(List<PostDetailsCommentBean.DataBean.ReplyListBean> list) {
        this.g = list;
    }

    public void o(boolean z) {
        this.h = z;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            ((TitleHolder) viewHolder).b(this.e, this.f);
        } else if (itemViewType == 1) {
            ((ContentHolder) viewHolder).b(this.e, this.f);
        } else if (itemViewType == 2) {
            ((UpAndRewardViewHolder) viewHolder).b(this.e, this.f, this.i);
        } else if (itemViewType == 3) {
            int i2 = l() ? i : i - 3;
            ((CommentHolder) viewHolder).b(this.e, this.f.getId(), this.f.getMid(), this.f.getUid(), this.g.get(i2), this.i, this.f.getIsModerator(), this.f.getNocomment(), i2, i);
        } else if (itemViewType == 4) {
            BaseRecyclerViewAdapter.RecyclerViewFootViewHolder recyclerViewFootViewHolder = (BaseRecyclerViewAdapter.RecyclerViewFootViewHolder) viewHolder;
            Boolean valueOf = Boolean.valueOf(g());
            List<PostDetailsCommentBean.DataBean.ReplyListBean> list = this.g;
            recyclerViewFootViewHolder.f(valueOf, list == null ? 0 : list.size(), h(), f());
        } else if (itemViewType == 1110011) {
            ((BaseRecyclerViewAdapter.EmptyViewHolder) viewHolder).b(Boolean.valueOf(g()));
        }
        try {
            if (l()) {
                ((PostDetailsActivity) this.e).Z(this.g.get(i).getPage());
                return;
            }
            int i3 = i - 2;
            ((PostDetailsActivity) this.e).Z((i3 / 10) + (i3 % 10 > 0 ? 1 : 0));
        } catch (Exception unused) {
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new ContentHolder(LayoutInflater.from(this.e).inflate(R.layout.post_details_recyclerview_item_content_layout, viewGroup, false));
        }
        if (i == 2) {
            return new UpAndRewardViewHolder(LayoutInflater.from(this.e).inflate(R.layout.post_details_recyclerview_item_up_and_reward_layout, viewGroup, false));
        }
        if (i == 3) {
            return new CommentHolder(LayoutInflater.from(this.e).inflate(R.layout.test_post_adapter_item_layout, viewGroup, false));
        }
        if (i == 4) {
            return new BaseRecyclerViewAdapter.RecyclerViewFootViewHolder(LayoutInflater.from(this.e).inflate(R.layout.looding_footview, viewGroup, false));
        }
        if (i != 1110011) {
            return new TitleHolder(LayoutInflater.from(this.e).inflate(R.layout.post_details_recyclerview_item_title_layout, viewGroup, false));
        }
        return new BaseRecyclerViewAdapter.EmptyViewHolder(this, LayoutInflater.from(this.e).inflate(R.layout.post_details_recyclerview_item_empty_view_layout, viewGroup, false));
    }

    public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        c0.u("PostDetailsRecyclerViewAdapter", "销毁  onViewRecycled");
        if (viewHolder.getItemViewType() != 1) {
            return;
        }
        ((ContentHolder) viewHolder).c();
    }
}
