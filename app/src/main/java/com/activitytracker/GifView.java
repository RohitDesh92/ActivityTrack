package com.activitytracker;

import java.io.InputStream;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Movie;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class GifView extends View {
    public Movie mMovie;
    public long movieStart;
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
        String str=Atype.getType();
       switch (str){
            case "Walking":is = getContext().getResources().openRawResource(R.drawable.walking);
                            break;
            case "Jogging":is = getContext().getResources().openRawResource(R.drawable.running);
                            break;
            case "Standing":is = getContext().getResources().openRawResource(R.drawable.standing);
                            break;
            case "Sitting":is = getContext().getResources().openRawResource(R.drawable.sitting);
                           break;
            case "Upstairs":is = getContext().getResources().openRawResource(R.drawable.ascendingstairs);
                            break;
            case "Downstairs":is = getContext().getResources().openRawResource(R.drawable.descendingstairs);
                             break;
            default: is = getContext().getResources().openRawResource(R.drawable.walking);
        }
        //is = getContext().getResources().openRawResource(R.drawable.descendingstairs);
        mMovie = Movie.decodeStream(is);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.TRANSPARENT);
        super.onDraw(canvas);
        long now = android.os.SystemClock.uptimeMillis();
        if (movieStart == 0) {
            movieStart = now;
        }
        if (mMovie != null) {
            int relTime = (int) ((now - movieStart) % mMovie.duration());
            mMovie.setTime(relTime);
            float scaleWidth = (float) ((getWidth() / (1f*mMovie.width())));//add 1f does the trick
            float scaleHeight = (float) ((getHeight() / (1f*mMovie.height())));
            canvas.scale(scaleWidth, scaleHeight);
            mMovie.draw(canvas, 0, 0);//mMovie is my gif picture
            //mMovie.draw(canvas, getWidth() - mMovie.width(), getHeight() - mMovie.height());
            this.invalidate();
        }
    }
    private int gifId;

    public void setGIFResource(int resId) {
        this.gifId = resId;
        initializeView();
    }

    public int getGIFResource() {
        return this.gifId;
    }
}