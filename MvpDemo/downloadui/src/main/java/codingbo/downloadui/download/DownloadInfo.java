package codingbo.downloadui.download;

/**
 * Created by bob
 * on 17.2.10.
 */

public class DownloadInfo {
    private String mName;
    private float mProgress;

    public DownloadInfo() {
    }

    public DownloadInfo(String name, float progress) {
        mName = name;
        mProgress = progress;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public float getProgress() {
        return mProgress;
    }

    public void setProgress(float progress) {
        mProgress = progress;
    }


}
