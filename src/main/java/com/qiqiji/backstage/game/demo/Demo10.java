package com.qiqiji.backstage.game.demo;

public class Demo10 {
    public static void main(String[] args) {
        /**
         * 判断点和圆的关系
         * */
        System.out.println("圆的半径为5,点的坐标为[3,4]");
        Point point = new Point(3, 4);
        Circle circle = new Circle(4);
        int res = circle.Judgement(point);
        System.out.println(res);
    }
}

class Point {
    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

class Circle {
    private int r;

    Circle(int r) {
        this.r = r;
    }

    int Judgement(Point point) {
        int x = point.getX();
        int y = point.getY();
        int xx = x * x;
        int yy = y * y;
        int rr = r * r;
        int xxyy = xx + yy;
        if (xxyy > rr) {
            return 1;//圆外
        } else if (xxyy < rr) {
            return -1;//圆内
        } else {
            return 0;
        }
    }
}
