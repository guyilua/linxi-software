package com.ss.android.download.api.a;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.ss.android.download.api.config.i;
import com.ss.android.download.api.config.t;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b implements i {
    private t a;

    @Override // com.ss.android.download.api.config.i
    public void a(@NonNull Activity activity, @NonNull String[] strArr, t tVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.a = tVar;
            activity.requestPermissions(strArr, 1);
        } else if (tVar != null) {
            tVar.a();
        }
    }

    @Override // com.ss.android.download.api.config.i
    public boolean a(@Nullable Context context, @NonNull String str) {
        return context != null && ContextCompat.checkSelfPermission(context, str) == 0;
    }

    @Override // com.ss.android.download.api.config.i
    public void a(@NonNull Activity activity, int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        t tVar;
        if (iArr.length <= 0 || (tVar = this.a) == null) {
            return;
        }
        if (iArr[0] == -1) {
            tVar.a(strArr[0]);
        } else if (iArr[0] == 0) {
            tVar.a();
        }
    }
}
