package leetcode.topinterview.array;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.Array
 * @since : 2022/10/13
 */
public class BestTimeToBuyandSellStock2 {

  public static void main(String[] args) {
    int[] inputNums = {1,2,3,4,5};
    BestTimeToBuyandSellStock2 bestTimeToBuyandSellStock2 = new BestTimeToBuyandSellStock2();
    int i = bestTimeToBuyandSellStock2.maxProfit(inputNums);
    System.out.println("i = " + i);
  }

  public int maxProfit(int[] prices) {
    int i = 0;
    int valley = prices[0];
    int peak = prices[0];
    int maxprofit = 0;
    while (i < prices.length - 1) {
      while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
        i++;
      }
      valley = prices[i];
      while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
        i++;
      }
      peak = prices[i];
      maxprofit += peak - valley;
    }
    return maxprofit;
  }
}
