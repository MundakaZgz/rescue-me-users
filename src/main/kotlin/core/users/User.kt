package core.users

import core.define.Data
import java.util.*

data class User(override val id: String = UUID.randomUUID().toString()) : Data
