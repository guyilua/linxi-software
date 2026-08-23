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
import com.rtk.app.bean.DownLoadBean;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DownLoadDialogListAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f44c;
    private List<DownLoadBean.DataBean> d;
    private com.rtk.app.tool.s e;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        TextView downloadListItemTv;

        ViewHolder(DownLoadDialogListAdapter downLoadDialogListAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.downloadListItemTv = (TextView) butterknife.c.a.c(view, R.id.download_list_item_tv, "field 'downloadListItemTv'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.downloadListItemTv = null;
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
            if (this.a != 1) {
                return;
            }
            DownLoadDialogListAdapter.this.e.a(((DownLoadBean.DataBean) DownLoadDialogListAdapter.this.d.get(this.b)).getUrl() + "");
        }
    }

    public DownLoadDialogListAdapter(Context context, List<DownLoadBean.DataBean> list, com.rtk.app.tool.s sVar) {
        super(list);
        this.d = list;
        this.f44c = context;
        this.e = sVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f44c).inflate(R.layout.download_list_item_layout, (ViewGroup) null);
        ViewHolder viewHolder = new ViewHolder(this, inflate);
        viewHolder.downloadListItemTv.setText(this.d.get(i).getName());
        viewHolder.downloadListItemTv.setOnClickListener(new a(1, i));
        return inflate;
    }
}
