package multimodule.hexagonal.domain.member

import multimodule.hexagonal.domain.member.data.extension.toResponse
import multimodule.hexagonal.domain.member.data.response.MemberResponse
import multimodule.hexagonal.domain.member.usecase.DeleteMemberUseCase
import multimodule.hexagonal.domain.member.usecase.GetMemberUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/members")
class MemberWebAdapter(
    private val deleteMemberUseCase: DeleteMemberUseCase,
    private val getMemberUseCase: GetMemberUseCase
) {
    @DeleteMapping
    fun deleteMember(): ResponseEntity<Void> =
        deleteMemberUseCase.execute()
            .run { ResponseEntity.ok().build() }

    @GetMapping
    fun getCurrentMember(): ResponseEntity<MemberResponse> =
        getMemberUseCase.execute()
            .let { ResponseEntity.ok(it.toResponse()) }
}