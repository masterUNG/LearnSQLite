package appewtc.masterung.learnsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MyListView extends AppCompatActivity {

    //Explicit
    ListView listView;  // นี่คือการประกาศอย่างย่อ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_view);

        //Bind Widget
        listView = (ListView) findViewById(R.id.livUser);

        createListView();

    }   // Main Method

    private void createListView() {



    }   // createListView

}   // Main Class
