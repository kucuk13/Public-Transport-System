package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.database.Cursor;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogActivity extends AppCompatActivity {

    DatabaseHelper mydb;
    EditText Mail, password;
    TextView id;
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        getSupportActionBar().setTitle("Giriş Yap");
        mydb = new DatabaseHelper(this);
        buttonLogin = findViewById(R.id.buttonLogin);
        Mail = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);

        buttonLogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = mydb.getAllUsers();
                        if (res.getCount() == 0){
                            return;
                        }
                        //StringBuffer stringBuffer = new StringBuffer("Bulunmadı. Tekrar Dene.");
                        boolean isNotFind = true;
                        while(res.moveToNext()){
                            if (res.getString(2).equals(Mail.getText().toString())){
                                if (res.getString(3).equals(password.getText().toString())){
                                    Toast.makeText(LogActivity.this, "Merhaba " + res.getString(1) + "!", Toast.LENGTH_LONG).show();
                                    isNotFind = false;
                                    new Person(res.getString(0),
                                            res.getString(1),
                                            res.getString(2),
                                            res.getString(3),
                                            res.getString(4));
                                    Intent intent = new Intent(LogActivity.this, Main2Activity.class);
                                    startActivity(intent);
                                    break;
                                }
                            }
                            /*stringBuffer.append("ID: " + res.getString(0) + "\n");
                            stringBuffer.append("User: " + res.getString(1) + "\n");
                            stringBuffer.append("Mail: " + res.getString(2) + "\n");
                            stringBuffer.append("Password: " + res.getString(3) + "\n");
                            stringBuffer.append("Tel: " + res.getString(4) + "\n");
                            AlertDialog.Builder builder = new AlertDialog.Builder(LogActivity.this);
                            builder.setCancelable(true);
                            builder.setTitle("Data");
                            builder.setMessage(stringBuffer.toString());
                            builder.show();*/
                        }
                        if (isNotFind){
                            Toast.makeText(LogActivity.this, "Tekrar Deneyin!", Toast.LENGTH_LONG).show();
                        }


                    }
                }
        );

    }
}
