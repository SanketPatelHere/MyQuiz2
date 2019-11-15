package com.example.myquiz2;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MathsActivity extends AppCompatActivity {
    TextView tvQuestionNo, tvQuestion;
    EditText etanswer;
    Button btnsubmit;

    int countQuestion = 1;
    String checkboxes;
    String range;
    String totalQuestion;
    int totalQuestion1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths);
        try {

            checkboxes = getIntent().getExtras().getString("checkboxes");
            range = getIntent().getExtras().getString("range");
            totalQuestion = getIntent().getExtras().getString("totalQuestion");
            Toast.makeText(MathsActivity.this, "Maths : Checkboxes = " + checkboxes + "\nselect name = " + range + "\nTotal Questions = " + totalQuestion, Toast.LENGTH_SHORT).show();
            totalQuestion1 = Integer.parseInt(totalQuestion);
            Log.i("My totalQuestion1",totalQuestion1+"");

            tvQuestionNo = (TextView) findViewById(R.id.tvQuestionNo);
            tvQuestion = (TextView) findViewById(R.id.tvQuestion);
            etanswer = (EditText) findViewById(R.id.etanswer);
            btnsubmit = (Button) findViewById(R.id.btnsubmit);

            tvQuestionNo.setText("Question " + countQuestion + " out of " + totalQuestion);
            updateQuestion();
            btnsubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MathsActivity.this, "countQuestion = "+countQuestion, Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            });

        }
        catch (Exception e)
        {
            Log.e("My Exception",e+"");
        }
    }
    public void updateQuestion()
    {
        if(countQuestion>=totalQuestion1)  //1>=5  => 5>=5
        {
            countQuestion = 0;
        }
        if(checkboxes.equalsIgnoreCase("[Addition]"))
        {
            tvQuestion.setText("100 "+"+"+" 200");
        }
        else if(checkboxes.equalsIgnoreCase("[Substraction]"))
        {
            tvQuestion.setText("100 "+"-"+" 200");
        }
        else if(checkboxes.equalsIgnoreCase("[Multiplication]"))
        {
            tvQuestion.setText("100 "+"*"+" 200");
        }
        else if(checkboxes.equalsIgnoreCase("[Division]"))
        {
            tvQuestion.setText("100 "+"/"+" 200");
        }
        countQuestion++;
    }
}
