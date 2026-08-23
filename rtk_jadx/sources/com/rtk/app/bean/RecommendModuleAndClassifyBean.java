package com.rtk.app.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class RecommendModuleAndClassifyBean {
    private int code;
    private DataBean data;
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataBean {
        private List<AppcategoryBean> appcategory;
        private List<CategoryBean> category;
        private List<GamecategoryBean> gamecategory;
        private List<MatrixBean> matrix;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class AppcategoryBean implements Serializable {
            private String custom_url;
            private String games_language;
            private String games_type;
            private String icon;
            private String id;
            private String methods;
            private String search_words;
            private String tags_2;
            private String tags_id;
            private String title;
            private Map<String, String> type;

            public String getCustom_url() {
                return this.custom_url;
            }

            public String getGames_language() {
                return this.games_language;
            }

            public String getGames_type() {
                return this.games_type;
            }

            public String getIcon() {
                return this.icon;
            }

            public String getId() {
                return this.id;
            }

            public String getMethods() {
                return this.methods;
            }

            public String getSearch_words() {
                return this.search_words;
            }

            public String getTags_2() {
                return this.tags_2;
            }

            public String getTags_id() {
                return this.tags_id;
            }

            public String getTitle() {
                return this.title;
            }

            public Map<String, String> getType() {
                return this.type;
            }

            public void setCustom_url(String str) {
                this.custom_url = str;
            }

            public void setGames_language(String str) {
                this.games_language = str;
            }

            public void setGames_type(String str) {
                this.games_type = str;
            }

            public void setIcon(String str) {
                this.icon = str;
            }

            public void setId(String str) {
                this.id = str;
            }

            public void setMethods(String str) {
                this.methods = str;
            }

            public void setSearch_words(String str) {
                this.search_words = str;
            }

            public void setTags_2(String str) {
                this.tags_2 = str;
            }

            public void setTags_id(String str) {
                this.tags_id = str;
            }

            public void setTitle(String str) {
                this.title = str;
            }

            public void setType(Map<String, String> map) {
                this.type = map;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class CategoryBean implements Serializable {
            private String icon;
            private List<ListBean> list;
            private String title;
            private Map<String, String> type;

            /* loaded from: /tmp/rtk_apk/classes3.dex */
            public static class ListBean implements Serializable {
                private String title;
                private Map<String, String> type;

                public String getTitle() {
                    return this.title;
                }

                public Map<String, String> getType() {
                    return this.type;
                }

                public void setTitle(String str) {
                    this.title = str;
                }

                public void setType(Map<String, String> map) {
                    this.type = map;
                }
            }

            /* loaded from: /tmp/rtk_apk/classes3.dex */
            public static class TypeBean {
                private String games_type;

                public String getGames_type() {
                    return this.games_type;
                }

                public void setGames_type(String str) {
                    this.games_type = str;
                }
            }

            public String getIcon() {
                return this.icon;
            }

            public List<ListBean> getList() {
                return this.list;
            }

            public String getTitle() {
                return this.title;
            }

            public Map<String, String> getType() {
                return this.type;
            }

            public void setIcon(String str) {
                this.icon = str;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public void setTitle(String str) {
                this.title = str;
            }

            public void setType(Map<String, String> map) {
                this.type = map;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class GamecategoryBean implements Serializable {
            private String custom_url;
            private String games_language;
            private String games_type;
            private String icon;
            private String id;
            private String methods;
            private String search_words;
            private String tags_2;
            private String tags_id;
            private String title;
            private Map<String, String> type;

            public String getCustom_url() {
                return this.custom_url;
            }

            public String getGames_language() {
                return this.games_language;
            }

            public String getGames_type() {
                return this.games_type;
            }

            public String getIcon() {
                return this.icon;
            }

            public String getId() {
                return this.id;
            }

            public String getMethods() {
                return this.methods;
            }

            public String getSearch_words() {
                return this.search_words;
            }

            public String getTags_2() {
                return this.tags_2;
            }

            public String getTags_id() {
                return this.tags_id;
            }

            public String getTitle() {
                return this.title;
            }

            public Map<String, String> getType() {
                return this.type;
            }

            public void setCustom_url(String str) {
                this.custom_url = str;
            }

            public void setGames_language(String str) {
                this.games_language = str;
            }

            public void setGames_type(String str) {
                this.games_type = str;
            }

            public void setIcon(String str) {
                this.icon = str;
            }

            public void setId(String str) {
                this.id = str;
            }

            public void setMethods(String str) {
                this.methods = str;
            }

            public void setSearch_words(String str) {
                this.search_words = str;
            }

            public void setTags_2(String str) {
                this.tags_2 = str;
            }

            public void setTags_id(String str) {
                this.tags_id = str;
            }

            public void setTitle(String str) {
                this.title = str;
            }

            public void setType(Map<String, String> map) {
                this.type = map;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class MatrixBean implements Serializable {
            private String icon;
            private String methods;
            private String title;
            private Map<String, String> type;

            public String getIcon() {
                return this.icon;
            }

            public String getMethods() {
                return this.methods;
            }

            public String getTitle() {
                return this.title;
            }

            public Map<String, String> getType() {
                return this.type;
            }

            public void setIcon(String str) {
                this.icon = str;
            }

            public void setMethods(String str) {
                this.methods = str;
            }

            public void setTitle(String str) {
                this.title = str;
            }

            public void setType(Map<String, String> map) {
                this.type = map;
            }
        }

        public List<AppcategoryBean> getAppcategory() {
            return this.appcategory;
        }

        public List<CategoryBean> getCategory() {
            return this.category;
        }

        public List<GamecategoryBean> getGamecategory() {
            return this.gamecategory;
        }

        public List<MatrixBean> getMatrix() {
            return this.matrix;
        }

        public void setAppcategory(List<AppcategoryBean> list) {
            this.appcategory = list;
        }

        public void setCategory(List<CategoryBean> list) {
            this.category = list;
        }

        public void setGamecategory(List<GamecategoryBean> list) {
            this.gamecategory = list;
        }

        public void setMatrix(List<MatrixBean> list) {
            this.matrix = list;
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
