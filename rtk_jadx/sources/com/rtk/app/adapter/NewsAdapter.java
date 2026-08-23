package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.bean.NewsBean;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class NewsAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f95c;
    private List<NewsBean.DataBean> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        LinearLayout newsListObjectItemLayout;

        @BindView
        TextView newsListObjectItemLayoutAddTime;

        @BindView
        TextView newsListObjectItemLayoutContent;

        @BindView
        TextView newsListObjectItemLayoutTitle;

        @BindView
        TextView newsListObjectItemLayoutType;

        ViewHolder(NewsAdapter newsAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.newsListObjectItemLayoutTitle = (TextView) butterknife.c.a.c(view, R.id.news_list_object_item_layout_title, "field 'newsListObjectItemLayoutTitle'", TextView.class);
            viewHolder.newsListObjectItemLayoutContent = (TextView) butterknife.c.a.c(view, R.id.news_list_object_item_layout_content, "field 'newsListObjectItemLayoutContent'", TextView.class);
            viewHolder.newsListObjectItemLayoutAddTime = (TextView) butterknife.c.a.c(view, R.id.news_list_object_item_layout_add_time, "field 'newsListObjectItemLayoutAddTime'", TextView.class);
            viewHolder.newsListObjectItemLayoutType = (TextView) butterknife.c.a.c(view, R.id.news_list_object_item_layout_type, "field 'newsListObjectItemLayoutType'", TextView.class);
            viewHolder.newsListObjectItemLayout = (LinearLayout) butterknife.c.a.c(view, R.id.news_list_object_item_layout, "field 'newsListObjectItemLayout'", LinearLayout.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.newsListObjectItemLayoutTitle = null;
                viewHolder.newsListObjectItemLayoutContent = null;
                viewHolder.newsListObjectItemLayoutAddTime = null;
                viewHolder.newsListObjectItemLayoutType = null;
                viewHolder.newsListObjectItemLayout = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public NewsAdapter(Context context, List<NewsBean.DataBean> list) {
        super(list);
        this.f95c = context;
        this.d = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f95c).inflate(R.layout.news_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(this, view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.newsListObjectItemLayoutAddTime.setText(com.rtk.app.tool.c0.g(this.d.get(i).getAddtime()));
        viewHolder.newsListObjectItemLayoutTitle.setText(this.d.get(i).getNew_title());
        viewHolder.newsListObjectItemLayoutContent.setText(this.d.get(i).getDescription());
        viewHolder.newsListObjectItemLayoutType.setText(com.rtk.app.tool.t.N(this.d.get(i).getCate_id()));
        return view;
    }
}
