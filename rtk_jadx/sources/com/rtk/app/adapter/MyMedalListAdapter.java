package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.base.BaseRecyclerViewAdapter;
import com.rtk.app.bean.AchievementBean;
import com.rtk.app.bean.EventMedalBean;
import com.rtk.app.custom.CustomTextView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyMedalListAdapter extends BaseRecyclerViewAdapter {
    private Context e;
    private List<AchievementBean> f;
    private List<EventMedalBean> g;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class AchievementHolder extends RecyclerView.ViewHolder {

        @BindView
        LinearLayout myMedalListItemForAchievementLvLayout;

        public AchievementHolder(@NonNull View view) {
            super(view);
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class AchievementHolder_ViewBinding implements Unbinder {
        private AchievementHolder b;

        @UiThread
        public AchievementHolder_ViewBinding(AchievementHolder achievementHolder, View view) {
            this.b = achievementHolder;
            achievementHolder.myMedalListItemForAchievementLvLayout = (LinearLayout) butterknife.c.a.c(view, R.id.my_medal_list_item_for_achievement_lv_layout, "field 'myMedalListItemForAchievementLvLayout'", LinearLayout.class);
        }

        @CallSuper
        public void a() {
            AchievementHolder achievementHolder = this.b;
            if (achievementHolder != null) {
                this.b = null;
                achievementHolder.myMedalListItemForAchievementLvLayout = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ExclusiveHolder extends RecyclerView.ViewHolder {

        @BindView
        LinearLayout myMedalListItemForExclusiveLvLayout;

        public ExclusiveHolder(@NonNull View view) {
            super(view);
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ExclusiveHolder_ViewBinding implements Unbinder {
        private ExclusiveHolder b;

        @UiThread
        public ExclusiveHolder_ViewBinding(ExclusiveHolder exclusiveHolder, View view) {
            this.b = exclusiveHolder;
            exclusiveHolder.myMedalListItemForExclusiveLvLayout = (LinearLayout) butterknife.c.a.c(view, R.id.my_medal_list_item_for_exclusive_lv_layout, "field 'myMedalListItemForExclusiveLvLayout'", LinearLayout.class);
        }

        @CallSuper
        public void a() {
            ExclusiveHolder exclusiveHolder = this.b;
            if (exclusiveHolder != null) {
                this.b = null;
                exclusiveHolder.myMedalListItemForExclusiveLvLayout = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class InformationHolder extends RecyclerView.ViewHolder {

        @BindView
        TextView medalInformationNickName;

        @BindView
        CustomTextView medalInformationNum;

        @BindView
        RoundedImageView medalInformationUserLogo;
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class InformationHolder_ViewBinding implements Unbinder {
        private InformationHolder b;

        @UiThread
        public InformationHolder_ViewBinding(InformationHolder informationHolder, View view) {
            informationHolder.medalInformationNickName = (TextView) butterknife.c.a.c(view, R.id.medal_information_nickName, "field 'medalInformationNickName'", TextView.class);
            informationHolder.medalInformationNum = (CustomTextView) butterknife.c.a.c(view, R.id.medal_information_num, "field 'medalInformationNum'", CustomTextView.class);
            informationHolder.medalInformationUserLogo = (RoundedImageView) butterknife.c.a.c(view, R.id.medal_information_user_logo, "field 'medalInformationUserLogo'", RoundedImageView.class);
        }

        @CallSuper
        public void a() {
            InformationHolder informationHolder = this.b;
            if (informationHolder != null) {
                informationHolder.medalInformationNickName = null;
                informationHolder.medalInformationNum = null;
                informationHolder.medalInformationUserLogo = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            com.rtk.app.tool.t.h0(MyMedalListAdapter.this.e, ((AchievementBean) MyMedalListAdapter.this.f.get(intValue)).getId(), ((AchievementBean) MyMedalListAdapter.this.f.get(intValue)).getPid(), com.rtk.app.tool.y.K());
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.rtk.app.tool.t.x0(MyMedalListAdapter.this.e, ((EventMedalBean) MyMedalListAdapter.this.g.get(((Integer) view.getTag()).intValue())).getId(), com.rtk.app.tool.y.K());
        }
    }

    public MyMedalListAdapter(Context context) {
        this.e = context;
    }

    public int getItemCount() {
        return 2;
    }

    public int getItemViewType(int i) {
        return i != 0 ? 3 : 2;
    }

    public void o(List<AchievementBean> list) {
        this.f = list;
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        int i2 = R.layout.my_medal_list_item_for_achievement_item_layout;
        int i3 = R.id.my_medal_list_item_for_achievement_item_for_item_name;
        int i4 = R.id.my_medal_list_item_for_achievement_item_for_item_img;
        float f = 1.0f;
        int i5 = -2;
        if (itemViewType != 2) {
            if (this.g == null) {
                return;
            }
            com.rtk.app.tool.c0.u("MyMedalListAdapter", "11001");
            ArrayList arrayList = new ArrayList();
            ExclusiveHolder exclusiveHolder = (ExclusiveHolder) viewHolder;
            exclusiveHolder.myMedalListItemForExclusiveLvLayout.removeAllViews();
            com.rtk.app.tool.c0.u("MyMedalListAdapter", "111");
            LinearLayout linearLayout = null;
            int i6 = 0;
            while (i6 < this.g.size()) {
                if (i6 % 3 == 0) {
                    com.rtk.app.tool.c0.u("MyMedalListAdapter", "222");
                    linearLayout = (LinearLayout) LayoutInflater.from(this.e).inflate(R.layout.my_medal_list_item_for_achievement_item_layout, (ViewGroup) null);
                    arrayList.add(linearLayout);
                    exclusiveHolder.myMedalListItemForExclusiveLvLayout.addView(linearLayout);
                }
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.e).inflate(R.layout.my_medal_list_item_for_achievement_item_for_item_layout, (ViewGroup) null);
                linearLayout2.setTag(Integer.valueOf(i6));
                linearLayout2.setOnClickListener(new b());
                com.rtk.app.tool.c0.u("MyMedalListAdapter", "33");
                linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, f));
                ImageView imageView = (ImageView) linearLayout2.findViewById(i4);
                TextView textView = (TextView) linearLayout2.findViewById(i3);
                com.rtk.app.tool.c0.u("MyMedalListAdapter", "444");
                textView.setText(this.g.get(i6).getTitle());
                com.rtk.app.tool.t.c(this.e, this.g.get(i6).getPic(), imageView, new boolean[0]);
                linearLayout.addView(linearLayout2);
                i6++;
                i3 = R.id.my_medal_list_item_for_achievement_item_for_item_name;
                i4 = R.id.my_medal_list_item_for_achievement_item_for_item_img;
                f = 1.0f;
            }
            return;
        }
        if (this.f == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        AchievementHolder achievementHolder = (AchievementHolder) viewHolder;
        achievementHolder.myMedalListItemForAchievementLvLayout.removeAllViews();
        LinearLayout linearLayout3 = null;
        int i7 = 0;
        while (i7 < this.f.size()) {
            if (i7 % 3 == 0) {
                linearLayout3 = (LinearLayout) LayoutInflater.from(this.e).inflate(i2, (ViewGroup) null);
                arrayList2.add(linearLayout3);
                achievementHolder.myMedalListItemForAchievementLvLayout.addView(linearLayout3);
            }
            LinearLayout linearLayout4 = (LinearLayout) LayoutInflater.from(this.e).inflate(R.layout.my_medal_list_item_for_achievement_item_for_item_layout, (ViewGroup) null);
            linearLayout4.setTag(Integer.valueOf(i7));
            linearLayout4.setOnClickListener(new a());
            linearLayout4.setLayoutParams(new LinearLayout.LayoutParams(0, i5, 1.0f));
            ImageView imageView2 = (ImageView) linearLayout4.findViewById(R.id.my_medal_list_item_for_achievement_item_for_item_img);
            ((TextView) linearLayout4.findViewById(R.id.my_medal_list_item_for_achievement_item_for_item_name)).setText(this.f.get(i7).getTitle());
            com.rtk.app.tool.t.c(this.e, this.f.get(i7).getPic(), imageView2, new boolean[0]);
            linearLayout3.addView(linearLayout4);
            i7++;
            i2 = R.layout.my_medal_list_item_for_achievement_item_layout;
            i5 = -2;
        }
    }

    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i != 2) {
            return new ExclusiveHolder(LayoutInflater.from(this.e).inflate(R.layout.my_medal_list_item_for_exclusive_layout, viewGroup, false));
        }
        return new AchievementHolder(LayoutInflater.from(this.e).inflate(R.layout.my_medal_list_item_for_achievement_layout, viewGroup, false));
    }

    public void p(List<EventMedalBean> list) {
        this.g = list;
    }
}
