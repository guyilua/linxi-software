package com.sigmob.sdk.base.services;

import android.annotation.SuppressLint;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.services.j;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e implements j.a {
    private static LocationManager b;
    private k d = k.STOP;
    private static final LocationListener a = new LocationListener() { // from class: com.sigmob.sdk.base.services.e.1
        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (ClientMetadata.getInstance() == null) {
                return;
            }
            ClientMetadata.getInstance().setLocation(location);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private static String f428c = PointCategory.NETWORK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e() {
        LocationManager a2;
        if (ClientMetadata.getInstance() == null || (a2 = a()) == null) {
            return;
        }
        Criteria criteria = new Criteria();
        criteria.setAccuracy(2);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(false);
        criteria.setPowerRequirement(1);
        f428c = a2.getBestProvider(criteria, false);
    }

    static LocationManager a() {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = ClientMetadata.getInstance().getLocationManager();
                }
            }
        }
        return b;
    }

    @SuppressLint({"MissingPermission"})
    private void b() {
        try {
            LocationManager locationManager = b;
            if (locationManager != null) {
                locationManager.removeUpdates(a);
            }
            b = null;
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    @SuppressLint({"MissingPermission"})
    private void c() {
        String str;
        try {
            LocationManager a2 = a();
            if (a2 == null || (str = f428c) == null || !a2.isProviderEnabled(str)) {
                return;
            }
            SigmobLog.d("private :use_location ");
            a2.requestLocationUpdates(f428c, 10000L, 10.0f, a);
            this.d = k.RUNNING;
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public boolean e() {
        if (this.d == k.RUNNING) {
            return false;
        }
        c();
        return true;
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public k f() {
        return this.d;
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public void g() {
        if (this.d == k.RUNNING) {
            b();
            this.d = k.STOP;
        }
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public Error h() {
        return null;
    }
}
