package com.drkiettran.financemath;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.BigDecimalCloseTo.closeTo;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.jfree.date.MonthConstants;
import org.jfree.date.SerialDate;
import org.jfree.date.SerialDateUtilities;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.drkiettran.financemath.tvm.SimpleInterestAPI;
import com.drkiettran.financemath.tvm.SimpleInterestImpl;

public class SimpleInterestTest {
	private static final Logger logger = LoggerFactory.getLogger(SimpleInterestTest.class);

	@Test
	public void shouldComputeTotalInterest() {
		SimpleInterestAPI si = new SimpleInterestImpl();
		BigDecimal cv = new BigDecimal(2000.0);
		BigDecimal r = new BigDecimal(0.035);
		BigDecimal n = new BigDecimal(5);
		BigDecimal expectedInterest = new BigDecimal(350.00);
		BigDecimal actualInterest = si.getTotalInterest(cv, r, n);
		logger.info("cv {},\n r {},\n n {},\n expected {},\n actual {}", cv, r, n,
				expectedInterest.setScale(2, BigDecimal.ROUND_HALF_UP),
				actualInterest.setScale(2, BigDecimal.ROUND_HALF_UP));
		assertThat(actualInterest, closeTo(expectedInterest, new BigDecimal(0.1)));

	}

	@Test
	public void shouldComputeRateOfInterest() {
		SimpleInterestAPI si = new SimpleInterestImpl();
		BigDecimal cv = new BigDecimal(1500.0);
		BigDecimal i = new BigDecimal(236.25);
		BigDecimal n = new BigDecimal(3);
		BigDecimal expectedRate = new BigDecimal(0.0525);
		BigDecimal actualRate = si.getRateOfInterest(cv, i, n);
		logger.info("cv {},\n i {},\n n {},\n expected {},\n actual {}", cv, i, n,
				expectedRate.setScale(4, BigDecimal.ROUND_HALF_UP), actualRate.setScale(4, BigDecimal.ROUND_HALF_UP));
		assertThat(actualRate, closeTo(expectedRate, new BigDecimal(0.0001)));

	}

	@Test
	public void shouldComputeTermOfMaturity() {
		SimpleInterestAPI si = new SimpleInterestImpl();
		BigDecimal cv = new BigDecimal(3000.0).setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal i = new BigDecimal(825.0);
		BigDecimal r = new BigDecimal(0.055);
		BigDecimal expectedTerm = new BigDecimal(5.0);
		BigDecimal actualTerm = si.getTermOfMaturity(cv, i, r);
		logger.info("cv {},\n i {},\n n {},\n expected {},\n actual {}", cv, i, r,
				expectedTerm.setScale(1, BigDecimal.ROUND_HALF_UP), actualTerm.setScale(1, BigDecimal.ROUND_HALF_UP));
		assertThat(actualTerm, closeTo(expectedTerm, new BigDecimal(1)));

	}

	@Test
	public void shouldComputeCurrentValue() {
		SimpleInterestAPI si = new SimpleInterestImpl();

		BigDecimal i = new BigDecimal(1000.0);
		BigDecimal r = new BigDecimal(0.06);
		BigDecimal n = new BigDecimal(4);
		BigDecimal expectedCurrentValue = new BigDecimal(4167.00);
		BigDecimal actualCurrentValue = si.getCurrentValue(i, r, n);
		logger.info("\n i {},\n r {},\n n {},\n expected {},\n actual {}", i, r, n,
				expectedCurrentValue.setScale(1, BigDecimal.ROUND_HALF_UP),
				actualCurrentValue.setScale(1, BigDecimal.ROUND_HALF_UP));
		assertThat(actualCurrentValue, closeTo(expectedCurrentValue, new BigDecimal(1.0)));
	}

	@Test
	public void shouldComputeFutureValue() {
		SimpleInterestAPI si = new SimpleInterestImpl();
		BigDecimal cv = new BigDecimal(900.00);
		BigDecimal r = new BigDecimal(0.07);
		BigDecimal n = new BigDecimal(1.33);
		BigDecimal expectedFutureValue = new BigDecimal(983.79);
		BigDecimal actualFutureValue = si.getFutureValue(cv, r, n);
		logger.info("\n cv {},\n r {},\n n {},\n expected {},\n actual {}", cv, r, n,
				expectedFutureValue.setScale(2, BigDecimal.ROUND_HALF_UP),
				actualFutureValue.setScale(2, BigDecimal.ROUND_HALF_UP));
		assertThat(actualFutureValue, closeTo(expectedFutureValue, new BigDecimal(1.0)));
	}

