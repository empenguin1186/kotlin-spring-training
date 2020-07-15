package jp.co.ssl.demo.infrastructure

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class DemoProvider {

    @Bean
    fun getRequest(): RestTemplate {
        return RestTemplateBuilder().build()
    }
}