package com.rtk.app.custom.RichEditText;

import androidx.annotation.Keep;

@Keep
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ResourceTypeBean {
    private boolean isResource;
    private boolean isStart;
    private String resourceName;
    private String resourceType;
    private String resourceid;

    public boolean getIsResource() {
        return this.isResource;
    }

    public boolean getIsStart() {
        return this.isStart;
    }

    public String getResourceName() {
        return this.resourceName;
    }

    public String getResourceType() {
        return this.resourceType;
    }

    public String getResourceid() {
        return this.resourceid;
    }

    public void setIsResource(boolean z) {
        this.isResource = z;
    }

    public void setIsStart(boolean z) {
        this.isStart = z;
    }

    public void setResourceName(String str) {
        this.resourceName = str;
    }

    public void setResourceType(String str) {
        this.resourceType = str;
    }

    public void setResourceid(String str) {
        this.resourceid = str;
    }
}
