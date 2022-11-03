package meteordevelopment.pulsar.transition;

import java.util.HashMap;
import java.util.Map;

public class Transitions {

    private static final Map<String, ITransition> transitions = new HashMap<>();

    public static ITransition LINEAR = add("Linear", x -> x);

    public static ITransition EASE = add("Ease", _cubicBezier(0.25,0.1,0.25,1));
    public static ITransition EASE_IN = add("EaseIn", _cubicBezier(0.42,0,1,1));
    public static ITransition EASE_OUT = add("EaseOut", _cubicBezier(0,0,0.58,1));
    public static ITransition EASE_IN_OUT = add("EaseInOut", _cubicBezier(0.42,0,0.58,1));

    public static ITransition cubicBezier(double p0, double p1, double p2, double p3) {
        return add("CubicBezier", _cubicBezier(p0, p1, p2, p3));
    }

    private static ITransition _cubicBezier(double p0, double p1, double p2, double p3) {
        return x ->
                Math.pow(1 - x, 3) * p0 +
                        3 * Math.pow(1 - x, 2) * x * p1 +
                        3 * (1 - x) * Math.pow(x, 2) * p2 +
                        Math.pow(x, 3) * p3;
    }

    private static ITransition add(String name, ITransition transition) {
        return transitions.put(name, transition);
    }

    public static ITransition get(String name) {
        return transitions.get(name);
    }
}

