--CROSS JOIN 하나의 사원은 27개 모든 부서에 소속될 수 있다 (107*27=2889)
SELECT employee_id,last_name,department_name
FROM employees,departments;

-- 조인 시 컬럼명의 모호성을 해결하기 위해 테이블명이나 별칭 사용을 권장

SELECT e.employee_id,e.last_name,d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id;
--이렇게 쓰는것을  권장함
SELECT e.employee_id,e.last_name,d.department_name
FROM employees e CROSS JOIN departments d;

SELECT e.employee_id,e.last_name,d.department_name
FROM employees e, departments d;

