package manju.query.organization;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class OrganizationMember {
	
	@EmbeddedId
	private PrimaryKey pk;
	
	private String role;

	@SuppressWarnings("unused")
	private OrganizationMember(){}
	
	public OrganizationMember(UUID organizationId, String userId, String role) {
		this.pk = new PrimaryKey(organizationId, userId);
		this.role = role;
	}

	public UUID getOrganizationId() {
		return pk.getOrganizationId();
	}

	public String getUserId() {
		return pk.getUserId();
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Embeddable
	public static class PrimaryKey implements Serializable{
		private static final long serialVersionUID = 6459748958354314129L;

		private UUID organizationId;
		
		private String userId;
		
		@SuppressWarnings("unused")
		private PrimaryKey(){}

		public PrimaryKey(UUID organizationId, String userId) {
			this.organizationId = organizationId;
			this.userId = userId;
		}

		public UUID getOrganizationId() {
			return organizationId;
		}
		
		public String getUserId() {
			return userId;
		}
		
	}
	
}
