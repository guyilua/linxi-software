package com.sigmob.sdk.base.models.rtb;

import android.os.Parcelable;
import com.czhj.wire.AndroidMessage;
import com.czhj.wire.FieldEncoding;
import com.czhj.wire.Message;
import com.czhj.wire.ProtoAdapter;
import com.czhj.wire.ProtoReader;
import com.czhj.wire.ProtoWriter;
import com.czhj.wire.WireField;
import com.czhj.wire.internal.Internal;
import com.czhj.wire.okio.ByteString;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class AdSetting extends AndroidMessage<AdSetting, Builder> {
    public static final ProtoAdapter<AdSetting> ADAPTER;
    public static final Parcelable.Creator<AdSetting> CREATOR;
    public static final Boolean DEFAULT_DISABLE_DOWNLOAD_LISTENER;
    public static final Boolean DEFAULT_IN_APP;
    public static final Integer DEFAULT_RETRY_COUNT;
    public static final Integer DEFAULT_SENSITIVITY;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 7)
    public final Boolean disable_download_listener;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 5)
    public final Boolean in_app;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer retry_count;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.RvAdSetting#ADAPTER", tag = 1)
    public final RvAdSetting rv_setting;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 8)
    public final List<String> scheme_white_list;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 9)
    public final Integer sensitivity;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.SingleNativeAdSetting#ADAPTER", tag = 4)
    public final SingleNativeAdSetting single_native_setting;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.SplashAdSetting#ADAPTER", tag = 2)
    public final SplashAdSetting splash_setting;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class Builder extends Message.Builder<AdSetting, Builder> {
        public RvAdSetting rv_setting;
        public SingleNativeAdSetting single_native_setting;
        public SplashAdSetting splash_setting;
        public Integer retry_count = AdSetting.DEFAULT_RETRY_COUNT;
        public Boolean in_app = AdSetting.DEFAULT_IN_APP;
        public Boolean disable_download_listener = AdSetting.DEFAULT_DISABLE_DOWNLOAD_LISTENER;
        public Integer sensitivity = AdSetting.DEFAULT_SENSITIVITY;
        public List<String> scheme_white_list = Internal.newMutableList();

        public AdSetting build() {
            return new AdSetting(this.rv_setting, this.splash_setting, this.retry_count, this.single_native_setting, this.in_app, this.disable_download_listener, this.scheme_white_list, this.sensitivity, super.buildUnknownFields());
        }

        public Builder disable_download_listener(Boolean bool) {
            this.disable_download_listener = bool;
            return this;
        }

        public Builder in_app(Boolean bool) {
            this.in_app = bool;
            return this;
        }

        public Builder retry_count(Integer num) {
            this.retry_count = num;
            return this;
        }

        public Builder rv_setting(RvAdSetting rvAdSetting) {
            this.rv_setting = rvAdSetting;
            return this;
        }

        public Builder scheme_white_list(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.scheme_white_list = list;
            return this;
        }

        public Builder sensitivity(Integer num) {
            this.sensitivity = num;
            return this;
        }

        public Builder single_native_setting(SingleNativeAdSetting singleNativeAdSetting) {
            this.single_native_setting = singleNativeAdSetting;
            return this;
        }

        public Builder splash_setting(SplashAdSetting splashAdSetting) {
            this.splash_setting = splashAdSetting;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class ProtoAdapter_AdSetting extends ProtoAdapter<AdSetting> {
        public ProtoAdapter_AdSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, AdSetting.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public AdSetting m50decode(ProtoReader protoReader) {
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
                        builder.rv_setting((RvAdSetting) RvAdSetting.ADAPTER.decode(protoReader));
                        break;
                    case 2:
                        builder.splash_setting((SplashAdSetting) SplashAdSetting.ADAPTER.decode(protoReader));
                        break;
                    case 3:
                        builder.retry_count((Integer) ProtoAdapter.INT32.decode(protoReader));
                        break;
                    case 4:
                        builder.single_native_setting((SingleNativeAdSetting) SingleNativeAdSetting.ADAPTER.decode(protoReader));
                        break;
                    case 5:
                        builder.in_app((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 6:
                    default:
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        break;
                    case 7:
                        builder.disable_download_listener((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 8:
                        builder.scheme_white_list.add((String) ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 9:
                        builder.sensitivity((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                }
            }
        }

        public void encode(ProtoWriter protoWriter, AdSetting adSetting) {
            RvAdSetting.ADAPTER.encodeWithTag(protoWriter, 1, adSetting.rv_setting);
            SplashAdSetting.ADAPTER.encodeWithTag(protoWriter, 2, adSetting.splash_setting);
            ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, adSetting.retry_count);
            SingleNativeAdSetting.ADAPTER.encodeWithTag(protoWriter, 4, adSetting.single_native_setting);
            ProtoAdapter protoAdapter = ProtoAdapter.BOOL;
            protoAdapter.encodeWithTag(protoWriter, 5, adSetting.in_app);
            protoAdapter.encodeWithTag(protoWriter, 7, adSetting.disable_download_listener);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 8, adSetting.scheme_white_list);
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 9, adSetting.sensitivity);
            protoWriter.writeBytes(adSetting.unknownFields());
        }

        public int encodedSize(AdSetting adSetting) {
            int encodedSizeWithTag = RvAdSetting.ADAPTER.encodedSizeWithTag(1, adSetting.rv_setting) + SplashAdSetting.ADAPTER.encodedSizeWithTag(2, adSetting.splash_setting) + ProtoAdapter.INT32.encodedSizeWithTag(3, adSetting.retry_count) + SingleNativeAdSetting.ADAPTER.encodedSizeWithTag(4, adSetting.single_native_setting);
            ProtoAdapter protoAdapter = ProtoAdapter.BOOL;
            return encodedSizeWithTag + protoAdapter.encodedSizeWithTag(5, adSetting.in_app) + protoAdapter.encodedSizeWithTag(7, adSetting.disable_download_listener) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(8, adSetting.scheme_white_list) + ProtoAdapter.UINT32.encodedSizeWithTag(9, adSetting.sensitivity) + adSetting.unknownFields().size();
        }

        public AdSetting redact(AdSetting adSetting) {
            Builder newBuilder = adSetting.newBuilder();
            RvAdSetting rvAdSetting = newBuilder.rv_setting;
            if (rvAdSetting != null) {
                newBuilder.rv_setting = (RvAdSetting) RvAdSetting.ADAPTER.redact(rvAdSetting);
            }
            SplashAdSetting splashAdSetting = newBuilder.splash_setting;
            if (splashAdSetting != null) {
                newBuilder.splash_setting = (SplashAdSetting) SplashAdSetting.ADAPTER.redact(splashAdSetting);
            }
            SingleNativeAdSetting singleNativeAdSetting = newBuilder.single_native_setting;
            if (singleNativeAdSetting != null) {
                newBuilder.single_native_setting = (SingleNativeAdSetting) SingleNativeAdSetting.ADAPTER.redact(singleNativeAdSetting);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_AdSetting protoAdapter_AdSetting = new ProtoAdapter_AdSetting();
        ADAPTER = protoAdapter_AdSetting;
        CREATOR = AndroidMessage.newCreator(protoAdapter_AdSetting);
        DEFAULT_RETRY_COUNT = 0;
        Boolean bool = Boolean.FALSE;
        DEFAULT_IN_APP = bool;
        DEFAULT_DISABLE_DOWNLOAD_LISTENER = bool;
        DEFAULT_SENSITIVITY = 0;
    }

    public AdSetting(RvAdSetting rvAdSetting, SplashAdSetting splashAdSetting, Integer num, SingleNativeAdSetting singleNativeAdSetting, Boolean bool, Boolean bool2, List<String> list, Integer num2) {
        this(rvAdSetting, splashAdSetting, num, singleNativeAdSetting, bool, bool2, list, num2, ByteString.EMPTY);
    }

    public AdSetting(RvAdSetting rvAdSetting, SplashAdSetting splashAdSetting, Integer num, SingleNativeAdSetting singleNativeAdSetting, Boolean bool, Boolean bool2, List<String> list, Integer num2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.rv_setting = rvAdSetting;
        this.splash_setting = splashAdSetting;
        this.retry_count = num;
        this.single_native_setting = singleNativeAdSetting;
        this.in_app = bool;
        this.disable_download_listener = bool2;
        this.scheme_white_list = Internal.immutableCopyOf("scheme_white_list", list);
        this.sensitivity = num2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSetting)) {
            return false;
        }
        AdSetting adSetting = (AdSetting) obj;
        return unknownFields().equals(adSetting.unknownFields()) && Internal.equals(this.rv_setting, adSetting.rv_setting) && Internal.equals(this.splash_setting, adSetting.splash_setting) && Internal.equals(this.retry_count, adSetting.retry_count) && Internal.equals(this.single_native_setting, adSetting.single_native_setting) && Internal.equals(this.in_app, adSetting.in_app) && Internal.equals(this.disable_download_listener, adSetting.disable_download_listener) && this.scheme_white_list.equals(adSetting.scheme_white_list) && Internal.equals(this.sensitivity, adSetting.sensitivity);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        RvAdSetting rvAdSetting = this.rv_setting;
        int hashCode2 = (hashCode + (rvAdSetting != null ? rvAdSetting.hashCode() : 0)) * 37;
        SplashAdSetting splashAdSetting = this.splash_setting;
        int hashCode3 = (hashCode2 + (splashAdSetting != null ? splashAdSetting.hashCode() : 0)) * 37;
        Integer num = this.retry_count;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        SingleNativeAdSetting singleNativeAdSetting = this.single_native_setting;
        int hashCode5 = (hashCode4 + (singleNativeAdSetting != null ? singleNativeAdSetting.hashCode() : 0)) * 37;
        Boolean bool = this.in_app;
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.disable_download_listener;
        int hashCode7 = (((hashCode6 + (bool2 != null ? bool2.hashCode() : 0)) * 37) + this.scheme_white_list.hashCode()) * 37;
        Integer num2 = this.sensitivity;
        int hashCode8 = hashCode7 + (num2 != null ? num2.hashCode() : 0);
        ((Message) this).hashCode = hashCode8;
        return hashCode8;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.rv_setting = this.rv_setting;
        builder.splash_setting = this.splash_setting;
        builder.retry_count = this.retry_count;
        builder.single_native_setting = this.single_native_setting;
        builder.in_app = this.in_app;
        builder.disable_download_listener = this.disable_download_listener;
        builder.scheme_white_list = Internal.copyOf("scheme_white_list", this.scheme_white_list);
        builder.sensitivity = this.sensitivity;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.rv_setting != null) {
            sb.append(", rv_setting=");
            sb.append(this.rv_setting);
        }
        if (this.splash_setting != null) {
            sb.append(", splash_setting=");
            sb.append(this.splash_setting);
        }
        if (this.retry_count != null) {
            sb.append(", retry_count=");
            sb.append(this.retry_count);
        }
        if (this.single_native_setting != null) {
            sb.append(", single_native_setting=");
            sb.append(this.single_native_setting);
        }
        if (this.in_app != null) {
            sb.append(", in_app=");
            sb.append(this.in_app);
        }
        if (this.disable_download_listener != null) {
            sb.append(", disable_download_listener=");
            sb.append(this.disable_download_listener);
        }
        if (!this.scheme_white_list.isEmpty()) {
            sb.append(", scheme_white_list=");
            sb.append(this.scheme_white_list);
        }
        if (this.sensitivity != null) {
            sb.append(", sensitivity=");
            sb.append(this.sensitivity);
        }
        StringBuilder replace = sb.replace(0, 2, "AdSetting{");
        replace.append('}');
        return replace.toString();
    }
}
