package com.qumeng.advlib.open.oaid.qma;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.qumeng.advlib.open.oaid.OAIDException;
import java.util.Objects;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class i implements com.qumeng.advlib.open.oaid.b {
    private final Context a;

    public i(Context context) {
        this.a = context;
    }

    @Override // com.qumeng.advlib.open.oaid.b
    public boolean a() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return com.qumeng.advlib.open.oaid.c.a("persist.sys.identifierid.supported", "0").equals("1");
    }

    @Override // com.qumeng.advlib.open.oaid.b
    public void a(com.qumeng.advlib.open.oaid.a aVar) {
        if (this.a == null || aVar == null) {
            return;
        }
        try {
            Cursor query = this.a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            try {
                Objects.requireNonNull(query);
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex("value"));
                if (string != null && string.length() != 0) {
                    aVar.a(string);
                    if (query != null) {
                        query.close();
                        return;
                    }
                    return;
                }
                throw new OAIDException("OAID query failed");
            } finally {
            }
        } catch (Exception e) {
            aVar.a(e);
        }
    }
}
