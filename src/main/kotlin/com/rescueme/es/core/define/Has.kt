package com.rescueme.es.core.define

import com.rescueme.es.core.users.Repository

sealed interface Has {
    interface Logger {
        val logger: com.rescueme.es.core.define.Logger
    }
    interface UserRepository {
        val userRepository: Repository
    }
}