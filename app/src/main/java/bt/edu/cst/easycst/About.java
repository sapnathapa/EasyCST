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
                "<h2 align=\"center\">Developers</h2> 1.<a href =\"mail to : nathtek136@gmail.com\">Mr.Tek Nath Acharya</a><br>" +
                "         2.<a href =\"mail to : karmadorgey@gmail.com\">Mr.Karma Dorji</a><br>" +
                "        3.<a href =\"mail to : deepikasbr@gmail.com\">Ms.Deepika Suberi</a><br>" +
                "        4.<a href =\"mail to : kartse100@gmail.com\"> Mr.Karma Tshewang</a>\n" +
                "<h2 align=\"center\">Special Thanks</h2> 1.<a href =\"mail to : parshuram.cst@rub.edu.bt\">Mr.Parshuram Dhungyel</a><br>" +
                "        2.<a href =\"mail to : hari.kafley@itechnologies.bt\">Mr.Hari Kafley</a><br>" +
                "        3.<a href =\"mail to : 0215518.cst@rub.edu.bt\">Mr.Khusant Chhetri</a></body></html>";

//        String myData = "Hello World! This tutorial is to show demo of displaying text with justify alignment in WebView.";

        webView.loadData(String.format(htmlText,myData),"text/html","utf-8");
    }
}
