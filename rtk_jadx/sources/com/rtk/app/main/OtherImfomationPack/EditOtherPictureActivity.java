package com.rtk.app.main.OtherImfomationPack;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.adapter.EditOtherPictureAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.OtherImformationBean;
import com.rtk.app.main.dialogPack.DialogForEnSure;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.y;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class EditOtherPictureActivity extends BaseActivity implements h.j, com.rtk.app.tool.s {

    @BindView
    TextView editOtherPictureDeleteAll;

    @BindView
    RecyclerView editOtherPictureRecyclerView;

    @BindView
    SwipeRefreshLayout editOtherPictureSwipeRefresh;

    @BindView
    TextView editOtherPictureTopBack;

    @BindView
    LinearLayout editOtherPictureTopLayout;
    private List<OtherImformationBean.DataBean.PhotoWallBean> q;
    private String r;
    private String s;
    private EditOtherPictureAdapter t;
    private DialogForEnSure u = null;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements com.rtk.app.tool.s {
        a() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            EditOtherPictureActivity.this.O(3);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements com.rtk.app.tool.s {

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        class a implements com.rtk.app.tool.s {
            a() {
            }

            @Override // com.rtk.app.tool.s
            public void a(String... strArr) {
                EditOtherPictureActivity.this.O(2);
            }
        }

        b() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            EditOtherPictureActivity.this.s = strArr[0];
            EditOtherPictureActivity.this.u = new DialogForEnSure(EditOtherPictureActivity.this.f147c, "确定删除该图片吗？", new a());
            EditOtherPictureActivity.this.u.show();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements SwipeRefreshLayout.OnRefreshListener {
        c(EditOtherPictureActivity editOtherPictureActivity) {
        }

        public void onRefresh() {
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.editOtherPictureTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void O(int... iArr) {
        int i = iArr[0];
        if (i == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("user/photo/delete");
            sb.append(y.u(this.f147c));
            sb.append("&uid=");
            sb.append(y.K());
            sb.append("&token=");
            sb.append(y.H());
            sb.append("&touser=");
            sb.append(this.r);
            sb.append("&ids=");
            sb.append(this.s);
            sb.append("&key=");
            sb.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.f147c, "touser=" + this.r, "ids=" + this.s, "uid=" + y.K(), "token=" + y.H()))));
            String sb2 = sb.toString();
            com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(y.e).a(sb2));
            StringBuilder sb3 = new StringBuilder();
            sb3.append("  修改其他用户的图片  mark=");
            sb3.append(iArr[0]);
            sb3.append("   ");
            sb3.append(y.e);
            sb3.append(sb2);
            c0.u("EditOtherPictureActivity", sb3.toString());
            return;
        }
        String str = "";
        if (i != 3) {
            com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(""));
            c0.u("EditOtherPictureActivity", "  修改其他用户的图片  mark=" + iArr[0] + "   " + y.d + "");
            return;
        }
        for (int i2 = 0; i2 < this.q.size(); i2++) {
            str = i2 == this.q.size() - 1 ? str + this.q.get(i2).getId() : str + this.q.get(i2).getId() + ",";
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("user/photo/delete");
        sb4.append(y.u(this.f147c));
        sb4.append("&uid=");
        sb4.append(y.K());
        sb4.append("&token=");
        sb4.append(y.H());
        sb4.append("&touser=");
        sb4.append(this.r);
        sb4.append("&ids=");
        sb4.append(str);
        sb4.append("&key=");
        sb4.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.f147c, "touser=" + this.r, "ids=" + str, "uid=" + y.K(), "token=" + y.H()))));
        String sb5 = sb4.toString();
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(y.e).a(sb5));
        StringBuilder sb6 = new StringBuilder();
        sb6.append("  修改其他用户的图片  mark=");
        sb6.append(iArr[0]);
        sb6.append("   ");
        sb6.append(y.e);
        sb6.append(sb5);
        c0.u("EditOtherPictureActivity", sb6.toString());
    }

    @Override // com.rtk.app.tool.s
    public void a(String... strArr) {
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        this.u.dismiss();
        if (i != 2) {
            if (i != 3) {
                return;
            }
            c0.u("EditOtherPictureActivity", "删除全部" + str);
            this.q.clear();
            this.t.notifyDataSetChanged();
            return;
        }
        c0.u("EditOtherPictureActivity", "删除指定游戏" + str);
        for (int i2 = 0; i2 < this.q.size(); i2++) {
            if (this.q.get(i2).getId().equals(this.s)) {
                this.q.remove(i2);
            }
        }
        this.t.notifyDataSetChanged();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        this.q = ((OtherImformationBean) extras.getSerializable("otherImformationBean")).getData().getPhotoWall();
        this.r = extras.getString("fans");
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.editOtherPictureSwipeRefresh.setOnRefreshListener(new c(this));
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.t = new EditOtherPictureAdapter(this.q, this.f147c, new b());
        this.editOtherPictureRecyclerView.setLayoutManager(new GridLayoutManager(this.f147c, 3));
        this.editOtherPictureRecyclerView.setAdapter(this.t);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != 2131297485) {
            if (id != 2131297488) {
                return;
            }
            finish();
        } else {
            DialogForEnSure dialogForEnSure = new DialogForEnSure(this.f147c, "确定全部删除吗", new a());
            this.u = dialogForEnSure;
            dialogForEnSure.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_edit_other_picture);
        ButterKnife.a(this);
    }
}
