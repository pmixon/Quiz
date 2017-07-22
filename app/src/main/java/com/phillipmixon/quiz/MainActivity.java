package com.phillipmixon.quiz;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean questionThreeCorrect;

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
        int totalScore = 0;

        if (isQuestionOneCorrect()) {
            scoreSummary = scoreSummary + "\nQuestion 1: Correct";
            totalScore++;
        } else {
            scoreSummary = scoreSummary + "\nQuestion 1: Incorrect";
        }

        if (isQuestionTwoCorrect()) {
            scoreSummary = scoreSummary + "\nQuestion 2: Correct";
            totalScore++;
        } else {
            scoreSummary = scoreSummary + "\nQuestion 2: Incorrect";
        }

        if (isQuestionThreeCorrect()) {
            scoreSummary = scoreSummary + "\nQuestion 3: Correct";
            totalScore++;
        } else {
            scoreSummary = scoreSummary + "\nQuestion 3: Incorrect";
        }

        if (isQuestionFourCorrect()) {
            scoreSummary = scoreSummary + "\nQuestion 4: Correct";
            totalScore++;
        } else {
            scoreSummary = scoreSummary + "\nQuestion 4: Incorrect";
        }

        toastTotalScore(totalScore);
        return scoreSummary;
    }

    public boolean isQuestionOneCorrect() {
        CheckBox questionOneYellowAnswer = (CheckBox) findViewById(R.id.question_one_yellow_answer);
        CheckBox questionOneWhiteAnswer = (CheckBox) findViewById(R.id.question_one_white_answer);
        CheckBox questionOneBrownAnswer = (CheckBox) findViewById(R.id.question_one_brown_answer);

        if ((questionOneYellowAnswer.isChecked()) && questionOneWhiteAnswer.isChecked() && !questionOneBrownAnswer.isChecked()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isQuestionTwoCorrect() {
        EditText questionTwoEditText = (EditText) findViewById(R.id.question_two_edit_text);

        if (questionTwoEditText.getText().toString().toLowerCase().equals("black")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isQuestionThreeCorrect() {
        return questionThreeCorrect;
    }

    public boolean isQuestionFourCorrect() {
        EditText questionFourEditText = (EditText) findViewById(R.id.question_four_edit_text);
        if (questionFourEditText.getText().toString().trim().toLowerCase().equals("brown")) {
            return true;
        } else {
            return false;
        }
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.question_three_answer_black:
                if (checked)
                    questionThreeCorrect = false;
                // Pirates are the best
                break;
            case R.id.question_three_answer_green:
                if (checked)
                    questionThreeCorrect = false;
                break;
            case R.id.question_three_answer_purple:
                if (checked)
                    questionThreeCorrect = true;
                break;
        }
    }

    public void displayScoreSummary(String summary) {
        TextView scoreSummary = (TextView) findViewById(R.id.total_score_text_view);
        scoreSummary.setText(summary);
    }

    public void toastTotalScore(int totalScore) {
        Context context = getApplicationContext();
        CharSequence text = "Your score is: " + totalScore;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}
