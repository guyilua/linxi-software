package com.rtk.app.main.HomeCommunityPack;

import android.R;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.UpServiceUpImgBean;
import com.rtk.app.bean.UpVideoBean;
import com.rtk.app.bean.UpVideoIdBean;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.dialogPack.DialogAnalysisApk;
import com.rtk.app.main.dialogPack.DialogForEnSure;
import com.rtk.app.main.dialogPack.DialogForProgressHorizontal;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.o.n;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.io.IOException;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpProgressVideoIntroActivity extends BaseActivity implements h.j, n.d {
    private com.rtk.app.main.UpModule.UpHolderTool.c A;
    private String B;
    private DialogAnalysisApk C;
    private Bundle D;
    private UpServiceUpImgBean F;
    private UpVideoBean G;
    private DialogForProgressTip I;
    private DialogForProgressTip J;
    private String q;
    private Bundle r;
    private MediaMetadataRetriever s;
    private MediaPlayer t;
    private int u;

    @BindView
    TextView upVideoIntroBack;

    @BindView
    ImageView upVideoIntroImage;

    @BindView
    LinearLayout upVideoIntroTopLayout;

    @BindView
    EditText upVideoIntroVideoName;

    @BindView
    TextView upVideoSelectorEnsure;

    @BindView
    SeekBar upVideoSelectorSeekTime;
    private Bitmap w;
    private DialogForProgressHorizontal y;
    private Handler v = new a();
    private String x = "";
    private String z = "";
    private String E = null;
    private boolean H = true;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                int i2 = message.arg1;
                UpProgressVideoIntroActivity upProgressVideoIntroActivity = UpProgressVideoIntroActivity.this;
                upProgressVideoIntroActivity.w = upProgressVideoIntroActivity.s.getFrameAtTime((UpProgressVideoIntroActivity.this.u / 100) * i2 * 1000);
                UpProgressVideoIntroActivity upProgressVideoIntroActivity2 = UpProgressVideoIntroActivity.this;
                upProgressVideoIntroActivity2.upVideoIntroImage.setImageBitmap(upProgressVideoIntroActivity2.w);
                return;
            }
            if (i != 2) {
                if (i == 3) {
                    UpProgressVideoIntroActivity.this.upVideoSelectorEnsure.setEnabled(true);
                    return;
                }
                if (i != 4) {
                    return;
                }
                int i3 = message.arg1 + 1;
                Message message2 = new Message();
                message2.arg1 = i3;
                message2.what = 4;
                UpProgressVideoIntroActivity.this.y.y();
                if (i3 > 10 || UpProgressVideoIntroActivity.this.H) {
                    return;
                }
                UpProgressVideoIntroActivity.this.v.sendMessageDelayed(message2, 1000L);
                return;
            }
            UpProgressVideoIntroActivity.this.B = (String) message.obj;
            UpProgressVideoIntroActivity.this.C.dismiss();
            if (com.rtk.app.tool.v.b(MyApplication.b(), "upVideoIndex" + UpProgressVideoIntroActivity.this.B) > 1) {
                UpProgressVideoIntroActivity upProgressVideoIntroActivity3 = UpProgressVideoIntroActivity.this;
                upProgressVideoIntroActivity3.E = com.rtk.app.tool.v.d(upProgressVideoIntroActivity3.f147c, "VideoName" + UpProgressVideoIntroActivity.this.B);
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements com.rtk.app.tool.s {
        b() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            UpProgressVideoIntroActivity.this.H = !r4.H;
            if (UpProgressVideoIntroActivity.this.H) {
                UpProgressVideoIntroActivity.this.I.show();
            } else {
                UpProgressVideoIntroActivity.this.Y(2);
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements SeekBar.OnSeekBarChangeListener {
        c() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            Message message = new Message();
            message.what = 1;
            message.arg1 = i;
            UpProgressVideoIntroActivity.this.v.sendMessage(message);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class d implements com.rtk.app.tool.s {
        d() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            UpProgressVideoIntroActivity.this.Y(3);
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.upVideoIntroTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void Y(int... iArr) {
        int i = iArr[0];
        if (i == 1) {
            if (com.rtk.app.tool.c0.q(this.E)) {
                this.E = com.rtk.app.tool.y.K() + "_" + System.currentTimeMillis();
                com.rtk.app.tool.v.h(this.f147c, "VideoName" + this.B, this.E);
                com.rtk.app.tool.v.f(this.f147c, "upVideoIndex" + this.B, 1);
            }
            com.rtk.app.tool.c0.u("UpProgressVideoIntroActivity", "上传照片1");
            this.w = com.rtk.app.tool.d0.a.a(this.w);
            com.rtk.app.tool.c0.u("UpProgressVideoIntroActivity", "上传照片2");
            File l = com.rtk.app.tool.t.l(this.f147c, this.w);
            com.rtk.app.tool.c0.u("UpProgressVideoIntroActivity", "上传照片3");
            com.rtk.app.tool.o.h.x(this.f147c, this, com.rtk.app.tool.y.j + "html/filelist/uploadVideoImgNew", 1, l, "picture", this.E);
            return;
        }
        if (i == 2) {
            String substring = this.q.substring(this.q.lastIndexOf("."));
            if (com.rtk.app.tool.c0.q(substring)) {
                substring = ".mp4";
            }
            String str = substring;
            int b2 = com.rtk.app.tool.v.b(MyApplication.b(), "upVideoIndex" + this.B);
            com.rtk.app.tool.o.n.o(this, com.rtk.app.tool.y.j + com.rtk.app.tool.y.m, 2, this.q, b2 == 0 ? 1 : b2, this.B, this.E, str, false);
            return;
        }
        if (i != 3) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(com.rtk.app.tool.y.n);
        sb.append(com.rtk.app.tool.y.u(this.f147c));
        sb.append("&uid=");
        sb.append(com.rtk.app.tool.y.K());
        sb.append("&token=");
        sb.append(com.rtk.app.tool.y.H());
        sb.append("&device_name=");
        sb.append(com.rtk.app.tool.y.p(this.f147c));
        sb.append("&os_version=");
        sb.append(com.rtk.app.tool.y.D());
        sb.append("&logo=");
        sb.append(this.F.getPath().getPic());
        sb.append("&path=");
        sb.append(this.G.getPath());
        sb.append("&playTime=");
        sb.append(this.u / 1000);
        sb.append("&name=");
        sb.append(this.z);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "device_name=" + com.rtk.app.tool.y.p(this.f147c), "os_version=" + com.rtk.app.tool.y.D(), "logo=" + this.F.getPath().getPic(), "path=" + this.G.getPath(), "playTime=" + (this.u / 1000)))));
        String sb2 = sb.toString();
        com.rtk.app.tool.o.h.l(this.f147c, this, 3, com.rtk.app.tool.o.h.h(new String[0]).a(sb2));
        StringBuilder sb3 = new StringBuilder();
        sb3.append("请求视频Id接口");
        sb3.append(com.rtk.app.tool.y.d);
        sb3.append(sb2);
        com.rtk.app.tool.c0.u("UpProgressVideoIntroActivity", sb3.toString());
        this.J.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i == 1) {
            com.rtk.app.tool.c0.u("UpProgressVideoIntroActivity", "上传图片地址 " + str);
            this.F = (UpServiceUpImgBean) this.g.fromJson(str, UpServiceUpImgBean.class);
            String str2 = this.F.getPath().getUrl() + this.F.getPath().getPic();
            this.x = str2;
            this.D.putString("previewUrl", str2);
            Y(2);
            return;
        }
        if (i == 2) {
            this.G = (UpVideoBean) this.g.fromJson(str, UpVideoBean.class);
            com.rtk.app.tool.c0.u("UpProgressVideoIntroActivity", "上传视频" + str);
            this.D.putString("videoUrl", this.G.getPath());
            Y(3);
            this.v.removeMessages(4);
            return;
        }
        if (i != 3) {
            return;
        }
        com.rtk.app.tool.c0.u("UpProgressVideoIntroActivity", "视屏Id" + str);
        Intent intent = new Intent();
        this.D.putInt("videoId", ((UpVideoIdBean) this.g.fromJson(str, UpVideoIdBean.class)).getData().getId());
        intent.putExtras(this.D);
        setResult(1027, intent);
        com.rtk.app.tool.f.a(this.f147c, "上传成功", f.a.f);
        this.y.dismiss();
        finish();
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        this.v.removeMessages(1);
        this.v.removeMessages(2);
        this.v.removeMessages(3);
        this.v.removeMessages(4);
        com.rtk.app.tool.o.n.n(null);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (i2 != 1 && i2 != 2) {
            if (i2 != 3) {
                return;
            }
            this.J.dismiss();
            this.I.dismiss();
            this.y.w(true);
            this.y.dismiss();
            this.v.sendEmptyMessage(3);
            new DialogForEnSure(this.f147c, "上传成功，但提交失败，是否重试~", new d()).show();
            return;
        }
        com.rtk.app.tool.c0.u("UpProgressVideoIntroActivity", "上传视频mark" + i2 + "   --->" + str);
        if (str.contains("请检查文件")) {
            com.rtk.app.tool.f.a(this.f147c, "上传失败，请检查文件", f.a.f);
        } else {
            com.rtk.app.tool.f.a(this.f147c, "上传失败，请检查网络后重试！", f.a.f);
        }
        this.y.dismiss();
        this.H = true;
        this.v.sendEmptyMessage(3);
        this.v.removeMessages(4);
    }

    @Override // com.rtk.app.tool.o.n.d
    public boolean i() {
        if (this.H) {
            this.I.dismiss();
            this.y.w(true);
        }
        return this.H;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        this.r = extras;
        this.q = extras.getString("videoPath");
        this.D = new Bundle();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        this.s = mediaMetadataRetriever;
        mediaMetadataRetriever.setDataSource(this.q);
        this.t = new MediaPlayer();
        new File(this.q);
        try {
            this.t.setDataSource(this.q);
            this.t.prepare();
            this.u = this.t.getDuration();
            com.rtk.app.tool.c0.u("UpProgressVideoIntroActivity", "总时间" + this.u);
            Bitmap frameAtTime = this.s.getFrameAtTime((long) (this.u / 100));
            this.w = frameAtTime;
            this.upVideoIntroImage.setImageBitmap(frameAtTime);
            this.upVideoSelectorSeekTime.setProgress(1);
        } catch (IOException unused) {
        }
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.upVideoSelectorSeekTime.setOnSeekBarChangeListener(new c());
        com.rtk.app.tool.o.n.n(this);
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.C = new DialogAnalysisApk(this.f147c);
        if (com.rtk.app.tool.c0.q(this.B)) {
            this.C.show();
            com.rtk.app.main.UpModule.UpHolderTool.c cVar = new com.rtk.app.main.UpModule.UpHolderTool.c(this.q, this.v);
            this.A = cVar;
            cVar.execute(new String[0]);
        }
        this.q.lastIndexOf("/");
        this.q.lastIndexOf(".");
        com.rtk.app.tool.c0.u("UpProgressVideoIntroActivity", "视频地址" + this.z);
        this.y = new DialogForProgressHorizontal(this.f147c, "视频资源上传中，请稍后...", new b());
        DialogForProgressTip dialogForProgressTip = new DialogForProgressTip(this.f147c, "处理中请稍后");
        this.I = dialogForProgressTip;
        dialogForProgressTip.setCancelable(false);
        this.J = new DialogForProgressTip(this.f147c, "资源整合中，请稍后");
    }

    @Override // com.rtk.app.tool.o.n.d
    public void o(int i, int i2) {
        com.rtk.app.tool.c0.u("UpProgressVideoIntroActivity", "当前视频进度all   " + i + " index  " + i2);
        this.I.dismiss();
        this.y.w(true);
        DialogForProgressHorizontal dialogForProgressHorizontal = this.y;
        if (dialogForProgressHorizontal != null) {
            dialogForProgressHorizontal.x(i, i2);
        }
        this.v.removeMessages(4);
        if (this.H) {
            return;
        }
        Message message = new Message();
        message.arg1 = 0;
        message.what = 4;
        this.v.sendMessageDelayed(message, 1000L);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131301054) {
            finish();
            return;
        }
        if (id != 2131301058) {
            return;
        }
        this.upVideoSelectorEnsure.setEnabled(false);
        this.H = !this.H;
        this.z = this.upVideoIntroVideoName.getText().toString().trim();
        this.y.show();
        if (this.G != null) {
            Y(3);
        } else {
            Y(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_up_video_intro);
        ButterKnife.a(this);
    }
}
