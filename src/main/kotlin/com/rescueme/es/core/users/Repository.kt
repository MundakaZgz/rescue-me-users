package com.rescueme.es.core.users

import arrow.core.Either
import com.rescueme.es.core.AppException
import com.rescueme.es.core.define.Dependency
import java.util.*

interface Repository : Dependency {
    suspend fun getByUUID(uuid: UUID): Either<AppException, User>
}