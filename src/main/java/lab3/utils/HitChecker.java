package lab3.utils;

import static java.lang.Math.pow;

public class HitChecker {
    private static boolean checkArea(int x, float y, int R) {
        if (x >= 0) {
            if (y >= 0) {
                // Четверть круга
                return pow(x, 2) + pow(y, 2) <= pow((float) R, 2);
            } else {
                // прямоугольник
                return x <= R && y >= (float) -R / 2;
            }
        } else {
            if (y >= 0) {
                // треугольник, под прямой y = x + R
                return y < x + R;
            } else {
                //  ничего
                return false;
            }
        }
    }
}
