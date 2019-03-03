package bt.edu.cst.easycst;

/**
 * Created by Tek Nath Acharya nathtek136@gmail.com
 * for Easy CST app
 */
import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;
import bt.edu.cst.easycst.R;


public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.settings, rootKey);
    }
}
