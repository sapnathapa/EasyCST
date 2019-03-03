package bt.edu.cst.easycst;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import org.w3c.dom.Text;

public class About extends AppCompatActivity {

    WebSettings webSettings;
//    private GoogleApiClient client;
    private WebView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        view = (WebView) this.findViewById(R.id.webView);
        view.getSettings().setJavaScriptEnabled(true);
        view.getSettings().setDomStorageEnabled(true);
        view.setWebViewClient(new MyBrowser());
        view.loadUrl("myData");
        view.setWebChromeClient(new WebChromeClient()); // adding js alert



        String htmlText = " %s ";

        String myData = "<html><body style=\"text-align:justify\"><h2 align=\"center\">" +
                "Version : 1.0</h2>" +
                "<h2 align=\"center\">About App</h2>EasyCST is a platform for the student to have easy access to various services such as registration for maintenance services, " +
                "self-tracking, adding and editing timetable and providing feedback for college.<br><br>" +
                "<h2 align=\"center\">Developers </h2><a href =\"mailto: nathtek136@gmail.com\" style = \"text-decoration:none\">Tek Nath Acharya</a><br>" +
                "         <a href =\"mailto: karmadorgey@gmail.com\" style = \"text-decoration:none\">Karma Dorji</a><br>" +
                "        <a href =\"mailto: deepikasbr@gmail.com\" style = \"text-decoration:none\">Deepika Suberi</a><br>" +
                "        <a href =\"mailto: kartse100@gmail.com\" style = \"text-decoration:none\"> Karma Tshewang</a><br>" +
                "        <a href =\"mailto: parshuram.cst@rub.edu.bt\" style = \"text-decoration:none\">Parshuram Dhungyel (Guide)</body></html>";


        view.loadData(String.format(htmlText,myData),"text/html","utf-8");
    }
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.startsWith("tel:") || url.startsWith("sms:") || url.startsWith("smsto:") || url.startsWith("mailto:") || url.startsWith("mms:") || url.startsWith("mmsto:")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
//                return true;
            }
            else {
                view.loadUrl(url);
            }
            return true;
        }
    }
   /* public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && view.canGoBack()) {
            view.goBack(); //method goback()
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }*/
}
