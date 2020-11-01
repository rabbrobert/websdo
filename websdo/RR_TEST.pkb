create or replace PACKAGE BODY RR_TEST AS

PROCEDURE Intersec (
   id1 IN  NUMBER,
   id2 IN  NUMBER,
   RC  OUT RET_RECS 
   ) 
IS
SMT VARCHAR2(512);
A NUMBER;
BEGIN
    SMT := 'SELECT X, Y, Z FROM (TABLE(SDO_UTIL.GETVERTICES(  (  SELECT SDO_GEOM.SDO_INTERSECTION(  (select a.shape from test_ldr a where mp_id=:1)   
    ,(select b.shape from test_ldr b  where mp_id=:2),  0.05)  FROM DUAL ) )  ) ) ';
    EXECUTE IMMEDIATE SMT 
      BULK COLLECT INTO RC  USING  id1 , id2;
   
END;


PROCEDURE getGtype (
   id1 IN  NUMBER,
   id2 IN  NUMBER,
   GT   OUT NUMBER 
   ) 
IS
SMT VARCHAR2(512);
A NUMBER;
BEGIN
    SMT := 'SELECT  o.r.sdo_gtype from (SELECT   SDO_GEOM.SDO_INTERSECTION(  (select a.shape from test_ldr a where mp_id=:1)   
,(select b.shape from test_ldr b  where mp_id=:2),  0.05) as r  FROM DUAL )   o';
    EXECUTE IMMEDIATE SMT  INTO GT  USING  id1, id2;
   
END;




END RR_TEST;
/
