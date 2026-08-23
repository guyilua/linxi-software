package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.adapter.MyPostAuditListAdapter;
import com.rtk.app.base.BaseRecyclerViewAdapter;
import com.rtk.app.bean.CommunityPostBean;
import com.rtk.app.bean.ResponseDataBean;
import com.rtk.app.custom.RichEditText.PostModificationBean;
import com.rtk.app.main.dialogPack.DialogForEnSure;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyPostAuditListAdapter extends BaseRecyclerViewAdapter {
    private Context e;
    private List<CommunityPostBean.DataBean> f;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class NoPictrueHolder extends RecyclerView.ViewHolder {
        View a;

        @BindView
        ImageView audioPostListItemMore;

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

        @BindView
        View familyPrefix;

        public NoPictrueHolder(View view) {
            super(view);
            ButterKnife.b(this, view);
            this.a = view;
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
            noPictrueHolder.audioPostListItemMore = (ImageView) butterknife.c.a.c(view, R.id.audio_post_list_item_toMore, "field 'audioPostListItemMore'", ImageView.class);
            noPictrueHolder.familyPrefix = butterknife.c.a.b(view, R.id.family_post_title_prefix, "field 'familyPrefix'");
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
                noPictrueHolder.audioPostListItemMore = null;
                noPictrueHolder.familyPrefix = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class OnePictrueHolder extends RecyclerView.ViewHolder {
        View a;

        @BindView
        ImageView audioPostListItemMore;

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

        @BindView
        View familyPrefix;

        OnePictrueHolder(View view) {
            super(view);
            ButterKnife.b(this, view);
            this.a = view;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class OnePictrueHolder_ViewBinding implements Unbinder {
        private OnePictrueHolder b;

        @UiThread
        public OnePictrueHolder_ViewBinding(OnePictrueHolder onePictrueHolder, View view) {
            this.b = onePictrueHolder;
            onePictrueHolder.familyPrefix = butterknife.c.a.b(view, R.id.family_post_title_prefix, "field 'familyPrefix'");
            onePictrueHolder.auditPostListOnePictrueItemImg = (ImageView) butterknife.c.a.c(view, R.id.audit_post_list_one_pictrue_item_img, "field 'auditPostListOnePictrueItemImg'", ImageView.class);
            onePictrueHolder.auditPostListOnePictrueItemTitle = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_one_pictrue_item_title, "field 'auditPostListOnePictrueItemTitle'", TextView.class);
            onePictrueHolder.auditPostListOnePictrueItemContent = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_one_pictrue_item_content, "field 'auditPostListOnePictrueItemContent'", TextView.class);
            onePictrueHolder.auditPostListOnePictrueItemAuthor = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_one_pictrue_item_author, "field 'auditPostListOnePictrueItemAuthor'", TextView.class);
            onePictrueHolder.auditPostListOnePictrueItemCommentNum = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_one_pictrue_item_comment_num, "field 'auditPostListOnePictrueItemCommentNum'", TextView.class);
            onePictrueHolder.auditPostListOnePictrueItemViewNum = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_one_pictrue_item_viewNum, "field 'auditPostListOnePictrueItemViewNum'", TextView.class);
            onePictrueHolder.auditPostListOnePictrueItemAuditState = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_one_pictrue_item_audit_state, "field 'auditPostListOnePictrueItemAuditState'", TextView.class);
            onePictrueHolder.auditPostListOnePictrueItemTime = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_one_pictrue_item_time, "field 'auditPostListOnePictrueItemTime'", TextView.class);
            onePictrueHolder.auditPostListOnePictrueItemImgNum = (TextView) butterknife.c.a.c(view, R.id.audit_post_list_one_pictrue_item_img_num, "field 'auditPostListOnePictrueItemImgNum'", TextView.class);
            onePictrueHolder.audioPostListItemMore = (ImageView) butterknife.c.a.c(view, R.id.audio_post_list_item_toMore, "field 'audioPostListItemMore'", ImageView.class);
        }

        @CallSuper
        public void a() {
            OnePictrueHolder onePictrueHolder = this.b;
            if (onePictrueHolder != null) {
                this.b = null;
                onePictrueHolder.familyPrefix = null;
                onePictrueHolder.auditPostListOnePictrueItemImg = null;
                onePictrueHolder.auditPostListOnePictrueItemTitle = null;
                onePictrueHolder.auditPostListOnePictrueItemContent = null;
                onePictrueHolder.auditPostListOnePictrueItemAuthor = null;
                onePictrueHolder.auditPostListOnePictrueItemCommentNum = null;
                onePictrueHolder.auditPostListOnePictrueItemViewNum = null;
                onePictrueHolder.auditPostListOnePictrueItemAuditState = null;
                onePictrueHolder.auditPostListOnePictrueItemTime = null;
                onePictrueHolder.auditPostListOnePictrueItemImgNum = null;
                onePictrueHolder.audioPostListItemMore = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ThreePictrueHolder extends RecyclerView.ViewHolder {
        View a;

        @BindView
        ImageView audioPostListItemMore;

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

        @BindView
        View familyPrefix;

        ThreePictrueHolder(View view) {
            super(view);
            ButterKnife.b(this, view);
            this.a = view;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ThreePictrueHolder_ViewBinding implements Unbinder {
        private ThreePictrueHolder b;

        @UiThread
        public ThreePictrueHolder_ViewBinding(ThreePictrueHolder threePictrueHolder, View view) {
            this.b = threePictrueHolder;
            threePictrueHolder.familyPrefix = butterknife.c.a.b(view, R.id.family_post_title_prefix, "field 'familyPrefix'");
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
            threePictrueHolder.audioPostListItemMore = (ImageView) butterknife.c.a.c(view, R.id.audio_post_list_item_toMore, "field 'audioPostListItemMore'", ImageView.class);
        }

        @CallSuper
        public void a() {
            ThreePictrueHolder threePictrueHolder = this.b;
            if (threePictrueHolder != null) {
                this.b = null;
                threePictrueHolder.familyPrefix = null;
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
                threePictrueHolder.audioPostListItemMore = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class VideoHolder extends RecyclerView.ViewHolder {
        View a;

        @BindView
        ImageView audioPostListItemMore;

        @BindView
        TextView auditCommunityFragmentPostlistVideoItemAuditState;

        @BindView
        TextView auditCommunityFragmentPostlistVideoItemAuthor;

        @BindView
        TextView auditCommunityFragmentPostlistVideoItemCommentNum;

        @BindView
        TextView auditCommunityFragmentPostlistVideoItemContent;

        @BindView
        ImageView auditCommunityFragmentPostlistVideoItemPerviewImg;

        @BindView
        TextView auditCommunityFragmentPostlistVideoItemTime;

        @BindView
        TextView auditCommunityFragmentPostlistVideoItemTitle;

        @BindView
        TextView auditCommunityFragmentPostlistVideoItemViewNum;

        @BindView
        View familyPrefix;

        public VideoHolder(View view) {
            super(view);
            ButterKnife.b(this, view);
            this.a = view;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class VideoHolder_ViewBinding implements Unbinder {
        private VideoHolder b;

        @UiThread
        public VideoHolder_ViewBinding(VideoHolder videoHolder, View view) {
            this.b = videoHolder;
            videoHolder.familyPrefix = butterknife.c.a.b(view, R.id.family_post_title_prefix, "field 'familyPrefix'");
            videoHolder.auditCommunityFragmentPostlistVideoItemTitle = (TextView) butterknife.c.a.c(view, R.id.audit_community_fragment_postlist_video_item_title, "field 'auditCommunityFragmentPostlistVideoItemTitle'", TextView.class);
            videoHolder.auditCommunityFragmentPostlistVideoItemAuditState = (TextView) butterknife.c.a.c(view, R.id.audit_community_fragment_postlist_video_item_audit_state, "field 'auditCommunityFragmentPostlistVideoItemAuditState'", TextView.class);
            videoHolder.auditCommunityFragmentPostlistVideoItemContent = (TextView) butterknife.c.a.c(view, R.id.audit_community_fragment_postlist_video_item_content, "field 'auditCommunityFragmentPostlistVideoItemContent'", TextView.class);
            videoHolder.auditCommunityFragmentPostlistVideoItemPerviewImg = (ImageView) butterknife.c.a.c(view, R.id.audit_community_fragment_postlist_video_item_perview_img, "field 'auditCommunityFragmentPostlistVideoItemPerviewImg'", ImageView.class);
            videoHolder.auditCommunityFragmentPostlistVideoItemAuthor = (TextView) butterknife.c.a.c(view, R.id.audit_community_fragment_postlist_video_item_author, "field 'auditCommunityFragmentPostlistVideoItemAuthor'", TextView.class);
            videoHolder.auditCommunityFragmentPostlistVideoItemTime = (TextView) butterknife.c.a.c(view, R.id.audit_community_fragment_postlist_video_item_time, "field 'auditCommunityFragmentPostlistVideoItemTime'", TextView.class);
            videoHolder.auditCommunityFragmentPostlistVideoItemViewNum = (TextView) butterknife.c.a.c(view, R.id.audit_community_fragment_postlist_video_item_viewNum, "field 'auditCommunityFragmentPostlistVideoItemViewNum'", TextView.class);
            videoHolder.auditCommunityFragmentPostlistVideoItemCommentNum = (TextView) butterknife.c.a.c(view, R.id.audit_community_fragment_postlist_video_item_commentNum, "field 'auditCommunityFragmentPostlistVideoItemCommentNum'", TextView.class);
            videoHolder.audioPostListItemMore = (ImageView) butterknife.c.a.c(view, R.id.audio_post_list_item_toMore, "field 'audioPostListItemMore'", ImageView.class);
        }

        @CallSuper
        public void a() {
            VideoHolder videoHolder = this.b;
            if (videoHolder != null) {
                this.b = null;
                videoHolder.familyPrefix = null;
                videoHolder.auditCommunityFragmentPostlistVideoItemTitle = null;
                videoHolder.auditCommunityFragmentPostlistVideoItemAuditState = null;
                videoHolder.auditCommunityFragmentPostlistVideoItemContent = null;
                videoHolder.auditCommunityFragmentPostlistVideoItemPerviewImg = null;
                videoHolder.auditCommunityFragmentPostlistVideoItemAuthor = null;
                videoHolder.auditCommunityFragmentPostlistVideoItemTime = null;
                videoHolder.auditCommunityFragmentPostlistVideoItemViewNum = null;
                videoHolder.auditCommunityFragmentPostlistVideoItemCommentNum = null;
                videoHolder.audioPostListItemMore = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements View.OnClickListener {
        private Context a;
        private int b;

        /* renamed from: c, reason: collision with root package name */
        private CommunityPostBean.DataBean f89c;
        private int d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.rtk.app.adapter.MyPostAuditListAdapter$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public class C0014a implements com.rtk.app.tool.s {
            final /* synthetic */ CommunityPostBean.DataBean a;
            final /* synthetic */ View b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f90c;

            /* renamed from: com.rtk.app.adapter.MyPostAuditListAdapter$a$a$a, reason: collision with other inner class name */
            /* loaded from: /tmp/rtk_apk/classes3.dex */
            class C0015a implements h.j {
                C0015a() {
                }

                @Override // com.rtk.app.tool.o.h.j
                public void d(String str, int i) {
                    com.rtk.app.tool.f.a(a.this.a, ((ResponseDataBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, ResponseDataBean.class)).getMsg(), f.a.f);
                    C0014a.this.a.setState(4);
                    C0014a c0014a = C0014a.this;
                    MyPostAuditListAdapter.this.notifyItemChanged(c0014a.f90c);
                }

                @Override // com.rtk.app.tool.o.h.j
                public void g(int i, String str, int i2) {
                }
            }

            C0014a(CommunityPostBean.DataBean dataBean, View view, int i) {
                this.a = dataBean;
                this.b = view;
                this.f90c = i;
            }

            @Override // com.rtk.app.tool.s
            public void a(String... strArr) {
                String mid = this.a.getMid();
                String pid = this.a.getPid();
                String str = "自己删除";
                try {
                    str = URLEncoder.encode("自己删除", "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("bbs/posts/delete");
                sb.append(com.rtk.app.tool.y.u(a.this.a));
                sb.append("&uid=");
                sb.append(com.rtk.app.tool.y.K());
                sb.append("&token=");
                sb.append(com.rtk.app.tool.y.H());
                sb.append("&mid=");
                sb.append(mid);
                sb.append("&pid=");
                sb.append(pid);
                sb.append("&msg=");
                sb.append(str);
                sb.append("&key=");
                sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.b.getContext(), "pid=" + pid, "mid=" + mid, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(" 删除  ");
                sb3.append(com.rtk.app.tool.y.d);
                sb3.append(sb2);
                com.rtk.app.tool.c0.u("MyPostAuditListAdapter", sb3.toString());
                com.rtk.app.tool.o.h.l(a.this.a, new C0015a(), a.this.b, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb2));
            }
        }

        public a(Context context, int i, CommunityPostBean.DataBean dataBean, int i2) {
            this.a = context;
            this.b = i;
            this.f89c = dataBean;
            this.d = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean d(CommunityPostBean.DataBean dataBean, View view, int i, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.post_more_click_num /* 2131299871 */:
                    com.rtk.app.tool.t.F0(dataBean.getPid());
                    return false;
                case R.id.post_more_delete /* 2131299872 */:
                    new DialogForEnSure(view.getContext(), "确认删除吗？", new C0014a(dataBean, view, i)).show();
                    return false;
                case R.id.post_more_edit /* 2131299873 */:
                    com.rtk.app.tool.t.v1(this.a, new PostModificationBean(dataBean.getPid()));
                    return false;
                default:
                    return false;
            }
        }

        private void e(final int i, final View view, final CommunityPostBean.DataBean dataBean) {
            PopupMenu popupMenu = new PopupMenu(this.a, view);
            popupMenu.getMenuInflater().inflate(R.menu.post_audit, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.rtk.app.adapter.p1
                @Override // android.widget.PopupMenu.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    return MyPostAuditListAdapter.a.this.d(dataBean, view, i, menuItem);
                }
            });
            popupMenu.show();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = this.b;
            if (i == 1) {
                com.rtk.app.tool.t.J0(this.a, this.f89c.getPid());
            } else {
                if (i != 2) {
                    return;
                }
                e(this.d, view, this.f89c);
            }
        }
    }

    public MyPostAuditListAdapter(Context context, List<CommunityPostBean.DataBean> list) {
        this.e = context;
        this.f = list;
    }

    public int getItemCount() {
        if (this.f.size() == 0) {
            return 1;
        }
        return this.f.size() + 1;
    }

    public int getItemViewType(int i) {
        if (i == getItemCount() - 1 || getItemCount() == 1) {
            return 4;
        }
        if (this.f.get(i).getPic() == null) {
            return 0;
        }
        if (this.f.get(i).getList_post_video() != null && this.f.get(i).getList_post_video().size() > 0) {
            return 5;
        }
        int size = this.f.get(i).getPic().size();
        if (size != 0) {
            return (size == 1 || size == 2) ? 1 : 3;
        }
        return 0;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 1) {
            OnePictrueHolder onePictrueHolder = (OnePictrueHolder) viewHolder;
            CommunityPostBean.DataBean dataBean = this.f.get(i);
            int state3 = dataBean.isFamilyPost() ? dataBean.getState3() : dataBean.getState();
            c.d.a.d.g(this.e, onePictrueHolder.auditPostListOnePictrueItemAuditState, state3, dataBean.isFamilyPost());
            com.rtk.app.tool.t.U1(onePictrueHolder.auditPostListOnePictrueItemTitle, this.f.get(i).getTitle(), this.f.get(i).getPost_title());
            onePictrueHolder.auditPostListOnePictrueItemAuthor.setText(this.f.get(i).getOwner().getNickname());
            com.rtk.app.tool.t.c(this.e, this.f.get(i).getPic().get(0), onePictrueHolder.auditPostListOnePictrueItemImg, new boolean[0]);
            onePictrueHolder.auditPostListOnePictrueItemTime.setText(this.f.get(i).getBefore());
            onePictrueHolder.auditPostListOnePictrueItemViewNum.setText(this.f.get(i).getClickNum() + "");
            onePictrueHolder.auditPostListOnePictrueItemViewNum.setVisibility(com.rtk.app.tool.y.b ? 0 : 8);
            onePictrueHolder.auditPostListOnePictrueItemCommentNum.setText(this.f.get(i).getCommentNum() + "");
            onePictrueHolder.auditPostListOnePictrueItemContent.setText(this.f.get(i).getContent());
            onePictrueHolder.auditPostListOnePictrueItemImgNum.setText(this.f.get(i).getPic().size() + "图");
            onePictrueHolder.a.setOnClickListener(new a(this.e, 1, this.f.get(i), i));
            onePictrueHolder.familyPrefix.setVisibility(dataBean.isFamilyPost() ? 0 : 8);
            if (state3 == 4) {
                onePictrueHolder.audioPostListItemMore.setVisibility(8);
                return;
            } else {
                onePictrueHolder.audioPostListItemMore.setVisibility(0);
                onePictrueHolder.audioPostListItemMore.setOnClickListener(new a(this.e, 2, this.f.get(i), i));
                return;
            }
        }
        if (itemViewType == 3) {
            ThreePictrueHolder threePictrueHolder = (ThreePictrueHolder) viewHolder;
            CommunityPostBean.DataBean dataBean2 = this.f.get(i);
            int state32 = dataBean2.isFamilyPost() ? dataBean2.getState3() : dataBean2.getState();
            c.d.a.d.g(this.e, threePictrueHolder.auditPostListThreePictrueItemAuditState, state32, dataBean2.isFamilyPost());
            com.rtk.app.tool.t.U1(threePictrueHolder.auditPostListThreePictrueItemTitle, dataBean2.getTitle(), this.f.get(i).getPost_title());
            threePictrueHolder.auditPostListThreePictrueItemAuthor.setText(this.f.get(i).getOwner().getNickname());
            com.rtk.app.tool.t.c(this.e, this.f.get(i).getPic().get(0), threePictrueHolder.auditPostListThreePictrueItemImg1, new boolean[0]);
            com.rtk.app.tool.t.c(this.e, this.f.get(i).getPic().get(1), threePictrueHolder.auditPostListThreePictrueItemImg2, new boolean[0]);
            com.rtk.app.tool.t.c(this.e, this.f.get(i).getPic().get(2), threePictrueHolder.auditPostListThreePictrueItemImg3, new boolean[0]);
            threePictrueHolder.familyPrefix.setVisibility(dataBean2.isFamilyPost() ? 0 : 8);
            threePictrueHolder.auditPostListThreePictrueItemTime.setText(this.f.get(i).getBefore());
            threePictrueHolder.auditPostListThreePictrueItemViewNum.setText(this.f.get(i).getClickNum() + "");
            threePictrueHolder.auditPostListThreePictrueItemViewNum.setVisibility(com.rtk.app.tool.y.b ? 0 : 8);
            threePictrueHolder.auditPostListThreePictrueItemCommentNum.setText(this.f.get(i).getCommentNum() + "");
            threePictrueHolder.auditPostListThreePictrueItemImg3Num.setText(this.f.get(i).getPic().size() + "图");
            threePictrueHolder.auditPostListThreePictrueItemContent.setText(this.f.get(i).getContent());
            threePictrueHolder.a.setOnClickListener(new a(this.e, 1, this.f.get(i), i));
            if (state32 == 4) {
                threePictrueHolder.audioPostListItemMore.setVisibility(8);
                return;
            } else {
                threePictrueHolder.audioPostListItemMore.setVisibility(0);
                threePictrueHolder.audioPostListItemMore.setOnClickListener(new a(this.e, 2, this.f.get(i), i));
                return;
            }
        }
        if (itemViewType == 4) {
            BaseRecyclerViewAdapter.RecyclerViewFootViewHolder recyclerViewFootViewHolder = (BaseRecyclerViewAdapter.RecyclerViewFootViewHolder) viewHolder;
            Boolean valueOf = Boolean.valueOf(g());
            List<CommunityPostBean.DataBean> list = this.f;
            recyclerViewFootViewHolder.f(valueOf, list != null ? list.size() : 0, h(), f());
            return;
        }
        if (itemViewType != 5) {
            NoPictrueHolder noPictrueHolder = (NoPictrueHolder) viewHolder;
            CommunityPostBean.DataBean dataBean3 = this.f.get(i);
            int state33 = dataBean3.isFamilyPost() ? dataBean3.getState3() : dataBean3.getState();
            c.d.a.d.g(this.e, noPictrueHolder.auditPostListItemAuditState, state33, dataBean3.isFamilyPost());
            com.rtk.app.tool.t.U1(noPictrueHolder.auditPostListItemName, this.f.get(i).getTitle(), this.f.get(i).getPost_title());
            noPictrueHolder.familyPrefix.setVisibility(dataBean3.isFamilyPost() ? 0 : 8);
            noPictrueHolder.auditPostListItemContent.setText(this.f.get(i).getContent());
            noPictrueHolder.auditPostListItemUserName.setText(this.f.get(i).getOwner().getNickname());
            noPictrueHolder.auditPostListItemTime.setText(this.f.get(i).getBefore());
            noPictrueHolder.auditPostListItemClickNum.setText(this.f.get(i).getClickNum() + "");
            noPictrueHolder.auditPostListItemClickNum.setVisibility(com.rtk.app.tool.y.b ? 0 : 8);
            noPictrueHolder.auditPostListItemCommentNum.setText(this.f.get(i).getCommentNum() + "");
            noPictrueHolder.a.setOnClickListener(new a(this.e, 1, this.f.get(i), i));
            if (state33 == 4) {
                noPictrueHolder.audioPostListItemMore.setVisibility(8);
                return;
            } else {
                noPictrueHolder.audioPostListItemMore.setVisibility(0);
                noPictrueHolder.audioPostListItemMore.setOnClickListener(new a(this.e, 2, this.f.get(i), i));
                return;
            }
        }
        VideoHolder videoHolder = (VideoHolder) viewHolder;
        com.rtk.app.tool.t.U1(videoHolder.auditCommunityFragmentPostlistVideoItemTitle, this.f.get(i).getTitle(), this.f.get(i).getPost_title());
        CommunityPostBean.DataBean dataBean4 = this.f.get(i);
        int state34 = dataBean4.isFamilyPost() ? dataBean4.getState3() : dataBean4.getState();
        c.d.a.d.g(this.e, videoHolder.auditCommunityFragmentPostlistVideoItemAuditState, state34, dataBean4.isFamilyPost());
        videoHolder.familyPrefix.setVisibility(dataBean4.isFamilyPost() ? 0 : 8);
        videoHolder.auditCommunityFragmentPostlistVideoItemAuthor.setText(this.f.get(i).getOwner().getNickname());
        com.rtk.app.tool.t.c(this.e, this.f.get(i).getList_post_video().get(0).getLogo(), videoHolder.auditCommunityFragmentPostlistVideoItemPerviewImg, new boolean[0]);
        videoHolder.auditCommunityFragmentPostlistVideoItemTime.setText(this.f.get(i).getBefore());
        videoHolder.auditCommunityFragmentPostlistVideoItemViewNum.setText(this.f.get(i).getClickNum());
        videoHolder.auditCommunityFragmentPostlistVideoItemViewNum.setVisibility(com.rtk.app.tool.y.b ? 0 : 8);
        videoHolder.auditCommunityFragmentPostlistVideoItemCommentNum.setText(this.f.get(i).getCommentNum());
        videoHolder.auditCommunityFragmentPostlistVideoItemContent.setText(this.f.get(i).getContent());
        videoHolder.a.setOnClickListener(new a(this.e, 1, dataBean4, i));
        if (state34 == 4) {
            videoHolder.audioPostListItemMore.setVisibility(8);
        } else {
            videoHolder.audioPostListItemMore.setVisibility(0);
            videoHolder.audioPostListItemMore.setOnClickListener(new a(this.e, 2, dataBean4, i));
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new OnePictrueHolder(LayoutInflater.from(this.e).inflate(R.layout.audit_post_one_pictrue_item_layout, viewGroup, false));
        }
        if (i == 3) {
            return new ThreePictrueHolder(LayoutInflater.from(this.e).inflate(R.layout.audit_post_three_pictrue_item_layout, viewGroup, false));
        }
        if (i == 4) {
            return new BaseRecyclerViewAdapter.RecyclerViewFootViewHolder(LayoutInflater.from(this.e).inflate(R.layout.looding_footview, viewGroup, false));
        }
        if (i != 5) {
            return new NoPictrueHolder(LayoutInflater.from(this.e).inflate(R.layout.audit_post_list_no_pictrue_item_layout, viewGroup, false));
        }
        return new VideoHolder(LayoutInflater.from(this.e).inflate(R.layout.audit_community_fragment_postlist_video_item_layout, viewGroup, false));
    }
}
