package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ExchangeGoldCoinsBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private ExchangeBean exchange;
        private String tips;
        private UserBean user;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class UserBean {
            private String coin;
            private String nickname;
            private String rcoin;

            public String getCoin() {
                return this.coin;
            }

            public String getNickname() {
                return this.nickname;
            }

            public String getRcoin() {
                return this.rcoin;
            }

            public void setCoin(String str) {
                this.coin = str;
            }

            public void setNickname(String str) {
                this.nickname = str;
            }

            public void setRcoin(String str) {
                this.rcoin = str;
            }
        }

        public ExchangeBean getExchange() {
            return this.exchange;
        }

        public String getTips() {
            return this.tips;
        }

        public UserBean getUser() {
            return this.user;
        }

        public void setExchange(ExchangeBean exchangeBean) {
            this.exchange = exchangeBean;
        }

        public void setTips(String str) {
            this.tips = str;
        }

        public void setUser(UserBean userBean) {
            this.user = userBean;
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
