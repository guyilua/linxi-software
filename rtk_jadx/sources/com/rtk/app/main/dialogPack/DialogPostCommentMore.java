package com.rtk.app.main.dialogPack;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.bean.ResponseDataBean;
import com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsRecyclerViewAdapter;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogPostCommentMore extends Dialog implements View.OnClickListener, h.j {
    private Window a;
    private ViewHolder b;

    /* renamed from: c, reason: collision with root package name */
    private Context f245c;
    private String d;
    private String e;
    private String f;
    private int g;
    private int h;
    private int i;
    private String j;
    private String k;
    private String l;
    private boolean m;
    private PostDetailsRecyclerViewAdapter.a n;
    private String o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder {

        @BindView
        TextView dialogPostCommentMoreCancle;

        @BindView
        TextView dialogPostCommentMoreComment;

        @BindView
        LinearLayout dialogPostCommentMoreDelete;

        @BindView
        TextView dialogPostCommentMoreReport;

        @BindView
        LinearLayout dialogPostCommentMoreReward;

        ViewHolder(DialogPostCommentMore dialogPostCommentMore, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.dialogPostCommentMoreComment = (TextView) butterknife.c.a.c(view, R.id.dialog_post_comment_more_comment, "field 'dialogPostCommentMoreComment'", TextView.class);
            viewHolder.dialogPostCommentMoreReport = (TextView) butterknife.c.a.c(view, R.id.dialog_post_comment_more_report, "field 'dialogPostCommentMoreReport'", TextView.class);
            viewHolder.dialogPostCommentMoreCancle = (TextView) butterknife.c.a.c(view, R.id.dialog_post_comment_more_cancle, "field 'dialogPostCommentMoreCancle'", TextView.class);
            viewHolder.dialogPostCommentMoreDelete = (LinearLayout) butterknife.c.a.c(view, R.id.dialog_post_comment_more_delete, "field 'dialogPostCommentMoreDelete'", LinearLayout.class);
            viewHolder.dialogPostCommentMoreReward = (LinearLayout) butterknife.c.a.c(view, R.id.dialog_post_comment_more_reward, "field 'dialogPostCommentMoreReward'", LinearLayout.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.dialogPostCommentMoreComment = null;
                viewHolder.dialogPostCommentMoreReport = null;
                viewHolder.dialogPostCommentMoreCancle = null;
                viewHolder.dialogPostCommentMoreDelete = null;
                viewHolder.dialogPostCommentMoreReward = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public DialogPostCommentMore(@NonNull Context context, String str, String str2, int i, int i2, int i3, PostDetailsRecyclerViewAdapter.a aVar, String str3, String str4, String str5, boolean z, String str6) {
        super(context);
        this.o = "";
        this.f245c = context;
        this.f = str6;
        this.m = z;
        this.i = i;
        this.e = str;
        this.d = str2;
        this.l = str5;
        this.h = i2;
        this.g = i3;
        this.n = aVar;
        this.j = str3;
        this.k = str4;
        c();
        b();
    }

    private void b() {
        this.b.dialogPostCommentMoreComment.setOnClickListener(this);
        this.b.dialogPostCommentMoreCancle.setOnClickListener(this);
        this.b.dialogPostCommentMoreReport.setOnClickListener(this);
        this.b.dialogPostCommentMoreDelete.setOnClickListener(this);
        this.b.dialogPostCommentMoreReward.setOnClickListener(this);
    }

    private void c() {
        setContentView(R.layout.dialog_post_comment_more);
        h(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
        setCanceledOnTouchOutside(true);
        this.b = new ViewHolder(this, getWindow().getDecorView());
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        if (this.i != 1 && this.h != 1) {
            this.b.dialogPostCommentMoreDelete.setVisibility(8);
            this.b.dialogPostCommentMoreReport.setVisibility(0);
        } else {
            this.b.dialogPostCommentMoreDelete.setVisibility(0);
            this.b.dialogPostCommentMoreReport.setVisibility(8);
        }
        this.b.dialogPostCommentMoreReward.setVisibility(this.m ? 0 : 8);
        this.b.dialogPostCommentMoreComment.setVisibility(this.f.equals("0") ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(String[] strArr) {
        this.o = strArr[0];
        a(1);
    }

    public void a(int i) {
        String sb;
        if (i != 1) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/deleteComment");
            sb2.append(com.rtk.app.tool.y.u(this.f245c));
            sb2.append("&uid=");
            sb2.append(com.rtk.app.tool.y.K());
            sb2.append("&token=");
            sb2.append(com.rtk.app.tool.y.H());
            sb2.append("&mid=");
            sb2.append(this.d);
            sb2.append("&pid=");
            sb2.append(this.e);
            sb2.append("&cid=");
            sb2.append(this.g);
            sb2.append("&msg=");
            sb2.append(this.o);
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f245c, "pid=" + this.e, "mid=" + this.d, "cid=" + this.g, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
            sb = sb2.toString();
        }
        if (com.rtk.app.tool.c0.q(sb)) {
            return;
        }
        com.rtk.app.tool.o.h.l(this.f245c, this, i, com.rtk.app.tool.o.h.h(new String[0]).a(sb));
        com.rtk.app.tool.c0.u("DialogPostCommentMore", "删除Dialog2" + com.rtk.app.tool.y.d + sb);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        com.rtk.app.tool.c0.u("DialogPostCommentMore", "删除Dialog3");
        if (i != 1) {
            return;
        }
        com.rtk.app.tool.f.a(this.f245c, ((ResponseDataBean) create.fromJson(str, ResponseDataBean.class)).getMsg(), f.a.f);
        PostDetailsRecyclerViewAdapter.a aVar = this.n;
        if (aVar != null) {
            aVar.j(this.g);
        }
        dismiss();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.f245c, str, f.a.f);
        dismiss();
    }

    public void h(float f, float f2) {
        Window window = getWindow();
        this.a = window;
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = (int) f;
        attributes.y = (int) f2;
        attributes.gravity = 80;
        attributes.width = -1;
        attributes.height = -2;
        this.a.setAttributes(attributes);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new Bundle();
        switch (view.getId()) {
            case R.id.dialog_post_comment_more_comment /* 2131297329 */:
                if (com.rtk.app.tool.y.x(this.f245c)) {
                    com.rtk.app.tool.t.M0(this.f245c, this.d, this.e, this.j, this.k, this.l, 0, 0);
                    break;
                } else {
                    com.rtk.app.tool.t.w0(this.f245c);
                    break;
                }
            case R.id.dialog_post_comment_more_delete /* 2131297330 */:
                com.rtk.app.tool.c0.u("DialogPostCommentMore", "删除Dialog");
                new DialogForAuditCheckReason(this.f245c, R.array.audit_reason_bbs_comment, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.dialogPack.j
                    @Override // com.rtk.app.tool.s
                    public final void a(String[] strArr) {
                        DialogPostCommentMore.this.f(strArr);
                    }
                }).show();
                break;
            case R.id.dialog_post_comment_more_report /* 2131297331 */:
                if (!com.rtk.app.tool.y.x(this.f245c)) {
                    com.rtk.app.tool.t.w0(this.f245c);
                    com.rtk.app.tool.f.a(this.f245c, "请先登录", f.a.f);
                    return;
                }
                com.rtk.app.tool.t.R0(this.f245c, this.d, this.e, this.g + "");
                break;
            case R.id.dialog_post_comment_more_reward /* 2131297332 */:
                if (com.rtk.app.tool.y.x(this.f245c)) {
                    new DialogPostReward(this.f245c, this.l, "rewardComment", this.g + "", this.e).show();
                    break;
                } else {
                    com.rtk.app.tool.t.w0(this.f245c);
                    break;
                }
        }
        dismiss();
    }
}
