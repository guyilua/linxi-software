package com.rtk.app.main.UpModule.UpHolderTool;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.base.g;
import com.rtk.app.bean.UpGameTypeBean;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpGameSrcTypeHolder extends g implements View.OnClickListener, h.j {
    private Context j;
    private View k;
    private List<UpGameTypeBean.DataBean> l;
    private ArrayAdapter<UpGameTypeBean.DataBean> m;
    public int n;
    public String o;
    public String p;

    @BindView
    Spinner upGameSrcApkTags;

    @BindView
    RadioGroup upGameSrcApkType;

    @BindView
    RadioButton upGameSrcApkTypeGame;

    @BindView
    RadioButton upGameSrcApkTypeSoft;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements RadioGroup.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (radioGroup.getCheckedRadioButtonId() == 2131300947) {
                UpGameSrcTypeHolder.this.n = 0;
            } else {
                UpGameSrcTypeHolder.this.n = 1;
            }
            UpGameSrcTypeHolder.this.s();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            UpGameSrcTypeHolder upGameSrcTypeHolder = UpGameSrcTypeHolder.this;
            upGameSrcTypeHolder.o = ((UpGameTypeBean.DataBean) upGameSrcTypeHolder.l.get(i)).getId();
            UpGameSrcTypeHolder upGameSrcTypeHolder2 = UpGameSrcTypeHolder.this;
            upGameSrcTypeHolder2.p = ((UpGameTypeBean.DataBean) upGameSrcTypeHolder2.l.get(i)).getTitle();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public UpGameSrcTypeHolder(Context context, View view) {
        super(context, view);
        this.o = null;
        this.j = context;
        this.k = view;
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        c0.u("UpGameSrcTypeHolder", "  上传游戏的类型列表   " + str);
        UpGameTypeBean upGameTypeBean = (UpGameTypeBean) create.fromJson(str, UpGameTypeBean.class);
        this.l.clear();
        this.l.addAll(upGameTypeBean.getData());
        this.m.notifyDataSetChanged();
        this.upGameSrcApkTags.performClick();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }

    @Override // com.rtk.app.base.g
    public void h(Context context, View view) {
        this.upGameSrcApkType.setOnCheckedChangeListener(new a());
        this.upGameSrcApkTags.setOnItemSelectedListener(new b());
    }

    @Override // com.rtk.app.base.g
    public void i(Context context, View view) {
        ButterKnife.b(this, view);
        this.l = new ArrayList();
        ArrayAdapter<UpGameTypeBean.DataBean> arrayAdapter = new ArrayAdapter<>(context, R.layout.simple_spinner_dropdown_item, this.l);
        this.m = arrayAdapter;
        this.upGameSrcApkTags.setAdapter((SpinnerAdapter) arrayAdapter);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void s() {
        h.l(this.j, this, 1, h.h(new String[0]).a("members/sourceType" + y.u(this.j) + "&type=" + this.n + "&key=" + t.c0(c0.e(y.v(this.j, new String[0])))));
    }
}
