package kr.co.hwakjjin.myapplication;

import androidx.appcompat.app.AppCompatActivity;

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
        final LinearLayout layout_priceSelect = (LinearLayout) findViewById(R.id.price_select_layout);


        btn_price.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout_priceSelect.setVisibility(View.VISIBLE);
                btn_back.setVisibility(View.VISIBLE);
                btn_menu.setVisibility(View.INVISIBLE);
                btn_price.setVisibility(View.INVISIBLE);
            }
        });

        btn_back.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                layout_priceSelect.setVisibility(View.INVISIBLE);
                btn_back.setVisibility(View.INVISIBLE);
                btn_menu.setVisibility(View.VISIBLE);
                btn_price.setVisibility(View.VISIBLE);
            }
        });
    }
}
