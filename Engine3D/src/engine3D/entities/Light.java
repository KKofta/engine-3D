package engine3D.entities;

public enum Light {
    
    SA(0.15f),
    KS(0.25f),
    KD(0.75f),
    N(30),
    IP(0.8f),
    MAX(0.99f),
    MIN(0.2f);

    float value;

    Light(float v) {
        value = v;
    }
}
