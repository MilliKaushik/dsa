package greedy;

//https://leetcode.com/problems/gas-station/
//https://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
//https://www.interviewbit.com/problems/gas-station/
public class GasStation {

	// O(n)
	public int canCompleteCircuit1(int[] gas, int[] cost) {
		for (int k = 0; k < gas.length; k++) {
			if (gas[k] >= cost[k]) {
				int leftover = canCompleteK1(gas, cost, 0, k, gas.length - 1);
				if (leftover == -1)
					continue;
				if (canCompleteK1(gas, cost, leftover, 0, k - 1) != -1)
					return k;
			}
		}
		return -1;
	}

	public int canCompleteK1(int[] gas, int[] cost, int leftover, int st, int end) {
		for (int i = st; i <= end; i++) {
			int currentGas = leftover + gas[i];
			if (cost[i] > currentGas)
				return -1;
			leftover = currentGas - cost[i];
		}
		return leftover;
	}

	// Brute force O(n2)
	public int canCompleteCircuit(int[] gas, int[] cost) {
		for (int k = 0; k < gas.length; k++) {
			int leftover = canCompleteK(gas, cost, 0, k, gas.length - 1);
			if (leftover == -1)
				continue;
			if (canCompleteK(gas, cost, leftover, 0, k - 1) != -1)
				return k;
		}
		return -1;
	}

	public int canCompleteK(int[] gas, int[] cost, int leftover, int st, int end) {
		for (int i = st; i <= end; i++) {
			int currentGas = leftover + gas[i];
			if (cost[i] > currentGas)
				return -1;
			leftover = currentGas - cost[i];
		}
		return leftover;
	}
}
