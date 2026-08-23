package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home5MyGoldBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private int income;
        private List<ListBean> list;
        private int outcome;
        private int totalCoin;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class ListBean {
            private String addtime;
            private String coin;
            private String id;
            private String type;

            public String getAddtime() {
                return this.addtime;
            }

            public String getCoin() {
                return this.coin;
            }

            public String getId() {
                return this.id;
            }

            public String getType() {
                return this.type;
            }

            public void setAddtime(String str) {
                this.addtime = str;
            }

            public void setCoin(String str) {
                this.coin = str;
            }

            public void setId(String str) {
                this.id = str;
            }

            public void setType(String str) {
                this.type = str;
            }
        }

        public int getIncome() {
            return this.income;
        }

        public List<ListBean> getList() {
            return this.list;
        }

        public int getOutcome() {
            return this.outcome;
        }

        public int getTotalCoin() {
            return this.totalCoin;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
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
