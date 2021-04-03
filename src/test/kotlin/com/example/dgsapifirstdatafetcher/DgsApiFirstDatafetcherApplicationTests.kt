package com.example.dgsapifirstdatafetcher

import com.netflix.graphql.dgs.DgsQueryExecutor
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DgsApiFirstDatafetcherApplicationTests {

    @Autowired
    lateinit var dgsQueryExecutor: DgsQueryExecutor

    @Test
    fun contextLoads() {
    }

    @Test
    fun todos() {
        val todos : List<String> = dgsQueryExecutor.executeAndExtractJsonPath("""
            {
                todos {
                    title
                }
            }
        """.trimIndent(), "data.todos[*].title")

        assertThat(todos).contains("Milk")
    }
}
