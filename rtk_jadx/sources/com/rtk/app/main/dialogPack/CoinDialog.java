package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.bean.CoinDetailsBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CoinDialog extends o implements h.j {
    private ViewHolder k;
    private Context l;
    private String m;
    private CoinDetailsBean n;
    private int o;
    private String p;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class CoinToCommentHolder {

        @BindView
        CustomTextView coinDialogCommentContent;

        @BindView
        RoundedImageView coinDialogCommentIcon;

        @BindView
        TextView coinDialogCommentNickName;

        @BindView
        ImageView coinDialogRewardUpSrcIcon;

        @BindView
        LinearLayout coinDialogRewardUpSrcLv;

        @BindView
        TextView coinDialogRewardUpSrcName;
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class CoinToCommentHolder_ViewBinding implements Unbinder {
        private CoinToCommentHolder b;

        @UiThread
        public CoinToCommentHolder_ViewBinding(CoinToCommentHolder coinToCommentHolder, View view) {
            coinToCommentHolder.coinDialogCommentIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.coin_dialog_comment_icon, "field 'coinDialogCommentIcon'", RoundedImageView.class);
            coinToCommentHolder.coinDialogCommentNickName = (TextView) butterknife.c.a.c(view, R.id.coin_dialog_comment_nickName, "field 'coinDialogCommentNickName'", TextView.class);
            coinToCommentHolder.coinDialogCommentContent = (CustomTextView) butterknife.c.a.c(view, R.id.coin_dialog_comment_content, "field 'coinDialogCommentContent'", CustomTextView.class);
            coinToCommentHolder.coinDialogRewardUpSrcIcon = (ImageView) butterknife.c.a.c(view, R.id.coin_dialog_reward_up_src_icon, "field 'coinDialogRewardUpSrcIcon'", ImageView.class);
            coinToCommentHolder.coinDialogRewardUpSrcName = (TextView) butterknife.c.a.c(view, R.id.coin_dialog_reward_up_src_name, "field 'coinDialogRewardUpSrcName'", TextView.class);
            coinToCommentHolder.coinDialogRewardUpSrcLv = (LinearLayout) butterknife.c.a.c(view, R.id.coin_dialog_reward_up_src_lv, "field 'coinDialogRewardUpSrcLv'", LinearLayout.class);
        }

        @CallSuper
        public void a() {
            CoinToCommentHolder coinToCommentHolder = this.b;
            if (coinToCommentHolder != null) {
                coinToCommentHolder.coinDialogCommentIcon = null;
                coinToCommentHolder.coinDialogCommentNickName = null;
                coinToCommentHolder.coinDialogCommentContent = null;
                coinToCommentHolder.coinDialogRewardUpSrcIcon = null;
                coinToCommentHolder.coinDialogRewardUpSrcName = null;
                coinToCommentHolder.coinDialogRewardUpSrcLv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class FamilyTypeHolder {

        @BindView
        ImageView familyLogImg;

        @BindView
        TextView familyNameTv;

        @BindView
        LinearLayout familyParentLv;

        FamilyTypeHolder(View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class FamilyTypeHolder_ViewBinding implements Unbinder {
        private FamilyTypeHolder b;

        @UiThread
        public FamilyTypeHolder_ViewBinding(FamilyTypeHolder familyTypeHolder, View view) {
            this.b = familyTypeHolder;
            familyTypeHolder.familyParentLv = (LinearLayout) butterknife.c.a.c(view, R.id.coin_dialog_reward_family_comment_lv, "field 'familyParentLv'", LinearLayout.class);
            familyTypeHolder.familyLogImg = (ImageView) butterknife.c.a.c(view, R.id.coin_dialog_for_family_command_icon, "field 'familyLogImg'", ImageView.class);
            familyTypeHolder.familyNameTv = (TextView) butterknife.c.a.c(view, R.id.coin_dialog_for_family_command_name, "field 'familyNameTv'", TextView.class);
        }

        @CallSuper
        public void a() {
            FamilyTypeHolder familyTypeHolder = this.b;
            if (familyTypeHolder != null) {
                this.b = null;
                familyTypeHolder.familyParentLv = null;
                familyTypeHolder.familyLogImg = null;
                familyTypeHolder.familyNameTv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class GameViewHolder {

        @BindView
        ImageView coinDialogRewardGameIcon;

        @BindView
        LinearLayout coinDialogRewardGameLayoutLv;

        @BindView
        TextView coinDialogRewardGameName;

        GameViewHolder(View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class GameViewHolder_ViewBinding implements Unbinder {
        private GameViewHolder b;

        @UiThread
        public GameViewHolder_ViewBinding(GameViewHolder gameViewHolder, View view) {
            this.b = gameViewHolder;
            gameViewHolder.coinDialogRewardGameLayoutLv = (LinearLayout) butterknife.c.a.c(view, R.id.coin_dialog_reward_game_layout_lv, "field 'coinDialogRewardGameLayoutLv'", LinearLayout.class);
            gameViewHolder.coinDialogRewardGameIcon = (ImageView) butterknife.c.a.c(view, R.id.coin_dialog_reward_game_icon, "field 'coinDialogRewardGameIcon'", ImageView.class);
            gameViewHolder.coinDialogRewardGameName = (TextView) butterknife.c.a.c(view, R.id.coin_dialog_reward_game_name, "field 'coinDialogRewardGameName'", TextView.class);
        }

        @CallSuper
        public void a() {
            GameViewHolder gameViewHolder = this.b;
            if (gameViewHolder != null) {
                this.b = null;
                gameViewHolder.coinDialogRewardGameLayoutLv = null;
                gameViewHolder.coinDialogRewardGameIcon = null;
                gameViewHolder.coinDialogRewardGameName = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ModuleHolder {

        @BindView
        LinearLayout coinDialogSignInLv;

        @BindView
        ImageView coinDialogSignInMidIcon;

        @BindView
        TextView coinDialogSignInMidName;

        ModuleHolder(View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ModuleHolder_ViewBinding implements Unbinder {
        private ModuleHolder b;

        @UiThread
        public ModuleHolder_ViewBinding(ModuleHolder moduleHolder, View view) {
            this.b = moduleHolder;
            moduleHolder.coinDialogSignInLv = (LinearLayout) butterknife.c.a.c(view, R.id.coin_dialog_sign_in_lv, "field 'coinDialogSignInLv'", LinearLayout.class);
            moduleHolder.coinDialogSignInMidIcon = (ImageView) butterknife.c.a.c(view, R.id.coin_dialog_sign_in_mid_icon, "field 'coinDialogSignInMidIcon'", ImageView.class);
            moduleHolder.coinDialogSignInMidName = (TextView) butterknife.c.a.c(view, R.id.coin_dialog_sign_in_mid_name, "field 'coinDialogSignInMidName'", TextView.class);
        }

        @CallSuper
        public void a() {
            ModuleHolder moduleHolder = this.b;
            if (moduleHolder != null) {
                this.b = null;
                moduleHolder.coinDialogSignInLv = null;
                moduleHolder.coinDialogSignInMidIcon = null;
                moduleHolder.coinDialogSignInMidName = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class UpCommentHolder {

        @BindView
        CustomTextView commentContentTv;

        UpCommentHolder(View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class UpCommentHolder_ViewBinding implements Unbinder {
        private UpCommentHolder b;

        @UiThread
        public UpCommentHolder_ViewBinding(UpCommentHolder upCommentHolder, View view) {
            this.b = upCommentHolder;
            upCommentHolder.commentContentTv = (CustomTextView) butterknife.c.a.c(view, R.id.coin_dialog_reward_up_comment_content, "field 'commentContentTv'", CustomTextView.class);
        }

        @CallSuper
        public void a() {
            UpCommentHolder upCommentHolder = this.b;
            if (upCommentHolder != null) {
                this.b = null;
                upCommentHolder.commentContentTv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class UpSrcHolder {

        @BindView
        ImageView coinDialogRewardUpSrcIcon;

        @BindView
        LinearLayout coinDialogRewardUpSrcLv;

        @BindView
        TextView coinDialogRewardUpSrcName;

        UpSrcHolder(View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class UpSrcHolder_ViewBinding implements Unbinder {
        private UpSrcHolder b;

        @UiThread
        public UpSrcHolder_ViewBinding(UpSrcHolder upSrcHolder, View view) {
            this.b = upSrcHolder;
            upSrcHolder.coinDialogRewardUpSrcLv = (LinearLayout) butterknife.c.a.c(view, R.id.coin_dialog_reward_up_src_lv, "field 'coinDialogRewardUpSrcLv'", LinearLayout.class);
            upSrcHolder.coinDialogRewardUpSrcIcon = (ImageView) butterknife.c.a.c(view, R.id.coin_dialog_reward_up_src_icon, "field 'coinDialogRewardUpSrcIcon'", ImageView.class);
            upSrcHolder.coinDialogRewardUpSrcName = (TextView) butterknife.c.a.c(view, R.id.coin_dialog_reward_up_src_name, "field 'coinDialogRewardUpSrcName'", TextView.class);
        }

        @CallSuper
        public void a() {
            UpSrcHolder upSrcHolder = this.b;
            if (upSrcHolder != null) {
                this.b = null;
                upSrcHolder.coinDialogRewardUpSrcLv = null;
                upSrcHolder.coinDialogRewardUpSrcIcon = null;
                upSrcHolder.coinDialogRewardUpSrcName = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ViewHolder {

        @BindView
        LinearLayout coinDialogAddView;

        @BindView
        LinearLayout coinDialogContentLv;

        @BindView
        TextView coinDialogFamily;

        @BindView
        CustomTextView coinDialogIntro;

        @BindView
        LinearLayout coinDialogLoading;

        @BindView
        CustomTextView coinDialogSend;

        @BindView
        CustomTextView coinDialogTime;

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
            viewHolder.coinDialogSend = (CustomTextView) butterknife.c.a.c(view, R.id.coin_dialog_send, "field 'coinDialogSend'", CustomTextView.class);
            viewHolder.coinDialogFamily = (TextView) butterknife.c.a.c(view, R.id.coin_dialog_is_family, "field 'coinDialogFamily'", TextView.class);
            viewHolder.coinDialogTime = (CustomTextView) butterknife.c.a.c(view, R.id.coin_dialog_time, "field 'coinDialogTime'", CustomTextView.class);
            viewHolder.coinDialogIntro = (CustomTextView) butterknife.c.a.c(view, R.id.coin_dialog_intro, "field 'coinDialogIntro'", CustomTextView.class);
            viewHolder.coinDialogAddView = (LinearLayout) butterknife.c.a.c(view, R.id.coin_dialog_addView, "field 'coinDialogAddView'", LinearLayout.class);
            viewHolder.coinDialogContentLv = (LinearLayout) butterknife.c.a.c(view, R.id.coin_dialog_contentLv, "field 'coinDialogContentLv'", LinearLayout.class);
            viewHolder.coinDialogLoading = (LinearLayout) butterknife.c.a.c(view, R.id.coin_dialog_loading, "field 'coinDialogLoading'", LinearLayout.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.coinDialogSend = null;
                viewHolder.coinDialogFamily = null;
                viewHolder.coinDialogTime = null;
                viewHolder.coinDialogIntro = null;
                viewHolder.coinDialogAddView = null;
                viewHolder.coinDialogContentLv = null;
                viewHolder.coinDialogLoading = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public CoinDialog(Context context, String str, int i) {
        super(context);
        this.m = str;
        this.o = i;
        this.l = context;
        i(R.layout.coin_dialog_layout, 17);
        this.k = new ViewHolder(getWindow().getDecorView());
        q();
        p();
    }

    private void p() {
        StringBuilder sb = new StringBuilder();
        sb.append("members/coinDetailById");
        sb.append(com.rtk.app.tool.y.u(this.l));
        sb.append("&uid=");
        sb.append(com.rtk.app.tool.y.K());
        sb.append("&token=");
        sb.append(com.rtk.app.tool.y.H());
        sb.append("&id=");
        sb.append(this.m);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.l, "id=" + this.m, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
        String sb2 = sb.toString();
        com.rtk.app.tool.o.h.l(this.l, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a(sb2));
        StringBuilder sb3 = new StringBuilder();
        sb3.append("金币详情链接");
        sb3.append(com.rtk.app.tool.y.d);
        sb3.append(sb2);
        com.rtk.app.tool.c0.u("CoinDialog", sb3.toString());
    }

    private void q() {
        if (this.o < 0) {
            this.k.coinDialogSend.setLeftText("接受者：");
        } else {
            this.k.coinDialogSend.setLeftText("发送者：");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0143, code lost:
    
        if (r6.equals("posts") == false) goto L10;
     */
    @Override // com.rtk.app.tool.o.h.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(java.lang.String r6, int r7) {
        /*
            Method dump skipped, instructions count: 958
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.main.dialogPack.CoinDialog.d(java.lang.String, int):void");
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.l, str, f.a.f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x015f, code lost:
    
        if (r1.equals("postsReply") != false) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0176  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onClick(android.view.View r19) {
        /*
            Method dump skipped, instructions count: 600
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.main.dialogPack.CoinDialog.onClick(android.view.View):void");
    }
}
