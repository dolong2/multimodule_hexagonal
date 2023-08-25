package multimodule.hexagonal.global.config


import multimodule.hexagonal.common.annotation.Service
import multimodule.hexagonal.common.annotation.UseCase
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType
import org.springframework.context.annotation.ComponentScan.Filter

@Configuration
@ComponentScan(
    basePackages = ["multimodule.hexagonal"],
    includeFilters = [
        Filter(
            type = FilterType.ANNOTATION,
            classes = [
                UseCase::class,
                Service::class
            ]
        )
    ]
)
class ComponentScanConfiguration