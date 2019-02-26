package bt.edu.cst.easycst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import org.w3c.dom.Text;

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
        TextView tv = (TextView)findViewById(R.id.text);
        tv.setMovementMethod(LinkMovementMethod.getInstance());
//      webView.setData(LinkMovementMethod.getInstance());
        String htmlText = " %s ";

        String myData = "<html><body style=\"text-align:justify\"><h2 align=\"center\">Version : 1.0</h2><h2 align=\"center\">About App</h2>EasyCST is a platform for the student to have easy access to various services such as " +
                "registration for maintenance services,self-tracking,adding and editing timetable and providing feedback for college" +
                "<h2 align=\"center\">Developers</h2> 1.<a href =\"mailto : nathtek136@gmail.com\" style = \"text-decoration:none\">Mr.Tek Nath Acharya</a><br>" +
                "         2.<a href =\"mailto : karmadorgey@gmail.com\" style = \"text-decoration:none\">Mr.Karma Dorji</a><br>" +
                "        3.<a href =\"mailto : deepikasbr@gmail.com\" style = \"text-decoration:none\">Ms.Deepika Suberi</a><br>" +
                "        4.<a href =\"mailto : kartse100@gmail.com\" style = \"text-decoration:none\"> Mr.Karma Tshewang</a>\n" +
                "<h2 align=\"center\">Special Thanks</h2> 1.<a href =\"mailto : parshuram.cst@rub.edu.bt\" style = \"text-decoration:none\">Mr.Parshuram Dhungyel</a><br>" +
                "        2.<a href =\"mailto : hari.kafley@itechnologies.bt\" style = \"text-decoration:none\">Mr.Hari Kafley</a><br>" +
                "        3.<a href =\"mailto : 0215518.cst@rub.edu.bt\" style = \"text-decoration:none\">Mr.Khusant Chhetri</a></body></html>";


        webView.loadData(String.format(htmlText,myData),"text/html","utf-8");
    }
}
