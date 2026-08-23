package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.widget.TextView;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TbsLogClient {
    static TbsLogClient a = null;

    /* renamed from: c, reason: collision with root package name */
    static File f972c = null;
    static String d = null;
    static byte[] e = null;
    private static boolean i = true;
    TextView b;
    private SimpleDateFormat f;
    private Context g;
    private StringBuffer h = new StringBuffer();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private class a implements Runnable {
        String a;

        a(String str) {
            this.a = null;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            TextView textView = TbsLogClient.this.b;
            if (textView != null) {
                textView.append(this.a + UMCustomLogInfoBuilder.LINE_SEP);
            }
        }
    }

    public TbsLogClient(Context context) {
        this.f = null;
        this.g = null;
        try {
            this.g = context.getApplicationContext();
            this.f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS", Locale.US);
        } catch (Exception unused) {
            this.f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        }
    }

    private void a() {
        try {
            if (f972c == null) {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    String a2 = f.a(this.g, 6);
                    if (a2 == null) {
                        f972c = null;
                    } else {
                        f972c = new File(a2, "tbslog.txt");
                        d = LogFileUtils.createKey();
                        e = LogFileUtils.createHeaderText(f972c.getName(), d);
                    }
                } else {
                    f972c = null;
                }
            }
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        } catch (SecurityException e3) {
            e3.printStackTrace();
        }
    }

    public static void setWriteLogJIT(boolean z) {
        i = z;
    }

    public void d(String str, String str2) {
    }

    public void e(String str, String str2) {
    }

    public void i(String str, String str2) {
    }

    public void setLogView(TextView textView) {
        this.b = textView;
    }

    public void showLog(String str) {
        TextView textView = this.b;
        if (textView != null) {
            textView.post(new a(str));
        }
    }

    public void v(String str, String str2) {
    }

    public void w(String str, String str2) {
    }

    public void writeLog(String str) {
        try {
            String format = this.f.format(Long.valueOf(System.currentTimeMillis()));
            StringBuffer stringBuffer = this.h;
            stringBuffer.append(format);
            stringBuffer.append(" pid=");
            stringBuffer.append(Process.myPid());
            stringBuffer.append(" tid=");
            stringBuffer.append(Process.myTid());
            stringBuffer.append(str);
            stringBuffer.append(UMCustomLogInfoBuilder.LINE_SEP);
            if (Thread.currentThread() != Looper.getMainLooper().getThread() || i) {
                writeLogToDisk();
            }
            if (this.h.length() > 524288) {
                StringBuffer stringBuffer2 = this.h;
                stringBuffer2.delete(0, stringBuffer2.length());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void writeLogToDisk() {
        try {
            a();
            File file = f972c;
            if (file != null) {
                LogFileUtils.writeDataToStorage(file, d, e, this.h.toString(), true);
                StringBuffer stringBuffer = this.h;
                stringBuffer.delete(0, stringBuffer.length());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
