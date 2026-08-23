package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.bean.DataBean;
import com.rtk.app.tool.ApkInfo;
import com.zhy.view.flowlayout.TagFlowLayout;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GameListViewAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f59c;
    private List<DataBean> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        TextView gameListViewItemVersion;

        @BindView
        TextView gameListviewItemDownLoad;

        @BindView
        TextView gameListviewItemGameName;

        @BindView
        ImageView gameListviewItemIcon;

        @BindView
        TextView gameListviewItemLanguage;

        @BindView
        ProgressBar gameListviewItemProgressBar;

        @BindView
        ImageView gameListviewItemRang;

        @BindView
        TextView gameListviewItemSize;

        @BindView
        TagFlowLayout gameListviewItemTag;

        @BindView
        TextView gameListviewItemType;

        ViewHolder(GameListViewAdapter gameListViewAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.gameListviewItemIcon = (ImageView) butterknife.c.a.c(view, R.id.game_listview_item_icon, "field 'gameListviewItemIcon'", ImageView.class);
            viewHolder.gameListviewItemProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.game_listview_item_ProgressBar, "field 'gameListviewItemProgressBar'", ProgressBar.class);
            viewHolder.gameListviewItemDownLoad = (TextView) butterknife.c.a.c(view, R.id.game_listview_item_downLoad, "field 'gameListviewItemDownLoad'", TextView.class);
            viewHolder.gameListviewItemGameName = (TextView) butterknife.c.a.c(view, R.id.game_listview_item_GameName, "field 'gameListviewItemGameName'", TextView.class);
            viewHolder.gameListviewItemRang = (ImageView) butterknife.c.a.c(view, R.id.game_listview_item_rang, "field 'gameListviewItemRang'", ImageView.class);
            viewHolder.gameListViewItemVersion = (TextView) butterknife.c.a.c(view, R.id.game_listView_item_version, "field 'gameListViewItemVersion'", TextView.class);
            viewHolder.gameListviewItemTag = (TagFlowLayout) butterknife.c.a.c(view, R.id.game_listview_item_tag, "field 'gameListviewItemTag'", TagFlowLayout.class);
            viewHolder.gameListviewItemType = (TextView) butterknife.c.a.c(view, R.id.game_listview_item_type, "field 'gameListviewItemType'", TextView.class);
            viewHolder.gameListviewItemLanguage = (TextView) butterknife.c.a.c(view, R.id.game_listview_item_language, "field 'gameListviewItemLanguage'", TextView.class);
            viewHolder.gameListviewItemSize = (TextView) butterknife.c.a.c(view, R.id.game_listview_item_size, "field 'gameListviewItemSize'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.gameListviewItemIcon = null;
                viewHolder.gameListviewItemProgressBar = null;
                viewHolder.gameListviewItemDownLoad = null;
                viewHolder.gameListviewItemGameName = null;
                viewHolder.gameListviewItemRang = null;
                viewHolder.gameListViewItemVersion = null;
                viewHolder.gameListviewItemTag = null;
                viewHolder.gameListviewItemType = null;
                viewHolder.gameListviewItemLanguage = null;
                viewHolder.gameListviewItemSize = null;
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
            com.rtk.app.tool.DownLoadTool.r.g(GameListViewAdapter.this.f59c, new ApkInfo((DataBean) GameListViewAdapter.this.d.get(this.b)), (TextView) view);
        }
    }

    public GameListViewAdapter(Context context, List<DataBean> list) {
        super(list);
        this.f59c = context;
        this.d = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f59c).inflate(R.layout.game_listview_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(this, view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.gameListviewItemGameName.setText(this.d.get(i).getGame_name());
        com.rtk.app.tool.t.d(this.f59c, this.d.get(i).getGame_logo(), viewHolder.gameListviewItemIcon);
        viewHolder.gameListviewItemLanguage.setText(this.d.get(i).getLangues());
        try {
            viewHolder.gameListviewItemTag.setAdapter(new d3(this.d.get(i).getTag_name(), this.f59c));
        } catch (Exception unused) {
        }
        viewHolder.gameListviewItemType.setText(this.d.get(i).getGame_type());
        viewHolder.gameListviewItemSize.setText(this.d.get(i).getPackage_size());
        viewHolder.gameListViewItemVersion.setText("V" + this.d.get(i).getGame_version());
        switch (this.d.get(i).getGame_level()) {
            case 1:
                viewHolder.gameListviewItemRang.setBackgroundResource(R.mipmap.star_1);
                break;
            case 2:
                viewHolder.gameListviewItemRang.setBackgroundResource(R.mipmap.star_2);
                break;
            case 3:
                viewHolder.gameListviewItemRang.setBackgroundResource(R.mipmap.star_3);
                break;
            case 4:
                viewHolder.gameListviewItemRang.setBackgroundResource(R.mipmap.star_4);
                break;
            case 5:
                viewHolder.gameListviewItemRang.setBackgroundResource(R.mipmap.star_5);
                break;
            case 6:
                viewHolder.gameListviewItemRang.setBackgroundResource(R.mipmap.star_6);
                break;
            case 7:
                viewHolder.gameListviewItemRang.setBackgroundResource(R.mipmap.star_7);
                break;
            case 8:
                viewHolder.gameListviewItemRang.setBackgroundResource(R.mipmap.star_8);
                break;
            case 9:
                viewHolder.gameListviewItemRang.setBackgroundResource(R.mipmap.star_9);
                break;
            case 10:
                viewHolder.gameListviewItemRang.setBackgroundResource(R.mipmap.star_10);
                break;
            default:
                viewHolder.gameListviewItemRang.setBackgroundResource(R.mipmap.star_10);
                break;
        }
        viewHolder.gameListviewItemDownLoad.setTag(Integer.valueOf(this.d.get(i).getGame_id()));
        viewHolder.gameListviewItemDownLoad.setOnClickListener(new a(0, i));
        com.rtk.app.tool.DownLoadTool.u uVar = new com.rtk.app.tool.DownLoadTool.u(viewHolder.gameListviewItemProgressBar, this.d.get(i).getGame_id(), viewHolder.gameListviewItemDownLoad);
        this.b.add(uVar);
        com.rtk.app.tool.DownLoadTool.x.c().a(uVar);
        com.rtk.app.tool.DownLoadTool.r.h(this.f59c, new ApkInfo(this.d.get(i)), viewHolder.gameListviewItemDownLoad, viewHolder.gameListviewItemProgressBar);
        return view;
    }
}
