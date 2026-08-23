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
public final class WXProgramRes extends AndroidMessage<WXProgramRes, Builder> {
    public static final ProtoAdapter<WXProgramRes> ADAPTER;
    public static final Parcelable.Creator<WXProgramRes> CREATOR;
    public static final String DEFAULT_WX_APP_ID = "";
    public static final String DEFAULT_WX_APP_PATH = "";
    public static final String DEFAULT_WX_APP_USERNAME = "";
    public static final Integer DEFAULT_WX_BUSINESS_TYPE;
    public static final String DEFAULT_WX_EXT_MSG = "";
    public static final String DEFAULT_WX_UNIVERSAL_LINK = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String wx_app_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String wx_app_path;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String wx_app_username;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 6)
    public final Integer wx_business_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String wx_ext_msg;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String wx_universal_link;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class Builder extends Message.Builder<WXProgramRes, Builder> {
        public String wx_app_id = "";
        public String wx_universal_link = "";
        public String wx_app_username = "";
        public String wx_app_path = "";
        public String wx_ext_msg = "";
        public Integer wx_business_type = WXProgramRes.DEFAULT_WX_BUSINESS_TYPE;

        public WXProgramRes build() {
            return new WXProgramRes(this.wx_app_id, this.wx_universal_link, this.wx_app_username, this.wx_app_path, this.wx_ext_msg, this.wx_business_type, super.buildUnknownFields());
        }

        public Builder wx_app_id(String str) {
            this.wx_app_id = str;
            return this;
        }

        public Builder wx_app_path(String str) {
            this.wx_app_path = str;
            return this;
        }

        public Builder wx_app_username(String str) {
            this.wx_app_username = str;
            return this;
        }

        public Builder wx_business_type(Integer num) {
            this.wx_business_type = num;
            return this;
        }

        public Builder wx_ext_msg(String str) {
            this.wx_ext_msg = str;
            return this;
        }

        public Builder wx_universal_link(String str) {
            this.wx_universal_link = str;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class ProtoAdapter_WXProgramRes extends ProtoAdapter<WXProgramRes> {
        public ProtoAdapter_WXProgramRes() {
            super(FieldEncoding.LENGTH_DELIMITED, WXProgramRes.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public WXProgramRes m113decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                switch (nextTag) {
                    case 1:
                        builder.wx_app_id((String) ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 2:
                        builder.wx_universal_link((String) ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 3:
                        builder.wx_app_username((String) ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 4:
                        builder.wx_app_path((String) ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 5:
                        builder.wx_ext_msg((String) ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 6:
                        builder.wx_business_type((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    default:
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        break;
                }
            }
        }

        public void encode(ProtoWriter protoWriter, WXProgramRes wXProgramRes) {
            ProtoAdapter protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, wXProgramRes.wx_app_id);
            protoAdapter.encodeWithTag(protoWriter, 2, wXProgramRes.wx_universal_link);
            protoAdapter.encodeWithTag(protoWriter, 3, wXProgramRes.wx_app_username);
            protoAdapter.encodeWithTag(protoWriter, 4, wXProgramRes.wx_app_path);
            protoAdapter.encodeWithTag(protoWriter, 5, wXProgramRes.wx_ext_msg);
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 6, wXProgramRes.wx_business_type);
            protoWriter.writeBytes(wXProgramRes.unknownFields());
        }

        public int encodedSize(WXProgramRes wXProgramRes) {
            ProtoAdapter protoAdapter = ProtoAdapter.STRING;
            return protoAdapter.encodedSizeWithTag(1, wXProgramRes.wx_app_id) + protoAdapter.encodedSizeWithTag(2, wXProgramRes.wx_universal_link) + protoAdapter.encodedSizeWithTag(3, wXProgramRes.wx_app_username) + protoAdapter.encodedSizeWithTag(4, wXProgramRes.wx_app_path) + protoAdapter.encodedSizeWithTag(5, wXProgramRes.wx_ext_msg) + ProtoAdapter.UINT32.encodedSizeWithTag(6, wXProgramRes.wx_business_type) + wXProgramRes.unknownFields().size();
        }

        public WXProgramRes redact(WXProgramRes wXProgramRes) {
            Builder newBuilder = wXProgramRes.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_WXProgramRes protoAdapter_WXProgramRes = new ProtoAdapter_WXProgramRes();
        ADAPTER = protoAdapter_WXProgramRes;
        CREATOR = AndroidMessage.newCreator(protoAdapter_WXProgramRes);
        DEFAULT_WX_BUSINESS_TYPE = 0;
    }

    public WXProgramRes(String str, String str2, String str3, String str4, String str5, Integer num) {
        this(str, str2, str3, str4, str5, num, ByteString.EMPTY);
    }

    public WXProgramRes(String str, String str2, String str3, String str4, String str5, Integer num, ByteString byteString) {
        super(ADAPTER, byteString);
        this.wx_app_id = str;
        this.wx_universal_link = str2;
        this.wx_app_username = str3;
        this.wx_app_path = str4;
        this.wx_ext_msg = str5;
        this.wx_business_type = num;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WXProgramRes)) {
            return false;
        }
        WXProgramRes wXProgramRes = (WXProgramRes) obj;
        return unknownFields().equals(wXProgramRes.unknownFields()) && Internal.equals(this.wx_app_id, wXProgramRes.wx_app_id) && Internal.equals(this.wx_universal_link, wXProgramRes.wx_universal_link) && Internal.equals(this.wx_app_username, wXProgramRes.wx_app_username) && Internal.equals(this.wx_app_path, wXProgramRes.wx_app_path) && Internal.equals(this.wx_ext_msg, wXProgramRes.wx_ext_msg) && Internal.equals(this.wx_business_type, wXProgramRes.wx_business_type);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.wx_app_id;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.wx_universal_link;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.wx_app_username;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.wx_app_path;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.wx_ext_msg;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num = this.wx_business_type;
        int hashCode7 = hashCode6 + (num != null ? num.hashCode() : 0);
        ((Message) this).hashCode = hashCode7;
        return hashCode7;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.wx_app_id = this.wx_app_id;
        builder.wx_universal_link = this.wx_universal_link;
        builder.wx_app_username = this.wx_app_username;
        builder.wx_app_path = this.wx_app_path;
        builder.wx_ext_msg = this.wx_ext_msg;
        builder.wx_business_type = this.wx_business_type;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.wx_app_id != null) {
            sb.append(", wx_app_id=");
            sb.append(this.wx_app_id);
        }
        if (this.wx_universal_link != null) {
            sb.append(", wx_universal_link=");
            sb.append(this.wx_universal_link);
        }
        if (this.wx_app_username != null) {
            sb.append(", wx_app_username=");
            sb.append(this.wx_app_username);
        }
        if (this.wx_app_path != null) {
            sb.append(", wx_app_path=");
            sb.append(this.wx_app_path);
        }
        if (this.wx_ext_msg != null) {
            sb.append(", wx_ext_msg=");
            sb.append(this.wx_ext_msg);
        }
        if (this.wx_business_type != null) {
            sb.append(", wx_business_type=");
            sb.append(this.wx_business_type);
        }
        StringBuilder replace = sb.replace(0, 2, "WXProgramRes{");
        replace.append('}');
        return replace.toString();
    }
}
