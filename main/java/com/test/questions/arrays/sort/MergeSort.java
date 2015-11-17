package com.test.questions.arrays.sort;

/**
 * Created by remote on 10/22/15.
 */
public class MergeSort extends AbstractBaseSort
{
	@Override
	public void sort(int[] array, int len)
	{
		int[] common = new int[len];

		sort(array, common, 0, len - 1);
	}

	private void merge(int[] array, int[] common, int low, int mid, int high)
	{
		System.arraycopy(array, low, common, low, (high - low + 1));

		int left = low;

		int right = mid + 1;

		int cnt = low;

		while (left <= mid && right <= high)
		{
			if (common[left] < common[right])
			{
				array[cnt] = common[left];

				left++;
			}
			else
			{
				array[cnt] = common[right];

				right++;
			}

			cnt++;
		}

		System.arraycopy(common, left, array, cnt, (mid - left) + 1);
	}

	public static void main(String[] args)
	{
		MergeSort mergeSort = new MergeSort();

		mergeSort.sort();
	}


	private void sort(int[] array, int[] common, int start, int end)
	{
		if (start < end)
		{
			int mid = (end + start) / 2;

			sort(array, common, start, mid);
			sort(array, common, mid + 1, end);

			merge(array, common, start, mid, end);
		}
	}
}
