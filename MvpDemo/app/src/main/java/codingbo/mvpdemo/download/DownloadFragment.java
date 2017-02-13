package codingbo.mvpdemo.download;

import java.util.List;

import codingbo.mvpdemo.BasePresenter;
import codingbo.mvpdemo.base.BaseFragment;
import codingbo.mvpdemo.data.FileInfo;

/**
 * Created by bob
 * on 17.2.8.
 */

public class DownloadFragment extends BaseFragment implements DownloadContract.View{


    @Override
    public void showLoadingIndicator(boolean active) {

    }

    @Override
    public void showFileDetail(String fileId) {

    }

    @Override
    public void showFiles(List<FileInfo> fs) {

    }

    @Override
    public void showDownloadComplete(String msg) {

    }

    @Override
    public void showFileCancel(String msg) {

    }

    @Override
    public void showDownloadFailed(String msg) {

    }

    @Override
    public void showAddDownload() {

    }

    @Override
    public void showLoadFilesError() {

    }

    @Override
    public void showFilesEmpty() {

    }

    @Override
    public void showDeleteFile(String s) {

    }

    @Override
    public void setPresenter(BasePresenter p) {

    }
}
