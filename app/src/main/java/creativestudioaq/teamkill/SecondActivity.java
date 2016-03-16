package creativestudioaq.teamkill;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by honggyu on 2016-02-13.
 */

public class SecondActivity extends BaseActivity implements View.OnClickListener {

    ArrayList<TaskList> _lists1;
    ArrayList<TaskList> _lists2;
    TaskAdapter adapter1;
    ImportantAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ListView importancelist = (ListView) findViewById(R.id.importantlist);
        ListView tasklist = (ListView) findViewById(R.id.tasklist);

        Button importantbutton = (Button) findViewById(R.id.importantplus);
        Button taskbutton = (Button) findViewById(R.id.taskplus);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button back = (Button) findViewById(R.id.back);
        Button invite = (Button)findViewById(R.id.invite);


        _lists1 = new ArrayList<>();
        _lists2 = new ArrayList<>();


        TaskList sample = new TaskList(2, "7pm까지 피피티 1~3p 완성");
        _lists2.add(sample);
        sample = new TaskList(2, "파트 2까지 자료조사 완성 전송");
        _lists2.add(sample);
        sample = new TaskList(1, "금요일 3교시에 과학관");
        _lists2.add(sample);
        sample = new TaskList(2, "7pm까지 피피티 1~3p 완성");
        _lists1.add(sample);
        sample = new TaskList(2, "파트 2까지 자료조사 완성 전송");
        _lists1.add(sample);
        sample = new TaskList(1, "금요일 3교시에 과학관");
        _lists1.add(sample);
        sample = new TaskList(1, "파트 1까지 자료조사 완성 전송");
        _lists1.add(sample);
        sample = new TaskList(2, "파트 3까지 자료조사 완성 전송");
        _lists1.add(sample);


        adapter1 = new TaskAdapter(this, R.layout.sub_tasklistview, _lists1);
        adapter2 = new ImportantAdapter(this, R.layout.sub_secondlistview, _lists2);
        tasklist.setAdapter(adapter1);
        importancelist.setAdapter(adapter2);
        importancelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast toast = Toast.makeText(SecondActivity.this, "1-" + position, Toast.LENGTH_LONG);
                toast.show();
            }
        });
        tasklist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast toast = Toast.makeText(SecondActivity.this, "2-" + position, Toast.LENGTH_LONG);
                toast.show();
            }
        });

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        importantbutton.setOnClickListener(this);
        taskbutton.setOnClickListener(this);
        back.setOnClickListener(this);
        invite.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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
            case R.id.importantplus:
                Intent intent4 = new Intent(this, ImportantPlusActivity.class);
                startActivity(intent4);
                break;
            case R.id.taskplus:
                Intent intent5 = new Intent(this, TaskplusActivity.class);
                startActivity(intent5);
                break;
            case R.id.back:
                finish();
                break;
            case R.id.invite:
                Intent msg = new Intent(Intent.ACTION_SEND);
                msg.addCategory(Intent.CATEGORY_DEFAULT);
                msg.putExtra(Intent.EXTRA_TEXT, "[NPLE]추노팀플로 초대합니다.\n"+
                        "nple.us/n/a2a0p8U5Y880R\n"+
                        "FROM 박건희");
                msg.setType("text/plain");
                startActivity(Intent.createChooser(msg, "공유"));
                break;
        }
    }

}
