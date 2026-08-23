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
public final class SingleNativeAdSetting extends AndroidMessage<SingleNativeAdSetting, Builder> {
    public static final ProtoAdapter<SingleNativeAdSetting> ADAPTER;
    public static final Parcelable.Creator<SingleNativeAdSetting> CREATOR;
    public static final Boolean DEFAULT_USE_NA_VIDEO_COMPONENT;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean use_na_video_component;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class Builder extends Message.Builder<SingleNativeAdSetting, Builder> {
        public Boolean use_na_video_component = SingleNativeAdSetting.DEFAULT_USE_NA_VIDEO_COMPONENT;

        public SingleNativeAdSetting build() {
            return new SingleNativeAdSetting(this.use_na_video_component, super.buildUnknownFields());
        }

        public Builder use_na_video_component(Boolean bool) {
            this.use_na_video_component = bool;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class ProtoAdapter_SingleNativeAdSetting extends ProtoAdapter<SingleNativeAdSetting> {
        public ProtoAdapter_SingleNativeAdSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, SingleNativeAdSetting.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public SingleNativeAdSetting m98decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag != 1) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.use_na_video_component((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, SingleNativeAdSetting singleNativeAdSetting) {
            ProtoAdapter.BOOL.encodeWithTag(protoWriter, 1, singleNativeAdSetting.use_na_video_component);
            protoWriter.writeBytes(singleNativeAdSetting.unknownFields());
        }

        public int encodedSize(SingleNativeAdSetting singleNativeAdSetting) {
            return ProtoAdapter.BOOL.encodedSizeWithTag(1, singleNativeAdSetting.use_na_video_component) + singleNativeAdSetting.unknownFields().size();
        }

        public SingleNativeAdSetting redact(SingleNativeAdSetting singleNativeAdSetting) {
            Builder newBuilder = singleNativeAdSetting.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_SingleNativeAdSetting protoAdapter_SingleNativeAdSetting = new ProtoAdapter_SingleNativeAdSetting();
        ADAPTER = protoAdapter_SingleNativeAdSetting;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SingleNativeAdSetting);
        DEFAULT_USE_NA_VIDEO_COMPONENT = Boolean.FALSE;
    }

    public SingleNativeAdSetting(Boolean bool) {
        this(bool, ByteString.EMPTY);
    }

    public SingleNativeAdSetting(Boolean bool, ByteString byteString) {
        super(ADAPTER, byteString);
        this.use_na_video_component = bool;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SingleNativeAdSetting)) {
            return false;
        }
        SingleNativeAdSetting singleNativeAdSetting = (SingleNativeAdSetting) obj;
        return unknownFields().equals(singleNativeAdSetting.unknownFields()) && Internal.equals(this.use_na_video_component, singleNativeAdSetting.use_na_video_component);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Boolean bool = this.use_na_video_component;
        int hashCode2 = hashCode + (bool != null ? bool.hashCode() : 0);
        ((Message) this).hashCode = hashCode2;
        return hashCode2;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.use_na_video_component = this.use_na_video_component;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.use_na_video_component != null) {
            sb.append(", use_na_video_component=");
            sb.append(this.use_na_video_component);
        }
        StringBuilder replace = sb.replace(0, 2, "SingleNativeAdSetting{");
        replace.append('}');
        return replace.toString();
    }
}
