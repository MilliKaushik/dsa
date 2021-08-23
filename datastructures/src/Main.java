import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import array.ArrayPractice;
import array.FindTheCelebrity;
import array.RotateArrayByK;
import array.ThreeSum;
import array.bitwise.HammingDistance;
import array.bitwise.ReverseBits;
import array.bitwise.SumOfTwoNosWithoutPlusMinusOperator;
import array.math.DivideTwoIntegers;
import array.math.FractionToDecimal;
import array.math.NthNaturalNumber;
import array.math.PlusOne;
import array.math.Power;
import array.math.PowerOfThree;
import array.math.PrintPrimeFactors;
import array.math.SquareRoot;
import array.matrix.SpiralMatrix;
import array.misc.ConsecutiveArrayElements;
import array.misc.PowerSet;
import array.missingAndDuplicateFrom1ToN.FindMissingAndDuplicateNumber;
import array.orderStatistics.SmallestMissingNumber;
import array.search.AppearingOnce;
import array.search.MajorityElement;
import array.slidingWindow.FindIndicesOfOccurrencesOfAnagram;
import array.slidingWindow.LongestSubstringWithKUniqueCharacters;
import array.slidingWindow.LongestSubstringWithoutRepeatingCharacters;
import array.sort.MergeIntervals;
import array.sort.SortColours;
import binarySearch.AllocateMinimumNumberOfPages;
import binarySearch.FindElementInBitonicArray;
import binarySearch.FloorInASortedArray;
import binarySearch.NextAlphabetElement;
import binarySearch.NoOfTimesRotatedCOPY;
import binarySearch.RemoveDuplicatesfromSortedArray;
import binarySearch.SearchinRotatedSortedArray;
import binarySearch.SearchingInANearlySortedArray;
import design.LRUCache2;
import design.RateLimiter;
import dynamicProgramming.EqualPartitionSubsetSum;
import dynamicProgramming.IsSubsequence;
import dynamicProgramming.LongestCommonSubstring;
import dynamicProgramming.LongestPalindromicSubstring;
import heap.KClosestNumbers;
import heap.KClosestNumbersGFG;
import heap.KLargestElementsInArray;
import heap.TopKFrequentNumbers;
import linkedList.AddTwoNumbers2;
import linkedList.ListNode;
import linkedList.ReverseLinkedList;
import recursion.Permutations;
import recursion.SortArray;
import stack.stackapplications.MaximumAreaHistogram;
import stack.stackapplications.MaximumAreaRectangleInBinaryMatrixLEETCODE;
import stack.stackapplications.MinStackExtraSpace;
import stack.stackapplications.MinStackNoExtraSpace;
import string.GroupAnagramsCOPY;
import string.GroupAnagramsFromList;
import string.ReverseInteger;
import string.ReverseWordsInString1;
import string.StringCompression;
import string.StringToIntegerATOI;
import string.StudentGradeProblem;
import tree.BTInorderTraversal;
import tree.BinaryTreeInorderPreorderConstruct;
import tree.MaximumDepthOfTree;
import tree.TreeNode;
import tree.ZigzagLevelOrderTraversal;

public class Main {

