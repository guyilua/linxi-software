package com.sigmob.sdk.base.models;

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
public final class WebEvent extends AndroidMessage<WebEvent, Builder> {
    public static final ProtoAdapter<WebEvent> ADAPTER;
    public static final Parcelable.Creator<WebEvent> CREATOR;
    public static final String DEFAULT_EVENT_NAME = "";
    public static final String DEFAULT_EVENT_TYPE = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String event_name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String event_type;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class Builder extends Message.Builder<WebEvent, Builder> {
        public String event_type = "";
        public String event_name = "";

        public WebEvent build() {
            return new WebEvent(this.event_type, this.event_name, super.buildUnknownFields());
        }

        public Builder event_name(String str) {
            this.event_name = str;
            return this;
        }

        public Builder event_type(String str) {
            this.event_type = str;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class ProtoAdapter_WebEvent extends ProtoAdapter<WebEvent> {
        public ProtoAdapter_WebEvent() {
            super(FieldEncoding.LENGTH_DELIMITED, WebEvent.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public WebEvent m2decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.event_type((String) ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.event_name((String) ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, WebEvent webEvent) {
            ProtoAdapter protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, webEvent.event_type);
            protoAdapter.encodeWithTag(protoWriter, 2, webEvent.event_name);
            protoWriter.writeBytes(webEvent.unknownFields());
        }

        public int encodedSize(WebEvent webEvent) {
            ProtoAdapter protoAdapter = ProtoAdapter.STRING;
            return protoAdapter.encodedSizeWithTag(1, webEvent.event_type) + protoAdapter.encodedSizeWithTag(2, webEvent.event_name) + webEvent.unknownFields().size();
        }

        public WebEvent redact(WebEvent webEvent) {
            Builder newBuilder = webEvent.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_WebEvent protoAdapter_WebEvent = new ProtoAdapter_WebEvent();
        ADAPTER = protoAdapter_WebEvent;
        CREATOR = AndroidMessage.newCreator(protoAdapter_WebEvent);
    }

    public WebEvent(String str, String str2) {
        this(str, str2, ByteString.EMPTY);
    }

    public WebEvent(String str, String str2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.event_type = str;
        this.event_name = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WebEvent)) {
            return false;
        }
        WebEvent webEvent = (WebEvent) obj;
        return unknownFields().equals(webEvent.unknownFields()) && Internal.equals(this.event_type, webEvent.event_type) && Internal.equals(this.event_name, webEvent.event_name);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.event_type;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.event_name;
        int hashCode3 = hashCode2 + (str2 != null ? str2.hashCode() : 0);
        ((Message) this).hashCode = hashCode3;
        return hashCode3;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.event_type = this.event_type;
        builder.event_name = this.event_name;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.event_type != null) {
            sb.append(", event_type=");
            sb.append(this.event_type);
        }
        if (this.event_name != null) {
            sb.append(", event_name=");
            sb.append(this.event_name);
        }
        StringBuilder replace = sb.replace(0, 2, "WebEvent{");
        replace.append('}');
        return replace.toString();
    }
}
