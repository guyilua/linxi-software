package com.sigmob.sdk.base.common;

import android.os.Bundle;
import android.text.TextUtils;
import com.czhj.wire.okio.ByteString;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class ap extends com.sigmob.sdk.mraid.e {
    /* JADX INFO: Access modifiers changed from: protected */
    public ap(o.b bVar) {
        super(bVar);
    }

    private static boolean b(MaterialMeta materialMeta) {
        return (materialMeta.creative_type.intValue() != m.CreativeTypeVideo_Tar.a() || TextUtils.isEmpty(materialMeta.endcard_md5) || TextUtils.isEmpty(materialMeta.endcard_url) || TextUtils.isEmpty(materialMeta.video_url)) ? false : true;
    }

    public static boolean c(BaseAdUnit baseAdUnit) {
        boolean d = com.sigmob.sdk.mraid.e.d(baseAdUnit);
        MaterialMeta material = baseAdUnit.getMaterial();
        return d && (baseAdUnit.getCreativeType() == m.CreativeTypeMRAID.a() ? com.sigmob.sdk.mraid.e.a(material) : b(material) || c(material) || d(material));
    }

    private static boolean c(MaterialMeta materialMeta) {
        ByteString byteString;
        return (materialMeta.creative_type.intValue() == m.CreativeTypeVideo_Html_Snippet.a() || materialMeta.creative_type.intValue() == m.CreativeTypeVideo_transparent_html.a()) && (byteString = materialMeta.html_snippet) != null && byteString.size() > 10 && !TextUtils.isEmpty(materialMeta.video_url);
    }

    private static boolean d(MaterialMeta materialMeta) {
        return (materialMeta.creative_type.intValue() != m.CreativeTypeVideo_EndCardURL.a() || TextUtils.isEmpty(materialMeta.html_url) || TextUtils.isEmpty(materialMeta.video_url)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.x
    public void a(o.b bVar) {
        super.a(bVar);
    }

    @Override // com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.x
    public void a(BaseAdUnit baseAdUnit, Bundle bundle) {
        h.a(baseAdUnit);
        super.a(baseAdUnit, bundle);
    }

    @Override // com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.x
    public boolean a(BaseAdUnit baseAdUnit) {
        boolean a = super.a(baseAdUnit);
        MaterialMeta material = baseAdUnit.getMaterial();
        return a && (baseAdUnit.getCreativeType() == m.CreativeTypeMRAID.a() ? com.sigmob.sdk.mraid.e.a(material) : baseAdUnit.getCreativeType() == m.CreativeTypeMRAIDTWO.a() || b(material) || c(material) || d(material));
    }

    @Override // com.sigmob.sdk.mraid.e, com.sigmob.sdk.base.common.x
    public void b(BaseAdUnit baseAdUnit) {
        h.b(baseAdUnit);
        super.b(baseAdUnit);
    }
}
