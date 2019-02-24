package bt.edu.cst.easycst;

/**
 * Created by Tek Nath Acharya nathtek136@gmail.com
 * for Easy CST app
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import bt.edu.cst.easycst.ModuleDatabaseContract.ModuleDatabase;
public class ModuleDatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "module.db";
    public ModuleDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersio, int newVersion) {

        db.execSQL(DELETE_USER_TABLE);
        onCreate(db);

    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    private static final String CREATE_USER_TABLE = "CREATE TABLE " + ModuleDatabase.TABLE_NAME +
            "( " + ModuleDatabase._ID + " INTEGER PRIMARY KEY," +
            ModuleDatabase.COLUMN_NAME_COL1 + " text," +
            ModuleDatabase.COLUMN_NAME_COL2 + " text," +
            ModuleDatabase.COLUMN_NAME_COL3 + " text," +
            ModuleDatabase.COLUMN_NAME_COL4 + " text)";
    private static final String DELETE_USER_TABLE = "DROP TABLE IF EXISTS " + ModuleDatabase.TABLE_NAME;

}
