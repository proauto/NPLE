package creativestudioaq.teamkill;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by honggyu on 2016-01-20.
 */
public class GraphAdapter extends PagerAdapter {


    SharedPreferences settingshared;
    SharedPreferences.Editor editor;
    String dbName1;
    int dbVersion1;

    SQLiteDatabase db1;
    String sql1;

    private FrameLayout thirdlayout;
    private PieChart mChart;
    ArrayList<Integer> ylist = new ArrayList<>();
    ArrayList<String> xlist = new ArrayList<>();
    String[] legendstringchange;
    int[] result;
    Context ctx;
    Typeface mTypeface;


    int realcolor1 = Color.rgb(228, 90, 87);
    int realcolor2 = Color.rgb(143, 143, 143);
    int realcolor3 = Color.rgb(170, 66, 67);
    int realcolor4 = Color.rgb(31, 30, 26);
    int realcolor5 = Color.rgb(93, 68, 68);

    int realcolor6 = Color.rgb(122, 201, 67);
    int realcolor7 = Color.rgb(41, 171, 226);
    int realcolor8 = Color.rgb(13, 89, 127);
    LayoutInflater inflater;

    public GraphAdapter(LayoutInflater inflater, Context context, Typeface typeface) {
        // TODO Auto-generated constructor stub

        //전달 받은 LayoutInflater를 멤버변수로 전달
        this.inflater = inflater;
        this.ctx = context;
        this.mTypeface = typeface;
    }

    //PagerAdapter가 가지고 잇는 View의 개수를 리턴
    //보통 보여줘야하는 이미지 배열 데이터의 길이를 리턴
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 1; //이미지 개수 리턴(그림이 10개라서 10을 리턴)
    }

    //ViewPager가 현재 보여질 Item(View객체)를 생성할 필요가 있는 때 자동으로 호출
    //쉽게 말해, 스크롤을 통해 현재 보여져야 하는 View를 만들어냄.
    //첫번째 파라미터 : ViewPager
    //두번째 파라미터 : ViewPager가 보여줄 View의 위치(가장 처음부터 0,1,2,3...)
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO Auto-generated method stub

        View view = null;


        //새로운 View 객체를 Layoutinflater를 이용해서 생성
        //만들어질 View의 설계는 res폴더>>layout폴더>>viewpater_childview.xml 레이아웃 파일 사용
        view = inflater.inflate(R.layout.graph_child, null);


        //만들어진 View안에 있는 ImageView 객체 참조
        //위에서 inflated 되어 만들어진 view로부터 findViewById()를 해야 하는 것에 주의.
        //ImageView img= (ImageView)view.findViewById(R.id.img_viewpager_childimage);

        //ImageView에 현재 position 번째에 해당하는 이미지를 보여주기 위한 작업
        //현재 position에 해당하는 이미지를 setting


        ylist = new ArrayList<>();
        xlist = new ArrayList<>();
        ylist.add(10);
        xlist.add("정우성");
        ylist.add(20);
        xlist.add("현빈");
        ylist.add(30);
        xlist.add("강동원");
        ylist.add(20);
        xlist.add("원빈");
        ylist.add(40);
        xlist.add("공유");


        Integer[] ylistgo = ylist.toArray(new Integer[ylist.size()]);
        String[] xlistgo = xlist.toArray(new String[xlist.size()]);


        thirdlayout = (FrameLayout) view.findViewById(R.id.thirdlayout);


        mChart = new PieChart(ctx);
        //add pie chart to Layout
        int leng = ylistgo.length;

        TextView backgroundthing = (TextView) view.findViewById(R.id.backgroundthing);
        if (leng != 1) {
            thirdlayout.addView(mChart);
        } else {
            thirdlayout.setBackgroundColor(Color.rgb(255, 255, 255));
        }


        //configure pit chart
        mChart.setUsePercentValues(true);
        mChart.setDescription("N플");

        //enable hole and configure
        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColorTransparent(true);
        mChart.setHoleRadius(0);
        mChart.setTransparentCircleRadius(0);


        //add Data
        addData(ylistgo, xlistgo);

        //customize legends
        mChart.getLegend().setPosition(Legend.LegendPosition.LEFT_OF_CHART_INSIDE);
        mChart.getLegend().setTextSize(11f);


        //ViewPager에 만들어 낸 View 추가
        container.addView(view);
        view.setTag(position);


        //Image가 세팅된 View를 리턴
        return view;
    }

    //화면에 보이지 않은 View는파쾨를 해서 메모리를 관리함.
    //첫번째 파라미터 : ViewPager
    //두번째 파라미터 : 파괴될 View의 인덱스(가장 처음부터 0,1,2,3...)
    //세번째 파라미터 : 파괴될 객체(더 이상 보이지 않은 View 객체)
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub

        //ViewPager에서 보이지 않는 View는 제거
        //세번째 파라미터가 View 객체 이지만 데이터 타입이 Object여서 형변환 실시
        container.removeView((View) object);

    }

    //instantiateItem() 메소드에서 리턴된 Ojbect가 View가  맞는지 확인하는 메소드
    @Override
    public boolean isViewFromObject(View v, Object obj) {
        // TODO Auto-generated method stub
        return v == obj;
    }

    private void addData(Integer[] yData, String[] xData) {
        ArrayList<Entry> yVals1 = new ArrayList<Entry>();

        for (int i = 0; i < yData.length; i++)
            yVals1.add(new Entry(yData[i], i));

        ArrayList<String> xVals = new ArrayList<String>();

        for (int i = 0; i < xData.length; i++)
            xVals.add(xData[i]);

        //create pie data set
        PieDataSet dataSet = new PieDataSet(yVals1, "");
        //dataSet.setSliceSpace(3);
        dataSet.setSelectionShift(5);

        // add many colors
        ArrayList<Integer> colors = new ArrayList<Integer>();

        colors.add(realcolor1);
        colors.add(realcolor2);
        colors.add(realcolor3);
        colors.add(realcolor4);
        colors.add(realcolor5);
        colors.add(realcolor6);
        colors.add(realcolor7);
        colors.add(realcolor8);
        colors.add(realcolor6);
        colors.add(realcolor6);

        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);


        //instantiate pie data object now

        PieData data = new PieData(xVals, dataSet);
        data.setDrawValues(false);
        data.setValueTextSize(0f);
        data.setValueTextColor(Color.BLACK);

        mChart.setData(data);

        //undo all highlights
        mChart.highlightValue(null);

        //update pie chart
        mChart.invalidate();

        //now it's time for demo !!!
    }

}
