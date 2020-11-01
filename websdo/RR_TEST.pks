create or replace PACKAGE RR_TEST AS 

  /* TODO enter package declarations (types, exceptions, methods etc) here */ 
TYPE  ret_rec IS  RECORD
(
  X NUMBER,
  Y  NUMBER,
  Z  NUMBER

);
TYPE RET_RECS IS TABLE OF ret_rec INDEX BY PLS_INTEGER ;

PROCEDURE Intersec (
   id1 IN  NUMBER,
   id2 IN  NUMBER,
    RC  OUT RET_RECS 
   );
   
PROCEDURE getGtype (
   id1 IN  NUMBER,
   id2 IN  NUMBER,
   GT   OUT NUMBER 
   );

END RR_TEST;
/
