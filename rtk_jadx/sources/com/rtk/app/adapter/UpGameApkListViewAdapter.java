package com.rtk.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpGameApkListViewAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f119c;
    private List<ApkBean> d;
    private CompositeDisposable e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder {

        @BindView
        ImageView up_gameItemImg;

        @BindView
        TextView up_gameItemName;

        @BindView
        TextView up_gameItemSize;

        @BindView
        TextView up_gameItemVersion;

        @BindView
        LinearLayout up_gameItemVersionInstallLy;

        ViewHolder(UpGameApkListViewAdapter upGameApkListViewAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.up_gameItemImg = (ImageView) butterknife.c.a.c(view, R.id.up_game_item_img, "field 'up_gameItemImg'", ImageView.class);
            viewHolder.up_gameItemName = (TextView) butterknife.c.a.c(view, R.id.up_game_item_name, "field 'up_gameItemName'", TextView.class);
            viewHolder.up_gameItemSize = (TextView) butterknife.c.a.c(view, R.id.up_game_item_size, "field 'up_gameItemSize'", TextView.class);
            viewHolder.up_gameItemVersion = (TextView) butterknife.c.a.c(view, R.id.up_game_item_version, "field 'up_gameItemVersion'", TextView.class);
            viewHolder.up_gameItemVersionInstallLy = (LinearLayout) butterknife.c.a.c(view, R.id.up_game_item_version_install_ly, "field 'up_gameItemVersionInstallLy'", LinearLayout.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.up_gameItemImg = null;
                viewHolder.up_gameItemName = null;
                viewHolder.up_gameItemSize = null;
                viewHolder.up_gameItemVersion = null;
                viewHolder.up_gameItemVersionInstallLy = null;
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
            if (UpGameApkListViewAdapter.this.f119c.getPackageManager().getPackageArchiveInfo(((ApkBean) UpGameApkListViewAdapter.this.d.get(this.a)).getPath(), 0) == null) {
                observableEmitter.onError(new NullPointerException("本地apk图片为空"));
            }
            observableEmitter.onNext(com.rtk.app.tool.t.C(UpGameApkListViewAdapter.this.f119c, ((ApkBean) UpGameApkListViewAdapter.this.d.get(this.a)).getPath()));
            observableEmitter.onComplete();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b extends DisposableObserver<Drawable> {
        final /* synthetic */ ViewHolder a;

        b(UpGameApkListViewAdapter upGameApkListViewAdapter, ViewHolder viewHolder) {
            this.a = viewHolder;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Drawable drawable) {
            this.a.up_gameItemImg.setImageDrawable(drawable);
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
            int intValue = ((Integer) view.getTag()).intValue();
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("apkName", ((ApkBean) UpGameApkListViewAdapter.this.d.get(intValue)).getName());
            bundle.putString("apkSize", ((ApkBean) UpGameApkListViewAdapter.this.d.get(intValue)).getSize());
            bundle.putString("apkPath", ((ApkBean) UpGameApkListViewAdapter.this.d.get(intValue)).getPath());
            intent.putExtras(bundle);
            ((Activity) UpGameApkListViewAdapter.this.f119c).setResult(1014, intent);
            ((Activity) UpGameApkListViewAdapter.this.f119c).finish();
        }
    }

    public UpGameApkListViewAdapter(Context context, List<ApkBean> list) {
        super(list);
        this.e = new CompositeDisposable();
        this.f119c = context;
        this.d = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f119c).inflate(R.layout.up_game_listview_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(this, view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.up_gameItemImg.setImageResource(R.mipmap.icon_logo);
        Observable create = Observable.create(new a(i));
        b bVar = new b(this, viewHolder);
        DisposableObserver disposableObserver = (DisposableObserver) viewHolder.up_gameItemImg.getTag();
        if (disposableObserver != null) {
            this.e.remove(disposableObserver);
        }
        viewHolder.up_gameItemImg.setTag(bVar);
        create.subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(bVar);
        this.e.add(bVar);
        viewHolder.up_gameItemName.setText(this.d.get(i).getName());
        viewHolder.up_gameItemSize.setText(this.d.get(i).getSize());
        viewHolder.up_gameItemVersion.setText(this.d.get(i).getVersion());
        viewHolder.up_gameItemVersionInstallLy.setTag(Integer.valueOf(i));
        viewHolder.up_gameItemVersionInstallLy.setOnClickListener(new c());
        return view;
    }
}
