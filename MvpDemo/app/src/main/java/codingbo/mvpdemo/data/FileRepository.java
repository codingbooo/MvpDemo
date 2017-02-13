package codingbo.mvpdemo.data;

import java.util.Map;

/**
 * Created by bob
 * on 17.2.8.
 */

public class FileRepository implements FileDataSource {

    private static FileRepository INSTANCE = null;

    private final FileLocalDataSource mLocalSource;

    private FileRepository(FileLocalDataSource localSource) {
        mLocalSource = localSource;
    }

    public static synchronized FileRepository getInstance(FileLocalDataSource localSource) {
        if (INSTANCE == null) {
            INSTANCE = new FileRepository(localSource);
        }
        return INSTANCE;
    }

    @Override
    public void getFiles(LoadFileCallback callback) {

    }

    @Override
    public void getFile(String fileId, GetFileCallback callback) {

    }

    @Override
    public void refreshData() {

    }

    @Override
    public void downloadComplete(String fileId) {

    }

    @Override
    public void downloadFailed(String fileId) {

    }

    @Override
    public void downloading(String fileId) {

    }

    @Override
    public void updateProgress(String fileId, float progress) {

    }

    @Override
    public void saveFile(FileInfo f) {

    }

    @Override
    public void deleteFile(String fileId) {

    }

    @Override
    public void deleteAllFiles() {

    }
}
