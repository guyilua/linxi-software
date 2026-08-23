package com.rtk.app.custom;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.rtk.app.R;
import com.rtk.app.bean.CheckUser;
import com.rtk.app.tool.t;
import java.lang.ref.WeakReference;

/* compiled from: AuditUserViewHolder.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c {
    private View a;
    private ImageView b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f175c;
    private CustomTextView d;
    private WeakReference<Context> e;

    public c(View view, WeakReference<Context> weakReference) {
        this.a = view;
        this.b = (ImageView) view.findViewById(R.id.audit_check_user_icon);
        this.f175c = (TextView) this.a.findViewById(R.id.audit_check_user_nick_name);
        this.d = (CustomTextView) this.a.findViewById(R.id.audit_check_user_reason);
        this.e = weakReference;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(CheckUser checkUser, View view) {
        if (this.e.get() == null) {
            return;
        }
        t.B0(this.e.get(), checkUser.getCheck_uid());
    }

    public void c(final CheckUser checkUser) {
        Context context = this.e.get();
        if (context == null) {
            return;
        }
        if (checkUser != null && !checkUser.getCheck_uid().equals("0")) {
            t.c(context, checkUser.getCheck_face(), this.b, new boolean[0]);
            this.f175c.setText(checkUser.getCheck_nickname());
            this.d.setVisibility(TextUtils.isEmpty(checkUser.getCheck_reason()) ? 8 : 0);
            this.d.setText(checkUser.getCheck_reason());
            this.a.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.custom.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.this.b(checkUser, view);
                }
            });
            return;
        }
        this.a.setVisibility(8);
    }
}
