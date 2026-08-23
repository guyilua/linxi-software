package com.umeng.commonsdk.utils;

import java.util.Comparator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class JSONArraySortUtil implements Comparator<JSONObject> {
    private String mCompareKey;

    public void setCompareKey(String str) {
        this.mCompareKey = str;
    }

    @Override // java.util.Comparator
    public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            return (int) (jSONObject.getLong(this.mCompareKey) - jSONObject2.getLong(this.mCompareKey));
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
