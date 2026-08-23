package com.sigmob.sdk.mraid;

import android.os.Bundle;
import android.text.TextUtils;
import com.czhj.wire.okio.ByteString;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.common.x;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e extends x {
    /* JADX INFO: Access modifiers changed from: protected */
    public e(o.b bVar) {
        super(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean a(MaterialMeta materialMeta) {
        ByteString byteString;
        return materialMeta.creative_type.intValue() == com.sigmob.sdk.base.common.m.CreativeTypeMRAID.a() && (!TextUtils.isEmpty(materialMeta.html_url) || ((byteString = materialMeta.html_snippet) != null && byteString.size() > 10));
    }

    public static boolean d(BaseAdUnit baseAdUnit) {
        return (baseAdUnit.getMaterial() == null || TextUtils.isEmpty(baseAdUnit.getCrid())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sigmob.sdk.base.common.x
    public void a(o.b bVar) {
        this.a = bVar;
    }

    @Override // com.sigmob.sdk.base.common.x
    public void a(BaseAdUnit baseAdUnit, Bundle bundle) {
        List<BaseAdUnit> e;
        if (baseAdUnit.getCreativeType() == com.sigmob.sdk.base.common.m.CreativeTypeMRAIDTWO.a() && (e = com.sigmob.sdk.base.common.h.e(baseAdUnit.getUuid())) == null) {
            com.sigmob.sdk.mraid2.b.a().a(baseAdUnit.getUuid(), new com.sigmob.sdk.mraid2.d(com.sigmob.sdk.b.e(), e));
        }
        super.a(baseAdUnit, bundle);
    }

    @Override // com.sigmob.sdk.base.common.x
    public void a(Map<String, Object> map, BaseAdUnit baseAdUnit) {
        super.a(map, baseAdUnit);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sigmob.sdk.base.common.x
    public boolean a(BaseAdUnit baseAdUnit) {
        return d(baseAdUnit);
    }

    @Override // com.sigmob.sdk.base.common.x
    public void b(BaseAdUnit baseAdUnit) {
        super.b(baseAdUnit);
    }
}
