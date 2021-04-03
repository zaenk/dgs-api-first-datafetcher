package com.example.dgsapifirstdatafetcher

import com.example.dgsinterfacedatafetcher.graphql.DgsConstants
import com.example.dgsinterfacedatafetcher.graphql.types.Todo
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DgsApiFirstDatafetcherApplication

fun main(args: Array<String>) {
    runApplication<DgsApiFirstDatafetcherApplication>(*args)
}

interface DgsTodoFetcher {
    @DgsData(parentType = DgsConstants.QUERY.TYPE_NAME, field = DgsConstants.QUERY.Todos)
    fun todos(): List<Todo>
}

@DgsComponent
class TodoFetcher : DgsTodoFetcher {

    private val todos = listOf(
        Todo(title = "Bread", completed = false),
        Todo(title = "Milk", completed = false),
        Todo(title = "Eggs", completed = false),
        Todo(title = "Mayo", completed = false)
    )

    override fun todos(): List<Todo> =
        todos

}
