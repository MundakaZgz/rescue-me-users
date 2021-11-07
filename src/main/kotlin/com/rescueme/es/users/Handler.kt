package com.rescueme.es.users

import arrow.core.Either
import arrow.core.getOrHandle
import com.rescueme.es.core.AppException
import com.rescueme.es.core.Reader
import com.rescueme.es.core.users.Context
import com.rescueme.es.core.users.User
import com.rescueme.es.core.users.bindGet
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
        handle { bindGet(uuid) }

    private suspend fun <A> handle(block: suspend () -> Reader<Context, Either<AppException, A>>) =
        block().provide(context).getOrHandle { throw it }
}