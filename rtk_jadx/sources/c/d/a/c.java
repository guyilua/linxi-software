package c.d.a;

import java.util.regex.Pattern;

/* compiled from: IDCardValidator.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c {
    public static boolean a(String str) {
        if (!Pattern.matches("[1-9]\\d{5}(18|19|20)?\\d{2}(0[1-9]|1[0-2])(0[1-9]|[1-2]\\d|3[0-1])\\d{3}[\\dXx]", str)) {
            return false;
        }
        if (str.length() != 18) {
            return true;
        }
        int[] iArr = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        char[] cArr = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        int i = 0;
        for (int i2 = 0; i2 < 17; i2++) {
            i += (str.charAt(i2) - '0') * iArr[i2];
        }
        return cArr[i % 11] == str.charAt(17);
    }
}
