package creativestudioaq.teamkill;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by honggyu on 2016-02-13.
 */
public class TaskAdapter extends BaseAdapter {

    private LayoutInflater _inflater;
    private static ArrayList<TaskList> _lists;
    private int _layout;
    private static Context m_ctx;


    TaskAdapter(Context context, int layout, ArrayList<TaskList> lists) {
        _inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        _lists = lists;
        _layout = layout;
        m_ctx = context;


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
        SecondListViewHolder holder;
        if (convertView == null) {
            convertView = _inflater.inflate(_layout, parent, false);

            holder = new SecondListViewHolder();
            holder.content = (TextView) convertView.findViewById(R.id.content);
            holder.button = (Button) convertView.findViewById(R.id.button);
            convertView.setTag(holder);
        } else {
            holder = (SecondListViewHolder) convertView.getTag();
        }

        TaskList list = _lists.get(position);

        int button = list.getbutton();

        String resName1 = "@drawable/take_btn_" + button;
        int resID1 = m_ctx.getResources().getIdentifier(resName1, "drawable", m_ctx.getPackageName());
        Drawable drawID = m_ctx.getResources().getDrawable(resID1);


        holder.button.setBackground(drawID);
        holder.content.setText(list.getcontent());


        return convertView;
    }


}
