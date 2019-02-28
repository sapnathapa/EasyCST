package bt.edu.cst.easycst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Help extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

//        String[] list = {"About Company", "Home Page", "Contact"};
//
//        Adapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
//
//        ListView listView = (ListView) findViewById(R.id.listId);
//
//        listView.setAdapter((ListAdapter) adapter);
//
//        listView.setOnItemClickListener(
//
//                new AdapterView.OnItemClickListener() {
//
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        String listPosition = String.valueOf(parent.getItemAtPosition(position));
//                        /*after clicking the first row of the list show the following info :
//                        NAME: Some name
//                        ADDRESS: Somewhere
//                         */
//                    }
//                }
//        );


    }
}
