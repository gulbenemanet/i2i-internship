# SQL Sorguları
1. 
- Write  followig SQL queries:
- Add a colum to employees table named MAX_SALARY.
- Update MAX_SALARY with maximum salary amount with subquery.
- Delete employee who have minimum salary using subquery.


![sorgu13.1](./images/sql3_1_alter.png)
 
![sorgu3.1](./images/sql3_1_update.png)

![sorgu3.1](./images/sql3_1_delete.png)

![sorgu3.1](./images/sql3_1_output.png)

2. 
- Define index (named DPR_NAME_IDX) on DEPARTMENT_NAME column of DEPARTMENTS table.
- Define constraint (named CNSTR_SALARY) on employee salary. (Salary must be between 1000$ and 100.000$)
- Drop defined index.
- Enable, disable, drop defined constraint.


![sorgu3.2](./images/sql3_2_constraint.png)

![sorgu3.2](./images/sql3_2_createindex.png)

![sorgu3.2](./images/sql3_2_others.png)

3. Create a table from EMPLOYEES with distinct department_id column. Add department_name to that table. With DEPARTMENTS table, update department_name for included department_ids and insert department_id and department_name values for not included rows. Use MERGE keyword.

![sorgu3.3](./images/sql3_3.png)


4. 
- Firstly select first_name, last_name, job_id, department_id from employees table whoes job_id starts with ‘S’.
- Additionally select job_title and min-max  salary amount.
- Add  department_name to that query.
- Lastly concat first_name and last_name with space as full_name alias and list with other selected columns.


![sorgu3.4](./images/sql3_4_1.png)

![sorgu3.4](./images/sql3_4_2.png)

![sorgu3.4](./images/sql3_4_3.png)

![sorgu3.4](./images/sql3_4_4.png)

5.  Search for COMMIT and ROLLBACK keywords and explain them.

![sorgu3.5](./images/sql3_5.png)