package com.rtk.app.main.OtherImfomationPack;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.adapter.TagFlowLayoutForBBsCheckReasonAdapter;
import com.rtk.app.custom.GridRadioGroup;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.tool.c0;
import com.sigmob.sdk.downloader.f;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForProhibitUser extends com.rtk.app.main.dialogPack.o {

    @BindView
    GridRadioGroup dialogForProhibitDaysGroup;

    @BindView
    GridRadioGroup dialogForProhibitDaysGroup2;

    @BindView
    TextView dialogForProhibitUserCancel;

    @BindView
    TextView dialogForProhibitUserEnsure;

    @BindView
    EditText dialogForProhibitUserReason;

    @BindView
    TagFlowLayout dialogForProhibitUserReasonTagFlowLayout;
    private Context k;
    public int l;
    private List<Integer> m;
    public a n;
    private List<String> o;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a(int i, String str);
    }

    public DialogForProhibitUser(Context context, a aVar) {
        super(context);
        this.k = context;
        this.n = aVar;
        i(R.layout.dialog_for_prohibit_user_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        p();
        q();
    }

    private void p() {
        this.m = new ArrayList();
        c0.u("DialogForProhibitUser", " 用户权限getAdmin " + MainActivity.p.getData().getAdmin().getAdmin() + "  getUserAdmin" + MainActivity.p.getData().getAdmin().getUserAdmin());
        if (!c.d.a.d.d() || (MainActivity.p.getData().getAdmin().getAdmin() != 1 && MainActivity.p.getData().getAdmin().getUserAdmin() != 1)) {
            this.m.add(1);
            this.m.add(2);
            this.m.add(3);
            this.dialogForProhibitDaysGroup.setVisibility(8);
            this.dialogForProhibitDaysGroup2.setVisibility(0);
        } else {
            this.m.add(1);
            this.m.add(3);
            this.m.add(7);
            this.m.add(15);
            this.m.add(30);
            this.m.add(90);
            this.m.add(180);
            this.m.add(365);
            this.m.add(1095);
            this.dialogForProhibitDaysGroup.setVisibility(0);
            this.dialogForProhibitDaysGroup2.setVisibility(8);
        }
        ArrayList arrayList = new ArrayList();
        this.o = arrayList;
        arrayList.add("发布违规信息");
        this.o.add("发布色情信息");
        this.o.add("违规推广");
        this.o.add("头像违规");
        this.o.add("签名违规");
        this.o.add("冒充他人");
        this.dialogForProhibitUserReasonTagFlowLayout.setAdapter(new TagFlowLayoutForBBsCheckReasonAdapter(this.k, this.o));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean s(View view, int i, FlowLayout flowLayout) {
        this.dialogForProhibitUserReason.setText(this.o.get(i));
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_for_prohibit_user_cancel /* 2131297239 */:
                dismiss();
                return;
            case R.id.dialog_for_prohibit_user_ensure /* 2131297240 */:
                String trim = this.dialogForProhibitUserReason.getText().toString().trim();
                if (c.d.a.d.d() && (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getUserAdmin() == 1)) {
                    for (int i = 0; i < this.dialogForProhibitDaysGroup.getChildCount(); i++) {
                        if (((RadioButton) this.dialogForProhibitDaysGroup.getChildAt(i)).isChecked()) {
                            this.l = this.m.get(i).intValue();
                        }
                    }
                } else {
                    for (int i2 = 0; i2 < this.dialogForProhibitDaysGroup2.getChildCount(); i2++) {
                        if (((RadioButton) this.dialogForProhibitDaysGroup2.getChildAt(i2)).isChecked()) {
                            this.l = this.m.get(i2).intValue();
                        }
                    }
                }
                if (!c0.q(trim) && this.l != 0) {
                    c0.u("DialogForProhibitUser", "封号时长" + this.l + "  封号原因" + trim);
                    this.n.a(this.l, trim);
                    this.l = 0;
                    dismiss();
                    return;
                }
                com.rtk.app.tool.f.a(this.k, "封号原因不可为空", f.a.f);
                return;
            default:
                return;
        }
    }

    public void q() {
        this.dialogForProhibitUserCancel.setOnClickListener(this);
        this.dialogForProhibitUserEnsure.setOnClickListener(this);
        this.dialogForProhibitUserReasonTagFlowLayout.setOnTagClickListener(new TagFlowLayout.b() { // from class: com.rtk.app.main.OtherImfomationPack.a
            public final boolean a(View view, int i, FlowLayout flowLayout) {
                return DialogForProhibitUser.this.s(view, i, flowLayout);
            }
        });
    }
}
