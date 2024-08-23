create table test_stock_info(
    num number primary key,
    country_type varchar2(30) not null,
    ticker varchar2(20) not null,
    amount number(20,6) not null,
    purchase_price number(20,2) not null,
    now_price number(20,2) not null,
    purchase_total number(22,8) not null,
    now_total number(22,8) not null,
    hiredate date,
    user_id varchar2(10) not null
);

drop table test_stock_info;

CREATE SEQUENCE STOCK_INFO_AUTO  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;

create or replace TRIGGER test_stock_info_auto
BEFORE INSERT ON test_stock_info
FOR EACH ROW
BEGIN
    IF :NEW.num IS NULL THEN
        SELECT stock_info_auto.NEXTVAL
        INTO :NEW.num
        FROM dual;
    END IF;
END;
/

select * from test_stock_info;

select country_type, sum(purchase_total), sum(now_total) , hiredate from test_stock_info group by country_type,hiredate;

commit;
/*
 2024-05-26
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'SOXL', 0.003803,43.39,51.44,0.16501217,0.19562632, TO_DATE('2024-05-26', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'JEPQ', 43.104547,46.87,54.38,2020.310118,2344.025266, TO_DATE('2024-05-26', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'MAIN', 10.400108,42.07,48.55,437.5325436,504.9252434, TO_DATE('2024-05-26', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'NVDA', 0.013809,940.87,1064.69,12.99247383,14.70230421, TO_DATE('2024-05-26', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'SCHD', 20.389945,73.24,78.1,1493.359572,1592.454705, TO_DATE('2024-05-26', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'QQQM', 0.232698,180.47,188.48,41.99500806,43.85891904, TO_DATE('2024-05-26', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'AAPL', 1.66825,182.85,189.98,305.0395125,316.934135, TO_DATE('2024-05-26', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'JEPI', 40.331417,55.15,56.92,2224.277648,2295.664256, TO_DATE('2024-05-26', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'VOO', 0.088637,473.74,486.73,41.99089238,43.14228701, TO_DATE('2024-05-26', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'O', 15.36158,52.92,52.22,812.9348136,802.1817076, TO_DATE('2024-05-26', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('일본 ETF', '1489.t', 5,2302,2345,11510,11725, TO_DATE('2024-05-26', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('일본 ETF', '1655.t', 220,573.05,597.4,126071,131428, TO_DATE('2024-05-26', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('일본 ETF', '2529.t', 10,1726,1713,17260,17130, TO_DATE('2024-05-26', 'YYYY-MM-DD'), 'root');

2024-06-02
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'SOXL', 0.023437,51.46,48.59,1.20606802,1.13880383, TO_DATE('2024-06-02', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'JEPQ', 43.178301,46.89,54.19,2024.630534,2339.832131, TO_DATE('2024-06-02', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'MAIN', 10.482572,42.12,49,441.5259326,513.646028, TO_DATE('2024-06-02', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'NVDA', 0.017378,997.72,1096.33,17.33837816,19.05202274, TO_DATE('2024-06-02', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'SCHD', 20.44178,73.24,78.57,1497.155967,1606.110655, TO_DATE('2024-06-02', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'QQQM', 0.254115,181,185.87,45.994815,47.23235505, TO_DATE('2024-06-02', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'AAPL', 1.66825,182.85,192.25,305.0395125,320.7210625, TO_DATE('2024-06-02', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'JEPI', 40.40237,55.15,56.83,2228.190706,2296.066687, TO_DATE('2024-06-02', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'VOO', 0.096916,474.54,484.62,45.99051864,46.96743192, TO_DATE('2024-06-02', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'O', 15.438363,105.83,106.18,1633.841956,1639.245383, TO_DATE('2024-06-02', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('일본 ETF', '1489.t', 5,2302,2407,11510,12035, TO_DATE('2024-06-02', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('일본 ETF', '1655.t', 220,573.05,591.4,126071,130108, TO_DATE('2024-06-02', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('일본 ETF', '2529.t', 10,1726,1744,17260,17440, TO_DATE('2024-06-02', 'YYYY-MM-DD'), 'root');

2024-06-09
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'SOXL', 0.023437,51.46,51.87,1.20606802,1.21567719, TO_DATE('2024-06-09', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'JEPQ', 43.252331,46.9,54.49,2028.534324,2356.819516, TO_DATE('2024-06-09', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'MAIN', 10.563897,42.17,48.75,445.4795365,514.9899788, TO_DATE('2024-06-09', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'NVDA', 0.020796,1009.23,1208.88,20.98794708,25.13986848, TO_DATE('2024-06-09', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'SCHD', 20.492964,73.26,77.89,1501.314543,1596.196966, TO_DATE('2024-06-09', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'QQQM', 0.27538,181.55,190.53,49.995239,52.4681514, TO_DATE('2024-06-09', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'AAPL', 1.66825,182.85,196.86,305.0395125,328.411695, TO_DATE('2024-06-09', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'JEPI', 40.473337,55.15,56.52,2232.104536,2287.553007, TO_DATE('2024-06-09', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'VOO', 0.105127,475.51,490.8,49.98893977,51.5963316, TO_DATE('2024-06-09', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'O', 15.513729,52.91,53.32,820.8314014,827.1920303, TO_DATE('2024-06-09', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('일본 ETF', '1489.t', 5,2302,2382,11510,11910, TO_DATE('2024-06-09', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('일본 ETF', '1655.t', 220,573.05,601.5,126071,132330, TO_DATE('2024-06-09', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('일본 ETF', '2529.t', 10,1726,1731,17260,17310, TO_DATE('2024-06-09', 'YYYY-MM-DD'), 'root');

2024-06-16
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'MSFT', 0.002264,441.65,442.57,0.9998956,1.00197848, TO_DATE('2024-06-16', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'JEPQ', 43.343405,46.92,55.18,2033.672563,2391.689088, TO_DATE('2024-06-16', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'MAIN', 10.665973,42.24,49.34,450.5306995,526.2591078, TO_DATE('2024-06-16', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'NVDA', 0.2478,104.87,131.88,25.986786,32.679864, TO_DATE('2024-06-16', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'SCHD', 20.557754,73.27,76.79,1506.266636,1578.62993, TO_DATE('2024-06-16', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'QQQM', 0.301155,182.61,197.19,54.99391455,59.38475445, TO_DATE('2024-06-16', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'AAPL', 1.672945,182.94,212.49,306.0485583,355.4840831, TO_DATE('2024-06-16', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'JEPI', 40.562079,55.15,56.2,2236.998657,2279.58884, TO_DATE('2024-06-16', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'VOO', 0.115227,477.22,498.98,54.98862894,57.49596846, TO_DATE('2024-06-16', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'O', 15.608796,52.91,53.33,825.8613964,832.4170907, TO_DATE('2024-06-16', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('일본 ETF', '1489.t', 5,2302,2351,11510,11755, TO_DATE('2024-06-16', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('일본 ETF', '1655.t', 220,573.05,620.2,126071,136444, TO_DATE('2024-06-16', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('일본 ETF', '2529.t', 10,1726,1724,17260,17240, TO_DATE('2024-06-16', 'YYYY-MM-DD'), 'root');

2024-06-23
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'MSFT', 0.011236,444.9,449.78,4.9988964,5.05372808, TO_DATE('2024-06-23', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'JEPQ', 43.415769,46.93,55.24,2037.502039,2398.28708, TO_DATE('2024-06-23', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'MAIN', 10.746792,42.29,49.19,454.4818337,528.6346985, TO_DATE('2024-06-23', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'NVDA', 0.278076,107.83,126.57,29.98493508,35.19607932, TO_DATE('2024-06-23', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'SCHD', 20.609315,73.28,78.12,1510.250603,1609.999688, TO_DATE('2024-06-23', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'QQQM', 0.321293,183.61,197.54,58.99260773,63.46821922, TO_DATE('2024-06-23', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'AAPL', 1.691703,183.27,207.49,310.0384088,351.0114555, TO_DATE('2024-06-23', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'JEPI', 40.632978,55.16,56.7,2241.315066,2303.889853, TO_DATE('2024-06-23', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'VOO', 0.123186,478.85,501.78,58.9876161,61.81227108, TO_DATE('2024-06-23', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'O', 15.684825,52.9,53.27,829.7272425,835.5306278, TO_DATE('2024-06-23', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'AVGO', 0.000586,1703.76,1658.63,0.99840336,0.97195718, TO_DATE('2024-06-23', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('일본 ETF', '1489.t', 5,2302,2320,11510,11600, TO_DATE('2024-06-23', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('일본 ETF', '1655.t', 220,573.05,628.7,126071,138314, TO_DATE('2024-06-23', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('일본 ETF', '2529.t', 10,1726,1696,17260,16960, TO_DATE('2024-06-23', 'YYYY-MM-DD'), 'root');

2024-06-30 
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'MAIN', 10.846836,42.36,50.49,459.471973,547.6567496, TO_DATE('2024-06-30', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'JEPQ', 43.50602,46.95,55.5,2042.607639,2414.58411, TO_DATE('2024-06-30', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'AAPL', 1.715231,183.67,210.62,315.0364778,361.2619532, TO_DATE('2024-06-30', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'NVDA', 0.318709,109.77,123.54,34.98468693,39.37330986, TO_DATE('2024-06-30', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'QQQM', 0.346617,184.64,197.11,63.99936288,68.32167687, TO_DATE('2024-06-30', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'SCHD', 20.67334,73.3,77.76,1515.355822,1607.558918, TO_DATE('2024-06-30', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'VOO', 0.133117,480.67,500.13,63.98534839,66.57580521, TO_DATE('2024-06-30', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 ETF', 'JEPI', 40.720993,55.16,56.68,2246.169974,2308.065883, TO_DATE('2024-06-30', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'MSFT', 0.022291,448.52,446.95,9.99795932,9.96296245, TO_DATE('2024-06-30', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'AVGO', 0.003707,1616.79,1605.53,5.99344053,5.95169971, TO_DATE('2024-06-30', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('미국 주식', 'O', 15.779361,52.9,52.73,834.7281969,832.0457055, TO_DATE('2024-06-30', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('일본 ETF', '1489.t', 5,2302,2397,11510,11985, TO_DATE('2024-06-30', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('일본 ETF', '1655.t', 220,573.05,638.6,126071,140492, TO_DATE('2024-06-30', 'YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) 
VALUES ('일본 ETF', '2529.t', 10,1726,1734,17260,17340, TO_DATE('2024-06-30', 'YYYY-MM-DD'), 'root');

2024-07-07
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','MAIN',10.924733,42.43,52.2,463.57,570.24,to_date('2024-07-07','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','AAPl',1.733397,184.05,226.11,319.04,391.94,to_date('2024-07-07','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','JEPQ',43.578202,46.97,55.82,2046.7,2432.71,to_date('2024-07-07','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','NVDA',0.351015,111.05,125.69,38.98,44.12,to_date('2024-07-07','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','QQQM',0.36661,185.46,203.98,67.99,74.78,to_date('2024-07-07','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','VOO',0.141063,481.91,509.28,67.98,71.84,to_date('2024-07-07','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','SCHD',20.725044,73.31,76.94,1519.35,1594.65,to_date('2024-07-07','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','AVGO',0.006106,1634.46,1701.6,9.98,10.39,to_date('2024-07-07','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','MSFT',0.031011,451.13,466.93,13.99,14.48,to_date('2024-07-07','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','JEPI',40.792184,55.17,56.32,2250.34,2297.51,to_date('2024-07-07','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','O',15.856132,53.03,53.05,840.79,841.12,to_date('2024-07-07','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('일본 ETF','1489.t',5,2302,2464,11510,12320,to_date('2024-07-07','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('일본 ETF','1655.t',220,573.05,642.9,126072,141438,to_date('2024-07-07','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('일본 ETF','2529.t',10,1726,1774,17260,17740,to_date('2024-07-07','YYYY-MM-DD'), 'root');

2024-07-14
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','VOO',0.150815,483.9,514.07,72.98,77.53,to_date('2024-07-14','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','SCHD',20.7899219,73.32,79.56,1524.35,1654,to_date('2024-07-14','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','QQQM',0.391023,186.66,203.47,72.99,79.56,to_date('2024-07-14','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','JEPQ',43.667549,46.98,55.78,2051.7,2435.96,to_date('2024-07-14','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','JEPI',40.880862,55.17,56.85,2255.34,2324.14,to_date('2024-07-14','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','NVDA',0.389147,113.02,129.1,43.98,50.24,to_date('2024-07-14','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','AAPL',1.755259,184.61,230.31,324.04,404.25,to_date('2024-07-14','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','GOOGL',0.026521,188.15,184.76,4.99,4.9,to_date('2024-07-14','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','AVGO',0.008999,1664.63,1699.08,14.98,15.29,to_date('2024-07-14','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','META',0.009527,523.77,498.58,4.99,4.75,to_date('2024-07-14','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','MAIN',11.02094,42.52,51.43,468.57,566.79,to_date('2024-07-14','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','MSFT',0.04189,453.33,453.09,18.99,18.98,to_date('2024-07-14','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','O',15.949607,53.03,55.69,845.84,888.22,to_date('2024-07-14','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','LMT',0.00868,459.68,463.13,3.99,4.02,to_date('2024-07-14','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('일본 ETF','1489.t',5,2302,2460,11510,12300,to_date('2024-07-14','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('일본 ETF','1655.t',220,573.05,642.2,126072,141284,to_date('2024-07-14','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('일본 ETF','2529.t',10,1726,1780,17260,17800,to_date('2024-07-14','YYYY-MM-DD'), 'root');

2024-07-21
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','VOO',0.160544,485.72,504.04,77.98,80.92,to_date('2024-07-21','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','SCHD',20.85066,73.35,81.03,1529.35,1689.5,to_date('2024-07-21','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','QQQM',0.415912,187.52,195.35,77.99,81.25,to_date('2024-07-21','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','JEPQ',43.758108,47,54.14,2056.7,2368.88,to_date('2024-07-21','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','JEPI',40.968289,55.17,56.71,2260.34,2323.38,to_date('2024-07-21','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','NVDA',0.429871,113.94,117.8,48.98,50.64,to_date('2024-07-21','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','AAPL',1.777093,185.16,224.09,329.04,398.22,to_date('2024-07-21','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','GOOGL',0.053958,185.14,177.55,9.99,9.58,to_date('2024-07-21','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','AVGO',0.120633,165.63,157.25,19.98,18.97,to_date('2024-07-21','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','META',0.019881,502.49,476.33,9.99,9.47,to_date('2024-07-21','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','MAIN',11.118478,42.59,50.1,473.57,557.04,to_date('2024-07-21','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','MSFT',0.053167,451.22,436.57,23.99,23.211,to_date('2024-07-21','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','O',16.0381,53.05,57.55,850.88,922.95,to_date('2024-07-21','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','LMT',0.019283,466.21,474.51,8.99,9.15,to_date('2024-07-21','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('일본 ETF','1489.t',5,2302,2426,11510,12130,to_date('2024-07-21','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('일본 ETF','1655.t',220,573.05,636.7,126072,140074,to_date('2024-07-21','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('일본 ETF','2529.t',10,1726,1767,17260,17670,to_date('2024-07-21','YYYY-MM-DD'), 'root');

2024-07-28
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','VOO',0.170478,486.75,499.83,82.98,85.21,to_date('2024-07-28','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','SCHD',20.912299,73.37,82.39,1534.35,1722.91,to_date('2024-07-28','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','QQQM',0.441669,187.9,190.37,82.99,84.08,to_date('2024-07-28','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','JEPQ',43.850972,47.02,52.91,2061.7,2320.02,to_date('2024-07-28','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','JEPI',41.056266,55.18,56.9,2265.34,2336.17,to_date('2024-07-28','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','NVDA',0.472117,114.34,112.94,53.98,53.32,to_date('2024-07-28','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','AAPL',1.799674,185.61,217.74,334.04,391.86,to_date('2024-07-28','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','GOOGL',0.082471,181.76,166.85,14.99,13.76,to_date('2024-07-28','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','AVGO',0.152605,163.69,151.44,24.98,23.11,to_date('2024-07-28','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','META',0.030416,492.83,465.22,14.99,14.15,to_date('2024-07-28','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','MAIN',11.216999,42.66,50.94,478.57,571.38,to_date('2024-07-28','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','MSFT',0.064673,448.26,424.91,28.99,27.48,to_date('2024-07-28','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','O',15.125046,56.59,61.87,855.88,935.86,to_date('2024-07-28','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','LMT',0.029217,478.83,524.35,13.99,15.32,to_date('2024-07-28','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('일본 ETF','1489.t',5,2302,2318,11510,11590,to_date('2024-07-28','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('일본 ETF','1655.t',220,573.05,601.8,126072,132396,to_date('2024-07-28','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('일본 ETF','2529.t',10,1726,1702,17260,17020,to_date('2024-07-28','YYYY-MM-DD'), 'root');

2024-08-04
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','VOO',0.180469,487.51,489.45,87.98,88.33,to_date('2024-08-04','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','SCHD',20.973245,73.4,80.72,1539.35,1692.94,to_date('2024-08-04','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','QQQM',0.468007,188.01,184.48,87.99,86.34,to_date('2024-08-04','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','JEPQ',43.945941,47.03,51.09,2066.7,2245.15,to_date('2024-08-04','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','JEPI',41.144008,55.18,56.31,2270.34,2316.91,to_date('2024-08-04','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','NVDA',0.517406,113.99,107.17,58.98,55.45,to_date('2024-08-04','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','AAPL',1.822388,186.04,219.64,339.04,400.27,to_date('2024-08-04','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','GOOGL',0.111915,178.62,166.55,19.99,18.64,to_date('2024-08-04','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','AVGO',0.185989,161.19,143.66,29.98,26.72,to_date('2024-08-04','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','META',0.040835,489.53,487.82,19.99,19.92,to_date('2024-08-04','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','MAIN',11.314754,42.74,49.27,483.57,557.49,to_date('2024-08-04','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','MSFT',0.076633,443.54,408.05,33.99,31.27,to_date('2024-08-04','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','O',16.211461,53.11,59.25,860.92,960.49,to_date('2024-08-04','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','LMT',0.038503,493.21,548.01,18.99,21.1,to_date('2024-08-04','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('일본 ETF','1489.t',5,2302,2201,11510,11005,to_date('2024-08-04','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('일본 ETF','1655.t',220,573.05,581.5,126072,127930,to_date('2024-08-04','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('일본 ETF','2529.t',10,1726,1604,17260,16040,to_date('2024-08-04','YYYY-MM-DD'), 'root');

2024-08-11
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','VOO',0.190824,487.2,489.3,92.97,93.37,to_date('2024-08-11','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','SCHD',21.035945,73.41,80.09,1544.35,1684.77,to_date('2024-08-11','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','QQQM',0.495396,187.71,185.14,92.99,91.72,to_date('2024-08-11','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','JEPQ',42.044717,47.04,51.24,1977.64,2154.32,to_date('2024-08-11','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','JEPI',41.233605,55.18,56.35,2275.34,2323.6,to_date('2024-08-11','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','NVDA',0.565689,113.1,104.65,63.98,59.2,to_date('2024-08-11','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','AAPL',1.84601,186.37,216.03,344.04,398.79,to_date('2024-08-11','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','GOOGL',0.142916,174.86,163.52,24.99,23.37,to_date('2024-08-11','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','AVGO',0.220431,158.69,148.12,34.98,32.65,to_date('2024-08-11','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','META',0.050892,491.04,517.37,24.99,26.33,to_date('2024-08-11','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','MAIN',11.417853,42.79,48.52,488.57,554.01,to_date('2024-08-11','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','MSFT',0.089027,437.96,405.61,38.99,36.11,to_date('2024-08-11','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','O',16.295604,53.14,60.56,865.95,986.88,to_date('2024-08-11','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','LMT',0.047625,503.73,550.97,23.99,26.24,to_date('2024-08-11','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('일본 ETF','1489.t',5,2302,2115,11510,10575,to_date('2024-08-11','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('일본 ETF','1655.t',220,573.05,562.9,126072,123838,to_date('2024-08-11','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('일본 ETF','2529.t',10,1726,1570,17260,15700,to_date('2024-08-11','YYYY-MM-DD'), 'root');

2024-08-18
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','VOO',0.200836,487.81,508.92,97.97,102.21,to_date('2024-08-18','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','SCHD',21.097862,73.44,81.88,1549.35,1727.46,to_date('2024-08-18','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','QQQM',0.521584,187.87,195.29,97.99,101.86,to_date('2024-08-18','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','JEPQ',42.139909,47.05,53.4,1982.64,2250.12,to_date('2024-08-18','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 ETF','JEPI',41.32144,55.19,57.55,2280.34,2378.08,to_date('2024-08-18','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','NVDA',0.608341,113.39,124.45,68.98,75.71,to_date('2024-08-18','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','AAPL',1.868533,186.8,225.82,349.04,421.96,to_date('2024-08-18','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','GOOGL',0.173772,172.58,162.8,29.99,28.29,to_date('2024-08-18','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','AVGO',0.252303,158.46,165.55,39.98,41.77,to_date('2024-08-18','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','META',0.060374,496.74,526.88,29.99,31.81,to_date('2024-08-18','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','MAIN',11.520164,42.84,49.23,493.57,567.15,to_date('2024-08-18','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','MSFT',0.101091,435.05,418.04,43.98,42.26,to_date('2024-08-18','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','O',16.378836,53.18,60.01,870.95,982.91,to_date('2024-08-18','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('미국 주식','LMT',0.056582,512.35,559.54,28.99,31.66,to_date('2024-08-18','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('일본 ETF','1489.t',5,2302,2281,11510,11405,to_date('2024-08-18','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('일본 ETF','1655.t',220,573.05,595.8,126072,131076,to_date('2024-08-18','YYYY-MM-DD'), 'root');
INSERT INTO test_stock_info (country_type, ticker, amount, purchase_price, now_price, purchase_total, now_total, hiredate, user_id) VALUES ('일본 ETF','2529.t',10,1726,1659,17260,16590,to_date('2024-08-18','YYYY-MM-DD'), 'root');
*/