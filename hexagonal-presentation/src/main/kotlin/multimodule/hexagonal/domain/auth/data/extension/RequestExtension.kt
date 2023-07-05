package multimodule.hexagonal.domain.auth.data.extension

import multimodule.hexagonal.domain.auth.data.request.SignInRequest
import multimodule.hexagonal.domain.auth.data.request.SignupRequest
import multimodule.hexagonal.domain.auth.data.response.SignInResponse
import multimodule.hexagonal.domain.auth.dto.request.SignInData
import multimodule.hexagonal.domain.auth.dto.request.SignUpData
import multimodule.hexagonal.domain.auth.dto.response.TokenResponseData

fun SignupRequest.toData(): SignUpData =
    SignUpData(
        email = this.email,
        name = this.name,
        password = this.password
    )

fun SignInRequest.toData(): SignInData =
    SignInData(
        email = this.email,
        password = this.password
    )

fun TokenResponseData.toResponse(): SignInResponse =
    SignInResponse(
        accessToken = this.accessToken,
        accessTokenExp = this.accessTokenExp,
        refreshToken = this.refreshToken,
        refreshTokenExp = this.refreshTokenExp
    )