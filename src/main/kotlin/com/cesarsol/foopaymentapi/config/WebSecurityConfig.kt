package com.cesarsol.foopaymentapi.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class WebSecurityConfig {

    companion object {
        private val allowedMethods = arrayOf("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
        val allowedUris = arrayOf(
            "/swagger-ui**", "/webjars/springfox-swagger-ui/**", "/swagger-resources/**", "/v2/**",
            "/actuator/health**", "/error**", "/favicon.ico", "/swagger-ui/**", "/v3/**"
        )
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain? {
        http
            .requestMatchers { matchers -> matchers.antMatchers(*allowedUris) }
            .authorizeHttpRequests { authorize -> authorize.anyRequest().permitAll() }
            .requestCache().disable()
            .securityContext().disable()
            .sessionManagement().disable()

        return http.build()
    }

    @Bean
    fun webSecurityCustomizer(): WebSecurityCustomizer? {
        return WebSecurityCustomizer { web: WebSecurity -> web.ignoring().antMatchers(*allowedUris) }
    }

}