create or replace PACKAGE TT AUTHID DEFINER
AS
	TYPE tt_list IS TABLE OF VARCHAR2(20);
	PROCEDURE  tjobs;
	PROCEDURE signal_success(
        event_name IN VARCHAR2
    );
	PROCEDURE signal_failure(
        event_name  IN VARCHAR2,
        message     IN VARCHAR2 DEFAULT 'FAILED'
    );


	PROCEDURE run_test(testnr IN  NUMBER,  job_name  IN VARCHAR2 DEFAULT NULL);


END TT;
/
