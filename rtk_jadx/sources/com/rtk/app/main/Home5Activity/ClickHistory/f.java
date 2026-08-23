package com.rtk.app.main.Home5Activity.ClickHistory;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.bean.ListHisGameBean;
import com.rtk.app.bean.ListHisPostBean;
import com.rtk.app.bean.ListHisUpBean;
import com.rtk.app.bean.ListHisUserBean;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.v;

/* compiled from: HisClickUtils.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f {
    private static Gson a = new GsonBuilder().enableComplexMapKeySerialization().create();

    public static void a(Context context, ListHisGameBean.HisGameBean hisGameBean) {
        hisGameBean.setClickTime(System.currentTimeMillis());
        ListHisGameBean listHisGameBean = (ListHisGameBean) a.fromJson(v.d(context, "GAME_HISTORY"), ListHisGameBean.class);
        ListHisGameBean listHisGameBean2 = new ListHisGameBean();
        listHisGameBean2.getListBean().add(hisGameBean);
        if (listHisGameBean != null && listHisGameBean.getListBean() != null && listHisGameBean.getListBean().size() != 0) {
            int i = 0;
            while (true) {
                if (i >= listHisGameBean.getListBean().size()) {
                    break;
                }
                if (listHisGameBean.getListBean().get(i).getApkInfo().getUpGameId() == hisGameBean.getApkInfo().getGameId()) {
                    listHisGameBean.getListBean().remove(i);
                    break;
                }
                i++;
            }
            listHisGameBean2.getListBean().addAll(listHisGameBean.getListBean());
        }
        while (listHisGameBean2.getListBean().size() > 300) {
            listHisGameBean2.getListBean().remove(listHisGameBean2.getListBean().size() - 1);
        }
        v.h(context, "GAME_HISTORY", a.toJson(listHisGameBean2, ListHisGameBean.class));
    }

    public static void b(Context context, ListHisPostBean.HisPostBean hisPostBean) {
        hisPostBean.setClickTime(System.currentTimeMillis());
        ListHisPostBean listHisPostBean = (ListHisPostBean) a.fromJson(v.d(context, "POST_HISTORY"), ListHisPostBean.class);
        ListHisPostBean listHisPostBean2 = new ListHisPostBean();
        listHisPostBean2.getListBean().add(hisPostBean);
        if (listHisPostBean != null && listHisPostBean.getListBean() != null && listHisPostBean.getListBean().size() != 0) {
            int i = 0;
            while (true) {
                if (i >= listHisPostBean.getListBean().size()) {
                    break;
                }
                if (listHisPostBean.getListBean().get(i).getPostId().equals(hisPostBean.getPostId())) {
                    listHisPostBean.getListBean().remove(i);
                    break;
                }
                i++;
            }
            listHisPostBean2.getListBean().addAll(listHisPostBean.getListBean());
        }
        while (listHisPostBean2.getListBean().size() > 300) {
            listHisPostBean2.getListBean().remove(listHisPostBean2.getListBean().size() - 1);
        }
        v.h(context, "POST_HISTORY", a.toJson(listHisPostBean2, ListHisPostBean.class));
    }

    public static void c(Context context, ApkInfo apkInfo) {
        apkInfo.setClickTime(System.currentTimeMillis());
        ListHisUpBean listHisUpBean = (ListHisUpBean) a.fromJson(v.d(context, "UP_HISTORY"), ListHisUpBean.class);
        ListHisUpBean listHisUpBean2 = new ListHisUpBean();
        listHisUpBean2.getUpBeanList().add(apkInfo);
        if (listHisUpBean != null && listHisUpBean.getUpBeanList() != null && listHisUpBean.getUpBeanList().size() != 0) {
            int i = 0;
            while (true) {
                if (i >= listHisUpBean.getUpBeanList().size()) {
                    break;
                }
                if (listHisUpBean.getUpBeanList().get(i).getUpGameId() == apkInfo.getUpGameId()) {
                    listHisUpBean.getUpBeanList().remove(i);
                    break;
                }
                i++;
            }
            listHisUpBean2.getUpBeanList().addAll(listHisUpBean.getUpBeanList());
        }
        while (listHisUpBean2.getUpBeanList().size() > 300) {
            listHisUpBean2.getUpBeanList().remove(listHisUpBean2.getUpBeanList().size() - 1);
        }
        v.h(context, "UP_HISTORY", a.toJson(listHisUpBean2, ListHisUpBean.class));
    }

    public static void d(Context context, ListHisUserBean.HisUserBean hisUserBean) {
        hisUserBean.setClickTime(System.currentTimeMillis());
        ListHisUserBean listHisUserBean = (ListHisUserBean) a.fromJson(v.d(context, "USER_HISTORY"), ListHisUserBean.class);
        ListHisUserBean listHisUserBean2 = new ListHisUserBean();
        listHisUserBean2.getListBean().add(hisUserBean);
        if (listHisUserBean != null && listHisUserBean.getListBean() != null && listHisUserBean.getListBean().size() != 0) {
            int i = 0;
            while (true) {
                if (i >= listHisUserBean.getListBean().size()) {
                    break;
                }
                if (listHisUserBean.getListBean().get(i).getUid().equals(hisUserBean.getUid())) {
                    listHisUserBean.getListBean().remove(i);
                    break;
                }
                i++;
            }
            listHisUserBean2.getListBean().addAll(listHisUserBean.getListBean());
        }
        while (listHisUserBean2.getListBean().size() > 300) {
            listHisUserBean2.getListBean().remove(listHisUserBean2.getListBean().size() - 1);
        }
        v.h(context, "USER_HISTORY", a.toJson(listHisUserBean2, ListHisUserBean.class));
    }

    public static void e(Context context) {
        v.h(context, "GAME_HISTORY", "");
    }

    public static void f(Context context) {
        v.h(context, "POST_HISTORY", "");
    }

    public static void g(Context context) {
        v.h(context, "UP_HISTORY", "");
    }

    public static void h(Context context) {
        v.h(context, "USER_HISTORY", "");
    }

    public static void i(Context context, ListHisGameBean.HisGameBean hisGameBean) {
        hisGameBean.setClickTime(System.currentTimeMillis());
        ListHisGameBean listHisGameBean = (ListHisGameBean) a.fromJson(v.d(context, "GAME_HISTORY"), ListHisGameBean.class);
        ListHisGameBean listHisGameBean2 = new ListHisGameBean();
        if (listHisGameBean != null && listHisGameBean.getListBean() != null && listHisGameBean.getListBean().size() != 0) {
            int i = 0;
            while (true) {
                if (i >= listHisGameBean.getListBean().size()) {
                    break;
                }
                if (listHisGameBean.getListBean().get(i).getApkInfo().getUpGameId() == hisGameBean.getApkInfo().getGameId()) {
                    listHisGameBean.getListBean().remove(i);
                    break;
                }
                i++;
            }
            listHisGameBean2.getListBean().addAll(listHisGameBean.getListBean());
        }
        v.h(context, "GAME_HISTORY", a.toJson(listHisGameBean2, ListHisGameBean.class));
    }

    public static void j(Context context, ListHisPostBean.HisPostBean hisPostBean) {
        hisPostBean.setClickTime(System.currentTimeMillis());
        ListHisPostBean listHisPostBean = (ListHisPostBean) a.fromJson(v.d(context, "POST_HISTORY"), ListHisPostBean.class);
        ListHisPostBean listHisPostBean2 = new ListHisPostBean();
        if (listHisPostBean != null && listHisPostBean.getListBean() != null && listHisPostBean.getListBean().size() != 0) {
            int i = 0;
            while (true) {
                if (i >= listHisPostBean.getListBean().size()) {
                    break;
                }
                if (listHisPostBean.getListBean().get(i).getPostId().equals(hisPostBean.getPostId())) {
                    listHisPostBean.getListBean().remove(i);
                    break;
                }
                i++;
            }
            listHisPostBean2.getListBean().addAll(listHisPostBean.getListBean());
        }
        v.h(context, "POST_HISTORY", a.toJson(listHisPostBean2, ListHisPostBean.class));
    }

    public static void k(Context context, ApkInfo apkInfo) {
        apkInfo.setClickTime(System.currentTimeMillis());
        ListHisUpBean listHisUpBean = (ListHisUpBean) a.fromJson(v.d(context, "UP_HISTORY"), ListHisUpBean.class);
        ListHisUpBean listHisUpBean2 = new ListHisUpBean();
        if (listHisUpBean != null && listHisUpBean.getUpBeanList() != null && listHisUpBean.getUpBeanList().size() != 0) {
            int i = 0;
            while (true) {
                if (i >= listHisUpBean.getUpBeanList().size()) {
                    break;
                }
                if (listHisUpBean.getUpBeanList().get(i).getUpGameId() == apkInfo.getUpGameId()) {
                    listHisUpBean.getUpBeanList().remove(i);
                    break;
                }
                i++;
            }
            listHisUpBean2.getUpBeanList().addAll(listHisUpBean.getUpBeanList());
        }
        v.h(context, "UP_HISTORY", a.toJson(listHisUpBean2, ListHisUpBean.class));
    }

    public static void l(Context context, ListHisUserBean.HisUserBean hisUserBean) {
        hisUserBean.setClickTime(System.currentTimeMillis());
        ListHisUserBean listHisUserBean = (ListHisUserBean) a.fromJson(v.d(context, "USER_HISTORY"), ListHisUserBean.class);
        ListHisUserBean listHisUserBean2 = new ListHisUserBean();
        if (listHisUserBean != null && listHisUserBean.getListBean() != null && listHisUserBean.getListBean().size() != 0) {
            int i = 0;
            while (true) {
                if (i >= listHisUserBean.getListBean().size()) {
                    break;
                }
                if (listHisUserBean.getListBean().get(i).getUid().equals(hisUserBean.getUid())) {
                    listHisUserBean.getListBean().remove(i);
                    break;
                }
                i++;
            }
            listHisUserBean2.getListBean().addAll(listHisUserBean.getListBean());
        }
        v.h(context, "USER_HISTORY", a.toJson(listHisUserBean2, ListHisUserBean.class));
    }

    public static ListHisGameBean m(Context context) {
        String d = v.d(context, "GAME_HISTORY");
        if (d == null) {
            c0.t("HisClickUtils", "saveUserHisStr is null.");
            return null;
        }
        try {
            return (ListHisGameBean) a.fromJson(d, ListHisGameBean.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public static ListHisPostBean n(Context context) {
        String d = v.d(context, "POST_HISTORY");
        if (d == null) {
            c0.t("HisClickUtils", "saveUserHisStr is null.");
            return null;
        }
        return (ListHisPostBean) a.fromJson(d, ListHisPostBean.class);
    }

    public static ListHisUpBean o(Context context) {
        String d = v.d(context, "UP_HISTORY");
        if (d == null) {
            return null;
        }
        try {
            return (ListHisUpBean) a.fromJson(d, ListHisUpBean.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public static ListHisUserBean p(Context context) {
        String d = v.d(context, "USER_HISTORY");
        if (d == null) {
            c0.t("HisClickUtils", "saveUserHisStr is null.");
            return null;
        }
        return (ListHisUserBean) a.fromJson(d, ListHisUserBean.class);
    }

    public static void q(Context context, ListHisGameBean.HisGameBean hisGameBean) {
        ListHisGameBean listHisGameBean = (ListHisGameBean) a.fromJson(v.d(context, "GAME_HISTORY"), ListHisGameBean.class);
        ListHisGameBean listHisGameBean2 = new ListHisGameBean();
        listHisGameBean2.getListBean().add(hisGameBean);
        if (listHisGameBean != null && listHisGameBean.getListBean() != null && listHisGameBean.getListBean().size() != 0) {
            int i = 0;
            while (true) {
                if (i >= listHisGameBean.getListBean().size()) {
                    break;
                }
                if (listHisGameBean.getListBean().get(i).getApkInfo().getGameId() == hisGameBean.getApkInfo().getGameId()) {
                    c0.t("HisClickUtils", "remove gameId:" + hisGameBean.getApkInfo().getGameId());
                    listHisGameBean.getListBean().remove(i);
                    break;
                }
                i++;
            }
            listHisGameBean2.getListBean().addAll(listHisGameBean.getListBean());
            v.h(context, "GAME_HISTORY", a.toJson(listHisGameBean2, ListHisGameBean.class));
            return;
        }
        c0.t("HisClickUtils", "历史为空");
    }

    public static void r(Context context, ListHisPostBean.HisPostBean hisPostBean) {
        ListHisPostBean listHisPostBean = (ListHisPostBean) a.fromJson(v.d(context, "POST_HISTORY"), ListHisPostBean.class);
        ListHisPostBean listHisPostBean2 = new ListHisPostBean();
        listHisPostBean2.getListBean().add(hisPostBean);
        if (listHisPostBean != null && listHisPostBean.getListBean() != null && listHisPostBean.getListBean().size() != 0) {
            int i = 0;
            while (true) {
                if (i >= listHisPostBean.getListBean().size()) {
                    break;
                }
                if (listHisPostBean.getListBean().get(i).getPostId().equals(hisPostBean.getPostId())) {
                    c0.t("HisClickUtils", "remove postId:" + hisPostBean.getPostId());
                    listHisPostBean.getListBean().remove(i);
                    break;
                }
                i++;
            }
            listHisPostBean2.getListBean().addAll(listHisPostBean.getListBean());
            v.h(context, "POST_HISTORY", a.toJson(listHisPostBean2, ListHisPostBean.class));
            return;
        }
        c0.t("HisClickUtils", "历史为空");
    }

    public static void s(Context context, ApkInfo apkInfo) {
        ListHisUpBean listHisUpBean = (ListHisUpBean) a.fromJson(v.d(context, "UP_HISTORY"), ListHisUpBean.class);
        ListHisUpBean listHisUpBean2 = new ListHisUpBean();
        listHisUpBean2.getUpBeanList().add(apkInfo);
        if (listHisUpBean != null && listHisUpBean.getUpBeanList() != null && listHisUpBean.getUpBeanList().size() != 0) {
            int i = 0;
            while (true) {
                if (i >= listHisUpBean.getUpBeanList().size()) {
                    break;
                }
                if (listHisUpBean.getUpBeanList().get(i).getUpGameId() == apkInfo.getUpGameId()) {
                    c0.t("HisClickUtils", "remove game:" + apkInfo.getUpGameId());
                    listHisUpBean.getUpBeanList().remove(i);
                    break;
                }
                i++;
            }
            listHisUpBean2.getUpBeanList().addAll(listHisUpBean.getUpBeanList());
            v.h(context, "UP_HISTORY", a.toJson(listHisUpBean2, ListHisUpBean.class));
            return;
        }
        c0.t("HisClickUtils", "历史为空");
    }

    public static void t(Context context, ListHisUserBean.HisUserBean hisUserBean) {
        ListHisUserBean listHisUserBean = (ListHisUserBean) a.fromJson(v.d(context, "USER_HISTORY"), ListHisUserBean.class);
        ListHisUserBean listHisUserBean2 = new ListHisUserBean();
        listHisUserBean2.getListBean().add(hisUserBean);
        if (listHisUserBean != null && listHisUserBean.getListBean() != null && listHisUserBean.getListBean().size() != 0) {
            int i = 0;
            while (true) {
                if (i >= listHisUserBean.getListBean().size()) {
                    break;
                }
                if (listHisUserBean.getListBean().get(i).getUid().equals(hisUserBean.getUid())) {
                    c0.t("HisClickUtils", "remove uid:" + hisUserBean.getUid());
                    listHisUserBean.getListBean().remove(i);
                    break;
                }
                i++;
            }
            listHisUserBean2.getListBean().addAll(listHisUserBean.getListBean());
            v.h(context, "USER_HISTORY", a.toJson(listHisUserBean2, ListHisUserBean.class));
            return;
        }
        c0.t("HisClickUtils", "历史为空");
    }
}
