package com.sigmob.sdk.base.models.config;

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
public final class SigmobNativeConfig extends AndroidMessage<SigmobNativeConfig, Builder> {
    public static final ProtoAdapter<SigmobNativeConfig> ADAPTER;
    public static final Parcelable.Creator<SigmobNativeConfig> CREATOR;
    public static final Integer DEFAULT_AD_LOAD_TIMEOUT;
    public static final Integer DEFAULT_CACHETOP;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer ad_load_timeout;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer cacheTop;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class Builder extends Message.Builder<SigmobNativeConfig, Builder> {
        public Integer ad_load_timeout;
        public Integer cacheTop;

        public Builder ad_load_timeout(Integer num) {
            this.ad_load_timeout = num;
            return this;
        }

        public SigmobNativeConfig build() {
            return new SigmobNativeConfig(this.cacheTop, this.ad_load_timeout, super.buildUnknownFields());
        }

        public Builder cacheTop(Integer num) {
            this.cacheTop = num;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class ProtoAdapter_SigmobNativeConfig extends ProtoAdapter<SigmobNativeConfig> {
        public ProtoAdapter_SigmobNativeConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SigmobNativeConfig.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public SigmobNativeConfig m26decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.cacheTop((Integer) ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.ad_load_timeout((Integer) ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, SigmobNativeConfig sigmobNativeConfig) {
            ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, sigmobNativeConfig.cacheTop);
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 2, sigmobNativeConfig.ad_load_timeout);
            protoWriter.writeBytes(sigmobNativeConfig.unknownFields());
        }

        public int encodedSize(SigmobNativeConfig sigmobNativeConfig) {
            return ProtoAdapter.INT32.encodedSizeWithTag(1, sigmobNativeConfig.cacheTop) + ProtoAdapter.UINT32.encodedSizeWithTag(2, sigmobNativeConfig.ad_load_timeout) + sigmobNativeConfig.unknownFields().size();
        }

        public SigmobNativeConfig redact(SigmobNativeConfig sigmobNativeConfig) {
            Builder newBuilder = sigmobNativeConfig.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_SigmobNativeConfig protoAdapter_SigmobNativeConfig = new ProtoAdapter_SigmobNativeConfig();
        ADAPTER = protoAdapter_SigmobNativeConfig;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SigmobNativeConfig);
        DEFAULT_CACHETOP = 0;
        DEFAULT_AD_LOAD_TIMEOUT = 0;
    }

    public SigmobNativeConfig(Integer num, Integer num2) {
        this(num, num2, ByteString.EMPTY);
    }

    public SigmobNativeConfig(Integer num, Integer num2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.cacheTop = num;
        this.ad_load_timeout = num2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SigmobNativeConfig)) {
            return false;
        }
        SigmobNativeConfig sigmobNativeConfig = (SigmobNativeConfig) obj;
        return unknownFields().equals(sigmobNativeConfig.unknownFields()) && Internal.equals(this.cacheTop, sigmobNativeConfig.cacheTop) && Internal.equals(this.ad_load_timeout, sigmobNativeConfig.ad_load_timeout);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.cacheTop;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.ad_load_timeout;
        int hashCode3 = hashCode2 + (num2 != null ? num2.hashCode() : 0);
        ((Message) this).hashCode = hashCode3;
        return hashCode3;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.cacheTop = this.cacheTop;
        builder.ad_load_timeout = this.ad_load_timeout;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.cacheTop != null) {
            sb.append(", cacheTop=");
            sb.append(this.cacheTop);
        }
        if (this.ad_load_timeout != null) {
            sb.append(", ad_load_timeout=");
            sb.append(this.ad_load_timeout);
        }
        StringBuilder replace = sb.replace(0, 2, "SigmobNativeConfig{");
        replace.append('}');
        return replace.toString();
    }
}
