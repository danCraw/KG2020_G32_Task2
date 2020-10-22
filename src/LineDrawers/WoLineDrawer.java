package LineDrawers;

import KG.Task2.LineDrawer;
import KG.Task2.PixelDrawer;

import java.awt.*;

public class WoLineDrawer implements LineDrawer {

    private PixelDrawer pd;

    public WoLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        int x, y, dx, dy;
        boolean swap = false;

        if (Math.abs(y2 - y1) < Math.abs(x2 - x1)) {
            if (0 < x2 - x1) {
                x = x1;
                y = y1;
                dx = x2 - x1;
                dy = y2 - y1;
            } else {
                x = x2;
                y = y2;
                dx = x1 - x2;
                dy = y1 - y2;
            }
        } else {
            swap = true;
            if (0 < y2 - y1) {
                x = y1;
                y = x1;
                dx = y2 - y1;
                dy = x2 - x1;
            } else {
                x = y2;
                y = x2;
                dx = y1 - y2;
                dy = x1 - x2;
            }
        }
        int err = 0;
        for (int i = 0; i <= dx; i++) {
            drawWuPixel(x, y, err, dx, swap);
            err += 2 * dy;
            if (err > dx) {
                err -= 2 * dx;
                y++;
            } else if (err < -dx) {
                err += 2 * dx;
                y--;
            }
            x++;
        }
    }

    private void drawWuPixel(int x, int y, int err, int dx, boolean swap) {
        Color c =  Color.BLACK;
        Color c1, c2;

        int d = dx != 0 ? (255 * err) / (2 * dx) : 255;
        int dPos = Math.max(0, d);
        int dNeg = Math.max(0, -d);
        int dMax = 255 - Math.abs(d);

        c1 = setColor(255 - Math.abs(d), c);
        c2 = setColor(Math.abs(d), c);

        if (!swap) {
            pd.drawPixel(x, y, c1);
            if (dx != 0) {
                if (dPos > 0)
                    pd.drawPixel(x, y + 1, c2);
                else
                    pd.drawPixel(x, y - 1, c2);
            }
        } else {
            pd.drawPixel(y, x, c1);
            if (dx != 0) {
                if (dPos > 0)
                    pd.drawPixel(y + 1, x, c2);
                else
                    pd.drawPixel(y - 1, x, c2);
            }
        }
    }

    private Color setColor(int t, Color c) {
        return new Color(c.getRed(), c.getGreen(), c.getBlue(), t);
    }

    }
