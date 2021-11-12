package com.manggeek.android.geek.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;

import com.manggeek.android.geek.R;

import androidx.appcompat.widget.AppCompatImageView;


/**
 * Created by ${黄文飞} on 2017/7/21.
 */

public class RoundImageView extends AppCompatImageView {
    private Paint paint;
    private int roundWidth = 50;
    private int roundHeight = 50;
    private Paint paint2;

    public RoundImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    public RoundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private int cornerType;


    public void SetRoundValue(float roundValue) {
        roundWidth = (int) roundValue;
        roundHeight = (int) roundValue;
    }

    public RoundImageView(Context context) {
        super(context);
        init(context, null);
    }

    @SuppressLint("Recycle")
    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RoundImageView);
            roundWidth = a.getDimensionPixelSize(R.styleable.RoundImageView_roundWidth, roundWidth);
            roundHeight = a.getDimensionPixelSize(R.styleable.RoundImageView_roundHeight, roundHeight);
            cornerType = a.getInt(R.styleable.RoundImageView_cornerType, 0);
        } else {
            float density = context.getResources().getDisplayMetrics().density;
            roundWidth = (int) (roundWidth * density);
            roundHeight = (int) (roundHeight * density);
        }
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        paint2 = new Paint();
        paint2.setXfermode(null);
    }

    @Override
    public void draw(Canvas canvas) {
        Bitmap bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(bitmap);
        super.draw(canvas2);
        drawRoundRect(canvas2);
        canvas.drawBitmap(bitmap, 0, 0, paint2);
        bitmap.recycle();
    }

    private void drawRoundRect(Canvas canvas2) {
        switch (cornerType) {
            case 0:
                break;
            case 1:
                drawLiftUp(canvas2);
                drawRightUp(canvas2);
                drawLiftDown(canvas2);
                drawRightDown(canvas2);
                break;
            case 2:
                drawLiftUp(canvas2);
                drawLiftDown(canvas2);
                break;
            case 3:
                drawRightUp(canvas2);
                drawRightDown(canvas2);
                break;
            case 4:
                drawLiftUp(canvas2);
                drawRightUp(canvas2);
                break;
            case 5:
                drawLiftDown(canvas2);
                drawRightDown(canvas2);
                break;
        }
    }

    private void drawLiftUp(Canvas canvas) {
        Path path = new Path();
        path.moveTo(0, roundHeight);
        path.lineTo(0, 0);
        path.lineTo(roundWidth, 0);
        path.arcTo(new RectF(0, 0, roundWidth * 2, roundHeight * 2), -90, -90);
        path.close();
        canvas.drawPath(path, paint);
    }

    private void drawRightUp(Canvas canvas) {
        Path path = new Path();
        path.moveTo(getWidth(), roundHeight);
        path.lineTo(getWidth(), 0);
        path.lineTo(getWidth() - roundWidth, 0);
        path.arcTo(new RectF(getWidth() - roundWidth * 2, 0, getWidth(), 0 + roundHeight * 2), -90, 90);
        path.close();
        canvas.drawPath(path, paint);
    }

    private void drawLiftDown(Canvas canvas) {
        Path path = new Path();
//        path.moveTo(0, getHeight() - roundHeight);
//        path.lineTo(0, getHeight());
//        path.lineTo(roundWidth, getHeight());


        path.moveTo(roundWidth, getHeight());
        path.lineTo(0, getHeight());
        path.lineTo(0, getHeight() - roundHeight);
        path.arcTo(new RectF(0, getHeight() - roundHeight * 2, roundWidth * 2, getHeight()), 180, -90);

        path.close();
        canvas.drawPath(path, paint);
    }

    private void drawRightDown(Canvas canvas) {
        Path path = new Path();
        path.moveTo(getWidth() - roundWidth, getHeight());
        path.lineTo(getWidth(), getHeight());
        path.lineTo(getWidth(), getHeight() - roundHeight);
        path.arcTo(new RectF(getWidth() - roundWidth * 2, getHeight() - roundHeight * 2, getWidth(), getHeight()), 0, 90);
        path.close();
        canvas.drawPath(path, paint);
    }

}
