package creativestudioaq.teamkill;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.etsy.android.grid.StaggeredGridView;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    ArrayList<MainList> _lists;
    MainListAdapter adapter;
    phpInsert task_insert;
    String mac;
    phpDown task;
    int i=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button plusbutton = (Button) findViewById(R.id.plusbutton);

        WifiManager mWifiManger = (WifiManager)getSystemService(WIFI_SERVICE);
        WifiInfo mWifiInfo = mWifiManger.getConnectionInfo();
        mac = mWifiInfo.getMacAddress();


        _lists = new ArrayList<>();

        MainList sample = new MainList(1, "테크노경영");
        _lists.add(sample);
        sample = new MainList(2, "심리의 이해");
        _lists.add(sample);
        sample = new MainList(3, "연극");
        _lists.add(sample);
        sample = new MainList(4, "영어 스터디");
        _lists.add(sample);
        sample = new MainList(5, "C언어");
        _lists.add(sample);
        sample = new MainList(6, "개발 공부");
        _lists.add(sample);


        adapter = new MainListAdapter(this, R.layout.sub_listview, _lists);

        StaggeredGridView gridView = (StaggeredGridView) findViewById(R.id.grid_view);

        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);


            }
        });


        plusbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("팀플 만들기");

                final EditText name = new EditText(MainActivity.this);
                name.setSingleLine();
                int maxLength = 15;
                InputFilter[] fArray = new InputFilter[1];
                fArray[0] = new InputFilter.LengthFilter(maxLength);
                name.setFilters(fArray);
                alert.setView(name);

                alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String checkname = name.getText().toString();
                        checkname = checkname.replace("'", "''");

                        if (checkname.equals("")) {
                            Toast.makeText(MainActivity.this, "팀플 이름을 입력해주세요~!", Toast.LENGTH_SHORT).show();
                        } else {

                            MainList sample = new MainList(i, checkname);
                            _lists.add(sample);

                            adapter.notifyDataSetChanged();

                            task_insert = new phpInsert();

                            task_insert.execute("http://teamkill.dothome.co.kr/app/dataget_user.php?ctrl=1&userid_mac="+mac);

                            i++;
                            if (i >= 6)
                                i = 1;
                        }
                    }
                });


                alert.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.cancel();
                    }
                });

                alert.show();

            }
        });


    }



}
