package meteordevelopment.pts.utils.transition;

public enum TransitionTimingFunction {
    LINEAR,
    EASE,
    EASE_IN,
    EASE_OUT,
    EASE_IN_OUT;

    public static TransitionTimingFunction get(String name) {
        for (TransitionTimingFunction property : values()) {
            if (property.name().equalsIgnoreCase(name)) {
                return property;
            }
        }
        return null;
    }
}
