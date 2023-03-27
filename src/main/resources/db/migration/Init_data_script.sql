/* Data para inicializar la BBDD */

/* V1 PROFILES" Data */

INSERT INTO "PROFILES"("ID", "FIRST_NAME", "LAST_NAME","TIPO_IPF","NUM_IPF","DUP_IPF","DES_IPF")
	VALUES ('1', 'MENDEZ', 'CRISPIN MARTIN', '1', '073401680D', '01', '00');
INSERT INTO "PROFILES"("ID", "FIRST_NAME", "LAST_NAME","TIPO_IPF","NUM_IPF","DUP_IPF","DES_IPF")
    VALUES ('2', 'ANGEL', 'PEREZ PEREZ', '1', '000000000T', '01', '00');
INSERT INTO "PROFILES"("ID", "FIRST_NAME", "LAST_NAME","TIPO_IPF","NUM_IPF","DUP_IPF","DES_IPF")
    VALUES ('3', 'ROBERTO', 'DIAZ DIAZ', '1', '000000001R', '01', '00');

/* V2 PRO"FILES" Data */
/* INSERT INTO "AUTH"(
	"ID", "USERNAME", "EMAIL", "PASSWORD")
	VALUES ('1', 'tdelgado', 'tdelgado@opencanarias.es', '88a0ca91aa499de5d8851f8e75e40fe01845f8ee7d16672ea52b00bf3f80c276'); */
INSERT INTO "AUTH"(
    "ID", "USERNAME", "EMAIL", "PASSWORD")
    VALUES ('1', 'user', 'user@opencanarias.es', '04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb');

/* V3 "FILES" Data */

INSERT INTO "FILES" ("T_EXP", "P_EXP", "A_EXP", "C_EXP", "N_EXP", "DU_EXP", "DE_EXP", "TIPOIPF", "NUMIPF", "DUPIPF", "DESIPF") VALUES ('1', '01', '1900', '3', '000003295', '01', '00', '1','073401680D','01','00');
INSERT INTO "FILES" ("T_EXP", "P_EXP", "A_EXP", "C_EXP", "N_EXP", "DU_EXP", "DE_EXP", "TIPOIPF", "NUMIPF", "DUPIPF", "DESIPF") VALUES ('1', '01', '1900', '3', '000003296', '01', '00', '1','000000000T','01','00');
INSERT INTO "FILES" ("T_EXP", "P_EXP", "A_EXP", "C_EXP", "N_EXP", "DU_EXP", "DE_EXP", "TIPOIPF", "NUMIPF", "DUPIPF", "DESIPF") VALUES ('1', '01', '1900', '3', '000003297', '01', '00', '1','000000001R','01','00');


/* V4 PAYMENTS Data */
/*** USUARIO 1073401680D0100 101190030000032950100 ***/

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2021', '101', '7024025504', 'I', '2', 2095, 3132, '2021-04-01', '2021-06-30', 'NOMINA NORMAL','101190030000032950100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2021', '101', '1022025492', 'I', '2', 2095, 3132, '2021-02-01', '2021-10-31', 'NOMINA NORMAL','101190030000032950100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2021', '101','6021025520',  'I', '2', 2095, 3132, '2021-01-01',  '2021-04-30', 'NOMINA NORMAL','101190030000032950100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2021', '101', '2023025527','P', '2', 2095, 3132, '2021-03-01', '2022-03-31', 'NOMINA NORMAL','101190030000032950100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2021', '101', '1022025499', 'P', '2',  2095, 3132, '2021-02-01', '2021-02-28',  'NOMINA NORMAL','101190030000032950100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2021', '101', '6021025529',  'P', '2',  2095, 3132, '2021-01-01', '2021-01-31',  'NOMINA NORMAL','101190030000032950100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2020', '101',  '6032025562',  'P',  '2',  2095, 3132, '2020-12-01',  '2020-12-31', 'NOMINA NORMAL','101190030000032950100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2020', '101',  '8231025506',  'P', '2', 2095, 3132,  '2020-06-01', '2020-11-30', 'PAGA EXTRA','101190030000032950100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2020', '101', '2031025507', 'P', '2',  2095,3132,  '2020-11-01',  '2020-11-30', 'NOMINA NORMAL','101190030000032950100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2020', '101', '9030025457', 'P',  '2',  2095, 3132, '2020-10-01', '2020-10-31', 'NOMINA NORMAL','101190030000032950100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2020',  '101',  '5029025489',  'P',  '2', 2095,3132,  '2020-09-01',  '2020-09-30',  'NOMINA NORMAL','101190030000032950100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2020', '101', '9028025510', 'P',  '2',  2095,3132,  '2020-08-01',  '2020-08-31', 'NOMINA NORMAL','101190030000032950100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2020', '101',  '7027025464', 'P',  '2',2095,  3132,  '2020-07-01', '2020-07-31', 'NOMINA NORMAL','101190030000032950100');

