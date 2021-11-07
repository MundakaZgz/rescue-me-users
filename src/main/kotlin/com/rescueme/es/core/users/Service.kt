package com.rescueme.es.core.users

import com.rescueme.es.core.Reader
import com.rescueme.es.core.define.Has
import java.util.*

suspend fun <R> getByUUID(uuid: UUID) where R : Has.UserRepository = Reader { r: R ->
    r.userRepository.getByUUID(uuid)
}