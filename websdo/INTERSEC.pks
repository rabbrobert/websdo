create or replace PROCEDURE Intersec (
   id1 IN  NUMBER,
   id2 IN  NUMBER,
    T_A  OUT SYS_REFCURSOR 
   )
IS
A NUMBER;

--CREATE 
 TYPE  ret_rec IS  RECORD
(
  MP_ID NUMBER,
 ID1  NUMBER,
 ID2  NUMBER

);
TYPE ret_recs IS TABLE OF ret_rec;

BEGIN

   DBMS_OUTPUT.PUT_LINE('');
END;

