package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.bean.GameDetailsBean;
import com.rtk.app.tool.ApkInfo;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GameDetailsItem1OtherVersionAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f55c;
    private List<GameDetailsBean.DataBean.OtherVersionBean> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class MyHolder {

        @BindView
        RelativeLayout gameDetailsItem1OtherVersionItemDownLoadLv;

        @BindView
        TextView gameDetailsItem1OtherVersionItemItemDownLoad;

        @BindView
        TextView gameDetailsItem1OtherVersionItemName;

        @BindView
        ProgressBar gameDetailsItem1OtherVersionItemProgressBar;

        @BindView
        TextView gameDetailsItem1OtherVersionItemVersion;

        MyHolder(GameDetailsItem1OtherVersionAdapter gameDetailsItem1OtherVersionAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class MyHolder_ViewBinding implements Unbinder {
        private MyHolder b;

        @UiThread
        public MyHolder_ViewBinding(MyHolder myHolder, View view) {
            this.b = myHolder;
            myHolder.gameDetailsItem1OtherVersionItemName = (TextView) butterknife.c.a.c(view, R.id.game_details_item1_other_version_item_name, "field 'gameDetailsItem1OtherVersionItemName'", TextView.class);
            myHolder.gameDetailsItem1OtherVersionItemVersion = (TextView) butterknife.c.a.c(view, R.id.game_details_item1_other_version_item_version, "field 'gameDetailsItem1OtherVersionItemVersion'", TextView.class);
            myHolder.gameDetailsItem1OtherVersionItemProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.game_details_item1_other_version_item_ProgressBar, "field 'gameDetailsItem1OtherVersionItemProgressBar'", ProgressBar.class);
            myHolder.gameDetailsItem1OtherVersionItemItemDownLoad = (TextView) butterknife.c.a.c(view, R.id.game_details_item1_other_version_item_item_downLoad, "field 'gameDetailsItem1OtherVersionItemItemDownLoad'", TextView.class);
            myHolder.gameDetailsItem1OtherVersionItemDownLoadLv = (RelativeLayout) butterknife.c.a.c(view, R.id.game_details_item1_other_version_item_downLoad_lv, "field 'gameDetailsItem1OtherVersionItemDownLoadLv'", RelativeLayout.class);
        }

        @CallSuper
        public void a() {
            MyHolder myHolder = this.b;
            if (myHolder != null) {
                this.b = null;
                myHolder.gameDetailsItem1OtherVersionItemName = null;
                myHolder.gameDetailsItem1OtherVersionItemVersion = null;
                myHolder.gameDetailsItem1OtherVersionItemProgressBar = null;
                myHolder.gameDetailsItem1OtherVersionItemItemDownLoad = null;
                myHolder.gameDetailsItem1OtherVersionItemDownLoadLv = null;
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
            if (this.a != 0) {
                return;
            }
            com.rtk.app.tool.DownLoadTool.r.g(GameDetailsItem1OtherVersionAdapter.this.f55c, new ApkInfo(((GameDetailsBean.DataBean.OtherVersionBean) GameDetailsItem1OtherVersionAdapter.this.d.get(this.b)).getGame_id(), ((GameDetailsBean.DataBean.OtherVersionBean) GameDetailsItem1OtherVersionAdapter.this.d.get(this.b)).getGame_name(), ((GameDetailsBean.DataBean.OtherVersionBean) GameDetailsItem1OtherVersionAdapter.this.d.get(this.b)).getPackage_name(), ((GameDetailsBean.DataBean.OtherVersionBean) GameDetailsItem1OtherVersionAdapter.this.d.get(this.b)).getGame_logo(), ((GameDetailsBean.DataBean.OtherVersionBean) GameDetailsItem1OtherVersionAdapter.this.d.get(this.b)).getPackage_size(), ((GameDetailsBean.DataBean.OtherVersionBean) GameDetailsItem1OtherVersionAdapter.this.d.get(this.b)).getSignaturesMD5(), ((GameDetailsBean.DataBean.OtherVersionBean) GameDetailsItem1OtherVersionAdapter.this.d.get(this.b)).getIs_apk(), ((GameDetailsBean.DataBean.OtherVersionBean) GameDetailsItem1OtherVersionAdapter.this.d.get(this.b)).getVersion_code(), ((GameDetailsBean.DataBean.OtherVersionBean) GameDetailsItem1OtherVersionAdapter.this.d.get(this.b)).getDownlist()), (TextView) view);
        }
    }

    public GameDetailsItem1OtherVersionAdapter(Context context, List<GameDetailsBean.DataBean.OtherVersionBean> list) {
        super(list);
        this.f55c = context;
        this.d = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyHolder myHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f55c).inflate(R.layout.game_details_item1_other_version_item_layout, (ViewGroup) null);
            myHolder = new MyHolder(this, view);
            view.setTag(myHolder);
        } else {
            myHolder = (MyHolder) view.getTag();
        }
        myHolder.gameDetailsItem1OtherVersionItemName.setText(this.d.get(i).getGame_name());
        myHolder.gameDetailsItem1OtherVersionItemVersion.setText("V" + this.d.get(i).getGame_version() + "\t 更新日期:" + com.rtk.app.tool.c0.g(this.d.get(i).getGame_updated()));
        int game_id = this.d.get(i).getGame_id();
        myHolder.gameDetailsItem1OtherVersionItemItemDownLoad.setTag(Integer.valueOf(game_id));
        myHolder.gameDetailsItem1OtherVersionItemItemDownLoad.setOnClickListener(new a(0, i));
        com.rtk.app.tool.DownLoadTool.u uVar = new com.rtk.app.tool.DownLoadTool.u(myHolder.gameDetailsItem1OtherVersionItemProgressBar, game_id, myHolder.gameDetailsItem1OtherVersionItemItemDownLoad);
        this.b.add(uVar);
        com.rtk.app.tool.DownLoadTool.x.c().a(uVar);
        com.rtk.app.tool.DownLoadTool.r.i(2, this.f55c, new ApkInfo(this.d.get(i).getGame_id(), this.d.get(i).getGame_name(), this.d.get(i).getPackage_name(), this.d.get(i).getGame_logo(), this.d.get(i).getPackage_size(), this.d.get(i).getSignaturesMD5(), this.d.get(i).getIs_apk(), this.d.get(i).getVersion_code(), this.d.get(i).getDownlist()), myHolder.gameDetailsItem1OtherVersionItemItemDownLoad, myHolder.gameDetailsItem1OtherVersionItemProgressBar);
        return view;
    }
}
