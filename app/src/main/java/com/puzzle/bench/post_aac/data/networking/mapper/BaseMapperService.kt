package com.puzzle.bench.post_aac.data.networking.mapper

/**
 * Interface for model mappers. It provides helper methods that facilitate
 * retrieving of models from outer data source layers
 *
 * @param <P> the presentation model input type
 * @param <S> the service model input type
 */
interface BaseMapperService<S, P> {
    fun transformPresentation(serviceModel: S): P
    fun transformToResponse(presentationModel: P): S
}