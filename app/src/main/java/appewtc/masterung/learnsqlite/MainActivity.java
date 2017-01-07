package appewtc.masterung.learnsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private Button signInButton, singUpButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindWidget();


    }   // Main Method นี่คือเมธอดหลัก

    //คือการผูกความสัมพันระหว่าง ตัวแปร และ ออปเจค บน Activity
    private void bindWidget() {



    }

}   // Main Class
