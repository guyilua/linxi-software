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
public class PostRewardListAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f103c;
    private List<PostUpAndRewardListBean.DataBean> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    protected static class ViewHolder {

        @BindView
        TextView postRewardListCoinNum;

        @BindView
        ImageView postRewardListIcon;

        @BindView
        TextView postRewardListNickName;

        @BindView
        TextView postRewardListTime;

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
            viewHolder.postRewardListIcon = (ImageView) butterknife.c.a.c(view, R.id.post_reward_list_icon, "field 'postRewardListIcon'", ImageView.class);
            viewHolder.postRewardListNickName = (TextView) butterknife.c.a.c(view, R.id.post_reward_list_nickName, "field 'postRewardListNickName'", TextView.class);
            viewHolder.postRewardListTime = (TextView) butterknife.c.a.c(view, R.id.post_reward_list_time, "field 'postRewardListTime'", TextView.class);
            viewHolder.postRewardListCoinNum = (TextView) butterknife.c.a.c(view, R.id.post_reward_list_coinNum, "field 'postRewardListCoinNum'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.postRewardListIcon = null;
                viewHolder.postRewardListNickName = null;
                viewHolder.postRewardListTime = null;
                viewHolder.postRewardListCoinNum = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public PostRewardListAdapter(Context context, List<PostUpAndRewardListBean.DataBean> list) {
        super(list);
        this.f103c = context;
        this.d = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f103c).inflate(R.layout.post_reward_list_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        com.rtk.app.tool.t.c(this.f103c, this.d.get(i).getFace(), viewHolder.postRewardListIcon, new boolean[0]);
        viewHolder.postRewardListCoinNum.setText(this.d.get(i).getCoin());
        viewHolder.postRewardListNickName.setText(this.d.get(i).getNickname());
        viewHolder.postRewardListTime.setText(this.d.get(i).getAddtime());
        return view;
    }
}
