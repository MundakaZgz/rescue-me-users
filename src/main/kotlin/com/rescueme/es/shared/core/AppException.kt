package com.rescueme.es.shared.core

sealed class AppException(message: String, cause: Throwable? = null) : RuntimeException(message, cause) {
    class InternalServerError(cause: Throwable? = null) : AppException("Internal Server Error", cause)
    class NotFoundError(cause: Throwable? = null) : AppException("Entity not found", cause)
}