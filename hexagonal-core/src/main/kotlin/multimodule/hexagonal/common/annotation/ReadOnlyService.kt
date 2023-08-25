package multimodule.hexagonal.common.annotation

import org.springframework.transaction.annotation.Transactional


@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Transactional(readOnly = true)
annotation class ReadOnlyService()
