package kr.co.hwakjjin.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class DinerList1 extends AppCompatActivity {

    ArrayList<MenuData> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diner_list1);
        TextView txt_title = (TextView) findViewById(R.id.txt_title);
        final Button btn_back = (Button) findViewById(R.id.btn_back);
        final Button btn_haksik = (Button) findViewById(R.id.btn_haksik);
        final Button btn_gyosik = (Button) findViewById(R.id.btn_gyosik);
        final Button btn_gisik = (Button) findViewById(R.id.btn_gisik);

        this.setListData(); // 데이터 로드 form server?, firebase?, 내장 데이터?

        // 리스트뷰 설정 //

        ListView listView = (ListView) findViewById(R.id.listView);
        final DinerList1Adapter adpater = new DinerList1Adapter(this, mList);
        listView.setAdapter(adpater);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 상세화면(지도정보, 리뷰시스템 등등) 호출 -> 액티비티? 다이얼로그?
            }
        });

        Intent intent = getIntent(); /*데이터 수신*/
        String title = intent.getExtras().getString("title");
        txt_title.setText(title);

        // 리스트뷰 설정 //

        // 에드몹 배너광고 //

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdView mAdView = findViewById(R.id.adView);

        mAdView.setVisibility(View.INVISIBLE);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        // 애드몹배너광고 //

        if(title.equals("~5000")){

        } else{
            btn_gisik.setVisibility(View.INVISIBLE);
            btn_gyosik.setVisibility(View.INVISIBLE);
            btn_haksik.setVisibility(View.INVISIBLE);
        }


        btn_back.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /*
     * 뿌릴 리스트데이터 설정 작업 , 정렬관련 구현, 서버나 내장데이터의 로드
     */
    public void setListData(){
        mList = new ArrayList<MenuData>();

        mList.add(new MenuData(R.drawable.sausagerice, "소시지필라프 - 3pop", 4.0f, 5000, "jeon", "맛있노", 5));
        mList.add(new MenuData(R.drawable.galbimandu, "갈비만두 - 3pop", 4.3f, 4000, "kim", "gglglaslaslfasdgj", 3));
        mList.add(new MenuData(R.drawable.cheesestick, "치즈스틱 - 3pop", 4.0f, 5000, "park", "asdasdasdas", 5));
        mList.add(new MenuData(R.drawable.gyojamandu, "교자만두시발새기ㅏ듬ㄴㄹㄴㅇ - 존나긴이름이다시발놈드라", 4.0f, 5000, "john", "afdffds", 13));
        mList.add(new MenuData(R.drawable.kimchirice, "김치두루치기 덮밥 - 3pop", 4.0f, 5000, "igi", "00asdf8ags", 45));

    }
}
