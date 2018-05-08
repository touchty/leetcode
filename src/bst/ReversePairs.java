package bst;

import java.util.Arrays;

public class ReversePairs {
    class Node {
        int val, cnt;
        Node left, right;

        Node(int val) {
            this.val = val;
            this.cnt = 1;
        }
    }

    private int search(Node root, long val) {
        if (root == null) {
            return 0;
        } else if (val == root.val) {
            return root.cnt;
        } else if (val < root.val) {
            return root.cnt + search(root.left, val);
        } else {
            return search(root.right, val);
        }
    }

    private Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
        } else if (val == root.val) {
            root.cnt++;
        } else if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.cnt++;
            root.right = insert(root.right, val);
        }

        return root;
    }

    public int reversePairs(int[] nums) {
        int res = 0;
        Node root = null;

        for (int ele : nums) {
            res += search(root, 2L * ele + 1);
            root = insert(root, ele);
        }

        return res;
    }

    // Very Short and Clear MergeSort & BST Java Solutions
    public int reversePairs_MergeSort(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    private int mergeSort(int[] nums, int s, int e){
        if(s>=e) return 0;
        int mid = s + (e-s)/2;
        // after mergeSort1(nums, s, mid), nums[s...mid] is sorted.
        // after mergeSort1(nums, mid+1,e), nums[mid+1...e] is sorted.
        int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e);

        // compare between two sorted subarrays, position of i and j respectively
        for(int i = s, j = mid+1; i<=mid; i++){
            while(j<=e && nums[i]/2.0 > nums[j]) j++;
            cnt += j-(mid+1);
        }
        Arrays.sort(nums, s, e+1);
        return cnt;
    }
}
