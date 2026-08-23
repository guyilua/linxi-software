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
public final class BiddingResponse extends AndroidMessage<BiddingResponse, Builder> {
    public static final ProtoAdapter<BiddingResponse> ADAPTER;
    public static final Parcelable.Creator<BiddingResponse> CREATOR;
    public static final Integer DEFAULT_ECPM;
    public static final String DEFAULT_LOSE_URL = "";
    public static final String DEFAULT_WIN_URL = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer ecpm;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String lose_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String win_url;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class Builder extends Message.Builder<BiddingResponse, Builder> {
        public String win_url = "";
        public String lose_url = "";
        public Integer ecpm = BiddingResponse.DEFAULT_ECPM;

        public BiddingResponse build() {
            return new BiddingResponse(this.win_url, this.lose_url, this.ecpm, super.buildUnknownFields());
        }

        public Builder ecpm(Integer num) {
            this.ecpm = num;
            return this;
        }

        public Builder lose_url(String str) {
            this.lose_url = str;
            return this;
        }

        public Builder win_url(String str) {
            this.win_url = str;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class ProtoAdapter_BiddingResponse extends ProtoAdapter<BiddingResponse> {
        public ProtoAdapter_BiddingResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, BiddingResponse.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public BiddingResponse m59decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.win_url((String) ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.lose_url((String) ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.ecpm((Integer) ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, BiddingResponse biddingResponse) {
            ProtoAdapter protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, biddingResponse.win_url);
            protoAdapter.encodeWithTag(protoWriter, 2, biddingResponse.lose_url);
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 3, biddingResponse.ecpm);
            protoWriter.writeBytes(biddingResponse.unknownFields());
        }

        public int encodedSize(BiddingResponse biddingResponse) {
            ProtoAdapter protoAdapter = ProtoAdapter.STRING;
            return protoAdapter.encodedSizeWithTag(1, biddingResponse.win_url) + protoAdapter.encodedSizeWithTag(2, biddingResponse.lose_url) + ProtoAdapter.UINT32.encodedSizeWithTag(3, biddingResponse.ecpm) + biddingResponse.unknownFields().size();
        }

        public BiddingResponse redact(BiddingResponse biddingResponse) {
            Builder newBuilder = biddingResponse.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_BiddingResponse protoAdapter_BiddingResponse = new ProtoAdapter_BiddingResponse();
        ADAPTER = protoAdapter_BiddingResponse;
        CREATOR = AndroidMessage.newCreator(protoAdapter_BiddingResponse);
        DEFAULT_ECPM = 0;
    }

    public BiddingResponse(String str, String str2, Integer num) {
        this(str, str2, num, ByteString.EMPTY);
    }

    public BiddingResponse(String str, String str2, Integer num, ByteString byteString) {
        super(ADAPTER, byteString);
        this.win_url = str;
        this.lose_url = str2;
        this.ecpm = num;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BiddingResponse)) {
            return false;
        }
        BiddingResponse biddingResponse = (BiddingResponse) obj;
        return unknownFields().equals(biddingResponse.unknownFields()) && Internal.equals(this.win_url, biddingResponse.win_url) && Internal.equals(this.lose_url, biddingResponse.lose_url) && Internal.equals(this.ecpm, biddingResponse.ecpm);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.win_url;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.lose_url;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.ecpm;
        int hashCode4 = hashCode3 + (num != null ? num.hashCode() : 0);
        ((Message) this).hashCode = hashCode4;
        return hashCode4;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.win_url = this.win_url;
        builder.lose_url = this.lose_url;
        builder.ecpm = this.ecpm;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.win_url != null) {
            sb.append(", win_url=");
            sb.append(this.win_url);
        }
        if (this.lose_url != null) {
            sb.append(", lose_url=");
            sb.append(this.lose_url);
        }
        if (this.ecpm != null) {
            sb.append(", ecpm=");
            sb.append(this.ecpm);
        }
        StringBuilder replace = sb.replace(0, 2, "BiddingResponse{");
        replace.append('}');
        return replace.toString();
    }
}
