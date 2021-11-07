package com.rescueme.es

import com.rescueme.es.shared.core.define.Logger
import com.rescueme.es.users.core.Context
import com.rescueme.es.users.core.Repository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import com.rescueme.es.shared.LiveLayer
import com.rescueme.es.shared.LiveLogger
import com.rescueme.es.users.InMemoryRepository
import com.rescueme.es.users.Handler as UserHandler

@Configuration
class AppConfig(private val liveLayer: LiveLayer) {

    @Bean
    fun usersHandler(): UserHandler = UserHandler(object : Context {
        override val logger: Logger = LiveLogger
        override val userRepository: Repository = InMemoryRepository(liveLayer)
    })
}