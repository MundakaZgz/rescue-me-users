package core.define

sealed interface Has {
    interface Logger {
        val logger: core.define.Logger
    }
    interface UserRepository {
        val userRepository: core.users.Repository
    }
}