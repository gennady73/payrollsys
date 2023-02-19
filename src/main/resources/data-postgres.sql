-- Populate employee table
INSERT INTO employee (first_name, last_name, email, phone_number, hire_date, job_title, salary)
VALUES ('John', 'Doe', 'john.doe@example.com', '555-1234', '2022-01-01', 'Software Developer', 80000),
       ('Jane', 'Doe', 'jane.doe@example.com', '555-5678', '2022-01-01', 'Project Manager', 100000),
       ('Bob', 'Smith', 'bob.smith@example.com', '555-4321', '2022-01-01', 'Sales Associate', 60000),
       ('Alice', 'Jones', 'alice.jones@example.com', '555-8765', '2022-01-01', 'Marketing Specialist', 75000),
       ('Mike', 'Brown', 'mike.brown@example.com', '555-1111', '2022-01-01', 'IT Support', 50000);

-- Populate payment_rule table
INSERT INTO payment_rule (name, description, calculation_type, amount)
VALUES ('Monthly Salary', 'Fixed monthly salary', 'FIX', 80000),
       ('Hourly Rate', 'Pay based on hours worked', 'HOUR', 20),
       ('Commission', 'Pay based on sales commission', 'COM', 0.05);

-- Populate timecard table
INSERT INTO timecard (employee_id, work_date, hours_worked, job_code, approved)
VALUES (1, '2022-02-01', 8, 'DEV', true),
       (1, '2022-02-02', 8, 'DEV', true),
       (1, '2022-02-03', 8, 'DEV', true),
       (1, '2022-02-04', 8, 'DEV', true),
       (1, '2022-02-07', 8, 'DEV', true),
       (2, '2022-02-01', 8, 'PM', true),
       (2, '2022-02-02', 8, 'PM', true),
       (2, '2022-02-03', 8, 'PM', true),
       (2, '2022-02-04', 8, 'PM', true),
       (2, '2022-02-07', 8, 'PM', true),
       (3, '2022-02-01', 4, 'SALES', true),
       (3, '2022-02-02', 4, 'SALES', true),
       (3, '2022-02-03', 5, 'SALES', true),
       (3, '2022-02-04', 5, 'SALES', true),
       (3, '2022-02-07', 3, 'SALES', true),
       (4, '2022-02-01', 4, 'MKT', true),
       (4, '2022-02-02', 4, 'MKT', true),
       (4, '2022-02-03', 4, 'MKT', true),
       (4, '2022-02-04', 2, 'MKT', true),
       (4, '2022-02-07', 2, 'MKT', true),
       (5, '2022-02-01', 8, 'IT', true),
       (5, '2022-02-02', 8, 'IT', true),
       (5, '2022-02-03', 8, 'IT', true),
       (5, '2022-02-04', 8, 'IT', true),
       (5, '2022-02-07', 8, 'IT', true);
