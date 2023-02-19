DROP TABLE IF EXISTS report;
DROP TABLE IF EXISTS paycheck;
DROP TABLE IF EXISTS payment_rule;
DROP TABLE IF EXISTS timecard;
DROP TABLE IF EXISTS employee;


CREATE TABLE IF NOT EXISTS employee (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(64),
    last_name VARCHAR(64),
    email VARCHAR(254),
    phone_number VARCHAR(16),
    hire_date DATE,
    job_title VARCHAR(64),
    salary DECIMAL(10, 2)
);

CREATE TABLE IF NOT EXISTS timecard (
    id SERIAL PRIMARY KEY,
    employee_id INTEGER NOT NULL,
    work_date DATE NOT NULL,
    hours_worked NUMERIC(5,2) NOT NULL,
    job_code VARCHAR(16) NOT NULL,
    approved BOOLEAN NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employee (id)
);

CREATE TABLE IF NOT EXISTS payment_rule (
    id SERIAL PRIMARY KEY,
    name VARCHAR(64) NOT NULL,
    description VARCHAR(255) NOT NULL,
    calculation_type VARCHAR(5) NOT NULL,
    amount DECIMAL(10, 2)
);

CREATE TABLE IF NOT EXISTS paycheck (
    id SERIAL PRIMARY KEY,
    employee_id INTEGER NOT NULL, -- one employee has many paychecks
    payment_rule_id INTEGER NOT NULL, -- one payment rule has many paychecks
    pay_date DATE NOT NULL,
    pay_period_start_date DATE NOT NULL,
    pay_period_end_date DATE NOT NULL,
    gross_pay DECIMAL(10, 2),
    net_pay DECIMAL(10, 2),
    deductions VARCHAR(255) NOT NULL, -- The payroll deductions:
    -- Income tax, Social security tax, 401(k) contributions,
    -- Wage garnishments(Bonuses, Pensions and retirement plan payments),
    -- Child support payments.
    FOREIGN KEY (employee_id) REFERENCES employee (id),
    FOREIGN KEY (payment_rule_id) REFERENCES payment_rule (id)
);

CREATE TABLE IF NOT EXISTS report (
    id SERIAL PRIMARY KEY,
    paycheck_id INTEGER NOT NULL, -- one paycheck has one report
    name VARCHAR(128) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    report_data VARCHAR(1024) NOT NULL,
    FOREIGN KEY (paycheck_id) REFERENCES paycheck (id)
);