package com.ss.android.socialbase.downloader.impls;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class n extends com.ss.android.socialbase.downloader.downloader.a implements ServiceConnection {
    private static final String e = n.class.getSimpleName();
    private com.ss.android.socialbase.downloader.downloader.i f;
    private com.ss.android.socialbase.downloader.downloader.n g;
    private int h = -1;

    private void h() {
        SparseArray<List<DownloadTask>> clone;
        try {
            synchronized (this.a) {
                clone = this.a.clone();
                this.a.clear();
            }
            if (clone == null || clone.size() <= 0 || com.ss.android.socialbase.downloader.downloader.c.D() == null) {
                return;
            }
            for (int i = 0; i < clone.size(); i++) {
                List<DownloadTask> list = clone.get(clone.keyAt(i));
                if (list != null) {
                    Iterator<DownloadTask> it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            this.f.a(com.ss.android.socialbase.downloader.i.g.a(it.next()));
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.c.a.b(e, "resumePendingTaskForIndependent failed", th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void a(Context context, ServiceConnection serviceConnection) {
        try {
            com.ss.android.socialbase.downloader.c.a.b(e, "bindService");
            Intent intent = new Intent(context, (Class<?>) IndependentProcessDownloadService.class);
            if (com.ss.android.socialbase.downloader.i.f.a()) {
                intent.putExtra("fix_downloader_db_sigbus", com.ss.android.socialbase.downloader.g.a.c().a("fix_sigbus_downloader_db"));
            }
            if (serviceConnection != null) {
                context.bindService(intent, serviceConnection, 1);
            }
            context.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void b(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        String str = e;
        StringBuilder sb = new StringBuilder("tryDownload aidlService == null:");
        sb.append(this.f == null);
        com.ss.android.socialbase.downloader.c.a.b(str, sb.toString());
        if (this.f == null) {
            a(downloadTask);
            a(com.ss.android.socialbase.downloader.downloader.c.O(), this);
            return;
        }
        h();
        try {
            this.f.a(com.ss.android.socialbase.downloader.i.g.a(downloadTask));
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void c(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.d.a().a(downloadTask.getDownloadId(), true);
        a D = com.ss.android.socialbase.downloader.downloader.c.D();
        if (D != null) {
            D.a(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void f() {
        if (this.f == null) {
            a(com.ss.android.socialbase.downloader.downloader.c.O(), this);
        }
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        this.f = null;
        com.ss.android.socialbase.downloader.downloader.n nVar = this.g;
        if (nVar != null) {
            nVar.i();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String str = e;
        com.ss.android.socialbase.downloader.c.a.b(str, "onServiceConnected ");
        this.f = i.a.a(iBinder);
        com.ss.android.socialbase.downloader.downloader.n nVar = this.g;
        if (nVar != null) {
            nVar.a(iBinder);
        }
        StringBuilder sb = new StringBuilder("onServiceConnected aidlService!=null");
        sb.append(this.f != null);
        sb.append(" pendingTasks.size:");
        sb.append(this.a.size());
        com.ss.android.socialbase.downloader.c.a.b(str, sb.toString());
        if (this.f != null) {
            com.ss.android.socialbase.downloader.downloader.d.a().b();
            this.b = true;
            this.d = false;
            int i = this.h;
            if (i != -1) {
                try {
                    this.f.l(i);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            if (this.f != null) {
                h();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.ss.android.socialbase.downloader.c.a.b(e, "onServiceDisconnected ");
        this.f = null;
        this.b = false;
        com.ss.android.socialbase.downloader.downloader.n nVar = this.g;
        if (nVar != null) {
            nVar.i();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public IBinder a(Intent intent) {
        if (intent != null && intent.getBooleanExtra("fix_downloader_db_sigbus", false)) {
            Log.w(e, "downloader process sync database on main process!");
            com.ss.android.socialbase.downloader.g.a.a("fix_sigbus_downloader_db", true);
        }
        com.ss.android.socialbase.downloader.c.a.b(e, "onBind IndependentDownloadBinder");
        return new m();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void a(com.ss.android.socialbase.downloader.downloader.n nVar) {
        this.g = nVar;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.o
    public void a(int i) {
        com.ss.android.socialbase.downloader.downloader.i iVar = this.f;
        if (iVar == null) {
            this.h = i;
            return;
        }
        try {
            iVar.l(i);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
