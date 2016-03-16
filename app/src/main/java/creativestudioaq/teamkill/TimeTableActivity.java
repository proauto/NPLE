package creativestudioaq.teamkill;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;

import com.etsy.android.grid.StaggeredGridView;

import java.util.ArrayList;

public class TimeTableActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        Button back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final ArrayList<TimeList> _lists = new ArrayList<>();

        TimeList sample;

        for(int i = 0 ; i<54 ; i++){
            sample = new TimeList(0, "");
            _lists.add(sample);
        }

        final TimeListAdapter adapter = new TimeListAdapter(this, R.layout.time_sub_listview, _lists);

        final StaggeredGridView gridView = (StaggeredGridView)findViewById(R.id.time_grid_view);

        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //view.setBackgroundResource(R.drawable.main_check);
                //_lists.get(position).getphoto().setBackgroundResource(R.drawable.main_check);
                /*
                String mDrawableName = "main_check";
                int resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
                _lists.get(position).setphoto(resID);*/
                ImageView img_view = (ImageView)view.findViewById(R.id.phototime);

                if( (position >= 0 && position <= 5)|| (position%6 == 0) ){

                }
                else{
                    if(_lists.get(position).status==0){
                        _lists.get(position).status=1;
                        img_view.setBackgroundColor(Color.argb(255, 228, 90, 87));
                    }
                    else{
                        _lists.get(position).status=0;
                        img_view.setBackgroundResource(R.drawable.main0);
                    }
                }
            }
        });
    }
}
