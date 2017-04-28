package walden.com.particleanimationtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import walden.com.particleanimationtest.LiziRain.RainView;

public class RainActivity extends AppCompatActivity {

    @InjectView(R.id.rainview)
    public RainView rainview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rain);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {
        ImageView imageView = (ImageView) findViewById(R.id.image_rain);
        imageView.setImageAlpha(150);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        rainview.stopRain();
        rainview.clear();
        System.gc();
    }

    @OnClick(R.id.rain)
    void rain() {
        rainview.setRain(0);
    }

    @OnClick(R.id.snow)
    void snow() {
        rainview.setRain(1);
    }

    @OnClick(R.id.r_s)
    void snowAndRain() {
        rainview.setRain(2);
    }
}