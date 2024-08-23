SELECT TO_CHAR(t.hiredate, 'YYYY-MM-DD') AS hiredate,
       SUM(CASE
           WHEN t.country_type LIKE '미국%' THEN t.purchase_total * e.us_exchange
           WHEN t.country_type LIKE '일본%' THEN (t.purchase_total * e.jp_exchange) / 100
           ELSE 0 END) AS purchase_total,
       SUM(CASE
           WHEN t.country_type LIKE '미국%' THEN t.now_total * e.us_exchange
           WHEN t.country_type LIKE '일본%' THEN (t.now_total * e.jp_exchange) / 100
           ELSE 0 END) AS now_total
FROM test_stock_info t
JOIN exchange_rate e ON t.hiredate = e.hiredate
GROUP BY TO_CHAR(t.hiredate, 'YYYY-MM-DD')
ORDER BY TO_CHAR(t.hiredate, 'YYYY-MM-DD') ASC;