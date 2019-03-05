package com.example.aoge.game_findanimal_daniel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class congActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cong);

        final Intent intent = getIntent();
        long s = intent.getLongExtra("start", 0);

        long endDate = new Date().getTime();
        int time = (int)(endDate-s)/1000;
        ((TextView) findViewById(R.id.tv_show2)).setText("Your time is:"+String.valueOf(time)+"s");

        Button btn5 = (Button)findViewById(R.id.btn_again1);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(congActivity.this , GameActivity.class);
                congActivity.this.finish();
                startActivity(i);
            }
        });
        Button btn6 = (Button)findViewById(R.id.btn_exit1);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
//                android.os.Process.killProcess(android.os.Process.myPid());
//                System.exit(0);
            }
        });
    }
}
