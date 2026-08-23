package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMLogUtils;

/* compiled from: UMLogAnalytics.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class j {
    public static final String A = "MobclickAgent.setSecret方法参数secretkey不能为null，也不能为空字符串。|secretkey参数必须是非空 字符串。";
    public static final String B = "统计SDK常见问题索引贴 详见链接 http://developer.umeng.com/docs/66650/cate/66650";
    public static final String H = "检测到进入页面生命周期时尚未完成SDK初始化，请检查是否未在Application.onCreate函数中执行SDK初始化函数。";
    public static final String N = "MobclickAgent.onDeepLinkReceived方法Context参数不能为null。|参数Context需要指定ApplicationContext值。";
    public static final String O = "MobclickAgent.onDeepLinkReceived方法link参数不能为null，也不能为空字符串。|参数link必须为非空字符串。";
    public static final String P = "MobclickAgent.onDeepLinkReceived方法link参数长度超过限制。|参数link长度不能超过1024字符。";
    public static final String ar = "请在Application.onCreate函数中使用UMConfigure.preInit函数初始化友盟sdk";
    public static final String z = "MobclickAgent.setSecret方法参数context不能为null|参数Context需要指定ApplicationContext值。";
    public static final String a = "事件属性集合参数为空|onEvent接口必须传入非空的属性集合。详见问题链接 " + UMLogUtils.makeUrl("66946");
    public static final String b = "事件ID和保留字冲突|onEvent接口传入的事件ID不能和保留字冲突。详见问题链接 " + UMLogUtils.makeUrl("66946");

    /* renamed from: c, reason: collision with root package name */
    public static final String f1054c = "事件ID为null或者为空字符串|onEvent接口传入的事件ID不能为null，也不能为空字符串。详见问题链接 " + UMLogUtils.makeUrl("66946");
    public static final String d = "事件属性集合map没有加入K-V值|事件属性集合参数map必须添加K-V值。详见问题链接 " + UMLogUtils.makeUrl("66946");
    public static final String e = "事件属性集合map中key值和保留字冲突|事件属性集合map中key值不能和保留字冲突。详见问题链接 " + UMLogUtils.makeUrl("66946");
    public static final String f = "事件ID为null或者长度超过限制|事件ID不能为null、空串，且长度不能超过128个字符。详见问题链接 " + UMLogUtils.makeUrl("66946");
    public static final String g = "事件属性集合参数为空或者事件属性集合map没有加入K-V值|事件属性集合参数map必须添加K-V值。详见问题链接 " + UMLogUtils.makeUrl("66946");
    public static final String h = "事件属性集合map中key非法|事件属性集合参数map中key不能为非法的。详见问题链接 " + UMLogUtils.makeUrl("66946");
    public static final String i = "事件属性集合map中value为null|事件属性集合参数map中value不能为null。详见问题链接 " + UMLogUtils.makeUrl("66946");
    public static final String j = "事件属性集合map中value长度超过限制|事件属性集合参数map中value如果为字符串时，其长度不能超过256个字符。详见问题链接 " + UMLogUtils.makeUrl("66946");
    public static final String k = "事件标签为null或者为空字符串|onEvent接口传入的事件标签不能为null，也不能为空字符串。详见问题链接 " + UMLogUtils.makeUrl("66946");
    public static final String l = "事件ID为null或者长度超过限制，或事件标签长度超过限制|事件ID不能为null、空串，且长度不能超过128个字符。事件标签长度不能超过256个字符。详见问题链接 " + UMLogUtils.makeUrl("66946");
    public static final String m = "事件ID和保留字冲突|onEvent接口传入的事件ID不能和保留字冲突。详见问题链接 " + UMLogUtils.makeUrl("66946");
    public static final String n = "MobclickAgent.onResume接口参数不能为null|MobclickAgent.onResume接口参数应该传入当前Activity的上下文。详见问题链接 " + UMLogUtils.makeUrl("66948");
    public static final String o = "MobclickAgent.onResume接口参数不是Activity的上下文|MobclickAgent.onResume接口参数应该传入当前Activity的上下文。详见问题链接 " + UMLogUtils.makeUrl("66948");
    public static final String p = "MobclickAgent.onPause接口参数不能为null|MobclickAgent.onPause接口参数应该传入当前Activity的上下文。详见问题链接 " + UMLogUtils.makeUrl("66948");
    public static final String q = "MobclickAgent.onPause接口参数不是Activity的上下文|MobclickAgent.onPause接口参数应该传入当前Activity的上下文。详见问题链接 " + UMLogUtils.makeUrl("66948");
    public static final String r = "@ 遗漏了Mobclick.onResume函数调用|每个Activity的onResume中都必须调用MobclickAgent.onResume。详见问题链接 " + UMLogUtils.makeUrl("66948");
    public static final String s = "@ 遗漏了Mobclick.onPaused函数调用|每个Activity的onPaused中都必须调用MobclickAgent.onPaused。详见问题链接 " + UMLogUtils.makeUrl("66948");
    public static final String t = "MobclickAgent.onProfileSignIn接口参数 账号ID 不能为null|账号ID不能为空。详见问题链接 " + UMLogUtils.makeUrl("66951");
    public static final String u = "MobclickAgent.onProfileSignIn接口参数 账号ID 长度超过限制|账号ID 长度不能超过64个字符。详见问题链接 " + UMLogUtils.makeUrl("66951");
    public static final String v = "MobclickAgent.onProfileSignIn接口参数 账号来源 长度超过限制|账号来源 长度不能超过32个字符。详见问题链接 " + UMLogUtils.makeUrl("66951");
    public static final String w = "MobclickAgent.reportError方法参数context不能为null|参数Context需要指定ApplicationContext值。详见问题链接 " + UMLogUtils.makeUrl("66971");
    public static final String x = "MobclickAgent.reportError方法参数error不能为null，也不能为空字符串。|error参数必须是非空字符串。详见问题链接 " + UMLogUtils.makeUrl("66971");
    public static final String y = "MobclickAgent.reportError方法 Context和Throwable参数都不能为空。|参数Context需要指定ApplicationContext值，Throwable参数传入捕获到的异常对象。详见问题链接 " + UMLogUtils.makeUrl("66971");
    public static final String C = "MobclickAgent.onPageStart方法参数不能为null，也不能为空字符串。|参数viewName必须为非空字符串。详见链接 " + UMLogUtils.makeUrl("66975");
    public static final String D = "MobclickAgent.onPageEnd方法参数不能为null，也不能为空字符串。|参数viewName必须为非空 字符串。详见链接 " + UMLogUtils.makeUrl("66975");
    public static final String E = "对于页面@，onPageStart和onPageEnd调用对的参数不一致。|对于同一个页面，请先调用onPageStart，再调用onPageEnd。详见链接 " + UMLogUtils.makeUrl("66975");
    public static final String F = "对于页面@，请确保先依序成对调用onPageStart，onPageEnd接口，再调用onPageStart接口对其它页面进行统计。|对于任意一个页面，必须依序成对调用onPageStart以及onPageEnd，不能有遗漏。详见链接 " + UMLogUtils.makeUrl("66975");
    public static final String G = "对于页面@，请检查是否遗漏onPageStart接口调用。|对于任意一个页面，必须依序成对调用onPageStart以及onPageEnd，不能有遗漏。详见链接 " + UMLogUtils.makeUrl("66975");
    public static final String I = "当前发送策略为：启动时发送。详见链接 " + UMLogUtils.makeUrl("66976");
    public static final String J = "当前发送策略为: 间隔发送。间隔时间为：@秒。详见链接 " + UMLogUtils.makeUrl("66976");
    public static final String K = "当前发送策略为: 集成测试。但是SDK未切换到调试模式，所以后台设置未生效。|如想切换到集成测试发送策略，请调用UMConfigure.setLogEnabled(true)将SDK切换到调试模式。详见链接 " + UMLogUtils.makeUrl("66976");
    public static final String L = "当前发送策略为：集成测试。详见链接 " + UMLogUtils.makeUrl("66976");
    public static final String M = "当前发送策略为: 准实时发送。间隔时间为：@秒。详见链接 " + UMLogUtils.makeUrl("66976");
    public static final String Q = "发送数据时发生java.net.UnknownHostException异常|友盟后端对设备端证书验证失败。请确保设备端没有运行抓包代理类程序。详见链接 " + UMLogUtils.makeUrl("66978");
    public static final String R = "发送数据时发生javax.net.sslHandshakeException异常|导致友盟后端域名解析失败。请检查系统DNS服务器配置是否正确。详见链接 " + UMLogUtils.makeUrl("66978");
    public static final String S = "track接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接：" + UMLogUtils.makeUrl("67310");
    public static final String T = "registerSuperProperty接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接：" + UMLogUtils.makeUrl("67310");
    public static final String U = "unregisterSuperProperty接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接：" + UMLogUtils.makeUrl("67310");
    public static final String V = "getSuperProperty接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接: " + UMLogUtils.makeUrl("67310");
    public static final String W = "getSuperProperties接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接：" + UMLogUtils.makeUrl("67310");
    public static final String X = "clearSuperProperties接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接：" + UMLogUtils.makeUrl("67310");
    public static final String Y = "setFirstLaunchEvent接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接：" + UMLogUtils.makeUrl("67310");
    public static final String Z = "registerPreProperties接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接：" + UMLogUtils.makeUrl("67310");
    public static final String aa = "unregisterPreProperty接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接：" + UMLogUtils.makeUrl("67310");
    public static final String ab = "clearPreProperties接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接：" + UMLogUtils.makeUrl("67310");
    public static final String ac = "getPreProperties接口调用非法。|当前处于非DPLUS场景中，不能使用DPLUS相关接口，详见问题连接：" + UMLogUtils.makeUrl("67310");
    public static final String ad = "eventName为空，请检查|eventName参数不能为空，详见问题连接：" + UMLogUtils.makeUrl("67311");
    public static final String ae = "请注意：map为空|track接口的参数说明，详见问题连接：" + UMLogUtils.makeUrl("67311");
    public static final String af = "context参数为空｜context参数不能为空，详见问题连接：" + UMLogUtils.makeUrl("67312");
    public static final String ag = "propertyName参数或propertyValue参数为空｜propertyName、propertyValue参数不能为空，详见问题连接：" + UMLogUtils.makeUrl("67312");
    public static final String ah = "context参数为空|context参数不能为空，详见问题连接：" + UMLogUtils.makeUrl("67313");
    public static final String ai = "context参数为空|context参数不能为空，详见问题连接：" + UMLogUtils.makeUrl("67316");
    public static final String aj = "context参数为空|context参数不能为空，详见问题连接：" + UMLogUtils.makeUrl("67318");
    public static final String ak = "trackID参数为空|trackID参数不能为空，详见问题连接：" + UMLogUtils.makeUrl("67318");
    public static final String al = "context参数为空|context参数不能为空，详见问题连接：" + UMLogUtils.makeUrl("67319");
    public static final String am = "propertics参数为空|propertics参数不能为空，详见问题连接：" + UMLogUtils.makeUrl("67319");
    public static final String an = "context参数为空|context参数不能为空，详见问题连接：" + UMLogUtils.makeUrl("67320");
    public static final String ao = "未匹配到您传入的property参数|property参数不能匹配，" + UMLogUtils.makeUrl("67320");
    public static final String ap = "context参数为空|context参数不能为空，详见问题连接：" + UMLogUtils.makeUrl("67321");
    public static final String aq = "context参数为空|context参数不能为空，详见问题连接：" + UMLogUtils.makeUrl("67322");
}
