# FinanceUA
Project is written with purpose of getting familiar with such technologies as WebDriver, JBehave and Serenity

Bug report:

Bug title: 
When counting summary values, values from row "Идея Банк", are not taken into account, despite not being marked as "expired". 

ID: 1

Severity : Major

Status: New

Author: Oleg Kuts

Environment: Linux Xubuntu 14.04 64bit, FireFox 44.0.

Description:

Steps to Reproduce:

1) Open finance.i.ua web site

2) Switch to "eur" tab

3) Count Average purchase and sale rates from the table, which contains banks info

Expected Result:

Counted Average values, sholud be equal to Average values from Summary table. Also Maximum, Minumum and Optimal values should be equal.

Actual Result:

Counted Average values, are different from Average values from Summary table. As a result, it can also affect Maximum, Minumum and Optimal values.





Bug title: 
When first time switching between tabs, Maximum and Optimal in summary table should be written in russian language, but instead is written in ukrainian.

ID: 2

Severity : Trivial

Status: New

Author: Oleg Kuts

Environment: Linux Xubuntu 14.04 64bit, FireFox 44.0.

Description:

Steps to Reproduce:

1) Open finance.i.ua web site

2) Switch to "eur" or "rub" tab

Expected Result:

Maximum and Optimal in summary table should be written in russian language

Actual Result:

Maximum and Optimal in summary table is written in ukrainian language
