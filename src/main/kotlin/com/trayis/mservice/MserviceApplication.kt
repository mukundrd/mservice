package com.trayis.mservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver
import java.util.*

@SpringBootApplication
class MserviceApplication

fun main(args: Array<String>) {

    runApplication<MserviceApplication>(*args)

    @Bean
    fun localeResolver(): LocaleResolver {
        val localeResolver = AcceptHeaderLocaleResolver()
        localeResolver.defaultLocale = Locale.US
        return localeResolver
    }

}
