package core.users

import core.Reader
import core.define.Has
import java.util.*

suspend fun <R> getByUUID(uuid: UUID) where R : Has.UserRepository = Reader { r: R ->
    r.userRepository.getByUUID(uuid)
}