package com.rtk.app.main.HomeCommunityPack.PostAdapter;

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
import butterknife.c.a;
import com.rtk.app.R;
import com.rtk.app.adapter.a3;
import com.rtk.app.bean.CommunityListBean;
import com.rtk.app.tool.t;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CommunityTopAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f188c;
    private List<CommunityListBean.DataBean.TopBean> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ViewHolder {

        @BindView
        TextView communityTopListItemTitle;

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
            viewHolder.communityTopListItemTitle = (TextView) a.c(view, R.id.community_top_list_item_title, "field 'communityTopListItemTitle'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.communityTopListItemTitle = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public CommunityTopAdapter(Context context, List<CommunityListBean.DataBean.TopBean> list) {
        super(list);
        this.d = list;
        this.f188c = context;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f188c).inflate(R.layout.community_top_list_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        t.U1(viewHolder.communityTopListItemTitle, this.d.get(i).getTitle(), this.d.get(i).getPost_title());
        return view;
    }
}
