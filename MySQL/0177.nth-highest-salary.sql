CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
DECLARE X INT;
SET X=N-1;
    RETURN(
        SELECT DISTINCT Salary
        FROM Employee
        ORDER BY Salary DESC
        LIMIT 1 OFFSET X
    );
END