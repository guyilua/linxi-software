package com.umeng.commonsdk.statistics.noise;

import android.content.Context;
import android.text.TextUtils;
import com.sigmob.sdk.base.blurkit.c;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.d;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ABTest implements d {
    private static ABTest instance;
    private Context context;
    private boolean isInTest = false;
    private int mPolicy = -1;
    private int mInterval = -1;
    private int mGroup = -1;
    private float mProb13 = c.d;
    private float mProb07 = c.d;
    private String mPoli = null;

    private ABTest(Context context, String str, int i) {
        this.context = null;
        this.context = context;
        onExperimentChanged(str, i);
    }

    public static synchronized ABTest getService(Context context) {
        ABTest aBTest;
        synchronized (ABTest.class) {
            if (instance == null) {
                instance = new ABTest(context, UMEnvelopeBuild.imprintProperty(context, "client_test", null), Integer.valueOf(UMEnvelopeBuild.imprintProperty(context, "test_report_interval", "0")).intValue());
            }
            aBTest = instance;
        }
        return aBTest;
    }

    private void parseFIXED(String str) {
        if (str == null) {
            return;
        }
        String[] split = str.split("\\|");
        float f = c.d;
        if (split[2].equals("SIG13")) {
            f = Float.valueOf(split[3]).floatValue();
        }
        if (this.mProb13 > f) {
            this.isInTest = false;
            return;
        }
        int intValue = split[0].equals("FIXED") ? Integer.valueOf(split[1]).intValue() : -1;
        int[] iArr = null;
        if (split[4].equals("RPT")) {
            this.mPoli = "RPT";
            String[] split2 = split[5].split(",");
            iArr = new int[split2.length];
            for (int i = 0; i < split2.length; i++) {
                iArr[i] = Integer.valueOf(split2[i]).intValue();
            }
        } else if (split[4].equals("DOM")) {
            this.mPoli = "DOM";
            this.isInTest = true;
            try {
                String[] split3 = split[5].split(",");
                iArr = new int[split3.length];
                for (int i2 = 0; i2 < split3.length; i2++) {
                    iArr[i2] = Integer.valueOf(split3[i2]).intValue();
                }
            } catch (Exception unused) {
            }
        }
        if (intValue != -1) {
            this.isInTest = true;
            this.mGroup = intValue;
            if (iArr != null) {
                this.mPolicy = iArr[intValue - 1];
                return;
            }
            return;
        }
        this.isInTest = false;
    }

    private void parseSig7(String str) {
        float[] fArr;
        if (str == null) {
            return;
        }
        String[] split = str.split("\\|");
        boolean equals = split[2].equals("SIG13");
        float f = c.d;
        if (this.mProb13 > (equals ? Float.valueOf(split[3]).floatValue() : c.d)) {
            this.isInTest = false;
            return;
        }
        int[] iArr = null;
        if (split[0].equals("SIG7")) {
            String[] split2 = split[1].split(",");
            fArr = new float[split2.length];
            for (int i = 0; i < split2.length; i++) {
                fArr[i] = Float.valueOf(split2[i]).floatValue();
            }
        } else {
            fArr = null;
        }
        if (split[4].equals("RPT")) {
            this.mPoli = "RPT";
            String[] split3 = split[5].split(",");
            iArr = new int[split3.length];
            for (int i2 = 0; i2 < split3.length; i2++) {
                iArr[i2] = Integer.valueOf(split3[i2]).intValue();
            }
        } else if (split[4].equals("DOM")) {
            this.isInTest = true;
            this.mPoli = "DOM";
            try {
                String[] split4 = split[5].split(",");
                iArr = new int[split4.length];
                for (int i3 = 0; i3 < split4.length; i3++) {
                    iArr[i3] = Integer.valueOf(split4[i3]).intValue();
                }
            } catch (Exception unused) {
            }
        }
        int i4 = 0;
        while (true) {
            if (i4 >= fArr.length) {
                i4 = -1;
                break;
            }
            f += fArr[i4];
            if (this.mProb07 < f) {
                break;
            } else {
                i4++;
            }
        }
        if (i4 != -1) {
            this.isInTest = true;
            this.mGroup = i4 + 1;
            if (iArr != null) {
                this.mPolicy = iArr[i4];
                return;
            }
            return;
        }
        this.isInTest = false;
    }

    private float prob(String str, int i) {
        int i2 = i * 2;
        return str == null ? c.d : Integer.valueOf(str.substring(i2, i2 + 5), 16).intValue() / 1048576.0f;
    }

    public static boolean validate(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] split = str.split("\\|");
        if (split.length != 6) {
            return false;
        }
        if (split[0].startsWith("SIG7") && split[1].split(",").length == split[5].split(",").length) {
            return true;
        }
        if (split[0].startsWith("FIXED")) {
            int length = split[5].split(",").length;
            int parseInt = Integer.parseInt(split[1]);
            if (length >= parseInt && parseInt >= 1) {
                return true;
            }
        }
        return false;
    }

    public int getGroup() {
        return this.mGroup;
    }

    public String getGroupInfo() {
        return !this.isInTest ? "error" : String.valueOf(this.mGroup);
    }

    public int getTestInterval() {
        return this.mInterval;
    }

    public String getTestName() {
        return this.mPoli;
    }

    public int getTestPolicy() {
        return this.mPolicy;
    }

    public boolean isInTest() {
        return this.isInTest;
    }

    public void onExperimentChanged(String str, int i) {
        this.mInterval = i;
        String signature = Envelope.getSignature(this.context);
        if (!TextUtils.isEmpty(signature) && !TextUtils.isEmpty(str)) {
            try {
                this.mProb13 = prob(signature, 12);
                this.mProb07 = prob(signature, 6);
                if (str.startsWith("SIG7")) {
                    parseSig7(str);
                } else if (str.startsWith("FIXED")) {
                    parseFIXED(str);
                }
                return;
            } catch (Exception e) {
                this.isInTest = false;
                MLog.e("v:" + str, e);
                return;
            }
        }
        this.isInTest = false;
    }

    @Override // com.umeng.commonsdk.statistics.internal.d
    public void onImprintChanged(ImprintHandler.a aVar) {
        onExperimentChanged(aVar.a("client_test", null), Integer.valueOf(aVar.a("test_report_interval", "0")).intValue());
    }

    public String toString() {
        return " p13:" + this.mProb13 + " p07:" + this.mProb07 + " policy:" + this.mPolicy + " interval:" + this.mInterval;
    }
}
