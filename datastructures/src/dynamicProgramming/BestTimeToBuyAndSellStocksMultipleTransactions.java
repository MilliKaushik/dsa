package dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//concept : make a decision tree/choice diagram. Start from end - now either don't consider this 
//element which means call the recursion on the previous element
//or consider this element and make a decision tree as to which is the most profitable of all the 
//allowed buy and sells - that means store all the indexes of elements which are smaller than this
//element and calculate profit on that plus recursion on the just previous element 
//multiple transactions allowed
//https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/572/

//might be solved by maximum difference algo too - TODO
public class BestTimeToBuyAndSellStocksMultipleTransactions {

	public int maxProfitMemoized(int[] prices) {
		int n = prices.length;
		Map<Integer, List<Integer>> indexToSmallerElementsIndexes = new HashMap<>();
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--)
				if (prices[j] < prices[i])
					addToMap(prices, indexToSmallerElementsIndexes, i, j);
		}
		int[] profitValue = new int[n + 1];
		for (int k = 0; k <= n; k++)
			profitValue[k] = -1;
		return maxProfitMemoizedHelper(prices, 0, n - 1, profitValue, indexToSmallerElementsIndexes);
	}

	private int maxProfitMemoizedHelper(int[] prices, int st, int end, int[] profitValue,
			Map<Integer, List<Integer>> indexToSmallerElementsIndexes) {
		if (st >= end)
			return 0;
		if (profitValue[end] != -1)
			return profitValue[end];
		// not including this element
		int notIncludedProfit = maxProfitMemoizedHelper(prices, st, end - 1, profitValue,
				indexToSmallerElementsIndexes);
		int includedProfit = 0;
		// including this and calculating the value of the profit for every smaller
		// price
		if (indexToSmallerElementsIndexes.get(end) == null)
			return notIncludedProfit;
		for (int smallerIndex : indexToSmallerElementsIndexes.get(end)) {
			includedProfit = Math.max(prices[end] - prices[smallerIndex]
					+ maxProfitMemoizedHelper(prices, st, smallerIndex - 1, profitValue, indexToSmallerElementsIndexes),
					includedProfit);
		}
		profitValue[end] = Math.max(notIncludedProfit, includedProfit);
		return profitValue[end];
	}

	private void addToMap(int[] prices, Map<Integer, List<Integer>> indexToSmallerElementsIndexes, int i, int j) {
		List<Integer> smallerElementsIndexList;
		if (indexToSmallerElementsIndexes.containsKey(i))
			smallerElementsIndexList = indexToSmallerElementsIndexes.get(i);
		else
			smallerElementsIndexList = new ArrayList<>();

		smallerElementsIndexList.add(j);
		indexToSmallerElementsIndexes.put(i, smallerElementsIndexList);
	}

	// Not solved
	public int maxProfitTabular(int[] prices) {

		return 0;
	}
}
