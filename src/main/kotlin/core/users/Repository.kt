package core.users

import arrow.core.Either
import core.AppException
import core.define.Dependency
import java.util.*

interface Repository : Dependency {
    suspend fun getByUUID(uuid: UUID): Either<AppException, User>
}