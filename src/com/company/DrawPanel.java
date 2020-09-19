package com.company;

import LineDrawers.GraphicsLineDrawer;
import utils.DrawUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel {

    @Override
    public void paint(Graphics g) {
        LineDrawer ld = new GraphicsLineDrawer(g);
        BufferedImage bf = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics bi_g = 
        LineDrawer ld = new GraphicsLineDrawer(bi_g);
        DrawUtils.drawSnowFlake(ld, 300, 200, 100, 31);

    }
}
