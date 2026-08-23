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
public final class ResponseAsset extends AndroidMessage<ResponseAsset, Builder> {
    public static final ProtoAdapter<ResponseAsset> ADAPTER;
    public static final Parcelable.Creator<ResponseAsset> CREATOR;
    public static final Integer DEFAULT_INDEX;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "ResponseAssetImage#ADAPTER", tag = 3)
    public final ResponseAssetImage image;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer index;

    @WireField(adapter = "ResponseAssetText#ADAPTER", tag = 4)
    public final ResponseAssetText text;

    @WireField(adapter = "ResponseAssetVideo#ADAPTER", tag = 2)
    public final ResponseAssetVideo video;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class Builder extends Message.Builder<ResponseAsset, Builder> {
        public ResponseAssetImage image;
        public Integer index = ResponseAsset.DEFAULT_INDEX;
        public ResponseAssetText text;
        public ResponseAssetVideo video;

        public ResponseAsset build() {
            return new ResponseAsset(this.index, this.video, this.image, this.text, super.buildUnknownFields());
        }

        public Builder image(ResponseAssetImage responseAssetImage) {
            this.image = responseAssetImage;
            return this;
        }

        public Builder index(Integer num) {
            this.index = num;
            return this;
        }

        public Builder text(ResponseAssetText responseAssetText) {
            this.text = responseAssetText;
            return this;
        }

        public Builder video(ResponseAssetVideo responseAssetVideo) {
            this.video = responseAssetVideo;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class ProtoAdapter_ResponseAsset extends ProtoAdapter<ResponseAsset> {
        public ProtoAdapter_ResponseAsset() {
            super(FieldEncoding.LENGTH_DELIMITED, ResponseAsset.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public ResponseAsset m80decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.index((Integer) ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.video((ResponseAssetVideo) ResponseAssetVideo.ADAPTER.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.image((ResponseAssetImage) ResponseAssetImage.ADAPTER.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.text((ResponseAssetText) ResponseAssetText.ADAPTER.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, ResponseAsset responseAsset) {
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 1, responseAsset.index);
            ResponseAssetVideo.ADAPTER.encodeWithTag(protoWriter, 2, responseAsset.video);
            ResponseAssetImage.ADAPTER.encodeWithTag(protoWriter, 3, responseAsset.image);
            ResponseAssetText.ADAPTER.encodeWithTag(protoWriter, 4, responseAsset.text);
            protoWriter.writeBytes(responseAsset.unknownFields());
        }

        public int encodedSize(ResponseAsset responseAsset) {
            return ProtoAdapter.UINT32.encodedSizeWithTag(1, responseAsset.index) + ResponseAssetVideo.ADAPTER.encodedSizeWithTag(2, responseAsset.video) + ResponseAssetImage.ADAPTER.encodedSizeWithTag(3, responseAsset.image) + ResponseAssetText.ADAPTER.encodedSizeWithTag(4, responseAsset.text) + responseAsset.unknownFields().size();
        }

        public ResponseAsset redact(ResponseAsset responseAsset) {
            Builder newBuilder = responseAsset.newBuilder();
            ResponseAssetVideo responseAssetVideo = newBuilder.video;
            if (responseAssetVideo != null) {
                newBuilder.video = (ResponseAssetVideo) ResponseAssetVideo.ADAPTER.redact(responseAssetVideo);
            }
            ResponseAssetImage responseAssetImage = newBuilder.image;
            if (responseAssetImage != null) {
                newBuilder.image = (ResponseAssetImage) ResponseAssetImage.ADAPTER.redact(responseAssetImage);
            }
            ResponseAssetText responseAssetText = newBuilder.text;
            if (responseAssetText != null) {
                newBuilder.text = (ResponseAssetText) ResponseAssetText.ADAPTER.redact(responseAssetText);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_ResponseAsset protoAdapter_ResponseAsset = new ProtoAdapter_ResponseAsset();
        ADAPTER = protoAdapter_ResponseAsset;
        CREATOR = AndroidMessage.newCreator(protoAdapter_ResponseAsset);
        DEFAULT_INDEX = 0;
    }

    public ResponseAsset(Integer num, ResponseAssetVideo responseAssetVideo, ResponseAssetImage responseAssetImage, ResponseAssetText responseAssetText) {
        this(num, responseAssetVideo, responseAssetImage, responseAssetText, ByteString.EMPTY);
    }

    public ResponseAsset(Integer num, ResponseAssetVideo responseAssetVideo, ResponseAssetImage responseAssetImage, ResponseAssetText responseAssetText, ByteString byteString) {
        super(ADAPTER, byteString);
        this.index = num;
        this.video = responseAssetVideo;
        this.image = responseAssetImage;
        this.text = responseAssetText;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseAsset)) {
            return false;
        }
        ResponseAsset responseAsset = (ResponseAsset) obj;
        return unknownFields().equals(responseAsset.unknownFields()) && Internal.equals(this.index, responseAsset.index) && Internal.equals(this.video, responseAsset.video) && Internal.equals(this.image, responseAsset.image) && Internal.equals(this.text, responseAsset.text);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.index;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        ResponseAssetVideo responseAssetVideo = this.video;
        int hashCode3 = (hashCode2 + (responseAssetVideo != null ? responseAssetVideo.hashCode() : 0)) * 37;
        ResponseAssetImage responseAssetImage = this.image;
        int hashCode4 = (hashCode3 + (responseAssetImage != null ? responseAssetImage.hashCode() : 0)) * 37;
        ResponseAssetText responseAssetText = this.text;
        int hashCode5 = hashCode4 + (responseAssetText != null ? responseAssetText.hashCode() : 0);
        ((Message) this).hashCode = hashCode5;
        return hashCode5;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.index = this.index;
        builder.video = this.video;
        builder.image = this.image;
        builder.text = this.text;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.index != null) {
            sb.append(", index=");
            sb.append(this.index);
        }
        if (this.video != null) {
            sb.append(", video=");
            sb.append(this.video);
        }
        if (this.image != null) {
            sb.append(", image=");
            sb.append(this.image);
        }
        if (this.text != null) {
            sb.append(", text=");
            sb.append(this.text);
        }
        StringBuilder replace = sb.replace(0, 2, "ResponseAsset{");
        replace.append('}');
        return replace.toString();
    }
}
