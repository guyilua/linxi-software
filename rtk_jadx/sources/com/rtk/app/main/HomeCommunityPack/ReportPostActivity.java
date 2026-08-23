package com.rtk.app.main.HomeCommunityPack;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.ReportPostListBean;
import com.rtk.app.bean.ResponseDataBean;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ReportPostActivity extends BaseActivity implements h.j {
    private String q;

    @BindView
    TextView reportPostBack;

    @BindView
    EditText reportPostComment;

    @BindView
    EditText reportPostContact;

    @BindView
    TextView reportPostContentSize;

    @BindView
    LinearLayout reportPostLayout;

    @BindView
    Spinner reportPostSpinner;

    @BindView
    TextView reportPostSubmit;
    private ArrayAdapter s;
    private String t;
    private String u;
    private String v;
    private ReportPostListBean w;
    private String x;
    private String z;
    private List<String> r = new ArrayList();
    private boolean y = false;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i == 0) {
                return;
            }
            ReportPostActivity reportPostActivity = ReportPostActivity.this;
            reportPostActivity.t = reportPostActivity.w.getData().get(i - 1).getId();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.reportPostLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void N(int... iArr) {
        String str;
        int i = iArr[0];
        if (i != 1) {
            if (i != 2) {
                str = "";
            } else {
                if (this.reportPostSpinner.getSelectedItemPosition() == 0) {
                    com.rtk.app.tool.f.a(this.f147c, "请选择举报类型", f.a.f);
                    return;
                }
                if (this.y) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("members/userComplaint");
                    sb.append(com.rtk.app.tool.y.u(this.f147c));
                    sb.append("&uid=");
                    sb.append(com.rtk.app.tool.y.K());
                    sb.append("&token=");
                    sb.append(com.rtk.app.tool.y.H());
                    sb.append("&toUser=");
                    sb.append(this.z);
                    sb.append("&type=");
                    sb.append(this.t);
                    sb.append("&contact=");
                    sb.append(this.u);
                    sb.append("&desc=");
                    sb.append(this.v);
                    sb.append("&key=");
                    sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "type=" + this.t, "toUser=" + this.z, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
                    str = sb.toString();
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("members/postsComplaint");
                    sb2.append(com.rtk.app.tool.y.u(this.f147c));
                    sb2.append("&uid=");
                    sb2.append(com.rtk.app.tool.y.K());
                    sb2.append("&token=");
                    sb2.append(com.rtk.app.tool.y.H());
                    sb2.append("&pid=");
                    sb2.append(this.q);
                    sb2.append("&type=");
                    sb2.append(this.t);
                    sb2.append("&cmtid=");
                    sb2.append(this.x);
                    sb2.append("&contact=");
                    sb2.append(this.u);
                    sb2.append("&desc=");
                    sb2.append(this.v);
                    sb2.append("&key=");
                    sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "pid=" + this.q, "type=" + this.t, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
                    str = sb2.toString();
                }
            }
        } else if (this.y) {
            str = "members/userComplaintList" + com.rtk.app.tool.y.u(this.f147c) + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, new String[0])));
        } else {
            str = "members/postsComplaintList" + com.rtk.app.tool.y.u(this.f147c) + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, new String[0])));
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(str));
        com.rtk.app.tool.c0.u("ReportPostActivity", "举报  " + com.rtk.app.tool.y.d + str);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("ReportPostActivity", "举报" + str);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            if (i != 2) {
                return;
            }
            com.rtk.app.tool.f.a(this.f147c, ((ResponseDataBean) create.fromJson(str, ResponseDataBean.class)).getMsg(), f.a.f);
            finish();
            return;
        }
        this.w = (ReportPostListBean) create.fromJson(str, ReportPostListBean.class);
        this.r.add("请选择");
        for (int i2 = 0; i2 < this.w.getData().size(); i2++) {
            this.r.add(this.w.getData().get(i2).getName());
        }
        this.s.notifyDataSetChanged();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        boolean z = extras.getBoolean("reportUser", false);
        this.y = z;
        if (z) {
            this.z = extras.getString("toUser", "");
        } else {
            extras.getString("mid");
            this.q = extras.getString("pid");
            this.x = extras.getString("cmtid", "");
        }
        N(1);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.reportPostSpinner.setOnItemSelectedListener(new a());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context) this.f147c, R.layout.simple_spinner_dropdown_item, (List) this.r);
        this.s = arrayAdapter;
        this.reportPostSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131300023) {
            finish();
        } else {
            if (id != 2131300029) {
                return;
            }
            this.u = this.reportPostContact.getText().toString().trim();
            this.v = this.reportPostComment.getText().toString().trim();
            N(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_report_post);
        ButterKnife.a(this);
    }
}
