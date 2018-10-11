/*
 * Created by Darshan Pandya.
 * @itznotabug
 * Copyright (c) 2018.
 */

package pl.mkaflowski.library.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.AsyncTask;

import com.bumptech.glide.Glide;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class HouseAdsHelper {
    public static String parseJsonObject(String url) {
        Document doc = null;
        try {
            doc = Jsoup
                    .connect(url.trim())
                    .ignoreContentType(true)
                    .timeout(3000)
                    .header("Connection", "keep-alive")
                    .header("Cache-Control", "max-age=0")
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.125 Safari/537.36")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Referer", "'HouseAdsDialog' (App)")
                    .header("Accept-Encoding", "gzip,deflate,sdch")
                    .header("Accept-Language", "en-US,en;q=0.8,ru;q=0.6")
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //noinspection ConstantConditions
        if (doc != null && !doc.body().text().trim().equals(""))
            return doc.body().text();

        else return "";
    }

    public static boolean isAppInstalled(Context mActivity, String packageName) {
        if (packageName.startsWith("http")) {
            String[] splits = packageName.split("id=");
            if (splits.length == 0)
                return false;
            packageName = splits[splits.length - 1];
        }

        PackageManager pm = mActivity.getPackageManager();
        boolean isInstalled;
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            isInstalled = true;
        } catch (PackageManager.NameNotFoundException e) {
            isInstalled = false;
        }
        return isInstalled;
    }


    @SuppressLint("StaticFieldLeak")
    public static void clearGlideCache(final Context context) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                Glide.get(context).clearMemory();
            }

            @Override
            protected Void doInBackground(Void... voids) {
                Glide.get(context).clearDiskCache();
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        }.execute();
    }
}
