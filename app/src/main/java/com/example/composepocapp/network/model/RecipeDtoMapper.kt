package com.example.composepocapp.network.model

import android.util.Log
import com.example.composepocapp.domain.model.Recipe
import com.example.composepocapp.domain.util.DomainMapper
import com.example.composepocapp.utils.TAG

class RecipeDtoMapper: DomainMapper<RecipeDto, Recipe> {

    //from network
    override fun mapToDomainModel(model: RecipeDto): Recipe {
        Log.d("RecipeDtoMapper : ", model.title.toString())
        return Recipe(
            id = model.pk,
            title = model.title,
            featuredImage = model.featuredImage,
            rating = model.rating,
            publisher = model.publisher,
            sourceUrl = model.sourceUrl,
            ingredients = model.ingredients,
            dateAdded = model.dateAdded,
            dateUpdated = model.dateUpdated,
        )
    }

    //to network
    override fun mapFromDomainModel(domainModel: Recipe): RecipeDto {
        return RecipeDto(
            pk = domainModel.id,
            title = domainModel.title,
            featuredImage = domainModel.featuredImage,
            rating = domainModel.rating,
            publisher = domainModel.publisher,
            sourceUrl = domainModel.sourceUrl,
            ingredients = domainModel.ingredients,
            dateAdded = domainModel.dateAdded,
            dateUpdated = domainModel.dateUpdated,
        )
    }

    //from network
    fun toDomainList(initial: List<RecipeDto>): List<Recipe>{
        return initial.map { mapToDomainModel(it) }
    }

    //to network
    fun fromDomainList(initial : List<Recipe>): List<RecipeDto>{
        return initial.map { mapFromDomainModel(it) }
    }
}