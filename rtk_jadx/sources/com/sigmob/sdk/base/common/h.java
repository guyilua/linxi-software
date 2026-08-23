package com.sigmob.sdk.base.common;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.models.AdCache;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.VolleyError;
import com.czhj.volley.toolbox.DownloadItem;
import com.czhj.volley.toolbox.FileDownloadRequest;
import com.czhj.volley.toolbox.FileDownloader;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.AdPrivacy;
import com.sigmob.sdk.base.models.rtb.BidResponse;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.models.rtb.ResponseAsset;
import com.sigmob.sdk.base.models.rtb.ResponseAssetVideo;
import com.sigmob.sdk.base.models.rtb.Template;
import com.sigmob.sdk.videocache.h;
import com.sigmob.windad.WindAdError;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class h {
    private static com.sigmob.sdk.videocache.h h;
    private static volatile ImageManager j;
    private static BaseAdUnit k;
    private static BaseAdUnit l;
    private static ab n;
    private String r;
    private String s;
    private String w;
    private String x;
    private static final Integer b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static final Integer f383c = 1;
    private static final Integer d = 2;
    private static final Integer e = 3;
    private static h f = null;
    private static Map<String, BaseAdUnit> g = new HashMap();
    private static HashMap<String, Integer> i = new HashMap<>();
    private static HashMap<String, List<BaseAdUnit>> m = new HashMap<>();
    private static HashMap<String, BidResponse> p = new HashMap<>();
    private static HashMap<String, Integer> t = new HashMap<>();
    private static Map<String, List<BaseAdUnit>> B = new HashMap();
    private Map<String, String> o = new HashMap();
    private HashSet<a> q = new HashSet<>();
    final FileDownloadRequest.FileDownloadListener a = new FileDownloadRequest.FileDownloadListener() { // from class: com.sigmob.sdk.base.common.h.1
        public void downloadProgress(DownloadItem downloadItem, long j2, long j3) {
        }

        public void onCancel(DownloadItem downloadItem) {
            h.i.put(Md5Util.md5(downloadItem.url), h.e);
            Iterator it = h.this.q.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                BaseAdUnit a2 = aVar.a();
                if (a2 != null && downloadItem.type == DownloadItem.FileType.FILE && a2.getEndCardZipPath().equals(downloadItem.filePath)) {
                    aVar.b(a2);
                }
            }
        }

        public void onErrorResponse(DownloadItem downloadItem) {
            SigmobLog.e("onErrorResponse: ", downloadItem.error);
            h.i.put(Md5Util.md5(downloadItem.url), h.e);
            Iterator it = h.this.q.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                BaseAdUnit a2 = aVar.a();
                if (a2 != null && a2.getEndCardZipPath().equals(downloadItem.filePath) && downloadItem.type == DownloadItem.FileType.FILE) {
                    aVar.b(a2);
                }
            }
            new c(downloadItem).executeOnExecutor(ThreadPoolFactory.BackgroundThreadPool.getInstance().getExecutorService(), new Object[0]);
        }

        public void onSuccess(DownloadItem downloadItem) {
            h.i.put(Md5Util.md5(downloadItem.url), h.e);
            Iterator it = h.this.q.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                BaseAdUnit a2 = aVar.a();
                if (a2 != null && downloadItem.type == DownloadItem.FileType.FILE && a2.getEndCardZipPath().equals(downloadItem.filePath)) {
                    aVar.a(a2);
                }
            }
            new c(downloadItem).executeOnExecutor(ThreadPoolFactory.BackgroundThreadPool.getInstance().getExecutorService(), new Object[0]);
        }
    };
    private ArrayList<BaseAdUnit> u = new ArrayList<>();
    private HashMap<String, AdCache> v = new HashMap<>();
    private HashMap<String, b> y = new HashMap<>();
    private HashMap<String, AdCache> z = new HashMap<>();
    private Map<String, AdCache> A = new HashMap();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        BaseAdUnit a();

        void a(BaseAdUnit baseAdUnit);

        void b(BaseAdUnit baseAdUnit);
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface b {
        void a(BaseAdUnit baseAdUnit);

        void a(BaseAdUnit baseAdUnit, String str);
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c extends AsyncTask<Object, Void, String> {
        private DownloadItem b;

        c(DownloadItem downloadItem) {
            this.b = null;
            this.b = downloadItem;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(Object... objArr) {
            WindAdError windAdError;
            String message;
            DownloadItem downloadItem = this.b;
            if (downloadItem != null) {
                VolleyError volleyError = downloadItem.error;
                if (volleyError != null) {
                    return volleyError.toString();
                }
                String str = downloadItem.filePath;
                String extensionName = FileUtil.getExtensionName(str);
                String fileMd5 = Md5Util.fileMd5(str);
                if (TextUtils.isEmpty(this.b.md5) || this.b.md5.equalsIgnoreCase(fileMd5)) {
                    if (this.b.type == DownloadItem.FileType.VIDEO) {
                        h.this.o.put(str, fileMd5);
                        this.b.status = 1;
                    } else if (TextUtils.isEmpty(extensionName) || !extensionName.equalsIgnoreCase("tgz")) {
                        DownloadItem downloadItem2 = this.b;
                        if (downloadItem2.type == DownloadItem.FileType.MRAID_VIDEO) {
                            return null;
                        }
                        downloadItem2.status = 0;
                        windAdError = WindAdError.ERROR_SIGMOB_INFORMATION_LOSE;
                    } else {
                        try {
                            com.sigmob.sdk.base.utils.b.a(new File(str), new File(str.replace(".tgz", "/")));
                            this.b.status = 1;
                        } catch (Throwable th) {
                            this.b.status = 0;
                            message = th.getMessage();
                        }
                    }
                    return null;
                }
                this.b.status = 0;
                windAdError = WindAdError.ERROR_SIGMOB_FILE_MD5;
                return windAdError.toString();
            }
            message = "Download Item is null";
            SigmobLog.e(message);
            windAdError = WindAdError.ERROR_SIGMOB_FILE_DOWNLOAD;
            return windAdError.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            DownloadItem downloadItem;
            DownloadItem.FileType fileType;
            super.onPostExecute(str);
            if (!TextUtils.isEmpty(str)) {
                FileUtil.deleteFile(this.b.filePath);
            }
            Iterator it = new CopyOnWriteArrayList(h.this.u).iterator();
            while (it.hasNext()) {
                BaseAdUnit baseAdUnit = (BaseAdUnit) it.next();
                b bVar = (b) h.this.y.get(baseAdUnit.getUuid());
                if (this.b.type == DownloadItem.FileType.VIDEO && baseAdUnit.getVideoPath().equals(this.b.filePath)) {
                    downloadItem = this.b;
                } else {
                    if ((this.b.type != DownloadItem.FileType.FILE || !baseAdUnit.getEndCardZipPath().equals(this.b.filePath)) && (fileType = (downloadItem = this.b).type) != DownloadItem.FileType.ZIP_FILE) {
                        if (fileType == DownloadItem.FileType.MRAID_VIDEO) {
                        }
                    }
                    h.this.a(baseAdUnit, str, bVar);
                }
                ae.a(downloadItem, baseAdUnit, str, false);
                h.this.a(baseAdUnit, str, bVar);
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private class d extends AsyncTask<Object, Void, ArrayList<DownloadItem>> {
        BaseAdUnit a;

        d(BaseAdUnit baseAdUnit) {
            this.a = baseAdUnit;
        }

        private DownloadItem a(Template template) {
            if (!TextUtils.isEmpty(template.context.utf8())) {
                String md5 = Md5Util.md5(template.context.utf8());
                File file = new File(com.sigmob.sdk.base.utils.e.f(com.sigmob.sdk.base.utils.e.f438c), md5 + ".tgz");
                if (!file.exists()) {
                    DownloadItem downloadItem = new DownloadItem();
                    downloadItem.url = template.context.utf8();
                    downloadItem.filePath = file.getAbsolutePath();
                    downloadItem.type = DownloadItem.FileType.ZIP_FILE;
                    return downloadItem;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<DownloadItem> doInBackground(Object... objArr) {
            List<ResponseAsset> list;
            ResponseAssetVideo responseAssetVideo;
            DownloadItem a;
            DownloadItem a2;
            DownloadItem a3;
            String str;
            try {
                ArrayList<DownloadItem> arrayList = new ArrayList<>();
                BaseAdUnit baseAdUnit = this.a;
                if (baseAdUnit != null && baseAdUnit.getMaterial() != null) {
                    MaterialMeta material = this.a.getMaterial();
                    long j = 0;
                    if (!TextUtils.isEmpty(this.a.getVideo_url())) {
                        if (this.a.isVideoExist()) {
                            str = Md5Util.fileMd5(this.a.getVideoPath());
                            if (TextUtils.isEmpty(this.a.getVideo_OriginMD5()) || this.a.getVideo_OriginMD5().equalsIgnoreCase(str)) {
                                h.this.o.put(this.a.getVideoPath(), str);
                                j = new File(this.a.getVideoPath()).length();
                            } else {
                                FileUtil.deleteFile(this.a.getVideoPath());
                            }
                        } else {
                            str = null;
                        }
                        boolean checkVideoValid = this.a.checkVideoValid();
                        DownloadItem downloadItem = new DownloadItem();
                        if (checkVideoValid && this.a.isVideoExist()) {
                            downloadItem.url = this.a.getVideo_url();
                            downloadItem.filePath = this.a.getVideoPath();
                            downloadItem.type = DownloadItem.FileType.VIDEO;
                            downloadItem.md5 = str;
                            downloadItem.size = j;
                            downloadItem.status = 1;
                            ae.a(downloadItem, this.a, (String) null, true);
                        } else if (this.a.getPlayMode() != 2) {
                            downloadItem.url = this.a.getVideo_url();
                            downloadItem.filePath = this.a.getVideoPath();
                            downloadItem.type = DownloadItem.FileType.VIDEO;
                            downloadItem.md5 = this.a.getVideo_OriginMD5();
                            h.this.a(downloadItem, this.a);
                            arrayList.add(downloadItem);
                        }
                    }
                    if (material.creative_type.intValue() == m.CreativeTypeVideo_Tar.a()) {
                        DownloadItem downloadItem2 = new DownloadItem();
                        downloadItem2.url = this.a.getEndcard_url();
                        downloadItem2.filePath = this.a.getEndCardZipPath();
                        downloadItem2.type = DownloadItem.FileType.FILE;
                        downloadItem2.md5 = this.a.getEndCard_OriginMD5();
                        arrayList.add(downloadItem2);
                    }
                    Template template = this.a.scene;
                    if (template != null && template.type.intValue() == 3 && (a3 = a(this.a.scene)) != null) {
                        arrayList.add(a3);
                    }
                    Template template2 = material.main_template;
                    if (template2 != null && template2.type.intValue() == 3 && (a2 = a(material.main_template)) != null) {
                        arrayList.add(a2);
                    }
                    Template template3 = material.sub_template;
                    if (template3 != null && template3.type.intValue() == 3 && (a = a(material.sub_template)) != null) {
                        arrayList.add(a);
                    }
                    if (this.a.isCatchVideo() && (list = material.asset) != null && list.size() > 0) {
                        for (int i = 0; i < material.asset.size(); i++) {
                            ResponseAsset responseAsset = material.asset.get(i);
                            if (responseAsset != null && (responseAssetVideo = responseAsset.video) != null && !TextUtils.isEmpty(responseAssetVideo.url)) {
                                File c2 = h.d().c(responseAsset.video.url);
                                if (!c2.exists()) {
                                    DownloadItem downloadItem3 = new DownloadItem();
                                    downloadItem3.url = responseAsset.video.url;
                                    downloadItem3.filePath = c2.getAbsolutePath();
                                    downloadItem3.type = DownloadItem.FileType.MRAID_VIDEO;
                                    h.this.a(downloadItem3, this.a);
                                    arrayList.add(downloadItem3);
                                }
                            }
                        }
                    }
                    SigmobLog.d("cache() adUnit = [" + this.a.getCrid() + "] videoUrl = [" + this.a.getVideo_url() + "] endcardUrl = [" + this.a.getEndcard_url() + "]");
                    return arrayList;
                }
                return null;
            } catch (Throwable th) {
                SigmobLog.e("AdUnitCheckCacheTask error: " + th.getMessage());
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(ArrayList<DownloadItem> arrayList) {
            boolean z;
            AdPrivacy adPrivacy;
            super.onPostExecute(arrayList);
            BaseAdUnit baseAdUnit = this.a;
            if (baseAdUnit == null) {
                return;
            }
            MaterialMeta material = baseAdUnit.getMaterial();
            b bVar = (b) h.this.y.get(this.a.getUuid());
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (arrayList.size() == 0) {
                if (bVar != null) {
                    bVar.a(this.a, null);
                }
                h.this.g(this.a);
            } else {
                FileDownloader a = r.a();
                Iterator it = h.this.u.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((BaseAdUnit) it.next()).getUuid().equals(this.a.getUuid())) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z && bVar != null) {
                    h.this.u.add(this.a);
                }
                Iterator<DownloadItem> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    DownloadItem next = it2.next();
                    String md5 = Md5Util.md5(next.url);
                    SigmobLog.d("downloader add  item " + next.url);
                    if (next.type != DownloadItem.FileType.VIDEO && (h.i.get(md5) == null || ((Integer) h.i.get(md5)).equals(h.e))) {
                        h.i.put(md5, h.f383c);
                        a.add(next, h.this.a);
                    }
                }
            }
            if (material == null || (adPrivacy = material.ad_privacy) == null) {
                return;
            }
            String str = adPrivacy.privacy_template_url;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String md52 = Md5Util.md5(str);
            File d = com.sigmob.sdk.base.utils.e.d(com.sigmob.sdk.base.utils.e.b);
            File a2 = com.sigmob.sdk.base.utils.e.a(d, md52 + ".html");
            if (a2 == null || a2.exists()) {
                SigmobLog.i("privacy_template_url:" + md52 + " is exists");
                return;
            }
            try {
                if (d.exists() && d.isDirectory()) {
                    for (File file : d.listFiles()) {
                        if (file.exists() && file.isFile() && file.delete()) {
                            SigmobLog.d("删除单个文件" + file.getAbsolutePath() + "成功！");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            DownloadItem downloadItem = new DownloadItem();
            downloadItem.url = str;
            downloadItem.filePath = a2.getAbsolutePath();
            downloadItem.type = DownloadItem.FileType.OTHER;
            arrayList.add(downloadItem);
            r.a().add(downloadItem, new FileDownloadRequest.FileDownloadListener() { // from class: com.sigmob.sdk.base.common.h.d.1
                public void downloadProgress(DownloadItem downloadItem2, long j, long j2) {
                }

                public void onCancel(DownloadItem downloadItem2) {
                    SigmobLog.i("onPostExecute onCancel:" + downloadItem2.url);
                }

                public void onErrorResponse(DownloadItem downloadItem2) {
                    SigmobLog.i("onPostExecute onErrorResponse:" + downloadItem2.url);
                }

                public void onSuccess(DownloadItem downloadItem2) {
                    SigmobLog.i("onPostExecute onSuccess:" + downloadItem2.url);
                }
            });
        }
    }

    private h() {
    }

    public static synchronized ImageManager a() {
        ImageManager imageManager;
        synchronized (h.class) {
            if (j == null) {
                File file = new File(com.sigmob.sdk.base.utils.e.f());
                synchronized (ImageManager.class) {
                    if (j == null) {
                        j = new ImageManager(com.sigmob.sdk.b.e()).customCachePath(file);
                    }
                }
            }
            imageManager = j;
        }
        return imageManager;
    }

    public static BidResponse a(String str) {
        return p.get(str);
    }

    public static List<BaseAdUnit> a(String str, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        List<BaseAdUnit> d2 = d(str);
        if (d2 != null) {
            Iterator it = new CopyOnWriteArrayList(d2).iterator();
            while (it.hasNext()) {
                BaseAdUnit baseAdUnit = (BaseAdUnit) it.next();
                int bidEcpm = baseAdUnit.getBidEcpm();
                if (bidEcpm == 0) {
                    bidEcpm = baseAdUnit.getBP();
                }
                if (bidEcpm >= i2 || i2 == 0) {
                    arrayList.add(baseAdUnit);
                    d2.remove(baseAdUnit);
                }
                if (baseAdUnit.bidding_response != null || arrayList.size() >= i3) {
                    break;
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final DownloadItem downloadItem, BaseAdUnit baseAdUnit) {
        if (h != null) {
            String str = downloadItem.url;
            if (TextUtils.isEmpty(str) || h.b(str)) {
                return;
            }
            String a2 = h.a(str);
            final long currentTimeMillis = System.currentTimeMillis();
            h.a(new com.sigmob.sdk.videocache.d() { // from class: com.sigmob.sdk.base.common.h.3
                @Override // com.sigmob.sdk.videocache.d
                public void a(File file, String str2, int i2) {
                    SigmobLog.d(file + " onCacheAvailable " + i2);
                    if (i2 != 100 || file == null || file.getAbsolutePath().endsWith("download")) {
                        return;
                    }
                    h.h.a(this);
                    downloadItem.networkMs = System.currentTimeMillis() - currentTimeMillis;
                    new c(downloadItem).executeOnExecutor(ThreadPoolFactory.BackgroundThreadPool.getInstance().getExecutorService(), new Object[0]);
                }

                @Override // com.sigmob.sdk.videocache.d
                public void a(String str2, Throwable th) {
                    h.h.a(this);
                    downloadItem.error = new VolleyError(WindAdError.ERROR_SIGMOB_VIDEO_FILE.getMessage());
                    downloadItem.networkMs = System.currentTimeMillis() - currentTimeMillis;
                    new c(downloadItem).executeOnExecutor(ThreadPoolFactory.BackgroundThreadPool.getInstance().getExecutorService(), new Object[0]);
                    SigmobLog.e(str2 + " onCacheUnavailable ", th);
                }
            }, str);
            com.sigmob.sdk.videocache.x.a(com.sigmob.sdk.b.e()).a(a2);
        }
    }

    public static void a(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null || TextUtils.isEmpty(baseAdUnit.getUuid())) {
            return;
        }
        g.put(baseAdUnit.getUuid(), baseAdUnit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:
    
        if (r3 != null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.sigmob.sdk.base.models.BaseAdUnit r1, java.lang.String r2, com.sigmob.sdk.base.common.h.b r3) {
        /*
            r0 = this;
            if (r2 != 0) goto L14
            boolean r2 = r1.isVideoExist()
            if (r2 == 0) goto L13
            boolean r2 = r1.isEndCardIndexExist()
            if (r2 != 0) goto Lf
            goto L13
        Lf:
            if (r3 == 0) goto L19
            r2 = 0
            goto L16
        L13:
            return
        L14:
            if (r3 == 0) goto L19
        L16:
            r3.a(r1, r2)
        L19:
            r0.g(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.common.h.a(com.sigmob.sdk.base.models.BaseAdUnit, java.lang.String, com.sigmob.sdk.base.common.h$b):void");
    }

    public static void a(String str, BidResponse bidResponse) {
        if (TextUtils.isEmpty(str) || bidResponse == null) {
            return;
        }
        p.put(str, bidResponse);
    }

    public static void a(String str, List<BaseAdUnit> list, int i2) {
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
            return;
        }
        List<BaseAdUnit> d2 = d(str);
        if (d2 != null && !d2.isEmpty() && i2 != 0) {
            d2.addAll(list);
            list = d2;
        }
        Collections.sort(list, new Comparator<BaseAdUnit>() { // from class: com.sigmob.sdk.base.common.h.2
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(BaseAdUnit baseAdUnit, BaseAdUnit baseAdUnit2) {
                return -Integer.compare(baseAdUnit.getBidEcpm() > 0 ? baseAdUnit.getBidEcpm() : baseAdUnit.getBP(), baseAdUnit2.getBidEcpm() > 0 ? baseAdUnit2.getBidEcpm() : baseAdUnit2.getBP());
            }
        });
        if (i2 <= 0) {
            m.remove(str);
            return;
        }
        if (list.size() > i2) {
            list = new LinkedList(list.subList(0, i2));
        }
        m.put(str, list);
    }

    public static void a(List<BaseAdUnit> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        B.put(list.get(0).getUuid(), list);
    }

    public static File[] a(File[] fileArr, long j2, long j3) {
        if (fileArr == null || fileArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(fileArr));
        for (File file : fileArr) {
            long j4 = j2 - j3;
            if (file.exists() && j4 > file.lastModified()) {
                file.delete();
                arrayList.remove(file);
                SigmobLog.d("file delete " + file.getName());
            }
        }
        return (File[]) arrayList.toArray(new File[0]);
    }

    public static void b() {
        try {
            FileUtil.deleteDirectory(com.sigmob.sdk.base.utils.e.d(com.sigmob.sdk.base.utils.e.a).getAbsolutePath());
            t();
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    public static void b(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null || TextUtils.isEmpty(baseAdUnit.getUuid())) {
            return;
        }
        g.remove(baseAdUnit.getUuid());
        B.remove(baseAdUnit.getUuid());
    }

    private void b(final BaseAdUnit baseAdUnit, final b bVar) {
        if (baseAdUnit != null) {
            File adPrivacyTemplateFile = baseAdUnit.getAdPrivacyTemplateFile();
            if (adPrivacyTemplateFile != null && !adPrivacyTemplateFile.exists()) {
                DownloadItem downloadItem = new DownloadItem();
                downloadItem.url = baseAdUnit.getadPrivacy().privacy_template_url;
                downloadItem.filePath = adPrivacyTemplateFile.getAbsolutePath();
                downloadItem.type = DownloadItem.FileType.OTHER;
                FileDownloader a2 = r.a();
                if (a2 != null) {
                    a2.add(downloadItem, new FileDownloadRequest.FileDownloadListener() { // from class: com.sigmob.sdk.base.common.h.4
                        public void downloadProgress(DownloadItem downloadItem2, long j2, long j3) {
                        }

                        public void onCancel(DownloadItem downloadItem2) {
                        }

                        public void onErrorResponse(DownloadItem downloadItem2) {
                        }

                        public void onSuccess(DownloadItem downloadItem2) {
                        }
                    });
                }
            }
            File file = new File(baseAdUnit.getSplashFilePath());
            if (file.exists()) {
                file.setLastModified(System.currentTimeMillis());
                if (bVar != null) {
                    bVar.a(baseAdUnit, null);
                    return;
                }
                return;
            }
            FileDownloader a3 = r.a();
            DownloadItem downloadItem2 = new DownloadItem();
            downloadItem2.filePath = baseAdUnit.getSplashFilePath();
            downloadItem2.url = baseAdUnit.getSplashURL();
            downloadItem2.type = DownloadItem.FileType.OTHER;
            downloadItem2.userRange = false;
            a3.add(downloadItem2, new FileDownloadRequest.FileDownloadListener() { // from class: com.sigmob.sdk.base.common.h.5
                public void downloadProgress(DownloadItem downloadItem3, long j2, long j3) {
                }

                public void onCancel(DownloadItem downloadItem3) {
                }

                public void onErrorResponse(DownloadItem downloadItem3) {
                    String message = downloadItem3.error.getMessage();
                    if (downloadItem3.error.networkResponse != null) {
                        message = message + " status code " + downloadItem3.error.networkResponse.statusCode;
                    }
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a(baseAdUnit, message);
                    }
                    SigmobLog.e("onErrorResponse: " + message);
                }

                public void onSuccess(DownloadItem downloadItem3) {
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a(baseAdUnit, null);
                    }
                }
            });
        }
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        p.remove(str);
    }

    public static BaseAdUnit c(String str) {
        return g.get(str);
    }

    public static void c() {
        try {
            for (File file : FileUtil.orderByDate(com.sigmob.sdk.base.utils.e.c())) {
                long currentTimeMillis = System.currentTimeMillis() - ((com.sigmob.sdk.base.l.a().ab() * 3600) * 1000);
                if (file.exists() && currentTimeMillis > file.lastModified()) {
                    if (file.isFile()) {
                        if (!FileUtil.deleteFile(file.getAbsolutePath())) {
                            return;
                        }
                    } else if (file.isDirectory() && !FileUtil.deleteDirectory(file.getAbsolutePath())) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void c(BaseAdUnit baseAdUnit) {
        k = baseAdUnit;
    }

    public static synchronized com.sigmob.sdk.videocache.h d() {
        com.sigmob.sdk.videocache.h hVar;
        synchronized (h.class) {
            if (h == null) {
                e();
            }
            hVar = h;
        }
        return hVar;
    }

    public static List<BaseAdUnit> d(String str) {
        List<BaseAdUnit> list;
        if (TextUtils.isEmpty(str) || (list = m.get(str)) == null || list.isEmpty()) {
            return null;
        }
        Iterator it = new CopyOnWriteArrayList(list).iterator();
        while (it.hasNext()) {
            BaseAdUnit baseAdUnit = (BaseAdUnit) it.next();
            if (baseAdUnit.isExpiredAd()) {
                list.remove(baseAdUnit);
            }
        }
        return list;
    }

    public static void d(BaseAdUnit baseAdUnit) {
        l = baseAdUnit;
    }

    public static List<BaseAdUnit> e(String str) {
        return B.get(str);
    }

    public static synchronized void e() {
        synchronized (h.class) {
            h.a aVar = new h.a(com.sigmob.sdk.b.e());
            try {
                aVar.a(new File(com.sigmob.sdk.base.utils.e.b()));
            } catch (Throwable th) {
                SigmobLog.e("initHttpProxyCacheServer fail ", th);
            }
            h = aVar.a();
        }
    }

    public static BaseAdUnit f() {
        return k;
    }

    public static void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Integer num = t.get(str);
        if (num != null) {
            t.put(str, Integer.valueOf(num.intValue() + 1));
        } else {
            t.put(str, 1);
        }
    }

    public static synchronized h g() {
        h hVar;
        synchronized (h.class) {
            if (f == null) {
                f = new h();
            }
            hVar = f;
        }
        return hVar;
    }

    public static void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        t.remove(str);
    }

    public static Integer h(String str) {
        if (TextUtils.isEmpty(str) || !t.containsKey(str)) {
            return 1;
        }
        return t.get(str);
    }

    public static void h() {
        String str;
        try {
            File[] clearCacheFileByCount = FileUtil.clearCacheFileByCount(a(FileUtil.orderByDate(com.sigmob.sdk.base.utils.e.e()), System.currentTimeMillis(), com.sigmob.sdk.base.l.a().w()), com.sigmob.sdk.base.l.a().v());
            if (clearCacheFileByCount == null) {
                str = "splash ad file list is null";
            } else {
                str = "splash ad file remain num: " + clearCacheFileByCount.length;
            }
            SigmobLog.i(str);
        } catch (Throwable th) {
            SigmobLog.e("clean splash ad file error", th);
        }
    }

    public static void i() {
        String str;
        try {
            File[] clearCacheFileByCount = FileUtil.clearCacheFileByCount(FileUtil.orderByDate(com.sigmob.sdk.base.utils.e.b()), com.sigmob.sdk.base.l.a().s() + com.sigmob.sdk.base.l.a().x());
            if (clearCacheFileByCount == null) {
                str = "splash ad file list is null";
            } else {
                str = "splash ad file remain num: " + clearCacheFileByCount.length;
            }
            SigmobLog.i(str);
        } catch (Throwable th) {
            SigmobLog.e("clean splash ad file error", th);
        }
    }

    public static void j() {
        String str;
        try {
            File[] clearCacheFileByCount = FileUtil.clearCacheFileByCount(FileUtil.orderByDate(com.sigmob.sdk.base.utils.e.f()), com.sigmob.sdk.base.l.a().x());
            if (clearCacheFileByCount == null) {
                str = "native ad file list is null";
            } else {
                str = "native ad file remain num: " + clearCacheFileByCount.length;
            }
            SigmobLog.i(str);
        } catch (Throwable th) {
            SigmobLog.e("clean native ad file error", th);
        }
    }

    public static void k() {
        try {
            File[] orderByDate = FileUtil.orderByDate(com.sigmob.sdk.base.utils.e.a(com.sigmob.sdk.b.e()).getAbsolutePath());
            if (orderByDate == null || orderByDate.length <= 0) {
                return;
            }
            for (File file : orderByDate) {
                if (System.currentTimeMillis() - file.lastModified() > 604800000) {
                    SigmobLog.i("Download APK files timeOut seven day and delete:" + file.getName() + ":" + file.delete());
                }
            }
        } catch (Throwable th) {
            SigmobLog.e("clean Download APK file error", th);
        }
    }

    private String l(String str) {
        File c2;
        if (TextUtils.isEmpty(str) || (c2 = d().c(str)) == null || !c2.exists()) {
            return null;
        }
        return c2.getAbsolutePath();
    }

    public static void l() {
        try {
            File[] orderByDate = FileUtil.orderByDate(com.sigmob.sdk.base.utils.e.a());
            ArrayList arrayList = new ArrayList(Arrays.asList(orderByDate));
            for (File file : orderByDate) {
                if (!file.getPath().endsWith(".mp4") && !file.getPath().endsWith(".mp4.tmp") && !file.getPath().endsWith(".tgz") && !file.getPath().endsWith(".html")) {
                    arrayList.remove(file);
                }
            }
            File[] clearCacheFileByCount = FileUtil.clearCacheFileByCount((File[]) arrayList.toArray(new File[0]), 5);
            SigmobLog.i(clearCacheFileByCount == null ? "splash ad file list is null" : "splash ad file remain num: " + clearCacheFileByCount.length);
        } catch (Throwable th) {
            SigmobLog.e("clean splash ad file error", th);
        }
    }

    public static BaseAdUnit m() {
        return l;
    }

    private static void t() {
        try {
            for (File file : FileUtil.orderByDate(com.sigmob.sdk.base.utils.e.f(com.sigmob.sdk.base.utils.e.f438c).getAbsolutePath())) {
                long currentTimeMillis = System.currentTimeMillis() - com.sigmob.sdk.base.l.a().w();
                if (file.exists() && currentTimeMillis > file.lastModified()) {
                    if (file.isFile()) {
                        if (!FileUtil.deleteFile(file.getAbsolutePath())) {
                            return;
                        }
                    } else if (file.isDirectory() && !FileUtil.deleteDirectory(file.getAbsolutePath())) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public Map<String, AdCache> a(int i2) {
        if (i2 == 1 || i2 == 4) {
            return this.v;
        }
        if (i2 == 5) {
            return this.z;
        }
        if (i2 != 6) {
            return null;
        }
        return this.A;
    }

    public void a(a aVar) {
        if (aVar == null || this.q.contains(aVar)) {
            return;
        }
        this.q.add(aVar);
    }

    public void a(BaseAdUnit baseAdUnit, b bVar) {
        if (bVar != null) {
            bVar.a(baseAdUnit);
        }
        if (baseAdUnit == null) {
            SigmobLog.e("adUnit is null");
            if (bVar != null) {
                bVar.a(baseAdUnit, "adUnit is null");
                return;
            }
            return;
        }
        if (baseAdUnit.getAd_type() == 2) {
            b(baseAdUnit, bVar);
            return;
        }
        if (bVar != null) {
            this.y.put(baseAdUnit.getUuid(), bVar);
        }
        try {
            new d(baseAdUnit).executeOnExecutor(ThreadPoolFactory.BackgroundThreadPool.getInstance().getExecutorService(), new Object[0]);
        } catch (Throwable th) {
            SigmobLog.e("AdUnitCheckCacheTask execute error", th);
        }
    }

    public void a(String str, int i2) {
        Map<String, AdCache> a2;
        if (TextUtils.isEmpty(str) || (a2 = a(i2)) == null) {
            return;
        }
        a2.remove(str);
    }

    public List<BaseAdUnit> b(String str, int i2) {
        return null;
    }

    public void b(a aVar) {
        if (aVar == null || !this.q.contains(aVar)) {
            return;
        }
        this.q.remove(aVar);
    }

    public void e(BaseAdUnit baseAdUnit) {
        Map<String, AdCache> a2;
        AdCache adCache;
        if (baseAdUnit == null || TextUtils.isEmpty(baseAdUnit.getAdslot_id()) || (a2 = a(baseAdUnit.getAd_type())) == null || (adCache = a2.get(baseAdUnit.getAdslot_id())) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(adCache.crids);
        if (adCache != null && arrayList.contains(baseAdUnit.getCrid())) {
            arrayList.remove(baseAdUnit.getCrid());
        }
        a2.put(baseAdUnit.getAdslot_id(), new AdCache(Integer.valueOf(baseAdUnit.getAd_type()), arrayList));
    }

    public void f(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null || TextUtils.isEmpty(baseAdUnit.getCrid()) || TextUtils.isEmpty(baseAdUnit.getAdslot_id())) {
            return;
        }
        Map<String, AdCache> a2 = a(baseAdUnit.getAd_type());
        if ((a2 == null || a2.size() <= 29) && a2 != null) {
            AdCache adCache = a2.get(baseAdUnit.getAdslot_id());
            ArrayList arrayList = new ArrayList();
            arrayList.add(baseAdUnit.getCrid());
            if (adCache != null) {
                arrayList.addAll(adCache.crids);
            }
            a2.put(baseAdUnit.getAdslot_id(), new AdCache(Integer.valueOf(baseAdUnit.getAd_type()), arrayList));
        }
    }

    public void g(BaseAdUnit baseAdUnit) {
        this.u.remove(baseAdUnit);
        this.y.remove(baseAdUnit.getUuid());
    }

    public void i(String str) {
        this.w = str;
    }

    public void j(String str) {
        this.x = str;
    }

    public String k(String str) {
        return this.o.get(str);
    }

    public String n() {
        return this.w;
    }

    public String o() {
        return this.x;
    }
}
