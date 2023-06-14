package multimodule.hexagonal.global.security.auth

import multimodule.hexagonal.domain.member.spi.MemberPort
import multimodule.hexagonal.global.security.exception.TokenNotValidException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class MemberDetailsService(
    private val memberPort: MemberPort
) : UserDetailsService{
    override fun loadUserByUsername(username: String): UserDetails {
        if (!memberPort.existsMemberId(username))
            throw TokenNotValidException()
        return MemberDetails(username)
    }
}