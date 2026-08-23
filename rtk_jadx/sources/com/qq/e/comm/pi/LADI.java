package com.qq.e.comm.pi;

import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface LADI extends ApkDownloadComplianceInterface, IBidding {
    int getECPM();

    String getECPMLevel();

    Map<String, Object> getExtraInfo();

    boolean isValid();
}
