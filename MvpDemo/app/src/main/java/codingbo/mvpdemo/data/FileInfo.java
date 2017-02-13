package codingbo.mvpdemo.data;

import android.support.annotation.NonNull;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;

import codingbo.mvpdemo.download.DownloadStatus;
import codingbo.mvpdemo.download.DownloadStatusConvert;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by bob
 * on 17.2.8.
 */
@Entity
public class FileInfo {
    @NonNull
    @Unique
    @Id
    private String mFileId;
    @NonNull
    private String mFileName;
    private float mProgress;
    @NonNull
    @Convert(converter = DownloadStatusConvert.class, columnType = Integer.class)
    private DownloadStatus mDownloadStatus;

    @Generated(hash = 1367591352)
    public FileInfo() {
    }

    @Generated(hash = 1314478983)
    public FileInfo(@NonNull String mFileId, @NonNull String mFileName, float mProgress,
            @NonNull DownloadStatus mDownloadStatus) {
        this.mFileId = mFileId;
        this.mFileName = mFileName;
        this.mProgress = mProgress;
        this.mDownloadStatus = mDownloadStatus;
    }

    public String getFileId() {
        return mFileId;
    }

    public void setFileId(String fileId) {
        mFileId = fileId;
    }

    public String getFileName() {
        return mFileName;
    }

    public void setFileName(String fileName) {
        mFileName = fileName;
    }

    public float getProgress() {
        return mProgress;
    }

    public void setProgress(float progress) {
        mProgress = progress;
    }

    public DownloadStatus getDownloadStatus() {
        return mDownloadStatus;
    }

    public void setDownloadStatus(DownloadStatus downloadStatus) {
        mDownloadStatus = downloadStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileInfo info = (FileInfo) o;

        if (mFileId != null ? !mFileId.equals(info.mFileId) : info.mFileId != null) return false;
        return mFileName != null ? mFileName.equals(info.mFileName) : info.mFileName == null;

    }

    @Override
    public int hashCode() {
        int result = mFileId != null ? mFileId.hashCode() : 0;
        result = 31 * result + (mFileName != null ? mFileName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                " mFileId='" + mFileId + '\'' +
                ", mFileName='" + mFileName + '\'' +
                ", mProgress=" + mProgress +
                ", mDownloadStatus=" + mDownloadStatus +
                '}';
    }

    public float getMProgress() {
        return this.mProgress;
    }

    public void setMProgress(float mProgress) {
        this.mProgress = mProgress;
    }

    public String getMFileName() {
        return this.mFileName;
    }

    public void setMFileName(String mFileName) {
        this.mFileName = mFileName;
    }

    public String getMFileId() {
        return this.mFileId;
    }

    public void setMFileId(String mFileId) {
        this.mFileId = mFileId;
    }

    public DownloadStatus getMDownloadStatus() {
        return this.mDownloadStatus;
    }

    public void setMDownloadStatus(DownloadStatus mDownloadStatus) {
        this.mDownloadStatus = mDownloadStatus;
    }
}
