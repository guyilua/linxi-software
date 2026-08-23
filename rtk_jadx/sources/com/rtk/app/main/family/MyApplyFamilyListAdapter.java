package com.rtk.app.main.family;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.adapter.a3;
import com.rtk.app.bean.ApplyJoinFamilyInfo;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyApplyFamilyListAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f264c;
    private List<ApplyJoinFamilyInfo.DataBean> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class ViewHolder {

        @BindView
        TextView cancelApply;

        @BindView
        RoundedImageView familyLogo;

        @BindView
        TextView familyName;

        @BindView
        TextView memberNu;

        ViewHolder(MyApplyFamilyListAdapter myApplyFamilyListAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.familyLogo = (RoundedImageView) butterknife.c.a.c(view, R.id.family_logo, "field 'familyLogo'", RoundedImageView.class);
            viewHolder.familyName = (TextView) butterknife.c.a.c(view, R.id.family_name, "field 'familyName'", TextView.class);
            viewHolder.memberNu = (TextView) butterknife.c.a.c(view, R.id.member_nu, "field 'memberNu'", TextView.class);
            viewHolder.cancelApply = (TextView) butterknife.c.a.c(view, R.id.cancel_apply, "field 'cancelApply'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.familyLogo = null;
                viewHolder.familyName = null;
                viewHolder.memberNu = null;
                viewHolder.cancelApply = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements View.OnClickListener {
        final /* synthetic */ ViewHolder a;
        final /* synthetic */ ApplyJoinFamilyInfo.DataBean b;

        a(ViewHolder viewHolder, ApplyJoinFamilyInfo.DataBean dataBean) {
            this.a = viewHolder;
            this.b = dataBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MyApplyFamilyListAdapter.this.h(this.a.cancelApply, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements DialogInterface.OnClickListener {
        final /* synthetic */ ApplyJoinFamilyInfo.DataBean a;
        final /* synthetic */ TextView b;

        /* loaded from: /tmp/rtk_apk/classes3.dex */
        class a implements h.j {
            a() {
            }

            @Override // com.rtk.app.tool.o.h.j
            public void d(String str, int i) {
                com.rtk.app.tool.f.a(MyApplyFamilyListAdapter.this.f264c, "成功取消", f.a.f);
                b.this.b.setText("已取消");
                b bVar = b.this;
                bVar.b.setBackground(ContextCompat.getDrawable(MyApplyFamilyListAdapter.this.f264c, R.drawable.shape_corner_wideline_5dp));
                b.this.b.setOnClickListener(null);
            }

            @Override // com.rtk.app.tool.o.h.j
            public void g(int i, String str, int i2) {
            }
        }

        b(ApplyJoinFamilyInfo.DataBean dataBean, TextView textView) {
            this.a = dataBean;
            this.b = textView;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            HashMap<String, String> l = com.rtk.app.tool.y.l();
            l.put("family_id", this.a.getFamily_id());
            l.put("key", com.rtk.app.tool.t.L(l));
            com.rtk.app.tool.o.h.j(MyApplyFamilyListAdapter.this.f264c, new a(), com.rtk.app.tool.y.e + "family/join/cancel", 1, l);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class c implements DialogInterface.OnClickListener {
        c(MyApplyFamilyListAdapter myApplyFamilyListAdapter) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public MyApplyFamilyListAdapter(Context context, List<ApplyJoinFamilyInfo.DataBean> list) {
        super(list);
        this.f264c = context;
        this.d = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(TextView textView, ApplyJoinFamilyInfo.DataBean dataBean) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f264c);
        builder.setTitle("温馨提示");
        builder.setMessage("是否确认取消申请加入" + dataBean.getFamily_name() + "家族?");
        builder.setPositiveButton("确定", new b(dataBean, textView));
        builder.setNegativeButton("取消", new c(this));
        builder.create().show();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f264c).inflate(R.layout.family_list_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(this, view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        ApplyJoinFamilyInfo.DataBean dataBean = this.d.get(i);
        com.rtk.app.tool.t.c(this.f264c, dataBean.getFamily_logo(), viewHolder.familyLogo, new boolean[0]);
        viewHolder.familyName.setText("家族名称：" + dataBean.getFamily_name());
        viewHolder.memberNu.setText("成员数量：" + dataBean.getMember_num());
        viewHolder.cancelApply.setVisibility(0);
        if (TextUtils.equals("1", dataBean.getStatus())) {
            viewHolder.cancelApply.setOnClickListener(new a(viewHolder, dataBean));
        }
        return view;
    }
}
