package com.rtk.app.main.family;

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
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.adapter.a3;
import com.rtk.app.bean.FamilyInfoBean;
import com.rtk.app.bean.PostTitleBean;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyListAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f260c;
    private List<FamilyInfoBean.DataBean> d;
    private boolean e;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        RoundedImageView familyLogo;

        @BindView
        TextView familyName;

        @BindView
        TextView memberNu;

        @BindView
        TextView memberRole;

        @BindView
        View memberRoleLayout;

        @BindView
        TextView role;

        ViewHolder(FamilyListAdapter familyListAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.familyLogo = (RoundedImageView) butterknife.c.a.c(view, R.id.family_logo, "field 'familyLogo'", RoundedImageView.class);
            viewHolder.familyName = (TextView) butterknife.c.a.c(view, R.id.family_name, "field 'familyName'", TextView.class);
            viewHolder.memberNu = (TextView) butterknife.c.a.c(view, R.id.member_nu, "field 'memberNu'", TextView.class);
            viewHolder.memberRole = (TextView) butterknife.c.a.c(view, R.id.member_role, "field 'memberRole'", TextView.class);
            viewHolder.memberRoleLayout = butterknife.c.a.b(view, R.id.member_role_layout, "field 'memberRoleLayout'");
            viewHolder.role = (TextView) butterknife.c.a.c(view, R.id.role, "field 'role'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.familyLogo = null;
                viewHolder.familyName = null;
                viewHolder.memberNu = null;
                viewHolder.memberRole = null;
                viewHolder.memberRoleLayout = null;
                viewHolder.role = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public FamilyListAdapter(Context context, List<FamilyInfoBean.DataBean> list) {
        super(list);
        this.e = false;
        this.f260c = context;
        this.d = list;
    }

    public void e(boolean z) {
        this.e = z;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f260c).inflate(R.layout.family_list_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(this, view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        FamilyInfoBean.DataBean dataBean = this.d.get(i);
        com.rtk.app.tool.t.c(this.f260c, dataBean.getFamily_logo(), viewHolder.familyLogo, new boolean[0]);
        viewHolder.familyName.setText("家族名称：" + dataBean.getFamily_name());
        viewHolder.memberNu.setText("成员数量：" + dataBean.getMember_num());
        List<PostTitleBean> my_role = dataBean.getMy_role();
        if (my_role != null && !my_role.isEmpty()) {
            viewHolder.role.setText(this.e ? "Ta的身份：" : "我的身份：");
            viewHolder.memberRoleLayout.setVisibility(0);
            com.rtk.app.tool.t.T1(viewHolder.memberRole, "", my_role, 5, 5);
        } else {
            viewHolder.memberRoleLayout.setVisibility(8);
        }
        return view;
    }
}
