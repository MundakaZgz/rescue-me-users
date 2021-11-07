package com.rescueme.es.users

import arrow.core.Either
import arrow.core.getOrNone
import com.rescueme.es.shared.core.AppException
import com.rescueme.es.users.core.Repository
import com.rescueme.es.users.core.User
import com.rescueme.es.shared.HasLive
import java.util.*

interface MemoryContext : HasLive.InMemory
data class UserEntity(val uuid: UUID)
class InMemoryRepository(context: MemoryContext) : Repository {
    private val users = mapOf(
        UUID.fromString("5f42a79c-6579-43ff-959d-c887d9738523")
                to UserEntity(UUID.fromString("5f42a79c-6579-43ff-959d-c887d9738523")),
        UUID.fromString("54ca561f-1568-4354-be13-7941c8ddf3ec")
                to UserEntity(UUID.fromString("54ca561f-1568-4354-be13-7941c8ddf3ec"))
    )

    init {
        println("Properties loaded ${context.oneProp}")
    }

    override suspend fun getByUUID(uuid: UUID): Either<AppException, User> =
        users.getOrNone(uuid)
            .toEither { AppException.NotFoundError() }
            .map { User(it.uuid.toString()) }
}