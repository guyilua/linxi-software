package com.rtk.app.main.dialogPack;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDialogPageAdapter;
import com.rtk.app.main.HomeCommunityPack.PostDetailsActivity;
import java.util.ArrayList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogPostPageTurning extends Dialog implements View.OnClickListener {
    private Window a;
    private Context b;

    /* renamed from: c, reason: collision with root package name */
    private ViewHolder f247c;
    private int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ViewHolder {

        @BindView
        TextView dialogPostPageTurningEndPage;

        @BindView
        TextView dialogPostPageTurningHome;

        @BindView
        RecyclerView dialogPostPageTurningRecyclerView;

        ViewHolder(View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.dialogPostPageTurningHome = (TextView) butterknife.c.a.c(view, R.id.dialog_post_page_turning_home, "field 'dialogPostPageTurningHome'", TextView.class);
            viewHolder.dialogPostPageTurningEndPage = (TextView) butterknife.c.a.c(view, R.id.dialog_post_page_turning_endPage, "field 'dialogPostPageTurningEndPage'", TextView.class);
            viewHolder.dialogPostPageTurningRecyclerView = (RecyclerView) butterknife.c.a.c(view, R.id.dialog_post_page_turning_recyclerView, "field 'dialogPostPageTurningRecyclerView'", RecyclerView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.dialogPostPageTurningHome = null;
                viewHolder.dialogPostPageTurningEndPage = null;
                viewHolder.dialogPostPageTurningRecyclerView = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public DialogPostPageTurning(@NonNull Context context, int i) {
        super(context);
        this.b = context;
        this.d = (i / 10) + (i % 10 > 0 ? 1 : 0);
        b();
        a();
    }

    private void a() {
        this.f247c.dialogPostPageTurningEndPage.setOnClickListener(this);
        this.f247c.dialogPostPageTurningHome.setOnClickListener(this);
    }

    private void b() {
        setContentView(R.layout.dialog_post_page_turning);
        c(com.sigmob.sdk.base.blurkit.c.d, com.sigmob.sdk.base.blurkit.c.d);
        setCanceledOnTouchOutside(true);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        this.f247c = new ViewHolder(getWindow().getDecorView());
        this.f247c.dialogPostPageTurningRecyclerView.setLayoutManager(new GridLayoutManager(this.b, 4));
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i <= this.d; i++) {
            arrayList.add(i + "");
        }
        this.f247c.dialogPostPageTurningRecyclerView.setAdapter(new PostDialogPageAdapter(this.b, arrayList));
    }

    public void c(float f, float f2) {
        Window window = getWindow();
        this.a = window;
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = (int) f;
        attributes.y = (int) f2;
        attributes.gravity = 80;
        attributes.width = -1;
        attributes.height = -2;
        this.a.setAttributes(attributes);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_post_page_turning_endPage /* 2131297336 */:
                ((PostDetailsActivity) this.b).X(this.d);
                break;
            case R.id.dialog_post_page_turning_home /* 2131297337 */:
                ((PostDetailsActivity) this.b).X(1);
                break;
        }
        dismiss();
    }
}
