package meteordevelopment.pulsar.utils;

public record ColorImpl(int r, int g, int b, int a) implements IColor {
    @Override
    public int getR() {
        return r;
    }

    @Override
    public int getG() {
        return g;
    }

    @Override
    public int getB() {
        return b;
    }

    @Override
    public int getA() {
        return a;
    }
}
