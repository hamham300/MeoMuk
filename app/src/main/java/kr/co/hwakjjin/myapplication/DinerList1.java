package kr.co.hwakjjin.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DinerList1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diner_list1);
        TextView txt_title = (TextView) findViewById(R.id.txt_title);
        final Button btn_back = (Button) findViewById(R.id.btn_back);

        Intent intent = getIntent(); /*데이터 수신*/
        String title = intent.getExtras().getString("title");
        txt_title.setText(title);


        btn_back.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
