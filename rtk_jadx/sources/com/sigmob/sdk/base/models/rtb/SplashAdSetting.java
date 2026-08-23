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

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class SplashAdSetting extends AndroidMessage<SplashAdSetting, Builder> {
    public static final ProtoAdapter<SplashAdSetting> ADAPTER;
    public static final Parcelable.Creator<SplashAdSetting> CREATOR;
    public static final Boolean DEFAULT_ENABLE_CLOSE_ON_CLICK;
    public static final Boolean DEFAULT_ENABLE_FULL_CLICK;
    public static final Boolean DEFAULT_INVISIBLE_AD_LABEL;
    public static final Integer DEFAULT_SHOW_DURATION;
    public static final Boolean DEFAULT_USE_FLOATING_BTN;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 2)
    public final Boolean enable_close_on_click;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 5)
    public final Boolean enable_full_click;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 6)
    public final Boolean invisible_ad_label;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer show_duration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 7)
    public final Boolean use_floating_btn;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class Builder extends Message.Builder<SplashAdSetting, Builder> {
        public Integer show_duration = SplashAdSetting.DEFAULT_SHOW_DURATION;
        public Boolean enable_close_on_click = SplashAdSetting.DEFAULT_ENABLE_CLOSE_ON_CLICK;
        public Boolean enable_full_click = SplashAdSetting.DEFAULT_ENABLE_FULL_CLICK;
        public Boolean invisible_ad_label = SplashAdSetting.DEFAULT_INVISIBLE_AD_LABEL;
        public Boolean use_floating_btn = SplashAdSetting.DEFAULT_USE_FLOATING_BTN;

        public SplashAdSetting build() {
            return new SplashAdSetting(this.show_duration, this.enable_close_on_click, this.enable_full_click, this.invisible_ad_label, this.use_floating_btn, super.buildUnknownFields());
        }

        public Builder enable_close_on_click(Boolean bool) {
            this.enable_close_on_click = bool;
            return this;
        }

        public Builder enable_full_click(Boolean bool) {
            this.enable_full_click = bool;
            return this;
        }

        public Builder invisible_ad_label(Boolean bool) {
            this.invisible_ad_label = bool;
            return this;
        }

        public Builder show_duration(Integer num) {
            this.show_duration = num;
            return this;
        }

        public Builder use_floating_btn(Boolean bool) {
            this.use_floating_btn = bool;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class ProtoAdapter_SplashAdSetting extends ProtoAdapter<SplashAdSetting> {
        public ProtoAdapter_SplashAdSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, SplashAdSetting.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public SplashAdSetting m104decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.show_duration((Integer) ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.enable_close_on_click((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag == 5) {
                    builder.enable_full_click((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag == 6) {
                    builder.invisible_ad_label((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag != 7) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.use_floating_btn((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, SplashAdSetting splashAdSetting) {
            ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, splashAdSetting.show_duration);
            ProtoAdapter protoAdapter = ProtoAdapter.BOOL;
            protoAdapter.encodeWithTag(protoWriter, 2, splashAdSetting.enable_close_on_click);
            protoAdapter.encodeWithTag(protoWriter, 5, splashAdSetting.enable_full_click);
            protoAdapter.encodeWithTag(protoWriter, 6, splashAdSetting.invisible_ad_label);
            protoAdapter.encodeWithTag(protoWriter, 7, splashAdSetting.use_floating_btn);
            protoWriter.writeBytes(splashAdSetting.unknownFields());
        }

        public int encodedSize(SplashAdSetting splashAdSetting) {
            int encodedSizeWithTag = ProtoAdapter.INT32.encodedSizeWithTag(1, splashAdSetting.show_duration);
            ProtoAdapter protoAdapter = ProtoAdapter.BOOL;
            return encodedSizeWithTag + protoAdapter.encodedSizeWithTag(2, splashAdSetting.enable_close_on_click) + protoAdapter.encodedSizeWithTag(5, splashAdSetting.enable_full_click) + protoAdapter.encodedSizeWithTag(6, splashAdSetting.invisible_ad_label) + protoAdapter.encodedSizeWithTag(7, splashAdSetting.use_floating_btn) + splashAdSetting.unknownFields().size();
        }

        public SplashAdSetting redact(SplashAdSetting splashAdSetting) {
            Builder newBuilder = splashAdSetting.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_SplashAdSetting protoAdapter_SplashAdSetting = new ProtoAdapter_SplashAdSetting();
        ADAPTER = protoAdapter_SplashAdSetting;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SplashAdSetting);
        DEFAULT_SHOW_DURATION = 0;
        Boolean bool = Boolean.FALSE;
        DEFAULT_ENABLE_CLOSE_ON_CLICK = bool;
        DEFAULT_ENABLE_FULL_CLICK = bool;
        DEFAULT_INVISIBLE_AD_LABEL = bool;
        DEFAULT_USE_FLOATING_BTN = bool;
    }

    public SplashAdSetting(Integer num, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        this(num, bool, bool2, bool3, bool4, ByteString.EMPTY);
    }

    public SplashAdSetting(Integer num, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, ByteString byteString) {
        super(ADAPTER, byteString);
        this.show_duration = num;
        this.enable_close_on_click = bool;
        this.enable_full_click = bool2;
        this.invisible_ad_label = bool3;
        this.use_floating_btn = bool4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SplashAdSetting)) {
            return false;
        }
        SplashAdSetting splashAdSetting = (SplashAdSetting) obj;
        return unknownFields().equals(splashAdSetting.unknownFields()) && Internal.equals(this.show_duration, splashAdSetting.show_duration) && Internal.equals(this.enable_close_on_click, splashAdSetting.enable_close_on_click) && Internal.equals(this.enable_full_click, splashAdSetting.enable_full_click) && Internal.equals(this.invisible_ad_label, splashAdSetting.invisible_ad_label) && Internal.equals(this.use_floating_btn, splashAdSetting.use_floating_btn);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.show_duration;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool = this.enable_close_on_click;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.enable_full_click;
        int hashCode4 = (hashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.invisible_ad_label;
        int hashCode5 = (hashCode4 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.use_floating_btn;
        int hashCode6 = hashCode5 + (bool4 != null ? bool4.hashCode() : 0);
        ((Message) this).hashCode = hashCode6;
        return hashCode6;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.show_duration = this.show_duration;
        builder.enable_close_on_click = this.enable_close_on_click;
        builder.enable_full_click = this.enable_full_click;
        builder.invisible_ad_label = this.invisible_ad_label;
        builder.use_floating_btn = this.use_floating_btn;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.show_duration != null) {
            sb.append(", show_duration=");
            sb.append(this.show_duration);
        }
        if (this.enable_close_on_click != null) {
            sb.append(", enable_close_on_click=");
            sb.append(this.enable_close_on_click);
        }
        if (this.enable_full_click != null) {
            sb.append(", enable_full_click=");
            sb.append(this.enable_full_click);
        }
        if (this.invisible_ad_label != null) {
            sb.append(", invisible_ad_label=");
            sb.append(this.invisible_ad_label);
        }
        if (this.use_floating_btn != null) {
            sb.append(", use_floating_btn=");
            sb.append(this.use_floating_btn);
        }
        StringBuilder replace = sb.replace(0, 2, "SplashAdSetting{");
        replace.append('}');
        return replace.toString();
    }
}
