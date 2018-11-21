package com.drkiettran.financemath.service;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.drkiettran.financemath.model.SimpleInterest;
import com.drkiettran.financemath.tvm.SimpleInterestAPI;
import com.drkiettran.financemath.tvm.SimpleInterestImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("${com.drkiettran.financemath.service.base-path:/api/v1}")
public class TimeValueMoneyImpl implements TimeValueMoneyAPI {
	private static final Logger logger = LoggerFactory.getLogger(TimeValueMoneyImpl.class);

	@ApiOperation(value = "", nickname = "interestPut", notes = "", response = SimpleInterest.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = SimpleInterest.class) })
	@RequestMapping(value = "/timevaluemoney/interest", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	public ResponseEntity<SimpleInterest> interestPut(@RequestHeader HttpHeaders headers,
			@ApiParam(value = "Simple Interest", required = true) @Valid @RequestBody SimpleInterest si) {
		logInfo(si);
		SimpleInterestAPI siImpl = new SimpleInterestImpl();
		si.setI(siImpl.getTotalInterest(si.getCv(), si.getR(), si.getN()));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-type", "application/json");
		logInfo(si);
		return ResponseEntity.status(HttpStatus.OK).headers(responseHeaders).body(si);
	}

	@ApiOperation(value = "", nickname = "ratePut", notes = "", response = SimpleInterest.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = SimpleInterest.class) })
	@RequestMapping(value = "/timevaluemoney/rate", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	public ResponseEntity<SimpleInterest> ratePut(@RequestHeader HttpHeaders headers,
			@ApiParam(value = "Simple Interest", required = true) @Valid @RequestBody SimpleInterest si) {
		logInfo(si);
		SimpleInterestAPI siImpl = new SimpleInterestImpl();
		si.setR(siImpl.getRateOfInterest(si.getCv(), si.getI(), si.getN()));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-type", "application/json");
		logInfo(si);
		return ResponseEntity.status(HttpStatus.OK).headers(responseHeaders).body(si);
	}

	@ApiOperation(value = "", nickname = "termPut", notes = "", response = SimpleInterest.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = SimpleInterest.class) })
	@RequestMapping(value = "/timevaluemoney/term", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	public ResponseEntity<SimpleInterest> termPut(@RequestHeader HttpHeaders headers,
			@ApiParam(value = "Simple Term", required = true) @Valid @RequestBody SimpleInterest si) {
		logInfo(si);
		SimpleInterestAPI siImpl = new SimpleInterestImpl();
		si.setN(siImpl.getTermOfMaturity(si.getCv(), si.getI(), si.getR()));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-type", "application/json");
		logInfo(si);
		return ResponseEntity.status(HttpStatus.OK).headers(responseHeaders).body(si);
	}

	@ApiOperation(value = "", nickname = "cvPut", notes = "", response = SimpleInterest.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = SimpleInterest.class) })
	@RequestMapping(value = "/timevaluemoney/cv", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	public ResponseEntity<SimpleInterest> cvPut(@RequestHeader HttpHeaders headers,
			@ApiParam(value = "Simple Term", required = true) @Valid @RequestBody SimpleInterest si) {
		logInfo(si);
		SimpleInterestAPI siImpl = new SimpleInterestImpl();
		si.setCv(siImpl.getCurrentValue(si.getI(), si.getR(), si.getN()));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-type", "application/json");
		logInfo(si);
		return ResponseEntity.status(HttpStatus.OK).headers(responseHeaders).body(si);
	}

	@ApiOperation(value = "", nickname = "fvPut", notes = "", response = SimpleInterest.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = SimpleInterest.class) })
	@RequestMapping(value = "/timevaluemoney/fv", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	public ResponseEntity<SimpleInterest> fvPut(@RequestHeader HttpHeaders headers,
			@ApiParam(value = "Simple Term", required = true) @Valid @RequestBody SimpleInterest si) {
		logInfo(si);
		SimpleInterestAPI siImpl = new SimpleInterestImpl();
		si.setFv(siImpl.getFutureValue(si.getCv(), si.getR(), si.getN()));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-type", "application/json");
		logInfo(si);
		return ResponseEntity.status(HttpStatus.OK).headers(responseHeaders).body(si);
	}

	@ApiOperation(value = "", nickname = "rate_cvfvPut", notes = "", response = SimpleInterest.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = SimpleInterest.class) })
	@RequestMapping(value = "/timevaluemoney/rate_cvfv", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	public ResponseEntity<SimpleInterest> rate_cvfPut(@RequestHeader HttpHeaders headers,
			@ApiParam(value = "Simple Term", required = true) @Valid @RequestBody SimpleInterest si) {
		logInfo(si);
		SimpleInterestAPI siImpl = new SimpleInterestImpl();
		si.setR(siImpl.getRateGivenFvCv(si.getCv(), si.getFv(), si.getN()));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-type", "application/json");
		logInfo(si);
		return ResponseEntity.status(HttpStatus.OK).headers(responseHeaders).body(si);
	}

	@ApiOperation(value = "", nickname = "term_cvfvPut", notes = "", response = SimpleInterest.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = SimpleInterest.class) })
	@RequestMapping(value = "/timevaluemoney/term_cvfv", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	public ResponseEntity<SimpleInterest> term_cvfPut(@RequestHeader HttpHeaders headers,
			@ApiParam(value = "Simple Term", required = true) @Valid @RequestBody SimpleInterest si) {
		logInfo(si);
		SimpleInterestAPI siImpl = new SimpleInterestImpl();
		si.setN(siImpl.getTermGivenFvCv(si.getCv(), si.getFv(), si.getR()));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-type", "application/json");
		logInfo(si);
		return ResponseEntity.status(HttpStatus.OK).headers(responseHeaders).body(si);
	}

	@ApiOperation(value = "", nickname = "sdCvPut", notes = "", response = SimpleInterest.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = SimpleInterest.class) })
	@RequestMapping(value = "/timevaluemoney/sdCv", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	public ResponseEntity<SimpleInterest> sdCvPut(@RequestHeader HttpHeaders headers,
			@ApiParam(value = "Simple Term", required = true) @Valid @RequestBody SimpleInterest si) {
		logInfo(si);
		SimpleInterestAPI siImpl = new SimpleInterestImpl();
		si.setCv(siImpl.getCurrentValueMonthly(si.getFv(), si.getR(), si.getN()));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-type", "application/json");
		logInfo(si);
		return ResponseEntity.status(HttpStatus.OK).headers(responseHeaders).body(si);
	}

	@ApiOperation(value = "", nickname = "sdFvPut", notes = "", response = SimpleInterest.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = SimpleInterest.class) })
	@RequestMapping(value = "/timevaluemoney/sdFv", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	public ResponseEntity<SimpleInterest> sdFvPut(@RequestHeader HttpHeaders headers,
			@ApiParam(value = "Simple Term", required = true) @Valid @RequestBody SimpleInterest si) {
		logInfo(si);
		SimpleInterestAPI siImpl = new SimpleInterestImpl();
		si.setFv(siImpl.getFutureValueMonthly(si.getCv(), si.getR(), si.getN()));
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-type", "application/json");
		logInfo(si);
		return ResponseEntity.status(HttpStatus.OK).headers(responseHeaders).body(si);
	}

	private void logInfo(@Valid SimpleInterest si) {
		logger.info("cv {},\n r {},\n i {},\n n {},\n fv {}", si.getCv(), si.getR(), si.getI(), si.getN(), si.getFv());
	}
}
