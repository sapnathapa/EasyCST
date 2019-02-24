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
        String myData = "<html><body style=\"text-align:justify\">The E-Learning Application is a Mobile based application. " +
                "The main objective of this application is to make it interactive \n" +
                "\t    and its ease of use.The main features that the application provides are \n" +
                "\t    online tutorial and tests, once the registered people select their \n" +
                "\t\tinterested subjects. " +
                "This helps to establish incremental learning process. Users can also \n" +
                "\tdiscuss an issue/topic by posting messages in the discussion forum.\n" +
                "              Along with this they can also take real time simulations of the most \n" +
                "\t\t\twidely known competitive exams.</body></html>";
//        String myData = "Hello World! This tutorial is to show demo of displaying text with justify alignment in WebView.";

        webView.loadData(String.format(htmlText,myData),"text/html","utf-8");
    }
}
