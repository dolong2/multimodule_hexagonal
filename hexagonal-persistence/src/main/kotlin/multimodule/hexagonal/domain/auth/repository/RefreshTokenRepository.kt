package multimodule.hexagonal.domain.auth.repository

import multimodule.hexagonal.domain.auth.entity.RefreshTokenEntity
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RefreshTokenRepository : CrudRepository<RefreshTokenEntity, String> {
    fun findByUserId(userId: String): List<RefreshTokenEntity>
}