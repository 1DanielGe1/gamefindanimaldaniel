package com.example.aoge.game_findanimal_daniel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class failActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fail);
        Button btn3 = (Button)findViewById(R.id.btn_again);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(failActivity.this , GameActivity.class);
                failActivity.this.finish();
                startActivity(i);
            }
        });
        Button btn4 = (Button)findViewById(R.id.btn_exit);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
//                android.os.Process.killProcess(android.os.Process.myPid());
//                System.exit(0);
            }
        });
    }
}
