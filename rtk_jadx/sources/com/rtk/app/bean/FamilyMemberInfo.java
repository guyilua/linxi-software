package com.rtk.app.bean;

import android.text.TextUtils;
import com.rtk.app.bean.UserRankBean;
import java.io.Serializable;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyMemberInfo implements Serializable {
    private int code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean extends UserRankBean.DataBean implements Serializable {
        private List<PostTitleBean> admin_title;

        public List<PostTitleBean> getAdmin_title() {
            return this.admin_title;
        }

        @Override // com.rtk.app.bean.UserRankBean.DataBean
        public String getUid() {
            return this.uid;
        }

        public boolean isBbsAdmin() {
            return TextUtils.equals(this.admin.getBbs_admin(), "1");
        }

        public boolean isHeadLeader() {
            return TextUtils.equals(this.admin.getLeader(), "1");
        }

        public boolean isLeader() {
            return isHeadLeader() || isSecondLeader();
        }

        public boolean isSecondLeader() {
            return TextUtils.equals(this.admin.getLeader(), "2");
        }

        public boolean isUpAdmin() {
            return TextUtils.equals(this.admin.getUp_admin(), "1");
        }

        public void setAdmin_title(List<PostTitleBean> list) {
            this.admin_title = list;
        }

        @Override // com.rtk.app.bean.UserRankBean.DataBean
        public void setUid(String str) {
            this.uid = str;
        }
    }

    public int getCode() {
        return this.code;
    }

    public List<DataBean> getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(List<DataBean> list) {
        this.data = list;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
