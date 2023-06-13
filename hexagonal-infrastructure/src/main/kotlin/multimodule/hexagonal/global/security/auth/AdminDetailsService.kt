package multimodule.hexagonal.global.security.auth

import multimodule.hexagonal.domain.member.spi.MemberPort
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class AdminDetailsService(
    private val memberPort: MemberPort
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        if (memberPort.existsMemberId(username))
            throw RuntimeException()// TODO username으로 조회할 수 없음
        return MemberDetails(username)
    }
}