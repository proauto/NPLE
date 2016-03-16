package creativestudioaq.teamkill;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by honggyu on 2016-02-13.
 */
public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
