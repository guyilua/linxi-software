package com.rtk.app.custom.RichEditText;

import java.util.regex.Pattern;

/* compiled from: FilterHtmlUtil.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c {
    public static String a(String str) {
        try {
            return Pattern.compile("<[^>]+>", 2).matcher(Pattern.compile("<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>", 2).matcher(Pattern.compile("<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>", 2).matcher(str).replaceAll("")).replaceAll("")).replaceAll("");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
