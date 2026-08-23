package com.rtk.app.custom.RichEditText;

import android.text.Layout;
import android.text.Spanned;
import android.text.TextDirectionHeuristics;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.ParagraphStyle;
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import com.rtk.app.tool.c0;
import com.umeng.analytics.pro.ak;

/* compiled from: CustomHtml.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {
    private static void a(StringBuilder sb, Spanned spanned, int i) {
        c0.u("CustomHtml", "encodeTextAlignmentByDiv原始数据" + ((Object) spanned));
        int length = spanned.length();
        int i2 = 0;
        while (i2 < length) {
            int nextSpanTransition = spanned.nextSpanTransition(i2, length, ParagraphStyle.class);
            ParagraphStyle[] paragraphStyleArr = (ParagraphStyle[]) spanned.getSpans(i2, nextSpanTransition, ParagraphStyle.class);
            String str = " ";
            boolean z = false;
            for (int i3 = 0; i3 < paragraphStyleArr.length; i3++) {
                if (paragraphStyleArr[i3] instanceof AlignmentSpan) {
                    Layout.Alignment alignment = ((AlignmentSpan) paragraphStyleArr[i3]).getAlignment();
                    if (alignment == Layout.Alignment.ALIGN_CENTER) {
                        str = "align=\"center\" " + str;
                    } else if (alignment == Layout.Alignment.ALIGN_OPPOSITE) {
                        str = "align=\"right\" " + str;
                    } else {
                        str = "align=\"left\" " + str;
                    }
                    z = true;
                }
            }
            if (z) {
                sb.append("<div ");
                sb.append(str);
                sb.append(">");
            }
            h(sb, spanned, i2, nextSpanTransition, i);
            if (z) {
                sb.append("</div>");
            }
            i2 = nextSpanTransition;
        }
    }

    private static String b(Spanned spanned, int i, int i2) {
        return TextDirectionHeuristics.FIRSTSTRONG_LTR.isRtl(spanned, i, i2 - i) ? " dir=\"rtl\"" : " dir=\"ltr\"";
    }

    private static String c(Spanned spanned, int i, int i2, boolean z, boolean z2) {
        String str = null;
        String str2 = z ? "margin-top:0; margin-bottom:0;" : null;
        if (z2) {
            AlignmentSpan[] alignmentSpanArr = (AlignmentSpan[]) spanned.getSpans(i, i2, AlignmentSpan.class);
            int length = alignmentSpanArr.length - 1;
            while (true) {
                if (length < 0) {
                    break;
                }
                AlignmentSpan alignmentSpan = alignmentSpanArr[length];
                if ((spanned.getSpanFlags(alignmentSpan) & 51) == 51) {
                    Layout.Alignment alignment = alignmentSpan.getAlignment();
                    if (alignment == Layout.Alignment.ALIGN_NORMAL) {
                        str = "text-align:start;";
                    } else if (alignment == Layout.Alignment.ALIGN_CENTER) {
                        str = "text-align:center;";
                    } else if (alignment == Layout.Alignment.ALIGN_OPPOSITE) {
                        str = "text-align:end;";
                    }
                } else {
                    length--;
                }
            }
        }
        if (str2 == null && str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(" style=\"");
        if (str2 != null && str != null) {
            sb.append(str2);
            sb.append(" ");
            sb.append(str);
        } else if (str2 != null) {
            sb.append(str2);
        } else if (str != null) {
            sb.append(str);
        }
        sb.append("\"");
        return sb.toString();
    }

    public static String d(Spanned spanned, int i) {
        StringBuilder sb = new StringBuilder();
        i(sb, spanned, i);
        return sb.toString();
    }

    private static void e(StringBuilder sb, Spanned spanned, int i, int i2, int i3) {
        if ((i3 & 1) == 0) {
            f(sb, spanned, i, i2);
        } else {
            g(sb, spanned, i, i2);
        }
    }

    private static void f(StringBuilder sb, Spanned spanned, int i, int i2) {
        while (i < i2) {
            int indexOf = TextUtils.indexOf((CharSequence) spanned, '\n', i, i2);
            if (indexOf < 0) {
                indexOf = i2;
            }
            int i3 = 0;
            boolean z = true;
            if (indexOf >= i2 || spanned.charAt(indexOf) != '\n') {
                z = false;
            } else {
                indexOf++;
                i3 = 1;
            }
            j(sb, spanned, i, indexOf - i3);
            if (z) {
                sb.append("<br>");
            }
            i = indexOf;
        }
    }

    private static void g(StringBuilder sb, Spanned spanned, int i, int i2) {
        boolean z;
        boolean z2 = false;
        while (i <= i2) {
            int indexOf = TextUtils.indexOf((CharSequence) spanned, '\n', i, i2);
            if (indexOf < 0) {
                indexOf = i2;
            }
            if (indexOf == i) {
                if (z2) {
                    sb.append("</ul>\n");
                    z2 = false;
                }
                sb.append("<br>\n");
            } else {
                ParagraphStyle[] paragraphStyleArr = (ParagraphStyle[]) spanned.getSpans(i, indexOf, ParagraphStyle.class);
                int length = paragraphStyleArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z = false;
                        break;
                    }
                    ParagraphStyle paragraphStyle = paragraphStyleArr[i3];
                    if ((spanned.getSpanFlags(paragraphStyle) & 51) == 51 && (paragraphStyle instanceof BulletSpan)) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (z && !z2) {
                    sb.append("<ul");
                    sb.append(c(spanned, i, indexOf, true, false));
                    sb.append(">\n");
                    z2 = true;
                }
                if (z2 && !z) {
                    sb.append("</ul>\n");
                    z2 = false;
                }
                String str = z ? "li" : ak.ax;
                sb.append("<");
                sb.append(str);
                sb.append(b(spanned, i, indexOf));
                sb.append(c(spanned, i, indexOf, !z, true));
                sb.append(">");
                j(sb, spanned, i, indexOf);
                sb.append("</");
                sb.append(str);
                sb.append(">\n");
                if (indexOf == i2 && z2) {
                    sb.append("</ul>\n");
                    z2 = false;
                }
            }
            i = indexOf + 1;
        }
    }

    private static void h(StringBuilder sb, Spanned spanned, int i, int i2, int i3) {
        while (i < i2) {
            int nextSpanTransition = spanned.nextSpanTransition(i, i2, QuoteSpan.class);
            QuoteSpan[] quoteSpanArr = (QuoteSpan[]) spanned.getSpans(i, nextSpanTransition, QuoteSpan.class);
            for (QuoteSpan quoteSpan : quoteSpanArr) {
                sb.append("<blockquote>");
            }
            e(sb, spanned, i, nextSpanTransition, i3);
            for (QuoteSpan quoteSpan2 : quoteSpanArr) {
                sb.append("</blockquote>\n");
            }
            i = nextSpanTransition;
        }
    }

    private static void i(StringBuilder sb, Spanned spanned, int i) {
        if ((i & 1) == 0) {
            a(sb, spanned, i);
        } else {
            h(sb, spanned, 0, spanned.length(), i);
        }
    }

    private static void j(StringBuilder sb, Spanned spanned, int i, int i2) {
        String str;
        while (i < i2) {
            int nextSpanTransition = spanned.nextSpanTransition(i, i2, CharacterStyle.class);
            CharacterStyle[] characterStyleArr = (CharacterStyle[]) spanned.getSpans(i, nextSpanTransition, CharacterStyle.class);
            ForegroundColorSpan foregroundColorSpan = null;
            AbsoluteSizeSpan absoluteSizeSpan = null;
            for (int i3 = 0; i3 < characterStyleArr.length; i3++) {
                if (characterStyleArr[i3] instanceof StyleSpan) {
                    int style = ((StyleSpan) characterStyleArr[i3]).getStyle();
                    if ((style & 1) != 0) {
                        sb.append("<b>");
                    }
                    if ((style & 2) != 0) {
                        sb.append("<i>");
                    }
                }
                if ((characterStyleArr[i3] instanceof TypefaceSpan) && "monospace".equals(((TypefaceSpan) characterStyleArr[i3]).getFamily())) {
                    sb.append("<tt>");
                }
                if (characterStyleArr[i3] instanceof SuperscriptSpan) {
                    sb.append("<sup>");
                }
                if (characterStyleArr[i3] instanceof SubscriptSpan) {
                    sb.append("<sub>");
                }
                if (characterStyleArr[i3] instanceof UnderlineSpan) {
                    sb.append("<u>");
                }
                if (characterStyleArr[i3] instanceof StrikethroughSpan) {
                    sb.append("<strike>");
                }
                if (characterStyleArr[i3] instanceof URLSpan) {
                    sb.append("<a href=\"");
                    sb.append(((URLSpan) characterStyleArr[i3]).getURL());
                    sb.append("\">");
                }
                if (characterStyleArr[i3] instanceof ImageSpan) {
                    sb.append("<img src=\"");
                    sb.append(((ImageSpan) characterStyleArr[i3]).getSource());
                    sb.append("\">");
                    i = nextSpanTransition;
                }
                if (characterStyleArr[i3] instanceof AbsoluteSizeSpan) {
                    absoluteSizeSpan = (AbsoluteSizeSpan) characterStyleArr[i3];
                }
                if (characterStyleArr[i3] instanceof RelativeSizeSpan) {
                    sb.append(String.format("<span style=\"font-size:%.2fem;\">", Float.valueOf(((RelativeSizeSpan) characterStyleArr[i3]).getSizeChange())));
                }
                if (characterStyleArr[i3] instanceof ForegroundColorSpan) {
                    foregroundColorSpan = (ForegroundColorSpan) characterStyleArr[i3];
                }
                if (characterStyleArr[i3] instanceof BackgroundColorSpan) {
                    sb.append(String.format("<span style=\"background-color:#%06X;\">", Integer.valueOf(((BackgroundColorSpan) characterStyleArr[i3]).getBackgroundColor() & 16777215)));
                }
            }
            StringBuilder sb2 = new StringBuilder();
            if (foregroundColorSpan != null || absoluteSizeSpan != null) {
                sb2.append("<font ");
            }
            if (foregroundColorSpan != null) {
                sb2.append(String.format("color='#%06X' ", Integer.valueOf(foregroundColorSpan.getForegroundColor() & 16777215)));
            }
            if (absoluteSizeSpan != null) {
                if (absoluteSizeSpan.getSize() == 18) {
                    str = "18px";
                } else {
                    str = absoluteSizeSpan.getSize() == 14 ? "14px" : "16px";
                }
                sb2.append("style='font-size:" + str + ";'");
            }
            if (sb2.length() > 0) {
                sb.append(((Object) sb2) + ">");
            }
            k(sb, spanned, i, nextSpanTransition);
            if (sb2.length() > 0) {
                sb.append("</font>");
            }
            for (int length = characterStyleArr.length - 1; length >= 0; length--) {
                if (characterStyleArr[length] instanceof BackgroundColorSpan) {
                    sb.append("</span>");
                }
                boolean z = characterStyleArr[length] instanceof ForegroundColorSpan;
                if (characterStyleArr[length] instanceof RelativeSizeSpan) {
                    sb.append("</span>");
                }
                boolean z2 = characterStyleArr[length] instanceof AbsoluteSizeSpan;
                if (characterStyleArr[length] instanceof URLSpan) {
                    sb.append("</a>");
                }
                if (characterStyleArr[length] instanceof StrikethroughSpan) {
                    sb.append("</strike>");
                }
                if (characterStyleArr[length] instanceof UnderlineSpan) {
                    sb.append("</u>");
                }
                if (characterStyleArr[length] instanceof SubscriptSpan) {
                    sb.append("</sub>");
                }
                if (characterStyleArr[length] instanceof SuperscriptSpan) {
                    sb.append("</sup>");
                }
                if ((characterStyleArr[length] instanceof TypefaceSpan) && ((TypefaceSpan) characterStyleArr[length]).getFamily().equals("monospace")) {
                    sb.append("</tt>");
                }
                if (characterStyleArr[length] instanceof StyleSpan) {
                    int style2 = ((StyleSpan) characterStyleArr[length]).getStyle();
                    if ((style2 & 1) != 0) {
                        sb.append("</b>");
                    }
                    if ((style2 & 2) != 0) {
                        sb.append("</i>");
                    }
                }
            }
            i = nextSpanTransition;
        }
    }

    private static void k(StringBuilder sb, CharSequence charSequence, int i, int i2) {
        sb.append(charSequence.subSequence(i, i2));
    }
}
