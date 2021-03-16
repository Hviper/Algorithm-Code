package 贪心算法.Coin;

public class Article {

    int value;
    int height;
    double valueDensity ;
    public Article(int value,int height){
        this.height = height;
        this.value = value;
        valueDensity = (value*1.0)/height;
    }

    @Override
    public String toString() {
        return "Article{" +
                "value=" + value +
                ", height=" + height +
                ", valueDensity=" + valueDensity +
                '}';
    }
}
