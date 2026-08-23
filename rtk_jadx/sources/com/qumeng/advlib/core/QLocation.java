package com.qumeng.advlib.core;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class QLocation implements IQLocation {
    private double lat;
    private double lot;
    private int type;

    public QLocation() {
        this.lat = 0.0d;
        this.lot = 0.0d;
        this.type = 0;
    }

    @Override // com.qumeng.advlib.core.IQLocation
    public double getLatitude() {
        return this.lat;
    }

    @Override // com.qumeng.advlib.core.IQLocation
    public double getLongitude() {
        return this.lot;
    }

    @Override // com.qumeng.advlib.core.IQLocation
    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public QLocation(double d, double d2, int i) {
        this.lat = 0.0d;
        this.lot = 0.0d;
        this.type = 0;
        this.lat = d;
        this.lot = d2;
        this.type = i;
    }
}
