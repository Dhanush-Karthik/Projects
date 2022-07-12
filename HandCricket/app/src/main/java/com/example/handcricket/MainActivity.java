package com.example.handcricket;

import android.media.MediaPlayer;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    // Create a VideoView variable, a MediaPlayer variable, and an int to hold the current
    // video position.
    private VideoView videoBG;
    MediaPlayer mMediaPlayer;
    int mCurrentVideoPosition;
    int des;
    static int res;
    static int min=1;
    static int max = 10;
    static int n=(int)(Math.random()*(max-min+1)+min);
    static int bat=0,bowl=1,score=0,target=0;
    public void fadeIn(View view){
        TextView display=(TextView) findViewById(R.id.displayView);
        TextView you=(TextView) findViewById(R.id.youView);
        TextView oppo=(TextView) findViewById(R.id.oppoView);
        TextView scoreBoard = (TextView) findViewById(R.id.scoreView);
        TextView targetBoard = (TextView) findViewById(R.id.targetView);
        TextView info = (TextView) findViewById(R.id.tossId);
        ImageView placeHolder1 = (ImageView) findViewById(R.id.imageView1);
        ImageView placeHolder2 = (ImageView) findViewById(R.id.imageView2);
        ImageView handBoard = (ImageView) findViewById(R.id.handBoard);
        ImageView numberBoard = (ImageView) findViewById(R.id.numberBoard);
        ImageView buttonOne = (ImageView) findViewById(R.id.buttonOne);
        ImageView buttonTwo = (ImageView) findViewById(R.id.buttonTwo);
        ImageView buttonThree = (ImageView) findViewById(R.id.buttonThree);
        ImageView buttonFour = (ImageView) findViewById(R.id.buttonFour);
        ImageView buttonFive = (ImageView) findViewById(R.id.buttonFive);
        ImageView buttonSix = (ImageView) findViewById(R.id.buttonSix);
        ImageView okay = (ImageView) findViewById(R.id.okayButton);
        scoreBoard.animate().alpha(1).setDuration(1000);
        targetBoard.animate().alpha(1).setDuration(1000);
        display.animate().alpha(1).setDuration(1000);
        you.animate().alpha(1).setDuration(1000);
        oppo.animate().alpha(1).setDuration(1000);
        handBoard.animate().alpha(1).setDuration(1000);
        numberBoard.animate().alpha(1).setDuration(1000);
        buttonOne.animate().alpha(1).setDuration(1000);
        buttonTwo.animate().alpha(1).setDuration(1000);
        buttonThree.animate().alpha(1).setDuration(1000);
        buttonFour.animate().alpha(1).setDuration(1000);
        buttonFive.animate().alpha(1).setDuration(1000);
        buttonSix.animate().alpha(1).setDuration(1000);
        placeHolder1.animate().alpha(1).setDuration(1000);
        placeHolder2.animate().alpha(1).setDuration(1000);
        okay.animate().alpha(0).setDuration(1000);
        info.animate().alpha(0).setDuration(1000);
        placeHolder1.setImageResource(android.R.color.transparent);
        placeHolder2.setImageResource(android.R.color.transparent);

    }

    public void fadeOut(){
        TextView scoreBoard = (TextView) findViewById(R.id.scoreView);
        TextView targetBoard = (TextView) findViewById(R.id.targetView);
        TextView display=(TextView) findViewById(R.id.displayView);
        TextView you=(TextView) findViewById(R.id.youView);
        TextView oppo=(TextView) findViewById(R.id.oppoView);
        ImageView placeHolder1 = (ImageView) findViewById(R.id.imageView1);
        ImageView placeHolder2 = (ImageView) findViewById(R.id.imageView2);
        ImageView handBoard = (ImageView) findViewById(R.id.handBoard);
        ImageView numberBoard = (ImageView) findViewById(R.id.numberBoard);
        ImageView buttonOne = (ImageView) findViewById(R.id.buttonOne);
        ImageView buttonTwo = (ImageView) findViewById(R.id.buttonTwo);
        ImageView buttonThree = (ImageView) findViewById(R.id.buttonThree);
        ImageView buttonFour = (ImageView) findViewById(R.id.buttonFour);
        ImageView buttonFive = (ImageView) findViewById(R.id.buttonFive);
        ImageView buttonSix = (ImageView) findViewById(R.id.buttonSix);
        scoreBoard.animate().alpha(0).setDuration(1500);
        targetBoard.animate().alpha(0).setDuration(1500);
        display.animate().alpha(0).setDuration(1500);
        you.animate().alpha(0).setDuration(1500);
        oppo.animate().alpha(0).setDuration(1500);
        handBoard.animate().alpha(0).setDuration(1500);
        numberBoard.animate().alpha(0).setDuration(1500);
        buttonOne.animate().alpha(0).setDuration(1500);
        buttonTwo.animate().alpha(0).setDuration(1500);
        buttonThree.animate().alpha(0).setDuration(1500);
        buttonFour.animate().alpha(0).setDuration(1500);
        buttonFive.animate().alpha(0).setDuration(1500);
        buttonSix.animate().alpha(0).setDuration(1500);
        placeHolder1.animate().alpha(0).setDuration(1500);
        placeHolder2.animate().alpha(0).setDuration(1500);

    }
    public void click(View view){
        //before start
        TextView gameName = (TextView) findViewById(R.id.gameName);
        ImageView playButton = (ImageView) findViewById(R.id.playButton);
        ImageView gameLogo = (ImageView) findViewById(R.id.gameLogo);
        gameName.animate().alpha(0).setDuration(1000);
        playButton.animate().alpha(0).setDuration(1000);
        gameLogo.animate().alpha(0).setDuration(1000);
        //after Start
        TextView tossTime = (TextView) findViewById(R.id.tossId);
        ImageView headsButton = (ImageView) findViewById(R.id.headsButton);
        ImageView tailsButton = (ImageView) findViewById(R.id.tailsButton);
        tossTime.animate().alpha(1).setDuration(1000);
        headsButton.animate().alpha(1).setDuration(1000);
        tailsButton.animate().alpha(1).setDuration(1000);
        playButton.setVisibility(View.INVISIBLE);
        headsButton.setVisibility(View.VISIBLE);
        tailsButton.setVisibility(View.VISIBLE);
    }
    public  void heads(View view){
        TextView tossTime = (TextView) findViewById(R.id.tossId);
        ImageView headsButton = (ImageView) findViewById(R.id.headsButton);
        ImageView tailsButton = (ImageView) findViewById(R.id.tailsButton);
        tossTime.animate().alpha(0).setDuration(10);
        headsButton.animate().alpha(0).setDuration(1000);
        tailsButton.animate().alpha(0).setDuration(1000);
        headsButton.setVisibility(View.INVISIBLE);
        tailsButton.setVisibility(View.INVISIBLE);
        if(n%2==1){
            res=1;
            TextView result=(TextView) findViewById(R.id.tossResult);
            result.setText("You Won the Toss!!!");
            result.setVisibility(View.VISIBLE);
            ImageView batButton = (ImageView) findViewById(R.id.batButton);
            ImageView bowlButton = (ImageView) findViewById(R.id.bowlButton);
            batButton.setVisibility(View.VISIBLE);
            bowlButton.setVisibility(View.VISIBLE);
        }
        else{
            res=0;
            TextView result=(TextView) findViewById(R.id.tossResult);
            result.setText("You Lost the Toss!!!");
            result.setVisibility(View.VISIBLE);
            if (n % 2 == 0) {
                des = 1;
                TextView display = (TextView) findViewById(R.id.displayView);
                display.setVisibility(View.VISIBLE);
                display.setText(" You are asked to Bat first!!!");
                firstBat();
            } else {
                des = 3;
                TextView display = (TextView) findViewById(R.id.displayView);
                display.setVisibility(View.VISIBLE);
                display.setText("You are asked to bowl first!!!");
                firstBowl();

            }
        }
    }
    public  void tails(View view) {
        TextView tossTime = (TextView) findViewById(R.id.tossId);
        ImageView headsButton = (ImageView) findViewById(R.id.headsButton);
        ImageView tailsButton = (ImageView) findViewById(R.id.tailsButton);
        tossTime.animate().alpha(0).setDuration(10);
        headsButton.animate().alpha(0).setDuration(1000);
        tailsButton.animate().alpha(0).setDuration(1000);
        headsButton.setVisibility(View.INVISIBLE);
        tailsButton.setVisibility(View.INVISIBLE);
        if (n%2==1) {
            res = 1;
            TextView result = (TextView) findViewById(R.id.tossResult);
            result.setText("You Won the Toss!!!");
            result.setVisibility(View.VISIBLE);
            ImageView batButton = (ImageView) findViewById(R.id.batButton);
            ImageView bowlButton = (ImageView) findViewById(R.id.bowlButton);
            batButton.setVisibility(View.VISIBLE);
            bowlButton.setVisibility(View.VISIBLE);
        } else {
            res = 0;
            TextView result = (TextView) findViewById(R.id.tossResult);
            result.setText("You Lost the Toss!!!");
            result.animate().alpha(1).setDuration(1000);
            result.setVisibility(View.VISIBLE);
            if (n % 2 == 0) {
                des = 1;
                TextView display = (TextView) findViewById(R.id.displayView);
                display.setVisibility(View.VISIBLE);
                display.setText(" You are asked to Bat first!!!");
                firstBat();
            } else {
                des = 3;
                TextView display = (TextView) findViewById(R.id.displayView);
                display.setVisibility(View.VISIBLE);
                display.setText("You are asked to bowl first!!!");
                firstBowl();
            }
        }
    }
    public void firstBat(){
        TextView display=(TextView) findViewById(R.id.displayView);
        display.setVisibility(View.VISIBLE);
        TextView you=(TextView) findViewById(R.id.youView);
        TextView oppo=(TextView) findViewById(R.id.oppoView);
        TextView result=(TextView) findViewById(R.id.tossResult);
        ImageView batButton = (ImageView) findViewById(R.id.batButton);
        ImageView bowlButton = (ImageView) findViewById(R.id.bowlButton);
        ImageView handBoard = (ImageView) findViewById(R.id.handBoard);
        ImageView numberBoard = (ImageView) findViewById(R.id.numberBoard);
        ImageView buttonOne = (ImageView) findViewById(R.id.buttonOne);
        ImageView buttonTwo = (ImageView) findViewById(R.id.buttonTwo);
        ImageView buttonThree = (ImageView) findViewById(R.id.buttonThree);
        ImageView buttonFour = (ImageView) findViewById(R.id.buttonFour);
        ImageView buttonFive = (ImageView) findViewById(R.id.buttonFive);
        ImageView buttonSix = (ImageView) findViewById(R.id.buttonSix);
        result.animate().alpha(0).setDuration(10);
        batButton.animate().alpha(0).setDuration(800);
        bowlButton.animate().alpha(0).setDuration(800);
        you.animate().alpha(1).setDuration(1000);
        oppo.animate().alpha(1).setDuration(1000);
        handBoard.animate().alpha(1).setDuration(1000);
        numberBoard.animate().alpha(1).setDuration(1000);
        buttonOne.animate().alpha(1).setDuration(1000);
        buttonTwo.animate().alpha(1).setDuration(1000);
        buttonThree.animate().alpha(1).setDuration(1000);
        buttonFour.animate().alpha(1).setDuration(1000);
        buttonFive.animate().alpha(1).setDuration(1000);
        buttonSix.animate().alpha(1).setDuration(1000);
        batButton.setVisibility(View.INVISIBLE);
        bowlButton.setVisibility(View.INVISIBLE);
    }
    public void firstBowl(){
        TextView display=(TextView) findViewById(R.id.displayView);
        display.setVisibility(View.VISIBLE);
        TextView result=(TextView) findViewById(R.id.tossResult);
        TextView you=(TextView) findViewById(R.id.youView);
        TextView oppo=(TextView) findViewById(R.id.oppoView);
        ImageView batButton = (ImageView) findViewById(R.id.batButton);
        ImageView bowlButton = (ImageView) findViewById(R.id.bowlButton);
        ImageView handBoard = (ImageView) findViewById(R.id.handBoard);
        ImageView numberBoard = (ImageView) findViewById(R.id.numberBoard);
        ImageView buttonOne = (ImageView) findViewById(R.id.buttonOne);
        ImageView buttonTwo = (ImageView) findViewById(R.id.buttonTwo);
        ImageView buttonThree = (ImageView) findViewById(R.id.buttonThree);
        ImageView buttonFour = (ImageView) findViewById(R.id.buttonFour);
        ImageView buttonFive = (ImageView) findViewById(R.id.buttonFive);
        ImageView buttonSix = (ImageView) findViewById(R.id.buttonSix);
        result.animate().alpha(0).setDuration(80);
        batButton.animate().alpha(0).setDuration(800);
        bowlButton.animate().alpha(0).setDuration(800);
        result.animate().alpha(0).setDuration(5000);
        you.animate().alpha(1).setDuration(1000);
        oppo.animate().alpha(1).setDuration(1000);
        handBoard.animate().alpha(1).setDuration(1000);
        numberBoard.animate().alpha(1).setDuration(1000);
        buttonOne.animate().alpha(1).setDuration(1000);
        buttonTwo.animate().alpha(1).setDuration(1000);
        buttonThree.animate().alpha(1).setDuration(1000);
        buttonFour.animate().alpha(1).setDuration(1000);
        buttonFive.animate().alpha(1).setDuration(1000);
        buttonSix.animate().alpha(1).setDuration(1000);
        batButton.setVisibility(View.INVISIBLE);
        bowlButton.setVisibility(View.INVISIBLE);
    }


    public void firstBat(View view){
        TextView display=(TextView) findViewById(R.id.displayView);
        display.setVisibility(View.VISIBLE);
        display.setText(" You chose to Bat first!!!");
        TextView you=(TextView) findViewById(R.id.youView);
        TextView oppo=(TextView) findViewById(R.id.oppoView);
        TextView result=(TextView) findViewById(R.id.tossResult);
        ImageView batButton = (ImageView) findViewById(R.id.batButton);
        ImageView bowlButton = (ImageView) findViewById(R.id.bowlButton);
        ImageView handBoard = (ImageView) findViewById(R.id.handBoard);
        ImageView numberBoard = (ImageView) findViewById(R.id.numberBoard);
        ImageView buttonOne = (ImageView) findViewById(R.id.buttonOne);
        ImageView buttonTwo = (ImageView) findViewById(R.id.buttonTwo);
        ImageView buttonThree = (ImageView) findViewById(R.id.buttonThree);
        ImageView buttonFour = (ImageView) findViewById(R.id.buttonFour);
        ImageView buttonFive = (ImageView) findViewById(R.id.buttonFive);
        ImageView buttonSix = (ImageView) findViewById(R.id.buttonSix);
        result.animate().alpha(0).setDuration(80);
        batButton.animate().alpha(0).setDuration(800);
        bowlButton.animate().alpha(0).setDuration(800);
        result.animate().alpha(0).setDuration(800);
        you.animate().alpha(1).setDuration(1000);
        oppo.animate().alpha(1).setDuration(1000);
        handBoard.animate().alpha(1).setDuration(1000);
        numberBoard.animate().alpha(1).setDuration(1000);
        buttonOne.animate().alpha(1).setDuration(1000);
        buttonTwo.animate().alpha(1).setDuration(1000);
        buttonThree.animate().alpha(1).setDuration(1000);
        buttonFour.animate().alpha(1).setDuration(1000);
        buttonFive.animate().alpha(1).setDuration(1000);
        buttonSix.animate().alpha(1).setDuration(1000);
        batButton.setVisibility(View.INVISIBLE);
        bowlButton.setVisibility(View.INVISIBLE);
        des=1;
    }
    public void firstBowl(View view){
        TextView display=(TextView) findViewById(R.id.displayView);
        display.setVisibility(View.VISIBLE);
        display.setText(" You chose to Bowl first!!!");
        TextView you=(TextView) findViewById(R.id.youView);
        TextView oppo=(TextView) findViewById(R.id.oppoView);
        TextView result=(TextView) findViewById(R.id.tossResult);
        ImageView batButton = (ImageView) findViewById(R.id.batButton);
        ImageView bowlButton = (ImageView) findViewById(R.id.bowlButton);
        ImageView handBoard = (ImageView) findViewById(R.id.handBoard);
        ImageView numberBoard = (ImageView) findViewById(R.id.numberBoard);
        ImageView buttonOne = (ImageView) findViewById(R.id.buttonOne);
        ImageView buttonTwo = (ImageView) findViewById(R.id.buttonTwo);
        ImageView buttonThree = (ImageView) findViewById(R.id.buttonThree);
        ImageView buttonFour = (ImageView) findViewById(R.id.buttonFour);
        ImageView buttonFive = (ImageView) findViewById(R.id.buttonFive);
        ImageView buttonSix = (ImageView) findViewById(R.id.buttonSix);
        result.animate().alpha(0).setDuration(80);
        batButton.animate().alpha(0).setDuration(800);
        bowlButton.animate().alpha(0).setDuration(800);
        result.animate().alpha(0).setDuration(800);
        you.animate().alpha(1).setDuration(1000);
        oppo.animate().alpha(1).setDuration(1000);
        handBoard.animate().alpha(1).setDuration(1000);
        numberBoard.animate().alpha(1).setDuration(1000);
        buttonOne.animate().alpha(1).setDuration(1000);
        buttonTwo.animate().alpha(1).setDuration(1000);
        buttonThree.animate().alpha(1).setDuration(1000);
        buttonFour.animate().alpha(1).setDuration(1000);
        buttonFive.animate().alpha(1).setDuration(1000);
        buttonSix.animate().alpha(1).setDuration(1000);
        batButton.setVisibility(View.INVISIBLE);
        bowlButton.setVisibility(View.INVISIBLE);
        des=3;
    }
    public void onClick(View view){
        int ma=6,mi=1;
        ImageView counter = (ImageView) view;
        ImageView placeHolder1 = (ImageView) findViewById(R.id.imageView1);
        ImageView placeHolder2 = (ImageView) findViewById(R.id.imageView2);
        TextView scoreBoard = (TextView) findViewById(R.id.scoreView);
        TextView targetBoard = (TextView) findViewById(R.id.targetView);
        int tappedCounter= Integer.parseInt(counter.getTag().toString());
        switch (des) {
            case 1:
                switch (tappedCounter) {
                    case 1:
                        bat = 1;
                        score += 1;
                        placeHolder1.setImageResource(R.drawable.one_finger);
                        break;
                    case 2:
                        bat = 2;
                        score += 2;
                        placeHolder1.setImageResource(R.drawable.two_finger);
                        break;
                    case 3:
                        bat = 3;
                        score += 3;
                        placeHolder1.setImageResource(R.drawable.three_finger);
                        break;
                    case 4:
                        bat = 4;
                        score += 4;
                        placeHolder1.setImageResource(R.drawable.four_finger);
                        break;
                    case 5:
                        bat = 5;
                        score += 5;
                        placeHolder1.setImageResource(R.drawable.five_finger);
                        break;
                    case 6:
                        bat = 6;
                        score += 6;
                        placeHolder1.setImageResource(R.drawable.six_finger);
                        break;
                }
                bowl = (int) (Math.random() * (ma - mi + 1) + mi);
                switch (bowl) {
                    case 1:
                        placeHolder2.setImageResource(R.drawable.one_finger);
                        break;
                    case 2:
                        placeHolder2.setImageResource(R.drawable.two_finger);
                        break;
                    case 3:
                        placeHolder2.setImageResource(R.drawable.three_finger);
                        break;
                    case 4:
                        placeHolder2.setImageResource(R.drawable.four_finger);
                        break;
                    case 5:
                        placeHolder2.setImageResource(R.drawable.five_finger);
                        break;
                    case 6:
                        placeHolder2.setImageResource(R.drawable.six_finger);
                        break;
                }
                if (bat == bowl) {
                    TextView info = (TextView) findViewById(R.id.tossId);
                    ImageView okay = (ImageView) findViewById(R.id.okayButton);
                    fadeOut();
                    score -= bat;
                    info.setText(" You are Out!!! \n    Score: " + score);
                    info.animate().alpha(1).setDuration(3000);
                    info.setVisibility(View.VISIBLE);
                    okay.animate().alpha(1).setDuration(3000);
                    okay.setVisibility(View.VISIBLE);
                    target = score + 1;
                    des = 2;
                    score = 0;
                }
                scoreBoard.setText("Score:" + score);
                scoreBoard.setVisibility(View.VISIBLE);
                break;

            case 2:
                scoreBoard.setText("Score: " + score);
                targetBoard.setText("Target: " + target);
                TextView display = (TextView) findViewById(R.id.displayView);
                display.setVisibility(View.VISIBLE);
                display.setText(" You are defending now");
                switch (tappedCounter) {
                    case 1:
                        bowl = 1;
                        placeHolder1.setImageResource(R.drawable.one_finger);
                        break;
                    case 2:
                        bowl = 2;

                        placeHolder1.setImageResource(R.drawable.two_finger);
                        break;
                    case 3:
                        bowl = 3;

                        placeHolder1.setImageResource(R.drawable.three_finger);
                        break;
                    case 4:
                        bowl = 4;

                        placeHolder1.setImageResource(R.drawable.four_finger);
                        break;
                    case 5:
                        bowl = 5;

                        placeHolder1.setImageResource(R.drawable.five_finger);
                        break;
                    case 6:
                        bowl = 6;

                        placeHolder1.setImageResource(R.drawable.six_finger);
                        break;
                }
                bat = (int) (Math.random() * (ma - mi + 1) + mi);
                switch (bat) {
                    case 1:
                        placeHolder2.setImageResource(R.drawable.one_finger);
                        score += 1;
                        target -= 1;
                        break;
                    case 2:
                        placeHolder2.setImageResource(R.drawable.two_finger);
                        score += 2;
                        target -= 2;
                        break;
                    case 3:
                        placeHolder2.setImageResource(R.drawable.three_finger);
                        score += 3;
                        target -= 3;
                        break;
                    case 4:
                        placeHolder2.setImageResource(R.drawable.four_finger);
                        score += 4;
                        target -= 4;
                        break;
                    case 5:
                        placeHolder2.setImageResource(R.drawable.five_finger);
                        score += 5;
                        target -= 5;
                        break;
                    case 6:
                        placeHolder2.setImageResource(R.drawable.six_finger);
                        score += 6;
                        target -= 6;
                        break;
                }

                scoreBoard.setText("Score: " + score);
                targetBoard.setText("Target: " + target);
                targetBoard.setVisibility(View.VISIBLE);

                if(target<=score){
                    fadeOut();
                    placeHolder1.animate().alpha(0).setDuration(1000);
                    placeHolder2.animate().alpha(0).setDuration(1000);
                    TextView info = (TextView) findViewById(R.id.tossId);
                    info.animate().alpha(1).setDuration(1000);
                    ImageView again = (ImageView) findViewById(R.id.leave);
                    again.animate().alpha(1).setDuration(1000);
                    again.setVisibility(View.VISIBLE);
                    info.setText("  You lost the \n     match!!!");
                    info.setVisibility(View.VISIBLE);
                    des=0;
                }
                if(bat==bowl){
                    fadeOut();
                    placeHolder1.animate().alpha(0).setDuration(1000);
                    placeHolder2.animate().alpha(0).setDuration(1000);
                    TextView displayView = (TextView) findViewById(R.id.gameName);
                    TextView info = (TextView) findViewById(R.id.tossId);
                    displayView.setText("Oppo is Out!!!");
                    displayView.animate().alpha(1).setDuration(1000);
                    displayView.setVisibility(View.VISIBLE);
                    if(target>score){
                        info.animate().alpha(1).setDuration(5000);
                        info.setText("   You won the \n      match!!!");
                        ImageView again = (ImageView) findViewById(R.id.leave);
                        again.animate().alpha(1).setDuration(1000);
                        again.setVisibility(View.VISIBLE);
                        info.setVisibility(View.VISIBLE);
                        des=0;
                    }
                    if(target==score){
                        info.animate().alpha(1).setDuration(5000);
                        ImageView again = (ImageView) findViewById(R.id.leave);
                        again.animate().alpha(1).setDuration(1000);
                        again.setVisibility(View.VISIBLE);
                        info.setText("  Match draw!!!");
                        info.setVisibility(View.VISIBLE);
                        des=0;
                    }
                }
                break;
            case 3:
                switch (tappedCounter) {
                    case 1:
                        bowl = 1;
                        placeHolder1.setImageResource(R.drawable.one_finger);
                        break;
                    case 2:
                        bowl = 2;

                        placeHolder1.setImageResource(R.drawable.two_finger);
                        break;
                    case 3:
                        bowl = 3;

                        placeHolder1.setImageResource(R.drawable.three_finger);
                        break;
                    case 4:
                        bowl = 4;

                        placeHolder1.setImageResource(R.drawable.four_finger);
                        break;
                    case 5:
                        bowl = 5;

                        placeHolder1.setImageResource(R.drawable.five_finger);
                        break;
                    case 6:
                        bowl = 6;

                        placeHolder1.setImageResource(R.drawable.six_finger);
                        break;
                }
                bat = (int) (Math.random() * (ma - mi + 1) + mi);
                switch (bat) {
                    case 1:
                        placeHolder2.setImageResource(R.drawable.one_finger);
                        score += 1;
                        target -= 1;
                        break;
                    case 2:
                        placeHolder2.setImageResource(R.drawable.two_finger);
                        score += 2;
                        target -= 2;
                        break;
                    case 3:
                        placeHolder2.setImageResource(R.drawable.three_finger);
                        score += 3;
                        target -= 3;
                        break;
                    case 4:
                        placeHolder2.setImageResource(R.drawable.four_finger);
                        score += 4;
                        target -= 4;
                        break;
                    case 5:
                        placeHolder2.setImageResource(R.drawable.five_finger);
                        score += 5;
                        target -= 5;
                        break;
                    case 6:
                        placeHolder2.setImageResource(R.drawable.six_finger);
                        score += 6;
                        target -= 6;
                        break;
                }
                if (bat == bowl) {
                    TextView info = (TextView) findViewById(R.id.tossId);
                    ImageView okay = (ImageView) findViewById(R.id.okayButton);
                    fadeOut();
                    score -= bat;
                    info.setText(" oppo is Out!!! \n    Score: " + score);
                    info.animate().alpha(1).setDuration(3000);
                    info.setVisibility(View.VISIBLE);
                    okay.animate().alpha(1).setDuration(3000);
                    okay.setVisibility(View.VISIBLE);
                    target = score + 1;
                    des = 4;
                    score = 0;
                }
                scoreBoard.setText("Score:" + score);
                scoreBoard.setVisibility(View.VISIBLE);
                break;
            case 4:
                switch (tappedCounter) {
                    case 1:
                        bat = 1;
                        score += 1;
                        placeHolder1.setImageResource(R.drawable.one_finger);
                        break;
                    case 2:
                        bat = 2;
                        score += 2;
                        placeHolder1.setImageResource(R.drawable.two_finger);
                        break;
                    case 3:
                        bat = 3;
                        score += 3;
                        placeHolder1.setImageResource(R.drawable.three_finger);
                        break;
                    case 4:
                        bat = 4;
                        score += 4;
                        placeHolder1.setImageResource(R.drawable.four_finger);
                        break;
                    case 5:
                        bat = 5;
                        score += 5;
                        placeHolder1.setImageResource(R.drawable.five_finger);
                        break;
                    case 6:
                        bat = 6;
                        score += 6;
                        placeHolder1.setImageResource(R.drawable.six_finger);
                        break;
                }
                bowl = (int) (Math.random() * (ma - mi + 1) + mi);
                switch (bowl) {
                    case 1:
                        placeHolder2.setImageResource(R.drawable.one_finger);
                        break;
                    case 2:
                        placeHolder2.setImageResource(R.drawable.two_finger);
                        break;
                    case 3:
                        placeHolder2.setImageResource(R.drawable.three_finger);
                        break;
                    case 4:
                        placeHolder2.setImageResource(R.drawable.four_finger);
                        break;
                    case 5:
                        placeHolder2.setImageResource(R.drawable.five_finger);
                        break;
                    case 6:
                        placeHolder2.setImageResource(R.drawable.six_finger);
                        break;
                }
                TextView show = (TextView) findViewById(R.id.displayView);
                show.setVisibility(View.VISIBLE);
                show.setText(" You are chasing now");
                scoreBoard.setText("Score: " + score);
                targetBoard.setText("Target: " + target);
                targetBoard.setVisibility(View.VISIBLE);

                if(target<=score){
                    fadeOut();
                    placeHolder1.animate().alpha(0).setDuration(1000);
                    placeHolder2.animate().alpha(0).setDuration(1000);
                    TextView info = (TextView) findViewById(R.id.tossId);
                    info.animate().alpha(1).setDuration(1000);
                    info.setText("  You won the \n     match!!!");
                    ImageView again = (ImageView) findViewById(R.id.leave);
                    again.animate().alpha(1).setDuration(1000);
                    again.setVisibility(View.VISIBLE);
                    info.setVisibility(View.VISIBLE);
                    des=0;
                }
                if(bat==bowl){
                    fadeOut();
                    placeHolder1.animate().alpha(0).setDuration(1000);
                    placeHolder2.animate().alpha(0).setDuration(1000);
                    TextView displayView = (TextView) findViewById(R.id.gameName);
                    TextView info = (TextView) findViewById(R.id.tossId);
                    displayView.setText("you are Out!!!");
                    displayView.animate().alpha(1).setDuration(1000);
                    displayView.setVisibility(View.VISIBLE);
                    if(target>score){
                        info.animate().alpha(1).setDuration(5000);
                        info.setText("   You lost the \n      match!!!");
                        ImageView again = (ImageView) findViewById(R.id.leave);
                        again.animate().alpha(1).setDuration(1000);
                        again.setVisibility(View.VISIBLE);
                        info.setVisibility(View.VISIBLE);
                        des=0;
                    }
                    if(target==score){
                        info.animate().alpha(1).setDuration(5000);
                        ImageView again = (ImageView) findViewById(R.id.leave);
                        again.animate().alpha(1).setDuration(1000);
                        again.setVisibility(View.VISIBLE);
                        info.setText("  Match draw!!!");
                        info.setVisibility(View.VISIBLE);
                        des=0;
                    }
                }
                break;
        }


    }
    public void leave(View view){
        finish();
        System.exit(0);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        // Hook up the VideoView to our UI.
        videoBG = (VideoView) findViewById(R.id.videoView);

        // Build your video Uri
        Uri uri = Uri.parse("android.resource://" // First start with this,
                + getPackageName() // then retrieve your package name,
                + "/" // add a slash,
                + R.raw.game_bg); // and then finally add your video resource. Make sure it is stored
        // in the raw folder.

        // Set the new Uri to our VideoView
        videoBG.setVideoURI(uri);
        // Start the VideoView
        videoBG.start();

        // Set an OnPreparedListener for our VideoView. For more information about VideoViews,
        // check out the Android Docs: https://developer.android.com/reference/android/widget/VideoView.html
        videoBG.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mMediaPlayer = mediaPlayer;
                // We want our video to play over and over so we set looping to true.
                mMediaPlayer.setLooping(true);
                // We then seek to the current posistion if it has been set and play the video.
                if (mCurrentVideoPosition != 0) {
                    mMediaPlayer.seekTo(mCurrentVideoPosition);
                    mMediaPlayer.start();
                }
            }
        });
    }

    /*================================ Important Section! ================================
    We must override onPause(), onResume(), and onDestroy() to properly handle our
    VideoView.
     */

    @Override
    protected void onPause() {
        super.onPause();
        // Capture the current video position and pause the video.
        mCurrentVideoPosition = mMediaPlayer.getCurrentPosition();
        videoBG.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Restart the video when resuming the Activity
        videoBG.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // When the Activity is destroyed, release our MediaPlayer and set it to null.
        mMediaPlayer.release();
        mMediaPlayer = null;
    }

}