	public static void main(String[] args) {
		int[] a = new int[3];
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;

//		System.out.println(a);
//		System.out.println(Arrays.toString(a));
//
//		int[] b = { 1, 2, 3 };
//		System.out.println(Arrays.toString(b));
//		System.out.println(b.length);
//
//		Array<String> arr = new Array<>(10);
//		arr.print();
//		arr.add("a");
//		arr.add("b");
//		arr.add("c");

//		arr.print();

		// System.out.println(arr.indexOf("d"));
//Linked list
//-------------------------------------------------------------------------
//		LinkedList<String> list = new LinkedList<>();
//		list.addLast("a");
		// list.addLast("b");
		// list.addLast("c");
		// list.addLast("d");

		// list.removeKthFromEnd(1);

//		list.printList();
		// list.reverse();
		// list.printList();
//		System.out.println(Arrays.toString(list.toArray()));
//-----------------------------------------------------------------
//		StringManipulation strManipulation = new StringManipulation();
//		System.out.println(strManipulation.reverseWordsInString("abc def"));
//
//		System.out.println(strManipulation.reverseWordsInString("j"));
//		System.out.println(strManipulation.reverseWordsInString("the sky is blue"));
//		System.out.println(strManipulation.reverseWordsInString("this is ib"));
		// doesnt work for below case
		// System.out.println(strManipulation.reverseWordsInString(
		// " fwbpudnbrozzifml osdt ulc jsx kxorifrhubk ouhsuhf sswz qfho dqmy sn myq
		// igjgip iwfcqq "));

//		System.out.println(strManipulation.strStrBruteIterative("abcde", "cd"));
//		System.out.println(strManipulation.strStrBruteIterative("abcde", "cdef"));
//		System.out.println(strManipulation.strStrBruteIterative("abcee", "cdef"));
//		System.out.println(strManipulation.strStrBruteIterative("abcee", ""));
//		System.out.println(strManipulation.strStrBruteIterative("ccc", "cccc"));
//		System.out.println(strManipulation.strStrBruteIterative("ccc", "ccc"));
//		System.out.println(strManipulation.strStrBruteIterative("ccc", "cee"));

//		System.out.println(strManipulation.strStrBruteIterative(
//				"babbaaabaaaabbababaaabaabbbbabaaaabbabbabaaaababbabbbaaabbbaaabbbaabaabaaaaababbaaaaaabababbbbba",
//				"bababbbbbbabbbaabbaaabbbaababa"));

		// -----------------------------------
//		List list = new List();
//		ListNode head = new ListNode(1);
//		head.next = new ListNode(1);
//		ListNode node = list.sortBinaryList(head);
//		System.out.println(node);

//		BinaryTree bt = new BinaryTree();
//
//		TreeNode t = new TreeNode(1);
//		t.val = 76;
//		t.left = new TreeNode(77);
//		// bt.correctBST(t);
//
//		BinaryTreeInorderPreorderConstruct b = new BinaryTreeInorderPreorderConstruct();
//		ArrayList<Integer> in = new ArrayList<>(Arrays.asList(1, 2, 3));
//		ArrayList<Integer> pre = new ArrayList<>(Arrays.asList(2, 1, 3));
//		// TreeNode root = b.constructFromInorderPreorder(in, pre);
//		// b.printInorder(root);
//
//		BinaryTreePreorderTraversal t1 = new BinaryTreePreorderTraversal();
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(3);
//		System.out.println(t1.preorderTraversalRecursive(root));
//
//		NumbersDisappearedInArray num = new NumbersDisappearedInArray();
//		// int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
//		// System.out.println(num.findDisappearedNumbers(nums));
//		RotateArrayByK obj = new RotateArrayByK();
//		int nums[] = { 1, 2, 3, 4, 5 };
//		int k = 0;
//		// obj.rotate(nums, k);
//		GenerateSubarraySubsequence obj1 = new GenerateSubarraySubsequence();
//		int[] num1 = { 1, 2, 3, 4 };
//		List<List<Integer>> result = obj1.generateSubArray(num1);
//		for(int i = 0 ; i < result.size();i++)
//			System.out.println(result.get(i));

		PowerSet powerSet = new PowerSet();
		int[] num = { 1, 2 };
		// powerSet.printSubset(num);
//powerSet.generateSubset(num);
		ConsecutiveArrayElements c = new ConsecutiveArrayElements();
		long[] nums = { 89, 93, 94, 88, 91, 92, 94 };
		// System.out.println(c.areConsecutives(nums, nums.length));

		AppearingOnce o1 = new AppearingOnce();
		int[] num1 = { 1, 1, 2, 3, 2 };
		// System.out.println(o1.getAppearingOnce(num1));
		EqualPartitionSubsetSum e = new EqualPartitionSubsetSum();
		int[] arr1 = { 1, 2, 5 };
		// e.canPartition(arr1);

		IsSubsequence obj2 = new IsSubsequence();
		// System.out.println(obj2.isSubsequenceRecursion("axc", "ahbgdc"));
		FractionToDecimal fracToDec = new FractionToDecimal();
		// System.out.println(fracToDec.fractionToDecimal(1, 3));
		PlusOne plusOne = new PlusOne();
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(9);
		arr.add(9);
		int N = 2;
		// System.out.println(plusOne.increment(arr, N));
		NthNaturalNumber obj3 = new NthNaturalNumber();
//		System.out.println(obj3.findNth(18));
//		System.out.println(obj3.findNth(8));
//		System.out.println(obj3.findNth(19));

		MaximumAreaRectangleInBinaryMatrixLEETCODE obj4 = new MaximumAreaRectangleInBinaryMatrixLEETCODE();
		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		// System.out.println(obj4.maxArea(matrix));
		KLargestElementsInArray kle = new KLargestElementsInArray();
		// kle.findKLargest(new ArrayList<>(Arrays.asList(468, 335)), 1);

		KClosestNumbers kClosest = new KClosestNumbers();
		int[] arr6 = { 5, 6, 7, 8, 9 };
		int x = 7;
		int k = 3;
		// System.out.println(kClosest.findKClosest(arr6, x, k));

		KClosestNumbersGFG obj5 = new KClosestNumbersGFG();
		int[] arr7 = { 36, 146, 154, 170, 282, 293, 300, 323, 335, 359, 383, 392, 422, 437, 448, 465, 468, 479, 492,
				501, 539, 605, 668, 704, 706, 717, 719, 725, 727, 772, 812, 828, 828, 870, 895, 896, 903, 913, 943, 962,
				963, 996 };
		// System.out.println(Arrays.toString(obj5.findKClosest(arr7, 717, 8)));
		TopKFrequentNumbers topK = new TopKFrequentNumbers();
		int[] arr9 = { 1, 1, 1, 2, 2, 3 };
		// System.out.println(Arrays.toString(topK.findTopKFrequent(arr9, 2)));

		FindMissingAndDuplicateNumber findMissingAndDup = new FindMissingAndDuplicateNumber();
		// System.out.println(findMissingAndDup.findMissingAndDuplicateSingle(new int[]
		// { 5, 2, 1, 2, 4 }));
		// System.out.println(findMissingAndDup.findDuplicate(new int[] { 2, 1, 1, 1, 4
		// }));

		List<Integer> Ar = Arrays.asList(128, 389, 299, 65, 518, 361, 103, 342, 406, 24, 79, 192, 181, 178, 205, 38,
				298, 218, 143, 446, 324, 82, 41, 312, 166, 252, 59, 91, 6, 248, 395, 157, 332, 352, 57, 106, 246, 506,
				261, 16, 470, 224, 228, 286, 121, 193, 241, 203, 36, 264, 234, 386, 471, 225, 466, 81, 58, 253, 468, 31,
				197, 15, 282, 334, 171, 358, 209, 158, 355, 243, 75, 411, 43, 485, 291, 270, 25, 100, 194, 476, 70, 402,
				403, 109, 322, 421, 313, 239, 327, 238, 257, 433, 254, 328, 163, 436, 520, 437, 392, 199, 63, 482, 222,
				500, 454, 84, 265, 508, 416, 141, 447, 258, 384, 138, 47, 156, 172, 319, 137, 62, 85, 154, 97, 18, 360,
				244, 272, 93, 263, 262, 266, 290, 369, 357, 176, 317, 383, 333, 204, 56, 521, 502, 326, 353, 469, 455,
				190, 393, 453, 314, 480, 189, 77, 129, 439, 139, 441, 443, 351, 528, 182, 101, 501, 425, 126, 231, 445,
				155, 432, 418, 95, 375, 376, 60, 271, 74, 11, 419, 488, 486, 54, 460, 321, 341, 174, 408, 131, 115, 107,
				134, 448, 532, 292, 289, 320, 14, 323, 61, 481, 371, 151, 385, 325, 472, 44, 335, 431, 187, 51, 88, 105,
				145, 215, 122, 162, 458, 52, 496, 277, 362, 374, 26, 211, 452, 130, 346, 10, 315, 459, 92, 531, 467,
				309, 34, 281, 478, 477, 136, 519, 196, 240, 12, 288, 302, 119, 356, 503, 527, 22, 27, 55, 343, 490, 127,
				444, 308, 354, 278, 497, 191, 294, 117, 1, 396, 125, 148, 285, 509, 208, 382, 297, 405, 245, 5, 330,
				311, 133, 274, 275, 118, 463, 504, 39, 99, 442, 337, 169, 140, 104, 373, 221, 499, 413, 124, 510, 159,
				465, 80, 276, 83, 329, 524, 255, 387, 259, 397, 491, 517, 23, 4, 230, 48, 349, 412, 142, 114, 487, 381,
				164, 35, 67, 498, 73, 440, 108, 226, 96, 132, 144, 207, 235, 33, 69, 128, 236, 364, 198, 475, 173, 493,
				150, 90, 515, 111, 68, 232, 340, 112, 526, 492, 512, 495, 429, 146, 336, 17, 350, 251, 7, 184, 76, 380,
				359, 293, 19, 49, 345, 227, 212, 430, 89, 474, 279, 201, 398, 347, 273, 37, 185, 177, 102, 304, 295,
				422, 94, 426, 514, 116, 183, 180, 494, 42, 305, 152, 390, 30, 247, 451, 32, 388, 331, 78, 424, 368, 394,
				188, 306, 449, 8, 214, 120, 179, 280, 511, 409, 338, 153, 507, 370, 461, 217, 161, 483, 147, 242, 86,
				417, 268, 71, 462, 420, 167, 513, 379, 307, 522, 435, 113, 296, 457, 525, 45, 529, 423, 427, 2, 438, 64,
				316, 46, 40, 13, 516, 367, 233, 110, 318, 250, 283, 216, 186, 310, 237, 377, 365, 175, 479, 378, 66,
				414, 473, 165, 210, 50, 348, 372, 363, 339, 20, 168, 284, 415, 505, 206, 53, 223, 434, 202, 123, 399,
				400, 135, 269, 428, 219, 456, 28, 464, 267, 489, 98, 391, 195, 366, 300, 484, 533, 229, 213, 149, 160,
				256, 303, 530, 301, 29, 404, 344, 401, 220, 287, 9, 407, 170, 450, 523, 249, 72, 410, 3, 21, 200, 260);
		// System.out.println(findMissingAndDup.repeatedNumber(Ar));

		FloorInASortedArray floor = new FloorInASortedArray();
		int[] arr10 = { 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94,
				95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112 };
		int k1 = 68;
		// System.out.println(floor.findFloor(arr10, k1));

		SearchingInANearlySortedArray s = new SearchingInANearlySortedArray();
		int[] arr11 = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
		// System.out.println(s.singleNonDuplicate(arr11));

		NextAlphabetElement nextAlphaEle = new NextAlphabetElement();
		// System.out.println(nextAlphaEle.findNextAlphabet("acfh", 'f'));

		GroupAnagramsFromList anagrams = new GroupAnagramsFromList();
		String[] list = { "cat", "dog", "god" };
		// System.out.println(anagrams.groupAnagrams(list));

		StudentGradeProblem stu = new StudentGradeProblem();
		String[][] data = { { "Shrikanth", "20", "30", "10" }, { "Ram", "100", "50", "10" } };
		// System.out.println(stu.getMaxAverage(data));

		StringCompression strCom = new StringCompression();
		// System.out.println(strCom.compressString("aabccc"));

		PrintPrimeFactors primeFactors = new PrintPrimeFactors();
//		System.out.println(primeFactors.getPrimeFactors(2));
//		System.out.println(primeFactors.getPrimeFactors(17));
//		System.out.println(primeFactors.getPrimeFactors(200));

		PowerOfThree powThree = new PowerOfThree();
//		System.out.println(powThree.isPowerOfThree(27));
//		System.out.println(powThree.isPowerOfThree(1));
//		System.out.println(powThree.isPowerOfThree(6));

		FindElementInBitonicArray find = new FindElementInBitonicArray();
		int[] arr12 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11 };
		int key = 12;
		// System.out.println(find.findElement(arr12, key));

