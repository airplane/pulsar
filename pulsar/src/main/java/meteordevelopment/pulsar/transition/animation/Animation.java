package meteordevelopment.pulsar.transition.animation;


import meteordevelopment.pulsar.transition.ITransition;

import java.time.Duration;

public interface Animation {

    Duration getDuration();

    ITransition getTransition();

    double getLinearProgression();

    boolean isRunning();

    boolean isDone();

    boolean isForward();

    void reset();

    void setRunning(boolean running);

    void setForward(boolean forward);

    default double getProgression() {
        return getTransition().apply(getLinearProgression());
    }

    default double transitioned(double progression) {
        return clamp(getTransition().apply(progression), 0, 1);
    }

    default double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }
}
