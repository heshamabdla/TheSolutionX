package am.leon.solutionx.features.authentication.login.data.repository.remote

import am.leon.solutionx.common.domain.repository.remote.IRestApiNetworkProvider
import java.lang.reflect.Type

class FakeRestApiNetworkProvider: IRestApiNetworkProvider {

    var postFakeResponse: Any? = null

    override suspend fun <ResponseBody, RequestBody> post(
        responseWrappedModel: Type,
        pathUrl: String,
        headers: Map<String, Any>?,
        queryParams: Map<String, Any>?,
        requestBody: RequestBody
    ): ResponseBody {
        return postFakeResponse as ResponseBody
    }

    override suspend fun <ResponseBody, RequestBody> delete(
        responseWrappedModel: Type,
        pathUrl: String,
        headers: Map<String, Any>?,
        queryParams: Map<String, Any>?,
        requestBody: RequestBody?
    ): ResponseBody {
        throw UnsupportedOperationException("Not implemented")
    }

    override suspend fun <ResponseBody, RequestBody> put(
        responseWrappedModel: Type,
        pathUrl: String,
        headers: Map<String, Any>?,
        queryParams: Map<String, Any>?,
        requestBody: RequestBody?
    ): ResponseBody {
        throw UnsupportedOperationException("Not implemented")
    }

    override suspend fun <ResponseBody> get(
        responseWrappedModel: Type,
        pathUrl: String,
        headers: Map<String, Any>?,
        queryParams: Map<String, Any>?
    ): ResponseBody {

        throw UnsupportedOperationException()

    }


}