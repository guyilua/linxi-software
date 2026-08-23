package com.rtk.app.bean;

import com.rtk.app.tool.c0;
import java.io.Serializable;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpClassifyBean implements Serializable {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private List<GameBean> game;
        private List<SoftBean> soft;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class GameBean {
            private int game_total;
            private String icon;
            private String tags;
            private String title;
            private String type;

            public int getGame_total() {
                return this.game_total;
            }

            public String getIcon() {
                return this.icon;
            }

            public String getTags() {
                return this.tags;
            }

            public String getTitle() {
                return this.title;
            }

            public String getType() {
                return c0.q(this.type) ? "" : this.type;
            }

            public void setGame_total(int i) {
                this.game_total = i;
            }

            public void setIcon(String str) {
                this.icon = str;
            }

            public void setTags(String str) {
                this.tags = str;
            }

            public void setTitle(String str) {
                this.title = str;
            }

            public void setType(String str) {
                this.type = str;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class SoftBean {
            private int game_total;
            private String icon;
            private String tags;
            private String title;
            private String type;

            public int getGame_total() {
                return this.game_total;
            }

            public String getIcon() {
                return this.icon;
            }

            public String getTags() {
                return this.tags;
            }

            public String getTitle() {
                return this.title;
            }

            public String getType() {
                return c0.q(this.type) ? "" : this.type;
            }

            public void setGame_total(int i) {
                this.game_total = i;
            }

            public void setIcon(String str) {
                this.icon = str;
            }

            public void setTags(String str) {
                this.tags = str;
            }

            public void setTitle(String str) {
                this.title = str;
            }

            public void setType(String str) {
                this.type = str;
            }
        }

        public List<GameBean> getGame() {
            return this.game;
        }

        public List<SoftBean> getSoft() {
            return this.soft;
        }

        public void setGame(List<GameBean> list) {
            this.game = list;
        }

        public void setSoft(List<SoftBean> list) {
            this.soft = list;
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
