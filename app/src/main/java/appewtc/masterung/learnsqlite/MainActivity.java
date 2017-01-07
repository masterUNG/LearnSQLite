package appewtc.masterung.learnsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private Button signInButton, singUpButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindWidget();

        buttonController();


    }   // Main Method นี่คือเมธอดหลัก

    private void buttonController() {
        //For signUp
        singUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignUp.class));
            }
        });


    }   // buttonController

    //คือการผูกความสัมพันระหว่าง ตัวแปร และ ออปเจค บน Activity
    private void bindWidget() {

        signInButton = (Button) findViewById(R.id.button);
        singUpButton = (Button) findViewById(R.id.button2);

    }

}   // Main Class
