package codingbo.mvpdemo.download;

import java.util.List;

import codingbo.mvpdemo.data.FileDataSource;
import codingbo.mvpdemo.data.FileInfo;
import codingbo.mvpdemo.data.FileRepository;

import static codingbo.mvpdemo.utils.Preconditions.checkNotNull;

/**
 * Created by bob
 * on 17.2.8.
 */

public class DownloadPresenter implements DownloadContract.Presenter {

    private FileRepository mFileRepository;
    private DownloadContract.View mDownloadView;

    private boolean mFirstLoad = true;

    public DownloadPresenter(FileRepository fileRepository, DownloadContract.View downloadView) {

        mFileRepository = checkNotNull(fileRepository, "FileRepository cannot be null");

        mDownloadView = checkNotNull(downloadView, "DownloadContract.View cannot be null");

        mDownloadView.setPresenter(this);

    }

    @Override
    public void result(int requestCode, int resultCode, FileInfo fileInfo) {
        mFileRepository.saveFile(fileInfo);
        loadFiles(false, false);
    }

    @Override
    public void addDownloadFile() {
        mDownloadView.showAddDownload();
    }

    @Override
    public void loadFiles(boolean forceUpdate) {

        loadFiles(forceUpdate || mFirstLoad, true);

        mFirstLoad = false;
    }

    private void loadFiles(boolean forceUpdate, final boolean showLoadingUI) {

        if(showLoadingUI){
            mDownloadView.showLoadingIndicator(true);
        }

        if(forceUpdate){
            mFileRepository.refreshData();
        }

        mFileRepository.getFiles(new FileDataSource.LoadFileCallback() {
            @Override
            public void onFilesLoaded(List<FileInfo> files) {
                if (files != null && !files.isEmpty()) {
                    mDownloadView.showFiles(files);
                } else {
                    mDownloadView.showFilesEmpty();
                }

                if(showLoadingUI){
                    mDownloadView.showLoadingIndicator(false);
                }

            }

            @Override
            public void onDataNotAvailable() {
                mDownloadView.showLoadFilesError();
                if(showLoadingUI){
                    mDownloadView.showLoadingIndicator(false);
                }
            }
        });
    }

    @Override
    public void retryDownload(FileInfo f) {

    }

    @Override
    public void deleteFile(FileInfo f) {
        mFileRepository.deleteFile(f.getFileId());
        mDownloadView.showDeleteFile(f.getFileName() + "删除成功");
        loadFiles(false, false);
    }

    @Override
    public void openFile(FileInfo f) {
        mDownloadView.showFileDetail(f.getFileId());
    }

    @Override
    public void setFiltering(DownloadStatus status) {

    }

    @Override
    public DownloadStatus getFiltering() {
        return null;
    }

    @Override
    public void start() {
        loadFiles(false);
    }
}
