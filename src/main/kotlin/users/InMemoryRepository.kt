package users

import arrow.core.Either
import arrow.core.getOrNone
import core.AppException
import core.users.Repository
import core.users.User
import shared.HasLive
import java.util.*

interface MemoryContext : HasLive.InMemory
data class UserEntity(val uuid: UUID)
class InMemoryRepository(context: MemoryContext) : Repository {
    private val users = mapOf(
        UUID.fromString("Alejandro") to UserEntity(UUID.fromString("Alejandro")),
        UUID.fromString("Budy") to UserEntity(UUID.fromString("Budy")),
    )

    init {
        println("Properties loaded ${context.oneProp}")
    }

    override suspend fun getByUUID(uuid: UUID): Either<AppException, User> =
        users.getOrNone(uuid)
            .toEither { AppException.NotFoundError() }
            .map { User(it.uuid.toString()) }
}