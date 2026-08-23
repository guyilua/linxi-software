package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.bean.BlacklistListBean;
import com.rtk.app.main.dialogPack.DialogAddBlacklist;
import com.rtk.app.main.dialogPack.DialogRemoveBlacklist;
import com.rtk.app.tool.j;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class BlacklistListAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f39c;
    private List<BlacklistListBean.DataDTO> d;
    private String e;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ViewHolder {

        @BindView
        RoundedImageView blacklistListItemIcon;

        @BindView
        TextView blacklistListItemNickName;

        @BindView
        TextView blacklistListItemState;

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
            viewHolder.blacklistListItemIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.blacklist_list_item_icon, "field 'blacklistListItemIcon'", RoundedImageView.class);
            viewHolder.blacklistListItemNickName = (TextView) butterknife.c.a.c(view, R.id.blacklist_list_item_nickName, "field 'blacklistListItemNickName'", TextView.class);
            viewHolder.blacklistListItemState = (TextView) butterknife.c.a.c(view, R.id.blacklist_list_item_state, "field 'blacklistListItemState'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.blacklistListItemIcon = null;
                viewHolder.blacklistListItemNickName = null;
                viewHolder.blacklistListItemState = null;
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
            int[] iArr = new int[j.a.values().length];
            a = iArr;
            try {
                iArr[j.a.YES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[j.a.NO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public BlacklistListAdapter(Context context, List<BlacklistListBean.DataDTO> list, String str) {
        super(list);
        this.f39c = context;
        this.d = list;
        this.e = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(final int i, View view) {
        if (this.d.get(i).isBlacklist()) {
            new DialogRemoveBlacklist(this.f39c, this.e, this.d.get(i).getUid(), this.d.get(i).getNickname(), new com.rtk.app.tool.j() { // from class: com.rtk.app.adapter.j0
                @Override // com.rtk.app.tool.j
                public final void m(j.a aVar) {
                    BlacklistListAdapter.this.i(i, aVar);
                }
            }).show();
        } else {
            new DialogAddBlacklist(this.f39c, this.e, this.d.get(i).getNickname(), this.d.get(i).getUid(), new com.rtk.app.tool.j() { // from class: com.rtk.app.adapter.k0
                @Override // com.rtk.app.tool.j
                public final void m(j.a aVar) {
                    BlacklistListAdapter.this.k(i, aVar);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(int i, j.a aVar) {
        if (a.a[aVar.ordinal()] != 2) {
            return;
        }
        this.d.get(i).setBlacklist(false);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(int i, j.a aVar) {
        if (a.a[aVar.ordinal()] != 1) {
            return;
        }
        this.d.get(i).setBlacklist(true);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f39c).inflate(R.layout.blacklist_list_item_layout, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        com.rtk.app.tool.t.c(this.f39c, this.d.get(i).getFace(), viewHolder.blacklistListItemIcon, new boolean[0]);
        viewHolder.blacklistListItemNickName.setText(this.d.get(i).getNickname());
        viewHolder.blacklistListItemState.setText(this.d.get(i).isBlacklist() ? "解除" : "加入");
        viewHolder.blacklistListItemState.setSelected(this.d.get(i).isBlacklist());
        viewHolder.blacklistListItemState.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.adapter.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BlacklistListAdapter.this.f(i, view2);
            }
        });
        return view;
    }
}
