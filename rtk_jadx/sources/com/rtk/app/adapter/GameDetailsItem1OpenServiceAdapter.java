package com.rtk.app.adapter;

import android.annotation.SuppressLint;
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
import com.rtk.app.bean.GameDetailsBean;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GameDetailsItem1OpenServiceAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f54c;
    private List<GameDetailsBean.DataBean.GameTestListBean> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        TextView gameDetailsItem1OpenServiceDay;

        @BindView
        TextView gameDetailsItem1OpenServiceDistrict;

        @BindView
        ImageView gameDetailsItem1OpenServiceDot;

        @BindView
        TextView gameDetailsItem1OpenServiceTime;

        ViewHolder(GameDetailsItem1OpenServiceAdapter gameDetailsItem1OpenServiceAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.gameDetailsItem1OpenServiceDot = (ImageView) butterknife.c.a.c(view, R.id.game_details_item1_open_service_dot, "field 'gameDetailsItem1OpenServiceDot'", ImageView.class);
            viewHolder.gameDetailsItem1OpenServiceDay = (TextView) butterknife.c.a.c(view, R.id.game_details_item1_open_service_day, "field 'gameDetailsItem1OpenServiceDay'", TextView.class);
            viewHolder.gameDetailsItem1OpenServiceTime = (TextView) butterknife.c.a.c(view, R.id.game_details_item1_open_service_time, "field 'gameDetailsItem1OpenServiceTime'", TextView.class);
            viewHolder.gameDetailsItem1OpenServiceDistrict = (TextView) butterknife.c.a.c(view, R.id.game_details_item1_open_service_district, "field 'gameDetailsItem1OpenServiceDistrict'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.gameDetailsItem1OpenServiceDot = null;
                viewHolder.gameDetailsItem1OpenServiceDay = null;
                viewHolder.gameDetailsItem1OpenServiceTime = null;
                viewHolder.gameDetailsItem1OpenServiceDistrict = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public GameDetailsItem1OpenServiceAdapter(Context context, List<GameDetailsBean.DataBean.GameTestListBean> list) {
        super(list);
        this.f54c = context;
        this.d = list;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"ResourceAsColor"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f54c).inflate(R.layout.game_details_item1_open_service_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(this, view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        String h = com.rtk.app.tool.c0.h(this.d.get(i).getStart_time());
        viewHolder.gameDetailsItem1OpenServiceDay.setText(h);
        viewHolder.gameDetailsItem1OpenServiceTime.setText(com.rtk.app.tool.c0.i(this.d.get(i).getStart_time()));
        viewHolder.gameDetailsItem1OpenServiceDistrict.setText(this.d.get(i).getTitle());
        if (h.equals("今天")) {
            viewHolder.gameDetailsItem1OpenServiceDay.setTextColor(this.f54c.getResources().getColor(R.color.openServiceToday));
            viewHolder.gameDetailsItem1OpenServiceTime.setTextColor(this.f54c.getResources().getColor(R.color.openServiceToday));
            viewHolder.gameDetailsItem1OpenServiceDistrict.setTextColor(this.f54c.getResources().getColor(2131100024));
            viewHolder.gameDetailsItem1OpenServiceDistrict.setBackgroundResource(R.drawable.bg_server_name_red);
            viewHolder.gameDetailsItem1OpenServiceDot.setBackgroundResource(R.drawable.icon_ic_dot_red);
        } else if (this.d.get(i).getStart_time() > System.currentTimeMillis() / 1000) {
            viewHolder.gameDetailsItem1OpenServiceDay.setTextColor(this.f54c.getResources().getColor(R.color.openService));
            viewHolder.gameDetailsItem1OpenServiceTime.setTextColor(this.f54c.getResources().getColor(R.color.openService));
            viewHolder.gameDetailsItem1OpenServiceDistrict.setTextColor(this.f54c.getResources().getColor(2131100024));
            viewHolder.gameDetailsItem1OpenServiceDistrict.setBackgroundResource(R.drawable.bg_server_name_green);
            viewHolder.gameDetailsItem1OpenServiceDot.setBackgroundResource(R.drawable.icon_ic_dot_green);
        } else {
            viewHolder.gameDetailsItem1OpenServiceDay.setTextColor(this.f54c.getResources().getColor(R.color.drak666));
            viewHolder.gameDetailsItem1OpenServiceTime.setTextColor(this.f54c.getResources().getColor(R.color.drak666));
            viewHolder.gameDetailsItem1OpenServiceDistrict.setTextColor(this.f54c.getResources().getColor(R.color.drak666));
            viewHolder.gameDetailsItem1OpenServiceDistrict.setBackgroundResource(R.drawable.bg_server_name_gray);
            viewHolder.gameDetailsItem1OpenServiceDot.setBackgroundResource(R.drawable.icon_ic_dot_gray);
        }
        return view;
    }
}