		AllocateMinimumNumberOfPages min = new AllocateMinimumNumberOfPages();
		// int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		// int D = 5;
		// int[] weights = { 1, 2, 3 };
		// int D = 1;
		int[] weights = { 407, 59, 416, 189, 326, 109, 399, 404, 181, 275, 135, 57, 147, 7, 158, 201, 218, 111, 56, 9,
				149, 231, 186, 293, 187, 395, 75, 100, 334, 23, 327, 434 };
		int D = 32;
		// System.out.println(min.shipWithinDays(weights, D));

		ReverseInteger revInt = new ReverseInteger();
		// System.out.println(revInt.reverse(123));
		// System.out.println(revInt.reverse(9646324351));

		HammingDistance hammingDistance = new HammingDistance();
		// System.out.println(hammingDistance.hammingDistance(1, 4));

		TreeNode t1Left = new TreeNode(1);
		TreeNode t1 = new TreeNode(1, t1Left, null);
		MaximumDepthOfTree max = new MaximumDepthOfTree();
		// System.out.println(max.isValidBST(t1));

		MinStackExtraSpace min1 = new MinStackExtraSpace();
		min1.push(0);
		min1.push(1);
		min1.push(0);
		// System.out.println(min1.getMin());
		// min1.pop();
		// System.out.println(min1.getMin());

