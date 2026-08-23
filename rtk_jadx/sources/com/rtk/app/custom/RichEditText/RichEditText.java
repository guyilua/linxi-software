package com.rtk.app.custom.RichEditText;

import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.CheckedTextView;
import com.rtk.app.bean.CommunityPostBean;
import com.rtk.app.bean.MyAttentionBean;
import com.rtk.app.custom.RichEditText.BaseRitchEdit;
import com.rtk.app.custom.RichEditText.a.a;
import com.rtk.app.custom.RichEditText.a.i;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.base.mta.PointCategory;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class RichEditText extends BaseRitchEdit implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    private Context f166c;
    private BaseRitchEdit.a d;
    private int e;
    private int f;
    private CheckedTextView g;
    private CheckedTextView h;
    private CheckedTextView i;
    protected boolean j;

    public RichEditText(Context context) {
        super(context);
        this.e = 1;
        this.f = 0;
        this.j = false;
        f(context);
        y.P(context, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private d c(int i, int i2) {
        d dVar = new d();
        for (CharacterStyle characterStyle : (CharacterStyle[]) getEditableText().getSpans(i, i2, CharacterStyle.class)) {
            if (characterStyle instanceof StyleSpan) {
                int style = ((StyleSpan) characterStyle).getStyle();
                if (style == 1) {
                    dVar.a = true;
                } else if (style == 2) {
                    dVar.b = true;
                }
            } else if (characterStyle instanceof UnderlineSpan) {
                dVar.f170c = true;
            } else if (characterStyle instanceof StrikethroughSpan) {
                dVar.d = true;
            } else if (characterStyle instanceof AbsoluteSizeSpan) {
                dVar.e = ((AbsoluteSizeSpan) characterStyle).getSize();
            } else if (characterStyle instanceof ForegroundColorSpan) {
                dVar.f = ((ForegroundColorSpan) characterStyle).getForegroundColor();
            }
        }
        return dVar;
    }

    private CharacterStyle d(d dVar) {
        if (dVar.a) {
            return new StyleSpan(1);
        }
        if (dVar.b) {
            return new StyleSpan(2);
        }
        if (dVar.f170c) {
            return new UnderlineSpan();
        }
        if (dVar.d) {
            return new StrikethroughSpan();
        }
        if (dVar.e > 0) {
            return new AbsoluteSizeSpan(dVar.e, true);
        }
        if (dVar.f != 0) {
            return new ForegroundColorSpan(dVar.f);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> List<h> e(T[] tArr, d dVar) {
        ArrayList arrayList = new ArrayList();
        for (Object[] objArr : tArr) {
            boolean z = true;
            if (objArr instanceof StyleSpan) {
                int style = ((StyleSpan) objArr).getStyle();
                if ((!dVar.a || style != 1) && (!dVar.b || style != 2)) {
                    z = false;
                }
            }
            if (z) {
                h hVar = new h(dVar);
                hVar.g = getEditableText().getSpanStart(objArr);
                hVar.h = getEditableText().getSpanEnd(objArr);
                if (objArr instanceof AbsoluteSizeSpan) {
                    hVar.e = ((AbsoluteSizeSpan) objArr).getSize();
                } else if (objArr instanceof ForegroundColorSpan) {
                    hVar.f = ((ForegroundColorSpan) objArr).getForegroundColor();
                }
                arrayList.add(hVar);
                getEditableText().removeSpan(objArr);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void h() {
        setBold(false);
        setUnderline(false);
        setItalic(false);
        b(this.a);
        int selectionStart = getSelectionStart();
        String obj = getText().toString();
        if (selectionStart <= 0 || obj.substring(selectionStart - 1, selectionStart).equals(UMCustomLogInfoBuilder.LINE_SEP)) {
            return;
        }
        c0.u("RichEditText", "在前面插入了换行");
        getEditableText().insert(selectionStart, UMCustomLogInfoBuilder.LINE_SEP);
        setSelection(selectionStart + 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> void i(d dVar, boolean z, Class<T> cls) {
        Log.d("setSpan", "");
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        int i = 34;
        for (h hVar : e(getEditableText().getSpans(selectionStart, selectionEnd, cls), dVar)) {
            if (hVar.g < selectionStart) {
                if (selectionStart == selectionEnd) {
                    i = 33;
                }
                getEditableText().setSpan(d(hVar), hVar.g, selectionStart, i);
            }
            if (hVar.h > selectionEnd) {
                getEditableText().setSpan(d(hVar), selectionEnd, hVar.h, i);
            }
        }
        if (z) {
            if (selectionStart == selectionEnd) {
                i = 18;
            }
            getEditableText().setSpan(d(dVar), selectionStart, selectionEnd, i);
        }
    }

    private void j(boolean z, int i) {
        d dVar = new d();
        if (i == 1) {
            dVar.a = true;
        } else if (i == 2) {
            dVar.b = true;
        }
        i(dVar, z, StyleSpan.class);
    }

    private void setFontSizeSpan(int i) {
        if (i == 0) {
            i = 16;
        }
        d dVar = new d();
        dVar.e = i;
        i(dVar, true, AbsoluteSizeSpan.class);
    }

    private void setForcegroundColor(int i) {
        if (i == 0) {
            i = Color.parseColor("#FF212121");
        }
        d dVar = new d();
        dVar.f = i;
        i(dVar, true, ForegroundColorSpan.class);
    }

    private void setStreakSpan(boolean z) {
        d dVar = new d();
        dVar.d = true;
        i(dVar, z, StrikethroughSpan.class);
    }

    private void setUnderlineSpan(boolean z) {
        d dVar = new d();
        dVar.f170c = true;
        i(dVar, z, UnderlineSpan.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void f(Context context) {
        this.f166c = context;
        setOnClickListener(this);
        e eVar = new e(this);
        this.a = eVar;
        a(eVar);
    }

    public void g() {
        setBold(this.g.isChecked());
        setUnderline(this.i.isChecked());
        setItalic(this.h.isChecked());
        a(this.a);
    }

    public int getCurrentVideoNum() {
        return this.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getLabelString() {
        String trim = b.d(getEditableText(), 0).trim();
        c0.u("RichEditText", "原始数据" + trim);
        int c2 = c0.c(trim, "</font>");
        for (int i = 0; i < c2; i++) {
            int indexOf = trim.indexOf("<font");
            trim.indexOf("</font>");
            trim = trim.replaceFirst("</font>", "[/size][/forecolor]").replaceFirst("px;'>", "]").replaceFirst(" style='font-size:", "[size=");
            int i2 = indexOf + 21;
            String substring = trim.substring(indexOf, i2);
            String substring2 = trim.substring(i2 - 8, i2 - 1);
            c0.u("RichEditText", substring + "   " + substring2);
            if (!c0.q(substring, substring2)) {
                trim = trim.replaceFirst(substring, "[forecolor=" + substring2 + "]");
            }
        }
        int c3 = c0.c(trim, "[size=16]");
        for (int i3 = 0; i3 < c3; i3++) {
            int indexOf2 = trim.indexOf("[size=16]");
            trim = trim.substring(0, indexOf2) + trim.substring(indexOf2).replaceFirst("\\[size=16\\]", "").replaceFirst("\\[/size\\]", "");
        }
        int c4 = c0.c(trim, "[forecolor=#212121]");
        for (int i4 = 0; i4 < c4; i4++) {
            int indexOf3 = trim.indexOf("[forecolor=#212121]");
            String substring3 = trim.substring(indexOf3).substring(19);
            int indexOf4 = substring3.indexOf("[/forecolor]");
            trim = trim.substring(0, indexOf3) + (substring3.substring(0, indexOf4) + substring3.substring(indexOf4 + 12));
        }
        String replaceAll = trim.replaceAll("\\[size=\\d\\d\\]\\[/size\\]", "");
        c0.u("RichEditText", "正则表达式替换后" + replaceAll);
        String replaceAll2 = replaceAll.replaceAll("\\[forecolor=#\\w\\w\\w\\w\\w\\w\\]\\[/forecolor\\]", "").replaceAll("<b><b><b><b><b><b>", "<b>").replaceAll("<b><b><b><b><b>", "<b>").replaceAll("<b><b><b><b>", "<b>").replaceAll("<b><b><b>", "<b>").replaceAll("<b><b>", "<b>").replaceAll("<b>", "[b]").replaceAll("</b></b></b></b></b></b>", "</b>").replaceAll("</b></b></b></b></b>", "</b>").replaceAll("</b></b></b></b>", "</b>").replaceAll("</b></b></b>", "</b>").replaceAll("</b></b>", "</b>").replaceAll("</b>", "[/b]").replaceAll("<i><i><i><i><i><i>", "<i>").replaceAll("<i><i><i><i><i>", "<i>").replaceAll("<i><i><i><i>", "<i>").replaceAll("<i><i><i>", "<i>").replaceAll("<i><i>", "<i>").replaceAll("<i>", "[i]").replaceAll("</i></i></i></i></i></i>", "</i>").replaceAll("</i></i></i></i></i>", "</i>").replaceAll("</i></i></i></i>", "</i>").replaceAll("</i></i></i>", "</i>").replaceAll("</i></i>", "</i>").replaceAll("</i>", "[/i]").replaceAll("<u><u><u><u><u><u>", "<u>").replaceAll("<u><u><u><u><u>", "<u>").replaceAll("<u><u><u><u>", "<u>").replaceAll("<u><u><u>", "<u>").replaceAll("<u><u>", "<u>").replaceAll("</u></u></u></u></u></u>", "</u>").replaceAll("</u></u></u></u></u>", "</u>").replaceAll("</u></u></u></u>", "</u>").replaceAll("</u></u></u>", "</u>").replaceAll("</u></u>", "</u>").replaceAll("<u>", "[u]").replaceAll("</u>", "[/u]").replaceAll("<img src=\"\\[game", "\\[game").replaceAll("\\[/game\\]\"><br>", "\\[/game\\]").replaceAll("<img src=\"\\[upfile", "\\[upfile").replaceAll("\\[/upfile\\]\"><br>", "\\[/upfile\\]").replaceAll("<img src=\"\\[post", "\\[post").replaceAll("\\[/post\\]\"><br>", "\\[/post\\]").replaceAll("<img src=\"\\[user", "\\[user").replaceAll("\\[/user\\]\"><br>", "\\[/user\\]").replaceAll("<img src=\"\\[img", "\\[img").replaceAll("\\[/img\\]\"><br>", "\\[/img\\]").replaceAll("<img src=\"\\[video", "\\[video").replaceAll("\\[/video\\]\"><br>", "\\[/video\\]");
        this.j = false;
        return replaceAll2;
    }

    public int getMaxVideoNum() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getPlainText() {
        String str = "[text]" + c.a(b.d(getEditableText(), 0).trim()).replaceAll("\\[upfile*?\\[/upfile\\]", "").replaceAll("\\[game*?\\[/game\\]", "") + "[/text]";
        c0.u("RichEditText", "上传纯文本" + str);
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int selectionStart = getSelectionStart() - 1;
        if (selectionStart == -1) {
            selectionStart = 0;
        }
        if (selectionStart < -1) {
            return;
        }
        d c2 = c(selectionStart, selectionStart);
        setBold(c2.a);
        setItalic(c2.b);
        setUnderline(c2.f170c);
        setStreak(c2.d);
        setFontSize(c2.e);
        setFontColor(c2.f);
        BaseRitchEdit.a aVar = this.d;
        if (aVar == null || selectionStart < 0) {
            return;
        }
        aVar.b(selectionStart, selectionStart);
        this.d.a(c2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTextContextMenuItem(int i) {
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        if (i == 16908322) {
            DialogForProgressTip dialogForProgressTip = new DialogForProgressTip(this.f166c, "插入中请稍后");
            dialogForProgressTip.show();
            String charSequence = clipboardManager.getText().toString();
            c0.u("RichEditText", "复制的文本" + charSequence);
            c0.u("RichEditText", "处理后的图片" + charSequence);
            if (charSequence.contains("[")) {
                setTagStr(charSequence.replaceAll("\\[img\\]图片\\[/img\\]", ""));
                clipboardManager.setText("");
            }
            setBold(false);
            setItalic(false);
            setUnderline(false);
            setStreak(false);
            dialogForProgressTip.dismiss();
        }
        try {
            return super.onTextContextMenuItem(i);
        } catch (Exception unused) {
            return true;
        }
    }

    public void setBitmap(Bitmap bitmap) {
        h();
        new com.rtk.app.custom.RichEditText.a.b(this.f166c, this).l(bitmap, t.l(this.f166c, bitmap));
        g();
    }

    public void setBold(boolean z) {
        j(z, 1);
    }

    public void setControlView(CheckedTextView checkedTextView, CheckedTextView checkedTextView2, CheckedTextView checkedTextView3) {
        this.g = checkedTextView;
        this.h = checkedTextView2;
        this.i = checkedTextView3;
    }

    public void setCurrentVideoNum(int i) {
        this.f = i;
    }

    public void setFontColor(int i) {
        setForcegroundColor(i);
    }

    public void setFontSize(int i) {
        setFontSizeSpan(i);
    }

    public void setGame(f fVar) {
        c0.u("RichEditText", "设置游戏内容" + fVar.toString());
        h();
        new a(this.f166c, this).a(fVar);
        g();
    }

    public void setImg(String str) {
        h();
        c0.u("RichEditText", "富文本图片地址" + str);
        if (!TextUtils.isEmpty(str)) {
            new com.rtk.app.custom.RichEditText.a.b(this.f166c, this).n(str);
        }
        g();
    }

    public void setItalic(boolean z) {
        j(z, 2);
    }

    public void setMaxVideoNum(int i) {
        this.e = i;
    }

    public void setMoreBitMap(List<String> list) {
        h();
        new com.rtk.app.custom.RichEditText.a.b(this.f166c, this).o(list);
        g();
    }

    public void setOnSelectChangeListener(BaseRitchEdit.a aVar) {
        this.d = aVar;
    }

    public void setPost(CommunityPostBean.DataBean dataBean) {
        c0.u("RichEditText", "设置用户内容" + dataBean.toString());
        h();
        new com.rtk.app.custom.RichEditText.a.d(this.f166c, this).a(dataBean);
        g();
    }

    public void setStreak(boolean z) {
        setStreakSpan(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTagStr(String str) {
        String substring;
        int i;
        char c2;
        int indexOf;
        int length;
        if (c0.q(str)) {
            return;
        }
        String replaceAll = str.replaceAll("<br>", UMCustomLogInfoBuilder.LINE_SEP);
        int i2 = 0;
        while (true) {
            try {
                try {
                    b(this.a);
                    substring = replaceAll.substring(i2);
                } catch (Exception unused) {
                }
                if (substring.length() <= 0) {
                    return;
                }
                if (substring.startsWith("[")) {
                    c0.u("RichEditText", "反编辑进来了   是括号开头的");
                    ResourceTypeBean d = g.d(substring);
                    if (d != null && d.getIsResource() && !c0.q(d.getResourceType())) {
                        String str2 = "[/" + d.getResourceType() + "]";
                        c0.u("RichEditText", "反编辑出来了类型" + str2);
                        String resourceType = d.getResourceType();
                        switch (resourceType.hashCode()) {
                            case -838779241:
                                if (resourceType.equals("upfile")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 104387:
                                if (resourceType.equals("img")) {
                                    c2 = 4;
                                    break;
                                }
                                break;
                            case 3165170:
                                if (resourceType.equals("game")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case 3446944:
                                if (resourceType.equals("post")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case 3599307:
                                if (resourceType.equals("user")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case 112202875:
                                if (resourceType.equals(PointCategory.VIDEO)) {
                                    c2 = 5;
                                    break;
                                }
                                break;
                        }
                        c2 = 65535;
                        if (c2 == 0) {
                            setGame(new f(d.getResourceid(), d.getResourceName()));
                            indexOf = substring.indexOf(str2) + i2;
                            length = str2.length();
                        } else if (c2 == 1) {
                            setUpSrc(new UpSrcBean(d.getResourceid(), d.getResourceName()));
                            indexOf = substring.indexOf(str2) + i2;
                            length = str2.length();
                        } else if (c2 == 2) {
                            CommunityPostBean.DataBean dataBean = new CommunityPostBean.DataBean();
                            dataBean.setPid(d.getResourceid());
                            dataBean.setTitle(d.getResourceName());
                            setPost(dataBean);
                            indexOf = substring.indexOf(str2) + i2;
                            length = str2.length();
                        } else if (c2 == 3) {
                            MyAttentionBean.DataBean dataBean2 = new MyAttentionBean.DataBean();
                            dataBean2.setFans(d.getResourceid());
                            dataBean2.setNickname(d.getResourceName());
                            setUser(dataBean2);
                            indexOf = substring.indexOf(str2) + i2;
                            length = str2.length();
                        } else if (c2 == 4) {
                            setImg(d.getResourceName());
                            indexOf = substring.indexOf(str2) + i2;
                            length = str2.length();
                        } else if (c2 == 5) {
                            List<String> d2 = c0.d(d.getResourceName(), "\\|\\|");
                            c0.u("RichEditText", "剪切的尺寸  " + d2.size());
                            setVideo(Integer.parseInt(d.getResourceid()), d2.get(0), d2.size() > 1 ? d2.get(1) : "占位符");
                            indexOf = substring.indexOf(str2) + i2;
                            length = str2.length();
                        }
                        i2 = indexOf + length;
                    } else {
                        if (substring.startsWith("[b]")) {
                            setBold(true);
                        } else {
                            if (substring.startsWith("[/b]")) {
                                setBold(false);
                            } else if (substring.startsWith("[u]")) {
                                setUnderline(true);
                            } else if (substring.startsWith("[/u]")) {
                                setUnderline(false);
                            } else if (substring.startsWith("[i]")) {
                                setItalic(true);
                            } else if (substring.startsWith("[/i]")) {
                                setItalic(false);
                            } else if (substring.startsWith("[forecolor=")) {
                                setFontColor(Color.parseColor(substring.substring(11, 18)));
                            } else if (substring.startsWith("[/forecolor]")) {
                                setFontColor(Color.parseColor("#333333"));
                            } else if (substring.startsWith("[size=")) {
                                setFontSize(Integer.parseInt(substring.substring(6, 8)));
                            } else if (substring.startsWith("[/size]")) {
                                setFontSize(16);
                            } else {
                                i = i2 + 1;
                                try {
                                    getEditableText().insert(getSelectionEnd(), replaceAll.substring(i2, i));
                                    i2 = i;
                                } catch (Exception unused2) {
                                    i2 = i;
                                    int i3 = i2 + 1;
                                    getEditableText().insert(getSelectionEnd(), replaceAll.substring(i2, i3));
                                    a(this.a);
                                    i2 = i3;
                                }
                            }
                            i2 += 4;
                        }
                        i2 += 3;
                    }
                    a(this.a);
                } else if (substring.startsWith(UMCustomLogInfoBuilder.LINE_SEP)) {
                    c0.u("RichEditText", "尖括号开头，进来了");
                    if (!getEditableText().toString().endsWith("]\n")) {
                        getEditableText().insert(getSelectionEnd(), UMCustomLogInfoBuilder.LINE_SEP);
                    }
                    i2++;
                    a(this.a);
                } else {
                    i = i2 + 1;
                    getEditableText().insert(getSelectionEnd(), replaceAll.substring(i2, i));
                    i2 = i;
                    a(this.a);
                }
            } finally {
                a(this.a);
            }
        }
    }

    public void setUnderline(boolean z) {
        setUnderlineSpan(z);
    }

    public void setUpSrc(UpSrcBean upSrcBean) {
        c0.u("RichEditText", "设置up资源内容" + upSrcBean.toString());
        h();
        new com.rtk.app.custom.RichEditText.a.g(this.f166c, this).a(upSrcBean);
        g();
    }

    public void setUser(MyAttentionBean.DataBean dataBean) {
        c0.u("RichEditText", "设置用户内容" + dataBean.toString());
        h();
        new com.rtk.app.custom.RichEditText.a.h(this.f166c, this).a(dataBean);
        g();
    }

    public void setVideo(int i, String str, String str2) {
        h();
        c0.u("RichEditText", "视频地址 " + i + " 富文视频预览图片地址  " + str);
        if (!TextUtils.isEmpty(str)) {
            this.f++;
            new i(this.f166c, this).h(i, str, str2);
        }
        g();
    }

    public void setWebContent(String str) {
        TextUtils.isEmpty(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RichEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 1;
        this.f = 0;
        this.j = false;
        setLayerType(1, null);
        f(context);
    }

    public RichEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 1;
        this.f = 0;
        this.j = false;
        f(context);
    }
}
