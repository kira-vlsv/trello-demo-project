package apitests.dto;

import lombok.*;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrefsDTO {
	private String backgroundBrightness;
	private String backgroundColor;
	private String comments;
	private String backgroundTopColor;
	private boolean canBeEnterprise;
	private boolean hideVotes;
	private Object backgroundImage;
	private boolean canBeOrg;
	private String backgroundBottomColor;
	private String voting;
	private boolean calendarFeedEnabled;
	private boolean backgroundTile;
	private boolean canBePublic;
	private boolean canBePrivate;
	private Object backgroundImageScaled;
	private String permissionLevel;
	private String cardAging;
	private boolean canInvite;
	private String invitations;
	private boolean isTemplate;
	private String background;
	private boolean cardCovers;
	private boolean selfJoin;
}
