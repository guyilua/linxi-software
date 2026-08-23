package com.ss.android.socialbase.downloader.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import com.umeng.analytics.pro.ao;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b implements Parcelable {
    private int b;

    /* renamed from: c, reason: collision with root package name */
    private long f896c;
    private AtomicLong d;
    private long e;
    private long f;
    private int g;
    private AtomicInteger h;
    private long i;
    private List<b> j;
    private b k;
    private int l;
    private boolean m;
    private AtomicBoolean n;
    private com.ss.android.socialbase.downloader.h.b o;
    private static final String a = b.class.getSimpleName();
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.ss.android.socialbase.downloader.model.b.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i) {
            return new b[i];
        }
    };

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        private int a;
        private long b;

        /* renamed from: c, reason: collision with root package name */
        private long f897c;
        private long d;
        private long e;
        private int f;
        private long g;
        private b h;

        public a(int i) {
            this.a = i;
        }

        public a a(long j) {
            this.b = j;
            return this;
        }

        public a b(long j) {
            this.f897c = j;
            return this;
        }

        public a c(long j) {
            this.d = j;
            return this;
        }

        public a d(long j) {
            this.e = j;
            return this;
        }

        public a e(long j) {
            this.g = j;
            return this;
        }

        public a a(int i) {
            this.f = i;
            return this;
        }

        public a a(b bVar) {
            this.h = bVar;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ao.d, Integer.valueOf(this.b));
        contentValues.put("chunkIndex", Integer.valueOf(this.g));
        contentValues.put("startOffset", Long.valueOf(this.f896c));
        contentValues.put("curOffset", Long.valueOf(n()));
        contentValues.put("endOffset", Long.valueOf(this.e));
        contentValues.put("chunkContentLen", Long.valueOf(this.f));
        contentValues.put("hostChunkIndex", Integer.valueOf(b()));
        return contentValues;
    }

    public int b() {
        AtomicInteger atomicInteger = this.h;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    public boolean c() {
        AtomicBoolean atomicBoolean = this.n;
        if (atomicBoolean == null) {
            return false;
        }
        return atomicBoolean.get();
    }

    public boolean d() {
        return b() == -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public b e() {
        b bVar = !d() ? this.k : this;
        if (bVar == null || !bVar.f()) {
            return null;
        }
        return bVar.g().get(0);
    }

    public boolean f() {
        List<b> list = this.j;
        return list != null && list.size() > 0;
    }

    public List<b> g() {
        return this.j;
    }

    public boolean h() {
        b bVar = this.k;
        if (bVar == null) {
            return true;
        }
        if (!bVar.f()) {
            return false;
        }
        for (int i = 0; i < this.k.g().size(); i++) {
            b bVar2 = this.k.g().get(i);
            if (bVar2 != null) {
                int indexOf = this.k.g().indexOf(this);
                if (indexOf > i && !bVar2.i()) {
                    return false;
                }
                if (indexOf == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean i() {
        long j = this.f896c;
        if (d()) {
            long j2 = this.i;
            if (j2 > this.f896c) {
                j = j2;
            }
        }
        return n() - j >= this.f;
    }

    public long j() {
        b bVar = this.k;
        if (bVar != null && bVar.g() != null) {
            int indexOf = this.k.g().indexOf(this);
            boolean z = false;
            for (int i = 0; i < this.k.g().size(); i++) {
                b bVar2 = this.k.g().get(i);
                if (bVar2 != null) {
                    if (z) {
                        return bVar2.n();
                    }
                    if (indexOf == i) {
                        z = true;
                    }
                }
            }
        }
        return -1L;
    }

    public int k() {
        return this.b;
    }

    public long l() {
        return this.f896c;
    }

    public long m() {
        AtomicLong atomicLong = this.d;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public long n() {
        if (d() && f()) {
            long j = 0;
            for (int i = 0; i < this.j.size(); i++) {
                b bVar = this.j.get(i);
                if (bVar != null) {
                    if (!bVar.i()) {
                        return bVar.m();
                    }
                    if (j < bVar.m()) {
                        j = bVar.m();
                    }
                }
            }
            return j;
        }
        return m();
    }

    public long o() {
        long n = n() - this.f896c;
        if (f()) {
            n = 0;
            for (int i = 0; i < this.j.size(); i++) {
                b bVar = this.j.get(i);
                if (bVar != null) {
                    n += bVar.n() - bVar.l();
                }
            }
        }
        return n;
    }

    public long p() {
        return this.e;
    }

    public long q() {
        return this.f;
    }

    public void r() {
        this.i = n();
    }

    public int s() {
        return this.g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b);
        parcel.writeLong(this.f896c);
        AtomicLong atomicLong = this.d;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
        parcel.writeLong(this.e);
        parcel.writeLong(this.f);
        parcel.writeInt(this.g);
        AtomicInteger atomicInteger = this.h;
        parcel.writeInt(atomicInteger != null ? atomicInteger.get() : -1);
    }

    private b(a aVar) {
        if (aVar == null) {
            return;
        }
        this.b = aVar.a;
        this.f896c = aVar.b;
        this.d = new AtomicLong(aVar.f897c);
        this.e = aVar.d;
        this.f = aVar.e;
        this.g = aVar.f;
        this.i = aVar.g;
        this.h = new AtomicInteger(-1);
        a(aVar.h);
        this.n = new AtomicBoolean(false);
    }

    public void b(boolean z) {
        this.m = z;
    }

    public void c(int i) {
        this.g = i;
    }

    public void b(int i) {
        this.b = i;
    }

    public long c(boolean z) {
        long n = n();
        long j = this.f;
        long j2 = this.i;
        long j3 = j - (n - j2);
        if (!z && n == j2) {
            j3 = j - (n - this.f896c);
        }
        com.ss.android.socialbase.downloader.c.a.b("DownloadChunk", "contentLength:" + this.f + " curOffset:" + n() + " oldOffset:" + this.i + " retainLen:" + j3);
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public void b(long j) {
        AtomicLong atomicLong = this.d;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.d = new AtomicLong(j);
        }
    }

    public void a(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.l = 0;
        sQLiteStatement.clearBindings();
        int i = this.l + 1;
        this.l = i;
        sQLiteStatement.bindLong(i, this.b);
        int i2 = this.l + 1;
        this.l = i2;
        sQLiteStatement.bindLong(i2, this.g);
        int i3 = this.l + 1;
        this.l = i3;
        sQLiteStatement.bindLong(i3, this.f896c);
        int i4 = this.l + 1;
        this.l = i4;
        sQLiteStatement.bindLong(i4, n());
        int i5 = this.l + 1;
        this.l = i5;
        sQLiteStatement.bindLong(i5, this.e);
        int i6 = this.l + 1;
        this.l = i6;
        sQLiteStatement.bindLong(i6, this.f);
        int i7 = this.l + 1;
        this.l = i7;
        sQLiteStatement.bindLong(i7, b());
    }

    public b(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.b = cursor.getInt(cursor.getColumnIndex(ao.d));
        this.g = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
        this.f896c = cursor.getLong(cursor.getColumnIndex("startOffset"));
        int columnIndex = cursor.getColumnIndex("curOffset");
        if (columnIndex != -1) {
            this.d = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.d = new AtomicLong(0L);
        }
        this.e = cursor.getLong(cursor.getColumnIndex("endOffset"));
        int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
        if (columnIndex2 != -1) {
            this.h = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.h = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
        if (columnIndex3 != -1) {
            this.f = cursor.getLong(columnIndex3);
        }
        this.n = new AtomicBoolean(false);
    }

    public void a(int i) {
        AtomicInteger atomicInteger = this.h;
        if (atomicInteger == null) {
            this.h = new AtomicInteger(i);
        } else {
            atomicInteger.set(i);
        }
    }

    public void a(com.ss.android.socialbase.downloader.h.b bVar) {
        this.o = bVar;
        r();
    }

    public void a(boolean z) {
        AtomicBoolean atomicBoolean = this.n;
        if (atomicBoolean == null) {
            this.n = new AtomicBoolean(z);
        } else {
            atomicBoolean.set(z);
        }
        this.o = null;
    }

    protected b(Parcel parcel) {
        this.b = parcel.readInt();
        this.f896c = parcel.readLong();
        this.d = new AtomicLong(parcel.readLong());
        this.e = parcel.readLong();
        this.f = parcel.readLong();
        this.g = parcel.readInt();
        this.h = new AtomicInteger(parcel.readInt());
    }

    public void a(b bVar) {
        this.k = bVar;
        if (bVar != null) {
            a(bVar.s());
        }
    }

    public void a(List<b> list) {
        this.j = list;
    }

    public void a(long j) {
        this.f = j;
    }

    public List<b> a(int i, long j) {
        b bVar;
        long p;
        long j2;
        long j3;
        long j4;
        b bVar2 = this;
        int i2 = i;
        if (!d() || f()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long m = m();
        long c2 = bVar2.c(true);
        long j5 = c2 / i2;
        com.ss.android.socialbase.downloader.c.a.b(a, "retainLen:" + c2 + " divideChunkForReuse chunkSize:" + j5 + " current host downloadChunk index:" + bVar2.g);
        int i3 = 0;
        while (i3 < i2) {
            if (i3 == 0) {
                j2 = l();
            } else {
                int i4 = i2 - 1;
                if (i3 == i4) {
                    long p2 = p();
                    j3 = p2;
                    j4 = p2 > m ? (p2 - m) + 1 : c2 - (i4 * j5);
                    j2 = m;
                    long j6 = c2;
                    long j7 = j4;
                    b a2 = new a(bVar2.b).a((-i3) - 1).a(j2).b(m).e(m).c(j3).d(j7).a(bVar2).a();
                    com.ss.android.socialbase.downloader.c.a.b(a, "divide sub chunk : " + i3 + " startOffset:" + j2 + " curOffset:" + m + " endOffset:" + j3 + " contentLen:" + j7);
                    arrayList.add(a2);
                    m += j5;
                    i3++;
                    bVar2 = this;
                    i2 = i;
                    c2 = j6;
                } else {
                    j2 = m;
                }
            }
            j3 = (m + j5) - 1;
            j4 = j5;
            long j62 = c2;
            long j72 = j4;
            b a22 = new a(bVar2.b).a((-i3) - 1).a(j2).b(m).e(m).c(j3).d(j72).a(bVar2).a();
            com.ss.android.socialbase.downloader.c.a.b(a, "divide sub chunk : " + i3 + " startOffset:" + j2 + " curOffset:" + m + " endOffset:" + j3 + " contentLen:" + j72);
            arrayList.add(a22);
            m += j5;
            i3++;
            bVar2 = this;
            i2 = i;
            c2 = j62;
        }
        long j8 = 0;
        for (int size = arrayList.size() - 1; size > 0; size--) {
            b bVar3 = arrayList.get(size);
            if (bVar3 != null) {
                j8 += bVar3.q();
            }
        }
        com.ss.android.socialbase.downloader.c.a.b(a, "reuseChunkContentLen:".concat(String.valueOf(j8)));
        b bVar4 = arrayList.get(0);
        if (bVar4 != null) {
            if (p() == 0) {
                p = j - l();
            } else {
                p = (p() - l()) + 1;
            }
            bVar4.a(p - j8);
            bVar = this;
            bVar4.c(bVar.g);
            com.ss.android.socialbase.downloader.h.b bVar5 = bVar.o;
            if (bVar5 != null) {
                bVar5.a(bVar4.p(), q() - j8);
            }
        } else {
            bVar = this;
        }
        bVar.a(arrayList);
        return arrayList;
    }
}
