package algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 0 - 1背包问题，背包最大承重150 ，每个物品都有价值v和重量w，如何选择放入使价值最大化
 *  三种思路：价值主导，重量主导，价值密度主导
 *  同样才用贪心算法
 */
public class BagProblem {

    private Article[] articles = new Article[]{
            new Article(35, 10), new Article(30, 40),
            new Article(60, 30), new Article(50, 50),
            new Article(40, 35), new Article(10, 40),
            new Article(25, 30)
    };

    private int capacity = 150;

    public void valueFirst(){
        Arrays.sort(articles, (a1, a2) -> {
            return a2.value - a1.value;
        });
        select("valueFirst");
    }

    public void weightFirst(){
        Arrays.sort(articles, (a1, a2) -> {
            return a1.weight - a2.weight;
        });
        select("weightFirst");
    }

    public void valueDensityFirst(){
        Arrays.sort(articles, (a1, a2) -> {
            return Double.compare(a2.valueDensity, a1.valueDensity);
        });
        select("valueDensityFirst");
    }

    private void select(String title){
        int weight = 0, value = 0;
        ArrayList<Article> selectedArticles = new ArrayList<>();
        for (int i = 0; i < articles.length; i++) {
            //需要先判断是否超重然后再加
            int newWeight = weight + articles[i].weight;
            if (newWeight <= capacity){
                weight = newWeight;
                value += articles[i].value;
                selectedArticles.add(articles[i]);
            }
        }
        System.out.println("[" + title + "]");
        System.out.println("total value: " + value);
        selectedArticles.forEach(System.out::println);
        System.out.println("-------------------------");
    }

    private static class Article{
        int weight;
        int value;
        double valueDensity;

        public Article(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.valueDensity = value * 1.0 / weight;
        }

        @Override
        public String toString() {
            return "Article{" +
                    "weight=" + weight +
                    ", value=" + value +
                    ", valueDensity=" + valueDensity +
                    '}';
        }
    }

    public static void main(String[] args) {
        BagProblem bagProblem = new BagProblem();
        bagProblem.valueFirst();
        bagProblem.weightFirst();
        bagProblem.valueDensityFirst();
    }
}
