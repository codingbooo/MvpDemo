package codingbo.downloadui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import codingbo.downloadui.download.DownloadActivity;
import codingbo.downloadui.downloadMvp.DownloadMvpActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void download(View view) {

        startActivity(new Intent(this, DownloadActivity.class));

    }
    public void mvp(View view) {

        startActivity(new Intent(this, DownloadMvpActivity.class));

    }
}
