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
import com.umeng.analytics.pro.d;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class SigmobAntiFraudLogConfig extends AndroidMessage<SigmobAntiFraudLogConfig, Builder> {
    public static final ProtoAdapter<SigmobAntiFraudLogConfig> ADAPTER;
    public static final Parcelable.Creator<SigmobAntiFraudLogConfig> CREATOR;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 2)
    public final List<String> events;

    @WireField(adapter = "com.sigmob.sdk.base.models.config.SigmobMotionConfig#ADAPTER", tag = 1)
    public final SigmobMotionConfig motion_config;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class Builder extends Message.Builder<SigmobAntiFraudLogConfig, Builder> {
        public List<String> events = Internal.newMutableList();
        public SigmobMotionConfig motion_config;

        public SigmobAntiFraudLogConfig build() {
            return new SigmobAntiFraudLogConfig(this.motion_config, this.events, super.buildUnknownFields());
        }

        public Builder events(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.events = list;
            return this;
        }

        public Builder motion_config(SigmobMotionConfig sigmobMotionConfig) {
            this.motion_config = sigmobMotionConfig;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class ProtoAdapter_SigmobAntiFraudLogConfig extends ProtoAdapter<SigmobAntiFraudLogConfig> {
        public ProtoAdapter_SigmobAntiFraudLogConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SigmobAntiFraudLogConfig.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public SigmobAntiFraudLogConfig m11decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.motion_config((SigmobMotionConfig) SigmobMotionConfig.ADAPTER.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.events.add((String) ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, SigmobAntiFraudLogConfig sigmobAntiFraudLogConfig) {
            SigmobMotionConfig.ADAPTER.encodeWithTag(protoWriter, 1, sigmobAntiFraudLogConfig.motion_config);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 2, sigmobAntiFraudLogConfig.events);
            protoWriter.writeBytes(sigmobAntiFraudLogConfig.unknownFields());
        }

        public int encodedSize(SigmobAntiFraudLogConfig sigmobAntiFraudLogConfig) {
            return SigmobMotionConfig.ADAPTER.encodedSizeWithTag(1, sigmobAntiFraudLogConfig.motion_config) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, sigmobAntiFraudLogConfig.events) + sigmobAntiFraudLogConfig.unknownFields().size();
        }

        public SigmobAntiFraudLogConfig redact(SigmobAntiFraudLogConfig sigmobAntiFraudLogConfig) {
            Builder newBuilder = sigmobAntiFraudLogConfig.newBuilder();
            SigmobMotionConfig sigmobMotionConfig = newBuilder.motion_config;
            if (sigmobMotionConfig != null) {
                newBuilder.motion_config = (SigmobMotionConfig) SigmobMotionConfig.ADAPTER.redact(sigmobMotionConfig);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_SigmobAntiFraudLogConfig protoAdapter_SigmobAntiFraudLogConfig = new ProtoAdapter_SigmobAntiFraudLogConfig();
        ADAPTER = protoAdapter_SigmobAntiFraudLogConfig;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SigmobAntiFraudLogConfig);
    }

    public SigmobAntiFraudLogConfig(SigmobMotionConfig sigmobMotionConfig, List<String> list) {
        this(sigmobMotionConfig, list, ByteString.EMPTY);
    }

    public SigmobAntiFraudLogConfig(SigmobMotionConfig sigmobMotionConfig, List<String> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.motion_config = sigmobMotionConfig;
        this.events = Internal.immutableCopyOf(d.ar, list);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SigmobAntiFraudLogConfig)) {
            return false;
        }
        SigmobAntiFraudLogConfig sigmobAntiFraudLogConfig = (SigmobAntiFraudLogConfig) obj;
        return unknownFields().equals(sigmobAntiFraudLogConfig.unknownFields()) && Internal.equals(this.motion_config, sigmobAntiFraudLogConfig.motion_config) && this.events.equals(sigmobAntiFraudLogConfig.events);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        SigmobMotionConfig sigmobMotionConfig = this.motion_config;
        int hashCode2 = ((hashCode + (sigmobMotionConfig != null ? sigmobMotionConfig.hashCode() : 0)) * 37) + this.events.hashCode();
        ((Message) this).hashCode = hashCode2;
        return hashCode2;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.motion_config = this.motion_config;
        builder.events = Internal.copyOf(d.ar, this.events);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.motion_config != null) {
            sb.append(", motion_config=");
            sb.append(this.motion_config);
        }
        if (!this.events.isEmpty()) {
            sb.append(", events=");
            sb.append(this.events);
        }
        StringBuilder replace = sb.replace(0, 2, "SigmobAntiFraudLogConfig{");
        replace.append('}');
        return replace.toString();
    }
}
