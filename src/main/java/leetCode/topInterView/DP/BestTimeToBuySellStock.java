package leetCode.topInterView.DP;

/**
 * @author : iyeong-gyo
 * @package : leetCode.topInterView.DP
 * @since : 2023/04/18
 */
public class BestTimeToBuySellStock {
  public static void main(String[] args) {
    BestTimeToBuySellStockInterface solution = new BestTimeToBuySellStockSolution();
    int[] prices = {7, 1, 5, 3, 6, 4};
    int result = solution.maxProfit(prices);
    System.out.println("result = " + result);
  }
}

class BestTimeToBuySellStockSolution implements BestTimeToBuySellStockInterface {
  @Override
  public int maxProfit(int[] prices) {
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;

    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < minPrice) {
        minPrice = prices[i];
      } else if (prices[i] - minPrice > maxProfit) {
        maxProfit = prices[i] - minPrice;
      }
    }
    return maxProfit;
  }
}

interface BestTimeToBuySellStockInterface {
  int maxProfit(int[] prices);
}
