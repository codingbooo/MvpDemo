package codingbo.mvpdemo.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.util.Log;

import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import codingbo.mvpdemo.data.dao.DaoMaster;
import codingbo.mvpdemo.data.dao.DaoSession;
import codingbo.mvpdemo.data.dao.FileInfoDao;
import codingbo.mvpdemo.download.DownloadStatus;

/**
 * Created by bob
 * on 17.2.9.
 */

public class FileLocalDataSource implements FileDataSource {
    private static final String TAG = "FileLocalDataSource";
    private static FileLocalDataSource INSTANCE;

    private FileInfoDao mFileInfoDao;


    private FileLocalDataSource(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "recluse-db", null);
        SQLiteDatabase database = helper.getWritableDatabase();
        DaoMaster master = new DaoMaster(database);
        DaoSession session = master.newSession();
        mFileInfoDao = session.getFileInfoDao();
    }

    public static synchronized FileLocalDataSource getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new FileLocalDataSource(context);
        }
        return INSTANCE;
    }

    @Override
    public void getFiles(LoadFileCallback callback) {
        if (callback == null) {
            return;
        }
        callback.onFilesLoaded(mFileInfoDao.loadAll());
//        callback.onDataNotAvailable();
    }

    @Override
    public void getFile(String fileId, GetFileCallback callback) {
        if (callback == null) {
            return;
        }
        FileInfo info = getFileInfo(fileId);
        if (info != null) {
            callback.onFilesLoaded(info);
        }

    }

    @Nullable
    private FileInfo getFileInfo(String fileId) {
        List<FileInfo> list = mFileInfoDao.queryBuilder()
                .where(FileInfoDao.Properties.MFileId.eq(fileId))
                .list();

        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public void refreshData() {

    }

    @Override
    public void downloadComplete(String fileId) {
        updateDownloadStatus(fileId, DownloadStatus.COMPLETED);
    }

    private void updateDownloadStatus(String fileId, DownloadStatus completed) {
        FileInfo info = getFileInfo(fileId);
        if (info == null) {
            return;
        }
        info.setDownloadStatus(completed);
        mFileInfoDao.update(info);
    }

    @Override
    public void downloadFailed(String fileId) {
        updateDownloadStatus(fileId, DownloadStatus.DOWNLOAD_FAILED);
    }

    @Override
    public void downloading(String fileId) {
        updateDownloadStatus(fileId, DownloadStatus.DOWNLOADING);
    }

    @Override
    public void updateProgress(String fileId, float progress) {
        FileInfo info = getFileInfo(fileId);
        if (info == null) {
            return;
        }
        info.setProgress(progress);
        mFileInfoDao.update(info);
    }

    @Override
    public void saveFile(FileInfo f) {
        FileInfo info = getFileInfo(f.getFileId());
        Log.d(TAG, "saveFile: " + info);
        if (info != null) {
//            mFileInfoDao.update(f);

            return;
        }
        mFileInfoDao.insert(f);
    }

    @Override
    public void deleteFile(String fileId) {
        FileInfo info = getFileInfo(fileId);
        if (info == null) {
            return;
        }
        mFileInfoDao.delete(info);
    }

    @Override
    public void deleteAllFiles() {
        mFileInfoDao.deleteAll();
    }
}
