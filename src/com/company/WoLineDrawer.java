package com.company;

import java.awt.*;

public class WoLineDrawer implements LineDrawer {
    private PixelDrawer pd;

    WoLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }


    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        if (x2 < x1) {
            x1 += x2;
            x2 = x1 - x2;
            x1 -= x2;
            y1 += y2;
            y2 = y1 - y2;
            y1 -= y2;
        }
        int dx = x2 - x1;
        int dy = y2 - y1;
        //Горизонтальные и вертикальные линии не нуждаются в сглаживании
        if (dx == 0 || dy == 0) {
            pd.drawPixel(x1, y1, java.awt.Color.BLACK);
            return;
        }
        float gradient = 0;
        if (dx > dy) {
            gradient = (float) dy / dx;
            float intery = y1 + gradient;
            java.awt.Color c = (new java.awt.Color(0, 0, 0, (int) (255 - fractionalPart(intery) * 255)));
            pd.drawPixel(x1, y1, java.awt.Color.black);
            for (int x = x1; x < x2; ++x) {
//                g.setColor(new Color(0, 0, 0, (int) (fractionalPart(intery) * 255))); //Меняем прозрачность
                pd.drawPixel(x, (int)intery, c);
//                g.setColor(new Color(0, 0, 0, (int) (fractionalPart(intery) * 255)));
                pd.drawPixel(x, (int)intery + 1, c);
                intery += gradient;
            }
            pd.drawPixel(x2, y2, java.awt.Color.black);
        }
        else {
            gradient = (float) dx / dy;
            float interx = x1 + gradient;
            pd.drawPixel(x1, y1, java.awt.Color.black);
            for (int y = y1; y < y2; ++y) {
                java.awt.Color c = (new java.awt.Color(0, 0, 0, (int) (255 - fractionalPart(interx) * 255)));
                pd.drawPixel((int)interx, y, c);
                java.awt.Color c2 = (new java.awt.Color(0, 0, 0, (int) (fractionalPart(interx) * 255)));
                pd.drawPixel((int)interx + 1, y, c2);
                interx += gradient;
            }
            pd.drawPixel(x2, y2, Color.black);
        }

    }

    private float fractionalPart(float x) {
        int tmp = (int) x;
        return x - tmp; //вернёт дробную часть числа
    }

}
