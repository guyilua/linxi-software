package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.adapter.TagFlowLayoutForBBsCheckReasonAdapter;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForAuditCheckReason extends o {

    @BindView
    TagFlowLayout dialogForBbsCheckReasonTagFlowLayout;
    private com.rtk.app.tool.s k;
    private List<String> l;

    public DialogForAuditCheckReason(Context context, int i, com.rtk.app.tool.s sVar) {
        super(context);
        this.k = sVar;
        i(R.layout.dialog_for_bbs_check_reason_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        String[] stringArray = context.getResources().getStringArray(i);
        this.l = new ArrayList();
        if (stringArray != null) {
            for (String str : stringArray) {
                this.l.add(str);
            }
        }
        this.dialogForBbsCheckReasonTagFlowLayout.setAdapter(new TagFlowLayoutForBBsCheckReasonAdapter(context, this.l));
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean r(View view, int i, FlowLayout flowLayout) {
        com.rtk.app.tool.c0.u("DialogForAuditCheckReason", "评论审核" + this.l.get(i));
        this.k.a(this.l.get(i));
        dismiss();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void p() {
        this.dialogForBbsCheckReasonTagFlowLayout.setOnTagClickListener(new TagFlowLayout.b() { // from class: com.rtk.app.main.dialogPack.c
            public final boolean a(View view, int i, FlowLayout flowLayout) {
                return DialogForAuditCheckReason.this.r(view, i, flowLayout);
            }
        });
    }
}
