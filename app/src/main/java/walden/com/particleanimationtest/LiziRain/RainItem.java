package walden.com.particleanimationtest.LiziRain;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.Random;

public class RainItem {

    private int height;
    private int width;
    private float startX;   //粒子左上角X坐标
    private float startY;   //粒子左上角Y坐标
    private float stopX;    //粒子右下角X坐标
    private float stopY;    //粒子右下角Y坐标
    private float sizeX;    //粒子x大小
    private float sizeY;    //粒子Y大小
    private float offset = 0.5f;  //粒子运动速率
    private Paint paint;
    private int mType = 0;     //0为雨 , 1为雪
    private Random random = new Random();

    public RainItem(int height, int width, int type) {
        this.width = width;
        this.height = height;    //粒子所在的View的尺寸
        paint = new Paint();
        mType = type;
        init();
    }

    public RainItem(int height, int width) {
        this.width = width;
        this.height = height;    //粒子所在的View的尺寸
        paint = new Paint();
        init();
    }

    public void init() {
        sizeX = 1 + random.nextInt(10);
        sizeY = 10 + random.nextInt(20);

        startX = random.nextInt(width);
        startY = random.nextInt(height);

        stopX = startX + sizeX;
        stopY = startY + sizeY;

        offset = (float) (0.2 + random.nextFloat());

    }

    public void draw(Canvas canvas) {
        paint.setARGB(255, getRandomColor(), getRandomColor(), getRandomColor());
        if (mType == 0) {
            canvas.drawLine(startX, startY, stopX, stopY, paint);
        } else if (mType == 1) {
            canvas.drawCircle((startX + stopX) / 2, (startY + stopY) / 2, 3, paint);
        }
    }


    public void movestep() {
        startX += sizeX * offset;
        stopX += sizeX * offset;

        startY += sizeY * offset;
        stopY += sizeY * offset;
        if (startY > height) {
            init();
        }
    }

    private int getRandomColor() {
        return 200 + random.nextInt(55);
    }

    public void setType(int type) {
        mType = type;
    }
}
