package appewtc.masterung.learnsqlite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private Button signInButton, singUpButton;
    private MyManage myManage;
    private EditText userEditText, passwordEditText;
    private String userString, passwordString, passwordTrueString, nameString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myManage = new MyManage(MainActivity.this);

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

        //For singIn
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAuthen();
            }
        });


    }   // buttonController

    private void checkAuthen() {

        //Get Value
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        if (userString.equals("") || passwordString.equals("")) {
            //Have Space
            myDialog(getResources().getString(R.string.haveSpace));
        } else if (checkUser()) {
            //User False
            myDialog(getResources().getString(R.string.userFalse));
        } else if (!passwordString.equals(passwordTrueString)) {
            //Password False
            myDialog(getResources().getString(R.string.passFalse));
        } else {
            //Welcome
            myDialog("Welcome " + nameString);
            startActivity(new Intent(MainActivity.this, MyListView.class));
        }


    }   // checkAuthen

    private boolean checkUser() {

        boolean result = true;  // true ==> User False

        try {

            //Connected SQLite
            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                    MODE_PRIVATE, null);
            //Create Cursor ==> คือการเอาฐานข้อมูลไป ไปประมวลผลใน แรม
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM userTABLE", null);
            cursor.moveToFirst();

            for (int i=0;i<cursor.getCount();i++) {

                if (userString.equals(cursor.getString(2))) {
                    result = false;
                    passwordTrueString = cursor.getString(3);
                    nameString = cursor.getString(1);
                }

                cursor.moveToNext();
            }   // for


        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    private void myDialog(String string) {
        Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
    }

    //คือการผูกความสัมพันระหว่าง ตัวแปร และ ออปเจค บน Activity
    private void bindWidget() {

        signInButton = (Button) findViewById(R.id.button);
        singUpButton = (Button) findViewById(R.id.button2);
        userEditText = (EditText) findViewById(R.id.editText4);
        passwordEditText = (EditText) findViewById(R.id.editText5);

    }

}   // Main Class
