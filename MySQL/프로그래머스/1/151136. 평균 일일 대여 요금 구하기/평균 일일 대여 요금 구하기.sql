-- 코드를 입력하세요
SELECT round(avg(crcc.DAILY_FEE)) as AVERAGE_FEE
from CAR_RENTAL_COMPANY_CAR crcc
where crcc.CAR_TYPE like '%SUV%'
group by crcc.CAR_TYPE;