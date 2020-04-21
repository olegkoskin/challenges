package week3.leftmost_column_with_at_least_a_one;

import java.util.Arrays;
import java.util.List;

public class TestBinaryMatrix implements BinaryMatrix {

    private final int[][] mat;
    private final int n;
    private final int m;

    public TestBinaryMatrix(int[][] mat) {
        this.n = mat.length;
        this.m = mat[0].length;
        this.mat = new int[n][];
        for (int i = 0; i < n; i++) {
            this.mat[i] = Arrays.copyOf(mat[i], m);
        }
    }
    @Override
    public int get(int x, int y) {
        return mat[x][y];
    }

    @Override
    public List<Integer> dimensions() {
        return Arrays.asList(n, m);
    }
}
