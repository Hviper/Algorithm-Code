package 贪心算法.Coin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class test {
    public static void main(String[] args) {
        test test = new test();
        test.select((Article a1,Article a2)->{
            return Double.compare(a2.valueDensity,a1.valueDensity);
        });
    }
    Article[] articles;
    public void select(Comparator<Article> comparator){
        articles = new Article[]{
                new Article(10,35),
                new Article(40,30),
                new Article(30,60),
                new Article(50,50),
                new Article(35,40),
                new Article(40,10),
                new Article(30,25),
        };
        Arrays.sort(articles,comparator);
        int capacity = 150;
        int sum=0;
        int value=0;
        ArrayList<Article> list = new ArrayList<>();
        for (Article article : articles) {
            //先更新f符合后再判断，不然判断里面更新以后就有可能错误
            int new_sum = article.height + sum;
            if (new_sum <= capacity) {
                sum = new_sum;
                value = article.value + value;
                list.add(article);
            }
        }
        System.out.println("总价值为-->【"+value+"】");
        System.out.println("总质量为-->【"+sum+"】");
        for (Article article : list) {
            System.out.println(article.toString());
        }
    }
}
