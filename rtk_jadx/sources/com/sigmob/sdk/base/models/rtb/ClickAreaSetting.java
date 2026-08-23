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
import com.sigmob.sdk.base.blurkit.c;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class ClickAreaSetting extends AndroidMessage<ClickAreaSetting, Builder> {
    public static final ProtoAdapter<ClickAreaSetting> ADAPTER;
    public static final Parcelable.Creator<ClickAreaSetting> CREATOR;
    public static final Float DEFAULT_BOTTOM;
    public static final Float DEFAULT_LEFT;
    public static final Float DEFAULT_RIGHT;
    public static final Float DEFAULT_TOP;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
    public final Float bottom;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
    public final Float left;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
    public final Float right;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
    public final Float top;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class Builder extends Message.Builder<ClickAreaSetting, Builder> {
        public Float top = ClickAreaSetting.DEFAULT_TOP;
        public Float left = ClickAreaSetting.DEFAULT_LEFT;
        public Float bottom = ClickAreaSetting.DEFAULT_BOTTOM;
        public Float right = ClickAreaSetting.DEFAULT_RIGHT;

        public Builder bottom(Float f) {
            this.bottom = f;
            return this;
        }

        public ClickAreaSetting build() {
            return new ClickAreaSetting(this.top, this.left, this.bottom, this.right, super.buildUnknownFields());
        }

        public Builder left(Float f) {
            this.left = f;
            return this;
        }

        public Builder right(Float f) {
            this.right = f;
            return this;
        }

        public Builder top(Float f) {
            this.top = f;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class ProtoAdapter_ClickAreaSetting extends ProtoAdapter<ClickAreaSetting> {
        public ProtoAdapter_ClickAreaSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, ClickAreaSetting.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public ClickAreaSetting m62decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.top((Float) ProtoAdapter.FLOAT.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.left((Float) ProtoAdapter.FLOAT.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.bottom((Float) ProtoAdapter.FLOAT.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.right((Float) ProtoAdapter.FLOAT.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, ClickAreaSetting clickAreaSetting) {
            ProtoAdapter protoAdapter = ProtoAdapter.FLOAT;
            protoAdapter.encodeWithTag(protoWriter, 1, clickAreaSetting.top);
            protoAdapter.encodeWithTag(protoWriter, 2, clickAreaSetting.left);
            protoAdapter.encodeWithTag(protoWriter, 3, clickAreaSetting.bottom);
            protoAdapter.encodeWithTag(protoWriter, 4, clickAreaSetting.right);
            protoWriter.writeBytes(clickAreaSetting.unknownFields());
        }

        public int encodedSize(ClickAreaSetting clickAreaSetting) {
            ProtoAdapter protoAdapter = ProtoAdapter.FLOAT;
            return protoAdapter.encodedSizeWithTag(1, clickAreaSetting.top) + protoAdapter.encodedSizeWithTag(2, clickAreaSetting.left) + protoAdapter.encodedSizeWithTag(3, clickAreaSetting.bottom) + protoAdapter.encodedSizeWithTag(4, clickAreaSetting.right) + clickAreaSetting.unknownFields().size();
        }

        public ClickAreaSetting redact(ClickAreaSetting clickAreaSetting) {
            Builder newBuilder = clickAreaSetting.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_ClickAreaSetting protoAdapter_ClickAreaSetting = new ProtoAdapter_ClickAreaSetting();
        ADAPTER = protoAdapter_ClickAreaSetting;
        CREATOR = AndroidMessage.newCreator(protoAdapter_ClickAreaSetting);
        Float valueOf = Float.valueOf(c.d);
        DEFAULT_TOP = valueOf;
        DEFAULT_LEFT = valueOf;
        DEFAULT_BOTTOM = valueOf;
        DEFAULT_RIGHT = valueOf;
    }

    public ClickAreaSetting(Float f, Float f2, Float f3, Float f4) {
        this(f, f2, f3, f4, ByteString.EMPTY);
    }

    public ClickAreaSetting(Float f, Float f2, Float f3, Float f4, ByteString byteString) {
        super(ADAPTER, byteString);
        this.top = f;
        this.left = f2;
        this.bottom = f3;
        this.right = f4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClickAreaSetting)) {
            return false;
        }
        ClickAreaSetting clickAreaSetting = (ClickAreaSetting) obj;
        return unknownFields().equals(clickAreaSetting.unknownFields()) && Internal.equals(this.top, clickAreaSetting.top) && Internal.equals(this.left, clickAreaSetting.left) && Internal.equals(this.bottom, clickAreaSetting.bottom) && Internal.equals(this.right, clickAreaSetting.right);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Float f = this.top;
        int hashCode2 = (hashCode + (f != null ? f.hashCode() : 0)) * 37;
        Float f2 = this.left;
        int hashCode3 = (hashCode2 + (f2 != null ? f2.hashCode() : 0)) * 37;
        Float f3 = this.bottom;
        int hashCode4 = (hashCode3 + (f3 != null ? f3.hashCode() : 0)) * 37;
        Float f4 = this.right;
        int hashCode5 = hashCode4 + (f4 != null ? f4.hashCode() : 0);
        ((Message) this).hashCode = hashCode5;
        return hashCode5;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.top = this.top;
        builder.left = this.left;
        builder.bottom = this.bottom;
        builder.right = this.right;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.top != null) {
            sb.append(", top=");
            sb.append(this.top);
        }
        if (this.left != null) {
            sb.append(", left=");
            sb.append(this.left);
        }
        if (this.bottom != null) {
            sb.append(", bottom=");
            sb.append(this.bottom);
        }
        if (this.right != null) {
            sb.append(", right=");
            sb.append(this.right);
        }
        StringBuilder replace = sb.replace(0, 2, "ClickAreaSetting{");
        replace.append('}');
        return replace.toString();
    }
}
