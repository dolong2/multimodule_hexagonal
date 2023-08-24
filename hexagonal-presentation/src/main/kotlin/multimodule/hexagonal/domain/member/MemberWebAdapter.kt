package multimodule.hexagonal.domain.member

import multimodule.hexagonal.domain.member.usecase.DeleteMemberUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/members")
class MemberWebAdapter(
    private val deleteMemberUseCase: DeleteMemberUseCase
) {
    @DeleteMapping
    fun deleteMember(): ResponseEntity<Void> =
        deleteMemberUseCase.execute()
            .run { ResponseEntity.ok().build() }

}