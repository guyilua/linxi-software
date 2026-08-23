package com.rtk.app.main.login;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.adapter.EditPictureRecyclerAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.Home5ImfromationBean;
import com.rtk.app.bean.PostImageBean;
import com.rtk.app.bean.ResponseDataBean;
import com.rtk.app.bean.UpServiceUpImgBean;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.dialogPack.DialogPermision;
import com.rtk.app.main.dialogPack.b0;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class EditPictureActivity extends BaseActivity implements h.j, s {

    @BindView
    CheckBox editPictureDeleteBtu;

    @BindView
    RecyclerView editPictureRecyclerView;

    @BindView
    SwipeRefreshLayout editPictureSwipeRefresh;

    @BindView
    TextView editPictureTopBack;

    @BindView
    LinearLayout editPictureTopLayout;
    private List<Home5ImfromationBean.DataBean.PhotoWallBean> q;
    private b0 r;
    private List<String> s;
    private EditPictureRecyclerAdapter t;
    private Home5ImfromationBean u;
    private String v;
    private UpServiceUpImgBean w;
    private File x;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N() {
        this.q.clear();
        L(2);
    }

    private void O() {
        this.r.show();
        List<String> list = this.s;
        if (list != null && list.size() > 0) {
            this.x = new File(this.s.get(0));
            L(1);
            this.s.remove(0);
            return;
        }
        this.r.dismiss();
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        t.S1(this.f147c, this.editPictureTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
        int i = iArr[0];
        String str = "";
        if (i == 1) {
            c0.u("EditPictureActivity", "请求上传");
            com.rtk.app.tool.o.h.v(this.f147c, new com.rtk.app.custom.RichEditText.a.f(y.K(), y.H(), MainActivity.p.getData().getLevel() + "", this, y.i + "html/filelist/uploadBbsImg", iArr[0], this.x, "photo"), new boolean[0]);
        } else if (i == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("members/userBaseInfo");
            sb.append(y.u(this.f147c));
            sb.append("&uid=");
            sb.append(y.K());
            sb.append("&token=");
            sb.append(y.G(this.f147c));
            sb.append("&key=");
            sb.append(t.c0(c0.e(y.v(this.f147c, "uid=" + y.K(), "token=" + y.G(this.f147c)))));
            str = sb.toString();
        } else if (i == 3) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/removeUserPhoto");
            sb2.append(y.u(this.f147c));
            sb2.append("&uid=");
            sb2.append(y.K());
            sb2.append("&id=");
            sb2.append(this.v);
            sb2.append("&token=");
            sb2.append(y.H());
            sb2.append("&key=");
            sb2.append(t.c0(c0.e(y.v(this.f147c, "id=" + this.v, "uid=" + y.K(), "token=" + y.H()))));
            str = sb2.toString();
        } else if (i == 4) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("members/setUserPhoto");
            sb3.append(y.u(this.f147c));
            sb3.append("&uid=");
            sb3.append(y.K());
            sb3.append("&pic=");
            sb3.append(this.w.getPath().getPic());
            sb3.append("&thumPic=");
            sb3.append(this.w.getPath().getThumb());
            sb3.append("&token=");
            sb3.append(y.H());
            sb3.append("&key=");
            sb3.append(t.c0(c0.e(y.v(this.f147c, "pic=" + this.w.getPath().getPic(), "thumPic=" + this.w.getPath().getThumb(), "uid=" + y.K(), "token=" + y.H()))));
            str = sb3.toString();
        }
        c0.u("EditPictureActivity", "删除图片" + y.d + str);
        if (c0.q(str)) {
            return;
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(str));
    }

    @Override // com.rtk.app.tool.s
    public void a(String... strArr) {
        String str = strArr[0];
        str.hashCode();
        if (!str.equals("1")) {
            if (str.equals("2") && this.q.size() < 9) {
                t.E1(this.f147c, 9 - this.q.size(), false);
                return;
            }
            return;
        }
        this.v = strArr[1];
        L(3);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        int i2 = 0;
        if (i == 1) {
            c0.u("EditPictureActivity", "上传图片   " + str);
            this.w = (UpServiceUpImgBean) this.g.fromJson(str, UpServiceUpImgBean.class);
            L(4);
            return;
        }
        if (i == 2) {
            c0.u("EditPictureActivity", "  我的相冊列表   " + str);
            this.editPictureSwipeRefresh.setRefreshing(false);
            Home5ImfromationBean home5ImfromationBean = (Home5ImfromationBean) this.g.fromJson(str, Home5ImfromationBean.class);
            this.u = home5ImfromationBean;
            this.q.addAll(home5ImfromationBean.getData().getPhotoWall());
            this.t.notifyDataSetChanged();
            return;
        }
        if (i == 3) {
            c0.u("EditPictureActivity", "  刪除照片   " + str);
            com.rtk.app.tool.f.a(this.f147c, ((ResponseDataBean) this.g.fromJson(str, ResponseDataBean.class)).getMsg(), f.a.f);
            while (true) {
                if (i2 >= this.q.size()) {
                    break;
                }
                if (this.q.get(i2).getId().equals(this.v)) {
                    this.q.remove(i2);
                    break;
                }
                i2++;
            }
            this.t.notifyDataSetChanged();
            return;
        }
        if (i != 4) {
            return;
        }
        c0.u("EditPictureActivity", "  服务器保留地址成功  " + str);
        this.w = null;
        PostImageBean postImageBean = (PostImageBean) this.g.fromJson(str, PostImageBean.class);
        Home5ImfromationBean.DataBean.PhotoWallBean photoWallBean = new Home5ImfromationBean.DataBean.PhotoWallBean();
        photoWallBean.setId(postImageBean.getData().getId() + "");
        photoWallBean.setPic(postImageBean.getData().getPic());
        photoWallBean.setThumPic(postImageBean.getData().getThum());
        this.q.add(photoWallBean);
        this.t.notifyDataSetChanged();
        O();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        c0.u("EditPictureActivity", "相册界面" + str);
        this.editPictureSwipeRefresh.setRefreshing(false);
        this.r.dismiss();
        com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        this.q = new ArrayList();
        this.editPictureRecyclerView.setLayoutManager(new GridLayoutManager(this.f147c, 3));
        EditPictureRecyclerAdapter editPictureRecyclerAdapter = new EditPictureRecyclerAdapter(this.f147c, this.q, this);
        this.t = editPictureRecyclerAdapter;
        this.editPictureRecyclerView.setAdapter(editPictureRecyclerAdapter);
        L(2);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.editPictureSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.rtk.app.main.login.a
            public final void onRefresh() {
                EditPictureActivity.this.N();
            }
        });
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.r = new b0(this.f147c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 115 && i2 == -1) {
            try {
                this.s = new ArrayList();
                List d = com.luck.picture.lib.b.d(intent);
                this.s.clear();
                Iterator it = d.iterator();
                while (it.hasNext()) {
                    this.s.add(((com.luck.picture.lib.f.b) it.next()).f());
                }
                O();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != 2131297491) {
            if (id != 2131297497) {
                return;
            }
            finish();
        } else if (this.editPictureDeleteBtu.isChecked()) {
            this.editPictureDeleteBtu.setText("完成");
            this.t.l(true);
            this.t.notifyDataSetChanged();
        } else {
            this.editPictureDeleteBtu.setText("编辑");
            this.t.l(false);
            this.t.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_edit_picture);
        ButterKnife.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 10000 || i == 10001) {
            for (int i2 : iArr) {
                if (i2 != 0) {
                    DialogPermision dialogPermision = new DialogPermision(MyApplication.b(), t.U(this));
                    dialogPermision.d();
                    dialogPermision.show();
                    return;
                }
            }
            if (this.q.size() < 9) {
                t.E1(this.f147c, 9 - this.q.size(), false);
            }
        }
    }
}
