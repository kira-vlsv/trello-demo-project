package apitests.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LimitsDTO {
}