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
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.bean.MyMessageForUserBean;
import com.rtk.app.custom.CustomTextView;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyMessageForUserAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f88c;
    private List<MyMessageForUserBean.DataBean> d;
    private com.rtk.app.tool.s e;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ViewHolder {

        @BindView
        TextView myMessageForUserItemContent;

        @BindView
        RoundedImageView myMessageForUserItemIcon;

        @BindView
        LinearLayout myMessageForUserItemIconLv;

        @BindView
        TextView myMessageForUserItemReadIt;

        @BindView
        TextView myMessageForUserItemState;

        @BindView
        TextView myMessageForUserItemTime;

        @BindView
        CustomTextView myMessageForUserItemTitle;

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
            viewHolder.myMessageForUserItemIconLv = (LinearLayout) butterknife.c.a.c(view, R.id.my_message_for_user_item_icon_lv, "field 'myMessageForUserItemIconLv'", LinearLayout.class);
            viewHolder.myMessageForUserItemIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.my_message_for_user_item_icon, "field 'myMessageForUserItemIcon'", RoundedImageView.class);
            viewHolder.myMessageForUserItemTitle = (CustomTextView) butterknife.c.a.c(view, R.id.my_message_for_user_item_title, "field 'myMessageForUserItemTitle'", CustomTextView.class);
            viewHolder.myMessageForUserItemContent = (TextView) butterknife.c.a.c(view, R.id.my_message_for_user_item_content, "field 'myMessageForUserItemContent'", TextView.class);
            viewHolder.myMessageForUserItemTime = (TextView) butterknife.c.a.c(view, R.id.my_message_for_user_item_time, "field 'myMessageForUserItemTime'", TextView.class);
            viewHolder.myMessageForUserItemState = (TextView) butterknife.c.a.c(view, R.id.my_message_for_user_item_state, "field 'myMessageForUserItemState'", TextView.class);
            viewHolder.myMessageForUserItemReadIt = (TextView) butterknife.c.a.c(view, R.id.my_message_for_user_item_readIt, "field 'myMessageForUserItemReadIt'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.myMessageForUserItemIconLv = null;
                viewHolder.myMessageForUserItemIcon = null;
                viewHolder.myMessageForUserItemTitle = null;
                viewHolder.myMessageForUserItemContent = null;
                viewHolder.myMessageForUserItemTime = null;
                viewHolder.myMessageForUserItemState = null;
                viewHolder.myMessageForUserItemReadIt = null;
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
            int intValue = ((Integer) view.getTag()).intValue();
            if (((MyMessageForUserBean.DataBean) MyMessageForUserAdapter.this.d.get(intValue)).getUid().equals("0")) {
                return;
            }
            com.rtk.app.tool.t.B0(MyMessageForUserAdapter.this.f88c, ((MyMessageForUserBean.DataBean) MyMessageForUserAdapter.this.d.get(intValue)).getUid());
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            MyMessageForUserAdapter.this.e.a(intValue + "");
        }
    }

    public MyMessageForUserAdapter(Context context, List<MyMessageForUserBean.DataBean> list, com.rtk.app.tool.s sVar) {
        super(list);
        this.f88c = context;
        this.d = list;
        this.e = sVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f88c).inflate(R.layout.my_message_for_user_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.myMessageForUserItemTitle.setLeftText(this.d.get(i).getNickname());
        CustomTextView customTextView = viewHolder.myMessageForUserItemTitle;
        String str = "";
        if (!this.d.get(i).getCoin().equals("0")) {
            str = "" + this.d.get(i).getCoin() + "金币";
        }
        customTextView.setRightText(str);
        viewHolder.myMessageForUserItemTitle.setText(this.d.get(i).getTitle());
        com.rtk.app.tool.t.c(this.f88c, this.d.get(i).getFace(), viewHolder.myMessageForUserItemIcon, new boolean[0]);
        com.rtk.app.tool.c0.u("MyMessageForUserAdapter", "头像地址" + this.d.get(i).getFace());
        viewHolder.myMessageForUserItemIconLv.setTag(Integer.valueOf(i));
        viewHolder.myMessageForUserItemIconLv.setOnClickListener(new a());
        viewHolder.myMessageForUserItemContent.setText(this.d.get(i).getMsg());
        viewHolder.myMessageForUserItemTime.setText(this.d.get(i).getEdittime());
        viewHolder.myMessageForUserItemState.setText(this.d.get(i).getOpened().equals("0") ? "未读" : "已读");
        viewHolder.myMessageForUserItemState.setEnabled(!this.d.get(i).getOpened().equals("0"));
        viewHolder.myMessageForUserItemReadIt.setVisibility(8);
        viewHolder.myMessageForUserItemReadIt.setTag(Integer.valueOf(i));
        viewHolder.myMessageForUserItemReadIt.setOnClickListener(new b());
        return view;
    }
}
