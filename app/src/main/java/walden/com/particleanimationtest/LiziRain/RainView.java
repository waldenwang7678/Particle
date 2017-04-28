package walden.com.particleanimationtest.LiziRain;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Random;

import walden.com.particleanimationtest.R;

public class RainView extends RelativeLayout {
    private int isRain = 0;
    private boolean isRun = true;
    private control thread;
    Random random = new Random();
    ArrayList<RainItem> list = new ArrayList<RainItem>();  //粒子对象集合
    private int num = 100; //粒子数量 默认100

    public RainView(Context context) {
        super(context);
    }

    public RainView(Context context, AttributeSet attrs) { //xml文件中使用
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.RainView);
        num = ta.getInteger(R.styleable.RainView_rainnum, 100);
        ta.recycle();
    }

    @Override
    protected final void onDraw(Canvas canvas) {
        if (thread == null) {
            thread = new control();
            thread.start();
        } else {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).draw(canvas);
            }
        }
    }

    public class control extends Thread {
        @Override
        public void run() {
            init();
            while (isRun) {
                move();
                postInvalidate();
                try {
                    sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected void init() {
        list.clear();
        for (int i = 0; i < num; i++) {
            RainItem item = new RainItem(getHeight(), getWidth()); //默认type==1
            list.add(item);
        }
    }

    protected void move() {
        for (RainItem item : list) {
            if (isChanged) {
                item.setType(isRain != 2 ? isRain : random.nextInt(2));
            }
            item.movestep();
        }
        isChanged = false;
    }

    public void stopRain() {
        isRun = false;
    }

    public void setRain(int flag) { //0,1,2
        isRain = flag;
        isChanged = true;
    }

    boolean isChanged = false;

    public void clear(){
        list.clear();
    }
}
