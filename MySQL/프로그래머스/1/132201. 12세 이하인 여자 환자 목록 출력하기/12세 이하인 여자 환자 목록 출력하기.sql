-- 코드를 입력하세요
SELECT p.PT_NAME, p.PT_NO, p.GEND_CD, p.AGE, coalesce(p.TLNO, 'NONE') as TLNO
from PATIENT p
where p.AGE <= 12
    and GEND_CD = 'W'
order by p.AGE desc, p.PT_NAME asc;