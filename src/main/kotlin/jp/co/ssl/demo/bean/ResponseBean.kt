package jp.co.ssl.demo.bean

import com.google.gson.Gson
import jp.co.ssl.demo.entity.Request
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.context.annotation.RequestScope
import java.net.URI

@Component
@RequestScope
class ResponseBean(
        private val requestBean: RequestBean,
        private val restTemplate: RestTemplate
) {
    val hoge: Request by lazy {
        restTemplate.getForObject(URI("http://localhost:8080/"), String::class.java).let {
            Gson().fromJson(it, Request::class.java)
        }
    }
}