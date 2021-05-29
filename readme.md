###### spring boot application for wallet transaction history

**Schema:**

**Wallet table:**  master wallet table with wallet details and customer dertails

**transaction table:** table keeps transaction in double acount entry manner, for each transaction 1 debit and 1 credit

**A/c statement table:** keeps daily/weekly balance as suited. The running balance is calculated by the latest balance in the statement table and any transactions after this date

**Transaction Type:** A static table to keep hold of transaction types. eg- debit=0, credit=1



