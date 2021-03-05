package org.example;

import java.util.Arrays;

public class Task32 {

    public static void main(String[] args) {
        Matrix matrix = new Matrix(new int[][]
                {
                        {0, 7, 0, 17, 0, 1, 0, 5, 0, 2},
                        {0, 0, 29, 0, 28, 0, 3, 0, 16, 0},
                        {0, 3, 0, 0, 0, 1, 0, 0, 0, 0},
                        {48, 0, 3, 0, 0, 0, 17, 0, 0, 0},
                        {0, 6, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                });

        matrix.print();

        System.out.println("R submatrix:");
        Matrix R = matrix.getRSubmatrix();
        R.print();

        System.out.println("Q submatrix:");
        Matrix Q = matrix.getQSubmatrix();
        Q.print();

        System.out.println("Identity matrix:");
        Matrix I = matrix.getIdentityMatrix();
        I.print();

        System.out.println("I - Q:");
        Matrix IQ = Matrix.subtract(I, Q);
        IQ.print();

        System.out.println("Determinant (I - Q):");
        Fraction det_IQ = Matrix.determinant(IQ);
        System.out.println(det_IQ);
        System.out.println("______________________");

        System.out.println("F ((I - Q)^-1):");
        Matrix F = Matrix.inverse(IQ);
        F.print();

        System.out.println("FR:");
        Matrix FR = Matrix.multiply(F, R);
        FR.print();

        System.out.println(Arrays.toString(getAnswer(FR)));
    }

    static final Fraction ZERO = new Fraction(0, 1);
    static final Fraction ONE = new Fraction(1, 1);

    public static int[] solution(int[][] m) {
        Matrix matrix = new Matrix(m);

        if (matrix.isRowTerminal(0) && matrix.M == 1) {
            return new int[]{1, 1};
        }

        if (matrix.isRowTerminal(0)) {
            int[] answer = new int[matrix.M];
            answer[0] = 1;
            for (int i = 1; i < matrix.M - 1; i++) {
                answer[i] = 0;
            }
            answer[matrix.M - 1] = 1;
            return answer;
        }

        Matrix Q = matrix.getQSubmatrix();
        Matrix R = matrix.getRSubmatrix();
        Matrix I = matrix.getIdentityMatrix();
        Matrix I_Q = Matrix.subtract(I, Q);
        Matrix F = Matrix.inverse(I_Q);
        Matrix FR = Matrix.multiply(F, R);

        return getAnswer(FR);
    }

    public static int[] getAnswer(Matrix FR) {
        int[] result = new int[FR.N + 1];
        Fraction[] probabilities = FR.getFirstRow();
        int lcm = Fraction.lcm(probabilities);
        for (int i = 0; i < probabilities.length; i++) {
            Fraction fraction = probabilities[i];
            result[i] = lcm / fraction.denom * fraction.num;
        }
        result[result.length - 1] = lcm;
        return result;
    }

    static class Matrix {

        private final Fraction[][] inner;
        private final int M;
        private final int N;

        public Matrix(int[][] matrix) {
            this.M = matrix.length;
            this.N = matrix[0].length;
            this.inner = fromIntArray(matrix);
            reorder();
        }

        public Matrix(int rowsNum, int colsNum) {
            this.M = rowsNum;
            this.N = colsNum;
            this.inner = new Fraction[M][N];
        }

        public void print() {
            for (Fraction[] cols : inner) {
                for (int j = 0; j < inner[0].length; j++) {
                    System.out.print(cols[j] + " ");
                }
                System.out.println();
            }
            System.out.println("______________________");
        }

        public Fraction[] getFirstRow() {
            return inner[0];
        }

        private void reorder() {
            for (int i = M - 2; i >= 0; i--) {
                if (isRowTerminal(i)) {
                    int rowNum = i;
                    while (!isRowTerminal(rowNum + 1)) {
                        moveRowDown(rowNum);
                        moveColRight(rowNum);
                        rowNum++;
                    }
                }
            }
        }

        private void moveRowDown(int rowNum) {
            Fraction[] temp = inner[rowNum + 1];
            inner[rowNum + 1] = inner[rowNum];
            inner[rowNum] = temp;
        }

        private void moveColRight(int colNum) {
            for (int i = 0; i < M; i++) {
                Fraction temp = inner[i][colNum + 1];
                inner[i][colNum + 1] = inner[i][colNum];
                inner[i][colNum] = temp;
            }
        }

        Matrix getSubmatrix(int rowsNum, int fromCol, int toCol) {
            Matrix submatrix = new Matrix(rowsNum, toCol - fromCol + 1);
            for (int i = 0, iSub = 0; i < rowsNum; i++, iSub++) {
                for (int j = fromCol, jSub = 0; j <= toCol; j++, jSub++) {
                    submatrix.inner[iSub][jSub] = this.inner[i][j];
                }
            }
            return submatrix;
        }

        private Fraction[][] fromIntArray(int[][] arr) {
            Fraction[][] matrix = new Fraction[M][N];
            for (int i = 0; i < arr.length; i++) {
                int denom = getRowSum(arr[i]);
                for (int j = 0; j < arr[i].length; j++) {
                    matrix[i][j] = new Fraction(arr[i][j], denom);
                }
            }
            return matrix;
        }

        static int getRowSum(int[] row) {
            return Arrays.stream(row).sum();
        }

        boolean isRowTerminal(int row) {
            return Arrays.stream(inner[row]).allMatch(i -> i.equals(ZERO));
        }

        public int getNumOfTerminalRows() {
            int num = 0;
            for (int i = 0; i < inner.length; i++) {
                if (isRowTerminal(i)) num++;
            }
            return num;
        }

        public int getNumOfNonTerminalRows() {
            return N - getNumOfTerminalRows();
        }

        public static Matrix subtract(Matrix m1, Matrix m2) {
            Matrix result = new Matrix(m1.M, m1.N);
            for (int i = 0; i < m1.M; i++) {
                for (int j = 0; j < m1.N; j++) {
                    result.inner[i][j] = Fraction.subtract(m1.inner[i][j], m2.inner[i][j]);
                }
            }
            return result;
        }

        Matrix getQSubmatrix() {
            return getSubmatrix(getNumOfNonTerminalRows(), 0, getNumOfNonTerminalRows() - 1);
        }

        Matrix getRSubmatrix() {
            return getSubmatrix(getNumOfNonTerminalRows(), getNumOfNonTerminalRows(), M - 1);
        }

        Matrix getIdentityMatrix() {
            Matrix identityMatrix = new Matrix(getNumOfNonTerminalRows(), getNumOfNonTerminalRows());
            for (int i = 0; i < identityMatrix.M; i++) {
                for (int j = 0; j < identityMatrix.N; j++) {
                    if (i == j) {
                        identityMatrix.inner[i][j] = ONE;
                    } else {
                        identityMatrix.inner[i][j] = ZERO;
                    }
                }
            }
            return identityMatrix;
        }

        private static Fraction determinant(Matrix matrix) {
            if (matrix.M == 1) {
                return matrix.inner[0][0];
            }
            if (matrix.M == 2) {
                Fraction m1 = Fraction.multiply(matrix.inner[0][0], matrix.inner[1][1]);
                Fraction m2 = Fraction.multiply(matrix.inner[0][1], matrix.inner[1][0]);
                return Fraction.subtract(m1, m2);
            }

            Fraction det = ZERO;
            for (int i = 0; i < matrix.N; i++) {
                double pow = Math.pow(-1, i);
                int sign = pow < 0 ? -1 : 1;
                Fraction m1 = Fraction.multiply(new Fraction((int) pow, 1, sign), matrix.inner[0][i]);
                Fraction m2 = determinant(minor(matrix, 0, i));
                det = Fraction.add(det, Fraction.multiply(m1, m2));
            }
            return det;
        }

        private static Matrix inverse(Matrix matrix) {
            Matrix inverse = new Matrix(matrix.M, matrix.N);

            for (int i = 0; i < matrix.M; i++)
                for (int j = 0; j < matrix.N; j++) {
                    double pow = Math.pow(-1, i + j);
                    int sign = pow < 0 ? -1 : 1;
                    inverse.inner[i][j] = Fraction.multiply(new Fraction((int) pow, 1, sign),
                            determinant(minor(matrix, i, j)));
                }

            Fraction det = Fraction.inverse(determinant(matrix));

            for (int i = 0; i < inverse.M; i++) {
                for (int j = 0; j <= i; j++) {
                    Fraction temp = inverse.inner[i][j];
                    inverse.inner[i][j] = Fraction.multiply(inverse.inner[j][i], det);
                    inverse.inner[j][i] = Fraction.multiply(temp, det);
                }
            }
            return inverse;
        }

        private static Matrix minor(Matrix matrix, int row, int column) {
            Matrix minor = new Matrix(matrix.M - 1, matrix.N - 1);

            for (int i = 0; i < matrix.M; i++)
                for (int j = 0; i != row && j < matrix.N; j++)
                    if (j != column) {
                        minor.inner[i < row ? i : i - 1][j < column ? j : j - 1] = matrix.inner[i][j];
                    }
            return minor;
        }

        private static Matrix multiply(Matrix m1, Matrix m2) {
            Matrix result = new Matrix(m1.M, m2.N);
            for (int i = 0; i < m1.M; i++) {
                for (int j = 0; j < m2.N; j++) {
                    Fraction sum = ZERO;
                    for (int k = 0; k < m1.N; k++)
                        sum = Fraction.add(sum, Fraction.multiply(m1.inner[i][k], m2.inner[k][j]));
                    result.inner[i][j] = sum;
                }
            }
            return result;
        }

    }

    static class Fraction {
        private int num;
        private int denom;
        private int sign;

        public Fraction(int num, int denom) {
            this(num, denom, 1);
        }

        public Fraction(int num, int denom, int sign) {
            this.num = Math.abs(num);
            this.denom = num == 0 ? 1 : Math.abs(denom);
            this.sign = sign;
            this.simplify();
        }

        static int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        static int lcm(int a, int b) {
            return (a * b) / gcd(a, b);
        }

        static int lcm(Fraction... arr) {
            int lcm = 1;
            for (int i = 0; i < arr.length - 1; i++) {
                int newLcm = lcm(arr[i].denom, arr[i + 1].denom);
                if (newLcm > lcm) {
                    lcm = newLcm;
                }
            }
            return lcm;
        }

        public void simplify() {
            int gcd = gcd(num, denom);
            num /= gcd;
            denom /= gcd;
        }

        public static Fraction add(Fraction f1, Fraction f2) {
            int denom = f1.denom * f2.denom;
            int signedNum = f1.num * f2.denom * f1.sign + f2.num * f1.denom * f2.sign;
            int sign = signedNum < 0 ? -1 : 1;
            int num = Math.abs(signedNum);
            return new Fraction(num, denom, sign);
        }

        public static Fraction subtract(Fraction f1, Fraction f2) {
            return add(f1, f2.changeSign());
        }

        public Fraction changeSign() {
            this.sign *= -1;
            return this;
        }

        public static Fraction multiply(Fraction f1, Fraction f2) {
            int num = f1.num * f2.num;
            int denom = f1.denom * f2.denom;
            int sign = f1.sign * f2.sign;
            return new Fraction(num, denom, sign);
        }

        public static Fraction inverse(Fraction f) {
            if (f.equals(ZERO)) return ZERO;
            return new Fraction(f.denom, f.num, f.sign);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Fraction fraction = (Fraction) o;
            return num == fraction.num && denom == fraction.denom && sign == fraction.sign;
        }

        @Override
        public String toString() {
            if (this.num == 0) return " 0 ";
            if (this.num == 1 && this.denom == 1) return " 1 ";
            String sign = this.sign == 1 ? "" : "-";
            return sign + num + "/" + denom;
        }
    }

}
