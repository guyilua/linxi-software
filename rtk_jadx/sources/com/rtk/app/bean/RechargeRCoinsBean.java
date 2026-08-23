package com.rtk.app.bean;

import com.rtk.app.bean.ExchangeGoldCoinsBean;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class RechargeRCoinsBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private List<PaymentMethodsBean> paymentMethodsNew;
        private ExchangeBean price;
        private RcoinInfoBean rcoinInfo;
        private ExchangeGoldCoinsBean.DataBean.UserBean user;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class RcoinInfoBean {
            private String descriptions;
            private String ratio;

            public String getDescriptions() {
                return this.descriptions;
            }

            public String getRatio() {
                return this.ratio;
            }

            public void setDescriptions(String str) {
                this.descriptions = str;
            }

            public void setRatio(String str) {
                this.ratio = str;
            }
        }

        public List<PaymentMethodsBean> getPaymentMethodsNew() {
            return this.paymentMethodsNew;
        }

        public ExchangeBean getPrice() {
            return this.price;
        }

        public RcoinInfoBean getRcoinInfo() {
            return this.rcoinInfo;
        }

        public ExchangeGoldCoinsBean.DataBean.UserBean getUser() {
            return this.user;
        }

        public void setPaymentMethodsNew(List<PaymentMethodsBean> list) {
            this.paymentMethodsNew = list;
        }

        public void setPrice(ExchangeBean exchangeBean) {
            this.price = exchangeBean;
        }

        public void setRcoinInfo(RcoinInfoBean rcoinInfoBean) {
            this.rcoinInfo = rcoinInfoBean;
        }

        public void setUser(ExchangeGoldCoinsBean.DataBean.UserBean userBean) {
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
