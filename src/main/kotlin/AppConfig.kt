import core.define.Logger
import core.users.Context
import core.users.Repository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import shared.LiveLayer
import shared.LiveLogger
import users.InMemoryRepository
import users.Handler as UserHandler

@Configuration
class AppConfig(private val liveLayer: LiveLayer) {

    @Bean
    fun usersHandler(): UserHandler = UserHandler(object : Context {
        override val logger: Logger = LiveLogger
        override val userRepository: Repository = InMemoryRepository(liveLayer)

    })
}