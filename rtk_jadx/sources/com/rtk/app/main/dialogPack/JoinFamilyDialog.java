package com.rtk.app.main.dialogPack;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.CustomSingleEditTextView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class JoinFamilyDialog extends Dialog implements View.OnClickListener {
    private Window a;
    private ViewHolder b;

    /* renamed from: c, reason: collision with root package name */
    private a f254c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder {

        @BindView
        TextView cancel;

        @BindView
        TextView message;

        @BindView
        TextView ok;

        @BindView
        CustomSingleEditTextView singleEditTextView;

        @BindView
        TextView tips;

        @BindView
        TextView title;

        ViewHolder(JoinFamilyDialog joinFamilyDialog, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.title = (TextView) butterknife.c.a.c(view, R.id.dialog_title, "field 'title'", TextView.class);
            viewHolder.tips = (TextView) butterknife.c.a.c(view, R.id.dialog_tips, "field 'tips'", TextView.class);
            viewHolder.ok = (TextView) butterknife.c.a.c(view, R.id.dialog_ok, "field 'ok'", TextView.class);
            viewHolder.cancel = (TextView) butterknife.c.a.c(view, R.id.dialog_cancel, "field 'cancel'", TextView.class);
            viewHolder.singleEditTextView = (CustomSingleEditTextView) butterknife.c.a.c(view, R.id.custom_single_edit_text, "field 'singleEditTextView'", CustomSingleEditTextView.class);
            viewHolder.message = (TextView) butterknife.c.a.c(view, R.id.dialog_message, "field 'message'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.title = null;
                viewHolder.tips = null;
                viewHolder.ok = null;
                viewHolder.cancel = null;
                viewHolder.singleEditTextView = null;
                viewHolder.message = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a(String str);

        void b(String str);
    }

    public JoinFamilyDialog(@NonNull Context context) {
        super(context);
        c();
        b();
        d();
    }

    private void b() {
        this.b.cancel.setOnClickListener(this);
        this.b.ok.setOnClickListener(this);
    }

    private void c() {
        setContentView(R.layout.dialog_join_family);
        k(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
        setCanceledOnTouchOutside(false);
        this.b = new ViewHolder(this, getWindow().getDecorView());
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }

    private void d() {
    }

    public CustomSingleEditTextView a() {
        return this.b.singleEditTextView;
    }

    public void e(a aVar) {
        this.f254c = aVar;
    }

    public void f(String str) {
        this.b.singleEditTextView.setHint(str);
    }

    public void g(String str) {
        if (TextUtils.isEmpty(str)) {
            this.b.message.setVisibility(8);
        } else {
            this.b.message.setVisibility(0);
            this.b.message.setText(str);
        }
    }

    public void h(String str) {
        this.b.ok.setText(str);
    }

    public void i(String str) {
        if (TextUtils.isEmpty(str)) {
            this.b.tips.setVisibility(8);
        } else {
            this.b.tips.setVisibility(0);
            this.b.tips.setText(str);
        }
    }

    public void j(String str) {
        this.b.title.setText(str);
    }

    public void k(float f, float f2) {
        Window window = getWindow();
        this.a = window;
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = (int) f;
        attributes.y = (int) f2;
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -2;
        this.a.setAttributes(attributes);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f254c == null) {
            return;
        }
        String content = this.b.singleEditTextView.getContent();
        int id = view.getId();
        if (id == 2131297121) {
            this.f254c.b(content);
        } else {
            if (id != 2131297315) {
                return;
            }
            this.f254c.a(content);
        }
    }
}
