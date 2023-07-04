package multimodule.hexagonal.common.service

interface SecurityService {
    fun getUserId(): String
    fun encodePassword(rawPassword: String): String
}