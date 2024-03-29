package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.CurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportForAccountsDept implements Report {

    private final Store store;

    private final DateTimeParser<Calendar> dateTimeParser;

    private final CurrencyConverter inMemoryCurrencyConverter;

    private final Currency sourceCurrency; /* Initial curr */

    private final Currency targetCurrency; /* Curr to convert into */

    public ReportForAccountsDept(Store store,
                                 DateTimeParser<Calendar> dateTimeParser,
                                 CurrencyConverter inMemoryCurrencyConverter,
                                 Currency sourceCurrency,
                                 Currency targetCurrency) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.inMemoryCurrencyConverter = inMemoryCurrencyConverter;
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary; Converted Salary")
                .append(System.lineSeparator());

        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(" ")
                    .append(dateTimeParser.parse(employee.getHired())).append(" ")
                    .append(dateTimeParser.parse(employee.getFired())).append(" ")
                    .append(employee.getSalary()).append(" ")
                    .append(inMemoryCurrencyConverter.convert(sourceCurrency, employee.getSalary(), targetCurrency))
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}



