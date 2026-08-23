package com.rtk.app.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.bean.ApkBean;
import com.rtk.app.main.MyApplication;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class InstallApkListViewAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f79c;
    private List<ApkBean> d;
    private CompositeDisposable e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder {

        @BindView
        ImageView apkmanagerItemImg;

        @BindView
        TextView apkmanagerItemName;

        @BindView
        TextView apkmanagerItemSize;

        @BindView
        TextView apkmanagerItemState;

        @BindView
        TextView apkmanagerItemVersion;

        @BindView
        ImageView apkmanagerItemVersionClose;

        @BindView
        LinearLayout apkmanagerItemVersionInstallLy;

        ViewHolder(InstallApkListViewAdapter installApkListViewAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.apkmanagerItemImg = (ImageView) butterknife.c.a.c(view, R.id.apkmanager_item_img, "field 'apkmanagerItemImg'", ImageView.class);
            viewHolder.apkmanagerItemName = (TextView) butterknife.c.a.c(view, R.id.apkmanager_item_name, "field 'apkmanagerItemName'", TextView.class);
            viewHolder.apkmanagerItemSize = (TextView) butterknife.c.a.c(view, R.id.apkmanager_item_size, "field 'apkmanagerItemSize'", TextView.class);
            viewHolder.apkmanagerItemVersion = (TextView) butterknife.c.a.c(view, R.id.apkmanager_item_version, "field 'apkmanagerItemVersion'", TextView.class);
            viewHolder.apkmanagerItemState = (TextView) butterknife.c.a.c(view, R.id.apkmanager_item_state, "field 'apkmanagerItemState'", TextView.class);
            viewHolder.apkmanagerItemVersionInstallLy = (LinearLayout) butterknife.c.a.c(view, R.id.apkmanager_item_version_install_ly, "field 'apkmanagerItemVersionInstallLy'", LinearLayout.class);
            viewHolder.apkmanagerItemVersionClose = (ImageView) butterknife.c.a.c(view, R.id.apkmanager_item_version_close, "field 'apkmanagerItemVersionClose'", ImageView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.apkmanagerItemImg = null;
                viewHolder.apkmanagerItemName = null;
                viewHolder.apkmanagerItemSize = null;
                viewHolder.apkmanagerItemVersion = null;
                viewHolder.apkmanagerItemState = null;
                viewHolder.apkmanagerItemVersionInstallLy = null;
                viewHolder.apkmanagerItemVersionClose = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements ObservableOnSubscribe<Drawable> {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        public void subscribe(ObservableEmitter<Drawable> observableEmitter) {
            if (InstallApkListViewAdapter.this.f79c.getPackageManager().getPackageArchiveInfo(((ApkBean) InstallApkListViewAdapter.this.d.get(this.a)).getPath(), 0) == null) {
                observableEmitter.onError(new NullPointerException("本地apk图片为空"));
            }
            observableEmitter.onNext(com.rtk.app.tool.t.C(InstallApkListViewAdapter.this.f79c, ((ApkBean) InstallApkListViewAdapter.this.d.get(this.a)).getPath()));
            observableEmitter.onComplete();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b extends DisposableObserver<Drawable> {
        final /* synthetic */ ViewHolder a;

        b(InstallApkListViewAdapter installApkListViewAdapter, ViewHolder viewHolder) {
            this.a = viewHolder;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Drawable drawable) {
            this.a.apkmanagerItemImg.setImageDrawable(drawable);
        }

        public void onComplete() {
        }

        public void onError(Throwable th) {
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.rtk.app.tool.t.n1(InstallApkListViewAdapter.this.f79c, (String) view.getTag());
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class d implements View.OnClickListener {
        final /* synthetic */ int a;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        class a implements com.rtk.app.tool.s {
            a() {
            }

            @Override // com.rtk.app.tool.s
            public void a(String... strArr) {
                InstallApkListViewAdapter.this.d.remove(Integer.parseInt(strArr[0]));
                InstallApkListViewAdapter.this.notifyDataSetChanged();
            }
        }

        d(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new com.rtk.app.main.dialogPack.r(MyApplication.b(), ((ApkBean) InstallApkListViewAdapter.this.d.get(this.a)).getPath(), this.a, new a()).show();
        }
    }

    public InstallApkListViewAdapter(Context context, List<ApkBean> list) {
        super(list);
        this.e = new CompositeDisposable();
        this.f79c = context;
        this.d = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f79c).inflate(R.layout.install_apk_listview_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(this, view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Observable create = Observable.create(new a(i));
        b bVar = new b(this, viewHolder);
        DisposableObserver disposableObserver = (DisposableObserver) viewHolder.apkmanagerItemImg.getTag();
        if (disposableObserver != null) {
            this.e.remove(disposableObserver);
        }
        viewHolder.apkmanagerItemImg.setTag(bVar);
        create.subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(bVar);
        this.e.add(bVar);
        viewHolder.apkmanagerItemName.setText(this.d.get(i).getName());
        viewHolder.apkmanagerItemSize.setText(this.d.get(i).getSize());
        viewHolder.apkmanagerItemVersion.setText(this.d.get(i).getVersion());
        if (com.rtk.app.tool.t.q1(this.f79c, this.d.get(i).getPackageName())) {
            viewHolder.apkmanagerItemState.setText("已安装");
        }
        viewHolder.apkmanagerItemVersionInstallLy.setTag(this.d.get(i).getPath());
        viewHolder.apkmanagerItemVersionInstallLy.setOnClickListener(new c());
        viewHolder.apkmanagerItemVersionClose.setTag(Integer.valueOf(i));
        viewHolder.apkmanagerItemVersionClose.setOnClickListener(new d(i));
        return view;
    }
}
