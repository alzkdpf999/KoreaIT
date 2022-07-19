--SQL DQL test
SELECT * 
FROM employees;


-- subquery use so table copy
CREATE TABLE emp AS 
SELECT *
FROM employees;

SELECT *
FROM emp;

--UNION test 107count

SELECT *
FROM employees
UNION
SELECT *
FROM emp;

--UNION ALL test 214 count

SELECT *
FROM employees
UNION ALL
SELECT *
FROM emp;

--MINUS test 0count

SELECT *
FROM employees
MINUS
SELECT *
FROM emp;

--INTERSECT test 107count 

SELECT *
FROM employees
INTERSECT
SELECT *
FROM emp;

--oracle function(단일행 함수)
--문자 처리 함수 
SELECT CONCAT('Oracle', 'Java Developer')
FROM dual;

desc dual;

SELECT CONCAT(first_name,last_name) "이름"
FROM employees;

SELECT INITCAP('kim ki jung')
FROM dual;

SELECT first_name, last_name
FROM employees
--WHERE first_name = 'james';
WHERE LOWER(first_name) = 'james';

SELECT UPPER('bangry')
FROM dual;

SELECT LPAD('DataBase', 10, '*')
FROM dual;

SELECT RPAD('DataBase', 10, '*')
FROM dual;

SELECT SUBSTR('Java Developer', 6, 9)
FROM dual;

SELECT SUBSTR('서울시가산동', 4)
FROM dual;

SELECT first_name, LENGTH(first_name)
FROM employees;

SELECT REPLACE('기정바보', '바보', '최고')
FROM dual;

SELECT REPLACE('서울 시', ' ', '')
FROM dual;

SELECT INSTR('DataBase', 'B')
--SELECT INSTR('DataBase', 'a', 1, 2)
FROM dual;

--SELECT LTRIM(' JavaDeveloper')
--SELECT LTRIM(' JavaDeveloper', ' ')
SELECT LTRIM('JavaDeveloper', 'Java')
FROM dual;

--SELECT RTRIM('JavaDeveloper ')
--SELECT RTRIM('JavaDeveloper ', ' ')
SELECT RTRIM('JavaDeveloper', 'Developer')
FROM dual;

SELECT TRIM(' Java Developer ')
FROM dual;

SELECT ROUND(45.923), ROUND(45.923, 0), ROUND(45.923, 2), ROUND(45.923, -1)
FROM dual;

SELECT TRUNC(45.923), TRUNC(45.923, 0), TRUNC(45.923, 2), TRUNC(45.923, -1)
FROM dual;

SELECT CEIL(123.123)
FROM dual;

SELECT FLOOR(123.123)
FROM dual;

SELECT ABS(-500)
FROM dual;

SELECT POWER(5, 2), SQRT(4), SIN(30), COS(30), TAN(30)
FROM dual;

-- 최소값 반환
SELECT LEAST(10, 20, 30, 40)
FROM dual;

-- 최대값 반환
SELECT GREATEST(10, 20, 30, 40)
FROM dual;

SELECT SYSDATE
FROM dual;

SELECT SYSTIMESTAMP
FROM dual;

-- DATE 타입에 연산 가능
SELECT SYSDATE - 1 "어제" , SYSDATE "오늘", SYSDATE + 1 "내일"
FROM dual;
-- 사원별 근무 일수 검색
SELECT first_name, hire_date, SYSDATE, CEIL(SYSDATE - hire_date) "근무일수"
FROM employees;
-- 사원별 근무 개월수 검색
SELECT first_name, TRUNC(MONTHS_BETWEEN(SYSDATE, hire_date)) "근무개월수"
FROM employees;
-- 특정개월수를 더한 날짜 반환
SELECT SYSDATE, ADD_MONTHS(SYSDATE, 2) "오늘부터 2개월 후"
FROM dual;
-- 이번주 토요일 날짜
SELECT SYSDATE "오늘", NEXT_DAY(SYSDATE, 7) "이번주 토요일"
FROM dual;
-- 이번달 마지막 날짜
SELECT SYSDATE, LAST_DAY(SYSDATE) "이번달 마지막날"
FROM dual;
