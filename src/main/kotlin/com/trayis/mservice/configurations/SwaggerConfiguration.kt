package com.trayis.mservice.configurations

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*
import kotlin.collections.HashSet

@Configuration
@EnableSwagger2
class SwaggerConfiguration {

    companion object {
        private val CONTACT_DETAILS = Contact("Mukund Desai", "http://www.github.com/mukundrd", "muks.dev@trayis.com")
        private val DEFAULT_API_INFO = ApiInfo("MService Api Documentation", "MService Api Documentation Description",
                "1.0", "Terms of Service", CONTACT_DETAILS,
                "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", ArrayList())
        private val DEFAULT_PRODUCES_AND_CONSUMES = HashSet<String>()

        init {
            DEFAULT_PRODUCES_AND_CONSUMES.add("application/json")
            // DEFAULT_PRODUCES_AND_CONSUMES.add("application/xml")
        }
    }

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
