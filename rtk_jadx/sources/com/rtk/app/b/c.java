package com.rtk.app.b;

import java.io.File;
import java.util.List;

/* compiled from: RTKZipUtil.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c {
    public static String a(String str) {
        File file = new File(d.c());
        if (a.f(d.c())) {
            b.b("清空拷贝文件夹成功");
        } else {
            b.b("清空拷贝文件夹失败,路径为 : " + d.c());
        }
        file.mkdirs();
        File file2 = new File(d.g());
        if (a.f(d.g())) {
            b.b("清空压缩文件夹成功");
        } else {
            b.b("清空压缩文件夹失败,路径为 : " + d.g());
        }
        file2.mkdirs();
        String str2 = d.e() + str + ".log";
        String c2 = d.c();
        if (a.g(str2)) {
            b.b("文件：" + str + ".log存在");
            if (!a.c(new File(str2), c2, str + ".log")) {
                b.b("拷贝日志文件失败！");
                return "拷贝日志文件失败！";
            }
            b.b("拷贝日志文件成功！");
            if (!a.b(d.c(), d.g() + "check_3_" + str + ".zip")) {
                b.b("压缩日志文件失败！");
                return "压缩日志文件失败！";
            }
            b.b("压缩日志文件成功！");
            return "";
        }
        b.b("未找到文件：" + d.e() + str + ".log");
        return "日志文件未找到！";
    }

    public static String b(String str, String str2) {
        File file = new File(d.c());
        if (a.f(d.c())) {
            b.b("清空拷贝文件夹成功");
        } else {
            b.b("清空拷贝文件夹失败,路径为 : " + d.c());
        }
        file.mkdirs();
        File file2 = new File(d.g());
        if (a.f(d.g())) {
            b.b("清空压缩文件夹成功");
        } else {
            b.b("清空压缩文件夹失败,路径为 : " + d.g());
        }
        file2.mkdirs();
        if (!"".equals(str) && !"".equals(str2)) {
            List<String> a = d.a(str, str2);
            if (a != null && a.size() != 0) {
                int size = a.size();
                int i = 0;
                for (int i2 = 0; i2 < a.size(); i2++) {
                    String str3 = d.e() + a.get(i2) + ".log";
                    String c2 = d.c();
                    if (a.g(str3)) {
                        b.b("文件：" + a.get(i2) + ".log存在");
                        if (!a.c(new File(str3), c2, a.get(i2) + ".log")) {
                            b.b("拷贝日志文件失败！");
                            return "拷贝日志文件失败！";
                        }
                        b.b("拷贝日志文件成功！");
                        if (!a.b(d.c(), d.g() + "check_3_" + str + "_" + str2 + ".zip")) {
                            b.b("压缩日志文件失败！");
                            return "压缩日志文件失败！";
                        }
                        b.b("压缩日志文件成功！");
                    } else {
                        i++;
                        b.b("未找到文件：" + d.e() + a.get(i2) + ".log");
                    }
                    try {
                        Thread.sleep(500L);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (i != size) {
                    return "";
                }
                b.b("所选日期之间没有日志文件");
                return "所选日期之间没有日志文件！";
            }
            b.b("解析起止日期失败！");
            return "解析起止日期失败！";
        }
        b.b("起止日期格式异常！");
        return "起止日期格式异常！";
    }
}
