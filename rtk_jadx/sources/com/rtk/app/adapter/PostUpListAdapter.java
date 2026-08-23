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
import com.rtk.app.bean.PostUpAndRewardListBean;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostUpListAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f104c;
    private List<PostUpAndRewardListBean.DataBean> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ViewHolder {

        @BindView
        ImageView postUpListIcon;

        @BindView
        TextView postUpListNickName;

        @BindView
        TextView postUpListTime;

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
            viewHolder.postUpListIcon = (ImageView) butterknife.c.a.c(view, R.id.post_up_list_icon, "field 'postUpListIcon'", ImageView.class);
            viewHolder.postUpListNickName = (TextView) butterknife.c.a.c(view, R.id.post_up_list_nickName, "field 'postUpListNickName'", TextView.class);
            viewHolder.postUpListTime = (TextView) butterknife.c.a.c(view, R.id.post_up_list_time, "field 'postUpListTime'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.postUpListIcon = null;
                viewHolder.postUpListNickName = null;
                viewHolder.postUpListTime = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public PostUpListAdapter(Context context, List<PostUpAndRewardListBean.DataBean> list) {
        super(list);
        this.f104c = context;
        this.d = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f104c).inflate(R.layout.post_up_list_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        com.rtk.app.tool.t.c(this.f104c, this.d.get(i).getFace(), viewHolder.postUpListIcon, new boolean[0]);
        viewHolder.postUpListNickName.setText(this.d.get(i).getNickname());
        viewHolder.postUpListTime.setText(this.d.get(i).getAddtime());
        return view;
    }
}
