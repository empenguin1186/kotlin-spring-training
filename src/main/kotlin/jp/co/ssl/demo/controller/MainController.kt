package jp.co.ssl.demo.controller

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTCreationException
import com.auth0.jwt.exceptions.JWTVerificationException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Base64

@RestController
@RequestMapping("/")
class MainController {

    @GetMapping
    fun get(): String {
        val token = try {
            val algorithm = Algorithm.HMAC256("secret")
            JWT.create()
                    .withIssuer("hoge")
                    .withClaim("xymlogin", "fugafuga")
                    .sign(algorithm)
        } catch (e: JWTCreationException) {
            "hoge"
        }

        val decoded = try {
            val verifier = Algorithm.HMAC256("secret").let {
                JWT.require(it).withIssuer("hoge").build()
            }
            verifier.verify(token)
        } catch (e: JWTVerificationException) {
            throw e
        }

        throw Exception("hoge")

        return Base64.getDecoder().decode(decoded.payload).let {
            String(it)
        }
    }
}