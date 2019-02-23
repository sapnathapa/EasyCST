package bt.edu.cst.easycst;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Attendance extends AppCompatActivity {

    AttendanceHelper toGetData;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        FloatingActionButton addmodule = findViewById(R.id.addmodule);
        toGetData = new AttendanceHelper(this);
        display = (TextView) findViewById(R.id.display);

        Cursor res = toGetData.getModule();
        StringBuffer stringbuffer = new StringBuffer();
        if(res != null && res.getCount() > 0){
            while(res.moveToNext()){
                stringbuffer.append("SL: "+ res.getString(0)+"\n");
                stringbuffer.append("Name: "+ res.getString(1)+"\n");
                stringbuffer.append("Tutor: "+ res.getString(2)+"\n");
                stringbuffer.append("Attendance: "+ res.getString(3)+"\n");
            }
            display.setText(stringbuffer.toString());
        }

        addmodule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Attendance.this,AddModule.class);
                startActivity(intent);
            }
        });
    }
}
