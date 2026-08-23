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
public final class ResponseAssetText extends AndroidMessage<ResponseAssetText, Builder> {
    public static final ProtoAdapter<ResponseAssetText> ADAPTER;
    public static final Parcelable.Creator<ResponseAssetText> CREATOR;
    public static final String DEFAULT_CONTEXT = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String context;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class Builder extends Message.Builder<ResponseAssetText, Builder> {
        public String context = "";

        public ResponseAssetText build() {
            return new ResponseAssetText(this.context, super.buildUnknownFields());
        }

        public Builder context(String str) {
            this.context = str;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class ProtoAdapter_ResponseAssetText extends ProtoAdapter<ResponseAssetText> {
        public ProtoAdapter_ResponseAssetText() {
            super(FieldEncoding.LENGTH_DELIMITED, ResponseAssetText.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public ResponseAssetText m86decode(ProtoReader protoReader) {
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
                    builder.context((String) ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, ResponseAssetText responseAssetText) {
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, responseAssetText.context);
            protoWriter.writeBytes(responseAssetText.unknownFields());
        }

        public int encodedSize(ResponseAssetText responseAssetText) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, responseAssetText.context) + responseAssetText.unknownFields().size();
        }

        public ResponseAssetText redact(ResponseAssetText responseAssetText) {
            Builder newBuilder = responseAssetText.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_ResponseAssetText protoAdapter_ResponseAssetText = new ProtoAdapter_ResponseAssetText();
        ADAPTER = protoAdapter_ResponseAssetText;
        CREATOR = AndroidMessage.newCreator(protoAdapter_ResponseAssetText);
    }

    public ResponseAssetText(String str) {
        this(str, ByteString.EMPTY);
    }

    public ResponseAssetText(String str, ByteString byteString) {
        super(ADAPTER, byteString);
        this.context = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseAssetText)) {
            return false;
        }
        ResponseAssetText responseAssetText = (ResponseAssetText) obj;
        return unknownFields().equals(responseAssetText.unknownFields()) && Internal.equals(this.context, responseAssetText.context);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.context;
        int hashCode2 = hashCode + (str != null ? str.hashCode() : 0);
        ((Message) this).hashCode = hashCode2;
        return hashCode2;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.context = this.context;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.context != null) {
            sb.append(", context=");
            sb.append(this.context);
        }
        StringBuilder replace = sb.replace(0, 2, "ResponseAssetText{");
        replace.append('}');
        return replace.toString();
    }
}
