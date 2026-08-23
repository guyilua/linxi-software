package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.bean.DuOrUpBean;
import com.rtk.app.bean.UpApkCommentDetailsBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.dialogPack.DialogForGameCommentDeleteReason;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpApkCommentDetailsAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private com.rtk.app.main.comment.express.c f111c;
    private List<UpApkCommentDetailsBean.DataBean.ReplyBean> d;
    private Context e;
    private int f;
    private String g;
    private int h;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ViewHolder {

        @BindView
        LinearLayout appDetailItem2ItemAddItemAdminLy;

        @BindView
        TextView appDetailItem2ItemAddItemCommentLy;

        @BindView
        TextView appDetailItem2ItemAddItemContent;

        @BindView
        TextView appDetailItem2ItemAddItemDelete;

        @BindView
        CheckBox appDetailItem2ItemAddItemDuTv;

        @BindView
        TextView appDetailItem2ItemAddItemFloor;

        @BindView
        ImageView appDetailItem2ItemAddItemImg;

        @BindView
        LinearLayout appDetailItem2ItemAddItemImgLv;

        @BindView
        TextView appDetailItem2ItemAddItemIsUpMain;

        @BindView
        CustomTextView appDetailItem2ItemAddItemName;

        @BindView
        TextView appDetailItem2ItemAddItemPhone;

        @BindView
        TextView appDetailItem2ItemAddItemTime;

        @BindView
        TextView appDetailItem2ItemAddItemUuTv;

        ViewHolder(View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.appDetailItem2ItemAddItemImgLv = (LinearLayout) butterknife.c.a.c(view, R.id.app_detail_item2_item_add_item_img_lv, "field 'appDetailItem2ItemAddItemImgLv'", LinearLayout.class);
            viewHolder.appDetailItem2ItemAddItemImg = (ImageView) butterknife.c.a.c(view, R.id.app_detail_item2_item_add_item_img, "field 'appDetailItem2ItemAddItemImg'", ImageView.class);
            viewHolder.appDetailItem2ItemAddItemName = (CustomTextView) butterknife.c.a.c(view, R.id.app_detail_item2_item_add_item_name, "field 'appDetailItem2ItemAddItemName'", CustomTextView.class);
            viewHolder.appDetailItem2ItemAddItemTime = (TextView) butterknife.c.a.c(view, R.id.app_detail_item2_item_add_item_time, "field 'appDetailItem2ItemAddItemTime'", TextView.class);
            viewHolder.appDetailItem2ItemAddItemIsUpMain = (TextView) butterknife.c.a.c(view, R.id.app_detail_item2_item_add_item_isUpMain, "field 'appDetailItem2ItemAddItemIsUpMain'", TextView.class);
            viewHolder.appDetailItem2ItemAddItemContent = (TextView) butterknife.c.a.c(view, R.id.app_detail_item2_item_add_item_content, "field 'appDetailItem2ItemAddItemContent'", TextView.class);
            viewHolder.appDetailItem2ItemAddItemDelete = (TextView) butterknife.c.a.c(view, R.id.app_detail_item2_item_add_item_delete, "field 'appDetailItem2ItemAddItemDelete'", TextView.class);
            viewHolder.appDetailItem2ItemAddItemFloor = (TextView) butterknife.c.a.c(view, R.id.app_detail_item2_item_add_item_floor, "field 'appDetailItem2ItemAddItemFloor'", TextView.class);
            viewHolder.appDetailItem2ItemAddItemDuTv = (CheckBox) butterknife.c.a.c(view, R.id.app_detail_item2_item_add_item_du_tv, "field 'appDetailItem2ItemAddItemDuTv'", CheckBox.class);
            viewHolder.appDetailItem2ItemAddItemUuTv = (TextView) butterknife.c.a.c(view, R.id.app_detail_item2_item_add_item_uu_tv, "field 'appDetailItem2ItemAddItemUuTv'", TextView.class);
            viewHolder.appDetailItem2ItemAddItemCommentLy = (TextView) butterknife.c.a.c(view, R.id.app_detail_item2_item_add_item_comment_ly, "field 'appDetailItem2ItemAddItemCommentLy'", TextView.class);
            viewHolder.appDetailItem2ItemAddItemAdminLy = (LinearLayout) butterknife.c.a.c(view, R.id.app_detail_item2_item_add_item_admin_ly, "field 'appDetailItem2ItemAddItemAdminLy'", LinearLayout.class);
            viewHolder.appDetailItem2ItemAddItemPhone = (TextView) butterknife.c.a.c(view, R.id.app_detail_item2_item_add_item_phone, "field 'appDetailItem2ItemAddItemPhone'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.appDetailItem2ItemAddItemImgLv = null;
                viewHolder.appDetailItem2ItemAddItemImg = null;
                viewHolder.appDetailItem2ItemAddItemName = null;
                viewHolder.appDetailItem2ItemAddItemTime = null;
                viewHolder.appDetailItem2ItemAddItemIsUpMain = null;
                viewHolder.appDetailItem2ItemAddItemContent = null;
                viewHolder.appDetailItem2ItemAddItemDelete = null;
                viewHolder.appDetailItem2ItemAddItemFloor = null;
                viewHolder.appDetailItem2ItemAddItemDuTv = null;
                viewHolder.appDetailItem2ItemAddItemUuTv = null;
                viewHolder.appDetailItem2ItemAddItemCommentLy = null;
                viewHolder.appDetailItem2ItemAddItemAdminLy = null;
                viewHolder.appDetailItem2ItemAddItemPhone = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private class a implements View.OnClickListener, h.j {
        private int a;
        private int b;

        /* renamed from: c, reason: collision with root package name */
        private Context f112c;
        private int d;
        private int e;
        private UpApkCommentDetailsBean.DataBean.ReplyBean f;
        private DialogForProgressTip g;
        private String h;
        private int i;

        /* renamed from: com.rtk.app.adapter.UpApkCommentDetailsAdapter$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        class C0016a implements com.rtk.app.tool.s {
            C0016a() {
            }

            @Override // com.rtk.app.tool.s
            public void a(String... strArr) {
                a.this.h = strArr[0];
                a.this.h(4);
                a.this.g = new DialogForProgressTip(a.this.f112c, "删除中，请稍后...");
                a.this.g.show();
            }
        }

        a(Context context, int i, UpApkCommentDetailsBean.DataBean.ReplyBean replyBean, int i2) {
            this.a = i;
            this.f = replyBean;
            this.f112c = context;
            this.b = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(int i) {
            String sb;
            if (i == 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("members/sourceCommentLikes");
                sb2.append(com.rtk.app.tool.y.u(this.f112c));
                sb2.append("&uid=");
                sb2.append(com.rtk.app.tool.y.K());
                sb2.append("&token=");
                sb2.append(com.rtk.app.tool.y.H());
                sb2.append("&cmtid=");
                sb2.append(this.d);
                sb2.append("&op=du&key=");
                sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f112c, "cmtid=" + this.d, "op=du", "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
                sb = sb2.toString();
            } else if (i == 1) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("members/sourceCommentLikes");
                sb3.append(com.rtk.app.tool.y.u(this.f112c));
                sb3.append("&uid=");
                sb3.append(com.rtk.app.tool.y.K());
                sb3.append("&token=");
                sb3.append(com.rtk.app.tool.y.H());
                sb3.append("&cmtid=");
                sb3.append(this.d);
                sb3.append("&op=uu&key=");
                sb3.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f112c, "cmtid=" + this.d, "op=uu", "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
                sb = sb3.toString();
            } else {
                if (i == 4) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("up/comment/delete");
                    sb4.append(com.rtk.app.tool.y.u(this.f112c));
                    sb4.append("&uid=");
                    sb4.append(com.rtk.app.tool.y.K());
                    sb4.append("&token=");
                    sb4.append(com.rtk.app.tool.y.H());
                    sb4.append("&cid=");
                    sb4.append(((UpApkCommentDetailsBean.DataBean.ReplyBean) UpApkCommentDetailsAdapter.this.d.get(this.b)).getCmtid());
                    sb4.append("&table=up&msg=");
                    sb4.append(this.h);
                    sb4.append("&key=");
                    sb4.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f112c, "cid=" + ((UpApkCommentDetailsBean.DataBean.ReplyBean) UpApkCommentDetailsAdapter.this.d.get(this.b)).getCmtid(), "table=up", "msg=" + this.h, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
                    com.rtk.app.tool.o.h.l(this.f112c, this, i, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb4.toString()));
                    return;
                }
                sb = "";
            }
            com.rtk.app.tool.o.h.l(this.f112c, this, i, com.rtk.app.tool.o.h.h(new String[0]).a(sb));
            com.rtk.app.tool.c0.u("UpApkCommentDetailsAdapter", "评论详情页面   " + com.rtk.app.tool.y.d + sb);
        }

        @Override // com.rtk.app.tool.o.h.j
        public void d(String str, int i) {
            Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
            com.rtk.app.tool.c0.u("UpApkCommentDetailsAdapter", " 顶和踩    " + str + "");
            if (i == 0) {
                DuOrUpBean duOrUpBean = (DuOrUpBean) create.fromJson(str, DuOrUpBean.class);
                ((UpApkCommentDetailsBean.DataBean.ReplyBean) UpApkCommentDetailsAdapter.this.d.get(this.b)).setIsdu(((UpApkCommentDetailsBean.DataBean.ReplyBean) UpApkCommentDetailsAdapter.this.d.get(this.b)).getDu() <= duOrUpBean.getData().getDu() ? 1 : 0);
                ((UpApkCommentDetailsBean.DataBean.ReplyBean) UpApkCommentDetailsAdapter.this.d.get(this.b)).setDu(duOrUpBean.getData().getDu());
                ((UpApkCommentDetailsBean.DataBean.ReplyBean) UpApkCommentDetailsAdapter.this.d.get(this.b)).setUu(duOrUpBean.getData().getUu());
            } else if (i == 1) {
                DuOrUpBean duOrUpBean2 = (DuOrUpBean) create.fromJson(str, DuOrUpBean.class);
                ((UpApkCommentDetailsBean.DataBean.ReplyBean) UpApkCommentDetailsAdapter.this.d.get(this.b)).setIsuu(((UpApkCommentDetailsBean.DataBean.ReplyBean) UpApkCommentDetailsAdapter.this.d.get(this.b)).getUu() <= duOrUpBean2.getData().getUu() ? 1 : 0);
                ((UpApkCommentDetailsBean.DataBean.ReplyBean) UpApkCommentDetailsAdapter.this.d.get(this.b)).setDu(duOrUpBean2.getData().getDu());
                ((UpApkCommentDetailsBean.DataBean.ReplyBean) UpApkCommentDetailsAdapter.this.d.get(this.b)).setUu(duOrUpBean2.getData().getUu());
            } else if (i == 4) {
                DialogForProgressTip dialogForProgressTip = this.g;
                if (dialogForProgressTip != null) {
                    dialogForProgressTip.dismiss();
                }
                UpApkCommentDetailsAdapter.this.d.remove(this.b);
                UpApkCommentDetailsAdapter.this.notifyDataSetChanged();
                com.rtk.app.tool.f.a(this.f112c, "删除成功", f.a.f);
            }
            UpApkCommentDetailsAdapter.this.notifyDataSetChanged();
        }

        @Override // com.rtk.app.tool.o.h.j
        public void g(int i, String str, int i2) {
            DialogForProgressTip dialogForProgressTip;
            com.rtk.app.tool.f.a(this.f112c, str, f.a.f);
            if (i2 == 4 && (dialogForProgressTip = this.g) != null) {
                dialogForProgressTip.dismiss();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.d = this.f.getCmtid();
            this.e = this.f.getRoot_reply_id();
            int i = this.a;
            if (i == 0) {
                if (!com.rtk.app.tool.y.x(this.f112c)) {
                    com.rtk.app.tool.t.w0(this.f112c);
                    return;
                } else {
                    if (this.f != null) {
                        h(0);
                        return;
                    }
                    return;
                }
            }
            if (i == 1) {
                if (!com.rtk.app.tool.y.x(this.f112c)) {
                    com.rtk.app.tool.t.w0(this.f112c);
                    return;
                } else {
                    if (this.f != null) {
                        h(1);
                        return;
                    }
                    return;
                }
            }
            if (i != 2) {
                if (i == 3) {
                    com.rtk.app.tool.t.B0(this.f112c, this.f.getUid() + "");
                    return;
                }
                if (i == 4) {
                    new DialogForGameCommentDeleteReason(this.f112c, new C0016a()).show();
                    return;
                } else {
                    if (i != 5) {
                        return;
                    }
                    com.rtk.app.tool.t.C0(this.f112c, ((UpApkCommentDetailsBean.DataBean.ReplyBean) UpApkCommentDetailsAdapter.this.d.get(this.b)).getPic(), this.i);
                    return;
                }
            }
            if (!com.rtk.app.tool.y.x(this.f112c)) {
                com.rtk.app.tool.t.w0(this.f112c);
                return;
            }
            com.rtk.app.tool.t.l0(this.f112c, this.b, UpApkCommentDetailsAdapter.this.f, this.d, this.e, "0", UpApkCommentDetailsAdapter.this.g, "upApk", this.f.getUid() + "");
        }
    }

    public UpApkCommentDetailsAdapter(Context context, List<UpApkCommentDetailsBean.DataBean.ReplyBean> list, int i, String str) {
        super(list);
        this.d = list;
        this.f = i;
        this.g = str;
        this.e = context;
        this.f111c = com.rtk.app.main.comment.express.c.g();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.e).inflate(R.layout.app_datail_item2_item_add_item, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        UpApkCommentDetailsBean.DataBean.ReplyBean replyBean = this.d.get(i);
        com.rtk.app.tool.t.d(this.e, replyBean.getU_face(), viewHolder.appDetailItem2ItemAddItemImg);
        com.rtk.app.tool.c0.u("UpApkCommentDetailsAdapter", " 适配器里的id   " + replyBean.getReply_id() + "     " + replyBean.getRoot_reply_id());
        if (replyBean.getReply_id() != replyBean.getRoot_reply_id()) {
            viewHolder.appDetailItem2ItemAddItemName.setLeftText(replyBean.getU_name());
            viewHolder.appDetailItem2ItemAddItemName.setRightText(replyBean.getHisName());
            viewHolder.appDetailItem2ItemAddItemName.setText(" 回复" + replyBean.getHisFloor() + "层的 ");
        } else {
            viewHolder.appDetailItem2ItemAddItemName.setLeftText("");
            viewHolder.appDetailItem2ItemAddItemName.setRightText("");
            viewHolder.appDetailItem2ItemAddItemName.setText(replyBean.getU_name());
        }
        viewHolder.appDetailItem2ItemAddItemFloor.setText(replyBean.getFloor() + "层");
        viewHolder.appDetailItem2ItemAddItemContent.setText(this.f111c.a(replyBean.getContent()));
        viewHolder.appDetailItem2ItemAddItemTime.setText(replyBean.getTime());
        viewHolder.appDetailItem2ItemAddItemDuTv.setText(replyBean.getDu() + "");
        viewHolder.appDetailItem2ItemAddItemUuTv.setText(replyBean.getUu() + "");
        viewHolder.appDetailItem2ItemAddItemPhone.setText(replyBean.getClient());
        viewHolder.appDetailItem2ItemAddItemDuTv.setChecked(replyBean.getIsdu() != 0);
        viewHolder.appDetailItem2ItemAddItemDuTv.setOnClickListener(new a(this.e, 0, this.d.get(i), i));
        viewHolder.appDetailItem2ItemAddItemUuTv.setOnClickListener(new a(this.e, 1, this.d.get(i), i));
        viewHolder.appDetailItem2ItemAddItemUuTv.setVisibility(8);
        viewHolder.appDetailItem2ItemAddItemCommentLy.setOnClickListener(new a(this.e, 2, this.d.get(i), i));
        viewHolder.appDetailItem2ItemAddItemImgLv.setOnClickListener(new a(this.e, 3, this.d.get(i), i));
        viewHolder.appDetailItem2ItemAddItemDelete.setOnClickListener(new a(this.e, 4, this.d.get(i), i));
        viewHolder.appDetailItem2ItemAddItemDelete.setVisibility((c.d.a.d.d() && (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getCommentadmin() == 1 || MainActivity.p.getData().getUid() == this.h)) ? 0 : 8);
        viewHolder.appDetailItem2ItemAddItemIsUpMain.setVisibility(replyBean.getUid() == this.h ? 0 : 8);
        if (replyBean.getIs_admin() == 1) {
            viewHolder.appDetailItem2ItemAddItemAdminLy.setVisibility(8);
        } else {
            viewHolder.appDetailItem2ItemAddItemAdminLy.setVisibility(0);
        }
        return view;
    }

    public void i(int i) {
        this.h = i;
    }
}
