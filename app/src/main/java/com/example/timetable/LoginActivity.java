package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Message;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class LoginActivity extends AppCompatActivity {

    public static String GroupNumber = "";

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //открытие или создание бд
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);

        SharedPreferences sharedPrefs = getSharedPreferences("sp_name", MODE_PRIVATE);
        SharedPreferences.Editor ed;
        if(!sharedPrefs.contains("initialized")){
            db.execSQL("CREATE TABLE IF NOT EXISTS groups (id INTEGER, number INTEGER)");
            db.execSQL("INSERT INTO groups VALUES(1, 4335)");
            db.execSQL("INSERT INTO groups VALUES(2, 4235)");

            //создание таблиц
            db.execSQL("CREATE TABLE IF NOT EXISTS pary (id INTEGER,   dayOfWeek INTEGER, isChet INTEGER, startTime TEXT, endTime TEXT, naim TEXT,prepod TEXT ,group_num INTEGER, tipZan TETX, audit TEXT, zdanie TETX)");
            db.execSQL("delete from pary");
            StringBuilder queryText = new StringBuilder().append("INSERT INTO pary VALUES(1,  1, 1, '8:00', '9:30', 'РМП', 'Гимадиев', 4335 ,'лабораторная работа', '204', '7')");
            db.execSQL(queryText.toString());
            queryText = new StringBuilder().append("INSERT INTO pary VALUES(2, 1, 1, '11:20', '15:00', 'РПМ', 'Лоповок', 4335,'лабораторная работа', '204', '7')");
            db.execSQL(queryText.toString());
            queryText = new StringBuilder().append("INSERT INTO pary VALUES(3,  1, 0, '8:00', '9:30', 'ПиТПМ', 'Лоповок', 4335,'практическая работа', '204', '7')");
            db.execSQL(queryText.toString());
            queryText = new StringBuilder().append("INSERT INTO pary VALUES(4, 1, 0, '9:40', '11:20', 'Философия', 'Сиразеева', 4335,'лекция', '204', '7')");
            db.execSQL(queryText.toString());

            queryText = new StringBuilder().append("INSERT INTO pary VALUES(5,  1, 1, '8:00', '9:30', 'ОАиП', 'Мингалиев', 4235 ,'практическая работа', '204', '7')");
            db.execSQL(queryText.toString());
            queryText = new StringBuilder().append("INSERT INTO pary VALUES(6, 1, 1, '11:20', '12:50', 'ЭВМ', 'Смирнов', 4235,'практическая работа', '204', '7')");
            db.execSQL(queryText.toString());
            queryText = new StringBuilder().append("INSERT INTO pary VALUES(7,  1, 0, '8:00', '9:30', 'Дискретная математика', 'Лоповок', 4235,'практическая работа', '204', '7')");
            db.execSQL(queryText.toString());
            queryText = new StringBuilder().append("INSERT INTO pary VALUES(8, 1, 0, '9:40', '11:20', 'ОАиП', 'Мингалиев', 4235,'лекция', '204', '7')");
            db.execSQL(queryText.toString());

            db.execSQL("CREATE TABLE IF NOT EXISTS news (id INTEGER, title TEXT, descrip TEXT, href TEXT/*, image BLOB*/)");
            //если хочешь изображение - переделай
            /*File fi = new File("myfile.jpg");
            byte[] fileContent = Files.readAllBytes(fi.toPath());
            try {
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
                String userInput;
                while ((userInput = stdIn.readLine()) != null) {
                    System.out.println(userInput);
                }
            } catch(IOException ie) {
                ie.printStackTrace();
            }*/
            queryText = new StringBuilder().append("INSERT INTO news VALUES(1, 'Путин и Ктулху  Интернетчики задали российскому президенту очень странные вопросы', 'В Рунете праздник. Впервые в истории российского интернета президент России решил встретиться с аудиторией Сети и ответить на ее вопросы.', 'https://lenta.ru/articles/2006/07/04/cthulhu/')");
            db.execSQL(queryText.toString());
            queryText = new StringBuilder().append("INSERT INTO news VALUES(2, 'Аниме новинки осеннего аниме сезона 2021 года, на которые стоит обратить внимание', 'Прошло уже больше середины октября? Тогда самое время рассказать про новинки аниме осени этого года. Стоит отметить, что сезон получился плодотворным, так что...', 'https://zen.yandex.ru/media/lazyanime/anime-novinki-osennego-anime-sezona-2021-goda-na-kotorye-stoit-obratit-vnimanie-61718cd282b45839b4f62066?&')");
            db.execSQL(queryText.toString());
            queryText = new StringBuilder().append("INSERT INTO news VALUES(3, 'Чем Россия сбила свой спутник?', 'Вообще-то сбить спутник это очень сложно. А с земли сбить спутник на высоте 500 км почти невозможно. Россия это сделала. Но чем? Минобороны, естественн…', 'https://zen.yandex.ru/media/sdelanounas.ru/chem-rossiia-sbila-svoi-sputnik-61945da19a7cd450cc4715d7')");
            db.execSQL(queryText.toString());
            queryText = new StringBuilder().append("INSERT INTO news VALUES(4, 'Косплей на модном приговоре - обзор нарядов от топовых стилистов', 'Модный приговор- программа, которую знают практически все. Но, какого же было мое удивление, когда я увидела на \"главном подиуме страны\" косплееров... ', 'https://zen.yandex.ru/media/dino_loves_tea/kosplei-na-modnom-prigovore-mnenie-kospleera-i-obzor-nariadov-ot-topovyh-stilistov-6192892debd3945421a59197?&')");
            db.execSQL(queryText.toString());

            ed = sharedPrefs.edit();

            //Indicate that the default shared prefs have been set
            ed.putBoolean("initialized", true);

            //Set some default shared pref
            ed.putString("myDefString", "wowsaBowsa");

            ed.commit();
        }
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