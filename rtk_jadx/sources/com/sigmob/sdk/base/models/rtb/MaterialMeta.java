package com.sigmob.sdk.base.models.rtb;

import android.os.Parcelable;
import com.czhj.sdk.common.models.Size;
import com.czhj.wire.AndroidMessage;
import com.czhj.wire.FieldEncoding;
import com.czhj.wire.Message;
import com.czhj.wire.ProtoAdapter;
import com.czhj.wire.ProtoReader;
import com.czhj.wire.ProtoWriter;
import com.czhj.wire.WireField;
import com.czhj.wire.internal.Internal;
import com.czhj.wire.okio.ByteString;
import com.sigmob.sdk.base.blurkit.c;
import com.sigmob.sdk.base.models.WebEventHandle;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class MaterialMeta extends AndroidMessage<MaterialMeta, Builder> {
    public static final ProtoAdapter<MaterialMeta> ADAPTER;
    public static final Parcelable.Creator<MaterialMeta> CREATOR;
    public static final String DEFAULT_APK_MD5 = "";
    public static final String DEFAULT_APP_NAME = "";
    public static final String DEFAULT_BUTTON_TEXT = "";
    public static final Integer DEFAULT_CLICK_TYPE;
    public static final ByteString DEFAULT_CLOSECARD_HTML_SNIPPET;
    public static final String DEFAULT_CREATIVE_TITLE = "";
    public static final Integer DEFAULT_CREATIVE_TYPE;
    public static final String DEFAULT_DEEPLINK_URL = "";
    public static final String DEFAULT_DESC = "";
    public static final Boolean DEFAULT_DISABLE_AUTO_DEEPLINK;
    public static final Boolean DEFAULT_DOWNLOAD_DIALOG;
    public static final Boolean DEFAULT_ENABLE_COLLAPSE_TOOL_BAR;
    public static final String DEFAULT_ENDCARD_IMAGE_SRC = "";
    public static final String DEFAULT_ENDCARD_MD5 = "";
    public static final String DEFAULT_ENDCARD_URL = "";
    public static final Boolean DEFAULT_HAS_COMPANION_ENDCARD;
    public static final Boolean DEFAULT_HAS_ENDCARD;
    public static final ByteString DEFAULT_HTML_SNIPPET;
    public static final String DEFAULT_HTML_SRC = "";
    public static final String DEFAULT_HTML_URL = "";
    public static final String DEFAULT_ICON_URL = "";
    public static final String DEFAULT_IMAGE_MD5 = "";
    public static final String DEFAULT_IMAGE_SRC = "";
    public static final Integer DEFAULT_IMAGE_TYPE;
    public static final Integer DEFAULT_INTERACTION_TYPE;
    public static final Boolean DEFAULT_IN_APP;
    public static final String DEFAULT_LANDING_PAGE = "";
    public static final Integer DEFAULT_OPEN_MARKET_MODE;
    public static final Integer DEFAULT_PLAY_MODE;
    public static final Float DEFAULT_SCORE;
    public static final Integer DEFAULT_SUB_INTERACTION_TYPE;
    public static final Integer DEFAULT_TEMPLATE_ID;
    public static final Integer DEFAULT_TEMPLATE_TYPE;
    public static final Integer DEFAULT_THEME_DATA;
    public static final String DEFAULT_TITLE = "";
    public static final Integer DEFAULT_VIDEO_BYTE_SIZE;
    public static final Integer DEFAULT_VIDEO_DURATION;
    public static final String DEFAULT_VIDEO_MD5 = "";
    public static final Integer DEFAULT_VIDEO_RECIPROCAL_MILLISECOND;
    public static final String DEFAULT_VIDEO_URL = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.Widget#ADAPTER", label = WireField.Label.REPEATED, tag = 51)
    public final List<Widget> Widget_list;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.AdPrivacy#ADAPTER", tag = 36)
    public final AdPrivacy ad_privacy;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.AndroidMarket#ADAPTER", tag = 41)
    public final AndroidMarket android_market;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 52)
    public final String apk_md5;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 34)
    public final String app_name;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.ResponseAsset#ADAPTER", label = WireField.Label.REPEATED, tag = 44)
    public final List<ResponseAsset> asset;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.Color#ADAPTER", tag = 50)
    public final Color button_color;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 35)
    public final String button_text;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 16)
    public final Integer click_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 33)
    public final ByteString closecard_html_snippet;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.CompanionEndcard#ADAPTER", tag = 18)
    public final CompanionEndcard companion;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 48)
    public final String creative_title;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer creative_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String deeplink_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 28)
    public final String desc;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 32)
    public final Boolean disable_auto_deeplink;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 40)
    public final Boolean download_dialog;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 23)
    public final Boolean enable_collapse_tool_bar;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 47)
    public final String endcard_image_src;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String endcard_md5;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final String endcard_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 17)
    public final Boolean has_companion_endcard;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 49)
    public final Boolean has_endcard;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 7)
    public final ByteString html_snippet;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 38)
    public final String html_src;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 22)
    public final String html_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 29)
    public final String icon_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 14)
    public final String image_md5;

    @WireField(adapter = "com.sigmob.sdk.common.models.Size#ADAPTER", tag = 13)
    public final Size image_size;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    public final String image_src;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 15)
    public final Integer image_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 46)
    public final Boolean in_app;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer interaction_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String landing_page;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.Template#ADAPTER", tag = 42)
    public final Template main_template;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.ResponseNativeAd#ADAPTER", tag = 39)
    public final ResponseNativeAd native_ad;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 24)
    public final Integer open_market_mode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 25)
    public final Integer play_mode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 30)
    public final Float score;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 26)
    public final Integer sub_interaction_type;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.Template#ADAPTER", tag = 43)
    public final Template sub_template;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 31)
    public final Integer template_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 20)
    public final Integer template_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 45)
    public final Integer theme_data;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 27)
    public final String title;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 37)
    public final Integer video_byte_size;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 5)
    public final Integer video_duration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String video_md5;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 21)
    public final Integer video_reciprocal_millisecond;

    @WireField(adapter = "com.sigmob.sdk.common.models.Size#ADAPTER", tag = 6)
    public final Size video_size;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String video_url;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.WebEventHandle#ADAPTER", tag = 19)
    public final WebEventHandle web_event_handle;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class Builder extends Message.Builder<MaterialMeta, Builder> {
        public AdPrivacy ad_privacy;
        public AndroidMarket android_market;
        public String apk_md5;
        public Color button_color;
        public CompanionEndcard companion;
        public Size image_size;
        public Template main_template;
        public ResponseNativeAd native_ad;
        public Template sub_template;
        public Size video_size;
        public WebEventHandle web_event_handle;
        public Integer creative_type = MaterialMeta.DEFAULT_CREATIVE_TYPE;
        public Integer interaction_type = MaterialMeta.DEFAULT_INTERACTION_TYPE;
        public String landing_page = "";
        public String video_url = "";
        public Integer video_duration = MaterialMeta.DEFAULT_VIDEO_DURATION;
        public ByteString html_snippet = MaterialMeta.DEFAULT_HTML_SNIPPET;
        public String endcard_url = "";
        public String video_md5 = "";
        public String endcard_md5 = "";
        public String deeplink_url = "";
        public String image_src = "";
        public String image_md5 = "";
        public Integer image_type = MaterialMeta.DEFAULT_IMAGE_TYPE;
        public Integer click_type = MaterialMeta.DEFAULT_CLICK_TYPE;
        public Boolean has_companion_endcard = MaterialMeta.DEFAULT_HAS_COMPANION_ENDCARD;
        public Integer template_type = MaterialMeta.DEFAULT_TEMPLATE_TYPE;
        public Integer video_reciprocal_millisecond = MaterialMeta.DEFAULT_VIDEO_RECIPROCAL_MILLISECOND;
        public String html_url = "";
        public Boolean enable_collapse_tool_bar = MaterialMeta.DEFAULT_ENABLE_COLLAPSE_TOOL_BAR;
        public Integer open_market_mode = MaterialMeta.DEFAULT_OPEN_MARKET_MODE;
        public Integer play_mode = MaterialMeta.DEFAULT_PLAY_MODE;
        public Integer sub_interaction_type = MaterialMeta.DEFAULT_SUB_INTERACTION_TYPE;
        public String title = "";
        public String desc = "";
        public String icon_url = "";
        public Float score = MaterialMeta.DEFAULT_SCORE;
        public Integer template_id = MaterialMeta.DEFAULT_TEMPLATE_ID;
        public Boolean disable_auto_deeplink = MaterialMeta.DEFAULT_DISABLE_AUTO_DEEPLINK;
        public ByteString closecard_html_snippet = MaterialMeta.DEFAULT_CLOSECARD_HTML_SNIPPET;
        public String app_name = "";
        public String button_text = "";
        public Integer video_byte_size = MaterialMeta.DEFAULT_VIDEO_BYTE_SIZE;
        public String html_src = "";
        public Boolean download_dialog = MaterialMeta.DEFAULT_DOWNLOAD_DIALOG;
        public Integer theme_data = MaterialMeta.DEFAULT_THEME_DATA;
        public Boolean in_app = MaterialMeta.DEFAULT_IN_APP;
        public String endcard_image_src = "";
        public String creative_title = "";
        public Boolean has_endcard = MaterialMeta.DEFAULT_HAS_ENDCARD;
        public List<ResponseAsset> asset = Internal.newMutableList();
        public List<Widget> Widget_list = Internal.newMutableList();

        public Builder Widget_list(List<Widget> list) {
            Internal.checkElementsNotNull(list);
            this.Widget_list = list;
            return this;
        }

        public Builder ad_privacy(AdPrivacy adPrivacy) {
            this.ad_privacy = adPrivacy;
            return this;
        }

        public Builder android_market(AndroidMarket androidMarket) {
            this.android_market = androidMarket;
            return this;
        }

        public Builder apk_md5(String str) {
            this.apk_md5 = str;
            return this;
        }

        public Builder app_name(String str) {
            this.app_name = str;
            return this;
        }

        public Builder asset(List<ResponseAsset> list) {
            Internal.checkElementsNotNull(list);
            this.asset = list;
            return this;
        }

        public MaterialMeta build() {
            return new MaterialMeta(this.creative_type, this.interaction_type, this.landing_page, this.video_url, this.video_duration, this.video_size, this.html_snippet, this.endcard_url, this.video_md5, this.endcard_md5, this.deeplink_url, this.image_src, this.image_size, this.image_md5, this.image_type, this.click_type, this.has_companion_endcard, this.companion, this.web_event_handle, this.template_type, this.video_reciprocal_millisecond, this.html_url, this.enable_collapse_tool_bar, this.open_market_mode, this.play_mode, this.sub_interaction_type, this.title, this.desc, this.icon_url, this.score, this.template_id, this.disable_auto_deeplink, this.closecard_html_snippet, this.app_name, this.button_text, this.ad_privacy, this.video_byte_size, this.html_src, this.native_ad, this.download_dialog, this.android_market, this.main_template, this.sub_template, this.asset, this.theme_data, this.in_app, this.endcard_image_src, this.creative_title, this.has_endcard, this.button_color, this.Widget_list, this.apk_md5, super.buildUnknownFields());
        }

        public Builder button_color(Color color) {
            this.button_color = color;
            return this;
        }

        public Builder button_text(String str) {
            this.button_text = str;
            return this;
        }

        public Builder click_type(Integer num) {
            this.click_type = num;
            return this;
        }

        public Builder closecard_html_snippet(ByteString byteString) {
            this.closecard_html_snippet = byteString;
            return this;
        }

        public Builder companion(CompanionEndcard companionEndcard) {
            this.companion = companionEndcard;
            return this;
        }

        public Builder creative_title(String str) {
            this.creative_title = str;
            return this;
        }

        public Builder creative_type(Integer num) {
            this.creative_type = num;
            return this;
        }

        public Builder deeplink_url(String str) {
            this.deeplink_url = str;
            return this;
        }

        public Builder desc(String str) {
            this.desc = str;
            return this;
        }

        public Builder disable_auto_deeplink(Boolean bool) {
            this.disable_auto_deeplink = bool;
            return this;
        }

        public Builder download_dialog(Boolean bool) {
            this.download_dialog = bool;
            return this;
        }

        public Builder enable_collapse_tool_bar(Boolean bool) {
            this.enable_collapse_tool_bar = bool;
            return this;
        }

        public Builder endcard_image_src(String str) {
            this.endcard_image_src = str;
            return this;
        }

        public Builder endcard_md5(String str) {
            this.endcard_md5 = str;
            return this;
        }

        public Builder endcard_url(String str) {
            this.endcard_url = str;
            return this;
        }

        public Builder has_companion_endcard(Boolean bool) {
            this.has_companion_endcard = bool;
            return this;
        }

        public Builder has_endcard(Boolean bool) {
            this.has_endcard = bool;
            return this;
        }

        public Builder html_snippet(ByteString byteString) {
            this.html_snippet = byteString;
            return this;
        }

        public Builder html_src(String str) {
            this.html_src = str;
            return this;
        }

        public Builder html_url(String str) {
            this.html_url = str;
            return this;
        }

        public Builder icon_url(String str) {
            this.icon_url = str;
            return this;
        }

        public Builder image_md5(String str) {
            this.image_md5 = str;
            return this;
        }

        public Builder image_size(Size size) {
            this.image_size = size;
            return this;
        }

        public Builder image_src(String str) {
            this.image_src = str;
            return this;
        }

        public Builder image_type(Integer num) {
            this.image_type = num;
            return this;
        }

        public Builder in_app(Boolean bool) {
            this.in_app = bool;
            return this;
        }

        public Builder interaction_type(Integer num) {
            this.interaction_type = num;
            return this;
        }

        public Builder landing_page(String str) {
            this.landing_page = str;
            return this;
        }

        public Builder main_template(Template template) {
            this.main_template = template;
            return this;
        }

        public Builder native_ad(ResponseNativeAd responseNativeAd) {
            this.native_ad = responseNativeAd;
            return this;
        }

        public Builder open_market_mode(Integer num) {
            this.open_market_mode = num;
            return this;
        }

        public Builder play_mode(Integer num) {
            this.play_mode = num;
            return this;
        }

        public Builder score(Float f) {
            this.score = f;
            return this;
        }

        public Builder sub_interaction_type(Integer num) {
            this.sub_interaction_type = num;
            return this;
        }

        public Builder sub_template(Template template) {
            this.sub_template = template;
            return this;
        }

        public Builder template_id(Integer num) {
            this.template_id = num;
            return this;
        }

        public Builder template_type(Integer num) {
            this.template_type = num;
            return this;
        }

        public Builder theme_data(Integer num) {
            this.theme_data = num;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder video_byte_size(Integer num) {
            this.video_byte_size = num;
            return this;
        }

        public Builder video_duration(Integer num) {
            this.video_duration = num;
            return this;
        }

        public Builder video_md5(String str) {
            this.video_md5 = str;
            return this;
        }

        public Builder video_reciprocal_millisecond(Integer num) {
            this.video_reciprocal_millisecond = num;
            return this;
        }

        public Builder video_size(Size size) {
            this.video_size = size;
            return this;
        }

        public Builder video_url(String str) {
            this.video_url = str;
            return this;
        }

        public Builder web_event_handle(WebEventHandle webEventHandle) {
            this.web_event_handle = webEventHandle;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class ProtoAdapter_MaterialMeta extends ProtoAdapter<MaterialMeta> {
        public ProtoAdapter_MaterialMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, MaterialMeta.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public MaterialMeta m74decode(ProtoReader protoReader) {
            List list;
            AndroidMessage androidMessage;
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                switch (nextTag) {
                    case 1:
                        builder.creative_type((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        continue;
                    case 2:
                        builder.interaction_type((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        continue;
                    case 3:
                        builder.landing_page((String) ProtoAdapter.STRING.decode(protoReader));
                        continue;
                    case 4:
                        builder.video_url((String) ProtoAdapter.STRING.decode(protoReader));
                        continue;
                    case 5:
                        builder.video_duration((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        continue;
                    case 6:
                        builder.video_size((Size) Size.ADAPTER.decode(protoReader));
                        continue;
                    case 7:
                        builder.html_snippet((ByteString) ProtoAdapter.BYTES.decode(protoReader));
                        continue;
                    case 8:
                        builder.endcard_url((String) ProtoAdapter.STRING.decode(protoReader));
                        continue;
                    case 9:
                        builder.video_md5((String) ProtoAdapter.STRING.decode(protoReader));
                        continue;
                    case 10:
                        builder.endcard_md5((String) ProtoAdapter.STRING.decode(protoReader));
                        continue;
                    case 11:
                        builder.deeplink_url((String) ProtoAdapter.STRING.decode(protoReader));
                        continue;
                    case 12:
                        builder.image_src((String) ProtoAdapter.STRING.decode(protoReader));
                        continue;
                    case 13:
                        builder.image_size((Size) Size.ADAPTER.decode(protoReader));
                        continue;
                    case 14:
                        builder.image_md5((String) ProtoAdapter.STRING.decode(protoReader));
                        continue;
                    case 15:
                        builder.image_type((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        continue;
                    case 16:
                        builder.click_type((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        continue;
                    case 17:
                        builder.has_companion_endcard((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        continue;
                    case 18:
                        builder.companion((CompanionEndcard) CompanionEndcard.ADAPTER.decode(protoReader));
                        continue;
                    case 19:
                        builder.web_event_handle((WebEventHandle) WebEventHandle.ADAPTER.decode(protoReader));
                        continue;
                    case 20:
                        builder.template_type((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        continue;
                    case 21:
                        builder.video_reciprocal_millisecond((Integer) ProtoAdapter.INT32.decode(protoReader));
                        continue;
                    case 22:
                        builder.html_url((String) ProtoAdapter.STRING.decode(protoReader));
                        continue;
                    case 23:
                        builder.enable_collapse_tool_bar((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        continue;
                    case 24:
                        builder.open_market_mode((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        continue;
                    case 25:
                        builder.play_mode((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        continue;
                    case 26:
                        builder.sub_interaction_type((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        continue;
                    case 27:
                        builder.title((String) ProtoAdapter.STRING.decode(protoReader));
                        continue;
                    case 28:
                        builder.desc((String) ProtoAdapter.STRING.decode(protoReader));
                        continue;
                    case 29:
                        builder.icon_url((String) ProtoAdapter.STRING.decode(protoReader));
                        continue;
                    case 30:
                        builder.score((Float) ProtoAdapter.FLOAT.decode(protoReader));
                        continue;
                    case 31:
                        builder.template_id((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        continue;
                    case 32:
                        builder.disable_auto_deeplink((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        continue;
                    case 33:
                        builder.closecard_html_snippet((ByteString) ProtoAdapter.BYTES.decode(protoReader));
                        continue;
                    case 34:
                        builder.app_name((String) ProtoAdapter.STRING.decode(protoReader));
                        continue;
                    case 35:
                        builder.button_text((String) ProtoAdapter.STRING.decode(protoReader));
                        continue;
                    case 36:
                        builder.ad_privacy((AdPrivacy) AdPrivacy.ADAPTER.decode(protoReader));
                        continue;
                    case 37:
                        builder.video_byte_size((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        continue;
                    case 38:
                        builder.html_src((String) ProtoAdapter.STRING.decode(protoReader));
                        continue;
                    case 39:
                        builder.native_ad((ResponseNativeAd) ResponseNativeAd.ADAPTER.decode(protoReader));
                        continue;
                    case 40:
                        builder.download_dialog((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        continue;
                    case 41:
                        builder.android_market((AndroidMarket) AndroidMarket.ADAPTER.decode(protoReader));
                        continue;
                    case 42:
                        builder.main_template((Template) Template.ADAPTER.decode(protoReader));
                        continue;
                    case 43:
                        builder.sub_template((Template) Template.ADAPTER.decode(protoReader));
                        continue;
                    case 44:
                        list = builder.asset;
                        androidMessage = (ResponseAsset) ResponseAsset.ADAPTER.decode(protoReader);
                        break;
                    case 45:
                        builder.theme_data((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        continue;
                    case 46:
                        builder.in_app((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        continue;
                    case 47:
                        builder.endcard_image_src((String) ProtoAdapter.STRING.decode(protoReader));
                        continue;
                    case 48:
                        builder.creative_title((String) ProtoAdapter.STRING.decode(protoReader));
                        continue;
                    case 49:
                        builder.has_endcard((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        continue;
                    case 50:
                        builder.button_color((Color) Color.ADAPTER.decode(protoReader));
                        continue;
                    case 51:
                        list = builder.Widget_list;
                        androidMessage = (Widget) Widget.ADAPTER.decode(protoReader);
                        break;
                    case 52:
                        builder.apk_md5((String) ProtoAdapter.STRING.decode(protoReader));
                        continue;
                    default:
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        continue;
                }
                list.add(androidMessage);
            }
        }

        public void encode(ProtoWriter protoWriter, MaterialMeta materialMeta) {
            ProtoAdapter protoAdapter = ProtoAdapter.UINT32;
            protoAdapter.encodeWithTag(protoWriter, 1, materialMeta.creative_type);
            protoAdapter.encodeWithTag(protoWriter, 2, materialMeta.interaction_type);
            ProtoAdapter protoAdapter2 = ProtoAdapter.STRING;
            protoAdapter2.encodeWithTag(protoWriter, 3, materialMeta.landing_page);
            protoAdapter2.encodeWithTag(protoWriter, 4, materialMeta.video_url);
            protoAdapter.encodeWithTag(protoWriter, 5, materialMeta.video_duration);
            ProtoAdapter protoAdapter3 = Size.ADAPTER;
            protoAdapter3.encodeWithTag(protoWriter, 6, materialMeta.video_size);
            ProtoAdapter protoAdapter4 = ProtoAdapter.BYTES;
            protoAdapter4.encodeWithTag(protoWriter, 7, materialMeta.html_snippet);
            protoAdapter2.encodeWithTag(protoWriter, 8, materialMeta.endcard_url);
            protoAdapter2.encodeWithTag(protoWriter, 9, materialMeta.video_md5);
            protoAdapter2.encodeWithTag(protoWriter, 10, materialMeta.endcard_md5);
            protoAdapter2.encodeWithTag(protoWriter, 11, materialMeta.deeplink_url);
            protoAdapter2.encodeWithTag(protoWriter, 12, materialMeta.image_src);
            protoAdapter3.encodeWithTag(protoWriter, 13, materialMeta.image_size);
            protoAdapter2.encodeWithTag(protoWriter, 14, materialMeta.image_md5);
            protoAdapter.encodeWithTag(protoWriter, 15, materialMeta.image_type);
            protoAdapter.encodeWithTag(protoWriter, 16, materialMeta.click_type);
            ProtoAdapter protoAdapter5 = ProtoAdapter.BOOL;
            protoAdapter5.encodeWithTag(protoWriter, 17, materialMeta.has_companion_endcard);
            CompanionEndcard.ADAPTER.encodeWithTag(protoWriter, 18, materialMeta.companion);
            WebEventHandle.ADAPTER.encodeWithTag(protoWriter, 19, materialMeta.web_event_handle);
            protoAdapter.encodeWithTag(protoWriter, 20, materialMeta.template_type);
            ProtoAdapter.INT32.encodeWithTag(protoWriter, 21, materialMeta.video_reciprocal_millisecond);
            protoAdapter2.encodeWithTag(protoWriter, 22, materialMeta.html_url);
            protoAdapter5.encodeWithTag(protoWriter, 23, materialMeta.enable_collapse_tool_bar);
            protoAdapter.encodeWithTag(protoWriter, 24, materialMeta.open_market_mode);
            protoAdapter.encodeWithTag(protoWriter, 25, materialMeta.play_mode);
            protoAdapter.encodeWithTag(protoWriter, 26, materialMeta.sub_interaction_type);
            protoAdapter2.encodeWithTag(protoWriter, 27, materialMeta.title);
            protoAdapter2.encodeWithTag(protoWriter, 28, materialMeta.desc);
            protoAdapter2.encodeWithTag(protoWriter, 29, materialMeta.icon_url);
            ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 30, materialMeta.score);
            protoAdapter.encodeWithTag(protoWriter, 31, materialMeta.template_id);
            protoAdapter5.encodeWithTag(protoWriter, 32, materialMeta.disable_auto_deeplink);
            protoAdapter4.encodeWithTag(protoWriter, 33, materialMeta.closecard_html_snippet);
            protoAdapter2.encodeWithTag(protoWriter, 34, materialMeta.app_name);
            protoAdapter2.encodeWithTag(protoWriter, 35, materialMeta.button_text);
            AdPrivacy.ADAPTER.encodeWithTag(protoWriter, 36, materialMeta.ad_privacy);
            protoAdapter.encodeWithTag(protoWriter, 37, materialMeta.video_byte_size);
            protoAdapter2.encodeWithTag(protoWriter, 38, materialMeta.html_src);
            ResponseNativeAd.ADAPTER.encodeWithTag(protoWriter, 39, materialMeta.native_ad);
            protoAdapter5.encodeWithTag(protoWriter, 40, materialMeta.download_dialog);
            AndroidMarket.ADAPTER.encodeWithTag(protoWriter, 41, materialMeta.android_market);
            ProtoAdapter<Template> protoAdapter6 = Template.ADAPTER;
            protoAdapter6.encodeWithTag(protoWriter, 42, materialMeta.main_template);
            protoAdapter6.encodeWithTag(protoWriter, 43, materialMeta.sub_template);
            ResponseAsset.ADAPTER.asRepeated().encodeWithTag(protoWriter, 44, materialMeta.asset);
            protoAdapter.encodeWithTag(protoWriter, 45, materialMeta.theme_data);
            protoAdapter5.encodeWithTag(protoWriter, 46, materialMeta.in_app);
            protoAdapter2.encodeWithTag(protoWriter, 47, materialMeta.endcard_image_src);
            protoAdapter2.encodeWithTag(protoWriter, 48, materialMeta.creative_title);
            protoAdapter5.encodeWithTag(protoWriter, 49, materialMeta.has_endcard);
            Color.ADAPTER.encodeWithTag(protoWriter, 50, materialMeta.button_color);
            Widget.ADAPTER.asRepeated().encodeWithTag(protoWriter, 51, materialMeta.Widget_list);
            protoAdapter2.encodeWithTag(protoWriter, 52, materialMeta.apk_md5);
            protoWriter.writeBytes(materialMeta.unknownFields());
        }

        public int encodedSize(MaterialMeta materialMeta) {
            ProtoAdapter protoAdapter = ProtoAdapter.UINT32;
            int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(1, materialMeta.creative_type) + protoAdapter.encodedSizeWithTag(2, materialMeta.interaction_type);
            ProtoAdapter protoAdapter2 = ProtoAdapter.STRING;
            int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter2.encodedSizeWithTag(3, materialMeta.landing_page) + protoAdapter2.encodedSizeWithTag(4, materialMeta.video_url) + protoAdapter.encodedSizeWithTag(5, materialMeta.video_duration);
            ProtoAdapter protoAdapter3 = Size.ADAPTER;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + protoAdapter3.encodedSizeWithTag(6, materialMeta.video_size);
            ProtoAdapter protoAdapter4 = ProtoAdapter.BYTES;
            int encodedSizeWithTag4 = encodedSizeWithTag3 + protoAdapter4.encodedSizeWithTag(7, materialMeta.html_snippet) + protoAdapter2.encodedSizeWithTag(8, materialMeta.endcard_url) + protoAdapter2.encodedSizeWithTag(9, materialMeta.video_md5) + protoAdapter2.encodedSizeWithTag(10, materialMeta.endcard_md5) + protoAdapter2.encodedSizeWithTag(11, materialMeta.deeplink_url) + protoAdapter2.encodedSizeWithTag(12, materialMeta.image_src) + protoAdapter3.encodedSizeWithTag(13, materialMeta.image_size) + protoAdapter2.encodedSizeWithTag(14, materialMeta.image_md5) + protoAdapter.encodedSizeWithTag(15, materialMeta.image_type) + protoAdapter.encodedSizeWithTag(16, materialMeta.click_type);
            ProtoAdapter protoAdapter5 = ProtoAdapter.BOOL;
            int encodedSizeWithTag5 = encodedSizeWithTag4 + protoAdapter5.encodedSizeWithTag(17, materialMeta.has_companion_endcard) + CompanionEndcard.ADAPTER.encodedSizeWithTag(18, materialMeta.companion) + WebEventHandle.ADAPTER.encodedSizeWithTag(19, materialMeta.web_event_handle) + protoAdapter.encodedSizeWithTag(20, materialMeta.template_type) + ProtoAdapter.INT32.encodedSizeWithTag(21, materialMeta.video_reciprocal_millisecond) + protoAdapter2.encodedSizeWithTag(22, materialMeta.html_url) + protoAdapter5.encodedSizeWithTag(23, materialMeta.enable_collapse_tool_bar) + protoAdapter.encodedSizeWithTag(24, materialMeta.open_market_mode) + protoAdapter.encodedSizeWithTag(25, materialMeta.play_mode) + protoAdapter.encodedSizeWithTag(26, materialMeta.sub_interaction_type) + protoAdapter2.encodedSizeWithTag(27, materialMeta.title) + protoAdapter2.encodedSizeWithTag(28, materialMeta.desc) + protoAdapter2.encodedSizeWithTag(29, materialMeta.icon_url) + ProtoAdapter.FLOAT.encodedSizeWithTag(30, materialMeta.score) + protoAdapter.encodedSizeWithTag(31, materialMeta.template_id) + protoAdapter5.encodedSizeWithTag(32, materialMeta.disable_auto_deeplink) + protoAdapter4.encodedSizeWithTag(33, materialMeta.closecard_html_snippet) + protoAdapter2.encodedSizeWithTag(34, materialMeta.app_name) + protoAdapter2.encodedSizeWithTag(35, materialMeta.button_text) + AdPrivacy.ADAPTER.encodedSizeWithTag(36, materialMeta.ad_privacy) + protoAdapter.encodedSizeWithTag(37, materialMeta.video_byte_size) + protoAdapter2.encodedSizeWithTag(38, materialMeta.html_src) + ResponseNativeAd.ADAPTER.encodedSizeWithTag(39, materialMeta.native_ad) + protoAdapter5.encodedSizeWithTag(40, materialMeta.download_dialog) + AndroidMarket.ADAPTER.encodedSizeWithTag(41, materialMeta.android_market);
            ProtoAdapter<Template> protoAdapter6 = Template.ADAPTER;
            return encodedSizeWithTag5 + protoAdapter6.encodedSizeWithTag(42, materialMeta.main_template) + protoAdapter6.encodedSizeWithTag(43, materialMeta.sub_template) + ResponseAsset.ADAPTER.asRepeated().encodedSizeWithTag(44, materialMeta.asset) + protoAdapter.encodedSizeWithTag(45, materialMeta.theme_data) + protoAdapter5.encodedSizeWithTag(46, materialMeta.in_app) + protoAdapter2.encodedSizeWithTag(47, materialMeta.endcard_image_src) + protoAdapter2.encodedSizeWithTag(48, materialMeta.creative_title) + protoAdapter5.encodedSizeWithTag(49, materialMeta.has_endcard) + Color.ADAPTER.encodedSizeWithTag(50, materialMeta.button_color) + Widget.ADAPTER.asRepeated().encodedSizeWithTag(51, materialMeta.Widget_list) + protoAdapter2.encodedSizeWithTag(52, materialMeta.apk_md5) + materialMeta.unknownFields().size();
        }

        public MaterialMeta redact(MaterialMeta materialMeta) {
            Builder newBuilder = materialMeta.newBuilder();
            Size size = newBuilder.video_size;
            if (size != null) {
                newBuilder.video_size = (Size) Size.ADAPTER.redact(size);
            }
            Size size2 = newBuilder.image_size;
            if (size2 != null) {
                newBuilder.image_size = (Size) Size.ADAPTER.redact(size2);
            }
            CompanionEndcard companionEndcard = newBuilder.companion;
            if (companionEndcard != null) {
                newBuilder.companion = (CompanionEndcard) CompanionEndcard.ADAPTER.redact(companionEndcard);
            }
            WebEventHandle webEventHandle = newBuilder.web_event_handle;
            if (webEventHandle != null) {
                newBuilder.web_event_handle = (WebEventHandle) WebEventHandle.ADAPTER.redact(webEventHandle);
            }
            AdPrivacy adPrivacy = newBuilder.ad_privacy;
            if (adPrivacy != null) {
                newBuilder.ad_privacy = (AdPrivacy) AdPrivacy.ADAPTER.redact(adPrivacy);
            }
            ResponseNativeAd responseNativeAd = newBuilder.native_ad;
            if (responseNativeAd != null) {
                newBuilder.native_ad = (ResponseNativeAd) ResponseNativeAd.ADAPTER.redact(responseNativeAd);
            }
            AndroidMarket androidMarket = newBuilder.android_market;
            if (androidMarket != null) {
                newBuilder.android_market = (AndroidMarket) AndroidMarket.ADAPTER.redact(androidMarket);
            }
            Template template = newBuilder.main_template;
            if (template != null) {
                newBuilder.main_template = (Template) Template.ADAPTER.redact(template);
            }
            Template template2 = newBuilder.sub_template;
            if (template2 != null) {
                newBuilder.sub_template = (Template) Template.ADAPTER.redact(template2);
            }
            Internal.redactElements(newBuilder.asset, ResponseAsset.ADAPTER);
            Color color = newBuilder.button_color;
            if (color != null) {
                newBuilder.button_color = (Color) Color.ADAPTER.redact(color);
            }
            Internal.redactElements(newBuilder.Widget_list, Widget.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_MaterialMeta protoAdapter_MaterialMeta = new ProtoAdapter_MaterialMeta();
        ADAPTER = protoAdapter_MaterialMeta;
        CREATOR = AndroidMessage.newCreator(protoAdapter_MaterialMeta);
        DEFAULT_CREATIVE_TYPE = 0;
        DEFAULT_INTERACTION_TYPE = 0;
        DEFAULT_VIDEO_DURATION = 0;
        ByteString byteString = ByteString.EMPTY;
        DEFAULT_HTML_SNIPPET = byteString;
        DEFAULT_IMAGE_TYPE = 0;
        DEFAULT_CLICK_TYPE = 1;
        Boolean bool = Boolean.FALSE;
        DEFAULT_HAS_COMPANION_ENDCARD = bool;
        DEFAULT_TEMPLATE_TYPE = 0;
        DEFAULT_VIDEO_RECIPROCAL_MILLISECOND = 0;
        DEFAULT_ENABLE_COLLAPSE_TOOL_BAR = bool;
        DEFAULT_OPEN_MARKET_MODE = 0;
        DEFAULT_PLAY_MODE = 0;
        DEFAULT_SUB_INTERACTION_TYPE = 0;
        DEFAULT_SCORE = Float.valueOf(c.d);
        DEFAULT_TEMPLATE_ID = 0;
        DEFAULT_DISABLE_AUTO_DEEPLINK = bool;
        DEFAULT_CLOSECARD_HTML_SNIPPET = byteString;
        DEFAULT_VIDEO_BYTE_SIZE = 0;
        DEFAULT_DOWNLOAD_DIALOG = bool;
        DEFAULT_THEME_DATA = 0;
        DEFAULT_IN_APP = bool;
        DEFAULT_HAS_ENDCARD = bool;
    }

    public MaterialMeta(Integer num, Integer num2, String str, String str2, Integer num3, Size size, ByteString byteString, String str3, String str4, String str5, String str6, String str7, Size size2, String str8, Integer num4, Integer num5, Boolean bool, CompanionEndcard companionEndcard, WebEventHandle webEventHandle, Integer num6, Integer num7, String str9, Boolean bool2, Integer num8, Integer num9, Integer num10, String str10, String str11, String str12, Float f, Integer num11, Boolean bool3, ByteString byteString2, String str13, String str14, AdPrivacy adPrivacy, Integer num12, String str15, ResponseNativeAd responseNativeAd, Boolean bool4, AndroidMarket androidMarket, Template template, Template template2, List<ResponseAsset> list, Integer num13, Boolean bool5, String str16, String str17, Boolean bool6, Color color, List<Widget> list2, String str18) {
        this(num, num2, str, str2, num3, size, byteString, str3, str4, str5, str6, str7, size2, str8, num4, num5, bool, companionEndcard, webEventHandle, num6, num7, str9, bool2, num8, num9, num10, str10, str11, str12, f, num11, bool3, byteString2, str13, str14, adPrivacy, num12, str15, responseNativeAd, bool4, androidMarket, template, template2, list, num13, bool5, str16, str17, bool6, color, list2, str18, ByteString.EMPTY);
    }

    public MaterialMeta(Integer num, Integer num2, String str, String str2, Integer num3, Size size, ByteString byteString, String str3, String str4, String str5, String str6, String str7, Size size2, String str8, Integer num4, Integer num5, Boolean bool, CompanionEndcard companionEndcard, WebEventHandle webEventHandle, Integer num6, Integer num7, String str9, Boolean bool2, Integer num8, Integer num9, Integer num10, String str10, String str11, String str12, Float f, Integer num11, Boolean bool3, ByteString byteString2, String str13, String str14, AdPrivacy adPrivacy, Integer num12, String str15, ResponseNativeAd responseNativeAd, Boolean bool4, AndroidMarket androidMarket, Template template, Template template2, List<ResponseAsset> list, Integer num13, Boolean bool5, String str16, String str17, Boolean bool6, Color color, List<Widget> list2, String str18, ByteString byteString3) {
        super(ADAPTER, byteString3);
        this.creative_type = num;
        this.interaction_type = num2;
        this.landing_page = str;
        this.video_url = str2;
        this.video_duration = num3;
        this.video_size = size;
        this.html_snippet = byteString;
        this.endcard_url = str3;
        this.video_md5 = str4;
        this.endcard_md5 = str5;
        this.deeplink_url = str6;
        this.image_src = str7;
        this.image_size = size2;
        this.image_md5 = str8;
        this.image_type = num4;
        this.click_type = num5;
        this.has_companion_endcard = bool;
        this.companion = companionEndcard;
        this.web_event_handle = webEventHandle;
        this.template_type = num6;
        this.video_reciprocal_millisecond = num7;
        this.html_url = str9;
        this.enable_collapse_tool_bar = bool2;
        this.open_market_mode = num8;
        this.play_mode = num9;
        this.sub_interaction_type = num10;
        this.title = str10;
        this.desc = str11;
        this.icon_url = str12;
        this.score = f;
        this.template_id = num11;
        this.disable_auto_deeplink = bool3;
        this.closecard_html_snippet = byteString2;
        this.app_name = str13;
        this.button_text = str14;
        this.ad_privacy = adPrivacy;
        this.video_byte_size = num12;
        this.html_src = str15;
        this.native_ad = responseNativeAd;
        this.download_dialog = bool4;
        this.android_market = androidMarket;
        this.main_template = template;
        this.sub_template = template2;
        this.asset = Internal.immutableCopyOf("asset", list);
        this.theme_data = num13;
        this.in_app = bool5;
        this.endcard_image_src = str16;
        this.creative_title = str17;
        this.has_endcard = bool6;
        this.button_color = color;
        this.Widget_list = Internal.immutableCopyOf("Widget_list", list2);
        this.apk_md5 = str18;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MaterialMeta)) {
            return false;
        }
        MaterialMeta materialMeta = (MaterialMeta) obj;
        return unknownFields().equals(materialMeta.unknownFields()) && Internal.equals(this.creative_type, materialMeta.creative_type) && Internal.equals(this.interaction_type, materialMeta.interaction_type) && Internal.equals(this.landing_page, materialMeta.landing_page) && Internal.equals(this.video_url, materialMeta.video_url) && Internal.equals(this.video_duration, materialMeta.video_duration) && Internal.equals(this.video_size, materialMeta.video_size) && Internal.equals(this.html_snippet, materialMeta.html_snippet) && Internal.equals(this.endcard_url, materialMeta.endcard_url) && Internal.equals(this.video_md5, materialMeta.video_md5) && Internal.equals(this.endcard_md5, materialMeta.endcard_md5) && Internal.equals(this.deeplink_url, materialMeta.deeplink_url) && Internal.equals(this.image_src, materialMeta.image_src) && Internal.equals(this.image_size, materialMeta.image_size) && Internal.equals(this.image_md5, materialMeta.image_md5) && Internal.equals(this.image_type, materialMeta.image_type) && Internal.equals(this.click_type, materialMeta.click_type) && Internal.equals(this.has_companion_endcard, materialMeta.has_companion_endcard) && Internal.equals(this.companion, materialMeta.companion) && Internal.equals(this.web_event_handle, materialMeta.web_event_handle) && Internal.equals(this.template_type, materialMeta.template_type) && Internal.equals(this.video_reciprocal_millisecond, materialMeta.video_reciprocal_millisecond) && Internal.equals(this.html_url, materialMeta.html_url) && Internal.equals(this.enable_collapse_tool_bar, materialMeta.enable_collapse_tool_bar) && Internal.equals(this.open_market_mode, materialMeta.open_market_mode) && Internal.equals(this.play_mode, materialMeta.play_mode) && Internal.equals(this.sub_interaction_type, materialMeta.sub_interaction_type) && Internal.equals(this.title, materialMeta.title) && Internal.equals(this.desc, materialMeta.desc) && Internal.equals(this.icon_url, materialMeta.icon_url) && Internal.equals(this.score, materialMeta.score) && Internal.equals(this.template_id, materialMeta.template_id) && Internal.equals(this.disable_auto_deeplink, materialMeta.disable_auto_deeplink) && Internal.equals(this.closecard_html_snippet, materialMeta.closecard_html_snippet) && Internal.equals(this.app_name, materialMeta.app_name) && Internal.equals(this.button_text, materialMeta.button_text) && Internal.equals(this.ad_privacy, materialMeta.ad_privacy) && Internal.equals(this.video_byte_size, materialMeta.video_byte_size) && Internal.equals(this.html_src, materialMeta.html_src) && Internal.equals(this.native_ad, materialMeta.native_ad) && Internal.equals(this.download_dialog, materialMeta.download_dialog) && Internal.equals(this.android_market, materialMeta.android_market) && Internal.equals(this.main_template, materialMeta.main_template) && Internal.equals(this.sub_template, materialMeta.sub_template) && this.asset.equals(materialMeta.asset) && Internal.equals(this.theme_data, materialMeta.theme_data) && Internal.equals(this.in_app, materialMeta.in_app) && Internal.equals(this.endcard_image_src, materialMeta.endcard_image_src) && Internal.equals(this.creative_title, materialMeta.creative_title) && Internal.equals(this.has_endcard, materialMeta.has_endcard) && Internal.equals(this.button_color, materialMeta.button_color) && this.Widget_list.equals(materialMeta.Widget_list) && Internal.equals(this.apk_md5, materialMeta.apk_md5);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.creative_type;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.interaction_type;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.landing_page;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.video_url;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num3 = this.video_duration;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Size size = this.video_size;
        int hashCode7 = (hashCode6 + (size != null ? size.hashCode() : 0)) * 37;
        ByteString byteString = this.html_snippet;
        int hashCode8 = (hashCode7 + (byteString != null ? byteString.hashCode() : 0)) * 37;
        String str3 = this.endcard_url;
        int hashCode9 = (hashCode8 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.video_md5;
        int hashCode10 = (hashCode9 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.endcard_md5;
        int hashCode11 = (hashCode10 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.deeplink_url;
        int hashCode12 = (hashCode11 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.image_src;
        int hashCode13 = (hashCode12 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Size size2 = this.image_size;
        int hashCode14 = (hashCode13 + (size2 != null ? size2.hashCode() : 0)) * 37;
        String str8 = this.image_md5;
        int hashCode15 = (hashCode14 + (str8 != null ? str8.hashCode() : 0)) * 37;
        Integer num4 = this.image_type;
        int hashCode16 = (hashCode15 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.click_type;
        int hashCode17 = (hashCode16 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Boolean bool = this.has_companion_endcard;
        int hashCode18 = (hashCode17 + (bool != null ? bool.hashCode() : 0)) * 37;
        CompanionEndcard companionEndcard = this.companion;
        int hashCode19 = (hashCode18 + (companionEndcard != null ? companionEndcard.hashCode() : 0)) * 37;
        WebEventHandle webEventHandle = this.web_event_handle;
        int hashCode20 = (hashCode19 + (webEventHandle != null ? webEventHandle.hashCode() : 0)) * 37;
        Integer num6 = this.template_type;
        int hashCode21 = (hashCode20 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.video_reciprocal_millisecond;
        int hashCode22 = (hashCode21 + (num7 != null ? num7.hashCode() : 0)) * 37;
        String str9 = this.html_url;
        int hashCode23 = (hashCode22 + (str9 != null ? str9.hashCode() : 0)) * 37;
        Boolean bool2 = this.enable_collapse_tool_bar;
        int hashCode24 = (hashCode23 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num8 = this.open_market_mode;
        int hashCode25 = (hashCode24 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.play_mode;
        int hashCode26 = (hashCode25 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.sub_interaction_type;
        int hashCode27 = (hashCode26 + (num10 != null ? num10.hashCode() : 0)) * 37;
        String str10 = this.title;
        int hashCode28 = (hashCode27 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.desc;
        int hashCode29 = (hashCode28 + (str11 != null ? str11.hashCode() : 0)) * 37;
        String str12 = this.icon_url;
        int hashCode30 = (hashCode29 + (str12 != null ? str12.hashCode() : 0)) * 37;
        Float f = this.score;
        int hashCode31 = (hashCode30 + (f != null ? f.hashCode() : 0)) * 37;
        Integer num11 = this.template_id;
        int hashCode32 = (hashCode31 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Boolean bool3 = this.disable_auto_deeplink;
        int hashCode33 = (hashCode32 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        ByteString byteString2 = this.closecard_html_snippet;
        int hashCode34 = (hashCode33 + (byteString2 != null ? byteString2.hashCode() : 0)) * 37;
        String str13 = this.app_name;
        int hashCode35 = (hashCode34 + (str13 != null ? str13.hashCode() : 0)) * 37;
        String str14 = this.button_text;
        int hashCode36 = (hashCode35 + (str14 != null ? str14.hashCode() : 0)) * 37;
        AdPrivacy adPrivacy = this.ad_privacy;
        int hashCode37 = (hashCode36 + (adPrivacy != null ? adPrivacy.hashCode() : 0)) * 37;
        Integer num12 = this.video_byte_size;
        int hashCode38 = (hashCode37 + (num12 != null ? num12.hashCode() : 0)) * 37;
        String str15 = this.html_src;
        int hashCode39 = (hashCode38 + (str15 != null ? str15.hashCode() : 0)) * 37;
        ResponseNativeAd responseNativeAd = this.native_ad;
        int hashCode40 = (hashCode39 + (responseNativeAd != null ? responseNativeAd.hashCode() : 0)) * 37;
        Boolean bool4 = this.download_dialog;
        int hashCode41 = (hashCode40 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        AndroidMarket androidMarket = this.android_market;
        int hashCode42 = (hashCode41 + (androidMarket != null ? androidMarket.hashCode() : 0)) * 37;
        Template template = this.main_template;
        int hashCode43 = (hashCode42 + (template != null ? template.hashCode() : 0)) * 37;
        Template template2 = this.sub_template;
        int hashCode44 = (((hashCode43 + (template2 != null ? template2.hashCode() : 0)) * 37) + this.asset.hashCode()) * 37;
        Integer num13 = this.theme_data;
        int hashCode45 = (hashCode44 + (num13 != null ? num13.hashCode() : 0)) * 37;
        Boolean bool5 = this.in_app;
        int hashCode46 = (hashCode45 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
        String str16 = this.endcard_image_src;
        int hashCode47 = (hashCode46 + (str16 != null ? str16.hashCode() : 0)) * 37;
        String str17 = this.creative_title;
        int hashCode48 = (hashCode47 + (str17 != null ? str17.hashCode() : 0)) * 37;
        Boolean bool6 = this.has_endcard;
        int hashCode49 = (hashCode48 + (bool6 != null ? bool6.hashCode() : 0)) * 37;
        Color color = this.button_color;
        int hashCode50 = (((hashCode49 + (color != null ? color.hashCode() : 0)) * 37) + this.Widget_list.hashCode()) * 37;
        String str18 = this.apk_md5;
        int hashCode51 = hashCode50 + (str18 != null ? str18.hashCode() : 0);
        ((Message) this).hashCode = hashCode51;
        return hashCode51;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.creative_type = this.creative_type;
        builder.interaction_type = this.interaction_type;
        builder.landing_page = this.landing_page;
        builder.video_url = this.video_url;
        builder.video_duration = this.video_duration;
        builder.video_size = this.video_size;
        builder.html_snippet = this.html_snippet;
        builder.endcard_url = this.endcard_url;
        builder.video_md5 = this.video_md5;
        builder.endcard_md5 = this.endcard_md5;
        builder.deeplink_url = this.deeplink_url;
        builder.image_src = this.image_src;
        builder.image_size = this.image_size;
        builder.image_md5 = this.image_md5;
        builder.image_type = this.image_type;
        builder.click_type = this.click_type;
        builder.has_companion_endcard = this.has_companion_endcard;
        builder.companion = this.companion;
        builder.web_event_handle = this.web_event_handle;
        builder.template_type = this.template_type;
        builder.video_reciprocal_millisecond = this.video_reciprocal_millisecond;
        builder.html_url = this.html_url;
        builder.enable_collapse_tool_bar = this.enable_collapse_tool_bar;
        builder.open_market_mode = this.open_market_mode;
        builder.play_mode = this.play_mode;
        builder.sub_interaction_type = this.sub_interaction_type;
        builder.title = this.title;
        builder.desc = this.desc;
        builder.icon_url = this.icon_url;
        builder.score = this.score;
        builder.template_id = this.template_id;
        builder.disable_auto_deeplink = this.disable_auto_deeplink;
        builder.closecard_html_snippet = this.closecard_html_snippet;
        builder.app_name = this.app_name;
        builder.button_text = this.button_text;
        builder.ad_privacy = this.ad_privacy;
        builder.video_byte_size = this.video_byte_size;
        builder.html_src = this.html_src;
        builder.native_ad = this.native_ad;
        builder.download_dialog = this.download_dialog;
        builder.android_market = this.android_market;
        builder.main_template = this.main_template;
        builder.sub_template = this.sub_template;
        builder.asset = Internal.copyOf("asset", this.asset);
        builder.theme_data = this.theme_data;
        builder.in_app = this.in_app;
        builder.endcard_image_src = this.endcard_image_src;
        builder.creative_title = this.creative_title;
        builder.has_endcard = this.has_endcard;
        builder.button_color = this.button_color;
        builder.Widget_list = Internal.copyOf("Widget_list", this.Widget_list);
        builder.apk_md5 = this.apk_md5;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.creative_type != null) {
            sb.append(", creative_type=");
            sb.append(this.creative_type);
        }
        if (this.interaction_type != null) {
            sb.append(", interaction_type=");
            sb.append(this.interaction_type);
        }
        if (this.landing_page != null) {
            sb.append(", landing_page=");
            sb.append(this.landing_page);
        }
        if (this.video_url != null) {
            sb.append(", video_url=");
            sb.append(this.video_url);
        }
        if (this.video_duration != null) {
            sb.append(", video_duration=");
            sb.append(this.video_duration);
        }
        if (this.video_size != null) {
            sb.append(", video_size=");
            sb.append(this.video_size);
        }
        if (this.html_snippet != null) {
            sb.append(", html_snippet=");
            sb.append(this.html_snippet);
        }
        if (this.endcard_url != null) {
            sb.append(", endcard_url=");
            sb.append(this.endcard_url);
        }
        if (this.video_md5 != null) {
            sb.append(", video_md5=");
            sb.append(this.video_md5);
        }
        if (this.endcard_md5 != null) {
            sb.append(", endcard_md5=");
            sb.append(this.endcard_md5);
        }
        if (this.deeplink_url != null) {
            sb.append(", deeplink_url=");
            sb.append(this.deeplink_url);
        }
        if (this.image_src != null) {
            sb.append(", image_src=");
            sb.append(this.image_src);
        }
        if (this.image_size != null) {
            sb.append(", image_size=");
            sb.append(this.image_size);
        }
        if (this.image_md5 != null) {
            sb.append(", image_md5=");
            sb.append(this.image_md5);
        }
        if (this.image_type != null) {
            sb.append(", image_type=");
            sb.append(this.image_type);
        }
        if (this.click_type != null) {
            sb.append(", click_type=");
            sb.append(this.click_type);
        }
        if (this.has_companion_endcard != null) {
            sb.append(", has_companion_endcard=");
            sb.append(this.has_companion_endcard);
        }
        if (this.companion != null) {
            sb.append(", companion=");
            sb.append(this.companion);
        }
        if (this.web_event_handle != null) {
            sb.append(", web_event_handle=");
            sb.append(this.web_event_handle);
        }
        if (this.template_type != null) {
            sb.append(", template_type=");
            sb.append(this.template_type);
        }
        if (this.video_reciprocal_millisecond != null) {
            sb.append(", video_reciprocal_millisecond=");
            sb.append(this.video_reciprocal_millisecond);
        }
        if (this.html_url != null) {
            sb.append(", html_url=");
            sb.append(this.html_url);
        }
        if (this.enable_collapse_tool_bar != null) {
            sb.append(", enable_collapse_tool_bar=");
            sb.append(this.enable_collapse_tool_bar);
        }
        if (this.open_market_mode != null) {
            sb.append(", open_market_mode=");
            sb.append(this.open_market_mode);
        }
        if (this.play_mode != null) {
            sb.append(", play_mode=");
            sb.append(this.play_mode);
        }
        if (this.sub_interaction_type != null) {
            sb.append(", sub_interaction_type=");
            sb.append(this.sub_interaction_type);
        }
        if (this.title != null) {
            sb.append(", title=");
            sb.append(this.title);
        }
        if (this.desc != null) {
            sb.append(", desc=");
            sb.append(this.desc);
        }
        if (this.icon_url != null) {
            sb.append(", icon_url=");
            sb.append(this.icon_url);
        }
        if (this.score != null) {
            sb.append(", score=");
            sb.append(this.score);
        }
        if (this.template_id != null) {
            sb.append(", template_id=");
            sb.append(this.template_id);
        }
        if (this.disable_auto_deeplink != null) {
            sb.append(", disable_auto_deeplink=");
            sb.append(this.disable_auto_deeplink);
        }
        if (this.closecard_html_snippet != null) {
            sb.append(", closecard_html_snippet=");
            sb.append(this.closecard_html_snippet);
        }
        if (this.app_name != null) {
            sb.append(", app_name=");
            sb.append(this.app_name);
        }
        if (this.button_text != null) {
            sb.append(", button_text=");
            sb.append(this.button_text);
        }
        if (this.ad_privacy != null) {
            sb.append(", ad_privacy=");
            sb.append(this.ad_privacy);
        }
        if (this.video_byte_size != null) {
            sb.append(", video_byte_size=");
            sb.append(this.video_byte_size);
        }
        if (this.html_src != null) {
            sb.append(", html_src=");
            sb.append(this.html_src);
        }
        if (this.native_ad != null) {
            sb.append(", native_ad=");
            sb.append(this.native_ad);
        }
        if (this.download_dialog != null) {
            sb.append(", download_dialog=");
            sb.append(this.download_dialog);
        }
        if (this.android_market != null) {
            sb.append(", android_market=");
            sb.append(this.android_market);
        }
        if (this.main_template != null) {
            sb.append(", main_template=");
            sb.append(this.main_template);
        }
        if (this.sub_template != null) {
            sb.append(", sub_template=");
            sb.append(this.sub_template);
        }
        if (!this.asset.isEmpty()) {
            sb.append(", asset=");
            sb.append(this.asset);
        }
        if (this.theme_data != null) {
            sb.append(", theme_data=");
            sb.append(this.theme_data);
        }
        if (this.in_app != null) {
            sb.append(", in_app=");
            sb.append(this.in_app);
        }
        if (this.endcard_image_src != null) {
            sb.append(", endcard_image_src=");
            sb.append(this.endcard_image_src);
        }
        if (this.creative_title != null) {
            sb.append(", creative_title=");
            sb.append(this.creative_title);
        }
        if (this.has_endcard != null) {
            sb.append(", has_endcard=");
            sb.append(this.has_endcard);
        }
        if (this.button_color != null) {
            sb.append(", button_color=");
            sb.append(this.button_color);
        }
        if (!this.Widget_list.isEmpty()) {
            sb.append(", Widget_list=");
            sb.append(this.Widget_list);
        }
        if (this.apk_md5 != null) {
            sb.append(", apk_md5=");
            sb.append(this.apk_md5);
        }
        StringBuilder replace = sb.replace(0, 2, "MaterialMeta{");
        replace.append('}');
        return replace.toString();
    }
}
