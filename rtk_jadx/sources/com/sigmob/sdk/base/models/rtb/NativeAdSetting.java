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
public final class NativeAdSetting extends AndroidMessage<NativeAdSetting, Builder> {
    public static final ProtoAdapter<NativeAdSetting> ADAPTER;
    public static final Parcelable.Creator<NativeAdSetting> CREATOR;
    public static final Integer DEFAULT_AD_POOL_SIZE;
    public static final Integer DEFAULT_DETAIL_PAGE_VIDEO_MUTE;
    public static final Integer DEFAULT_END_IMPRESSION_TIME;
    public static final Integer DEFAULT_IMPRESSION_PERCENT;
    public static final Integer DEFAULT_IMPRESSION_TIME;
    public static final Integer DEFAULT_LOG_INTERVAL_TIME;
    public static final Integer DEFAULT_MEDIA_EXPECTED_FLOOR;
    public static final Integer DEFAULT_PREVIEW_PAGE_VIDEO_MUTE;
    public static final Integer DEFAULT_REQ_INTERVAL_TIME;
    public static final Integer DEFAULT_VIDEO_AUTO_PLAY;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 8)
    public final Integer ad_pool_size;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer detail_page_video_mute;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 6)
    public final Integer end_impression_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 4)
    public final Integer impression_percent;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 5)
    public final Integer impression_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 10)
    public final Integer log_interval_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 9)
    public final Integer media_expected_floor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer preview_page_video_mute;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 7)
    public final Integer req_interval_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer video_auto_play;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class Builder extends Message.Builder<NativeAdSetting, Builder> {
        public Integer video_auto_play = NativeAdSetting.DEFAULT_VIDEO_AUTO_PLAY;
        public Integer preview_page_video_mute = NativeAdSetting.DEFAULT_PREVIEW_PAGE_VIDEO_MUTE;
        public Integer detail_page_video_mute = NativeAdSetting.DEFAULT_DETAIL_PAGE_VIDEO_MUTE;
        public Integer impression_percent = NativeAdSetting.DEFAULT_IMPRESSION_PERCENT;
        public Integer impression_time = NativeAdSetting.DEFAULT_IMPRESSION_TIME;
        public Integer end_impression_time = NativeAdSetting.DEFAULT_END_IMPRESSION_TIME;
        public Integer req_interval_time = NativeAdSetting.DEFAULT_REQ_INTERVAL_TIME;
        public Integer ad_pool_size = NativeAdSetting.DEFAULT_AD_POOL_SIZE;
        public Integer media_expected_floor = NativeAdSetting.DEFAULT_MEDIA_EXPECTED_FLOOR;
        public Integer log_interval_time = NativeAdSetting.DEFAULT_LOG_INTERVAL_TIME;

        public Builder ad_pool_size(Integer num) {
            this.ad_pool_size = num;
            return this;
        }

        public NativeAdSetting build() {
            return new NativeAdSetting(this.video_auto_play, this.preview_page_video_mute, this.detail_page_video_mute, this.impression_percent, this.impression_time, this.end_impression_time, this.req_interval_time, this.ad_pool_size, this.media_expected_floor, this.log_interval_time, super.buildUnknownFields());
        }

        public Builder detail_page_video_mute(Integer num) {
            this.detail_page_video_mute = num;
            return this;
        }

        public Builder end_impression_time(Integer num) {
            this.end_impression_time = num;
            return this;
        }

        public Builder impression_percent(Integer num) {
            this.impression_percent = num;
            return this;
        }

        public Builder impression_time(Integer num) {
            this.impression_time = num;
            return this;
        }

        public Builder log_interval_time(Integer num) {
            this.log_interval_time = num;
            return this;
        }

        public Builder media_expected_floor(Integer num) {
            this.media_expected_floor = num;
            return this;
        }

        public Builder preview_page_video_mute(Integer num) {
            this.preview_page_video_mute = num;
            return this;
        }

        public Builder req_interval_time(Integer num) {
            this.req_interval_time = num;
            return this;
        }

        public Builder video_auto_play(Integer num) {
            this.video_auto_play = num;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class ProtoAdapter_NativeAdSetting extends ProtoAdapter<NativeAdSetting> {
        public ProtoAdapter_NativeAdSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, NativeAdSetting.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public NativeAdSetting m77decode(ProtoReader protoReader) {
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
                        builder.video_auto_play((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 2:
                        builder.preview_page_video_mute((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 3:
                        builder.detail_page_video_mute((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 4:
                        builder.impression_percent((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 5:
                        builder.impression_time((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 6:
                        builder.end_impression_time((Integer) ProtoAdapter.INT32.decode(protoReader));
                        break;
                    case 7:
                        builder.req_interval_time((Integer) ProtoAdapter.INT32.decode(protoReader));
                        break;
                    case 8:
                        builder.ad_pool_size((Integer) ProtoAdapter.INT32.decode(protoReader));
                        break;
                    case 9:
                        builder.media_expected_floor((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 10:
                        builder.log_interval_time((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    default:
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        break;
                }
            }
        }

        public void encode(ProtoWriter protoWriter, NativeAdSetting nativeAdSetting) {
            ProtoAdapter protoAdapter = ProtoAdapter.UINT32;
            protoAdapter.encodeWithTag(protoWriter, 1, nativeAdSetting.video_auto_play);
            protoAdapter.encodeWithTag(protoWriter, 2, nativeAdSetting.preview_page_video_mute);
            protoAdapter.encodeWithTag(protoWriter, 3, nativeAdSetting.detail_page_video_mute);
            protoAdapter.encodeWithTag(protoWriter, 4, nativeAdSetting.impression_percent);
            protoAdapter.encodeWithTag(protoWriter, 5, nativeAdSetting.impression_time);
            ProtoAdapter protoAdapter2 = ProtoAdapter.INT32;
            protoAdapter2.encodeWithTag(protoWriter, 6, nativeAdSetting.end_impression_time);
            protoAdapter2.encodeWithTag(protoWriter, 7, nativeAdSetting.req_interval_time);
            protoAdapter2.encodeWithTag(protoWriter, 8, nativeAdSetting.ad_pool_size);
            protoAdapter.encodeWithTag(protoWriter, 9, nativeAdSetting.media_expected_floor);
            protoAdapter.encodeWithTag(protoWriter, 10, nativeAdSetting.log_interval_time);
            protoWriter.writeBytes(nativeAdSetting.unknownFields());
        }

        public int encodedSize(NativeAdSetting nativeAdSetting) {
            ProtoAdapter protoAdapter = ProtoAdapter.UINT32;
            int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(1, nativeAdSetting.video_auto_play) + protoAdapter.encodedSizeWithTag(2, nativeAdSetting.preview_page_video_mute) + protoAdapter.encodedSizeWithTag(3, nativeAdSetting.detail_page_video_mute) + protoAdapter.encodedSizeWithTag(4, nativeAdSetting.impression_percent) + protoAdapter.encodedSizeWithTag(5, nativeAdSetting.impression_time);
            ProtoAdapter protoAdapter2 = ProtoAdapter.INT32;
            return encodedSizeWithTag + protoAdapter2.encodedSizeWithTag(6, nativeAdSetting.end_impression_time) + protoAdapter2.encodedSizeWithTag(7, nativeAdSetting.req_interval_time) + protoAdapter2.encodedSizeWithTag(8, nativeAdSetting.ad_pool_size) + protoAdapter.encodedSizeWithTag(9, nativeAdSetting.media_expected_floor) + protoAdapter.encodedSizeWithTag(10, nativeAdSetting.log_interval_time) + nativeAdSetting.unknownFields().size();
        }

        public NativeAdSetting redact(NativeAdSetting nativeAdSetting) {
            Builder newBuilder = nativeAdSetting.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_NativeAdSetting protoAdapter_NativeAdSetting = new ProtoAdapter_NativeAdSetting();
        ADAPTER = protoAdapter_NativeAdSetting;
        CREATOR = AndroidMessage.newCreator(protoAdapter_NativeAdSetting);
        DEFAULT_VIDEO_AUTO_PLAY = 0;
        DEFAULT_PREVIEW_PAGE_VIDEO_MUTE = 0;
        DEFAULT_DETAIL_PAGE_VIDEO_MUTE = 0;
        DEFAULT_IMPRESSION_PERCENT = 0;
        DEFAULT_IMPRESSION_TIME = 0;
        DEFAULT_END_IMPRESSION_TIME = 0;
        DEFAULT_REQ_INTERVAL_TIME = 0;
        DEFAULT_AD_POOL_SIZE = 0;
        DEFAULT_MEDIA_EXPECTED_FLOOR = 0;
        DEFAULT_LOG_INTERVAL_TIME = 0;
    }

    public NativeAdSetting(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10) {
        this(num, num2, num3, num4, num5, num6, num7, num8, num9, num10, ByteString.EMPTY);
    }

    public NativeAdSetting(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, ByteString byteString) {
        super(ADAPTER, byteString);
        this.video_auto_play = num;
        this.preview_page_video_mute = num2;
        this.detail_page_video_mute = num3;
        this.impression_percent = num4;
        this.impression_time = num5;
        this.end_impression_time = num6;
        this.req_interval_time = num7;
        this.ad_pool_size = num8;
        this.media_expected_floor = num9;
        this.log_interval_time = num10;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NativeAdSetting)) {
            return false;
        }
        NativeAdSetting nativeAdSetting = (NativeAdSetting) obj;
        return unknownFields().equals(nativeAdSetting.unknownFields()) && Internal.equals(this.video_auto_play, nativeAdSetting.video_auto_play) && Internal.equals(this.preview_page_video_mute, nativeAdSetting.preview_page_video_mute) && Internal.equals(this.detail_page_video_mute, nativeAdSetting.detail_page_video_mute) && Internal.equals(this.impression_percent, nativeAdSetting.impression_percent) && Internal.equals(this.impression_time, nativeAdSetting.impression_time) && Internal.equals(this.end_impression_time, nativeAdSetting.end_impression_time) && Internal.equals(this.req_interval_time, nativeAdSetting.req_interval_time) && Internal.equals(this.ad_pool_size, nativeAdSetting.ad_pool_size) && Internal.equals(this.media_expected_floor, nativeAdSetting.media_expected_floor) && Internal.equals(this.log_interval_time, nativeAdSetting.log_interval_time);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.video_auto_play;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.preview_page_video_mute;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.detail_page_video_mute;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.impression_percent;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.impression_time;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.end_impression_time;
        int hashCode7 = (hashCode6 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.req_interval_time;
        int hashCode8 = (hashCode7 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.ad_pool_size;
        int hashCode9 = (hashCode8 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.media_expected_floor;
        int hashCode10 = (hashCode9 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.log_interval_time;
        int hashCode11 = hashCode10 + (num10 != null ? num10.hashCode() : 0);
        ((Message) this).hashCode = hashCode11;
        return hashCode11;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.video_auto_play = this.video_auto_play;
        builder.preview_page_video_mute = this.preview_page_video_mute;
        builder.detail_page_video_mute = this.detail_page_video_mute;
        builder.impression_percent = this.impression_percent;
        builder.impression_time = this.impression_time;
        builder.end_impression_time = this.end_impression_time;
        builder.req_interval_time = this.req_interval_time;
        builder.ad_pool_size = this.ad_pool_size;
        builder.media_expected_floor = this.media_expected_floor;
        builder.log_interval_time = this.log_interval_time;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.video_auto_play != null) {
            sb.append(", video_auto_play=");
            sb.append(this.video_auto_play);
        }
        if (this.preview_page_video_mute != null) {
            sb.append(", preview_page_video_mute=");
            sb.append(this.preview_page_video_mute);
        }
        if (this.detail_page_video_mute != null) {
            sb.append(", detail_page_video_mute=");
            sb.append(this.detail_page_video_mute);
        }
        if (this.impression_percent != null) {
            sb.append(", impression_percent=");
            sb.append(this.impression_percent);
        }
        if (this.impression_time != null) {
            sb.append(", impression_time=");
            sb.append(this.impression_time);
        }
        if (this.end_impression_time != null) {
            sb.append(", end_impression_time=");
            sb.append(this.end_impression_time);
        }
        if (this.req_interval_time != null) {
            sb.append(", req_interval_time=");
            sb.append(this.req_interval_time);
        }
        if (this.ad_pool_size != null) {
            sb.append(", ad_pool_size=");
            sb.append(this.ad_pool_size);
        }
        if (this.media_expected_floor != null) {
            sb.append(", media_expected_floor=");
            sb.append(this.media_expected_floor);
        }
        if (this.log_interval_time != null) {
            sb.append(", log_interval_time=");
            sb.append(this.log_interval_time);
        }
        StringBuilder replace = sb.replace(0, 2, "NativeAdSetting{");
        replace.append('}');
        return replace.toString();
    }
}
