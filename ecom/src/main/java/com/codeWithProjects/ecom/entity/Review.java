package com.codeWithProjects.ecom.entity;

@Entity
@Data

public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationTypr.IDENTITY)
	private Long id;
	
	private Long rating;
	
	@Lob
	private String description;
	
	@Lob
	@Column(columnDefinition = "longblob")
	private byte[] img;
	
	@ManyToOne(fetcg = FetchType.LAZY, optional = false)
	@JoinColumn(name= "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "product_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Product product;
	
	public ReviewDto getDto() {
		ReviewDto reviewDto = new ReviewDto();
		
		reviewDto.setId(id);
		reviewDto.setRating(rating);
		reviewDto.setDescription(description);
		reviewDto.setReturnedImg(img);
		reviewDto.setProductId(product.getId());
		reviewDto.setUserId(user.getId());
		reviewDto.setUsername(use.getName());
		
	}
}
