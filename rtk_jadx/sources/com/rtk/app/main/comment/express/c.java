package com.rtk.app.main.comment.express;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.rtk.app.R;
import com.rtk.app.main.MyApplication;
import com.rtk.app.tool.c0;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: SmileyParser.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c {
    private static c f;
    public static final int[] g = {R.drawable.am, R.drawable.aw, R.drawable.bhb, R.drawable.bz, R.drawable.ch, R.drawable.dbq, R.drawable.dk, R.drawable.fd, R.drawable.gg, R.drawable.gl, R.drawable.gxfc, R.drawable.gz, R.drawable.hc, R.drawable.hj, R.drawable.hl, R.drawable.hx, R.drawable.jiayou, R.drawable.jinya, R.drawable.kl, R.drawable.lcx, R.drawable.mg, R.drawable.ok, R.drawable.q, R.drawable.qq, R.drawable.se, R.drawable.sj, R.drawable.sk, R.drawable.sq, R.drawable.sx, R.drawable.tst, R.drawable.tx, R.drawable.wl, R.drawable.wq, R.drawable.wx, R.drawable.xe, R.drawable.xv, R.drawable.yun, R.drawable.yw, R.drawable.zj};
    private final Context a;
    public String[] b;

    /* renamed from: c, reason: collision with root package name */
    public String[] f230c;
    private final Pattern d;
    private Map<String, Integer> e;

    private c(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = applicationContext.getResources().getStringArray(R.array.custom_smiley_texts);
        this.f230c = applicationContext.getResources().getStringArray(R.array.caicai_smiley_texts);
        this.e = d();
        this.d = c();
    }

    private Pattern c() {
        StringBuilder sb = new StringBuilder((this.b.length + this.f230c.length) * 3);
        sb.append('(');
        for (String str : this.b) {
            sb.append(Pattern.quote(str));
            sb.append('|');
        }
        for (String str2 : this.f230c) {
            sb.append(Pattern.quote(str2));
            sb.append('|');
        }
        sb.replace(sb.length() - 1, sb.length(), ")");
        return Pattern.compile(sb.toString());
    }

    private Map<String, Integer> d() {
        if (g.length == this.f230c.length) {
            HashMap hashMap = new HashMap();
            int i = 0;
            while (true) {
                String[] strArr = this.f230c;
                if (i >= strArr.length) {
                    return hashMap;
                }
                hashMap.put(strArr[i], Integer.valueOf(g[i]));
                i++;
            }
        } else {
            c0.s("SmileyParser", "ID和图片不匹配");
            throw new IllegalStateException("ID和图片不匹配");
        }
    }

    public static int e(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 <= i2 && i4 <= i) {
            return 1;
        }
        int round = Math.round(i3 / i2);
        int round2 = Math.round(i4 / i);
        return round < round2 ? round : round2;
    }

    public static Bitmap f(Resources resources, int i, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inDensity = resources.getDisplayMetrics().densityDpi;
        BitmapFactory.decodeResource(resources, i, options);
        options.inSampleSize = e(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i, options);
    }

    public static c g() {
        if (f == null) {
            f = new c(MyApplication.b().getApplicationContext());
        }
        return f;
    }

    public CharSequence a(CharSequence charSequence) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        Matcher matcher = this.d.matcher(charSequence);
        while (matcher.find()) {
            String group = matcher.group();
            c0.r("SmileyParser", "matcher:" + group);
            Integer num = this.e.get(group);
            if (num == null) {
                return spannableStringBuilder;
            }
            spannableStringBuilder.setSpan(new ImageSpan(this.a, num.intValue()), matcher.start(), matcher.end(), 33);
        }
        return spannableStringBuilder;
    }

    public CharSequence b(CharSequence charSequence, int i, int i2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        Matcher matcher = this.d.matcher(charSequence);
        while (matcher.find()) {
            int intValue = this.e.get(matcher.group()).intValue();
            Context context = this.a;
            spannableStringBuilder.setSpan(new ImageSpan(context, f(context.getResources(), intValue, d.a(this.a, i), d.a(this.a, i2))), matcher.start(), matcher.end(), 33);
        }
        return spannableStringBuilder;
    }
}