		// BestTimeToBuyAndSellStocksMultipleTransactions bestTime = new
		// BestTimeToBuyAndSellStocksMultipleTransactions();
		// int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
		int[] prices = new int[] { 1, 2, 3, 4, 5 };
		// System.out.println(bestTime.maxProfitMemoized(prices));

		RemoveDuplicatesfromSortedArray removeDup = new RemoveDuplicatesfromSortedArray();
		// int[] arr15 = new int[] { 1, 1, 2 };
		int[] arr15 = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		// System.out.println(removeDup.removeDuplicates(arr15));
		// System.out.println(Arrays.toString(arr15));

		RotateArrayByK rotate = new RotateArrayByK();
		int[] nums1 = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int key1 = 5;
		// rotate.rotate1(nums1, key1);
		// System.out.println(Arrays.toString(nums1));

		ReverseBits revBits = new ReverseBits();
		// System.out.println(revBits.reverseBits(4294967293L));

		ReverseLinkedList revList = new ReverseLinkedList();
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		// revList.printList(node);
		// revList.printList(revList.reverseListRecursive(node));

		PlusOne plusOne1 = new PlusOne();
		int[] digits = new int[] { 1, 2, 3 };
		// System.out.println(Arrays.toString(plusOne1.plusOne(digits)));

