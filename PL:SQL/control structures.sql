Scenario 1: Apply 1% Discount to Loan Interest Rate for Customers Above 60 Years
BEGIN
    FOR rec IN (
        SELECT l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE c.Age > 60
    )
    LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE LoanID = rec.LoanID;
    END LOOP;

    COMMIT;
END;
/

Scenario 2: Promote Customers to VIP
BEGIN
    FOR rec IN (
        SELECT CustomerID
        FROM Customers
        WHERE Balance > 10000
    )
    LOOP
        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = rec.CustomerID;
    END LOOP;

    COMMIT;
END;
/

Scenario 3: Send Reminder for Loans Due Within 30 Days
BEGIN
    FOR rec IN (
        SELECT c.CustomerName,
               l.LoanID,
               l.DueDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Dear ' || rec.CustomerName ||
            ', your Loan ID ' || rec.LoanID ||
            ' is due on ' || TO_CHAR(rec.DueDate, 'DD-MON-YYYY')
        );
    END LOOP;
END;
/
