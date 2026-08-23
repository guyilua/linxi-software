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
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class AdPrivacy extends AndroidMessage<AdPrivacy, Builder> {
    public static final ProtoAdapter<AdPrivacy> ADAPTER;
    public static final Parcelable.Creator<AdPrivacy> CREATOR;
    public static final String DEFAULT_PRIVACY_INFO_URL = "";
    public static final String DEFAULT_PRIVACY_TEMPLATE_URL = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String privacy_info_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final Map<String, String> privacy_template_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String privacy_template_url;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class Builder extends Message.Builder<AdPrivacy, Builder> {
        public String privacy_info_url = "";
        public String privacy_template_url = "";
        public Map<String, String> privacy_template_info = Internal.newMutableMap();

        public AdPrivacy build() {
            return new AdPrivacy(this.privacy_info_url, this.privacy_template_url, this.privacy_template_info, super.buildUnknownFields());
        }

        public Builder privacy_info_url(String str) {
            this.privacy_info_url = str;
            return this;
        }

        public Builder privacy_template_info(Map<String, String> map) {
            Internal.checkElementsNotNull(map);
            this.privacy_template_info = map;
            return this;
        }

        public Builder privacy_template_url(String str) {
            this.privacy_template_url = str;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class ProtoAdapter_AdPrivacy extends ProtoAdapter<AdPrivacy> {
        private final ProtoAdapter<Map<String, String>> privacy_template_info;

        public ProtoAdapter_AdPrivacy() {
            super(FieldEncoding.LENGTH_DELIMITED, AdPrivacy.class);
            ProtoAdapter protoAdapter = ProtoAdapter.STRING;
            this.privacy_template_info = ProtoAdapter.newMapAdapter(protoAdapter, protoAdapter);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public AdPrivacy m47decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.privacy_info_url((String) ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.privacy_template_url((String) ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.privacy_template_info.putAll((Map) this.privacy_template_info.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, AdPrivacy adPrivacy) {
            ProtoAdapter protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, adPrivacy.privacy_info_url);
            protoAdapter.encodeWithTag(protoWriter, 2, adPrivacy.privacy_template_url);
            this.privacy_template_info.encodeWithTag(protoWriter, 3, adPrivacy.privacy_template_info);
            protoWriter.writeBytes(adPrivacy.unknownFields());
        }

        public int encodedSize(AdPrivacy adPrivacy) {
            ProtoAdapter protoAdapter = ProtoAdapter.STRING;
            return protoAdapter.encodedSizeWithTag(1, adPrivacy.privacy_info_url) + protoAdapter.encodedSizeWithTag(2, adPrivacy.privacy_template_url) + this.privacy_template_info.encodedSizeWithTag(3, adPrivacy.privacy_template_info) + adPrivacy.unknownFields().size();
        }

        public AdPrivacy redact(AdPrivacy adPrivacy) {
            Builder newBuilder = adPrivacy.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_AdPrivacy protoAdapter_AdPrivacy = new ProtoAdapter_AdPrivacy();
        ADAPTER = protoAdapter_AdPrivacy;
        CREATOR = AndroidMessage.newCreator(protoAdapter_AdPrivacy);
    }

    public AdPrivacy(String str, String str2, Map<String, String> map) {
        this(str, str2, map, ByteString.EMPTY);
    }

    public AdPrivacy(String str, String str2, Map<String, String> map, ByteString byteString) {
        super(ADAPTER, byteString);
        this.privacy_info_url = str;
        this.privacy_template_url = str2;
        this.privacy_template_info = Internal.immutableCopyOf("privacy_template_info", map);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdPrivacy)) {
            return false;
        }
        AdPrivacy adPrivacy = (AdPrivacy) obj;
        return unknownFields().equals(adPrivacy.unknownFields()) && Internal.equals(this.privacy_info_url, adPrivacy.privacy_info_url) && Internal.equals(this.privacy_template_url, adPrivacy.privacy_template_url) && this.privacy_template_info.equals(adPrivacy.privacy_template_info);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.privacy_info_url;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.privacy_template_url;
        int hashCode3 = ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37) + this.privacy_template_info.hashCode();
        ((Message) this).hashCode = hashCode3;
        return hashCode3;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.privacy_info_url = this.privacy_info_url;
        builder.privacy_template_url = this.privacy_template_url;
        builder.privacy_template_info = Internal.copyOf("privacy_template_info", this.privacy_template_info);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.privacy_info_url != null) {
            sb.append(", privacy_info_url=");
            sb.append(this.privacy_info_url);
        }
        if (this.privacy_template_url != null) {
            sb.append(", privacy_template_url=");
            sb.append(this.privacy_template_url);
        }
        if (!this.privacy_template_info.isEmpty()) {
            sb.append(", privacy_template_info=");
            sb.append(this.privacy_template_info);
        }
        StringBuilder replace = sb.replace(0, 2, "AdPrivacy{");
        replace.append('}');
        return replace.toString();
    }
}
