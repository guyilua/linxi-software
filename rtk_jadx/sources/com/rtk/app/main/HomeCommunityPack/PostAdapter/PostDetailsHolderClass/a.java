package com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsHolderClass;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.rtk.app.R;
import com.rtk.app.bean.DataBean;
import com.rtk.app.bean.ListPostImgBean;
import com.rtk.app.bean.ListPostPostBean;
import com.rtk.app.bean.ListPostUserBean;
import com.rtk.app.bean.ListPostVideoBean;
import com.rtk.app.bean.PostCommentAuditBean;
import com.rtk.app.bean.UpApkListBean;
import com.rtk.app.main.HomeCommunityPack.videoPack.VideoHolder;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.t;
import com.rtk.app.tool.v;
import com.rtk.app.tool.y;
import com.xiao.nicevideoplayer.VideoBean;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PostCreateViewTool.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    private static int a = 15;
    private static int b = 10;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f194c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PostCreateViewTool.java */
    /* renamed from: com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsHolderClass.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ViewOnClickListenerC0020a implements View.OnClickListener {
        final /* synthetic */ List a;
        final /* synthetic */ Context b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f195c;

        ViewOnClickListenerC0020a(List list, Context context, int i) {
            this.a = list;
            this.b = context;
            this.f195c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.a.size(); i++) {
                arrayList.add(((ListPostImgBean) this.a.get(i)).getPic());
            }
            t.C0(this.b, arrayList, this.f195c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PostCreateViewTool.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class b implements View.OnClickListener {
        final /* synthetic */ List a;
        final /* synthetic */ Context b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f196c;

        b(List list, Context context, int i) {
            this.a = list;
            this.b = context;
            this.f196c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.a.size(); i++) {
                arrayList.add(((ListPostImgBean) this.a.get(i)).getPic());
            }
            t.C0(this.b, arrayList, this.f196c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PostCreateViewTool.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class c implements View.OnClickListener {
        final /* synthetic */ List a;
        final /* synthetic */ Context b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f197c;

        c(List list, Context context, int i) {
            this.a = list;
            this.b = context;
            this.f197c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.a.size(); i++) {
                arrayList.add(((ListPostImgBean) this.a.get(i)).getPic());
            }
            t.C0(this.b, arrayList, this.f197c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PostCreateViewTool.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class d implements View.OnClickListener {
        final /* synthetic */ Context a;
        final /* synthetic */ DataBean b;

        d(Context context, DataBean dataBean) {
            this.a = context;
            this.b = dataBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t.e0(this.a, new ApkInfo(this.b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PostCreateViewTool.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class e implements View.OnClickListener {
        final /* synthetic */ Context a;
        final /* synthetic */ UpApkListBean.DataBean b;

        e(Context context, UpApkListBean.DataBean dataBean) {
            this.a = context;
            this.b = dataBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t.X0(this.a, new ApkInfo(this.b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PostCreateViewTool.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class f implements View.OnClickListener {
        final /* synthetic */ Context a;
        final /* synthetic */ ListPostPostBean b;

        f(Context context, ListPostPostBean listPostPostBean) {
            this.a = context;
            this.b = listPostPostBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t.J0(this.a, this.b.getId() + "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PostCreateViewTool.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class g implements View.OnClickListener {
        final /* synthetic */ Context a;
        final /* synthetic */ ListPostUserBean b;

        g(Context context, ListPostUserBean listPostUserBean) {
            this.a = context;
            this.b = listPostUserBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t.B0(this.a, this.b.getUid() + "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PostCreateViewTool.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class h extends ClickableSpan {
        final /* synthetic */ URLSpan a;
        final /* synthetic */ Context b;

        h(URLSpan uRLSpan, Context context) {
            this.a = uRLSpan;
            this.b = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            c0.u("PostCreateViewTool", "点击了setLinkClickable()  " + this.a.getURL());
            if (this.a.getURL().endsWith(".apk")) {
                ((Activity) this.b).startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.a.getURL())));
            } else {
                t.L0(this.b, this.a.getURL());
            }
        }
    }

    private static View a(Context context, DataBean dataBean) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i = a;
        layoutParams.bottomMargin = i;
        layoutParams.topMargin = i;
        View inflate = LayoutInflater.from(context).inflate(R.layout.post_game_item_layout, (ViewGroup) null);
        inflate.setLayoutParams(layoutParams);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.test_post_game_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.test_post_game_name);
        t.c(context, dataBean.getGame_logo(), imageView, new boolean[0]);
        textView.setText(dataBean.getGame_name());
        inflate.setOnClickListener(new d(context, dataBean));
        return inflate;
    }

    private static ImageView b(Context context, List<ListPostImgBean> list, int i) {
        ImageView imageView = (ImageView) LayoutInflater.from(context).inflate(R.layout.test_post_create_img_layout, (ViewGroup) null);
        try {
            if (list.get(i).getWidth() + (y.f(context) * 20) > 480) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(t.b0(), (int) (list.get(i).getHeight() * ((t.b0() - r2) / list.get(i).getWidth())));
                layoutParams.gravity = 1;
                imageView.setPadding(y.f(context) * 10, 0, y.f(context) * 10, 0);
                int i2 = a;
                layoutParams.bottomMargin = i2;
                layoutParams.topMargin = i2;
                imageView.setLayoutParams(layoutParams);
            } else {
                double b0 = t.b0() / 480;
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams((int) (list.get(i).getWidth() * b0), (int) (list.get(i).getHeight() * b0));
                layoutParams2.gravity = 1;
                int i3 = a;
                layoutParams2.bottomMargin = i3;
                layoutParams2.topMargin = i3;
                imageView.setLayoutParams(layoutParams2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        c0.u("PostCreateViewTool", "创建图片地址    " + list.get(i).getPic());
        t.c(context, list.get(i).getThumb(), imageView, new boolean[0]);
        imageView.setOnClickListener(new b(list, context, i));
        return imageView;
    }

    private static ImageView c(int i, Context context, List<ListPostImgBean> list, int i2) {
        ImageView imageView = (ImageView) LayoutInflater.from(context).inflate(R.layout.test_post_create_img_layout, (ViewGroup) null);
        try {
            int f2 = y.f(context) * 20;
            if (i > 0) {
                if (list.get(i2).getWidth() + f2 <= i && list.get(i2).getWidth() + f2 < 480) {
                    double d2 = (480 - f2) / (i - f2);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) (list.get(i2).getWidth() / d2), (int) (list.get(i2).getHeight() / d2));
                    int i3 = a;
                    layoutParams.bottomMargin = i3;
                    layoutParams.topMargin = i3;
                    layoutParams.gravity = 1;
                    imageView.setLayoutParams(layoutParams);
                }
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, (int) ((list.get(i2).getHeight() * (i - f2)) / list.get(i2).getWidth()));
                int i4 = a;
                layoutParams2.bottomMargin = i4;
                layoutParams2.topMargin = i4;
                imageView.setLayoutParams(layoutParams2);
                layoutParams2.gravity = 1;
                imageView.setPadding(y.f(context) * 10, 0, y.f(context) * 10, 0);
                imageView.setLayoutParams(layoutParams2);
            } else {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(list.get(i2).getWidth(), list.get(i2).getHeight());
                layoutParams3.gravity = 1;
                int i5 = a;
                layoutParams3.bottomMargin = i5;
                layoutParams3.topMargin = i5;
                imageView.setLayoutParams(layoutParams3);
            }
        } catch (Exception e2) {
            c0.u("PostCreateViewTool", "高度异常");
            e2.printStackTrace();
        }
        t.c(context, list.get(i2).getThumb(), imageView, new boolean[0]);
        imageView.setOnClickListener(new c(list, context, i2));
        return imageView;
    }

    private static void d(Context context, LinearLayout linearLayout, List<ListPostImgBean> list) {
        LinearLayout linearLayout2 = null;
        for (int i = 0; i < list.size(); i++) {
            int i2 = i % 3;
            if (i2 == 0) {
                linearLayout2 = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.post_create_img_linearlayout_layout, (ViewGroup) null);
            }
            ImageView imageView = (ImageView) LayoutInflater.from(context).inflate(v.a(context, v.j) ? R.layout.post_create_night_original_img_layout : R.layout.post_create_night_img_layout, (ViewGroup) null);
            c0.u("PostCreateViewTool", "当前屏幕宽高" + t.b0());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams.leftMargin = 3;
            layoutParams.rightMargin = 3;
            layoutParams.topMargin = 3;
            layoutParams.bottomMargin = 3;
            imageView.setLayoutParams(layoutParams);
            t.c(context, list.get(i).getThumb(), imageView, new boolean[0]);
            imageView.setOnClickListener(new ViewOnClickListenerC0020a(list, context, i));
            linearLayout2.addView(imageView);
            if (i2 == 0 && linearLayout2 != null) {
                linearLayout.addView(linearLayout2);
            }
        }
    }

    private static View e(Context context, ListPostPostBean listPostPostBean) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.test_post_create_post_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.test_post_create_post_title);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i = b;
        layoutParams.bottomMargin = i;
        layoutParams.topMargin = i;
        inflate.setLayoutParams(layoutParams);
        textView.setText(listPostPostBean.getTitle());
        inflate.setOnClickListener(new f(context, listPostPostBean));
        return inflate;
    }

    public static TextView f(Context context, String str) {
        TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.test_post_create_textview_layout, (ViewGroup) null);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(Html.fromHtml(str));
        textView.setText(k(context, (Spanned) textView.getText()));
        return textView;
    }

    public static TextView g(Context context) {
        TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.test_post_create_textview_layout, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i = a;
        layoutParams.bottomMargin = i;
        layoutParams.topMargin = i;
        textView.setLayoutParams(layoutParams);
        textView.setText("此内容需要最新版本APP才可显示，请升级APP");
        textView.setTextSize(30.0f);
        textView.setTextColor(context.getResources().getColor(R.color.theme26));
        return textView;
    }

    private static View h(Context context, UpApkListBean.DataBean dataBean) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i = a;
        layoutParams.bottomMargin = i;
        layoutParams.topMargin = i;
        View inflate = LayoutInflater.from(context).inflate(R.layout.post_game_item_layout, (ViewGroup) null);
        inflate.setLayoutParams(layoutParams);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.test_post_game_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.test_post_game_name);
        t.c(context, dataBean.getSourceLogo(), imageView, new boolean[0]);
        textView.setText(dataBean.getVarName());
        inflate.setOnClickListener(new e(context, dataBean));
        return inflate;
    }

    private static TextView i(Context context, ListPostUserBean listPostUserBean) {
        TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.test_post_create_user_textview_layout, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i = b;
        layoutParams.bottomMargin = i;
        layoutParams.topMargin = i;
        textView.setLayoutParams(layoutParams);
        textView.setText("@用户：" + listPostUserBean.getNickname());
        textView.setTextColor(context.getResources().getColor(R.color.theme1));
        textView.setOnClickListener(new g(context, listPostUserBean));
        return textView;
    }

    public static View j(Context context, List<ListPostVideoBean> list, int i) {
        c0.u("PostCreateViewTool", "创建视频视图");
        View inflate = LayoutInflater.from(context).inflate(R.layout.test_post_create_video_view_layout, (ViewGroup) null);
        new VideoHolder(inflate, new VideoBean("", list.get(i).getLogo(), list.get(i).getPath()));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) ((t.b0() / 16.0d) * 9.0d));
        int i2 = b;
        layoutParams.bottomMargin = i2;
        layoutParams.topMargin = i2;
        layoutParams.gravity = 17;
        inflate.setLayoutParams(layoutParams);
        return inflate;
    }

    private static SpannableStringBuilder k(Context context, Spanned spanned) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spanned);
        for (URLSpan uRLSpan : (URLSpan[]) spannableStringBuilder.getSpans(0, spanned.length(), URLSpan.class)) {
            r(context, spannableStringBuilder, uRLSpan);
        }
        return spannableStringBuilder;
    }

    public static boolean l() {
        return f194c;
    }

    public static String m(String str) {
        return str.replaceAll("<br><br><br><br><br>", "<br>").replaceAll("<br><br><br><br>", "<br>").replaceAll("<br><br><br>", "<br>").replaceAll("<br><br>", "<br>");
    }

    public static void n(Context context, LinearLayout linearLayout, String str, List<ListPostUserBean> list, List<ListPostPostBean> list2, List<PostCommentAuditBean.ConvDataBean.ListPostUpfileBean> list3, List<PostCommentAuditBean.ConvDataBean.ListPostGameBean> list4, List<ListPostImgBean> list5) {
        char c2;
        int i = 0;
        String str2 = str;
        for (int i2 = 0; i2 < list5.size(); i2++) {
            try {
                str2 = str2.replaceAll("<@--imgRTK" + i2 + "-->", "");
            } catch (Exception unused) {
            }
        }
        if (v.a(context, v.i)) {
            str2 = m(str2);
        }
        linearLayout.removeAllViews();
        String str3 = str2;
        while (str3.length() > 0) {
            int indexOf = str3.indexOf("<@--");
            if (indexOf > 0) {
                try {
                    linearLayout.addView(f(context, str3.substring(i, indexOf - 1)));
                } catch (Exception e2) {
                    c0.u("PostCreateViewTool", "initData()异常" + e2);
                }
                str3 = str3.substring(indexOf);
                i = 0;
            } else {
                if (str3.contains("<@--")) {
                    int indexOf2 = str3.indexOf("-->") + 3;
                    int indexOf3 = str3.indexOf("RTK");
                    String substring = str3.substring(4, indexOf3);
                    int parseInt = Integer.parseInt(str3.substring(indexOf3 + 3, indexOf2 - 3));
                    try {
                        switch (substring.hashCode()) {
                            case -838779241:
                                if (substring.equals("upfile")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 104387:
                                if (substring.equals("img")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case 3165170:
                                if (substring.equals("game")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case 3446944:
                                if (substring.equals("post")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case 3599307:
                                if (substring.equals("user")) {
                                    c2 = 4;
                                    break;
                                }
                                break;
                        }
                        c2 = 65535;
                        if (c2 == 0) {
                            DataBean dataBean = new DataBean();
                            dataBean.setGame_id(list4.get(parseInt).getId());
                            dataBean.setGame_name(list4.get(parseInt).getGame_name());
                            dataBean.setPackage_name(list4.get(parseInt).getPackageName());
                            dataBean.setGame_logo(list4.get(parseInt).getGame_logo());
                            dataBean.setPackage_size(list4.get(parseInt).getPackage_size());
                            dataBean.setSignaturesMD5(list4.get(parseInt).getSignaturesMD5());
                            dataBean.setVersion_code(list4.get(parseInt).getVersion_code());
                            dataBean.setDownlist(list4.get(parseInt).getDownlist());
                            dataBean.setIs_apk(list4.get(parseInt).getIsapk());
                            linearLayout.addView(a(context, dataBean));
                        } else if (c2 == 1) {
                            UpApkListBean.DataBean dataBean2 = new UpApkListBean.DataBean();
                            dataBean2.setId(list3.get(parseInt).getId());
                            dataBean2.setVarName(list3.get(parseInt).getVarName());
                            dataBean2.setPackageName(list3.get(parseInt).getPackageName());
                            dataBean2.setSourceLogo(list3.get(parseInt).getSourceLogo());
                            dataBean2.setSourceSize(list3.get(parseInt).getSourceSize());
                            dataBean2.setMd5(list3.get(parseInt).getMd5());
                            dataBean2.setVersionCode(list3.get(parseInt).getVersionCode());
                            linearLayout.addView(h(context, dataBean2));
                        } else if (c2 == 3) {
                            try {
                                linearLayout.addView(e(context, list2.get(parseInt)));
                            } catch (Exception e3) {
                                e = e3;
                                c0.u("PostCreateViewTool", "initData()异常1" + e);
                                indexOf = indexOf2;
                                str3 = str3.substring(indexOf);
                                i = 0;
                            }
                        } else if (c2 == 4) {
                            list.get(parseInt).setUid(list.get(parseInt).getId());
                            linearLayout.addView(i(context, list.get(parseInt)));
                        }
                    } catch (Exception e4) {
                        e = e4;
                    }
                    indexOf = indexOf2;
                } else {
                    try {
                        linearLayout.addView(f(context, str3));
                        d(context, linearLayout, list5);
                    } catch (Exception e5) {
                        c0.u("PostCreateViewTool", "initData()异常1" + e5);
                    }
                }
                str3 = str3.substring(indexOf);
                i = 0;
            }
            d(context, linearLayout, list5);
        }
        d(context, linearLayout, list5);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:34:0x00b0. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0185  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void o(android.content.Context r16, android.widget.LinearLayout r17, java.lang.String r18, java.util.List<com.rtk.app.bean.ListPostUserBean> r19, java.util.List<com.rtk.app.bean.ListPostPostBean> r20, java.util.List<com.rtk.app.bean.UpApkListBean.DataBean> r21, java.util.List<com.rtk.app.bean.DataBean> r22, java.util.List<com.rtk.app.bean.ListPostImgBean> r23, java.util.List<com.rtk.app.bean.ListPostVideoBean> r24) {
        /*
            Method dump skipped, instructions count: 528
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsHolderClass.a.o(android.content.Context, android.widget.LinearLayout, java.lang.String, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:34:0x00ae. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void p(android.content.Context r16, android.widget.LinearLayout r17, java.lang.String r18, java.util.List<com.rtk.app.bean.ListPostUserBean> r19, java.util.List<com.rtk.app.bean.ListPostPostBean> r20, java.util.List<com.rtk.app.bean.UpApkListBean.DataBean> r21, java.util.List<com.rtk.app.bean.DataBean> r22, java.util.List<com.rtk.app.bean.ListPostImgBean> r23) {
        /*
            Method dump skipped, instructions count: 460
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsHolderClass.a.p(android.content.Context, android.widget.LinearLayout, java.lang.String, java.util.List, java.util.List, java.util.List, java.util.List, java.util.List):void");
    }

    public static void q(boolean z) {
        f194c = z;
    }

    private static void r(Context context, SpannableStringBuilder spannableStringBuilder, URLSpan uRLSpan) {
        spannableStringBuilder.setSpan(new h(uRLSpan, context), spannableStringBuilder.getSpanStart(uRLSpan), spannableStringBuilder.getSpanEnd(uRLSpan), spannableStringBuilder.getSpanFlags(uRLSpan));
    }
}
