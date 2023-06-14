package multimodule.hexagonal.global.filter

import com.fasterxml.jackson.databind.ObjectMapper
import multimodule.hexagonal.global.security.jwt.token.ParseTokenAdapter
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class FilterConfig(
    private val objectMapper: ObjectMapper,
    private val parseTokenAdapter: ParseTokenAdapter
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {
    override fun configure(builder: HttpSecurity) {
        builder.addFilterBefore(ExceptionFilter(objectMapper), UsernamePasswordAuthenticationFilter::class.java)
        builder.addFilterBefore(JwtReqFilter(parseTokenAdapter), UsernamePasswordAuthenticationFilter::class.java)
    }
}