package bt.edu.cst.easycst;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class register extends AppCompatActivity {
    // Creating EditText.
    //EditText name, uid, email, password ;
    private TextInputLayout name, uid, email, password;

    // Creating button;
    Button Register;

    //Creating Spinner
    Spinner spinners;

    // Creating Volley RequestQueue.
    RequestQueue requestQueue;

    // Create string variable to hold the EditText Value.
    String NameHolder, EmailHolder, PasswordHolder, DepartmentHolder, GenderHolder, UidHolder;

    // Creating Progress dialog.
    ProgressDialog progressDialog;

    //Creating RadioGroup
    RadioGroup gender;

    // Storing server url into String variable.
    String HttpUrl = "http://192.168.42.249/easycst/register.php";

    Boolean CheckEditText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Assigning ID's to EditText.
        name =  findViewById(R.id.nameWrapper);

        email = findViewById(R.id.regemailWrapper);

        password = findViewById(R.id.pass1Wrapper);

        uid = findViewById(R.id.uidWrapper);

        gender = (RadioGroup) findViewById(R.id.gender);

        spinners=(Spinner) findViewById(R.id.spinner);

        // Assigning ID's to Button.
        Register = (Button) findViewById(R.id.regButton);

        //Creating Spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        List<String> departments = new ArrayList<String>();
        departments.add("Civil Engg. and Architecture Department");
        departments.add("Electrical Engg Department");
        departments.add("Electronics and Communication Department");
        departments.add("Information Technology Department");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,departments);
        spinner.setPrompt("Department");
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //department.setPrompt("Department");
        spinner.setAdapter(dataAdapter);


        GenderHolder = (String) ((RadioButton) this.gender.findViewById(this.gender.getCheckedRadioButtonId())).getText();

        // Creating Volley newRequestQueue .
        requestQueue = Volley.newRequestQueue(register.this);

        // Assigning Activity this to progress dialog.
        progressDialog = new ProgressDialog(register.this);

        // Adding click listener to button.
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DepartmentHolder = String.valueOf(spinners.getSelectedItem());
                CheckEditTextIsEmptyOrNot();
                if(CheckEditText){
                    UserRegistration();
                }
                else {
                    Snackbar.make(view, "Please fill all fields", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }

            }
        });
    }

    public void UserRegistration(){

        // Showing progress dialog at user registration time.
        progressDialog.setMessage("Please Wait, We are Inserting Your Data on Server");
        progressDialog.show();

        // Creating string request with post method.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, HttpUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String ServerResponse) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();

                        // Showing Echo Response Message Coming From Server.

                        Toast.makeText(register.this, ServerResponse, Toast.LENGTH_LONG).show();
                        if(ServerResponse.equals("Registration Successfull")){
                            startActivity(new Intent(register.this, Home.class));
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();

                        // Showing error message if something goes wrong.
                        Toast.makeText(register.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                // Adding All values to Params.
                // The firs argument should be same sa your MySQL database table columns.
                params.put("name", NameHolder);
                params.put("uid", UidHolder);
                params.put("password", PasswordHolder);
                params.put("gender", GenderHolder);
                params.put("email", EmailHolder);
                params.put("department", DepartmentHolder);

                return params;
            }

        };

        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(register.this);

        // Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);

    }


    public void CheckEditTextIsEmptyOrNot(){

        // Getting values from EditText.
        NameHolder = name.getEditText().getText().toString().trim();
        UidHolder= uid.getEditText().getText().toString().trim();
        PasswordHolder = password.getEditText().getText().toString().trim();
        EmailHolder = email.getEditText().getText().toString().trim();

        Log.d("name",NameHolder);
        Log.d("uid",UidHolder);
        Log.d("password",PasswordHolder);
        Log.d("email",EmailHolder);


        // Checking whether EditText value is empty or not.
        if(TextUtils.isEmpty(NameHolder) || TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder)|| TextUtils.isEmpty(UidHolder))
        {

            // If any of EditText is empty then set variable value as False.
            CheckEditText = false;

        }
        else {

            // If any of EditText is filled then set variable value as True.
            CheckEditText = true ;
            if(isEmail(EmailHolder)){
                CheckEditText = true;
            }
            else{
                CheckEditText = false;
                EditText myEditText = (EditText)findViewById(R.id.regemail);
                //myEditText.setTextColor(Color.RED);
                myEditText.setText("");
                myEditText.setHintTextColor(Color.RED);
                myEditText.setHint("Please enter correct email");
                myEditText.setBackgroundTintList(ColorStateList.valueOf(Color.RED));

            }
        }
    }
    public final static boolean isEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

}
