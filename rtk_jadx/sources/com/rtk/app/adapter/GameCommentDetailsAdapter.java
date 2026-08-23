package com.rtk.app.adapter;

import android.content.Context;
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
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.bean.CommentDetailsBean;
import com.rtk.app.bean.ResponseDataBean;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.dialogPack.DialogForGameCommentDeleteReason;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GameCommentDetailsAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private com.rtk.app.main.comment.express.c f50c;
    private Context d;
    private List<CommentDetailsBean.DataBean.ReplyBean> e;
    private List<Integer> f;
    private int g;
    private String h;
    private String i;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        LinearLayout appDetailItem2ItemAddItemAdminLy;

        @BindView
        LinearLayout appDetailItem2ItemAddItemCommentLy;

        @BindView
        TextView appDetailItem2ItemAddItemContent;

        @BindView
        TextView appDetailItem2ItemAddItemDelete;

        @BindView
        LinearLayout appDetailItem2ItemAddItemDuLy;

        @BindView
        TextView appDetailItem2ItemAddItemDuTv;

        @BindView
        ImageView appDetailItem2ItemAddItemImg;

        @BindView
        TextView appDetailItem2ItemAddItemName;

        @BindView
        TextView appDetailItem2ItemAddItemPhone;

        @BindView
        TextView appDetailItem2ItemAddItemTime;

        @BindView
        LinearLayout appDetailItem2ItemAddItemUuLy;

        @BindView
        TextView appDetailItem2ItemAddItemUuTv;

        ViewHolder(GameCommentDetailsAdapter gameCommentDetailsAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.appDetailItem2ItemAddItemImg = (ImageView) butterknife.c.a.c(view, R.id.app_detail_item2_item_add_for_gameitem_img, "field 'appDetailItem2ItemAddItemImg'", ImageView.class);
            viewHolder.appDetailItem2ItemAddItemName = (TextView) butterknife.c.a.c(view, R.id.app_detail_item2_item_add_for_gameitem_name, "field 'appDetailItem2ItemAddItemName'", TextView.class);
            viewHolder.appDetailItem2ItemAddItemTime = (TextView) butterknife.c.a.c(view, R.id.app_detail_item2_item_add_for_gameitem_time, "field 'appDetailItem2ItemAddItemTime'", TextView.class);
            viewHolder.appDetailItem2ItemAddItemContent = (TextView) butterknife.c.a.c(view, R.id.app_detail_item2_item_add_for_gameitem_content, "field 'appDetailItem2ItemAddItemContent'", TextView.class);
            viewHolder.appDetailItem2ItemAddItemDelete = (TextView) butterknife.c.a.c(view, R.id.app_detail_item2_item_add_for_gameitem_delete, "field 'appDetailItem2ItemAddItemDelete'", TextView.class);
            viewHolder.appDetailItem2ItemAddItemDuTv = (TextView) butterknife.c.a.c(view, R.id.app_detail_item2_item_add_for_gameitem_du_tv, "field 'appDetailItem2ItemAddItemDuTv'", TextView.class);
            viewHolder.appDetailItem2ItemAddItemDuLy = (LinearLayout) butterknife.c.a.c(view, R.id.app_detail_item2_item_add_for_gameitem_du_ly, "field 'appDetailItem2ItemAddItemDuLy'", LinearLayout.class);
            viewHolder.appDetailItem2ItemAddItemUuTv = (TextView) butterknife.c.a.c(view, R.id.app_detail_item2_item_add_for_gameitem_uu_tv, "field 'appDetailItem2ItemAddItemUuTv'", TextView.class);
            viewHolder.appDetailItem2ItemAddItemUuLy = (LinearLayout) butterknife.c.a.c(view, R.id.app_detail_item2_item_add_for_gameitem_uu_ly, "field 'appDetailItem2ItemAddItemUuLy'", LinearLayout.class);
            viewHolder.appDetailItem2ItemAddItemCommentLy = (LinearLayout) butterknife.c.a.c(view, R.id.app_detail_item2_item_add_for_gameitem_comment_ly, "field 'appDetailItem2ItemAddItemCommentLy'", LinearLayout.class);
            viewHolder.appDetailItem2ItemAddItemAdminLy = (LinearLayout) butterknife.c.a.c(view, R.id.app_detail_item2_item_add_for_gameitem_admin_ly, "field 'appDetailItem2ItemAddItemAdminLy'", LinearLayout.class);
            viewHolder.appDetailItem2ItemAddItemPhone = (TextView) butterknife.c.a.c(view, R.id.app_detail_item2_item_add_for_gameitem_phone, "field 'appDetailItem2ItemAddItemPhone'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.appDetailItem2ItemAddItemImg = null;
                viewHolder.appDetailItem2ItemAddItemName = null;
                viewHolder.appDetailItem2ItemAddItemTime = null;
                viewHolder.appDetailItem2ItemAddItemContent = null;
                viewHolder.appDetailItem2ItemAddItemDelete = null;
                viewHolder.appDetailItem2ItemAddItemDuTv = null;
                viewHolder.appDetailItem2ItemAddItemDuLy = null;
                viewHolder.appDetailItem2ItemAddItemUuTv = null;
                viewHolder.appDetailItem2ItemAddItemUuLy = null;
                viewHolder.appDetailItem2ItemAddItemCommentLy = null;
                viewHolder.appDetailItem2ItemAddItemAdminLy = null;
                viewHolder.appDetailItem2ItemAddItemPhone = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements View.OnClickListener, h.j {
        int a;
        int b;

        /* renamed from: c, reason: collision with root package name */
        String f51c = "add";
        int d;
        private int e;
        private DialogForProgressTip f;

        /* renamed from: com.rtk.app.adapter.GameCommentDetailsAdapter$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        class C0013a implements com.rtk.app.tool.s {
            C0013a() {
            }

            @Override // com.rtk.app.tool.s
            public void a(String... strArr) {
                String str = strArr[0];
                Context context = GameCommentDetailsAdapter.this.d;
                a aVar = a.this;
                com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e);
                StringBuilder sb = new StringBuilder();
                sb.append("up/comment/delete");
                sb.append(com.rtk.app.tool.y.u(GameCommentDetailsAdapter.this.d));
                sb.append("&uid=");
                sb.append(com.rtk.app.tool.y.K());
                sb.append("&token=");
                sb.append(com.rtk.app.tool.y.H());
                sb.append("&cid=");
                sb.append(((CommentDetailsBean.DataBean.ReplyBean) GameCommentDetailsAdapter.this.e.get(a.this.b)).getCmtid());
                sb.append("&table=game&msg=");
                sb.append(str);
                sb.append("&key=");
                sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(GameCommentDetailsAdapter.this.d, "cid=" + ((CommentDetailsBean.DataBean.ReplyBean) GameCommentDetailsAdapter.this.e.get(a.this.b)).getCmtid(), "table=game", "msg=" + str, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
                com.rtk.app.tool.o.h.l(context, aVar, 3, h.a(sb.toString()));
                a.this.f = new DialogForProgressTip(GameCommentDetailsAdapter.this.d, "删除中，请稍后...");
                a.this.f.show();
            }
        }

        a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // com.rtk.app.tool.o.h.j
        public void d(String str, int i) {
            if (((ResponseDataBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, ResponseDataBean.class)).getCode() == 0) {
                if (i == 3) {
                    DialogForProgressTip dialogForProgressTip = this.f;
                    if (dialogForProgressTip != null) {
                        dialogForProgressTip.dismiss();
                    }
                    GameCommentDetailsAdapter.this.e.remove(this.b);
                    GameCommentDetailsAdapter.this.notifyDataSetChanged();
                    com.rtk.app.tool.f.a(GameCommentDetailsAdapter.this.d, "删除成功", f.a.f);
                }
                GameCommentDetailsAdapter.this.notifyDataSetChanged();
            }
        }

        @Override // com.rtk.app.tool.o.h.j
        public void g(int i, String str, int i2) {
            DialogForProgressTip dialogForProgressTip;
            com.rtk.app.tool.f.a(GameCommentDetailsAdapter.this.d, str, f.a.f);
            if (i2 == 4 && (dialogForProgressTip = this.f) != null) {
                dialogForProgressTip.dismiss();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.d = ((CommentDetailsBean.DataBean.ReplyBean) GameCommentDetailsAdapter.this.e.get(this.b)).getCmtid();
            this.e = ((CommentDetailsBean.DataBean.ReplyBean) GameCommentDetailsAdapter.this.e.get(this.b)).getRoot_reply_id();
            int i = this.a;
            if (i == 0) {
                GameCommentDetailsAdapter gameCommentDetailsAdapter = GameCommentDetailsAdapter.this;
                gameCommentDetailsAdapter.f = com.rtk.app.tool.t.J(gameCommentDetailsAdapter.d, GameCommentDetailsAdapter.this.g);
                if (!GameCommentDetailsAdapter.this.f.contains(Integer.valueOf(this.d))) {
                    ((CommentDetailsBean.DataBean.ReplyBean) GameCommentDetailsAdapter.this.e.get(this.b)).setDu(((CommentDetailsBean.DataBean.ReplyBean) GameCommentDetailsAdapter.this.e.get(this.b)).getDu() + 1);
                    com.rtk.app.tool.t.a(GameCommentDetailsAdapter.this.d, GameCommentDetailsAdapter.this.g, this.d);
                    Context context = GameCommentDetailsAdapter.this.d;
                    com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(new String[0]);
                    StringBuilder sb = new StringBuilder();
                    sb.append("game/gameCommentOp");
                    sb.append(com.rtk.app.tool.y.u(GameCommentDetailsAdapter.this.d));
                    sb.append("&cmtid=");
                    sb.append(this.d);
                    sb.append("&op=du&type=");
                    sb.append(this.f51c);
                    sb.append("&key=");
                    sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(GameCommentDetailsAdapter.this.d, "cmtid=" + this.d, "op=du", "type=" + this.f51c))));
                    com.rtk.app.tool.o.h.l(context, this, 0, h.a(sb.toString()));
                    return;
                }
                com.rtk.app.tool.f.a(GameCommentDetailsAdapter.this.d, "不可重复操作", f.a.f);
                return;
            }
            if (i != 1) {
                if (i == 2) {
                    com.rtk.app.tool.t.l0(GameCommentDetailsAdapter.this.d, this.b, GameCommentDetailsAdapter.this.g, this.d, this.e, GameCommentDetailsAdapter.this.h, GameCommentDetailsAdapter.this.i, new String[0]);
                    return;
                }
                if (i != 3) {
                    if (i != 4) {
                        return;
                    }
                    new DialogForGameCommentDeleteReason(GameCommentDetailsAdapter.this.d, new C0013a()).show();
                    return;
                } else {
                    com.rtk.app.tool.t.B0(GameCommentDetailsAdapter.this.d, ((CommentDetailsBean.DataBean.ReplyBean) GameCommentDetailsAdapter.this.e.get(this.b)).getUid() + "");
                    return;
                }
            }
            GameCommentDetailsAdapter gameCommentDetailsAdapter2 = GameCommentDetailsAdapter.this;
            gameCommentDetailsAdapter2.f = com.rtk.app.tool.t.J(gameCommentDetailsAdapter2.d, GameCommentDetailsAdapter.this.g);
            if (!GameCommentDetailsAdapter.this.f.contains(Integer.valueOf(this.d))) {
                ((CommentDetailsBean.DataBean.ReplyBean) GameCommentDetailsAdapter.this.e.get(this.b)).setUu(((CommentDetailsBean.DataBean.ReplyBean) GameCommentDetailsAdapter.this.e.get(this.b)).getUu() + 1);
                com.rtk.app.tool.t.a(GameCommentDetailsAdapter.this.d, GameCommentDetailsAdapter.this.g, this.d);
                Context context2 = GameCommentDetailsAdapter.this.d;
                com.rtk.app.tool.o.i h2 = com.rtk.app.tool.o.h.h(new String[0]);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("game/gameCommentOp");
                sb2.append(com.rtk.app.tool.y.u(GameCommentDetailsAdapter.this.d));
                sb2.append("&cmtid=");
                sb2.append(this.d);
                sb2.append("&op=uu&type=");
                sb2.append(this.f51c);
                sb2.append("&key=");
                sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(GameCommentDetailsAdapter.this.d, "cmtid=" + this.d, "op=uu", "type=" + this.f51c))));
                com.rtk.app.tool.o.h.l(context2, this, 1, h2.a(sb2.toString()));
                return;
            }
            com.rtk.app.tool.f.a(GameCommentDetailsAdapter.this.d, "不可重复操作", f.a.f);
        }
    }

    public GameCommentDetailsAdapter(Context context, List<CommentDetailsBean.DataBean.ReplyBean> list, int i, String str, String str2) {
        super(list);
        this.f = new ArrayList();
        this.d = context;
        this.e = list;
        this.g = i;
        this.h = str;
        this.i = str2;
        this.f50c = com.rtk.app.main.comment.express.c.g();
        this.f = com.rtk.app.tool.t.J(context, i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.d).inflate(R.layout.app_datail_item2_item_add_for_game_item, (ViewGroup) null);
            viewHolder = new ViewHolder(this, view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        CommentDetailsBean.DataBean.ReplyBean replyBean = this.e.get(i);
        com.rtk.app.tool.t.d(this.d, replyBean.getU_face(), viewHolder.appDetailItem2ItemAddItemImg);
        viewHolder.appDetailItem2ItemAddItemName.setText(replyBean.getU_name());
        viewHolder.appDetailItem2ItemAddItemContent.setText(this.f50c.a(replyBean.getContent()));
        viewHolder.appDetailItem2ItemAddItemTime.setText(com.rtk.app.tool.c0.o(replyBean.getTime()));
        viewHolder.appDetailItem2ItemAddItemDuTv.setText(replyBean.getDu() + "");
        viewHolder.appDetailItem2ItemAddItemUuTv.setText(replyBean.getUu() + "");
        viewHolder.appDetailItem2ItemAddItemPhone.setText(replyBean.getPhone_model());
        viewHolder.appDetailItem2ItemAddItemDuLy.setOnClickListener(new a(0, i));
        viewHolder.appDetailItem2ItemAddItemUuLy.setOnClickListener(new a(1, i));
        viewHolder.appDetailItem2ItemAddItemCommentLy.setOnClickListener(new a(2, i));
        viewHolder.appDetailItem2ItemAddItemImg.setOnClickListener(new a(3, i));
        viewHolder.appDetailItem2ItemAddItemDelete.setOnClickListener(new a(4, i));
        viewHolder.appDetailItem2ItemAddItemDelete.setVisibility((c.d.a.d.d() && (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getCommentadmin() == 1)) ? 0 : 8);
        if (replyBean.getIs_admin() == 1) {
            viewHolder.appDetailItem2ItemAddItemAdminLy.setVisibility(8);
        } else {
            viewHolder.appDetailItem2ItemAddItemAdminLy.setVisibility(0);
        }
        return view;
    }
}
