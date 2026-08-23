package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.zhy.view.flowlayout.FlowLayout;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TagFlowLayoutForBBsCheckReasonAdapter extends com.zhy.view.flowlayout.a<String> {
    private Context d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder {

        @BindView
        TextView tabFlowForBbsCheckReasonLayoutItemTv;

        ViewHolder(TagFlowLayoutForBBsCheckReasonAdapter tagFlowLayoutForBBsCheckReasonAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.tabFlowForBbsCheckReasonLayoutItemTv = (TextView) butterknife.c.a.c(view, R.id.tab_flow_for_bbs_check_reason_layout_item_tv, "field 'tabFlowForBbsCheckReasonLayoutItemTv'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.tabFlowForBbsCheckReasonLayoutItemTv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public TagFlowLayoutForBBsCheckReasonAdapter(Context context, List<String> list) {
        super(list);
        this.d = context;
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public View d(FlowLayout flowLayout, int i, String str) {
        View inflate = LayoutInflater.from(this.d).inflate(R.layout.tab_flow_for_bbs_check_reason_layout_item_layout, (ViewGroup) flowLayout, false);
        new ViewHolder(this, inflate).tabFlowForBbsCheckReasonLayoutItemTv.setText(str);
        return inflate;
    }
}
