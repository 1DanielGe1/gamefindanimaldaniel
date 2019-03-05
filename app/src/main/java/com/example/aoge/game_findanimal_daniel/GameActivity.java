package com.example.aoge.game_findanimal_daniel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;

public class GameActivity extends AppCompatActivity {
    public String animalArray[] = {"bear","bird","cat","elephant","fish", "flower","giraffe","honey","house","hippo","kangaroo","leopard","lion","pig","rhinoceros","sun","tiger","wolf"};
    public int pictureArray[] = {R.drawable.bear,R.drawable.bird,R.drawable.cat,R.drawable.elephant,R.drawable.fish,R.drawable.flower,R.drawable.giraffe,R.drawable.honey,R.drawable.house,R.drawable.hypo,R.drawable.kangaroo,R.drawable.leo
            ,R.drawable.lion,R.drawable.pig,R.drawable.rhino,R.drawable.sun,R.drawable.tiger,R.drawable.wolf};
    public int imageArray[] = {R.id.imageView,R.id.imageView2,R.id.imageView3,R.id.imageView4};
    public int correct;
    public int score = 0;
    public int errorCount = 3;
    public ImageView iv;
    public long startDate;
    ImageView imv1;
    ImageView imv2;
    ImageView imv3;
    ImageView imv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        init();
    }
    public void init(){
        startDate = new Date().getTime();
        refresh();
        imv1 = (ImageView)findViewById(R.id.imageView);
        imv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(correct == 0){
                    score++;
//                    imv1.setImageDrawable(getResources().getDrawable(R.drawable.correct));
                    scoreShow(score);
                }else{
                    imv1.setImageDrawable(getResources().getDrawable(R.drawable.wrong));
                    errorCount--;
                    ((TextView) findViewById(R.id.tv_wrong)).setText(String.valueOf(errorCount));
                    if(errorCount == 0) {
                        enoughError();
                    }
                }

            }
        });
        imv2 = (ImageView)findViewById(R.id.imageView2);
        imv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(correct == 1){
                    score++;
//                    imv2.setImageDrawable(getResources().getDrawable(R.drawable.correct));
                    scoreShow(score);
                }else{
                    imv2.setImageDrawable(getResources().getDrawable(R.drawable.wrong));
                    errorCount--;
                    ((TextView) findViewById(R.id.tv_wrong)).setText(String.valueOf(errorCount));
                    if(errorCount == 0) {
                        enoughError();
                    }
                }

            }
        });
        imv3 = (ImageView)findViewById(R.id.imageView3);
        imv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(correct == 2){
                    score++;
//                    imv3.setImageDrawable(getResources().getDrawable(R.drawable.correct));
                    scoreShow(score);
                }else{
                    imv3.setImageDrawable(getResources().getDrawable(R.drawable.wrong));
                    errorCount--;
                    ((TextView) findViewById(R.id.tv_wrong)).setText(String.valueOf(errorCount));
                    if(errorCount == 0) {
                        enoughError();
                    }
                }

            }
        });
        imv4 = (ImageView)findViewById(R.id.imageView4);
        imv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(correct == 3){
                    score++;
//                    imv4.setImageDrawable(getResources().getDrawable(R.drawable.correct));
                    scoreShow(score);
                }else{
                    imv4.setImageDrawable(getResources().getDrawable(R.drawable.wrong));
                    errorCount--;
                    ((TextView) findViewById(R.id.tv_wrong)).setText(String.valueOf(errorCount));
                    if(errorCount == 0) {
                        enoughError();
                    }
                }
            }
        });
    }

    public void scoreShow(int s){

        ((TextView) findViewById(R.id.tv_score)).setText(String.valueOf(s));

        refresh();
    }

    public void refresh(){
        if(score == 10){
            enoughScore();
        }else{
                boolean[] bool = new boolean[20];
                //       System.out.println(bool[1]);
                int mark ;
                int random = (int)(0+Math.random()*(18));
                bool[random] = true;
                int random1 = (int)(0+Math.random()*(4));
                correct = random1;
                iv = (ImageView) findViewById(imageArray[random1]);
                iv.setImageDrawable(getResources().getDrawable(pictureArray[random]));

                for(int i = 0;i<3;i++){
                    do{
                        mark = (int)(0+Math.random()*(18));
                    }while(bool[mark]);
                    bool[mark] = true;
                    iv = (ImageView) findViewById(imageArray[(random1+1+i)%4]);
                    iv.setImageDrawable(getResources().getDrawable(pictureArray[mark]));
                }
                ((TextView) findViewById(R.id.tv_show)).setText(animalArray[random]);
            }
    }

    public void enoughScore()
    {
        Intent i = new Intent(GameActivity.this , congActivity.class);
        i.putExtra("start",startDate);
        GameActivity.this.finish();
        startActivity(i);
    }
    public void enoughError() {
        Intent i = new Intent(GameActivity.this , failActivity.class);
//        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        GameActivity.this.finish();
        startActivity(i);
    }
}
