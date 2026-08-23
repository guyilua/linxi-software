package com.rtk.app.main.family;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qq.e.comm.constants.ErrorCode;
import com.rtk.app.R;
import com.rtk.app.adapter.MyFragmentAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.AdminBean;
import com.rtk.app.bean.FamilyInfoBean;
import com.rtk.app.bean.InformNumListBean;
import com.rtk.app.bean.LeaderBean;
import com.rtk.app.bean.LoginBean;
import com.rtk.app.bean.MainUseProtocolUpdateNoticeBean;
import com.rtk.app.custom.BaseViewPager;
import com.rtk.app.custom.RichEditText.PostModificationBean;
import com.rtk.app.custom.b;
import com.rtk.app.main.Home5Activity.MyMessageListActivity;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.dialogPack.DialogForCheckPsw;
import com.rtk.app.main.dialogPack.FamilyDialogNotice;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyFamilyActivity extends FamilyBaseActivity implements h.j {
    private String A;

    @BindView
    AppBarLayout appBar;

    @BindView
    View backLayout;

    @BindView
    ImageView familyCover;

    @BindView
    View familyDynamicsLayout;

    @BindView
    View familyGradientView;

    @BindView
    LinearLayout familyIntroduceLayout;

    @BindView
    TextView familyIntroduceOpen;

    @BindView
    RoundedImageView familyLogo;

    @BindView
    TextView familyMemberNu;

    @BindView
    View familyMore;

    @BindView
    TextView familyName;

    @BindView
    TextView familyNotice;

    @BindView
    TextView familySn;

    @BindView
    GridView gridView;

    @BindView
    TabLayout homePageItemAttentionTab;

    @BindView
    BaseViewPager homePageItemAttentionViewPager;

    @BindView
    View manager;

    @BindView
    TextView managerMessageNum;

    @BindView
    View messageLayout;

    @BindView
    TextView messageNum;

    @BindView
    ViewGroup parent;

    @BindView
    ImageView publish;
    InformNumListBean r;
    private String s;
    private FamilyInfoBean.DataBean t;

    @BindView
    TextView title;
    private String u;
    private List<String> v = new ArrayList();
    private List<BaseFragment> w = new ArrayList();
    private FamilyUpFragment x;
    private MyFamilyPostFragment y;
    private MyFragmentAdapter z;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.b {
        a() {
        }

        @Override // com.rtk.app.custom.b
        public void a(AppBarLayout appBarLayout, b.a aVar) {
            if (aVar == b.a.EXPANDED) {
                try {
                    MyFamilyActivity.this.title.setText(R.string.my_family);
                } catch (NullPointerException | Exception unused) {
                }
            } else if (aVar == b.a.COLLAPSED) {
                MyFamilyActivity myFamilyActivity = MyFamilyActivity.this;
                myFamilyActivity.title.setText(myFamilyActivity.t.getFamily_name());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements DialogForCheckPsw.a {
        final /* synthetic */ AlertDialog a;

        b(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        @Override // com.rtk.app.main.dialogPack.DialogForCheckPsw.a
        public void a() {
        }

        @Override // com.rtk.app.main.dialogPack.DialogForCheckPsw.a
        public void b() {
            MyFamilyActivity.this.Q(3);
            this.a.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class c implements Runnable {
        final /* synthetic */ TextView a;
        final /* synthetic */ TextView b;

        c(MyFamilyActivity myFamilyActivity, TextView textView, TextView textView2) {
            this.a = textView;
            this.b = textView2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Layout layout = this.a.getLayout();
            if (layout != null) {
                if (layout.getEllipsisCount(this.a.getLineCount() - 1) > 0) {
                    this.a.setMaxLines(4);
                    this.b.setVisibility(0);
                    this.b.setText("展开全文↓");
                    this.b.setSelected(true);
                    return;
                }
                this.a.setMaxLines(100);
                this.b.setSelected(false);
                this.b.setText("");
                this.b.setVisibility(8);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void O() {
        LoginBean loginBean = MainActivity.p;
        if (loginBean == null || loginBean.getData() == null || this.t.getFamily_admin() == null) {
            return;
        }
        if (MainActivity.p.getData().getAdmin() == null) {
            MainActivity.p.getData().setAdmin(new AdminBean());
        }
        if (this.t.getFamily_admin().getLeader().getId() == com.rtk.app.tool.y.I(this)) {
            MainActivity.p.getData().getAdmin().setFamilyLead(this.s);
            com.rtk.app.tool.v.h(this, "userInformation", this.g.toJson(MainActivity.p));
            return;
        }
        if (this.t.getFamily_admin().getSecond_leader() != null) {
            Iterator<LeaderBean> it = this.t.getFamily_admin().getSecond_leader().iterator();
            while (it.hasNext()) {
                if (it.next().getId() == com.rtk.app.tool.y.I(this)) {
                    MainActivity.p.getData().getAdmin().setFamilySecondLead(this.s);
                    com.rtk.app.tool.v.h(this, "userInformation", this.g.toJson(MainActivity.p));
                    return;
                }
            }
        }
        if (this.t.getFamily_admin().getBbs_admin() != null) {
            Iterator<LeaderBean> it2 = this.t.getFamily_admin().getBbs_admin().iterator();
            while (it2.hasNext()) {
                if (it2.next().getId() == com.rtk.app.tool.y.I(this)) {
                    MainActivity.p.getData().getAdmin().setFamilyBBSAmin(this.s);
                }
            }
        }
        if (this.t.getFamily_admin().getUp_admin() != null) {
            Iterator<LeaderBean> it3 = this.t.getFamily_admin().getUp_admin().iterator();
            while (it3.hasNext()) {
                if (it3.next().getId() == com.rtk.app.tool.y.I(this)) {
                    MainActivity.p.getData().getAdmin().setFamilyUPAmin(this.s);
                }
            }
        }
        com.rtk.app.tool.v.h(this, "userInformation", this.g.toJson(MainActivity.p));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private AlertDialog.Builder P(LinearLayout linearLayout) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("转让家族");
        builder.setMessage("家族只可转让给副族长，请选择您要转让给的用户。");
        builder.setView(linearLayout);
        builder.setPositiveButton("确定", (DialogInterface.OnClickListener) null);
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.rtk.app.main.family.q0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MyFamilyActivity.U(dialogInterface, i);
            }
        });
        return builder;
    }

    private ArrayList<i1> R() {
        ArrayList<i1> arrayList = new ArrayList<>();
        arrayList.add(new i1(R.mipmap.family_intro, "公告介绍"));
        arrayList.add(new i1(R.mipmap.family_bbs, "家族论坛"));
        arrayList.add(new i1(R.mipmap.family_up, "家族UP"));
        arrayList.add(new i1(R.mipmap.family_member, "家族成员"));
        arrayList.add(new i1(R.mipmap.family_manager, "家族管理"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T(String[] strArr) {
        Q(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void U(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W(AdapterView adapterView, View view, int i, long j) {
        if (!com.rtk.app.tool.y.x(this)) {
            com.rtk.app.tool.t.w0(this);
            return;
        }
        if (i == 0) {
            Intent intent = new Intent((Context) this, (Class<?>) FamilyNoticeAndIntroduceActivity.class);
            intent.putExtra("family_Info", this.t);
            startActivity(intent);
            return;
        }
        if (i == 1) {
            com.rtk.app.tool.t.I0(this, this.t.getFamily_name(), this.t.getFamily_logo(), this.t.getModule().getId() + "", this.t.getFamily_id());
            return;
        }
        if (i == 2) {
            Bundle bundle = new Bundle();
            bundle.putString("family_id", this.t.getFamily_id());
            com.rtk.app.tool.c.b(this, FamilyUpActivity.class, bundle);
        } else if (i == 3) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("family_id", this.t.getFamily_id());
            com.rtk.app.tool.c.b(this, FamilyMemberActivity.class, bundle2);
        } else {
            if (i != 4) {
                return;
            }
            Bundle bundle3 = new Bundle();
            bundle3.putString("family_id", this.t.getFamily_id());
            com.rtk.app.tool.c.b(this, FamilyAdministratorsActivity.class, bundle3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void X(TextView textView, TextView textView2) {
        if (textView.getText().equals("展开全文↓")) {
            textView.setVisibility(0);
            textView2.setMaxLines(100);
            textView.setText("收起全文↑");
        } else if (textView.getText().equals("收起全文↑")) {
            textView.setVisibility(0);
            textView2.setMaxLines(4);
            textView.setText("展开全文↓");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void Y(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a0(DialogInterface dialogInterface, int i) {
        Q(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean d0(boolean z, PopupMenu popupMenu, MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != 2131299971) {
            if (itemId == 2131300193) {
                com.rtk.app.tool.t.I1(this, "http://a.ruansky.com/family/" + this.s + "/");
            }
        } else if (z) {
            v0();
        } else {
            o0();
        }
        popupMenu.dismiss();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean f0(PopupMenu popupMenu, MenuItem menuItem) {
        FamilyInfoBean.DataBean.ModuleBean module;
        switch (menuItem.getItemId()) {
            case R.id.publish_something_post /* 2131299961 */:
                FamilyInfoBean.DataBean dataBean = this.t;
                if (dataBean != null && dataBean.getModule() != null && (module = this.t.getModule()) != null) {
                    com.rtk.app.tool.t.v1(this, new PostModificationBean(module.getSublist(), this.t.getModule().getId() + "", this.s));
                    break;
                }
                break;
            case R.id.publish_something_up /* 2131299962 */:
                com.rtk.app.tool.t.d1(this, this.s);
                break;
        }
        popupMenu.dismiss();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h0(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent((Context) this, (Class<?>) FamilyUserPermissionSelectActivity.class);
        intent.putExtra(com.umeng.analytics.pro.d.y, 1);
        intent.putExtra("family_id", this.s);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void i0(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k0(CheckBox checkBox, List list, CheckBox[] checkBoxArr, CompoundButton compoundButton, boolean z) {
        if (z) {
            this.u = ((LeaderBean) list.get(((Integer) checkBox.getTag()).intValue())).getId() + "";
            for (CheckBox checkBox2 : checkBoxArr) {
                if (checkBox2 != compoundButton) {
                    checkBox2.setChecked(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m0(CheckBox[] checkBoxArr, AlertDialog alertDialog, View view) {
        int i = 0;
        while (true) {
            if (i >= checkBoxArr.length) {
                i = -1;
                break;
            } else if (checkBoxArr[i].isChecked()) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            com.rtk.app.tool.f.a(this, "您需要选中一个副族长进行转让。", ErrorCode.NETWORK_UNKNOWN);
        } else {
            new DialogForCheckPsw(this, new b(alertDialog)).show();
        }
    }

    private void n0() {
        Q(4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void o0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("退出家族");
        builder.setMessage("您确认要退出" + this.t.getFamily_name() + "家族吗?");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.rtk.app.main.family.a1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MyFamilyActivity.this.a0(dialogInterface, i);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.rtk.app.main.family.x0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MyFamilyActivity.Y(dialogInterface, i);
            }
        });
        builder.create().show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void r0(View view) {
        final PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.my_family_menu, popupMenu.getMenu());
        final boolean isHeadLeader = this.t.isHeadLeader(com.rtk.app.tool.y.K());
        if (isHeadLeader) {
            popupMenu.getMenu().getItem(1).setVisible(false);
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.rtk.app.main.family.r0
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return MyFamilyActivity.this.d0(isHeadLeader, popupMenu, menuItem);
            }
        });
        popupMenu.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void s0() {
        String d = com.rtk.app.tool.v.d(this, "family_introduce_content");
        String family_notice = this.t.getFamily_notice();
        if (TextUtils.isEmpty(family_notice)) {
            this.familyIntroduceLayout.setVisibility(8);
            return;
        }
        com.rtk.app.tool.v.h(this, "family_introduce_content", family_notice);
        this.familyNotice.setText(family_notice);
        if (TextUtils.isEmpty(d)) {
            this.familyIntroduceLayout.setVisibility(0);
            com.rtk.app.tool.v.e(this, "family_introduce_switch", Boolean.FALSE);
        } else if (!TextUtils.equals(d, family_notice)) {
            this.familyIntroduceLayout.setVisibility(0);
            com.rtk.app.tool.v.e(this, "family_introduce_switch", Boolean.FALSE);
        } else {
            this.familyIntroduceLayout.setVisibility(com.rtk.app.tool.v.a(this, "family_introduce_switch") ? 8 : 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void t0(View view) {
        final PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.publish_something_item_menu, popupMenu.getMenu());
        popupMenu.getMenu().getItem(1).setVisible(false);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.rtk.app.main.family.p0
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return MyFamilyActivity.this.f0(popupMenu, menuItem);
            }
        });
        popupMenu.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void u0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("转让家族");
        builder.setMessage("家族只可转让给副族长，您的家族暂没副族长，请先设置副族长！需要设置吗？");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.rtk.app.main.family.v0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MyFamilyActivity.this.h0(dialogInterface, i);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.rtk.app.main.family.u0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MyFamilyActivity.i0(dialogInterface, i);
            }
        });
        builder.create().show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void v0() {
        FamilyInfoBean.DataBean.FamilyAdminBean family_admin = this.t.getFamily_admin();
        if (family_admin == null) {
            return;
        }
        final List<LeaderBean> second_leader = family_admin.getSecond_leader();
        if (second_leader != null && !second_leader.isEmpty()) {
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(1);
            int i = -1;
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            int size = second_leader.size();
            final CheckBox[] checkBoxArr = new CheckBox[size];
            int i2 = 0;
            while (i2 < size) {
                final CheckBox checkBox = new CheckBox(this);
                checkBoxArr[i2] = checkBox;
                checkBox.setTag(Integer.valueOf(i2));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 16;
                checkBox.setLayoutParams(layoutParams);
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rtk.app.main.family.t0
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        MyFamilyActivity.this.k0(checkBox, second_leader, checkBoxArr, compoundButton, z);
                    }
                });
                LinearLayout linearLayout2 = new LinearLayout(this);
                linearLayout2.setOrientation(0);
                ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, -2);
                linearLayout2.setPadding(com.rtk.app.tool.h.a(25.0f, this), 0, 0, 0);
                linearLayout2.setLayoutParams(layoutParams2);
                linearLayout2.addView(checkBox);
                LinearLayout linearLayout3 = new LinearLayout(this);
                linearLayout3.setOrientation(1);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                linearLayout2.setPadding(com.rtk.app.tool.h.a(10.0f, this), 0, 0, com.rtk.app.tool.h.a(3.0f, this));
                layoutParams3.gravity = 16;
                linearLayout3.setLayoutParams(layoutParams3);
                RoundedImageView b2 = com.rtk.app.tool.d0.a.b(this, second_leader.get(i2).getFace());
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams4.gravity = 1;
                b2.setLayoutParams(layoutParams4);
                linearLayout3.addView(b2);
                TextView textView = new TextView(this);
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams5.topMargin = com.rtk.app.tool.h.a(3.0f, this);
                textView.setText(second_leader.get(i2).getNickname());
                layoutParams5.gravity = 1;
                textView.setLayoutParams(layoutParams5);
                textView.setGravity(1);
                linearLayout3.addView(textView);
                linearLayout2.addView(linearLayout3);
                linearLayout.addView(linearLayout2);
                i2++;
                i = -1;
            }
            final AlertDialog create = P(linearLayout).create();
            create.show();
            create.getButton(-1).setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.main.family.b1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MyFamilyActivity.this.m0(checkBoxArr, create, view);
                }
            });
            return;
        }
        u0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void w0() {
        if (this.t == null) {
            return;
        }
        this.familyMore.setVisibility(0);
        this.messageLayout.setVisibility(0);
        InformNumListBean messageNum = this.t.getMessageNum();
        this.r = messageNum;
        if (messageNum != null && messageNum.getAllUnreadNum() > 0) {
            this.messageNum.setVisibility(0);
            this.messageNum.setText(this.r.getAllUnreadNum() + "");
        } else {
            this.messageNum.setVisibility(8);
        }
        String K = com.rtk.app.tool.y.K();
        this.manager.setVisibility(this.t.isAdmin(K) ? 0 : 8);
        if (this.t.isLeader(K)) {
            n0();
        }
        this.familyNotice.setText(this.t.getFamily_notice());
        this.A = this.t.getFamily_sn();
        this.familySn.setText("家族号：" + this.A);
        this.familyMemberNu.setText(this.t.getMember_num() + "人");
        this.familyName.setText(this.t.getFamily_name());
        com.rtk.app.tool.t.c(this, this.t.getFamily_cover(), this.familyCover, new boolean[0]);
        com.rtk.app.tool.t.c(this, this.t.getFamily_logo(), this.familyLogo, new boolean[0]);
        s0();
        if (this.familyIntroduceLayout.getVisibility() == 0) {
            q0(this.familyIntroduceLayout, this.familyNotice, this.t.getFamily_notice(), this.familyIntroduceOpen);
        }
        O();
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity
    protected void A() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void Q(int... iArr) {
        HashMap<String, String> l = com.rtk.app.tool.y.l();
        l.put("family_id", this.s);
        int i = iArr[0];
        if (i == 1) {
            l.put("key", com.rtk.app.tool.t.L(l));
            com.rtk.app.tool.o.h.l(this, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(com.rtk.app.tool.y.w("family/home-page", l)));
            return;
        }
        if (i == 2) {
            l.put("key", com.rtk.app.tool.t.L(l));
            com.rtk.app.tool.o.h.j(this, this, com.rtk.app.tool.y.e + "family/join/exit", 2, l);
            return;
        }
        if (i == 3) {
            l.put("leader_uid", this.u);
            l.put("key", com.rtk.app.tool.t.L(l));
            com.rtk.app.tool.o.h.j(this, this, com.rtk.app.tool.y.e + "family/transfer", 3, l);
            return;
        }
        if (i == 4) {
            l.put("family_id", this.t.getFamily_id());
            l.put("key", com.rtk.app.tool.t.L(l));
            com.rtk.app.tool.o.h.j(this, this, com.rtk.app.tool.y.e + "family/join/total-pending", 4, l);
            return;
        }
        if (i != 5) {
            return;
        }
        l.put("key", com.rtk.app.tool.t.L(l));
        com.rtk.app.tool.o.h.j(this, this, com.rtk.app.tool.y.e + "family/announcement", 5, l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        MainUseProtocolUpdateNoticeBean mainUseProtocolUpdateNoticeBean;
        F();
        com.rtk.app.tool.c0.r("MyFamilyActivity", "success,str:" + com.rtk.app.c.a.b(str));
        if (i == 1) {
            this.t = ((FamilyInfoBean) w(str, FamilyInfoBean.class)).getData();
            w0();
            this.y.x(this.t.getModule().getId() + "");
            this.y.w();
            return;
        }
        if (i == 2) {
            com.rtk.app.tool.f.a(this, "退出家族成功", ErrorCode.NETWORK_UNKNOWN);
            finish();
            return;
        }
        if (i == 3) {
            com.rtk.app.tool.f.a(this, "转让家族成功", ErrorCode.NETWORK_UNKNOWN);
            Q(1);
            return;
        }
        if (i != 4) {
            if (i == 5 && (mainUseProtocolUpdateNoticeBean = (MainUseProtocolUpdateNoticeBean) w(str, MainUseProtocolUpdateNoticeBean.class)) != null) {
                new FamilyDialogNotice(this, this.s, mainUseProtocolUpdateNoticeBean.getData().getAnnouncement()).show();
                return;
            }
            return;
        }
        try {
            String optString = new JSONObject(str).getJSONObject("data").optString("total");
            if (!TextUtils.isEmpty(optString) && !TextUtils.equals("0", optString)) {
                this.managerMessageNum.setVisibility(0);
                this.managerMessageNum.setText(optString);
            } else {
                this.managerMessageNum.setVisibility(8);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.r("MyFamilyActivity", "code:" + i + ",mark:" + i2 + "str:" + str);
        if (i2 != 1) {
            com.rtk.app.tool.f.a(this, str, ErrorCode.NETWORK_UNKNOWN);
        } else {
            this.familyCover.setVisibility(0);
            I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.family.w0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    MyFamilyActivity.this.T(strArr);
                }
            });
        }
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initData() {
        com.rtk.app.tool.c0.u("MyFamilyActivity", "运行到了");
        this.v = new ArrayList();
        this.w = new ArrayList();
        this.v.add("社区动态");
        this.v.add("UP动态");
        this.x = new FamilyUpFragment(this.s);
        MyFamilyPostFragment myFamilyPostFragment = new MyFamilyPostFragment(this.s);
        this.y = myFamilyPostFragment;
        this.w.add(myFamilyPostFragment);
        this.w.add(this.x);
        try {
            MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this.w, this.v);
            this.z = myFragmentAdapter;
            this.homePageItemAttentionViewPager.setAdapter(myFragmentAdapter);
            this.homePageItemAttentionTab.setupWithViewPager(this.homePageItemAttentionViewPager, true);
        } catch (Exception e) {
            com.rtk.app.tool.c0.u("MyFamilyActivity", "  设置关注界面异常   " + e.toString());
        }
        this.appBar.addOnOffsetChangedListener(new a());
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initListener() {
        this.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.rtk.app.main.family.y0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                MyFamilyActivity.this.W(adapterView, view, i, j);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initView() {
        this.gridView.setAdapter((ListAdapter) new l1(this, R()));
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#33000000"), Color.parseColor("#4D000000")});
        gradientDrawable.setShape(0);
        this.familyGradientView.setBackground(gradientDrawable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.t == null) {
            return;
        }
        switch (view.getId()) {
            case R.id.backTV /* 2131296692 */:
                finish();
                return;
            case R.id.family_introduce_delete /* 2131297536 */:
                com.rtk.app.tool.v.e(this, "family_introduce_switch", Boolean.TRUE);
                this.familyIntroduceLayout.setVisibility(8);
                return;
            case R.id.family_introduce_layout /* 2131297537 */:
                Intent intent = new Intent((Context) this, (Class<?>) FamilyNoticeAndIntroduceActivity.class);
                intent.putExtra("family_Info", this.t);
                startActivity(intent);
                return;
            case R.id.family_more /* 2131297546 */:
                r0(this.familyMore);
                return;
            case R.id.family_publish_something /* 2131297555 */:
                t0(this.publish);
                return;
            case R.id.family_sn /* 2131297556 */:
                if (TextUtils.isEmpty(this.A)) {
                    com.rtk.app.tool.c0.s("MyFamilyActivity", "家族号为空");
                    return;
                } else {
                    com.rtk.app.tool.t.I1(this, this.A);
                    return;
                }
            case R.id.manager_layout /* 2131299024 */:
                Intent intent2 = new Intent((Context) this, (Class<?>) FamilyManagerActivity.class);
                intent2.putExtra("family_Info", this.t);
                startActivity(intent2);
                return;
            case R.id.message_layout /* 2131299085 */:
                Bundle bundle = new Bundle();
                InformNumListBean informNumListBean = this.r;
                if (informNumListBean != null) {
                    bundle.putInt("allUnreadNum", informNumListBean.getAllUnreadNum());
                    bundle.putInt("systemUnreadNum", this.r.getSystemUnreadNum());
                    bundle.putInt("userUnreadNum", this.r.getUserUnreadNum());
                }
                bundle.putString("family_id", this.s);
                com.rtk.app.tool.c.b(this, MyMessageListActivity.class, bundle);
                return;
            case R.id.quit_family /* 2131299971 */:
                if (this.t.isHeadLeader(com.rtk.app.tool.y.K())) {
                    v0();
                    return;
                } else {
                    o0();
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_my_family);
        ButterKnife.a(this);
        ((RelativeLayout.LayoutParams) this.publish.getLayoutParams()).bottomMargin = v() + com.rtk.app.tool.h.a(20.0f, this);
        String stringExtra = getIntent().getStringExtra("family_id");
        this.s = stringExtra;
        if (stringExtra == null) {
            com.rtk.app.tool.c0.s("MyFamilyActivity", "familyId is null.");
            finish();
        }
        G(this.parent, this.backLayout);
        Q(5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        Q(1);
    }

    public void p0(TextView textView, TextView textView2) {
        textView.post(new c(this, textView, textView2));
    }

    @Override // com.rtk.app.custom.SwipeBackActivity
    public boolean q() {
        return true;
    }

    public void q0(LinearLayout linearLayout, final TextView textView, String str, final TextView textView2) {
        try {
            if (!com.rtk.app.tool.c0.q(str)) {
                linearLayout.setVisibility(0);
                textView.setMaxLines(4);
                textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
                textView.setText(str);
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.main.family.s0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        r0.post(new Runnable() { // from class: com.rtk.app.main.family.z0
                            @Override // java.lang.Runnable
                            public final void run() {
                                MyFamilyActivity.X(r1, r2);
                            }
                        });
                    }
                });
                p0(textView, textView2);
            } else {
                linearLayout.setVisibility(8);
            }
        } catch (Exception e) {
            com.rtk.app.tool.c0.u("MyFamilyActivity", "游戏详情异常" + e);
        }
    }
}
