package multimodule.hexagonal.domain.posting.spi

interface PostingPort :
    CommandPostingPort,
    QueryPostingPort