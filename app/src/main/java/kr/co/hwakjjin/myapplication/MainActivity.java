package kr.co.hwakjjin.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btn_price = (Button) findViewById(R.id.btn_price);
        final Button btn_menu = (Button) findViewById(R.id.btn_menu);
        final Button btn_back = (Button) findViewById(R.id.btn_back);
        final Button btn_under5 = (Button) findViewById(R.id.btn_under5);
        final Button btn_5to6 = (Button) findViewById(R.id.btn_5to6);
        final Button btn_6to7 = (Button) findViewById(R.id.btn_6to7);
        final Button btn_over7 = (Button) findViewById(R.id.btn_over7);
        final LinearLayout layout_priceSelect = (LinearLayout) findViewById(R.id.price_select_layout);
        final LinearLayout layout_menuSelect = (LinearLayout) findViewById(R.id.menu_select_layout);

        final Button btn_login = (Button) findViewById(R.id.test_btn);
        btn_price.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout_priceSelect.setVisibility(View.VISIBLE);
                btn_back.setVisibility(View.VISIBLE);
                btn_menu.setVisibility(View.INVISIBLE);
                btn_price.setVisibility(View.INVISIBLE);
            }
        });

        btn_menu.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout_menuSelect.setVisibility(View.VISIBLE);
                btn_back.setVisibility(View.VISIBLE);
                btn_menu.setVisibility(View.INVISIBLE);
                btn_price.setVisibility(View.INVISIBLE);
            }
        });

        btn_back.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                layout_menuSelect.setVisibility(View.INVISIBLE);
                layout_priceSelect.setVisibility(View.INVISIBLE);
                btn_back.setVisibility(View.INVISIBLE);
                btn_menu.setVisibility(View.VISIBLE);
                btn_price.setVisibility(View.VISIBLE);
            }
        });

        btn_under5.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DinerList1.class);
                intent.putExtra("title","~5000");
                startActivity(intent);
            }
        });
        btn_5to6.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DinerList1.class);
                intent.putExtra("title","5000 ~ 6000");
                startActivity(intent);
            }
        });
        btn_6to7.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DinerList1.class);
                intent.putExtra("title","6000 ~ 7000");
                startActivity(intent);
            }
        });
        btn_over7.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DinerList1.class);
                intent.putExtra("title","7000 ~");
                startActivity(intent);
            }
        });
        btn_login.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                intent.putExtra("title","~5000");
                startActivity(intent);
            }
        });
        // commit test suyoung
    }
}
