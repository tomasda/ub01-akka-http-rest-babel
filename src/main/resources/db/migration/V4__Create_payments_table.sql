CREATE TABLE IF NOT EXISTS "PAYMENTS" (
    "ANIO"          varchar(4) NOT NULL,
    "ENT_PAGO"      integer DEFAULT 0,
    "ENTIDAD"       varchar(3) NOT NULL,
    "FECHA_DESDE"   date DEFAULT '1990-01-01',
    "FECHA_HASTA"   date DEFAULT '1990-01-01',
    "MOD_PAGO"      varchar(1) ,
    "RECIBO"        varchar(10) NOT NULL,
    "SIT"           varchar(1) ,
    "SUC_PAGO"      integer DEFAULT 0,
    "TIP_PAGO"     varchar(20) ,
    "FILE"          varchar(21),
    CONSTRAINT payment_pkey PRIMARY KEY ("ANIO", "ENTIDAD", "RECIBO")
);