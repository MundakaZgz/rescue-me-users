package shared

import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import users.MemoryContext

@Configuration
class LiveLayer(env: Environment): HasLive.InMemory, MemoryContext {
    override val oneProp: String = env.getRequiredProperty("database.inmemory.prop")
}