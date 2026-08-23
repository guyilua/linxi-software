package com.rtk.app.bean;

import com.google.gson.a.c;
import java.io.Serializable;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpApkCommentAuditBean implements Serializable {

    @c("code")
    private Integer code;

    @c("data")
    private List<DataDTO> data;

    @c("msg")
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataDTO implements Serializable {

        @c("check_user")
        private CheckUserDTO check_user;

        @c("content")
        private String content;

        @c("created")
        private String created;

        @c("id")
        private String id;

        @c("pic")
        private List<String> pic;

        @c("root_reply_id")
        private String root_reply_id;

        @c("sid")
        private String sid;

        @c("state")
        private String state;

        @c("state3")
        private String state3;

        @c("uid")
        private String uid;

        @c("user")
        private UserDTO user;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class CheckUserDTO implements Serializable {

            @c("check_face")
            private String check_face;

            @c("check_nickname")
            private String check_nickname;

            @c("check_reason")
            private String check_reason;

            @c("check_time")
            private String check_time;

            @c("check_uid")
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
        public static class UserDTO implements Serializable {

            @c("face")
            private String face;

            @c("id")
            private String id;

            @c("nickname")
            private String nickname;

            @c("user_title")
            private UserTitleDao user_title;

            /* loaded from: /tmp/rtk_apk/classes3.dex */
            public static class UserTitleDao implements Serializable {

                @c("color")
                private String color;

                @c("txt")
                private String txt;

                public String getColor() {
                    return this.color;
                }

                public String getTxt() {
                    return this.txt;
                }

                public void setColor(String str) {
                    this.color = str;
                }

                public void setTxt(String str) {
                    this.txt = str;
                }
            }

            public String getFace() {
                return this.face;
            }

            public String getId() {
                return this.id;
            }

            public String getNickname() {
                return this.nickname;
            }

            public UserTitleDao getUser_title() {
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

            public void setUser_title(UserTitleDao userTitleDao) {
                this.user_title = userTitleDao;
            }
        }

        public CheckUserDTO getCheck_user() {
            return this.check_user;
        }

        public String getContent() {
            return this.content;
        }

        public String getCreated() {
            return this.created;
        }

        public String getId() {
            return this.id;
        }

        public List<String> getPic() {
            return this.pic;
        }

        public String getRoot_reply_id() {
            return this.root_reply_id;
        }

        public String getSid() {
            return this.sid;
        }

        public String getState() {
            return this.state;
        }

        public String getState3() {
            return this.state3;
        }

        public String getUid() {
            return this.uid;
        }

        public UserDTO getUser() {
            return this.user;
        }

        public void setCheck_user(CheckUserDTO checkUserDTO) {
            this.check_user = checkUserDTO;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setCreated(String str) {
            this.created = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setPic(List<String> list) {
            this.pic = list;
        }

        public void setRoot_reply_id(String str) {
            this.root_reply_id = str;
        }

        public void setSid(String str) {
            this.sid = str;
        }

        public void setState(String str) {
            this.state = str;
        }

        public void setState3(String str) {
            this.state3 = str;
        }

        public void setUid(String str) {
            this.uid = str;
        }

        public void setUser(UserDTO userDTO) {
            this.user = userDTO;
        }
    }

    public Integer getCode() {
        return this.code;
    }

    public List<DataDTO> getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public void setData(List<DataDTO> list) {
        this.data = list;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
