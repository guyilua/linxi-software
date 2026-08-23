package com.qumeng.advlib.open.oaid.qma;

import com.qumeng.advlib.open.oaid.OAIDException;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class a implements com.qumeng.advlib.open.oaid.b {
    @Override // com.qumeng.advlib.open.oaid.b
    public void a(com.qumeng.advlib.open.oaid.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(new OAIDException("Unsupported"));
    }

    @Override // com.qumeng.advlib.open.oaid.b
    public boolean a() {
        return false;
    }
}
