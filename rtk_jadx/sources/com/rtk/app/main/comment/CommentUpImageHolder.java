package com.rtk.app.main.comment;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.bean.UpServiceUpImgBean;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.dialogPack.b0;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.r;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import com.zhy.view.flowlayout.FlowLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CommentUpImageHolder extends com.rtk.app.base.g implements View.OnClickListener, h.j {
    public List<UpServiceUpImgBean.PathBean> j;
    private Bitmap k;
    private List<String> l;
    private File m;
    private b0 n;
    private Handler o;
    private String p;

    @BindView
    ImageView upApkUpImageAddPhoto;

    @BindView
    FlowLayout upApkUpImagePhotoLv;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            CommentUpImageHolder.this.s(((UpServiceUpImgBean) message.obj).getPath());
        }
    }

    public CommentUpImageHolder(Context context, View view, String str) {
        super(context, view);
        this.o = new a();
        this.p = str;
        this.n = new b0(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(UpServiceUpImgBean.PathBean pathBean) {
        try {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.edit_picture_item_layout, (ViewGroup) null);
            ViewGroup.LayoutParams layoutParams = this.upApkUpImageAddPhoto.getLayoutParams();
            inflate.setLayoutParams(new ViewGroup.MarginLayoutParams(layoutParams.width, layoutParams.height));
            ImageView imageView = (ImageView) inflate.findViewById(R.id.edit_picture_img);
            ((ImageView) inflate.findViewById(R.id.edit_picture_delete)).setOnClickListener(this);
            imageView.setImageBitmap(this.k);
            t.c(this.a, pathBean.getUrl() + pathBean.getPic(), imageView, new boolean[0]);
            this.upApkUpImagePhotoLv.addView(inflate, this.upApkUpImagePhotoLv.getChildCount() + (-1));
            if (this.upApkUpImagePhotoLv.getChildCount() == 10) {
                this.upApkUpImagePhotoLv.removeView(this.upApkUpImageAddPhoto);
            }
        } catch (Exception e) {
            c0.u("CommentUpImageHolder", "上传图片设置已上传图片异常" + e);
            com.rtk.app.tool.f.a(this.a, "图片过大，请重新选择！", f.a.f);
        }
    }

    private void w() {
        this.n.show();
        List<String> list = this.l;
        if (list != null && list.size() > 0) {
            c0.u("CommentUpImageHolder", "上传图片的地址  " + this.l.get(0));
            this.m = new File(this.l.get(0));
            u();
            this.l.remove(0);
            return;
        }
        this.n.dismiss();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        c0.u("CommentUpImageHolder", "  图片上传   " + str);
        UpServiceUpImgBean upServiceUpImgBean = (UpServiceUpImgBean) create.fromJson(str, UpServiceUpImgBean.class);
        this.j.add(upServiceUpImgBean.getPath());
        Message message = new Message();
        message.what = 1;
        message.obj = upServiceUpImgBean;
        this.o.sendMessage(message);
        w();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (i2 != 1) {
            return;
        }
        if (str.contains("SocketTimeoutException")) {
            com.rtk.app.tool.f.a(this.a, "图片上传失败：链接服务器失败", f.a.f);
        } else {
            com.rtk.app.tool.f.a(this.a, "图片上传失败：" + str, f.a.f);
        }
        c0.u("CommentUpImageHolder", "  图片上传   " + str);
        w();
    }

    @Override // com.rtk.app.base.g
    public void h(Context context, View view) {
        this.upApkUpImageAddPhoto.setOnClickListener(this);
    }

    @Override // com.rtk.app.base.g
    public void i(Context context, View view) {
        ButterKnife.b(this, view);
        this.j = new ArrayList();
        if (this.upApkUpImagePhotoLv.getChildCount() > 1) {
            this.upApkUpImagePhotoLv.removeAllViews();
            this.upApkUpImagePhotoLv.addView(this.upApkUpImageAddPhoto);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != 2131297490) {
            if (id == 2131300703 && r.b(this.a) && this.j.size() < 9) {
                t.E1(this.a, 9 - this.j.size(), false);
                return;
            }
            return;
        }
        try {
            int indexOfChild = this.upApkUpImagePhotoLv.indexOfChild((View) view.getParent());
            c0.u("CommentUpImageHolder", " 删除的位置  position" + indexOfChild);
            this.j.remove(indexOfChild);
            this.upApkUpImagePhotoLv.removeViewAt(indexOfChild);
            FlowLayout parent = this.upApkUpImageAddPhoto.getParent();
            FlowLayout flowLayout = this.upApkUpImagePhotoLv;
            if (parent != flowLayout) {
                flowLayout.addView(this.upApkUpImageAddPhoto);
            }
        } catch (Exception unused) {
            c0.u("CommentUpImageHolder", "删除错误1");
        }
    }

    public String t() {
        int i = 0;
        String str = "";
        while (i < this.j.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(this.j.get(i).getPic());
            sb.append(i < this.j.size() + (-1) ? "|" : "");
            str = sb.toString();
            i++;
        }
        c0.u("CommentUpImageHolder", "上传图片  " + str);
        return str;
    }

    public void u() {
        h.v(this.a, new com.rtk.app.custom.RichEditText.a.f(y.K(), y.H(), MainActivity.p.getData().getLevel() + "", this, y.i + "html/filelist/uploadCommentImg", 1, this.m, this.p), true);
    }

    public void v(List<String> list) {
        this.l = list;
        w();
    }
}
