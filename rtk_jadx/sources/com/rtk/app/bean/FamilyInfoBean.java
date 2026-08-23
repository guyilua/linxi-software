package com.rtk.app.bean;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyInfoBean implements Serializable {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean implements Serializable {
        private String add_date;
        private String answer;
        private FamilyAdminBean family_admin;
        private String family_coin;
        private String family_cover;
        private String family_id;
        private String family_introduce;
        private String family_logo;
        private String family_name;
        private String family_notice;
        private String family_sn;
        private String is_join;
        private int join_coin;
        private String member_num;
        private InformNumListBean messageNum;
        private ModuleBean module_list;
        private List<PostTitleBean> my_role;
        private int open_type;
        private int posts_num;
        private String question;
        private int up_num;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class FamilyAdminBean implements Serializable {
            private List<LeaderBean> bbs_admin;
            private LeaderBean leader;
            private List<LeaderBean> second_leader;
            private List<LeaderBean> up_admin;

            public List<LeaderBean> getBbs_admin() {
                return this.bbs_admin;
            }

            public LeaderBean getLeader() {
                return this.leader;
            }

            public List<LeaderBean> getSecond_leader() {
                return this.second_leader;
            }

            public List<LeaderBean> getUp_admin() {
                return this.up_admin;
            }

            public void setBbs_admin(List<LeaderBean> list) {
                this.bbs_admin = list;
            }

            public void setLeader(LeaderBean leaderBean) {
                this.leader = leaderBean;
            }

            public void setSecond_leader(List<LeaderBean> list) {
                this.second_leader = list;
            }

            public void setUp_admin(List<LeaderBean> list) {
                this.up_admin = list;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class ModuleBean extends TagsBean implements Serializable {
            List<TagsBean> tagsList;

            public List<TagsBean> getSublist() {
                return this.tagsList;
            }

            public void setSublist(List<TagsBean> list) {
                this.tagsList = list;
            }
        }

        public String getAdd_date() {
            return this.add_date;
        }

        public String getAnswer() {
            return this.answer;
        }

        public FamilyAdminBean getFamily_admin() {
            return this.family_admin;
        }

        public String getFamily_coin() {
            return this.family_coin;
        }

        public String getFamily_cover() {
            return this.family_cover;
        }

        public String getFamily_id() {
            return this.family_id;
        }

        public String getFamily_introduce() {
            return this.family_introduce;
        }

        public String getFamily_logo() {
            return this.family_logo;
        }

        public String getFamily_name() {
            return this.family_name;
        }

        public String getFamily_notice() {
            return this.family_notice;
        }

        public String getFamily_sn() {
            return this.family_sn;
        }

        public String getIsJoin() {
            return this.is_join;
        }

        public int getJoin_coin() {
            return this.join_coin;
        }

        public String getMember_num() {
            return this.member_num;
        }

        public InformNumListBean getMessageNum() {
            return this.messageNum;
        }

        public ModuleBean getModule() {
            return this.module_list;
        }

        public List<PostTitleBean> getMy_role() {
            return this.my_role;
        }

        public int getOpen_type() {
            return this.open_type;
        }

        public int getPosts_num() {
            return this.posts_num;
        }

        public String getQuestion() {
            return this.question;
        }

        public int getUp_num() {
            return this.up_num;
        }

        public boolean isAdmin(String str) {
            return isHeadLeader(str) || isSecondLeader(str) || isUpAdmin(str) || isBbsAdmin(str);
        }

        public boolean isBbsAdmin(String str) {
            FamilyAdminBean familyAdminBean = this.family_admin;
            if (familyAdminBean == null || familyAdminBean.bbs_admin == null) {
                return false;
            }
            Iterator it = this.family_admin.bbs_admin.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(((LeaderBean) it.next()).getId() + "", str)) {
                    return true;
                }
            }
            return false;
        }

        public boolean isHeadLeader(String str) {
            return TextUtils.equals(this.family_admin.leader.getId() + "", str);
        }

        public boolean isJoin() {
            return TextUtils.equals("1", this.is_join);
        }

        public boolean isLeader(String str) {
            return isHeadLeader(str) || isSecondLeader(str);
        }

        public boolean isSecondLeader(String str) {
            FamilyAdminBean familyAdminBean = this.family_admin;
            if (familyAdminBean == null || familyAdminBean.second_leader == null || this.family_admin.second_leader.isEmpty()) {
                return false;
            }
            Iterator it = this.family_admin.second_leader.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(((LeaderBean) it.next()).getId() + "", str)) {
                    return true;
                }
            }
            return false;
        }

        public boolean isUpAdmin(String str) {
            FamilyAdminBean familyAdminBean = this.family_admin;
            if (familyAdminBean == null || familyAdminBean.up_admin == null) {
                return false;
            }
            Iterator it = this.family_admin.up_admin.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(((LeaderBean) it.next()).getId() + "", str)) {
                    return true;
                }
            }
            return false;
        }

        public void setAdd_date(String str) {
            this.add_date = str;
        }

        public void setFamily_admin(FamilyAdminBean familyAdminBean) {
            this.family_admin = familyAdminBean;
        }

        public void setFamily_id(String str) {
            this.family_id = str;
        }

        public void setFamily_introduce(String str) {
            this.family_introduce = str;
        }

        public void setFamily_logo(String str) {
            this.family_logo = str;
        }

        public void setFamily_name(String str) {
            this.family_name = str;
        }

        public void setFamily_notice(String str) {
            this.family_notice = str;
        }

        public void setFamily_sn(String str) {
            this.family_sn = str;
        }

        public void setJoin_coin(int i) {
            this.join_coin = i;
        }

        public void setMember_num(String str) {
            this.member_num = str;
        }

        public void setModule(ModuleBean moduleBean) {
            this.module_list = moduleBean;
        }

        public void setPosts_num(int i) {
            this.posts_num = i;
        }

        public void setUp_num(int i) {
            this.up_num = i;
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
