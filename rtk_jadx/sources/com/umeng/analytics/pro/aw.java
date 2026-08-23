package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bm;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: TDeserializer.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class aw {
    private final bs a;
    private final cf b;

    public aw() {
        this(new bm.a());
    }

    private bn j(byte[] bArr, ba baVar, ba... baVarArr) {
        this.b.a(bArr);
        int length = baVarArr.length + 1;
        ba[] baVarArr2 = new ba[length];
        int i = 0;
        baVarArr2[0] = baVar;
        int i2 = 0;
        while (i2 < baVarArr.length) {
            int i3 = i2 + 1;
            baVarArr2[i3] = baVarArr[i2];
            i2 = i3;
        }
        this.a.j();
        bn bnVar = null;
        while (i < length) {
            bnVar = this.a.l();
            if (bnVar.b == 0 || bnVar.f1033c > baVarArr2[i].a()) {
                return null;
            }
            if (bnVar.f1033c != baVarArr2[i].a()) {
                bv.a(this.a, bnVar.b);
                this.a.m();
            } else {
                i++;
                if (i < length) {
                    this.a.j();
                }
            }
        }
        return bnVar;
    }

    public void a(at atVar, byte[] bArr) {
        try {
            this.b.a(bArr);
            atVar.read(this.a);
        } finally {
            this.b.e();
            this.a.B();
        }
    }

    public Byte b(byte[] bArr, ba baVar, ba... baVarArr) {
        return (Byte) a((byte) 3, bArr, baVar, baVarArr);
    }

    public Double c(byte[] bArr, ba baVar, ba... baVarArr) {
        return (Double) a((byte) 4, bArr, baVar, baVarArr);
    }

    public Short d(byte[] bArr, ba baVar, ba... baVarArr) {
        return (Short) a((byte) 6, bArr, baVar, baVarArr);
    }

    public Integer e(byte[] bArr, ba baVar, ba... baVarArr) {
        return (Integer) a((byte) 8, bArr, baVar, baVarArr);
    }

    public Long f(byte[] bArr, ba baVar, ba... baVarArr) {
        return (Long) a((byte) 10, bArr, baVar, baVarArr);
    }

    public String g(byte[] bArr, ba baVar, ba... baVarArr) {
        return (String) a((byte) 11, bArr, baVar, baVarArr);
    }

    public ByteBuffer h(byte[] bArr, ba baVar, ba... baVarArr) {
        return (ByteBuffer) a((byte) 100, bArr, baVar, baVarArr);
    }

    public Short i(byte[] bArr, ba baVar, ba... baVarArr) {
        Short sh;
        try {
            try {
                if (j(bArr, baVar, baVarArr) != null) {
                    this.a.j();
                    sh = Short.valueOf(this.a.l().f1033c);
                } else {
                    sh = null;
                }
                return sh;
            } catch (Exception e) {
                throw new az(e);
            }
        } finally {
            this.b.e();
            this.a.B();
        }
    }

    public aw(bu buVar) {
        cf cfVar = new cf();
        this.b = cfVar;
        this.a = buVar.a(cfVar);
    }

    public void a(at atVar, String str, String str2) {
        try {
            try {
                a(atVar, str.getBytes(str2));
            } catch (UnsupportedEncodingException unused) {
                throw new az("JVM DOES NOT SUPPORT ENCODING: " + str2);
            }
        } finally {
            this.a.B();
        }
    }

    public void a(at atVar, byte[] bArr, ba baVar, ba... baVarArr) {
        try {
            try {
                if (j(bArr, baVar, baVarArr) != null) {
                    atVar.read(this.a);
                }
            } catch (Exception e) {
                throw new az(e);
            }
        } finally {
            this.b.e();
            this.a.B();
        }
    }

    public Boolean a(byte[] bArr, ba baVar, ba... baVarArr) {
        return (Boolean) a((byte) 2, bArr, baVar, baVarArr);
    }

    private Object a(byte b, byte[] bArr, ba baVar, ba... baVarArr) {
        Object obj;
        try {
            try {
                bn j = j(bArr, baVar, baVarArr);
                if (j != null) {
                    if (b != 2) {
                        if (b != 3) {
                            if (b != 4) {
                                if (b != 6) {
                                    if (b != 8) {
                                        if (b != 100) {
                                            if (b != 10) {
                                                if (b == 11 && j.b == 11) {
                                                    obj = this.a.z();
                                                }
                                            } else if (j.b == 10) {
                                                obj = Long.valueOf(this.a.x());
                                            }
                                        } else if (j.b == 11) {
                                            obj = this.a.A();
                                        }
                                    } else if (j.b == 8) {
                                        obj = Integer.valueOf(this.a.w());
                                    }
                                } else if (j.b == 6) {
                                    obj = Short.valueOf(this.a.v());
                                }
                            } else if (j.b == 4) {
                                obj = Double.valueOf(this.a.y());
                            }
                        } else if (j.b == 3) {
                            obj = Byte.valueOf(this.a.u());
                        }
                    } else if (j.b == 2) {
                        obj = Boolean.valueOf(this.a.t());
                    }
                    return obj;
                }
                obj = null;
                return obj;
            } catch (Exception e) {
                throw new az(e);
            }
        } finally {
            this.b.e();
            this.a.B();
        }
    }

    public void a(at atVar, String str) {
        a(atVar, str.getBytes());
    }
}