		StringToIntegerATOI atoi = new StringToIntegerATOI();
		// System.out.println(atoi.myAtoi("2147483648"));

		ThreeSum threeSum = new ThreeSum();
		int[] nums20 = new int[] { -1, 0, 1, 2, -1, -4 };
		// System.out.println(threeSum.threeSum(nums20));

		SumOfTwoNosWithoutPlusMinusOperator sum = new SumOfTwoNosWithoutPlusMinusOperator();
		// System.out.println(sum.getSum(1, 2));
		// System.out.println(sum.getSum(2, 3));

		SortColours sort = new SortColours();
		int[] nums21 = new int[] { 2, 0, 2, 1, 1, 0 };
		// sort.sortColors2(nums21);

		SearchinRotatedSortedArray search = new SearchinRotatedSortedArray();
		// System.out.println(search.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));

		Power power = new Power();
		// System.out.println(power.myPow(2.00, -2147483648));

		SquareRoot sqrt = new SquareRoot();
		// System.out.println(sqrt.mySqrt(2000000000));

		DivideTwoIntegers divide = new DivideTwoIntegers();
		// System.out.println(divide.divide(-2147483648, 2));

		BTInorderTraversal inorder = new BTInorderTraversal();
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		// System.out.println(inorder.inorderTraversalRecursive(root));
		// System.out.println(inorder.inorderTraversalIterative(root));

		SmallestMissingNumber missing = new SmallestMissingNumber();
		// System.out.println(missing.findFirstMissingPositiveConstantSpace(new int[] {
		// 3, 4, -1, 1 }));
		// System.out.println(missing.findFirstMissingPositiveConstantSpace(new int[] {
		// 1, 1 }));

