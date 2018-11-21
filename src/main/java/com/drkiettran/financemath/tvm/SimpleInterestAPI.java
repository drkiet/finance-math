package com.drkiettran.financemath.tvm;

import java.math.BigDecimal;

public interface SimpleInterestAPI {

	BigDecimal getTotalInterest(BigDecimal cv, BigDecimal r, BigDecimal n);

	BigDecimal getRateOfInterest(BigDecimal cv, BigDecimal i, BigDecimal n);

	BigDecimal getTermOfMaturity(BigDecimal cv, BigDecimal i, BigDecimal r);

	BigDecimal getCurrentValue(BigDecimal i, BigDecimal r, BigDecimal n);

	BigDecimal getFutureValue(BigDecimal cv, BigDecimal r, BigDecimal n);

	BigDecimal getRateGivenFvCv(BigDecimal cv, BigDecimal fv, BigDecimal n);

	BigDecimal getTermGivenFvCv(BigDecimal cv, BigDecimal fv, BigDecimal r);

	BigDecimal getCurrentValueMonthly(BigDecimal fv, BigDecimal r, BigDecimal n);

	BigDecimal getFutureValueMonthly(BigDecimal cv, BigDecimal r, BigDecimal n);

	BigDecimal getInterest(BigDecimal cv, BigDecimal r, BigDecimal n, BigDecimal i);

	BigDecimal getIoFromIe(BigDecimal Ie);

	BigDecimal getIeFromIo(BigDecimal interest);

	BigDecimal getCvFromFv(BigDecimal fv, BigDecimal r, BigDecimal n);

}
