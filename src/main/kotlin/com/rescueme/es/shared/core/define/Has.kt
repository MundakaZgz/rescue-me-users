package com.rescueme.es.shared.core.define

import com.rescueme.es.users.core.Repository

sealed interface Has {
    interface Logger {
        val logger: com.rescueme.es.shared.core.define.Logger
    }
    interface UserRepository {
        val userRepository: Repository
    }
}