package com.activitytracker;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Movie;
import android.util.AttributeSet;
import android.view.View;

public class GifView extends View {
    public Movie mMovie;
    public long image;
    private InputStream is;


    public GifView(Context context) {
        super(context);
        initializeView();
    }

    public GifView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeView();
    }

    public GifView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initializeView();
    }

    private void initializeView() {
        GetActivityType Atype = new GetActivityType();
        String str = Atype.getType();
        switch (str) {
            case "Walking":
                is = getContext().getResources().openRawResource(R.drawable.walking);
                break;
            case "Jogging":
                is = getContext().getResources().openRawResource(R.drawable.running);
                break;
            case "Standing":
                is = getContext().getResources().openRawResource(R.drawable.standing);
                break;
            case "Upstairs":
                is = getContext().getResources().openRawResource(R.drawable.ascendingstairs);
                break;
            case "Downstairs":
                is = getContext().getResources().openRawResource(R.drawable.ascendingstairs);
                break;
            default:
                is = getContext().getResources().openRawResource(R.drawable.standing);
        }
        mMovie = Movie.decodeStream(is);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.TRANSPARENT);
        super.onDraw(canvas);
        long now = android.os.SystemClock.uptimeMillis();
        if (image == 0) {
            image = now;
        }
        if (mMovie != null) {
            int relTime = (int) ((now - image) % mMovie.duration());
            mMovie.setTime(relTime);
            float scaleWidth = (float) ((getWidth() / (1f * mMovie.width())));
            float scaleHeight = (float) ((getHeight() / (1f * mMovie.height())));
            canvas.scale(scaleWidth, scaleHeight);
            mMovie.draw(canvas, 0, 0);
            this.invalidate();
        }
    }
}