/***   USUARIO 1000000000T0100  101190030000032960100***/

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2021', '101', '7024025505', 'I', '2', 2095, 3132, '2021-04-01', '2021-06-30', 'NOMINA NORMAL','101190030000032960100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2021', '101', '1022025491', 'I', '2', 2095, 3132, '2021-02-01', '2021-10-31', 'NOMINA NORMAL','101190030000032960100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2021', '101','6021025521',  'I', '2', 2095, 3132, '2021-01-01',  '2021-04-30', 'NOMINA NORMAL','101190030000032960100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2021', '101', '2023025526','P', '2', 2095, 3132, '2021-03-01', '2022-03-31', 'NOMINA NORMAL','101190030000032960100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2021', '101', '1022025450', 'P', '2',  2095, 3132, '2021-02-01', '2021-02-28',  'NOMINA NORMAL','101190030000032960100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2021', '101', '6021025528',  'P', '2',  2095, 3132, '2021-01-01', '2021-01-31',  'NOMINA NORMAL','101190030000032960100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2020', '101',  '6032025563',  'P',  '2',  2095, 3132, '2020-12-01', '2020-12-31', 'NOMINA NORMAL','101190030000032960100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2020', '101',  '8231025505',  'P', '2', 2095, 3132,  '2020-06-01', '2020-11-30', 'PAGA EXTRA','101190030000032960100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2020', '101', '2031025508', 'P', '2',  2095,3132,  '2020-11-01',  '2020-11-30', 'NOMINA NORMAL','101190030000032960100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2020', '101', '9030025456', 'P',  '2',  2095, 3132, '2020-10-01', '2020-10-31', 'NOMINA NORMAL','101190030000032960100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2020',  '101',  '5029025490',  'P',  '2', 2095,3132,  '2020-09-01',  '2020-09-30',  'NOMINA NORMAL','101190030000032960100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2020', '101', '9028025509', 'P',  '2',  2095,3132,  '2020-08-01',  '2020-08-31', 'NOMINA NORMAL','101190030000032960100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2020', '101',  '7027025465', 'P',  '2',2095,  3132,  '2020-07-01', '2020-07-31', 'NOMINA NORMAL','101190030000032960100');

/*** USUARIO 1000000001R0100 ***/

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2021', '101', '7024025506', 'I', '2', 2095, 3132, '2021-04-01', '2021-06-30', 'NOMINA NORMAL','101190030000032970100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2021', '101', '1022025490', 'I', '2', 2095, 3132, '2021-02-01', '2021-10-31', 'NOMINA NORMAL','101190030000032970100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2021', '101','6021025522',  'I', '2', 2095, 3132, '2021-01-01',  '2021-04-30', 'NOMINA NORMAL','101190030000032970100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2021', '101', '2023025525','P', '2', 2095, 3132, '2021-03-01', '2022-03-31', 'NOMINA NORMAL','101190030000032970100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2021', '101', '1022025451', 'P', '2',  2095, 3132, '2021-02-01', '2021-02-28',  'NOMINA NORMAL','101190030000032970100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2021', '101', '6021025527',  'P', '2',  2095, 3132, '2021-01-01', '2021-01-31',  'NOMINA NORMAL','101190030000032970100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2020', '101',  '6032025564',  'P',  '2',  2095, 3132, '2020-12-01',  '2020-12-31', 'NOMINA NORMAL','101190030000032970100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2020', '101',  '8231025504',  'P', '2', 2095, 3132,  '2020-06-01', '2020-11-30', 'PAGA EXTRA','101190030000032970100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2020', '101', '2031025509', 'P', '2',  2095,3132,  '2020-11-01',  '2020-11-30', 'NOMINA NORMAL','101190030000032970100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2020', '101', '9030025455', 'P',  '2',  2095, 3132, '2020-10-01', '2020-10-31', 'NOMINA NORMAL','101190030000032970100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2020',  '101',  '5029025491',  'P',  '2', 2095,3132,  '2020-09-01',  '2020-09-30',  'NOMINA NORMAL','101190030000032970100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2020', '101', '9028025508', 'P',  '2',  2095,3132,  '2020-08-01',  '2020-08-31', 'NOMINA NORMAL','101190030000032970100');

