package apitests.dto;

import lombok.*;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListDTO {
	private boolean subscribed;
	private String idBoard;
	private int pos;
	private String name;
	private boolean closed;
	private String id;
	private Object softLimit;
}
