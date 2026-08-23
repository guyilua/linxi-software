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
public final class Tracking extends AndroidMessage<Tracking, Builder> {
    public static final ProtoAdapter<Tracking> ADAPTER;
    public static final Parcelable.Creator<Tracking> CREATOR;
    public static final String DEFAULT_TRACKING_EVENT_TYPE = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String tracking_event_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 2)
    public final List<String> tracking_url;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class Builder extends Message.Builder<Tracking, Builder> {
        public String tracking_event_type = "";
        public List<String> tracking_url = Internal.newMutableList();

        public Tracking build() {
            return new Tracking(this.tracking_event_type, this.tracking_url, super.buildUnknownFields());
        }

        public Builder tracking_event_type(String str) {
            this.tracking_event_type = str;
            return this;
        }

        public Builder tracking_url(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.tracking_url = list;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class ProtoAdapter_Tracking extends ProtoAdapter<Tracking> {
        public ProtoAdapter_Tracking() {
            super(FieldEncoding.LENGTH_DELIMITED, Tracking.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public Tracking m110decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.tracking_event_type((String) ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.tracking_url.add((String) ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, Tracking tracking) {
            ProtoAdapter protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, tracking.tracking_event_type);
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 2, tracking.tracking_url);
            protoWriter.writeBytes(tracking.unknownFields());
        }

        public int encodedSize(Tracking tracking) {
            ProtoAdapter protoAdapter = ProtoAdapter.STRING;
            return protoAdapter.encodedSizeWithTag(1, tracking.tracking_event_type) + protoAdapter.asRepeated().encodedSizeWithTag(2, tracking.tracking_url) + tracking.unknownFields().size();
        }

        public Tracking redact(Tracking tracking) {
            Builder newBuilder = tracking.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_Tracking protoAdapter_Tracking = new ProtoAdapter_Tracking();
        ADAPTER = protoAdapter_Tracking;
        CREATOR = AndroidMessage.newCreator(protoAdapter_Tracking);
    }

    public Tracking(String str, List<String> list) {
        this(str, list, ByteString.EMPTY);
    }

    public Tracking(String str, List<String> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.tracking_event_type = str;
        this.tracking_url = Internal.immutableCopyOf("tracking_url", list);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Tracking)) {
            return false;
        }
        Tracking tracking = (Tracking) obj;
        return unknownFields().equals(tracking.unknownFields()) && Internal.equals(this.tracking_event_type, tracking.tracking_event_type) && this.tracking_url.equals(tracking.tracking_url);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.tracking_event_type;
        int hashCode2 = ((hashCode + (str != null ? str.hashCode() : 0)) * 37) + this.tracking_url.hashCode();
        ((Message) this).hashCode = hashCode2;
        return hashCode2;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.tracking_event_type = this.tracking_event_type;
        builder.tracking_url = Internal.copyOf("tracking_url", this.tracking_url);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.tracking_event_type != null) {
            sb.append(", tracking_event_type=");
            sb.append(this.tracking_event_type);
        }
        if (!this.tracking_url.isEmpty()) {
            sb.append(", tracking_url=");
            sb.append(this.tracking_url);
        }
        StringBuilder replace = sb.replace(0, 2, "Tracking{");
        replace.append('}');
        return replace.toString();
    }
}
