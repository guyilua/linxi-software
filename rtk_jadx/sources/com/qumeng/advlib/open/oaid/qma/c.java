package com.qumeng.advlib.open.oaid.qma;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.qumeng.advlib.open.oaid.OAIDException;
import java.util.Objects;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class c implements com.qumeng.advlib.open.oaid.b {
    private final Context a;

    public c(Context context) {
        this.a = context;
    }

    @Override // com.qumeng.advlib.open.oaid.b
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.qumeng.advlib.open.oaid.b
    public void a(com.qumeng.advlib.open.oaid.a aVar) {
        if (this.a == null || aVar == null) {
            return;
        }
        try {
            Cursor query = this.a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
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
