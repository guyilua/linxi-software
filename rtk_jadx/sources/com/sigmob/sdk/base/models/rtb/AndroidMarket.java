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
public final class AndroidMarket extends AndroidMessage<AndroidMarket, Builder> {
    public static final ProtoAdapter<AndroidMarket> ADAPTER;
    public static final Parcelable.Creator<AndroidMarket> CREATOR;
    public static final String DEFAULT_APPSTORE_PACKAGE_NAME = "";
    public static final String DEFAULT_APP_PACKAGE_NAME = "";
    public static final String DEFAULT_MARKET_URL = "";
    public static final Integer DEFAULT_TYPE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String app_package_name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String appstore_package_name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String market_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 4)
    public final Integer type;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class Builder extends Message.Builder<AndroidMarket, Builder> {
        public String app_package_name;
        public String appstore_package_name;
        public String market_url;
        public Integer type;

        public Builder app_package_name(String str) {
            this.app_package_name = str;
            return this;
        }

        public Builder appstore_package_name(String str) {
            this.appstore_package_name = str;
            return this;
        }

        public AndroidMarket build() {
            return new AndroidMarket(this.market_url, this.app_package_name, this.appstore_package_name, this.type, super.buildUnknownFields());
        }

        public Builder market_url(String str) {
            this.market_url = str;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class ProtoAdapter_AndroidMarket extends ProtoAdapter<AndroidMarket> {
        public ProtoAdapter_AndroidMarket() {
            super(FieldEncoding.LENGTH_DELIMITED, AndroidMarket.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public AndroidMarket m53decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.market_url((String) ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.app_package_name((String) ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.appstore_package_name((String) ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.type((Integer) ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, AndroidMarket androidMarket) {
            ProtoAdapter protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, androidMarket.market_url);
            protoAdapter.encodeWithTag(protoWriter, 2, androidMarket.app_package_name);
            protoAdapter.encodeWithTag(protoWriter, 3, androidMarket.appstore_package_name);
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 4, androidMarket.type);
            protoWriter.writeBytes(androidMarket.unknownFields());
        }

        public int encodedSize(AndroidMarket androidMarket) {
            ProtoAdapter protoAdapter = ProtoAdapter.STRING;
            return protoAdapter.encodedSizeWithTag(1, androidMarket.market_url) + protoAdapter.encodedSizeWithTag(2, androidMarket.app_package_name) + protoAdapter.encodedSizeWithTag(3, androidMarket.appstore_package_name) + ProtoAdapter.UINT32.encodedSizeWithTag(4, androidMarket.type) + androidMarket.unknownFields().size();
        }

        public AndroidMarket redact(AndroidMarket androidMarket) {
            Builder newBuilder = androidMarket.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_AndroidMarket protoAdapter_AndroidMarket = new ProtoAdapter_AndroidMarket();
        ADAPTER = protoAdapter_AndroidMarket;
        CREATOR = AndroidMessage.newCreator(protoAdapter_AndroidMarket);
        DEFAULT_TYPE = 0;
    }

    public AndroidMarket(String str, String str2, String str3, Integer num) {
        this(str, str2, str3, num, ByteString.EMPTY);
    }

    public AndroidMarket(String str, String str2, String str3, Integer num, ByteString byteString) {
        super(ADAPTER, byteString);
        this.market_url = str;
        this.app_package_name = str2;
        this.appstore_package_name = str3;
        this.type = num;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AndroidMarket)) {
            return false;
        }
        AndroidMarket androidMarket = (AndroidMarket) obj;
        return unknownFields().equals(androidMarket.unknownFields()) && Internal.equals(this.market_url, androidMarket.market_url) && Internal.equals(this.app_package_name, androidMarket.app_package_name) && Internal.equals(this.appstore_package_name, androidMarket.appstore_package_name) && Internal.equals(this.type, androidMarket.type);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.market_url;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.app_package_name;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.appstore_package_name;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num = this.type;
        int hashCode5 = hashCode4 + (num != null ? num.hashCode() : 0);
        ((Message) this).hashCode = hashCode5;
        return hashCode5;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.market_url = this.market_url;
        builder.app_package_name = this.app_package_name;
        builder.appstore_package_name = this.appstore_package_name;
        builder.type = this.type;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.market_url != null) {
            sb.append(", market_url=");
            sb.append(this.market_url);
        }
        if (this.app_package_name != null) {
            sb.append(", app_package_name=");
            sb.append(this.app_package_name);
        }
        if (this.appstore_package_name != null) {
            sb.append(", appstore_package_name=");
            sb.append(this.appstore_package_name);
        }
        if (this.type != null) {
            sb.append(", type=");
            sb.append(this.type);
        }
        StringBuilder replace = sb.replace(0, 2, "AndroidMarket{");
        replace.append('}');
        return replace.toString();
    }
}
