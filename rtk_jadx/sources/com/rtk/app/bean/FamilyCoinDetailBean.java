package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyCoinDetailBean {
    private int code;
    private List<DataBean> data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private String balance_family_coin;
        private String transaction_coin;
        private String transaction_time;
        private TransactionTypeBean transaction_type;
        private TransactionUserBean transaction_user;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class TransactionTypeBean {
            private String id;
            private String name;

            public String getId() {
                return this.id;
            }

            public String getName() {
                return this.name;
            }

            public void setId(String str) {
                this.id = str;
            }

            public void setName(String str) {
                this.name = str;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class TransactionUserBean {
            private String face;
            private String nickname;
            private String uid;

            public String getFace() {
                return this.face;
            }

            public String getNickname() {
                return this.nickname;
            }

            public String getUid() {
                return this.uid;
            }

            public void setFace(String str) {
                this.face = str;
            }

            public void setNickname(String str) {
                this.nickname = str;
            }

            public void setUid(String str) {
                this.uid = str;
            }
        }

        public String getBalance_family_coin() {
            return this.balance_family_coin;
        }

        public String getTransaction_coin() {
            return this.transaction_coin;
        }

        public String getTransaction_time() {
            return this.transaction_time;
        }

        public TransactionTypeBean getTransaction_type() {
            return this.transaction_type;
        }

        public TransactionUserBean getTransaction_user() {
            return this.transaction_user;
        }

        public void setBalance_family_coin(String str) {
            this.balance_family_coin = str;
        }

        public void setTransaction_coin(String str) {
            this.transaction_coin = str;
        }

        public void setTransaction_time(String str) {
            this.transaction_time = str;
        }

        public void setTransaction_type(TransactionTypeBean transactionTypeBean) {
            this.transaction_type = transactionTypeBean;
        }

        public void setTransaction_user(TransactionUserBean transactionUserBean) {
            this.transaction_user = transactionUserBean;
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
