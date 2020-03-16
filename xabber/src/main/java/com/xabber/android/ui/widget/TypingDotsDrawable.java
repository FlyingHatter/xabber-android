package com.xabber.android.ui.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.view.animation.DecelerateInterpolator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.xabber.android.R;
import com.xabber.android.data.Application;
import com.xabber.android.data.log.LogManager;
import com.xabber.android.utils.Utils;

public class TypingDotsDrawable extends Drawable {

    private Paint dotPaint = new Paint();

    private float[] scale = new float[3];
    private float[] startTimes = new float[] {0, 150, 300};
    private float[] elapsedTimes = new float[] {0, 0, 0};
    private long lastUpdateTime;
    private DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
    private boolean started;

    public TypingDotsDrawable() {
        dotPaint.setColor(Application.getInstance().getResources().getColor(R.color.red_500));
        dotPaint.setAntiAlias(true);
    }

    private void update() {
        long newTime = System.currentTimeMillis();
        long dt = newTime - lastUpdateTime;
        lastUpdateTime = newTime;
        if (dt > 50) {
            dt = 50;
        }

        for (int a = 0; a < 3; a++) {
            elapsedTimes[a] += dt;
            float timeSinceStart = elapsedTimes[a] - startTimes[a];
            if (timeSinceStart > 0) {
                if (timeSinceStart <= 320) {
                    float diff = decelerateInterpolator.getInterpolation(timeSinceStart / 320.0f);
                    scale[a] = 1.33f + diff;
                } else if (timeSinceStart <= 640) {
                    float diff = decelerateInterpolator.getInterpolation((timeSinceStart - 320.0f) / 320.0f);
                    scale[a] = 1.33f + (1 - diff);
                } else if (timeSinceStart >= 800) {
                    elapsedTimes[a] = 0;
                    startTimes[a] = 0;
                    scale[a] = 1.33f;
                } else {
                    scale[a] = 1.33f;
                }
            } else {
                scale[a] = 1.33f;
            }
        }

        invalidateSelf();
    }

    public void start() {
        lastUpdateTime = System.currentTimeMillis();
        started = true;
        invalidateSelf();
    }

    public boolean isStarted() {
        return started;
    }

    public void stop() {
        for (int a = 0; a < 3; a++) {
            elapsedTimes[a] = 0;
            scale[a] = 1.33f;
        }
        startTimes[0] = 0;
        startTimes[1] = 150;
        startTimes[2] = 300;
        started = false;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        canvas.drawCircle(Utils.dipToPxFloat(3, Application.getInstance()),
                Utils.dipToPxFloat(10, Application.getInstance()),
                Utils.dipToPxFloat(scale[0], Application.getInstance()),
                dotPaint);

        canvas.drawCircle(Utils.dipToPxFloat(9, Application.getInstance()),
                Utils.dipToPxFloat(10, Application.getInstance()),
                Utils.dipToPxFloat(scale[1], Application.getInstance()),
                dotPaint);

        canvas.drawCircle(Utils.dipToPxFloat(15, Application.getInstance()),
                Utils.dipToPxFloat(10, Application.getInstance()),
                Utils.dipToPxFloat(scale[2], Application.getInstance()),
                dotPaint);
        LogManager.d("TypingDots", "first dot = " + scale[0] + " second dot = " + scale[1] + " third dot = " + scale[2]);
        if (started) {
            Application.getInstance().runOnUiThreadDelay(new Runnable() {
                @Override
                public void run() {
                    update();
                }
            }, 20);
        }
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSPARENT;
    }

    @Override
    public int getIntrinsicWidth() {
        return Utils.dipToPx(18, Application.getInstance());
    }

    @Override
    public int getIntrinsicHeight() {
        return Utils.dipToPx(18, Application.getInstance());
    }
}
