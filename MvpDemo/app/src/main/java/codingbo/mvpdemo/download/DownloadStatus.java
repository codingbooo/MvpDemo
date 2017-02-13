package codingbo.mvpdemo.download;

/**
 * 下载状态
 */

public enum DownloadStatus {
    /**
     * 未下载
     */
    NOT_DOWNLOAD(0),

    /**
     * 正在下载
     */
    DOWNLOADING(1),

    /**
     * 已下载
     */
    COMPLETED(2), DOWNLOAD_FAILED(3);

    final int id;

    DownloadStatus(int id) {
        this.id = id;
    }
}

