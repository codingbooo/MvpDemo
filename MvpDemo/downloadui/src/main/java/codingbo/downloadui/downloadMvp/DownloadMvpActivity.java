package codingbo.downloadui.downloadMvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import codingbo.downloadui.R;

/**
 * Created by bob
 * on 17.2.13.
 */

public class DownloadMvpActivity extends AppCompatActivity {

    private DownloadPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download_mvp_act);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_edit_task);

//        fab.setOnClickListener(new );

        DownloadFragment fragment = (DownloadFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (fragment == null) {
            fragment = DownloadFragment.getInstance();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.contentFrame, fragment);
            transaction.commit();

        }

        mPresenter = DownloadPresenter.getInstance(DataRepository.getInstance(this), fragment);

    }
}
