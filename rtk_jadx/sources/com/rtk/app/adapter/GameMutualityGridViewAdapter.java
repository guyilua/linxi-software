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
import com.rtk.app.bean.RecommendModuleAndClassifyBean;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GameMutualityGridViewAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f61c;
    private List<RecommendModuleAndClassifyBean.DataBean.MatrixBean> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        ImageView gameMutualityGridviewItemImg;

        @BindView
        TextView gameMutualityGridviewItemTypeName;

        ViewHolder(GameMutualityGridViewAdapter gameMutualityGridViewAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.gameMutualityGridviewItemImg = (ImageView) butterknife.c.a.c(view, R.id.game_mutuality_gridview_item_img, "field 'gameMutualityGridviewItemImg'", ImageView.class);
            viewHolder.gameMutualityGridviewItemTypeName = (TextView) butterknife.c.a.c(view, R.id.game_mutuality_gridview_item_TypeName, "field 'gameMutualityGridviewItemTypeName'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.gameMutualityGridviewItemImg = null;
                viewHolder.gameMutualityGridviewItemTypeName = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public GameMutualityGridViewAdapter(List<RecommendModuleAndClassifyBean.DataBean.MatrixBean> list, Context context) {
        super(list);
        this.f61c = context;
        this.d = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f61c).inflate(R.layout.game_mutuality_gridview_item_layout, viewGroup, false);
        switch (i) {
            case 0:
                inflate.setBackgroundResource(R.drawable.shape_gradient_1);
                break;
            case 1:
                inflate.setBackgroundResource(R.drawable.shape_gradient_2);
                break;
            case 2:
                inflate.setBackgroundResource(R.drawable.shape_gradient_3);
                break;
            case 3:
                inflate.setBackgroundResource(R.drawable.shape_gradient_4);
                break;
            case 4:
                inflate.setBackgroundResource(R.drawable.shape_gradient_5);
                break;
            case 5:
                inflate.setBackgroundResource(R.drawable.shape_gradient_6);
                break;
            case 6:
                inflate.setBackgroundResource(R.drawable.shape_gradient_7);
                break;
            case 7:
                inflate.setBackgroundResource(R.drawable.shape_gradient_8);
                break;
        }
        ViewHolder viewHolder = new ViewHolder(this, inflate);
        com.rtk.app.tool.t.c(this.f61c, this.d.get(i).getIcon(), viewHolder.gameMutualityGridviewItemImg, new boolean[0]);
        viewHolder.gameMutualityGridviewItemTypeName.setText(this.d.get(i).getTitle());
        return inflate;
    }
}
