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
public final class RvAdSetting extends AndroidMessage<RvAdSetting, Builder> {
    public static final ProtoAdapter<RvAdSetting> ADAPTER;
    public static final Parcelable.Creator<RvAdSetting> CREATOR;
    public static final Integer DEFAULT_CHARGE_PERCENT;
    public static final Integer DEFAULT_CHARGE_SECONDS;
    public static final Integer DEFAULT_CONFIRM_DIALOG;
    public static final Boolean DEFAULT_DISABLE_AUTO_LOAD;
    public static final Boolean DEFAULT_ENABLE_EXIT_ON_VIDEO_CLOSE;
    public static final Integer DEFAULT_ENDCARD_CLOSE_IMAGE;
    public static final Integer DEFAULT_ENDCARD_CLOSE_POSITION;
    public static final Integer DEFAULT_END_IMPRESSION_TIME;
    public static final Integer DEFAULT_END_TIME;
    public static final Float DEFAULT_FINISHED;
    public static final Boolean DEFAULT_FULL_CLICK_ON_VIDEO;
    public static final Integer DEFAULT_IF_MUTE;
    public static final Boolean DEFAULT_INVISIBLE_AD_LABEL;
    public static final Integer DEFAULT_MUTE_POSTION;
    public static final Integer DEFAULT_REWARD_PERCENT;
    public static final Integer DEFAULT_REWARD_SECONDS;
    public static final Integer DEFAULT_REWARD_STYLE;
    public static final Integer DEFAULT_SKIP_PERCENT;
    public static final Integer DEFAULT_SKIP_SECONDS;
    public static final Integer DEFAULT_VIDEO_CLOSE_POSITION;
    public static final Boolean DEFAULT_VIDEO_ERROR_REWARD;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 17)
    public final Integer charge_percent;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 16)
    public final Integer charge_seconds;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.ClickAreaSetting#ADAPTER", tag = 10)
    public final ClickAreaSetting click_setting;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 20)
    public final Integer confirm_dialog;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 15)
    public final Boolean disable_auto_load;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 8)
    public final Boolean enable_exit_on_video_close;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 14)
    public final Integer end_impression_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 12)
    public final Integer end_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 13)
    public final Integer endcard_close_image;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer endcard_close_position;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
    public final Float finished;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 9)
    public final Boolean full_click_on_video;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer if_mute;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 11)
    public final Boolean invisible_ad_label;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    public final Integer mute_postion;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 19)
    public final Integer reward_percent;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 18)
    public final Integer reward_seconds;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 21)
    public final Integer reward_style;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 6)
    public final Integer skip_percent;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 7)
    public final Integer skip_seconds;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer video_close_position;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 22)
    public final Boolean video_error_reward;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class Builder extends Message.Builder<RvAdSetting, Builder> {
        public ClickAreaSetting click_setting;
        public Integer skip_seconds;
        public Integer if_mute = RvAdSetting.DEFAULT_IF_MUTE;
        public Float finished = RvAdSetting.DEFAULT_FINISHED;
        public Integer video_close_position = RvAdSetting.DEFAULT_VIDEO_CLOSE_POSITION;
        public Integer endcard_close_position = RvAdSetting.DEFAULT_ENDCARD_CLOSE_POSITION;
        public Integer mute_postion = RvAdSetting.DEFAULT_MUTE_POSTION;
        public Integer skip_percent = RvAdSetting.DEFAULT_SKIP_PERCENT;
        public Boolean enable_exit_on_video_close = RvAdSetting.DEFAULT_ENABLE_EXIT_ON_VIDEO_CLOSE;
        public Boolean full_click_on_video = RvAdSetting.DEFAULT_FULL_CLICK_ON_VIDEO;
        public Boolean invisible_ad_label = RvAdSetting.DEFAULT_INVISIBLE_AD_LABEL;
        public Integer end_time = RvAdSetting.DEFAULT_END_TIME;
        public Integer endcard_close_image = RvAdSetting.DEFAULT_ENDCARD_CLOSE_IMAGE;
        public Integer end_impression_time = RvAdSetting.DEFAULT_END_IMPRESSION_TIME;
        public Boolean disable_auto_load = RvAdSetting.DEFAULT_DISABLE_AUTO_LOAD;
        public Integer charge_seconds = RvAdSetting.DEFAULT_CHARGE_SECONDS;
        public Integer charge_percent = RvAdSetting.DEFAULT_CHARGE_PERCENT;
        public Integer reward_seconds = RvAdSetting.DEFAULT_REWARD_SECONDS;
        public Integer reward_percent = RvAdSetting.DEFAULT_REWARD_PERCENT;
        public Integer confirm_dialog = RvAdSetting.DEFAULT_CONFIRM_DIALOG;
        public Integer reward_style = RvAdSetting.DEFAULT_REWARD_STYLE;
        public Boolean video_error_reward = RvAdSetting.DEFAULT_VIDEO_ERROR_REWARD;

        public RvAdSetting build() {
            return new RvAdSetting(this.if_mute, this.finished, this.video_close_position, this.endcard_close_position, this.mute_postion, this.skip_percent, this.skip_seconds, this.enable_exit_on_video_close, this.full_click_on_video, this.click_setting, this.invisible_ad_label, this.end_time, this.endcard_close_image, this.end_impression_time, this.disable_auto_load, this.charge_seconds, this.charge_percent, this.reward_seconds, this.reward_percent, this.confirm_dialog, this.reward_style, this.video_error_reward, super.buildUnknownFields());
        }

        public Builder charge_percent(Integer num) {
            this.charge_percent = num;
            return this;
        }

        public Builder charge_seconds(Integer num) {
            this.charge_seconds = num;
            return this;
        }

        public Builder click_setting(ClickAreaSetting clickAreaSetting) {
            this.click_setting = clickAreaSetting;
            return this;
        }

        public Builder confirm_dialog(Integer num) {
            this.confirm_dialog = num;
            return this;
        }

        public Builder disable_auto_load(Boolean bool) {
            this.disable_auto_load = bool;
            return this;
        }

        public Builder enable_exit_on_video_close(Boolean bool) {
            this.enable_exit_on_video_close = bool;
            return this;
        }

        public Builder end_impression_time(Integer num) {
            this.end_impression_time = num;
            return this;
        }

        public Builder end_time(Integer num) {
            this.end_time = num;
            return this;
        }

        public Builder endcard_close_image(Integer num) {
            this.endcard_close_image = num;
            return this;
        }

        public Builder endcard_close_position(Integer num) {
            this.endcard_close_position = num;
            return this;
        }

        public Builder finished(Float f) {
            this.finished = f;
            return this;
        }

        public Builder full_click_on_video(Boolean bool) {
            this.full_click_on_video = bool;
            return this;
        }

        public Builder if_mute(Integer num) {
            this.if_mute = num;
            return this;
        }

        public Builder invisible_ad_label(Boolean bool) {
            this.invisible_ad_label = bool;
            return this;
        }

        public Builder mute_postion(Integer num) {
            this.mute_postion = num;
            return this;
        }

        public Builder reward_percent(Integer num) {
            this.reward_percent = num;
            return this;
        }

        public Builder reward_seconds(Integer num) {
            this.reward_seconds = num;
            return this;
        }

        public Builder reward_style(Integer num) {
            this.reward_style = num;
            return this;
        }

        public Builder skip_percent(Integer num) {
            this.skip_percent = num;
            return this;
        }

        public Builder skip_seconds(Integer num) {
            this.skip_seconds = num;
            return this;
        }

        public Builder video_close_position(Integer num) {
            this.video_close_position = num;
            return this;
        }

        public Builder video_error_reward(Boolean bool) {
            this.video_error_reward = bool;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class ProtoAdapter_RvAdSetting extends ProtoAdapter<RvAdSetting> {
        public ProtoAdapter_RvAdSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, RvAdSetting.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public RvAdSetting m95decode(ProtoReader protoReader) {
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
                        builder.if_mute((Integer) ProtoAdapter.INT32.decode(protoReader));
                        break;
                    case 2:
                        builder.finished((Float) ProtoAdapter.FLOAT.decode(protoReader));
                        break;
                    case 3:
                        builder.video_close_position((Integer) ProtoAdapter.INT32.decode(protoReader));
                        break;
                    case 4:
                        builder.endcard_close_position((Integer) ProtoAdapter.INT32.decode(protoReader));
                        break;
                    case 5:
                        builder.mute_postion((Integer) ProtoAdapter.INT32.decode(protoReader));
                        break;
                    case 6:
                        builder.skip_percent((Integer) ProtoAdapter.INT32.decode(protoReader));
                        break;
                    case 7:
                        builder.skip_seconds((Integer) ProtoAdapter.INT32.decode(protoReader));
                        break;
                    case 8:
                        builder.enable_exit_on_video_close((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 9:
                        builder.full_click_on_video((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 10:
                        builder.click_setting((ClickAreaSetting) ClickAreaSetting.ADAPTER.decode(protoReader));
                        break;
                    case 11:
                        builder.invisible_ad_label((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 12:
                        builder.end_time((Integer) ProtoAdapter.INT32.decode(protoReader));
                        break;
                    case 13:
                        builder.endcard_close_image((Integer) ProtoAdapter.INT32.decode(protoReader));
                        break;
                    case 14:
                        builder.end_impression_time((Integer) ProtoAdapter.INT32.decode(protoReader));
                        break;
                    case 15:
                        builder.disable_auto_load((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 16:
                        builder.charge_seconds((Integer) ProtoAdapter.INT32.decode(protoReader));
                        break;
                    case 17:
                        builder.charge_percent((Integer) ProtoAdapter.INT32.decode(protoReader));
                        break;
                    case 18:
                        builder.reward_seconds((Integer) ProtoAdapter.INT32.decode(protoReader));
                        break;
                    case 19:
                        builder.reward_percent((Integer) ProtoAdapter.INT32.decode(protoReader));
                        break;
                    case 20:
                        builder.confirm_dialog((Integer) ProtoAdapter.INT32.decode(protoReader));
                        break;
                    case 21:
                        builder.reward_style((Integer) ProtoAdapter.INT32.decode(protoReader));
                        break;
                    case 22:
                        builder.video_error_reward((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    default:
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        break;
                }
            }
        }

        public void encode(ProtoWriter protoWriter, RvAdSetting rvAdSetting) {
            ProtoAdapter protoAdapter = ProtoAdapter.INT32;
            protoAdapter.encodeWithTag(protoWriter, 1, rvAdSetting.if_mute);
            ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 2, rvAdSetting.finished);
            protoAdapter.encodeWithTag(protoWriter, 3, rvAdSetting.video_close_position);
            protoAdapter.encodeWithTag(protoWriter, 4, rvAdSetting.endcard_close_position);
            protoAdapter.encodeWithTag(protoWriter, 5, rvAdSetting.mute_postion);
            protoAdapter.encodeWithTag(protoWriter, 6, rvAdSetting.skip_percent);
            protoAdapter.encodeWithTag(protoWriter, 7, rvAdSetting.skip_seconds);
            ProtoAdapter protoAdapter2 = ProtoAdapter.BOOL;
            protoAdapter2.encodeWithTag(protoWriter, 8, rvAdSetting.enable_exit_on_video_close);
            protoAdapter2.encodeWithTag(protoWriter, 9, rvAdSetting.full_click_on_video);
            ClickAreaSetting.ADAPTER.encodeWithTag(protoWriter, 10, rvAdSetting.click_setting);
            protoAdapter2.encodeWithTag(protoWriter, 11, rvAdSetting.invisible_ad_label);
            protoAdapter.encodeWithTag(protoWriter, 12, rvAdSetting.end_time);
            protoAdapter.encodeWithTag(protoWriter, 13, rvAdSetting.endcard_close_image);
            protoAdapter.encodeWithTag(protoWriter, 14, rvAdSetting.end_impression_time);
            protoAdapter2.encodeWithTag(protoWriter, 15, rvAdSetting.disable_auto_load);
            protoAdapter.encodeWithTag(protoWriter, 16, rvAdSetting.charge_seconds);
            protoAdapter.encodeWithTag(protoWriter, 17, rvAdSetting.charge_percent);
            protoAdapter.encodeWithTag(protoWriter, 18, rvAdSetting.reward_seconds);
            protoAdapter.encodeWithTag(protoWriter, 19, rvAdSetting.reward_percent);
            protoAdapter.encodeWithTag(protoWriter, 20, rvAdSetting.confirm_dialog);
            protoAdapter.encodeWithTag(protoWriter, 21, rvAdSetting.reward_style);
            protoAdapter2.encodeWithTag(protoWriter, 22, rvAdSetting.video_error_reward);
            protoWriter.writeBytes(rvAdSetting.unknownFields());
        }

        public int encodedSize(RvAdSetting rvAdSetting) {
            ProtoAdapter protoAdapter = ProtoAdapter.INT32;
            int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(1, rvAdSetting.if_mute) + ProtoAdapter.FLOAT.encodedSizeWithTag(2, rvAdSetting.finished) + protoAdapter.encodedSizeWithTag(3, rvAdSetting.video_close_position) + protoAdapter.encodedSizeWithTag(4, rvAdSetting.endcard_close_position) + protoAdapter.encodedSizeWithTag(5, rvAdSetting.mute_postion) + protoAdapter.encodedSizeWithTag(6, rvAdSetting.skip_percent) + protoAdapter.encodedSizeWithTag(7, rvAdSetting.skip_seconds);
            ProtoAdapter protoAdapter2 = ProtoAdapter.BOOL;
            return encodedSizeWithTag + protoAdapter2.encodedSizeWithTag(8, rvAdSetting.enable_exit_on_video_close) + protoAdapter2.encodedSizeWithTag(9, rvAdSetting.full_click_on_video) + ClickAreaSetting.ADAPTER.encodedSizeWithTag(10, rvAdSetting.click_setting) + protoAdapter2.encodedSizeWithTag(11, rvAdSetting.invisible_ad_label) + protoAdapter.encodedSizeWithTag(12, rvAdSetting.end_time) + protoAdapter.encodedSizeWithTag(13, rvAdSetting.endcard_close_image) + protoAdapter.encodedSizeWithTag(14, rvAdSetting.end_impression_time) + protoAdapter2.encodedSizeWithTag(15, rvAdSetting.disable_auto_load) + protoAdapter.encodedSizeWithTag(16, rvAdSetting.charge_seconds) + protoAdapter.encodedSizeWithTag(17, rvAdSetting.charge_percent) + protoAdapter.encodedSizeWithTag(18, rvAdSetting.reward_seconds) + protoAdapter.encodedSizeWithTag(19, rvAdSetting.reward_percent) + protoAdapter.encodedSizeWithTag(20, rvAdSetting.confirm_dialog) + protoAdapter.encodedSizeWithTag(21, rvAdSetting.reward_style) + protoAdapter2.encodedSizeWithTag(22, rvAdSetting.video_error_reward) + rvAdSetting.unknownFields().size();
        }

        public RvAdSetting redact(RvAdSetting rvAdSetting) {
            Builder newBuilder = rvAdSetting.newBuilder();
            ClickAreaSetting clickAreaSetting = newBuilder.click_setting;
            if (clickAreaSetting != null) {
                newBuilder.click_setting = (ClickAreaSetting) ClickAreaSetting.ADAPTER.redact(clickAreaSetting);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_RvAdSetting protoAdapter_RvAdSetting = new ProtoAdapter_RvAdSetting();
        ADAPTER = protoAdapter_RvAdSetting;
        CREATOR = AndroidMessage.newCreator(protoAdapter_RvAdSetting);
        DEFAULT_IF_MUTE = 0;
        DEFAULT_FINISHED = Float.valueOf(c.d);
        DEFAULT_VIDEO_CLOSE_POSITION = 0;
        DEFAULT_ENDCARD_CLOSE_POSITION = 0;
        DEFAULT_MUTE_POSTION = 0;
        DEFAULT_SKIP_PERCENT = 0;
        DEFAULT_SKIP_SECONDS = 0;
        Boolean bool = Boolean.FALSE;
        DEFAULT_ENABLE_EXIT_ON_VIDEO_CLOSE = bool;
        DEFAULT_FULL_CLICK_ON_VIDEO = bool;
        DEFAULT_INVISIBLE_AD_LABEL = bool;
        DEFAULT_END_TIME = 0;
        DEFAULT_ENDCARD_CLOSE_IMAGE = 0;
        DEFAULT_END_IMPRESSION_TIME = 0;
        DEFAULT_DISABLE_AUTO_LOAD = bool;
        DEFAULT_CHARGE_SECONDS = 0;
        DEFAULT_CHARGE_PERCENT = 0;
        DEFAULT_REWARD_SECONDS = 0;
        DEFAULT_REWARD_PERCENT = 0;
        DEFAULT_CONFIRM_DIALOG = 0;
        DEFAULT_REWARD_STYLE = 0;
        DEFAULT_VIDEO_ERROR_REWARD = bool;
    }

    public RvAdSetting(Integer num, Float f, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Boolean bool, Boolean bool2, ClickAreaSetting clickAreaSetting, Boolean bool3, Integer num7, Integer num8, Integer num9, Boolean bool4, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Boolean bool5) {
        this(num, f, num2, num3, num4, num5, num6, bool, bool2, clickAreaSetting, bool3, num7, num8, num9, bool4, num10, num11, num12, num13, num14, num15, bool5, ByteString.EMPTY);
    }

    public RvAdSetting(Integer num, Float f, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Boolean bool, Boolean bool2, ClickAreaSetting clickAreaSetting, Boolean bool3, Integer num7, Integer num8, Integer num9, Boolean bool4, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Boolean bool5, ByteString byteString) {
        super(ADAPTER, byteString);
        this.if_mute = num;
        this.finished = f;
        this.video_close_position = num2;
        this.endcard_close_position = num3;
        this.mute_postion = num4;
        this.skip_percent = num5;
        this.skip_seconds = num6;
        this.enable_exit_on_video_close = bool;
        this.full_click_on_video = bool2;
        this.click_setting = clickAreaSetting;
        this.invisible_ad_label = bool3;
        this.end_time = num7;
        this.endcard_close_image = num8;
        this.end_impression_time = num9;
        this.disable_auto_load = bool4;
        this.charge_seconds = num10;
        this.charge_percent = num11;
        this.reward_seconds = num12;
        this.reward_percent = num13;
        this.confirm_dialog = num14;
        this.reward_style = num15;
        this.video_error_reward = bool5;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RvAdSetting)) {
            return false;
        }
        RvAdSetting rvAdSetting = (RvAdSetting) obj;
        return unknownFields().equals(rvAdSetting.unknownFields()) && Internal.equals(this.if_mute, rvAdSetting.if_mute) && Internal.equals(this.finished, rvAdSetting.finished) && Internal.equals(this.video_close_position, rvAdSetting.video_close_position) && Internal.equals(this.endcard_close_position, rvAdSetting.endcard_close_position) && Internal.equals(this.mute_postion, rvAdSetting.mute_postion) && Internal.equals(this.skip_percent, rvAdSetting.skip_percent) && Internal.equals(this.skip_seconds, rvAdSetting.skip_seconds) && Internal.equals(this.enable_exit_on_video_close, rvAdSetting.enable_exit_on_video_close) && Internal.equals(this.full_click_on_video, rvAdSetting.full_click_on_video) && Internal.equals(this.click_setting, rvAdSetting.click_setting) && Internal.equals(this.invisible_ad_label, rvAdSetting.invisible_ad_label) && Internal.equals(this.end_time, rvAdSetting.end_time) && Internal.equals(this.endcard_close_image, rvAdSetting.endcard_close_image) && Internal.equals(this.end_impression_time, rvAdSetting.end_impression_time) && Internal.equals(this.disable_auto_load, rvAdSetting.disable_auto_load) && Internal.equals(this.charge_seconds, rvAdSetting.charge_seconds) && Internal.equals(this.charge_percent, rvAdSetting.charge_percent) && Internal.equals(this.reward_seconds, rvAdSetting.reward_seconds) && Internal.equals(this.reward_percent, rvAdSetting.reward_percent) && Internal.equals(this.confirm_dialog, rvAdSetting.confirm_dialog) && Internal.equals(this.reward_style, rvAdSetting.reward_style) && Internal.equals(this.video_error_reward, rvAdSetting.video_error_reward);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.if_mute;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Float f = this.finished;
        int hashCode3 = (hashCode2 + (f != null ? f.hashCode() : 0)) * 37;
        Integer num2 = this.video_close_position;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.endcard_close_position;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.mute_postion;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.skip_percent;
        int hashCode7 = (hashCode6 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.skip_seconds;
        int hashCode8 = (hashCode7 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Boolean bool = this.enable_exit_on_video_close;
        int hashCode9 = (hashCode8 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.full_click_on_video;
        int hashCode10 = (hashCode9 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        ClickAreaSetting clickAreaSetting = this.click_setting;
        int hashCode11 = (hashCode10 + (clickAreaSetting != null ? clickAreaSetting.hashCode() : 0)) * 37;
        Boolean bool3 = this.invisible_ad_label;
        int hashCode12 = (hashCode11 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Integer num7 = this.end_time;
        int hashCode13 = (hashCode12 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.endcard_close_image;
        int hashCode14 = (hashCode13 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.end_impression_time;
        int hashCode15 = (hashCode14 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Boolean bool4 = this.disable_auto_load;
        int hashCode16 = (hashCode15 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Integer num10 = this.charge_seconds;
        int hashCode17 = (hashCode16 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.charge_percent;
        int hashCode18 = (hashCode17 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.reward_seconds;
        int hashCode19 = (hashCode18 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Integer num13 = this.reward_percent;
        int hashCode20 = (hashCode19 + (num13 != null ? num13.hashCode() : 0)) * 37;
        Integer num14 = this.confirm_dialog;
        int hashCode21 = (hashCode20 + (num14 != null ? num14.hashCode() : 0)) * 37;
        Integer num15 = this.reward_style;
        int hashCode22 = (hashCode21 + (num15 != null ? num15.hashCode() : 0)) * 37;
        Boolean bool5 = this.video_error_reward;
        int hashCode23 = hashCode22 + (bool5 != null ? bool5.hashCode() : 0);
        ((Message) this).hashCode = hashCode23;
        return hashCode23;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.if_mute = this.if_mute;
        builder.finished = this.finished;
        builder.video_close_position = this.video_close_position;
        builder.endcard_close_position = this.endcard_close_position;
        builder.mute_postion = this.mute_postion;
        builder.skip_percent = this.skip_percent;
        builder.skip_seconds = this.skip_seconds;
        builder.enable_exit_on_video_close = this.enable_exit_on_video_close;
        builder.full_click_on_video = this.full_click_on_video;
        builder.click_setting = this.click_setting;
        builder.invisible_ad_label = this.invisible_ad_label;
        builder.end_time = this.end_time;
        builder.endcard_close_image = this.endcard_close_image;
        builder.end_impression_time = this.end_impression_time;
        builder.disable_auto_load = this.disable_auto_load;
        builder.charge_seconds = this.charge_seconds;
        builder.charge_percent = this.charge_percent;
        builder.reward_seconds = this.reward_seconds;
        builder.reward_percent = this.reward_percent;
        builder.confirm_dialog = this.confirm_dialog;
        builder.reward_style = this.reward_style;
        builder.video_error_reward = this.video_error_reward;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.if_mute != null) {
            sb.append(", if_mute=");
            sb.append(this.if_mute);
        }
        if (this.finished != null) {
            sb.append(", finished=");
            sb.append(this.finished);
        }
        if (this.video_close_position != null) {
            sb.append(", video_close_position=");
            sb.append(this.video_close_position);
        }
        if (this.endcard_close_position != null) {
            sb.append(", endcard_close_position=");
            sb.append(this.endcard_close_position);
        }
        if (this.mute_postion != null) {
            sb.append(", mute_postion=");
            sb.append(this.mute_postion);
        }
        if (this.skip_percent != null) {
            sb.append(", skip_percent=");
            sb.append(this.skip_percent);
        }
        if (this.skip_seconds != null) {
            sb.append(", skip_seconds=");
            sb.append(this.skip_seconds);
        }
        if (this.enable_exit_on_video_close != null) {
            sb.append(", enable_exit_on_video_close=");
            sb.append(this.enable_exit_on_video_close);
        }
        if (this.full_click_on_video != null) {
            sb.append(", full_click_on_video=");
            sb.append(this.full_click_on_video);
        }
        if (this.click_setting != null) {
            sb.append(", click_setting=");
            sb.append(this.click_setting);
        }
        if (this.invisible_ad_label != null) {
            sb.append(", invisible_ad_label=");
            sb.append(this.invisible_ad_label);
        }
        if (this.end_time != null) {
            sb.append(", end_time=");
            sb.append(this.end_time);
        }
        if (this.endcard_close_image != null) {
            sb.append(", endcard_close_image=");
            sb.append(this.endcard_close_image);
        }
        if (this.end_impression_time != null) {
            sb.append(", end_impression_time=");
            sb.append(this.end_impression_time);
        }
        if (this.disable_auto_load != null) {
            sb.append(", disable_auto_load=");
            sb.append(this.disable_auto_load);
        }
        if (this.charge_seconds != null) {
            sb.append(", charge_seconds=");
            sb.append(this.charge_seconds);
        }
        if (this.charge_percent != null) {
            sb.append(", charge_percent=");
            sb.append(this.charge_percent);
        }
        if (this.reward_seconds != null) {
            sb.append(", reward_seconds=");
            sb.append(this.reward_seconds);
        }
        if (this.reward_percent != null) {
            sb.append(", reward_percent=");
            sb.append(this.reward_percent);
        }
        if (this.confirm_dialog != null) {
            sb.append(", confirm_dialog=");
            sb.append(this.confirm_dialog);
        }
        if (this.reward_style != null) {
            sb.append(", reward_style=");
            sb.append(this.reward_style);
        }
        if (this.video_error_reward != null) {
            sb.append(", video_error_reward=");
            sb.append(this.video_error_reward);
        }
        StringBuilder replace = sb.replace(0, 2, "RvAdSetting{");
        replace.append('}');
        return replace.toString();
    }
}
