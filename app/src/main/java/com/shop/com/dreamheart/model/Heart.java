package com.shop.com.dreamheart.model;

/**
 * Created by caozhiyu on 17/5/22.
 * <p/>
 * 描述桃心
 */
public class Heart {

    // 半径
    private float radius;
    // 圆心坐标
    private float x;
    private float y;


    public Heart() {

    }

    public Heart(float x, float y, float radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getRadius() {
        return radius;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}
