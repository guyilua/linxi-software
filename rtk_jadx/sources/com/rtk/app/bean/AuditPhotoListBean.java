package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AuditPhotoListBean {
    private int code;
    private List<DataDTO> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataDTO {
        private String addtime;
        private CheckUserDTO check_user;
        private String cid;
        private String pic;
        private String state;
        private String thumPic;
        private String uid;
        private UserDTO user;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class CheckUserDTO {
            private String check_face;
            private String check_nickname;
            private String check_reason;
            private String check_time;
            private String check_uid;

            public String getCheck_face() {
                return this.check_face;
            }

            public String getCheck_nickname() {
                return this.check_nickname;
            }

            public String getCheck_reason() {
                return this.check_reason;
            }

            public String getCheck_time() {
                return this.check_time;
            }

            public String getCheck_uid() {
                return this.check_uid;
            }

            public void setCheck_face(String str) {
                this.check_face = str;
            }

            public void setCheck_nickname(String str) {
                this.check_nickname = str;
            }

            public void setCheck_reason(String str) {
                this.check_reason = str;
            }

            public void setCheck_time(String str) {
                this.check_time = str;
            }

            public void setCheck_uid(String str) {
                this.check_uid = str;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class UserDTO {
            private String face;
            private String id;
            private String nickname;
            private UserTitleBean user_title;

            public String getFace() {
                return this.face;
            }

            public String getId() {
                return this.id;
            }

            public String getNickname() {
                return this.nickname;
            }

            public UserTitleBean getUser_title() {
                return this.user_title;
            }

            public void setFace(String str) {
                this.face = str;
            }

            public void setId(String str) {
                this.id = str;
            }

            public void setNickname(String str) {
                this.nickname = str;
            }

            public void setUser_title(UserTitleBean userTitleBean) {
                this.user_title = userTitleBean;
            }
        }

        public String getAddtime() {
            return this.addtime;
        }

        public CheckUserDTO getCheck_user() {
            return this.check_user;
        }

        public String getCid() {
            return this.cid;
        }

        public String getPic() {
            return this.pic;
        }

        public String getState() {
            return this.state;
        }

        public String getThumPic() {
            return this.thumPic;
        }

        public String getUid() {
            return this.uid;
        }

        public UserDTO getUser() {
            return this.user;
        }

        public void setAddtime(String str) {
            this.addtime = str;
        }

        public void setCheck_user(CheckUserDTO checkUserDTO) {
            this.check_user = checkUserDTO;
        }

        public void setCid(String str) {
            this.cid = str;
        }

        public void setPic(String str) {
            this.pic = str;
        }

        public void setState(String str) {
            this.state = str;
        }

        public void setThumPic(String str) {
            this.thumPic = str;
        }

        public void setUid(String str) {
            this.uid = str;
        }

        public void setUser(UserDTO userDTO) {
            this.user = userDTO;
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
