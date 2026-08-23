package com.sigmob.windad;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public enum WindAdError {
    ERROR_LOAD_FILTER_FOR_PROVIDER_ERROR(600201, "Provider声明错误,请检查manifest文件"),
    ERROR_LOAD_FILTER_FOR_PROVIDER_XML_ERROR(600200, "Provider的Xml配置错误,请检查Xml文件内容"),
    ERROR_LOAD_FILTER_FOR_PROGUARD_ERROR(600202, "SDK混淆配置错误"),
    ERROR_LOAD_FILTER_FOR_ACTIVITY_ERROR(600203, "AdActivity未声明,请检查manifest文件"),
    ERROR_LOAD_FILTER_FOR_INSTALL_PERMISSION_ERROR(600204, " 缺少REQUEST_INSTALL_PACKAGES,请检查manifest文件"),
    ERROR_AD_LOAD_FAIL_LOADING(610012, "广告正在加载中，请稍后再加载"),
    ERROR_AD_LOAD_FAIL_INTERVAL(610013, "广告加载频繁，请稍后在试"),
    ERROR_SIGMOB_BID_TOKEN_IS_EMPTY(600300, "BidToken is empty"),
    ERROR_SIGMOB_PERSONALIZED_OFF(600400, "广告个性化开关被关闭，请开启个性化开关"),
    ERROR_SIGMOB_NETWORK(600100, "网络错误"),
    ERROR_SIGMOB_REQUEST(600101, "广告请求出错"),
    ERROR_SIGMOB_NATIVE_ADCOUNT(650001, "广告请求数ad_count 必需大于0"),
    ERROR_SIGMOB_FILE_DOWNLOAD(600104, "文件下载错误"),
    ERROR_SIGMOB_BAD_REQUEST(600150, "内部错误，请联系运营或技术人员"),
    ERROR_SIGMOB_AD_TIME_OUT(600105, "下载广告超时"),
    ERROR_SIGMOB_PLAY_VIDEO(600106, "视频播放失败"),
    ERROR_SIGMOB_NOT_INIT(600900, "SDK未初始化"),
    ERROR_SIGMOB_PLACEMENTID_EMPTY(600901, "广告位为空"),
    ERROR_SIGMOB_INSTALL_FAIL(600903, "安装失败"),
    ERROR_SIGMOB_AD_DB_INSERT(600904, "插入数据库失败"),
    ERROR_SIGMOB_GDPR_DENIED(600905, "GDPR 未授权"),
    ERROR_SIGMOB_INIT_FAIL(600906, "SDK 初始化失败"),
    ERROR_SIGMOB_ADCONTAINER_IS_NULL(600907, "广告容器不能为NULL"),
    ERROR_SIGMOB_ADCONTAINER_NOT_VIEWGROUP(600908, "广告容器只允许为ViewGroup类型"),
    ERROR_OTHER(600999, ""),
    ERROR_SIGMOB_AD_PLAY(610002, "激励视频播放出错"),
    ERROR_SIGMOB_SPLASH_NOT_READY(610003, "开屏广告未准备好"),
    ERROR_SIGMOB_INFORMATION_LOSE(610004, "server下发的广告信息缺失关键信息"),
    ERROR_SIGMOB_FILE_MD5(610005, "下载的文件校验md5出错"),
    ERROR_SIGMOB_VIDEO_FILE(610008, "下载的视频文件出错"),
    ERROR_SIGMOB_AD_PLAY_CHECK_FAIL(610006, "激励视频播接口检查出错（广告过期或者未ready)"),
    ERROR_SIGMOB_AD_PLAY_HAS_PLAYING(610007, "激励视频播接口检查出错（激励视频当前有广告正在播放中)"),
    ERROR_SIGMOB_SPLASH_TIMEOUT(620001, "开屏广告加载超时"),
    ERROR_SIGMOB_SPLASH_UNSUPPORT_ORIENTATION(620002, "开屏广告不支持当前方向"),
    ERROR_SIGMOB_SPLASH_UNSUPPORT_RESOURCE(620003, "开屏广告不支持的资源类型"),
    ERROR_SPLASH_ADBLOCK(620900, "AD BLOCK"),
    ERROR_AD_ERROR(0, "AD ERROR"),
    RENDER_PROCESS_GONE_WITH_CRASH(620901, "RENDER PROCESS GONE WITH CRASH"),
    RENDER_PROCESS_GONE_UNSPECIFIED(620902, "RENDER PROCESS GONE UNSPECIFIED"),
    MRAID_LOAD_ERROR(620903, "MRAID LOAD ERROR"),
    VIDEO_CACHE_ERROR(620904, "VIDEO CACHE ERROR"),
    ERROR_NO_AD(200000, "无广告填充");

    private int a;
    private String message;

    WindAdError(int i, String str) {
        this.a = i;
        this.message = str;
    }

    public static WindAdError getWindAdError(int i) {
        for (WindAdError windAdError : values()) {
            if (windAdError.getErrorCode() == i) {
                return windAdError;
            }
        }
        return null;
    }

    public int getErrorCode() {
        return this.a;
    }

    public String getMessage() {
        return this.message;
    }

    public void setErrorMessage(int i, String str) {
        this.a = i;
        this.message = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.format("{ \"error_code\":%d, \"message\": %s }", Integer.valueOf(this.a), this.message);
    }
}
