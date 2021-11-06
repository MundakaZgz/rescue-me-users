package core

import arrow.core.Either
import arrow.core.left
import core.Reader.Factory.just

sealed class AppException(message: String, cause: Throwable? = null) : RuntimeException(message, cause) {
    class InternalServerError(cause: Throwable? = null) : AppException("Internal Server Error", cause)
}

fun <R> AppException.toReader() = just<R, Either<AppException, Nothing>>( left() )