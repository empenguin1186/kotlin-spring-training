package jp.co.ssl.demo.filter

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse

@Component
class AccessLogFilter : Filter {

    companion object {
        val logger = LoggerFactory.getLogger(AccessLogFilter::class.java)
    }

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val start = System.currentTimeMillis()

        chain?.doFilter(request, response)

        val duration = System.currentTimeMillis() - start
        logger.info("duration=${duration}")
        println(duration)
    }
}