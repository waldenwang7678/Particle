package walden.com.particleanimationtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
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

}
