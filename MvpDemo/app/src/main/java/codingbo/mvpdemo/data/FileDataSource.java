package codingbo.mvpdemo.data;


import java.util.List;

/**
 * Created by bob
 * on 17.2.8.
 */

public interface FileDataSource {


    interface LoadFileCallback {

        void onFilesLoaded(List<FileInfo> files);

        void onDataNotAvailable();
    }

    interface GetFileCallback {

        void onFilesLoaded(FileInfo file);

        void onDataNotAvailable();
    }

    void getFiles(LoadFileCallback callback);

    void getFile(String fileId, GetFileCallback callback);

    void refreshData();

    void downloadComplete(String fileId);

    void downloadFailed(String fileId);

    void downloading(String fileId);

    void updateProgress(String fileId, float progress);

    void saveFile(FileInfo f);

    void deleteFile(String fileId);

    void deleteAllFiles();
}
