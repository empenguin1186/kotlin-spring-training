package jp.co.ssl.demo.bean

import com.google.gson.Gson
import jp.co.ssl.demo.entity.Request
import org.springframework.stereotype.Component
import org.springframework.web.context.annotation.RequestScope
import java.util.stream.Collectors
import javax.servlet.http.HttpServletRequest

@Component
@RequestScope
data class RequestBean(
        final val request: HttpServletRequest
) {
    val method: String = request.getHeader("Method")
    val serverType: String = request.getHeader("ServerType")
    val body: Request = request.reader.lines().collect(Collectors.joining("\r\n")).let {
        Gson().fromJson<Request>(it, Request::class.java)
    }
}