package walden.com.particleanimationtest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import walden.com.particleanimationtest.spark.SparkView;

public class SparkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SparkView view = new SparkView(this);
        setContentView(view);
    }
}
