package com.rescueme.es.users.core

import com.rescueme.es.shared.core.define.Data
import java.util.*

data class User(override val id: String = UUID.randomUUID().toString()) : Data