		LRUCache2 lru21 = new LRUCache2(2);
//		lru21.put(1, 1);
//		lru21.put(2, 2);
//		System.out.println(lru21.get(1));
//		lru21.put(3, 3);
//		System.out.println(lru21.get(2));
//		lru21.put(4, 4);
//		System.out.println(lru21.get(1));
//		System.out.println(lru21.get(3));
//		System.out.println(lru21.get(4));

		LRUCache2 lru22 = new LRUCache2(1);
//		lru22.put(2, 1);
//		System.out.println(lru22.get(2));
//		lru22.put(2, 2);
//		System.out.println(lru22.get(2));
//		System.out.println(lru22.get(3));

		MaximumAreaHistogram max1 = new MaximumAreaHistogram();
		// System.out.println(max1.maximumAreaHistorgram(new int[] { 2, 4 }));
		// System.out.println(max1.maximumAreaHistorgram(new int[] { 2, 0, 2 }));

		MajorityElement maj = new MajorityElement();
		// maj.majorityElementBST(new int[] { 3, 2, 3 });
		// maj.majorityElementBST(new int[] { 1 });

		MergeIntervals mergeIntervals = new MergeIntervals();
		// System.out.println(mergeIntervals
		// .merge(new int[][] { { 1, 3 }, { 0, 2 }, { 2, 3 }, { 4, 6 }, { 4, 5 }, { 5, 5
		// }, { 0, 2 }, { 3, 3 } }));
		// System.out.println(mergeIntervals.merge(new int[][] { { 1, 4 }, { 1, 5 } }));
		// System.out.println(mergeIntervals.merge(new int[][] { { 1, 3 }, { 2, 6 }, {
		// 8, 10 }, { 15, 18 } }));

		GroupAnagramsCOPY groupAnagrams = new GroupAnagramsCOPY();
		// groupAnagrams.groupAnagramsSorting(new String[] { "cat", "dog", "god" });

		LongestSubstringWithoutRepeatingCharacters longestSub = new LongestSubstringWithoutRepeatingCharacters();
		// System.out.println(longestSub.lengthOfLongestSubstring(" "));

		LongestPalindromicSubstring subs = new LongestPalindromicSubstring();
		// System.out.println(subs.longestPalindrome("babad"));
		// System.out.println(subs.longestPalindrome("abb"));
		// System.out.println(subs.longestPalindrome("aacabdkacaa"));
		// System.out.println(subs.longestPalindrome("abcb"));

		LongestCommonSubstring substring = new LongestCommonSubstring();
		// System.out.println(substring.longestCommonSubstring("abfce", "abcde"));
		// System.out.println(substring.longestCommonSubstring("sfgabfce", "abcde"));
		// System.out.println(substring.longestCommonSubstring("sfgabfce", ""));
		NoOfTimesRotatedCOPY c1 = new NoOfTimesRotatedCOPY();
		// c1.noOfTimes(new int[] { 11, 13, 15, 17 });

		MinStackNoExtraSpace minStackNoExtraSpace = new MinStackNoExtraSpace();
//		minStackNoExtraSpace.push(-2);
//		minStackNoExtraSpace.push(0);
//		minStackNoExtraSpace.push(-3);
//		System.out.println(minStackNoExtraSpace.getMin());
//		minStackNoExtraSpace.pop();
//		System.out.println(minStackNoExtraSpace.top());
//		System.out.println(minStackNoExtraSpace.getMin());

		EqualPartitionSubsetSum equalPartition = new EqualPartitionSubsetSum();
//		equalPartition.isEqualPartitionSUmTabular(new int[] { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
//				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
//				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
//				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
//				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
//				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
//				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
//				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
//				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
//				100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97 });
		FindIndicesOfOccurrencesOfAnagram count = new FindIndicesOfOccurrencesOfAnagram();
		// System.out.println(count.findAnagrams1("cbaebabacd", "abc"));

		LongestSubstringWithKUniqueCharacters a2 = new LongestSubstringWithKUniqueCharacters();
		// System.out.println(a2.longestkSubstr("aabacbebebe", 3));
		// System.out.println(a2.longestkSubstr("aaaa", 2));

