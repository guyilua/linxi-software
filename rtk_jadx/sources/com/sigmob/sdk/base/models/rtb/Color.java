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
public final class Color extends AndroidMessage<Color, Builder> {
    public static final ProtoAdapter<Color> ADAPTER;
    public static final Parcelable.Creator<Color> CREATOR;
    public static final Float DEFAULT_ALPHA;
    public static final Integer DEFAULT_BLUE;
    public static final Integer DEFAULT_GREEN;
    public static final Integer DEFAULT_RED;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
    public final Float alpha;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer blue;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer green;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer red;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class Builder extends Message.Builder<Color, Builder> {
        public Integer red = Color.DEFAULT_RED;
        public Integer green = Color.DEFAULT_GREEN;
        public Integer blue = Color.DEFAULT_BLUE;
        public Float alpha = Color.DEFAULT_ALPHA;

        public Builder alpha(Float f) {
            this.alpha = f;
            return this;
        }

        public Builder blue(Integer num) {
            this.blue = num;
            return this;
        }

        public Color build() {
            return new Color(this.red, this.green, this.blue, this.alpha, super.buildUnknownFields());
        }

        public Builder green(Integer num) {
            this.green = num;
            return this;
        }

        public Builder red(Integer num) {
            this.red = num;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class ProtoAdapter_Color extends ProtoAdapter<Color> {
        public ProtoAdapter_Color() {
            super(FieldEncoding.LENGTH_DELIMITED, Color.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public Color m65decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.red((Integer) ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.green((Integer) ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.blue((Integer) ProtoAdapter.UINT32.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.alpha((Float) ProtoAdapter.FLOAT.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, Color color) {
            ProtoAdapter protoAdapter = ProtoAdapter.UINT32;
            protoAdapter.encodeWithTag(protoWriter, 1, color.red);
            protoAdapter.encodeWithTag(protoWriter, 2, color.green);
            protoAdapter.encodeWithTag(protoWriter, 3, color.blue);
            ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 4, color.alpha);
            protoWriter.writeBytes(color.unknownFields());
        }

        public int encodedSize(Color color) {
            ProtoAdapter protoAdapter = ProtoAdapter.UINT32;
            return protoAdapter.encodedSizeWithTag(1, color.red) + protoAdapter.encodedSizeWithTag(2, color.green) + protoAdapter.encodedSizeWithTag(3, color.blue) + ProtoAdapter.FLOAT.encodedSizeWithTag(4, color.alpha) + color.unknownFields().size();
        }

        public Color redact(Color color) {
            Builder newBuilder = color.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_Color protoAdapter_Color = new ProtoAdapter_Color();
        ADAPTER = protoAdapter_Color;
        CREATOR = AndroidMessage.newCreator(protoAdapter_Color);
        DEFAULT_RED = 0;
        DEFAULT_GREEN = 0;
        DEFAULT_BLUE = 0;
        DEFAULT_ALPHA = Float.valueOf(c.d);
    }

    public Color(Integer num, Integer num2, Integer num3, Float f) {
        this(num, num2, num3, f, ByteString.EMPTY);
    }

    public Color(Integer num, Integer num2, Integer num3, Float f, ByteString byteString) {
        super(ADAPTER, byteString);
        this.red = num;
        this.green = num2;
        this.blue = num3;
        this.alpha = f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Color)) {
            return false;
        }
        Color color = (Color) obj;
        return unknownFields().equals(color.unknownFields()) && Internal.equals(this.red, color.red) && Internal.equals(this.green, color.green) && Internal.equals(this.blue, color.blue) && Internal.equals(this.alpha, color.alpha);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.red;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.green;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.blue;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Float f = this.alpha;
        int hashCode5 = hashCode4 + (f != null ? f.hashCode() : 0);
        ((Message) this).hashCode = hashCode5;
        return hashCode5;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.red = this.red;
        builder.green = this.green;
        builder.blue = this.blue;
        builder.alpha = this.alpha;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.red != null) {
            sb.append(", red=");
            sb.append(this.red);
        }
        if (this.green != null) {
            sb.append(", green=");
            sb.append(this.green);
        }
        if (this.blue != null) {
            sb.append(", blue=");
            sb.append(this.blue);
        }
        if (this.alpha != null) {
            sb.append(", alpha=");
            sb.append(this.alpha);
        }
        StringBuilder replace = sb.replace(0, 2, "Color{");
        replace.append('}');
        return replace.toString();
    }
}
