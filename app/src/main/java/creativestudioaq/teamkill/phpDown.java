package creativestudioaq.teamkill;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by honggyu on 2016-02-14.
 */
public class phpDown extends AsyncTask<String, Integer,String> {

    ArrayList<ListItem> listItem= new ArrayList<ListItem>();

    @Override
    protected String doInBackground(String... urls) {
        StringBuilder jsonHtml = new StringBuilder();
        try{
            //연결 url 설정
            URL url = new URL(urls[0]);
            //커넥션 객체 생성
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            if(conn != null){
                conn.setConnectTimeout(10000);
                conn.setUseCaches(false);
                //연결되었음 코드가 리턴되면
                if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                    for(;;){
                        //웹상에 보여지는 텍스트를 라인단위로 읽어 저장
                        String line = br.readLine();
                        if(line == null) break;
                        //저장된 텍스트 라인을 jsonHtml에 붙여넣음
                        jsonHtml.append(line + "\n");
                    }
                    br.close();
                }
                conn.disconnect();
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return jsonHtml.toString();
    }

    protected void onPostExecute(String str){
        String data1, data2;

        try{
            JSONObject root = new JSONObject(str);   //Json 문서를 JSONObject 객체로 받음
            //JSONArray 선언, JSONObject에서 JSONArray를 get 해오는데, results라는 것은 Json 문서의 결과 값 리스트
            JSONArray ja = root.getJSONArray("results");   //자료들의 리스트를 "results" 라고 정의

            JSONObject jo = ja.getJSONObject(0);

            data1 = jo.getString("teamname");
            data2 = jo.getString("teamdate");

            listItem.add(new ListItem(data1,data2));
        } catch(JSONException e){
            e.printStackTrace();
        }

        int i = listItem.size()-1;
//        String name = listItem.get(i).getData(0).toString();
  //      System.out.println(name);

//        //String->Int변환
//        int inttemp = Integer.parseInt(listItem.get(i).getData(1));
//        detection(inttemp);
    }

}