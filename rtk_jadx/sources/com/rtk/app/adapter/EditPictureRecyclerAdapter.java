package com.rtk.app.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.bean.Home5ImfromationBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class EditPictureRecyclerAdapter extends RecyclerView.Adapter {
    private Context a;
    private List<Home5ImfromationBean.DataBean.PhotoWallBean> b;

    /* renamed from: c, reason: collision with root package name */
    private com.rtk.app.tool.s f47c;
    private boolean d = false;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class FootHolder extends RecyclerView.ViewHolder {

        @BindView
        ImageView editPictureFootImg;

        FootHolder(View view) {
            super(view);
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class FootHolder_ViewBinding implements Unbinder {
        private FootHolder b;

        @UiThread
        public FootHolder_ViewBinding(FootHolder footHolder, View view) {
            this.b = footHolder;
            footHolder.editPictureFootImg = (ImageView) butterknife.c.a.c(view, R.id.edit_picture_foot_img, "field 'editPictureFootImg'", ImageView.class);
        }

        @CallSuper
        public void a() {
            FootHolder footHolder = this.b;
            if (footHolder != null) {
                this.b = null;
                footHolder.editPictureFootImg = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class PictureHolder extends RecyclerView.ViewHolder {

        @BindView
        ImageView editPictureDelete;

        @BindView
        ImageView editPictureImg;

        @BindView
        TextView editPictureState;

        PictureHolder(View view) {
            super(view);
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class PictureHolder_ViewBinding implements Unbinder {
        private PictureHolder b;

        @UiThread
        public PictureHolder_ViewBinding(PictureHolder pictureHolder, View view) {
            this.b = pictureHolder;
            pictureHolder.editPictureImg = (ImageView) butterknife.c.a.c(view, R.id.edit_picture_img, "field 'editPictureImg'", ImageView.class);
            pictureHolder.editPictureDelete = (ImageView) butterknife.c.a.c(view, R.id.edit_picture_delete, "field 'editPictureDelete'", ImageView.class);
            pictureHolder.editPictureState = (TextView) butterknife.c.a.c(view, R.id.edit_picture_state, "field 'editPictureState'", TextView.class);
        }

        @CallSuper
        public void a() {
            PictureHolder pictureHolder = this.b;
            if (pictureHolder != null) {
                this.b = null;
                pictureHolder.editPictureImg = null;
                pictureHolder.editPictureDelete = null;
                pictureHolder.editPictureState = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public EditPictureRecyclerAdapter(Context context, List<Home5ImfromationBean.DataBean.PhotoWallBean> list, com.rtk.app.tool.s sVar) {
        this.a = context;
        this.b = list;
        this.f47c = sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(int i, View view) {
        this.f47c.a("1", this.b.get(i).getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(int i, View view) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            arrayList.add(this.b.get(i2).getPic());
        }
        com.rtk.app.tool.t.C0(this.a, arrayList, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(View view) {
        this.f47c.a("2");
    }

    public int getItemCount() {
        if (this.b.size() < 9) {
            return this.b.size() + 1;
        }
        return this.b.size();
    }

    public int getItemViewType(int i) {
        return (i != getItemCount() + (-1) || getItemCount() == this.b.size()) ? 2 : 3;
    }

    public void l(boolean z) {
        this.d = z;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, @SuppressLint({"RecyclerView"}) final int i) {
        if (getItemViewType(i) != 2) {
            ((RecyclerView.ViewHolder) ((FootHolder) viewHolder)).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.q0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EditPictureRecyclerAdapter.this.k(view);
                }
            });
            return;
        }
        PictureHolder pictureHolder = (PictureHolder) viewHolder;
        com.rtk.app.tool.t.d(this.a, this.b.get(i).getThumPic(), pictureHolder.editPictureImg);
        if (this.d) {
            pictureHolder.editPictureDelete.setVisibility(0);
        } else {
            pictureHolder.editPictureDelete.setVisibility(8);
        }
        pictureHolder.editPictureDelete.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditPictureRecyclerAdapter.this.g(i, view);
            }
        });
        ((RecyclerView.ViewHolder) pictureHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditPictureRecyclerAdapter.this.i(i, view);
            }
        });
        if (!com.rtk.app.tool.c0.q(this.b.get(i).getCheck_status()) && !this.b.get(i).getCheck_status().equals("1")) {
            pictureHolder.editPictureState.setVisibility(8);
        } else {
            pictureHolder.editPictureState.setVisibility(0);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != 2) {
            return new FootHolder(LayoutInflater.from(this.a).inflate(R.layout.edit_picture_foot_item_layout, viewGroup, false));
        }
        return new PictureHolder(LayoutInflater.from(this.a).inflate(R.layout.edit_picture_item_layout, viewGroup, false));
    }
}
