package creativestudioaq.teamkill;

/**
 * Created by honggyu on 2016-02-13.
 */
public class TaskList {


    private String _content;
    private int _button;

    public int getbutton() {
        return _button;
    }

    public String getcontent() {
        return _content;
    }

    public TaskList(int button, String content) {
        _button = button;
        _content = content;
    }
}
