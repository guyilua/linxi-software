package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.main.Home5Activity.SetThemeActivity;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SetThemeAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f108c;
    private List<Integer> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ViewHolder {

        @BindView
        RoundedImageView setThemeGridViewItemImg;

        @BindView
        TextView setThemeGridViewItemMode;

        @BindView
        TextView setThemeGridViewItemSelect;

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
            viewHolder.setThemeGridViewItemImg = (RoundedImageView) butterknife.c.a.c(view, R.id.set_theme_gridView_item_img, "field 'setThemeGridViewItemImg'", RoundedImageView.class);
            viewHolder.setThemeGridViewItemSelect = (TextView) butterknife.c.a.c(view, R.id.set_theme_gridView_item_select, "field 'setThemeGridViewItemSelect'", TextView.class);
            viewHolder.setThemeGridViewItemMode = (TextView) butterknife.c.a.c(view, R.id.set_theme_gridView_item_mode, "field 'setThemeGridViewItemMode'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.setThemeGridViewItemImg = null;
                viewHolder.setThemeGridViewItemSelect = null;
                viewHolder.setThemeGridViewItemMode = null;
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
            if (intValue == 0) {
                intValue = 27;
                com.rtk.app.tool.y.S(false, null);
            } else {
                com.rtk.app.tool.y.S(true, null);
            }
            com.rtk.app.tool.v.f(SetThemeAdapter.this.f108c, "THEME", intValue % 28);
            ((SetThemeActivity) SetThemeAdapter.this.f108c).A();
            SetThemeAdapter.this.notifyDataSetChanged();
        }
    }

    public SetThemeAdapter(Context context, List<Integer> list) {
        super(list);
        this.f108c = context;
        this.d = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f108c).inflate(R.layout.set_theme_gridview_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.setThemeGridViewItemImg.setImageResource(this.d.get(i).intValue());
        int b = com.rtk.app.tool.v.b(this.f108c, "THEME") % 28;
        if (b == i) {
            viewHolder.setThemeGridViewItemSelect.setVisibility(0);
        } else {
            viewHolder.setThemeGridViewItemSelect.setVisibility(8);
        }
        if (i == 0) {
            viewHolder.setThemeGridViewItemMode.setVisibility(0);
        } else {
            viewHolder.setThemeGridViewItemMode.setVisibility(8);
        }
        if (b == 27 && i == 0) {
            viewHolder.setThemeGridViewItemSelect.setVisibility(0);
        }
        viewHolder.setThemeGridViewItemImg.setTag(Integer.valueOf(i));
        viewHolder.setThemeGridViewItemImg.setOnClickListener(new a());
        int M = (com.rtk.app.tool.y.M(this.f108c) / 3) - 20;
        ViewGroup.LayoutParams layoutParams = viewHolder.setThemeGridViewItemImg.getLayoutParams();
        layoutParams.width = M;
        layoutParams.height = M;
        viewHolder.setThemeGridViewItemImg.setLayoutParams(layoutParams);
        return view;
    }
}
