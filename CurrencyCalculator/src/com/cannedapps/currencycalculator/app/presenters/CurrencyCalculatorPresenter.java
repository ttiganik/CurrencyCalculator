package com.cannedapps.currencycalculator.app.presenters;

import java.util.Iterator;
import java.util.List;

import com.cannedapps.currencycalculator.app.models.Currency;
import com.cannedapps.currencycalculator.app.views.interfaces.ICurrencyCalculatorActivity;

public class CurrencyCalculatorPresenter extends AbstractCannedappsPresenter<ICurrencyCalculatorActivity> {

  public void convert(String value, String fromCurrency, String toCurrency) {
       
    String convertedValue = "";
    try {
      double dValue = Double.valueOf(value);
      Currency from = Currency.getCurrency(fromCurrency);
      Currency to = Currency.getCurrency(toCurrency);

      double newValue = Currency.convert(dValue, from, to);
      convertedValue = String.format("%.2f", newValue);
    } catch (NumberFormatException e) {
      // TODO: handle exception
    }

    getView().showConvertValue(convertedValue);
  }

  public String[] getCurrencies() {
    List<Currency> all = Currency.getAll();
    String[] currencies = new String[all.size()];
    int i = 0;
    for (Iterator<Currency> iterator = all.iterator(); iterator.hasNext();) {
      Currency currency = (Currency) iterator.next();
      currencies[i] = currency.getName();
      i++;
    }
    return currencies;
  }

}
