package com.rtk.app.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.main.UpModule.UpControlPack.YcFileManageActivity;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class YcFileManageAdapter extends RecyclerView.Adapter {
    private Context a;
    private List<c> b;

    /* renamed from: c, reason: collision with root package name */
    private com.rtk.app.tool.s f130c;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    protected static class FileViewHolder extends RecyclerView.ViewHolder {
        View a;

        @BindView
        TextView fileItemName;

        @BindView
        TextView fileItemSize;

        @BindView
        TextView fileItemTime;

        public FileViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.b(this, view);
            this.a = view;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class FileViewHolder_ViewBinding implements Unbinder {
        private FileViewHolder b;

        @UiThread
        public FileViewHolder_ViewBinding(FileViewHolder fileViewHolder, View view) {
            this.b = fileViewHolder;
            fileViewHolder.fileItemName = (TextView) butterknife.c.a.c(view, R.id.file_item_name, "field 'fileItemName'", TextView.class);
            fileViewHolder.fileItemTime = (TextView) butterknife.c.a.c(view, R.id.file_item_time, "field 'fileItemTime'", TextView.class);
            fileViewHolder.fileItemSize = (TextView) butterknife.c.a.c(view, R.id.file_item_size, "field 'fileItemSize'", TextView.class);
        }

        @CallSuper
        public void a() {
            FileViewHolder fileViewHolder = this.b;
            if (fileViewHolder != null) {
                this.b = null;
                fileViewHolder.fileItemName = null;
                fileViewHolder.fileItemTime = null;
                fileViewHolder.fileItemSize = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    protected static class FolderViewHolder extends RecyclerView.ViewHolder {
        View a;

        @BindView
        TextView folderItemName;

        public FolderViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.b(this, view);
            this.a = view;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class FolderViewHolder_ViewBinding implements Unbinder {
        private FolderViewHolder b;

        @UiThread
        public FolderViewHolder_ViewBinding(FolderViewHolder folderViewHolder, View view) {
            this.b = folderViewHolder;
            folderViewHolder.folderItemName = (TextView) butterknife.c.a.c(view, R.id.folder_item_name, "field 'folderItemName'", TextView.class);
        }

        @CallSuper
        public void a() {
            FolderViewHolder folderViewHolder = this.b;
            if (folderViewHolder != null) {
                this.b = null;
                folderViewHolder.folderItemName = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.a.values().length];
            a = iArr;
            try {
                iArr[c.a.file.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.a.folder.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private class b implements View.OnClickListener {
        private Context a;
        private c b;

        public b(YcFileManageAdapter ycFileManageAdapter, Context context, c cVar, com.rtk.app.tool.s sVar) {
            this.a = context;
            this.b = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = a.a[this.b.b().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                com.rtk.app.tool.c0.u("YcFileManageAdapter", "点击了文件夹" + this.b.b);
                com.rtk.app.tool.t.j1(this.a, this.b.b);
                return;
            }
            com.rtk.app.tool.c0.u("YcFileManageAdapter", "点击了文件" + this.b.b);
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("zipPath", this.b.b);
            intent.putExtras(bundle);
            ((YcFileManageActivity) YcFileManageActivity.v.get(0)).setResult(1029, intent);
            YcFileManageActivity.Q();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class c {
        String a;
        String b;

        /* renamed from: c, reason: collision with root package name */
        long f131c;
        long d;
        a e;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        public enum a {
            file,
            folder
        }

        public c(String str, String str2, long j, long j2, a aVar) {
            this.a = str;
            this.b = str2;
            this.d = j2;
            this.f131c = j;
            this.e = aVar;
        }

        public String a() {
            return this.a;
        }

        public a b() {
            return this.e;
        }

        public long c() {
            return this.f131c;
        }

        public long d() {
            return this.d;
        }
    }

    public YcFileManageAdapter(Context context, List<c> list, com.rtk.app.tool.s sVar) {
        this.a = context;
        this.b = list;
        this.f130c = sVar;
    }

    public int getItemCount() {
        return this.b.size();
    }

    public int getItemViewType(int i) {
        return a.a[this.b.get(i).b().ordinal()] != 1 ? 1 : 0;
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemViewType(i) != 1) {
            FileViewHolder fileViewHolder = (FileViewHolder) viewHolder;
            fileViewHolder.fileItemName.setText(this.b.get(i).a());
            fileViewHolder.fileItemTime.setText(com.rtk.app.tool.c0.f(this.b.get(i).d() / 1000));
            fileViewHolder.fileItemSize.setText(com.rtk.app.tool.c0.k(this.b.get(i).c()));
            fileViewHolder.a.setOnClickListener(new b(this, this.a, this.b.get(i), this.f130c));
            return;
        }
        FolderViewHolder folderViewHolder = (FolderViewHolder) viewHolder;
        folderViewHolder.folderItemName.setText(this.b.get(i).a());
        folderViewHolder.a.setOnClickListener(new b(this, this.a, this.b.get(i), this.f130c));
    }

    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i != 1) {
            return new FileViewHolder(LayoutInflater.from(this.a).inflate(R.layout.file_item_layout, viewGroup, false));
        }
        return new FolderViewHolder(LayoutInflater.from(this.a).inflate(R.layout.folder_item_layout, viewGroup, false));
    }
}
