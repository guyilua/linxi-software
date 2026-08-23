package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyUpAuditListBean {
    private int code;
    private List<DataDTO> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataDTO {
        private String addtime;
        private String check_time3;
        private CheckUser3 check_user3;
        private String dataPath;
        private String dataSize;
        private int id;
        private InstallationBean installation;
        private String isshow3;
        private String md5;
        private String msg3;
        private String packageName;
        private String showmsg3;
        private String sourceLogo;
        private String sourcePath;
        private String sourceSize;
        private int status3;
        private String status3Name;
        private List<UpDataPathListBean> upSourcePathList;
        private String varName;
        private String versionName;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public class CheckUser3 {
            private String check_face;
            private int check_isshow;
            private String check_msg;
            private String check_nickname;
            private String check_showmsg;
            private int check_status;
            private String check_status_name;
            private String check_time;
            private int check_uid;

            public CheckUser3() {
            }

            public String getCheck_face() {
                return this.check_face;
            }

            public int getCheck_isshow() {
                return this.check_isshow;
            }

            public String getCheck_msg() {
                return this.check_msg;
            }

            public String getCheck_nickname() {
                return this.check_nickname;
            }

            public String getCheck_showmsg() {
                return this.check_showmsg;
            }

            public int getCheck_status() {
                return this.check_status;
            }

            public String getCheck_status_name() {
                return this.check_status_name;
            }

            public String getCheck_time() {
                return this.check_time;
            }

            public int getCheck_uid() {
                return this.check_uid;
            }

            public void setCheck_face(String str) {
                this.check_face = str;
            }

            public void setCheck_isshow(int i) {
                this.check_isshow = i;
            }

            public void setCheck_msg(String str) {
                this.check_msg = str;
            }

            public void setCheck_nickname(String str) {
                this.check_nickname = str;
            }

            public void setCheck_showmsg(String str) {
                this.check_showmsg = str;
            }

            public void setCheck_status(int i) {
                this.check_status = i;
            }

            public void setCheck_status_name(String str) {
                this.check_status_name = str;
            }

            public void setCheck_time(String str) {
                this.check_time = str;
            }

            public void setCheck_uid(int i) {
                this.check_uid = i;
            }
        }

        public String getAddtime() {
            return this.addtime;
        }

        public String getCheck_time3() {
            return this.check_time3;
        }

        public CheckUser3 getCheck_user3() {
            return this.check_user3;
        }

        public String getDataPath() {
            return this.dataPath;
        }

        public String getDataSize() {
            return this.dataSize;
        }

        public int getId() {
            return this.id;
        }

        public InstallationBean getInstallation() {
            return this.installation;
        }

        public String getIsshow3() {
            return this.isshow3;
        }

        public String getMd5() {
            return this.md5;
        }

        public String getMsg3() {
            return this.msg3;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public String getShowmsg3() {
            return this.showmsg3;
        }

        public String getSourceLogo() {
            return this.sourceLogo;
        }

        public String getSourcePath() {
            return this.sourcePath;
        }

        public String getSourceSize() {
            return this.sourceSize;
        }

        public int getStatus3() {
            return this.status3;
        }

        public String getStatus3Name() {
            return this.status3Name;
        }

        public List<UpDataPathListBean> getUpSourcePathList() {
            return this.upSourcePathList;
        }

        public String getVarName() {
            return this.varName;
        }

        public String getVersionName() {
            return this.versionName;
        }

        public void setAddtime(String str) {
            this.addtime = str;
        }

        public void setCheck_time3(String str) {
            this.check_time3 = str;
        }

        public void setCheck_user3(CheckUser3 checkUser3) {
            this.check_user3 = checkUser3;
        }

        public void setDataPath(String str) {
            this.dataPath = str;
        }

        public void setDataSize(String str) {
            this.dataSize = str;
        }

        public void setId(int i) {
            this.id = i;
        }

        public void setInstallation(InstallationBean installationBean) {
            this.installation = installationBean;
        }

        public void setIsshow3(String str) {
            this.isshow3 = str;
        }

        public void setMd5(String str) {
            this.md5 = str;
        }

        public void setMsg3(String str) {
            this.msg3 = str;
        }

        public void setPackageName(String str) {
            this.packageName = str;
        }

        public void setShowmsg3(String str) {
            this.showmsg3 = str;
        }

        public void setSourceLogo(String str) {
            this.sourceLogo = str;
        }

        public void setSourcePath(String str) {
            this.sourcePath = str;
        }

        public void setSourceSize(String str) {
            this.sourceSize = str;
        }

        public void setStatus3(int i) {
            this.status3 = i;
        }

        public void setStatus3Name(String str) {
            this.status3Name = str;
        }

        public void setUpSourcePathList(List<UpDataPathListBean> list) {
            this.upSourcePathList = list;
        }

        public void setVarName(String str) {
            this.varName = str;
        }

        public void setVersionName(String str) {
            this.versionName = str;
        }
    }

    public int getCode() {
        return this.code;
    }

    public List<DataDTO> getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(List<DataDTO> list) {
        this.data = list;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
