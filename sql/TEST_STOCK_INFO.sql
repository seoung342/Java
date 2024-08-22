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
*/

