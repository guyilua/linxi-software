package com.rtk.app.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.bean.OtherImformationBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class EditOtherPictureAdapter extends RecyclerView.Adapter {
    private List<OtherImformationBean.DataBean.PhotoWallBean> a;
    private Context b;

    /* renamed from: c, reason: collision with root package name */
    private com.rtk.app.tool.s f46c;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class PictureHolder extends RecyclerView.ViewHolder {

        @BindView
        ImageView editPictureDelete;

        @BindView
        ImageView editPictureImg;

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
        }

        @CallSuper
        public void a() {
            PictureHolder pictureHolder = this.b;
            if (pictureHolder != null) {
                this.b = null;
                pictureHolder.editPictureImg = null;
                pictureHolder.editPictureDelete = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public EditOtherPictureAdapter(List<OtherImformationBean.DataBean.PhotoWallBean> list, Context context, com.rtk.app.tool.s sVar) {
        this.a = list;
        this.b = context;
        this.f46c = sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(int i, View view) {
        this.f46c.a(this.a.get(i).getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(int i, View view) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            arrayList.add(this.a.get(i2).getPic());
        }
        com.rtk.app.tool.t.C0(this.b, arrayList, i);
    }

    public int getItemCount() {
        return this.a.size();
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @SuppressLint({"RecyclerView"}) final int i) {
        PictureHolder pictureHolder = (PictureHolder) viewHolder;
        com.rtk.app.tool.t.d(this.b, this.a.get(i).getThumPic(), pictureHolder.editPictureImg);
        pictureHolder.editPictureDelete.setVisibility(0);
        pictureHolder.editPictureDelete.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditOtherPictureAdapter.this.g(i, view);
            }
        });
        ((RecyclerView.ViewHolder) pictureHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditOtherPictureAdapter.this.i(i, view);
            }
        });
    }

    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new PictureHolder(LayoutInflater.from(this.b).inflate(R.layout.edit_picture_item_layout, viewGroup, false));
    }
}
