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
public final class ResponseAssetImage extends AndroidMessage<ResponseAssetImage, Builder> {
    public static final ProtoAdapter<ResponseAssetImage> ADAPTER;
    public static final Parcelable.Creator<ResponseAssetImage> CREATOR;
    public static final Integer DEFAULT_H;
    public static final String DEFAULT_URL = "";
    public static final Integer DEFAULT_W;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer h;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer w;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class Builder extends Message.Builder<ResponseAssetImage, Builder> {
        public String url = "";
        public Integer w = ResponseAssetImage.DEFAULT_W;
        public Integer h = ResponseAssetImage.DEFAULT_H;

        public ResponseAssetImage build() {
            return new ResponseAssetImage(this.url, this.w, this.h, super.buildUnknownFields());
        }

        public Builder h(Integer num) {
            this.h = num;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        public Builder w(Integer num) {
            this.w = num;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class ProtoAdapter_ResponseAssetImage extends ProtoAdapter<ResponseAssetImage> {
        public ProtoAdapter_ResponseAssetImage() {
            super(FieldEncoding.LENGTH_DELIMITED, ResponseAssetImage.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public ResponseAssetImage m83decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.url((String) ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.w((Integer) ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.h((Integer) ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, ResponseAssetImage responseAssetImage) {
            ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, responseAssetImage.url);
            ProtoAdapter protoAdapter = ProtoAdapter.UINT32;
            protoAdapter.encodeWithTag(protoWriter, 2, responseAssetImage.w);
            protoAdapter.encodeWithTag(protoWriter, 3, responseAssetImage.h);
            protoWriter.writeBytes(responseAssetImage.unknownFields());
        }

        public int encodedSize(ResponseAssetImage responseAssetImage) {
            int encodedSizeWithTag = ProtoAdapter.STRING.encodedSizeWithTag(1, responseAssetImage.url);
            ProtoAdapter protoAdapter = ProtoAdapter.UINT32;
            return encodedSizeWithTag + protoAdapter.encodedSizeWithTag(2, responseAssetImage.w) + protoAdapter.encodedSizeWithTag(3, responseAssetImage.h) + responseAssetImage.unknownFields().size();
        }

        public ResponseAssetImage redact(ResponseAssetImage responseAssetImage) {
            Builder newBuilder = responseAssetImage.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_ResponseAssetImage protoAdapter_ResponseAssetImage = new ProtoAdapter_ResponseAssetImage();
        ADAPTER = protoAdapter_ResponseAssetImage;
        CREATOR = AndroidMessage.newCreator(protoAdapter_ResponseAssetImage);
        DEFAULT_W = 0;
        DEFAULT_H = 0;
    }

    public ResponseAssetImage(String str, Integer num, Integer num2) {
        this(str, num, num2, ByteString.EMPTY);
    }

    public ResponseAssetImage(String str, Integer num, Integer num2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.url = str;
        this.w = num;
        this.h = num2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseAssetImage)) {
            return false;
        }
        ResponseAssetImage responseAssetImage = (ResponseAssetImage) obj;
        return unknownFields().equals(responseAssetImage.unknownFields()) && Internal.equals(this.url, responseAssetImage.url) && Internal.equals(this.w, responseAssetImage.w) && Internal.equals(this.h, responseAssetImage.h);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.url;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.w;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.h;
        int hashCode4 = hashCode3 + (num2 != null ? num2.hashCode() : 0);
        ((Message) this).hashCode = hashCode4;
        return hashCode4;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.url = this.url;
        builder.w = this.w;
        builder.h = this.h;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.url != null) {
            sb.append(", url=");
            sb.append(this.url);
        }
        if (this.w != null) {
            sb.append(", w=");
            sb.append(this.w);
        }
        if (this.h != null) {
            sb.append(", h=");
            sb.append(this.h);
        }
        StringBuilder replace = sb.replace(0, 2, "ResponseAssetImage{");
        replace.append('}');
        return replace.toString();
    }
}
