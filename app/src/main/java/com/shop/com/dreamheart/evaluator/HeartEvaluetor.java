package com.shop.com.dreamheart.evaluator;

import android.animation.TypeEvaluator;

import com.shop.com.dreamheart.model.Heart;

/**
 * Created by caozhiyu on 17/5/22.
 */
public class HeartEvaluetor implements TypeEvaluator<Heart> {

    @Override
    public Heart evaluate(float v, Heart start, Heart end) {
        Heart heart = new Heart();
        heart.setX(start.getX() + v * (end.getX() - start.getX()));
        heart.setY(start.getY() + v * (end.getY() - start.getY()));
        heart.setRadius(start.getRadius() + v * (end.getRadius() - start.getRadius()));
        return heart;
    }
}
