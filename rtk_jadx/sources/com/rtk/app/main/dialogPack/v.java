package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import com.rtk.app.R;
import com.rtk.app.adapter.TagFlowLayoutForBBsCheckReasonAdapter;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DialogForUpCheckReason.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class v extends o {
    private com.rtk.app.tool.s k;
    private TagFlowLayout l;
    private List<String> m;

    public v(Context context, int i, com.rtk.app.tool.s sVar) {
        super(context);
        this.k = sVar;
        i(R.layout.dialog_for_up_check_reason_layout, 17);
        this.m = new ArrayList();
        String[] stringArray = context.getResources().getStringArray(i);
        if (stringArray != null) {
            for (String str : stringArray) {
                this.m.add(str);
            }
        }
        this.l = getWindow().getDecorView().findViewById(R.id.dialog_for_up_check_reason_listView);
        this.l.setAdapter(new TagFlowLayoutForBBsCheckReasonAdapter(context, this.m));
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean r(View view, int i, FlowLayout flowLayout) {
        if (i != this.m.size() - 1) {
            this.k.a(this.m.get(i));
        } else {
            this.k.a("");
        }
        dismiss();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void p() {
        this.l.setOnTagClickListener(new TagFlowLayout.b() { // from class: com.rtk.app.main.dialogPack.g
            public final boolean a(View view, int i, FlowLayout flowLayout) {
                return v.this.r(view, i, flowLayout);
            }
        });
    }
}
