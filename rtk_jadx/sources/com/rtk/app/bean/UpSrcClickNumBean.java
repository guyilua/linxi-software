package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpSrcClickNumBean {
    private int code;
    private DataDTO data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataDTO {
        private int today;
        private int total;

        public int getToday() {
            return this.today;
        }

        public int getTotal() {
            return this.total;
        }

        public void setToday(int i) {
            this.today = i;
        }

        public void setTotal(int i) {
            this.total = i;
        }
    }

    public int getCode() {
        return this.code;
    }

    public DataDTO getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(DataDTO dataDTO) {
        this.data = dataDTO;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
