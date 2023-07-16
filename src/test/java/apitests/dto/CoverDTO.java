package apitests.dto;

import lombok.*;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoverDTO {
	private Object idUploadedBackground;
	private String brightness;
	private Object color;
	private String size;
	private Object idAttachment;
	private Object idPlugin;
}