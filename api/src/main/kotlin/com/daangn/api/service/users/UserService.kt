package com.daangn.api.service.users

import com.daangn.api.dto.common.PaginationResponseDto
import com.daangn.api.dto.users.ChangeUserPasswordRequestDto
import com.daangn.api.dto.users.CreateUserRequestDto
import com.daangn.api.dto.users.UpdateUserRequestDto
import com.daangn.api.dto.users.UserResponseDto
import com.daangn.api.service.users.converter.UserConverter
import com.daangn.api.service.users.updater.UserUpdater
import com.daangn.api.service.users.validator.UserValidator
import com.daangn.domain.dto.Pagination
import com.daangn.domain.entity.users.UserOrderType
import com.daangn.domain.entity.users.UserQueryFilter
import com.daangn.domain.entity.users.UserRepositoryWrapper
import com.daangn.domain.exception.ErrorCode
import com.daangn.domain.exception.PolicyException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val repositoryWrapper: UserRepositoryWrapper,
    private val converter: UserConverter,
    private val updater: UserUpdater,
    private val validator: UserValidator,
    private val passwordEncoder: BCryptPasswordEncoder
) {

    @Transactional
    fun create(request: CreateUserRequestDto): String {
        validator.validate(
            request = request
        )
        val user = converter.convert(request)
        return repositoryWrapper.save(user).id
    }

    fun getUsers(
        queryFilter: UserQueryFilter,
        pagination: Pagination,
        orderTypes: List<UserOrderType>
    ): PaginationResponseDto {
        val users = repositoryWrapper.search(
            queryFilter = queryFilter,
            pagination = pagination,
            orderTypes = orderTypes
        )
        val totalCount = repositoryWrapper.searchCount(
            queryFilter = queryFilter,
        )
        return PaginationResponseDto(
            page = pagination.page,
            size = pagination.size,
            data = converter.convert(users),
            totalCount = totalCount
        )
    }

    fun getUser(userId: String): UserResponseDto {
        val user = repositoryWrapper.findById(userId)
        return converter.convert(user)
    }

    @Transactional
    fun update(userId: String, request: UpdateUserRequestDto): String {
        validator.validate(
            request = request
        )
        val user = repositoryWrapper.findById(userId)
        updater.markAsUpdate(
            request = request,
            entity = user
        )
        return user.id
    }

    @Transactional
    fun changePassword(userId: String, request: ChangeUserPasswordRequestDto): String {
        validator.validate(request)
        val user = repositoryWrapper.findById(userId)
        if (!passwordEncoder.matches(request.curPassword, user.password)) {
            throw PolicyException(
                errorCode = ErrorCode.CURRENT_PASSWORD_DOES_NOT_MATCH,
                message = ErrorCode.CURRENT_PASSWORD_DOES_NOT_MATCH.message
            )
        }
        user.password = passwordEncoder.encode(request.newPassword)
        return userId
    }

    @Transactional
    fun resign(userId: String): Boolean {
        val user = repositoryWrapper.findById(userId)
        user.resign()
        return user.resigned
    }
}
