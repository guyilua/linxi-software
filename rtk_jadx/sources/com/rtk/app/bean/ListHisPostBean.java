package com.rtk.app.bean;

import com.rtk.app.bean.PostDetailsBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ListHisPostBean {
    List<HisPostBean> listBean = new ArrayList();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class HisPostBean {
        private long clickTime;
        private String postId;
        private String title;

        public HisPostBean(PostDetailsBean.DataBean dataBean) {
            this.postId = dataBean.getId();
            this.title = dataBean.getTitle();
        }

        public long getClickTime() {
            return this.clickTime;
        }

        public String getPostId() {
            return this.postId;
        }

        public String getTitle() {
            return this.title;
        }

        public void setClickTime(long j) {
            this.clickTime = j;
        }

        public void setPostId(String str) {
            this.postId = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }
    }

    public List<HisPostBean> getListBean() {
        return this.listBean;
    }

    public void setListBean(List<HisPostBean> list) {
        this.listBean = list;
    }
}
