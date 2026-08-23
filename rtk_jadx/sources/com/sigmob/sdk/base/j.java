package com.sigmob.sdk.base;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.czhj.sdk.common.Database.SQLiteBuider;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.y;
import com.sigmob.sdk.base.db.a;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmobRequest;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.WindAds;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class j {

    /* renamed from: c, reason: collision with root package name */
    private static HashMap<String, e> f405c = new HashMap<>();
    protected WindAdRequest a;
    private e b;
    private boolean e;
    private String f;
    private int h;
    public AdStatus mADStatus = AdStatus.AdStatusNone;
    public int pIdEmpty_filters = 0;
    public int init_filters = 0;
    public int loadCount = 0;
    private int d = 0;
    private int g = 0;
    private String i = WindAds.CNY;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(WindAdRequest windAdRequest, boolean z) {
        this.a = windAdRequest;
        windAdRequest.setHalfInterstitial(z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0031, code lost:
    
        if (r1.isClosed() == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.sigmob.sdk.base.e a(java.lang.String r6) {
        /*
            r5 = this;
            com.sigmob.sdk.base.e r0 = new com.sigmob.sdk.base.e
            r0.<init>()
            r1 = 0
            com.sigmob.sdk.base.db.a r2 = com.sigmob.sdk.base.db.a.a()     // Catch: java.lang.Throwable -> L34
            android.database.sqlite.SQLiteDatabase r2 = r2.getReadableDatabase()     // Catch: java.lang.Throwable -> L34
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L34
            r3.<init>()     // Catch: java.lang.Throwable -> L34
            java.lang.String r4 = "select error_code, count(*) as num from adload_event where adslot_id = '"
            r3.append(r4)     // Catch: java.lang.Throwable -> L34
            r3.append(r6)     // Catch: java.lang.Throwable -> L34
            java.lang.String r6 = "' group by adslot_id"
            r3.append(r6)     // Catch: java.lang.Throwable -> L34
            java.lang.String r6 = r3.toString()     // Catch: java.lang.Throwable -> L34
            android.database.Cursor r1 = r2.rawQuery(r6, r1)     // Catch: java.lang.Throwable -> L34
            r5.a(r0, r1)     // Catch: java.lang.Throwable -> L34
            if (r1 == 0) goto L47
            boolean r6 = r1.isClosed()
            if (r6 != 0) goto L47
            goto L44
        L34:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()     // Catch: java.lang.Throwable -> L48
            com.czhj.sdk.logger.SigmobLog.e(r6)     // Catch: java.lang.Throwable -> L48
            if (r1 == 0) goto L47
            boolean r6 = r1.isClosed()
            if (r6 != 0) goto L47
        L44:
            r1.close()
        L47:
            return r0
        L48:
            r6 = move-exception
            if (r1 == 0) goto L54
            boolean r0 = r1.isClosed()
            if (r0 != 0) goto L54
            r1.close()
        L54:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.j.a(java.lang.String):com.sigmob.sdk.base.e");
    }

    private void a(e eVar, Cursor cursor) {
        if (cursor == null || !cursor.moveToFirst()) {
            return;
        }
        int i = cursor.getInt(cursor.getColumnIndexOrThrow("error_code"));
        int i2 = cursor.getInt(cursor.getColumnIndexOrThrow("num"));
        do {
            if (i != 0) {
                eVar.a = i2;
            }
            eVar.b += i2;
            switch (i) {
                case 600200:
                case 600201:
                case 600203:
                case 600204:
                    eVar.g = i2;
                    break;
                case 600900:
                    eVar.e = i2;
                    break;
                case 600905:
                    eVar.f401c = i2;
                    break;
                case 610012:
                    eVar.h = i2;
                    break;
                case 610013:
                    eVar.d = i2;
                    break;
            }
        } while (cursor.moveToNext());
    }

    private void a(final String str, final int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            SQLiteDatabase writableDatabase = com.sigmob.sdk.base.db.a.a().getWritableDatabase();
            SQLiteBuider.Insert.Builder builder = new SQLiteBuider.Insert.Builder();
            builder.setTableName(com.sigmob.sdk.base.db.a.f);
            HashMap hashMap = new HashMap();
            hashMap.put("adslot_id", str);
            hashMap.put("error_code", Integer.valueOf(i));
            hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            builder.setColumnValues(hashMap);
            com.sigmob.sdk.base.db.a.a().a(writableDatabase, builder.build(), new a.InterfaceC0034a() { // from class: com.sigmob.sdk.base.j.1
                @Override // com.sigmob.sdk.base.db.a.InterfaceC0034a
                public void a() {
                    SigmobLog.d(str + " insert  load error event " + i + " onSuccess: ");
                }

                @Override // com.sigmob.sdk.base.db.a.InterfaceC0034a
                public void a(Throwable th) {
                    SigmobLog.e(str + " insert  load error event " + i + " onFailed: ", th);
                }
            });
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    private void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            com.sigmob.sdk.base.db.a.a().getWritableDatabase().delete(com.sigmob.sdk.base.db.a.f, "adslot_id=?", new String[]{str});
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.pIdEmpty_filters = 0;
        b(a());
        this.b.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a() {
        WindAdRequest windAdRequest = this.a;
        if (windAdRequest != null) {
            return windAdRequest.getPlacementId();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final y yVar) {
        ae.a(PointCategory.REQUEST, PointCategory.INIT, this.a, (LoadAdRequest) null, new ae.a() { // from class: com.sigmob.sdk.base.j.2
            @Override // com.sigmob.sdk.base.common.ae.a
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmobRequest) {
                    PointEntitySigmobRequest pointEntitySigmobRequest = (PointEntitySigmobRequest) obj;
                    pointEntitySigmobRequest.setLoad_count(String.valueOf(j.this.b.b));
                    pointEntitySigmobRequest.setInvalid_load_count(String.valueOf(j.this.b.a));
                    pointEntitySigmobRequest.setGdpr_filters(String.valueOf(j.this.b.f401c));
                    pointEntitySigmobRequest.setInterval_filters(String.valueOf(j.this.b.d));
                    pointEntitySigmobRequest.setPldempty_filters(String.valueOf(j.this.pIdEmpty_filters));
                    pointEntitySigmobRequest.setInit_filters(String.valueOf(j.this.b.e));
                    pointEntitySigmobRequest.setLoading_filters(String.valueOf(j.this.b.h));
                    pointEntitySigmobRequest.setProguard_filters(String.valueOf(j.this.b.g));
                    if (!TextUtils.isEmpty(j.this.f)) {
                        pointEntitySigmobRequest.setBid_token(j.this.f);
                    }
                    pointEntitySigmobRequest.setAdx_id(null);
                    HashMap hashMap = new HashMap();
                    hashMap.put("feed_pre_reque st_count", String.valueOf(yVar.a));
                    hashMap.put("feed_pre_ready_count", String.valueOf(yVar.b));
                    hashMap.put("is_minor", f.a().d() ? "0" : "1");
                    hashMap.put("is_unpersonalized", f.a().e() ? "0" : "1");
                    hashMap.put("personalized_filters", String.valueOf(j.this.b.f));
                    pointEntitySigmobRequest.setOptions(hashMap);
                }
                j.this.d();
            }
        });
    }

    protected abstract void a(WindAdError windAdError);

    protected abstract void a(String str, String str2);

    protected void a(boolean z) {
        this.e = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        ae.a(PointCategory.REQUEST, PointCategory.INIT, this.a, (LoadAdRequest) null, new ae.a() { // from class: com.sigmob.sdk.base.j.3
            @Override // com.sigmob.sdk.base.common.ae.a
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmobRequest) {
                    PointEntitySigmobRequest pointEntitySigmobRequest = (PointEntitySigmobRequest) obj;
                    pointEntitySigmobRequest.setLoad_count(String.valueOf(j.this.b.b));
                    pointEntitySigmobRequest.setInvalid_load_count(String.valueOf(j.this.b.a));
                    pointEntitySigmobRequest.setGdpr_filters(String.valueOf(j.this.b.f401c));
                    pointEntitySigmobRequest.setInterval_filters(String.valueOf(j.this.b.d));
                    pointEntitySigmobRequest.setPldempty_filters(String.valueOf(j.this.pIdEmpty_filters));
                    pointEntitySigmobRequest.setInit_filters(String.valueOf(j.this.b.e));
                    pointEntitySigmobRequest.setLoading_filters(String.valueOf(j.this.b.h));
                    pointEntitySigmobRequest.setProguard_filters(String.valueOf(j.this.b.g));
                    if (!TextUtils.isEmpty(j.this.f)) {
                        pointEntitySigmobRequest.setBid_token(j.this.f);
                    }
                    pointEntitySigmobRequest.setAdx_id(null);
                    HashMap hashMap = new HashMap();
                    hashMap.put("is_minor", f.a().d() ? "0" : "1");
                    hashMap.put("is_unpersonalized", f.a().e() ? "0" : "1");
                    hashMap.put("personalized_filters", String.valueOf(j.this.b.f));
                    pointEntitySigmobRequest.setOptions(hashMap);
                }
                j.this.d();
            }
        });
    }

    protected abstract Map<String, BiddingResponse> c();

    public int getBidFloor() {
        return this.h;
    }

    public String getBid_token() {
        return this.f;
    }

    public String getCurrency() {
        return this.i;
    }

    public abstract String getEcpm();

    public boolean loadAd() {
        this.e = false;
        this.f = null;
        return false;
    }

    public boolean loadAd(String str) {
        this.e = true;
        this.f = str;
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean loadAdFilter() {
        /*
            Method dump skipped, instructions count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.j.loadAdFilter():boolean");
    }

    public void sendLossNotificationWithInfo(Map<String, Object> map) {
        Set<String> keySet;
        String str;
        try {
            if (c() == null || (keySet = c().keySet()) == null || keySet.size() <= 0) {
                return;
            }
            for (String str2 : keySet) {
                BiddingResponse biddingResponse = c().get(str2);
                if (biddingResponse != null) {
                    String str3 = biddingResponse.lose_url;
                    if (!TextUtils.isEmpty(str3)) {
                        if (map != null && map.size() > 0) {
                            if (map.get(WindAds.AUCTION_PRICE) != null) {
                                a(SigMacroCommon._PUBLISHERPRICE_, String.valueOf(map.get(WindAds.AUCTION_PRICE)));
                                str3 = str3.replace("__AUCTION_PRICE__", String.valueOf(map.get(WindAds.AUCTION_PRICE)));
                            }
                            if (map.get(WindAds.CURRENCY) != null) {
                                a(SigMacroCommon._CURRENCY_, String.valueOf(map.get(WindAds.CURRENCY)));
                                str = String.valueOf(map.get(WindAds.CURRENCY));
                            } else {
                                a(SigMacroCommon._CURRENCY_, this.i);
                                str = this.i;
                            }
                            str3 = str3.replace("__CURRENCY__", str);
                            if (map.get(WindAds.LOSS_REASON) != null) {
                                str3 = str3.replace("_BIDLOSSCODE_", String.valueOf(map.get(WindAds.LOSS_REASON)));
                            }
                            if (map.get(WindAds.ADN_ID) != null) {
                                str3 = str3.replace("_WINADNID_", String.valueOf(map.get(WindAds.ADN_ID)));
                            }
                        }
                        com.sigmob.sdk.base.network.b.a(str3, PointCategory.LOSE, this.a, str2);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendWinNotificationWithInfo(Map<String, Object> map) {
        Set<String> keySet;
        String str;
        try {
            if (c() == null || (keySet = c().keySet()) == null || keySet.size() <= 0) {
                return;
            }
            for (String str2 : keySet) {
                BiddingResponse biddingResponse = c().get(str2);
                if (biddingResponse != null) {
                    String str3 = biddingResponse.win_url;
                    if (!TextUtils.isEmpty(str3)) {
                        if (map != null && map.size() > 0) {
                            if (map.get(WindAds.AUCTION_PRICE) != null) {
                                a(SigMacroCommon._PUBLISHERPRICE_, String.valueOf(map.get(WindAds.AUCTION_PRICE)));
                                str3 = str3.replace("__AUCTION_PRICE__", String.valueOf(map.get(WindAds.AUCTION_PRICE)));
                            }
                            if (map.get(WindAds.HIGHEST_LOSS_PRICE) != null) {
                                a(SigMacroCommon._HIGHESTLOSSPRICE_, String.valueOf(map.get(WindAds.HIGHEST_LOSS_PRICE)));
                                str3 = str3.replace("__HIGHEST_LOSS_PRICE__", String.valueOf(map.get(WindAds.HIGHEST_LOSS_PRICE)));
                            }
                            if (map.get(WindAds.CURRENCY) != null) {
                                a(SigMacroCommon._CURRENCY_, String.valueOf(map.get(WindAds.CURRENCY)));
                                str = String.valueOf(map.get(WindAds.CURRENCY));
                            } else {
                                a(SigMacroCommon._CURRENCY_, this.i);
                                str = this.i;
                            }
                            str3 = str3.replace("__CURRENCY__", str);
                        }
                        com.sigmob.sdk.base.network.b.a(str3, PointCategory.WIN, this.a, str2);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBidEcpm(int i) {
        a(SigMacroCommon._PUBLISHERPRICE_, String.valueOf(i));
    }

    public void setBidFloor(int i) {
        this.h = i;
    }

    public void setCurrency(String str) {
        this.i = str;
    }
}
