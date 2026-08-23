package com.umeng.commonsdk.debug;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UMLogCommon {
    public static final String SC_10003 = "统计SDK初始化成功";
    public static final String SC_10004 = "PUSH AppKey设置成功";
    public static final String SC_10005 = "PUSH Channel设置成功";
    public static final String SC_10006 = "Share AppKey设置成功";
    public static final String SC_10008 = "AppKey改变!!!";
    public static final String SC_10009 = "PUSH Secret设置成功";
    public static final String SC_10010 = "错误分析SDK初始化成功";
    public static final String SC_10011 = "请注意：您init接口中设置的AppKey是@，manifest中设置的AppKey是#，init接口设置的AppKey会覆盖manifest中设置的AppKey";
    public static final String SC_10012 = "基础组件库完整性自检通过。";
    public static final String SC_10013 = "基础组件库完整性自检未通过！请检查应用混淆配置。";
    public static final String SC_10014 = "APM SDK初始化成功";
    public static final String SC_10015 = "基础组件库9.3.x版本仅支持6.2.0及更高版本推送SDK、7.1.0及更高版本分享SDK。";
    public static final String SC_10016 = "传入key或value为空，setModuleTag调用无效，请检查传入参数。";
    public static final String SC_10017 = "传入key长度超限，setModuleTag调用无效，请检查传入参数。";
    public static final String SC_10018 = "传入value长度超限，setModuleTag调用无效，请检查传入参数。";
    public static final String SC_10019 = "传入业务类型参数错误，setModuleTag调用无效。";
    public static final String SC_10020 = "传入key为空，deleteModuleTag调用无效，请检查传入参数。";
    public static final String SC_10021 = "传入key长度超限，deleteModuleTag调用无效，请检查传入参数。";
    public static final String SC_10022 = "传入业务类型参数错误，deleteModuleTag调用无效。";
    public static final String SC_10023 = "传入key-value键值对个数已达30个，setModuleTag调用无效。";
    public static final String SC_10024 = "传入业务类型枚举值不能为null，setModuleTag调用无效，请检查传入参数。";
    public static final String SC_10025 = "传入业务类型枚举值不能为null，deleteModuleTag调用无效，请检查传入参数。";
    public static final String SC_10026 = "检测到SDK初始化过程遗漏UMConfigure.preInit函数，请参考【友盟+】合规指南: https://developer.umeng.com/docs/119267/detail/182050";
    public static final String SC_10028 = "检测到未调用隐私授权API，详情见：https://developer.umeng.com/docs/119267/detail/182050";
    public static final String SC_10001 = "不能在非主进程进行初始化|目前只能在主进程进行初始化，如何正确初始化请详见地址：" + UMLogUtils.makeUrl("67292");
    public static final String SC_10002 = "不能在非Application的onCreate方法中进行初始化|目前只能在Application的onCreate方法中进行初始化，如何正确初始化请详见地址：" + UMLogUtils.makeUrl("67292");
    public static final String SC_10007 = "AppKey不能为空|您必须正确设置AppKey，如何正确初始化请详见地址：" + UMLogUtils.makeUrl("67292");
}
