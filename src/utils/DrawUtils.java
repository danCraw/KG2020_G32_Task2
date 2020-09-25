package utils;

import com.company.LineDrawer;
import com.company.PixelDrawer;

import java.awt.*;

public class DrawUtils {
    public static void drawSnowFlake(LineDrawer ld, int x, int y, int r, int n) {
        double da = 2 * Math.PI / n;
        for (int i = 0; i < n; i++) {
            double dx = r * Math.cos(da * i);
            double dy = r * Math.sin(da * i);
            ld.drawLine(x, y, x + (int) dx, y + (int) dy);
        }
    }

    public static void drawCircle(PixelDrawer pd, int x, int y, int r) {
        int curX, curY;
        for (curY = 1; curY < r * r; curY++) {
            curX = (int) Math.sqrt(r^2-y^2);
            pd.drawPixel(curX, curY, Color.black);
        }
    }
}
