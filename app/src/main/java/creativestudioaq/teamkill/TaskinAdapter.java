package creativestudioaq.teamkill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by honggyu on 2016-02-13.
 */
public class TaskinAdapter extends BaseAdapter {

    private LayoutInflater _inflater;
    private static ArrayList<TaskinList> _lists;
    private int _layout;
    private static Context m_ctx;
    private ListView _listview;


    TaskinAdapter(Context context, int layout, ArrayList<TaskinList> lists, ListView listView) {
        _inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        _lists = lists;
        _layout = layout;
        m_ctx = context;
        _listview = listView;


    }

    @Override
    public int getCount() {
        return _lists.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TaskinViewHolder holder;
        if (convertView == null) {
            convertView = _inflater.inflate(_layout, parent, false);

            holder = new TaskinViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.number = (TextView) convertView.findViewById(R.id.number);
            holder.taskinin = (ListView) convertView.findViewById(R.id.ininlist);
            convertView.setTag(holder);
        } else {
            holder = (TaskinViewHolder) convertView.getTag();
        }

        TaskinList list = _lists.get(position);

        int number = list.getnumber();
        String name = list.getname();
        ArrayList<TaskininList> taskin = list.gettasklists();

        holder.name.setText(name);
        holder.number.setText("" + number);
        holder.taskinin.setAdapter(new TaskininAdapter(m_ctx, R.layout.sub_inininadapter, taskin));
        holder.taskinin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                _listview.requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        holder.taskinin.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(m_ctx, "1-" + position, Toast.LENGTH_LONG);
                toast.show();
            }
        });

        return convertView;
    }


}
