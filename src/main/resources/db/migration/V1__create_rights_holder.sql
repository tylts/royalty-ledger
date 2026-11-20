CREATE TABLE rights_holder
(
    id         BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name       VARCHAR(200) NOT NULL,
    type       VARCHAR(20)  NOT NULL,
    email      VARCHAR(320),
    created_at TIMESTAMPTZ  NOT NULL DEFAULT now(),

    CONSTRAINT chk_rights_holder_type
        CHECK ( type IN ('WRITER', 'PUBLISHER', 'LABEL', 'ARTIST') )
);