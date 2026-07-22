Scenario 1: Process Monthly Interest
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Monthly interest processed successfully.');
END;
/
BEGIN
    ProcessMonthlyInterest;
END;
/
Scenario 2: Update Employee Bonus
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_Department IN VARCHAR2,
    p_BonusPercent IN NUMBER
)
IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_BonusPercent / 100)
    WHERE Department = p_Department;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Employee bonus updated successfully.');
END;
/
BEGIN
    UpdateEmployeeBonus('IT', 10);
END;
/
Scenario 3: Transfer Funds
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_FromAccount IN NUMBER,
    p_ToAccount IN NUMBER,
    p_Amount IN NUMBER
)
IS
    v_Balance NUMBER;
BEGIN
    SELECT Balance
    INTO v_Balance
    FROM Accounts
    WHERE AccountID = p_FromAccount;

    IF v_Balance >= p_Amount THEN

        UPDATE Accounts
        SET Balance = Balance - p_Amount
        WHERE AccountID = p_FromAccount;

        UPDATE Accounts
        SET Balance = Balance + p_Amount
        WHERE AccountID = p_ToAccount;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Fund transfer successful.');

    ELSE

        DBMS_OUTPUT.PUT_LINE('Insufficient balance.');

    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Account not found.');

    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/
BEGIN
    TransferFunds(101, 102, 5000);
END;
/