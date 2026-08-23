package com.sigmob.sdk.mraid;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.mraid.j;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class o extends j implements j.a, com.sigmob.sdk.videocache.d {

    /* renamed from: c, reason: collision with root package name */
    public static final int f571c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static final int g = 4;
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;
    public static final int k = 4;
    public static final int l = 8;
    private m m;
    private String n;
    private a o;

    /* renamed from: com.sigmob.sdk.mraid.o$2, reason: invalid class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.sigmob.sdk.videoplayer.e.values().length];
            a = iArr;
            try {
                iArr[com.sigmob.sdk.videoplayer.e.STATE_PREPARED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.e.STATE_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.e.STATE_PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.e.STATE_PLAYING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.e.STATE_AUTO_COMPLETE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.e.STATE_PREPARING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.e.STATE_BUFFERING_START.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.e.STATE_BUFFERING_END.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.e.STATE_STOP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a(String str, int i);

        void a(String str, int i, String str2);

        void a(String str, long j);

        void a(String str, long j, int i, int i2);

        void a(String str, long j, long j2);

        void b(String str, int i);
    }

    public o(String str) {
        super(str);
    }

    private void a(String str, String str2) {
        Uri parse = Uri.parse(str2);
        if (parse == null || !"127.0.0.1".equalsIgnoreCase(parse.getHost())) {
            return;
        }
        Matcher matcher = Pattern.compile("/(.*)").matcher(parse.getPath());
        if (matcher.find()) {
            this.n = matcher.group(1);
            com.sigmob.sdk.base.common.h.d().a(this, this.n);
        }
    }

    @Override // com.sigmob.sdk.mraid.j.a
    public void a(Context context, JSONObject jSONObject) {
        m mVar = new m(context);
        this.m = mVar;
        mVar.setVideoPlayerStatusListener(new com.sigmob.sdk.videoplayer.l() { // from class: com.sigmob.sdk.mraid.o.1
            @Override // com.sigmob.sdk.videoplayer.l
            public void a(long j2, long j3) {
                if (o.this.o != null) {
                    o.this.o.a(o.this.a, j2, j3);
                }
            }

            @Override // com.sigmob.sdk.videoplayer.l
            public void a(com.sigmob.sdk.videoplayer.e eVar) {
                a aVar;
                String str;
                SigmobLog.d("VIDEO_PLAYER_STATE change: " + eVar);
                int i2 = 1;
                switch (AnonymousClass2.a[eVar.ordinal()]) {
                    case 1:
                        if (o.this.o != null) {
                            o.this.o.a(o.this.a, o.this.m.getDuration(), o.this.m.getVideoWidth(), o.this.m.getVideoHeight());
                        }
                        if (o.this.o != null) {
                            o.this.o.b(o.this.a, 2);
                        }
                        if (o.this.o != null) {
                            o.this.o.b(o.this.a, 4);
                            return;
                        }
                        return;
                    case 2:
                        if (o.this.o != null) {
                            o.this.o.a(o.this.a, o.this.m.getErrorCode(), o.this.m.getErrorMessage());
                            return;
                        }
                        return;
                    case 3:
                        if (o.this.o != null) {
                            o.this.o.a(o.this.a, 2);
                            return;
                        }
                        return;
                    case 4:
                        if (o.this.o != null) {
                            o.this.o.a(o.this.a, 1);
                            return;
                        }
                        return;
                    case 5:
                        if (o.this.o != null) {
                            a aVar2 = o.this.o;
                            o oVar = o.this;
                            aVar2.a(oVar.a, oVar.m.getDuration(), o.this.m.getDuration());
                            a aVar3 = o.this.o;
                            o oVar2 = o.this;
                            aVar3.a(oVar2.a, oVar2.m.getDuration());
                            return;
                        }
                        return;
                    case 6:
                        if (o.this.o != null) {
                            aVar = o.this.o;
                            str = o.this.a;
                            break;
                        } else {
                            return;
                        }
                    case 7:
                        if (o.this.o != null) {
                            o.this.m.j();
                            aVar = o.this.o;
                            str = o.this.a;
                            i2 = 8;
                            break;
                        } else {
                            return;
                        }
                    case 8:
                        if (o.this.o != null) {
                            o.this.m.d();
                            o.this.o.b(o.this.a, 2);
                            return;
                        }
                        return;
                    case 9:
                        if (o.this.o != null) {
                            o.this.o.a(o.this.a, 4);
                            return;
                        }
                        return;
                    default:
                        return;
                }
                aVar.b(str, i2);
            }
        });
    }

    public void a(a aVar) {
        this.o = aVar;
    }

    @Override // com.sigmob.sdk.videocache.d
    public void a(File file, String str, int i2) {
    }

    @Override // com.sigmob.sdk.videocache.d
    public void a(String str, Throwable th) {
        SigmobLog.e("url", th);
        a aVar = this.o;
        if (aVar != null) {
            aVar.a(this.a, 0, th.getMessage());
        }
    }

    @Override // com.sigmob.sdk.mraid.j.a
    public void a(JSONObject jSONObject) {
        if (this.m != null) {
            String optString = jSONObject.optString("URL");
            if (jSONObject.optBoolean("proxy", false) && !TextUtils.isEmpty(optString) && optString.startsWith("http")) {
                Uri parse = Uri.parse(optString);
                if (parse != null && !"127.0.0.1".equalsIgnoreCase(parse.getHost())) {
                    optString = com.sigmob.sdk.base.common.h.d().a(optString);
                }
                a(this.a, optString);
            }
            this.m.setUp(optString);
            this.m.n();
        }
    }

    @Override // com.sigmob.sdk.mraid.j
    public View b() {
        return this.m;
    }

    @Override // com.sigmob.sdk.mraid.j.a
    public void b(JSONObject jSONObject) {
        m mVar = this.m;
        if (mVar != null) {
            mVar.d();
        }
    }

    @Override // com.sigmob.sdk.mraid.j
    public void c() {
        m mVar = this.m;
        if (mVar != null) {
            com.sigmob.sdk.base.utils.f.a(mVar);
            this.m.removeAllViews();
            this.m.r();
            this.m = null;
        }
        if (this.n != null) {
            com.sigmob.sdk.base.common.h.d().b(this, this.n);
        }
    }

    @Override // com.sigmob.sdk.mraid.j.a
    public void c(JSONObject jSONObject) {
        m mVar = this.m;
        if (mVar != null) {
            mVar.a(0);
            this.m.d();
        }
    }

    @Override // com.sigmob.sdk.mraid.j.a
    public void d(JSONObject jSONObject) {
        m mVar = this.m;
        if (mVar != null) {
            mVar.j();
        }
    }

    @Override // com.sigmob.sdk.mraid.j.a
    public void e(JSONObject jSONObject) {
        m mVar = this.m;
        if (mVar != null) {
            mVar.i();
        }
    }

    @Override // com.sigmob.sdk.mraid.j.a
    public void f(JSONObject jSONObject) {
        if (this.m != null) {
            this.m.setMute(jSONObject.optBoolean("muted", false));
        }
    }

    @Override // com.sigmob.sdk.mraid.j.a
    public void g(JSONObject jSONObject) {
        if (this.m != null) {
            this.m.a(((int) jSONObject.optDouble("seekTime", 0.0d)) * 1000);
        }
    }

    @Override // com.sigmob.sdk.mraid.j.a
    public void h(JSONObject jSONObject) {
        if (this.m != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("frame");
            int optDouble = (int) optJSONObject.optDouble("x", 0.0d);
            int optDouble2 = (int) optJSONObject.optDouble("y", 0.0d);
            int optDouble3 = (int) optJSONObject.optDouble("w", -1.0d);
            int optDouble4 = (int) optJSONObject.optDouble("h", -1.0d);
            if (optDouble3 > 0) {
                optDouble3 = Dips.dipsToIntPixels(optDouble3, com.sigmob.sdk.b.e());
            }
            if (optDouble4 > 0) {
                optDouble4 = Dips.dipsToIntPixels(optDouble4, com.sigmob.sdk.b.e());
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(optDouble3, optDouble4);
            this.m.setX(Dips.dipsToIntPixels(optDouble, com.sigmob.sdk.b.e()));
            this.m.setY(Dips.dipsToIntPixels(optDouble2, com.sigmob.sdk.b.e()));
            this.m.setLayoutParams(layoutParams);
            this.m.requestLayout();
        }
    }
}
