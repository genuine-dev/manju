package manju.domain.article;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Tags {
	private List<Tag> value;

	public Tags(List<String> value) {
		this.value = value.stream()
				.map(tag -> new Tag(tag))
				.collect(Collectors.toList());
	}

	public List<Tag> getValue(){
		return Collections.unmodifiableList(value);
	}
}
