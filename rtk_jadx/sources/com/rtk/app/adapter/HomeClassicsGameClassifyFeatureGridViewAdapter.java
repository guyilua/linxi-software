package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.bean.ClassifyBean;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeClassicsGameClassifyFeatureGridViewAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f73c;
    private List<ClassifyBean.DataBean.FeatureTypeBean> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        ImageView home3Item2LayoutGridViewItemImg;

        @BindView
        TextView home3Item2LayoutGridViewItemName;

        ViewHolder(HomeClassicsGameClassifyFeatureGridViewAdapter homeClassicsGameClassifyFeatureGridViewAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.home3Item2LayoutGridViewItemImg = (ImageView) butterknife.c.a.c(view, R.id.home3_item2_layout_gridView_item_img, "field 'home3Item2LayoutGridViewItemImg'", ImageView.class);
            viewHolder.home3Item2LayoutGridViewItemName = (TextView) butterknife.c.a.c(view, R.id.home3_item2_layout_gridView_item_name, "field 'home3Item2LayoutGridViewItemName'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.home3Item2LayoutGridViewItemImg = null;
                viewHolder.home3Item2LayoutGridViewItemName = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public HomeClassicsGameClassifyFeatureGridViewAdapter(Context context, List<ClassifyBean.DataBean.FeatureTypeBean> list) {
        super(list);
        this.f73c = context;
        this.d = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f73c).inflate(R.layout.home3_item2_gridview_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(this, view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        com.rtk.app.tool.t.c(this.f73c, this.d.get(i).getIcon(), viewHolder.home3Item2LayoutGridViewItemImg, new boolean[0]);
        viewHolder.home3Item2LayoutGridViewItemName.setText(this.d.get(i).getTag_name());
        return view;
    }
}
