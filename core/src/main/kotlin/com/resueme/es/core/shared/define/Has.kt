package com.resueme.es.core.shared.define

import com.resueme.es.core.users.Repository

sealed interface Has {
    interface Logger {
        val logger: com.resueme.es.core.shared.define.Logger
    }

    interface UserRepository {
        val userRepository: Repository
    }
}