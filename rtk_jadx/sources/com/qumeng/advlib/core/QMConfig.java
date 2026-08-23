package com.qumeng.advlib.core;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.qumeng.advlib.common.e;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class QMConfig {
    private boolean agreePrivacyStrategy = false;
    private String androidId;
    private Context context;
    private QMCustomControl customControl;
    private boolean debug;
    private Map map;
    private String versionName;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class Builder {
        private boolean agreePrivacyStrategy = false;
        private String androidId;
        private QMCustomControl customControl;
        private boolean debug;
        private Map map;
        private String versionName;

        public Builder agreePrivacyStrategy(boolean z) {
            this.agreePrivacyStrategy = z;
            return this;
        }

        public Builder androidId(String str) {
            this.androidId = str;
            return this;
        }

        public QMConfig build(@NonNull Context context) {
            QMConfig qMConfig = new QMConfig();
            if (TextUtils.isEmpty(this.versionName)) {
                this.versionName = e.b(context);
            }
            QMCustomControl qMCustomControl = this.customControl;
            if (qMCustomControl != null) {
                String androidId = qMCustomControl.getAndroidId();
                this.androidId = androidId;
                if (TextUtils.isEmpty(androidId) && this.customControl.isCanUseAndroidId()) {
                    this.androidId = e.d(context);
                }
                if (this.map == null) {
                    this.map = new HashMap();
                }
                this.map.put("imei", this.customControl.getDevImei());
                this.map.put("imsi", this.customControl.getDevImsi());
                this.map.put("mac_address", this.customControl.getMacAddress());
                if (!TextUtils.isEmpty(this.customControl.getDevImei()) || !TextUtils.isEmpty(this.customControl.getDevImsi()) || !TextUtils.isEmpty(this.customControl.getMacAddress()) || !this.customControl.isCanUsePhoneState()) {
                    this.map.put("is_control", Boolean.TRUE);
                }
            } else if (TextUtils.isEmpty(this.androidId)) {
                this.androidId = e.d(context);
            }
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            qMConfig.setContext(context);
            qMConfig.setVersionName(this.versionName);
            qMConfig.setDebug(this.debug);
            qMConfig.setAgreePrivacyStrategy(this.agreePrivacyStrategy);
            qMConfig.setMap(this.map);
            qMConfig.setAndroidId(this.androidId);
            qMConfig.setCustomControl(this.customControl);
            return qMConfig;
        }

        public Builder customControl(QMCustomControl qMCustomControl) {
            this.customControl = qMCustomControl;
            return this;
        }

        public Builder debug(boolean z) {
            this.debug = z;
            return this;
        }

        public Builder extraMap(Map map) {
            this.map = map;
            return this;
        }

        public Builder versionName(String str) {
            this.versionName = str;
            return this;
        }
    }

    public String getAndroidId() {
        QMCustomControl qMCustomControl = this.customControl;
        if (qMCustomControl != null && !qMCustomControl.isCanUseAndroidId()) {
            return this.customControl.getAndroidId();
        }
        return this.androidId;
    }

    public Context getContext() {
        return this.context;
    }

    public QMCustomControl getCustomControl() {
        return this.customControl;
    }

    public Map getMap() {
        return this.map;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public boolean isAgreePrivacyStrategy() {
        return this.agreePrivacyStrategy;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public void setAgreePrivacyStrategy(boolean z) {
        this.agreePrivacyStrategy = z;
    }

    public void setAndroidId(String str) {
        this.androidId = str;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setCustomControl(QMCustomControl qMCustomControl) {
        this.customControl = qMCustomControl;
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }
}
