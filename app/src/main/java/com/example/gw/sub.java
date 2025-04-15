package com.example.gw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class sub extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.sub);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.sub), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //intent 받음.
        Intent myCallerIntent=getIntent();
        Bundle myBundle=myCallerIntent.getExtras();

        //main 에서 보낸거 받음.

        if (myBundle != null) {
            String name = myBundle.getString("name");
            String major = myBundle.getString("major");
            String id = myBundle.getString("id");

            String message = "Student Info: " + name + ", " + major + ", " + id;
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "No data received!", Toast.LENGTH_LONG).show();
        }


        //get text
        EditText in_url=findViewById(R.id.insert_url);
        String url=in_url.getText().toString();

        EditText in_phone=findViewById(R.id.insert_phone);
        String phone=in_phone.getText().toString();




        //뒤로가서 종료
        Button go_back = findViewById(R.id.btn_goback);

        go_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){

                Bundle send_bundle=new Bundle();

                send_bundle.putString("url",url);
                send_bundle.putString("phone",phone);

                //보냄.
                Intent result_intent=new Intent(sub.this,MainActivity.class);
                result_intent.putExtras(send_bundle);
                // Return the result to MainActivity
                setResult(RESULT_OK, result_intent);




              finish();
            }







        });





//    finish();


    }
}
