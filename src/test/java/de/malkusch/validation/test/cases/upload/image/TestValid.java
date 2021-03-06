package de.malkusch.validation.test.cases.upload.image;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import de.malkusch.validation.constraints.upload.Image;
import de.malkusch.validation.test.cases.AbstractValidTest;
import de.malkusch.validation.test.model.AbstractBean;

/**
 * @author Markus Malkusch
 */
public class TestValid extends AbstractValidTest {
	
	public static class Bean extends AbstractBean<MultipartFile> {
		
		@Override
		@Image
		public MultipartFile getProperty() {
			return super.getProperty();
		}
		
	}
	
	public <T>TestValid(Class<AbstractBean<T>> beanType, T property) {
		super(beanType, property);
	}

	@Parameters
	static public List<Object[]> beans() throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ImageIO.write(new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB), "jpeg", out);
		byte[] image = out.toByteArray();
		
		return Arrays.asList(new Object[][] {
				{ Bean.class, null },
				{ Bean.class, new MockMultipartFile("file", new byte[]{}) },
				{ Bean.class, new MockMultipartFile("file", image) },
		});
	}

}