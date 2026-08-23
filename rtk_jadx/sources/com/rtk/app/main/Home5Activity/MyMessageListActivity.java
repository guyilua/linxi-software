package com.rtk.app.main.Home5Activity;

import android.R;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.adapter.MyFragmentAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.custom.BaseViewPager;
import com.rtk.app.main.dialogPack.DialogForReadAllMessage;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyMessageListActivity extends BaseActivity implements h.j {

    @BindView
    TextView massageNumForSystem;

    @BindView
    TextView massageNumForUser;

    @BindView
    TabLayout myMessageListTab;

    @BindView
    TextView myMessageListTopBack;

    @BindView
    LinearLayout myMessageListTopLayout;

    @BindView
    TextView myMessageListTopReadAll;

    @BindView
    BaseViewPager myMessageListViewPager;
    protected int q;
    protected int r;
    private MyMessageForUserFragment s;
    private MyMessageForUserFragment t;
    private String u;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements com.rtk.app.tool.s {
        a() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            MyMessageListActivity.this.s.K();
            MyMessageListActivity.this.t.K();
            MyMessageListActivity myMessageListActivity = MyMessageListActivity.this;
            myMessageListActivity.r = 0;
            myMessageListActivity.q = 0;
            myMessageListActivity.O(0);
            MyMessageListActivity myMessageListActivity2 = MyMessageListActivity.this;
            myMessageListActivity2.N(myMessageListActivity2.q);
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.myMessageListTopLayout, this.myMessageListTab, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N(int i) {
        String str;
        if (i > 0) {
            TextView textView = this.massageNumForSystem;
            if (i > 99) {
                str = "99+";
            } else {
                str = i + "";
            }
            textView.setText(str);
        }
        this.massageNumForSystem.setVisibility(i > 0 ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void O(int i) {
        String str;
        if (i > 0) {
            TextView textView = this.massageNumForUser;
            if (i > 99) {
                str = "99+";
            } else {
                str = i + "";
            }
            textView.setText(str);
        }
        this.massageNumForUser.setVisibility(i > 0 ? 0 : 8);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        extras.getInt("allUnreadNum");
        this.q = extras.getInt("systemUnreadNum");
        this.r = extras.getInt("userUnreadNum");
        this.u = extras.getString("family_id");
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        if (!TextUtils.isEmpty(this.u) && !TextUtils.equals(this.u, "0")) {
            this.myMessageListTopBack.setText(com.rtk.app.R.string.family_message);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("用户消息");
        arrayList2.add("系统消息");
        O(this.r);
        N(this.q);
        this.s = new MyMessageForUserFragment();
        this.t = new MyMessageForUserFragment();
        Bundle bundle = new Bundle();
        bundle.putString("msgType", "1");
        bundle.putString("family_id", this.u);
        this.s.setArguments(bundle);
        Bundle bundle2 = new Bundle();
        bundle2.putString("msgType", "0");
        bundle2.putString("family_id", this.u);
        this.t.setArguments(bundle2);
        arrayList.add(this.s);
        arrayList.add(this.t);
        this.myMessageListTab.setupWithViewPager(this.myMessageListViewPager, true);
        this.myMessageListViewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), arrayList, arrayList2));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131299471) {
            finish();
        } else {
            if (id != 2131299473) {
                return;
            }
            new DialogForReadAllMessage(this.f147c, new a()).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_my_message_list);
        ButterKnife.a(this);
    }
}
