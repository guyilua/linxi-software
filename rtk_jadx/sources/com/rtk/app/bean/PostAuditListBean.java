package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostAuditListBean {
    private int code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private int addtime;
        private String before;
        private CheckUser check_user3;
        private int clickNum;
        private String client;
        private int commentNum;
        private String content;
        private String deviceName;
        private int edittime;
        private int id;
        private int levelCommentNum;
        private int mid;
        private String os_version;
        private List<String> pic;
        private List<PostTitleBean> post_title;
        private int state;
        private int state3;
        private int tags;
        private String title;
        private int type;
        private UserBean user;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class UserBean {
            private int admin;
            private int bbsAdmin;
            private String face;
            private int id;
            private String nickname;
            private String qq;
            private int upAdmin;
            private int userAdmin;

            public int getAdmin() {
                return this.admin;
            }

            public int getBbsAdmin() {
                return this.bbsAdmin;
            }

            public String getFace() {
                return this.face;
            }

            public int getId() {
                return this.id;
            }

            public String getNickname() {
                return this.nickname;
            }

            public String getQq() {
                return this.qq;
            }

            public int getUpAdmin() {
                return this.upAdmin;
            }

            public void setAdmin(int i) {
                this.admin = i;
            }

            public void setFace(String str) {
                this.face = str;
            }

            public void setId(int i) {
                this.id = i;
            }

            public void setNickname(String str) {
                this.nickname = str;
            }

            public void setQq(String str) {
                this.qq = str;
            }
        }

        public int getAddtime() {
            return this.addtime;
        }

        public String getBefore() {
            return this.before;
        }

        public CheckUser getCheck_user3() {
            return this.check_user3;
        }

        public int getClickNum() {
            return this.clickNum;
        }

        public String getClient() {
            return this.client;
        }

        public int getCommentNum() {
            return this.commentNum;
        }

        public String getContent() {
            return this.content;
        }

        public String getDeviceName() {
            return this.deviceName;
        }

        public int getEdittime() {
            return this.edittime;
        }

        public int getId() {
            return this.id;
        }

        public int getLevelCommentNum() {
            return this.levelCommentNum;
        }

        public int getMid() {
            return this.mid;
        }

        public String getOs_version() {
            return this.os_version;
        }

        public List<String> getPic() {
            return this.pic;
        }

        public List<PostTitleBean> getPost_title() {
            return this.post_title;
        }

        public int getState() {
            return this.state;
        }

        public int getState3() {
            return this.state3;
        }

        public int getTags() {
            return this.tags;
        }

        public String getTitle() {
            return this.title;
        }

        public int getType() {
            return this.type;
        }

        public UserBean getUser() {
            return this.user;
        }

        public void setAddtime(int i) {
            this.addtime = i;
        }

        public void setBefore(String str) {
            this.before = str;
        }

        public void setCheck_user3(CheckUser checkUser) {
            this.check_user3 = checkUser;
        }

        public void setClient(String str) {
            this.client = str;
        }

        public void setCommentNum(int i) {
            this.commentNum = i;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setDeviceName(String str) {
            this.deviceName = str;
        }

        public void setEdittime(int i) {
            this.edittime = i;
        }

        public void setId(int i) {
            this.id = i;
        }

        public void setMid(int i) {
            this.mid = i;
        }

        public void setOs_version(String str) {
            this.os_version = str;
        }

        public void setPic(List<String> list) {
            this.pic = list;
        }

        public void setState(int i) {
            this.state = i;
        }

        public void setState3(int i) {
            this.state3 = i;
        }

        public void setTags(int i) {
            this.tags = i;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setType(int i) {
            this.type = i;
        }

        public void setUser(UserBean userBean) {
            this.user = userBean;
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
