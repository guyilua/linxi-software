package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import com.tencent.smtt.utils.Apn;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TbsReaderView extends FrameLayout {
    public static final String IS_BAR_ANIMATING = "is_bar_animating";
    public static final String IS_BAR_SHOWING = "is_bar_show";
    public static final String IS_INTO_DOWNLOADING = "into_downloading";
    public static final String KEY_FILE_PATH = "filePath";
    public static final String KEY_TEMP_PATH = "tempPath";
    public static final int READER_CHANNEL_DOC_ID = 10965;
    public static final int READER_CHANNEL_PDF_ID = 10834;
    public static final int READER_CHANNEL_PPT_ID = 10833;
    public static final int READER_CHANNEL_TXT_ID = 10835;
    public static final String READER_STATISTICS_COUNT_CANCEL_LOADED_BTN = "AHNG802";
    public static final String READER_STATISTICS_COUNT_CLICK_LOADED_BTN = "AHNG801";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_BROWSER = "AHNG829";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_DIALOG = "AHNG827";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_DOWNLOAD = "AHNG828";
    public static final String READER_STATISTICS_COUNT_DOC_SEARCH_BTN = "AHNG826";
    public static final String READER_STATISTICS_COUNT_PDF_FOLDER_BTN = "AHNG810";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_BROWSER = "AHNG813";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_DIALOG = "AHNG811";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_DOWNLOAD = "AHNG812";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_BROWSER = "AHNG809";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_DIALOG = "AHNG807";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_DOWNLOAD = "AHNG808";
    public static final String READER_STATISTICS_COUNT_PPT_PLAY_BTN = "AHNG806";
    public static final String READER_STATISTICS_COUNT_RETRY_BTN = "AHNG803";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_BROWSER = "AHNG817";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_DIALOG = "AHNG815";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_DOWNLOAD = "AHNG816";
    public static final String READER_STATISTICS_COUNT_TXT_NOVEL_BTN = "AHNG814";
    public static final String TAG = "TbsReaderView";
    static boolean f = false;
    public static String gReaderPackName = "";
    public static String gReaderPackVersion = "";
    Context a;
    ReaderWizard b;

    /* renamed from: c, reason: collision with root package name */
    Object f945c;
    ReaderCallback d;
    ReaderCallback e;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface ReaderCallback {
        public static final int COPY_SELECT_TEXT = 5003;
        public static final int GET_BAR_ANIMATING = 5000;
        public static final int GET_BAR_ISSHOWING = 5024;
        public static final int HIDDEN_BAR = 5001;
        public static final int INSTALL_QB = 5011;
        public static final int NOTIFY_CANDISPLAY = 12;
        public static final int NOTIFY_ERRORCODE = 19;
        public static final int READER_OPEN_QQ_FILE_LIST = 5031;
        public static final int READER_PDF_LIST = 5008;
        public static final int READER_PLUGIN_ACTIVITY_PAUSE = 5032;
        public static final int READER_PLUGIN_CANLOAD = 5013;
        public static final int READER_PLUGIN_COMMAND_FIXSCREEN = 5015;
        public static final int READER_PLUGIN_COMMAND_PDF_LIST = 5036;
        public static final int READER_PLUGIN_COMMAND_PPT_PLAYER = 5035;
        public static final int READER_PLUGIN_COMMAND_ROTATESCREEN = 5018;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND = 5038;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_CLEAR = 5041;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_NEXT = 5039;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_PREV = 5040;
        public static final int READER_PLUGIN_DOWNLOADING = 5014;
        public static final int READER_PLUGIN_RES_DOC_GUIDE = 5029;
        public static final int READER_PLUGIN_RES_FIXSCREEN_NORMAL = 5016;
        public static final int READER_PLUGIN_RES_FIXSCREEN_PRESS = 5017;
        public static final int READER_PLUGIN_RES_PDF_GUIDE = 5023;
        public static final int READER_PLUGIN_RES_PPT_GUIDE = 5021;
        public static final int READER_PLUGIN_RES_ROTATESCREEN_NORMAL = 5019;
        public static final int READER_PLUGIN_RES_ROTATESCREEN_PRESS = 5020;
        public static final int READER_PLUGIN_RES_TXT_GUIDE = 5022;
        public static final int READER_PLUGIN_SO_ERR = 5025;
        public static final int READER_PLUGIN_SO_INTO_START = 5027;
        public static final int READER_PLUGIN_SO_PROGRESS = 5028;
        public static final int READER_PLUGIN_SO_VERSION = 5030;
        public static final int READER_PLUGIN_STATUS = 5012;
        public static final int READER_PLUGIN_TEXT_FIND_RESULT = 5042;
        public static final int READER_PPT_PLAY_MODEL = 5009;
        public static final int READER_SEARCH_IN_DOCUMENT = 5026;
        public static final int READER_TOAST = 5005;
        public static final int READER_TXT_READING_MODEL = 5010;
        public static final int SEARCH_SELECT_TEXT = 5004;
        public static final int SHOW_BAR = 5002;
        public static final int SHOW_DIALOG = 5006;

        void onCallBackAction(Integer num, Object obj, Object obj2);
    }

    public TbsReaderView(Context context, ReaderCallback readerCallback) {
        super(context.getApplicationContext());
        this.a = null;
        this.b = null;
        this.f945c = null;
        this.d = null;
        this.e = null;
        if (context instanceof Activity) {
            this.d = readerCallback;
            this.a = context;
            this.e = new ReaderCallback() { // from class: com.tencent.smtt.sdk.TbsReaderView.1
                /* JADX WARN: Removed duplicated region for block: B:14:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:9:0x017a A[ADDED_TO_REGION] */
                @Override // com.tencent.smtt.sdk.TbsReaderView.ReaderCallback
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void onCallBackAction(java.lang.Integer r12, java.lang.Object r13, java.lang.Object r14) {
                    /*
                        Method dump skipped, instructions count: 394
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsReaderView.AnonymousClass1.onCallBackAction(java.lang.Integer, java.lang.Object, java.lang.Object):void");
                }
            };
            return;
        }
        throw new RuntimeException("error: unexpect context(none Activity)");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context) {
        if (!f) {
            d.a(true).a(context.getApplicationContext(), true, false);
            f = d.a(false).b();
        }
        return f;
    }

    public static Drawable getResDrawable(Context context, int i) {
        if (a(context)) {
            return ReaderWizard.getResDrawable(i);
        }
        return null;
    }

    public static String getResString(Context context, int i) {
        return a(context) ? ReaderWizard.getResString(i) : "";
    }

    public static boolean isSupportExt(Context context, String str) {
        return a(context) && ReaderWizard.isSupportCurrentPlatform(context) && ReaderWizard.isSupportExt(str);
    }

    public void doCommand(Integer num, Object obj, Object obj2) {
        Object obj3;
        ReaderWizard readerWizard = this.b;
        if (readerWizard == null || (obj3 = this.f945c) == null) {
            return;
        }
        readerWizard.doCommand(obj3, num, obj, obj2);
    }

    public boolean downloadPlugin(String str) {
        Object obj = this.f945c;
        if (obj == null) {
            Log.e(TAG, "downloadPlugin failed!");
            return false;
        }
        return this.b.checkPlugin(obj, this.a, str, true);
    }

    public void onSizeChanged(int i, int i2) {
        Object obj;
        ReaderWizard readerWizard = this.b;
        if (readerWizard == null || (obj = this.f945c) == null) {
            return;
        }
        readerWizard.onSizeChanged(obj, i, i2);
    }

    public void onStop() {
        ReaderWizard readerWizard = this.b;
        if (readerWizard != null) {
            readerWizard.destroy(this.f945c);
            this.f945c = null;
        }
        this.a = null;
        f = false;
    }

    public void openFile(Bundle bundle) {
        if (this.f945c != null && bundle != null) {
            bundle.putBoolean("browser6.0", com.tencent.smtt.sdk.a.c.c(this.a) | (!com.tencent.smtt.sdk.a.c.b(this.a)));
            bundle.putBoolean("browser6.1", com.tencent.smtt.sdk.a.c.a(this.a, 6101625L, 610000L) | (!com.tencent.smtt.sdk.a.c.b(this.a)));
            if (this.b.openFile(this.f945c, this.a, bundle, this)) {
                return;
            }
            Log.e(TAG, "OpenFile failed!");
            return;
        }
        Log.e(TAG, "init failed!");
    }

    public boolean preOpen(String str, boolean z) {
        if (!isSupportExt(this.a, str)) {
            Log.e(TAG, "not supported by:" + str);
            return false;
        }
        boolean a = a(this.a);
        if (!a) {
            return a;
        }
        boolean a2 = a();
        if (z && a2) {
            return this.b.checkPlugin(this.f945c, this.a, str, Apn.getApnType(this.a) == 3);
        }
        return a2;
    }

    public void userStatistics(String str) {
        ReaderWizard readerWizard = this.b;
        if (readerWizard != null) {
            readerWizard.userStatistics(this.f945c, str);
        }
    }

    boolean a() {
        try {
            if (this.b == null) {
                this.b = new ReaderWizard(this.e);
            }
            if (this.f945c == null) {
                this.f945c = this.b.getTbsReader();
            }
            Object obj = this.f945c;
            if (obj != null) {
                return this.b.initTbsReader(obj, this.a);
            }
            return false;
        } catch (NullPointerException unused) {
            Log.e(TAG, "Unexpect null object!");
            return false;
        }
    }
}
