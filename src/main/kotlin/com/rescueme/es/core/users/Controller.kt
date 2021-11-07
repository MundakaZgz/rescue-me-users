package com.rescueme.es.core.users

import arrow.core.Either
import com.rescueme.es.core.AppException
import com.rescueme.es.core.define.Has
import com.rescueme.es.core.toReader
import java.util.*

interface Context : Has.Logger, Has.UserRepository

suspend fun bindGet(uuidString: String?) =
    validate { UUID.fromString(uuidString) }
        .fold(
            ifLeft = { it.toReader() },
            ifRight = { getByUUID<Context>(it) })

private fun <A> validate(block: () -> A) = try {
    Either.Right(block())
} catch (e: Exception) {
    Either.Left(AppException.InternalServerError())
}