package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AuditListSignatureBean {
    private int code;
    private List<DataDTO> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataDTO {
        private String add_time;
        private CheckUserDTO check_user;
        private String cid;
        private String new_signature;
        private String old_signature;
        private String state;
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

            public UserTitleBean getUserTitleBean() {
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

            public void setUserTitleBean(UserTitleBean userTitleBean) {
                this.user_title = userTitleBean;
            }
        }

        public String getAdd_time() {
            return this.add_time;
        }

        public CheckUserDTO getCheck_user() {
            return this.check_user;
        }

        public String getCid() {
            return this.cid;
        }

        public String getNew_signature() {
            return this.new_signature;
        }

        public String getOld_signature() {
            return this.old_signature;
        }

        public String getState() {
            return this.state;
        }

        public String getUid() {
            return this.uid;
        }

        public UserDTO getUser() {
            return this.user;
        }

        public void setAdd_time(String str) {
            this.add_time = str;
        }

        public void setCheck_user(CheckUserDTO checkUserDTO) {
            this.check_user = checkUserDTO;
        }

        public void setCid(String str) {
            this.cid = str;
        }

        public void setNew_signature(String str) {
            this.new_signature = str;
        }

        public void setOld_signature(String str) {
            this.old_signature = str;
        }

        public void setState(String str) {
            this.state = str;
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
