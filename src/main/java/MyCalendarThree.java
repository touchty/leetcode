class MyCalendarThree {
    public MyCalendarThree() {
        root = new TreeNode(0, 1000000000);
    }

    public int book(int start, int end) {
        add(root, start, end, 1);
        return getMax(root);
    }

    private class TreeNode {
        int start;
        int end;
        TreeNode left = null;
        TreeNode right = null;
        /* How much number is added to this interval(node)*/
        int booked = 0;

        /*The maximum number in this interval(node)*/
        int saved = 0;

        public TreeNode(int s, int t) {
            this.start = s;
            this.end = t;
        }
    }

    private TreeNode root;

    private void add(TreeNode node, int start, int end, int val) {
        if (node == null || start >= node.end || end < node.start) return;
        /**
         * If current node's range lies completely in update query range.
         */
        if (start <= node.start && node.end <= end) {
            node.booked += val;
            node.saved += val;
            return;
        }
        /**
         * If current node's range overlaps with update range, follow the same approach as above simple update.
         */
        int mid = node.start + (node.end - node.start) / 2;
        if (overlap(node.start, mid, start, end)) {
            if (node.left == null) node.left = new TreeNode(node.start, mid);
            add(node.left, start, end, val);
        }

        if (overlap(mid, node.end, start, end)) {
            if (node.right == null) node.right = new TreeNode(mid, node.end);
            add(node.right, start, end, val);
        }
        // Update current node using results of left and right calls.
        node.saved = node.booked + Math.max(getMax(node.left), getMax(node.right));
    }

    private int getMax(TreeNode node) {
        if (node == null) return 0;
        return node.saved;
    }

    private boolean overlap(int s, int e, int l, int r) {
        if (r <= s || l >= e) return false;
        return true;
    }
}