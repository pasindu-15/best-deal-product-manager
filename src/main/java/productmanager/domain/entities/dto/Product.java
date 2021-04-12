package productmanager.domain.entities.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product{

	private Integer shopCode;
	private List<OfferItem> offers;
	private String image;
	private String itemName;
	private String itemType;
	private Integer itemCode;
	private String shopName;
	private String description;

}