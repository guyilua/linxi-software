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
import com.rtk.app.bean.GameDetailsBean;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GameDetailsItem1RecommentGameAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f57c;
    private List<GameDetailsBean.DataBean.RecomGameBean> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        ImageView gameDetailsItem1GameRecommendItemIcon;

        @BindView
        TextView gameDetailsItem1GameRecommendItemName;

        ViewHolder(GameDetailsItem1RecommentGameAdapter gameDetailsItem1RecommentGameAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.gameDetailsItem1GameRecommendItemIcon = (ImageView) butterknife.c.a.c(view, R.id.game_details_item1_game_recommend_item_icon, "field 'gameDetailsItem1GameRecommendItemIcon'", ImageView.class);
            viewHolder.gameDetailsItem1GameRecommendItemName = (TextView) butterknife.c.a.c(view, R.id.game_details_item1_game_recommend_item_name, "field 'gameDetailsItem1GameRecommendItemName'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.gameDetailsItem1GameRecommendItemIcon = null;
                viewHolder.gameDetailsItem1GameRecommendItemName = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public GameDetailsItem1RecommentGameAdapter(Context context, List<GameDetailsBean.DataBean.RecomGameBean> list) {
        super(list);
        this.f57c = context;
        this.d = list;
    }

    @Override // com.rtk.app.adapter.a3, android.widget.Adapter
    public int getCount() {
        if (this.d.size() > 4) {
            return 4;
        }
        return this.d.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f57c).inflate(R.layout.game_details_item1_recommend_game_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(this, view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        com.rtk.app.tool.t.d(this.f57c, this.d.get(i).getGame_logo(), viewHolder.gameDetailsItem1GameRecommendItemIcon);
        viewHolder.gameDetailsItem1GameRecommendItemName.setText(this.d.get(i).getGame_name());
        return view;
    }
}
