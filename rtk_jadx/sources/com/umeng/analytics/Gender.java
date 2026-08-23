package com.umeng.analytics;

import java.util.Locale;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'Male' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Gender {
    public static final Gender Female;
    public static final Gender Male;
    public static final Gender Unknown;
    private static final /* synthetic */ Gender[] a;
    public int value;

    /* renamed from: com.umeng.analytics.Gender$4, reason: invalid class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Gender.values().length];
            a = iArr;
            try {
                iArr[Gender.Male.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Gender.Female.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Gender.Unknown.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        int i = 0;
        int i2 = 1;
        Gender gender = new Gender("Male", i, i2) { // from class: com.umeng.analytics.Gender.1
            @Override // java.lang.Enum
            public String toString() {
                return String.format(Locale.US, "Male:%d", Integer.valueOf(this.value));
            }
        };
        Male = gender;
        int i3 = 2;
        Gender gender2 = new Gender("Female", i2, i3) { // from class: com.umeng.analytics.Gender.2
            @Override // java.lang.Enum
            public String toString() {
                return String.format(Locale.US, "Female:%d", Integer.valueOf(this.value));
            }
        };
        Female = gender2;
        Gender gender3 = new Gender("Unknown", i3, i) { // from class: com.umeng.analytics.Gender.3
            @Override // java.lang.Enum
            public String toString() {
                return String.format(Locale.US, "Unknown:%d", Integer.valueOf(this.value));
            }
        };
        Unknown = gender3;
        a = new Gender[]{gender, gender2, gender3};
    }

    public static Gender getGender(int i) {
        if (i == 1) {
            return Male;
        }
        if (i != 2) {
            return Unknown;
        }
        return Female;
    }

    public static com.umeng.commonsdk.statistics.proto.Gender transGender(Gender gender) {
        int i = AnonymousClass4.a[gender.ordinal()];
        if (i == 1) {
            return com.umeng.commonsdk.statistics.proto.Gender.MALE;
        }
        if (i != 2) {
            return com.umeng.commonsdk.statistics.proto.Gender.UNKNOWN;
        }
        return com.umeng.commonsdk.statistics.proto.Gender.FEMALE;
    }

    public static Gender valueOf(String str) {
        return (Gender) Enum.valueOf(Gender.class, str);
    }

    public static Gender[] values() {
        return (Gender[]) a.clone();
    }

    public int value() {
        return this.value;
    }

    private Gender(String str, int i, int i2) {
        this.value = i2;
    }
}
