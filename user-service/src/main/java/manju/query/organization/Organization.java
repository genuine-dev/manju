package manju.query.organization;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Organization {

	@Id
	private UUID id;

	private String name;

	private String displayName;

	private String description;

	@OneToMany(fetch = FetchType.EAGER)
	private List<OrganizationMember> members;

	@SuppressWarnings("unused")
	private Organization() {
	}

	public Organization(UUID id, String name, String displayName, String description) {
		this.id = id;
		this.name = name;
		this.displayName = displayName;
		this.description = description;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<OrganizationMember> getMembers() {
		return members;
	}
}
