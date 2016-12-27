package manju.query.organization;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OrganizationMemberRepository extends CrudRepository<OrganizationMember, OrganizationMember.PrimaryKey>{
	public List<OrganizationMember> findByPkUserId(String userId);
}