INSERT INTO "PAYMENTS"(
	"ANIO", "ENTIDAD", "RECIBO", "SIT", "MOD_PAGO", "ENT_PAGO", "SUC_PAGO", "FECHA_DESDE", "FECHA_HASTA", "TIP_PAGO" ,"FILE")
	VALUES ('2020', '101',  '7027025466', 'P',  '2',2095,  3132,  '2020-07-01', '2020-07-31', 'NOMINA NORMAL','101190030000032970100');


/* V5 Receipts Data */
/*  RECEIPTS */

INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1012031025507', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1012031025508', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1012031025509', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1015029025489', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1015029025490', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1015029025491', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1016032025562', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1016032025563', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1016032025564', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1017027025464', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1017027025465', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1017027025466', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1018231025504', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1018231025505', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1018231025506', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1019028025508', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1019028025509', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1019028025510', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1019030025455', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1019030025456', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1019030025457', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1011022025450', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1011022025451', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1011022025490', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1011022025491', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1011022025492', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1011022025499', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1012023025525', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1012023025526', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1012023025527', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1016021025520', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1016021025521', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1016021025522', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1016021025527', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1016021025528', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1016021025529', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1017024025504', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
    "ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
    "LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
     VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
 1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1017024025505', 'P', 'PAGADO EFECTIVO');
INSERT INTO "RECEIPTS"(
	"ANIO_CONTABLE", "ANIO", "DIA_CONTABLE", "DOC_CONT_ANIO", "DOC_CONT_DC", "DOC_CONT_NUM", "FECHA_EMISION", "FECHA_SITU",
	"LIQUIDO_EURO", "LIT_NUEVA_SITU", "LIT_SITU", "MES_CONTABLE", "NUEVA_SITU", "RECIBO", "SITU", "TIPO_PAGO")
	 VALUES ('2021', '2021', '10', 2020, '1', 'AB32425', '2021-03-05', '2021-03-05',
     1000.50, 'Literal n situación', 'NEW-SIT', 'FE', 'N', '1017024025506', 'P', 'PAGADO EFECTIVO');



/*  1 MAPA-PHNMSIP1.#A#O-CONTABLE (A004)
    1 MAPA-PHNMSIP1.#ANNO (A004)
    1 MAPA-PHNMSIP1.#DIA-CONTABLE (A002)
    1 MAPA-PHNMSIP1.#DOC-CONT-A#O (N04,0)
    1 MAPA-PHNMSIP1.#DOC-CONT-dc (A001)
    1 MAPA-PHNMSIP1.#DOC-CONT-num (A007)
    1 MAPA-PHNMSIP1.#FECHA-EMISION (N08,0)
    1 MAPA-PHNMSIP1.#FECHA-SITU (N08,0)
    1 MAPA-PHNMSIP1.#LIQUIDO-EURO (N07,2)
    1 MAPA-PHNMSIP1.#LIT-NUEVA-SITU (A020)
    1 MAPA-PHNMSIP1.#LIT-SITU (A020)
    1 MAPA-PHNMSIP1.#MES-CONTABLE (A002)
    1 MAPA-PHNMSIP1.#NUEVA-SITU (A001)
    1 MAPA-PHNMSIP1.#RECIBO (A013)
    1 MAPA-PHNMSIP1.#SITU (A001)
    1 MAPA-PHNMSIP1.#TIPO-PAGO (A020) */