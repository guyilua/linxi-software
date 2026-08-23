package com.rtk.app.main.OtherImfomationPack;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PersonalPhotoListAdapter$ViewHolder_ViewBinding implements Unbinder {
    private PersonalPhotoListAdapter$ViewHolder b;

    @UiThread
    public PersonalPhotoListAdapter$ViewHolder_ViewBinding(PersonalPhotoListAdapter$ViewHolder personalPhotoListAdapter$ViewHolder, View view) {
        personalPhotoListAdapter$ViewHolder.personalPhotoListItemImg = (ImageView) butterknife.c.a.c(view, R.id.personal_photo_list_item_img, "field 'personalPhotoListItemImg'", ImageView.class);
    }

    @CallSuper
    public void a() {
        PersonalPhotoListAdapter$ViewHolder personalPhotoListAdapter$ViewHolder = this.b;
        if (personalPhotoListAdapter$ViewHolder != null) {
            personalPhotoListAdapter$ViewHolder.personalPhotoListItemImg = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
