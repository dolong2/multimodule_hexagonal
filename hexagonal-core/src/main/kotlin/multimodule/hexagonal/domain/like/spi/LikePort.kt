package multimodule.hexagonal.domain.like.spi

interface LikePort :
    CommandLikePort,
    QueryLikePort