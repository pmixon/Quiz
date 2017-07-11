package com.phillipmixon.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswers(View view) {
        displayScoreSummary(calculateScoreSummary());
    }

    public String calculateScoreSummary() {
        String scoreSummary = "";

        if (isQuestionOneCorrect()) {
            scoreSummary = scoreSummary + "\nQuestion 1: Correct";
        } else {
            scoreSummary = scoreSummary + "\nQuestion 1: Incorrect";
        }

        if (isQuestionTwoCorrect()) {
            scoreSummary = scoreSummary + "\nQuestion 2: Correct";
        } else {
            scoreSummary = scoreSummary + "\nQuestion 2: Incorrect";
        }

        return scoreSummary;
    }

    public boolean isQuestionOneCorrect() {
        CheckBox questionOneYellowAnswer = (CheckBox) findViewById(R.id.question_one_yellow_answer);
        CheckBox questionOneWhiteAnswer = (CheckBox) findViewById(R.id.question_one_white_answer);

        if ((questionOneYellowAnswer.isChecked()) && questionOneWhiteAnswer.isChecked()) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isQuestionTwoCorrect() {
        EditText questionTwoEditText = (EditText) findViewById(R.id.question_two_edit_text);

        Log.d()
        Log.d(,questionTwoEditText.getText().toString());
        if (questionTwoEditText.getText().toString() == "Black") {
            return true;
        } else {
            return false;
        }

    }

    public void displayScoreSummary(String summary) {
        TextView scoreSummary = (TextView) findViewById(R.id.total_score_text_view);
        scoreSummary.setText(summary);
    }
}
