package manju.domain.article;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PublicationTargets {
	private List<PublicationTarget> value;

	public PublicationTargets(List<String> value) {
		this.value = value.stream()
				.map(target -> new PublicationTarget(target))
				.collect(Collectors.toList());
	}
	

	public List<PublicationTarget> getValue(){
		return Collections.unmodifiableList(value);
	}
}
