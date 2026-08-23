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
import com.rtk.app.bean.DataBean;
import com.zhy.view.flowlayout.TagFlowLayout;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostGameListAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f101c;
    private List<DataBean> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        TextView gameListViewItemVersion;

        @BindView
        TextView gameListviewItemGameName;

        @BindView
        ImageView gameListviewItemIcon;

        @BindView
        TextView gameListviewItemLanguage;

        @BindView
        TextView gameListviewItemSize;

        @BindView
        TagFlowLayout gameListviewItemTag;

        @BindView
        TextView gameListviewItemType;

        ViewHolder(PostGameListAdapter postGameListAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.gameListviewItemIcon = (ImageView) butterknife.c.a.c(view, R.id.newest_game_listview_for_posticon, "field 'gameListviewItemIcon'", ImageView.class);
            viewHolder.gameListviewItemGameName = (TextView) butterknife.c.a.c(view, R.id.newest_game_listview_for_postGameName, "field 'gameListviewItemGameName'", TextView.class);
            viewHolder.gameListViewItemVersion = (TextView) butterknife.c.a.c(view, R.id.newest_game_listview_for_postversion, "field 'gameListViewItemVersion'", TextView.class);
            viewHolder.gameListviewItemTag = (TagFlowLayout) butterknife.c.a.c(view, R.id.newest_game_listview_for_posttag, "field 'gameListviewItemTag'", TagFlowLayout.class);
            viewHolder.gameListviewItemType = (TextView) butterknife.c.a.c(view, R.id.newest_game_listview_for_posttype, "field 'gameListviewItemType'", TextView.class);
            viewHolder.gameListviewItemLanguage = (TextView) butterknife.c.a.c(view, R.id.newest_game_listview_for_postlanguage, "field 'gameListviewItemLanguage'", TextView.class);
            viewHolder.gameListviewItemSize = (TextView) butterknife.c.a.c(view, R.id.newest_game_listview_for_postsize, "field 'gameListviewItemSize'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.gameListviewItemIcon = null;
                viewHolder.gameListviewItemGameName = null;
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

    public PostGameListAdapter(Context context, List<DataBean> list) {
        super(list);
        this.f101c = context;
        this.d = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f101c).inflate(R.layout.game_listview_item_for_post_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(this, view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.gameListviewItemGameName.setText(this.d.get(i).getGame_name());
        com.rtk.app.tool.t.d(this.f101c, this.d.get(i).getGame_logo(), viewHolder.gameListviewItemIcon);
        viewHolder.gameListviewItemLanguage.setText(this.d.get(i).getLangues());
        try {
            viewHolder.gameListviewItemTag.setAdapter(new d3(this.d.get(i).getTag_name(), this.f101c));
        } catch (Exception unused) {
        }
        viewHolder.gameListviewItemType.setText(this.d.get(i).getGame_type());
        viewHolder.gameListviewItemSize.setText(this.d.get(i).getPackage_size());
        viewHolder.gameListViewItemVersion.setText("V" + this.d.get(i).getGame_version());
        return view;
    }
}
