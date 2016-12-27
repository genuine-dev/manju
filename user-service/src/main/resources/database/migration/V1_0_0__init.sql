

CREATE TABLE IF NOT EXISTS user (
	id VARCHAR(30) NOT NULL,
	email_address VARCHAR(256) NOT NULL,
	avatar_url VARCHAR(256) NOT NULL,
	created_at TIMESTAMP NOT NULL default now(),
	modified_at TIMESTAMP NOT NULL default now(),
	CONSTRAINT pk_user PRIMARY KEY(id)
)
;

CREATE TABLE  IF NOT EXISTS organization (
	id BINARY(16) NOT NULL,
	name VARCHAR(30) NOT NULL,
	display_name VARCHAR(100) NOT NULL,
	description text,
	created_at TIMESTAMP NOT NULL default now(),
	modified_at TIMESTAMP NOT NULL default now(),
	CONSTRAINT pk_organization PRIMARY KEY(id),
	CONSTRAINT unq_organization UNIQUE(name)
)
;

CREATE TABLE  IF NOT EXISTS organization_member (
	organization_id BINARY(16) NOT NULL,
	user_id VARCHAR(30) NOT NULL,
	role VARCHAR(30) NOT NULL,
	created_at TIMESTAMP NOT NULL default now(),
	modified_at TIMESTAMP NOT NULL default now(),
	CONSTRAINT pk_organization_member PRIMARY KEY(organization_id, user_id),
	CONSTRAINT fk_organization_member_organization_id FOREIGN KEY (organization_id) REFERENCES organization(id),
	CONSTRAINT fk_organization_member_user_id FOREIGN KEY (user_id) REFERENCES user(id)
)
;
