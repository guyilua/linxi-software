package c.d.a;

import android.content.Context;
import android.widget.TextView;
import com.rtk.app.R;
import com.rtk.app.bean.LoginBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.main.MainActivityPack.MainActivity;

/* compiled from: LimitTool.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d {
    public static boolean a(String str) {
        LoginBean loginBean = MainActivity.p;
        return (loginBean == null || loginBean.getData() == null || MainActivity.p.getData().getAdmin() == null || !MainActivity.p.getData().getAdmin().hasFamilyBBSAdmin(str)) ? false : true;
    }

    public static boolean b(String str) {
        LoginBean loginBean = MainActivity.p;
        return (loginBean == null || loginBean.getData() == null || MainActivity.p.getData().getAdmin() == null || !MainActivity.p.getData().getAdmin().hasFamilyUpAdmin(str)) ? false : true;
    }

    public static boolean c() {
        LoginBean loginBean = MainActivity.p;
        return (loginBean == null || loginBean.getData() == null || MainActivity.p.getData().getAdmin() == null || !MainActivity.p.getData().getAdmin().hasSomeFamilyUpAdmin()) ? false : true;
    }

    public static boolean d() {
        LoginBean loginBean = MainActivity.p;
        return (loginBean == null || loginBean.getData() == null || MainActivity.p.getData().getAdmin() == null || MainActivity.p.getData().getQqLogin() == null) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void e(Context context, CustomTextView customTextView, int i, String str) {
        if (i == 0) {
            customTextView.setTextColor(context.getResources().getColor(R.color.drak999));
            customTextView.setRightText("(" + str + ")");
            customTextView.setText("已下架");
            return;
        }
        if (i == 1) {
            customTextView.setTextColor(context.getResources().getColor(R.color.theme1));
            customTextView.setRightText("");
            customTextView.setText("审核中");
            return;
        }
        if (i == 2) {
            customTextView.setTextColor(context.getResources().getColor(R.color.theme20));
            customTextView.setRightText("(" + str + ")");
            customTextView.setText("审核未通过");
            return;
        }
        if (i == 3) {
            customTextView.setTextColor(context.getResources().getColor(R.color.theme3));
            customTextView.setRightText("");
            customTextView.setText("审核已通过");
        } else {
            if (i != 4) {
                return;
            }
            customTextView.setTextColor(context.getResources().getColor(R.color.drak999));
            customTextView.setRightText("(" + str + ")");
            customTextView.setText("已删除");
        }
    }

    public static void f(Context context, TextView textView, int i) {
        g(context, textView, i, false);
    }

    public static void g(Context context, TextView textView, int i, boolean z) {
        String str = z ? "[家族]" : "";
        if (i == 1) {
            textView.setText(str + "审核中");
            textView.setTextColor(context.getResources().getColor(R.color.theme2));
            return;
        }
        if (i == 2) {
            textView.setText(str + "审核未通过");
            textView.setTextColor(context.getResources().getColor(R.color.theme20));
            return;
        }
        if (i == 3) {
            textView.setText(str + "审核已通过");
            textView.setTextColor(context.getResources().getColor(R.color.theme3));
            return;
        }
        if (i != 4) {
            return;
        }
        textView.setText(str + "已删除");
        textView.setTextColor(context.getResources().getColor(R.color.drak999));
    }
}
