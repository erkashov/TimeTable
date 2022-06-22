package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Message;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public static String GroupNumber = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //открытие или создание бд
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        //создание таблиц

        findViewById(R.id.loginBtn).setOnClickListener(v ->
                {
                    EditText editText = findViewById(R.id.groupNum);
                    GroupNumber = editText.getText().toString();
                    if(GroupNumber.equals("")){
                        //уведомление
                        Toast toast = Toast.makeText(this, "Введите номер группы", Toast.LENGTH_LONG);
                        toast.show();
                        return;
                    }
                    db.execSQL("CREATE TABLE IF NOT EXISTS groups (id INTEGER, number INTEGER)");
                    //db.execSQL("INSERT INTO groups VALUES(1, 4335)");

                    String queryText = new StringBuilder().append("SELECT * FROM groups Where number").append(" = ").append(GroupNumber).toString();

                    //берем значения
                    Cursor query = db.rawQuery(queryText, null);
                    if (query.moveToFirst()) {
                        startActivity(new Intent(this, MainActivity2.class));
                    } else {
                        Toast toast = Toast.makeText(this, "Группы с таким номером не существует", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
        );
    }
}