package com.bazuma.trivia.repository

import com.bazuma.trivia.data.DataOrException
import com.bazuma.trivia.model.QuestionItem
import com.bazuma.trivia.network.QuestionApi
import javax.inject.Inject


class QuestionRepository @Inject constructor(private val api:QuestionApi) {
    private var dataOrException= DataOrException<ArrayList<QuestionItem>,Boolean,Exception>()
    suspend fun getAllQuestion(): DataOrException<ArrayList<QuestionItem>,Boolean,Exception>{
        try{
            dataOrException.loading=true
            dataOrException.data = api.getAllQuestions()

            if (dataOrException.data.toString().isNotEmpty())
                dataOrException.loading=false



        }catch (exception:Exception){
            dataOrException.e = exception
        }
        return  dataOrException
    }
}