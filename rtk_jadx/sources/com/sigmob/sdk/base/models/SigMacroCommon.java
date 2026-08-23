package com.sigmob.sdk.base.models;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.track.BaseMacroCommon;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.TouchLocation;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.b;
import java.util.Random;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SigMacroCommon extends BaseMacroCommon {
    public static final String _ADSCENEID_ = "_ADSCENEID_";
    public static final String _ADSCENE_ = "_ADSCENE_";
    public static final String _BEGINTIME_ = "_BEGINTIME_";
    public static final String _BEHAVIOR_ = "_BEHAVIOR_";
    public static final String _CLICKAREA_ = "_CLICKAREA_";
    public static final String _CLICKID_ = "_CLICKID_";
    public static final String _CLICKSCENE_ = "_CLICKSCENE_";
    public static final String _COMPLETED_ = "_COMPLETED_";
    public static final String _CURRENCY_ = "_CURRENCY_";
    private static final String _DOWNTS_ = "_DOWNTS_";
    public static final String _DOWNX_ = "_DOWNX_";
    public static final String _DOWNY_ = "_DOWNY_";
    public static final String _ENDTIME_ = "_ENDTIME_";
    public static final String _FINALCLICK_ = "_FINALCLICK_";
    public static final String _HEIGHT_ = "_HEIGHT_";
    public static final String _HIGHESTLOSSPRICE_ = "_HIGHESTLOSSPRICE_";
    public static final String _IS_TRUNCATION_ = "_ISTRUNCATION_";
    public static final String _PLAYFIRSTFRAME_ = "_PLAYFIRSTFRAME_";
    public static final String _PLAYLASTFRAME_ = "_PLAYLASTFRAME_";
    public static final String _PROGRESS_ = "_PROGRESS_";
    public static final String _PUBLISHERPRICE_ = "_PUBLISHERPRICE_";
    public static final String _SCENE_ = "_SCENE_";
    public static final String _SETCLOSETIME_ = "_SETCLOSETIME_";
    public static final String _SHOWSKIPTIME_ = "_SHOWSKIPTIME_";
    public static final String _SLD_ = "_SLD_";
    public static final String _SLOTHEIGHT_ = "_SLOTHEIGHT_";
    public static final String _SLOTWIDTH_ = "_SLOTWIDTH_";
    public static final String _STATUS_ = "_STATUS_";
    public static final String _TEMPLATE_ = "_TEMPLATE_";
    public static final String _TYPE_ = "_TYPE_";
    private static final String _UPTS_ = "_UPTS_";
    public static final String _UPX_ = "_UPX_";
    public static final String _UPY_ = "_UPY_";
    public static final String _VIDEOTIME_ = "_VIDEOTIME_";
    public static final String _VMD5_ = "_VMD5_";
    public static final String _VURL_ = "_VURL_";
    public static final String _WIDTH_ = "_WIDTH_";
    private static final long serialVersionUID = 1;
    private static long initialUptimeMillis = SystemClock.uptimeMillis();
    private static long initialCurrentTimeMillis = System.currentTimeMillis();

    public static long convertUptimeMillisToCurrentTimeMillis(long j) {
        return initialCurrentTimeMillis + (j - initialUptimeMillis);
    }

    public static String getCoordinate(MotionEvent motionEvent, MotionEvent motionEvent2, boolean z) {
        return z ? String.format("%d,%d,%d,%d", Integer.valueOf(Dips.pixelsToIntDips(motionEvent.getRawX(), b.e())), Integer.valueOf(Dips.pixelsToIntDips(motionEvent.getRawY(), b.e())), Integer.valueOf(Dips.pixelsToIntDips(motionEvent2.getRawX(), b.e())), Integer.valueOf(Dips.pixelsToIntDips(motionEvent2.getRawX(), b.e()))) : String.format("%d,%d,%d,%d", Integer.valueOf(Dips.pixelsToIntDips(motionEvent.getX(), b.e())), Integer.valueOf(Dips.pixelsToIntDips(motionEvent.getY(), b.e())), Integer.valueOf(Dips.pixelsToIntDips(motionEvent2.getX(), b.e())), Integer.valueOf(Dips.pixelsToIntDips(motionEvent2.getY(), b.e())));
    }

    private static String getMacroValue(String str) {
        char c2 = 65535;
        try {
            switch (str.hashCode()) {
                case -1590308376:
                    if (str.equals(_BEGINTIME_)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1494891674:
                    if (str.equals(_TYPE_)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -662306149:
                    if (str.equals(_SLOTHEIGHT_)) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -415971623:
                    if (str.equals(_HEIGHT_)) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case 853731986:
                    if (str.equals(_SCENE_)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 891331278:
                    if (str.equals(_BEHAVIOR_)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 973765784:
                    if (str.equals(_WIDTH_)) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1179083118:
                    if (str.equals(_STATUS_)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 2074198166:
                    if (str.equals(_SLOTWIDTH_)) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
        } catch (Throwable unused) {
        }
        switch (c2) {
            case 0:
                return "1";
            case 1:
            case 2:
                return "0";
            case 3:
                return "2";
            case 4:
                return "0";
            case 5:
            case 6:
                return String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealWidthDip());
            case 7:
            case '\b':
                return String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealHeightDip());
            default:
                return "unFind";
        }
    }

    public String getCoordinate() {
        return String.format("%s,%s,%s,%s", getMarcoKey(_DOWNX_), getMarcoKey(_DOWNY_), getMarcoKey(_UPX_), getMarcoKey(_UPY_));
    }

    public String replaceWithDefault(String str) {
        String replaceWithDefault = super.replaceWithDefault(str);
        SigmobLog.d("macroProcess() called with:[" + str + "][" + replaceWithDefault + "]");
        if (!TextUtils.isEmpty(replaceWithDefault) && !replaceWithDefault.equals("unFind")) {
            return replaceWithDefault;
        }
        try {
            String macroValue = getMacroValue(str);
            SigmobLog.d("macroProcess() called with: [" + str + "][" + macroValue + "]");
            if (TextUtils.isEmpty(macroValue)) {
                return null;
            }
            if (macroValue.equals("unFind")) {
                return null;
            }
            return macroValue;
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return null;
        }
    }

    public void updateClickMarco(MotionEvent motionEvent, MotionEvent motionEvent2, boolean z) {
        int i;
        float y;
        if (motionEvent == null) {
            i = new Random().nextInt(50);
            motionEvent = motionEvent2;
        } else {
            i = 0;
        }
        if (z) {
            addMarcoKey(_DOWNX_, String.valueOf(Dips.pixelsToIntDips(motionEvent.getRawX(), b.e())));
            addMarcoKey(_DOWNY_, String.valueOf(Dips.pixelsToIntDips(motionEvent.getRawY(), b.e())));
            addMarcoKey(_UPX_, String.valueOf(Dips.pixelsToIntDips(motionEvent2.getRawX(), b.e())));
            y = motionEvent2.getRawY();
        } else {
            addMarcoKey(_DOWNX_, String.valueOf(Dips.pixelsToIntDips(motionEvent.getX(), b.e())));
            addMarcoKey(_DOWNY_, String.valueOf(Dips.pixelsToIntDips(motionEvent.getY(), b.e())));
            addMarcoKey(_UPX_, String.valueOf(Dips.pixelsToIntDips(motionEvent2.getX(), b.e())));
            y = motionEvent2.getY();
        }
        addMarcoKey(_UPY_, String.valueOf(Dips.pixelsToIntDips(y, b.e())));
        addMarcoKey(_UPTS_, String.valueOf(convertUptimeMillisToCurrentTimeMillis(motionEvent2.getEventTime() + i)));
        addMarcoKey(_DOWNTS_, String.valueOf(convertUptimeMillisToCurrentTimeMillis(motionEvent.getEventTime())));
        addMarcoKey(_SLD_, "0");
    }

    public void updateClickMarco(TouchLocation touchLocation, TouchLocation touchLocation2) {
        if (touchLocation == null && touchLocation2 == null) {
            return;
        }
        if (touchLocation2 == null) {
            touchLocation2 = touchLocation;
        } else if (touchLocation == null) {
            touchLocation = touchLocation2;
        }
        updateClickMarco(String.valueOf(Dips.pixelsToIntDips(touchLocation.getX(), b.e())), String.valueOf(Dips.pixelsToIntDips(touchLocation.getY(), b.e())), String.valueOf(Dips.pixelsToIntDips(touchLocation2.getX(), b.e())), String.valueOf(Dips.pixelsToIntDips(touchLocation2.getY(), b.e())));
        addMarcoKey(_SLD_, "0");
    }

    public void updateClickMarco(String str, String str2, String str3, String str4) {
        Random random = new Random();
        addMarcoKey(_DOWNX_, str);
        addMarcoKey(_DOWNY_, str2);
        addMarcoKey(_UPX_, str3);
        addMarcoKey(_UPY_, str4);
        if (str.equals("-999")) {
            return;
        }
        addMarcoKey(_DOWNTS_, String.valueOf(System.currentTimeMillis()));
        addMarcoKey(_UPTS_, String.valueOf(System.currentTimeMillis() + random.nextInt(50)));
    }
}
