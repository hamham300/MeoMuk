package kr.co.hwakjjin.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class DinerList1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diner_list1);
        TextView txt_title = (TextView) findViewById(R.id.txt_title);
        final Button btn_back = (Button) findViewById(R.id.btn_back);
        final Button btn_haksik = (Button) findViewById(R.id.btn_haksik);
        final Button btn_gyosik = (Button) findViewById(R.id.btn_gyosik);
        final Button btn_gisik = (Button) findViewById(R.id.btn_gisik);

        Intent intent = getIntent(); /*데이터 수신*/
        String title = intent.getExtras().getString("title");
        txt_title.setText(title);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        if(title.equals("~5000")){
            btn_gisik.setVisibility(View.VISIBLE);
            btn_gyosik.setVisibility(View.VISIBLE);
            btn_haksik.setVisibility(View.VISIBLE);
        }


        btn_back.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
