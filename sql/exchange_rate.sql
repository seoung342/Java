create table exchange_rate(
    num number primary key,
    hiredate date not null,
    us_exchange number not null,
    jp_exchange number not null
    );
    
CREATE SEQUENCE exchange_rate_AUTO  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;

create or replace TRIGGER test_exchange_rate_auto
BEFORE INSERT ON exchange_rate
FOR EACH ROW
BEGIN
    IF :NEW.num IS NULL THEN
        SELECT exchange_rate_auto.NEXTVAL
        INTO :NEW.num
        FROM dual;
    END IF;
END;
/

select * from exchange_rate;

insert into exchange_rate(hiredate, us_exchange, jp_exchange)
values (TO_DATE('2024-06-09', 'YYYY-MM-DD'), 1381, 881.05);
insert into exchange_rate(hiredate, us_exchange, jp_exchange)
values (TO_DATE('2024-06-16', 'YYYY-MM-DD'), 1389, 882.77);
insert into exchange_rate(hiredate, us_exchange, jp_exchange)
values (TO_DATE('2024-06-23', 'YYYY-MM-DD'), 1391, 871.23);
insert into exchange_rate(hiredate, us_exchange, jp_exchange)
values (TO_DATE('2024-06-30', 'YYYY-MM-DD'), 1382, 858.73);
insert into exchange_rate(hiredate, us_exchange, jp_exchange)
values (TO_DATE('2024-07-07', 'YYYY-MM-DD'), 1382.5, 859.84);
insert into exchange_rate(hiredate, us_exchange, jp_exchange)
values (TO_DATE('2024-07-14', 'YYYY-MM-DD'), 1377, 872.07);
insert into exchange_rate(hiredate, us_exchange, jp_exchange)
values (TO_DATE('2024-07-21', 'YYYY-MM-DD'), 1391.5, 883.58);
insert into exchange_rate(hiredate, us_exchange, jp_exchange)
values (TO_DATE('2024-07-28', 'YYYY-MM-DD'), 1385.5, 901.05);
insert into exchange_rate(hiredate, us_exchange, jp_exchange)
values (TO_DATE('2024-08-04', 'YYYY-MM-DD'), 1361.5, 929.22);
insert into exchange_rate(hiredate, us_exchange, jp_exchange)
values (TO_DATE('2024-08-11', 'YYYY-MM-DD'), 1366, 931.44);
insert into exchange_rate(hiredate, us_exchange, jp_exchange)
values (TO_DATE('2024-08-18', 'YYYY-MM-DD'), 1354, 917.59);
insert into exchange_rate(hiredate, us_exchange, jp_exchange)
values (TO_DATE('2024-08-25', 'YYYY-MM-DD'), 1329, 920.97);
