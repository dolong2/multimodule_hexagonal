package multimodule.hexagonal.domain.member.spi

interface MemberPort :
    CommandMemberPort,
    QueryMemberPort