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
import com.rtk.app.R;
import com.rtk.app.bean.UpClickSrcDataBean;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpSrcClickDataAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f123c;
    private List<UpClickSrcDataBean.DataDTO> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    protected static class UpSrcDataHolder {

        @BindView
        TextView upSrcDataItemData;

        @BindView
        TextView upSrcDataItemDownNUM;

        UpSrcDataHolder(View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class UpSrcDataHolder_ViewBinding implements Unbinder {
        private UpSrcDataHolder b;

        @UiThread
        public UpSrcDataHolder_ViewBinding(UpSrcDataHolder upSrcDataHolder, View view) {
            this.b = upSrcDataHolder;
            upSrcDataHolder.upSrcDataItemData = (TextView) butterknife.c.a.c(view, R.id.up_src_data_item_data, "field 'upSrcDataItemData'", TextView.class);
            upSrcDataHolder.upSrcDataItemDownNUM = (TextView) butterknife.c.a.c(view, R.id.up_src_data_item_downNUM, "field 'upSrcDataItemDownNUM'", TextView.class);
        }

        @CallSuper
        public void a() {
            UpSrcDataHolder upSrcDataHolder = this.b;
            if (upSrcDataHolder != null) {
                this.b = null;
                upSrcDataHolder.upSrcDataItemData = null;
                upSrcDataHolder.upSrcDataItemDownNUM = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public UpSrcClickDataAdapter(Context context, List<UpClickSrcDataBean.DataDTO> list) {
        super(list);
        this.f123c = context;
        this.d = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        UpSrcDataHolder upSrcDataHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f123c).inflate(R.layout.up_src_data_item_layout, (ViewGroup) null);
            upSrcDataHolder = new UpSrcDataHolder(view);
            view.setTag(upSrcDataHolder);
        } else {
            upSrcDataHolder = (UpSrcDataHolder) view.getTag();
        }
        upSrcDataHolder.upSrcDataItemData.setText(this.d.get(i).getDay() + "");
        upSrcDataHolder.upSrcDataItemDownNUM.setText(this.d.get(i).getPv() + "");
        if (this.d.get(i).getPv() > 50) {
            upSrcDataHolder.upSrcDataItemDownNUM.setTextColor(this.f123c.getResources().getColor(R.color.theme2));
        } else if (this.d.get(i).getPv() > 100) {
            upSrcDataHolder.upSrcDataItemDownNUM.setTextColor(this.f123c.getResources().getColor(R.color.theme26));
        } else if (this.d.get(i).getPv() == 0) {
            upSrcDataHolder.upSrcDataItemDownNUM.setTextColor(this.f123c.getResources().getColor(R.color.theme3));
        } else {
            upSrcDataHolder.upSrcDataItemDownNUM.setTextColor(this.f123c.getResources().getColor(R.color.drak444));
        }
        return view;
    }
}
