package com.resueme.es.core.users

import arrow.core.computations.either
import com.resueme.es.core.shared.AppException
import com.resueme.es.core.shared.define.Has
import java.util.*

suspend fun <R> R.getByUUID(uuid: UUID) where R : Has.UserRepository = either<AppException, User> {
    userRepository.getByUUID(uuid).bind()
}