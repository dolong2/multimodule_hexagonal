package multimodule.hexagonal.domain.auth

import multimodule.hexagonal.domain.auth.data.extension.toData
import multimodule.hexagonal.domain.auth.data.extension.toResponse
import multimodule.hexagonal.domain.auth.data.request.SignInRequest
import multimodule.hexagonal.domain.auth.data.request.SignupRequest
import multimodule.hexagonal.domain.auth.data.response.SignInResponse
import multimodule.hexagonal.domain.auth.usecase.ReissueTokenUseCase
import multimodule.hexagonal.domain.auth.usecase.SignInUseCase
import multimodule.hexagonal.domain.auth.usecase.SignOutUseCase
import multimodule.hexagonal.domain.auth.usecase.SignupUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthWebAdapter(
    private val signupUseCase: SignupUseCase,
    private val signInUseCase: SignInUseCase,
    private val signOutUseCase: SignOutUseCase,
    private val reissueTokenUseCase: ReissueTokenUseCase
) {
    @PostMapping("/signup")
    fun signup(@RequestBody signupRequest: SignupRequest): ResponseEntity<Void> =
        signupUseCase.execute(signupRequest.toData())
            .let { ResponseEntity.ok().build() }

    @PostMapping
    fun signIn(@RequestBody signInRequest: SignInRequest): ResponseEntity<SignInResponse> =
        signInUseCase.execute(signInRequest.toData())
            .let { ResponseEntity.ok(it.toResponse()) }

    @DeleteMapping
    fun signOut(@RequestHeader("Refresh-Token") refreshToken: String): ResponseEntity<Void> =
        signOutUseCase.execute(refreshToken)
            .let { ResponseEntity.ok().build() }

    @PatchMapping
    fun refresh(@RequestHeader("Refresh-Token") refreshToken: String): ResponseEntity<Void> =
        reissueTokenUseCase.execute(refreshToken)
            .let { ResponseEntity.ok().build() }
}