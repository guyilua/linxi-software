package com.rtk.app.main.UpModule;

import android.R;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.main.dialogPack.DialogForEnSure;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpSearchJustHistoryActivity extends BaseActivity {

    @BindView
    TextView activityUpSearchJustHistoryClear;

    @BindView
    LinearLayout activityUpSearchJustHistoryLv;

    @BindView
    TextView activityUpSearchJustHistoryTopBack;

    @BindView
    LinearLayout activityUpSearchJustHistoryTopLayout;

    @BindView
    EditText activityUpSearchJustHistoryTopSearch;

    @BindView
    TextView activityUpSearchJustHistoryTopSubmit;
    private String r;
    private String q = "";
    private List<String> s = new ArrayList();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements com.rtk.app.tool.s {
        a() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            UpSearchJustHistoryActivity.this.r = "";
            com.rtk.app.tool.v.h(UpSearchJustHistoryActivity.this.f147c, "searchUpHistoryVALUE", "");
            UpSearchJustHistoryActivity.this.activityUpSearchJustHistoryLv.removeAllViews();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = (String) ((TextView) view).getText();
            UpSearchJustHistoryActivity.this.s.remove(str);
            UpSearchJustHistoryActivity.this.s.add(0, str);
            UpSearchJustHistoryActivity upSearchJustHistoryActivity = UpSearchJustHistoryActivity.this;
            com.rtk.app.tool.t.D1(upSearchJustHistoryActivity.f147c, upSearchJustHistoryActivity.s);
            com.rtk.app.tool.t.g1(UpSearchJustHistoryActivity.this.f147c, str);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements View.OnLongClickListener {
        c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            UpSearchJustHistoryActivity.this.s.remove((String) ((TextView) view).getText());
            UpSearchJustHistoryActivity upSearchJustHistoryActivity = UpSearchJustHistoryActivity.this;
            com.rtk.app.tool.t.D1(upSearchJustHistoryActivity.f147c, upSearchJustHistoryActivity.s);
            UpSearchJustHistoryActivity.this.activityUpSearchJustHistoryLv.removeView(view);
            return true;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class d implements TextView.OnEditorActionListener {
        d() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            UpSearchJustHistoryActivity upSearchJustHistoryActivity = UpSearchJustHistoryActivity.this;
            upSearchJustHistoryActivity.q = upSearchJustHistoryActivity.activityUpSearchJustHistoryTopSearch.getText().toString().trim();
            if (!com.rtk.app.tool.c0.q(UpSearchJustHistoryActivity.this.q)) {
                UpSearchJustHistoryActivity.this.s.remove(UpSearchJustHistoryActivity.this.q);
                UpSearchJustHistoryActivity.this.s.add(0, UpSearchJustHistoryActivity.this.q);
                UpSearchJustHistoryActivity upSearchJustHistoryActivity2 = UpSearchJustHistoryActivity.this;
                com.rtk.app.tool.t.D1(upSearchJustHistoryActivity2.f147c, upSearchJustHistoryActivity2.s);
                UpSearchJustHistoryActivity upSearchJustHistoryActivity3 = UpSearchJustHistoryActivity.this;
                com.rtk.app.tool.t.g1(upSearchJustHistoryActivity3.f147c, upSearchJustHistoryActivity3.q);
            } else {
                com.rtk.app.tool.f.a(UpSearchJustHistoryActivity.this.f147c, "请输入搜索内容", f.a.f);
            }
            return true;
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.activityUpSearchJustHistoryTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.activityUpSearchJustHistoryTopSearch.setOnEditorActionListener(new d());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        com.rtk.app.tool.t.B1(this.activityUpSearchJustHistoryTopSearch, this.f147c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131296397) {
            new DialogForEnSure(this.f147c, "确定清除历史记录吗？", new a()).show();
            return;
        }
        if (id == 2131296399) {
            finish();
            return;
        }
        if (id != 2131296402) {
            return;
        }
        String trim = this.activityUpSearchJustHistoryTopSearch.getText().toString().trim();
        this.q = trim;
        if (com.rtk.app.tool.c0.q(trim)) {
            com.rtk.app.tool.f.a(this.f147c, "请输入搜索内容", f.a.f);
            return;
        }
        this.s.remove(this.q);
        this.s.add(0, this.q);
        com.rtk.app.tool.t.D1(this.f147c, this.s);
        com.rtk.app.tool.t.g1(this.f147c, this.q);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_up_search_just_history);
        ButterKnife.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        this.s.clear();
        this.activityUpSearchJustHistoryLv.removeAllViews();
        String d2 = com.rtk.app.tool.v.d(this.f147c, "searchUpHistoryVALUE");
        this.r = d2;
        this.s.addAll(com.rtk.app.tool.c0.d(d2, "\\|\\|"));
        for (int i = 0; i < this.s.size(); i++) {
            TextView textView = (TextView) LayoutInflater.from(this.f147c).inflate(com.rtk.app.R.layout.up_search_just_history_item_layout, (ViewGroup) null);
            textView.setText(this.s.get(i));
            textView.setOnClickListener(new b());
            textView.setOnLongClickListener(new c());
            this.activityUpSearchJustHistoryLv.addView(textView);
        }
    }
}
