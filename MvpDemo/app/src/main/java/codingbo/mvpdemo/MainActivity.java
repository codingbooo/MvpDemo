package codingbo.mvpdemo;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "recluse-db", null);
//
//        SQLiteDatabase database = helper.getWritableDatabase();
//
//        DaoMaster master = new DaoMaster(database);
//
//        DaoSession session = master.newSession();
//        FileInfoDao dao = session.getFileInfoDao();
//
//        dao.loadByRowId(1);

    }
}
