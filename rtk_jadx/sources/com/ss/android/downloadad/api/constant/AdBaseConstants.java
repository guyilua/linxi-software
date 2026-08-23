package com.ss.android.downloadad.api.constant;

import com.ss.android.download.api.constant.BaseConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface AdBaseConstants extends BaseConstants {
    public static final int DEFAULT_BROADCAST_CHECK_TIME = 600;
    public static final long DEFAULT_DELAY_TIMESTAMP = 86400000;
    public static final int DEFAULT_INSTALL_FINISH_TRY_COUNT = 15;
    public static final int DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS = 20000;
    public static final long DEFAULT_INSTALL_FINISH_TRY_SUM_TIMESTAMP = 600000;

    @Deprecated
    public static final int DOWNLOAD_AFTER_JUMP = 1;

    @Deprecated
    public static final int DOWNLOAD_IMMEDIATELY = 0;

    @Deprecated
    public static final int DOWNLOAD_OPEN_MARKET_WITH_BUTTON_AND_ITEM_CLICK = 3;

    @Deprecated
    public static final int DOWNLOAD_OPEN_MARKET_WITH_BUTTON_CLICK = 2;

    @Deprecated
    public static final int DOWNLOAD_SCENE_DETAIL = 1;

    @Deprecated
    public static final int DOWNLOAD_SCENE_NORMAL = 0;

    @Deprecated
    public static final int ENABLE_DEEP_LINK_ONLY = 2;

    @Deprecated
    public static final int ENABLE_NORMAL_AND_DEEP_LINK = 1;

    @Deprecated
    public static final int ENABLE_NORMAL_LINK_ONLY = 0;
    public static final String HTTP_DOMAIN_AD = "https://i.snssdk.com/";
    public static final String HTTP_PATH_QUERY_SCHEME_LIST = "api/ad/v1/scheme/query/";
    public static final String HTTP_PATH_REPORT_SCHEME_LIST = "api/ad/v1/scheme/report/";
    public static final String MARKET_OPEN_BRIDGE_ACTIVITY = "com.bytedance.ads.convert.BDBridgeActivity";
    public static final String MARKET_OPEN_CLICK_ID = "click_id";
    public static final String MARKET_OPEN_INTENT_EXTRA = "intent_extra";
    public static final String MARKET_OPEN_INTENT_OPEN_URL = "open_url";
    public static final String MIME_APK = "application/vnd.android.package-archive";
    public static final int MIUI_DEEPLINK_PANGOLIN_CALLSCENE = 50;
    public static final int RECOMMEND_EVENT_EXTRA_VALUE = 3;
    public static final int SEND_INSTALL_FINISH_BY_BROADCAST = 1;
    public static final int SEND_INSTALL_FINISH_BY_POLLING_THREAD = 2;
    public static final int SEND_INSTALL_FINISH_BY_REBOOT_BACKUP = 3;
    public static final int STATUS_DOWNLOAD_FINISH = 2;
    public static final int STATUS_START_DOWNLOAD = 1;

    @Deprecated
    public static final int TYPE_GAME = 2;

    @Deprecated
    public static final int TYPE_RECOMMEND_DOWNLOAD_MODEL = 1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public @interface AddClickIdSource {
        public static final int ADD_CLICK_ID_APP_OPEN = 1;
        public static final int ADD_CLICK_ID_URL_OPEN = 2;
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public @interface DownloadConfigureName {
        public static final String PANGOLIN = "pangolin";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public @interface DownloadMode {
        public static final int DOWNLOAD = 0;
        public static final int DOWNLOAD_AND_JUMP = 1;
        public static final int OPEN_MARKET_WITH_CLICK_ALL = 3;
        public static final int OPEN_MARKET_WITH_CLICK_BTN = 2;
        public static final int OPEN_WEB = 4;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public @interface DownloadScene {
        public static final int DETAIL = 1;
        public static final int NORMAL = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public @interface DownloadStoreCode {
        public static final int MARKET_TYPE_HUAWEI = 3;
        public static final int MARKET_TYPE_OPPO = 1;
        public static final int MARKET_TYPE_VIVO = 2;
        public static final int MARKET_TYPE_XIAOMI = 4;
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public @interface FunnelType {
        public static final int APP_LINK = 4;
        public static final int DOWNLOAD = 1;
        public static final int MARKET = 2;
        public static final int QUICK_APP = 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public @interface LinkMode {
        public static final int ENABLE_AUTO_OPEN = 1;
        public static final int ENABLE_AUTO_OPEN2 = 2;
        public static final int NORMAL_AND_DEEP = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public @interface MiuiNewMarketResult {
        public static final int REAL_OPEN_MARKET_SUCCESS = 0;
        public static final int ROLL_BACK_DOWNLOAD = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public @interface ModelType {
        public static final int AD = 0;
        public static final int BROWSER = 3;
        public static final int GAME = 2;
        public static final int RECOMMEND_AD = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public @interface OpenAppScene {
        public static final int APP_LINK = 0;
        public static final int INSTALLER = 1;
        public static final int MARKET = 2;
        public static final int QUICK_APP = 3;
    }
}
