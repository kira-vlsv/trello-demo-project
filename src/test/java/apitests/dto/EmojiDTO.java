package apitests.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmojiDTO {
}