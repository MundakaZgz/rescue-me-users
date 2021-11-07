package com.rescueme.es.users.core

import arrow.core.computations.either
import com.rescueme.es.shared.core.AppException
import com.rescueme.es.shared.core.define.Has
import java.util.*

suspend fun <R> R.getByUUID(uuid: UUID) where R : Has.UserRepository = either<AppException, User> {
    userRepository.getByUUID(uuid).bind()
}