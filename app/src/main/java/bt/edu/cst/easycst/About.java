package bt.edu.cst.easycst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class About extends AppCompatActivity {
    WebView webView;
    WebSettings webSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        webView= findViewById(R.id.webView);
        webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String htmlText = " %s ";

        String myData = "<html><body style=\"text-align:justify\"><h2 align=\"center\">Version : 1.0</h2><h2 align=\"center\">About App</h2>EasyCST, a platform where the student can have easy access to the service like maintenance.\n" +
                "        Has privilege to track ones attendance and own editable timetable.\n" +
                "        User can provide feedback and suggestion for the betterment of the college.\n" +
                "<h2 align=\"center\">Developers</h2> 1. Mr.Tek Nath Acharya(nathtek136@gmail.com)<br>" +
                "        2. Mr.Karma Dori(karmadorgey@gmail.com)<br>" +
                "        3. Ms.Deepika Suberi(deepikasbr@gmail.com)<br>" +
                "        4. Mr.Karma Tshewang(kartse100@gmail.com).\n" +
                "<h2 align=\"center\">Special Thanks</h2> 1. Mr.Parshuram Dhungyel(parshuram.cst@rub.<br>edu.bt)<br>" +
                "        2. Mr.Hari Kafley(hari.kafley@itechnologies.bt)<br>" +
                "        3. Mr.Khusant Chhetri(0215518.cst@rub.edu.bt)</body></html>";

//        String myData = "Hello World! This tutorial is to show demo of displaying text with justify alignment in WebView.";

        webView.loadData(String.format(htmlText,myData),"text/html","utf-8");
    }
}
