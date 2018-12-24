package bt.edu.cst.easycst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Button register = (Button) findViewById(R.id.regButton);

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

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(register.this,Home.class);
                finish();
                startActivity(intent);
            }
        });


    }
}
