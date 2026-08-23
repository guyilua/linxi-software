package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpAuditAgainListBean {
    private int code;
    private List<DataDTO> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataDTO {
        private String addtime;
        private String check_time2;
        private CheckUser2 check_user2;
        private String dataPath;
        private String dataSize;
        private int id;
        private InstallationBean installation;
        private String isshow2;
        private String md5;
        private String msg2;
        private String packageName;
        private String showmsg2;
        private String sourceLogo;
        private String sourcePath;
        private String sourceSize;
        private int status2;
        private String status2Name;
        private List<UpDataPathListBean> upSourcePathList;
        private String varName;
        private String versionName;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public class CheckUser2 {
            private String check_face;
            private int check_isshow;
            private String check_msg;
            private String check_nickname;
            private String check_showmsg;
            private int check_status;
            private String check_status_name;
            private String check_time;
            private int check_uid;

            public CheckUser2() {
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

        public String getCheck_time2() {
            return this.check_time2;
        }

        public CheckUser2 getCheck_user2() {
            return this.check_user2;
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

        public String getIsshow2() {
            return this.isshow2;
        }

        public String getMd5() {
            return this.md5;
        }

        public String getMsg2() {
            return this.msg2;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public String getShowmsg2() {
            return this.showmsg2;
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

        public int getStatus2() {
            return this.status2;
        }

        public String getStatus2Name() {
            return this.status2Name;
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

        public void setCheck_time2(String str) {
            this.check_time2 = str;
        }

        public void setCheck_user2(CheckUser2 checkUser2) {
            this.check_user2 = checkUser2;
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

        public void setIsshow2(String str) {
            this.isshow2 = str;
        }

        public void setMd5(String str) {
            this.md5 = str;
        }

        public void setMsg2(String str) {
            this.msg2 = str;
        }

        public void setPackageName(String str) {
            this.packageName = str;
        }

        public void setShowmsg2(String str) {
            this.showmsg2 = str;
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

        public void setStatus2(int i) {
            this.status2 = i;
        }

        public void setStatus2Name(String str) {
            this.status2Name = str;
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
