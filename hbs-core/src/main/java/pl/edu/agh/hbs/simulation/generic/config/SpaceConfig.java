package pl.edu.agh.hbs.simulation.generic.config;

public class SpaceConfig {
    private final int width;
    private final int height;
    private final int patchWidth;
    private final int patchHeight;

    public SpaceConfig(int width, int height, int patchWidth, int patchHeight) {
        this.width = width;
        this.height = height;
        this.patchWidth = patchWidth;
        this.patchHeight = patchHeight;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPatchWidth() {
        return patchWidth;
    }

    public int getPatchHeight() {
        return patchHeight;
    }
}
