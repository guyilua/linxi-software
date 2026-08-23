package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.adapter.x2;
import com.rtk.app.main.MainActivityPack.MainActivity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForEditOtherPersonal extends o {

    @BindView
    TextView dialogForEditOtherPersonalCancel;

    @BindView
    ListView dialogForEditOtherPersonalListView;
    private Context k;
    private c l;
    private List<String> m;
    private b n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a extends com.rtk.app.custom.AutoListView.b {
        a(DialogForEditOtherPersonal dialogForEditOtherPersonal) {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements com.rtk.app.tool.s {
        private b() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            if (!com.rtk.app.tool.c0.q(strArr[0])) {
                DialogForEditOtherPersonal.this.l.k(strArr[0]);
                DialogForEditOtherPersonal.this.dismiss();
            } else {
                com.rtk.app.tool.c0.u("DialogForEditOtherPersonal", "callback str is null");
            }
        }

        /* synthetic */ b(DialogForEditOtherPersonal dialogForEditOtherPersonal, a aVar) {
            this();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface c {
        void k(String str);
    }

    public DialogForEditOtherPersonal(Context context, c cVar) {
        super(context);
        this.n = new b(this, null);
        this.k = context;
        this.l = cVar;
        i(R.layout.dialog_for_edit_other_personal, 80);
        ButterKnife.b(this, getWindow().getDecorView());
        r();
        q();
    }

    private void r() {
        ArrayList arrayList = new ArrayList();
        this.m = arrayList;
        arrayList.add("重置头像");
        this.m.add("编辑用户相册");
        this.m.add("编辑用户资料");
        if (c.d.a.d.d() && (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getUserAdmin() == 1)) {
            this.m.add("删除他所有的帖子");
            this.m.add("删除他的回帖");
            this.m.add("删除他所有的游戏评论");
            this.m.add("删除他所有的Up资源评论");
        }
        if (c.d.a.d.d() && (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getAdmin() == 2 || MainActivity.p.getData().getAdmin().getUserAdmin() == 1 || MainActivity.p.getData().getAdmin().getUserAdmin() == 2)) {
            this.m.add("封号/解封");
        }
        this.dialogForEditOtherPersonalListView.setAdapter((ListAdapter) new x2(this.k, this.m, this.n));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131297197) {
            return;
        }
        dismiss();
    }

    public void q() {
        this.dialogForEditOtherPersonalCancel.setOnClickListener(this);
        this.dialogForEditOtherPersonalListView.setOnItemClickListener(new a(this));
    }
}
