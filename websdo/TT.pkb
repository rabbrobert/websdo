create or replace PACKAGE BODY TT AS

PROCEDURE signal_failure(event_name  IN VARCHAR2, message     IN VARCHAR2 DEFAULT 'FAILED')
AS  
    PRAGMA AUTONOMOUS_TRANSACTION;
BEGIN
    dbms_alert.signal(name => event_name, message => message);
    COMMIT;
END signal_failure;

PROCEDURE signal_success(  event_name IN VARCHAR2 )
AS    
    PRAGMA AUTONOMOUS_TRANSACTION;
BEGIN
    dbms_alert.signal(name => event_name, message => 'SUCCEEDED');
    COMMIT;
END signal_success;

PROCEDURE error_test
AS
	v_feld   VARCHAR(10 CHAR);
BEGIN
    v_feld := '12345678';

END error_test;

PROCEDURE run_test(testnr IN  NUMBER,  job_name  IN VARCHAR2 DEFAULT NULL)
AS
	v_feld   VARCHAR(10 CHAR);
BEGIN    
    error_test();
    signal_success(job_name); 
EXCEPTION
	WHEN OTHERS
    THEN
        ROLLBACK;
        signal_failure(job_name,' SQLCODE: ' ||SQLCODE || ' SQLERRM: ' || SQLERRM );
        RAISE;
END run_test;



PROCEDURE  tjobs
AS
        v_job_name              VARCHAR(50 CHAR);
        v_job_name_with_schema  VARCHAR(100 CHAR);
		v_job_msg               VARCHAR2(4000 CHAR);
        v_job_status            NUMBER;
        v_err_msg               VARCHAR2(4000 CHAR);
        v_processed_events      tt_list   := tt_list();
        v_erroneous_events      tt_list   := tt_list();
BEGIN
        DBMS_OUTPUT.ENABLE (buffer_size => NULL);
		v_job_name := 'T1_JOB';
		v_job_name_with_schema := 'RR.' || v_job_name;

		-- register wait event for this job
		dbms_alert.register(v_job_name);

		dbms_scheduler.create_job(job_name => v_job_name_with_schema,job_type => 'STORED_PROCEDURE',job_action => 'TT.run_test',
		number_of_arguments => 2,start_date => NULL,job_class => 'SYS.UPD_TABLES_JOB_CLASS',repeat_interval => NULL,end_date => NULL,enabled => false,auto_drop => true,comments => '');

		dbms_scheduler.set_attribute(name => v_job_name_with_schema, attribute => 'LOGGING_LEVEL', value =>DBMS_SCHEDULER.LOGGING_RUNS) ;
		dbms_scheduler.set_job_argument_value(job_name => v_job_name_with_schema,argument_position => 1,argument_value => 1);
		dbms_scheduler.set_job_argument_value(job_name => v_job_name_with_schema,argument_position => 2,argument_value => v_job_name);

		dbms_scheduler.enable(name => v_job_name_with_schema);

		v_processed_events.extend();
		v_processed_events(v_processed_events.count) := v_job_name;
        DBMS_OUTPUT.put_line('Job:' || v_job_name);

      -- wait for jobs to end
		dbms_alert.waitone(name => v_job_name, message => v_job_msg, status => v_job_status, timeout => 86400000);
		dbms_alert.remove(v_job_name); -- unregister alert event

        DBMS_OUTPUT.put_line('Return message:' || v_job_msg);
		IF
			v_job_msg <> 'SUCCEEDED'
		THEN
			v_erroneous_events.extend();
			v_erroneous_events(v_erroneous_events.count) := v_job_msg;
		END IF;

        -- cleanup all registered alerts
        dbms_alert.removeall;

        -- report errors and raise condition
        IF v_erroneous_events.count > 0 THEN
            SELECT LISTAGG(column_value, CHR(10)) WITHIN GROUP (order by column_value) INTO v_err_msg FROM TABLE(v_erroneous_events) WHERE rownum <= 10;
            IF v_erroneous_events.count > 10 THEN
                v_err_msg := v_err_msg || CHR(10) || '('||(v_erroneous_events.count-10)||') more events...';
            END IF;
            DBMS_OUTPUT.put_line('raise_application_error: ' || v_err_msg);
            raise_application_error(-20252,'Error while call run_test: ' || CHR(10) || v_err_msg);
        END IF;

END tjobs;

END  TT;
/
