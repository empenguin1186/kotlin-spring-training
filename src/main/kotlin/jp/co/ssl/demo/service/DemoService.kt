package jp.co.ssl.demo.service

import jp.co.ssl.demo.bean.RequestBean
import jp.co.ssl.demo.bean.ResponseBean
import org.springframework.stereotype.Service

@Service
class DemoService(
        private val requestBean: RequestBean,
        private val response: ResponseBean
) {
    fun getResult(): String {
        return response.hoge.bar
    }
}