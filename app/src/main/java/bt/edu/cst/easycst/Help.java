package bt.edu.cst.easycst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Help extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

         final String[] descriptionList = {"Company's Address....", "Home Address....", "Contact no...."};

        Adapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, descriptionList);

         final TextView textView =(TextView)findViewById(R.id.textviewA);

        ListView listView = (ListView) findViewById(R.id.listId);

        listView.setAdapter((ListAdapter) adapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
//                String listPosition = descriptionList[position];
//                Toast.makeText(MainActivity .this, listPosition , Toast.LENGTH_LONG).show();
//            }
//        });

//        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                textView.setText(descriptionList.getTag(position));
//            } } );

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
