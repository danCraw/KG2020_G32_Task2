package com.company;

import utils.DrawUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel implements MouseMotionListener, KeyListener, MouseListener {

    private int drawAlgorithm = 0;
    private Point position = new Point(0, 0);

    DrawPanel() {
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.addKeyListener(this);
    }


    @Override
    public void paint(Graphics g) {
        LineDrawer ld = null;
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics bi_g = bi.createGraphics();
        bi_g.setColor(Color.WHITE);
        bi_g.fillRect(0, 0, getWidth(), getHeight());
        bi_g.setColor(Color.black);
        PixelDrawer pd = new GraphicsPixelDrawer(bi_g);

        if (drawAlgorithm == 0) {
            ld = new DDALineDrawer(pd);
        }
        if (drawAlgorithm == 1) {
            ld = new BresenhamLineDrawer(pd);
        }
        if (drawAlgorithm == 2) {
            ld = new WoLineDrawer(pd);
        }
        if (drawAlgorithm > 2) {
            drawAlgorithm = 0;
        }
        drawAll(ld, pd);
        g.drawImage(bi, 0, 0, null);
        bi_g.dispose();
    }

    private void drawAll(LineDrawer ld, PixelDrawer pd) {
        DrawUtils.drawSnowFlake(ld, getWidth() / 2, getHeight() / 2, 100, 70);
        DrawUtils.drawCircle(pd, 100, 100, 50);
        ld.drawLine(getWidth() / 2, getHeight() / 2, position.x, position.y);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
            System.err.println(keyEvent.getKeyCode());
        if (keyEvent.getKeyCode()==KeyEvent.VK_LEFT) {
            System.err.println(KeyEvent.VK_LEFT);
            drawAlgorithm--;
            repaint();
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            drawAlgorithm++;
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }


    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }


    @Override
    public void mouseMoved(MouseEvent e) {
        position = new Point(e.getX(), e.getY());
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        drawAlgorithm++;
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
