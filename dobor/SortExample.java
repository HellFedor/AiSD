package DoborAisd;


import java.util.Arrays;

public class SortExample {
    public static void main(String[] args) {
        int[] arr = generateRandomArray(1000);
        int[] arrCopy1 = Arrays.copyOf(arr, arr.length);
        int[] arrCopy2 = Arrays.copyOf(arr, arr.length);

        long startTime = System.nanoTime();
        treeSort(arrCopy1);
        long endTime = System.nanoTime();
        long treeSortTime = endTime - startTime;

        startTime = System.nanoTime();
        bucketSort(arrCopy2);
        endTime = System.nanoTime();
        long bucketSortTime = endTime - startTime;

        System.out.println("Tree Sort Iterations: " + treeSortTime);
        System.out.println("Bucket Sort Iterations: " + bucketSortTime);

        if (treeSortTime < bucketSortTime) {
            System.out.println("Tree Sort has fewer iterations.");
        } else if (bucketSortTime < treeSortTime) {
            System.out.println("Bucket Sort has fewer iterations.");
        } else {
            System.out.println("Both sorting algorithms have the same number of iterations.");
        }
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        return arr;
    }

    public static void treeSort(int[] arr) {
        TreeNode root = null;
        for (int num : arr) {
            root = insert(root, num);
        }
        inorderTraversal(root, arr);
    }

    public static TreeNode insert(TreeNode root, int num) {
        if (root == null) {
            return new TreeNode(num);
        }
        if (num < root.val) {
            root.left = insert(root.left, num);
        } else if (num > root.val) {
            root.right = insert(root.right, num);
        }
        return root;
    }

    public static void inorderTraversal(TreeNode root, int[] arr) {
        if (root != null) {
            inorderTraversal(root.left, arr);
            System.out.print(root.val + " ");
            inorderTraversal(root.right, arr);
        }
    }

    public static void bucketSort(int[] arr) {
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for (int num : arr) {
            maxVal = Math.max(maxVal, num);
            minVal = Math.min(minVal, num);
        }

        int bucketCount = (maxVal - minVal) / arr.length + 1;
        int[][] buckets = new int[bucketCount][0];

        for (int num : arr) {
            int bucketIndex = (num - minVal) / arr.length;
            buckets[bucketIndex] = appendToBucket(buckets[bucketIndex], num);
        }

        int index = 0;
        for (int[] bucket : buckets) {
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
    }

    public static int[] appendToBucket(int[] bucket, int num) {
        int[] newBucket = Arrays.copyOf(bucket, bucket.length + 1);
        newBucket[newBucket.length - 1] = num;
        return newBucket;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}