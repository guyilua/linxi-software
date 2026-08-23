package com.rtk.app.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.adapter.DownLoadAdapter;
import com.rtk.app.main.MyApplication;
import java.io.File;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DownLoadAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f42c;
    private List<com.rtk.app.tool.DownLoadTool.p> d;
    private Handler e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder {

        @BindView
        ImageView downloadAdapterItemClose;

        @BindView
        ImageView downloadAdapterItemIcon;

        @BindView
        TextView downloadAdapterItemInstall;

        @BindView
        TextView downloadAdapterItemName;

        @BindView
        ProgressBar downloadAdapterItemProgressBar;

        @BindView
        TextView downloadAdapterItemSize;

        @BindView
        TextView downloadAdapterItemSpeed;

        @BindView
        ImageView downloadAdapterItemStartOrStop;

        ViewHolder(DownLoadAdapter downLoadAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.downloadAdapterItemIcon = (ImageView) butterknife.c.a.c(view, R.id.download_adapter_item_icon, "field 'downloadAdapterItemIcon'", ImageView.class);
            viewHolder.downloadAdapterItemName = (TextView) butterknife.c.a.c(view, R.id.download_adapter_item_name, "field 'downloadAdapterItemName'", TextView.class);
            viewHolder.downloadAdapterItemProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.download_adapter_item_ProgressBar, "field 'downloadAdapterItemProgressBar'", ProgressBar.class);
            viewHolder.downloadAdapterItemSpeed = (TextView) butterknife.c.a.c(view, R.id.download_adapter_item_speed, "field 'downloadAdapterItemSpeed'", TextView.class);
            viewHolder.downloadAdapterItemSize = (TextView) butterknife.c.a.c(view, R.id.download_adapter_item_size, "field 'downloadAdapterItemSize'", TextView.class);
            viewHolder.downloadAdapterItemStartOrStop = (ImageView) butterknife.c.a.c(view, R.id.download_adapter_item_start_or_stop, "field 'downloadAdapterItemStartOrStop'", ImageView.class);
            viewHolder.downloadAdapterItemClose = (ImageView) butterknife.c.a.c(view, R.id.download_adapter_item_close, "field 'downloadAdapterItemClose'", ImageView.class);
            viewHolder.downloadAdapterItemInstall = (TextView) butterknife.c.a.c(view, R.id.download_adapter_item_install, "field 'downloadAdapterItemInstall'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.downloadAdapterItemIcon = null;
                viewHolder.downloadAdapterItemName = null;
                viewHolder.downloadAdapterItemProgressBar = null;
                viewHolder.downloadAdapterItemSpeed = null;
                viewHolder.downloadAdapterItemSize = null;
                viewHolder.downloadAdapterItemStartOrStop = null;
                viewHolder.downloadAdapterItemClose = null;
                viewHolder.downloadAdapterItemInstall = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements View.OnClickListener {
        private int a;
        private int b;

        /* renamed from: c, reason: collision with root package name */
        private ViewHolder f43c;

        public a(int i, int i2, ViewHolder viewHolder) {
            this.a = i;
            this.b = i2;
            this.f43c = viewHolder;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(String[] strArr) {
            com.rtk.app.tool.f.a(DownLoadAdapter.this.f42c, "文件不存在！", 200);
            DownLoadAdapter.this.d.remove(this.a);
            DownLoadAdapter.this.notifyDataSetChanged();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (com.rtk.app.tool.DownLoadTool.q.e().size() == 0) {
                    com.rtk.app.tool.g.c.e(MyApplication.b()).b();
                }
                com.rtk.app.tool.DownLoadTool.p d = com.rtk.app.tool.DownLoadTool.q.d(((com.rtk.app.tool.DownLoadTool.p) DownLoadAdapter.this.d.get(this.a)).j());
                int i = this.b;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return;
                        }
                        new com.rtk.app.main.dialogPack.p(DownLoadAdapter.this.f42c, d, DownLoadAdapter.this.e, 0, new List[0]).show();
                        return;
                    } else {
                        if (((TextView) view).getText().equals("安装")) {
                            try {
                                com.rtk.app.tool.t.M1(d.j(), DownLoadAdapter.this.f42c, new com.rtk.app.tool.s() { // from class: com.rtk.app.adapter.l0
                                    @Override // com.rtk.app.tool.s
                                    public final void a(String[] strArr) {
                                        DownLoadAdapter.a.this.b(strArr);
                                    }
                                });
                                return;
                            } catch (Exception e) {
                                com.rtk.app.tool.c0.u("DownLoadAdapter", "点击安装的异常" + e.toString());
                                return;
                            }
                        }
                        return;
                    }
                }
                int j = d.j();
                com.rtk.app.tool.c0.u("DownLoadAdapter", "下载管理页面开始暂停按钮" + j);
                if (d.h() == com.rtk.app.tool.DownLoadTool.q.f286c) {
                    com.rtk.app.tool.DownLoadTool.t.h(j, com.rtk.app.tool.DownLoadTool.q.d, new boolean[0]);
                    com.rtk.app.tool.p.a(DownLoadAdapter.this.f42c).d(d.j());
                    d.y(com.rtk.app.tool.DownLoadTool.q.d);
                    com.rtk.app.tool.DownLoadTool.x.c().k(j);
                    com.rtk.app.tool.g.c.e(DownLoadAdapter.this.f42c).i(com.rtk.app.tool.DownLoadTool.q.d, j);
                } else if (d.h() == com.rtk.app.tool.DownLoadTool.q.d) {
                    d.y(com.rtk.app.tool.DownLoadTool.q.f286c);
                    if (d.q() != 0) {
                        com.rtk.app.tool.i.i.e(DownLoadAdapter.this.f42c, d);
                    } else {
                        com.rtk.app.tool.DownLoadTool.r.c(DownLoadAdapter.this.f42c, d);
                    }
                }
                DownLoadAdapter.this.j(this.f43c, com.rtk.app.tool.DownLoadTool.q.d(d.j()).h());
            } catch (Exception e2) {
                com.rtk.app.tool.c0.u("DownLoadAdapter", "点击异常" + e2.toString());
            }
        }
    }

    public DownLoadAdapter(Context context, List<com.rtk.app.tool.DownLoadTool.p> list, Handler handler) {
        super(list);
        this.f42c = context;
        this.d = list;
        this.e = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ViewHolder viewHolder, int i) {
        if (i == com.rtk.app.tool.DownLoadTool.q.f286c) {
            viewHolder.downloadAdapterItemStartOrStop.setSelected(false);
            viewHolder.downloadAdapterItemStartOrStop.setVisibility(0);
            viewHolder.downloadAdapterItemInstall.setVisibility(4);
            viewHolder.downloadAdapterItemSpeed.setText("等待中");
            viewHolder.downloadAdapterItemProgressBar.setVisibility(0);
            viewHolder.downloadAdapterItemSize.setVisibility(8);
            viewHolder.downloadAdapterItemInstall.setText("下载中");
            return;
        }
        if (i == com.rtk.app.tool.DownLoadTool.q.d) {
            viewHolder.downloadAdapterItemStartOrStop.setSelected(true);
            viewHolder.downloadAdapterItemStartOrStop.setVisibility(0);
            viewHolder.downloadAdapterItemInstall.setVisibility(4);
            viewHolder.downloadAdapterItemSpeed.setText("已暂停");
            viewHolder.downloadAdapterItemProgressBar.setVisibility(0);
            viewHolder.downloadAdapterItemInstall.setText("继续");
            return;
        }
        if (i == com.rtk.app.tool.DownLoadTool.q.e) {
            viewHolder.downloadAdapterItemStartOrStop.setVisibility(4);
            viewHolder.downloadAdapterItemInstall.setVisibility(0);
            viewHolder.downloadAdapterItemSpeed.setText("下载完成，可安装");
            viewHolder.downloadAdapterItemProgressBar.setVisibility(8);
            viewHolder.downloadAdapterItemInstall.setText("安装");
            viewHolder.downloadAdapterItemSize.setVisibility(0);
            return;
        }
        if (i == com.rtk.app.tool.DownLoadTool.q.g) {
            viewHolder.downloadAdapterItemStartOrStop.setSelected(false);
            viewHolder.downloadAdapterItemStartOrStop.setVisibility(0);
            viewHolder.downloadAdapterItemInstall.setVisibility(4);
            viewHolder.downloadAdapterItemSpeed.setText("等待中");
            viewHolder.downloadAdapterItemProgressBar.setVisibility(0);
            viewHolder.downloadAdapterItemSize.setVisibility(8);
            viewHolder.downloadAdapterItemInstall.setText("下载中");
            return;
        }
        com.rtk.app.tool.c0.u("DownLoadAdapter", "我是其他状态 " + i);
        viewHolder.downloadAdapterItemStartOrStop.setVisibility(8);
        viewHolder.downloadAdapterItemInstall.setVisibility(8);
        viewHolder.downloadAdapterItemProgressBar.setVisibility(8);
        viewHolder.downloadAdapterItemInstall.setText("-- --");
    }

    @Override // com.rtk.app.adapter.a3
    public void b() {
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f42c).inflate(R.layout.download_adapter_item, (ViewGroup) null);
            viewHolder = new ViewHolder(this, view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        int size = (this.d.size() - i) - 1;
        com.rtk.app.tool.DownLoadTool.p pVar = this.d.get(size);
        com.rtk.app.tool.t.d(this.f42c, pVar.k(), viewHolder.downloadAdapterItemIcon);
        viewHolder.downloadAdapterItemInstall.setTag(Integer.valueOf(pVar.j()));
        viewHolder.downloadAdapterItemProgressBar.setVisibility(8);
        viewHolder.downloadAdapterItemProgressBar.setMax((int) pVar.p());
        viewHolder.downloadAdapterItemProgressBar.setProgress((int) pVar.f());
        viewHolder.downloadAdapterItemName.setText(pVar.c());
        com.rtk.app.tool.DownLoadTool.v vVar = new com.rtk.app.tool.DownLoadTool.v(viewHolder.downloadAdapterItemProgressBar, pVar.j(), viewHolder.downloadAdapterItemInstall, viewHolder.downloadAdapterItemStartOrStop, viewHolder.downloadAdapterItemSpeed, viewHolder.downloadAdapterItemSize);
        this.b.add(vVar);
        com.rtk.app.tool.DownLoadTool.x.c().a(vVar);
        j(viewHolder, pVar.h());
        File file = new File(pVar.e());
        viewHolder.downloadAdapterItemSize.setVisibility(file.length() != 0 ? 0 : 8);
        if (pVar.h() == com.rtk.app.tool.DownLoadTool.q.e) {
            viewHolder.downloadAdapterItemSize.setText(file.length() != 0 ? com.rtk.app.tool.c0.l(file.length()) : "--.--");
        } else {
            TextView textView = viewHolder.downloadAdapterItemSize;
            StringBuilder sb = new StringBuilder();
            sb.append(file.length() == 0 ? "--.--" : com.rtk.app.tool.c0.l(file.length()));
            sb.append("/");
            sb.append(pVar.d() != 0 ? com.rtk.app.tool.c0.l(pVar.d()) : "--.--");
            textView.setText(sb.toString());
        }
        viewHolder.downloadAdapterItemStartOrStop.setOnClickListener(new a(size, 1, viewHolder));
        viewHolder.downloadAdapterItemInstall.setOnClickListener(new a(size, 2, viewHolder));
        viewHolder.downloadAdapterItemClose.setOnClickListener(new a(size, 3, viewHolder));
        return view;
    }
}
