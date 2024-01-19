package ai.visualexerciseaid.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Slf4j
@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ai.visualexerciseaid.controller"))
                .paths(PathSelectors.any()) // 配置路径
                .build()
                .apiInfo(
                        new ApiInfoBuilder()
                                .title("视觉训练辅助系统接口文档")
                                .version("v1.0")
                                .description("视觉训练辅助系统接口文档")
                                .contact(new Contact("XXX", "XXX", "XXX"))
                                .license("Apache2.0")
                                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                                .build()
                );
    }

}