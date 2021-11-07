package com.resueme.es.core.users

import arrow.core.Either
import arrow.core.computations.either
import com.resueme.es.core.shared.AppException
import com.resueme.es.core.shared.define.Has
import java.util.*

interface Context : Has.Logger, Has.UserRepository

suspend fun Context.bindGet(uuidString: String) = either<AppException, User> {
    val uuid = validate { UUID.fromString(uuidString) }.bind()
    getByUUID(uuid).bind()
}

private fun <A> validate(block: () -> A) = try {
    Either.Right(block())
} catch (e: Exception) {
    Either.Left(AppException.InternalServerError())
}