package com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsHolderClass;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.rtk.app.bean.MyUpApkCommentBean;
import com.rtk.app.custom.X5WebView;
import com.rtk.app.custom.f;
import com.rtk.app.tool.ApkInfo;
import java.util.ArrayList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class WebViewHolder extends RecyclerView.ViewHolder {

    @BindView
    public X5WebView postDetailsRecyclerviewItemWebview;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class a extends WebViewClient {
        final /* synthetic */ f a;
        final /* synthetic */ WebView b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f193c;

        a(f fVar, WebView webView, Context context) {
            this.b = webView;
            this.f193c = context;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            f fVar = this.a;
            if (fVar == null) {
                return;
            }
            fVar.a();
            throw null;
        }

        @JavascriptInterface
        public void run(int i) {
            f fVar = this.a;
            if (fVar == null) {
                return;
            }
            fVar.a();
            throw null;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                String scheme = Uri.parse(str).getScheme();
                String host = Uri.parse(str).getHost();
                if (TextUtils.equals("myapp", scheme)) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    Uri data = intent.getData();
                    if (data != null) {
                        Bundle bundle = new Bundle();
                        char c2 = 65535;
                        switch (host.hashCode()) {
                            case -1134416946:
                                if (host.equals("toupsrc")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case -1021421998:
                                if (host.equals("tonative")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case -868028005:
                                if (host.equals("topost")) {
                                    c2 = 4;
                                    break;
                                }
                                break;
                            case -867875642:
                                if (host.equals("touser")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case 389354301:
                                if (host.equals("topictrue")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                        }
                        if (c2 == 0) {
                            bundle.putSerializable("apkInfo", new ApkInfo(Integer.parseInt(data.getQueryParameter("gameId")), data.getQueryParameter("appName"), data.getQueryParameter("packageName"), null, null, null, 0, 0, null));
                        } else if (c2 == 1) {
                            MyUpApkCommentBean.DataBean dataBean = new MyUpApkCommentBean.DataBean();
                            dataBean.setUsid(Integer.parseInt(data.getQueryParameter("id")));
                            dataBean.setVarName(data.getQueryParameter("varName"));
                            dataBean.setSourceLogo(data.getQueryParameter("sourceLogo"));
                            dataBean.setPackageName(data.getQueryParameter("packageName"));
                            dataBean.setSourcePath(data.getQueryParameter("sourcePath"));
                            bundle.putSerializable("apkInfo", new ApkInfo(dataBean));
                        } else if (c2 == 2) {
                            bundle.putString("nowPicture", data.getQueryParameter("imgpath"));
                            try {
                                bundle.putStringArrayList("list", (ArrayList) this.b.getTag());
                            } catch (Exception unused) {
                            }
                        } else if (c2 == 3) {
                            bundle.putString("fans", data.getQueryParameter("fans"));
                        } else if (c2 == 4) {
                            bundle.putString("pid", data.getQueryParameter("pid"));
                        }
                        intent.putExtras(bundle);
                    }
                    this.f193c.startActivity(intent);
                    return true;
                }
            } catch (Exception unused2) {
            }
            return false;
        }
    }

    public static void b(WebView webView, String str, Context context, f fVar) {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setDisplayZoomControls(true);
        settings.setAllowFileAccess(true);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(false);
        settings.setLoadWithOverviewMode(true);
        webView.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        if (fVar == null) {
            webView.setWebViewClient(new a(fVar, webView, context));
        } else {
            fVar.a();
            throw null;
        }
    }
}
