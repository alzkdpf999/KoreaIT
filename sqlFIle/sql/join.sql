--CROSS JOIN �ϳ��� ����� 27�� ��� �μ��� �Ҽӵ� �� �ִ� (107*27=2889)
SELECT employee_id,last_name,department_name
FROM employees,departments;

-- ���� �� �÷����� ��ȣ���� �ذ��ϱ� ���� ���̺���̳� ��Ī ����� ����

SELECT e.employee_id,e.last_name,d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id;
--�̷��� ���°���  ������
SELECT e.employee_id,e.last_name,d.department_name
FROM employees e CROSS JOIN departments d;

SELECT e.employee_id,e.last_name,d.department_name
FROM employees e, departments d;

