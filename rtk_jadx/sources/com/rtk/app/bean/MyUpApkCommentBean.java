package com.rtk.app.bean;

import com.rtk.app.tool.c0;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyUpApkCommentBean {
    private int code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private int cmtid;
        private String content;
        private int du;
        private int floor;
        private String hisContent;
        private String hisFace;
        private int hisFloor;
        private String hisName;
        private String hisUid;
        private InstallationBean installation;
        private int is_admin;
        private int isdu;
        private int isuu;
        private String packageName;
        private int reply_id;
        private int root_reply_id;
        private String sourceLogo;
        private String sourceName;
        private String sourcePath;
        private int star;
        private String time;
        private String u_face;
        private String u_name;
        private int uid;
        private List<UpDataPathListBean> upDataPathList;
        private List<UpSourcePathListBean> upSourcePathList;
        private int usid;
        private int uu;
        private String varName;

        public int getCmtid() {
            return this.cmtid;
        }

        public String getContent() {
            return this.content;
        }

        public int getDu() {
            return this.du;
        }

        public int getFloor() {
            return this.floor;
        }

        public String getHisContent() {
            return this.hisContent;
        }

        public String getHisFace() {
            return this.hisFace;
        }

        public int getHisFloor() {
            return this.hisFloor;
        }

        public String getHisName() {
            return this.hisName;
        }

        public String getHisUid() {
            return this.hisUid;
        }

        public InstallationBean getInstallation() {
            return this.installation;
        }

        public int getIs_admin() {
            return this.is_admin;
        }

        public int getIsdu() {
            return this.isdu;
        }

        public int getIsuu() {
            return this.isuu;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public int getReply_id() {
            return this.reply_id;
        }

        public int getRoot_reply_id() {
            return this.root_reply_id;
        }

        public String getSourceLogo() {
            return this.sourceLogo;
        }

        public String getSourceName() {
            return this.sourceName;
        }

        public String getSourcePath() {
            return this.sourcePath;
        }

        public int getStar() {
            return this.star;
        }

        public String getTime() {
            return this.time;
        }

        public String getU_face() {
            return this.u_face;
        }

        public String getU_name() {
            return this.u_name;
        }

        public int getUid() {
            return this.uid;
        }

        public List<UpDataPathListBean> getUpDataPathList() {
            return this.upDataPathList;
        }

        public List<UpSourcePathListBean> getUpSourcePathList() {
            return this.upSourcePathList;
        }

        public int getUsid() {
            return this.usid;
        }

        public int getUu() {
            return this.uu;
        }

        public String getVarName() {
            return this.varName;
        }

        public boolean isZip() {
            return (getUpDataPathList() == null || getUpDataPathList().size() <= 0 || c0.q(getUpDataPathList().get(0).getUrl())) ? false : true;
        }

        public void setCmtid(int i) {
            this.cmtid = i;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setDu(int i) {
            this.du = i;
        }

        public void setFloor(int i) {
            this.floor = i;
        }

        public void setHisContent(String str) {
            this.hisContent = str;
        }

        public void setHisFace(String str) {
            this.hisFace = str;
        }

        public void setHisFloor(int i) {
            this.hisFloor = i;
        }

        public void setHisName(String str) {
            this.hisName = str;
        }

        public void setHisUid(String str) {
            this.hisUid = str;
        }

        public void setInstallation(InstallationBean installationBean) {
            this.installation = installationBean;
        }

        public void setIs_admin(int i) {
            this.is_admin = i;
        }

        public void setIsdu(int i) {
            this.isdu = i;
        }

        public void setIsuu(int i) {
            this.isuu = i;
        }

        public void setPackageName(String str) {
            this.packageName = str;
        }

        public void setReply_id(int i) {
            this.reply_id = i;
        }

        public void setRoot_reply_id(int i) {
            this.root_reply_id = i;
        }

        public void setSourceLogo(String str) {
            this.sourceLogo = str;
        }

        public void setSourceName(String str) {
            this.sourceName = str;
        }

        public void setSourcePath(String str) {
            this.sourcePath = str;
        }

        public void setStar(int i) {
            this.star = i;
        }

        public void setTime(String str) {
            this.time = str;
        }

        public void setU_face(String str) {
            this.u_face = str;
        }

        public void setU_name(String str) {
            this.u_name = str;
        }

        public void setUid(int i) {
            this.uid = i;
        }

        public void setUpDataPathList(List<UpDataPathListBean> list) {
            this.upDataPathList = list;
        }

        public void setUpSourcePathList(List<UpSourcePathListBean> list) {
            this.upSourcePathList = list;
        }

        public void setUsid(int i) {
            this.usid = i;
        }

        public void setUu(int i) {
            this.uu = i;
        }

        public void setVarName(String str) {
            this.varName = str;
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
