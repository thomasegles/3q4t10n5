package MainPackage;

public class CalcMatrix {
    private double[][] a;
    private double[][] b;
    private double[][] c;

    public CalcMatrix(double[][] usrC) {
        c = usrC;
        a = new double[c.length][c.length];
        makeMatrixA();
        b = new double[c.length][c.length];
    }

    protected void calcBack() {
        for (int i = 0; i < c[0].length; i++) {
            b[0][i] = c[0][i];
        }

        calcFirstColumnOfA();
        calcSecondRowOfB();

        //ersetzt durch calcFirstColumnOfA
        //a[1][0] = c[1][0] / b[0][0];

        //werden ersetzt durch calcSecondRowOfB
        //b[1][1] = c[1][1] - a[1][0] * b[0][1];
        //b[1][2] = c[1][2] - a[1][0] * b[0][2];

        //ersetzt durch calcFirstColumnOfA
        //a[2][0] = c[2][0] / b[0][0];

        a[2][1] = (c[2][1] - a[2][0] * b[0][1]) / b[1][1];
        b[2][2] = c[2][2] - a[2][0] * b[0][2] - a[2][1] * b[1][2];
    }

    private void calcFirstColumnOfA() {
        for (int i = 0; i < c.length; i++) {
            a[i][0] = c[i][0] / b[0][0];
        }
    }

    private void calcSecondRowOfB() {
        for (int i = 1; i < b.length; i++) {
            System.out.println(c[1][i] - a[1][0] * b[0][i]);
            b[1][i] = c[1][i] - a[1][0] * b[0][i];
        }
    }

    private void calcRowOfA() {

    }

    private void makeMatrixA() {
        for (int i = 0; i < c.length; i++) {
            a[i][i] = 1;
        }
    }

    protected void showMatrices() {
        System.out.println("Array A: ");
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Array B: ");
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }

}
