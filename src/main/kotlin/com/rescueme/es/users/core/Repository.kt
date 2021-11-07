package com.rescueme.es.users.core

import arrow.core.Either
import com.rescueme.es.shared.core.AppException
import com.rescueme.es.shared.core.define.Dependency
import java.util.*

interface Repository : Dependency {
    suspend fun getByUUID(uuid: UUID): Either<AppException, User>
}