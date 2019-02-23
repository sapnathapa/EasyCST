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
    TextView modulet, attendancemiss, plus, minus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        FloatingActionButton addmodule = findViewById(R.id.addmodule);
        toGetData = new AttendanceHelper(this);
        modulet = (TextView) findViewById(R.id.modulet);
        attendancemiss = (TextView) findViewById(R.id.attendancemiss);
        plus = (TextView) findViewById(R.id.plusbutton);
        minus = (TextView) findViewById(R.id.minusbutton);

        Cursor res = toGetData.getModule();
        StringBuffer modulett = new StringBuffer();
        StringBuffer attendancemisst = new StringBuffer();

        if (res != null && res.getCount() > 0) {
            while (res.moveToNext()) {
                modulett.append(res.getString(1) + "\n");
                modulett.append(res.getString(2));
                attendancemisst.append(res.getString(3) + "\n");
                plus.setText("+");
                minus.setText("-");
            }
            modulet.setText(modulett.toString());
            attendancemiss.setText(attendancemisst.toString());
           // plus.setText("+");
            //minus.setText("-");
        }

        addmodule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Attendance.this, AddModule.class);
                startActivity(intent);
            }
        });
    }
}