	@Test
	public void shouldComputeRateGivenFvCv() {
		SimpleInterestAPI si = new SimpleInterestImpl();
		BigDecimal cv = new BigDecimal(6218.00);
		BigDecimal fv = new BigDecimal(7500);
		BigDecimal n = new BigDecimal(2.5);
		BigDecimal expectedRate = new BigDecimal(0.0825);
		BigDecimal actualRate = si.getRateGivenFvCv(cv, fv, n);
		logger.info("\n cv {},\n fv {},\n n {},\n expected {},\n actual {}", cv, fv, n,
				expectedRate.setScale(4, BigDecimal.ROUND_HALF_UP), actualRate.setScale(4, BigDecimal.ROUND_HALF_UP));
		assertThat(actualRate, closeTo(expectedRate, new BigDecimal(0.0001)));
	}

	@Test
	public void shouldComputeTermGivenFvCv() {
		SimpleInterestAPI si = new SimpleInterestImpl();
		BigDecimal cv = new BigDecimal(6218.00);
		BigDecimal fv = new BigDecimal(9000.00);
		BigDecimal r = new BigDecimal(0.08);
		BigDecimal expectedTerm = new BigDecimal(5.59);
		BigDecimal actualTerm = si.getTermGivenFvCv(cv, fv, r);
		logger.info("\n cv {},\n fv {},\n r {},\n expected {},\n actual {}", cv, fv, r,
				expectedTerm.setScale(3, BigDecimal.ROUND_HALF_UP), actualTerm.setScale(3, BigDecimal.ROUND_HALF_UP));
		assertThat(actualTerm, closeTo(expectedTerm, new BigDecimal(0.01)));
	}

	@Test
	public void shouldComputeCurrentValueMonthly() {
		SimpleInterestAPI si = new SimpleInterestImpl();
		BigDecimal fv = new BigDecimal(5500.00);
		BigDecimal r = new BigDecimal(0.065);
		BigDecimal n = new BigDecimal(8);
		BigDecimal expectedCurrentValue = new BigDecimal(5271.56);
		BigDecimal actualCurrentValue = si.getCurrentValueMonthly(fv, r, n);
		logger.info("\n fv {},\n r {},\n n {},\n expected {},\n actual {}", fv, r, n,
				expectedCurrentValue.setScale(2, BigDecimal.ROUND_HALF_UP),
				actualCurrentValue.setScale(2, BigDecimal.ROUND_HALF_UP));
		assertThat(actualCurrentValue, closeTo(expectedCurrentValue, new BigDecimal(0.01)));
	}

	@Test
	public void shouldComputeFutureValueMonthly() {
		SimpleInterestAPI si = new SimpleInterestImpl();
		BigDecimal cv = new BigDecimal(5271.56);
		BigDecimal r = new BigDecimal(0.065);
		BigDecimal n = new BigDecimal(8);
		BigDecimal expectedFutureValue = new BigDecimal(5500.00);
		BigDecimal actualFutureValue = si.getFutureValueMonthly(cv, r, n);
		logger.info("\n cv {},\n r {},\n n {},\n expected {},\n actual {}", cv, r, n,
				expectedFutureValue.setScale(2, BigDecimal.ROUND_HALF_UP),
				actualFutureValue.setScale(2, BigDecimal.ROUND_HALF_UP));
		assertThat(actualFutureValue, closeTo(expectedFutureValue, new BigDecimal(0.01)));
	}

