package com.rtk.app.main.MainActivityPack.HomePageItem1Pack;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.GridViewForScrollView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TypeModuleHolder_ViewBinding implements Unbinder {
    private TypeModuleHolder b;

    @UiThread
    public TypeModuleHolder_ViewBinding(TypeModuleHolder typeModuleHolder, View view) {
        this.b = typeModuleHolder;
        typeModuleHolder.homePageItem1FragmentTypeModuleItemGridView = (GridViewForScrollView) butterknife.c.a.c(view, R.id.home_page_item1_fragment_type_module_item_GridView, "field 'homePageItem1FragmentTypeModuleItemGridView'", GridViewForScrollView.class);
    }

    @CallSuper
    public void a() {
        TypeModuleHolder typeModuleHolder = this.b;
        if (typeModuleHolder != null) {
            this.b = null;
            typeModuleHolder.homePageItem1FragmentTypeModuleItemGridView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
