package codingbo.mvpdemo.download;

import java.util.List;

import codingbo.mvpdemo.BasePresenter;
import codingbo.mvpdemo.BaseView;
import codingbo.mvpdemo.data.FileInfo;

/**
 * Created by bob
 * on 17.2.8.
 */

public interface DownloadContract {
    interface View extends BaseView {

        void showLoadingIndicator(boolean active);//加载提示

        void showFileDetail(String fileId);//显示文件详情

        void showFiles(List<FileInfo> fs);//展示下载列表

        void showDownloadComplete(String msg);//提示下载完成

        void showFileCancel(String msg);//提示取消文件下载

        void showDownloadFailed(String msg);//提示下载失败

        void showAddDownload();//添加下载任务

        void showLoadFilesError();//获取下载任务失败

        void showFilesEmpty();//数据为空

        void showDeleteFile(String s);
    }

    interface Presenter extends BasePresenter {

        void result(int requestCode, int resultCode, FileInfo fileInfo);//OnActivityResult 回调

        void addDownloadFile();//添加下载任务

        void loadFiles(boolean forceUpdate);//加载下载任务

        void retryDownload(FileInfo f);//重新下载

        void deleteFile(FileInfo f);//删除任务

        void openFile(FileInfo f);//打开任务

        void setFiltering(DownloadStatus status);//设置过滤

        DownloadStatus getFiltering();

    }

}
