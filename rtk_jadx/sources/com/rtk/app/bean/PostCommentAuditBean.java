package com.rtk.app.bean;

import java.io.Serializable;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostCommentAuditBean {
    private int code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ConvDataBean {
        private String content;
        private List<ListPostGameBean> list_post_game;
        private List<ListPostImgBean> list_post_img;
        private List<ListPostPostBean> list_post_post;
        private List<ListPostUpfileBean> list_post_upfile;
        private List<ListPostUserBean> list_post_user;
        private List<PostTitleBean> post_title;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class ListPostGameBean implements Serializable {
            private String SignaturesMD5;
            private List<DownListBean> downlist;
            private String game_logo;
            private String game_name;
            private int id;
            private int isapk;
            private String packageName;
            private String package_size;
            private int version_code;

            public List<DownListBean> getDownlist() {
                return this.downlist;
            }

            public String getGame_logo() {
                return this.game_logo;
            }

            public String getGame_name() {
                return this.game_name;
            }

            public int getId() {
                return this.id;
            }

            public int getIsapk() {
                return this.isapk;
            }

            public String getPackageName() {
                return this.packageName;
            }

            public String getPackage_size() {
                return this.package_size;
            }

            public String getSignaturesMD5() {
                return this.SignaturesMD5;
            }

            public int getVersion_code() {
                return this.version_code;
            }

            public void setDownlist(List<DownListBean> list) {
                this.downlist = list;
            }

            public void setGame_logo(String str) {
                this.game_logo = str;
            }

            public void setGame_name(String str) {
                this.game_name = str;
            }

            public void setId(int i) {
                this.id = i;
            }

            public void setIsapk(int i) {
                this.isapk = i;
            }

            public void setPackageName(String str) {
                this.packageName = str;
            }

            public void setPackage_size(String str) {
                this.package_size = str;
            }

            public void setSignaturesMD5(String str) {
                this.SignaturesMD5 = str;
            }

            public void setVersion_code(int i) {
                this.version_code = i;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class ListPostUpfileBean implements Serializable {
            private int id;
            private String md5;
            private String packageName;
            private String sourceLogo;
            private String sourcePath;
            private String sourceSize;
            private String varName;
            private int versionCode;

            public int getId() {
                return this.id;
            }

            public String getMd5() {
                return this.md5;
            }

            public String getPackageName() {
                return this.packageName;
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

            public String getVarName() {
                return this.varName;
            }

            public int getVersionCode() {
                return this.versionCode;
            }

            public void setId(int i) {
                this.id = i;
            }

            public void setMd5(String str) {
                this.md5 = str;
            }

            public void setPackageName(String str) {
                this.packageName = str;
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

            public void setVarName(String str) {
                this.varName = str;
            }

            public void setVersionCode(int i) {
                this.versionCode = i;
            }
        }

        public String getContent() {
            return this.content;
        }

        public List<ListPostGameBean> getList_post_game() {
            return this.list_post_game;
        }

        public List<ListPostImgBean> getList_post_img() {
            return this.list_post_img;
        }

        public List<ListPostPostBean> getList_post_post() {
            return this.list_post_post;
        }

        public List<ListPostUpfileBean> getList_post_upfile() {
            return this.list_post_upfile;
        }

        public List<ListPostUserBean> getList_post_user() {
            return this.list_post_user;
        }

        public List<PostTitleBean> getPost_title() {
            return this.post_title;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setList_post_game(List<ListPostGameBean> list) {
            this.list_post_game = list;
        }

        public void setList_post_img(List<ListPostImgBean> list) {
            this.list_post_img = list;
        }

        public void setList_post_post(List<ListPostPostBean> list) {
            this.list_post_post = list;
        }

        public void setList_post_upfile(List<ListPostUpfileBean> list) {
            this.list_post_upfile = list;
        }

        public void setList_post_user(List<ListPostUserBean> list) {
            this.list_post_user = list;
        }

        public void setPost_title(List<PostTitleBean> list) {
            this.post_title = list;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private CheckUser check_user3;
        private ConvDataBean convData;
        private String created;
        private int display_mode;
        private int id;
        private ModulesBean modules;
        private PostsBean posts;
        private int reply_id;
        private int root_reply_id;
        private int state;
        private int state3;
        private UserBean user;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class ModulesBean {
            private int id;
            private String name;

            public int getId() {
                return this.id;
            }

            public String getName() {
                return this.name;
            }

            public void setId(int i) {
                this.id = i;
            }

            public void setName(String str) {
                this.name = str;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class PostsBean {
            private int id;
            private String title;

            public int getId() {
                return this.id;
            }

            public String getTitle() {
                return this.title;
            }

            public void setId(int i) {
                this.id = i;
            }

            public void setTitle(String str) {
                this.title = str;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class UserBean {
            private int admin;
            private int bbsAdmin;
            private String face;
            private String face_1;
            private String face_2;
            private String face_3;
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

            public String getFace_1() {
                return this.face_1;
            }

            public String getFace_2() {
                return this.face_2;
            }

            public String getFace_3() {
                return this.face_3;
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

            public int getUserAdmin() {
                return this.userAdmin;
            }

            public void setAdmin(int i) {
                this.admin = i;
            }

            public void setBbsAdmin(int i) {
                this.bbsAdmin = i;
            }

            public void setFace(String str) {
                this.face = str;
            }

            public void setFace_1(String str) {
                this.face_1 = str;
            }

            public void setFace_2(String str) {
                this.face_2 = str;
            }

            public void setFace_3(String str) {
                this.face_3 = str;
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

            public void setUpAdmin(int i) {
                this.upAdmin = i;
            }

            public void setUserAdmin(int i) {
                this.userAdmin = i;
            }
        }

        public CheckUser getCheck_user3() {
            return this.check_user3;
        }

        public ConvDataBean getConvData() {
            return this.convData;
        }

        public String getCreated() {
            return this.created;
        }

        public int getDisplay_mode() {
            return this.display_mode;
        }

        public int getId() {
            return this.id;
        }

        public ModulesBean getModules() {
            return this.modules;
        }

        public PostsBean getPosts() {
            return this.posts;
        }

        public int getReply_id() {
            return this.reply_id;
        }

        public int getRoot_reply_id() {
            return this.root_reply_id;
        }

        public int getState() {
            return this.state;
        }

        public int getState3() {
            return this.state3;
        }

        public UserBean getUser() {
            return this.user;
        }

        public void setCheck_user3(CheckUser checkUser) {
            this.check_user3 = checkUser;
        }

        public void setConvData(ConvDataBean convDataBean) {
            this.convData = convDataBean;
        }

        public void setCreated(String str) {
            this.created = str;
        }

        public void setDisplay_mode(int i) {
            this.display_mode = i;
        }

        public void setId(int i) {
            this.id = i;
        }

        public void setModules(ModulesBean modulesBean) {
            this.modules = modulesBean;
        }

        public void setPosts(PostsBean postsBean) {
            this.posts = postsBean;
        }

        public void setReply_id(int i) {
            this.reply_id = i;
        }

        public void setRoot_reply_id(int i) {
            this.root_reply_id = i;
        }

        public void setState(int i) {
            this.state = i;
        }

        public void setState3(int i) {
            this.state3 = i;
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
