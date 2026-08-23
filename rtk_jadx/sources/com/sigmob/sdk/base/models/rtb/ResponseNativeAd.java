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
public final class ResponseNativeAd extends AndroidMessage<ResponseNativeAd, Builder> {
    public static final ProtoAdapter<ResponseNativeAd> ADAPTER;
    public static final Parcelable.Creator<ResponseNativeAd> CREATOR;
    public static final Integer DEFAULT_TYPE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "ResponseAsset#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<ResponseAsset> assets;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer type;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class Builder extends Message.Builder<ResponseNativeAd, Builder> {
        public Integer type = ResponseNativeAd.DEFAULT_TYPE;
        public List<ResponseAsset> assets = Internal.newMutableList();

        public Builder assets(List<ResponseAsset> list) {
            Internal.checkElementsNotNull(list);
            this.assets = list;
            return this;
        }

        public ResponseNativeAd build() {
            return new ResponseNativeAd(this.assets, this.type, super.buildUnknownFields());
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class ProtoAdapter_ResponseNativeAd extends ProtoAdapter<ResponseNativeAd> {
        public ProtoAdapter_ResponseNativeAd() {
            super(FieldEncoding.LENGTH_DELIMITED, ResponseNativeAd.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public ResponseNativeAd m92decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.assets.add((ResponseAsset) ResponseAsset.ADAPTER.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.type((Integer) ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, ResponseNativeAd responseNativeAd) {
            ResponseAsset.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, responseNativeAd.assets);
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 2, responseNativeAd.type);
            protoWriter.writeBytes(responseNativeAd.unknownFields());
        }

        public int encodedSize(ResponseNativeAd responseNativeAd) {
            return ResponseAsset.ADAPTER.asRepeated().encodedSizeWithTag(1, responseNativeAd.assets) + ProtoAdapter.UINT32.encodedSizeWithTag(2, responseNativeAd.type) + responseNativeAd.unknownFields().size();
        }

        public ResponseNativeAd redact(ResponseNativeAd responseNativeAd) {
            Builder newBuilder = responseNativeAd.newBuilder();
            Internal.redactElements(newBuilder.assets, ResponseAsset.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_ResponseNativeAd protoAdapter_ResponseNativeAd = new ProtoAdapter_ResponseNativeAd();
        ADAPTER = protoAdapter_ResponseNativeAd;
        CREATOR = AndroidMessage.newCreator(protoAdapter_ResponseNativeAd);
        DEFAULT_TYPE = 0;
    }

    public ResponseNativeAd(List<ResponseAsset> list, Integer num) {
        this(list, num, ByteString.EMPTY);
    }

    public ResponseNativeAd(List<ResponseAsset> list, Integer num, ByteString byteString) {
        super(ADAPTER, byteString);
        this.assets = Internal.immutableCopyOf("assets", list);
        this.type = num;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseNativeAd)) {
            return false;
        }
        ResponseNativeAd responseNativeAd = (ResponseNativeAd) obj;
        return unknownFields().equals(responseNativeAd.unknownFields()) && this.assets.equals(responseNativeAd.assets) && Internal.equals(this.type, responseNativeAd.type);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = ((unknownFields().hashCode() * 37) + this.assets.hashCode()) * 37;
        Integer num = this.type;
        int hashCode2 = hashCode + (num != null ? num.hashCode() : 0);
        ((Message) this).hashCode = hashCode2;
        return hashCode2;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.assets = Internal.copyOf("assets", this.assets);
        builder.type = this.type;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.assets.isEmpty()) {
            sb.append(", assets=");
            sb.append(this.assets);
        }
        if (this.type != null) {
            sb.append(", type=");
            sb.append(this.type);
        }
        StringBuilder replace = sb.replace(0, 2, "ResponseNativeAd{");
        replace.append('}');
        return replace.toString();
    }
}
