package apitests.dto;

import lombok.*;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BadgesDTO {
	private int comments;
	private int attachments;
	private AttachmentsByTypeDTO attachmentsByTypeDTO;
	private boolean dueComplete;
	private Object start;
	private boolean description;
	private Object checkItemsEarliestDue;
	private boolean subscribed;
	private Object due;
	private boolean viewingMemberVoted;
	private boolean location;
	private int votes;
	private String fogbugz;
	private int checkItems;
	private int checkItemsChecked;
}