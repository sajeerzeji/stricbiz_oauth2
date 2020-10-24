# StricBiz oAuth

## Scripts

```sql
CREATE TABLE roles (
    id serial primary key NOT NULL,
    role varchar DEFAULT NULL,
    description varchar DEFAULT NULL
);


CREATE TABLE users (
    id serial primary key NOT NULL,
    first_name varchar NOT NULL,
    last_name varchar NOT NULL,
    password varchar NOT NULL,
    username varchar NOT NULL
);

CREATE TABLE user_role (
    id serial NOT NULL,
    user_id bigint NOT NULL,
    role_id bigint NOT NULL,
    CONSTRAINT FK859n2jvi8ivhui0rl0esws6o FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT FKa68196081fvovjhkek5m97n3y FOREIGN KEY (role_id) REFERENCES roles (id)
);

drop table if exists oauth_client_details;
create table oauth_client_details (
    client_id VARCHAR(256) PRIMARY KEY,
    resource_ids VARCHAR(256),
    client_secret VARCHAR(256),
    scope VARCHAR(256),
    authorized_grant_types VARCHAR(256),
    web_server_redirect_uri VARCHAR(256),
    authorities VARCHAR(256),
    access_token_validity INTEGER,
    refresh_token_validity INTEGER,
    additional_information VARCHAR(4096),
    autoapprove VARCHAR(256)
);

drop table if exists oauth_client_token;
create table oauth_client_token (
    token_id VARCHAR(255),
    token bytea ,
    authentication_id VARCHAR(255),
    user_name VARCHAR(255),
    client_id VARCHAR(255)
);

drop table if exists oauth_access_token;
create table oauth_access_token (
    token_id VARCHAR(255),
    token bytea,
    authentication_id VARCHAR(255),
    user_name VARCHAR(255),
    client_id VARCHAR(255),
    authentication bytea,
    refresh_token VARCHAR(255)
);

drop table if exists oauth_refresh_token;
create table oauth_refresh_token (
    token_id VARCHAR(255),
    token bytea,
    authentication bytea
);

drop table if exists oauth_code;
create table oauth_code (
    code VARCHAR(255), authentication bytea
);




INSERT INTO roles (role, description)
    VALUES ('STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO roles (role, description)
    VALUES ('ADMIN_USER', 'Admin User - Has permission to perform admin tasks');

-- USER
-- non-encrypted password: jwtpass
INSERT INTO users (first_name, last_name, password, username)
    VALUES ('John', 'Doe', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'john.doe');
INSERT INTO users (first_name, last_name, password, username)
    VALUES ('Admin', 'Admin', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'admin.admin');


INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,2);

-- insert client details 
-- username: testjwtclientid, password: $2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe
INSERT INTO oauth_client_details
   (client_id, client_secret, scope, authorized_grant_types,
   authorities, access_token_validity, refresh_token_validity)
VALUES
   ('testjwtclientid', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe',
    'read,write', 'password,refresh_token,client_credentials,authorization_code',
    'ROLE_CLIENT,ROLE_TRUSTED_CLIENT', 900, 2592000);
```