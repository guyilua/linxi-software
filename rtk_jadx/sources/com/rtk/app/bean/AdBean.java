package com.rtk.app.bean;

import com.google.gson.a.c;
import com.qq.e.comm.pi.ACTD;
import java.io.Serializable;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AdBean implements Serializable {

    @c("code")
    private Integer code;

    @c("data")
    private DataDTO data;

    @c("msg")
    private String msg;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class DataDTO {

        @c("DownPageAd")
        private DownPageAdDTO DownPageAd;

        @c("banner")
        private BannerDTO banner;

        @c("downAd")
        private DownAdDTO downAd;

        @c("downShare")
        private DownShareDTO downShare;

        @c("downTask")
        private Integer downTask;

        @c("gameDetailsPageAd")
        private GameDetailsPageAdDTO gameDetailsPageAd;

        @c("postsPageAd")
        private PostsPageAdDTO postsPageAd;

        @c("ttSplash")
        private TtSplashDTO ttSplash;

        @c("upDetailsPageAd")
        private UpDetailsPageAdDTO upDetailsPageAd;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class BannerDTO {

            @c(ACTD.APPID_KEY)
            private Integer appid;

            @c("codeBitId")
            private Integer codeBitId;

            @c("isshow")
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
        public static class DownAdDTO {

            @c("adType")
            private Integer adType;

            @c(ACTD.APPID_KEY)
            private Integer appid;

            @c("codeBitId")
            private Integer codeBitId;

            @c("codeBitId2")
            private Integer codeBitId2;

            @c("codeBitId3")
            private Integer codeBitId3;

            @c("codeBitIdToBid")
            private String codeBitIdToBid;

            @c("continuedTime")
            private Integer continuedTime;

            @c("endTips")
            private String endTips;

            @c("gradeLimit")
            private Integer gradeLimit;

            @c("tips")
            private String tips;

            public Integer getAdType() {
                return this.adType;
            }

            public Integer getAppid() {
                return this.appid;
            }

            public Integer getCodeBitId() {
                return this.codeBitId;
            }

            public Integer getCodeBitId2() {
                return this.codeBitId2;
            }

            public Integer getCodeBitId3() {
                return this.codeBitId3;
            }

            public String getCodeBitIdToBid() {
                return this.codeBitIdToBid;
            }

            public Integer getContinuedTime() {
                return this.continuedTime;
            }

            public String getEndTips() {
                return this.endTips;
            }

            public Integer getGradeLimit() {
                return this.gradeLimit;
            }

            public String getTips() {
                return this.tips;
            }

            public void setAdType(Integer num) {
                this.adType = num;
            }

            public void setAppid(Integer num) {
                this.appid = num;
            }

            public void setCodeBitId(Integer num) {
                this.codeBitId2 = num;
            }

            public void setCodeBitId2(Integer num) {
                this.codeBitId2 = num;
            }

            public void setCodeBitId3(Integer num) {
                this.codeBitId3 = num;
            }

            public void setContinuedTime(Integer num) {
                this.continuedTime = num;
            }

            public void setEndTips(String str) {
                this.endTips = str;
            }

            public void setGradeLimit(Integer num) {
                this.gradeLimit = num;
            }

            public void setTips(String str) {
                this.tips = str;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class DownPageAdDTO {

            @c(ACTD.APPID_KEY)
            private Integer appid;

            @c("codeBitId")
            private Integer codeBitId;

            @c("isshow")
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
        public static class DownShareDTO {

            @c("continuedTime")
            private Integer continuedTime;

            @c("gradeLimit")
            private Integer gradeLimit;

            @c("photoFieldTitle")
            private String photoFieldTitle;

            @c("photoFieldUrl")
            private String photoFieldUrl;

            @c("shareType")
            private Integer shareType;

            @c("tips")
            private String tips;

            @c("urlFieldContent")
            private String urlFieldContent;

            @c("urlFieldIconUrl")
            private String urlFieldIconUrl;

            @c("urlFieldTitle")
            private String urlFieldTitle;

            @c("urlFieldUrl")
            private String urlFieldUrl;

            public Integer getContinuedTime() {
                return this.continuedTime;
            }

            public Integer getGradeLimit() {
                return this.gradeLimit;
            }

            public String getPhotoFieldTitle() {
                return this.photoFieldTitle;
            }

            public String getPhotoFieldUrl() {
                return this.photoFieldUrl;
            }

            public Integer getShareType() {
                return this.shareType;
            }

            public String getTips() {
                return this.tips;
            }

            public String getUrlFieldContent() {
                return this.urlFieldContent;
            }

            public String getUrlFieldIconUrl() {
                return this.urlFieldIconUrl;
            }

            public String getUrlFieldTitle() {
                return this.urlFieldTitle;
            }

            public String getUrlFieldUrl() {
                return this.urlFieldUrl;
            }

            public void setContinuedTime(Integer num) {
                this.continuedTime = num;
            }

            public void setGradeLimit(Integer num) {
                this.gradeLimit = num;
            }

            public void setPhotoFieldTitle(String str) {
                this.photoFieldTitle = str;
            }

            public void setPhotoFieldUrl(String str) {
                this.photoFieldUrl = str;
            }

            public void setShareType(Integer num) {
                this.shareType = num;
            }

            public void setTips(String str) {
                this.tips = str;
            }

            public void setUrlFieldContent(String str) {
                this.urlFieldContent = str;
            }

            public void setUrlFieldIconUrl(String str) {
                this.urlFieldIconUrl = str;
            }

            public void setUrlFieldTitle(String str) {
                this.urlFieldTitle = str;
            }

            public void setUrlFieldUrl(String str) {
                this.urlFieldUrl = str;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class GameDetailsPageAdDTO {

            @c(ACTD.APPID_KEY)
            private Integer appid;

            @c("codeBitId")
            private Integer codeBitId;

            @c("gradeLimit")
            private Integer gradeLimit;

            @c("isshow")
            private Integer isshow;

            public Integer getAppid() {
                return this.appid;
            }

            public Integer getCodeBitId() {
                return this.codeBitId;
            }

            public Integer getGradeLimit() {
                return this.gradeLimit;
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

            public void setGradeLimit(Integer num) {
                this.gradeLimit = num;
            }

            public void setIsshow(Integer num) {
                this.isshow = num;
            }
        }

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public static class PostsPageAdDTO {

            @c(ACTD.APPID_KEY)
            private Integer appid;

            @c("codeBitId")
            private Integer codeBitId;

            @c("isshow")
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
        public static class TtSplashDTO {

            @c(ACTD.APPID_KEY)
            private Integer appid;

            @c("codeBitId")
            private Integer codeBitId;

            @c("isshow")
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
        public static class UpDetailsPageAdDTO {

            @c(ACTD.APPID_KEY)
            private Integer appid;

            @c("codeBitId")
            private Integer codeBitId;

            @c("isshow")
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

        public BannerDTO getBanner() {
            return this.banner;
        }

        public DownAdDTO getDownAd() {
            return this.downAd;
        }

        public DownPageAdDTO getDownPageAd() {
            return this.DownPageAd;
        }

        public DownShareDTO getDownShare() {
            return this.downShare;
        }

        public Integer getDownTask() {
            return this.downTask;
        }

        public GameDetailsPageAdDTO getGameDetailsPageAd() {
            return this.gameDetailsPageAd;
        }

        public PostsPageAdDTO getPostsPageAd() {
            return this.postsPageAd;
        }

        public TtSplashDTO getTtSplash() {
            return this.ttSplash;
        }

        public UpDetailsPageAdDTO getUpDetailsPageAd() {
            return this.upDetailsPageAd;
        }

        public void setBanner(BannerDTO bannerDTO) {
            this.banner = bannerDTO;
        }

        public void setDownAd(DownAdDTO downAdDTO) {
            this.downAd = downAdDTO;
        }

        public void setDownPageAd(DownPageAdDTO downPageAdDTO) {
            this.DownPageAd = downPageAdDTO;
        }

        public void setDownShare(DownShareDTO downShareDTO) {
            this.downShare = downShareDTO;
        }

        public void setDownTask(Integer num) {
            this.downTask = num;
        }

        public void setGameDetailsPageAd(GameDetailsPageAdDTO gameDetailsPageAdDTO) {
            this.gameDetailsPageAd = gameDetailsPageAdDTO;
        }

        public void setPostsPageAd(PostsPageAdDTO postsPageAdDTO) {
            this.postsPageAd = postsPageAdDTO;
        }

        public void setTtSplash(TtSplashDTO ttSplashDTO) {
            this.ttSplash = ttSplashDTO;
        }

        public void setUpDetailsPageAd(UpDetailsPageAdDTO upDetailsPageAdDTO) {
            this.upDetailsPageAd = upDetailsPageAdDTO;
        }
    }

    public Integer getCode() {
        return this.code;
    }

    public DataDTO getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public void setData(DataDTO dataDTO) {
        this.data = dataDTO;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
