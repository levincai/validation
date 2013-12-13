package de.malkusch.validation.validator.upload;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

import de.malkusch.validation.constraints.upload.Image;

public class ImageValidator implements ConstraintValidator<Image, MultipartFile> {
	
	@Override
	public void initialize(Image constraintAnnotation) {
	}

	@Override
	public boolean isValid(MultipartFile file,
			ConstraintValidatorContext context) {
		
		try {
			if (file == null || file.isEmpty()) {
				return true;
				
			}
			return ImageIO.read(file.getInputStream()) != null;
			
		} catch (IOException e) {
			throw new IllegalStateException(e);
			
		}
	}

}
