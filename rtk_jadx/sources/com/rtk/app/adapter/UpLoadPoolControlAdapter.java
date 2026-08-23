package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.main.dialogPack.DialogForEnSure;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpLoadPoolControlAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private DialogForProgressTip f121c;
    private Context d;
    private List<com.rtk.app.tool.g.g> e;
    public List<com.rtk.app.main.UpModule.UpControlPack.UpApk.e> f;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    protected static class ViewHolder {

        @BindView
        ImageView upLoadPoolControlItemDelete;

        @BindView
        TextView upLoadPoolControlItemEdit;

        @BindView
        ImageView upLoadPoolControlItemIcon;

        @BindView
        TextView upLoadPoolControlItemName;

        @BindView
        TextView upLoadPoolControlItemPercentage;

        @BindView
        ProgressBar upLoadPoolControlItemProgressBar;

        @BindView
        TextView upLoadPoolControlItemSize;

        @BindView
        TextView upLoadPoolControlItemSpeed;

        @BindView
        CheckBox upLoadPoolControlItemState;

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
            viewHolder.upLoadPoolControlItemIcon = (ImageView) butterknife.c.a.c(view, R.id.up_load_pool_control_item_icon, "field 'upLoadPoolControlItemIcon'", ImageView.class);
            viewHolder.upLoadPoolControlItemName = (TextView) butterknife.c.a.c(view, R.id.up_load_pool_control_item_name, "field 'upLoadPoolControlItemName'", TextView.class);
            viewHolder.upLoadPoolControlItemProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.up_load_pool_control_item_progressBar, "field 'upLoadPoolControlItemProgressBar'", ProgressBar.class);
            viewHolder.upLoadPoolControlItemSize = (TextView) butterknife.c.a.c(view, R.id.up_load_pool_control_item_size, "field 'upLoadPoolControlItemSize'", TextView.class);
            viewHolder.upLoadPoolControlItemSpeed = (TextView) butterknife.c.a.c(view, R.id.up_load_pool_control_item_speed, "field 'upLoadPoolControlItemSpeed'", TextView.class);
            viewHolder.upLoadPoolControlItemPercentage = (TextView) butterknife.c.a.c(view, R.id.up_load_pool_control_item_percentage, "field 'upLoadPoolControlItemPercentage'", TextView.class);
            viewHolder.upLoadPoolControlItemEdit = (TextView) butterknife.c.a.c(view, R.id.up_load_pool_control_item_edit, "field 'upLoadPoolControlItemEdit'", TextView.class);
            viewHolder.upLoadPoolControlItemState = (CheckBox) butterknife.c.a.c(view, R.id.up_load_pool_control_item_state, "field 'upLoadPoolControlItemState'", CheckBox.class);
            viewHolder.upLoadPoolControlItemDelete = (ImageView) butterknife.c.a.c(view, R.id.up_load_pool_control_item_delete, "field 'upLoadPoolControlItemDelete'", ImageView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.upLoadPoolControlItemIcon = null;
                viewHolder.upLoadPoolControlItemName = null;
                viewHolder.upLoadPoolControlItemProgressBar = null;
                viewHolder.upLoadPoolControlItemSize = null;
                viewHolder.upLoadPoolControlItemSpeed = null;
                viewHolder.upLoadPoolControlItemPercentage = null;
                viewHolder.upLoadPoolControlItemEdit = null;
                viewHolder.upLoadPoolControlItemState = null;
                viewHolder.upLoadPoolControlItemDelete = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private class a implements View.OnClickListener {
        private Context a;
        private com.rtk.app.tool.g.g b;

        /* renamed from: c, reason: collision with root package name */
        private ViewHolder f122c;

        /* renamed from: com.rtk.app.adapter.UpLoadPoolControlAdapter$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        class C0017a implements com.rtk.app.tool.s {
            C0017a() {
            }

            @Override // com.rtk.app.tool.s
            public void a(String... strArr) {
                com.rtk.app.tool.g.f.e(a.this.a).n(a.this.b.n());
                com.rtk.app.main.UpModule.UpControlPack.b.i().p(a.this.b.n());
                if (!com.rtk.app.tool.c0.q(a.this.b.z())) {
                    com.rtk.app.main.UpModule.UpControlPack.b.i().q(a.this.b.z());
                }
                UpLoadPoolControlAdapter.this.notifyDataSetChanged();
            }
        }

        public a(Context context, int i, ViewHolder viewHolder) {
            this.a = context;
            this.f122c = viewHolder;
            this.b = (com.rtk.app.tool.g.g) UpLoadPoolControlAdapter.this.e.get(i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.up_load_pool_control_item_delete /* 2131300968 */:
                    new DialogForEnSure(this.a, "确定删除该上传吗？", new C0017a()).show();
                    return;
                case R.id.up_load_pool_control_item_edit /* 2131300969 */:
                    if (!com.rtk.app.tool.c0.q(this.b.z())) {
                        if (com.rtk.app.tool.c0.q(com.rtk.app.tool.v.d(this.a, com.rtk.app.tool.v.m))) {
                            com.rtk.app.main.UpModule.UpControlPack.b.i().q(this.b.z());
                            com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().h((com.rtk.app.main.UpModule.UpControlPack.UpApk.e) this.f122c.upLoadPoolControlItemPercentage.getTag());
                            UpLoadPoolControlAdapter.this.notifyDataSetChanged();
                            com.rtk.app.tool.v.h(this.a, com.rtk.app.tool.v.m, com.rtk.app.tool.g.f.e(this.a).j(this.b.z()).o());
                            com.rtk.app.tool.t.e1(this.a);
                            return;
                        }
                        com.rtk.app.tool.f.a(this.a, "上传资源编辑页面有未处理完的信息，请清空后再试。", f.a.f);
                        return;
                    }
                    if (com.rtk.app.tool.c0.q(com.rtk.app.tool.v.d(this.a, com.rtk.app.tool.v.l))) {
                        com.rtk.app.main.UpModule.UpControlPack.b.i().p(this.b.n());
                        com.rtk.app.tool.g.f.e(this.a).s(this.b.n(), 0);
                        com.rtk.app.main.UpModule.UpControlPack.UpApk.e eVar = (com.rtk.app.main.UpModule.UpControlPack.UpApk.e) this.f122c.upLoadPoolControlItemPercentage.getTag();
                        com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().h(eVar);
                        UpLoadPoolControlAdapter.this.notifyDataSetChanged();
                        com.rtk.app.tool.v.h(this.a, com.rtk.app.tool.v.l, com.rtk.app.tool.g.f.e(this.a).g(eVar.f).o());
                        com.rtk.app.tool.t.c1(this.a);
                        return;
                    }
                    com.rtk.app.tool.f.a(this.a, "上传资源编辑页面有未处理完的信息，请清空后再试。", f.a.f);
                    return;
                case R.id.up_load_pool_control_item_state /* 2131300976 */:
                    boolean z = !((CheckBox) view).isChecked();
                    com.rtk.app.tool.c0.u("UpLoadPoolControlAdapter", "当前点击的这个游戏的状态" + z);
                    if (z) {
                        this.f122c.upLoadPoolControlItemSpeed.setText("已暂停");
                        if (!com.rtk.app.tool.c0.q(this.b.z())) {
                            com.rtk.app.tool.g.f.e(this.a).t(this.b.z(), 1);
                            this.b.L(1);
                            com.rtk.app.main.UpModule.UpControlPack.b.i().t(this.b);
                        } else {
                            com.rtk.app.tool.g.f.e(this.a).r(this.b.n(), 1);
                            this.b.K(1);
                            com.rtk.app.main.UpModule.UpControlPack.b.i().s(this.b);
                        }
                        if (com.rtk.app.tool.o.n.e.contains(this.b.z()) || com.rtk.app.tool.o.k.i().t(this.b.n())) {
                            DialogForProgressTip dialogForProgressTip = UpLoadPoolControlAdapter.this.f121c;
                            int[] iArr = new int[1];
                            iArr[0] = com.rtk.app.tool.c0.q(this.b.z()) ? this.b.E() : this.b.y();
                            dialogForProgressTip.r(iArr);
                            return;
                        }
                        this.f122c.upLoadPoolControlItemDelete.setVisibility(0);
                        return;
                    }
                    this.f122c.upLoadPoolControlItemDelete.setVisibility(4);
                    this.f122c.upLoadPoolControlItemSpeed.setText("上传中...");
                    if (!com.rtk.app.tool.c0.q(this.b.z())) {
                        String A = this.b.A();
                        com.rtk.app.tool.c0.u("UpLoadPoolControlAdapter", "压缩包暂停继续 压缩文件名  " + A + " zipmd5:" + this.b.z());
                        com.rtk.app.tool.g.f.e(this.a).t(this.b.z(), 0);
                        int f = com.rtk.app.tool.g.f.e(this.a).i(this.b.n()).f();
                        int i = f <= 0 ? 1 : f;
                        this.b.L(0);
                        com.rtk.app.main.UpModule.UpControlPack.b.i().t(this.b);
                        com.rtk.app.tool.g.f.e(this.a).t(this.b.z(), 0);
                        com.rtk.app.tool.o.n.p(com.rtk.app.main.UpModule.UpControlPack.b.m(this.b.z()), com.rtk.app.tool.y.i + "html/filelist/appsUploadDataBag", 0, i, this.b.z(), A, false);
                        return;
                    }
                    int e = com.rtk.app.tool.g.f.e(this.a).i(this.b.n()).e();
                    int i2 = e <= 0 ? 1 : e;
                    com.rtk.app.tool.o.k.i().r(com.rtk.app.main.UpModule.UpControlPack.b.m(this.b.n()), com.rtk.app.tool.y.i + com.rtk.app.tool.y.k, 0, i2, this.b.n(), false);
                    this.b.K(0);
                    com.rtk.app.main.UpModule.UpControlPack.b.i().s(this.b);
                    com.rtk.app.tool.g.f.e(this.a).r(this.b.n(), 0);
                    return;
                default:
                    return;
            }
        }
    }

    public UpLoadPoolControlAdapter(Context context, List<com.rtk.app.tool.g.g> list) {
        super(list);
        this.f = new ArrayList();
        this.d = context;
        this.e = list;
        this.f121c = new DialogForProgressTip(context, "处理中，请稍后...");
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        View view2;
        com.rtk.app.main.UpModule.UpControlPack.UpApk.e eVar;
        String str;
        if (view == null) {
            View inflate = LayoutInflater.from(this.d).inflate(R.layout.up_load_pool_control_item_layout, (ViewGroup) null);
            ViewHolder viewHolder2 = new ViewHolder(inflate);
            inflate.setTag(viewHolder2);
            viewHolder = viewHolder2;
            view2 = inflate;
        } else {
            viewHolder = (ViewHolder) view.getTag();
            view2 = view;
        }
        com.rtk.app.tool.g.g g = com.rtk.app.tool.g.f.e(this.d).g(this.e.get(i).E());
        if (g == null) {
            this.e.remove(i);
            notifyDataSetChanged();
            return view2;
        }
        if (!com.rtk.app.tool.c0.q(g.z())) {
            com.rtk.app.tool.c0.u("UpLoadPoolControlAdapter", "是数据包");
            eVar = new com.rtk.app.main.UpModule.UpControlPack.UpApk.e(g.y(), viewHolder.upLoadPoolControlItemProgressBar, viewHolder.upLoadPoolControlItemState, viewHolder.upLoadPoolControlItemDelete, viewHolder.upLoadPoolControlItemSpeed, viewHolder.upLoadPoolControlItemPercentage, this.f121c);
            try {
                viewHolder.upLoadPoolControlItemSize.setText(com.rtk.app.tool.c0.k(g.C()));
            } catch (Exception e) {
                com.rtk.app.tool.c0.u("UpLoadPoolControlAdapter", "线程池适配器异常" + e.toString());
            }
            viewHolder.upLoadPoolControlItemIcon.setImageDrawable(this.d.getResources().getDrawable(R.mipmap.icon_zip_logo));
            viewHolder.upLoadPoolControlItemName.setText(g.c() + "数据包");
            viewHolder.upLoadPoolControlItemProgressBar.setMax(g.b());
            viewHolder.upLoadPoolControlItemProgressBar.setProgress(g.f() - 1);
            TextView textView = viewHolder.upLoadPoolControlItemPercentage;
            if (g.b() == 0) {
                str = "";
            } else {
                str = (((g.f() - 1) * 100) / g.b()) + "%";
            }
            textView.setText(str);
            viewHolder.upLoadPoolControlItemProgressBar.setTag(Integer.valueOf(g.y()));
        } else {
            eVar = new com.rtk.app.main.UpModule.UpControlPack.UpApk.e(g.E(), viewHolder.upLoadPoolControlItemProgressBar, viewHolder.upLoadPoolControlItemState, viewHolder.upLoadPoolControlItemDelete, viewHolder.upLoadPoolControlItemSpeed, viewHolder.upLoadPoolControlItemPercentage, this.f121c);
            viewHolder.upLoadPoolControlItemSize.setText(com.rtk.app.tool.c0.k(Double.parseDouble(g.q())));
            viewHolder.upLoadPoolControlItemIcon.setImageDrawable(com.rtk.app.tool.t.C(this.d, g.o()));
            viewHolder.upLoadPoolControlItemName.setText(g.c());
            viewHolder.upLoadPoolControlItemProgressBar.setMax(g.a());
            viewHolder.upLoadPoolControlItemProgressBar.setProgress(g.e() - 1);
            viewHolder.upLoadPoolControlItemPercentage.setText((((g.e() - 1) * 100) / g.a()) + "%");
            viewHolder.upLoadPoolControlItemProgressBar.setTag(Integer.valueOf(g.E()));
        }
        com.rtk.app.main.UpModule.UpControlPack.UpApk.e eVar2 = eVar;
        int u = com.rtk.app.tool.c0.q(g.z()) ? g.u() : g.v();
        if (u == 0) {
            viewHolder.upLoadPoolControlItemState.setChecked(true);
            viewHolder.upLoadPoolControlItemDelete.setVisibility(4);
            viewHolder.upLoadPoolControlItemSpeed.setText("等待中..");
            if (!com.rtk.app.tool.o.n.e.contains(g.z()) && !com.rtk.app.tool.o.k.i().t(g.n())) {
                viewHolder.upLoadPoolControlItemSpeed.setText("等待中..");
            }
        } else if (u == 1) {
            viewHolder.upLoadPoolControlItemState.setChecked(false);
            viewHolder.upLoadPoolControlItemDelete.setVisibility(0);
            viewHolder.upLoadPoolControlItemSpeed.setText("已暂停");
        } else if (u == 2) {
            viewHolder.upLoadPoolControlItemState.setVisibility(8);
            viewHolder.upLoadPoolControlItemDelete.setVisibility(0);
            viewHolder.upLoadPoolControlItemSpeed.setText("已完成");
        }
        viewHolder.upLoadPoolControlItemState.setOnClickListener(new a(this.d, i, viewHolder));
        viewHolder.upLoadPoolControlItemDelete.setOnClickListener(new a(this.d, i, viewHolder));
        viewHolder.upLoadPoolControlItemEdit.setOnClickListener(new a(this.d, i, viewHolder));
        this.f.add(eVar2);
        com.rtk.app.main.UpModule.UpControlPack.UpApk.f.b().a(eVar2);
        return view2;
    }
}
