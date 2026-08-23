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
public final class SigmobSplashConfig extends AndroidMessage<SigmobSplashConfig, Builder> {
    public static final ProtoAdapter<SigmobSplashConfig> ADAPTER;
    public static final Parcelable.Creator<SigmobSplashConfig> CREATOR;
    public static final Integer DEFAULT_CACHETOP;
    public static final Integer DEFAULT_MATERIAL_EXPIRED_TIME;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer cacheTop;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer material_expired_time;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class Builder extends Message.Builder<SigmobSplashConfig, Builder> {
        public Integer cacheTop;
        public Integer material_expired_time;

        public SigmobSplashConfig build() {
            return new SigmobSplashConfig(this.cacheTop, this.material_expired_time, super.buildUnknownFields());
        }

        public Builder cacheTop(Integer num) {
            this.cacheTop = num;
            return this;
        }

        public Builder material_expired_time(Integer num) {
            this.material_expired_time = num;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class ProtoAdapter_SigmobSplashConfig extends ProtoAdapter<SigmobSplashConfig> {
        public ProtoAdapter_SigmobSplashConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SigmobSplashConfig.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public SigmobSplashConfig m41decode(ProtoReader protoReader) {
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
                    builder.material_expired_time((Integer) ProtoAdapter.INT32.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, SigmobSplashConfig sigmobSplashConfig) {
            ProtoAdapter protoAdapter = ProtoAdapter.INT32;
            protoAdapter.encodeWithTag(protoWriter, 1, sigmobSplashConfig.cacheTop);
            protoAdapter.encodeWithTag(protoWriter, 2, sigmobSplashConfig.material_expired_time);
            protoWriter.writeBytes(sigmobSplashConfig.unknownFields());
        }

        public int encodedSize(SigmobSplashConfig sigmobSplashConfig) {
            ProtoAdapter protoAdapter = ProtoAdapter.INT32;
            return protoAdapter.encodedSizeWithTag(1, sigmobSplashConfig.cacheTop) + protoAdapter.encodedSizeWithTag(2, sigmobSplashConfig.material_expired_time) + sigmobSplashConfig.unknownFields().size();
        }

        public SigmobSplashConfig redact(SigmobSplashConfig sigmobSplashConfig) {
            Builder newBuilder = sigmobSplashConfig.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_SigmobSplashConfig protoAdapter_SigmobSplashConfig = new ProtoAdapter_SigmobSplashConfig();
        ADAPTER = protoAdapter_SigmobSplashConfig;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SigmobSplashConfig);
        DEFAULT_CACHETOP = 0;
        DEFAULT_MATERIAL_EXPIRED_TIME = 0;
    }

    public SigmobSplashConfig(Integer num, Integer num2) {
        this(num, num2, ByteString.EMPTY);
    }

    public SigmobSplashConfig(Integer num, Integer num2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.cacheTop = num;
        this.material_expired_time = num2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SigmobSplashConfig)) {
            return false;
        }
        SigmobSplashConfig sigmobSplashConfig = (SigmobSplashConfig) obj;
        return unknownFields().equals(sigmobSplashConfig.unknownFields()) && Internal.equals(this.cacheTop, sigmobSplashConfig.cacheTop) && Internal.equals(this.material_expired_time, sigmobSplashConfig.material_expired_time);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.cacheTop;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.material_expired_time;
        int hashCode3 = hashCode2 + (num2 != null ? num2.hashCode() : 0);
        ((Message) this).hashCode = hashCode3;
        return hashCode3;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.cacheTop = this.cacheTop;
        builder.material_expired_time = this.material_expired_time;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.cacheTop != null) {
            sb.append(", cacheTop=");
            sb.append(this.cacheTop);
        }
        if (this.material_expired_time != null) {
            sb.append(", material_expired_time=");
            sb.append(this.material_expired_time);
        }
        StringBuilder replace = sb.replace(0, 2, "SigmobSplashConfig{");
        replace.append('}');
        return replace.toString();
    }
}
