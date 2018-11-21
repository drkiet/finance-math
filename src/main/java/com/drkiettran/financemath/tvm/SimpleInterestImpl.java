package com.drkiettran.financemath.tvm;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class SimpleInterestImpl implements SimpleInterestAPI {
	private static MathContext mc = new MathContext(10, RoundingMode.HALF_UP);

	@Override
	public BigDecimal getTotalInterest(BigDecimal cv, BigDecimal r, BigDecimal n) {
		return cv.multiply(r).multiply(n);
	}

	@Override
	public BigDecimal getRateOfInterest(BigDecimal cv, BigDecimal i, BigDecimal n) {
		return i.divide((cv.multiply(n)));
	}

	@Override
	public BigDecimal getTermOfMaturity(BigDecimal cv, BigDecimal i, BigDecimal r) {
		return i.divide(cv.multiply(r), mc);
	}

	@Override
	public BigDecimal getCurrentValue(BigDecimal i, BigDecimal r, BigDecimal n) {
		return i.divide(r.multiply(n), mc);
	}

	@Override
	public BigDecimal getFutureValue(BigDecimal cv, BigDecimal r, BigDecimal n) {
		return cv.multiply(new BigDecimal(1.00).add(r.multiply(n)));
	}

	@Override
	public BigDecimal getRateGivenFvCv(BigDecimal cv, BigDecimal fv, BigDecimal n) {
		return fv.divide(cv, mc).subtract(new BigDecimal(1)).divide(n, mc);
	}

	@Override
	public BigDecimal getTermGivenFvCv(BigDecimal cv, BigDecimal fv, BigDecimal r) {
		return fv.divide(cv, mc).subtract(new BigDecimal(1)).divide(r, mc);
	}

	@Override
	/**
	 * Simple discount: obtain cv from fv, interest rate & time.
	 */
	public BigDecimal getCurrentValueMonthly(BigDecimal fv, BigDecimal r, BigDecimal n) {
		return fv.divide(new BigDecimal(1).add(r.multiply(n.divide(new BigDecimal(12), mc))), mc);
	}

	@Override
	public BigDecimal getFutureValueMonthly(BigDecimal cv, BigDecimal r, BigDecimal n) {
		return cv.multiply(new BigDecimal(1).add(r.multiply(n.divide(new BigDecimal(12), mc))));
	}

	@Override
	/**
	 * Ordinary interest: daysPerYear = 360. Exact interest: daysPerYear = 365.
	 */
	public BigDecimal getInterest(BigDecimal cv, BigDecimal r, BigDecimal n, BigDecimal daysPerYear) {
		return cv.multiply(r.multiply(n.divide(daysPerYear, mc)));
	}

	@Override
	public BigDecimal getIoFromIe(BigDecimal ie) {
		return ie.multiply(new BigDecimal(1).add(new BigDecimal(1).divide(new BigDecimal(72), mc)));
	}

	@Override
	/**
	 * Error on page 74 of book - 1 - 1/73 as opposed to 1 + 1/73.
	 */
	public BigDecimal getIeFromIo(BigDecimal io) {
		return io.multiply(new BigDecimal(1).subtract(new BigDecimal(1).divide(new BigDecimal(73), mc)));
	}

	@Override
	public BigDecimal getCvFromFv(BigDecimal fv, BigDecimal r, BigDecimal n) {
		return fv.divide(new BigDecimal(1).add(r.multiply(n)), mc);
	}

}
