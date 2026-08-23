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

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class SigmobDialogSetting extends AndroidMessage<SigmobDialogSetting, Builder> {
    public static final ProtoAdapter<SigmobDialogSetting> ADAPTER;
    public static final Parcelable.Creator<SigmobDialogSetting> CREATOR;
    public static final String DEFAULT_BODY_TEXT = "";
    public static final String DEFAULT_CANCEL_BUTTON_TEXT = "";
    public static final String DEFAULT_CLOSE_BUTTON_TEXT = "";
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String body_text;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String cancel_button_text;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String close_button_text;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String title;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class Builder extends Message.Builder<SigmobDialogSetting, Builder> {
        public String body_text;
        public String cancel_button_text;
        public String close_button_text;
        public String title;

        public Builder body_text(String str) {
            this.body_text = str;
            return this;
        }

        public SigmobDialogSetting build() {
            return new SigmobDialogSetting(this.title, this.body_text, this.cancel_button_text, this.close_button_text, super.buildUnknownFields());
        }

        public Builder cancel_button_text(String str) {
            this.cancel_button_text = str;
            return this;
        }

        public Builder close_button_text(String str) {
            this.close_button_text = str;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class ProtoAdapter_SigmobDialogSetting extends ProtoAdapter<SigmobDialogSetting> {
        public ProtoAdapter_SigmobDialogSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, SigmobDialogSetting.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public SigmobDialogSetting m20decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.title((String) ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.body_text((String) ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.cancel_button_text((String) ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.close_button_text((String) ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public void encode(ProtoWriter protoWriter, SigmobDialogSetting sigmobDialogSetting) {
            ProtoAdapter protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, sigmobDialogSetting.title);
            protoAdapter.encodeWithTag(protoWriter, 2, sigmobDialogSetting.body_text);
            protoAdapter.encodeWithTag(protoWriter, 3, sigmobDialogSetting.cancel_button_text);
            protoAdapter.encodeWithTag(protoWriter, 4, sigmobDialogSetting.close_button_text);
            protoWriter.writeBytes(sigmobDialogSetting.unknownFields());
        }

        public int encodedSize(SigmobDialogSetting sigmobDialogSetting) {
            ProtoAdapter protoAdapter = ProtoAdapter.STRING;
            return protoAdapter.encodedSizeWithTag(1, sigmobDialogSetting.title) + protoAdapter.encodedSizeWithTag(2, sigmobDialogSetting.body_text) + protoAdapter.encodedSizeWithTag(3, sigmobDialogSetting.cancel_button_text) + protoAdapter.encodedSizeWithTag(4, sigmobDialogSetting.close_button_text) + sigmobDialogSetting.unknownFields().size();
        }

        public SigmobDialogSetting redact(SigmobDialogSetting sigmobDialogSetting) {
            Builder newBuilder = sigmobDialogSetting.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_SigmobDialogSetting protoAdapter_SigmobDialogSetting = new ProtoAdapter_SigmobDialogSetting();
        ADAPTER = protoAdapter_SigmobDialogSetting;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SigmobDialogSetting);
    }

    public SigmobDialogSetting(String str, String str2, String str3, String str4) {
        this(str, str2, str3, str4, ByteString.EMPTY);
    }

    public SigmobDialogSetting(String str, String str2, String str3, String str4, ByteString byteString) {
        super(ADAPTER, byteString);
        this.title = str;
        this.body_text = str2;
        this.cancel_button_text = str3;
        this.close_button_text = str4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SigmobDialogSetting)) {
            return false;
        }
        SigmobDialogSetting sigmobDialogSetting = (SigmobDialogSetting) obj;
        return unknownFields().equals(sigmobDialogSetting.unknownFields()) && Internal.equals(this.title, sigmobDialogSetting.title) && Internal.equals(this.body_text, sigmobDialogSetting.body_text) && Internal.equals(this.cancel_button_text, sigmobDialogSetting.cancel_button_text) && Internal.equals(this.close_button_text, sigmobDialogSetting.close_button_text);
    }

    public int hashCode() {
        int i = ((Message) this).hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.title;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.body_text;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.cancel_button_text;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.close_button_text;
        int hashCode5 = hashCode4 + (str4 != null ? str4.hashCode() : 0);
        ((Message) this).hashCode = hashCode5;
        return hashCode5;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.title = this.title;
        builder.body_text = this.body_text;
        builder.cancel_button_text = this.cancel_button_text;
        builder.close_button_text = this.close_button_text;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.title != null) {
            sb.append(", title=");
            sb.append(this.title);
        }
        if (this.body_text != null) {
            sb.append(", body_text=");
            sb.append(this.body_text);
        }
        if (this.cancel_button_text != null) {
            sb.append(", cancel_button_text=");
            sb.append(this.cancel_button_text);
        }
        if (this.close_button_text != null) {
            sb.append(", close_button_text=");
            sb.append(this.close_button_text);
        }
        StringBuilder replace = sb.replace(0, 2, "SigmobDialogSetting{");
        replace.append('}');
        return replace.toString();
    }
}
