package com.sigmob.sdk.mraid2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.common.utils.ReflectionUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.DownloadItem;
import com.czhj.volley.toolbox.FileDownloadRequest;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.r;
import com.sigmob.sdk.base.common.u;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.Ad;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.models.rtb.Template;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.mraid.o;
import com.sigmob.sdk.mraid2.c;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class g extends com.sigmob.sdk.mraid2.a {
    private static String o = "Mraid2Bridge";
    private static HashMap<String, g> r = new LinkedHashMap();
    private final g b;

    /* renamed from: c, reason: collision with root package name */
    private com.sigmob.sdk.mraid2.c f585c;
    private g d;
    private String e;
    private c f;
    private b g;
    private a h;
    private boolean i;
    private FrameLayout j;
    private LinearLayout k;
    private boolean l;
    private JSONObject m;
    private BaseAdUnit n;
    private final h p;
    private com.sigmob.sdk.base.common.g q;
    private HashMap<String, n> s;
    private f t;
    private final c.b u;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a(g gVar);

        void a(WindAdError windAdError);
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface b {
        LinearLayout a(g gVar, int i);

        g a(g gVar, JSONObject jSONObject);

        void a();

        void a(g gVar);

        void a(g gVar, BaseAdUnit baseAdUnit, JSONObject jSONObject);

        void b(g gVar);

        void b(g gVar, JSONObject jSONObject);
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface c {
        void a(g gVar, JSONObject jSONObject);

        void a(JSONObject jSONObject);

        void b(JSONObject jSONObject);
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private class d {
        private d() {
        }

        @JavascriptInterface
        public boolean canInstallByVid(String str, String str2) {
            String apkName;
            if (g.this.getAdUnitList() == null) {
                return false;
            }
            BaseAdUnit baseAdUnit = null;
            if (g.this.getAdUnitList() != null && g.this.getAdUnitList().size() > 0) {
                int i = 0;
                while (true) {
                    if (i >= g.this.getAdUnitList().size()) {
                        break;
                    }
                    BaseAdUnit baseAdUnit2 = g.this.getAdUnitList().get(i);
                    if (baseAdUnit2.getAd().vid.equals(str)) {
                        baseAdUnit = baseAdUnit2;
                        break;
                    }
                    i++;
                }
            }
            if (baseAdUnit == null) {
                return false;
            }
            if (TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(baseAdUnit.getApkName())) {
                    apkName = baseAdUnit.getApkName();
                } else if (TextUtils.isEmpty(baseAdUnit.getApkMd5())) {
                    apkName = "";
                } else {
                    apkName = baseAdUnit.getApkMd5() + ".apk";
                }
                str2 = apkName;
            }
            return baseAdUnit.canInstall(str2);
        }

        @JavascriptInterface
        public boolean canOpen(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return u.a(com.sigmob.sdk.b.e(), str);
        }

        @JavascriptInterface
        public boolean canOpenByVid(String str, String str2) {
            if (!TextUtils.isEmpty(str2)) {
                return g.this.getContext().getPackageManager().getLaunchIntentForPackage(str2) != null;
            }
            if (g.this.getAdUnitList() == null) {
                return false;
            }
            BaseAdUnit baseAdUnit = null;
            if (g.this.getAdUnitList() != null && g.this.getAdUnitList().size() > 0) {
                int i = 0;
                while (true) {
                    if (i >= g.this.getAdUnitList().size()) {
                        break;
                    }
                    BaseAdUnit baseAdUnit2 = g.this.getAdUnitList().get(i);
                    if (baseAdUnit2.getAd().vid.equals(str)) {
                        baseAdUnit = baseAdUnit2;
                        break;
                    }
                    i++;
                }
            }
            if (baseAdUnit == null) {
                return false;
            }
            return baseAdUnit.canOpen();
        }

        @JavascriptInterface
        public void hideSystemUI() {
            ThreadPoolFactory.MainThreadRun(new Runnable() { // from class: com.sigmob.sdk.mraid2.g.d.2
                @Override // java.lang.Runnable
                public void run() {
                    Activity c2 = com.sigmob.sdk.base.utils.f.c(g.this);
                    if (c2 != null) {
                        com.sigmob.sdk.videoplayer.d.f((Context) c2);
                    }
                }
            });
        }

        @JavascriptInterface
        public boolean isOpenListReport() {
            return (com.sigmob.sdk.base.l.a().O().isEmpty() || com.sigmob.sdk.base.services.b.a()) ? false : true;
        }

        @JavascriptInterface
        public void onOpenListReport() {
            com.sigmob.sdk.base.services.b.c();
        }

        @JavascriptInterface
        public void showSystemUI() {
            ThreadPoolFactory.MainThreadRun(new Runnable() { // from class: com.sigmob.sdk.mraid2.g.d.1
                @Override // java.lang.Runnable
                public void run() {
                    Activity c2 = com.sigmob.sdk.base.utils.f.c(g.this);
                    if (c2 != null) {
                        com.sigmob.sdk.videoplayer.d.h((Context) c2);
                    }
                }
            });
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class e {
        private View a;

        public e(View view) {
            this.a = view;
        }

        public int a() {
            return this.a.getLayoutParams().height;
        }

        public void a(int i) {
            this.a.getLayoutParams().height = i;
            this.a.requestLayout();
        }

        public int b() {
            return this.a.getLayoutParams().width;
        }

        public void b(int i) {
            this.a.getLayoutParams().width = i;
            this.a.requestLayout();
        }
    }

    public g(Context context, List<BaseAdUnit> list, FrameLayout frameLayout) {
        this(context, list, frameLayout, null, null);
        a(new d(), "sigandroidh5");
    }

    public g(Context context, List<BaseAdUnit> list, FrameLayout frameLayout, g gVar, JSONObject jSONObject) {
        super(context);
        this.l = false;
        this.n = null;
        this.p = new h() { // from class: com.sigmob.sdk.mraid2.g.1
            /* JADX INFO: Access modifiers changed from: private */
            public void a() {
                if (g.this.f585c != null) {
                    if (g.this.m != null) {
                        g.this.f585c.a(g.this.m);
                    }
                    g.this.f585c.d();
                }
                if (g.this.b != null && g.this.b.getMraidBridge() != null && !TextUtils.isEmpty(g.this.e)) {
                    g.this.b.getMraidBridge().c(g.this.e);
                }
                if (g.this.i) {
                    return;
                }
                g.this.i = true;
                if (g.this.h != null) {
                    g.this.h.a(g.this.d);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                Log.d(g.o, g.this.m + "-----------onPageFinished---------" + str);
                if (g.this.f585c.b()) {
                    a();
                } else {
                    g.this.f585c.a("javascript:(function () {\n    var uniqueId = 1;\n    var mraid = window.mraid = {};\n    var bridge = window.mraidbridge = {\n        nativeCallQueue: [],\n        nativeCallInFlight: false,\n        queue: {},\n    };\n    var bidResponse = {};\n    var bindData = undefined;\n    var isViewable = false;\n    var exposure = 0;\n    var sdkVersion = undefined;\n    var listeners = {};\n    var screenSize = {\n        width: 0,\n        height: 0\n    };\n    var currentAppOrientation = {\n        orientation: 0,\n        locked: true\n    };\n    var isNullOrEmpty = function(param) {\n        return param === null || param === undefined;\n    };\n    var EVENTS = mraid.EVENTS = {\n        error: 'error',\n        info: 'info',\n        ready: 'ready',\n        viewableChange: 'viewableChange',\n        sizeChange: 'sizeChange',\n        exposureChange: 'exposureChange',\n        playStateChanged: 'playStateChanged',\n        loadStateChanged: 'loadStateChanged',\n        currentTime: 'currentTime',\n        playEnd: 'playEnd',\n        pageChanged: 'pageChanged',\n        downloadStateChanged: 'downloadStateChanged',\n        safeAreaInsetsChange: 'safeAreaInsetsChange',\n    };\n\n    bridge.setScreenSize = function (val) {\n       if (screenSize.width != val.width || screenSize.height != val.height) {\n            screenSize = val;\n            broadcastEvent(listeners, EVENTS.sizeChange, val.width, val.height);\n        }\n    };\n    bridge.setIsViewable = function (val) {\n        if ((val ^ isViewable) == 1) {\n            isViewable = val;\n            broadcastEvent(listeners, EVENTS.viewableChange, isViewable)\n        }\n    };\n    bridge.setExposureChange = function (val) {\n        if (val != exposure) {\n            exposure = val;\n            broadcastEvent(listeners, EVENTS.exposureChange, val)\n        }\n    };\n    bridge.setBindData = function (val) { bindData = val; };\n    bridge.sdkVersion = function (val) { sdkVersion = val; }\n    bridge.orientation = function (val) { currentAppOrientation = val; }\n    bridge.onStorageChanged = function (evt) {\n        const key = 'storage_' + evt.key;\n        broadcastEvent(listeners, key, evt);\n    };\n    bridge.setBidResponse = function (val) {\n        bidResponse = val;\n    };\n    bridge.onChangeEvent = function(evt) {\n        broadcastEvent(listeners, evt.event, evt.data);\n    };\n    bridge.setvdReadyToPlay = function (val) {\n        let vpaid = bridge.queue[val.uniqueId]\n        broadcastEvent(vpaid.handlers, EVENTS.ready, val);\n    };\n    bridge.setvdPlayStateChanged = function (val) {\n        let vpaid = bridge.queue[val.uniqueId]\n        broadcastEvent(vpaid.handlers, EVENTS.playStateChanged, val);\n    };\n    bridge.setvdLoadStateChanged = function (val) {\n        let vpaid = bridge.queue[val.uniqueId]\n        broadcastEvent(vpaid.handlers, EVENTS.loadStateChanged, val);\n    };\n    bridge.setvdPlayCurrentTime = function (val) {\n        let vpaid = bridge.queue[val.uniqueId]\n        broadcastEvent(vpaid.handlers, EVENTS.currentTime, val);\n    };\n    bridge.setvdPlayToEnd = function (val) {\n        let vpaid = bridge.queue[val.uniqueId]\n        broadcastEvent(vpaid.handlers, EVENTS.playEnd, val);\n    };\n    bridge.setvdPlayError = function (val) {\n        let vpaid = bridge.queue[val.uniqueId]\n        broadcastEvent(vpaid.handlers, EVENTS.error, val);\n    };\n    bridge.onChangeFired = function (val) {\n        let obj = bridge.queue[val.uniqueId];\n        broadcastEvent(obj.handlers, val.event, val.args);\n    };\n    bridge.notify = function (val) {\n        console.log(val)\n        if (val.event.startsWith('fire_')) {\n            broadcastEvent(listeners, val.event)\n            return\n        }\n\n        if (val.event.startsWith('dispatch_')) {\n            broadcastEvent(listeners, val.event)\n            mraid.removeEventListener(val.event);\n            return\n        }\n\n        if (val.event.startsWith('animation_')) {\n            broadcastEvent(listeners, val.event)\n            mraid.removeEventListener(val.event);\n            return\n        }\n\n        broadcastEvent(listeners, val.event, val.message)\n        mraid.removeEventListener(val.event);\n    };\n    bridge.notifyPageChangeEvent = function (val) {\n        broadcastEvent(listeners, EVENTS.pageChanged, val)\n    };\n    bridge.notifyApkDownloadStateEvent = function (val) {\n        broadcastEvent(listeners, EVENTS.downloadStateChanged, val)\n    };\n    bridge.setWVFinished = function (val) {\n        let web = bridge.queue[val.uniqueId]\n        broadcastEvent(web.handlers, EVENTS.ready);\n    };\n    bridge.setWVError = function (val) {\n        let web = bridge.queue[val.uniqueId]\n        broadcastEvent(web.handlers, EVENTS.error, val.error);\n    };\n    bridge.postMessage = function (msg) {\n        var msgStr = JSON.stringify(msg);\n        sigandroid.postMessage(msgStr);\n    }\n    bridge.syncMessage = function (msg) {\n        if (this.nativeCallInFlight) {\n            this.nativeCallQueue.push(msg)\n        } else {\n            this.nativeCallInFlight = true;\n            var msgStr = JSON.stringify(msg);\n            sigandroid.postMessage(msgStr);\n        }\n    }\n    bridge.nativeCallComplete = function (command) {\n        console.log('nativeCallCompletecommand = ' + command)\n        if (this.nativeCallQueue.length === 0) {\n            this.nativeCallInFlight = false;\n            return\n        }\n        var nextCall = this.nativeCallQueue.shift();\n        bridge.postMessage(nextCall);\n    };\n    bridge.onMotionChanged = function (evt) {\n        const key = 'motion_' + evt.type+evt.event;\n        delete evt.type;\n        delete evt.event;\n        broadcastEvent(listeners, key, evt);\n    };\n    var changeHandlers = {\n        onChangeEvent: bridge.onChangeEvent,\n        vdReadyToPlay: bridge.setvdReadyToPlay,\n        vdPlayStateChanged: bridge.setvdPlayStateChanged,\n        vdLoadStateChanged: bridge.setvdLoadStateChanged,\n        vdPlayCurrentTime: bridge.setvdPlayCurrentTime,\n        vdPlayToEnd: bridge.setvdPlayToEnd,\n        vdPlayError: bridge.setvdPlayError,\n        wvFinished: bridge.setWVFinished,\n        wvError: bridge.setWVError,\n        screenSize: bridge.setScreenSize,\n        viewable: bridge.setIsViewable,\n        exposure: bridge.setExposureChange,\n        bindData: bridge.setBindData,\n        sdkVersion: bridge.sdkVersion,\n        orientation: bridge.orientation,\n        storageChanged: bridge.onStorageChanged,\n        bidResponse: bridge.setBidResponse,\n        notify: bridge.notify,\n        motionChanged: bridge.onMotionChanged,\n        onChangeFired: bridge.onChangeFired,\n    };\n    bridge.fireChangeEvent = function (properties) {\n        for (let p in properties) {\n            if (properties.hasOwnProperty(p)) {\n                let handler = changeHandlers[p];\n                try {\n                    handler(properties[p])\n                } catch (error) {\n                    console.log('error: ' + error.message);\n                }\n            }\n        }\n    };\n\n    var Storage = function (type) {\n        this.setItem = function (key, value) {\n            sigandroid.storage(JSON.stringify({ event: 'setItem', args: { type, key, value } }))\n        };\n        this.getItem = function (key) {\n            var result = sigandroid.storage(JSON.stringify({ event: 'getItem', args: { type, key } }));\n            return result\n        };\n        this.removeItem = function (key) {\n            sigandroid.storage(JSON.stringify({ event: 'removeItem', args: { type, key } }))\n        };\n        this.clear = function () {\n            sigandroid.storage(JSON.stringify({ event: 'clear', args: { type } }))\n        };\n        this.length = function () {\n            var result = sigandroid.storage(JSON.stringify({ event: 'length', args: { type } }));\n            return parseInt(result)\n        };\n        this.addEventListener = function (key, callback) {\n            sigandroid.storage(JSON.stringify({ event: 'addEventListener', args: { type, key } }))\n            mraid.addEventListener('storage_' + key, callback);\n        };\n    };\n    var EventListeners = function (event) {\n        this.event = event;\n        this.count = 0;\n        var listeners = {};\n        this.add = function (func) {\n            var id = String(func);\n            if (!listeners[id]) {\n                listeners[id] = func;\n                this.count++\n            }\n        };\n        this.remove = function (func) {\n            var id = String(func);\n            if (listeners[id]) {\n                listeners[id] = null;\n                delete listeners[id];\n                this.count--;\n                return true\n            } else {\n                return false\n            }\n        };\n        this.removeAll = function () {\n            for (var id in listeners) {\n                if (listeners.hasOwnProperty(id)) this.remove(listeners[id])\n            }\n        };\n        this.broadcast = function (args) {\n            for (var id in listeners) {\n                if (listeners.hasOwnProperty(id)) listeners[id].apply(mraid, args)\n            }\n        };\n        this.toString = function () {\n            var out = [event, ':'];\n            for (var id in listeners) {\n                if (listeners.hasOwnProperty(id)) out.push('|', id, '|')\n            }\n            return out.join('')\n        }\n    };\n    var contains = function (value, array) {\n        if (value.indexOf('motion_') == 0) {\n            return true;\n        }\n        if (value.indexOf('storage_') == 0) {\n            return true;\n        }\n        if (value.indexOf('fire_') == 0) {\n            return true;\n        }\n        if (value.indexOf('dispatch_') == 0) {\n            return true;\n        }\n        if (value.indexOf('animation_') == 0) {\n            return true;\n        }\n        if (value.indexOf('open_') == 0) {\n            return true;\n        }\n        if (value.indexOf('lance_') == 0) {\n            return true;\n        }\n\n        for (var i in array) {\n            if (array[i] === value) return true\n        }\n        return false\n    };\n    var broadcastEvent = function () {\n        var args = new Array(arguments.length);\n        var l = arguments.length;\n        for (var i = 0; i < l; i++) args[i] = arguments[i];\n        var handlers = args.shift();\n        var event = args.shift();\n        if (handlers[event]) {\n            handlers[event].broadcast(args)\n        }\n    };\n    var addEventListener = function (handlers, event, listener) {\n        if (!event || !listener) {\n            broadcastEvent(listeners, EVENTS.error, 'Both event and listener are required.', 'addEventListener')\n        } else {\n            if (!handlers[event]) {\n                handlers[event] = new EventListeners(event)\n            }\n            handlers[event].add(listener)\n        }\n    };\n    var removeEventListener = function (funs, event, listener) {\n        if (!event) {\n            broadcastEvent(listeners, EVENTS.error, 'Event is required.', 'removeEventListener');\n            return\n        }\n        if (listener) {\n            var success = false;\n            if (funs[event]) {\n                success = funs[event].remove(listener)\n            }\n            if (!success) {\n                broadcastEvent(listeners, EVENTS.error, 'Listener not currently registered for event.', 'removeEventListener');\n                return\n            }\n        } else if (funs && funs[event]) {\n            funs[event].removeAll()\n        }\n        if (funs[event] && funs[event].count === 0) {\n            funs[event] = null;\n            delete funs[event]\n        }\n    };\n    \n    var Motion = function(type) {\n        this.uniqId = 'motion_' + (uniqueId++) + '_' + new Date().getTime();\n        this.event = 'motion';\n        var events = [];\n        this.handlers = {};\n        bridge.queue[this.uniqId] = this;\n        this.init = function (sensitivity) {\n            bridge.syncMessage({ event: this.event, subEvent: 'init',args: { uniqueId: this.uniqId, type, sensitivity} });\n        };\n        this.initSensitivityRaw = function (sensitivity_raw) {\n            bridge.syncMessage({ event: this.event, subEvent: 'init_sensitivity_raw', args: { uniqueId: this.uniqId, type, sensitivity_raw } });\n        };\n        this.destroy = function () {\n            bridge.syncMessage({ event: this.event, subEvent: 'destroy',args: { uniqueId: this.uniqId, type } });\n        };\n        this.addEventListener = function (event,listener) {\n            addEventListener(this.handlers, event, listener);\n        };\n        this.removeEventListener = function (event, listener) {\n            removeEventListener(this.handlers, event, listener);\n        };\n    };\n    bridge.fireReadyEvent = function () { broadcastEvent(listeners, EVENTS.ready) };\n    bridge.frame = function (event, uniqId, x, y, w, h) {\n        if (!w || !h) {\n            broadcastEvent(listeners, EVENTS.error, 'x,y,w,h is required!', 'frame');\n        } else {\n            bridge.syncMessage({ event: event, subEvent: 'frame', args: { uniqueId: uniqId, frame: { x, y, w, h } } });\n        }\n    }\n    var safeAreaInsets = {\n        top: 0,\n        left: 0,\n        bottom: 0,\n        right: 0\n    };\n    bridge.setSafeAreaInsets = function(top, left, bottom, right) {\n        if (safeAreaInsets.top == top && safeAreaInsets.left == left && safeAreaInsets.bottom == bottom && safeAreaInsets.right == right) {\n            return;\n        }\n        safeAreaInsets = {\n            top: top,\n            left: left,\n            bottom: bottom,\n            right: right\n          };\n         broadcastEvent(listeners,EVENTS.safeAreaInsetsChange, top, left, bottom, right);\n    };\n    mraid.getSafeAreaInsets = function() {\n        return {\n            top: safeAreaInsets.top,\n            left: safeAreaInsets.left,\n            bottom: safeAreaInsets.bottom,\n            right: safeAreaInsets.right\n        };\n    };\n   mraid.MotionView = function(type) {\n        this.uniqId = 'motion_view_' + (uniqueId++) + '_' + new Date().getTime();\n        this.event = 'motionView';\n        this.rect = {x: 0, y: 0, w: 0, h: 0};\n        this.handlers = {};\n        bridge.queue[this.uniqId] = this;\n        bridge.syncMessage({ event: this.event, subEvent: 'init', args: { uniqueId: this.uniqId, type } });\n        this.frame = function (x, y, w, h) {\n            this.rect = {x, y, w, h};\n            bridge.frame(this.event, this.uniqId, x, y, w, h);\n        };\n        this.hidden = function (hidden) {\n            bridge.syncMessage({ event: this.event, subEvent: 'hidden', args: { uniqueId: this.uniqId, hidden } });\n        };\n        this.sensitivity = function (sensitivity) {\n            bridge.syncMessage({ event: this.event, subEvent: 'sensitivity', args: { uniqueId: this.uniqId, sensitivity } });\n        };\n        this.sensitivityRaw = function (sensitivity_raw) {\n            bridge.syncMessage({ event: this.event, subEvent: 'sensitivity_raw', args: { uniqueId: this.uniqId, sensitivity_raw } });\n        };\n        this.start = function () {\n            bridge.syncMessage({ event: this.event, subEvent: 'start', args: { uniqueId: this.uniqId } });\n        };\n        this.destroy = function () {\n            bridge.syncMessage({ event: this.event, subEvent: 'destroy', args: { uniqueId: this.uniqId } });\n        };\n        this.addEventListener = function (event, listener) {\n            addEventListener(this.handlers, event, listener);\n        };\n        this.removeEventListener = function (event, listener) {\n            removeEventListener(this.handlers, event, listener);\n        };\n    };\n    mraid.Vpaid = function (val) {\n        if (typeof (val) == 'object' && val.uniqId) {\n            this.uniqId = val.uniqId;\n            uniqueId++;\n            this.rect = val.rect;\n        } else {\n            this.uniqId = 'vd_' + (uniqueId++) + '_' + new Date().getTime();\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'init', args: { uniqueId: this.uniqId } });\n            this.rect = { x: 0, y: 0, w: 0, h: 0 };\n        }\n        bridge.queue[this.uniqId] = this;\n        this.handlers = {};\n        this.assetURL = function (URL,useProxy = true) {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'assetURL', args: { uniqueId: this.uniqId, URL: URL,proxy:useProxy} });\n        };\n        this.play = function () {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'play', args: { uniqueId: this.uniqId } });\n        };\n        this.replay = function () {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'replay', args: { uniqueId: this.uniqId } });\n        };\n        this.pause = function () {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'pause', args: { uniqueId: this.uniqId } });\n        };\n        this.stop = function () {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'stop', args: { uniqueId: this.uniqId } });\n        };\n        this.muted = function (flag) {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'muted', args: { uniqueId: this.uniqId, muted: flag } });\n        };\n        this.seek = function (val) {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'seek', args: { uniqueId: this.uniqId, seekTime: val } });\n        };\n        this.frame = function (x, y, w, h) {\n            this.rect = { x, y, w, h };\n            bridge.frame('vpaid', this.uniqId, x, y, w, h)\n        };\n        this.addEventListener = function (event, listener) {\n            addEventListener(this.handlers, event, listener);\n        };\n        this.removeEventListener = function (event, listener) {\n            removeEventListener(this.handlers, event, listener);\n        };\n    };\n\n    function callNativeFunc(kwargs, func) {\n        if (kwargs === undefined) return undefined;\n        if (func === undefined) return undefined;\n        kwargs['func'] = func;\n        var returnStr = sigandroid.func(JSON.stringify(kwargs));\n        if (returnStr) {\n            try {\n                return JSON.parse(returnStr)\n            } catch (e) {\n                return JSON.stringify(returnStr)\n            }\n        } else {\n            console.log('-------callNativeFunc return null-----');\n        }\n    };\n\n    mraid.Color = function(red, green, blue, alpha) {\n        this.red = red;\n        this.green = green;\n        this.blue = blue;\n        this.alpha = alpha;\n    };\n   mraid.backgroundColor = function (color) {\n        bridge.postMessage({ event: 'backgroundColor', args: { red: color.red, green: color.green, blue: color.blue, alpha: color.alpha } });\n    };\n   mraid.uniqId = function () {\n        return sigandroid.getUniqueId()\n    };    mraid.Timer = function (interval, repeats = false, callback) {\n        if (!interval || interval <= 0) return;\n        this.uniqId = 'timer_' + (uniqueId++) + '_' + new Date().getTime();\n        bridge.syncMessage({\n            event: 'timer',\n            subEvent: 'init',\n            args: {\n                uniqueId: this.uniqId,\n                interval: interval,\n                repeats: repeats\n            }\n        });\n        this.fire = function () {\n            mraid.addEventListener('fire_' + this.uniqId, callback);\n            bridge.syncMessage({ event: 'timer', subEvent: 'fire', args: { uniqueId: this.uniqId } });\n        };\n        this.invalidate = function () {\n            mraid.removeEventListener('fire_' + this.uniqId, callback);\n            bridge.syncMessage({ event: 'timer', subEvent: 'invalidate', args: { uniqueId: this.uniqId } });\n        };\n        this.pause = function () {\n            bridge.syncMessage({ event: 'timer', subEvent: 'pause', args: { uniqueId: this.uniqId } });\n        };\n        this.resume = function () {\n            bridge.syncMessage({ event: 'timer', subEvent: 'resume', args: { uniqueId: this.uniqId } });\n        };\n    };\n    mraid.WebView = function () {\n        this.uniqId = 'wv_' + (uniqueId++) + '_' + new Date().getTime();\n        this.event = 'webView'\n        this.handlers = {}\n        this.rect = { x: 0, y: 0, w: 0, h: 0 };\n        var args = undefined;\n        if (arguments) {\n            args = JSON.stringify(arguments);\n        }\n        bridge.queue[this.uniqId] = this;\n        bridge.syncMessage({ event: this.event, subEvent: 'init', args: { uniqueId: this.uniqId, args } });\n        this.frame = function (x, y, w, h) {\n            this.rect = { x, y, w, h };\n            bridge.frame(this.event, this.uniqId, x, y, w, h)\n        };\n        this.loadURL = function (url) {\n            bridge.syncMessage({ event: this.event, subEvent: 'loadURL', args: { uniqueId: this.uniqId, url } });\n        };\n        this.loadURLByPackage = function (URL) {\n            bridge.syncMessage({ event: this.event, subEvent: 'loadURLByPackage', args: { uniqueId: this.uniqId, URL } });\n        };\n        this.loadHTMLString = function (html) {\n            bridge.syncMessage({ event: this.event, subEvent: 'loadHTMLString', args: { uniqueId: this.uniqId, html } });\n        };\n        this.loadById = function (id) {\n            bridge.syncMessage({ event: this.event, subEvent: 'loadId', args: { uniqueId: this.uniqId, id } });\n        };\n        this.reload = function (id) {\n            bridge.syncMessage({ event: this.event, subEvent: 'reload', args: { uniqueId: this.uniqId } });\n        };\n        this.stopLoading = function (id) {\n            bridge.syncMessage({ event: this.event, subEvent: 'stopLoading', args: { uniqueId: this.uniqId } });\n        };\n        this.addEventListener = function (event, listener) {\n            addEventListener(this.handlers, event, listener);\n        };\n        this.removeEventListener = function (event, listener) {\n            removeEventListener(this.handlers, event, listener);\n        };\n    };\n    mraid.motion = {\n        shake: new Motion('shake'),\n        twist: new Motion('twist'),\n        slope: new Motion('slope'),\n        swing: new Motion('swing'),\n    };\n    mraid.blurEffect = {\n        init: function (color) {\n            bridge.syncMessage({ event: 'blurEffect', subEvent: 'init', args: { red: color.red, green: color.green, blue: color.blue, alpha: color.alpha } });\n        },\n        destroy: function () {\n            bridge.syncMessage({ event: 'blurEffect', subEvent: 'destroy' });\n        },\n    };\n    mraid.localStorage = new Storage(1);\n    mraid.sessionStorage = new Storage(2);\n    mraid.getVersion = () => sdkVersion;\n    mraid.getOs = () => 2;\n    mraid.isViewable = () => isViewable;\n    mraid.getState = () => state;\n    mraid.version = () => '2.2'; \n     mraid.getScreenSize = () => screenSize;\n    mraid.getCurrentAppOrientation = () => currentAppOrientation;\n    mraid.bidResponse = () => bidResponse;\n    mraid.visible = function(visible) {\n        bridge.syncMessage({ event: 'visible', args: {visible} });\n    };\n    mraid.feedbackByVid = function(vid) {\n        bridge.postMessage({ event: 'feedbackByVid', args: { vid } });\n    };\n    mraid.openByVid = function(vid, data, cbObj = {}) {\n        var event = 'open_' + new Date().getTime();\n        if (cbObj.onSuccess) {\n            mraid.addEventListener(event + \"_success\", cbObj.onSuccess)\n        }\n        if (cbObj.onFailed) {\n            mraid.addEventListener(event + \"_failed\", cbObj.onFailed)\n        }\n        bridge.syncMessage({ event: 'openByVid', args: {vid, event, data} });\n    };\n    mraid.open = function (url, data, cbObj = {}) {\n        var event = 'open_' + new Date().getTime();\n        if (cbObj.onSuccess) {\n            mraid.addEventListener(event + \"_success\", cbObj.onSuccess)\n        }\n        if (cbObj.onFailed) {\n            mraid.addEventListener(event + \"_failed\", cbObj.onFailed)\n        }\n        bridge.postMessage({ event: 'open', args: { url, event, data } })\n    };\n   mraid.subscribe = function(uniqId, event, listener) {\n        if (isNullOrEmpty(uniqId) || isNullOrEmpty(event)) {\n            broadcastEvent(listeners, EVENTS.error, 'Both event and uniqId are required.', 'subscribe');\n            return;\n        }\n        let key = uniqId + '~' + event;\n        addEventListener(listeners, key, listener);\n        if (listeners[key] && listeners[key].count == 1) {\n            bridge.syncMessage({ event: 'subscribe', args: { uniqId, event } });\n        }\n    };\n    mraid.unsubscribe = function(uniqId, event, listener) {\n        if (isNullOrEmpty(uniqId) || isNullOrEmpty(event)) {\n            broadcastEvent(listeners, EVENTS.error, 'Both event and uniqId are required.', 'unsubscribe');\n            return;\n        }\n        let key = uniqId + '~' + event;\n        removeEventListener(listeners, key, listener);\n        if (isNullOrEmpty(listeners[key])) {\n            bridge.syncMessage({ event: 'unsubscribe', args: { uniqId, event } });\n        }\n    };\n    mraid.publish = function(event, data) {\n        if (isNullOrEmpty(event)) {\n            broadcastEvent(listeners, EVENTS.error, 'event are required.', 'publish');\n            return;\n        }\n        bridge.syncMessage({ event: 'publish', args: {event, data} });\n    };\n    mraid.ready = function () { bridge.postMessage({ event: 'ready' }); };\n    mraid.close = function () { bridge.postMessage({ event: 'close' }) };\n    mraid.unload = function () { bridge.postMessage({ event: 'unload' }) }\n    mraid.addSubview = function (val) { bridge.syncMessage({ event: 'addSubview', args: { uniqueId: val.uniqId } }); };\n    mraid.belowSubview = function (val) { bridge.syncMessage({ event: 'belowSubview', args: { uniqueId: val.uniqId } }); };\n    mraid.useScrollView = function (flag) { bridge.syncMessage({ event: 'useScrollView', args: { flag } }); };\n    mraid.touchStart = function (x, y) { bridge.postMessage({ event: 'touchStart', args: { x, y } }); };\n    mraid.touchMove = function (x, y) { bridge.postMessage({ event: 'touchMove', args: { x, y } }); };\n    mraid.touchEnd = function (x, y) { bridge.postMessage({ event: 'touchEnd', args: { x, y } }); };\n    mraid.dispatchAfter = function (delay, callback) {\n        var event = 'dispatch_' + new Date().getTime();\n        mraid.addEventListener(event, callback);\n        bridge.postMessage({ event: 'dispatch_after', args: { 'event': event, 'delay': delay } });\n    };\n    mraid.useCustomClose = function (flag) { bridge.postMessage({ event: 'useCustomClose', args: { flag } }) };\n    mraid.addEventListener = function (event, listener) { addEventListener(listeners, event, listener); };\n    mraid.removeEventListener = function (event, listener) { removeEventListener(listeners, event, listener); };\n    mraid.arguments = () => bindData;\n    mraid.reward = function () {\n        bridge.postMessage({ event: 'reward' })\n    };\n    mraid.addMacro = function (key, value, vid) {\n        callNativeFunc({ event: 'addMacro', args: { key, value, vid } }, 'handleMacro:')\n    };\n    mraid.addAllMacros = function (maps, vid) {\n        callNativeFunc({ event: 'addAllMacros', args: { maps, vid } }, 'handleMacro:')\n    };\n    mraid.removeMacro = function (key, vid) {\n        callNativeFunc({ event: 'removeMacro', args: { key, vid } }, 'handleMacro:')\n    };\n    mraid.clearMacro = function (vid) {\n        callNativeFunc({ event: 'clearMacro', args: { vid } }, 'handleMacro:')\n    };\n    mraid.getMacro = function (key, vid) {\n        return callNativeFunc({ event: 'getMacro', args: { key, vid } }, 'handleMacro:')\n    };\n    mraid.addDclog = function (data, vid) {\n        return callNativeFunc({ data, vid }, 'addDclog:')\n    };\n    mraid.device = function () {\n        var device = sigandroid.getDeviceInfo()\n        if (device) {\n            return JSON.parse(device)\n        }\n    };\n    mraid.tracking = function (urls, event, data) {\n        if (urls.length > 0 || event) {\n            return callNativeFunc({ urls, event, data }, 'tracking:')\n        }\n    };\n    mraid.android = {\n        getApKDownloadProcess: function (vid) {\n            var process = sigandroidapk.getApKDownloadProcessId(vid);\n            return process\n        },\n        addEventListener: function (event, vid, listener) {\n            sigandroidapk.registerDownloadEvent(vid);\n            addEventListener(listeners, event, listener);\n        },\n        removeEventListener: function (event, listener) {\n            removeEventListener(listeners, event, listener);\n        }\n    };\n\n    mraid.loadAd = function (data, callback) {\n        var event = 'lance_' + new Date().getTime();\n        mraid.addEventListener(event, callback);\n        bridge.postMessage({ event: 'mraidLoadAd', args: { 'event': event, 'data': data } });\n    };\n\n    mraid.setCurPlayAd = function (vid) { bridge.postMessage({ event: 'curPlayAd', args: { vid } }); };\n\n    mraid.animation = function (duration, obj, from, to, completion) {\n        const fromRect = { x: from.x, y: from.y, w: from.w, h: from.h };\n        const toRect = { x: to.x, y: to.y, w: to.w, h: to.h };\n        var event = 'animation_' + new Date().getTime();\n        mraid.addEventListener(event, completion);\n        bridge.postMessage({ event: 'animation', args: { 'event': event, duration, uniqueId: obj.uniqId, from: fromRect, to: toRect } });\n    };\n\n    (function () {\n        bridge.postMessage({ event: 'mraidJsLoaded' })\n    })();\n\n    console.log('mraid ---- successed!!!')\n}());\n", new ValueCallback() { // from class: com.sigmob.sdk.mraid2.g.1.1
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(Object obj) {
                            a();
                        }
                    });
                }
            }

            @Override // com.sigmob.sdk.base.h, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // com.sigmob.sdk.base.h, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                ae.a("h5_error", "mraid2", i, str2 + " error:" + str, (WindAdRequest) null, (LoadAdRequest) null, g.this.getAdUnitList().get(0), (ae.a) null);
                if (g.this.b == null || g.this.b.getMraidBridge() == null || TextUtils.isEmpty(g.this.e)) {
                    return;
                }
                g.this.b.getMraidBridge().a(g.this.e, i, str);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                SigmobLog.i("onReceivedError:" + webResourceError.toString());
                int i = Build.VERSION.SDK_INT;
                if (i < 21 || i < 23) {
                    return;
                }
                ae.a("h5_error", "mraid2", 0, webResourceRequest.getUrl() + " error:" + ((Object) webResourceError.getDescription()), (WindAdRequest) null, (LoadAdRequest) null, g.this.getAdUnitList().get(0), (ae.a) null);
                if (g.this.b == null || g.this.b.getMraidBridge() == null || TextUtils.isEmpty(g.this.e)) {
                    return;
                }
                g.this.b.getMraidBridge().a(g.this.e, webResourceError.getErrorCode(), "" + ((Object) webResourceError.getDescription()));
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (Build.VERSION.SDK_INT >= 21) {
                    ae.a("h5_error", "mraid2", webResourceResponse.getStatusCode(), webResourceRequest.getUrl().toString(), (WindAdRequest) null, (LoadAdRequest) null, g.this.getAdUnitList().get(0), (ae.a) null);
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                Log.d(g.o, "-----------onRenderProcessGone---------" + renderProcessGoneDetail);
                WindAdError windAdError = Build.VERSION.SDK_INT >= 26 ? (renderProcessGoneDetail == null || !renderProcessGoneDetail.didCrash()) ? WindAdError.RENDER_PROCESS_GONE_UNSPECIFIED : WindAdError.RENDER_PROCESS_GONE_WITH_CRASH : null;
                SigmobLog.e("handleRenderProcessGone " + windAdError);
                if (g.this.h != null) {
                    g.this.h.a(windAdError);
                }
                g.this.a();
                return true;
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                int i;
                int i2;
                if (str == null) {
                    return false;
                }
                try {
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (!str.startsWith("http") && !str.startsWith(BaseConstants.SCHEME_HTTPS)) {
                    if (g.this.n != null) {
                        List<String> list2 = g.this.n.getAdSetting() != null ? g.this.n.getAdSetting().scheme_white_list : null;
                        if (list2 != null && list2.size() > 0) {
                            while (i2 < list2.size()) {
                                String str2 = list2.get(i2);
                                i2 = (str.startsWith(str2) || str2.equals("*")) ? 0 : i2 + 1;
                                u.a(g.this.getContext(), Uri.parse(str));
                                return true;
                            }
                        }
                    } else {
                        for (int i3 = 0; i3 < g.this.getAdUnitList().size(); i3++) {
                            BaseAdUnit baseAdUnit = g.this.getAdUnitList().get(i3);
                            List<String> list3 = baseAdUnit.getAdSetting() != null ? baseAdUnit.getAdSetting().scheme_white_list : null;
                            if (list3 != null && list3.size() > 0) {
                                while (i < list3.size()) {
                                    String str3 = list3.get(i);
                                    i = (str.startsWith(str3) || str3.equals("*")) ? 0 : i + 1;
                                    u.a(g.this.getContext(), Uri.parse(str));
                                    return true;
                                }
                            }
                        }
                    }
                    return true;
                }
                webView.loadUrl(str);
                return true;
            }
        };
        this.s = new LinkedHashMap();
        this.u = new c.b() { // from class: com.sigmob.sdk.mraid2.g.3
            @Override // com.sigmob.sdk.mraid2.c.b
            public void a() {
                if (g.this.g != null) {
                    g.this.g.a(g.this.d);
                }
            }

            @Override // com.sigmob.sdk.mraid2.c.b
            public void a(BaseAdUnit baseAdUnit, JSONObject jSONObject2) {
                if (g.this.g != null) {
                    g.this.g.a(g.this.d, baseAdUnit, jSONObject2);
                }
            }

            @Override // com.sigmob.sdk.mraid2.c.b
            public void a(String str) {
                if (!TextUtils.isEmpty(str)) {
                    for (int i = 0; i < g.this.getAdUnitList().size(); i++) {
                        g gVar2 = g.this;
                        gVar2.n = gVar2.getAdUnitList().get(i);
                        if (str.equals(g.this.n.getVid())) {
                            break;
                        }
                    }
                }
                if (g.this.n != null) {
                    com.sigmob.sdk.base.common.h.g().j(g.this.n.getCamp_id());
                    com.sigmob.sdk.base.common.h.g().i(g.this.n.getCrid());
                }
            }

            @Override // com.sigmob.sdk.mraid2.c.b
            public void a(String str, JSONObject jSONObject2) {
                SigmobLog.d(" onVpaidEvent :" + str + ":" + jSONObject2);
                String optString = jSONObject2.optString("uniqueId");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                com.sigmob.sdk.mraid.j jVar = com.sigmob.sdk.mraid2.a.a.get(optString);
                com.sigmob.sdk.mraid.o oVar = jVar instanceof com.sigmob.sdk.mraid.o ? (com.sigmob.sdk.mraid.o) jVar : null;
                str.hashCode();
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -934524953:
                        if (str.equals("replay")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -373213089:
                        if (str.equals("assetURL")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 3237136:
                        if (str.equals(PointCategory.INIT)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 3443508:
                        if (str.equals(PointCategory.PLAY)) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 3526264:
                        if (str.equals("seek")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 3540994:
                        if (str.equals("stop")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 97692013:
                        if (str.equals("frame")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case 104264043:
                        if (str.equals("muted")) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case 106440182:
                        if (str.equals("pause")) {
                            c2 = '\b';
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        if (oVar != null) {
                            oVar.c(jSONObject2);
                            return;
                        }
                        return;
                    case 1:
                        if (oVar != null) {
                            oVar.a(jSONObject2);
                            return;
                        }
                        return;
                    case 2:
                        com.sigmob.sdk.mraid.o oVar2 = new com.sigmob.sdk.mraid.o(optString);
                        oVar2.a(new o.a() { // from class: com.sigmob.sdk.mraid2.g.3.1
                            @Override // com.sigmob.sdk.mraid.o.a
                            public void a(String str2, int i) {
                                if (g.this.f585c != null) {
                                    g.this.f585c.a(str2, i);
                                }
                            }

                            @Override // com.sigmob.sdk.mraid.o.a
                            public void a(String str2, int i, String str3) {
                                if (g.this.f585c != null) {
                                    g.this.f585c.a(str2, "code:" + i + ", msg:" + str3);
                                }
                                ae.a(PointCategory.VIDEO, i, str3, g.this.n);
                            }

                            @Override // com.sigmob.sdk.mraid.o.a
                            public void a(String str2, long j) {
                                if (g.this.f585c != null) {
                                    g.this.f585c.c(str2, (int) j);
                                }
                            }

                            @Override // com.sigmob.sdk.mraid.o.a
                            public void a(String str2, long j, int i, int i2) {
                                if (g.this.f585c != null) {
                                    g.this.f585c.a(str2, (int) j, i, i2);
                                }
                            }

                            @Override // com.sigmob.sdk.mraid.o.a
                            public void a(String str2, long j, long j2) {
                                if (g.this.f585c != null) {
                                    g.this.f585c.a(str2, (int) j, (int) j2);
                                }
                            }

                            @Override // com.sigmob.sdk.mraid.o.a
                            public void b(String str2, int i) {
                                if (g.this.f585c != null) {
                                    g.this.f585c.b(str2, i);
                                }
                            }
                        });
                        oVar2.a(g.this.getContext(), jSONObject2);
                        View b2 = oVar2.b();
                        if (b2 != null) {
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(1, 1);
                            layoutParams.topMargin = 0;
                            layoutParams.rightMargin = 0;
                            b2.setLayoutParams(layoutParams);
                        }
                        com.sigmob.sdk.mraid2.a.a.put(optString, oVar2);
                        return;
                    case 3:
                        if (oVar != null) {
                            oVar.b(jSONObject2);
                            return;
                        }
                        return;
                    case 4:
                        if (oVar != null) {
                            oVar.g(jSONObject2);
                            return;
                        }
                        return;
                    case 5:
                        if (oVar != null) {
                            oVar.e(jSONObject2);
                            oVar.c();
                            com.sigmob.sdk.mraid2.a.a.remove(oVar);
                            return;
                        }
                        return;
                    case 6:
                        if (oVar != null) {
                            oVar.h(jSONObject2);
                            return;
                        }
                        return;
                    case 7:
                        if (oVar != null) {
                            oVar.f(jSONObject2);
                            return;
                        }
                        return;
                    case '\b':
                        if (oVar != null) {
                            oVar.d(jSONObject2);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x017b  */
            /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
            @Override // com.sigmob.sdk.mraid2.c.b
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void a(org.json.JSONObject r29) {
                /*
                    Method dump skipped, instructions count: 479
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.mraid2.g.AnonymousClass3.a(org.json.JSONObject):void");
            }

            @Override // com.sigmob.sdk.mraid2.c.b
            public void b() {
                for (com.sigmob.sdk.mraid.j jVar : com.sigmob.sdk.mraid2.a.a.values()) {
                    if (!TextUtils.isEmpty(jVar.d()) && jVar.d().equals(g.this.e)) {
                        com.sigmob.sdk.base.utils.f.a(jVar.b());
                        jVar.c();
                    }
                }
                com.sigmob.sdk.base.utils.f.a(g.this.d);
                if (g.this.s != null && g.this.s.size() > 0) {
                    Iterator it = g.this.s.values().iterator();
                    while (it.hasNext()) {
                        ((n) it.next()).c();
                    }
                    g.this.s.clear();
                }
                if (g.this.d != null) {
                    g.this.d = null;
                }
            }

            @Override // com.sigmob.sdk.mraid2.c.b
            public void b(String str, JSONObject jSONObject2) {
                SigmobLog.d(" onTimerEvent :" + str + ":" + jSONObject2);
                String optString = jSONObject2.optString("uniqueId");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                n nVar = (n) g.this.s.get(optString);
                str.hashCode();
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1831849669:
                        if (str.equals("invalidate")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 3143222:
                        if (str.equals("fire")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 3237136:
                        if (str.equals(PointCategory.INIT)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 106440182:
                        if (str.equals("pause")) {
                            c2 = 3;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        if (nVar != null) {
                            nVar.c();
                        }
                        g.this.s.remove(optString);
                        return;
                    case 1:
                        if (nVar != null) {
                            nVar.b();
                            return;
                        }
                        return;
                    case 2:
                        g.this.s.put(optString, new n(g.this.f585c, jSONObject2));
                        return;
                    case 3:
                        if (nVar != null) {
                            nVar.a();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }

            @Override // com.sigmob.sdk.mraid2.c.b
            public void b(JSONObject jSONObject2) {
                String optString = jSONObject2.optString("uniqueId");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                com.sigmob.sdk.mraid.j jVar = com.sigmob.sdk.mraid2.a.a.get(optString);
                if (jVar != null) {
                    jVar.a(g.this.e);
                    View b2 = jVar.b();
                    if (b2 != null) {
                        com.sigmob.sdk.base.utils.f.a(b2);
                        if (!g.this.l || g.this.k == null) {
                            g.this.j.addView(b2);
                        } else {
                            b2.setX(com.sigmob.sdk.base.blurkit.c.d);
                            b2.setY(com.sigmob.sdk.base.blurkit.c.d);
                            g.this.k.addView(b2);
                        }
                    }
                }
                g gVar2 = (g) g.r.get(optString);
                if (gVar2 != null) {
                    com.sigmob.sdk.base.utils.f.a(gVar2);
                    g.this.j.addView(gVar2);
                }
            }

            @Override // com.sigmob.sdk.mraid2.c.b
            public void c() {
                if (g.this.g != null) {
                    g.this.g.b(g.this.d);
                }
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.sigmob.sdk.mraid2.c.b
            public void c(String str, JSONObject jSONObject2) {
                char c2;
                SigmobLog.d(" onWebViewEvent :" + str + ":" + jSONObject2);
                String optString = jSONObject2.optString("uniqueId");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                g gVar2 = (g) g.r.get(optString);
                str.hashCode();
                switch (str.hashCode()) {
                    case -1435435774:
                        if (str.equals("loadHTMLString")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -1097519967:
                        if (str.equals("loadId")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -948122918:
                        if (str.equals("stopLoading")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -934641255:
                        if (str.equals("reload")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3237136:
                        if (str.equals(PointCategory.INIT)) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 97692013:
                        if (str.equals("frame")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 336630441:
                        if (str.equals("loadURL")) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 723516230:
                        if (str.equals("loadURLByPackage")) {
                            c2 = 7;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                switch (c2) {
                    case 0:
                        String optString2 = jSONObject2.optString("html");
                        if (gVar2 == null || TextUtils.isEmpty(optString2)) {
                            return;
                        }
                        gVar2.c(optString2);
                        return;
                    case 1:
                        String optString3 = jSONObject2.optString("id");
                        if (gVar2 == null || TextUtils.isEmpty(optString3)) {
                            return;
                        }
                        gVar2.f(optString3);
                        return;
                    case 2:
                        if (gVar2 != null) {
                            gVar2.i();
                            return;
                        }
                        return;
                    case 3:
                        if (gVar2 != null) {
                            gVar2.h();
                            return;
                        }
                        return;
                    case 4:
                        if (g.this.g != null) {
                            g.r.put(optString, g.this.g.a(g.this.d, jSONObject2));
                            return;
                        }
                        return;
                    case 5:
                        if (gVar2 != null) {
                            JSONObject optJSONObject = jSONObject2.optJSONObject("frame");
                            int optInt = optJSONObject.optInt("x", 0);
                            int optInt2 = optJSONObject.optInt("y", 0);
                            int optInt3 = optJSONObject.optInt("w", -1);
                            int optInt4 = optJSONObject.optInt("h", -1);
                            if (optInt3 > 0) {
                                optInt3 = Dips.dipsToIntPixels(optInt3, com.sigmob.sdk.b.e());
                            }
                            if (optInt4 > 0) {
                                optInt4 = Dips.dipsToIntPixels(optInt4, com.sigmob.sdk.b.e());
                            }
                            gVar2.setLayoutParams(new FrameLayout.LayoutParams(optInt3, optInt4));
                            gVar2.setX(Dips.dipsToIntPixels(optInt, com.sigmob.sdk.b.e()));
                            gVar2.setY(Dips.dipsToIntPixels(optInt2, com.sigmob.sdk.b.e()));
                            gVar2.requestLayout();
                            return;
                        }
                        return;
                    case 6:
                        String optString4 = jSONObject2.optString("url");
                        if (gVar2 != null) {
                            gVar2.d(optString4);
                            return;
                        }
                        return;
                    case 7:
                        String optString5 = jSONObject2.optString("URL");
                        if (gVar2 == null || TextUtils.isEmpty(optString5)) {
                            return;
                        }
                        gVar2.e(optString5);
                        return;
                    default:
                        return;
                }
            }

            @Override // com.sigmob.sdk.mraid2.c.b
            public void c(JSONObject jSONObject2) {
                String optString = jSONObject2.optString("uniqueId");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                com.sigmob.sdk.mraid.j jVar = com.sigmob.sdk.mraid2.a.a.get(optString);
                if (jVar != null) {
                    jVar.a(g.this.e);
                    View b2 = jVar.b();
                    if (b2 != null) {
                        com.sigmob.sdk.base.utils.f.a(b2);
                        if (!g.this.l || g.this.k == null) {
                            g.this.j.addView(b2);
                            g.this.j.bringChildToFront(g.this.d);
                        } else {
                            b2.setX(com.sigmob.sdk.base.blurkit.c.d);
                            b2.setY(com.sigmob.sdk.base.blurkit.c.d);
                            g.this.k.addView(b2);
                        }
                    }
                }
                g gVar2 = (g) g.r.get(optString);
                if (gVar2 != null) {
                    com.sigmob.sdk.base.utils.f.a(gVar2);
                    g.this.j.addView(gVar2);
                    g.this.j.bringChildToFront(g.this.d);
                }
            }

            @Override // com.sigmob.sdk.mraid2.c.b
            public void d() {
                if (g.this.g != null) {
                    g.this.g.a();
                }
            }

            @Override // com.sigmob.sdk.mraid2.c.b
            public void d(JSONObject jSONObject2) {
                g.this.l = true;
                int optInt = jSONObject2.optInt("flag");
                if (g.this.g == null || g.this.k != null) {
                    return;
                }
                g gVar2 = g.this;
                gVar2.k = gVar2.g.a(g.this.d, optInt);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < g.this.j.getChildCount(); i++) {
                    View childAt = g.this.j.getChildAt(i);
                    if (childAt instanceof com.sigmob.sdk.mraid.m) {
                        arrayList.add((com.sigmob.sdk.mraid.m) childAt);
                    }
                }
                Log.d(g.o, "-------------onUseScrollView----------" + arrayList.size());
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    com.sigmob.sdk.mraid.m mVar = (com.sigmob.sdk.mraid.m) arrayList.get(i2);
                    mVar.setX(com.sigmob.sdk.base.blurkit.c.d);
                    mVar.setY(com.sigmob.sdk.base.blurkit.c.d);
                    com.sigmob.sdk.base.utils.f.a(mVar);
                    g.this.k.addView(mVar);
                }
            }

            @Override // com.sigmob.sdk.mraid2.c.b
            public void e(JSONObject jSONObject2) {
                if (g.this.g != null) {
                    g.this.g.b(g.this.d, jSONObject2);
                }
            }

            @Override // com.sigmob.sdk.mraid2.c.b
            public void f(JSONObject jSONObject2) {
                f fVar;
                SigmobLog.d(" postMessage data:" + jSONObject2);
                JSONObject optJSONObject = jSONObject2.optJSONObject("args");
                String optString = optJSONObject != null ? optJSONObject.optString("uniqueId") : null;
                String optString2 = jSONObject2.optString("subEvent");
                if (TextUtils.isEmpty(optString)) {
                    SigmobLog.e(" onMotionViewEvent uniqueId is null:" + optJSONObject);
                    return;
                }
                com.sigmob.sdk.mraid.j jVar = com.sigmob.sdk.mraid2.a.a.get(optString);
                f fVar2 = jVar instanceof f ? (f) jVar : null;
                optString2.hashCode();
                char c2 = 65535;
                switch (optString2.hashCode()) {
                    case -1579599527:
                        if (optString2.equals("init_sensitivity_raw")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 3237136:
                        if (optString2.equals(PointCategory.INIT)) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 1557372922:
                        if (optString2.equals("destroy")) {
                            c2 = 2;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        String optString3 = optJSONObject.optString(com.umeng.analytics.pro.d.y, "");
                        int optInt = optJSONObject.optInt("sensitivity_raw", 0);
                        fVar = new f(optString, optString3);
                        fVar.a(new i() { // from class: com.sigmob.sdk.mraid2.g.3.4
                            @Override // com.sigmob.sdk.mraid2.i
                            public void a(String str, String str2, String str3, HashMap<String, Object> hashMap) {
                                if (g.this.f585c != null) {
                                    g.this.f585c.a(str, str2, str3, hashMap);
                                }
                            }
                        });
                        fVar.b(optInt);
                        break;
                    case 1:
                        String optString4 = optJSONObject.optString(com.umeng.analytics.pro.d.y, "");
                        int optInt2 = optJSONObject.optInt("sensitivity", 0);
                        fVar = new f(optString, optString4);
                        fVar.a(new i() { // from class: com.sigmob.sdk.mraid2.g.3.3
                            @Override // com.sigmob.sdk.mraid2.i
                            public void a(String str, String str2, String str3, HashMap<String, Object> hashMap) {
                                if (g.this.f585c != null) {
                                    g.this.f585c.a(str, str2, str3, hashMap);
                                }
                            }
                        });
                        fVar.a(optInt2);
                        break;
                    case 2:
                        if (fVar2 != null) {
                            fVar2.c();
                        }
                        com.sigmob.sdk.mraid2.a.a.remove(optString);
                        return;
                    default:
                        return;
                }
                fVar.a();
                com.sigmob.sdk.mraid2.a.a.put(optString, fVar);
            }

            @Override // com.sigmob.sdk.mraid2.c.b
            public void g(JSONObject jSONObject2) {
                SigmobLog.d(" postMessage data:" + jSONObject2);
                JSONObject optJSONObject = jSONObject2.optJSONObject("args");
                String optString = optJSONObject != null ? optJSONObject.optString("uniqueId") : null;
                String optString2 = jSONObject2.optString("subEvent");
                if (TextUtils.isEmpty(optString)) {
                    SigmobLog.e(" onMotionViewEvent uniqueId is null:" + optJSONObject);
                    return;
                }
                com.sigmob.sdk.mraid.j jVar = com.sigmob.sdk.mraid2.a.a.get(optString);
                com.sigmob.sdk.mraid.h hVar = jVar instanceof com.sigmob.sdk.mraid.h ? (com.sigmob.sdk.mraid.h) jVar : null;
                optString2.hashCode();
                char c2 = 65535;
                switch (optString2.hashCode()) {
                    case -1217487446:
                        if (optString2.equals("hidden")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 3237136:
                        if (optString2.equals(PointCategory.INIT)) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 97692013:
                        if (optString2.equals("frame")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 109757538:
                        if (optString2.equals("start")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 564403871:
                        if (optString2.equals("sensitivity")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 1557372922:
                        if (optString2.equals("destroy")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 1599250056:
                        if (optString2.equals("sensitivity_raw")) {
                            c2 = 6;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        if (hVar != null) {
                            hVar.a(optJSONObject.optBoolean("hidden"));
                            return;
                        }
                        return;
                    case 1:
                        com.sigmob.sdk.mraid.h hVar2 = new com.sigmob.sdk.mraid.h(com.sigmob.sdk.b.e(), optString, optJSONObject.optInt(com.umeng.analytics.pro.d.y));
                        hVar2.a(new i() { // from class: com.sigmob.sdk.mraid2.g.3.5
                            @Override // com.sigmob.sdk.mraid2.i
                            public void a(String str, String str2, String str3, HashMap<String, Object> hashMap) {
                                if (g.this.f585c != null) {
                                    g.this.f585c.a(str, str2, str3, hashMap);
                                }
                            }
                        });
                        com.sigmob.sdk.mraid2.a.a.put(optString, hVar2);
                        return;
                    case 2:
                        if (hVar != null) {
                            hVar.a(optJSONObject);
                            return;
                        }
                        return;
                    case 3:
                        if (hVar != null) {
                            hVar.a();
                            return;
                        }
                        return;
                    case 4:
                        if (hVar != null) {
                            hVar.a(optJSONObject.optInt("sensitivity"));
                            return;
                        }
                        return;
                    case 5:
                        if (hVar != null) {
                            hVar.c();
                        }
                        com.sigmob.sdk.mraid2.a.a.remove(optString);
                        return;
                    case 6:
                        if (hVar != null) {
                            hVar.b(optJSONObject.optInt("sensitivity_raw"));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.d = this;
        this.j = frameLayout;
        this.b = gVar;
        this.i = false;
        if (jSONObject != null) {
            try {
                this.m = new JSONObject(jSONObject.optString("args"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.e = jSONObject.optString("uniqueId");
        } else {
            String str = "wv_" + UUID.randomUUID().toString();
            this.e = str;
            r.put(str, this);
        }
        a(true);
        setBackgroundColor(0);
        try {
            ReflectionUtil.MethodBuilder methodBuilder = new ReflectionUtil.MethodBuilder(getSettings(), new String(Base64.decode(com.sigmob.sdk.base.k.C, 2)));
            methodBuilder.addParam(Boolean.TYPE, Boolean.TRUE);
            methodBuilder.execute();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            ReflectionUtil.MethodBuilder methodBuilder2 = new ReflectionUtil.MethodBuilder(getSettings(), new String(Base64.decode(com.sigmob.sdk.base.k.E, 2)));
            methodBuilder2.addParam(Boolean.TYPE, Boolean.TRUE);
            methodBuilder2.execute();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        this.p.a(com.sigmob.sdk.base.l.a().Z());
        BaseAdUnit baseAdUnit = list.get(0);
        if (baseAdUnit != null) {
            this.p.b(baseAdUnit.isDisablexRequestWith());
        }
        setWebViewClient(this.p);
        com.sigmob.sdk.mraid2.c cVar = new com.sigmob.sdk.mraid2.c(list);
        this.f585c = cVar;
        cVar.a(this.u);
        this.f585c.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"AddJavascriptInterface"})
    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(new c.a(this.f585c), "sigandroid");
        String md5 = Md5Util.md5(str);
        File f = com.sigmob.sdk.base.utils.e.f(com.sigmob.sdk.base.utils.e.f438c);
        final File file = new File(f.getAbsolutePath() + File.separator + md5, "endcard.html");
        Log.d(o, file.exists() + "---------loadURLByPackage----------" + file.getAbsolutePath());
        if (file.exists()) {
            a("file://" + file.getAbsolutePath());
            return;
        }
        File file2 = new File(f, md5 + ".tgz");
        DownloadItem downloadItem = new DownloadItem();
        downloadItem.url = str;
        downloadItem.filePath = file2.getAbsolutePath();
        downloadItem.type = DownloadItem.FileType.FILE;
        r.a().add(downloadItem, new FileDownloadRequest.FileDownloadListener() { // from class: com.sigmob.sdk.mraid2.g.2
            public void downloadProgress(DownloadItem downloadItem2, long j, long j2) {
            }

            public void onCancel(DownloadItem downloadItem2) {
                Log.d(g.o, "-----------onCancel----------" + downloadItem2.url);
            }

            public void onErrorResponse(DownloadItem downloadItem2) {
                Log.d(g.o, "-----------onErrorResponse----------" + downloadItem2.url);
            }

            public void onSuccess(DownloadItem downloadItem2) {
                Log.d(g.o, downloadItem2.url + "-----------onSuccess----------" + downloadItem2.filePath);
                try {
                    com.sigmob.sdk.base.utils.b.a(new File(downloadItem2.filePath), new File(downloadItem2.filePath.replace(".tgz", "/")));
                    if (file.exists()) {
                        g.this.d.a("file://" + file.getAbsolutePath());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        String str2;
        List<MaterialMeta> list;
        Template template;
        Log.d(o, "---------loadContentId----------" + str);
        for (int i = 0; i < getAdUnitList().size(); i++) {
            BaseAdUnit baseAdUnit = getAdUnitList().get(i);
            if (baseAdUnit != null) {
                Template template2 = baseAdUnit.scene;
                if (template2 == null || !str.equals(template2.templateId)) {
                    Ad ad = baseAdUnit.getAd();
                    if (ad != null && (list = ad.materials) != null && list.get(0) != null) {
                        if (ad.materials.get(0).main_template != null && str.equals(ad.materials.get(0).main_template.templateId)) {
                            template = ad.materials.get(0).main_template;
                        } else if (ad.materials.get(0).sub_template != null && str.equals(ad.materials.get(0).sub_template.templateId)) {
                            template = ad.materials.get(0).sub_template;
                        }
                    }
                } else {
                    template = baseAdUnit.scene;
                }
                str2 = template.context.utf8();
                break;
            }
        }
        str2 = null;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        c(str2);
    }

    public static HashMap<String, g> getMraidWebViews() {
        return r;
    }

    @Override // com.sigmob.sdk.mraid2.a
    public void a() {
        try {
            setLoadListener(null);
            setNextWebViewListener(null);
            setScrollTouchListener(null);
            if (this.d != null) {
                this.d = null;
            }
            com.sigmob.sdk.mraid2.c cVar = this.f585c;
            if (cVar != null) {
                cVar.g();
                this.f585c = null;
            }
            super.a();
        } catch (Throwable unused) {
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void c(String str) {
        a(new c.a(this.f585c), "sigandroid");
        File b2 = com.sigmob.sdk.base.utils.e.b(str, Md5Util.md5(str) + ".html");
        if (b2 == null || TextUtils.isEmpty(b2.getAbsolutePath())) {
            a(Networking.getBaseUrlScheme() + "://localhost/", str, "text/html", "UTF-8", null);
            return;
        }
        a("file://" + b2.getAbsolutePath());
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void d(String str) {
        Log.d(o, "---------loadContentUrl----------" + str);
        a(new c.a(this.f585c), "sigandroid");
        a(str);
    }

    public com.sigmob.sdk.base.common.g getAdSize() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.sigmob.sdk.mraid2.a
    public List<BaseAdUnit> getAdUnitList() {
        com.sigmob.sdk.mraid2.c cVar = this.f585c;
        if (cVar != null) {
            return cVar.c();
        }
        return null;
    }

    public com.sigmob.sdk.mraid2.c getMraidBridge() {
        return this.f585c;
    }

    public c getScrollTouchListener() {
        return this.f;
    }

    public String getUniqueId() {
        return this.e;
    }

    public void l() {
        BaseAdUnit baseAdUnit = getAdUnitList().get(0);
        Template template = baseAdUnit.scene;
        if (template == null) {
            template = (baseAdUnit.getMaterial() == null || baseAdUnit.getMaterial().main_template == null) ? (baseAdUnit.getMaterial() == null || baseAdUnit.getMaterial().sub_template == null) ? null : baseAdUnit.getMaterial().sub_template : baseAdUnit.getMaterial().main_template;
        }
        if (template != null) {
            int intValue = template.type.intValue();
            if (intValue == 1) {
                d(template.context.utf8());
                return;
            }
            if (intValue == 2) {
                c(template.context.utf8());
                return;
            }
            if (intValue == 3) {
                e(template.context.utf8());
                return;
            }
            SigmobLog.e("template type error:" + template.type);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        com.sigmob.sdk.mraid2.c cVar = this.f585c;
        if (cVar != null) {
            cVar.a(i == 0);
        }
    }

    public void setAdSize(com.sigmob.sdk.base.common.g gVar) {
        this.q = gVar;
    }

    public void setLoadListener(a aVar) {
        this.h = aVar;
    }

    public void setNextWebViewListener(b bVar) {
        this.g = bVar;
    }

    public void setScrollTouchListener(c cVar) {
        this.f = cVar;
    }
}
