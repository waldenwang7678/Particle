package walden.com.particleanimationtest.smash.factory;

import android.graphics.Bitmap;
import android.graphics.Rect;

import walden.com.particleanimationtest.smash.particle.Particle1;


/**
 * Created by Administrator on 2015/11/29 0029.
 */
public abstract class ParticleFactory {
    public abstract Particle1[][] generateParticles(Bitmap bitmap, Rect bound);
}
