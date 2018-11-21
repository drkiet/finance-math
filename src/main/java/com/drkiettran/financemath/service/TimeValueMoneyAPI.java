package com.drkiettran.financemath.service;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.drkiettran.financemath.model.SimpleInterest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Validated
@Api(value = "timevaluemoney")
public interface TimeValueMoneyAPI {
	@ApiOperation(value = "", nickname = "interestPut", notes = "", response = SimpleInterest.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = SimpleInterest.class) })
	@RequestMapping(value = "/timevaluemoney/interest", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	default ResponseEntity<SimpleInterest> interestPut(@RequestHeader HttpHeaders headers,
			@ApiParam(value = "Simple Interest", required = true) @Valid @RequestBody SimpleInterest si) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	@ApiOperation(value = "", nickname = "ratePut", notes = "", response = SimpleInterest.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = SimpleInterest.class) })
	@RequestMapping(value = "/timevaluemoney/rate", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	default ResponseEntity<SimpleInterest> ratePut(@RequestHeader HttpHeaders headers,
			@ApiParam(value = "Simple Rate", required = true) @Valid @RequestBody SimpleInterest si) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	@ApiOperation(value = "", nickname = "termPut", notes = "", response = SimpleInterest.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = SimpleInterest.class) })
	@RequestMapping(value = "/timevaluemoney/rate", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	default ResponseEntity<SimpleInterest> termPut(@RequestHeader HttpHeaders headers,
			@ApiParam(value = "Simple Term", required = true) @Valid @RequestBody SimpleInterest si) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	@ApiOperation(value = "", nickname = "cvPut", notes = "", response = SimpleInterest.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = SimpleInterest.class) })
	@RequestMapping(value = "/timevaluemoney/cv", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	default ResponseEntity<SimpleInterest> cvPut(@RequestHeader HttpHeaders headers,
			@ApiParam(value = "Simple Term", required = true) @Valid @RequestBody SimpleInterest si) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	@ApiOperation(value = "", nickname = "fvPut", notes = "", response = SimpleInterest.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = SimpleInterest.class) })
	@RequestMapping(value = "/timevaluemoney/fv", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	default ResponseEntity<SimpleInterest> fvPut(@RequestHeader HttpHeaders headers,
			@ApiParam(value = "Simple Term", required = true) @Valid @RequestBody SimpleInterest si) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}
	
	@ApiOperation(value = "", nickname = "rate_cvfvPut", notes = "", response = SimpleInterest.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = SimpleInterest.class) })
	@RequestMapping(value = "/timevaluemoney/rate_cvfv", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	default ResponseEntity<SimpleInterest> rate_cvfPut(@RequestHeader HttpHeaders headers,
			@ApiParam(value = "Simple Term", required = true) @Valid @RequestBody SimpleInterest si) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}
	
	@ApiOperation(value = "", nickname = "term_cvfvPut", notes = "", response = SimpleInterest.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = SimpleInterest.class) })
	@RequestMapping(value = "/timevaluemoney/term_cvfv", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	default ResponseEntity<SimpleInterest> term_cvfPut(@RequestHeader HttpHeaders headers,
			@ApiParam(value = "Simple Term", required = true) @Valid @RequestBody SimpleInterest si) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}
	
	@ApiOperation(value = "", nickname = "sdCvPut", notes = "", response = SimpleInterest.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = SimpleInterest.class) })
	@RequestMapping(value = "/timevaluemoney/sdCv", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	default ResponseEntity<SimpleInterest> sdCvPut(@RequestHeader HttpHeaders headers,
			@ApiParam(value = "Simple Term", required = true) @Valid @RequestBody SimpleInterest si) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}
	
	@ApiOperation(value = "", nickname = "sdFvPut", notes = "", response = SimpleInterest.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = SimpleInterest.class) })
	@RequestMapping(value = "/timevaluemoney/sdFv", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	default ResponseEntity<SimpleInterest> sdFvPut(@RequestHeader HttpHeaders headers,
			@ApiParam(value = "Simple Term", required = true) @Valid @RequestBody SimpleInterest si) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}
}
