package com.sigmob.sdk.base.models.config;

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
public final class SigmobCommon extends AndroidMessage<SigmobCommon, Builder> {
    public static final ProtoAdapter<SigmobCommon> ADAPTER;
    public static final Parcelable.Creator<SigmobCommon> CREATOR;
    public static final Integer DEFAULT_CONFIGREFRESH;
    public static final Boolean DEFAULT_DISABLE_UP_LOCATION;
    public static final Boolean DEFAULT_ENABLE_DEBUG_LEVEL;
    public static final Boolean DEFAULT_ENABLE_EXTRA_DCLOG;
    public static final Boolean DEFAULT_FEEDBACK_DEBUG;
    public static final Boolean DEFAULT_IS_GDPR_REGION;
    public static final Integer DEFAULT_LOAD_INTERVAL;
    public static final Boolean DEFAULT_LOG_ENC;
    public static final Integer DEFAULT_MAX_SEND_LOG_RECORDS;
    public static final Integer DEFAULT_NETWORK_TIMEOUT;
    public static final Integer DEFAULT_SEND_LOG_INTERVAL;
    public static final Integer DEFAULT_TRACKING_EXPIRATION_TIME;
    public static final Integer DEFAULT_TRACKING_RETRY_INTERVAL;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.sigmob.sdk.base.models.config.SigmobAntiFraudLogConfig#ADAPTER", tag = 7)
    public final SigmobAntiFraudLogConfig anti_fraud_log;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 6)
    public final Integer configRefresh;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", label = WireField.Label.REPEATED, tag = 13)
    public final List<Integer> dclog_blacklist;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 16)
    public final Boolean disable_up_location;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 14)
    public final Boolean enable_debug_level;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 19)
    public final Boolean enable_extra_dclog;

    @WireField(adapter = "com.sigmob.sdk.base.models.config.SigmobCommonEndpointsConfig#ADAPTER", tag = 1)
    public final SigmobCommonEndpointsConfig endpoints;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 18)
    public final Boolean feedback_debug;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 8)
    public final Boolean is_gdpr_region;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 15)
    public final Integer load_interval;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 17)
    public final Boolean log_enc;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 11)
    public final Integer max_send_log_records;

    @WireField(adapter = "com.sigmob.sdk.base.models.config.SigmobNativeConfig#ADAPTER", tag = 4)
    public final SigmobNativeConfig native_config;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 20)
    public final Integer network_timeout;

    @WireField(adapter = "com.sigmob.sdk.base.models.config.SigmobRvConfig#ADAPTER", tag = 2)
    public final SigmobRvConfig rv_config;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 12)
    public final Integer send_log_interval;

    @WireField(adapter = "com.sigmob.sdk.base.models.config.SigmobSplashConfig#ADAPTER", tag = 3)
    public final SigmobSplashConfig splash_config;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 9)
    public final Integer tracking_expiration_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 10)
    public final Integer tracking_retry_interval;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class Builder extends Message.Builder<SigmobCommon, Builder> {
        public SigmobAntiFraudLogConfig anti_fraud_log;
        public Integer configRefresh;
        public List<Integer> dclog_blacklist = Internal.newMutableList();
        public Boolean disable_up_location;
        public Boolean enable_debug_level;
        public Boolean enable_extra_dclog;
        public SigmobCommonEndpointsConfig endpoints;
        public Boolean feedback_debug;
        public Boolean is_gdpr_region;
        public Integer load_interval;
        public Boolean log_enc;
        public Integer max_send_log_records;
        public SigmobNativeConfig native_config;
        public Integer network_timeout;
        public SigmobRvConfig rv_config;
        public Integer send_log_interval;
        public SigmobSplashConfig splash_config;
        public Integer tracking_expiration_time;
        public Integer tracking_retry_interval;

        public Builder anti_fraud_log(SigmobAntiFraudLogConfig sigmobAntiFraudLogConfig) {
            this.anti_fraud_log = sigmobAntiFraudLogConfig;
            return this;
        }

        public SigmobCommon build() {
            return new SigmobCommon(this.endpoints, this.rv_config, this.splash_config, this.native_config, this.configRefresh, this.anti_fraud_log, this.is_gdpr_region, this.tracking_expiration_time, this.tracking_retry_interval, this.max_send_log_records, this.send_log_interval, this.dclog_blacklist, this.enable_debug_level, this.load_interval, this.disable_up_location, this.log_enc, this.feedback_debug, this.enable_extra_dclog, this.network_timeout, super.buildUnknownFields());
        }

        public Builder configRefresh(Integer num) {
            this.configRefresh = num;
            return this;
        }

        public Builder dclog_blacklist(List<Integer> list) {
            Internal.checkElementsNotNull(list);
            this.dclog_blacklist = list;
            return this;
        }

        public Builder disable_up_location(Boolean bool) {
            this.disable_up_location = bool;
            return this;
        }

        public Builder enable_debug_level(Boolean bool) {
            this.enable_debug_level = bool;
            return this;
        }

        public Builder enable_extra_dclog(Boolean bool) {
            this.enable_extra_dclog = bool;
            return this;
        }

        public Builder endpoints(SigmobCommonEndpointsConfig sigmobCommonEndpointsConfig) {
            this.endpoints = sigmobCommonEndpointsConfig;
            return this;
        }

        public Builder feedback_debug(Boolean bool) {
            this.feedback_debug = bool;
            return this;
        }

        public Builder is_gdpr_region(Boolean bool) {
            this.is_gdpr_region = bool;
            return this;
        }

        public Builder load_interval(Integer num) {
            this.load_interval = num;
            return this;
        }

        public Builder log_enc(Boolean bool) {
            this.log_enc = bool;
            return this;
        }

        public Builder max_send_log_records(Integer num) {
            this.max_send_log_records = num;
            return this;
        }

        public Builder native_config(SigmobNativeConfig sigmobNativeConfig) {
            this.native_config = sigmobNativeConfig;
            return this;
        }

        public Builder network_timeout(Integer num) {
            this.network_timeout = num;
            return this;
        }

        public Builder rv_config(SigmobRvConfig sigmobRvConfig) {
            this.rv_config = sigmobRvConfig;
            return this;
        }

        public Builder send_log_interval(Integer num) {
            this.send_log_interval = num;
            return this;
        }

        public Builder splash_config(SigmobSplashConfig sigmobSplashConfig) {
            this.splash_config = sigmobSplashConfig;
            return this;
        }

        public Builder tracking_expiration_time(Integer num) {
            this.tracking_expiration_time = num;
            return this;
        }

        public Builder tracking_retry_interval(Integer num) {
            this.tracking_retry_interval = num;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class ProtoAdapter_SigmobCommon extends ProtoAdapter<SigmobCommon> {
        public ProtoAdapter_SigmobCommon() {
            super(FieldEncoding.LENGTH_DELIMITED, SigmobCommon.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public SigmobCommon m14decode(ProtoReader protoReader) {
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
                        builder.endpoints((SigmobCommonEndpointsConfig) SigmobCommonEndpointsConfig.ADAPTER.decode(protoReader));
                        break;
                    case 2:
                        builder.rv_config((SigmobRvConfig) SigmobRvConfig.ADAPTER.decode(protoReader));
                        break;
                    case 3:
                        builder.splash_config((SigmobSplashConfig) SigmobSplashConfig.ADAPTER.decode(protoReader));
                        break;
                    case 4:
                        builder.native_config((SigmobNativeConfig) SigmobNativeConfig.ADAPTER.decode(protoReader));
                        break;
                    case 5:
                    default:
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        break;
                    case 6:
                        builder.configRefresh((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 7:
                        builder.anti_fraud_log((SigmobAntiFraudLogConfig) SigmobAntiFraudLogConfig.ADAPTER.decode(protoReader));
                        break;
                    case 8:
                        builder.is_gdpr_region((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 9:
                        builder.tracking_expiration_time((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 10:
                        builder.tracking_retry_interval((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 11:
                        builder.max_send_log_records((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 12:
                        builder.send_log_interval((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 13:
                        builder.dclog_blacklist.add((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 14:
                        builder.enable_debug_level((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 15:
                        builder.load_interval((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 16:
                        builder.disable_up_location((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 17:
                        builder.log_enc((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 18:
                        builder.feedback_debug((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 19:
                        builder.enable_extra_dclog((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 20:
                        builder.network_timeout((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                }
            }
        }

        public void encode(ProtoWriter protoWriter, SigmobCommon sigmobCommon) {
            SigmobCommonEndpointsConfig.ADAPTER.encodeWithTag(protoWriter, 1, sigmobCommon.endpoints);
            SigmobRvConfig.ADAPTER.encodeWithTag(protoWriter, 2, sigmobCommon.rv_config);
            SigmobSplashConfig.ADAPTER.encodeWithTag(protoWriter, 3, sigmobCommon.splash_config);
            SigmobNativeConfig.ADAPTER.encodeWithTag(protoWriter, 4, sigmobCommon.native_config);
            ProtoAdapter protoAdapter = ProtoAdapter.UINT32;
            protoAdapter.encodeWithTag(protoWriter, 6, sigmobCommon.configRefresh);
            SigmobAntiFraudLogConfig.ADAPTER.encodeWithTag(protoWriter, 7, sigmobCommon.anti_fraud_log);
            ProtoAdapter protoAdapter2 = ProtoAdapter.BOOL;
            protoAdapter2.encodeWithTag(protoWriter, 8, sigmobCommon.is_gdpr_region);
            protoAdapter.encodeWithTag(protoWriter, 9, sigmobCommon.tracking_expiration_time);
            protoAdapter.encodeWithTag(protoWriter, 10, sigmobCommon.tracking_retry_interval);
            protoAdapter.encodeWithTag(protoWriter, 11, sigmobCommon.max_send_log_records);
            protoAdapter.encodeWithTag(protoWriter, 12, sigmobCommon.send_log_interval);
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 13, sigmobCommon.dclog_blacklist);
            protoAdapter2.encodeWithTag(protoWriter, 14, sigmobCommon.enable_debug_level);
            protoAdapter.encodeWithTag(protoWriter, 15, sigmobCommon.load_interval);
            protoAdapter2.encodeWithTag(protoWriter, 16, sigmobCommon.disable_up_location);
            protoAdapter2.encodeWithTag(protoWriter, 17, sigmobCommon.log_enc);
            protoAdapter2.encodeWithTag(protoWriter, 18, sigmobCommon.feedback_debug);
            protoAdapter2.encodeWithTag(protoWriter, 19, sigmobCommon.enable_extra_dclog);
            protoAdapter.encodeWithTag(protoWriter, 20, sigmobCommon.network_timeout);
            protoWriter.writeBytes(sigmobCommon.unknownFields());
        }

        public int encodedSize(SigmobCommon sigmobCommon) {
            int encodedSizeWithTag = SigmobCommonEndpointsConfig.ADAPTER.encodedSizeWithTag(1, sigmobCommon.endpoints) + SigmobRvConfig.ADAPTER.encodedSizeWithTag(2, sigmobCommon.rv_config) + SigmobSplashConfig.ADAPTER.encodedSizeWithTag(3, sigmobCommon.splash_config) + SigmobNativeConfig.ADAPTER.encodedSizeWithTag(4, sigmobCommon.native_config);
            ProtoAdapter protoAdapter = ProtoAdapter.UINT32;
            int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter.encodedSizeWithTag(6, sigmobCommon.configRefresh) + SigmobAntiFraudLogConfig.ADAPTER.encodedSizeWithTag(7, sigmobCommon.anti_fraud_log);
            ProtoAdapter protoAdapter2 = ProtoAdapter.BOOL;
            return encodedSizeWithTag2 + protoAdapter2.encodedSizeWithTag(8, sigmobCommon.is_gdpr_region) + protoAdapter.encodedSizeWithTag(9, sigmobCommon.tracking_expiration_time) + protoAdapter.encodedSizeWithTag(10, sigmobCommon.tracking_retry_interval) + protoAdapter.encodedSizeWithTag(11, sigmobCommon.max_send_log_records) + protoAdapter.encodedSizeWithTag(12, sigmobCommon.send_log_interval) + protoAdapter.asRepeated().encodedSizeWithTag(13, sigmobCommon.dclog_blacklist) + protoAdapter2.encodedSizeWithTag(14, sigmobCommon.enable_debug_level) + protoAdapter.encodedSizeWithTag(15, sigmobCommon.load_interval) + protoAdapter2.encodedSizeWithTag(16, sigmobCommon.disable_up_location) + protoAdapter2.encodedSizeWithTag(17, sigmobCommon.log_enc) + protoAdapter2.encodedSizeWithTag(18, sigmobCommon.feedback_debug) + protoAdapter2.encodedSizeWithTag(19, sigmobCommon.enable_extra_dclog) + protoAdapter.encodedSizeWithTag(20, sigmobCommon.network_timeout) + sigmobCommon.unknownFields().size();
        }

        public SigmobCommon redact(SigmobCommon sigmobCommon) {
            Builder newBuilder = sigmobCommon.newBuilder();
            SigmobCommonEndpointsConfig sigmobCommonEndpointsConfig = newBuilder.endpoints;
            if (sigmobCommonEndpointsConfig != null) {
                newBuilder.endpoints = (SigmobCommonEndpointsConfig) SigmobCommonEndpointsConfig.ADAPTER.redact(sigmobCommonEndpointsConfig);
            }
            SigmobRvConfig sigmobRvConfig = newBuilder.rv_config;
            if (sigmobRvConfig != null) {
                newBuilder.rv_config = (SigmobRvConfig) SigmobRvConfig.ADAPTER.redact(sigmobRvConfig);
            }
            SigmobSplashConfig sigmobSplashConfig = newBuilder.splash_config;
            if (sigmobSplashConfig != null) {
                newBuilder.splash_config = (SigmobSplashConfig) SigmobSplashConfig.ADAPTER.redact(sigmobSplashConfig);
            }
            SigmobNativeConfig sigmobNativeConfig = newBuilder.native_config;
            if (sigmobNativeConfig != null) {
                newBuilder.native_config = (SigmobNativeConfig) SigmobNativeConfig.ADAPTER.redact(sigmobNativeConfig);
            }
            SigmobAntiFraudLogConfig sigmobAntiFraudLogConfig = newBuilder.anti_fraud_log;
            if (sigmobAntiFraudLogConfig != null) {
                newBuilder.anti_fraud_log = (SigmobAntiFraudLogConfig) SigmobAntiFraudLogConfig.ADAPTER.redact(sigmobAntiFraudLogConfig);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_SigmobCommon protoAdapter_SigmobCommon = new ProtoAdapter_SigmobCommon();
        ADAPTER = protoAdapter_SigmobCommon;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SigmobCommon);
        DEFAULT_CONFIGREFRESH = 0;
        Boolean bool = Boolean.FALSE;
        DEFAULT_IS_GDPR_REGION = bool;
        DEFAULT_TRACKING_EXPIRATION_TIME = 0;
        DEFAULT_TRACKING_RETRY_INTERVAL = 0;
        DEFAULT_MAX_SEND_LOG_RECORDS = 0;
        DEFAULT_SEND_LOG_INTERVAL = 0;
        DEFAULT_ENABLE_DEBUG_LEVEL = bool;
        DEFAULT_LOAD_INTERVAL = 0;
        DEFAULT_DISABLE_UP_LOCATION = bool;
        DEFAULT_LOG_ENC = bool;
        DEFAULT_FEEDBACK_DEBUG = bool;
        DEFAULT_ENABLE_EXTRA_DCLOG = bool;
        DEFAULT_NETWORK_TIMEOUT = 0;
    }

    public SigmobCommon(SigmobCommonEndpointsConfig sigmobCommonEndpointsConfig, SigmobRvConfig sigmobRvConfig, SigmobSplashConfig sigmobSplashConfig, SigmobNativeConfig sigmobNativeConfig, Integer num, SigmobAntiFraudLogConfig sigmobAntiFraudLogConfig, Boolean bool, Integer num2, Integer num3, Integer num4, Integer num5, List<Integer> list, Boolean bool2, Integer num6, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Integer num7) {
        this(sigmobCommonEndpointsConfig, sigmobRvConfig, sigmobSplashConfig, sigmobNativeConfig, num, sigmobAntiFraudLogConfig, bool, num2, num3, num4, num5, list, bool2, num6, bool3, bool4, bool5, bool6, num7, ByteString.EMPTY);
    }

    public SigmobCommon(SigmobCommonEndpointsConfig sigmobCommonEndpointsConfig, SigmobRvConfig sigmobRvConfig, SigmobSplashConfig sigmobSplashConfig, SigmobNativeConfig sigmobNativeConfig, Integer num, SigmobAntiFraudLogConfig sigmobAntiFraudLogConfig, Boolean bool, Integer num2, Integer num3, Integer num4, Integer num5, List<Integer> list, Boolean bool2, Integer num6, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Integer num7, ByteString byteString) {
        super(ADAPTER, byteString);
        this.endpoints = sigmobCommonEndpointsConfig;
        this.rv_config = sigmobRvConfig;
        this.splash_config = sigmobSplashConfig;
        this.native_config = sigmobNativeConfig;
        this.configRefresh = num;
        this.anti_fraud_log = sigmobAntiFraudLogConfig;
        this.is_gdpr_region = bool;
        this.tracking_expiration_time = num2;
        this.tracking_retry_interval = num3;
        this.max_send_log_records = num4;
        this.send_log_interval = num5;
        this.dclog_blacklist = Internal.immutableCopyOf("dclog_blacklist", list);
        this.enable_debug_level = bool2;
        this.load_interval = num6;
        this.disable_up_location = bool3;
        this.log_enc = bool4;
        this.feedback_debug = bool5;
        this.enable_extra_dclog = bool6;
        this.network_timeout = num7;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SigmobCommon)) {
            return false;
        }
        SigmobCommon sigmobCommon = (SigmobCommon) obj;
        return unknownFields().equals(sigmobCommon.unknownFields()) && Internal.equals(this.endpoints, sigmobCommon.endpoints) && Internal.equals(this.rv_config, sigmobCommon.rv_config) && Internal.equals(this.splash_config, sigmobCommon.splash_config) && Internal.equals(this.native_config, sigmobCommon.native_config) && Internal.equals(this.configRefresh, sigmobCommon.configRefresh) && Internal.equals(this.anti_fraud_log, sigmobCommon.anti_fraud_log) && Internal.equals(this.is_gdpr_region, sigmobCommon.is_gdpr_region) && Internal.equals(this.tracking_expiration_time, sigmobCommon.tracking_expiration_time) && Internal.equals(this.tracking_retry_interval, sigmobCommon.tracking_retry_interval) && Internal.equals(this.max_send_log_records, sigmobCommon.max_send_log_records) && Internal.equals(this.send_log_interval, sigmobCommon.send_log_interval) && this.dclog_blacklist.equals(sigmobCommon.dclog_blacklist) && Internal.equals(this.enable_debug_level, sigmobCommon.enable_debug_level) && Internal.equals(this.load_interval, sigmobCommon.load_interval) && Internal.equals(this.disable_up_location, sigmobCommon.disable_up_location) && Internal.equals(this.log_enc, sigmobCommon.log_enc) && Internal.equals(this.feedback_debug, sigmobCommon.feedback_debug) && Internal.equals(this.enable_extra_dclog, sigmobCommon.enable_extra_dclog) && Internal.equals(this.network_timeout, sigmobCommon.network_timeout);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        SigmobCommonEndpointsConfig sigmobCommonEndpointsConfig = this.endpoints;
        int hashCode2 = (hashCode + (sigmobCommonEndpointsConfig != null ? sigmobCommonEndpointsConfig.hashCode() : 0)) * 37;
        SigmobRvConfig sigmobRvConfig = this.rv_config;
        int hashCode3 = (hashCode2 + (sigmobRvConfig != null ? sigmobRvConfig.hashCode() : 0)) * 37;
        SigmobSplashConfig sigmobSplashConfig = this.splash_config;
        int hashCode4 = (hashCode3 + (sigmobSplashConfig != null ? sigmobSplashConfig.hashCode() : 0)) * 37;
        SigmobNativeConfig sigmobNativeConfig = this.native_config;
        int hashCode5 = (hashCode4 + (sigmobNativeConfig != null ? sigmobNativeConfig.hashCode() : 0)) * 37;
        Integer num = this.configRefresh;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 37;
        SigmobAntiFraudLogConfig sigmobAntiFraudLogConfig = this.anti_fraud_log;
        int hashCode7 = (hashCode6 + (sigmobAntiFraudLogConfig != null ? sigmobAntiFraudLogConfig.hashCode() : 0)) * 37;
        Boolean bool = this.is_gdpr_region;
        int hashCode8 = (hashCode7 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num2 = this.tracking_expiration_time;
        int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.tracking_retry_interval;
        int hashCode10 = (hashCode9 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.max_send_log_records;
        int hashCode11 = (hashCode10 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.send_log_interval;
        int hashCode12 = (((hashCode11 + (num5 != null ? num5.hashCode() : 0)) * 37) + this.dclog_blacklist.hashCode()) * 37;
        Boolean bool2 = this.enable_debug_level;
        int hashCode13 = (hashCode12 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num6 = this.load_interval;
        int hashCode14 = (hashCode13 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Boolean bool3 = this.disable_up_location;
        int hashCode15 = (hashCode14 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.log_enc;
        int hashCode16 = (hashCode15 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Boolean bool5 = this.feedback_debug;
        int hashCode17 = (hashCode16 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
        Boolean bool6 = this.enable_extra_dclog;
        int hashCode18 = (hashCode17 + (bool6 != null ? bool6.hashCode() : 0)) * 37;
        Integer num7 = this.network_timeout;
        int hashCode19 = hashCode18 + (num7 != null ? num7.hashCode() : 0);
        ((Message) this).hashCode = hashCode19;
        return hashCode19;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.endpoints = this.endpoints;
        builder.rv_config = this.rv_config;
        builder.splash_config = this.splash_config;
        builder.native_config = this.native_config;
        builder.configRefresh = this.configRefresh;
        builder.anti_fraud_log = this.anti_fraud_log;
        builder.is_gdpr_region = this.is_gdpr_region;
        builder.tracking_expiration_time = this.tracking_expiration_time;
        builder.tracking_retry_interval = this.tracking_retry_interval;
        builder.max_send_log_records = this.max_send_log_records;
        builder.send_log_interval = this.send_log_interval;
        builder.dclog_blacklist = Internal.copyOf("dclog_blacklist", this.dclog_blacklist);
        builder.enable_debug_level = this.enable_debug_level;
        builder.load_interval = this.load_interval;
        builder.disable_up_location = this.disable_up_location;
        builder.log_enc = this.log_enc;
        builder.feedback_debug = this.feedback_debug;
        builder.enable_extra_dclog = this.enable_extra_dclog;
        builder.network_timeout = this.network_timeout;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.endpoints != null) {
            sb.append(", endpoints=");
            sb.append(this.endpoints);
        }
        if (this.rv_config != null) {
            sb.append(", rv_config=");
            sb.append(this.rv_config);
        }
        if (this.splash_config != null) {
            sb.append(", splash_config=");
            sb.append(this.splash_config);
        }
        if (this.native_config != null) {
            sb.append(", native_config=");
            sb.append(this.native_config);
        }
        if (this.configRefresh != null) {
            sb.append(", configRefresh=");
            sb.append(this.configRefresh);
        }
        if (this.anti_fraud_log != null) {
            sb.append(", anti_fraud_log=");
            sb.append(this.anti_fraud_log);
        }
        if (this.is_gdpr_region != null) {
            sb.append(", is_gdpr_region=");
            sb.append(this.is_gdpr_region);
        }
        if (this.tracking_expiration_time != null) {
            sb.append(", tracking_expiration_time=");
            sb.append(this.tracking_expiration_time);
        }
        if (this.tracking_retry_interval != null) {
            sb.append(", tracking_retry_interval=");
            sb.append(this.tracking_retry_interval);
        }
        if (this.max_send_log_records != null) {
            sb.append(", max_send_log_records=");
            sb.append(this.max_send_log_records);
        }
        if (this.send_log_interval != null) {
            sb.append(", send_log_interval=");
            sb.append(this.send_log_interval);
        }
        if (!this.dclog_blacklist.isEmpty()) {
            sb.append(", dclog_blacklist=");
            sb.append(this.dclog_blacklist);
        }
        if (this.enable_debug_level != null) {
            sb.append(", enable_debug_level=");
            sb.append(this.enable_debug_level);
        }
        if (this.load_interval != null) {
            sb.append(", load_interval=");
            sb.append(this.load_interval);
        }
        if (this.disable_up_location != null) {
            sb.append(", disable_up_location=");
            sb.append(this.disable_up_location);
        }
        if (this.log_enc != null) {
            sb.append(", log_enc=");
            sb.append(this.log_enc);
        }
        if (this.feedback_debug != null) {
            sb.append(", feedback_debug=");
            sb.append(this.feedback_debug);
        }
        if (this.enable_extra_dclog != null) {
            sb.append(", enable_extra_dclog=");
            sb.append(this.enable_extra_dclog);
        }
        if (this.network_timeout != null) {
            sb.append(", network_timeout=");
            sb.append(this.network_timeout);
        }
        StringBuilder replace = sb.replace(0, 2, "SigmobCommon{");
        replace.append('}');
        return replace.toString();
    }
}
