package com.rtk.app.bean;

import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ClassifyBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private List<FeatureTypeBean> featureType;
        private List<NormalTypeBean> normalType;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class FeatureTypeBean {
            private int game_total;
            private String icon;
            private int tag_id;
            private String tag_name;
            private String tag_type;

            public int getGame_total() {
                return this.game_total;
            }

            public String getIcon() {
                return this.icon;
            }

            public int getTag_id() {
                return this.tag_id;
            }

            public String getTag_name() {
                return this.tag_name;
            }

            public String getTag_type() {
                return this.tag_type;
            }

            public void setGame_total(int i) {
                this.game_total = i;
            }

            public void setIcon(String str) {
                this.icon = str;
            }

            public void setTag_id(int i) {
                this.tag_id = i;
            }

            public void setTag_name(String str) {
                this.tag_name = str;
            }

            public void setTag_type(String str) {
                this.tag_type = str;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class NormalTypeBean {
            private int game_total;
            private String icon;
            private int type_id;
            private String type_name;

            public int getGame_total() {
                return this.game_total;
            }

            public String getIcon() {
                return this.icon;
            }

            public int getType_id() {
                return this.type_id;
            }

            public String getType_name() {
                return this.type_name;
            }

            public void setGame_total(int i) {
                this.game_total = i;
            }

            public void setIcon(String str) {
                this.icon = str;
            }

            public void setType_id(int i) {
                this.type_id = i;
            }

            public void setType_name(String str) {
                this.type_name = str;
            }
        }

        public List<FeatureTypeBean> getFeatureType() {
            return this.featureType;
        }

        public List<NormalTypeBean> getNormalType() {
            return this.normalType;
        }

        public void setFeatureType(List<FeatureTypeBean> list) {
            this.featureType = list;
        }

        public void setNormalType(List<NormalTypeBean> list) {
            this.normalType = list;
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
