package com.rescueme.es.users

import arrow.core.Either
import arrow.core.getOrHandle
import com.resueme.es.core.shared.AppException
import com.resueme.es.core.users.Context
import com.resueme.es.core.users.bindGet
import org.springframework.stereotype.Indexed
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Indexed
@ResponseBody
@RequestMapping("/users")
class Handler(private val context: Context) {

    @GetMapping("{uuid}")
    suspend fun getUserByUUID(@PathVariable uuid: String) =
        handle { context.bindGet(uuid) }

    private suspend fun <A> handle(block: suspend () -> Either<AppException, A>) =
        block().getOrHandle { throw it }
}