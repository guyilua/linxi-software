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
public final class SigmobAndroid extends AndroidMessage<SigmobAndroid, Builder> {
    public static final ProtoAdapter<SigmobAndroid> ADAPTER;
    public static final Parcelable.Creator<SigmobAndroid> CREATOR;
    public static final Integer DEFAULT_APK_EXPIRED_TIME;
    public static final Boolean DEFAULT_DISABLEUPAPPINFO;
    public static final Boolean DEFAULT_DISABLE_BOOT_MARK;
    public static final Boolean DEFAULT_DISABLE_INSTALL_MONITOR;
    public static final Integer DEFAULT_DISABLE_UP_OAID;
    public static final Integer DEFAULT_ENABLE_APP_LIST;
    public static final Boolean DEFAULT_ENABLE_OKHTTP3;
    public static final Boolean DEFAULT_ENABLE_PERMISSION;
    public static final Boolean DEFAULT_ENABLE_REPORT_CRASH;
    public static final Boolean DEFAULT_LOCK_PLAY;
    public static final Boolean DEFAULT_OAID_API_IS_DISABLE;
    public static final Integer DEFAULT_REPORT_LOG;
    public static final Boolean DEFAULT_SCREEN_KEEP;
    public static final Integer DEFAULT_UP_WIFI_LIST_INTERVAL;
    public static final Boolean DEFAULT_USE_WEB_SOURCE_CACHE;
    public static final Integer DEFAULT_WEB_SOURCE_CACHE_EXPIRATION_TIME;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 6)
    public final Integer apk_expired_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean disableUpAppInfo;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 9)
    public final Boolean disable_boot_mark;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 17)
    public final Boolean disable_install_monitor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 4)
    public final Integer disable_up_oaid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 11)
    public final Integer enable_app_list;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 10)
    public final Boolean enable_okhttp3;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 5)
    public final Boolean enable_permission;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 7)
    public final Boolean enable_report_crash;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 12)
    public final Boolean lock_play;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 8)
    public final Boolean oaid_api_is_disable;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 14)
    public final List<String> open_pkg_list;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer report_log;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 13)
    public final Boolean screen_keep;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer up_wifi_list_interval;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 15)
    public final Boolean use_web_source_cache;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 16)
    public final Integer web_source_cache_expiration_time;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class Builder extends Message.Builder<SigmobAndroid, Builder> {
        public Integer apk_expired_time;
        public Boolean disableUpAppInfo;
        public Boolean disable_boot_mark;
        public Boolean disable_install_monitor;
        public Integer disable_up_oaid;
        public Integer enable_app_list;
        public Boolean enable_okhttp3;
        public Boolean enable_permission;
        public Boolean enable_report_crash;
        public Boolean lock_play;
        public Boolean oaid_api_is_disable;
        public List<String> open_pkg_list = Internal.newMutableList();
        public Integer report_log;
        public Boolean screen_keep;
        public Integer up_wifi_list_interval;
        public Boolean use_web_source_cache;
        public Integer web_source_cache_expiration_time;

        public Builder apk_expired_time(Integer num) {
            this.apk_expired_time = num;
            return this;
        }

        public SigmobAndroid build() {
            return new SigmobAndroid(this.disableUpAppInfo, this.report_log, this.up_wifi_list_interval, this.disable_up_oaid, this.enable_permission, this.apk_expired_time, this.enable_report_crash, this.oaid_api_is_disable, this.disable_boot_mark, this.enable_okhttp3, this.enable_app_list, this.lock_play, this.screen_keep, this.open_pkg_list, this.use_web_source_cache, this.web_source_cache_expiration_time, this.disable_install_monitor, super.buildUnknownFields());
        }

        public Builder disableUpAppInfo(Boolean bool) {
            this.disableUpAppInfo = bool;
            return this;
        }

        public Builder disable_boot_mark(Boolean bool) {
            this.disable_boot_mark = bool;
            return this;
        }

        public Builder disable_install_monitor(Boolean bool) {
            this.disable_install_monitor = bool;
            return this;
        }

        public Builder disable_up_oaid(Integer num) {
            this.disable_up_oaid = num;
            return this;
        }

        public Builder enable_app_list(Integer num) {
            this.enable_app_list = num;
            return this;
        }

        public Builder enable_okhttp3(Boolean bool) {
            this.enable_okhttp3 = bool;
            return this;
        }

        public Builder enable_permission(Boolean bool) {
            this.enable_permission = bool;
            return this;
        }

        public Builder enable_report_crash(Boolean bool) {
            this.enable_report_crash = bool;
            return this;
        }

        public Builder lock_play(Boolean bool) {
            this.lock_play = bool;
            return this;
        }

        public Builder oaid_api_is_disable(Boolean bool) {
            this.oaid_api_is_disable = bool;
            return this;
        }

        public Builder open_pkg_list(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.open_pkg_list = list;
            return this;
        }

        public Builder report_log(Integer num) {
            this.report_log = num;
            return this;
        }

        public Builder screen_keep(Boolean bool) {
            this.screen_keep = bool;
            return this;
        }

        public Builder up_wifi_list_interval(Integer num) {
            this.up_wifi_list_interval = num;
            return this;
        }

        public Builder use_web_source_cache(Boolean bool) {
            this.use_web_source_cache = bool;
            return this;
        }

        public Builder web_source_cache_expiration_time(Integer num) {
            this.web_source_cache_expiration_time = num;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class ProtoAdapter_SigmobAndroid extends ProtoAdapter<SigmobAndroid> {
        public ProtoAdapter_SigmobAndroid() {
            super(FieldEncoding.LENGTH_DELIMITED, SigmobAndroid.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public SigmobAndroid m8decode(ProtoReader protoReader) {
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
                        builder.disableUpAppInfo((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 2:
                        builder.report_log((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 3:
                        builder.up_wifi_list_interval((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 4:
                        builder.disable_up_oaid((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 5:
                        builder.enable_permission((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 6:
                        builder.apk_expired_time((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 7:
                        builder.enable_report_crash((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 8:
                        builder.oaid_api_is_disable((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 9:
                        builder.disable_boot_mark((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 10:
                        builder.enable_okhttp3((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 11:
                        builder.enable_app_list((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 12:
                        builder.lock_play((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 13:
                        builder.screen_keep((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 14:
                        builder.open_pkg_list.add((String) ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 15:
                        builder.use_web_source_cache((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 16:
                        builder.web_source_cache_expiration_time((Integer) ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 17:
                        builder.disable_install_monitor((Boolean) ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    default:
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        break;
                }
            }
        }

        public void encode(ProtoWriter protoWriter, SigmobAndroid sigmobAndroid) {
            ProtoAdapter protoAdapter = ProtoAdapter.BOOL;
            protoAdapter.encodeWithTag(protoWriter, 1, sigmobAndroid.disableUpAppInfo);
            ProtoAdapter protoAdapter2 = ProtoAdapter.UINT32;
            protoAdapter2.encodeWithTag(protoWriter, 2, sigmobAndroid.report_log);
            protoAdapter2.encodeWithTag(protoWriter, 3, sigmobAndroid.up_wifi_list_interval);
            protoAdapter2.encodeWithTag(protoWriter, 4, sigmobAndroid.disable_up_oaid);
            protoAdapter.encodeWithTag(protoWriter, 5, sigmobAndroid.enable_permission);
            protoAdapter2.encodeWithTag(protoWriter, 6, sigmobAndroid.apk_expired_time);
            protoAdapter.encodeWithTag(protoWriter, 7, sigmobAndroid.enable_report_crash);
            protoAdapter.encodeWithTag(protoWriter, 8, sigmobAndroid.oaid_api_is_disable);
            protoAdapter.encodeWithTag(protoWriter, 9, sigmobAndroid.disable_boot_mark);
            protoAdapter.encodeWithTag(protoWriter, 10, sigmobAndroid.enable_okhttp3);
            protoAdapter2.encodeWithTag(protoWriter, 11, sigmobAndroid.enable_app_list);
            protoAdapter.encodeWithTag(protoWriter, 12, sigmobAndroid.lock_play);
            protoAdapter.encodeWithTag(protoWriter, 13, sigmobAndroid.screen_keep);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 14, sigmobAndroid.open_pkg_list);
            protoAdapter.encodeWithTag(protoWriter, 15, sigmobAndroid.use_web_source_cache);
            protoAdapter2.encodeWithTag(protoWriter, 16, sigmobAndroid.web_source_cache_expiration_time);
            protoAdapter.encodeWithTag(protoWriter, 17, sigmobAndroid.disable_install_monitor);
            protoWriter.writeBytes(sigmobAndroid.unknownFields());
        }

        public int encodedSize(SigmobAndroid sigmobAndroid) {
            ProtoAdapter protoAdapter = ProtoAdapter.BOOL;
            int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(1, sigmobAndroid.disableUpAppInfo);
            ProtoAdapter protoAdapter2 = ProtoAdapter.UINT32;
            return encodedSizeWithTag + protoAdapter2.encodedSizeWithTag(2, sigmobAndroid.report_log) + protoAdapter2.encodedSizeWithTag(3, sigmobAndroid.up_wifi_list_interval) + protoAdapter2.encodedSizeWithTag(4, sigmobAndroid.disable_up_oaid) + protoAdapter.encodedSizeWithTag(5, sigmobAndroid.enable_permission) + protoAdapter2.encodedSizeWithTag(6, sigmobAndroid.apk_expired_time) + protoAdapter.encodedSizeWithTag(7, sigmobAndroid.enable_report_crash) + protoAdapter.encodedSizeWithTag(8, sigmobAndroid.oaid_api_is_disable) + protoAdapter.encodedSizeWithTag(9, sigmobAndroid.disable_boot_mark) + protoAdapter.encodedSizeWithTag(10, sigmobAndroid.enable_okhttp3) + protoAdapter2.encodedSizeWithTag(11, sigmobAndroid.enable_app_list) + protoAdapter.encodedSizeWithTag(12, sigmobAndroid.lock_play) + protoAdapter.encodedSizeWithTag(13, sigmobAndroid.screen_keep) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(14, sigmobAndroid.open_pkg_list) + protoAdapter.encodedSizeWithTag(15, sigmobAndroid.use_web_source_cache) + protoAdapter2.encodedSizeWithTag(16, sigmobAndroid.web_source_cache_expiration_time) + protoAdapter.encodedSizeWithTag(17, sigmobAndroid.disable_install_monitor) + sigmobAndroid.unknownFields().size();
        }

        public SigmobAndroid redact(SigmobAndroid sigmobAndroid) {
            Builder newBuilder = sigmobAndroid.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_SigmobAndroid protoAdapter_SigmobAndroid = new ProtoAdapter_SigmobAndroid();
        ADAPTER = protoAdapter_SigmobAndroid;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SigmobAndroid);
        Boolean bool = Boolean.FALSE;
        DEFAULT_DISABLEUPAPPINFO = bool;
        DEFAULT_REPORT_LOG = 0;
        DEFAULT_UP_WIFI_LIST_INTERVAL = 0;
        DEFAULT_DISABLE_UP_OAID = 0;
        DEFAULT_ENABLE_PERMISSION = bool;
        DEFAULT_APK_EXPIRED_TIME = 0;
        DEFAULT_ENABLE_REPORT_CRASH = bool;
        DEFAULT_OAID_API_IS_DISABLE = bool;
        DEFAULT_DISABLE_BOOT_MARK = bool;
        DEFAULT_ENABLE_OKHTTP3 = bool;
        DEFAULT_ENABLE_APP_LIST = 0;
        DEFAULT_LOCK_PLAY = bool;
        DEFAULT_SCREEN_KEEP = bool;
        DEFAULT_USE_WEB_SOURCE_CACHE = bool;
        DEFAULT_WEB_SOURCE_CACHE_EXPIRATION_TIME = 0;
        DEFAULT_DISABLE_INSTALL_MONITOR = bool;
    }

    public SigmobAndroid(Boolean bool, Integer num, Integer num2, Integer num3, Boolean bool2, Integer num4, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Integer num5, Boolean bool7, Boolean bool8, List<String> list, Boolean bool9, Integer num6, Boolean bool10) {
        this(bool, num, num2, num3, bool2, num4, bool3, bool4, bool5, bool6, num5, bool7, bool8, list, bool9, num6, bool10, ByteString.EMPTY);
    }

    public SigmobAndroid(Boolean bool, Integer num, Integer num2, Integer num3, Boolean bool2, Integer num4, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Integer num5, Boolean bool7, Boolean bool8, List<String> list, Boolean bool9, Integer num6, Boolean bool10, ByteString byteString) {
        super(ADAPTER, byteString);
        this.disableUpAppInfo = bool;
        this.report_log = num;
        this.up_wifi_list_interval = num2;
        this.disable_up_oaid = num3;
        this.enable_permission = bool2;
        this.apk_expired_time = num4;
        this.enable_report_crash = bool3;
        this.oaid_api_is_disable = bool4;
        this.disable_boot_mark = bool5;
        this.enable_okhttp3 = bool6;
        this.enable_app_list = num5;
        this.lock_play = bool7;
        this.screen_keep = bool8;
        this.open_pkg_list = Internal.immutableCopyOf("open_pkg_list", list);
        this.use_web_source_cache = bool9;
        this.web_source_cache_expiration_time = num6;
        this.disable_install_monitor = bool10;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SigmobAndroid)) {
            return false;
        }
        SigmobAndroid sigmobAndroid = (SigmobAndroid) obj;
        return unknownFields().equals(sigmobAndroid.unknownFields()) && Internal.equals(this.disableUpAppInfo, sigmobAndroid.disableUpAppInfo) && Internal.equals(this.report_log, sigmobAndroid.report_log) && Internal.equals(this.up_wifi_list_interval, sigmobAndroid.up_wifi_list_interval) && Internal.equals(this.disable_up_oaid, sigmobAndroid.disable_up_oaid) && Internal.equals(this.enable_permission, sigmobAndroid.enable_permission) && Internal.equals(this.apk_expired_time, sigmobAndroid.apk_expired_time) && Internal.equals(this.enable_report_crash, sigmobAndroid.enable_report_crash) && Internal.equals(this.oaid_api_is_disable, sigmobAndroid.oaid_api_is_disable) && Internal.equals(this.disable_boot_mark, sigmobAndroid.disable_boot_mark) && Internal.equals(this.enable_okhttp3, sigmobAndroid.enable_okhttp3) && Internal.equals(this.enable_app_list, sigmobAndroid.enable_app_list) && Internal.equals(this.lock_play, sigmobAndroid.lock_play) && Internal.equals(this.screen_keep, sigmobAndroid.screen_keep) && this.open_pkg_list.equals(sigmobAndroid.open_pkg_list) && Internal.equals(this.use_web_source_cache, sigmobAndroid.use_web_source_cache) && Internal.equals(this.web_source_cache_expiration_time, sigmobAndroid.web_source_cache_expiration_time) && Internal.equals(this.disable_install_monitor, sigmobAndroid.disable_install_monitor);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Boolean bool = this.disableUpAppInfo;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num = this.report_log;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.up_wifi_list_interval;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.disable_up_oaid;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Boolean bool2 = this.enable_permission;
        int hashCode6 = (hashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num4 = this.apk_expired_time;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Boolean bool3 = this.enable_report_crash;
        int hashCode8 = (hashCode7 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.oaid_api_is_disable;
        int hashCode9 = (hashCode8 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Boolean bool5 = this.disable_boot_mark;
        int hashCode10 = (hashCode9 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
        Boolean bool6 = this.enable_okhttp3;
        int hashCode11 = (hashCode10 + (bool6 != null ? bool6.hashCode() : 0)) * 37;
        Integer num5 = this.enable_app_list;
        int hashCode12 = (hashCode11 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Boolean bool7 = this.lock_play;
        int hashCode13 = (hashCode12 + (bool7 != null ? bool7.hashCode() : 0)) * 37;
        Boolean bool8 = this.screen_keep;
        int hashCode14 = (((hashCode13 + (bool8 != null ? bool8.hashCode() : 0)) * 37) + this.open_pkg_list.hashCode()) * 37;
        Boolean bool9 = this.use_web_source_cache;
        int hashCode15 = (hashCode14 + (bool9 != null ? bool9.hashCode() : 0)) * 37;
        Integer num6 = this.web_source_cache_expiration_time;
        int hashCode16 = (hashCode15 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Boolean bool10 = this.disable_install_monitor;
        int hashCode17 = hashCode16 + (bool10 != null ? bool10.hashCode() : 0);
        ((Message) this).hashCode = hashCode17;
        return hashCode17;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.disableUpAppInfo = this.disableUpAppInfo;
        builder.report_log = this.report_log;
        builder.up_wifi_list_interval = this.up_wifi_list_interval;
        builder.disable_up_oaid = this.disable_up_oaid;
        builder.enable_permission = this.enable_permission;
        builder.apk_expired_time = this.apk_expired_time;
        builder.enable_report_crash = this.enable_report_crash;
        builder.oaid_api_is_disable = this.oaid_api_is_disable;
        builder.disable_boot_mark = this.disable_boot_mark;
        builder.enable_okhttp3 = this.enable_okhttp3;
        builder.enable_app_list = this.enable_app_list;
        builder.lock_play = this.lock_play;
        builder.screen_keep = this.screen_keep;
        builder.open_pkg_list = Internal.copyOf("open_pkg_list", this.open_pkg_list);
        builder.use_web_source_cache = this.use_web_source_cache;
        builder.web_source_cache_expiration_time = this.web_source_cache_expiration_time;
        builder.disable_install_monitor = this.disable_install_monitor;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.disableUpAppInfo != null) {
            sb.append(", disableUpAppInfo=");
            sb.append(this.disableUpAppInfo);
        }
        if (this.report_log != null) {
            sb.append(", report_log=");
            sb.append(this.report_log);
        }
        if (this.up_wifi_list_interval != null) {
            sb.append(", up_wifi_list_interval=");
            sb.append(this.up_wifi_list_interval);
        }
        if (this.disable_up_oaid != null) {
            sb.append(", disable_up_oaid=");
            sb.append(this.disable_up_oaid);
        }
        if (this.enable_permission != null) {
            sb.append(", enable_permission=");
            sb.append(this.enable_permission);
        }
        if (this.apk_expired_time != null) {
            sb.append(", apk_expired_time=");
            sb.append(this.apk_expired_time);
        }
        if (this.enable_report_crash != null) {
            sb.append(", enable_report_crash=");
            sb.append(this.enable_report_crash);
        }
        if (this.oaid_api_is_disable != null) {
            sb.append(", oaid_api_is_disable=");
            sb.append(this.oaid_api_is_disable);
        }
        if (this.disable_boot_mark != null) {
            sb.append(", disable_boot_mark=");
            sb.append(this.disable_boot_mark);
        }
        if (this.enable_okhttp3 != null) {
            sb.append(", enable_okhttp3=");
            sb.append(this.enable_okhttp3);
        }
        if (this.enable_app_list != null) {
            sb.append(", enable_app_list=");
            sb.append(this.enable_app_list);
        }
        if (this.lock_play != null) {
            sb.append(", lock_play=");
            sb.append(this.lock_play);
        }
        if (this.screen_keep != null) {
            sb.append(", screen_keep=");
            sb.append(this.screen_keep);
        }
        if (!this.open_pkg_list.isEmpty()) {
            sb.append(", open_pkg_list=");
            sb.append(this.open_pkg_list);
        }
        if (this.use_web_source_cache != null) {
            sb.append(", use_web_source_cache=");
            sb.append(this.use_web_source_cache);
        }
        if (this.web_source_cache_expiration_time != null) {
            sb.append(", web_source_cache_expiration_time=");
            sb.append(this.web_source_cache_expiration_time);
        }
        if (this.disable_install_monitor != null) {
            sb.append(", disable_install_monitor=");
            sb.append(this.disable_install_monitor);
        }
        StringBuilder replace = sb.replace(0, 2, "SigmobAndroid{");
        replace.append('}');
        return replace.toString();
    }
}
