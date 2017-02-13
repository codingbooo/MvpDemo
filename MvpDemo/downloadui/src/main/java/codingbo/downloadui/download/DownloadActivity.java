package codingbo.downloadui.download;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import codingbo.downloadui.R;

/**
 * Created by bob
 * on 17.2.10.
 */

public class DownloadActivity extends AppCompatActivity {

    private ListView mLlList;
    private DownloadAdapter mAdapter;
    private List<DownloadInfo> mData;
    public Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
//            mData.add(0,new DownloadInfo("add", 50));
            mAdapter.setData(mData);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download_act);

        mLlList = (ListView) findViewById(R.id.ll_list);

        mData = getData();

        mAdapter = new DownloadAdapter(mData);

        mLlList.setAdapter(mAdapter);

        downloading(mData);
    }

    private void downloading(List<DownloadInfo> data) {

        startDownload(data.get(0), 200);
        startDownload(data.get(2), 700);
        startDownload(data.get(4), 500);
        startDownload(data.get(8), 300);

    }

    private void startDownload(final DownloadInfo info, final int time) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                float progress = info.getProgress();
                while (progress < 100) {
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    info.setProgress(++progress);
                    mHandler.sendEmptyMessage(0);
                }
            }
        }).start();
    }

    public List<DownloadInfo> getData() {
        List<DownloadInfo> mData = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            mData.add(new DownloadInfo("task" + i, i));
        }
        return mData;
    }
}
