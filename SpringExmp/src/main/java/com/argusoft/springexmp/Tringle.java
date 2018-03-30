package com.argusoft.springexmp;


import java.awt.Point;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author naimish
 */
public class Tringle {
    Point point;
    private Point p1,p2,p3;

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Point getP3() {
        return p3;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }

  
    
    public void draw(){
       
        System.out.println("p1"+getP1().getX()+" "+getP1().getY() );
         System.out.println("p2"+getP2().getX()+" "+getP2().getY() );
          System.out.println("p3"+getP3().getX()+" "+getP3().getY() );
    }
}
