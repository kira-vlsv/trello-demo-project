package apitests.dto;

import lombok.*;
import lombok.experimental.Accessors;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrelloDTO {

	private int board;
	private int card;
}