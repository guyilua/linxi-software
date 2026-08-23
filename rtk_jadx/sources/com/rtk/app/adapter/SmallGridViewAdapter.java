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
import com.rtk.app.bean.RecommendModuleAndClassifyBean;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SmallGridViewAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f109c;
    private List<RecommendModuleAndClassifyBean.DataBean.CategoryBean.ListBean> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        TextView home3SmallTypeTv;

        ViewHolder(SmallGridViewAdapter smallGridViewAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.home3SmallTypeTv = (TextView) butterknife.c.a.c(view, R.id.home3_small_type_tv, "field 'home3SmallTypeTv'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.home3SmallTypeTv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public SmallGridViewAdapter(List<RecommendModuleAndClassifyBean.DataBean.CategoryBean.ListBean> list, Context context) {
        super(list);
        this.f109c = context;
        this.d = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f109c).inflate(R.layout.home2_small_type, viewGroup, false);
        new ViewHolder(this, inflate).home3SmallTypeTv.setText(this.d.get(i).getTitle());
        return inflate;
    }
}
