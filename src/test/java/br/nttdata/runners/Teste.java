package br.nttdata.runners;

import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.MonetaryRounding;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;
import javax.money.format.MonetaryAmountFormat;

import org.javamoney.moneta.ExchangeRateType;
import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.internal.DefaultMonetaryCurrenciesSingletonSpi;
import org.javamoney.moneta.spi.MonetaryConfig;
import org.joda.money.Money;
import org.junit.Test;

public class Teste {

	public static void main(String[] args)
    {
        //Primeiro vamos criar as moedas e os valores
        // moedas
		
		String preco = "$ 449.99";
		String[] parts = preco.split(" ");
		 double valorUnitario = Double.parseDouble(parts[1]);
		 System.out.println(valorUnitario);
    }
	 
	       
}

	
