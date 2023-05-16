package com.bazuma.trivia.data

//What is Happening,Status of Fetching data from Payload
//<T,Boolean,E:Exception>
// Pass Generic-ArrayListOfQuiz
//Boolean Loading is True/False transport to UI
//Pass execption if happens or any other type
//wrap with more metadata since <ArrayList<QuestionItem>
//can't add any metadata about the respose we are getting from the server - http exception
//loading status etc
data class DataOrException<T,Boolean,E:Exception> (
    var data:T?=null,
    var loading:Boolean?=null,
    var e:E?=null
)