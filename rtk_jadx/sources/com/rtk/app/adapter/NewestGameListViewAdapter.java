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
public class NewestGameListViewAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f93c;
    private List<DataBean> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        TextView newestGameListviewItemDownLoad;

        @BindView
        TextView newestGameListviewItemGameName;

        @BindView
        ImageView newestGameListviewItemIcon;

        @BindView
        TextView newestGameListviewItemLanguage;

        @BindView
        ProgressBar newestGameListviewItemProgressBar;

        @BindView
        TextView newestGameListviewItemSize;

        @BindView
        TagFlowLayout newestGameListviewItemTag;

        @BindView
        TextView newestGameListviewItemTime;

        @BindView
        TextView newestGameListviewItemType;

        @BindView
        TextView newestGameListviewItemVersion;

        ViewHolder(NewestGameListViewAdapter newestGameListViewAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.newestGameListviewItemIcon = (ImageView) butterknife.c.a.c(view, R.id.newest_game_listview_item_icon, "field 'newestGameListviewItemIcon'", ImageView.class);
            viewHolder.newestGameListviewItemProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.newest_game_listview_item_ProgressBar, "field 'newestGameListviewItemProgressBar'", ProgressBar.class);
            viewHolder.newestGameListviewItemDownLoad = (TextView) butterknife.c.a.c(view, R.id.newest_game_listview_item_downLoad, "field 'newestGameListviewItemDownLoad'", TextView.class);
            viewHolder.newestGameListviewItemGameName = (TextView) butterknife.c.a.c(view, R.id.newest_game_listview_item_GameName, "field 'newestGameListviewItemGameName'", TextView.class);
            viewHolder.newestGameListviewItemTime = (TextView) butterknife.c.a.c(view, R.id.newest_game_listview_item_time, "field 'newestGameListviewItemTime'", TextView.class);
            viewHolder.newestGameListviewItemVersion = (TextView) butterknife.c.a.c(view, R.id.newest_game_listview_item_version, "field 'newestGameListviewItemVersion'", TextView.class);
            viewHolder.newestGameListviewItemTag = (TagFlowLayout) butterknife.c.a.c(view, R.id.newest_game_listview_item_tag, "field 'newestGameListviewItemTag'", TagFlowLayout.class);
            viewHolder.newestGameListviewItemType = (TextView) butterknife.c.a.c(view, R.id.newest_game_listview_item_type, "field 'newestGameListviewItemType'", TextView.class);
            viewHolder.newestGameListviewItemLanguage = (TextView) butterknife.c.a.c(view, R.id.newest_game_listview_item_language, "field 'newestGameListviewItemLanguage'", TextView.class);
            viewHolder.newestGameListviewItemSize = (TextView) butterknife.c.a.c(view, R.id.newest_game_listview_item_size, "field 'newestGameListviewItemSize'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.newestGameListviewItemIcon = null;
                viewHolder.newestGameListviewItemProgressBar = null;
                viewHolder.newestGameListviewItemDownLoad = null;
                viewHolder.newestGameListviewItemGameName = null;
                viewHolder.newestGameListviewItemTime = null;
                viewHolder.newestGameListviewItemVersion = null;
                viewHolder.newestGameListviewItemTag = null;
                viewHolder.newestGameListviewItemType = null;
                viewHolder.newestGameListviewItemLanguage = null;
                viewHolder.newestGameListviewItemSize = null;
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
            com.rtk.app.tool.DownLoadTool.r.g(NewestGameListViewAdapter.this.f93c, new ApkInfo((DataBean) NewestGameListViewAdapter.this.d.get(this.b)), (TextView) view);
        }
    }

    public NewestGameListViewAdapter(Context context, List<DataBean> list) {
        super(list);
        this.f93c = context;
        this.d = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f93c).inflate(R.layout.newest_game_listview_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(this, view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.newestGameListviewItemGameName.setText(this.d.get(i).getGame_name());
        com.rtk.app.tool.t.d(this.f93c, this.d.get(i).getGame_logo(), viewHolder.newestGameListviewItemIcon);
        viewHolder.newestGameListviewItemSize.setText(this.d.get(i).getPackage_size());
        viewHolder.newestGameListviewItemTime.setText(com.rtk.app.tool.c0.g(this.d.get(i).getGame_updated()));
        viewHolder.newestGameListviewItemVersion.setText("V" + this.d.get(i).getGame_version());
        viewHolder.newestGameListviewItemTag.setAdapter(new d3(this.d.get(i).getTag_name(), this.f93c));
        viewHolder.newestGameListviewItemType.setText(this.d.get(i).getGame_type());
        viewHolder.newestGameListviewItemLanguage.setText(this.d.get(i).getLangues());
        int game_id = this.d.get(i).getGame_id();
        viewHolder.newestGameListviewItemDownLoad.setTag(Integer.valueOf(game_id));
        viewHolder.newestGameListviewItemDownLoad.setOnClickListener(new a(0, i));
        com.rtk.app.tool.DownLoadTool.u uVar = new com.rtk.app.tool.DownLoadTool.u(viewHolder.newestGameListviewItemProgressBar, game_id, viewHolder.newestGameListviewItemDownLoad);
        this.b.add(uVar);
        com.rtk.app.tool.DownLoadTool.x.c().a(uVar);
        com.rtk.app.tool.DownLoadTool.r.h(this.f93c, new ApkInfo(this.d.get(i)), viewHolder.newestGameListviewItemDownLoad, viewHolder.newestGameListviewItemProgressBar);
        return view;
    }
}
