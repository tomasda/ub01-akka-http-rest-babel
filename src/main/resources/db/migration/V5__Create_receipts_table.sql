CREATE TABLE IF NOT EXISTS "RECEIPTS" (
   "ANIO_CONTABLE"  varchar(4),
   "ANIO"           varchar(4),
   "DIA_CONTABLE"   varchar(2),
   "DOC_CONT_ANIO"  integer DEFAULT 0,
   "DOC_CONT_DC"    varchar(1) ,
   "DOC_CONT_NUM"   varchar(7) ,
   "FECHA_EMISION"  date DEFAULT '1990-01-01',
   "FECHA_SITU"     date DEFAULT '1990-01-01',
   "LIQUIDO_EURO"   numeric(7,2) ,
   "LIT_NUEVA_SITU" varchar(20),
   "LIT_SITU"       varchar(20),
   "MES_CONTABLE"   varchar(2),
   "NUEVA_SITU"     varchar(1),
   "RECIBO"         varchar(13),
   "SITU"           varchar(1),
   "TIPO_PAGO"      varchar(20),
   CONSTRAINT receipt_pkey PRIMARY KEY ("ANIO", "RECIBO")
);