	@Test
	public void shouldComputeOrdinaryAndExactInterest() {
		SimpleInterestAPI si = new SimpleInterestImpl();
		BigDecimal cv = new BigDecimal(8500.0);
		BigDecimal r = new BigDecimal(0.0725);
		BigDecimal n = new BigDecimal(90);
		BigDecimal expectedOrdinaryInterest = new BigDecimal(154.06);

		// Ordinary Interest (Io)
		BigDecimal actualOrdinaryInterest = si.getInterest(cv, r, n, new BigDecimal(360));
		logger.info("\n cv {},\n r {},\n n {},\n expected {},\n actual {}", cv, r, n,
				expectedOrdinaryInterest.setScale(2, BigDecimal.ROUND_HALF_UP),
				actualOrdinaryInterest.setScale(2, BigDecimal.ROUND_HALF_UP));
		assertThat(actualOrdinaryInterest, closeTo(expectedOrdinaryInterest, new BigDecimal(0.01)));

		// Exact Interest (Ie)
		expectedOrdinaryInterest = new BigDecimal(151.95);
		actualOrdinaryInterest = si.getInterest(cv, r, n, new BigDecimal(365));
		logger.info("\n cv {},\n r {},\n n {},\n expected {},\n actual {}", cv, r, n,
				expectedOrdinaryInterest.setScale(2, BigDecimal.ROUND_HALF_UP),
				actualOrdinaryInterest.setScale(2, BigDecimal.ROUND_HALF_UP));
		assertThat(actualOrdinaryInterest, closeTo(expectedOrdinaryInterest, new BigDecimal(0.01)));
	}

	@Test
	public void shouldComputeOrdinaryAndExactInterestIntermOfEachOther() {
		SimpleInterestAPI si = new SimpleInterestImpl();
		BigDecimal cv = new BigDecimal(8500.0);
		BigDecimal r = new BigDecimal(0.0725);
		BigDecimal n = new BigDecimal(90);
		BigDecimal expectedIo = new BigDecimal(154.06);

		// Ordinary Interest (Io)
		BigDecimal actualIo = si.getIoFromIe(si.getInterest(cv, r, n, new BigDecimal(365)));
		logger.info("\n cv {},\n r {},\n n {},\n expected {},\n actual {}", cv, r, n,
				expectedIo.setScale(2, BigDecimal.ROUND_HALF_UP), actualIo.setScale(2, BigDecimal.ROUND_HALF_UP));
		assertThat(actualIo, closeTo(expectedIo, new BigDecimal(0.01)));

		BigDecimal expectedIe = new BigDecimal(151.95);

		// Ordinary Interest (Io)
		BigDecimal actualIe = si.getIeFromIo(si.getInterest(cv, r, n, new BigDecimal(360)));
		logger.info("\n cv {},\n r {},\n n {},\n expected {},\n actual {}", cv, r, n,
				expectedIe.setScale(2, BigDecimal.ROUND_HALF_UP), actualIe.setScale(2, BigDecimal.ROUND_HALF_UP));
		assertThat(actualIe, closeTo(expectedIe, new BigDecimal(0.01)));
	}

	private static MathContext mc = new MathContext(10, RoundingMode.HALF_UP);

	@Test
	public void shouldDoMultipleFvsCvs() {
		SimpleInterestAPI si = new SimpleInterestImpl();
		BigDecimal fv1 = new BigDecimal(500.0), fv2 = new BigDecimal(1200.0), fv3 = new BigDecimal(1500.00),
				n1 = new BigDecimal(1), n2 = new BigDecimal(1).add(new BigDecimal(2).divide(new BigDecimal(3), mc)),
				n3 = new BigDecimal(2), r = new BigDecimal(0.095);
		BigDecimal cv1 = si.getCvFromFv(fv1, r, n1);
		BigDecimal cv2 = si.getCvFromFv(fv2, r, n2);
		BigDecimal cv3 = si.getCvFromFv(fv3, r, n3);
		BigDecimal cv = cv1.add(cv2).add(cv3);
		BigDecimal expectedCv = new BigDecimal(2753.09);

		logger.info(
				"\nfv1 {},\n fv2 {},\n fv3 {},\n n1 {},\n n2 {},\n n3 {},\n cv1 {},\n cv2 {},\n cv3 {},\n cv {},\n expectedCv {}\n",
				fv1, fv2, fv3, n1, n2, n3, cv1, cv2, cv3, cv, expectedCv);
		assertThat(cv, closeTo(expectedCv, new BigDecimal(0.01)));

	}

	@Test
	public void shouldDoSerialDate() {
		SerialDate may9Y2001 = SerialDate.createInstance(15, MonthConstants.MAY, 2001);
		SerialDate nov23Y2001 = SerialDate.createInstance(23, MonthConstants.NOVEMBER, 2001);
		int actualNoDays = SerialDateUtilities.dayCountActual(may9Y2001, nov23Y2001);
		int expectedNoDays = 192;
		assertThat(actualNoDays, equalTo(expectedNoDays));
	}
}
