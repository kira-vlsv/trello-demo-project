package apitests.dto;

import lombok.*;
import lombok.experimental.Accessors;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LabelNamesDTO {
	private String orange;
	private String red;
	private String sky;
	private String pink;
	private String green;
	private String blue;
	private String lime;
	private String yellow;
	private String black;
	private String purple;
}
