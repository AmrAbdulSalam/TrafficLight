package com.company;

import javax.swing.*;
import java.awt.*;

public class TrafficLightPanel extends JPanel {
    private boolean lightRed , lightYellow , lightGreen;
    private MyThread thread;

    public void setGreen(){
        lightGreen = true;
    }
    public void clearGreen(){
        lightGreen = false;
    }

    public void setRed(){
        lightRed = true;
    }
    public void clearRed(){
        lightRed = false;
    }

    public void setYellow(){
        lightYellow = true;
    }
    public void clearYellow(){
        lightYellow = false;
    }
    //constrouctor
    public TrafficLightPanel(){
        lightGreen = lightRed = lightYellow = false;
        thread = new MyThread("Test!");
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D s = (Graphics2D) g;
        super.paintComponent(g);
        s.setStroke(new BasicStroke(5));
        g.setColor(Color.BLACK);

        g.drawRect(20 , 50 ,100 , 200);
        s.setStroke(new BasicStroke(3));
        g.setColor(Color.RED);
        g.drawArc(45 , 60 ,50 , 50 , 0 , 360);

        s.setStroke(new BasicStroke(3));
        g.setColor(Color.YELLOW);
        g.drawArc(45 , 120 ,50 , 50 , 0 , 360);

        s.setStroke(new BasicStroke(3));
        g.setColor(Color.GREEN);
        g.drawArc(45 , 180 ,50 , 50 , 0 , 360);

        repaint();
        // for filling
        if (lightRed){
            //if the set it true
            g.setColor(Color.RED);
            g.fillArc(45 , 60 ,50 , 50 , 0 , 360);
        }
        if (lightYellow){
            g.setColor(Color.YELLOW);
            g.fillArc(45 , 120 ,50 , 50 , 0 , 360);
        }
        if (lightGreen){
            g.setColor(Color.GREEN);
            g.fillArc(45 , 180 ,50 , 50 , 0 , 360);
        }


    }

    //inner class
    class MyThread extends Thread {
        private String name ;

        public MyThread(String name){
            super(name);
            this.name = name;
            start();
        }
        public void run(){
            while (true){
                try{
                    setRed();
                    Thread.sleep(20000);
                    setYellow();
                    Thread.sleep(5000);
                    clearRed();
                    clearYellow();
                    setGreen();
                    Thread.sleep(20000);
                    clearGreen();
                    setYellow();
                    Thread.sleep(5000);
                    clearYellow();

                }
                catch (InterruptedException exception){
                    System.out.println(exception.toString());
                }
            }
        }
    }

}
