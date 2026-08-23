package com.rtk.app.main.UpModule.UpControlPack;

import android.R;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.adapter.YcFileManageAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.custom.YcRecyclerView;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.f;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class YcFileManageActivity extends BaseActivity implements s {
    public static List<YcFileManageActivity> v = new ArrayList();
    private String q;
    private YcFileManageAdapter t;

    @BindView
    TextView ycFileManageBackBackTV;

    @BindView
    LinearLayout ycFileManageBackLastPath;

    @BindView
    LinearLayout ycFileManageBackLayout;

    @BindView
    CheckBox ycFileManageFilter;

    @BindView
    YcRecyclerView ycFileManageRecyclerView;
    private List<YcFileManageAdapter.c> r = new ArrayList();
    private List<String> s = new ArrayList();
    private boolean u = true;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements FileFilter {
        YcFileManageAdapter.c.a a;

        public a(YcFileManageAdapter.c.a aVar) {
            this.a = aVar;
            c0.u("YcFileManageActivity", "进入过滤器");
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            c0.u("YcFileManageActivity", "进入过滤器+accept");
            YcFileManageAdapter.c.a aVar = this.a;
            if (aVar == YcFileManageAdapter.c.a.file) {
                return file.getName().endsWith(".zip") || file.getName().endsWith(".ZIP");
            }
            if (aVar == YcFileManageAdapter.c.a.folder && file.isDirectory()) {
                return YcFileManageActivity.this.u ? !file.getName().startsWith(".") : file.isDirectory();
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O(CompoundButton compoundButton, boolean z) {
        boolean z2 = !this.u;
        this.u = z2;
        this.ycFileManageFilter.setChecked(z2);
        initView();
    }

    public static void P(YcFileManageActivity ycFileManageActivity) {
        v.add(ycFileManageActivity);
    }

    public static void Q() {
        while (v.size() > 0) {
            v.get(r0.size() - 1).finish();
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        t.S1(this.f147c, this.ycFileManageBackLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public boolean M(String str, String str2) {
        int intValue = Integer.valueOf(str.toCharArray()[0]).intValue();
        int intValue2 = Integer.valueOf(str2.toCharArray()[0]).intValue();
        Integer num = 97;
        if (num.intValue() <= intValue && intValue <= 122) {
            intValue -= 32;
        }
        if (num.intValue() <= intValue2 && intValue2 <= 122) {
            intValue2 -= 32;
        }
        if (intValue > intValue2) {
            return true;
        }
        if (intValue != intValue2 || Integer.valueOf(str.toCharArray()[0]).intValue() < Integer.valueOf(str.toCharArray()[0]).intValue()) {
            return false;
        }
        if (Integer.valueOf(str.toCharArray()[0]).intValue() > Integer.valueOf(str.toCharArray()[0]).intValue()) {
            return true;
        }
        if (str.length() >= 2 && str2.length() >= 2) {
            return M(str.substring(1), str2.substring(1));
        }
        if (str.length() >= 1) {
            return true;
        }
        if (str.length() >= 1) {
        }
        return false;
    }

    public File[] R(File[] fileArr) {
        c0.u("YcFileManageActivity", "进入冒泡排序");
        for (int i = 0; i < fileArr.length; i++) {
            for (int i2 = 1; i2 < fileArr.length - i; i2++) {
                int i3 = i2 - 1;
                if (M(fileArr[i3].getName(), fileArr[i2].getName())) {
                    File file = fileArr[i2];
                    fileArr[i2] = fileArr[i3];
                    fileArr[i3] = file;
                }
            }
        }
        return fileArr;
    }

    @Override // com.rtk.app.tool.s
    public void a(String... strArr) {
        if (!this.s.contains(this.q)) {
            this.s.add(this.q);
        }
        this.q = strArr[0];
        initView();
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        v.remove(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        this.q = getIntent().getExtras().getString("currentPath");
        this.ycFileManageRecyclerView.setLayoutManager(new LinearLayoutManager(this.f147c));
        YcFileManageAdapter ycFileManageAdapter = new YcFileManageAdapter(this.f147c, this.r, this);
        this.t = ycFileManageAdapter;
        this.ycFileManageRecyclerView.setAdapter(ycFileManageAdapter);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.ycFileManageFilter.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rtk.app.main.UpModule.UpControlPack.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                YcFileManageActivity.this.O(compoundButton, z);
            }
        });
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.ycFileManageBackBackTV.setText(this.q.replace("/storage/emulated/0", "内部存储"));
        this.r.clear();
        File file = new File(this.q);
        File[] listFiles = file.listFiles(new a(YcFileManageAdapter.c.a.folder));
        if (listFiles == null) {
            c0.s("YcFileManageActivity", "initView files is null");
            f.a(this.f147c, "此路径没有访问权限", f.a.f);
            return;
        }
        if (listFiles.length == 0) {
            c0.s("YcFileManageActivity", "initView files is 0");
        }
        R(listFiles);
        File[] listFiles2 = file.listFiles(new a(YcFileManageAdapter.c.a.file));
        R(listFiles2);
        for (int i = 0; i < listFiles.length; i++) {
            this.r.add(new YcFileManageAdapter.c(listFiles[i].getName(), listFiles[i].getAbsolutePath(), 0L, listFiles[i].lastModified(), YcFileManageAdapter.c.a.folder));
        }
        for (int i2 = 0; i2 < listFiles2.length; i2++) {
            this.r.add(new YcFileManageAdapter.c(listFiles2[i2].getName(), listFiles2[i2].getAbsolutePath(), listFiles2[i2].length(), listFiles2[i2].lastModified(), YcFileManageAdapter.c.a.file));
        }
        this.t.notifyDataSetChanged();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.rtk.app.R.id.yc_file_manage_back_backTV /* 2131301173 */:
                finish();
                return;
            case com.rtk.app.R.id.yc_file_manage_back_last_path /* 2131301174 */:
                if (this.s.size() >= 1) {
                    this.s.remove(this.q);
                    List<String> list = this.s;
                    this.q = list.get(list.size() - 1);
                    initView();
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_yc_file_manage);
        ButterKnife.a(this);
        P(this);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            try {
                if (keyEvent.getAction() == 0) {
                    if (this.s.size() >= 1) {
                        this.s.remove(this.q);
                        List<String> list = this.s;
                        this.q = list.get(list.size() - 1);
                        initView();
                        return false;
                    }
                    finish();
                    return true;
                }
            } catch (Exception unused) {
                return super.onKeyDown(i, keyEvent);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }
}
