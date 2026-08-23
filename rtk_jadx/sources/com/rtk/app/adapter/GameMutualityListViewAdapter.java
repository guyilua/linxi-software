package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.bean.RecommendModuleAndClassifyBean;
import com.rtk.app.custom.GridViewForScrollView;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GameMutualityListViewAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f62c;
    private List<RecommendModuleAndClassifyBean.DataBean.CategoryBean> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        GridViewForScrollView home3Item1ListviewItemGridView;

        @BindView
        ImageView home3Item1ListviewItemImg;

        @BindView
        LinearLayout home3Item1ListviewItemImgLV;

        @BindView
        TextView home3Item1ListviewItemTv;

        ViewHolder(GameMutualityListViewAdapter gameMutualityListViewAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.home3Item1ListviewItemImgLV = (LinearLayout) butterknife.c.a.c(view, R.id.home3_item1_listview_item_img_lv, "field 'home3Item1ListviewItemImgLV'", LinearLayout.class);
            viewHolder.home3Item1ListviewItemImg = (ImageView) butterknife.c.a.c(view, R.id.home3_item1_listview_item_img, "field 'home3Item1ListviewItemImg'", ImageView.class);
            viewHolder.home3Item1ListviewItemTv = (TextView) butterknife.c.a.c(view, R.id.home3_item1_listview_item_tv, "field 'home3Item1ListviewItemTv'", TextView.class);
            viewHolder.home3Item1ListviewItemGridView = (GridViewForScrollView) butterknife.c.a.c(view, R.id.home3_item1_listview_item_GridView, "field 'home3Item1ListviewItemGridView'", GridViewForScrollView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.home3Item1ListviewItemImgLV = null;
                viewHolder.home3Item1ListviewItemImg = null;
                viewHolder.home3Item1ListviewItemTv = null;
                viewHolder.home3Item1ListviewItemGridView = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.rtk.app.tool.t.T0(GameMutualityListViewAdapter.this.f62c, ((RecommendModuleAndClassifyBean.DataBean.CategoryBean) GameMutualityListViewAdapter.this.d.get(((Integer) view.getTag()).intValue())).getTitle(), ((RecommendModuleAndClassifyBean.DataBean.CategoryBean) GameMutualityListViewAdapter.this.d.get(((Integer) view.getTag()).intValue())).getType());
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b extends com.rtk.app.custom.AutoListView.b {
        final /* synthetic */ int a;

        b(int i) {
            this.a = i;
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.T0(GameMutualityListViewAdapter.this.f62c, ((RecommendModuleAndClassifyBean.DataBean.CategoryBean) GameMutualityListViewAdapter.this.d.get(this.a)).getList().get(i).getTitle(), ((RecommendModuleAndClassifyBean.DataBean.CategoryBean) GameMutualityListViewAdapter.this.d.get(this.a)).getList().get(i).getType());
        }
    }

    public GameMutualityListViewAdapter(List<RecommendModuleAndClassifyBean.DataBean.CategoryBean> list, Context context) {
        super(list);
        this.d = list;
        this.f62c = context;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f62c).inflate(R.layout.home3_item1_listview_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(this, view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        try {
            viewHolder.home3Item1ListviewItemGridView.setAdapter((ListAdapter) new SmallGridViewAdapter(this.d.get(i).getList(), this.f62c));
        } catch (Exception unused) {
        }
        com.rtk.app.tool.t.c(this.f62c, this.d.get(i).getIcon(), viewHolder.home3Item1ListviewItemImg, new boolean[0]);
        viewHolder.home3Item1ListviewItemTv.setText(this.d.get(i).getTitle());
        viewHolder.home3Item1ListviewItemImgLV.setTag(Integer.valueOf(i));
        viewHolder.home3Item1ListviewItemImgLV.setOnClickListener(new a());
        viewHolder.home3Item1ListviewItemGridView.setOnItemClickListener(new b(i));
        return view;
    }
}
