package com.uroria.problemo;

import com.uroria.problemo.internal.PlainProblem;
import com.uroria.problemo.internal.ThrowableProblem;
import com.uroria.problemo.internal.UnavailableError;
import com.uroria.problemo.internal.UnknownProblem;
import lombok.NonNull;

import java.util.Optional;

public sealed interface Problem permits AbstractProblem {

    /**
     * Get the status code of this error.
     * Conventions are in project README.
     */
    int getStatus();

    /**
     * The cause message. Maybe it's a translation-key. Who knows...
     */
    String getCause();

    /**
     * A possible Throwable. Can be used to check, if something was thrown.
     */
    Optional<Throwable> getError();

    /**
     * Use this if you don't know what happened.
     */
    static UnknownProblem unknown(@NonNull String cause) {
        return new UnknownProblem(cause);
    }

    /**
     * Use this if something required is unavailable.
     */
    static UnavailableError unavailable(@NonNull String cause) {
        return new UnavailableError(cause);
    }

    /**
     * Use this if some error has been thrown.
     * Uses the {@link Throwable#getMessage()} to get cause.
     */
    static ThrowableProblem error(@NonNull Throwable throwable) {
        return error(throwable.getMessage(), throwable);
    }

    /**
     * Use this if some error has been thrown.
     */
    static ThrowableProblem error(@NonNull String cause, @NonNull Throwable throwable) {
        return new ThrowableProblem(cause, throwable);
    }

    /**
     * Just a problem with no specials.
     * Use this if you don't know what to use else.
     */
    static PlainProblem plain(@NonNull String cause) {
        return new PlainProblem(cause);
    }
}
