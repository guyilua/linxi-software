package com.rtk.app.custom.RichEditText;

import androidx.annotation.Keep;
import com.rtk.app.bean.TagsBean;
import java.io.Serializable;
import java.util.List;

@Keep
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostModificationBean implements Serializable {
    private String familyId;
    private String id;
    private String mId;
    private List<TagsBean> tags;
    private String title;

    public PostModificationBean(String str) {
        this.id = "";
        this.id = str;
    }

    public String getFamilyId() {
        return this.familyId;
    }

    public String getId() {
        return this.id;
    }

    public List<TagsBean> getTags() {
        return this.tags;
    }

    public String getTitle() {
        return this.title;
    }

    public String getmId() {
        return this.mId;
    }

    public void setFamilyId(String str) {
        this.familyId = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setTags(List<TagsBean> list) {
        this.tags = list;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setmId(String str) {
        this.mId = str;
    }

    public String toString() {
        return "PostModificationBean{id='" + this.id + "', title='" + this.title + "', tags=" + this.tags + ", mId='" + this.mId + "'}";
    }

    public PostModificationBean(List<TagsBean> list, String str) {
        this(list, str, null);
    }

    public PostModificationBean(List<TagsBean> list, String str, String str2) {
        this.id = "";
        this.tags = list;
        this.mId = str;
        this.familyId = str2;
    }
}
