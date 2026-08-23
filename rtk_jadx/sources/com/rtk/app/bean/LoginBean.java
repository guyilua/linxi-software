package com.rtk.app.bean;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.MyApplication;
import com.rtk.app.tool.v;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class LoginBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private AdminBean admin;
        private AuthorityBean authority;
        private long birthday;
        private long created;
        private String email;
        private String face;
        private String face_new;
        private int level;
        private String mobile;
        private String nickname;
        private String nickname_new;
        private QqLoginBean qqLogin;
        private int sex;
        private String signature;
        private String signature_new;
        private String token;
        private int uid;
        private String upAdmin;
        private WxLoginBean wxLogin;

        public AdminBean getAdmin() {
            return this.admin;
        }

        public AuthorityBean getAuthority() {
            return this.authority;
        }

        public long getBirthday() {
            return this.birthday;
        }

        public long getCreated() {
            return this.created;
        }

        public String getEmail() {
            return this.email;
        }

        public String getFace() {
            return this.face;
        }

        public String getFace_new() {
            return this.face_new;
        }

        public int getLevel() {
            return this.level;
        }

        public String getMobile() {
            return this.mobile;
        }

        public String getNickname() {
            return this.nickname;
        }

        public String getNickname_new() {
            return this.nickname_new;
        }

        public QqLoginBean getQqLogin() {
            return this.qqLogin;
        }

        public int getSex() {
            return this.sex;
        }

        public String getSignature() {
            return this.signature;
        }

        public String getSignature_new() {
            return this.signature_new;
        }

        public String getToken() {
            return this.token;
        }

        public int getUid() {
            return this.uid;
        }

        public String getUpAdmin() {
            return this.upAdmin;
        }

        public WxLoginBean getWxLogin() {
            return this.wxLogin;
        }

        public void setAdmin(AdminBean adminBean) {
            this.admin = adminBean;
        }

        public void setAuthority(AuthorityBean authorityBean) {
            this.authority = authorityBean;
        }

        public void setBirthday(long j) {
            this.birthday = j;
        }

        public void setCreated(long j) {
            this.created = j;
        }

        public void setEmail(String str) {
            this.email = str;
        }

        public void setFace(String str) {
            this.face = str;
        }

        public void setFace_new(String str) {
            this.face_new = str;
        }

        public void setHome5BeanToLoginBean(Home5ImfromationBean home5ImfromationBean) {
            Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
            setAdmin(home5ImfromationBean.getData().getAdmin());
            setLevel(Integer.parseInt(home5ImfromationBean.getData().getLevelNum()));
            MainActivity.p.getData().setAuthority(home5ImfromationBean.getData().getAuthority());
            MainActivity.p.getData().setQqLogin(home5ImfromationBean.getData().getQqLogin());
            MainActivity.p.getData().setWxLogin(home5ImfromationBean.getData().getWxLogin());
            MainActivity.p.getData().setFace_new(home5ImfromationBean.getData().getFace_new());
            MainActivity.p.getData().setSignature_new(home5ImfromationBean.getData().getSignature_new());
            MainActivity.p.getData().setNickname_new(home5ImfromationBean.getData().getNickname_new());
            v.h(MyApplication.b(), "userInformation", create.toJson(MainActivity.p));
        }

        public void setLevel(int i) {
            this.level = i;
        }

        public void setMobile(String str) {
            this.mobile = str;
        }

        public void setNickname(String str) {
            this.nickname = str;
        }

        public void setNickname_new(String str) {
            this.nickname_new = str;
        }

        public void setQqLogin(QqLoginBean qqLoginBean) {
            this.qqLogin = qqLoginBean;
        }

        public void setSex(int i) {
            this.sex = i;
        }

        public void setSignature(String str) {
            this.signature = str;
        }

        public void setSignature_new(String str) {
            this.signature_new = str;
        }

        public void setToken(String str) {
            this.token = str;
        }

        public void setUid(int i) {
            this.uid = i;
        }

        public void setUpAdmin(String str) {
            this.upAdmin = str;
        }

        public void setWxLogin(WxLoginBean wxLoginBean) {
            this.wxLogin = wxLoginBean;
        }
    }

    public int getCode() {
        return this.code;
    }

    public DataBean getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
