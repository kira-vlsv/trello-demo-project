package apitests.dto;

import lombok.*;
import lombok.experimental.Accessors;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MembershipsItemDTO {
	private boolean unconfirmed;
	private String idMember;
	private String id;
	private String memberType;
	private boolean deactivated;
}
