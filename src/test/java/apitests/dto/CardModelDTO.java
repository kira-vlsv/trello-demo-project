package apitests.dto;

import lombok.*;
import lombok.experimental.Accessors;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardModelDTO {

	private DescDataDTO descDataDTO;
	private List<Object> attachments;
	private List<Object> idLabels;
	private String shortUrl;
	private boolean dueComplete;
	private String dateLastActivity;
	private String idList;
	private List<Object> idMembersVoted;
	private String shortLink;
	private CoverDTO coverDTO;
	private Object dueReminder;
	private boolean subscribed;
	private int pos;
	private List<Object> idChecklists;
	private List<Object> stickers;
	private String id;
	private Object email;
	private LimitsDTO limitsDTO;
	private String idBoard;
	private Object cardRole;
	private Object start;
	private List<Object> checkItemStates;
	private String url;
	private List<Object> labels;
	private List<Object> idMembers;
	private BadgesDTO badgesDTO;
	private int idShort;
	private Object due;
	private Object idAttachmentCover;
	private boolean isTemplate;
	private String name;
	private boolean closed;
	private boolean manualCoverAttachment;
	private String desc;
}