package codingbo.downloadui.downloadMvp;

import android.content.Context;
import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

import codingbo.downloadui.download.DownloadInfo;

/**
 * Created by bob
 * on 17.2.13.
 */

public class DataRepository implements DataSource {

    private static DataRepository INSTANCE;

    private List<DownloadInfo> mData;

    private DataRepository(Context context) {
        mData = new ArrayList<>();
    }


    public static synchronized DataRepository getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new DataRepository(context);
        }
        return INSTANCE;
    }

//    @Override
//    public List<DownloadInfo> getData() {
//        return mData;
//    }

    @Override
    public void getData(LoadCallback callback) {
        callback.success(mData);
    }

    @Override
    public void addData(DownloadInfo info) {
        mData.add(info);
    }

    @Override
    public void downloading(DownloadInfo info, int time, DownloadCallback callback) {
        startDownload(info, time, callback);
    }

    private void startDownload(final DownloadInfo info, final int time, final DownloadCallback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    float progress = info.getProgress();
                    while (progress < 100) {
                        Thread.sleep(time);
                        info.setProgress(++progress);
                        callback.downloading(info, progress);
                    }
                    callback.success(info);
                } catch (InterruptedException e) {
                    callback.failed(info, e);
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
