package com.rtk.app.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home1RecommentPostAdapter$ViewHolder_ViewBinding implements Unbinder {
    private Home1RecommentPostAdapter$ViewHolder b;

    @UiThread
    public Home1RecommentPostAdapter$ViewHolder_ViewBinding(Home1RecommentPostAdapter$ViewHolder home1RecommentPostAdapter$ViewHolder, View view) {
        home1RecommentPostAdapter$ViewHolder.communityFragmentPostlistOnePictrueItemImg = (ImageView) butterknife.c.a.c(view, R.id.community_fragment_postlist_one_pictrue_item_img, "field 'communityFragmentPostlistOnePictrueItemImg'", ImageView.class);
        home1RecommentPostAdapter$ViewHolder.communityFragmentPostlistOnePictrueItemImgNum = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_one_pictrue_item_img_num, "field 'communityFragmentPostlistOnePictrueItemImgNum'", TextView.class);
        home1RecommentPostAdapter$ViewHolder.communityFragmentPostlistOnePictrueItemTitle = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_one_pictrue_item_title, "field 'communityFragmentPostlistOnePictrueItemTitle'", TextView.class);
        home1RecommentPostAdapter$ViewHolder.communityFragmentPostlistOnePictrueItemAuthor = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_one_pictrue_item_author, "field 'communityFragmentPostlistOnePictrueItemAuthor'", TextView.class);
        home1RecommentPostAdapter$ViewHolder.communityFragmentPostlistOnePictrueItemCommentNum = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_one_pictrue_item_comment_num, "field 'communityFragmentPostlistOnePictrueItemCommentNum'", TextView.class);
        home1RecommentPostAdapter$ViewHolder.communityFragmentPostlistOnePictrueItemViewNum = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_one_pictrue_item_viewNum, "field 'communityFragmentPostlistOnePictrueItemViewNum'", TextView.class);
        home1RecommentPostAdapter$ViewHolder.communityFragmentPostlistOnePictrueItemTime = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_one_pictrue_item_time, "field 'communityFragmentPostlistOnePictrueItemTime'", TextView.class);
        home1RecommentPostAdapter$ViewHolder.communityFragmentPostlistOnePictrueItemContent = (TextView) butterknife.c.a.c(view, R.id.community_fragment_postlist_one_pictrue_item_content, "field 'communityFragmentPostlistOnePictrueItemContent'", TextView.class);
    }

    @CallSuper
    public void a() {
        Home1RecommentPostAdapter$ViewHolder home1RecommentPostAdapter$ViewHolder = this.b;
        if (home1RecommentPostAdapter$ViewHolder != null) {
            home1RecommentPostAdapter$ViewHolder.communityFragmentPostlistOnePictrueItemImg = null;
            home1RecommentPostAdapter$ViewHolder.communityFragmentPostlistOnePictrueItemImgNum = null;
            home1RecommentPostAdapter$ViewHolder.communityFragmentPostlistOnePictrueItemTitle = null;
            home1RecommentPostAdapter$ViewHolder.communityFragmentPostlistOnePictrueItemAuthor = null;
            home1RecommentPostAdapter$ViewHolder.communityFragmentPostlistOnePictrueItemCommentNum = null;
            home1RecommentPostAdapter$ViewHolder.communityFragmentPostlistOnePictrueItemViewNum = null;
            home1RecommentPostAdapter$ViewHolder.communityFragmentPostlistOnePictrueItemTime = null;
            home1RecommentPostAdapter$ViewHolder.communityFragmentPostlistOnePictrueItemContent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
