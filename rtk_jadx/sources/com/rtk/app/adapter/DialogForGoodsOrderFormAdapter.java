package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.bean.GoodsDetailsBean;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForGoodsOrderFormAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f41c;
    private List<GoodsDetailsBean.DataBean.ContactBean> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ViewHolder {

        @BindView
        EditText dialogForGoodsOrderFormEditItemContent;

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
            viewHolder.dialogForGoodsOrderFormEditItemContent = (EditText) butterknife.c.a.c(view, R.id.dialog_for_goods_order_form_edit_item_content, "field 'dialogForGoodsOrderFormEditItemContent'", EditText.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.dialogForGoodsOrderFormEditItemContent = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public DialogForGoodsOrderFormAdapter(Context context, List<GoodsDetailsBean.DataBean.ContactBean> list) {
        super(list);
        this.d = list;
        this.f41c = context;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f41c).inflate(R.layout.dialog_for_goods_order_form_edit_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.dialogForGoodsOrderFormEditItemContent.setHint(this.d.get(i).getDisplay());
        String type = this.d.get(i).getType();
        char c2 = 65535;
        int hashCode = type.hashCode();
        if (hashCode != -891985903) {
            if (hashCode == 104431 && type.equals("int")) {
                c2 = 0;
            }
        } else if (type.equals("string")) {
            c2 = 1;
        }
        if (c2 != 0) {
            viewHolder.dialogForGoodsOrderFormEditItemContent.setInputType(1);
        } else {
            viewHolder.dialogForGoodsOrderFormEditItemContent.setInputType(2);
        }
        viewHolder.dialogForGoodsOrderFormEditItemContent.setLines(2);
        return view;
    }
}
