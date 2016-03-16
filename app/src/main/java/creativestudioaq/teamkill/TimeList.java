package creativestudioaq.teamkill;

/**
 * Created by honggyu on 2016-02-13.
 */
public class TimeList {

    private int _photo;
    private String _name;
    public int status;

    public int getphoto(){
        return _photo;
    }
    public String getname(){
        return _name;
    }

    public TimeList(int photo, String name){
        _photo=photo;
        _name=name;
        status=0;
    }
}
