package com.resueme.es.core.users

import com.resueme.es.core.shared.define.Data
import java.util.*

data class User(override val id: String = UUID.randomUUID().toString()) : Data
