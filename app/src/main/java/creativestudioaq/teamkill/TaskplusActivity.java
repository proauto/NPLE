package creativestudioaq.teamkill;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by honggyu on 2016-02-14.
 */
public class TaskplusActivity extends BaseActivity implements View.OnClickListener {

    EditText taskcontent;

    private int mYear;
    private int mMonth;
    private int mDay;

    phpInsert task_insert;
    phpDown task;


    static final int DATE_DIALOG_ID = 1;
    int taskid=1;
    String tasktext="";
    int taskcheck=1;
    String mac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taskplus);


        WifiManager mWifiManger = (WifiManager)getSystemService(WIFI_SERVICE);
        WifiInfo mWifiInfo = mWifiManger.getConnectionInfo();
        mac = mWifiInfo.getMacAddress();

        Button datedialog = (Button) findViewById(R.id.datedialog);
        Button back = (Button) findViewById(R.id.back);
        Button save = (Button)findViewById(R.id.save);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);


        taskcontent = (EditText) findViewById(R.id.taskcontent);


        datedialog.setOnClickListener(this);
        back.setOnClickListener(this);
        save.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DATE);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.datedialog:

                showDialog(DATE_DIALOG_ID);


                break;

            case R.id.back:
                finish();
                break;
            case R.id.save:

                int i = 31;
                task_insert = new phpInsert();

                task_insert.execute("http://teamkill.dothome.co.kr/app/dataget_task.php?ctrl=1&teamid="+i+"&tasktext="+taskcontent.getText().toString());




                finish();

                break;

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

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;

                }
            };

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, mDateSetListener, mYear, mMonth, mDay);
        }
        return null;
    }


}
