package com.rtk.app.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.bean.ModuleDetailsBean;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostModeratorListAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private List<ModuleDetailsBean.DataBean.ModeratorListBean> f102c;
    private Activity d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ViewHolder {

        @BindView
        RoundedImageView postModeratorListIcon;

        @BindView
        TextView postModeratorListNickName;

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
            viewHolder.postModeratorListIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.post_moderator_list_icon, "field 'postModeratorListIcon'", RoundedImageView.class);
            viewHolder.postModeratorListNickName = (TextView) butterknife.c.a.c(view, R.id.post_moderator_list_nickName, "field 'postModeratorListNickName'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.postModeratorListIcon = null;
                viewHolder.postModeratorListNickName = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public PostModeratorListAdapter(Activity activity, List<ModuleDetailsBean.DataBean.ModeratorListBean> list) {
        super(list);
        this.d = activity;
        this.f102c = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.d).inflate(R.layout.post_moderator_list_layout, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        com.rtk.app.tool.t.c(this.d, this.f102c.get(i).getFace(), viewHolder.postModeratorListIcon, new boolean[0]);
        viewHolder.postModeratorListNickName.setText(this.f102c.get(i).getNickname());
        return inflate;
    }
}
