package com.rtk.app.custom.RichEditText;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.rtk.app.R;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.y;
import com.sigmob.sdk.base.mta.PointCategory;
import com.umeng.umcrash.UMCustomLogInfoBuilder;

/* compiled from: RichEditTextTool.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class g {
    public static String[] a = {"[game=", "[upfile=", "[post=", "[user=", "[img]", "[video="};

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(RichEditText richEditText, String str, int i) {
        String obj = richEditText.getEditableText().toString();
        String substring = obj.length() >= (str.length() + i) + 1 ? obj.substring((str.length() + i) - 1, str.length() + i) : "";
        if (c0.q(substring) || !substring.startsWith(UMCustomLogInfoBuilder.LINE_SEP)) {
            richEditText.getEditableText().insert(i + str.length(), UMCustomLogInfoBuilder.LINE_SEP);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    public static Bitmap b(RichEditText richEditText, Context context, String str, String str2) {
        char c2;
        int f = y.f(context) * 18;
        int f2 = y.f(context) * 9;
        int color = context.getResources().getColor(R.color.theme4);
        str.hashCode();
        switch (str.hashCode()) {
            case 67290:
                if (str.equals("@：")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 23936608:
                if (str.equals("帖子：")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 27959075:
                if (str.equals("游戏：")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 116578899:
                if (str.equals("UP资源：")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                color = context.getResources().getColor(R.color.theme4);
                break;
            case 1:
                color = context.getResources().getColor(R.color.theme2);
                break;
            case 2:
                color = context.getResources().getColor(R.color.theme1);
                break;
            case 3:
                color = context.getResources().getColor(R.color.theme3);
                break;
        }
        String str3 = str + str2;
        Paint paint = new Paint();
        float f3 = f;
        paint.setTextSize(f3);
        int P = (y.P(context, richEditText) - richEditText.getPaddingLeft()) - richEditText.getPaddingRight();
        int measureText = (int) paint.measureText(str3 + "  ");
        c0.u("RichEditTextTool", "  paintWidth   " + measureText + "    viewWidth   " + P);
        if (P > 0) {
            if (measureText < P) {
                P = measureText;
            }
            measureText = P;
        }
        Bitmap createBitmap = Bitmap.createBitmap(measureText, f + f2, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint2 = new Paint();
        Paint paint3 = new Paint();
        paint2.setColor(-1);
        paint3.setColor(color);
        paint2.setTextSize(f3);
        Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
        paint2.getFontMetrics(fontMetrics);
        int measureText2 = (int) paint2.measureText(str3);
        int i = (int) ((r0 / 2) - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f));
        float f4 = 0;
        canvas.drawRoundRect(new RectF(f4, f4, measureText + 0, r0 - 0), 10.0f, 10.0f, paint3);
        if (measureText2 > measureText) {
            canvas.drawText(str3.substring(0, measureText / (measureText2 / str3.length())) + "…", (measureText - ((int) paint2.measureText(r12))) / 2, i, paint2);
        } else {
            canvas.drawText(str3, (measureText - measureText2) / 2, i, paint2);
        }
        return createBitmap;
    }

    public static ResourceTypeBean c(String str, String str2) {
        char c2;
        char c3;
        try {
            ResourceTypeBean resourceTypeBean = new ResourceTypeBean();
            if (!str.endsWith("[/game]") && !str.endsWith("[/img]") && !str.endsWith("[/upfile]") && !str.endsWith("[/post]") && !str.endsWith("[/user]") && !str.endsWith("[/video]")) {
                if (!str2.startsWith("[game=") && !str2.startsWith("[img]") && !str2.startsWith("[upfile=") && !str2.startsWith("[post=") && !str2.startsWith("[user=") && !str2.startsWith("[video=")) {
                    return null;
                }
                int indexOf = str2.indexOf("]");
                int indexOf2 = str2.indexOf("=");
                int indexOf3 = str2.indexOf("[/");
                if (!str2.startsWith("[img]")) {
                    String substring = str2.substring(indexOf2 + 1, indexOf);
                    resourceTypeBean.setResourceName(str2.substring(indexOf + 1, indexOf3));
                    resourceTypeBean.setResourceid(substring);
                }
                String substring2 = str2.substring(1, 5);
                switch (substring2.hashCode()) {
                    case 3165170:
                        if (substring2.equals("game")) {
                            c3 = 0;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case 3236090:
                        if (substring2.equals("img]")) {
                            c3 = 4;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case 3446944:
                        if (substring2.equals("post")) {
                            c3 = 2;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case 3596446:
                        if (substring2.equals("upfi")) {
                            c3 = 1;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case 3599307:
                        if (substring2.equals("user")) {
                            c3 = 3;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case 3619444:
                        if (substring2.equals("vide")) {
                            c3 = 5;
                            break;
                        }
                        c3 = 65535;
                        break;
                    default:
                        c3 = 65535;
                        break;
                }
                if (c3 == 0) {
                    resourceTypeBean.setResourceType("game");
                } else if (c3 == 1) {
                    resourceTypeBean.setResourceType("upfile");
                } else if (c3 == 2) {
                    resourceTypeBean.setResourceType("post");
                } else if (c3 == 3) {
                    resourceTypeBean.setResourceType("user");
                } else if (c3 == 4) {
                    resourceTypeBean.setResourceType("img");
                } else {
                    if (c3 != 5) {
                        return null;
                    }
                    resourceTypeBean.setResourceType(PointCategory.VIDEO);
                }
                resourceTypeBean.setIsResource(true);
                resourceTypeBean.setIsStart(true);
                return resourceTypeBean;
            }
            String substring3 = str.substring(str.lastIndexOf("[/") + 2, str.length() - 1);
            switch (substring3.hashCode()) {
                case -838779241:
                    if (substring3.equals("upfile")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 104387:
                    if (substring3.equals("img")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3165170:
                    if (substring3.equals("game")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3446944:
                    if (substring3.equals("post")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3599307:
                    if (substring3.equals("user")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 112202875:
                    if (substring3.equals(PointCategory.VIDEO)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                resourceTypeBean.setResourceType("game");
            } else if (c2 == 1) {
                resourceTypeBean.setResourceType("upfile");
            } else if (c2 == 2) {
                resourceTypeBean.setResourceType("post");
            } else if (c2 == 3) {
                resourceTypeBean.setResourceType("user");
            } else if (c2 == 4) {
                resourceTypeBean.setResourceType("img");
            } else {
                if (c2 != 5) {
                    return null;
                }
                resourceTypeBean.setResourceType(PointCategory.VIDEO);
            }
            resourceTypeBean.setIsResource(true);
            resourceTypeBean.setIsStart(false);
            return resourceTypeBean;
        } catch (Exception e) {
            c0.u("RichEditTextTool", "异常" + e.toString());
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00dc, code lost:
    
        if (r1.equals("game") == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.rtk.app.custom.RichEditText.ResourceTypeBean d(java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.custom.RichEditText.g.d(java.lang.String):com.rtk.app.custom.RichEditText.ResourceTypeBean");
    }
}
