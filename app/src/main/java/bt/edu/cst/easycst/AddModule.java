package bt.edu.cst.easycst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddModule extends AppCompatActivity {

    AddModuleHelper addModule;
    EditText name, tutor;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_module);

        addModule = new AddModuleHelper(this);

        name = (EditText) findViewById(R.id.mnamecode);
        tutor = (EditText) findViewById(R.id.tutor);
        save = (Button) findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDetails();
            }
        });
    }

    private void getDetails() {
        String sname = name.getText().toString();
        String stutor = tutor.getText().toString();
        int attendance=0;

        Boolean result = addModule.insertModule(sname,stutor, attendance);

        if(result){
            Toast.makeText(this, "Module recorded correctly", Toast.LENGTH_LONG).show();

        }
    }

}
