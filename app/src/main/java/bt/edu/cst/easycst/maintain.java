package bt.edu.cst.easycst;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class maintain extends AppCompatActivity {
    // Creating EditText.
    EditText room, phone, descript;
    private TextInputLayout room1, phone1, desc;


    // Creating button;
    Button Register;

    // Creating Volley RequestQueue.
    RequestQueue requestQueue;

    // Create string variable to hold the EditText Value.
    String RoomHolder, PhoneHolder, DescriptHolder;

    // Creating Progress dialog.
    ProgressDialog progressDialog;

    // Storing server url into String variable.
    String HttpUrl = "http://192.168.42.249/easycst/maintain.php";

    Boolean CheckEditText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintain);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Assigning ID's to EditText.
        room1 =  findViewById(R.id.roomWrapper);

        phone1 =  findViewById(R.id.phoneWrapper);

       descript = findViewById(R.id.descript);
       // desc = findViewById(R.id.descriptionWrapper);
        //descript = findViewById(R.id.descript);


        // Assigning ID's to Button.
        Register = (Button) findViewById(R.id.submit);




        // Creating Volley newRequestQueue .
        requestQueue = Volley.newRequestQueue(maintain.this);

        // Assigning Activity this to progress dialog.
        progressDialog = new ProgressDialog(maintain.this);

        // Adding click listener to button.
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckEditTextIsEmptyOrNot();
                if(CheckEditText){
                    MRegistration();
                }
                else {
                    Snackbar.make(view, "Please fill all fields ", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                }

            }
        });

    }

    public void MRegistration(){

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

                        Toast.makeText(maintain.this, ServerResponse, Toast.LENGTH_LONG).show();
                        if(ServerResponse.equals("Registration Successfull")){
                            startActivity(new Intent(maintain.this, Home.class));
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();

                        // Showing error message if something goes wrong.
                        Toast.makeText(maintain.this, volleyError.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                // Adding All values to Params.
                // The firs argument should be same sa your MySQL database table columns.
                params.put("room", RoomHolder);
                params.put("phone", PhoneHolder);
                params.put("descript", DescriptHolder);
                return params;
            }

        };

        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(maintain.this);

        // Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);

    }


    public void CheckEditTextIsEmptyOrNot(){

        // Getting values from EditText.
        RoomHolder = room1.getEditText().getText().toString().trim();
        PhoneHolder= phone1.getEditText().getText().toString().trim();
        //DescriptHolder = desc.getEditText().getText().toString().trim();
        DescriptHolder = descript.getText().toString().trim();

        Log.d("room1", RoomHolder);
        Log.d("phone1",PhoneHolder);
        //Log.d("desc", DescriptHolder);
        Log.d("descritp",DescriptHolder);
        // Checking whether EditText value is empty or not.
        if(TextUtils.isEmpty(RoomHolder) || TextUtils.isEmpty(RoomHolder) || TextUtils.isEmpty(DescriptHolder))
        {

            // If any of EditText is empty then set variable value as False.
            CheckEditText = false;

        }
        else {

            // If any of EditText is filled then set variable value as True.
            CheckEditText = true ;
        }
    }
}
