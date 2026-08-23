package com.ss.android.downloadad.api.download;

import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.downloadlib.addownload.k;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AdDownloadEventConfig implements DownloadEventConfig {
    protected String mClickButtonTag;
    protected String mClickContinueLabel;
    protected String mClickInstallLabel;
    protected String mClickItemTag;
    protected String mClickLabel;
    protected String mClickPauseLabel;
    protected String mClickStartLabel;
    protected int mDownloadScene;
    protected transient Object mExtraEventObject;
    protected JSONObject mExtraJson;
    protected boolean mIsEnableClickEvent;
    protected boolean mIsEnableV3Event;
    protected JSONObject mParamsJson;
    protected String mRefer;
    protected String mStorageDenyLabel;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static final class Builder {
        AdDownloadEventConfig eventConfig = new AdDownloadEventConfig();

        public AdDownloadEventConfig build() {
            return this.eventConfig;
        }

        public Builder setClickButtonTag(String str) {
            this.eventConfig.mClickButtonTag = str;
            return this;
        }

        public Builder setClickContinueLabel(String str) {
            this.eventConfig.mClickContinueLabel = str;
            return this;
        }

        @Deprecated
        public Builder setClickContinueTag(String str) {
            return this;
        }

        public Builder setClickInstallLabel(String str) {
            this.eventConfig.mClickInstallLabel = str;
            return this;
        }

        @Deprecated
        public Builder setClickInstallTag(String str) {
            return this;
        }

        public Builder setClickItemTag(String str) {
            this.eventConfig.mClickItemTag = str;
            return this;
        }

        public Builder setClickLabel(String str) {
            this.eventConfig.mClickLabel = str;
            return this;
        }

        @Deprecated
        public Builder setClickOpenLabel(String str) {
            return this;
        }

        @Deprecated
        public Builder setClickOpenTag(String str) {
            return this;
        }

        public Builder setClickPauseLabel(String str) {
            this.eventConfig.mClickPauseLabel = str;
            return this;
        }

        @Deprecated
        public Builder setClickPauseTag(String str) {
            return this;
        }

        public Builder setClickStartLabel(String str) {
            this.eventConfig.mClickStartLabel = str;
            return this;
        }

        @Deprecated
        public Builder setClickStartTag(String str) {
            return this;
        }

        @Deprecated
        public Builder setClickTag(String str) {
            return this;
        }

        @Deprecated
        public Builder setCompletedEventTag(String str) {
            return this;
        }

        @Deprecated
        public Builder setDownloadFailedLabel(String str) {
            return this;
        }

        public Builder setDownloadScene(int i) {
            this.eventConfig.mDownloadScene = i;
            return this;
        }

        public Builder setExtraEventObject(Object obj) {
            this.eventConfig.mExtraEventObject = obj;
            return this;
        }

        public Builder setExtraJson(JSONObject jSONObject) {
            this.eventConfig.mExtraJson = jSONObject;
            return this;
        }

        public Builder setIsEnableClickEvent(boolean z) {
            this.eventConfig.mIsEnableClickEvent = z;
            return this;
        }

        @Deprecated
        public Builder setIsEnableCompletedEvent(boolean z) {
            return this;
        }

        @Deprecated
        public Builder setIsEnableNoChargeClickEvent(boolean z) {
            return this;
        }

        public Builder setIsEnableV3Event(boolean z) {
            this.eventConfig.mIsEnableV3Event = z;
            return this;
        }

        @Deprecated
        public Builder setOpenLabel(String str) {
            return this;
        }

        @Deprecated
        public Builder setOpenTag(String str) {
            return this;
        }

        public Builder setParamsJson(JSONObject jSONObject) {
            this.eventConfig.mParamsJson = jSONObject;
            return this;
        }

        @Deprecated
        public Builder setQuickAppEventTag(String str) {
            return this;
        }

        public Builder setRefer(String str) {
            this.eventConfig.mRefer = str;
            return this;
        }

        public Builder setStorageDenyLabel(String str) {
            this.eventConfig.mStorageDenyLabel = str;
            return this;
        }

        @Deprecated
        public Builder setStorageDenyTag(String str) {
            return this;
        }
    }

    public AdDownloadEventConfig() {
        this.mIsEnableClickEvent = true;
        this.mIsEnableV3Event = false;
    }

    public static AdDownloadEventConfig fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Builder builder = new Builder();
        try {
            builder.setClickButtonTag(jSONObject.optString("click_button_tag"));
            builder.setClickItemTag(jSONObject.optString("click_item_tag"));
            builder.setClickLabel(jSONObject.optString("click_label"));
            builder.setClickStartLabel(jSONObject.optString("click_start_label"));
            builder.setClickContinueLabel(jSONObject.optString("click_continue_label"));
            builder.setClickPauseLabel(jSONObject.optString("click_pause_label"));
            builder.setClickInstallLabel(jSONObject.optString("click_install_label"));
            builder.setStorageDenyLabel(jSONObject.optString("storage_deny_label"));
            builder.setRefer(jSONObject.optString("refer"));
            builder.setDownloadScene(jSONObject.optInt("download_scene"));
            builder.setIsEnableClickEvent(jSONObject.optInt("enable_click_event") == 1);
            builder.setIsEnableV3Event(jSONObject.optInt("enable_v3_event") == 1);
            builder.setExtraJson(jSONObject.optJSONObject(BaseConstants.EVENT_LABEL_EXTRA));
            builder.setParamsJson(jSONObject.optJSONObject("params_json"));
        } catch (Exception e) {
            k.u().a(e, "AdDownloadEventConfig fromJson");
        }
        return builder.build();
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickButtonTag() {
        return this.mClickButtonTag;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickContinueLabel() {
        return this.mClickContinueLabel;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickInstallLabel() {
        return this.mClickInstallLabel;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickItemTag() {
        return this.mClickItemTag;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickLabel() {
        return this.mClickLabel;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickPauseLabel() {
        return this.mClickPauseLabel;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickStartLabel() {
        return this.mClickStartLabel;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public int getDownloadScene() {
        return this.mDownloadScene;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public Object getExtraEventObject() {
        return this.mExtraEventObject;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getExtraJson() {
        return this.mExtraJson;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getParamsJson() {
        return this.mParamsJson;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getRefer() {
        return this.mRefer;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getStorageDenyLabel() {
        return this.mStorageDenyLabel;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.mIsEnableClickEvent;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableV3Event() {
        return this.mIsEnableV3Event;
    }

    public void setClickButtonTag(String str) {
        this.mClickButtonTag = str;
    }

    public void setClickItemTag(String str) {
        this.mClickItemTag = str;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setDownloadScene(int i) {
        this.mDownloadScene = i;
    }

    public void setExtraEventObject(Object obj) {
        this.mExtraEventObject = obj;
    }

    public void setExtraJson(JSONObject jSONObject) {
        this.mExtraJson = jSONObject;
    }

    public void setParamsJson(JSONObject jSONObject) {
        this.mParamsJson = jSONObject;
    }

    @Deprecated
    public void setQuickAppEventTag(String str) {
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setRefer(String str) {
        this.mRefer = str;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("click_button_tag", this.mClickButtonTag);
            jSONObject.putOpt("click_item_tag", this.mClickItemTag);
            jSONObject.putOpt("click_label", this.mClickLabel);
            jSONObject.putOpt("click_start_label", this.mClickStartLabel);
            jSONObject.putOpt("click_continue_label", this.mClickContinueLabel);
            jSONObject.putOpt("click_pause_label", this.mClickPauseLabel);
            jSONObject.putOpt("click_install_label", this.mClickInstallLabel);
            jSONObject.putOpt("storage_deny_label", this.mStorageDenyLabel);
            jSONObject.putOpt("refer", this.mRefer);
            jSONObject.putOpt("download_scene", Integer.valueOf(this.mDownloadScene));
            int i = 1;
            jSONObject.putOpt("enable_click_event", Integer.valueOf(this.mIsEnableClickEvent ? 1 : 0));
            if (!this.mIsEnableV3Event) {
                i = 0;
            }
            jSONObject.putOpt("enable_v3_event", Integer.valueOf(i));
            jSONObject.putOpt(BaseConstants.EVENT_LABEL_EXTRA, this.mExtraJson);
            jSONObject.putOpt("params_json", this.mParamsJson);
        } catch (Exception e) {
            k.u().a(e, "AdDownloadEventConfig toJson");
        }
        return jSONObject;
    }

    public AdDownloadEventConfig(AdDownloadEventConfig adDownloadEventConfig) {
        this.mIsEnableClickEvent = true;
        this.mIsEnableV3Event = false;
        if (adDownloadEventConfig == null) {
            return;
        }
        this.mClickButtonTag = adDownloadEventConfig.mClickButtonTag;
        this.mClickItemTag = adDownloadEventConfig.mClickItemTag;
        this.mClickLabel = adDownloadEventConfig.mClickLabel;
        this.mClickStartLabel = adDownloadEventConfig.mClickStartLabel;
        this.mClickPauseLabel = adDownloadEventConfig.mClickPauseLabel;
        this.mClickContinueLabel = adDownloadEventConfig.mClickContinueLabel;
        this.mClickInstallLabel = adDownloadEventConfig.mClickInstallLabel;
        this.mStorageDenyLabel = adDownloadEventConfig.mStorageDenyLabel;
        this.mDownloadScene = adDownloadEventConfig.mDownloadScene;
        this.mIsEnableClickEvent = adDownloadEventConfig.mIsEnableClickEvent;
        this.mIsEnableV3Event = adDownloadEventConfig.mIsEnableV3Event;
        this.mRefer = adDownloadEventConfig.mRefer;
        this.mExtraJson = adDownloadEventConfig.mExtraJson;
        this.mParamsJson = adDownloadEventConfig.mParamsJson;
    }
}
