package com.rescueme.es.users.core

import com.rescueme.es.shared.core.Reader
import com.rescueme.es.shared.core.define.Has
import java.util.*

suspend fun <R> getByUUID(uuid: UUID) where R : Has.UserRepository = Reader { r: R ->
    r.userRepository.getByUUID(uuid)
}