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
public final class InterstitialSetting extends AndroidMessage<InterstitialSetting, Builder> {
    public static final ProtoAdapter<InterstitialSetting> ADAPTER;
    public static final Parcelable.Creator<InterstitialSetting> CREATOR;
    public static final Integer DEFAULT_CHARGE_TIME;
    public static final Boolean DEFAULT_DISABLE_AUTO_LOAD;
    public static final Integer DEFAULT_ENDCARD_CLOSE_POSITION;
    public static final Integer DEFAULT_IF_MUTE;
    public static final Integer DEFAULT_MUTE_POSITION;
    public static final Integer DEFAULT_SHAKE_LEVEL;
    public static final Integer DEFAULT_SHOW_SKIP_SECONDS;
    public static final Boolean DEFAULT_SKIP_CLOSE_AD;
    public static final Integer DEFAULT_SKIP_POSITION;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 8)
    public final Integer charge_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 9)
    public final Boolean disable_auto_load;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 5)
    public final Integer endcard_close_position;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer if_mute;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 6)
    public final Integer mute_position;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 7)
    public final Integer shake_level;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer show_skip_seconds;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 3)
    public final Boolean skip_close_ad;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 4)
    public final Integer skip_position;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class Builder extends Message.Builder<InterstitialSetting, Builder> {
        public Integer if_mute = InterstitialSetting.DEFAULT_IF_MUTE;
        public Integer show_skip_seconds = InterstitialSetting.DEFAULT_SHOW_SKIP_SECONDS;
        public Boolean skip_close_ad = InterstitialSetting.DEFAULT_SKIP_CLOSE_AD;
        public Integer skip_position = InterstitialSetting.DEFAULT_SKIP_POSITION;
        public Integer endcard_close_position = InterstitialSetting.DEFAULT_ENDCARD_CLOSE_POSITION;
        public Integer mute_position = InterstitialSetting.DEFAULT_MUTE_POSITION;
        public Integer shake_level = InterstitialSetting.DEFAULT_SHAKE_LEVEL;
        public Integer charge_time = InterstitialSetting.DEFAULT_CHARGE_TIME;
        public Boolean disable_auto_load = InterstitialSetting.DEFAULT_DISABLE_AUTO_LOAD;

        public InterstitialSetting build() {
            return new InterstitialSetting(this.if_mute, this.show_skip_seconds, this.skip_close_ad, this.skip_position, this.endcard_close_position, this.mute_position, this.shake_level, this.charge_time, this.disable_auto_load, super.buildUnknownFields());
        }

        public Builder charge_time(Integer num) {
            this.charge_time = num;
            return this;
        }

        public Builder disable_auto_load(Boolean bool) {
            this.disable_auto_load = bool;
            return this;
        }

        public Builder endcard_close_position(Integer num) {
            this.endcard_close_position = num;
            return this;
        }

        public Builder if_mute(Integer num) {
            this.if_mute = num;
            return this;
        }

        public Builder mute_position(Integer num) {
            this.mute_position = num;
            return this;
        }

        public Builder shake_level(Integer num) {
            this.shake_level = num;
            return this;
        }

        public Builder show_skip_seconds(Integer num) {
            this.show_skip_seconds = num;
            return this;
        }

        public Builder skip_close_ad(Boolean bool) {
            this.skip_close_ad = bool;
            return this;
        }

        public Builder skip_position(Integer num) {
            this.skip_position = num;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class ProtoAdapter_InterstitialSetting extends ProtoAdapter<InterstitialSetting> {
        public ProtoAdapter_InterstitialSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, InterstitialSetting.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public InterstitialSetting m71decode(ProtoReader protoReader) {
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
                        builder.if_mute((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 2:
                        builder.show_skip_seconds((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 3:
                        builder.skip_close_ad((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 4:
                        builder.skip_position((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 5:
                        builder.endcard_close_position((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 6:
                        builder.mute_position((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 7:
                        builder.shake_level((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 8:
                        builder.charge_time((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 9:
                        builder.disable_auto_load((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    default:
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        break;
                }
            }
        }

        public void encode(ProtoWriter protoWriter, InterstitialSetting interstitialSetting) {
            ProtoAdapter protoAdapter = ProtoAdapter.UINT32;
            protoAdapter.encodeWithTag(protoWriter, 1, interstitialSetting.if_mute);
            protoAdapter.encodeWithTag(protoWriter, 2, interstitialSetting.show_skip_seconds);
            ProtoAdapter protoAdapter2 = ProtoAdapter.BOOL;
            protoAdapter2.encodeWithTag(protoWriter, 3, interstitialSetting.skip_close_ad);
            protoAdapter.encodeWithTag(protoWriter, 4, interstitialSetting.skip_position);
            protoAdapter.encodeWithTag(protoWriter, 5, interstitialSetting.endcard_close_position);
            protoAdapter.encodeWithTag(protoWriter, 6, interstitialSetting.mute_position);
            protoAdapter.encodeWithTag(protoWriter, 7, interstitialSetting.shake_level);
            protoAdapter.encodeWithTag(protoWriter, 8, interstitialSetting.charge_time);
            protoAdapter2.encodeWithTag(protoWriter, 9, interstitialSetting.disable_auto_load);
            protoWriter.writeBytes(interstitialSetting.unknownFields());
        }

        public int encodedSize(InterstitialSetting interstitialSetting) {
            ProtoAdapter protoAdapter = ProtoAdapter.UINT32;
            int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(1, interstitialSetting.if_mute) + protoAdapter.encodedSizeWithTag(2, interstitialSetting.show_skip_seconds);
            ProtoAdapter protoAdapter2 = ProtoAdapter.BOOL;
            return encodedSizeWithTag + protoAdapter2.encodedSizeWithTag(3, interstitialSetting.skip_close_ad) + protoAdapter.encodedSizeWithTag(4, interstitialSetting.skip_position) + protoAdapter.encodedSizeWithTag(5, interstitialSetting.endcard_close_position) + protoAdapter.encodedSizeWithTag(6, interstitialSetting.mute_position) + protoAdapter.encodedSizeWithTag(7, interstitialSetting.shake_level) + protoAdapter.encodedSizeWithTag(8, interstitialSetting.charge_time) + protoAdapter2.encodedSizeWithTag(9, interstitialSetting.disable_auto_load) + interstitialSetting.unknownFields().size();
        }

        public InterstitialSetting redact(InterstitialSetting interstitialSetting) {
            Builder newBuilder = interstitialSetting.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_InterstitialSetting protoAdapter_InterstitialSetting = new ProtoAdapter_InterstitialSetting();
        ADAPTER = protoAdapter_InterstitialSetting;
        CREATOR = AndroidMessage.newCreator(protoAdapter_InterstitialSetting);
        DEFAULT_IF_MUTE = 0;
        DEFAULT_SHOW_SKIP_SECONDS = 0;
        Boolean bool = Boolean.FALSE;
        DEFAULT_SKIP_CLOSE_AD = bool;
        DEFAULT_SKIP_POSITION = 3;
        DEFAULT_ENDCARD_CLOSE_POSITION = 3;
        DEFAULT_MUTE_POSITION = 1;
        DEFAULT_SHAKE_LEVEL = 0;
        DEFAULT_CHARGE_TIME = 5;
        DEFAULT_DISABLE_AUTO_LOAD = bool;
    }

    public InterstitialSetting(Integer num, Integer num2, Boolean bool, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Boolean bool2) {
        this(num, num2, bool, num3, num4, num5, num6, num7, bool2, ByteString.EMPTY);
    }

    public InterstitialSetting(Integer num, Integer num2, Boolean bool, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Boolean bool2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.if_mute = num;
        this.show_skip_seconds = num2;
        this.skip_close_ad = bool;
        this.skip_position = num3;
        this.endcard_close_position = num4;
        this.mute_position = num5;
        this.shake_level = num6;
        this.charge_time = num7;
        this.disable_auto_load = bool2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InterstitialSetting)) {
            return false;
        }
        InterstitialSetting interstitialSetting = (InterstitialSetting) obj;
        return unknownFields().equals(interstitialSetting.unknownFields()) && Internal.equals(this.if_mute, interstitialSetting.if_mute) && Internal.equals(this.show_skip_seconds, interstitialSetting.show_skip_seconds) && Internal.equals(this.skip_close_ad, interstitialSetting.skip_close_ad) && Internal.equals(this.skip_position, interstitialSetting.skip_position) && Internal.equals(this.endcard_close_position, interstitialSetting.endcard_close_position) && Internal.equals(this.mute_position, interstitialSetting.mute_position) && Internal.equals(this.shake_level, interstitialSetting.shake_level) && Internal.equals(this.charge_time, interstitialSetting.charge_time) && Internal.equals(this.disable_auto_load, interstitialSetting.disable_auto_load);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.if_mute;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.show_skip_seconds;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Boolean bool = this.skip_close_ad;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num3 = this.skip_position;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.endcard_close_position;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.mute_position;
        int hashCode7 = (hashCode6 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.shake_level;
        int hashCode8 = (hashCode7 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.charge_time;
        int hashCode9 = (hashCode8 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Boolean bool2 = this.disable_auto_load;
        int hashCode10 = hashCode9 + (bool2 != null ? bool2.hashCode() : 0);
        ((Message) this).hashCode = hashCode10;
        return hashCode10;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.if_mute = this.if_mute;
        builder.show_skip_seconds = this.show_skip_seconds;
        builder.skip_close_ad = this.skip_close_ad;
        builder.skip_position = this.skip_position;
        builder.endcard_close_position = this.endcard_close_position;
        builder.mute_position = this.mute_position;
        builder.shake_level = this.shake_level;
        builder.charge_time = this.charge_time;
        builder.disable_auto_load = this.disable_auto_load;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.if_mute != null) {
            sb.append(", if_mute=");
            sb.append(this.if_mute);
        }
        if (this.show_skip_seconds != null) {
            sb.append(", show_skip_seconds=");
            sb.append(this.show_skip_seconds);
        }
        if (this.skip_close_ad != null) {
            sb.append(", skip_close_ad=");
            sb.append(this.skip_close_ad);
        }
        if (this.skip_position != null) {
            sb.append(", skip_position=");
            sb.append(this.skip_position);
        }
        if (this.endcard_close_position != null) {
            sb.append(", endcard_close_position=");
            sb.append(this.endcard_close_position);
        }
        if (this.mute_position != null) {
            sb.append(", mute_position=");
            sb.append(this.mute_position);
        }
        if (this.shake_level != null) {
            sb.append(", shake_level=");
            sb.append(this.shake_level);
        }
        if (this.charge_time != null) {
            sb.append(", charge_time=");
            sb.append(this.charge_time);
        }
        if (this.disable_auto_load != null) {
            sb.append(", disable_auto_load=");
            sb.append(this.disable_auto_load);
        }
        StringBuilder replace = sb.replace(0, 2, "InterstitialSetting{");
        replace.append('}');
        return replace.toString();
    }
}
