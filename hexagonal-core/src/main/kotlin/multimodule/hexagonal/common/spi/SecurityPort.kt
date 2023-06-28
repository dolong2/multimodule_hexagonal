package multimodule.hexagonal.common.spi

interface SecurityPort {
    fun getCurrentUserId(): String
}