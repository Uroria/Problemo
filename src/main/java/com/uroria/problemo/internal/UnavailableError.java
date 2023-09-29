package com.uroria.problemo.internal;

import com.uroria.problemo.AbstractProblem;

import java.util.Optional;

public class UnavailableError extends AbstractProblem {

    public UnavailableError(String cause) {
        super(1, cause);
    }

    @Override
    public Optional<Throwable> getError() {
        return Optional.empty();
    }
}
