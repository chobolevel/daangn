package com.daangn.domain.entity.posts.likes

import com.daangn.domain.dto.Pagination
import com.daangn.domain.entity.posts.likes.QPostLike.postLike
import com.querydsl.core.types.OrderSpecifier
import com.querydsl.core.types.dsl.BooleanExpression
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository

@Repository
class PostLikeCustomRepository : QuerydslRepositorySupport(PostLike::class.java) {

    fun searchByPredicates(
        booleanExpressions: Array<BooleanExpression>,
        pagination: Pagination,
        orderSpecifiers: Array<OrderSpecifier<*>>
    ): List<PostLike> {
        return from(postLike)
            .where(*booleanExpressions)
            .orderBy(*orderSpecifiers)
            .offset(pagination.offset)
            .limit(pagination.limit)
            .fetch()
    }

    fun countByPredicates(
        booleanExpressions: Array<BooleanExpression>,
    ): Long {
        return from(postLike)
            .where(*booleanExpressions)
            .fetchCount()
    }
}
