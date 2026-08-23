package com.sigmob.sdk.base.network;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c {
    public static byte[] a(byte[] bArr) {
        Inflater inflater = new Inflater();
        inflater.setInput(bArr);
        byte[] bArr2 = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (!inflater.finished()) {
                try {
                    byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
                } finally {
                }
            }
            inflater.end();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public static byte[] b(byte[] bArr) {
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (!deflater.finished()) {
                try {
                    byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
                } finally {
                }
            }
            deflater.end();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}
