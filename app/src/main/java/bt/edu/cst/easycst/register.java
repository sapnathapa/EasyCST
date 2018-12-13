package bt.edu.cst.easycst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        List<String> departments = new ArrayList<String>();
        departments.add("Please Select Your Department");
        departments.add("Civil Engg. and Architecture");
        departments.add("Electrical");
        departments.add("Electronics and Communication");
        departments.add("Information Technology");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,departments);
        spinner.setPrompt("Department");
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //department.setPrompt("Department");
        spinner.setAdapter(dataAdapter);

    }
}
