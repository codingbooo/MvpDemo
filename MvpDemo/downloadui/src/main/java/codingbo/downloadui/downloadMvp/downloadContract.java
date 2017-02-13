package codingbo.downloadui.downloadMvp;

import java.util.List;

import codingbo.downloadui.BasePresenter;
import codingbo.downloadui.BaseView;
import codingbo.downloadui.download.DownloadInfo;

/**
 * Created by bob
 * on 17.2.13.
 */

public interface DownloadContract {
    interface View extends BaseView<DownloadContract.Presenter> {

        void showDownload(List<DownloadInfo> info);

        void showAddDownload();

        void showFailed();
    }


    interface Presenter extends BasePresenter {

        void result(int requestCode, int resultCode, DownloadInfo info);

        void refreshData();

        void addDownload();

    }

}
