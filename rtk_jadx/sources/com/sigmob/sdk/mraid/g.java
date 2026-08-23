package com.sigmob.sdk.mraid;

import com.sigmob.sdk.base.models.PlacementType;
import com.sigmob.sdk.base.mta.PointCategory;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public enum g {
    CLOSE(PointCategory.CLOSE),
    EXPAND("expand") { // from class: com.sigmob.sdk.mraid.g.1
        @Override // com.sigmob.sdk.mraid.g
        boolean a(PlacementType placementType) {
            return placementType == PlacementType.INLINE;
        }
    },
    USE_CUSTOM_CLOSE("usecustomclose"),
    OPEN("open") { // from class: com.sigmob.sdk.mraid.g.2
        @Override // com.sigmob.sdk.mraid.g
        boolean a(PlacementType placementType) {
            return true;
        }
    },
    feedBack("feedback") { // from class: com.sigmob.sdk.mraid.g.3
        @Override // com.sigmob.sdk.mraid.g
        boolean a(PlacementType placementType) {
            return true;
        }
    },
    UNLOAD("unload"),
    OPENFOURELEMENTS("openFourElements"),
    RESIZE("resize") { // from class: com.sigmob.sdk.mraid.g.4
        @Override // com.sigmob.sdk.mraid.g
        boolean a(PlacementType placementType) {
            return true;
        }
    },
    SET_ORIENTATION_PROPERTIES("setOrientationProperties"),
    PLAY_VIDEO("playVideo") { // from class: com.sigmob.sdk.mraid.g.5
        @Override // com.sigmob.sdk.mraid.g
        boolean a(PlacementType placementType) {
            return placementType == PlacementType.INLINE;
        }
    },
    STORE_PICTURE("storePicture") { // from class: com.sigmob.sdk.mraid.g.6
        @Override // com.sigmob.sdk.mraid.g
        boolean a(PlacementType placementType) {
            return true;
        }
    },
    CREATE_CALENDAR_EVENT("createCalendarEvent") { // from class: com.sigmob.sdk.mraid.g.7
        @Override // com.sigmob.sdk.mraid.g
        boolean a(PlacementType placementType) {
            return true;
        }
    },
    VPAID("vpaid") { // from class: com.sigmob.sdk.mraid.g.8
        @Override // com.sigmob.sdk.mraid.g
        boolean a(PlacementType placementType) {
            return true;
        }
    },
    EXTENSION("extension") { // from class: com.sigmob.sdk.mraid.g.9
        @Override // com.sigmob.sdk.mraid.g
        boolean a(PlacementType placementType) {
            return true;
        }
    },
    UNSPECIFIED("");

    private final String p;

    g(String str) {
        this.p = str;
    }

    public static g a(String str) {
        for (g gVar : values()) {
            if (gVar.p.equals(str)) {
                return gVar;
            }
        }
        return UNSPECIFIED;
    }

    public String a() {
        return this.p;
    }

    boolean a(PlacementType placementType) {
        return false;
    }
}
