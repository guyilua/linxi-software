package com.rtk.app.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.bean.UpApkListBean;
import com.rtk.app.custom.CustomTextView;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostUpSrcSelectAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f105c;
    private List<UpApkListBean.DataBean> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ViewHolder {

        @BindView
        View itemIsFamily;

        @BindView
        TextView postUpSrcSelectItemCheckState;

        @BindView
        CustomTextView postUpSrcSelectItemCheckStateReason;

        @BindView
        TextView postUpSrcSelectItemGameName;

        @BindView
        CustomTextView postUpSrcSelectItemGameTime;

        @BindView
        CustomTextView postUpSrcSelectItemGameVersionAndSize;

        @BindView
        RoundedImageView postUpSrcSelectItemIcon;

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
            viewHolder.postUpSrcSelectItemIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.post_up_src_select_item_icon, "field 'postUpSrcSelectItemIcon'", RoundedImageView.class);
            viewHolder.postUpSrcSelectItemGameName = (TextView) butterknife.c.a.c(view, R.id.post_up_src_select_item_gameName, "field 'postUpSrcSelectItemGameName'", TextView.class);
            viewHolder.postUpSrcSelectItemGameVersionAndSize = (CustomTextView) butterknife.c.a.c(view, R.id.post_up_src_select_item_gameVersionAndSize, "field 'postUpSrcSelectItemGameVersionAndSize'", CustomTextView.class);
            viewHolder.postUpSrcSelectItemGameTime = (CustomTextView) butterknife.c.a.c(view, R.id.post_up_src_select_item_gameTime, "field 'postUpSrcSelectItemGameTime'", CustomTextView.class);
            viewHolder.postUpSrcSelectItemCheckState = (TextView) butterknife.c.a.c(view, R.id.post_up_src_select_item_checkState, "field 'postUpSrcSelectItemCheckState'", TextView.class);
            viewHolder.postUpSrcSelectItemCheckStateReason = (CustomTextView) butterknife.c.a.c(view, R.id.post_up_src_select_item_checkState_reason, "field 'postUpSrcSelectItemCheckStateReason'", CustomTextView.class);
            viewHolder.itemIsFamily = butterknife.c.a.b(view, R.id.post_up_src_select_item_is_family, "field 'itemIsFamily'");
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.postUpSrcSelectItemIcon = null;
                viewHolder.postUpSrcSelectItemGameName = null;
                viewHolder.postUpSrcSelectItemGameVersionAndSize = null;
                viewHolder.postUpSrcSelectItemGameTime = null;
                viewHolder.postUpSrcSelectItemCheckState = null;
                viewHolder.postUpSrcSelectItemCheckStateReason = null;
                viewHolder.itemIsFamily = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public PostUpSrcSelectAdapter(Context context, List<UpApkListBean.DataBean> list) {
        super(list);
        this.f105c = context;
        this.d = list;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00eb, code lost:
    
        if (r1.equals("1") == false) goto L15;
     */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View getView(int r7, android.view.View r8, android.view.ViewGroup r9) {
        /*
            Method dump skipped, instructions count: 484
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.adapter.PostUpSrcSelectAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
}
