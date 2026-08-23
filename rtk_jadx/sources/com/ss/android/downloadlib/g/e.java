package com.ss.android.downloadlib.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e {
    @Nullable
    public static JSONObject a() {
        return com.ss.android.downloadlib.addownload.k.j().optJSONObject("ad");
    }

    @NonNull
    public static com.ss.android.socialbase.downloader.g.a b(DownloadModel downloadModel) {
        return com.ss.android.socialbase.downloader.g.a.a(a(downloadModel));
    }

    public static int c(@NonNull DownloadModel downloadModel) {
        return a(b(downloadModel));
    }

    public static boolean d(int i) {
        return com.ss.android.socialbase.downloader.g.a.a(i).a("clean_fetch_apk_switch", 0L) == 1;
    }

    public static boolean e(int i) {
        return com.ss.android.socialbase.downloader.g.a.a(i).a("clean_space_before_download_switch", 0L) == 1;
    }

    public static boolean f(int i) {
        return com.ss.android.socialbase.downloader.g.a.a(i).a("clean_space_switch", 0) == 1;
    }

    public static boolean g(int i) {
        return com.ss.android.socialbase.downloader.g.a.a(i).a("clean_app_cache_dir", 0) == 1;
    }

    public static JSONObject a(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return null;
        }
        return downloadModel.isAd() ? m.a(com.ss.android.downloadlib.addownload.k.j(), downloadModel.getDownloadSettings()) : downloadModel.getDownloadSettings();
    }

    public static boolean b(com.ss.android.downloadad.api.a.a aVar) {
        return a(aVar).a("pause_reserve_on_wifi", 0) == 1 && aVar.q();
    }

    public static long d() {
        long optLong = com.ss.android.downloadlib.addownload.k.j().optLong("start_install_interval");
        if (optLong == 0) {
            return 300000L;
        }
        return optLong;
    }

    public static long e() {
        long optLong = com.ss.android.downloadlib.addownload.k.j().optLong("next_install_min_interval");
        if (optLong == 0) {
            return 10000L;
        }
        return optLong;
    }

    public static int f(com.ss.android.downloadad.api.a.b bVar) {
        return a((com.ss.android.downloadad.api.a.a) bVar).a("app_install_keep_receiver_time_s", 60);
    }

    public static long g(com.ss.android.downloadad.api.a.b bVar) {
        return a((com.ss.android.downloadad.api.a.a) bVar).a("ttdownloader_app_install_detect_sum_timestamp", AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_SUM_TIMESTAMP);
    }

    public static boolean c(com.ss.android.downloadad.api.a.a aVar) {
        return a(aVar).a("cancel_pause_optimise_wifi_retain_switch", 0) == 1 && aVar.q();
    }

    public static boolean d(com.ss.android.downloadad.api.a.b bVar) {
        return com.ss.android.downloadlib.addownload.k.j().optInt("market_install_finish_opt_broadcast", 0) == 1 || a((com.ss.android.downloadad.api.a.a) bVar).a("market_install_finish_opt_broadcast", 0) == 1;
    }

    public static boolean e(com.ss.android.downloadad.api.a.b bVar) {
        return com.ss.android.downloadlib.addownload.k.j().optInt("market_install_finish_opt_polling_thread", 0) == 1 || a((com.ss.android.downloadad.api.a.a) bVar).a("market_install_finish_opt_polling_thread", 0) == 1;
    }

    public static long b(int i) {
        return com.ss.android.socialbase.downloader.g.a.a(i).a("storage_min_size", 0L);
    }

    @NonNull
    public static com.ss.android.socialbase.downloader.g.a a(com.ss.android.downloadad.api.a.a aVar) {
        if (aVar == null) {
            return com.ss.android.socialbase.downloader.g.a.c();
        }
        if (aVar.s() != 0) {
            return com.ss.android.socialbase.downloader.g.a.a(aVar.s());
        }
        if (aVar.c()) {
            return com.ss.android.socialbase.downloader.g.a.a(a());
        }
        if (aVar.r() != null) {
            return com.ss.android.socialbase.downloader.g.a.a(aVar.r());
        }
        return com.ss.android.socialbase.downloader.g.a.c();
    }

    public static boolean b(com.ss.android.socialbase.downloader.g.a aVar) {
        return aVar != null && aVar.a("kllk_need_rename_apk", 0) == 1;
    }

    public static long c(int i) {
        return com.ss.android.socialbase.downloader.g.a.a(i).a("clean_fetch_apk_head_time_out", 800L);
    }

    public static boolean b() {
        return com.ss.android.socialbase.downloader.g.a.c().a("fix_notification_anr");
    }

    public static boolean c() {
        return com.ss.android.downloadlib.addownload.k.j().optInt("is_enable_start_install_again") == 1;
    }

    public static int b(com.ss.android.downloadad.api.a.b bVar) {
        return a((com.ss.android.downloadad.api.a.a) bVar).a("ttdownloader_app_install_detect_interval_ms", AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS);
    }

    public static boolean c(com.ss.android.downloadad.api.a.b bVar) {
        return com.ss.android.downloadlib.addownload.k.j().optInt("market_install_finish_opt_switch", 0) == 1 || a((com.ss.android.downloadad.api.a.a) bVar).a("market_install_finish_opt_switch", 0) == 1;
    }

    public static int a(@NonNull com.ss.android.socialbase.downloader.g.a aVar) {
        return aVar.a("external_storage_permission_path_type", 0);
    }

    public static double a(int i) {
        return com.ss.android.socialbase.downloader.g.a.a(i).a("clean_min_install_size", 0.0d);
    }

    public static int a(com.ss.android.downloadad.api.a.b bVar) {
        return a((com.ss.android.downloadad.api.a.a) bVar).a("ttdownloader_app_install_detect_count", 15);
    }
}
