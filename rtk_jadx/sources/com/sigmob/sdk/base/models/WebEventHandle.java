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
import com.umeng.analytics.pro.d;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class WebEventHandle extends AndroidMessage<WebEventHandle, Builder> {
    public static final ProtoAdapter<WebEventHandle> ADAPTER;
    public static final Parcelable.Creator<WebEventHandle> CREATOR;
    public static final Integer DEFAULT_HANDLE_TYPE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "WebEvent#ADAPTER", label = WireField.Label.REPEATED, tag = 3)
    public final List<WebEvent> events;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 2)
    public final List<String> handle_name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer handle_type;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class Builder extends Message.Builder<WebEventHandle, Builder> {
        public Integer handle_type = WebEventHandle.DEFAULT_HANDLE_TYPE;
        public List<String> handle_name = Internal.newMutableList();
        public List<WebEvent> events = Internal.newMutableList();

        public WebEventHandle build() {
            return new WebEventHandle(this.handle_type, this.handle_name, this.events, super.buildUnknownFields());
        }

        public Builder events(List<WebEvent> list) {
            Internal.checkElementsNotNull(list);
            this.events = list;
            return this;
        }

        public Builder handle_name(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.handle_name = list;
            return this;
        }

        public Builder handle_type(Integer num) {
            this.handle_type = num;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class ProtoAdapter_WebEventHandle extends ProtoAdapter<WebEventHandle> {
        public ProtoAdapter_WebEventHandle() {
            super(FieldEncoding.LENGTH_DELIMITED, WebEventHandle.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public WebEventHandle m5decode(ProtoReader protoReader) {
            List list;
            Object obj;
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag != 1) {
                    if (nextTag == 2) {
                        list = builder.handle_name;
                        obj = (String) ProtoAdapter.STRING.decode(protoReader);
                    } else if (nextTag != 3) {
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                    } else {
                        list = builder.events;
                        obj = (WebEvent) WebEvent.ADAPTER.decode(protoReader);
                    }
                    list.add(obj);
                } else {
                    builder.handle_type((Integer) ProtoAdapter.UINT32.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, WebEventHandle webEventHandle) {
            ProtoAdapter.UINT32.encodeWithTag(protoWriter, 1, webEventHandle.handle_type);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 2, webEventHandle.handle_name);
            WebEvent.ADAPTER.asRepeated().encodeWithTag(protoWriter, 3, webEventHandle.events);
            protoWriter.writeBytes(webEventHandle.unknownFields());
        }

        public int encodedSize(WebEventHandle webEventHandle) {
            return ProtoAdapter.UINT32.encodedSizeWithTag(1, webEventHandle.handle_type) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, webEventHandle.handle_name) + WebEvent.ADAPTER.asRepeated().encodedSizeWithTag(3, webEventHandle.events) + webEventHandle.unknownFields().size();
        }

        public WebEventHandle redact(WebEventHandle webEventHandle) {
            Builder newBuilder = webEventHandle.newBuilder();
            Internal.redactElements(newBuilder.events, WebEvent.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_WebEventHandle protoAdapter_WebEventHandle = new ProtoAdapter_WebEventHandle();
        ADAPTER = protoAdapter_WebEventHandle;
        CREATOR = AndroidMessage.newCreator(protoAdapter_WebEventHandle);
        DEFAULT_HANDLE_TYPE = 0;
    }

    public WebEventHandle(Integer num, List<String> list, List<WebEvent> list2) {
        this(num, list, list2, ByteString.EMPTY);
    }

    public WebEventHandle(Integer num, List<String> list, List<WebEvent> list2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.handle_type = num;
        this.handle_name = Internal.immutableCopyOf("handle_name", list);
        this.events = Internal.immutableCopyOf(d.ar, list2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WebEventHandle)) {
            return false;
        }
        WebEventHandle webEventHandle = (WebEventHandle) obj;
        return unknownFields().equals(webEventHandle.unknownFields()) && Internal.equals(this.handle_type, webEventHandle.handle_type) && this.handle_name.equals(webEventHandle.handle_name) && this.events.equals(webEventHandle.events);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.handle_type;
        int hashCode2 = ((((hashCode + (num != null ? num.hashCode() : 0)) * 37) + this.handle_name.hashCode()) * 37) + this.events.hashCode();
        ((Message) this).hashCode = hashCode2;
        return hashCode2;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.handle_type = this.handle_type;
        builder.handle_name = Internal.copyOf("handle_name", this.handle_name);
        builder.events = Internal.copyOf(d.ar, this.events);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.handle_type != null) {
            sb.append(", handle_type=");
            sb.append(this.handle_type);
        }
        if (!this.handle_name.isEmpty()) {
            sb.append(", handle_name=");
            sb.append(this.handle_name);
        }
        if (!this.events.isEmpty()) {
            sb.append(", events=");
            sb.append(this.events);
        }
        StringBuilder replace = sb.replace(0, 2, "WebEventHandle{");
        replace.append('}');
        return replace.toString();
    }
}
