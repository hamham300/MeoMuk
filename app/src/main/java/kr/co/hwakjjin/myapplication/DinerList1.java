package kr.co.hwakjjin.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
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
    private WebView mWebView; // 웹뷰 선언
    private WebSettings mWebSettings; //웹뷰세팅

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diner_list1);
        TextView txt_title = (TextView) findViewById(R.id.txt_title);
        final Button btn_back = (Button) findViewById(R.id.btn_back);
        final Button btn_haksik = (Button) findViewById(R.id.btn_haksik);
        final Button btn_gyosik = (Button) findViewById(R.id.btn_gyosik);
        final Button btn_gisik = (Button) findViewById(R.id.btn_gisik);
        final Button btn_sort = (Button) findViewById(R.id.btn_sort);

        ConstraintLayout layout_stdFood = (ConstraintLayout) findViewById(R.id.btnContainer);

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
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        // 애드몹배너광고 //

        assert title != null;
        if(title.equals("~5000")){
            layout_stdFood.setVisibility(View.VISIBLE);
            btn_haksik.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.soongguri.com/"));
                    startActivity(intent);
                }
            });
            btn_gyosik.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.soongguri.com/"));
                    startActivity(intent);
                }
            });
            btn_gisik.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ssudorm.ssu.ac.kr:444/SShostel/mall_main.php?viewform=B0001_foodboard_list&board_no=1"));
                    startActivity(intent);
                }
            });
        } else{
            btn_gisik.setVisibility(View.INVISIBLE);
            btn_gyosik.setVisibility(View.INVISIBLE);
            btn_haksik.setVisibility(View.INVISIBLE);
            layout_stdFood.setVisibility(View.GONE);
        }

        btn_sort.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String [] items = {"평점순", "가격순", "리뷰추천순"};

                AlertDialog.Builder builder = new AlertDialog.Builder(DinerList1.this);

                builder.setTitle("정렬기준 선택");
                int checkedItem = 0;
                CharSequence text = btn_sort.getText();
                if ("평점순".equals(text)) {
                    checkedItem = 0;
                } else if ("가격순".equals(text)) {
                    checkedItem = 1;
                } else if ("리뷰추천순".equals(text)) {
                    checkedItem = 2;
                } else {
                    throw new IllegalStateException("Unexpected value: " + btn_sort.getText());
                }
                builder.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        btn_sort.setText(items[which]);
                        sortListData(which);
                        dialog.dismiss(); // 누르면 바로 닫히는 형태
                    }

                });
                builder.create();
                builder.show();
            }
        });

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

    /*
     * 리스트아이템 정렬하는 함수
     */
    public void sortListData(int sortType){

    }
}
