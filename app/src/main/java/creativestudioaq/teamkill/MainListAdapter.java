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
public class MainListAdapter extends BaseAdapter {

    private LayoutInflater _inflater;
    private static ArrayList<MainList> _lists;
    private int _layout;
    private static Context m_ctx;


    MainListAdapter(Context context, int layout, ArrayList<MainList> lists) {
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
        MainListViewHolder holder;
        if (convertView == null) {
            convertView = _inflater.inflate(_layout, parent, false);

            holder = new MainListViewHolder();
            holder.photo = (ImageView) convertView.findViewById(R.id.photo);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(holder);
        } else {
            holder = (MainListViewHolder) convertView.getTag();
        }

        MainList list = _lists.get(position);

        int photo = list.getphoto();
        String name = list.getname();
        String resName1 = "@drawable/main" + photo;
        int resID1 = m_ctx.getResources().getIdentifier(resName1, "drawable", m_ctx.getPackageName());
        Drawable drawID = m_ctx.getResources().getDrawable(resID1);


        holder.photo.setBackground(drawID);
        holder.name.setText(name);


        return convertView;
    }


}
