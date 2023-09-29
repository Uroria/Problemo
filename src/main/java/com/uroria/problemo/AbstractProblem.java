package com.uroria.problemo;

import lombok.NonNull;

/**
 * Can be used to create new Problem variants.
 */
public abstract non-sealed class AbstractProblem implements Problem {
    protected final int status;
    protected final String cause;

    protected AbstractProblem(int status, @NonNull String cause) {
        this.status = status;
        this.cause = cause;
    }

    @Override
    public final int getStatus() {
        return this.status;
    }

    @Override
    public final String getCause() {
        return this.cause;
    }
}
