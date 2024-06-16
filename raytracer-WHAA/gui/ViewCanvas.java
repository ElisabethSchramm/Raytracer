package gui;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ViewCanvas extends Canvas {

    /**
     * BufferedImage das auf diesem Canvas gezeichnet wird
     */
    private BufferedImage bufferedImage;

     public void setImage(final BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
        this.setPreferredSize(new Dimension( bufferedImage.getWidth(), bufferedImage.getHeight()));
        repaint(); 
        invalidate();
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    @Override
    public void paint(final Graphics g) {

        if (bufferedImage != null) {
            g.drawImage(bufferedImage, 0, 0, this);
        }       
    }
}

