-- JPA (with Hibernate as provider) applies a default naming strategy that maps by default, camelCase → snake_case.
-- fullName (java) -> full_name (column)
CREATE TABLE test (
     id                UUID PRIMARY KEY DEFAULT gen_random_uuid(),
     email             VARCHAR(100)    NOT NULL,
     role              VARCHAR(255)    NOT NULL,
     created_at        TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
     updated_at        TIMESTAMP WITHOUT TIME ZONE,
     created_by        VARCHAR(100),
     updated_by        VARCHAR(100),
     UNIQUE (email)
);

CREATE INDEX idx_invite_email      ON test(email);
GRANT ALL PRIVILEGES ON TABLE test TO admin;