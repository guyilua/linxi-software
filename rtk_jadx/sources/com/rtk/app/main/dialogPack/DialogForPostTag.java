package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.adapter.v2;
import com.rtk.app.bean.TagsBean;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForPostTag extends o {
    private final ViewHolder k;
    private com.rtk.app.tool.s l;
    private List<TagsBean> m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ViewHolder {

        @BindView
        ListView dialogForPostMoreListView;

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
            viewHolder.dialogForPostMoreListView = (ListView) butterknife.c.a.c(view, R.id.dialog_for_post_tag_listView, "field 'dialogForPostMoreListView'", ListView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.dialogForPostMoreListView = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            DialogForPostTag.this.l.a(((TagsBean) DialogForPostTag.this.m.get(i)).getId() + "", ((TagsBean) DialogForPostTag.this.m.get(i)).getName());
        }
    }

    public DialogForPostTag(Context context, com.rtk.app.tool.s sVar, List<TagsBean> list) {
        super(context);
        this.l = sVar;
        this.m = list;
        i(R.layout.dialog_for_post_tag_layout, 17);
        ViewHolder viewHolder = new ViewHolder(getWindow().getDecorView());
        this.k = viewHolder;
        viewHolder.dialogForPostMoreListView.setAdapter((ListAdapter) new v2(context, list));
        r();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void r() {
        this.k.dialogForPostMoreListView.setOnItemClickListener(new a());
    }
}
