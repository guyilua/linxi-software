package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class WebSettings {
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;
    private IX5WebSettings a;
    private android.webkit.WebSettings b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f949c;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum LayoutAlgorithm {
        NORMAL,
        SINGLE_COLUMN,
        NARROW_COLUMNS
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum PluginState {
        ON,
        ON_DEMAND,
        OFF
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum RenderPriority {
        NORMAL,
        HIGH,
        LOW
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum TextSize {
        SMALLEST(50),
        SMALLER(75),
        NORMAL(100),
        LARGER(125),
        LARGEST(150);

        int value;

        TextSize(int i) {
            this.value = i;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum ZoomDensity {
        FAR(150),
        MEDIUM(100),
        CLOSE(75);

        int value;

        ZoomDensity(int i) {
            this.value = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSettings(IX5WebSettings iX5WebSettings) {
        this.a = null;
        this.b = null;
        this.f949c = false;
        this.a = iX5WebSettings;
        this.b = null;
        this.f949c = true;
    }

    @TargetApi(17)
    public static String getDefaultUserAgent(Context context) {
        Object a;
        if (t.a().b()) {
            return t.a().c().i(context);
        }
        if (Build.VERSION.SDK_INT >= 17 && (a = com.tencent.smtt.utils.k.a((Class<?>) android.webkit.WebSettings.class, "getDefaultUserAgent", (Class<?>[]) new Class[]{Context.class}, context)) != null) {
            return (String) a;
        }
        return null;
    }

    @Deprecated
    public boolean enableSmoothTransition() {
        android.webkit.WebSettings webSettings;
        Object a;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.enableSmoothTransition();
        }
        if (z || (webSettings = this.b) == null || Build.VERSION.SDK_INT < 11 || (a = com.tencent.smtt.utils.k.a(webSettings, "enableSmoothTransition")) == null) {
            return false;
        }
        return ((Boolean) a).booleanValue();
    }

    @TargetApi(11)
    public boolean getAllowContentAccess() {
        android.webkit.WebSettings webSettings;
        Object a;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getAllowContentAccess();
        }
        if (z || (webSettings = this.b) == null || Build.VERSION.SDK_INT < 11 || (a = com.tencent.smtt.utils.k.a(webSettings, "getAllowContentAccess")) == null) {
            return false;
        }
        return ((Boolean) a).booleanValue();
    }

    @TargetApi(3)
    public boolean getAllowFileAccess() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getAllowFileAccess();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getAllowFileAccess();
    }

    public synchronized boolean getBlockNetworkImage() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getBlockNetworkImage();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getBlockNetworkImage();
    }

    @TargetApi(8)
    public synchronized boolean getBlockNetworkLoads() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getBlockNetworkLoads();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 8) {
            return webSettings.getBlockNetworkLoads();
        }
        return false;
    }

    @TargetApi(3)
    public boolean getBuiltInZoomControls() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getBuiltInZoomControls();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getBuiltInZoomControls();
    }

    public int getCacheMode() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getCacheMode();
        }
        if (z || (webSettings = this.b) == null) {
            return 0;
        }
        return webSettings.getCacheMode();
    }

    public synchronized String getCursiveFontFamily() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (!z || (iX5WebSettings = this.a) == null) {
            return (z || (webSettings = this.b) == null) ? "" : webSettings.getCursiveFontFamily();
        }
        return iX5WebSettings.getCursiveFontFamily();
    }

    @TargetApi(5)
    public synchronized boolean getDatabaseEnabled() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getDatabaseEnabled();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getDatabaseEnabled();
    }

    @TargetApi(5)
    public synchronized String getDatabasePath() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (!z || (iX5WebSettings = this.a) == null) {
            return (z || (webSettings = this.b) == null) ? "" : webSettings.getDatabasePath();
        }
        return iX5WebSettings.getDatabasePath();
    }

    public synchronized int getDefaultFixedFontSize() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getDefaultFixedFontSize();
        }
        if (z || (webSettings = this.b) == null) {
            return 0;
        }
        return webSettings.getDefaultFixedFontSize();
    }

    public synchronized int getDefaultFontSize() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getDefaultFontSize();
        }
        if (z || (webSettings = this.b) == null) {
            return 0;
        }
        return webSettings.getDefaultFontSize();
    }

    public synchronized String getDefaultTextEncodingName() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (!z || (iX5WebSettings = this.a) == null) {
            return (z || (webSettings = this.b) == null) ? "" : webSettings.getDefaultTextEncodingName();
        }
        return iX5WebSettings.getDefaultTextEncodingName();
    }

    @TargetApi(7)
    public ZoomDensity getDefaultZoom() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return ZoomDensity.valueOf(iX5WebSettings.getDefaultZoom().name());
        }
        if (z || (webSettings = this.b) == null) {
            return null;
        }
        return ZoomDensity.valueOf(webSettings.getDefaultZoom().name());
    }

    @TargetApi(11)
    public boolean getDisplayZoomControls() {
        android.webkit.WebSettings webSettings;
        Object a;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getDisplayZoomControls();
        }
        if (z || (webSettings = this.b) == null || Build.VERSION.SDK_INT < 11 || (a = com.tencent.smtt.utils.k.a(webSettings, "getDisplayZoomControls")) == null) {
            return false;
        }
        return ((Boolean) a).booleanValue();
    }

    @TargetApi(7)
    public synchronized boolean getDomStorageEnabled() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getDomStorageEnabled();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getDomStorageEnabled();
    }

    public synchronized String getFantasyFontFamily() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (!z || (iX5WebSettings = this.a) == null) {
            return (z || (webSettings = this.b) == null) ? "" : webSettings.getFantasyFontFamily();
        }
        return iX5WebSettings.getFantasyFontFamily();
    }

    public synchronized String getFixedFontFamily() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (!z || (iX5WebSettings = this.a) == null) {
            return (z || (webSettings = this.b) == null) ? "" : webSettings.getFixedFontFamily();
        }
        return iX5WebSettings.getFixedFontFamily();
    }

    public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getJavaScriptCanOpenWindowsAutomatically();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getJavaScriptCanOpenWindowsAutomatically();
    }

    public synchronized boolean getJavaScriptEnabled() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getJavaScriptEnabled();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getJavaScriptEnabled();
    }

    public synchronized LayoutAlgorithm getLayoutAlgorithm() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return LayoutAlgorithm.valueOf(iX5WebSettings.getLayoutAlgorithm().name());
        }
        if (z || (webSettings = this.b) == null) {
            return null;
        }
        return LayoutAlgorithm.valueOf(webSettings.getLayoutAlgorithm().name());
    }

    public boolean getLightTouchEnabled() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getLightTouchEnabled();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getLightTouchEnabled();
    }

    @TargetApi(7)
    public boolean getLoadWithOverviewMode() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getLoadWithOverviewMode();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getLoadWithOverviewMode();
    }

    public synchronized boolean getLoadsImagesAutomatically() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getLoadsImagesAutomatically();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getLoadsImagesAutomatically();
    }

    @TargetApi(17)
    public boolean getMediaPlaybackRequiresUserGesture() {
        android.webkit.WebSettings webSettings;
        Object a;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getMediaPlaybackRequiresUserGesture();
        }
        if (z || (webSettings = this.b) == null || Build.VERSION.SDK_INT < 17 || (a = com.tencent.smtt.utils.k.a(webSettings, "getMediaPlaybackRequiresUserGesture")) == null) {
            return false;
        }
        return ((Boolean) a).booleanValue();
    }

    public synchronized int getMinimumFontSize() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getMinimumFontSize();
        }
        if (z || (webSettings = this.b) == null) {
            return 0;
        }
        return webSettings.getMinimumFontSize();
    }

    public synchronized int getMinimumLogicalFontSize() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getMinimumLogicalFontSize();
        }
        if (z || (webSettings = this.b) == null) {
            return 0;
        }
        return webSettings.getMinimumLogicalFontSize();
    }

    public synchronized int getMixedContentMode() {
        IX5WebSettings iX5WebSettings;
        int i = -1;
        if (this.f949c && (iX5WebSettings = this.a) != null) {
            try {
                return iX5WebSettings.getMixedContentMode();
            } catch (Throwable th) {
                th.printStackTrace();
                return -1;
            }
        }
        if (Build.VERSION.SDK_INT < 21) {
            return -1;
        }
        Object a = com.tencent.smtt.utils.k.a(this.b, "getMixedContentMode", (Class<?>[]) new Class[0], new Object[0]);
        if (a != null) {
            i = ((Integer) a).intValue();
        }
        return i;
    }

    public boolean getNavDump() {
        android.webkit.WebSettings webSettings;
        Object a;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getNavDump();
        }
        if (z || (webSettings = this.b) == null || (a = com.tencent.smtt.utils.k.a(webSettings, "getNavDump")) == null) {
            return false;
        }
        return ((Boolean) a).booleanValue();
    }

    @TargetApi(8)
    @Deprecated
    public synchronized PluginState getPluginState() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return PluginState.valueOf(iX5WebSettings.getPluginState().name());
        }
        if (z || (webSettings = this.b) == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return null;
        }
        Object a = com.tencent.smtt.utils.k.a(webSettings, "getPluginState");
        if (a == null) {
            return null;
        }
        return PluginState.valueOf(((WebSettings.PluginState) a).name());
    }

    @TargetApi(8)
    @Deprecated
    public synchronized boolean getPluginsEnabled() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getPluginsEnabled();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        if (i > 17) {
            if (i == 18) {
                return WebSettings.PluginState.ON == webSettings.getPluginState();
            }
            return false;
        }
        Object a = com.tencent.smtt.utils.k.a(webSettings, "getPluginsEnabled");
        if (a != null) {
            r1 = ((Boolean) a).booleanValue();
        }
        return r1;
    }

    @Deprecated
    public synchronized String getPluginsPath() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getPluginsPath();
        }
        if (z || (webSettings = this.b) == null) {
            return "";
        }
        if (Build.VERSION.SDK_INT > 17) {
            return "";
        }
        Object a = com.tencent.smtt.utils.k.a(webSettings, "getPluginsPath");
        return a == null ? null : (String) a;
    }

    public synchronized String getSansSerifFontFamily() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (!z || (iX5WebSettings = this.a) == null) {
            return (z || (webSettings = this.b) == null) ? "" : webSettings.getSansSerifFontFamily();
        }
        return iX5WebSettings.getSansSerifFontFamily();
    }

    public boolean getSaveFormData() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getSaveFormData();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getSaveFormData();
    }

    public boolean getSavePassword() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getSavePassword();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getSavePassword();
    }

    public synchronized String getSerifFontFamily() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (!z || (iX5WebSettings = this.a) == null) {
            return (z || (webSettings = this.b) == null) ? "" : webSettings.getSerifFontFamily();
        }
        return iX5WebSettings.getSerifFontFamily();
    }

    public synchronized String getStandardFontFamily() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (!z || (iX5WebSettings = this.a) == null) {
            return (z || (webSettings = this.b) == null) ? "" : webSettings.getStandardFontFamily();
        }
        return iX5WebSettings.getStandardFontFamily();
    }

    public TextSize getTextSize() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return TextSize.valueOf(iX5WebSettings.getTextSize().name());
        }
        if (z || (webSettings = this.b) == null) {
            return null;
        }
        return TextSize.valueOf(webSettings.getTextSize().name());
    }

    @TargetApi(14)
    public synchronized int getTextZoom() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getTextZoom();
        }
        if (z || (webSettings = this.b) == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT < 14) {
            return 0;
        }
        try {
            return webSettings.getTextZoom();
        } catch (Exception unused) {
            Object a = com.tencent.smtt.utils.k.a(this.b, "getTextZoom");
            if (a == null) {
                return 0;
            }
            return ((Integer) a).intValue();
        }
    }

    @Deprecated
    public boolean getUseWebViewBackgroundForOverscrollBackground() {
        android.webkit.WebSettings webSettings;
        Object a;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getUseWebViewBackgroundForOverscrollBackground();
        }
        if (z || (webSettings = this.b) == null || (a = com.tencent.smtt.utils.k.a(webSettings, "getUseWebViewBackgroundForOverscrollBackground")) == null) {
            return false;
        }
        return ((Boolean) a).booleanValue();
    }

    public synchronized boolean getUseWideViewPort() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.getUseWideViewPort();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.getUseWideViewPort();
    }

    @TargetApi(3)
    public String getUserAgentString() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (!z || (iX5WebSettings = this.a) == null) {
            return (z || (webSettings = this.b) == null) ? "" : webSettings.getUserAgentString();
        }
        return iX5WebSettings.getUserAgentString();
    }

    @TargetApi(11)
    public void setAllowContentAccess(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.f949c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setAllowContentAccess(z);
        } else {
            if (z2 || (webSettings = this.b) == null || Build.VERSION.SDK_INT < 11) {
                return;
            }
            com.tencent.smtt.utils.k.a(webSettings, "setAllowContentAccess", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @TargetApi(3)
    public void setAllowFileAccess(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.f949c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setAllowFileAccess(z);
        } else {
            if (z2 || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setAllowFileAccess(z);
        }
    }

    @TargetApi(16)
    public void setAllowFileAccessFromFileURLs(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.f949c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setAllowFileAccessFromFileURLs(z);
        } else {
            if (z2 || (webSettings = this.b) == null) {
                return;
            }
            com.tencent.smtt.utils.k.a(webSettings, "setAllowFileAccessFromFileURLs", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @TargetApi(16)
    public void setAllowUniversalAccessFromFileURLs(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.f949c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setAllowUniversalAccessFromFileURLs(z);
        } else {
            if (z2 || (webSettings = this.b) == null) {
                return;
            }
            com.tencent.smtt.utils.k.a(webSettings, "setAllowUniversalAccessFromFileURLs", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @TargetApi(7)
    public void setAppCacheEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.f949c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setAppCacheEnabled(z);
        } else {
            if (z2 || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setAppCacheEnabled(z);
        }
    }

    @TargetApi(7)
    public void setAppCacheMaxSize(long j) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setAppCacheMaxSize(j);
        } else {
            if (z || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setAppCacheMaxSize(j);
        }
    }

    @TargetApi(7)
    public void setAppCachePath(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setAppCachePath(str);
        } else {
            if (z || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setAppCachePath(str);
        }
    }

    public void setBlockNetworkImage(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.f949c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setBlockNetworkImage(z);
        } else {
            if (z2 || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setBlockNetworkImage(z);
        }
    }

    @TargetApi(8)
    public synchronized void setBlockNetworkLoads(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.f949c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setBlockNetworkLoads(z);
        } else {
            if (z2 || (webSettings = this.b) == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 8) {
                webSettings.setBlockNetworkLoads(z);
            }
        }
    }

    @TargetApi(3)
    public void setBuiltInZoomControls(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.f949c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setBuiltInZoomControls(z);
        } else {
            if (z2 || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setBuiltInZoomControls(z);
        }
    }

    public void setCacheMode(int i) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setCacheMode(i);
        } else {
            if (z || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setCacheMode(i);
        }
    }

    public synchronized void setCursiveFontFamily(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setCursiveFontFamily(str);
        } else if (z || (webSettings = this.b) == null) {
        } else {
            webSettings.setCursiveFontFamily(str);
        }
    }

    @TargetApi(5)
    public void setDatabaseEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.f949c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setDatabaseEnabled(z);
        } else {
            if (z2 || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setDatabaseEnabled(z);
        }
    }

    @TargetApi(5)
    @Deprecated
    public void setDatabasePath(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setDatabasePath(str);
        } else {
            if (z || (webSettings = this.b) == null) {
                return;
            }
            com.tencent.smtt.utils.k.a(webSettings, "setDatabasePath", (Class<?>[]) new Class[]{String.class}, str);
        }
    }

    public synchronized void setDefaultFixedFontSize(int i) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setDefaultFixedFontSize(i);
        } else if (z || (webSettings = this.b) == null) {
        } else {
            webSettings.setDefaultFixedFontSize(i);
        }
    }

    public synchronized void setDefaultFontSize(int i) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setDefaultFontSize(i);
        } else if (z || (webSettings = this.b) == null) {
        } else {
            webSettings.setDefaultFontSize(i);
        }
    }

    public synchronized void setDefaultTextEncodingName(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setDefaultTextEncodingName(str);
        } else if (z || (webSettings = this.b) == null) {
        } else {
            webSettings.setDefaultTextEncodingName(str);
        }
    }

    @TargetApi(7)
    public void setDefaultZoom(ZoomDensity zoomDensity) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setDefaultZoom(IX5WebSettings.ZoomDensity.valueOf(zoomDensity.name()));
        } else {
            if (z || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setDefaultZoom(WebSettings.ZoomDensity.valueOf(zoomDensity.name()));
        }
    }

    @TargetApi(11)
    public void setDisplayZoomControls(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.f949c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setDisplayZoomControls(z);
        } else {
            if (z2 || (webSettings = this.b) == null || Build.VERSION.SDK_INT < 11) {
                return;
            }
            com.tencent.smtt.utils.k.a(webSettings, "setDisplayZoomControls", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @TargetApi(7)
    public void setDomStorageEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.f949c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setDomStorageEnabled(z);
        } else {
            if (z2 || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setDomStorageEnabled(z);
        }
    }

    @TargetApi(11)
    @Deprecated
    public void setEnableSmoothTransition(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.f949c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setEnableSmoothTransition(z);
        } else {
            if (z2 || (webSettings = this.b) == null || Build.VERSION.SDK_INT < 11) {
                return;
            }
            com.tencent.smtt.utils.k.a(webSettings, "setEnableSmoothTransition", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public synchronized void setFantasyFontFamily(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setFantasyFontFamily(str);
        } else if (z || (webSettings = this.b) == null) {
        } else {
            webSettings.setFantasyFontFamily(str);
        }
    }

    public synchronized void setFixedFontFamily(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setFixedFontFamily(str);
        } else if (z || (webSettings = this.b) == null) {
        } else {
            webSettings.setFixedFontFamily(str);
        }
    }

    @TargetApi(5)
    public void setGeolocationDatabasePath(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setGeolocationDatabasePath(str);
        } else {
            if (z || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setGeolocationDatabasePath(str);
        }
    }

    @TargetApi(5)
    public void setGeolocationEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.f949c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setGeolocationEnabled(z);
        } else {
            if (z2 || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setGeolocationEnabled(z);
        }
    }

    public synchronized void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.f949c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setJavaScriptCanOpenWindowsAutomatically(z);
        } else if (z2 || (webSettings = this.b) == null) {
        } else {
            webSettings.setJavaScriptCanOpenWindowsAutomatically(z);
        }
    }

    @Deprecated
    public void setJavaScriptEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        try {
            boolean z2 = this.f949c;
            if (z2 && (iX5WebSettings = this.a) != null) {
                iX5WebSettings.setJavaScriptEnabled(z);
            } else if (z2 || (webSettings = this.b) == null) {
            } else {
                webSettings.setJavaScriptEnabled(z);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setLayoutAlgorithm(IX5WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
        } else {
            if (z || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
        }
    }

    public void setLightTouchEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.f949c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setLightTouchEnabled(z);
        } else {
            if (z2 || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setLightTouchEnabled(z);
        }
    }

    @TargetApi(7)
    public void setLoadWithOverviewMode(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.f949c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setLoadWithOverviewMode(z);
        } else {
            if (z2 || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setLoadWithOverviewMode(z);
        }
    }

    public void setLoadsImagesAutomatically(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.f949c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setLoadsImagesAutomatically(z);
        } else {
            if (z2 || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setLoadsImagesAutomatically(z);
        }
    }

    @TargetApi(17)
    public void setMediaPlaybackRequiresUserGesture(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.f949c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setMediaPlaybackRequiresUserGesture(z);
        } else {
            if (z2 || (webSettings = this.b) == null || Build.VERSION.SDK_INT < 17) {
                return;
            }
            com.tencent.smtt.utils.k.a(webSettings, "setMediaPlaybackRequiresUserGesture", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public synchronized void setMinimumFontSize(int i) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setMinimumFontSize(i);
        } else if (z || (webSettings = this.b) == null) {
        } else {
            webSettings.setMinimumFontSize(i);
        }
    }

    public synchronized void setMinimumLogicalFontSize(int i) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setMinimumLogicalFontSize(i);
        } else if (z || (webSettings = this.b) == null) {
        } else {
            webSettings.setMinimumLogicalFontSize(i);
        }
    }

    @TargetApi(21)
    public void setMixedContentMode(int i) {
        android.webkit.WebSettings webSettings;
        boolean z = this.f949c;
        if ((!z || this.a == null) && !z && (webSettings = this.b) != null && Build.VERSION.SDK_INT >= 21) {
            com.tencent.smtt.utils.k.a(webSettings, "setMixedContentMode", (Class<?>[]) new Class[]{Integer.TYPE}, Integer.valueOf(i));
        }
    }

    public void setNavDump(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.f949c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setNavDump(z);
        } else {
            if (z2 || (webSettings = this.b) == null) {
                return;
            }
            com.tencent.smtt.utils.k.a(webSettings, "setNavDump", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public void setNeedInitialFocus(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.f949c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setNeedInitialFocus(z);
        } else {
            if (z2 || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setNeedInitialFocus(z);
        }
    }

    @TargetApi(8)
    @Deprecated
    public synchronized void setPluginState(PluginState pluginState) {
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setPluginState(IX5WebSettings.PluginState.valueOf(pluginState.name()));
        } else {
            if (z || this.b == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 8) {
                com.tencent.smtt.utils.k.a(this.b, "setPluginState", (Class<?>[]) new Class[]{WebSettings.PluginState.class}, WebSettings.PluginState.valueOf(pluginState.name()));
            }
        }
    }

    @Deprecated
    public void setPluginsEnabled(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.f949c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setPluginsEnabled(z);
        } else {
            if (z2 || (webSettings = this.b) == null) {
                return;
            }
            com.tencent.smtt.utils.k.a(webSettings, "setPluginsEnabled", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    @Deprecated
    public synchronized void setPluginsPath(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setPluginsPath(str);
        } else if (z || (webSettings = this.b) == null) {
        } else {
            com.tencent.smtt.utils.k.a(webSettings, "setPluginsPath", (Class<?>[]) new Class[]{String.class}, str);
        }
    }

    public void setRenderPriority(RenderPriority renderPriority) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setRenderPriority(IX5WebSettings.RenderPriority.valueOf(renderPriority.name()));
        } else {
            if (z || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setRenderPriority(WebSettings.RenderPriority.valueOf(renderPriority.name()));
        }
    }

    public synchronized void setSansSerifFontFamily(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setSansSerifFontFamily(str);
        } else if (z || (webSettings = this.b) == null) {
        } else {
            webSettings.setSansSerifFontFamily(str);
        }
    }

    public void setSaveFormData(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.f949c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setSaveFormData(z);
        } else {
            if (z2 || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setSaveFormData(z);
        }
    }

    public void setSavePassword(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.f949c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setSavePassword(z);
        } else {
            if (z2 || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setSavePassword(z);
        }
    }

    public synchronized void setSerifFontFamily(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setSerifFontFamily(str);
        } else if (z || (webSettings = this.b) == null) {
        } else {
            webSettings.setSerifFontFamily(str);
        }
    }

    public synchronized void setStandardFontFamily(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setStandardFontFamily(str);
        } else if (z || (webSettings = this.b) == null) {
        } else {
            webSettings.setStandardFontFamily(str);
        }
    }

    public void setSupportMultipleWindows(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.f949c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setSupportMultipleWindows(z);
        } else {
            if (z2 || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setSupportMultipleWindows(z);
        }
    }

    public void setSupportZoom(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.f949c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setSupportZoom(z);
        } else {
            if (z2 || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setSupportZoom(z);
        }
    }

    public void setTextSize(TextSize textSize) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setTextSize(IX5WebSettings.TextSize.valueOf(textSize.name()));
        } else {
            if (z || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setTextSize(WebSettings.TextSize.valueOf(textSize.name()));
        }
    }

    @TargetApi(14)
    public synchronized void setTextZoom(int i) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setTextZoom(i);
        } else if (!z && (webSettings = this.b) != null) {
            if (Build.VERSION.SDK_INT < 14) {
                return;
            }
            try {
                webSettings.setTextZoom(i);
            } catch (Exception unused) {
                com.tencent.smtt.utils.k.a(this.b, "setTextZoom", (Class<?>[]) new Class[]{Integer.TYPE}, Integer.valueOf(i));
            }
        }
    }

    @Deprecated
    public void setUseWebViewBackgroundForOverscrollBackground(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.f949c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setUseWebViewBackgroundForOverscrollBackground(z);
        } else {
            if (z2 || (webSettings = this.b) == null) {
                return;
            }
            com.tencent.smtt.utils.k.a(webSettings, "setUseWebViewBackgroundForOverscrollBackground", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public void setUseWideViewPort(boolean z) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z2 = this.f949c;
        if (z2 && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setUseWideViewPort(z);
        } else {
            if (z2 || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setUseWideViewPort(z);
        }
    }

    public void setUserAgent(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setUserAgent(str);
        } else {
            if (z || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setUserAgentString(str);
        }
    }

    @TargetApi(3)
    public void setUserAgentString(String str) {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            iX5WebSettings.setUserAgentString(str);
        } else {
            if (z || (webSettings = this.b) == null) {
                return;
            }
            webSettings.setUserAgentString(str);
        }
    }

    public synchronized boolean supportMultipleWindows() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.supportMultipleWindows();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.supportMultipleWindows();
    }

    public boolean supportZoom() {
        android.webkit.WebSettings webSettings;
        IX5WebSettings iX5WebSettings;
        boolean z = this.f949c;
        if (z && (iX5WebSettings = this.a) != null) {
            return iX5WebSettings.supportZoom();
        }
        if (z || (webSettings = this.b) == null) {
            return false;
        }
        return webSettings.supportZoom();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSettings(android.webkit.WebSettings webSettings) {
        this.a = null;
        this.b = null;
        this.f949c = false;
        this.a = null;
        this.b = webSettings;
        this.f949c = false;
    }
}
