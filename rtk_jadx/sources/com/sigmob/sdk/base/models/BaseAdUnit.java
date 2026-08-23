package com.sigmob.sdk.base.models;

import android.net.Uri;
import android.text.TextUtils;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.StringUtil;
import com.czhj.wire.Wire;
import com.czhj.wire.okio.ByteString;
import com.sigmob.sdk.b;
import com.sigmob.sdk.base.common.ag;
import com.sigmob.sdk.base.common.ah;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.common.i;
import com.sigmob.sdk.base.common.m;
import com.sigmob.sdk.base.models.rtb.Ad;
import com.sigmob.sdk.base.models.rtb.AdPrivacy;
import com.sigmob.sdk.base.models.rtb.AdSetting;
import com.sigmob.sdk.base.models.rtb.AndroidMarket;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.models.rtb.ClickAreaSetting;
import com.sigmob.sdk.base.models.rtb.Color;
import com.sigmob.sdk.base.models.rtb.InterstitialSetting;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.models.rtb.NativeAdSetting;
import com.sigmob.sdk.base.models.rtb.ResponseAsset;
import com.sigmob.sdk.base.models.rtb.ResponseAssetImage;
import com.sigmob.sdk.base.models.rtb.ResponseAssetVideo;
import com.sigmob.sdk.base.models.rtb.ResponseNativeAd;
import com.sigmob.sdk.base.models.rtb.RvAdSetting;
import com.sigmob.sdk.base.models.rtb.SingleNativeAdSetting;
import com.sigmob.sdk.base.models.rtb.SlotAdSetting;
import com.sigmob.sdk.base.models.rtb.SplashAdSetting;
import com.sigmob.sdk.base.models.rtb.Template;
import com.sigmob.sdk.base.models.rtb.Tracking;
import com.sigmob.sdk.base.models.rtb.WXProgramRes;
import com.sigmob.sdk.base.models.rtb.Widget;
import com.sigmob.sdk.base.utils.e;
import com.sigmob.sdk.base.views.n;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.newInterstitial.d;
import com.sigmob.sdk.splash.c;
import com.sigmob.sdk.videoAd.a;
import com.sigmob.windad.natives.AdAppInfo;
import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class BaseAdUnit implements Serializable {
    private static final String TAG = "BaseAdUnit";
    private static final long serialVersionUID = 1;
    private Ad ad;
    private transient AdAppInfo adAppInfo;
    private transient i adConfig;
    private int adHeight;
    private LoadAdRequest adRequest;
    private HashMap<String, List<ah>> adTrackersMap;
    private int adWidth;
    private String ad_scene_desc;
    private String ad_scene_id;
    private String ad_source_channel;
    private int ad_type;
    private String adslot_id;
    private String adx_id;
    private String apkName;
    private String apkPackageName;
    private String bid_token;
    public BiddingResponse bidding_response;
    private String camp_id;
    private ClickCommon clickCommon;
    private long create_time;
    private String crid;
    private transient Uri deeplinkUri;
    private Long downloadId;
    private transient f downloadTask;
    private String downloadUrl;
    private List<com.sigmob.sdk.videoAd.f> download_trackers;
    private String endcard_md5;
    public int expiration_time;
    private transient List imageUrlList;
    private boolean isHalfInterstitial;
    private String landUrl;
    private String load_id;
    private AndroidMarket mCustomAndroidMarket;
    private String mCustomDeeplink;
    private String mCustomLandPageUrl;
    private transient ag mSessionManager;
    private SigMacroCommon macroCommon;
    private String nativeDesc;
    private String nativeIconUrl;
    private String nativeTtitle;
    private SigVideo nativeVideo;
    private String request_id;
    private String rv_callback_url;
    public Template scene;
    public SlotAdSetting slotAdSetting;
    public String uid;
    private String uuid;
    private VideoStatusCommon videoCommon;
    private String video_md5;
    private double adPercent = -1.0d;
    private double realAdPercent = -1.0d;
    private boolean useDownloadedApk = false;
    private boolean isDislikeReported = false;
    private boolean record = true;
    private boolean catchVideo = false;

    public static BaseAdUnit adUnit(Ad ad, String str, LoadAdRequest loadAdRequest, SlotAdSetting slotAdSetting, Template template, String str2, Integer num, BiddingResponse biddingResponse) {
        ByteString byteString;
        ResponseNativeAd nativeAd;
        BaseAdUnit baseAdUnit = null;
        try {
            MaterialMeta materialMeta = ad.materials.get(0);
            if (materialMeta == null) {
                return null;
            }
            BaseAdUnit baseAdUnit2 = new BaseAdUnit();
            try {
                baseAdUnit2.create_time = System.currentTimeMillis();
                baseAdUnit2.adslot_id = ad.adslot_id;
                baseAdUnit2.ad_type = ad.ad_type.intValue();
                baseAdUnit2.ad = ad;
                baseAdUnit2.crid = ad.crid;
                baseAdUnit2.camp_id = ad.camp_id;
                baseAdUnit2.request_id = str;
                baseAdUnit2.endcard_md5 = materialMeta.endcard_md5;
                baseAdUnit2.video_md5 = materialMeta.video_md5;
                baseAdUnit2.load_id = loadAdRequest.getLoadId();
                baseAdUnit2.ad_source_channel = ad.ad_source_channel;
                if ((materialMeta.creative_type.intValue() == m.CreativeTypeVideo_Html_Snippet.a() || materialMeta.creative_type.intValue() == m.CreativeTypeVideo_transparent_html.a()) && (byteString = materialMeta.html_snippet) != null) {
                    byteString.size();
                }
                baseAdUnit2.slotAdSetting = slotAdSetting;
                baseAdUnit2.adRequest = loadAdRequest;
                baseAdUnit2.scene = template;
                baseAdUnit2.uid = str2;
                baseAdUnit2.expiration_time = num.intValue();
                BiddingResponse biddingResponse2 = ad.bidding_response;
                if (biddingResponse2 != null) {
                    baseAdUnit2.bidding_response = biddingResponse2;
                } else {
                    baseAdUnit2.bidding_response = biddingResponse;
                }
                baseAdUnit2.useDownloadedApk = ((Boolean) Wire.get(slotAdSetting.use_downloaded_apk, Boolean.FALSE)).booleanValue();
                initAdTrackerMap(baseAdUnit2);
                if (ad.ad_track_macro != null) {
                    baseAdUnit2.getMacroCommon().setServerMacroMap(ad.ad_track_macro);
                }
                if (baseAdUnit2.ad_type == 5 && (nativeAd = baseAdUnit2.getNativeAd()) != null) {
                    if (nativeAd.type.intValue() == 1) {
                        baseAdUnit2.getNativeVideo();
                    } else {
                        baseAdUnit2.getImageUrlList();
                    }
                }
                return baseAdUnit2;
            } catch (Throwable th) {
                th = th;
                baseAdUnit = baseAdUnit2;
                SigmobLog.e("adUnit error", th);
                return baseAdUnit;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean checkFileMD5(String str, String str2) {
        String fileMd5 = Md5Util.fileMd5(str);
        SigmobLog.d("path: [ " + str + " ] calc [ " + fileMd5 + " ] origin " + str2);
        return fileMd5 != null && fileMd5.equalsIgnoreCase(str2);
    }

    public static List<ah> createTrackersForUrls(List<String> list, String str, String str2, Integer num) {
        Preconditions.NoThrow.checkNotNull(list);
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            ah ahVar = new ah(it.next(), str, str2);
            ahVar.setRetryNum(num);
            arrayList.add(ahVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getAppSize() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return 0;
        }
        String str = map.get("app_size");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static long getSerialVersionUID() {
        return 1L;
    }

    public static String getTAG() {
        return TAG;
    }

    private static void initAdTrackerMap(BaseAdUnit baseAdUnit) {
        List<Tracking> ad_tracking = baseAdUnit.getAd_tracking();
        baseAdUnit.adTrackersMap = new HashMap<>();
        for (Tracking tracking : ad_tracking) {
            baseAdUnit.adTrackersMap.put(tracking.tracking_event_type, createTrackersForUrls(tracking.tracking_url, tracking.tracking_event_type, baseAdUnit.request_id, Integer.valueOf(baseAdUnit.getTrackingRetryNum())));
        }
    }

    public boolean canInstall(String str) {
        boolean z = (TextUtils.isEmpty(getApkMd5()) && getDownloadTask() == null && getDownloadId() == null) ? false : true;
        if (canUseDownloadApk() && !TextUtils.isEmpty(str) && z) {
            File file = new File(e.a(b.e()), str);
            if (file.exists() && ClientMetadata.getPackageInfoWithUri(b.e(), file.getAbsolutePath()) != null) {
                return true;
            }
        }
        return false;
    }

    public boolean canOpen() {
        String str = this.apkPackageName;
        if (TextUtils.isEmpty(str)) {
            str = getProductId();
        }
        return (TextUtils.isEmpty(str) || b.e().getPackageManager().getLaunchIntentForPackage(str) == null) ? false : true;
    }

    public boolean canUseDownloadApk() {
        return this.useDownloadedApk;
    }

    public boolean checkEndCardZipValid() {
        if (TextUtils.isEmpty(getEndcard_url()) || TextUtils.isEmpty(this.endcard_md5)) {
            return true;
        }
        return checkFileMD5(getEndCardZipPath(), getEndcard_md5());
    }

    public boolean checkVideoValid() {
        if (TextUtils.isEmpty(getVideo_url()) || TextUtils.isEmpty(this.video_md5)) {
            return true;
        }
        return checkFileMD5(getVideoPath(), getVideo_OriginMD5());
    }

    public void destroy() {
        i iVar = this.adConfig;
        if (iVar != null) {
            iVar.k();
            this.adConfig = null;
        }
        ag agVar = this.mSessionManager;
        if (agVar != null) {
            agVar.a();
        }
    }

    public void dislikeReport() {
        this.isDislikeReported = true;
    }

    public void enableUseDownloadApk(boolean z) {
        this.useDownloadedApk = z;
    }

    public boolean enable_full_click() {
        SplashAdSetting splashAdSetting = getSplashAdSetting();
        if (splashAdSetting != null) {
            return splashAdSetting.enable_full_click.booleanValue();
        }
        return false;
    }

    public Ad getAd() {
        return this.ad;
    }

    public AdAppInfo getAdAppInfo() {
        AdPrivacy adPrivacy = getadPrivacy();
        if (this.adAppInfo == null && adPrivacy != null) {
            try {
                this.adAppInfo = new AdAppInfo() { // from class: com.sigmob.sdk.base.models.BaseAdUnit.1
                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getAppName() {
                        return BaseAdUnit.this.getPrivacyAppName();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public int getAppSize() {
                        return BaseAdUnit.this.getAppSize();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getAuthorName() {
                        return BaseAdUnit.this.getCompanyName();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getDescription() {
                        return BaseAdUnit.this.getDescription();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getDescriptionUrl() {
                        return BaseAdUnit.this.getDescriptionUrl();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getPermissions() {
                        return BaseAdUnit.this.getPermissions();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getPermissionsUrl() {
                        return BaseAdUnit.this.getPermissionsUrl();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getPrivacyAgreement() {
                        return BaseAdUnit.this.getPrivacyAgreement();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getPrivacyAgreementUrl() {
                        return BaseAdUnit.this.getPrivacyAgreementUrl();
                    }

                    @Override // com.sigmob.windad.natives.AdAppInfo
                    public String getVersionName() {
                        return BaseAdUnit.this.getAppVersion();
                    }

                    public String toString() {
                        return String.format("appName %s \n AuthorName %s \n  versionName %s \n permissionsUrl %s \n permissions %s \nprivacyAgreementUrl %s \n privacyAgreement %s \n descriptionUrl %s \n description %s \n  appsize %d", getAppName(), getAuthorName(), getVersionName(), getPermissionsUrl(), getPermissions(), getPrivacyAgreementUrl(), getPrivacyAgreement(), getDescriptionUrl(), getDescription(), Integer.valueOf(getAppSize()));
                    }
                };
            } catch (Throwable unused) {
            }
        }
        return this.adAppInfo;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0008. Please report as an issue. */
    public i getAdConfig() {
        i f;
        if (this.adConfig == null) {
            switch (getAd_type()) {
                case 1:
                case 4:
                    f = a.f(this);
                    this.adConfig = f;
                    return f;
                case 2:
                    f = c.f(this);
                    this.adConfig = f;
                    return f;
                case 3:
                case 6:
                    f = d.f(this);
                    this.adConfig = f;
                    return f;
                case 5:
                    f = com.sigmob.sdk.nativead.c.f(this);
                    this.adConfig = f;
                    return f;
            }
        }
        return this.adConfig;
    }

    public Integer getAdExpiredTime() {
        Integer num;
        Ad ad = this.ad;
        return Integer.valueOf((ad == null || (num = ad.expired_time) == null) ? 0 : num.intValue() * 1000);
    }

    public String getAdLogo() {
        return getAd_source_logo();
    }

    public double getAdPercent() {
        double d = this.adPercent;
        if (d > 0.0d) {
            return d;
        }
        double d2 = this.realAdPercent;
        if (d2 > 0.0d) {
            return d2;
        }
        return 1.7777777910232544d;
    }

    public File getAdPrivacyTemplateFile() {
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null) {
            return null;
        }
        String str = adPrivacy.privacy_template_url;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String md5 = Md5Util.md5(str);
        return e.a(e.d(e.b), md5 + ".html");
    }

    public LoadAdRequest getAdRequest() {
        return this.adRequest;
    }

    public AdSetting getAdSetting() {
        Ad ad = this.ad;
        if (ad != null) {
            return ad.ad_setting;
        }
        return null;
    }

    public List<ah> getAdTracker(String str) {
        HashMap<String, List<ah>> hashMap = this.adTrackersMap;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        return null;
    }

    public String getAd_scene_desc() {
        return this.ad_scene_desc;
    }

    public String getAd_scene_id() {
        return this.ad_scene_id;
    }

    public String getAd_source_channel() {
        return this.ad_source_channel;
    }

    public String getAd_source_logo() {
        Ad ad = this.ad;
        if (ad != null) {
            return ad.ad_source_logo;
        }
        return null;
    }

    public List<Tracking> getAd_tracking() {
        Ad ad = this.ad;
        if (ad != null) {
            return ad.ad_tracking;
        }
        return null;
    }

    public int getAd_type() {
        return this.ad_type;
    }

    public String getAdslot_id() {
        return this.adslot_id;
    }

    public String getAdx_id() {
        return this.adx_id;
    }

    public AndroidMarket getAndroidMarket() {
        AndroidMarket androidMarket;
        MaterialMeta material = getMaterial();
        AndroidMarket androidMarket2 = material != null ? material.android_market : null;
        return (androidMarket2 != null || (androidMarket = this.mCustomAndroidMarket) == null) ? androidMarket2 : androidMarket;
    }

    public int getApkDownloadType() {
        SlotAdSetting slotAdSetting = getSlotAdSetting();
        if (slotAdSetting != null) {
            return ((Integer) Wire.get(slotAdSetting.apk_download_type, 0)).intValue();
        }
        return 0;
    }

    public String getApkMd5() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return (String) Wire.get(material.apk_md5, (Object) null);
        }
        return null;
    }

    public String getApkName() {
        return this.apkName;
    }

    public String getApkPackageName() {
        return this.apkPackageName;
    }

    public String getAppName() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.app_name;
        }
        return null;
    }

    public String getAppVersion() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return null;
        }
        return map.get("app_version");
    }

    public int getBP() {
        Ad ad = this.ad;
        if (ad != null) {
            return ((Integer) Wire.get(ad.bid_price, 0)).intValue();
        }
        return 0;
    }

    public int getBidEcpm() {
        BiddingResponse biddingResponse = this.bidding_response;
        if (biddingResponse != null) {
            return ((Integer) Wire.get(biddingResponse.ecpm, 0)).intValue();
        }
        return 0;
    }

    public String getBid_token() {
        return this.bid_token;
    }

    public int getButtonColor() {
        Color color;
        MaterialMeta material = getMaterial();
        return (material == null || (color = material.button_color) == null) ? android.graphics.Color.parseColor("#FF5A57") : android.graphics.Color.argb((int) (color.alpha.floatValue() * 255.0f), material.button_color.red.intValue(), material.button_color.green.intValue(), material.button_color.blue.intValue());
    }

    public String getCTAText() {
        MaterialMeta material = getMaterial();
        String str = material != null ? material.button_text : null;
        return !TextUtils.isEmpty(str) ? str : getInteractionType() != 2 ? "查看详情" : "立即下载";
    }

    public String getCamp_id() {
        return this.camp_id;
    }

    public int getChargePercent() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting != null) {
            return ((Integer) Wire.get(rvAdSetting.charge_percent, 0)).intValue();
        }
        return 0;
    }

    public int getChargeSeconds() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting != null) {
            return ((Integer) Wire.get(rvAdSetting.charge_seconds, 0)).intValue();
        }
        return 0;
    }

    public ClickAreaSetting getClickAreaSetting() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        ClickAreaSetting clickAreaSetting = rvAdSetting.click_setting;
        if (clickAreaSetting != null) {
            if (rvAdSetting != null) {
                return clickAreaSetting;
            }
            return null;
        }
        ClickAreaSetting.Builder builder = new ClickAreaSetting.Builder();
        builder.bottom = Float.valueOf(0.1f);
        builder.right = Float.valueOf(0.1f);
        builder.top = Float.valueOf(0.1f);
        builder.left = Float.valueOf(0.1f);
        return builder.build();
    }

    public ClickCommon getClickCommon() {
        if (this.clickCommon == null) {
            this.clickCommon = new ClickCommon();
        }
        return this.clickCommon;
    }

    public int getClickType() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return ((Integer) Wire.get(material.click_type, 0)).intValue();
        }
        return 0;
    }

    public String getCloseCardHtmlData() {
        if (getMaterial() == null) {
            return null;
        }
        if (getMaterial().closecard_html_snippet != null || getMaterial().closecard_html_snippet.size() >= 10) {
            return getMaterial().closecard_html_snippet.utf8();
        }
        return null;
    }

    public String getCompanyName() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return null;
        }
        return map.get("app_company");
    }

    public int getConfirmDialog() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting != null) {
            return ((Integer) Wire.get(rvAdSetting.confirm_dialog, 0)).intValue();
        }
        return 0;
    }

    public long getCreate_time() {
        return this.create_time;
    }

    public n.b getCreativeResourceType() {
        return (TextUtils.isEmpty(getEndcard_url()) || !(getCreativeType() == m.CreativeTypeVideo_Tar.a() || getCreativeType() == m.CreativeTypeVideo_Tar_Companion.a())) ? !TextUtils.isEmpty(getHtmlData()) ? n.b.HTML_RESOURCE : !TextUtils.isEmpty(getHtmlUrl()) ? n.b.URL_RESOURCE : n.b.NATIVE_RESOURCE : n.b.NATIVE_RESOURCE;
    }

    public String getCreativeTitle() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.creative_title;
        }
        return null;
    }

    public int getCreativeType() {
        if (getMaterial() != null) {
            return getMaterial().creative_type.intValue();
        }
        return 0;
    }

    public String getCrid() {
        return this.crid;
    }

    public Uri getDeeplinkUri() {
        return this.deeplinkUri;
    }

    public String getDeeplinkUrl() {
        MaterialMeta material = getMaterial();
        String str = material != null ? material.deeplink_url : null;
        return (!TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mCustomDeeplink)) ? str : this.mCustomDeeplink;
    }

    public String getDesc() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.desc;
        }
        return null;
    }

    public String getDescription() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return null;
        }
        return map.get("app_func");
    }

    public String getDescriptionUrl() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return null;
        }
        return map.get("app_func_url");
    }

    public boolean getDisableAutoLoad() {
        Boolean bool;
        if (this.ad_type == 6) {
            InterstitialSetting newInterstitialSetting = getNewInterstitialSetting();
            if (newInterstitialSetting == null) {
                return false;
            }
            bool = newInterstitialSetting.disable_auto_load;
        } else {
            RvAdSetting rvAdSetting = getRvAdSetting();
            if (rvAdSetting == null) {
                return false;
            }
            bool = rvAdSetting.disable_auto_load;
        }
        return bool.booleanValue();
    }

    public int getDisplay_orientation() {
        Ad ad = getAd();
        if (ad != null) {
            return ((Integer) Wire.get(ad.display_orientation, 0)).intValue();
        }
        return 0;
    }

    public Long getDownloadId() {
        return this.downloadId;
    }

    public List<com.sigmob.sdk.videoAd.f> getDownloadQuarterTrack() {
        return this.download_trackers;
    }

    public f getDownloadTask() {
        return this.downloadTask;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public int getDuration() {
        int endTime = getEndTime();
        if (endTime > 0) {
            return endTime * 1000;
        }
        return 33333;
    }

    public boolean getEnableDeeplinkAndLandingPage() {
        SlotAdSetting slotAdSetting = this.slotAdSetting;
        if (slotAdSetting != null) {
            return ((Boolean) Wire.get(slotAdSetting.enable_deeplink_and_landing_page, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public String getEndCardDirPath() {
        return e.b() + String.format("/%s/", getEndcard_md5());
    }

    public String getEndCardImageUrl() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.endcard_image_src;
        }
        return null;
    }

    public String getEndCardIndexPath() {
        return getEndCardDirPath() + "endcard.html";
    }

    public String getEndCardZipPath() {
        return e.b() + String.format("/%s.tgz", this.endcard_md5);
    }

    public String getEndCard_OriginMD5() {
        return this.endcard_md5;
    }

    public int getEndTime() {
        RvAdSetting rvAdSetting;
        if (this.ad_type == 6 || (rvAdSetting = getRvAdSetting()) == null) {
            return 0;
        }
        return rvAdSetting.end_time.intValue();
    }

    public int getEndcardCloseImage() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting != null) {
            return rvAdSetting.endcard_close_image.intValue();
        }
        return 0;
    }

    public String getEndcard_md5() {
        return !TextUtils.isEmpty(this.endcard_md5) ? this.endcard_md5 : Md5Util.md5(getCrid());
    }

    public String getEndcard_url() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.endcard_url;
        }
        return null;
    }

    public float getFinishedTime() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting != null) {
            return rvAdSetting.finished.floatValue();
        }
        return 1.0f;
    }

    public int getFloor() {
        NativeAdSetting nativeAdSetting = getNativeAdSetting();
        if (nativeAdSetting != null) {
            return ((Integer) Wire.get(nativeAdSetting.media_expected_floor, 0)).intValue();
        }
        return 0;
    }

    public boolean getFullClickOnVideo() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting != null) {
            return rvAdSetting.full_click_on_video.booleanValue();
        }
        return false;
    }

    public String getHtmlData() {
        if (getMaterial() == null) {
            return null;
        }
        if (getMaterial().html_snippet != null || getMaterial().html_snippet.size() >= 10) {
            return getMaterial().html_snippet.utf8();
        }
        return null;
    }

    public String getHtmlUrl() {
        if (getMaterial() == null) {
            return null;
        }
        return getMaterial().html_url;
    }

    public String getIconUrl() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.icon_url;
        }
        return null;
    }

    public List<SigImage> getImageUrlList() {
        ResponseNativeAd nativeAd = getNativeAd();
        if (this.imageUrlList == null) {
            this.imageUrlList = new ArrayList();
            if (nativeAd != null && nativeAd.type.intValue() != 1) {
                Iterator<ResponseAsset> it = nativeAd.assets.iterator();
                while (it.hasNext()) {
                    ResponseAssetImage responseAssetImage = it.next().image;
                    if (responseAssetImage != null) {
                        SigImage sigImage = new SigImage(responseAssetImage.url, responseAssetImage.w.intValue(), responseAssetImage.h.intValue());
                        if (this.adPercent < 0.0d && responseAssetImage.w.intValue() > 0 && responseAssetImage.h.intValue() > 0) {
                            this.adPercent = (responseAssetImage.w.intValue() * 1.0f) / responseAssetImage.h.intValue();
                        }
                        this.imageUrlList.add(sigImage);
                    }
                }
            }
        }
        return this.imageUrlList;
    }

    public int getInteractionType() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.interaction_type.intValue();
        }
        return 1;
    }

    public boolean getInvisibleAdLabel() {
        RvAdSetting rvAdSetting;
        Boolean bool;
        if (getAd_type() == 2) {
            SplashAdSetting splashAdSetting = getSplashAdSetting();
            if (splashAdSetting == null) {
                return false;
            }
            bool = splashAdSetting.invisible_ad_label;
        } else {
            if ((getAd_type() != 1 && getAd_type() != 4) || (rvAdSetting = getRvAdSetting()) == null) {
                return false;
            }
            bool = rvAdSetting.invisible_ad_label;
        }
        return bool.booleanValue();
    }

    public int getIsMute() {
        Integer num;
        if (this.ad_type == 6) {
            InterstitialSetting newInterstitialSetting = getNewInterstitialSetting();
            if (newInterstitialSetting == null) {
                return 0;
            }
            num = newInterstitialSetting.if_mute;
        } else {
            RvAdSetting rvAdSetting = getRvAdSetting();
            if (rvAdSetting == null) {
                return 0;
            }
            num = rvAdSetting.if_mute;
        }
        return num.intValue();
    }

    public String getLandUrl() {
        return this.landUrl;
    }

    public String getLanding_page() {
        String str = getMaterial() != null ? getMaterial().landing_page : null;
        return (!TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mCustomLandPageUrl)) ? str : this.mCustomLandPageUrl;
    }

    public String getLoad_id() {
        return this.load_id;
    }

    public SigMacroCommon getMacroCommon() {
        if (this.macroCommon == null) {
            this.macroCommon = new SigMacroCommon();
            String video_url = getVideo_url();
            if (!TextUtils.isEmpty(video_url)) {
                try {
                    String encode = URLEncoder.encode(video_url, "UTF-8");
                    if (!TextUtils.isEmpty(encode)) {
                        this.macroCommon.addMarcoKey(SigMacroCommon._VURL_, encode);
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return this.macroCommon;
    }

    public String getMainImage() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.image_src;
        }
        return null;
    }

    public MaterialMeta getMaterial() {
        List<MaterialMeta> list;
        Ad ad = this.ad;
        if (ad == null || (list = ad.materials) == null || list.size() <= 0) {
            return null;
        }
        return this.ad.materials.get(0);
    }

    public ResponseNativeAd getNativeAd() {
        List<MaterialMeta> list;
        Ad ad = this.ad;
        if (ad == null || (list = ad.materials) == null || list.size() <= 0) {
            return null;
        }
        return this.ad.materials.get(0).native_ad;
    }

    public NativeAdSetting getNativeAdSetting() {
        SlotAdSetting slotAdSetting = this.slotAdSetting;
        if (slotAdSetting != null) {
            return slotAdSetting.native_setting;
        }
        return null;
    }

    public SigVideo getNativeVideo() {
        ResponseNativeAd nativeAd = getNativeAd();
        if (this.nativeVideo == null && nativeAd != null && nativeAd.type.intValue() == 1) {
            for (ResponseAsset responseAsset : nativeAd.assets) {
                ResponseAssetVideo responseAssetVideo = responseAsset.video;
                if (responseAssetVideo != null) {
                    if (this.nativeVideo == null) {
                        this.nativeVideo = new SigVideo();
                    }
                    SigVideo sigVideo = this.nativeVideo;
                    sigVideo.url = responseAssetVideo.url;
                    sigVideo.height = responseAssetVideo.h.intValue();
                    this.nativeVideo.width = responseAssetVideo.w.intValue();
                    if (this.adPercent < 0.0d && responseAssetVideo.h.intValue() > 0 && responseAssetVideo.w.intValue() > 0) {
                        this.adPercent = (responseAssetVideo.w.intValue() * 1.0f) / responseAssetVideo.h.intValue();
                    }
                }
                ResponseAssetImage responseAssetImage = responseAsset.image;
                if (responseAssetImage != null) {
                    if (this.nativeVideo == null) {
                        this.nativeVideo = new SigVideo();
                    }
                    this.nativeVideo.thumbUrl = responseAssetImage.url;
                }
            }
        }
        return this.nativeVideo;
    }

    public InterstitialSetting getNewInterstitialSetting() {
        SlotAdSetting slotAdSetting = getSlotAdSetting();
        if (slotAdSetting != null) {
            return slotAdSetting.interstitial_setting;
        }
        return null;
    }

    public String getPermissions() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return null;
        }
        return map.get("app_permission");
    }

    public String getPermissionsUrl() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return null;
        }
        return map.get("app_permission_url");
    }

    public int getPlayMode() {
        if (getMaterial() != null) {
            return getMaterial().play_mode.intValue();
        }
        return 0;
    }

    public String getPrivacyAgreement() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return null;
        }
        return map.get("app_privacy_text");
    }

    public String getPrivacyAgreementUrl() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return null;
        }
        return map.get("app_privacy_url");
    }

    public String getPrivacyAppName() {
        Map<String, String> map;
        AdPrivacy adPrivacy = getadPrivacy();
        if (adPrivacy == null || (map = adPrivacy.privacy_template_info) == null) {
            return null;
        }
        return map.get("app_name");
    }

    public String getProductId() {
        if (getAd() != null) {
            return getAd().product_id;
        }
        return null;
    }

    public String getProxyVideoUrl() {
        String video_url = getVideo_url();
        return !TextUtils.isEmpty(video_url) ? h.d().a(video_url) : video_url;
    }

    public String getRequestId() {
        return this.request_id;
    }

    public int getRewardPercent() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting != null) {
            return ((Integer) Wire.get(rvAdSetting.reward_percent, 0)).intValue();
        }
        return 0;
    }

    public int getRewardSeconds() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting != null) {
            return ((Integer) Wire.get(rvAdSetting.reward_seconds, 0)).intValue();
        }
        return 0;
    }

    public int getRewardStyle() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting != null) {
            return ((Integer) Wire.get(rvAdSetting.reward_style, 0)).intValue();
        }
        return 0;
    }

    public RvAdSetting getRvAdSetting() {
        SlotAdSetting slotAdSetting = this.slotAdSetting;
        if (slotAdSetting != null) {
            return slotAdSetting.rv_setting;
        }
        return null;
    }

    public String getRvCallBackUrl() {
        return this.rv_callback_url;
    }

    public Template getScene() {
        return this.scene;
    }

    public int getSensitivity() {
        AdSetting adSetting = getAdSetting();
        if (adSetting != null) {
            return adSetting.sensitivity.intValue();
        }
        return 0;
    }

    public ag getSessionManager() {
        return this.mSessionManager;
    }

    public SingleNativeAdSetting getSingleNativeSetting() {
        AdSetting adSetting = getAdSetting();
        if (adSetting != null) {
            return adSetting.single_native_setting;
        }
        return null;
    }

    public int getSkipPercent() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting != null) {
            return ((Integer) Wire.get(rvAdSetting.skip_percent, 0)).intValue();
        }
        return -1;
    }

    public int getSkipSeconds() {
        Integer num;
        if (this.ad_type == 6) {
            InterstitialSetting newInterstitialSetting = getNewInterstitialSetting();
            if (newInterstitialSetting == null) {
                return -1;
            }
            num = newInterstitialSetting.show_skip_seconds;
        } else {
            RvAdSetting rvAdSetting = getRvAdSetting();
            if (rvAdSetting == null) {
                return -1;
            }
            num = (Integer) Wire.get(rvAdSetting.skip_seconds, 0);
        }
        return num.intValue();
    }

    public SlotAdSetting getSlotAdSetting() {
        return this.slotAdSetting;
    }

    public SplashAdSetting getSplashAdSetting() {
        SlotAdSetting slotAdSetting = getSlotAdSetting();
        if (slotAdSetting != null) {
            return slotAdSetting.splash_setting;
        }
        return null;
    }

    public String getSplashFilePath() {
        StringBuilder sb;
        String str;
        if (m.CreativeTypeSplashVideo.a() == getMaterial().creative_type.intValue()) {
            sb = new StringBuilder();
            sb.append(e.e());
            sb.append(File.separator);
            str = getMaterial().video_url;
        } else {
            sb = new StringBuilder();
            sb.append(e.e());
            sb.append(File.separator);
            str = getMaterial().image_src;
        }
        sb.append(Md5Util.md5(str));
        return sb.toString();
    }

    public String getSplashURL() {
        return m.CreativeTypeSplashVideo.a() == getMaterial().creative_type.intValue() ? getMaterial().video_url : getMaterial().image_src;
    }

    public int getTemplateId() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.template_id.intValue();
        }
        return 0;
    }

    public int getTemplateType() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.template_type.intValue();
        }
        return 0;
    }

    public String getTitle() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.title;
        }
        return null;
    }

    public int getTrackingRetryNum() {
        SlotAdSetting slotAdSetting = this.slotAdSetting;
        if (slotAdSetting != null) {
            return ((Integer) Wire.get(slotAdSetting.retry_count, 0)).intValue();
        }
        return 0;
    }

    public String getUuid() {
        if (this.uuid == null) {
            this.uuid = UUID.randomUUID().toString();
        }
        return this.uuid;
    }

    public String getVid() {
        if (getAd() != null) {
            return getAd().vid;
        }
        return null;
    }

    public VideoStatusCommon getVideoCommon() {
        if (this.videoCommon == null) {
            this.videoCommon = new VideoStatusCommon();
        }
        return this.videoCommon;
    }

    public String getVideoCoverImageUrl() {
        SigVideo sigVideo = this.nativeVideo;
        if (sigVideo != null) {
            return sigVideo.thumbUrl;
        }
        return null;
    }

    public boolean getVideoErrorReward() {
        RvAdSetting rvAdSetting = getRvAdSetting();
        if (rvAdSetting != null) {
            return ((Boolean) Wire.get(rvAdSetting.video_error_reward, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public String getVideoPath() {
        File videoProxyFile = getVideoProxyFile();
        if (videoProxyFile != null) {
            return videoProxyFile.getAbsolutePath();
        }
        return null;
    }

    public File getVideoProxyFile() {
        String video_url = getVideo_url();
        if (TextUtils.isEmpty(video_url)) {
            return null;
        }
        return h.d().c(video_url);
    }

    public String getVideoTmpPath() {
        return e.a() + String.format("/%s.mp4.tmp", getVideo_md5());
    }

    public String getVideo_OriginMD5() {
        return this.video_md5;
    }

    public String getVideo_md5() {
        return !TextUtils.isEmpty(this.video_md5) ? this.video_md5 : Md5Util.md5(getVideo_url());
    }

    public String getVideo_url() {
        String str;
        Ad ad = this.ad;
        if (ad == null || ad.materials.size() <= 0) {
            return null;
        }
        if (this.ad_type == 5) {
            SigVideo nativeVideo = getNativeVideo();
            if (nativeVideo == null) {
                return null;
            }
            str = nativeVideo.url;
        } else {
            MaterialMeta materialMeta = this.ad.materials.get(0);
            if (materialMeta == null) {
                return null;
            }
            str = materialMeta.video_url;
        }
        return StringUtil.getUrl(str);
    }

    public WXProgramRes getWXProgramRes() {
        WXProgramRes wXProgramRes;
        Ad ad = getAd();
        if (ad == null || (wXProgramRes = ad.wx_program_res) == null) {
            return null;
        }
        return wXProgramRes;
    }

    public long getWidgetId(int i) {
        List<Widget> list;
        Widget widget;
        MaterialMeta material = getMaterial();
        if (material == null || (list = material.Widget_list) == null || list.isEmpty() || (widget = list.get(i)) == null) {
            return 0L;
        }
        return widget.widget_id.longValue();
    }

    public AdPrivacy getadPrivacy() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.ad_privacy;
        }
        return null;
    }

    public int getsubInteractionType() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.sub_interaction_type.intValue();
        }
        return 0;
    }

    public boolean hasEndCard() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.has_endcard.booleanValue();
        }
        return false;
    }

    public boolean isCatchVideo() {
        return this.catchVideo;
    }

    public boolean isClickAutoCloseSplash() {
        return false;
    }

    public boolean isDisablexRequestWith() {
        SlotAdSetting slotAdSetting = this.slotAdSetting;
        if (slotAdSetting != null) {
            return ((Boolean) Wire.get(slotAdSetting.disable_x_requested_with, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public boolean isDislikeReported() {
        return this.isDislikeReported;
    }

    public boolean isDownloadDialog() {
        MaterialMeta material = getMaterial();
        if (material != null) {
            return material.download_dialog.booleanValue();
        }
        return false;
    }

    public boolean isEndCardIndexExist() {
        if (TextUtils.isEmpty(getEndcard_url())) {
            return true;
        }
        if (getCreativeType() == m.CreativeTypeVideo_Tar.a() || getCreativeType() == m.CreativeTypeVideo_Tar_Companion.a()) {
            return new File(getEndCardIndexPath()).exists();
        }
        return true;
    }

    public boolean isExpiredAd() {
        long intValue = getAdExpiredTime().intValue();
        return (intValue == 0 || this.create_time == 0 || System.currentTimeMillis() - this.create_time <= intValue) ? false : true;
    }

    public boolean isHalfInterstitial() {
        return this.isHalfInterstitial;
    }

    public boolean isNativeAdH5() {
        return true;
    }

    public boolean isRecord() {
        return this.record;
    }

    public boolean isResumableDownload() {
        SlotAdSetting slotAdSetting = this.slotAdSetting;
        if (slotAdSetting != null) {
            return ((Boolean) Wire.get(slotAdSetting.resumable_download, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public boolean isSkipSigmobBrowser() {
        AdSetting adSetting = getAdSetting();
        return adSetting == null || !adSetting.in_app.booleanValue();
    }

    public boolean isUse_floating_btn() {
        SplashAdSetting splashAdSetting = getSplashAdSetting();
        if (splashAdSetting != null) {
            return splashAdSetting.use_floating_btn.booleanValue();
        }
        return false;
    }

    public boolean isVideoExist() {
        if (TextUtils.isEmpty(getVideo_url())) {
            return true;
        }
        String videoPath = getVideoPath();
        boolean exists = new File(videoPath).exists();
        SigmobLog.d("isVideoExist path :" + videoPath + " isExist: " + exists);
        return exists;
    }

    public boolean noHasDownloadDialog() {
        return ((getInteractionType() == 2 || getInteractionType() == 3) && getadPrivacy() != null && isDownloadDialog()) ? false : true;
    }

    public String resourcePath() {
        return (TextUtils.isEmpty(getEndcard_url()) || !(getCreativeType() == m.CreativeTypeVideo_Tar.a() || getCreativeType() == m.CreativeTypeVideo_Tar_Companion.a())) ? !TextUtils.isEmpty(getHtmlData()) ? getHtmlData() : getHtmlUrl() : getEndCardIndexPath();
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }

    public void setAdSize(int i, int i2) {
        this.adWidth = i;
        this.adHeight = i2;
        getMacroCommon().addMarcoKey(SigMacroCommon._WIDTH_, String.valueOf(i));
        getMacroCommon().addMarcoKey(SigMacroCommon._HEIGHT_, String.valueOf(i2));
    }

    public void setAd_scene_desc(String str) {
        this.ad_scene_desc = str;
    }

    public void setAd_scene_id(String str) {
        this.ad_scene_id = str;
    }

    public void setAd_source_channel(String str) {
        this.ad_source_channel = str;
    }

    public void setAd_type(int i) {
        this.ad_type = i;
    }

    public void setAdslot_id(String str) {
        this.adslot_id = str;
    }

    public void setAdx_id(String str) {
        this.adx_id = str;
    }

    public void setApkName(String str) {
        this.apkName = str;
    }

    public void setApkPackageName(String str) {
        this.apkPackageName = str;
    }

    public void setBid_token(String str) {
        this.bid_token = str;
    }

    public void setCamp_id(String str) {
        this.camp_id = str;
    }

    public void setCatchVideo(boolean z) {
        this.catchVideo = z;
    }

    public void setCreate_time(long j) {
        this.create_time = j;
    }

    public void setCrid(String str) {
        this.crid = str;
    }

    public void setCustomAndroidMarket(AndroidMarket androidMarket) {
        this.mCustomAndroidMarket = androidMarket;
    }

    public void setCustomDeeplink(String str) {
        this.mCustomDeeplink = str;
    }

    public void setCustomLandPageUrl(String str) {
        this.mCustomLandPageUrl = str;
    }

    public void setDeeplinkUri(Uri uri) {
        this.deeplinkUri = uri;
    }

    public void setDownloadId(Long l) {
        this.downloadId = l;
    }

    public void setDownloadQuarterTrack(List<com.sigmob.sdk.videoAd.f> list) {
        this.download_trackers = list;
    }

    public void setDownloadTask(f fVar) {
        this.downloadTask = fVar;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setEndcard_md5(String str) {
        this.endcard_md5 = str;
    }

    public void setHalfInterstitial(boolean z) {
        this.isHalfInterstitial = z;
    }

    public void setLoad_id(String str) {
        this.load_id = str;
    }

    public void setMacroCommon(SigMacroCommon sigMacroCommon) {
        this.macroCommon = sigMacroCommon;
    }

    public void setRecord(boolean z) {
        this.record = z;
    }

    public void setRequest_id(String str) {
        this.request_id = str;
    }

    public void setRvCallBackUrl(String str) {
        this.rv_callback_url = str;
    }

    public void setSessionManager(ag agVar) {
        this.mSessionManager = agVar;
    }

    public void setUrl(String str) {
        this.landUrl = str;
    }

    public void setVideo_md5(String str) {
        this.video_md5 = str;
    }

    public void updateRealAdPercent(double d) {
        this.realAdPercent = d;
    }
}