		LongestSubstringWithoutRepeatingCharacters longSubstring = new LongestSubstringWithoutRepeatingCharacters();
		// System.out.println(longSubstring.lengthOfLongestSubstringWithSW("pwwkew"));

		SortArray sort1 = new SortArray();
		// System.out.println(Arrays.toString(sort1.sort(new int[] { 3, 1, 2 })));

		Permutations permutations = new Permutations();
		// System.out.println(permutations.permute(new int[] { 1, 2 }));
		ReverseWordsInString1 reverse1 = new ReverseWordsInString1();
		// System.out.println(reverse1.reverseWords("the sky is blue"));

		LongestPalindromicSubstring palin1 = new LongestPalindromicSubstring();
		// System.out.println(palin1.longestPalindrome("cbbd"));

		SpiralMatrix spiral = new SpiralMatrix();

		AddTwoNumbers2 addList = new AddTwoNumbers2();
		ListNode l11 = new ListNode(8);
		ListNode l12 = new ListNode(9);
		ListNode l13 = new ListNode(9);
		l11.next = l12;
		l12.next = l13;

		ListNode l21 = new ListNode(2);

//		System.out.println(addList.addTwoNumbers(l11, l21));
//		System.out.println();

		ZigzagLevelOrderTraversal zigzag = new ZigzagLevelOrderTraversal();
		TreeNode root1 = new TreeNode(3);
		root1.left = new TreeNode(9);
		root1.right = new TreeNode(20);
		root1.right.left = new TreeNode(15);
		root1.right.right = new TreeNode(7);
		// System.out.println(zigzag.zigzagLevelOrder(root1));

		BinaryTreeInorderPreorderConstruct cons = new BinaryTreeInorderPreorderConstruct();
		// TreeNode root12 = cons.buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] {
		// 9, 3, 15, 20, 7 });
		// cons.printInorder(root12);

//		CloneGraph cloneGraph = new CloneGraph();
//		Node n1 = new Node(1);
//		Node n2 = new Node(2);
//		Node n3 = new Node(3);
//		Node n4 = new Node(4);
//List<Node> l1 = new ArrayList<>(Arrays.asList(n2, n3));
//List<Node> l2 = new ArrayList<>(Arrays.asList(n1, n3));
//List<Node> l3 = new ArrayList<>(Arrays.asList(n2, n4));
//List<Node> l4 = new ArrayList<>(Arrays.asList(n1, n3));
//		cloneGraph.cloneGraph(n1);

		FindTheCelebrity findTheCelebrity = new FindTheCelebrity();
		// findTheCelebrity.findCelebrity2(3);

		RateLimiter rateLimiter = new RateLimiter(1, 60);
		System.out.println(rateLimiter.rateLimit(1));
		System.out.println(rateLimiter.rateLimit(2));
		System.out.println(rateLimiter.rateLimit(1));
		System.out.println(rateLimiter.rateLimit(1));
		System.out.println(rateLimiter.rateLimit(1));
		System.out.println(rateLimiter.rateLimit(1));
		System.out.println(rateLimiter.rateLimit(1));
		System.out.println(rateLimiter.rateLimit(1));
		System.out.println(rateLimiter.rateLimit(1));
		System.out.println(rateLimiter.rateLimit(1));
		System.out.println(rateLimiter.rateLimit(1));
		System.out.println(rateLimiter.rateLimit(1));
		System.out.println(rateLimiter.rateLimit(1));
		System.out.println(rateLimiter.rateLimit(2));

		ArrayPractice<Integer> arr100 = new ArrayPractice<>();
		// System.out.println(arr.size());
		arr100.add(10);
		arr100.add(20);
		// System.out.println(arr.size());
		arr100.add(30);
		// System.out.println(arr.size());
		arr100.add(40);
		// System.out.println(arr.size());
		arr100.add(50);
		// System.out.println(arr.size());
		arr100.remove(0);
		arr100.print();
		arr100.remove(3);
		arr100.print();
		arr100.remove(2);
		arr100.print();
		arr100.remove(1);
		arr100.print();

	}
}