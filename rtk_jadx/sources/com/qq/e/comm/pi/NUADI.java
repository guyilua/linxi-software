package com.qq.e.comm.pi;

import com.qq.e.comm.constants.LoadAdParams;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface NUADI {
    String getAdNetWorkName();

    void loadData(int i);

    void loadData(int i, LoadAdParams loadAdParams);

    void setCategories(List<String> list);

    void setMaxVideoDuration(int i);

    void setMinVideoDuration(int i);

    void setVastClassName(String str);
}
