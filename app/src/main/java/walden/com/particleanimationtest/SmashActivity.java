package walden.com.particleanimationtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import walden.com.particleanimationtest.smash.ExplosionField;
import walden.com.particleanimationtest.smash.factory.ExplodeParticleFactory;
import walden.com.particleanimationtest.smash.factory.FallingParticleFactory;
import walden.com.particleanimationtest.smash.factory.FlyawayFactory;
import walden.com.particleanimationtest.smash.factory.VerticalAscentFactory;

public class SmashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smash);
        init();
    }

    private void init() {

        ExplosionField explosionField = new ExplosionField(this, new FallingParticleFactory());
        explosionField.addListener(findViewById(R.id.text_));
        explosionField.addListener(findViewById(R.id.layout1));

        ExplosionField explosionField2 = new ExplosionField(this, new FlyawayFactory());
        explosionField2.addListener(findViewById(R.id.text2));
        explosionField2.addListener(findViewById(R.id.layout2));

        ExplosionField explosionField4 = new ExplosionField(this, new ExplodeParticleFactory());
        explosionField4.addListener(findViewById(R.id.text3));
        explosionField4.addListener(findViewById(R.id.layout3));

        ExplosionField explosionField5 = new ExplosionField(this, new VerticalAscentFactory());
        explosionField5.addListener(findViewById(R.id.text4));
        explosionField5.addListener(findViewById(R.id.layout4));
    }
}
