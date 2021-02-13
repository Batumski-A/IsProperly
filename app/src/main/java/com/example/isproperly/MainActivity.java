package com.example.isproperly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.NavigableMap;

public class MainActivity extends AppCompatActivity {
    EditText NeedCheck;
    Button Submit;
    TextView Bool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NeedCheck = findViewById(R.id.mCheckThis);
        Submit = findViewById(R.id.mSubmit);
        Bool = findViewById(R.id.mGetBool);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String GetText = NeedCheck.getText().toString();
                if(isProperly(GetText)){
                    Bool.setText("TRUE");
                }else{
                    Bool.setText("FALSE");
                }


            }
        });



    }
    public Boolean isProperly(String sequence){
        int NALL = 0;
        for(int i=0;i<sequence.length();i++){
            if(sequence.charAt(i) == ("()").charAt(0)){
                NALL += 1;
            }else if(sequence.charAt(i) == "()".charAt(1) && NALL > 0){
                NALL -= 1;
            }else if(sequence.charAt(i) == "()".charAt(1) && NALL == 0){
                NALL -= 1;
                break;
            }else {
                continue;
            }
        }
        if(NALL == 0){
            return true;
        }else{
            return false;
        }
    }
}
