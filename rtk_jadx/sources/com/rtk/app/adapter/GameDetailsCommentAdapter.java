package com.rtk.app.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.bean.GameCommentBean;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.dialogPack.DialogForGameCommentDeleteReason;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import com.zhy.view.flowlayout.FlowLayout;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GameDetailsCommentAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private com.rtk.app.main.comment.express.c f52c;
    private Context d;
    private List<GameCommentBean.DataBean> e;
    private int f;
    private String g;
    private String h;
    private List<Integer> i;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class SecondHolder {

        @BindView
        LinearLayout appDetailItem3ItemAddItemAdminLy;

        @BindView
        LinearLayout appDetailItem3ItemAddItemCommentLy;

        @BindView
        TextView appDetailItem3ItemAddItemContent;

        @BindView
        TextView appDetailItem3ItemAddItemDuTv;

        @BindView
        ImageView appDetailItem3ItemAddItemImg;

        @BindView
        TextView appDetailItem3ItemAddItemName;

        @BindView
        TextView appDetailItem3ItemAddItemTime;

        @BindView
        LinearLayout appDetailItem3ItemAddItemUuLy;

        @BindView
        TextView appDetailItem3ItemAddItemUuTv;

        @BindView
        LinearLayout appDetails3ItemAddItemLayout;

        SecondHolder(GameDetailsCommentAdapter gameDetailsCommentAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class SecondHolder_ViewBinding implements Unbinder {
        private SecondHolder b;

        @UiThread
        public SecondHolder_ViewBinding(SecondHolder secondHolder, View view) {
            this.b = secondHolder;
            secondHolder.appDetailItem3ItemAddItemImg = (ImageView) butterknife.c.a.c(view, R.id.app_detail_item3_item_add_item_img, "field 'appDetailItem3ItemAddItemImg'", ImageView.class);
            secondHolder.appDetailItem3ItemAddItemTime = (TextView) butterknife.c.a.c(view, R.id.app_detail_item3_item_add_item_time, "field 'appDetailItem3ItemAddItemTime'", TextView.class);
            secondHolder.appDetailItem3ItemAddItemName = (TextView) butterknife.c.a.c(view, R.id.app_detail_item3_item_add_item_name, "field 'appDetailItem3ItemAddItemName'", TextView.class);
            secondHolder.appDetailItem3ItemAddItemContent = (TextView) butterknife.c.a.c(view, R.id.app_detail_item3_item_add_item_content, "field 'appDetailItem3ItemAddItemContent'", TextView.class);
            secondHolder.appDetailItem3ItemAddItemDuTv = (TextView) butterknife.c.a.c(view, R.id.app_detail_item3_item_add_item_du_tv, "field 'appDetailItem3ItemAddItemDuTv'", TextView.class);
            secondHolder.appDetailItem3ItemAddItemUuTv = (TextView) butterknife.c.a.c(view, R.id.app_detail_item3_item_add_item_uu_tv, "field 'appDetailItem3ItemAddItemUuTv'", TextView.class);
            secondHolder.appDetailItem3ItemAddItemUuLy = (LinearLayout) butterknife.c.a.c(view, R.id.app_detail_item3_item_add_item_uu_ly, "field 'appDetailItem3ItemAddItemUuLy'", LinearLayout.class);
            secondHolder.appDetailItem3ItemAddItemCommentLy = (LinearLayout) butterknife.c.a.c(view, R.id.app_detail_item3_item_add_item_comment_ly, "field 'appDetailItem3ItemAddItemCommentLy'", LinearLayout.class);
            secondHolder.appDetailItem3ItemAddItemAdminLy = (LinearLayout) butterknife.c.a.c(view, R.id.app_detail_item3_item_add_item_admin_ly, "field 'appDetailItem3ItemAddItemAdminLy'", LinearLayout.class);
            secondHolder.appDetails3ItemAddItemLayout = (LinearLayout) butterknife.c.a.c(view, R.id.app_details3_item_add_item_layout, "field 'appDetails3ItemAddItemLayout'", LinearLayout.class);
        }

        @CallSuper
        public void a() {
            SecondHolder secondHolder = this.b;
            if (secondHolder != null) {
                this.b = null;
                secondHolder.appDetailItem3ItemAddItemImg = null;
                secondHolder.appDetailItem3ItemAddItemTime = null;
                secondHolder.appDetailItem3ItemAddItemName = null;
                secondHolder.appDetailItem3ItemAddItemContent = null;
                secondHolder.appDetailItem3ItemAddItemDuTv = null;
                secondHolder.appDetailItem3ItemAddItemUuTv = null;
                secondHolder.appDetailItem3ItemAddItemUuLy = null;
                secondHolder.appDetailItem3ItemAddItemCommentLy = null;
                secondHolder.appDetailItem3ItemAddItemAdminLy = null;
                secondHolder.appDetails3ItemAddItemLayout = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        LinearLayout gameDetailItem2CommentItemAddLy;

        @BindView
        TextView gameDetailItem2CommentItemCommentBtu;

        @BindView
        TextView gameDetailItem2CommentItemContent;

        @BindView
        TextView gameDetailItem2CommentItemDelete;

        @BindView
        TextView gameDetailItem2CommentItemDuTv;

        @BindView
        ImageView gameDetailItem2CommentItemImg;

        @BindView
        LinearLayout gameDetailItem2CommentItemImgLv;

        @BindView
        TextView gameDetailItem2CommentItemName;

        @BindView
        ImageView gameDetailItem2CommentItemStart;

        @BindView
        TextView gameDetailItem2CommentItemTime;

        @BindView
        FlowLayout gameDetailItem2CommentItemUpSrc;

        @BindView
        TextView gameDetailItem2CommentItemUuTv;

        ViewHolder(GameDetailsCommentAdapter gameDetailsCommentAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.gameDetailItem2CommentItemImgLv = (LinearLayout) butterknife.c.a.c(view, R.id.game_detail_item2_comment_item_img_lv, "field 'gameDetailItem2CommentItemImgLv'", LinearLayout.class);
            viewHolder.gameDetailItem2CommentItemImg = (ImageView) butterknife.c.a.c(view, R.id.game_detail_item2_comment_item_img, "field 'gameDetailItem2CommentItemImg'", ImageView.class);
            viewHolder.gameDetailItem2CommentItemName = (TextView) butterknife.c.a.c(view, R.id.game_detail_item2_comment_item_name, "field 'gameDetailItem2CommentItemName'", TextView.class);
            viewHolder.gameDetailItem2CommentItemStart = (ImageView) butterknife.c.a.c(view, R.id.game_detail_item2_comment_item_start, "field 'gameDetailItem2CommentItemStart'", ImageView.class);
            viewHolder.gameDetailItem2CommentItemContent = (TextView) butterknife.c.a.c(view, R.id.game_detail_item2_comment_item_content, "field 'gameDetailItem2CommentItemContent'", TextView.class);
            viewHolder.gameDetailItem2CommentItemTime = (TextView) butterknife.c.a.c(view, R.id.game_detail_item2_comment_item_time, "field 'gameDetailItem2CommentItemTime'", TextView.class);
            viewHolder.gameDetailItem2CommentItemDelete = (TextView) butterknife.c.a.c(view, R.id.game_detail_item2_comment_item_delete, "field 'gameDetailItem2CommentItemDelete'", TextView.class);
            viewHolder.gameDetailItem2CommentItemDuTv = (TextView) butterknife.c.a.c(view, R.id.game_detail_item2_comment_item_du_tv, "field 'gameDetailItem2CommentItemDuTv'", TextView.class);
            viewHolder.gameDetailItem2CommentItemUuTv = (TextView) butterknife.c.a.c(view, R.id.game_detail_item2_comment_item_uu_tv, "field 'gameDetailItem2CommentItemUuTv'", TextView.class);
            viewHolder.gameDetailItem2CommentItemCommentBtu = (TextView) butterknife.c.a.c(view, R.id.game_detail_item2_comment_item_commentBtu, "field 'gameDetailItem2CommentItemCommentBtu'", TextView.class);
            viewHolder.gameDetailItem2CommentItemUpSrc = (FlowLayout) butterknife.c.a.c(view, R.id.game_detail_item2_comment_item_up_src, "field 'gameDetailItem2CommentItemUpSrc'", FlowLayout.class);
            viewHolder.gameDetailItem2CommentItemAddLy = (LinearLayout) butterknife.c.a.c(view, R.id.game_detail_item2_comment_item_add_ly, "field 'gameDetailItem2CommentItemAddLy'", LinearLayout.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.gameDetailItem2CommentItemImgLv = null;
                viewHolder.gameDetailItem2CommentItemImg = null;
                viewHolder.gameDetailItem2CommentItemName = null;
                viewHolder.gameDetailItem2CommentItemStart = null;
                viewHolder.gameDetailItem2CommentItemContent = null;
                viewHolder.gameDetailItem2CommentItemTime = null;
                viewHolder.gameDetailItem2CommentItemDelete = null;
                viewHolder.gameDetailItem2CommentItemDuTv = null;
                viewHolder.gameDetailItem2CommentItemUuTv = null;
                viewHolder.gameDetailItem2CommentItemCommentBtu = null;
                viewHolder.gameDetailItem2CommentItemUpSrc = null;
                viewHolder.gameDetailItem2CommentItemAddLy = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            com.rtk.app.tool.t.B0(GameDetailsCommentAdapter.this.d, intValue + "");
        }
    }

    public GameDetailsCommentAdapter(Context context, List<GameCommentBean.DataBean> list, String str, String str2) {
        super(list);
        this.i = new ArrayList();
        this.d = context;
        this.e = list;
        this.g = str;
        this.h = str2;
        this.f52c = com.rtk.app.main.comment.express.c.g();
        this.i = com.rtk.app.tool.t.J(context, this.f);
    }

    private void m(FlowLayout flowLayout, List<String> list, int i) {
        flowLayout.removeAllViews();
        if (list == null || list.size() < 0) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            View inflate = LayoutInflater.from(this.d).inflate(R.layout.just_image_view_layout, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.just_imageView);
            flowLayout.addView(inflate);
            com.rtk.app.tool.t.c(this.d, list.get(i2), imageView, new boolean[0]);
            imageView.setOnClickListener(new b(4, i, i2));
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        View view2;
        ViewGroup viewGroup2 = null;
        if (view == null) {
            view2 = LayoutInflater.from(this.d).inflate(R.layout.game_details_item2_comment_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(this, view2);
            view2.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
            view2 = view;
        }
        GameCommentBean.DataBean dataBean = this.e.get(i);
        com.rtk.app.tool.t.d(this.d, dataBean.getU_face(), viewHolder.gameDetailItem2CommentItemImg);
        viewHolder.gameDetailItem2CommentItemName.setText(dataBean.getU_name());
        viewHolder.gameDetailItem2CommentItemContent.setText(this.f52c.a(dataBean.getContent()));
        viewHolder.gameDetailItem2CommentItemTime.setText(com.rtk.app.tool.c0.f(dataBean.getTime()));
        viewHolder.gameDetailItem2CommentItemDuTv.setText(dataBean.getDu() + "");
        viewHolder.gameDetailItem2CommentItemUuTv.setText(dataBean.getUu() + "");
        int i2 = 8;
        if (dataBean.getIs_admin() == 1) {
            viewHolder.gameDetailItem2CommentItemAddLy.setVisibility(8);
        } else {
            viewHolder.gameDetailItem2CommentItemAddLy.setVisibility(0);
        }
        com.rtk.app.tool.t.Q1(dataBean.getStar(), viewHolder.gameDetailItem2CommentItemStart);
        viewHolder.gameDetailItem2CommentItemCommentBtu.setOnClickListener(new b(2, i));
        viewHolder.gameDetailItem2CommentItemDuTv.setOnClickListener(new b(0, i));
        viewHolder.gameDetailItem2CommentItemUuTv.setOnClickListener(new b(1, i));
        if (dataBean.getIs_admin() == 0) {
            viewHolder.gameDetailItem2CommentItemAddLy.setVisibility(0);
        } else {
            viewHolder.gameDetailItem2CommentItemAddLy.setVisibility(8);
        }
        viewHolder.gameDetailItem2CommentItemAddLy.removeAllViews();
        if (dataBean.getReply() != null && dataBean.getReply().size() > 0) {
            int i3 = 0;
            while (i3 < dataBean.getReply().size()) {
                GameCommentBean.DataBean.ReplyBean replyBean = dataBean.getReply().get(i3);
                View inflate = LayoutInflater.from(this.d).inflate(R.layout.app_datail_item3_item_add_item, viewGroup2);
                SecondHolder secondHolder = new SecondHolder(this, inflate);
                secondHolder.appDetailItem3ItemAddItemDuTv.setText(dataBean.getReply().get(i3).getDu() + "");
                secondHolder.appDetailItem3ItemAddItemUuTv.setText(dataBean.getReply().get(i3).getUu() + "");
                secondHolder.appDetailItem3ItemAddItemName.setText(dataBean.getReply().get(i3).getU_name() + "：");
                secondHolder.appDetailItem3ItemAddItemTime.setText(com.rtk.app.tool.c0.f((long) dataBean.getReply().get(i3).getTime()));
                secondHolder.appDetailItem3ItemAddItemContent.setText(this.f52c.a(replyBean.getContent()));
                viewHolder.gameDetailItem2CommentItemAddLy.addView(inflate);
                i3++;
                viewGroup2 = null;
            }
        }
        viewHolder.gameDetailItem2CommentItemDelete.setOnClickListener(new b(3, i));
        viewHolder.gameDetailItem2CommentItemImgLv.setTag(Integer.valueOf(this.e.get(i).getUid()));
        viewHolder.gameDetailItem2CommentItemImgLv.setOnClickListener(new a());
        TextView textView = viewHolder.gameDetailItem2CommentItemDelete;
        if (c.d.a.d.d() && (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getCommentadmin() == 1)) {
            i2 = 0;
        }
        textView.setVisibility(i2);
        m(viewHolder.gameDetailItem2CommentItemUpSrc, this.e.get(i).getPic(), i);
        return view2;
    }

    public void n(int i) {
        this.f = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements View.OnClickListener, h.j {
        private int a;
        private int b;

        /* renamed from: c, reason: collision with root package name */
        private int f53c;
        private String d = "add";
        private DialogForProgressTip e;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        class a implements com.rtk.app.tool.s {
            a() {
            }

            @Override // com.rtk.app.tool.s
            public void a(String... strArr) {
                String str = strArr[0];
                Context context = GameDetailsCommentAdapter.this.d;
                b bVar = b.this;
                com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e);
                StringBuilder sb = new StringBuilder();
                sb.append("up/comment/delete");
                sb.append(com.rtk.app.tool.y.u(GameDetailsCommentAdapter.this.d));
                sb.append("&uid=");
                sb.append(com.rtk.app.tool.y.K());
                sb.append("&token=");
                sb.append(com.rtk.app.tool.y.H());
                sb.append("&cid=");
                sb.append(((GameCommentBean.DataBean) GameDetailsCommentAdapter.this.e.get(b.this.b)).getCmtid());
                sb.append("&table=game&msg=");
                sb.append(str);
                sb.append("&key=");
                sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(GameDetailsCommentAdapter.this.d, "cid=" + ((GameCommentBean.DataBean) GameDetailsCommentAdapter.this.e.get(b.this.b)).getCmtid(), "table=game", "msg=" + str, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
                com.rtk.app.tool.o.h.l(context, bVar, 3, h.a(sb.toString()));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("删除评论链接");
                sb2.append(com.rtk.app.tool.y.e);
                sb2.append("up/comment/delete");
                sb2.append(com.rtk.app.tool.y.u(GameDetailsCommentAdapter.this.d));
                sb2.append("&uid=");
                sb2.append(com.rtk.app.tool.y.K());
                sb2.append("&token=");
                sb2.append(com.rtk.app.tool.y.H());
                sb2.append("&cid=");
                sb2.append(((GameCommentBean.DataBean) GameDetailsCommentAdapter.this.e.get(b.this.b)).getCmtid());
                sb2.append("&table=game&msg=");
                sb2.append(str);
                sb2.append("&key=");
                sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(GameDetailsCommentAdapter.this.d, "cid=" + ((GameCommentBean.DataBean) GameDetailsCommentAdapter.this.e.get(b.this.b)).getCmtid(), "table=game", "msg=" + str, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
                com.rtk.app.tool.c0.u("GameDetailsCommentAdapter", sb2.toString());
                b.this.e = new DialogForProgressTip(GameDetailsCommentAdapter.this.d, "删除中，请稍后...");
                b.this.e.show();
            }
        }

        public b(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
        }

        @Override // com.rtk.app.tool.o.h.j
        public void d(String str, int i) {
            if (i != 3) {
                return;
            }
            com.rtk.app.tool.c0.u("GameDetailsCommentAdapter", "删除评论成功" + str);
            DialogForProgressTip dialogForProgressTip = this.e;
            if (dialogForProgressTip != null) {
                dialogForProgressTip.dismiss();
            }
            GameDetailsCommentAdapter.this.e.remove(this.b);
            com.rtk.app.tool.f.a(GameDetailsCommentAdapter.this.d, "删除成功", f.a.f);
            GameDetailsCommentAdapter.this.notifyDataSetChanged();
        }

        @Override // com.rtk.app.tool.o.h.j
        public void g(int i, String str, int i2) {
            if (i2 != 3) {
                return;
            }
            DialogForProgressTip dialogForProgressTip = this.e;
            if (dialogForProgressTip != null) {
                dialogForProgressTip.dismiss();
            }
            com.rtk.app.tool.f.a(GameDetailsCommentAdapter.this.d, str, f.a.f);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new Bundle();
            int i = this.a;
            if (i == 0) {
                GameDetailsCommentAdapter gameDetailsCommentAdapter = GameDetailsCommentAdapter.this;
                gameDetailsCommentAdapter.i = com.rtk.app.tool.t.J(gameDetailsCommentAdapter.d, GameDetailsCommentAdapter.this.f);
                if (GameDetailsCommentAdapter.this.i.contains(Integer.valueOf(((GameCommentBean.DataBean) GameDetailsCommentAdapter.this.e.get(this.b)).getCmtid()))) {
                    com.rtk.app.tool.f.a(GameDetailsCommentAdapter.this.d, "不可重复操作", f.a.f);
                    return;
                }
                ((GameCommentBean.DataBean) GameDetailsCommentAdapter.this.e.get(this.b)).setDu(((GameCommentBean.DataBean) GameDetailsCommentAdapter.this.e.get(this.b)).getDu() + 1);
                com.rtk.app.tool.t.a(GameDetailsCommentAdapter.this.d, GameDetailsCommentAdapter.this.f, ((GameCommentBean.DataBean) GameDetailsCommentAdapter.this.e.get(this.b)).getCmtid());
                GameDetailsCommentAdapter.this.notifyDataSetChanged();
                Context context = GameDetailsCommentAdapter.this.d;
                com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(new String[0]);
                StringBuilder sb = new StringBuilder();
                sb.append("game/gameCommentOp");
                sb.append(com.rtk.app.tool.y.u(GameDetailsCommentAdapter.this.d));
                sb.append("&cmtid=");
                sb.append(((GameCommentBean.DataBean) GameDetailsCommentAdapter.this.e.get(this.b)).getCmtid());
                sb.append("&op=du&type=");
                sb.append(this.d);
                sb.append("&key=");
                sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(GameDetailsCommentAdapter.this.d, "cmtid=" + ((GameCommentBean.DataBean) GameDetailsCommentAdapter.this.e.get(this.b)).getCmtid(), "op=du", "type=" + this.d))));
                com.rtk.app.tool.o.h.l(context, this, 0, h.a(sb.toString()));
                return;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        new DialogForGameCommentDeleteReason(GameDetailsCommentAdapter.this.d, new a()).show();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        com.rtk.app.tool.t.C0(GameDetailsCommentAdapter.this.d, ((GameCommentBean.DataBean) GameDetailsCommentAdapter.this.e.get(this.b)).getPic(), this.f53c);
                        return;
                    }
                }
                com.rtk.app.tool.t.l0(GameDetailsCommentAdapter.this.d, this.b, GameDetailsCommentAdapter.this.f, ((GameCommentBean.DataBean) GameDetailsCommentAdapter.this.e.get(this.b)).getCmtid(), ((GameCommentBean.DataBean) GameDetailsCommentAdapter.this.e.get(this.b)).getCmtid(), 0 + GameDetailsCommentAdapter.this.g, GameDetailsCommentAdapter.this.h, new String[0]);
                return;
            }
            GameDetailsCommentAdapter gameDetailsCommentAdapter2 = GameDetailsCommentAdapter.this;
            gameDetailsCommentAdapter2.i = com.rtk.app.tool.t.J(gameDetailsCommentAdapter2.d, GameDetailsCommentAdapter.this.f);
            if (GameDetailsCommentAdapter.this.i.contains(Integer.valueOf(((GameCommentBean.DataBean) GameDetailsCommentAdapter.this.e.get(this.b)).getCmtid()))) {
                com.rtk.app.tool.f.a(GameDetailsCommentAdapter.this.d, "不可重复操作", f.a.f);
                return;
            }
            ((GameCommentBean.DataBean) GameDetailsCommentAdapter.this.e.get(this.b)).setUu(((GameCommentBean.DataBean) GameDetailsCommentAdapter.this.e.get(this.b)).getUu() + 1);
            com.rtk.app.tool.t.a(GameDetailsCommentAdapter.this.d, GameDetailsCommentAdapter.this.f, ((GameCommentBean.DataBean) GameDetailsCommentAdapter.this.e.get(this.b)).getCmtid());
            GameDetailsCommentAdapter.this.notifyDataSetChanged();
            Context context2 = GameDetailsCommentAdapter.this.d;
            com.rtk.app.tool.o.i h2 = com.rtk.app.tool.o.h.h(new String[0]);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("game/gameCommentOp");
            sb2.append(com.rtk.app.tool.y.u(GameDetailsCommentAdapter.this.d));
            sb2.append("&cmtid=");
            sb2.append(((GameCommentBean.DataBean) GameDetailsCommentAdapter.this.e.get(this.b)).getCmtid());
            sb2.append("&op=uu&type=");
            sb2.append(this.d);
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(GameDetailsCommentAdapter.this.d, "cmtid=" + ((GameCommentBean.DataBean) GameDetailsCommentAdapter.this.e.get(this.b)).getCmtid(), "op=uu", "type=" + this.d))));
            com.rtk.app.tool.o.h.l(context2, this, 1, h2.a(sb2.toString()));
        }

        public b(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }
}
