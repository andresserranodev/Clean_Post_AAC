package com.puzzle.bench.post_aac.data.mapper

/**
 * Interface for model mappers. It provides helper methods that facilitate
 * retrieving of models from outer data source layers
 *
 * @param <S> the service model input type
 * @param <E> the Entity model input type
 * @param <P> the Presentation  model input type
 */
interface BaseMapperData<S, E, P> {
    fun transformServiceToEntity(service: S): E
    fun transformEntityToPresentation(entity: E): P
}