package manju.domain.article;

import java.util.UUID;

public class ArticleId {
	private UUID value;
	
	public ArticleId(){
		this.value = UUID.randomUUID();
	}
	
	public ArticleId(UUID id){
		this.value = id;
	}
	
	public UUID getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return this.value.toString();
	}
}
