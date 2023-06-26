package multimodule.hexagonal.global.config

import com.fasterxml.jackson.databind.ObjectMapper
import multimodule.hexagonal.global.security.CustomAccessDeniedHandler
import multimodule.hexagonal.global.security.CustomAuthenticationEntryPoint
import multimodule.hexagonal.global.security.jwt.token.ParseTokenAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.RequestMatcher
import org.springframework.web.cors.CorsUtils

@Configuration
class SecurityConfig(
    private val parseTokenAdapter: ParseTokenAdapter,
    private val objectMapper: ObjectMapper,
    private val customAccessDeniedHandler: CustomAccessDeniedHandler,
) {
    @Bean
    protected fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .cors().and()
            .csrf().disable()
            .formLogin().disable()
            .httpBasic().disable()

        http
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        http
            .authorizeRequests()
            .requestMatchers(RequestMatcher { request ->
                CorsUtils.isPreFlightRequest(request)
            }).permitAll()

            // auth
            .anyRequest().denyAll()

        http
            .apply(FilterConfig(objectMapper, parseTokenAdapter))

        http
            .exceptionHandling()
            .authenticationEntryPoint(CustomAuthenticationEntryPoint(objectMapper))
            .accessDeniedHandler(customAccessDeniedHandler)

        return http.build()
    }
}