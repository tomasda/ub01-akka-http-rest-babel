CREATE TABLE IF NOT EXISTS "FILES" (
    "T_EXP" varchar(1) NOT NULL,
    "P_EXP" varchar(2) NOT NULL,
    "A_EXP" varchar(4) NOT NULL,
    "C_EXP" varchar(1) NOT NULL,
    "N_EXP" varchar(9) NOT NULL,
    "DU_EXP" varchar(2) NOT NULL,
    "DE_EXP" varchar(2) NOT NULL,
    "TIPOIPF" character varying(1) NOT NULL,
    "NUMIPF" character varying(10) NOT NULL,
    "DUPIPF" character varying(2) NOT NULL,
    "DESIPF" character varying(2) NOT NULL,
    CONSTRAINT file_pkey PRIMARY KEY ("T_EXP", "P_EXP", "A_EXP", "C_EXP", "N_EXP", "DU_EXP", "DE_EXP")
);
