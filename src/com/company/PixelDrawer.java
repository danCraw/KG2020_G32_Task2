package com.company;

import java.awt.*;

public interface PixelDrawer {
    default void drawPixel(int x, int y, Color C) {
    }
}
