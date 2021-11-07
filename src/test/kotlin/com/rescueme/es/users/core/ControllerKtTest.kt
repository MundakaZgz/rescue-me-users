package com.rescueme.es.users.core

import arrow.core.right
import com.rescueme.es.shared.core.define.Logger
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import java.util.*

class ControllerKtTest : StringSpec({

    val uuidString = "5f42a79c-6579-43ff-959d-c887d9738523"
    val uuid = UUID.fromString("5f42a79c-6579-43ff-959d-c887d9738523")
    val user = User(uuidString)

    val context = object : Context {
        override val logger: Logger = mockk()
        override val userRepository: Repository = mockk()
    }

    "Should validate and retrieve user ok" {
        coEvery { context.userRepository.getByUUID(uuid) } returns user.right()

        val actual = context.bindGet(uuidString)

        actual shouldBe user.right()
    }

})
