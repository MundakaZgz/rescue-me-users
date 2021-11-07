package com.rescueme.es.core.users

import com.rescueme.es.core.define.Data
import java.util.*

data class User(override val id: String = UUID.randomUUID().toString()) : Data
