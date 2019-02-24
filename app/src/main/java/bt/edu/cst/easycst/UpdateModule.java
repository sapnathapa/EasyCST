package bt.edu.cst.easycst;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import bt.edu.cst.easycst.ModuleDatabaseContract.ModuleDatabase;
import bt.edu.cst.easycst.ModuleDatabaseHelper;
import bt.edu.cst.easycst.ModuleDetails;
import java.util.ArrayList;
import java.util.List;
public class UpdateModule extends AppCompatActivity {
    ModuleDatabaseHelper dbHelper;
    EditText mcode, mname, mtutor;
    Button btUpdate;
    List<ModuleDetails> userDetailsList;
    String mcodeupdate, mnameupdate, mtutorupdate;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_module);
        dbHelper = new ModuleDatabaseHelper(this);
        db = dbHelper.getWritableDatabase();
        mcode = (EditText) findViewById(R.id.updatemcode);
        mname = (EditText) findViewById(R.id.updatemname);
        mtutor = (EditText) findViewById(R.id.updatemtutor);
        btUpdate = (Button) findViewById(R.id.updatesave);

        final int rowId = getIntent().getIntExtra("MID", -1);

        Cursor c1 = db.query(ModuleDatabase.TABLE_NAME, null, ModuleDatabase._ID + " = " + rowId, null, null, null, null);
        userDetailsList = new ArrayList<ModuleDetails>();
        userDetailsList.clear();
        if (c1 != null && c1.getCount() != 0) {
            while (c1.moveToNext()) {
                mcode.setText(c1.getString(c1.getColumnIndex(ModuleDatabase.COLUMN_NAME_COL1)));
                mname.setText(c1.getString(c1.getColumnIndex(ModuleDatabase.COLUMN_NAME_COL2)));
                mtutor.setText(c1.getString(c1.getColumnIndex(ModuleDatabase.COLUMN_NAME_COL3)));
            }
        }
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mcodeupdate = mcode.getText().toString();
                mnameupdate = mname.getText().toString();
                mtutorupdate = mtutor.getText().toString();
                ContentValues values = new ContentValues();
                values.put(ModuleDatabase.COLUMN_NAME_COL1, mcodeupdate);
                values.put(ModuleDatabase.COLUMN_NAME_COL2, mnameupdate);
                values.put(ModuleDatabase.COLUMN_NAME_COL3, mtutorupdate);
                int updateId = db.update(ModuleDatabase.TABLE_NAME, values, ModuleDatabase._ID + " = " + rowId, null);
                if (updateId != -1) {
                    Toast.makeText(UpdateModule.this, "Module Details Upated succesfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UpdateModule.this, Attendance.class);
                    startActivity(intent);
                    finish();
                } else {

                    Toast.makeText(UpdateModule.this, "Module Updation Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    protected void onDestroy() {
        db.close();
        super.onDestroy();
    }
}