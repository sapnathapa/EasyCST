package bt.edu.cst.easycst;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import bt.edu.cst.easycst.ModuleDetailsAdapter;
import bt.edu.cst.easycst.ModuleDatabaseContract.ModuleDatabase;
import bt.edu.cst.easycst.ModuleDatabaseHelper;
import bt.edu.cst.easycst.ModuleDetails;
import java.util.ArrayList;
import java.util.List;
public class Attendance extends AppCompatActivity {
    ModuleDatabaseHelper dbHelper;
    private RecyclerView recyclerView;
    private ModuleDetailsAdapter mopduleAdapter;
    private RecyclerView.LayoutManager layoutManager;
    FloatingActionButton addmodule;
    List<ModuleDetails> moduleDetailsList;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        dbHelper = new ModuleDatabaseHelper(this);
        db = dbHelper.getReadableDatabase();
        recyclerView = (RecyclerView) findViewById(R.id.modules);

        addmodule = findViewById(R.id.addmodule);
        addmodule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Attendance.this, AddModule.class);
                startActivity(intent);
            }
        });

        moduleDetailsList = new ArrayList<ModuleDetails>();
        moduleDetailsList.clear();
        Cursor c1 = db.query(ModuleDatabase.TABLE_NAME, null, null, null, null, null, null);
        if (c1 != null && c1.getCount() != 0) {
            moduleDetailsList.clear();
            while (c1.moveToNext()) {
                ModuleDetails moduleDetailsItem = new ModuleDetails();
                moduleDetailsItem.setModuleId(c1.getInt(c1.getColumnIndex(ModuleDatabase._ID)));
                moduleDetailsItem.setMcode(c1.getString(c1.getColumnIndex(ModuleDatabase.COLUMN_NAME_COL1)));
                moduleDetailsItem.setMname(c1.getString(c1.getColumnIndex(ModuleDatabase.COLUMN_NAME_COL2)));
                moduleDetailsItem.setMtutor(c1.getString(c1.getColumnIndex(ModuleDatabase.COLUMN_NAME_COL3)));
                moduleDetailsItem.setMattendance(c1.getInt(c1.getColumnIndex(ModuleDatabase.COLUMN_NAME_COL4)));
                moduleDetailsList.add(moduleDetailsItem);
            }
        }
        c1.close();
        layoutManager = new LinearLayoutManager(this);
        mopduleAdapter = new ModuleDetailsAdapter(moduleDetailsList,this,recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mopduleAdapter);
    }
    @Override
    protected void onDestroy() {
        db.close();
        super.onDestroy();
    }
}