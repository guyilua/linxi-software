package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.adapter.TagFlowLayoutForBBsCheckReasonAdapter;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForGameCommentDeleteReason extends o {

    @BindView
    TextView dialogForGameCommentDeleteReasonCancel;

    @BindView
    EditText dialogForGameCommentDeleteReasonEdv;

    @BindView
    TextView dialogForGameCommentDeleteReasonEnsure;

    @BindView
    TagFlowLayout dialogForGameCommentDeleteReasonTagFlowLayout;
    private com.rtk.app.tool.s k;
    private List<String> l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements TagFlowLayout.b {
        a() {
        }

        public boolean a(View view, int i, FlowLayout flowLayout) {
            DialogForGameCommentDeleteReason dialogForGameCommentDeleteReason = DialogForGameCommentDeleteReason.this;
            dialogForGameCommentDeleteReason.dialogForGameCommentDeleteReasonEdv.setText((CharSequence) dialogForGameCommentDeleteReason.l.get(i));
            return true;
        }
    }

    public DialogForGameCommentDeleteReason(Context context, com.rtk.app.tool.s sVar) {
        super(context);
        this.k = sVar;
        i(R.layout.dialog_for_game_comment_delete_reason_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        ArrayList arrayList = new ArrayList();
        this.l = arrayList;
        arrayList.add("色情");
        this.l.add("翻墙");
        this.l.add("赌博");
        this.l.add("木马");
        this.l.add("骂人");
        this.l.add("广告");
        this.l.add("重复发布");
        this.l.add("版权纠纷");
        this.l.add("违规");
        this.dialogForGameCommentDeleteReasonTagFlowLayout.setAdapter(new TagFlowLayoutForBBsCheckReasonAdapter(context, this.l));
        q();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131297214) {
            dismiss();
        } else {
            if (id != 2131297216) {
                return;
            }
            this.k.a(this.dialogForGameCommentDeleteReasonEdv.getText().toString().trim());
            dismiss();
        }
    }

    public void q() {
        this.dialogForGameCommentDeleteReasonTagFlowLayout.setOnTagClickListener(new a());
        this.dialogForGameCommentDeleteReasonCancel.setOnClickListener(this);
        this.dialogForGameCommentDeleteReasonEnsure.setOnClickListener(this);
    }
}
