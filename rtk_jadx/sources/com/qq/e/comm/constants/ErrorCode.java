package com.qq.e.comm.constants;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface ErrorCode {
    public static final int AD_APP_ID_BLOCKED = 5019;
    public static final int AD_DATA_EXPIRE = 5012;
    public static final int AD_DATA_NOT_READY = 4014;
    public static final int AD_INSTANCE_NOT_READY = 4017;
    public static final int AD_MANAGER_INIT_ERROR = 200101;
    public static final int AD_POS_ID_BLOCKED = 5018;
    public static final int AD_REPLAY = 4015;
    public static final int AD_REQUEST_THROTTLING = 5013;
    public static final int AD_TYPE_DEPRECATED = 5021;
    public static final int APPID_NULL = 400102;
    public static final int BIDDING_C2S_NO_AD = 5052;
    public static final int BIDDING_C2S_TIMEOUT = 5051;
    public static final int CONSTRUCTOR_PARAM_ERROR = 4001;
    public static final int CONTAINER_SIZE_ERROR = 4005;
    public static final int CONTENT_FORCE_EXPOSURE = 4012;
    public static final int CONTEXT_NULL = 400103;
    public static final int DEVICE_UNSUPPORT = 4007;
    public static final int DOWNLOADED_NOT_INSTALL_APK = 5045;
    public static final int DOWNLOADED_NOT_INSTALL_APK_INTER_TIME = 5042;
    public static final int DOWNLOADED_NOT_INSTALL_APK_NOT_EXITS = 5044;
    public static final int DOWNLOADED_NOT_INSTALL_APK_NULL = 5043;
    public static final int DOWNLOADED_NOT_INSTALL_APK_THROTTLING = 5041;
    public static final int ERROR_AD_ID = 5038;

    @Deprecated
    public static final int EXPRESS_RENDER_FAIL = 5022;
    public static final int IMAGE_LOAD_ERROR = 5008;
    public static final int INIT_ERROR = 2001;
    public static final int INNER_ERROR = 2002;
    public static final int JSON_ERROR_CLIENT = 5000;
    public static final int JS_PARSE_NATIVE_PARAM_ERROR = 200202;
    public static final int MANIFEST_ERROR = 4002;
    public static final int METHOD_CALL_ERROR = 5024;
    public static final int NATIVE_CLICK_BEFORE_EXPOSE = 4006;
    public static final int NATIVE_EXPRESS_DATA_AND_TEMPLATE_NOT_MATCHED_ERROR = 5011;
    public static final int NATIVE_PARSE_JS_PARAM_ERROR = 200201;
    public static final int NETWORK_ERROR = 3001;
    public static final int NETWORK_HTTP_STATUS_CODE = 3005;
    public static final int NETWORK_SSL_HANDSHAKE = 3004;
    public static final int NETWORK_TIMEOUT = 3002;
    public static final int NETWORK_UNKNOWN = 3000;
    public static final int NETWORK_UNREACHABLE = 3003;
    public static final int NOT_INIT = 2003;
    public static final int NOT_SUPPORT_EXPRESS_VIDEO = 4013;
    public static final int NO_AD_FILL = 5004;
    public static final int NO_AD_FILL_FOR_INSTALLED = 5014;
    public static final int NO_AD_FILL_FOR_LIST_EMPTY = 5025;
    public static final int NO_AD_FILL_FOR_MULTI = 5039;
    public static final int ORENTATION_MISMATCH = 4016;
    public static final int PACKAGE_NAME_ERROR = 5006;
    public static final int PLUGIN_INIT_ERROR = 200102;
    public static final int POFACTORY_GET_INTERFACE_ERROR = 200103;
    public static final int POSID_ERROR = 4003;
    public static final int POSID_NULL = 400101;
    public static final int RENDER_TYPE_POSTYPE_NOTMATCH = 5010;

    @Deprecated
    public static final int RESOURCE_LOAD_ERROR = 5007;
    public static final int REWARD_PAGE_SHOW_ERROR = 5027;
    public static final int SCREEN_ORIENTATION_ERROR = 4008;
    public static final int SERVER_JSON_PARSE_ERROR = 5001;
    public static final int SKIP_VIEW_SIZE_ERROR = 4009;
    public static final int SPLASH_CONTAINER_INVISIBLE = 4004;
    public static final int SPLASH_CONTAINER_NULL = 400104;
    public static final int SPLASH_DELAY_TIME_OUT = 4011;
    public static final int SPLASH_PRELOAD_NOT_MATCH_NO_AD = 5047;
    public static final int SPLASH_SKIP_INVISIBLE = 4019;
    public static final int TRAFFIC_CONTROL_DAY = 5005;
    public static final int TRAFFIC_CONTROL_HOUR = 5009;
    public static final int UNKNOWN_ERROR = 6000;
    public static final int VIDEO_DOWNLOAD_FAIL = 5002;
    public static final int VIDEO_DURATION_ERROR = 5040;
    public static final int VIDEO_PLAY_ERROR = 5003;
    public static final int VIDEO_URL_ERROR = 5020;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface PrivateError {
        public static final int AD_DATA_DESTROYED = 9003;
        public static final int ERROR_INTERFACE_CALLED = 9004;
        public static final int LOAD_FAIL = 9001;
        public static final int LOAD_TIME_OUT = 9000;
        public static final int PARAM_ERROR = 9002;
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface ServerError {
        public static final int APPID_STATE_ABNORMAL = 100135;
        public static final int ERROR_CALL_INTERFACE = 107040;
        public static final int JS_OLD_ADMISSION_RULES_DEPRECATED = 107049;
        public static final int JS_REQUEST_DOMAIN_NOT_MATCH = 107009;
        public static final int NOT_FOUND_SUITABLE_PT = 109512;
        public static final int NOT_SUPPORT_EXPRESS_VIDEO = 107035;
        public static final int NO_MATCH_AD = 102006;
        public static final int ORENTATION_MISMATCH = 100159;
        public static final int OS_TYPE_ERROR = 107011;
        public static final int PACKAGE_NAME_ERROR = 107030;
        public static final int POSID_NOT_MATCH_INTERFACE = 107050;
        public static final int POSID_NOT_MATCH_SUITABLE_PT = 100136;
        public static final int POSID_STATE_ABNORMAL = 100133;
        public static final int RENDER_TYPE_POSTYPE_NOTMATCH = 107034;
        public static final int REQUEST_FREQUENTLY = 109502;
        public static final int SERVER_BIDDING_NOT_RECEIVE_VALID_AD = 132007;
        public static final int SERVER_BIDDING_TOKEN_MISSING = 132005;
        public static final int SERVER_BIDDING_TOKEN_PARSE_FAIL = 132008;
        public static final int TRAFFIC_CONTROL_DAY = 109506;
        public static final int TRAFFIC_CONTROL_HOUR = 109507;
    }
}
