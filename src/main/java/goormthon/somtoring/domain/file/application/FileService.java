package goormthon.somtoring.domain.file.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import goormthon.somtoring.domain.file.domain.File;
import goormthon.somtoring.domain.file.infrastructure.FileRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileService {
	private final FileRepository fileRepository;
	private final FileUploader fileUploader;

	@Transactional
	public File uploadAndSaveFile(MultipartFile multipartFile) {
		String url = fileUploader.upload(multipartFile, multipartFile.getOriginalFilename());
		File file = File.of(multipartFile.getOriginalFilename(), url);
		return fileRepository.save(file);
	}
}
