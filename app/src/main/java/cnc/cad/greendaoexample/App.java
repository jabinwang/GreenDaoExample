package cnc.cad.greendaoexample;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

/**
 * @author :wangjm1
 * @version :1.0
 * @package : cnc.cad.greendaoexample
 * @class : ${CLASS_NAME}
 * @time : 2017/3/9 ${ITME}
 * @description :TODO
 */
public class App extends Application {
    public static final boolean ENCRYPTED = false;
    private  DaoSession mDaoSession;
    private static App mApplication;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplication = this;
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, ENCRYPTED?"notes-db-encrypted":"notes-db");
        Database db  = ENCRYPTED?helper.getEncryptedWritableDb("super-secret"):helper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession(){
        return mDaoSession;
    }

    public static App getApplication(){
        return mApplication;
    }
}
