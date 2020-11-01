create or replace PROCEDURE calc_secs_between (
   date1 IN DATE,
   date2 IN DATE,
   secs OUT NUMBER)
IS
BEGIN
   -- 24 hours in a day, 
   -- 60 minutes in an hour,
   -- 60 seconds in a minute...
   secs := (date2 - date1) * 24 * 60 * 60;
END;
/
