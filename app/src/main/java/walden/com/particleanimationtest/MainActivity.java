package walden.com.particleanimationtest;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.plattysoft.leonids.ParticleSystem;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static boolean flag1 = true;
    private static boolean flag2 = true;
    private static boolean flag3 = true;
    private static boolean flag4 = true;

    private ParticleSystem ps1;
    private ParticleSystem ps2;
    private ParticleSystem ps3;
    private ParticleSystem ps4;

    private Drawable drawable;
    private Activity activity;

    @InjectView(R.id.sourcr_area)
    ImageView sourcr_area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        init();
    }

    private void init() {
        activity = this;
        drawable = getResources().getDrawable(R.drawable.shape_particle);
    }

    @OnClick(R.id.rain)
    void rain() {
        Intent intent = new Intent(this, RainActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.smash)
    void smash() {
        Intent intent = new Intent(this, SmashActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.bt_1)
    void bt1() {
        control(1, flag1, ps1, new Runnable() {
            @Override
            public void run() {

                // param1 : Activity
                // param2 : 是最多的粒子数
                // param3 : 粒子图片资源
                // param4 : 持续时间 (毫秒) 默认
                // ps1 = new ParticleSystem(activity, 80, R.drawable.a18, 10000)
                ps1 = new ParticleSystem(activity, 80, drawable, 1000)
                        //最小速度 , 最大速度 , 最小角度 , 最大角度
                        .setSpeedModuleAndAngleRange(0.1f, 0.3f, 90, 180)
                        //粒子最小旋转角度 , 最大旋转角度
                        //.setRotationSpeedRange(100, 300)
                        //粒子旋转角度
                        .setRotationSpeed(0)
//                        .setFadeOut(6000) //淡出的区间，默认从不透明到完全透明
                        //粒子运动的加速度和方向
                        .setAcceleration(0.00005f, 90);
                ps1.emit(sourcr_area, 8);    // iv1 粒子效果产生的位置 ,  int 8 为每秒所产生的粒子数量

            }
        });

    }

    @OnClick(R.id.bt_2)
    void bt2() {
        control(2, flag2, ps2, new Runnable() {
            @Override
            public void run() {
                ps2 = new ParticleSystem(activity, 80, R.drawable.asw, 1000, R.id.content_)
                        .setSpeedModuleAndAngleRange(0f, 0.3f, 0, 180) //角度顺时针增加
                        .setRotationSpeed(144)
//                        .setFadeOut(6000) //淡出的区间，默认从不透明到完全透明
                        .setAcceleration(0.00005f, 90);
                ps2.emit(sourcr_area, 8);
            }
        });
    }

    @OnClick(R.id.bt_3)
    void bt3() {
        control(3, flag3, ps3, new Runnable() {
            @Override
            public void run() {
                ps3 = new ParticleSystem(activity, 100, R.drawable.asw, 5000)
                        .setSpeedRange(0.2f, 0.5f);
                ps3.oneShot(sourcr_area, 20);
            }
        });
    }

    @OnClick(R.id.bt_4)
    void bt4() {
        control(4, flag4, ps4, new Runnable() {
            @Override
            public void run() {
                ps4 = new ParticleSystem(activity, 10000, R.drawable.asw, 5000);
                ps4.emit(sourcr_area, 50);
            }
        });
    }

    private void control(int i, boolean flag, ParticleSystem ps, Runnable run) {
        if (flag) {
            run.run();
            switch (i) {
                case 1:
                    flag1 = false;
                    break;
                case 2:
                    flag2 = false;
                    break;
                case 3:
                    flag3 = true;
                    break;
                case 4:
                    flag4 = false;
                    break;
            }

        } else {
            if (ps != null) {
                ps.cancel();
            }
            switch (i) {
                case 1:
                    flag1 = true;
                    break;
                case 2:
                    flag2 = true;
                    break;
                case 3:
                    flag3 = true;
                    break;
                case 4:
                    flag4 = true;
                    break;
            }
        }
    }


}
