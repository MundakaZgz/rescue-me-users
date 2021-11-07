package com.resueme.es.core.users

import arrow.core.Either
import com.resueme.es.core.shared.AppException
import com.resueme.es.core.shared.define.Dependency
import java.util.*

interface Repository : Dependency {
    suspend fun getByUUID(uuid: UUID): Either<AppException, User>
}