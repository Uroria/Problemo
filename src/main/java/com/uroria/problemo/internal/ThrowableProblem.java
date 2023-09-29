package com.uroria.problemo.internal;

import com.uroria.problemo.AbstractProblem;
import lombok.NonNull;

import java.util.Optional;

public class ThrowableProblem extends AbstractProblem {
    protected Throwable throwable;

    public ThrowableProblem(String cause, @NonNull Throwable throwable) {
        super(2, cause);
        this.throwable = throwable;
    }

    @Override
    public Optional<Throwable> getError() {
        return Optional.of(this.throwable);
    }
}
