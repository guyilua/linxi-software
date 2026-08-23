package com.rtk.app.bean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AdIdBean {
    private Integer code;
    private Data data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class Data {
        private Banner banner;
        private GroMore toBid;
        private TtSplash ttSplash;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class Banner {
            private Integer appid;
            private Integer codeBitId;
            private Integer isshow;

            public Integer getAppid() {
                return this.appid;
            }

            public Integer getCodeBitId() {
                return this.codeBitId;
            }

            public Integer getIsshow() {
                return this.isshow;
            }

            public void setAppid(Integer num) {
                this.appid = num;
            }

            public void setCodeBitId(Integer num) {
                this.codeBitId = num;
            }

            public void setIsshow(Integer num) {
                this.isshow = num;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class GroMore {
            private Integer appidToBid;
            private String codeBitIdToBid;
            private Integer isshow;

            public Integer getAppid() {
                return this.appidToBid;
            }

            public String getCodeBitId() {
                return this.codeBitIdToBid;
            }

            public Integer getIsshow() {
                return this.isshow;
            }

            public void setAppid(Integer num) {
                this.appidToBid = num;
            }

            public void setCodeBitId(String str) {
                this.codeBitIdToBid = str;
            }

            public void setIsshow(Integer num) {
                this.isshow = num;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class TtSplash {
            private Integer appid;
            private Integer codeBitId;
            private Integer isshow;

            public Integer getAppid() {
                return this.appid;
            }

            public Integer getCodeBitId() {
                return this.codeBitId;
            }

            public Integer getIsshow() {
                return this.isshow;
            }

            public void setAppid(Integer num) {
                this.appid = num;
            }

            public void setCodeBitId(Integer num) {
                this.codeBitId = num;
            }

            public void setIsshow(Integer num) {
                this.isshow = num;
            }
        }

        public Banner getBanner() {
            return this.banner;
        }

        public GroMore getGroMore() {
            return this.toBid;
        }

        public TtSplash getTtSplash() {
            return this.ttSplash;
        }

        public void setBanner(Banner banner) {
            this.banner = banner;
        }

        public void setGroMore(GroMore groMore) {
            this.toBid = groMore;
        }

        public void setTtSplash(TtSplash ttSplash) {
            this.ttSplash = ttSplash;
        }
    }

    public Integer getCode() {
        return this.code;
    }

    public Data getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
