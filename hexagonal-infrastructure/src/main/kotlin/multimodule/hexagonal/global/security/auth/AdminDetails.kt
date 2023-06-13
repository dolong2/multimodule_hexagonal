package multimodule.hexagonal.global.security.auth

import multimodule.hexagonal.domain.auth.model.Role
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AdminDetails(
    private val memberId: String
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> =
        mutableListOf(SimpleGrantedAuthority(Role.ROLE_ADMIN.name))

    override fun getPassword(): String? = null

    override fun getUsername(): String = memberId

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}