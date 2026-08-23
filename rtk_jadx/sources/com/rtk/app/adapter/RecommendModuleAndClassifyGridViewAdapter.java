package com.rtk.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
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
import com.rtk.app.bean.RecommendModuleAndClassifyBean;
import com.rtk.app.main.LiBaoListActivity;
import com.rtk.app.main.MainActivityPack.GameRankListActivity;
import com.rtk.app.main.OpenServiceActivity;
import com.rtk.app.main.UpModule.UpApkListActivity;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class RecommendModuleAndClassifyGridViewAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f106c;
    private RecommendModuleAndClassifyBean.DataBean d;
    private b e;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ViewHolder {

        @BindView
        ImageView gameGridviewItemImg;

        @BindView
        TextView gameGridviewItemName;

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
            viewHolder.gameGridviewItemImg = (ImageView) butterknife.c.a.c(view, R.id.game_gridview_item_img, "field 'gameGridviewItemImg'", ImageView.class);
            viewHolder.gameGridviewItemName = (TextView) butterknife.c.a.c(view, R.id.game_gridview_item_name, "field 'gameGridviewItemName'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.gameGridviewItemImg = null;
                viewHolder.gameGridviewItemName = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements View.OnClickListener {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = RecommendModuleAndClassifyGridViewAdapter.this.e;
            b bVar2 = b.HomePage;
            String methods = bVar == bVar2 ? RecommendModuleAndClassifyGridViewAdapter.this.d.getAppcategory().get(this.a).getMethods() : RecommendModuleAndClassifyGridViewAdapter.this.d.getGamecategory().get(this.a).getMethods();
            String title = RecommendModuleAndClassifyGridViewAdapter.this.e == bVar2 ? RecommendModuleAndClassifyGridViewAdapter.this.d.getAppcategory().get(this.a).getTitle() : RecommendModuleAndClassifyGridViewAdapter.this.d.getGamecategory().get(this.a).getTitle();
            Map<String, String> type = RecommendModuleAndClassifyGridViewAdapter.this.e == bVar2 ? RecommendModuleAndClassifyGridViewAdapter.this.d.getAppcategory().get(this.a).getType() : RecommendModuleAndClassifyGridViewAdapter.this.d.getGamecategory().get(this.a).getType();
            methods.hashCode();
            char c2 = 65535;
            switch (methods.hashCode()) {
                case -1768442992:
                    if (methods.equals("gamelist")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1768272098:
                    if (methods.equals("gamerank")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1580983409:
                    if (methods.equals("customlist")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1485610008:
                    if (methods.equals("littlegame")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1140035200:
                    if (methods.equals("kaifulist")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 141096688:
                    if (methods.equals("gamecategory")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 338813073:
                    if (methods.equals("libaolist")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1711001652:
                    if (methods.equals("upsourceList")) {
                        c2 = 7;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    com.rtk.app.tool.t.T0(RecommendModuleAndClassifyGridViewAdapter.this.f106c, title, type);
                    return;
                case 1:
                    com.rtk.app.tool.c.b((Activity) RecommendModuleAndClassifyGridViewAdapter.this.f106c, GameRankListActivity.class, null);
                    return;
                case 2:
                    com.rtk.app.tool.t.U0(RecommendModuleAndClassifyGridViewAdapter.this.f106c, title, new HashMap(), type.get("custom_url"));
                    return;
                case 3:
                    return;
                case 4:
                    new Bundle();
                    com.rtk.app.tool.c.b((Activity) RecommendModuleAndClassifyGridViewAdapter.this.f106c, OpenServiceActivity.class, null);
                    return;
                case 5:
                    com.rtk.app.tool.t.t0(RecommendModuleAndClassifyGridViewAdapter.this.f106c);
                    return;
                case 6:
                    com.rtk.app.tool.c.b((Activity) RecommendModuleAndClassifyGridViewAdapter.this.f106c, LiBaoListActivity.class, null);
                    return;
                case 7:
                    com.rtk.app.tool.c.b((Activity) RecommendModuleAndClassifyGridViewAdapter.this.f106c, UpApkListActivity.class, null);
                    return;
                default:
                    com.rtk.app.tool.c0.u("RecommendModuleAndClassifyGridViewAdapter", "位置类型" + methods);
                    return;
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum b {
        HomePage,
        GamePage
    }

    public RecommendModuleAndClassifyGridViewAdapter(Context context, RecommendModuleAndClassifyBean.DataBean dataBean, b bVar) {
        super(bVar == b.HomePage ? dataBean.getAppcategory() : dataBean.getGamecategory());
        this.f106c = context;
        this.d = dataBean;
        this.e = bVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f106c).inflate(R.layout.game_gridview_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        if (this.e == b.HomePage) {
            com.rtk.app.tool.t.d(this.f106c, this.d.getAppcategory().get(i).getIcon(), viewHolder.gameGridviewItemImg);
            viewHolder.gameGridviewItemName.setText(this.d.getAppcategory().get(i).getTitle());
        } else {
            com.rtk.app.tool.t.d(this.f106c, this.d.getGamecategory().get(i).getIcon(), viewHolder.gameGridviewItemImg);
            viewHolder.gameGridviewItemName.setText(this.d.getGamecategory().get(i).getTitle());
        }
        viewHolder.gameGridviewItemImg.setOnClickListener(new a(i));
        return view;
    }
}
