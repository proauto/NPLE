package creativestudioaq.teamkill;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by honggyu on 2016-02-14.
 */

public class TaskActivity extends BaseActivity {
    ArrayList<TaskinList> _lists1 = new ArrayList<>();
    ArrayList<TaskininList> _lists2 = new ArrayList<>();
    TaskinAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        ListView taskinlist = (ListView) findViewById(R.id.taskinlist);
        Button back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        TaskininList sample = new TaskininList(2, "7pm까지 피피티 1~3p 완성");
        _lists2.add(sample);
        sample = new TaskininList(1, "파트 2까지 자료조사 완성전송");
        _lists2.add(sample);
        sample = new TaskininList(2, "금요일 3교시에 과학관");
        _lists2.add(sample);



        TaskinList sample1 = new TaskinList(1, "강동원", _lists2);
        _lists1.add(sample1);
        sample1 = new TaskinList(2, "정우성", _lists2);
        _lists1.add(sample1);
        sample1 = new TaskinList(3, "원빈", _lists2);
        _lists1.add(sample1);



        adapter = new TaskinAdapter(this, R.layout.sub_taskinlist, _lists1, taskinlist);


        taskinlist.setAdapter(adapter);



    }


}
