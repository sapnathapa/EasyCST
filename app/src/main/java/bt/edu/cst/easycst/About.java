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
        String myData =
                "<html>" +
                        "<body style=\"text-align:justify\">" +
                        "<center><h3>Version : 1.0</h3></center>"+
                        "<center><h3>About the App</h3></center>"+
                "EasyCST, a platform where the student can have easy access to the service like maintenance."+
                "\t User has a privilege to track ones attendance and own editable timetable."+
                "\t User can provide feedback and suggestion for the betterment of the college."+
                       "</body>" +
                        "<center><h3>Developers</h3></center>"+
                        "<center><h3>Special Thanks</h3></center>"+
                "</html>";




//        String myData = "Hello World! This tutorial is to show demo of displaying text with justify alignment in WebView.";

        webView.loadData(String.format(htmlText,myData),"text/html","utf-8");
    }
}
