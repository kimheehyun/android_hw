package com.example.gw;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button login_btn=findViewById(R.id.btn_login);
        Button web=findViewById(R.id.web);
        Button phone=findViewById(R.id.contact);



        login_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public int hashCode() {
                return super.hashCode();
            }

            @Override
            public void onClick(View view){ //버튼 누르면 실행.

                //sub 실행.

                EditText in_name=findViewById(R.id.Name);//edit text연결
                String input_name= in_name.getText().toString();

                EditText in_major=findViewById(R.id.Major);
                String input_major=in_major.getText().toString();

                EditText in_id=findViewById(R.id.Id);
                String input_id=in_id.getText().toString();


                Bundle mybundle=new Bundle ();
                mybundle.putString("name",input_name);
                mybundle.putString("major",input_major);
                mybundle.putString("id",input_id);

                Intent intent=new Intent(MainActivity.this,sub.class);
                intent.putExtras(mybundle);
                startActivity(intent);





            }











        });






















    }
}