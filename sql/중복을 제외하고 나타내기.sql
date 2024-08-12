-- 중복을 제외하고 나타내기
delete from dupes where id not in (select min(id) from dupes group by name)