package kr.co.hwakjjin.myapplication;

public class MenuData {
    private int foodPic;
    private String txt_menu;
    private float rate;
    private int price;
    private String bestReviewer;
    private String bestReview;
    private int bestReviewUp;

    public MenuData(int foodPic, String txt_menu, float rate, int price, String bestReviewer, String bestReview,int bestReviewUp)
    {
        this.foodPic = foodPic;
        this.txt_menu = txt_menu;
        this.rate = rate;
        this.price = price;
        this.bestReviewer = bestReviewer;
        this.bestReview = bestReview;
        this.bestReviewUp = bestReviewUp;
    }

    public int getFoodPic(){ return this.foodPic;}
    public String getMenuTxt(){ return this.txt_menu;}
    public float getRate(){ return this.rate;}
    public int getPrice(){ return this.price;}
    public String getBestReviewer(){ return this.bestReviewer;}
    public String getBestReview(){ return this.bestReview;}
    public int getBestReviewUp(){ return this.bestReviewUp;}
}
