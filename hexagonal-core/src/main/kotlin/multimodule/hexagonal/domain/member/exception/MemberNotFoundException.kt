package multimodule.hexagonal.domain.member.exception

import multimodule.hexagonal.common.error.BasicException
import multimodule.hexagonal.common.error.ErrorCode

class MemberNotFoundException : BasicException(ErrorCode.MEMBER_NOT_FOUND) {
}