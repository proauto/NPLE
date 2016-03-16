package creativestudioaq.teamkill;

import java.util.ArrayList;

/**
 * Created by honggyu on 2016-02-13.
 */
public class TaskinList {


    private String _name;
    private int _number;
    private ArrayList<TaskininList> _tasklists= new ArrayList<>();

    public int getnumber() {
        return _number;
    }

    public String getname() {
        return _name;
    }

    public  ArrayList<TaskininList> gettasklists(){return _tasklists;}

    public TaskinList(int number, String name,ArrayList<TaskininList> taskininList) {
        _number = number;
       _name = name;
        _tasklists = taskininList;
    }
}
