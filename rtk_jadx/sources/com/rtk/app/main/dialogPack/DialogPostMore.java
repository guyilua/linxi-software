package com.rtk.app.main.dialogPack;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.bean.FamilyBean;
import com.rtk.app.bean.PostDetailsBean;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogPostMore extends Dialog implements View.OnClickListener {
    private Window a;
    private ViewHolder b;

    /* renamed from: c, reason: collision with root package name */
    private Context f246c;
    private int d;
    private PostDetailsBean.DataBean e;
    private com.rtk.app.tool.s f;
    private List<String> g;
    private int h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder {

        @BindView
        ListView dialogPostMoreListView;

        ViewHolder(DialogPostMore dialogPostMore, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.dialogPostMoreListView = (ListView) butterknife.c.a.c(view, R.id.dialog_post_more_listView, "field 'dialogPostMoreListView'", ListView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.dialogPostMoreListView = null;
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
            if (i == DialogPostMore.this.g.size() - 1) {
                DialogPostMore.this.dismiss();
            } else {
                DialogPostMore.this.f.a((String) DialogPostMore.this.g.get(i));
            }
        }
    }

    public DialogPostMore(@NonNull Context context, PostDetailsBean.DataBean dataBean, com.rtk.app.tool.s sVar, FamilyBean familyBean) {
        super(context);
        this.h = 0;
        this.f246c = context;
        this.f = sVar;
        this.e = dataBean;
        this.d = dataBean.getAlloweDel();
        if (familyBean != null) {
            this.h = familyBean.getFamily_id();
        }
        d();
        c();
    }

    private void c() {
        this.b.dialogPostMoreListView.setOnItemClickListener(new a());
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0092, code lost:
    
        if (com.rtk.app.main.MainActivityPack.MainActivity.p.getData().getAdmin().getAdmin() != 1) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00f4, code lost:
    
        if (com.rtk.app.main.MainActivityPack.MainActivity.p.getData().getAdmin().getAdmin() != 1) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void d() {
        /*
            Method dump skipped, instructions count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.main.dialogPack.DialogPostMore.d():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(String[] strArr) {
        if (strArr.length != 0 && !com.rtk.app.tool.c0.q(strArr[0])) {
            this.f.a(strArr[0]);
            dismiss();
        } else {
            com.rtk.app.tool.c0.u("DialogPostMore", "callback str is null");
        }
    }

    public void g(float f, float f2) {
        Window window = getWindow();
        this.a = window;
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = (int) f;
        attributes.y = (int) f2;
        attributes.gravity = 80;
        attributes.width = -1;
        attributes.height = -2;
        this.a.setAttributes(attributes);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
