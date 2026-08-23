package com.sigmob.sdk.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.common.utils.ImageTypeUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.views.gif.e;
import com.sigmob.windad.WindAds;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e extends d {
    private com.sigmob.sdk.base.views.gif.e b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f642c;
    private float d;
    private boolean e;

    public e(Context context) {
        super(context);
        this.e = false;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.b = new com.sigmob.sdk.base.views.gif.e(context);
        setBackgroundColor(-1);
        addView(this.b, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Bitmap bitmap) {
        WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.splash.e.3
            @Override // java.lang.Runnable
            public void run() {
                if (bitmap == null || e.this.f642c != null) {
                    return;
                }
                com.sigmob.sdk.base.blurkit.a.a(e.this.getContext());
                e.this.f642c = new ImageView(e.this.getContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                e.this.f642c.setScaleType(ImageView.ScaleType.CENTER_CROP);
                e.this.f642c.setImageBitmap(com.sigmob.sdk.base.blurkit.a.a().a(bitmap, 25, 1.0f));
                e eVar = e.this;
                eVar.addView(eVar.f642c, 0, layoutParams);
            }
        });
    }

    @Override // com.sigmob.sdk.splash.d
    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.sigmob.sdk.splash.d
    public boolean a(BaseAdUnit baseAdUnit) {
        Bitmap decodeFile;
        if (baseAdUnit == null || baseAdUnit.getSplashFilePath() == null) {
            SigmobLog.e("adUnit or splashFilePath is null");
            return false;
        }
        String splashFilePath = baseAdUnit.getSplashFilePath();
        List asList = Arrays.asList("git", "jpeg", "jpg", "png", "bmp", "webp", "tif");
        String fileType = ImageTypeUtil.getFileType(splashFilePath);
        if (TextUtils.isEmpty(fileType)) {
            return false;
        }
        if (fileType.equals("gif")) {
            this.b.setBytes(FileUtil.readBytes(splashFilePath));
            this.b.setOnFrameAvailable(new e.c() { // from class: com.sigmob.sdk.splash.e.1
                @Override // com.sigmob.sdk.base.views.gif.e.c
                public Bitmap a(Bitmap bitmap) {
                    if (!e.this.e) {
                        e.this.e = true;
                        int width = bitmap.getWidth();
                        int height = bitmap.getHeight();
                        if (height > 0 && width > 0) {
                            if ((width * 1.0d) / height < e.this.d) {
                                WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.splash.e.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        e.this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                    }
                                });
                            } else {
                                e.this.a(bitmap);
                            }
                        }
                    }
                    return bitmap;
                }
            });
            this.b.d();
        } else {
            if (!asList.contains(fileType) || (decodeFile = BitmapFactory.decodeFile(splashFilePath)) == null) {
                return false;
            }
            this.b.setImageBitmap(decodeFile);
            int width = decodeFile.getWidth();
            int height = decodeFile.getHeight();
            if (height > 0 && width > 0) {
                if ((width * 1.0d) / height < this.d) {
                    WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.splash.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        }
                    });
                } else {
                    a(decodeFile);
                }
            }
        }
        BaseBroadcastReceiver.a(getContext(), baseAdUnit.getUuid(), IntentActions.ACTION_INTERSTITIAL_SHOW);
        return true;
    }

    @Override // com.sigmob.sdk.splash.d
    public void b() {
        super.b();
        com.sigmob.sdk.base.views.gif.e eVar = this.b;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // com.sigmob.sdk.splash.d
    public void c() {
        super.c();
        com.sigmob.sdk.base.views.gif.e eVar = this.b;
        if (eVar != null) {
            eVar.d();
        }
    }

    @Override // com.sigmob.sdk.splash.d
    public /* bridge */ /* synthetic */ int getDuration() {
        return super.getDuration();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.sigmob.sdk.base.views.gif.e eVar = this.b;
        if (eVar != null) {
            eVar.clearAnimation();
        }
        if (this.f642c != null) {
            this.f642c = null;
        }
        removeAllViews();
    }

    @Override // com.sigmob.sdk.splash.d
    public void setAspectRatio(float f) {
        this.d = f;
    }
}
