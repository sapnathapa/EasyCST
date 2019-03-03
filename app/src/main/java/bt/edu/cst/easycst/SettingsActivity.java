package bt.edu.cst.easycst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import bt.edu.cst.easycst.SettingsFragment;
import bt.edu.cst.easycst.R;

public class SettingsActivity extends AppCompatActivity {
    public static final String KEY_SEVEN_DAYS_SETTING = "sevendays";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
    }
}
