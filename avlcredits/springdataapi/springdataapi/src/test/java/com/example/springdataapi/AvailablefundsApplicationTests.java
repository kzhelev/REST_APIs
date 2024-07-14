package com.example.springdataapi;

import com.example.springdataapi.models.FailureResponse;
import com.example.springdataapi.models.SuccessResponse;
import com.example.springdataapi.models.dto.RequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class AvailablefundsApplicationTests {

	@Autowired
	private JacksonTester<SuccessResponse> jacksonTesterSR;

	@Autowired
	private JacksonTester<FailureResponse> jacksonTesterFR;

	@Autowired
	private JacksonTester<RequestDTO> requestDTOJacksonTester;

	@Test
	void testSuccessResponse() throws IOException {

		SuccessResponse successResponse = new SuccessResponse(true);

		assertThat(jacksonTesterSR.write(successResponse)).isStrictlyEqualToJson(new File("src/test/resources/expectedSR.json"));

	}

	@Test
	void testSuccessResponseForNoFunds() throws IOException {

		SuccessResponse successResponse = new SuccessResponse(false);

		assertThat(jacksonTesterSR.write(successResponse)).isStrictlyEqualToJson(new File("src/test/resources/expectedUSR.json"));

	}

	@Test
	void testFailureResponseForWrongIBAN() throws IOException {

		FailureResponse failureResponse = new FailureResponse(521,"No customer with that number!");

		assertThat(jacksonTesterFR.write(failureResponse)).isStrictlyEqualToJson(new File("src/test/resources/expectedFRnoCust.json"));

	}

	@Test
	void testFailureResponseForWrongCCY() throws IOException {

		FailureResponse failureResponse = new FailureResponse(522,"Account currency doesn’t match to the requested one!");

		assertThat(jacksonTesterFR.write(failureResponse)).isStrictlyEqualToJson(new File("src/test/resources/expectedFRwrgCCY.json"));

	}

	@Test
	void testRequestSer() throws IOException {

		String expectedRequest = "{\n" +
				"  \"customerNo\": \"000001\",\n" +
				"  \"currency\": \"BGN\",\n" +
				"  \"amount\": \"123.88\"\n" +
				"}";

		RequestDTO requestDTO = new RequestDTO("000001", "BGN", 123.88);

		assertThat(requestDTOJacksonTester.parseObject(expectedRequest)).usingRecursiveComparison().isEqualTo(requestDTO);
	}

}
