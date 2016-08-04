import java.util.HashMap;

public class LeetCodeTest {

	/*
	 * 1. Two Sum
	 */
	public static int[] twoSum(int[] nums, int target) {
		int result[] = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
				}
			}
		}
		return result;
	}

	public static int lengthOfLongestSubstring(String s) {
		int maxLength = 1;
		int result = 0;
		int s_len = s.length();
		HashMap<Character, Boolean> charMap = new HashMap<Character, Boolean>();
		for (int i = 0; i < s_len; i++) {
			maxLength = 1;
			charMap.put(s.charAt(i), true);
			for (int j = i + 1; j < s_len; j++) {
				if (charMap.containsKey(s.charAt(j))) {
					charMap.clear();
					break;
				} else {
					charMap.put(s.charAt(j), true);
					maxLength++;
				}
			}

			if (maxLength > result) {
				result = maxLength;
			}
		}
		return result;
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		int unionLen = len1 + len2;
		int i = 0;
		int j = 0;
		int k = 0;

		int[] unionNums = new int[len1 + len2];
		while ((i < len1) && (j < len2) && (k < unionLen)) {
			if (nums1[i] < nums2[j]) {
				unionNums[k++] = nums1[i++];
			} else if (nums1[i] > nums2[j]) {
				unionNums[k++] = nums2[j++];
			} else {
				unionNums[k++] = nums1[i];
				i++;
				j++;
			}
		}
		
		if ( i == len1)
		{
			while(j < len2)
			{
				unionNums[k++] = nums2[j++];
			}
		}
		
		return k;
	}

	public static void main(String[] args) {
		String s = "bbbbb";
		int result = lengthOfLongestSubstring(s);
		System.out.println(result);
	}
}
