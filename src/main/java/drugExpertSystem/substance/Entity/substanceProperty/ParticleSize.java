package drugExpertSystem.substance.Entity.substanceProperty;

/**
 * Created by Panupak on 8/9/2014.
 */
public enum ParticleSize {
    PHARMACEUTICLENANO("PharmaceuticleNanoparticle"),
    FINE("FineParticle"),
    MICRONIZED("MicronizedParticle"),
    NANOSIZE("NanosizeParticle"),
    ULTRA_MICRONIZED("Ultra-micronizedParticle"),
    VERYFINE("VeryFineParticle");

    private String PaerticleSizeType;

    ParticleSize(String paerticleSizeType) {
        PaerticleSizeType = paerticleSizeType;
    }

    public String getPaerticleSizeType() {
        return PaerticleSizeType;
    }
}
