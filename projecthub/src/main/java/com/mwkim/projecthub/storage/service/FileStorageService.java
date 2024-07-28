package com.mwkim.projecthub.storage.service;

import com.mwkim.projecthub.storage.entity.FileMetadata;
import com.mwkim.projecthub.storage.repository.FileMetadataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 *  파일 저장소 관련 작업을 처리하는 서비스 클래스.
 *
 *  이 클래스는 실제 파일 시스템에 대한 작업을 담당합니다.
 *  파일의 물리적 저장, 삭제, 경로 조회 등의 기능을 제공합니다.
 *
 * @note 파일 시스템 작업은 예외처리가 중요합니다. 모든 I/O 작업에서 예외를 적절히 처리해주세요.
 * @note 대용량 파일 처리 시 메모리 사용에 주의가 필요할 수 있습니다.
 */

@Service
@RequiredArgsConstructor
public class FileStorageService {

    private final String uploadDir; // 업로드 할 파일의 위치
    private final FileMetadataRepository fileMetadataRepository; // DI




}
