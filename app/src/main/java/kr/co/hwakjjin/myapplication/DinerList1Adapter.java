package kr.co.hwakjjin.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class DinerList1Adapter extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<MenuData> mList;

    public DinerList1Adapter(Context context, ArrayList<MenuData> data){
        mContext = context;
        mList = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.listitem_price, null);

        ImageView img_food = (ImageView)view.findViewById(R.id.img_food);

        RatingBar rating = (RatingBar)view.findViewById(R.id.rating);

        TextView txt_menu = (TextView)view.findViewById(R.id.txt_menu);
        TextView txt_rate = (TextView)view.findViewById(R.id.txt_rate);
        TextView txt_price = (TextView)view.findViewById(R.id.txt_price);
        TextView txt_bestReview = (TextView)view.findViewById(R.id.txt_bestReview);
        TextView txt_reviewUp =  (TextView)view.findViewById(R.id.txt_reviewup);

        String str_price = mList.get(position).getPrice() + " 원";
        String str_rate = mList.get(position).getRate() + "/ 5.0";
        String str_bestReview = mList.get(position).getBestReviewer() + " : " + mList.get(position).getBestReview();  // 이름 : 리뷰


        img_food.setImageResource(mList.get(position).getFoodPic());
        rating.setRating(mList.get(position).getRate());
        txt_menu.setText(mList.get(position).getMenuTxt());
        txt_price.setText(str_price);
        txt_rate.setText(str_rate);
        txt_bestReview.setText(str_bestReview);
        txt_reviewUp.setText(String.valueOf(mList.get(position).getBestReviewUp()));


        return view;
    }
}
