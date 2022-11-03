package meteordevelopment.pts.utils.transition;

public class Transition {

    public TransitionProperty property;
    public double duration;
    public TransitionTimingFunction timingFunction;
    public double delay;

    public Transition(TransitionProperty property, double duration, TransitionTimingFunction timingFunction, double delay) {
        this.property = property;
        this.duration = duration;
        this.timingFunction = timingFunction;
        this.delay = delay;
    }

}
