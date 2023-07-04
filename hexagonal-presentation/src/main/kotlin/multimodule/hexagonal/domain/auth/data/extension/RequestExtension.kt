package multimodule.hexagonal.domain.auth.data.extension

import multimodule.hexagonal.domain.auth.data.request.SignupRequest
import multimodule.hexagonal.domain.auth.dto.request.SignUpData

fun SignupRequest.toData(): SignUpData =
    SignUpData(
        email = this.email,
        name = this.name,
        password = this.password
    )