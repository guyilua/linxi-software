package com.qumeng.advlib.core;

import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.annotation.Keep;

@Keep
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ICliBundle {
    public int DataContent;
    public int DataType;
    public Bitmap[] bmparr;
    public String[] bmpurlarr;
    public String content;
    public String content_url;
    public String img_extra_desc;
    public String img_extra_title;
    public int img_height;
    public int img_width;
    public String lastError;
    public String onClickURL;
    public Bundle tbundle;
    public String title;
    public int video_duration;

    public ICliBundle() {
        this.DataType = 1;
        this.DataContent = 0;
        this.lastError = null;
        this.title = null;
        this.content = null;
        this.img_extra_title = null;
        this.img_extra_desc = null;
        this.img_height = 0;
        this.img_width = 0;
        this.video_duration = 0;
        this.content_url = null;
        this.onClickURL = null;
        this.bmparr = null;
        this.bmpurlarr = null;
        this.tbundle = null;
        _inner_initialize();
    }

    private void _inner_initialize() {
        this.tbundle = new Bundle();
    }

    public ICliBundle(int i) {
        this.DataType = 1;
        this.DataContent = 0;
        this.lastError = null;
        this.title = null;
        this.content = null;
        this.img_extra_title = null;
        this.img_extra_desc = null;
        this.img_height = 0;
        this.img_width = 0;
        this.video_duration = 0;
        this.content_url = null;
        this.onClickURL = null;
        this.bmparr = null;
        this.bmpurlarr = null;
        this.tbundle = null;
        this.bmparr = new Bitmap[i];
        this.bmpurlarr = new String[i];
        _inner_initialize();
    }
}
