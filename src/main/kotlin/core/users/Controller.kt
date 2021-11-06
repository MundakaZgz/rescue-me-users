package core.users

import arrow.core.Either
import core.AppException
import core.define.Has
import core.toReader
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