package dp;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<Integer> minlen = triangle.get(n - 1);
        for (int layer = n - 2; layer >= 0; layer--) // For each layer
        {
            for (int i = 0; i <= layer; i++) // Check its every 'node'
            {
                // Find the lesser of its two children, and sum the current value in the triangle with it.
                minlen.set(i, Math.min(minlen.get(i), minlen.get(i + 1)) + triangle.get(layer).get(i));
            }
        }
        return minlen.get(0);
    }
}
