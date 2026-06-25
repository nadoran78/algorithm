-- 코드를 입력하세요
SELECT b.BOOK_ID, b.PUBLISHED_DATE
from BOOK b
where b.CATEGORY = '인문'
    and b.PUBLISHED_DATE >= '2021-01-01'
    and b.PUBLISHED_DATE < '2022-01-01';