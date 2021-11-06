package users

import arrow.core.Either
import core.AppException
import core.users.Repository
import core.users.User
import shared.HasLive
import java.util.*

interface MemoryContext : HasLive.InMemory
class InMemoryRepository(context: MemoryContext) : Repository {
    override suspend fun getByUUID(uuid: UUID): Either<AppException, User> {
        TODO("Not yet implemented")
    }
}