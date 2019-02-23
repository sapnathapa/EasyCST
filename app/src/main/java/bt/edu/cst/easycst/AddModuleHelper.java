package bt.edu.cst.easycst;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Tek Nath Acharya nathtek136@gmail.com
 * for Easy CST app
 */
public class AddModuleHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="trackattendance";
    public static final String TABLE_NAME="modules";

    public static final String COL_1="SLNO";
    public static final String COL_2="Name";
    public static final String COL_3="TUTOR";
    public static final String COL_4="ATTENDANCE";

    public AddModuleHelper(Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreate="CREATE TABLE " +TABLE_NAME+ "(SLNO INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, TUTOR TEXT, ATTENDANCE INTEGER)";
        db.execSQL(queryCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }

    public boolean insertModule(String name,String tutor,int attendance) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,tutor);
        contentValues.put(COL_4,attendance);

        long result=db.insert(TABLE_NAME,null,contentValues);
        db.close();
        if(result==-1)
            return  false;
        else
            return true;
    }

    /*public boolean updateTrack(int key, String m1,String m2,String m3,String m4,String m5) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(KEY,key);//remove this line if there is an unexpeted error
        contentValues.put(COL_1,m1);
        contentValues.put(COL_2,m2);
        contentValues.put(COL_3,m3);
        contentValues.put(COL_4,m4);
        contentValues.put(COL_5,m5);
        long result=db.update(TABLE_NAME, contentValues, KEY + " = 1", null);
        db.close();
        if(result==-1)
            return  false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("SELECT "+COL_1+","+COL_2+","+COL_3+","+COL_4+","+COL_5+" FROM "+TABLE_NAME+" WHERE "+KEY+"=1",null);
        return res;
    }*/
}
