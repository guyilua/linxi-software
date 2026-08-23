package com.ss.android.socialbase.downloader.i;

import com.qq.e.comm.adevent.AdEventType;
import com.tencent.smtt.sdk.TbsListener;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {
    public static String a(int i) {
        if (i == 449) {
            return "Retry With";
        }
        if (i == 451) {
            return "Unavailable For Legal Reasons";
        }
        if (i == 600) {
            return "Unparseable Response Headers";
        }
        if (i == 509) {
            return "Bandwidth Limit Exceeded";
        }
        if (i == 510) {
            return "Not Extended";
        }
        switch (i) {
            case 100:
                return "Continue";
            case 101:
                return "Switching Protocols";
            case 102:
                return "Processing";
            default:
                switch (i) {
                    case 200:
                        return "OK";
                    case 201:
                        return "Created";
                    case 202:
                        return "Accepted";
                    case 203:
                        return "Non-Authoritative Information";
                    case 204:
                        return "No Content";
                    case 205:
                        return "Reset Content";
                    case 206:
                        return "Partial Content";
                    case 207:
                        return "Multi-Status";
                    default:
                        switch (i) {
                            case TbsListener.ErrorCode.ERROR_CODE_LOAD_BASE /* 300 */:
                                return "Multiple Choices";
                            case AdEventType.VIDEO_PAGE_OPEN /* 301 */:
                                return "Moved Permanently";
                            case 302:
                                return "Move Temporarily";
                            case 303:
                                return "See Other";
                            case 304:
                                return "Not Modified";
                            case 305:
                                return "Use Proxy";
                            case TbsListener.ErrorCode.THROWABLE_QBSDK_INIT /* 306 */:
                                return "Switch Proxy";
                            case TbsListener.ErrorCode.ERROR_CANLOADX5_RETURN_FALSE /* 307 */:
                                return "Temporary Redirect";
                            default:
                                switch (i) {
                                    case TbsListener.ErrorCode.INFO_CODE_BASE /* 400 */:
                                        return "Bad Request";
                                    case 401:
                                        return "Unauthorized";
                                    case 402:
                                        return "Payment Required";
                                    case 403:
                                        return "Forbidden";
                                    case 404:
                                        return "Not Found";
                                    case 405:
                                        return "Method Not Allowed";
                                    case 406:
                                        return "Not Acceptable";
                                    case 407:
                                        return "Proxy Authentication Required";
                                    case TbsListener.ErrorCode.INFO_CAN_NOT_DISABLED_BY_CRASH /* 408 */:
                                        return "Request Timeout";
                                    case TbsListener.ErrorCode.INFO_CAN_NOT_USE_X5_TBS_AVAILABLE /* 409 */:
                                        return "Conflict";
                                    case TbsListener.ErrorCode.INFO_CAN_NOT_USE_X5_TBS_NOTAVAILABLE /* 410 */:
                                        return "Gone";
                                    case TbsListener.ErrorCode.INFO_CAN_NOT_USE_X5_FINAL_REASON /* 411 */:
                                        return "Length Required";
                                    case TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX /* 412 */:
                                        return "Precondition Failed";
                                    case TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX /* 413 */:
                                        return "Request Entity Too Large";
                                    case TbsListener.ErrorCode.INFO_SDKINIT_IS_SYS_FORCED /* 414 */:
                                        return "Request-URI Too Long";
                                    case TbsListener.ErrorCode.INFO_INITX5_FALSE_DEFAULT /* 415 */:
                                        return "Unsupported Media Type";
                                    case 416:
                                        return "Requested Range Not Satisfiable";
                                    case TbsListener.ErrorCode.INFO_TEMP_CORE_EXIST_CONF_ERROR /* 417 */:
                                        return "Expectation Failed";
                                    case TbsListener.ErrorCode.INFO_CORE_EXIST_NOT_LOAD /* 418 */:
                                        return "I'm a teapot";
                                    default:
                                        switch (i) {
                                            case 421:
                                                return "Too Many Connections";
                                            case 422:
                                                return "Unprocessable Entity";
                                            case 423:
                                                return "Locked";
                                            case 424:
                                                return "Failed Dependency";
                                            case 425:
                                                return "Unordered Collection";
                                            case 426:
                                                return "Upgrade Required";
                                            default:
                                                switch (i) {
                                                    case TbsListener.ErrorCode.INFO_CODE_MINIQB /* 500 */:
                                                        return "Internal Server Error";
                                                    case TbsListener.ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_COUNTS /* 501 */:
                                                        return "Not Implemented";
                                                    case TbsListener.ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE /* 502 */:
                                                        return "Bad Gateway";
                                                    case TbsListener.ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS /* 503 */:
                                                        return "Service Unavailable";
                                                    case 504:
                                                        return "Gateway Timeout";
                                                    case TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_COUNTS /* 505 */:
                                                        return "HTTP Version Not Supported";
                                                    case TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_APKFILE /* 506 */:
                                                        return "Variant Also Negotiates";
                                                    case TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_NOTSUPPORT /* 507 */:
                                                        return "Insufficient Storage";
                                                    default:
                                                        return "";
                                                }
                                        }
                                }
                        }
                }
        }
    }
}
