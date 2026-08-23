package com.ss.android.downloadlib.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.download.api.model.b;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.c.l;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class g extends com.ss.android.socialbase.appdownloader.c.a {
    private static String a = "g";

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class a implements k {
        private Dialog a;

        public a(Dialog dialog) {
            if (dialog != null) {
                this.a = dialog;
                a();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public void a() {
            Dialog dialog = this.a;
            if (dialog != null) {
                dialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public boolean b() {
            Dialog dialog = this.a;
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.a, com.ss.android.socialbase.appdownloader.c.c
    public l a(Context context) {
        return new l(context) { // from class: com.ss.android.downloadlib.c.g.1
            final /* synthetic */ Context a;

            /* renamed from: c, reason: collision with root package name */
            private b.a f770c;
            private DialogInterface.OnClickListener d;
            private DialogInterface.OnClickListener e;
            private DialogInterface.OnCancelListener f;

            {
                this.a = context;
                this.f770c = new b.a(context);
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(int i) {
                this.f770c.a(this.a.getResources().getString(i));
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l b(int i, DialogInterface.OnClickListener onClickListener) {
                this.f770c.d(this.a.getResources().getString(i));
                this.e = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(String str) {
                this.f770c.b(str);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(int i, DialogInterface.OnClickListener onClickListener) {
                this.f770c.c(this.a.getResources().getString(i));
                this.d = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(DialogInterface.OnCancelListener onCancelListener) {
                this.f = onCancelListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(boolean z) {
                this.f770c.a(z);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public k a() {
                this.f770c.a(new b.InterfaceC0069b() { // from class: com.ss.android.downloadlib.c.g.1.1
                    @Override // com.ss.android.download.api.model.b.InterfaceC0069b
                    public void a(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.d != null) {
                            AnonymousClass1.this.d.onClick(dialogInterface, -1);
                        }
                    }

                    @Override // com.ss.android.download.api.model.b.InterfaceC0069b
                    public void b(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.e != null) {
                            AnonymousClass1.this.e.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.ss.android.download.api.model.b.InterfaceC0069b
                    public void c(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f == null || dialogInterface == null) {
                            return;
                        }
                        AnonymousClass1.this.f.onCancel(dialogInterface);
                    }
                });
                com.ss.android.downloadlib.g.k.a(g.a, "getThemedAlertDlgBuilder", null);
                this.f770c.a(3);
                return new a(com.ss.android.downloadlib.addownload.k.d().b(this.f770c.a()));
            }
        };
    }
}
