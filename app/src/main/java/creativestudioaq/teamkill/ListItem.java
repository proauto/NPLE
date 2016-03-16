package creativestudioaq.teamkill;

/**
 * Created by HwangYuJin on 2016-02-14.
 */
public class ListItem {
    private String[] mData;

    public ListItem(String[] data){
        mData = data;
    }

    public ListItem(String teamname, String teamdate){

        mData = new String[2];
//        mData[0] = teamId;
        mData[0] = teamname;
        mData[1] = teamdate;

    }

    public String[] getData(){
        return mData;
    }

    public String getData(int index){
        return mData[index];
    }

    public void setData(String[] data){
        mData = data;
    }
}
