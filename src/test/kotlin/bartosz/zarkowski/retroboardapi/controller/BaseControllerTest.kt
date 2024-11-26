package bartosz.zarkowski.retroboardapi.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.ResultMatcher
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder

abstract class BaseControllerTest {

    @Autowired
    protected lateinit var mockMvc: MockMvc

    protected fun performMockRequest(
        requestBuilder: MockHttpServletRequestBuilder,
        expectedStatus: ResultMatcher? = null
    ): ResultActions {

        val request = mockMvc.perform(requestBuilder
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
        )

        if (expectedStatus != null)
            request.andExpect(expectedStatus)

        return request
    }
}
