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
import com.rtk.app.bean.UpClassifyBean;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeUpSrcClassifyAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f78c;
    private List<UpClassifyBean.DataBean.GameBean> d;
    private List<UpClassifyBean.DataBean.SoftBean> e;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        ImageView home3Item2LayoutGridViewItemImg;

        @BindView
        TextView home3Item2LayoutGridViewItemName;

        ViewHolder(HomeUpSrcClassifyAdapter homeUpSrcClassifyAdapter, View view) {
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

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements View.OnClickListener {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.rtk.app.tool.t.v0(HomeUpSrcClassifyAdapter.this.f78c, ((UpClassifyBean.DataBean.GameBean) HomeUpSrcClassifyAdapter.this.d.get(this.a)).getType(), ((UpClassifyBean.DataBean.GameBean) HomeUpSrcClassifyAdapter.this.d.get(this.a)).getTags(), ((UpClassifyBean.DataBean.GameBean) HomeUpSrcClassifyAdapter.this.d.get(this.a)).getTitle());
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements View.OnClickListener {
        final /* synthetic */ int a;

        b(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.rtk.app.tool.t.v0(HomeUpSrcClassifyAdapter.this.f78c, ((UpClassifyBean.DataBean.SoftBean) HomeUpSrcClassifyAdapter.this.e.get(this.a)).getType(), ((UpClassifyBean.DataBean.SoftBean) HomeUpSrcClassifyAdapter.this.e.get(this.a)).getTags(), ((UpClassifyBean.DataBean.SoftBean) HomeUpSrcClassifyAdapter.this.e.get(this.a)).getTitle());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HomeUpSrcClassifyAdapter(Context context, List<UpClassifyBean.DataBean.GameBean> list, List<UpClassifyBean.DataBean.SoftBean> list2) {
        super(list != null ? list : list2);
        this.f78c = context;
        this.d = list;
        this.e = list2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f78c).inflate(R.layout.home3_item2_gridview_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(this, view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        if (this.d != null) {
            view.setOnClickListener(new a(i));
            com.rtk.app.tool.t.c(this.f78c, this.d.get(i).getIcon(), viewHolder.home3Item2LayoutGridViewItemImg, new boolean[0]);
            if (!com.rtk.app.tool.c0.q(this.d.get(i).getTitle())) {
                viewHolder.home3Item2LayoutGridViewItemName.setText(this.d.get(i).getTitle());
            } else {
                viewHolder.home3Item2LayoutGridViewItemName.setText(this.d.get(i).getTitle());
            }
        } else if (this.e != null) {
            view.setOnClickListener(new b(i));
            com.rtk.app.tool.t.c(this.f78c, this.e.get(i).getIcon(), viewHolder.home3Item2LayoutGridViewItemImg, new boolean[0]);
            if (!com.rtk.app.tool.c0.q(this.e.get(i).getTitle())) {
                viewHolder.home3Item2LayoutGridViewItemName.setText(this.e.get(i).getTitle());
            } else {
                viewHolder.home3Item2LayoutGridViewItemName.setText(this.e.get(i).getTitle());
            }
        }
        return view;
    }
}
