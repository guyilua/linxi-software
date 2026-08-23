package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.BindView;
import com.rtk.app.R;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForAuditPostComment extends o implements h.j {

    @BindView
    TextView dialogForAuditPostCommentLayoutCancel;

    @BindView
    TextView dialogForAuditPostCommentLayoutEnsure;

    @BindView
    TextView dialogForAuditPostCommentLayoutGoDetails;

    @BindView
    RadioGroup dialogForAuditPostCommentLayoutRadioGroup;

    @BindView
    EditText dialogForAuditPostCommentLayoutReason;
    private Context k;
    private String l;
    private String m;
    private String n;
    private int o;

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i == 1) {
            com.rtk.app.tool.f.a(this.k, "审核通过", f.a.f);
        }
        com.rtk.app.tool.c0.u("DialogForAuditPostComment", "审核成功内容" + str);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (i2 == 1) {
            com.rtk.app.tool.f.a(this.k, "审核失败" + str, f.a.f);
        }
        com.rtk.app.tool.c0.u("DialogForAuditPostComment", "审核失败内容" + str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_for_audit_post_comment_layout_cancel /* 2131297153 */:
                dismiss();
                return;
            case R.id.dialog_for_audit_post_comment_layout_ensure /* 2131297154 */:
                p(1);
                if (this.dialogForAuditPostCommentLayoutReason.getText().toString().trim().length() > 24) {
                    com.rtk.app.tool.f.a(this.k, "字数需要小于12字", f.a.f);
                    return;
                } else {
                    dismiss();
                    return;
                }
            case R.id.dialog_for_audit_post_comment_layout_go_details /* 2131297155 */:
                com.rtk.app.tool.t.G0(this.k, this.m, this.n, this.l);
                dismiss();
                return;
            default:
                return;
        }
    }

    public void p(int i) {
        String trim = this.dialogForAuditPostCommentLayoutReason.getText().toString().trim();
        if (i != 1) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("bbs/examine-comment/post");
        sb.append(com.rtk.app.tool.y.u(this.k));
        sb.append("&uid=");
        sb.append(com.rtk.app.tool.y.K());
        sb.append("&token=");
        sb.append(com.rtk.app.tool.y.H());
        sb.append("&mid=");
        sb.append(this.l);
        sb.append("&cid=");
        sb.append(this.n);
        sb.append("&state=");
        sb.append(this.o);
        sb.append("&msg=");
        sb.append(trim);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.k, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "cid=" + this.n, "mid=" + this.l, "state=" + this.o))));
        String sb2 = sb.toString();
        com.rtk.app.tool.o.h.l(this.k, this, i, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb2));
        StringBuilder sb3 = new StringBuilder();
        sb3.append(" 帖子评论审核请求  ");
        sb3.append(com.rtk.app.tool.y.e);
        sb3.append(sb2);
        com.rtk.app.tool.c0.u("DialogForAuditPostComment", sb3.toString());
    }
}
