package com.shop.com.dreamheart.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.shop.com.dreamheart.evaluator.HeartEvaluetor;
import com.shop.com.dreamheart.model.Heart;

/**
 * Created by caozhiyu on 17/5/22.
 */
public class HeartView extends View {

    public static final float MAX_RADIUS = 100.0f;
    public static final float MIN_RADIUS = 0.0f;

    private Paint paint;
    private Heart heart;
    private Path path;


    public HeartView(Context context) {
        super(context);
        init();
    }

    public HeartView(Context context, AttributeSet set) {
        super(context, set);
        init();
    }

    public HeartView(Context context, AttributeSet set, int delStyles) {
        super(context, set, delStyles);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.YELLOW);
        path = new Path();
    }

    private void drawHeart(Canvas canvas) {
        float x = heart.getX();
        float y = heart.getY();
        float radius = heart.getRadius();
        path.moveTo(x, y);
        // 根据心形函数画图
        for (double j = 0; j <= 2 * Math.PI; j += 0.001) {
             x = (float) (16 * Math.sin(j) * Math.sin(j) * Math.sin(j));
             y = (float) (13 * Math.cos(j) - 5 * Math.cos(2 * j) - 2
                    * Math.cos(3 * j) - Math.cos(4 * j));
            x *= radius;
            y *= radius;
            x = heart.getX() - x;
            y = heart.getY() - y;
            path.moveTo(x, y);
        }
        canvas.drawPath(path,paint);
    }

    private void startAnimation() {
        Heart start = new Heart(getWidth() - MAX_RADIUS, getHeight() - MAX_RADIUS, MAX_RADIUS);
        Heart end = new Heart(MIN_RADIUS, MIN_RADIUS, MIN_RADIUS);
        ValueAnimator animator = ValueAnimator.ofObject(new HeartEvaluetor(), start, end);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                heart = (Heart) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        animator.setDuration(6000);
        animator.start();

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (heart == null) {
            heart = new Heart(getWidth() - MAX_RADIUS, getHeight() - MAX_RADIUS, MAX_RADIUS);
            drawHeart(canvas);
            startAnimation();
        } else {
            drawHeart(canvas);
        }
    }
}
