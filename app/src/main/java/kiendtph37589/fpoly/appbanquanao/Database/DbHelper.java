package kiendtph37589.fpoly.appbanquanao.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "appMuaSam.db";
    private static final int DB_VERSION = 1;

    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableAdmin = "CREATE TABLE Admin (" +
                "maAM TEXT PRIMARY KEY, " +
                "matKhau TEXT NOT NULL, " +
                "role INTEGER NOT NULL," +
                "hoTen TEXT NOT NULL)";
        db.execSQL(createTableAdmin);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < newVersion){
            db.execSQL("DROP TABLE IF EXISTS Admin");
            onCreate(db);
        }
    }
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
        if (!db.isReadOnly()){
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }
}
