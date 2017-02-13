package codingbo.downloadui.downloadMvp;

import java.util.List;

import codingbo.downloadui.download.DownloadInfo;

/**
 * Created by bob
 * on 17.2.13.
 */

public interface DataSource {

    interface LoadCallback {
        void success(List<DownloadInfo> info);

        void failed(Exception e);
    }

    interface DownloadCallback {
        void success(DownloadInfo info);
        void failed(DownloadInfo info, Exception e);
        void downloading(DownloadInfo info, float progress);
    }

    void getData(LoadCallback callback);

    void addData(DownloadInfo info);

    void downloading(DownloadInfo info, int time, DownloadCallback callback);

}
