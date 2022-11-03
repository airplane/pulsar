package meteordevelopment.pts.utils.transition;

public enum TransitionProperty {
    None,
    All,
    Width,
    Height;

    public static TransitionProperty get(String name) {
        for (TransitionProperty property : values()) {
           if (property.name().equalsIgnoreCase(name)) {
               return property;
           }
        }
        return null;
    }

}
