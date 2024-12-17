package com.scrimmers.api.controller.v1.upload

import com.scrimmers.api.annotation.HasAuthorityUser
import com.scrimmers.api.dto.common.ResultResponse
import com.scrimmers.api.dto.upload.UploadRequestDto
import com.scrimmers.api.service.upload.UploadService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Upload(파일 업로드)", description = "파일 업로드 API")
@RestController
@RequestMapping("/api/v1")
class UploadController(
    private val service: UploadService
) {

    @Operation(summary = "파일 업로드용 경로 발급 API")
    @HasAuthorityUser
    @PostMapping("/upload/presigned-url")
    fun issuePresignedUrl(@RequestBody request: UploadRequestDto): ResponseEntity<ResultResponse> {
        val result = service.getPresignedUrl(request)
        return ResponseEntity.ok(ResultResponse(result))
    }
}
