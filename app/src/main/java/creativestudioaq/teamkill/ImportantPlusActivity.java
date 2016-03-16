package creativestudioaq.teamkill;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by honggyu on 2016-02-14.
 */
public class ImportantPlusActivity extends BaseActivity implements View.OnClickListener{

    EditText importantcontent;
    phpInsert task_insert;
    int teamId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_importantplus);

        importantcontent = (EditText) findViewById(R.id.importantcontent);
        Button save = (Button)findViewById(R.id.save);
        Button back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = importantcontent.getText().toString();
                task_insert = new phpInsert();
                task_insert.execute("http://teamkill.dothome.co.kr/app/dataget_notice1.php?ctrl=1&teamId=31&notice1Text="+content);
                finish();
            }
        });

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button1:
                Intent intent1 = new Intent(this, TimeTableActivity.class);
                startActivity(intent1);
                break;
            case R.id.button2:
                Intent intent2 = new Intent(this, TaskActivity.class);
                startActivity(intent2);
                break;
            case R.id.button3:
                Intent intent3 = new Intent(this, GraphActivity.class);
                startActivity(intent3);
                break;
        }
    }
}