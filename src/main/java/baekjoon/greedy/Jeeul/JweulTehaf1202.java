package baekjoon.greedy.Jeeul;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author : iyeong-gyo
 * @package : baekjoon.greedy
 * @since : 15.11.23
 */
public class JweulTehaf1202 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int K = scanner.nextInt();
    List<Jewel> jewels = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      jewels.add(new Jewel(scanner.nextInt(), scanner.nextInt()));
    }
    jewels.sort(Comparator.comparingInt((Jewel jewel) -> jewel.price).reversed());
    List<Bag> bags = new ArrayList<>();
    for (int i = 0; i < K; i++) {
      bags.add(new Bag(scanner.nextInt()));
    }
    bags.sort(Comparator.comparingInt((Bag bag) -> bag.limitWeigh).reversed());

    for (Bag bag : bags) {
      for (Jewel jewel : jewels) {
        bag.put(jewel);
      }
    }

    int totalPrice = 0;
    for (Bag bag : bags) {
      totalPrice += bag.getPrice();
    }

    System.out.println("totalPrice = " + totalPrice);
  }

  static class Jewel {

    int weigh;
    int price;
    boolean isSteal;

    public Jewel(int weigh, int price) {
      this.weigh = weigh;
      this.price = price;
      this.isSteal = false;
    }

    public int getWeigh() {
      return weigh;
    }

    public int getPrice() {
      return price;
    }

    public void alreadyStolen() {
      this.isSteal = true;
    }
  }

  static class Bag {

    int price;
    int limitWeigh;
    int currentWeigh;

    public Bag(int limitWeigh) {
      this.limitWeigh = limitWeigh;
      this.currentWeigh = 0;
    }

    public void put(Jewel jewel) {
      if (!jewel.isSteal && this.currentWeigh == 0 &&
          (jewel.getWeigh() <= this.limitWeigh)) {
        this.currentWeigh += jewel.getWeigh();
        this.price += jewel.getPrice();
        jewel.alreadyStolen();
      }
    }

    public int getPrice() {
      return price;
    }
  }
}
