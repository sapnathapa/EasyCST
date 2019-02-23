package bt.edu.cst.easycst;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Rate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
    }
    /*
     * Start with rating the app
     * Determine if the Play Store is installed on the device
     *
     * */
//    public void rateApp()
//    {
////        try
////        {
////            Intent rateIntent = rateIntentForUrl("market://details");
////            startActivity(rateIntent);
////        }
////        catch (ActivityNotFoundException e)
////        {
////            Intent rateIntent = rateIntentForUrl("https://play.google.com/store/apps/details");
////            startActivity(rateIntent);
////        }
//    }
//
//    private Intent rateIntentForUrl(String url)
//    {
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("%s?id=%s", url, getPackageName())));
//        int flags = Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_MULTIPLE_TASK;
//        if (Build.VERSION.SDK_INT >= 21)
//        {
//            flags |= Intent.FLAG_ACTIVITY_NEW_DOCUMENT;
//        }
//        else
//        {
//            //noinspection deprecation
//            flags |= Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET;
//        }
//        intent.addFlags(flags);
//        return intent;
    }

   /* public class PlayStoreLink {

        public void checkForUpdate(Context context, int applicationId)
        {
            try {
                context.startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse(context.getString(R.string.url_market_details)
                                + applicationId)));
            } catch (android.content.ActivityNotFoundException anfe) {
                try {
                    context.startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse(context.getString(R.string.url_playstore_app)
                                    + applicationId)));
                } catch (Exception e) {
                    Toast.makeText(context,
                            R.string.install_google_play_store,
                            Toast.LENGTH_SHORT).show();
                }
            }
        }

        public void moreApps(Context context, @StringRes int devName) {
            try {
                context.startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse(context.getString(R.string.url_market_search_app)
                                + context.getString(devName))));
            } catch (ActivityNotFoundException anfe) {
                try {
                    context.startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse(context.getString(R.string.url_playstore_search_app)
                                    + context.getString(devName))));
                } catch (Exception e) {
                    Toast.makeText(context,
                            R.string.install_google_play_store,
                            Toast.LENGTH_SHORT).show();
                }
            }
        }

        public void rateApp(Context context, int applicationId) {
            try {
                Uri uri = Uri.parse(context.getString(R.string.url_market_details)
                        + applicationId);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                int flags = Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_MULTIPLE_TASK;
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT_WATCH)
                    flags |= Intent.FLAG_ACTIVITY_NEW_DOCUMENT;
                else
                    flags |= Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET;
                intent.addFlags(flags);
                context.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                checkForUpdate(context, applicationId);
            }
        }
    }*/
//}


