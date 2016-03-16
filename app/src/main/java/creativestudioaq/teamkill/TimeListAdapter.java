package creativestudioaq.teamkill;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by honggyu on 2016-02-13.
 */
public class TimeListAdapter extends BaseAdapter {

    private LayoutInflater _inflater;
    private static ArrayList<TimeList> _lists;
    private int _layout;
    private static Context m_ctx;


    TimeListAdapter(Context context, int layout, ArrayList<TimeList> lists) {
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
        TimeListViewHolder holder;
        if (convertView == null) {
            convertView = _inflater.inflate(_layout, parent, false);

            holder = new TimeListViewHolder();
            holder.photo = (ImageView) convertView.findViewById(R.id.phototime);
            holder.name = (TextView) convertView.findViewById(R.id.nametime);
            convertView.setTag(holder);
        } else {
            holder = (TimeListViewHolder) convertView.getTag();
        }

        TimeList list = _lists.get(position);

        int photo = list.getphoto();
        String name = list.getname();
        String resName1 = "@drawable/main" + photo;
        int resID1 = m_ctx.getResources().getIdentifier(resName1, "drawable", m_ctx.getPackageName());
        Drawable drawID = m_ctx.getResources().getDrawable(resID1);

        if(position == 0){
            holder.photo.setVisibility(View.INVISIBLE);
        }
        else if(position == 1){
            holder.photo.setBackground(drawID);
            holder.name.setText("MON");
        }
        else if(position == 2){
            holder.photo.setBackground(drawID);
            holder.name.setText("TUE");
        }
        else if(position == 3){
            holder.photo.setBackground(drawID);
            holder.name.setText("WED");
        }
        else if(position == 4){
            holder.photo.setBackground(drawID);
            holder.name.setText("THU");
        }
        else if(position == 5){
            holder.photo.setBackground(drawID);
            holder.name.setText("FRI");
        }
        else{
            if(position%6 == 0){
                holder.photo.setBackground(drawID);
                holder.name.setText(""+ (position/6) + "class");
            }
            else{
                holder.photo.setBackground(drawID);
                holder.name.setText(name);
            }
        }

        return convertView;
    }


}
