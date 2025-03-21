package com.daangn.domain.exception

enum class ErrorCode(val message: String) {
    UNKNOWN("알 수 없는 에러"),
    INVALID_PARAMETER("파라미터가 유요하지 않습니다."),
    INVALID_REQUEST_BODY("요청 바디가 유효하지 않습니다."),
    BAD_CREDENTIALS("아이디 또는 비밀번호가 올바르지 않습니다."),
    ACCESS_DENIED("접근 권한이 없습니다."),
    METHOD_NOT_ALLOWED("지원하지 않은 메서드입니다."),
    EXPIRED_TOKEN("토큰이 만료되었습니다."),
    INVALID_TOKEN("토큰이 유효하지 않습니다."),
    INVALID_REFRESH_TOKEN("리프래시 토큰이 유효하지 않습니다."),
    REFRESH_TOKEN_NOT_EXISTS("리프래시 토큰이 존재하지 않습니다."),

    // USER
    USER_NOT_FOUND("회원을 찾을 수 없습니다."),
    USER_EMAIL_IS_DUPLICATED("이미 사용중인 이메일입니다."),
    CURRENT_PASSWORD_DOES_NOT_MATCH("현재 비밀번호가 일치하지 않습니다."),

    // USER REGION
    USER_REGION_NOT_FOUND("회원 지역을 찾을 수 없습니다."),

    // CATEGORY
    CATEGORY_NOT_FOUND("카테고리를 찾을 수 없습니다."),

    // POST
    POST_NOT_FOUND("게시글을 찾을 수 없습니다."),
    ONLY_POST_WRITER_CAN_ACCESS("게시글 작성자만 접근할 수 있습니다."),

    // LIKE
    LIKE_TARGET_NOT_FOUND("좋아요 대상을 찾을 수 없습니다."),

    // CHANNEL
    CHANNEL_NOT_FOUND("채널을 찾을 수 없습니다."),
    ALREADY_LEAVED_CHANNEL("이미 떠난 채널입니다."),

    // CHANNEL MESSAGE
    CHANNEL_MESSAGE_NOT_FOUND("채널 메세지를 찾을 수 없습니다.")
}
