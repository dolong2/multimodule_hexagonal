package multimodule.hexagonal.domain.auth.spi

interface RefreshTokenPort :
    CommandRefreshTokenPort,
    QueryRefreshTokenPort