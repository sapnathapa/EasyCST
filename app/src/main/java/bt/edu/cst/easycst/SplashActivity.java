package bt.edu.cst.easycst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);

        // Start home activity
        startActivity(new Intent(SplashActivity.this, Home.class));
        // close splash activity
        finish();
    }
}
