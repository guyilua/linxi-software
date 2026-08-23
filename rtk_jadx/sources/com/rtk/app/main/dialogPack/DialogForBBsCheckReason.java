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
public class DialogForBBsCheckReason extends o {

    @BindView
    TagFlowLayout dialogForBbsCheckReasonTagFlowLayout;
    private com.rtk.app.tool.s k;
    private List<String> l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements TagFlowLayout.b {
        a() {
        }

        public boolean a(View view, int i, FlowLayout flowLayout) {
            if (i != DialogForBBsCheckReason.this.l.size() - 1) {
                DialogForBBsCheckReason.this.k.a((String) DialogForBBsCheckReason.this.l.get(i));
            } else {
                DialogForBBsCheckReason.this.k.a("");
            }
            DialogForBBsCheckReason.this.dismiss();
            return true;
        }
    }

    public DialogForBBsCheckReason(Context context, com.rtk.app.tool.s sVar) {
        super(context);
        this.k = sVar;
        i(R.layout.dialog_for_bbs_check_reason_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        ArrayList arrayList = new ArrayList();
        this.l = arrayList;
        arrayList.add("色情");
        this.l.add("色情擦边球");
        this.l.add("涉政");
        this.l.add("翻墙");
        this.l.add("赌博");
        this.l.add("木马");
        this.l.add("骂人");
        this.l.add("广告");
        this.l.add("重复发布");
        this.l.add("版权问题");
        this.l.add("不收录类型");
        this.l.add("手动输入");
        this.dialogForBbsCheckReasonTagFlowLayout.setAdapter(new TagFlowLayoutForBBsCheckReasonAdapter(context, this.l));
        r();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void r() {
        this.dialogForBbsCheckReasonTagFlowLayout.setOnTagClickListener(new a());
    }
}
