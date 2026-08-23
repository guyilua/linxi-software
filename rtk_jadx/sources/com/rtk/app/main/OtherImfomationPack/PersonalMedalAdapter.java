package com.rtk.app.main.OtherImfomationPack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.bean.AchievementBean;
import com.rtk.app.bean.EventMedalBean;
import com.zhy.view.flowlayout.FlowLayout;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PersonalMedalAdapter extends com.zhy.view.flowlayout.a<String> {
    private Context d;
    private List<String> e;
    private List<AchievementBean> f;
    private List<EventMedalBean> g;
    private String h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class ViewHolder {

        @BindView
        ImageView personalMedalItemImg;

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
            viewHolder.personalMedalItemImg = (ImageView) butterknife.c.a.c(view, R.id.personal_medal_item_img, "field 'personalMedalItemImg'", ImageView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.personalMedalItemImg = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int size = PersonalMedalAdapter.this.g.size();
            PersonalMedalAdapter.this.f.size();
            int intValue = ((Integer) view.getTag()).intValue();
            if (intValue <= size - 1) {
                com.rtk.app.tool.t.x0(PersonalMedalAdapter.this.d, ((EventMedalBean) PersonalMedalAdapter.this.g.get(intValue)).getId(), PersonalMedalAdapter.this.h);
            } else {
                int i = intValue - size;
                com.rtk.app.tool.t.h0(PersonalMedalAdapter.this.d, ((AchievementBean) PersonalMedalAdapter.this.f.get(i)).getId(), ((AchievementBean) PersonalMedalAdapter.this.f.get(i)).getPid(), PersonalMedalAdapter.this.h);
            }
        }
    }

    public PersonalMedalAdapter(Context context, List<String> list, List<EventMedalBean> list2, List<AchievementBean> list3, String str) {
        super(list);
        this.h = "";
        this.e = list;
        this.h = str;
        this.f = list3;
        this.g = list2;
        this.d = context;
    }

    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public View d(FlowLayout flowLayout, int i, String str) {
        View inflate = LayoutInflater.from(this.d).inflate(R.layout.personnal_medal_item_layout, (ViewGroup) flowLayout, false);
        com.rtk.app.tool.t.c(this.d, this.e.get(i), new ViewHolder(inflate).personalMedalItemImg, new boolean[0]);
        inflate.setTag(Integer.valueOf(i));
        inflate.setOnClickListener(new a());
        return inflate;
    }
}
