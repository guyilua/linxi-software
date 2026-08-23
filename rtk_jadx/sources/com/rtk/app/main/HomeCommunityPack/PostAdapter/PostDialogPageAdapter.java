package com.rtk.app.main.HomeCommunityPack.PostAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.main.HomeCommunityPack.PostDetailsActivity;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostDialogPageAdapter extends RecyclerView.Adapter {
    private Context a;
    private List<String> b;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView
        TextView dialogPostPageTurningItemTv;

        ViewHolder(View view) {
            super(view);
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.dialogPostPageTurningItemTv = (TextView) butterknife.c.a.c(view, R.id.dialog_post_page_turning_item_tv, "field 'dialogPostPageTurningItemTv'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.dialogPostPageTurningItemTv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements View.OnClickListener {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((PostDetailsActivity) PostDialogPageAdapter.this.a).X(Integer.parseInt((String) PostDialogPageAdapter.this.b.get(this.a)));
        }
    }

    public PostDialogPageAdapter(Context context, List<String> list) {
        this.a = context;
        this.b = list;
    }

    public int getItemCount() {
        return this.b.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        viewHolder2.dialogPostPageTurningItemTv.setText(this.b.get(i));
        viewHolder2.dialogPostPageTurningItemTv.setOnClickListener(new a(i));
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(this.a).inflate(R.layout.dialog_post_page_turning_item_layout, viewGroup, false));
    }
}
