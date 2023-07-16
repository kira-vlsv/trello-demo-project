package apitests.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BoardDTO extends BaseDTO {
	private Object descData;
	private List<Object> idTags;
	private Object pinned;
	private LabelNamesDTO labelNamesDTO;
	private String shortUrl;
	private Object dateLastActivity;
	private Object datePluginDisable;
	private Object dateClosed;
	private String shortLink;
	private Object idBoardSource;
	private List<MembershipsItemDTO> memberships;
	private String creationMethod;
	private boolean subscribed;
	private boolean starred;
	private String idOrganization;
	private String dateLastView;
	private String id;
	private Object limits;
	private List<Object> powerUps;
	private Object templateGallery;
	private List<String> premiumFeatures;
	private String url;
	private PrefsDTO prefs;
	private boolean enterpriseOwned;
	private Object ixUpdate;
	private Object idEnterprise;
	private String name;
	private boolean closed;
	private String idMemberCreator;
	private String desc;
}