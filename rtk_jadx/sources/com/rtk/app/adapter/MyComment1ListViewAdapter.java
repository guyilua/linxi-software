package com.rtk.app.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.bean.MyCommentItemBean;
import com.rtk.app.tool.ApkInfo;
import com.zhy.view.flowlayout.FlowLayout;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyComment1ListViewAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f86c;
    private List<MyCommentItemBean.DataBean> d;
    private com.rtk.app.main.comment.express.c e;
    private int f;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        LinearLayout myComment1ListviewItemAddLy;

        @BindView
        TextView myComment1ListviewItemContent;

        @BindView
        FlowLayout myComment1ListviewItemFlowLayout;

        @BindView
        ImageView myComment1ListviewItemGameImg;

        @BindView
        LinearLayout myComment1ListviewItemGameLayout;

        @BindView
        TextView myComment1ListviewItemGameName;

        @BindView
        ImageView myComment1ListviewItemStart;

        @BindView
        TextView myComment1ListviewItemTime;

        ViewHolder(MyComment1ListViewAdapter myComment1ListViewAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.myComment1ListviewItemGameLayout = (LinearLayout) butterknife.c.a.c(view, R.id.my_comment1_listview_item_game_layout, "field 'myComment1ListviewItemGameLayout'", LinearLayout.class);
            viewHolder.myComment1ListviewItemGameImg = (ImageView) butterknife.c.a.c(view, R.id.my_comment1_listview_item_game_img, "field 'myComment1ListviewItemGameImg'", ImageView.class);
            viewHolder.myComment1ListviewItemGameName = (TextView) butterknife.c.a.c(view, R.id.my_comment1_listview_item_game_name, "field 'myComment1ListviewItemGameName'", TextView.class);
            viewHolder.myComment1ListviewItemStart = (ImageView) butterknife.c.a.c(view, R.id.my_comment1_listview_item_start, "field 'myComment1ListviewItemStart'", ImageView.class);
            viewHolder.myComment1ListviewItemTime = (TextView) butterknife.c.a.c(view, R.id.my_comment1_listview_item_time, "field 'myComment1ListviewItemTime'", TextView.class);
            viewHolder.myComment1ListviewItemAddLy = (LinearLayout) butterknife.c.a.c(view, R.id.my_comment1_listview_item_add_ly, "field 'myComment1ListviewItemAddLy'", LinearLayout.class);
            viewHolder.myComment1ListviewItemContent = (TextView) butterknife.c.a.c(view, R.id.my_comment1_listview_item_content, "field 'myComment1ListviewItemContent'", TextView.class);
            viewHolder.myComment1ListviewItemFlowLayout = (FlowLayout) butterknife.c.a.c(view, R.id.my_comment1_listview_item_flowLayout, "field 'myComment1ListviewItemFlowLayout'", FlowLayout.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.myComment1ListviewItemGameLayout = null;
                viewHolder.myComment1ListviewItemGameImg = null;
                viewHolder.myComment1ListviewItemGameName = null;
                viewHolder.myComment1ListviewItemStart = null;
                viewHolder.myComment1ListviewItemTime = null;
                viewHolder.myComment1ListviewItemAddLy = null;
                viewHolder.myComment1ListviewItemContent = null;
                viewHolder.myComment1ListviewItemFlowLayout = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private class a implements View.OnClickListener {
        private int a;
        private int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.a != 1) {
                return;
            }
            MyCommentItemBean.DataBean dataBean = (MyCommentItemBean.DataBean) MyComment1ListViewAdapter.this.d.get(this.b);
            com.rtk.app.tool.t.e0(MyComment1ListViewAdapter.this.f86c, new ApkInfo(dataBean.getGame_id(), dataBean.getGame_name(), dataBean.getPackage_name(), dataBean.getGame_logo(), dataBean.getData_package_size(), null, 1, 1, null));
        }
    }

    public MyComment1ListViewAdapter(Context context, List<MyCommentItemBean.DataBean> list, int i) {
        super(list);
        this.f86c = context;
        this.d = list;
        this.f = i;
        this.e = com.rtk.app.main.comment.express.c.g();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f86c).inflate(R.layout.my_comment1_listview_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(this, view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        int star = this.d.get(i).getStar();
        if (star == 1) {
            viewHolder.myComment1ListviewItemStart.setBackgroundResource(R.mipmap.star_1);
        } else if (star == 2) {
            viewHolder.myComment1ListviewItemStart.setBackgroundResource(R.mipmap.star_4);
        } else if (star == 3) {
            viewHolder.myComment1ListviewItemStart.setBackgroundResource(R.mipmap.star_6);
        } else if (star == 4) {
            viewHolder.myComment1ListviewItemStart.setBackgroundResource(R.mipmap.star_8);
        } else if (star != 5) {
            viewHolder.myComment1ListviewItemStart.setBackgroundResource(R.mipmap.star_10);
        } else {
            viewHolder.myComment1ListviewItemStart.setBackgroundResource(R.mipmap.star_10);
        }
        com.rtk.app.tool.t.d(this.f86c, this.d.get(i).getGame_logo(), viewHolder.myComment1ListviewItemGameImg);
        viewHolder.myComment1ListviewItemGameName.setText(this.d.get(i).getGame_name());
        switch (this.f) {
            case 1:
                viewHolder.myComment1ListviewItemContent.setText(this.e.a(Html.fromHtml("<font color='#47a83a'><small>我的评论：</small></font>" + this.d.get(i).getUcontent())));
                break;
            case 2:
                viewHolder.myComment1ListviewItemContent.setText(this.e.a(Html.fromHtml("<font color='#47a83a'><small>" + this.d.get(i).getT_name() + "：</small></font>" + this.d.get(i).getTcontent() + "<br><font color='#47a83a'><small>我回复：</small></font>" + this.d.get(i).getUcontent())));
                break;
            case 3:
                viewHolder.myComment1ListviewItemContent.setText(this.e.a(Html.fromHtml("<font color='#47a83a'><small>我的评论：</small></font>" + this.d.get(i).getTcontent() + "<br><font color='#47a83a'><small>" + this.d.get(i).getU_name() + "</small></font><font color='#FE8A23'><small>回复我：</small></font>" + this.d.get(i).getUcontent())));
                break;
            case 4:
                viewHolder.myComment1ListviewItemContent.setText(this.e.a(Html.fromHtml("<font color='#47a83a'><small>TA的评论：</small></font>" + this.d.get(i).getUcontent())));
                break;
            case 5:
                viewHolder.myComment1ListviewItemContent.setText(this.e.a(Html.fromHtml("<font color='#47a83a'><small>" + this.d.get(i).getT_name() + "：</small></font>" + this.d.get(i).getTcontent() + "<br><font color='#47a83a'><small>TA回复：</small></font>" + this.d.get(i).getUcontent())));
                break;
            case 6:
                viewHolder.myComment1ListviewItemContent.setText(this.e.a(Html.fromHtml("<font color='#47a83a'><small>TA的评论：</small></font>" + this.d.get(i).getTcontent() + "<br><font color='#47a83a'><small>" + this.d.get(i).getU_name() + "</small></font><font color='#FE8A23'><small>回复TA：</small></font>" + this.d.get(i).getUcontent())));
                break;
        }
        viewHolder.myComment1ListviewItemTime.setText(com.rtk.app.tool.c0.f(this.d.get(i).getTime()));
        viewHolder.myComment1ListviewItemGameLayout.setOnClickListener(new a(1, i));
        com.rtk.app.tool.t.i(this.f86c, viewHolder.myComment1ListviewItemFlowLayout, this.d.get(i).getPic());
        return view;
    }

    public void h(int i) {
        this.f = i;
    }
}
