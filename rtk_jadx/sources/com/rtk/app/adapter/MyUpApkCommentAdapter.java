package com.rtk.app.adapter;

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
import com.rtk.app.R;
import com.rtk.app.bean.MyUpApkCommentBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.tool.ApkInfo;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyUpApkCommentAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f91c;
    private List<MyUpApkCommentBean.DataBean> d;
    private String e;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ViewHolder {

        @BindView
        TextView myComment1ListviewItemTime;

        @BindView
        CustomTextView myUpApkCommentItem1;

        @BindView
        CustomTextView myUpApkCommentItem2;

        @BindView
        LinearLayout myUpApkCommentItemGameGameLayout;

        @BindView
        ImageView myUpApkCommentItemGameImg;

        @BindView
        TextView myUpApkCommentItemGameName;

        @BindView
        ImageView myUpApkCommentItemGameStart;

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
            viewHolder.myUpApkCommentItemGameImg = (ImageView) butterknife.c.a.c(view, R.id.my_up_apk_comment_item_game_img, "field 'myUpApkCommentItemGameImg'", ImageView.class);
            viewHolder.myUpApkCommentItemGameName = (TextView) butterknife.c.a.c(view, R.id.my_up_apk_comment_item_game_name, "field 'myUpApkCommentItemGameName'", TextView.class);
            viewHolder.myUpApkCommentItemGameStart = (ImageView) butterknife.c.a.c(view, R.id.my_up_apk_comment_item_game_start, "field 'myUpApkCommentItemGameStart'", ImageView.class);
            viewHolder.myComment1ListviewItemTime = (TextView) butterknife.c.a.c(view, R.id.my_comment1_listview_item_time, "field 'myComment1ListviewItemTime'", TextView.class);
            viewHolder.myUpApkCommentItemGameGameLayout = (LinearLayout) butterknife.c.a.c(view, R.id.my_up_apk_comment_item_game_game_layout, "field 'myUpApkCommentItemGameGameLayout'", LinearLayout.class);
            viewHolder.myUpApkCommentItem1 = (CustomTextView) butterknife.c.a.c(view, R.id.my_up_apk_comment_item_1, "field 'myUpApkCommentItem1'", CustomTextView.class);
            viewHolder.myUpApkCommentItem2 = (CustomTextView) butterknife.c.a.c(view, R.id.my_up_apk_comment_item_2, "field 'myUpApkCommentItem2'", CustomTextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.myUpApkCommentItemGameImg = null;
                viewHolder.myUpApkCommentItemGameName = null;
                viewHolder.myUpApkCommentItemGameStart = null;
                viewHolder.myComment1ListviewItemTime = null;
                viewHolder.myUpApkCommentItemGameGameLayout = null;
                viewHolder.myUpApkCommentItem1 = null;
                viewHolder.myUpApkCommentItem2 = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class a implements View.OnClickListener {
        private Context a;
        private MyUpApkCommentBean.DataBean b;

        public a(Context context, int i, MyUpApkCommentBean.DataBean dataBean) {
            this.a = context;
            this.b = dataBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != 2131299527) {
                return;
            }
            com.rtk.app.tool.t.X0(this.a, new ApkInfo(this.b));
        }
    }

    public MyUpApkCommentAdapter(Context context, List<MyUpApkCommentBean.DataBean> list, String str) {
        super(list);
        this.f91c = context;
        this.d = list;
        this.e = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a6, code lost:
    
        if (r0.equals("myreply") == false) goto L22;
     */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View getView(int r7, android.view.View r8, android.view.ViewGroup r9) {
        /*
            Method dump skipped, instructions count: 520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.adapter.MyUpApkCommentAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
}
